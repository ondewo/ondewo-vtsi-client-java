package ondewo.vtsi;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
 * &lt;p&gt;Reads, follows, exports and erases the CONTAINER LOGS VTSI captures from the per-call
 * ondewo-sip / ondewo-csi containers of a VTSI project. Entries are served from the VTSI database, not
 * from the docker daemon, so the logs of a container that was already removed stay readable until
 * retention or &lt;code&gt;DeleteCallLogs&lt;/code&gt; removes them.&lt;/p&gt;
 * &lt;p&gt;&lt;b&gt;Secrets are redacted server-side&lt;/b&gt; in every RPC that returns log text
 * (&lt;code&gt;StreamCallLogs&lt;/code&gt;, &lt;code&gt;ListCallLogs&lt;/code&gt;, &lt;code&gt;ExportCallLogs&lt;/code&gt;): the
 * project&amp;apos;s SIP passwords, the call-control secrets and, unless the operator disabled it
 * (&lt;code&gt;ONDEWO_VTSI_LOG_MASK_IDENTIFIERS&lt;/code&gt;, default true), identifiers such as phone numbers. The
 * redaction runs when the entry is read, so a redaction rule added later also applies to entries
 * captured before it.&lt;/p&gt;
 * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
 * filter, cursor, &lt;code&gt;page_token&lt;/code&gt; or &lt;code&gt;field_mask&lt;/code&gt; (each naming the field);
 * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or log stream; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the
 * server already serves its maximum of concurrent streams or exports; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the
 * database cannot be reached.&lt;/p&gt;
 * &lt;p&gt;Authorization (only when the server enforces it, see the &lt;code&gt;Projects&lt;/code&gt; service): a caller
 * without a credential is &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;; every RPC of this service requires
 * &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; and
 * &lt;code&gt;PROJECT_USER&lt;/code&gt; are refused, because log text can carry conversation content), otherwise
 * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, also for an unknown project. A long-running
 * &lt;code&gt;StreamCallLogs&lt;/code&gt; or &lt;code&gt;ExportCallLogs&lt;/code&gt; re-checks the caller&amp;apos;s role
 * periodically and ends when it was revoked or the credential expired.&lt;/p&gt;
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

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.ExportCallLogsRequest,
      ondewo.vtsi.LogsOuterClass.ExportCallLogsResponse> getExportCallLogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportCallLogs",
      requestType = ondewo.vtsi.LogsOuterClass.ExportCallLogsRequest.class,
      responseType = ondewo.vtsi.LogsOuterClass.ExportCallLogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.ExportCallLogsRequest,
      ondewo.vtsi.LogsOuterClass.ExportCallLogsResponse> getExportCallLogsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.LogsOuterClass.ExportCallLogsRequest, ondewo.vtsi.LogsOuterClass.ExportCallLogsResponse> getExportCallLogsMethod;
    if ((getExportCallLogsMethod = LogsGrpc.getExportCallLogsMethod) == null) {
      synchronized (LogsGrpc.class) {
        if ((getExportCallLogsMethod = LogsGrpc.getExportCallLogsMethod) == null) {
          LogsGrpc.getExportCallLogsMethod = getExportCallLogsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.LogsOuterClass.ExportCallLogsRequest, ondewo.vtsi.LogsOuterClass.ExportCallLogsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportCallLogs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.LogsOuterClass.ExportCallLogsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.LogsOuterClass.ExportCallLogsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LogsMethodDescriptorSupplier("ExportCallLogs"))
              .build();
        }
      }
    }
    return getExportCallLogsMethod;
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
   * &lt;p&gt;Reads, follows, exports and erases the CONTAINER LOGS VTSI captures from the per-call
   * ondewo-sip / ondewo-csi containers of a VTSI project. Entries are served from the VTSI database, not
   * from the docker daemon, so the logs of a container that was already removed stay readable until
   * retention or &lt;code&gt;DeleteCallLogs&lt;/code&gt; removes them.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Secrets are redacted server-side&lt;/b&gt; in every RPC that returns log text
   * (&lt;code&gt;StreamCallLogs&lt;/code&gt;, &lt;code&gt;ListCallLogs&lt;/code&gt;, &lt;code&gt;ExportCallLogs&lt;/code&gt;): the
   * project&amp;apos;s SIP passwords, the call-control secrets and, unless the operator disabled it
   * (&lt;code&gt;ONDEWO_VTSI_LOG_MASK_IDENTIFIERS&lt;/code&gt;, default true), identifiers such as phone numbers. The
   * redaction runs when the entry is read, so a redaction rule added later also applies to entries
   * captured before it.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, cursor, &lt;code&gt;page_token&lt;/code&gt; or &lt;code&gt;field_mask&lt;/code&gt; (each naming the field);
   * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or log stream; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the
   * server already serves its maximum of concurrent streams or exports; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the
   * database cannot be reached.&lt;/p&gt;
   * &lt;p&gt;Authorization (only when the server enforces it, see the &lt;code&gt;Projects&lt;/code&gt; service): a caller
   * without a credential is &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;; every RPC of this service requires
   * &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; and
   * &lt;code&gt;PROJECT_USER&lt;/code&gt; are refused, because log text can carry conversation content), otherwise
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, also for an unknown project. A long-running
   * &lt;code&gt;StreamCallLogs&lt;/code&gt; or &lt;code&gt;ExportCallLogs&lt;/code&gt; re-checks the caller&amp;apos;s role
   * periodically and ends when it was revoked or the credential expired.&lt;/p&gt;
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
     * &lt;p&gt;Limits: at most &lt;code&gt;ONDEWO_VTSI_LOG_STREAM_MAX_DURATION_S&lt;/code&gt; (default 3600) seconds per
     * stream, after which the server sends a final message with &lt;code&gt;end_reason_code =
     * LOG_STREAM_END_REASON_MAX_DURATION&lt;/code&gt; and a &lt;code&gt;resume_token&lt;/code&gt; to reconnect with; at most
     * &lt;code&gt;ONDEWO_VTSI_LOG_MAX_CONCURRENT_STREAMS&lt;/code&gt; (default 16) concurrent streams per server,
     * beyond which a new stream is &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;. New entries are polled every
     * &lt;code&gt;ONDEWO_VTSI_LOG_STREAM_POLL_INTERVAL_S&lt;/code&gt; (default 0.5) seconds. The server sends NO
     * keep-alive message: a quiet container sends nothing, so a client must not treat silence as a dead
     * stream (use HTTP/2 keep-alive pings to detect a dead connection).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a filter
     * carrying &lt;code&gt;start_time&lt;/code&gt; or &lt;code&gt;end_time&lt;/code&gt;, an &lt;code&gt;after_seq&lt;/code&gt; with a filter
     * that does not resolve to exactly one log stream, or a malformed &lt;code&gt;resume_token&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; as above. When the
     * caller&amp;apos;s role is revoked or its credential expires during the stream, the server sends a final
     * message (&lt;code&gt;LOG_STREAM_END_REASON_PERMISSION_REVOKED&lt;/code&gt; /
     * &lt;code&gt;LOG_STREAM_END_REASON_CREDENTIALS_EXPIRED&lt;/code&gt;, with a &lt;code&gt;resume_token&lt;/code&gt;) and ends
     * the stream with &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; / &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;No time window is required: without &lt;code&gt;start_time&lt;/code&gt; / &lt;code&gt;end_time&lt;/code&gt; the window is
     * the newest &lt;code&gt;max_lines&lt;/code&gt; matching entries (or, with &lt;code&gt;oldest_first&lt;/code&gt;, the oldest
     * after the cursor). With &lt;code&gt;include_counts&lt;/code&gt; the response also carries the number of matching
     * entries per severity.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, an invalid
     * or over-long &lt;code&gt;regex&lt;/code&gt;, a &lt;code&gt;start_time&lt;/code&gt; after &lt;code&gt;end_time&lt;/code&gt;,
     * &lt;code&gt;before_seq&lt;/code&gt; / &lt;code&gt;after_seq&lt;/code&gt; combined with &lt;code&gt;resume_token&lt;/code&gt; or with a
     * filter that does not resolve to exactly one log stream, a malformed &lt;code&gt;resume_token&lt;/code&gt; or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt; or
     * &lt;code&gt;name&lt;/code&gt;, for a log stream that belongs to another project than
     * &lt;code&gt;vtsi_project_name&lt;/code&gt;, or for an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or log stream.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;Ordered by &lt;code&gt;capture_started_at&lt;/code&gt;, newest first (ties by an internal id, so the order is
     * stable).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a malformed &lt;code&gt;page_token&lt;/code&gt;,
     * &lt;code&gt;LOG_CAPTURE_STATE_UNSPECIFIED&lt;/code&gt; in &lt;code&gt;capture_states&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;Only the identity filters and the time window apply; a time window ALONE (no identity filter)
     * is a valid filter and deletes every entry of the project inside it. The deletion is permanent and
     * runs in batches; a log stream whose last entry was deleted is removed too, unless it is still
     * &lt;code&gt;LOG_CAPTURE_STATE_CAPTURING&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;&lt;b&gt;Race with live capture:&lt;/b&gt; the deletion removes what is stored when it runs. A container
     * whose capture is still running keeps being captured, so entries it emits AFTER the deletion are
     * stored again (there is no tombstone). To erase the logs of a call completely, delete them after
     * the call ended and its capture is &lt;code&gt;LOG_CAPTURE_STATE_STOPPED&lt;/code&gt;, or repeat the deletion.&lt;/p&gt;
     * &lt;p&gt;Idempotent: repeating a deletion succeeds and reports &lt;code&gt;0&lt;/code&gt; deleted entries. With
     * &lt;code&gt;validate_only&lt;/code&gt; nothing is deleted and the counts are what would be deleted.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, an empty
     * filter (a filter whose only field is &lt;code&gt;call_types = [BOTH]&lt;/code&gt; counts as empty), a content
     * filter (&lt;code&gt;text&lt;/code&gt;, &lt;code&gt;regex&lt;/code&gt;, &lt;code&gt;log_levels&lt;/code&gt;, &lt;code&gt;min_log_level&lt;/code&gt;,
     * &lt;code&gt;include_unleveled_lines&lt;/code&gt;, &lt;code&gt;log_sources&lt;/code&gt;, &lt;code&gt;channels&lt;/code&gt;,
     * &lt;code&gt;emitter_prefixes&lt;/code&gt;, &lt;code&gt;thread_names&lt;/code&gt;; presence alone counts) or a
     * &lt;code&gt;start_time&lt;/code&gt; after &lt;code&gt;end_time&lt;/code&gt;; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown
     * project.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project. Every deletion is logged
     * by the server with the project, the filter fields in scope and the deleted counts.&lt;/p&gt;
     * </pre>
     */
    default void deleteCallLogs(ondewo.vtsi.LogsOuterClass.DeleteCallLogsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.DeleteCallLogsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCallLogsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Exports the captured log entries matching a filter as a file: plain text, NDJSON or CSV,
     * streamed in chunks. Entries are exported oldest first, with the same filter semantics and the same
     * server-side secret redaction as &lt;code&gt;ListCallLogs&lt;/code&gt;; unlike &lt;code&gt;ListCallLogs&lt;/code&gt; the
     * content filters are applied to EVERY entry of the window, never only inside a page. Concatenating
     * the &lt;code&gt;chunk&lt;/code&gt;s of all messages in order yields the file.&lt;/p&gt;
     * &lt;p&gt;A bounded time window is REQUIRED: &lt;code&gt;filter.start_time&lt;/code&gt; AND
     * &lt;code&gt;filter.end_time&lt;/code&gt; must both be set, with &lt;code&gt;start_time&lt;/code&gt; before
     * &lt;code&gt;end_time&lt;/code&gt;, because an export reads every entry of the window. (This is stricter than
     * &lt;code&gt;ListCallLogs&lt;/code&gt;, which needs no window because it reads one bounded page.)&lt;/p&gt;
     * &lt;p&gt;Limits: each &lt;code&gt;chunk&lt;/code&gt; is at most 1 MiB; an export holds at most
     * &lt;code&gt;ONDEWO_VTSI_LOG_EXPORT_MAX_ENTRIES&lt;/code&gt; (default 1000000) entries and at most
     * &lt;code&gt;ONDEWO_VTSI_LOG_EXPORT_MAX_BYTES&lt;/code&gt; (default 1 GiB) of output. When a limit is reached the
     * export ends early with &lt;code&gt;truncated = true&lt;/code&gt; on the last message; narrow the window (e.g.
     * start a new export at the timestamp of the last exported entry). At most
     * &lt;code&gt;ONDEWO_VTSI_LOG_MAX_CONCURRENT_EXPORTS&lt;/code&gt; (default 2) exports run per server, beyond which
     * a new one is &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;. The export is a snapshot of what is stored when each
     * entry is read; entries captured during the export may or may not be included.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a missing,
     * empty or inverted time window, an invalid &lt;code&gt;regex&lt;/code&gt; or an unknown
     * &lt;code&gt;format&lt;/code&gt; value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; as above. A role revoked or a credential expired during the export
     * ends it with &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; / &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; and no last message.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void exportCallLogs(ondewo.vtsi.LogsOuterClass.ExportCallLogsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.ExportCallLogsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportCallLogsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Logs.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Reads, follows, exports and erases the CONTAINER LOGS VTSI captures from the per-call
   * ondewo-sip / ondewo-csi containers of a VTSI project. Entries are served from the VTSI database, not
   * from the docker daemon, so the logs of a container that was already removed stay readable until
   * retention or &lt;code&gt;DeleteCallLogs&lt;/code&gt; removes them.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Secrets are redacted server-side&lt;/b&gt; in every RPC that returns log text
   * (&lt;code&gt;StreamCallLogs&lt;/code&gt;, &lt;code&gt;ListCallLogs&lt;/code&gt;, &lt;code&gt;ExportCallLogs&lt;/code&gt;): the
   * project&amp;apos;s SIP passwords, the call-control secrets and, unless the operator disabled it
   * (&lt;code&gt;ONDEWO_VTSI_LOG_MASK_IDENTIFIERS&lt;/code&gt;, default true), identifiers such as phone numbers. The
   * redaction runs when the entry is read, so a redaction rule added later also applies to entries
   * captured before it.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, cursor, &lt;code&gt;page_token&lt;/code&gt; or &lt;code&gt;field_mask&lt;/code&gt; (each naming the field);
   * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or log stream; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the
   * server already serves its maximum of concurrent streams or exports; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the
   * database cannot be reached.&lt;/p&gt;
   * &lt;p&gt;Authorization (only when the server enforces it, see the &lt;code&gt;Projects&lt;/code&gt; service): a caller
   * without a credential is &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;; every RPC of this service requires
   * &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; and
   * &lt;code&gt;PROJECT_USER&lt;/code&gt; are refused, because log text can carry conversation content), otherwise
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, also for an unknown project. A long-running
   * &lt;code&gt;StreamCallLogs&lt;/code&gt; or &lt;code&gt;ExportCallLogs&lt;/code&gt; re-checks the caller&amp;apos;s role
   * periodically and ends when it was revoked or the credential expired.&lt;/p&gt;
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
   * &lt;p&gt;Reads, follows, exports and erases the CONTAINER LOGS VTSI captures from the per-call
   * ondewo-sip / ondewo-csi containers of a VTSI project. Entries are served from the VTSI database, not
   * from the docker daemon, so the logs of a container that was already removed stay readable until
   * retention or &lt;code&gt;DeleteCallLogs&lt;/code&gt; removes them.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Secrets are redacted server-side&lt;/b&gt; in every RPC that returns log text
   * (&lt;code&gt;StreamCallLogs&lt;/code&gt;, &lt;code&gt;ListCallLogs&lt;/code&gt;, &lt;code&gt;ExportCallLogs&lt;/code&gt;): the
   * project&amp;apos;s SIP passwords, the call-control secrets and, unless the operator disabled it
   * (&lt;code&gt;ONDEWO_VTSI_LOG_MASK_IDENTIFIERS&lt;/code&gt;, default true), identifiers such as phone numbers. The
   * redaction runs when the entry is read, so a redaction rule added later also applies to entries
   * captured before it.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, cursor, &lt;code&gt;page_token&lt;/code&gt; or &lt;code&gt;field_mask&lt;/code&gt; (each naming the field);
   * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or log stream; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the
   * server already serves its maximum of concurrent streams or exports; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the
   * database cannot be reached.&lt;/p&gt;
   * &lt;p&gt;Authorization (only when the server enforces it, see the &lt;code&gt;Projects&lt;/code&gt; service): a caller
   * without a credential is &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;; every RPC of this service requires
   * &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; and
   * &lt;code&gt;PROJECT_USER&lt;/code&gt; are refused, because log text can carry conversation content), otherwise
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, also for an unknown project. A long-running
   * &lt;code&gt;StreamCallLogs&lt;/code&gt; or &lt;code&gt;ExportCallLogs&lt;/code&gt; re-checks the caller&amp;apos;s role
   * periodically and ends when it was revoked or the credential expired.&lt;/p&gt;
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
     * &lt;p&gt;Limits: at most &lt;code&gt;ONDEWO_VTSI_LOG_STREAM_MAX_DURATION_S&lt;/code&gt; (default 3600) seconds per
     * stream, after which the server sends a final message with &lt;code&gt;end_reason_code =
     * LOG_STREAM_END_REASON_MAX_DURATION&lt;/code&gt; and a &lt;code&gt;resume_token&lt;/code&gt; to reconnect with; at most
     * &lt;code&gt;ONDEWO_VTSI_LOG_MAX_CONCURRENT_STREAMS&lt;/code&gt; (default 16) concurrent streams per server,
     * beyond which a new stream is &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;. New entries are polled every
     * &lt;code&gt;ONDEWO_VTSI_LOG_STREAM_POLL_INTERVAL_S&lt;/code&gt; (default 0.5) seconds. The server sends NO
     * keep-alive message: a quiet container sends nothing, so a client must not treat silence as a dead
     * stream (use HTTP/2 keep-alive pings to detect a dead connection).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a filter
     * carrying &lt;code&gt;start_time&lt;/code&gt; or &lt;code&gt;end_time&lt;/code&gt;, an &lt;code&gt;after_seq&lt;/code&gt; with a filter
     * that does not resolve to exactly one log stream, or a malformed &lt;code&gt;resume_token&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; as above. When the
     * caller&amp;apos;s role is revoked or its credential expires during the stream, the server sends a final
     * message (&lt;code&gt;LOG_STREAM_END_REASON_PERMISSION_REVOKED&lt;/code&gt; /
     * &lt;code&gt;LOG_STREAM_END_REASON_CREDENTIALS_EXPIRED&lt;/code&gt;, with a &lt;code&gt;resume_token&lt;/code&gt;) and ends
     * the stream with &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; / &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;No time window is required: without &lt;code&gt;start_time&lt;/code&gt; / &lt;code&gt;end_time&lt;/code&gt; the window is
     * the newest &lt;code&gt;max_lines&lt;/code&gt; matching entries (or, with &lt;code&gt;oldest_first&lt;/code&gt;, the oldest
     * after the cursor). With &lt;code&gt;include_counts&lt;/code&gt; the response also carries the number of matching
     * entries per severity.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, an invalid
     * or over-long &lt;code&gt;regex&lt;/code&gt;, a &lt;code&gt;start_time&lt;/code&gt; after &lt;code&gt;end_time&lt;/code&gt;,
     * &lt;code&gt;before_seq&lt;/code&gt; / &lt;code&gt;after_seq&lt;/code&gt; combined with &lt;code&gt;resume_token&lt;/code&gt; or with a
     * filter that does not resolve to exactly one log stream, a malformed &lt;code&gt;resume_token&lt;/code&gt; or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt; or
     * &lt;code&gt;name&lt;/code&gt;, for a log stream that belongs to another project than
     * &lt;code&gt;vtsi_project_name&lt;/code&gt;, or for an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or log stream.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;Ordered by &lt;code&gt;capture_started_at&lt;/code&gt;, newest first (ties by an internal id, so the order is
     * stable).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a malformed &lt;code&gt;page_token&lt;/code&gt;,
     * &lt;code&gt;LOG_CAPTURE_STATE_UNSPECIFIED&lt;/code&gt; in &lt;code&gt;capture_states&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;Only the identity filters and the time window apply; a time window ALONE (no identity filter)
     * is a valid filter and deletes every entry of the project inside it. The deletion is permanent and
     * runs in batches; a log stream whose last entry was deleted is removed too, unless it is still
     * &lt;code&gt;LOG_CAPTURE_STATE_CAPTURING&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;&lt;b&gt;Race with live capture:&lt;/b&gt; the deletion removes what is stored when it runs. A container
     * whose capture is still running keeps being captured, so entries it emits AFTER the deletion are
     * stored again (there is no tombstone). To erase the logs of a call completely, delete them after
     * the call ended and its capture is &lt;code&gt;LOG_CAPTURE_STATE_STOPPED&lt;/code&gt;, or repeat the deletion.&lt;/p&gt;
     * &lt;p&gt;Idempotent: repeating a deletion succeeds and reports &lt;code&gt;0&lt;/code&gt; deleted entries. With
     * &lt;code&gt;validate_only&lt;/code&gt; nothing is deleted and the counts are what would be deleted.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, an empty
     * filter (a filter whose only field is &lt;code&gt;call_types = [BOTH]&lt;/code&gt; counts as empty), a content
     * filter (&lt;code&gt;text&lt;/code&gt;, &lt;code&gt;regex&lt;/code&gt;, &lt;code&gt;log_levels&lt;/code&gt;, &lt;code&gt;min_log_level&lt;/code&gt;,
     * &lt;code&gt;include_unleveled_lines&lt;/code&gt;, &lt;code&gt;log_sources&lt;/code&gt;, &lt;code&gt;channels&lt;/code&gt;,
     * &lt;code&gt;emitter_prefixes&lt;/code&gt;, &lt;code&gt;thread_names&lt;/code&gt;; presence alone counts) or a
     * &lt;code&gt;start_time&lt;/code&gt; after &lt;code&gt;end_time&lt;/code&gt;; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown
     * project.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project. Every deletion is logged
     * by the server with the project, the filter fields in scope and the deleted counts.&lt;/p&gt;
     * </pre>
     */
    public void deleteCallLogs(ondewo.vtsi.LogsOuterClass.DeleteCallLogsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.DeleteCallLogsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCallLogsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Exports the captured log entries matching a filter as a file: plain text, NDJSON or CSV,
     * streamed in chunks. Entries are exported oldest first, with the same filter semantics and the same
     * server-side secret redaction as &lt;code&gt;ListCallLogs&lt;/code&gt;; unlike &lt;code&gt;ListCallLogs&lt;/code&gt; the
     * content filters are applied to EVERY entry of the window, never only inside a page. Concatenating
     * the &lt;code&gt;chunk&lt;/code&gt;s of all messages in order yields the file.&lt;/p&gt;
     * &lt;p&gt;A bounded time window is REQUIRED: &lt;code&gt;filter.start_time&lt;/code&gt; AND
     * &lt;code&gt;filter.end_time&lt;/code&gt; must both be set, with &lt;code&gt;start_time&lt;/code&gt; before
     * &lt;code&gt;end_time&lt;/code&gt;, because an export reads every entry of the window. (This is stricter than
     * &lt;code&gt;ListCallLogs&lt;/code&gt;, which needs no window because it reads one bounded page.)&lt;/p&gt;
     * &lt;p&gt;Limits: each &lt;code&gt;chunk&lt;/code&gt; is at most 1 MiB; an export holds at most
     * &lt;code&gt;ONDEWO_VTSI_LOG_EXPORT_MAX_ENTRIES&lt;/code&gt; (default 1000000) entries and at most
     * &lt;code&gt;ONDEWO_VTSI_LOG_EXPORT_MAX_BYTES&lt;/code&gt; (default 1 GiB) of output. When a limit is reached the
     * export ends early with &lt;code&gt;truncated = true&lt;/code&gt; on the last message; narrow the window (e.g.
     * start a new export at the timestamp of the last exported entry). At most
     * &lt;code&gt;ONDEWO_VTSI_LOG_MAX_CONCURRENT_EXPORTS&lt;/code&gt; (default 2) exports run per server, beyond which
     * a new one is &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;. The export is a snapshot of what is stored when each
     * entry is read; entries captured during the export may or may not be included.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a missing,
     * empty or inverted time window, an invalid &lt;code&gt;regex&lt;/code&gt; or an unknown
     * &lt;code&gt;format&lt;/code&gt; value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; as above. A role revoked or a credential expired during the export
     * ends it with &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; / &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; and no last message.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void exportCallLogs(ondewo.vtsi.LogsOuterClass.ExportCallLogsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.ExportCallLogsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getExportCallLogsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Logs.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Reads, follows, exports and erases the CONTAINER LOGS VTSI captures from the per-call
   * ondewo-sip / ondewo-csi containers of a VTSI project. Entries are served from the VTSI database, not
   * from the docker daemon, so the logs of a container that was already removed stay readable until
   * retention or &lt;code&gt;DeleteCallLogs&lt;/code&gt; removes them.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Secrets are redacted server-side&lt;/b&gt; in every RPC that returns log text
   * (&lt;code&gt;StreamCallLogs&lt;/code&gt;, &lt;code&gt;ListCallLogs&lt;/code&gt;, &lt;code&gt;ExportCallLogs&lt;/code&gt;): the
   * project&amp;apos;s SIP passwords, the call-control secrets and, unless the operator disabled it
   * (&lt;code&gt;ONDEWO_VTSI_LOG_MASK_IDENTIFIERS&lt;/code&gt;, default true), identifiers such as phone numbers. The
   * redaction runs when the entry is read, so a redaction rule added later also applies to entries
   * captured before it.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, cursor, &lt;code&gt;page_token&lt;/code&gt; or &lt;code&gt;field_mask&lt;/code&gt; (each naming the field);
   * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or log stream; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the
   * server already serves its maximum of concurrent streams or exports; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the
   * database cannot be reached.&lt;/p&gt;
   * &lt;p&gt;Authorization (only when the server enforces it, see the &lt;code&gt;Projects&lt;/code&gt; service): a caller
   * without a credential is &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;; every RPC of this service requires
   * &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; and
   * &lt;code&gt;PROJECT_USER&lt;/code&gt; are refused, because log text can carry conversation content), otherwise
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, also for an unknown project. A long-running
   * &lt;code&gt;StreamCallLogs&lt;/code&gt; or &lt;code&gt;ExportCallLogs&lt;/code&gt; re-checks the caller&amp;apos;s role
   * periodically and ends when it was revoked or the credential expired.&lt;/p&gt;
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
     * &lt;p&gt;Limits: at most &lt;code&gt;ONDEWO_VTSI_LOG_STREAM_MAX_DURATION_S&lt;/code&gt; (default 3600) seconds per
     * stream, after which the server sends a final message with &lt;code&gt;end_reason_code =
     * LOG_STREAM_END_REASON_MAX_DURATION&lt;/code&gt; and a &lt;code&gt;resume_token&lt;/code&gt; to reconnect with; at most
     * &lt;code&gt;ONDEWO_VTSI_LOG_MAX_CONCURRENT_STREAMS&lt;/code&gt; (default 16) concurrent streams per server,
     * beyond which a new stream is &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;. New entries are polled every
     * &lt;code&gt;ONDEWO_VTSI_LOG_STREAM_POLL_INTERVAL_S&lt;/code&gt; (default 0.5) seconds. The server sends NO
     * keep-alive message: a quiet container sends nothing, so a client must not treat silence as a dead
     * stream (use HTTP/2 keep-alive pings to detect a dead connection).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a filter
     * carrying &lt;code&gt;start_time&lt;/code&gt; or &lt;code&gt;end_time&lt;/code&gt;, an &lt;code&gt;after_seq&lt;/code&gt; with a filter
     * that does not resolve to exactly one log stream, or a malformed &lt;code&gt;resume_token&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; as above. When the
     * caller&amp;apos;s role is revoked or its credential expires during the stream, the server sends a final
     * message (&lt;code&gt;LOG_STREAM_END_REASON_PERMISSION_REVOKED&lt;/code&gt; /
     * &lt;code&gt;LOG_STREAM_END_REASON_CREDENTIALS_EXPIRED&lt;/code&gt;, with a &lt;code&gt;resume_token&lt;/code&gt;) and ends
     * the stream with &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; / &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;No time window is required: without &lt;code&gt;start_time&lt;/code&gt; / &lt;code&gt;end_time&lt;/code&gt; the window is
     * the newest &lt;code&gt;max_lines&lt;/code&gt; matching entries (or, with &lt;code&gt;oldest_first&lt;/code&gt;, the oldest
     * after the cursor). With &lt;code&gt;include_counts&lt;/code&gt; the response also carries the number of matching
     * entries per severity.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, an invalid
     * or over-long &lt;code&gt;regex&lt;/code&gt;, a &lt;code&gt;start_time&lt;/code&gt; after &lt;code&gt;end_time&lt;/code&gt;,
     * &lt;code&gt;before_seq&lt;/code&gt; / &lt;code&gt;after_seq&lt;/code&gt; combined with &lt;code&gt;resume_token&lt;/code&gt; or with a
     * filter that does not resolve to exactly one log stream, a malformed &lt;code&gt;resume_token&lt;/code&gt; or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt; or
     * &lt;code&gt;name&lt;/code&gt;, for a log stream that belongs to another project than
     * &lt;code&gt;vtsi_project_name&lt;/code&gt;, or for an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or log stream.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;Ordered by &lt;code&gt;capture_started_at&lt;/code&gt;, newest first (ties by an internal id, so the order is
     * stable).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a malformed &lt;code&gt;page_token&lt;/code&gt;,
     * &lt;code&gt;LOG_CAPTURE_STATE_UNSPECIFIED&lt;/code&gt; in &lt;code&gt;capture_states&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;Only the identity filters and the time window apply; a time window ALONE (no identity filter)
     * is a valid filter and deletes every entry of the project inside it. The deletion is permanent and
     * runs in batches; a log stream whose last entry was deleted is removed too, unless it is still
     * &lt;code&gt;LOG_CAPTURE_STATE_CAPTURING&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;&lt;b&gt;Race with live capture:&lt;/b&gt; the deletion removes what is stored when it runs. A container
     * whose capture is still running keeps being captured, so entries it emits AFTER the deletion are
     * stored again (there is no tombstone). To erase the logs of a call completely, delete them after
     * the call ended and its capture is &lt;code&gt;LOG_CAPTURE_STATE_STOPPED&lt;/code&gt;, or repeat the deletion.&lt;/p&gt;
     * &lt;p&gt;Idempotent: repeating a deletion succeeds and reports &lt;code&gt;0&lt;/code&gt; deleted entries. With
     * &lt;code&gt;validate_only&lt;/code&gt; nothing is deleted and the counts are what would be deleted.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, an empty
     * filter (a filter whose only field is &lt;code&gt;call_types = [BOTH]&lt;/code&gt; counts as empty), a content
     * filter (&lt;code&gt;text&lt;/code&gt;, &lt;code&gt;regex&lt;/code&gt;, &lt;code&gt;log_levels&lt;/code&gt;, &lt;code&gt;min_log_level&lt;/code&gt;,
     * &lt;code&gt;include_unleveled_lines&lt;/code&gt;, &lt;code&gt;log_sources&lt;/code&gt;, &lt;code&gt;channels&lt;/code&gt;,
     * &lt;code&gt;emitter_prefixes&lt;/code&gt;, &lt;code&gt;thread_names&lt;/code&gt;; presence alone counts) or a
     * &lt;code&gt;start_time&lt;/code&gt; after &lt;code&gt;end_time&lt;/code&gt;; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown
     * project.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project. Every deletion is logged
     * by the server with the project, the filter fields in scope and the deleted counts.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.LogsOuterClass.DeleteCallLogsResponse deleteCallLogs(ondewo.vtsi.LogsOuterClass.DeleteCallLogsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteCallLogsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Exports the captured log entries matching a filter as a file: plain text, NDJSON or CSV,
     * streamed in chunks. Entries are exported oldest first, with the same filter semantics and the same
     * server-side secret redaction as &lt;code&gt;ListCallLogs&lt;/code&gt;; unlike &lt;code&gt;ListCallLogs&lt;/code&gt; the
     * content filters are applied to EVERY entry of the window, never only inside a page. Concatenating
     * the &lt;code&gt;chunk&lt;/code&gt;s of all messages in order yields the file.&lt;/p&gt;
     * &lt;p&gt;A bounded time window is REQUIRED: &lt;code&gt;filter.start_time&lt;/code&gt; AND
     * &lt;code&gt;filter.end_time&lt;/code&gt; must both be set, with &lt;code&gt;start_time&lt;/code&gt; before
     * &lt;code&gt;end_time&lt;/code&gt;, because an export reads every entry of the window. (This is stricter than
     * &lt;code&gt;ListCallLogs&lt;/code&gt;, which needs no window because it reads one bounded page.)&lt;/p&gt;
     * &lt;p&gt;Limits: each &lt;code&gt;chunk&lt;/code&gt; is at most 1 MiB; an export holds at most
     * &lt;code&gt;ONDEWO_VTSI_LOG_EXPORT_MAX_ENTRIES&lt;/code&gt; (default 1000000) entries and at most
     * &lt;code&gt;ONDEWO_VTSI_LOG_EXPORT_MAX_BYTES&lt;/code&gt; (default 1 GiB) of output. When a limit is reached the
     * export ends early with &lt;code&gt;truncated = true&lt;/code&gt; on the last message; narrow the window (e.g.
     * start a new export at the timestamp of the last exported entry). At most
     * &lt;code&gt;ONDEWO_VTSI_LOG_MAX_CONCURRENT_EXPORTS&lt;/code&gt; (default 2) exports run per server, beyond which
     * a new one is &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;. The export is a snapshot of what is stored when each
     * entry is read; entries captured during the export may or may not be included.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a missing,
     * empty or inverted time window, an invalid &lt;code&gt;regex&lt;/code&gt; or an unknown
     * &lt;code&gt;format&lt;/code&gt; value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; as above. A role revoked or a credential expired during the export
     * ends it with &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; / &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; and no last message.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, ondewo.vtsi.LogsOuterClass.ExportCallLogsResponse>
        exportCallLogs(ondewo.vtsi.LogsOuterClass.ExportCallLogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getExportCallLogsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Logs.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Reads, follows, exports and erases the CONTAINER LOGS VTSI captures from the per-call
   * ondewo-sip / ondewo-csi containers of a VTSI project. Entries are served from the VTSI database, not
   * from the docker daemon, so the logs of a container that was already removed stay readable until
   * retention or &lt;code&gt;DeleteCallLogs&lt;/code&gt; removes them.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Secrets are redacted server-side&lt;/b&gt; in every RPC that returns log text
   * (&lt;code&gt;StreamCallLogs&lt;/code&gt;, &lt;code&gt;ListCallLogs&lt;/code&gt;, &lt;code&gt;ExportCallLogs&lt;/code&gt;): the
   * project&amp;apos;s SIP passwords, the call-control secrets and, unless the operator disabled it
   * (&lt;code&gt;ONDEWO_VTSI_LOG_MASK_IDENTIFIERS&lt;/code&gt;, default true), identifiers such as phone numbers. The
   * redaction runs when the entry is read, so a redaction rule added later also applies to entries
   * captured before it.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, cursor, &lt;code&gt;page_token&lt;/code&gt; or &lt;code&gt;field_mask&lt;/code&gt; (each naming the field);
   * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or log stream; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the
   * server already serves its maximum of concurrent streams or exports; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the
   * database cannot be reached.&lt;/p&gt;
   * &lt;p&gt;Authorization (only when the server enforces it, see the &lt;code&gt;Projects&lt;/code&gt; service): a caller
   * without a credential is &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;; every RPC of this service requires
   * &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; and
   * &lt;code&gt;PROJECT_USER&lt;/code&gt; are refused, because log text can carry conversation content), otherwise
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, also for an unknown project. A long-running
   * &lt;code&gt;StreamCallLogs&lt;/code&gt; or &lt;code&gt;ExportCallLogs&lt;/code&gt; re-checks the caller&amp;apos;s role
   * periodically and ends when it was revoked or the credential expired.&lt;/p&gt;
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
     * &lt;p&gt;Limits: at most &lt;code&gt;ONDEWO_VTSI_LOG_STREAM_MAX_DURATION_S&lt;/code&gt; (default 3600) seconds per
     * stream, after which the server sends a final message with &lt;code&gt;end_reason_code =
     * LOG_STREAM_END_REASON_MAX_DURATION&lt;/code&gt; and a &lt;code&gt;resume_token&lt;/code&gt; to reconnect with; at most
     * &lt;code&gt;ONDEWO_VTSI_LOG_MAX_CONCURRENT_STREAMS&lt;/code&gt; (default 16) concurrent streams per server,
     * beyond which a new stream is &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;. New entries are polled every
     * &lt;code&gt;ONDEWO_VTSI_LOG_STREAM_POLL_INTERVAL_S&lt;/code&gt; (default 0.5) seconds. The server sends NO
     * keep-alive message: a quiet container sends nothing, so a client must not treat silence as a dead
     * stream (use HTTP/2 keep-alive pings to detect a dead connection).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a filter
     * carrying &lt;code&gt;start_time&lt;/code&gt; or &lt;code&gt;end_time&lt;/code&gt;, an &lt;code&gt;after_seq&lt;/code&gt; with a filter
     * that does not resolve to exactly one log stream, or a malformed &lt;code&gt;resume_token&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; as above. When the
     * caller&amp;apos;s role is revoked or its credential expires during the stream, the server sends a final
     * message (&lt;code&gt;LOG_STREAM_END_REASON_PERMISSION_REVOKED&lt;/code&gt; /
     * &lt;code&gt;LOG_STREAM_END_REASON_CREDENTIALS_EXPIRED&lt;/code&gt;, with a &lt;code&gt;resume_token&lt;/code&gt;) and ends
     * the stream with &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; / &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;No time window is required: without &lt;code&gt;start_time&lt;/code&gt; / &lt;code&gt;end_time&lt;/code&gt; the window is
     * the newest &lt;code&gt;max_lines&lt;/code&gt; matching entries (or, with &lt;code&gt;oldest_first&lt;/code&gt;, the oldest
     * after the cursor). With &lt;code&gt;include_counts&lt;/code&gt; the response also carries the number of matching
     * entries per severity.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, an invalid
     * or over-long &lt;code&gt;regex&lt;/code&gt;, a &lt;code&gt;start_time&lt;/code&gt; after &lt;code&gt;end_time&lt;/code&gt;,
     * &lt;code&gt;before_seq&lt;/code&gt; / &lt;code&gt;after_seq&lt;/code&gt; combined with &lt;code&gt;resume_token&lt;/code&gt; or with a
     * filter that does not resolve to exactly one log stream, a malformed &lt;code&gt;resume_token&lt;/code&gt; or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt; or
     * &lt;code&gt;name&lt;/code&gt;, for a log stream that belongs to another project than
     * &lt;code&gt;vtsi_project_name&lt;/code&gt;, or for an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or log stream.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;Ordered by &lt;code&gt;capture_started_at&lt;/code&gt;, newest first (ties by an internal id, so the order is
     * stable).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a malformed &lt;code&gt;page_token&lt;/code&gt;,
     * &lt;code&gt;LOG_CAPTURE_STATE_UNSPECIFIED&lt;/code&gt; in &lt;code&gt;capture_states&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;Only the identity filters and the time window apply; a time window ALONE (no identity filter)
     * is a valid filter and deletes every entry of the project inside it. The deletion is permanent and
     * runs in batches; a log stream whose last entry was deleted is removed too, unless it is still
     * &lt;code&gt;LOG_CAPTURE_STATE_CAPTURING&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;&lt;b&gt;Race with live capture:&lt;/b&gt; the deletion removes what is stored when it runs. A container
     * whose capture is still running keeps being captured, so entries it emits AFTER the deletion are
     * stored again (there is no tombstone). To erase the logs of a call completely, delete them after
     * the call ended and its capture is &lt;code&gt;LOG_CAPTURE_STATE_STOPPED&lt;/code&gt;, or repeat the deletion.&lt;/p&gt;
     * &lt;p&gt;Idempotent: repeating a deletion succeeds and reports &lt;code&gt;0&lt;/code&gt; deleted entries. With
     * &lt;code&gt;validate_only&lt;/code&gt; nothing is deleted and the counts are what would be deleted.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, an empty
     * filter (a filter whose only field is &lt;code&gt;call_types = [BOTH]&lt;/code&gt; counts as empty), a content
     * filter (&lt;code&gt;text&lt;/code&gt;, &lt;code&gt;regex&lt;/code&gt;, &lt;code&gt;log_levels&lt;/code&gt;, &lt;code&gt;min_log_level&lt;/code&gt;,
     * &lt;code&gt;include_unleveled_lines&lt;/code&gt;, &lt;code&gt;log_sources&lt;/code&gt;, &lt;code&gt;channels&lt;/code&gt;,
     * &lt;code&gt;emitter_prefixes&lt;/code&gt;, &lt;code&gt;thread_names&lt;/code&gt;; presence alone counts) or a
     * &lt;code&gt;start_time&lt;/code&gt; after &lt;code&gt;end_time&lt;/code&gt;; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown
     * project.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project. Every deletion is logged
     * by the server with the project, the filter fields in scope and the deleted counts.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.LogsOuterClass.DeleteCallLogsResponse deleteCallLogs(ondewo.vtsi.LogsOuterClass.DeleteCallLogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCallLogsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Exports the captured log entries matching a filter as a file: plain text, NDJSON or CSV,
     * streamed in chunks. Entries are exported oldest first, with the same filter semantics and the same
     * server-side secret redaction as &lt;code&gt;ListCallLogs&lt;/code&gt;; unlike &lt;code&gt;ListCallLogs&lt;/code&gt; the
     * content filters are applied to EVERY entry of the window, never only inside a page. Concatenating
     * the &lt;code&gt;chunk&lt;/code&gt;s of all messages in order yields the file.&lt;/p&gt;
     * &lt;p&gt;A bounded time window is REQUIRED: &lt;code&gt;filter.start_time&lt;/code&gt; AND
     * &lt;code&gt;filter.end_time&lt;/code&gt; must both be set, with &lt;code&gt;start_time&lt;/code&gt; before
     * &lt;code&gt;end_time&lt;/code&gt;, because an export reads every entry of the window. (This is stricter than
     * &lt;code&gt;ListCallLogs&lt;/code&gt;, which needs no window because it reads one bounded page.)&lt;/p&gt;
     * &lt;p&gt;Limits: each &lt;code&gt;chunk&lt;/code&gt; is at most 1 MiB; an export holds at most
     * &lt;code&gt;ONDEWO_VTSI_LOG_EXPORT_MAX_ENTRIES&lt;/code&gt; (default 1000000) entries and at most
     * &lt;code&gt;ONDEWO_VTSI_LOG_EXPORT_MAX_BYTES&lt;/code&gt; (default 1 GiB) of output. When a limit is reached the
     * export ends early with &lt;code&gt;truncated = true&lt;/code&gt; on the last message; narrow the window (e.g.
     * start a new export at the timestamp of the last exported entry). At most
     * &lt;code&gt;ONDEWO_VTSI_LOG_MAX_CONCURRENT_EXPORTS&lt;/code&gt; (default 2) exports run per server, beyond which
     * a new one is &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;. The export is a snapshot of what is stored when each
     * entry is read; entries captured during the export may or may not be included.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a missing,
     * empty or inverted time window, an invalid &lt;code&gt;regex&lt;/code&gt; or an unknown
     * &lt;code&gt;format&lt;/code&gt; value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; as above. A role revoked or a credential expired during the export
     * ends it with &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; / &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; and no last message.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public java.util.Iterator<ondewo.vtsi.LogsOuterClass.ExportCallLogsResponse> exportCallLogs(
        ondewo.vtsi.LogsOuterClass.ExportCallLogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getExportCallLogsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Logs.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Reads, follows, exports and erases the CONTAINER LOGS VTSI captures from the per-call
   * ondewo-sip / ondewo-csi containers of a VTSI project. Entries are served from the VTSI database, not
   * from the docker daemon, so the logs of a container that was already removed stay readable until
   * retention or &lt;code&gt;DeleteCallLogs&lt;/code&gt; removes them.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Secrets are redacted server-side&lt;/b&gt; in every RPC that returns log text
   * (&lt;code&gt;StreamCallLogs&lt;/code&gt;, &lt;code&gt;ListCallLogs&lt;/code&gt;, &lt;code&gt;ExportCallLogs&lt;/code&gt;): the
   * project&amp;apos;s SIP passwords, the call-control secrets and, unless the operator disabled it
   * (&lt;code&gt;ONDEWO_VTSI_LOG_MASK_IDENTIFIERS&lt;/code&gt;, default true), identifiers such as phone numbers. The
   * redaction runs when the entry is read, so a redaction rule added later also applies to entries
   * captured before it.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, cursor, &lt;code&gt;page_token&lt;/code&gt; or &lt;code&gt;field_mask&lt;/code&gt; (each naming the field);
   * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or log stream; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the
   * server already serves its maximum of concurrent streams or exports; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the
   * database cannot be reached.&lt;/p&gt;
   * &lt;p&gt;Authorization (only when the server enforces it, see the &lt;code&gt;Projects&lt;/code&gt; service): a caller
   * without a credential is &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;; every RPC of this service requires
   * &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; and
   * &lt;code&gt;PROJECT_USER&lt;/code&gt; are refused, because log text can carry conversation content), otherwise
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, also for an unknown project. A long-running
   * &lt;code&gt;StreamCallLogs&lt;/code&gt; or &lt;code&gt;ExportCallLogs&lt;/code&gt; re-checks the caller&amp;apos;s role
   * periodically and ends when it was revoked or the credential expired.&lt;/p&gt;
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
     * &lt;p&gt;No time window is required: without &lt;code&gt;start_time&lt;/code&gt; / &lt;code&gt;end_time&lt;/code&gt; the window is
     * the newest &lt;code&gt;max_lines&lt;/code&gt; matching entries (or, with &lt;code&gt;oldest_first&lt;/code&gt;, the oldest
     * after the cursor). With &lt;code&gt;include_counts&lt;/code&gt; the response also carries the number of matching
     * entries per severity.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, an invalid
     * or over-long &lt;code&gt;regex&lt;/code&gt;, a &lt;code&gt;start_time&lt;/code&gt; after &lt;code&gt;end_time&lt;/code&gt;,
     * &lt;code&gt;before_seq&lt;/code&gt; / &lt;code&gt;after_seq&lt;/code&gt; combined with &lt;code&gt;resume_token&lt;/code&gt; or with a
     * filter that does not resolve to exactly one log stream, a malformed &lt;code&gt;resume_token&lt;/code&gt; or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt; or
     * &lt;code&gt;name&lt;/code&gt;, for a log stream that belongs to another project than
     * &lt;code&gt;vtsi_project_name&lt;/code&gt;, or for an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or log stream.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;Ordered by &lt;code&gt;capture_started_at&lt;/code&gt;, newest first (ties by an internal id, so the order is
     * stable).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a malformed &lt;code&gt;page_token&lt;/code&gt;,
     * &lt;code&gt;LOG_CAPTURE_STATE_UNSPECIFIED&lt;/code&gt; in &lt;code&gt;capture_states&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
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
     * &lt;p&gt;Only the identity filters and the time window apply; a time window ALONE (no identity filter)
     * is a valid filter and deletes every entry of the project inside it. The deletion is permanent and
     * runs in batches; a log stream whose last entry was deleted is removed too, unless it is still
     * &lt;code&gt;LOG_CAPTURE_STATE_CAPTURING&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;&lt;b&gt;Race with live capture:&lt;/b&gt; the deletion removes what is stored when it runs. A container
     * whose capture is still running keeps being captured, so entries it emits AFTER the deletion are
     * stored again (there is no tombstone). To erase the logs of a call completely, delete them after
     * the call ended and its capture is &lt;code&gt;LOG_CAPTURE_STATE_STOPPED&lt;/code&gt;, or repeat the deletion.&lt;/p&gt;
     * &lt;p&gt;Idempotent: repeating a deletion succeeds and reports &lt;code&gt;0&lt;/code&gt; deleted entries. With
     * &lt;code&gt;validate_only&lt;/code&gt; nothing is deleted and the counts are what would be deleted.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, an empty
     * filter (a filter whose only field is &lt;code&gt;call_types = [BOTH]&lt;/code&gt; counts as empty), a content
     * filter (&lt;code&gt;text&lt;/code&gt;, &lt;code&gt;regex&lt;/code&gt;, &lt;code&gt;log_levels&lt;/code&gt;, &lt;code&gt;min_log_level&lt;/code&gt;,
     * &lt;code&gt;include_unleveled_lines&lt;/code&gt;, &lt;code&gt;log_sources&lt;/code&gt;, &lt;code&gt;channels&lt;/code&gt;,
     * &lt;code&gt;emitter_prefixes&lt;/code&gt;, &lt;code&gt;thread_names&lt;/code&gt;; presence alone counts) or a
     * &lt;code&gt;start_time&lt;/code&gt; after &lt;code&gt;end_time&lt;/code&gt;; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown
     * project.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project. Every deletion is logged
     * by the server with the project, the filter fields in scope and the deleted counts.&lt;/p&gt;
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
  private static final int METHODID_EXPORT_CALL_LOGS = 5;

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
        case METHODID_EXPORT_CALL_LOGS:
          serviceImpl.exportCallLogs((ondewo.vtsi.LogsOuterClass.ExportCallLogsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.LogsOuterClass.ExportCallLogsResponse>) responseObserver);
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
        .addMethod(
          getExportCallLogsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              ondewo.vtsi.LogsOuterClass.ExportCallLogsRequest,
              ondewo.vtsi.LogsOuterClass.ExportCallLogsResponse>(
                service, METHODID_EXPORT_CALL_LOGS)))
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
              .addMethod(getExportCallLogsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
