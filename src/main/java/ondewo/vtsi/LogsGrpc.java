package ondewo.vtsi;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class LogsGrpc {

  private LogsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ondewo.vtsi.Logs";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.StreamCallLogsRequest,
      ondewo.vtsi.LogsOuterClass.StreamCallLogsResponse> getStreamCallLogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamCallLogs",
      requestType = ondewo.vtsi.LogsOuterClass.StreamCallLogsRequest.class,
      responseType = ondewo.vtsi.LogsOuterClass.StreamCallLogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.StreamCallLogsRequest,
      ondewo.vtsi.LogsOuterClass.StreamCallLogsResponse> getStreamCallLogsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.StreamCallLogsRequest, ondewo.vtsi.LogsOuterClass.StreamCallLogsResponse> getStreamCallLogsMethod;
    if ((getStreamCallLogsMethod = LogsGrpc.getStreamCallLogsMethod) == null) {
      synchronized (LogsGrpc.class) {
        if ((getStreamCallLogsMethod = LogsGrpc.getStreamCallLogsMethod) == null) {
          LogsGrpc.getStreamCallLogsMethod = getStreamCallLogsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.LogsOuterClass.StreamCallLogsRequest, ondewo.vtsi.LogsOuterClass.StreamCallLogsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamCallLogs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.LogsOuterClass.StreamCallLogsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.LogsOuterClass.StreamCallLogsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LogsMethodDescriptorSupplier("StreamCallLogs"))
              .build();
        }
      }
    }
    return getStreamCallLogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.ListCallLogsRequest,
      ondewo.vtsi.LogsOuterClass.ListCallLogsResponse> getListCallLogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCallLogs",
      requestType = ondewo.vtsi.LogsOuterClass.ListCallLogsRequest.class,
      responseType = ondewo.vtsi.LogsOuterClass.ListCallLogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.ListCallLogsRequest,
      ondewo.vtsi.LogsOuterClass.ListCallLogsResponse> getListCallLogsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.ListCallLogsRequest, ondewo.vtsi.LogsOuterClass.ListCallLogsResponse> getListCallLogsMethod;
    if ((getListCallLogsMethod = LogsGrpc.getListCallLogsMethod) == null) {
      synchronized (LogsGrpc.class) {
        if ((getListCallLogsMethod = LogsGrpc.getListCallLogsMethod) == null) {
          LogsGrpc.getListCallLogsMethod = getListCallLogsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.LogsOuterClass.ListCallLogsRequest, ondewo.vtsi.LogsOuterClass.ListCallLogsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCallLogs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.LogsOuterClass.ListCallLogsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.LogsOuterClass.ListCallLogsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LogsMethodDescriptorSupplier("ListCallLogs"))
              .build();
        }
      }
    }
    return getListCallLogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.GetCallLogStreamRequest,
      ondewo.vtsi.LogsOuterClass.CallLogStream> getGetCallLogStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCallLogStream",
      requestType = ondewo.vtsi.LogsOuterClass.GetCallLogStreamRequest.class,
      responseType = ondewo.vtsi.LogsOuterClass.CallLogStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.GetCallLogStreamRequest,
      ondewo.vtsi.LogsOuterClass.CallLogStream> getGetCallLogStreamMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.GetCallLogStreamRequest, ondewo.vtsi.LogsOuterClass.CallLogStream> getGetCallLogStreamMethod;
    if ((getGetCallLogStreamMethod = LogsGrpc.getGetCallLogStreamMethod) == null) {
      synchronized (LogsGrpc.class) {
        if ((getGetCallLogStreamMethod = LogsGrpc.getGetCallLogStreamMethod) == null) {
          LogsGrpc.getGetCallLogStreamMethod = getGetCallLogStreamMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.LogsOuterClass.GetCallLogStreamRequest, ondewo.vtsi.LogsOuterClass.CallLogStream>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCallLogStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.LogsOuterClass.GetCallLogStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.LogsOuterClass.CallLogStream.getDefaultInstance()))
              .setSchemaDescriptor(new LogsMethodDescriptorSupplier("GetCallLogStream"))
              .build();
        }
      }
    }
    return getGetCallLogStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.ListCallLogStreamsRequest,
      ondewo.vtsi.LogsOuterClass.ListCallLogStreamsResponse> getListCallLogStreamsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCallLogStreams",
      requestType = ondewo.vtsi.LogsOuterClass.ListCallLogStreamsRequest.class,
      responseType = ondewo.vtsi.LogsOuterClass.ListCallLogStreamsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.ListCallLogStreamsRequest,
      ondewo.vtsi.LogsOuterClass.ListCallLogStreamsResponse> getListCallLogStreamsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.ListCallLogStreamsRequest, ondewo.vtsi.LogsOuterClass.ListCallLogStreamsResponse> getListCallLogStreamsMethod;
    if ((getListCallLogStreamsMethod = LogsGrpc.getListCallLogStreamsMethod) == null) {
      synchronized (LogsGrpc.class) {
        if ((getListCallLogStreamsMethod = LogsGrpc.getListCallLogStreamsMethod) == null) {
          LogsGrpc.getListCallLogStreamsMethod = getListCallLogStreamsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.LogsOuterClass.ListCallLogStreamsRequest, ondewo.vtsi.LogsOuterClass.ListCallLogStreamsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCallLogStreams"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.LogsOuterClass.ListCallLogStreamsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.LogsOuterClass.ListCallLogStreamsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LogsMethodDescriptorSupplier("ListCallLogStreams"))
              .build();
        }
      }
    }
    return getListCallLogStreamsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.DeleteCallLogsRequest,
      ondewo.vtsi.LogsOuterClass.DeleteCallLogsResponse> getDeleteCallLogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCallLogs",
      requestType = ondewo.vtsi.LogsOuterClass.DeleteCallLogsRequest.class,
      responseType = ondewo.vtsi.LogsOuterClass.DeleteCallLogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.DeleteCallLogsRequest,
      ondewo.vtsi.LogsOuterClass.DeleteCallLogsResponse> getDeleteCallLogsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.DeleteCallLogsRequest, ondewo.vtsi.LogsOuterClass.DeleteCallLogsResponse> getDeleteCallLogsMethod;
    if ((getDeleteCallLogsMethod = LogsGrpc.getDeleteCallLogsMethod) == null) {
      synchronized (LogsGrpc.class) {
        if ((getDeleteCallLogsMethod = LogsGrpc.getDeleteCallLogsMethod) == null) {
          LogsGrpc.getDeleteCallLogsMethod = getDeleteCallLogsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.LogsOuterClass.DeleteCallLogsRequest, ondewo.vtsi.LogsOuterClass.DeleteCallLogsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCallLogs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.LogsOuterClass.DeleteCallLogsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.LogsOuterClass.DeleteCallLogsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LogsMethodDescriptorSupplier("DeleteCallLogs"))
              .build();
        }
      }
    }
    return getDeleteCallLogsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LogsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LogsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LogsStub>() {
        @java.lang.Override
        public LogsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LogsStub(channel, callOptions);
        }
      };
    return LogsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static LogsBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LogsBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LogsBlockingV2Stub>() {
        @java.lang.Override
        public LogsBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LogsBlockingV2Stub(channel, callOptions);
        }
      };
    return LogsBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LogsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LogsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LogsBlockingStub>() {
        @java.lang.Override
        public LogsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LogsBlockingStub(channel, callOptions);
        }
      };
    return LogsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LogsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LogsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LogsFutureStub>() {
        @java.lang.Override
        public LogsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LogsFutureStub(channel, callOptions);
        }
      };
    return LogsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * &lt;p&gt;Streams the container logs of the ondewo-sip / ondewo-csi containers of a VTSI project as
     * they are captured, in the manner of &lt;code&gt;docker logs --follow&lt;/code&gt;. The stream replays
     * &lt;code&gt;tail_lines&lt;/code&gt; historical entries and then follows. It stays open until the capture
     * of every matching log stream has terminated, until the client disconnects, or until the
     * server-side maximum stream duration is reached.&lt;/p&gt;
     * &lt;p&gt;Entries are served from the VTSI database rather than from the docker daemon, so a
     * container that has already been removed still streams. Secrets are redacted server-side.&lt;/p&gt;
     * </pre>
     */
    default void streamCallLogs(ondewo.vtsi.LogsOuterClass.StreamCallLogsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.StreamCallLogsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamCallLogsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a bounded, filtered page of captured container log entries. Supports a time window,
     * severity filtering, a regular expression, a plain-text search and cursor paging in both
     * directions for infinite scrolling. Secrets are redacted server-side.&lt;/p&gt;
     * </pre>
     */
    default void listCallLogs(ondewo.vtsi.LogsOuterClass.ListCallLogsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.ListCallLogsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCallLogsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns the capture state of a single log stream, i.e. of one capture generation of one
     * container.&lt;/p&gt;
     * </pre>
     */
    default void getCallLogStream(ondewo.vtsi.LogsOuterClass.GetCallLogStreamRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.CallLogStream> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCallLogStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the log streams VTSI has captured for a project. A single container yields a new log
     * stream every time it is recreated, because a recreated container is a new docker container
     * whose previous logs no longer exist.&lt;/p&gt;
     * </pre>
     */
    default void listCallLogStreams(ondewo.vtsi.LogsOuterClass.ListCallLogStreamsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.ListCallLogStreamsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCallLogStreamsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Permanently deletes captured log entries matching a filter. This is the erasure path for
     * data-subject requests: retention answers &amp;quot;delete everything older than N days&amp;quot;, this
     * answers &amp;quot;delete everything for this call or this phone number&amp;quot;.&lt;/p&gt;
     * </pre>
     */
    default void deleteCallLogs(ondewo.vtsi.LogsOuterClass.DeleteCallLogsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.DeleteCallLogsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCallLogsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Logs.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public static abstract class LogsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LogsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Logs.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public static final class LogsStub
      extends io.grpc.stub.AbstractAsyncStub<LogsStub> {
    private LogsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LogsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LogsStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the container logs of the ondewo-sip / ondewo-csi containers of a VTSI project as
     * they are captured, in the manner of &lt;code&gt;docker logs --follow&lt;/code&gt;. The stream replays
     * &lt;code&gt;tail_lines&lt;/code&gt; historical entries and then follows. It stays open until the capture
     * of every matching log stream has terminated, until the client disconnects, or until the
     * server-side maximum stream duration is reached.&lt;/p&gt;
     * &lt;p&gt;Entries are served from the VTSI database rather than from the docker daemon, so a
     * container that has already been removed still streams. Secrets are redacted server-side.&lt;/p&gt;
     * </pre>
     */
    public void streamCallLogs(ondewo.vtsi.LogsOuterClass.StreamCallLogsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.StreamCallLogsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamCallLogsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a bounded, filtered page of captured container log entries. Supports a time window,
     * severity filtering, a regular expression, a plain-text search and cursor paging in both
     * directions for infinite scrolling. Secrets are redacted server-side.&lt;/p&gt;
     * </pre>
     */
    public void listCallLogs(ondewo.vtsi.LogsOuterClass.ListCallLogsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.ListCallLogsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCallLogsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns the capture state of a single log stream, i.e. of one capture generation of one
     * container.&lt;/p&gt;
     * </pre>
     */
    public void getCallLogStream(ondewo.vtsi.LogsOuterClass.GetCallLogStreamRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.CallLogStream> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCallLogStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the log streams VTSI has captured for a project. A single container yields a new log
     * stream every time it is recreated, because a recreated container is a new docker container
     * whose previous logs no longer exist.&lt;/p&gt;
     * </pre>
     */
    public void listCallLogStreams(ondewo.vtsi.LogsOuterClass.ListCallLogStreamsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.ListCallLogStreamsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCallLogStreamsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Permanently deletes captured log entries matching a filter. This is the erasure path for
     * data-subject requests: retention answers &amp;quot;delete everything older than N days&amp;quot;, this
     * answers &amp;quot;delete everything for this call or this phone number&amp;quot;.&lt;/p&gt;
     * </pre>
     */
    public void deleteCallLogs(ondewo.vtsi.LogsOuterClass.DeleteCallLogsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.DeleteCallLogsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCallLogsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Logs.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public static final class LogsBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<LogsBlockingV2Stub> {
    private LogsBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LogsBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LogsBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the container logs of the ondewo-sip / ondewo-csi containers of a VTSI project as
     * they are captured, in the manner of &lt;code&gt;docker logs --follow&lt;/code&gt;. The stream replays
     * &lt;code&gt;tail_lines&lt;/code&gt; historical entries and then follows. It stays open until the capture
     * of every matching log stream has terminated, until the client disconnects, or until the
     * server-side maximum stream duration is reached.&lt;/p&gt;
     * &lt;p&gt;Entries are served from the VTSI database rather than from the docker daemon, so a
     * container that has already been removed still streams. Secrets are redacted server-side.&lt;/p&gt;
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, ondewo.vtsi.LogsOuterClass.StreamCallLogsResponse>
        streamCallLogs(ondewo.vtsi.LogsOuterClass.StreamCallLogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getStreamCallLogsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a bounded, filtered page of captured container log entries. Supports a time window,
     * severity filtering, a regular expression, a plain-text search and cursor paging in both
     * directions for infinite scrolling. Secrets are redacted server-side.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.LogsOuterClass.ListCallLogsResponse listCallLogs(ondewo.vtsi.LogsOuterClass.ListCallLogsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListCallLogsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns the capture state of a single log stream, i.e. of one capture generation of one
     * container.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.LogsOuterClass.CallLogStream getCallLogStream(ondewo.vtsi.LogsOuterClass.GetCallLogStreamRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetCallLogStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the log streams VTSI has captured for a project. A single container yields a new log
     * stream every time it is recreated, because a recreated container is a new docker container
     * whose previous logs no longer exist.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.LogsOuterClass.ListCallLogStreamsResponse listCallLogStreams(ondewo.vtsi.LogsOuterClass.ListCallLogStreamsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListCallLogStreamsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Permanently deletes captured log entries matching a filter. This is the erasure path for
     * data-subject requests: retention answers &amp;quot;delete everything older than N days&amp;quot;, this
     * answers &amp;quot;delete everything for this call or this phone number&amp;quot;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.LogsOuterClass.DeleteCallLogsResponse deleteCallLogs(ondewo.vtsi.LogsOuterClass.DeleteCallLogsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteCallLogsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Logs.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public static final class LogsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LogsBlockingStub> {
    private LogsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LogsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LogsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the container logs of the ondewo-sip / ondewo-csi containers of a VTSI project as
     * they are captured, in the manner of &lt;code&gt;docker logs --follow&lt;/code&gt;. The stream replays
     * &lt;code&gt;tail_lines&lt;/code&gt; historical entries and then follows. It stays open until the capture
     * of every matching log stream has terminated, until the client disconnects, or until the
     * server-side maximum stream duration is reached.&lt;/p&gt;
     * &lt;p&gt;Entries are served from the VTSI database rather than from the docker daemon, so a
     * container that has already been removed still streams. Secrets are redacted server-side.&lt;/p&gt;
     * </pre>
     */
    public java.util.Iterator<ondewo.vtsi.LogsOuterClass.StreamCallLogsResponse> streamCallLogs(
        ondewo.vtsi.LogsOuterClass.StreamCallLogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamCallLogsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a bounded, filtered page of captured container log entries. Supports a time window,
     * severity filtering, a regular expression, a plain-text search and cursor paging in both
     * directions for infinite scrolling. Secrets are redacted server-side.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.LogsOuterClass.ListCallLogsResponse listCallLogs(ondewo.vtsi.LogsOuterClass.ListCallLogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCallLogsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns the capture state of a single log stream, i.e. of one capture generation of one
     * container.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.LogsOuterClass.CallLogStream getCallLogStream(ondewo.vtsi.LogsOuterClass.GetCallLogStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCallLogStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the log streams VTSI has captured for a project. A single container yields a new log
     * stream every time it is recreated, because a recreated container is a new docker container
     * whose previous logs no longer exist.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.LogsOuterClass.ListCallLogStreamsResponse listCallLogStreams(ondewo.vtsi.LogsOuterClass.ListCallLogStreamsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCallLogStreamsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Permanently deletes captured log entries matching a filter. This is the erasure path for
     * data-subject requests: retention answers &amp;quot;delete everything older than N days&amp;quot;, this
     * answers &amp;quot;delete everything for this call or this phone number&amp;quot;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.LogsOuterClass.DeleteCallLogsResponse deleteCallLogs(ondewo.vtsi.LogsOuterClass.DeleteCallLogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCallLogsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Logs.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public static final class LogsFutureStub
      extends io.grpc.stub.AbstractFutureStub<LogsFutureStub> {
    private LogsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LogsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LogsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a bounded, filtered page of captured container log entries. Supports a time window,
     * severity filtering, a regular expression, a plain-text search and cursor paging in both
     * directions for infinite scrolling. Secrets are redacted server-side.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.LogsOuterClass.ListCallLogsResponse> listCallLogs(
        ondewo.vtsi.LogsOuterClass.ListCallLogsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCallLogsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns the capture state of a single log stream, i.e. of one capture generation of one
     * container.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.LogsOuterClass.CallLogStream> getCallLogStream(
        ondewo.vtsi.LogsOuterClass.GetCallLogStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCallLogStreamMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the log streams VTSI has captured for a project. A single container yields a new log
     * stream every time it is recreated, because a recreated container is a new docker container
     * whose previous logs no longer exist.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.LogsOuterClass.ListCallLogStreamsResponse> listCallLogStreams(
        ondewo.vtsi.LogsOuterClass.ListCallLogStreamsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCallLogStreamsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Permanently deletes captured log entries matching a filter. This is the erasure path for
     * data-subject requests: retention answers &amp;quot;delete everything older than N days&amp;quot;, this
     * answers &amp;quot;delete everything for this call or this phone number&amp;quot;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.LogsOuterClass.DeleteCallLogsResponse> deleteCallLogs(
        ondewo.vtsi.LogsOuterClass.DeleteCallLogsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCallLogsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STREAM_CALL_LOGS = 0;
  private static final int METHODID_LIST_CALL_LOGS = 1;
  private static final int METHODID_GET_CALL_LOG_STREAM = 2;
  private static final int METHODID_LIST_CALL_LOG_STREAMS = 3;
  private static final int METHODID_DELETE_CALL_LOGS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_CALL_LOGS:
          serviceImpl.streamCallLogs((ondewo.vtsi.LogsOuterClass.StreamCallLogsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.StreamCallLogsResponse>) responseObserver);
          break;
        case METHODID_LIST_CALL_LOGS:
          serviceImpl.listCallLogs((ondewo.vtsi.LogsOuterClass.ListCallLogsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.ListCallLogsResponse>) responseObserver);
          break;
        case METHODID_GET_CALL_LOG_STREAM:
          serviceImpl.getCallLogStream((ondewo.vtsi.LogsOuterClass.GetCallLogStreamRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.CallLogStream>) responseObserver);
          break;
        case METHODID_LIST_CALL_LOG_STREAMS:
          serviceImpl.listCallLogStreams((ondewo.vtsi.LogsOuterClass.ListCallLogStreamsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.ListCallLogStreamsResponse>) responseObserver);
          break;
        case METHODID_DELETE_CALL_LOGS:
          serviceImpl.deleteCallLogs((ondewo.vtsi.LogsOuterClass.DeleteCallLogsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.DeleteCallLogsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getStreamCallLogsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              ondewo.vtsi.LogsOuterClass.StreamCallLogsRequest,
              ondewo.vtsi.LogsOuterClass.StreamCallLogsResponse>(
                service, METHODID_STREAM_CALL_LOGS)))
        .addMethod(
          getListCallLogsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.LogsOuterClass.ListCallLogsRequest,
              ondewo.vtsi.LogsOuterClass.ListCallLogsResponse>(
                service, METHODID_LIST_CALL_LOGS)))
        .addMethod(
          getGetCallLogStreamMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.LogsOuterClass.GetCallLogStreamRequest,
              ondewo.vtsi.LogsOuterClass.CallLogStream>(
                service, METHODID_GET_CALL_LOG_STREAM)))
        .addMethod(
          getListCallLogStreamsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.LogsOuterClass.ListCallLogStreamsRequest,
              ondewo.vtsi.LogsOuterClass.ListCallLogStreamsResponse>(
                service, METHODID_LIST_CALL_LOG_STREAMS)))
        .addMethod(
          getDeleteCallLogsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.LogsOuterClass.DeleteCallLogsRequest,
              ondewo.vtsi.LogsOuterClass.DeleteCallLogsResponse>(
                service, METHODID_DELETE_CALL_LOGS)))
        .build();
  }

  private static abstract class LogsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LogsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ondewo.vtsi.LogsOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Logs");
    }
  }

  private static final class LogsFileDescriptorSupplier
      extends LogsBaseDescriptorSupplier {
    LogsFileDescriptorSupplier() {}
  }

  private static final class LogsMethodDescriptorSupplier
      extends LogsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LogsMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LogsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LogsFileDescriptorSupplier())
              .addMethod(getStreamCallLogsMethod())
              .addMethod(getListCallLogsMethod())
              .addMethod(getGetCallLogStreamMethod())
              .addMethod(getListCallLogStreamsMethod())
              .addMethod(getDeleteCallLogsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
