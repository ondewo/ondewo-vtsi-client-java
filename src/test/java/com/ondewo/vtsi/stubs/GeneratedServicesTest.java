package com.ondewo.vtsi.stubs;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ondewo.vtsi.auth.BearerToken;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.ServerInterceptors;
import io.grpc.ServiceDescriptor;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;
import ondewo.vtsi.CallsGrpc;
import ondewo.vtsi.CallsOuterClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Exercises the generated gRPC service stubs: their descriptors, every stub flavour, and one
 * real request/response round trip over the in-process transport - no socket, no network, but
 * the real generated marshallers on both ends.
 */
class GeneratedServicesTest {

    /**
     * Number of {@code *Grpc} classes protoc must emit for this product: the three
     * {@code ondewo.vtsi} services (Calls, Projects, Logs) plus the 16 ondewo.nlu services and
     * {@code ondewo.qa.QA}, {@code ondewo.s2t.Speech2Text}, {@code ondewo.t2s.Text2Speech},
     * {@code ondewo.sip.Sip} - ondewo-vtsi-api vendors those apis. Bump it when the api adds or
     * drops a service - that is exactly the kind of silent generator regression this test
     * exists to catch.
     */
    private static final int EXPECTED_SERVICE_COUNT = 23;

    private static final Metadata.Key<String> AUTHORIZATION =
            Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);

    private final AtomicReference<Metadata> receivedHeaders = new AtomicReference<>();

    private Server server;
    private ManagedChannel channel;

    @BeforeEach
    void startServer() throws Exception {
        final CallsGrpc.CallsImplBase service =
                new CallsGrpc.CallsImplBase() {
                    @Override
                    public void listCallers(
                            final CallsOuterClass.ListCallersRequest request,
                            final StreamObserver<CallsOuterClass.ListCallersResponse>
                                    responseObserver) {
                        responseObserver.onNext(
                                CallsOuterClass.ListCallersResponse.newBuilder()
                                        .addCallers(
                                                CallsOuterClass.Caller.newBuilder()
                                                        .setName(
                                                                request.getVtsiProjectName()
                                                                        + "/callers/served")
                                                        .build())
                                        .setNextPageToken("served-" + request.getPageToken())
                                        .build());
                        responseObserver.onCompleted();
                    }
                };

        final ServerInterceptor headerCapture =
                new ServerInterceptor() {
                    @Override
                    public <Q, S> ServerCall.Listener<Q> interceptCall(
                            final ServerCall<Q, S> call,
                            final Metadata headers,
                            final ServerCallHandler<Q, S> next) {
                        receivedHeaders.set(headers);
                        return next.startCall(call, headers);
                    }
                };

        final String name = InProcessServerBuilder.generateName();
        server =
                InProcessServerBuilder.forName(name)
                        .directExecutor()
                        .addService(ServerInterceptors.intercept(service, headerCapture))
                        .build()
                        .start();
        channel = InProcessChannelBuilder.forName(name).build();
    }

    @AfterEach
    void stopServer() throws Exception {
        channel.shutdownNow();
        server.shutdownNow();
        channel.awaitTermination(10, TimeUnit.SECONDS);
        server.awaitTermination(10, TimeUnit.SECONDS);
    }

    @Test
    void exposesTheExpectedServiceDescriptor() {
        final ServiceDescriptor descriptor = CallsGrpc.getServiceDescriptor();

        final List<String> methods =
                descriptor.getMethods().stream()
                        .map(MethodDescriptor::getBareMethodName)
                        .collect(toList());

        assertEquals("ondewo.vtsi.Calls", descriptor.getName());
        assertTrue(
                methods.containsAll(
                        List.of(
                                "StartCaller",
                                "ListCallers",
                                "GetCaller",
                                "DeleteCaller",
                                "StopCaller")),
                "missing rpcs, got " + methods);
        assertEquals(
                MethodDescriptor.MethodType.UNARY, CallsGrpc.getListCallersMethod().getType());
        assertEquals(
                "ondewo.vtsi.Calls/ListCallers",
                CallsGrpc.getListCallersMethod().getFullMethodName());
    }

    /**
     * Every generated service class, found on the compiled classpath rather than listed by
     * hand, so a service added to the api is picked up without touching this test.
     */
    @Test
    void everyGeneratedServiceHasAUsableDescriptor() throws Exception {
        final Path classesRoot =
                Paths.get(
                        CallsGrpc.class
                                .getProtectionDomain()
                                .getCodeSource()
                                .getLocation()
                                .toURI());
        assertTrue(Files.isDirectory(classesRoot), "expected compiled classes at " + classesRoot);

        final List<String> serviceClasses;
        try (Stream<Path> tree = Files.walk(classesRoot)) {
            serviceClasses =
                    tree.filter(Files::isRegularFile)
                            .map(path -> classesRoot.relativize(path).toString())
                            .filter(name -> name.endsWith("Grpc.class"))
                            .map(name -> name.substring(0, name.length() - ".class".length()))
                            .map(name -> name.replace(java.io.File.separatorChar, '.'))
                            .sorted()
                            .collect(toList());
        }

        assertEquals(EXPECTED_SERVICE_COUNT, serviceClasses.size(), "found " + serviceClasses);

        for (final String className : serviceClasses) {
            final ServiceDescriptor descriptor =
                    (ServiceDescriptor)
                            Class.forName(className).getMethod("getServiceDescriptor").invoke(null);

            assertTrue(
                    descriptor.getName().startsWith("ondewo."),
                    className + " serves " + descriptor.getName());
            assertTrue(
                    descriptor.getMethods().iterator().hasNext(),
                    className + " declares no rpc");
        }
    }

    @Test
    void servesAUnaryCallOverTheGeneratedMarshallers() {
        final CallsGrpc.CallsBlockingStub stub =
                new BearerToken("s3cr3t").attachTo(CallsGrpc.newBlockingStub(channel));

        final CallsOuterClass.ListCallersResponse response =
                stub.listCallers(
                        CallsOuterClass.ListCallersRequest.newBuilder()
                                .setVtsiProjectName(
                                        "projects/6a1b2c3d-0000-4000-8000-000000000000/project")
                                .setPageToken("current_index-1--page_size-20")
                                .build());

        assertEquals(1, response.getCallersCount());
        assertEquals(
                "projects/6a1b2c3d-0000-4000-8000-000000000000/project/callers/served",
                response.getCallers(0).getName());
        assertEquals("served-current_index-1--page_size-20", response.getNextPageToken());
        assertEquals("Bearer s3cr3t", receivedHeaders.get().get(AUTHORIZATION));
    }

    /**
     * The published library declares grpc-netty-shaded, so a consumer can open a channel from
     * a plain target string without adding a transport. Nothing is dialled: gRPC connects
     * lazily, on the first call.
     */
    @Test
    void buildsEveryStubFlavourAgainstAPlainTargetChannel() {
        final ManagedChannel dummy =
                ManagedChannelBuilder.forTarget("localhost:50051").usePlaintext().build();
        try {
            assertNotNull(CallsGrpc.newBlockingStub(dummy));
            assertNotNull(CallsGrpc.newFutureStub(dummy));
            assertNotNull(CallsGrpc.newStub(dummy));
        } finally {
            dummy.shutdownNow();
        }
    }
}
