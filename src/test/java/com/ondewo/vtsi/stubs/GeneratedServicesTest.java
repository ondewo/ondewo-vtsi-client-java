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
import ondewo.vtsi.CampaignsGrpc;
import ondewo.vtsi.CampaignsOuterClass;
import ondewo.vtsi.EventsGrpc;
import ondewo.vtsi.EventsOuterClass;
import ondewo.vtsi.SoftphonesGrpc;
import ondewo.vtsi.SoftphonesOuterClass;
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
     * Number of {@code *Grpc} classes protoc must emit for this product: the six
     * {@code ondewo.vtsi} services (Calls, Projects, Logs, and since ondewo-vtsi-api 9.0.0
     * Softphones, Campaigns, Events) plus the 16 ondewo.nlu services and
     * {@code ondewo.qa.QA}, {@code ondewo.s2t.Speech2Text}, {@code ondewo.t2s.Text2Speech},
     * {@code ondewo.sip.Sip} - ondewo-vtsi-api vendors those apis. Bump it when the api adds or
     * drops a service - that is exactly the kind of silent generator regression this test
     * exists to catch.
     */
    private static final int EXPECTED_SERVICE_COUNT = 26;

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
     * The services and streaming rpcs added in ondewo-vtsi-api 9.0.0, under their exact proto
     * names: a generator that drops or renames one of them fails here.
     */
    @Test
    void exposesTheServicesAndStreamsAddedInApi9() {
        assertEquals("ondewo.vtsi.Softphones", SoftphonesGrpc.getServiceDescriptor().getName());
        assertEquals("ondewo.vtsi.Campaigns", CampaignsGrpc.getServiceDescriptor().getName());
        assertEquals("ondewo.vtsi.Events", EventsGrpc.getServiceDescriptor().getName());
        assertEquals(
                MethodDescriptor.MethodType.SERVER_STREAMING,
                CampaignsGrpc.getStreamCampaignStatusMethod().getType());
        assertEquals(
                MethodDescriptor.MethodType.SERVER_STREAMING,
                EventsGrpc.getSubscribeVtsiEventsMethod().getType());
        assertEquals(
                MethodDescriptor.MethodType.BIDI_STREAMING,
                CallsGrpc.getStreamCallAudioMethod().getType());
        assertEquals(
                MethodDescriptor.MethodType.SERVER_STREAMING,
                CallsGrpc.getListenCallAudioMethod().getType());
        assertEquals(
                MethodDescriptor.MethodType.SERVER_STREAMING,
                CallsGrpc.getStreamCallerStatusMethod().getType());
        assertEquals(
                MethodDescriptor.MethodType.UNARY,
                CallsGrpc.getAddCallersToCampaignMethod().getType());
    }

    /**
     * One unary call into each service added in ondewo-vtsi-api 9.0.0, over the in-process
     * transport and the real generated marshallers, with the bearer token attached.
     */
    @Test
    void servesAUnaryCallOnEachServiceAddedInApi9() throws Exception {
        final SoftphonesGrpc.SoftphonesImplBase softphones =
                new SoftphonesGrpc.SoftphonesImplBase() {
                    @Override
                    public void getSoftphoneAccount(
                            final SoftphonesOuterClass.GetSoftphoneAccountRequest request,
                            final StreamObserver<SoftphonesOuterClass.SoftphoneAccount>
                                    responseObserver) {
                        responseObserver.onNext(
                                SoftphonesOuterClass.SoftphoneAccount.newBuilder()
                                        .setName(request.getName())
                                        .build());
                        responseObserver.onCompleted();
                    }
                };
        final CampaignsGrpc.CampaignsImplBase campaigns =
                new CampaignsGrpc.CampaignsImplBase() {
                    @Override
                    public void getCampaign(
                            final CampaignsOuterClass.GetCampaignRequest request,
                            final StreamObserver<CampaignsOuterClass.Campaign> responseObserver) {
                        responseObserver.onNext(
                                CampaignsOuterClass.Campaign.newBuilder()
                                        .setName(request.getName())
                                        .build());
                        responseObserver.onCompleted();
                    }
                };
        final EventsGrpc.EventsImplBase events =
                new EventsGrpc.EventsImplBase() {
                    @Override
                    public void getWebhook(
                            final EventsOuterClass.GetWebhookRequest request,
                            final StreamObserver<EventsOuterClass.Webhook> responseObserver) {
                        responseObserver.onNext(
                                EventsOuterClass.Webhook.newBuilder()
                                        .setName(request.getName())
                                        .build());
                        responseObserver.onCompleted();
                    }
                };

        final String name = InProcessServerBuilder.generateName();
        final Server newServices =
                InProcessServerBuilder.forName(name)
                        .directExecutor()
                        .addService(softphones)
                        .addService(campaigns)
                        .addService(events)
                        .build()
                        .start();
        final ManagedChannel newChannel = InProcessChannelBuilder.forName(name).build();
        final BearerToken token = new BearerToken("s3cr3t");
        final String project = "projects/6a1b2c3d-0000-4000-8000-000000000000";
        try {
            assertEquals(
                    project + "/softphone_accounts/a1",
                    token.attachTo(SoftphonesGrpc.newBlockingStub(newChannel))
                            .getSoftphoneAccount(
                                    SoftphonesOuterClass.GetSoftphoneAccountRequest.newBuilder()
                                            .setName(project + "/softphone_accounts/a1")
                                            .build())
                            .getName());
            assertEquals(
                    project + "/campaigns/c1",
                    token.attachTo(CampaignsGrpc.newBlockingStub(newChannel))
                            .getCampaign(
                                    CampaignsOuterClass.GetCampaignRequest.newBuilder()
                                            .setName(project + "/campaigns/c1")
                                            .build())
                            .getName());
            assertEquals(
                    project + "/webhooks/w1",
                    token.attachTo(EventsGrpc.newBlockingStub(newChannel))
                            .getWebhook(
                                    EventsOuterClass.GetWebhookRequest.newBuilder()
                                            .setName(project + "/webhooks/w1")
                                            .build())
                            .getName());
        } finally {
            newChannel.shutdownNow();
            newServices.shutdownNow();
            newChannel.awaitTermination(10, TimeUnit.SECONDS);
            newServices.awaitTermination(10, TimeUnit.SECONDS);
        }
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
            assertNotNull(SoftphonesGrpc.newBlockingStub(dummy));
            assertNotNull(SoftphonesGrpc.newFutureStub(dummy));
            assertNotNull(SoftphonesGrpc.newStub(dummy));
            assertNotNull(CampaignsGrpc.newBlockingStub(dummy));
            assertNotNull(CampaignsGrpc.newFutureStub(dummy));
            assertNotNull(CampaignsGrpc.newStub(dummy));
            assertNotNull(EventsGrpc.newBlockingStub(dummy));
            assertNotNull(EventsGrpc.newFutureStub(dummy));
            assertNotNull(EventsGrpc.newStub(dummy));
        } finally {
            dummy.shutdownNow();
        }
    }
}
