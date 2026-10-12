package ondewo.vtsi;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class CallsGrpc {

  private CallsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ondewo.vtsi.Calls";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartCallerRequest,
      ondewo.vtsi.CallsOuterClass.StartCallerResponse> getStartCallerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartCaller",
      requestType = ondewo.vtsi.CallsOuterClass.StartCallerRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StartCallerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartCallerRequest,
      ondewo.vtsi.CallsOuterClass.StartCallerResponse> getStartCallerMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartCallerRequest, ondewo.vtsi.CallsOuterClass.StartCallerResponse> getStartCallerMethod;
    if ((getStartCallerMethod = CallsGrpc.getStartCallerMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getStartCallerMethod = CallsGrpc.getStartCallerMethod) == null) {
          CallsGrpc.getStartCallerMethod = getStartCallerMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.StartCallerRequest, ondewo.vtsi.CallsOuterClass.StartCallerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartCaller"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StartCallerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StartCallerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("StartCaller"))
              .build();
        }
      }
    }
    return getStartCallerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartCallersRequest,
      ondewo.vtsi.CallsOuterClass.StartCallersResponse> getStartCallersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartCallers",
      requestType = ondewo.vtsi.CallsOuterClass.StartCallersRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StartCallersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartCallersRequest,
      ondewo.vtsi.CallsOuterClass.StartCallersResponse> getStartCallersMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartCallersRequest, ondewo.vtsi.CallsOuterClass.StartCallersResponse> getStartCallersMethod;
    if ((getStartCallersMethod = CallsGrpc.getStartCallersMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getStartCallersMethod = CallsGrpc.getStartCallersMethod) == null) {
          CallsGrpc.getStartCallersMethod = getStartCallersMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.StartCallersRequest, ondewo.vtsi.CallsOuterClass.StartCallersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartCallers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StartCallersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StartCallersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("StartCallers"))
              .build();
        }
      }
    }
    return getStartCallersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.ListCallersRequest,
      ondewo.vtsi.CallsOuterClass.ListCallersResponse> getListCallersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCallers",
      requestType = ondewo.vtsi.CallsOuterClass.ListCallersRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.ListCallersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.ListCallersRequest,
      ondewo.vtsi.CallsOuterClass.ListCallersResponse> getListCallersMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.ListCallersRequest, ondewo.vtsi.CallsOuterClass.ListCallersResponse> getListCallersMethod;
    if ((getListCallersMethod = CallsGrpc.getListCallersMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getListCallersMethod = CallsGrpc.getListCallersMethod) == null) {
          CallsGrpc.getListCallersMethod = getListCallersMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.ListCallersRequest, ondewo.vtsi.CallsOuterClass.ListCallersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCallers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.ListCallersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.ListCallersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("ListCallers"))
              .build();
        }
      }
    }
    return getListCallersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.GetCallerRequest,
      ondewo.vtsi.CallsOuterClass.Caller> getGetCallerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCaller",
      requestType = ondewo.vtsi.CallsOuterClass.GetCallerRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.Caller.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.GetCallerRequest,
      ondewo.vtsi.CallsOuterClass.Caller> getGetCallerMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.GetCallerRequest, ondewo.vtsi.CallsOuterClass.Caller> getGetCallerMethod;
    if ((getGetCallerMethod = CallsGrpc.getGetCallerMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getGetCallerMethod = CallsGrpc.getGetCallerMethod) == null) {
          CallsGrpc.getGetCallerMethod = getGetCallerMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.GetCallerRequest, ondewo.vtsi.CallsOuterClass.Caller>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCaller"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.GetCallerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.Caller.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("GetCaller"))
              .build();
        }
      }
    }
    return getGetCallerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateCallerRequest,
      ondewo.vtsi.CallsOuterClass.UpdateCallerResponse> getUpdateCallerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCaller",
      requestType = ondewo.vtsi.CallsOuterClass.UpdateCallerRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.UpdateCallerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateCallerRequest,
      ondewo.vtsi.CallsOuterClass.UpdateCallerResponse> getUpdateCallerMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateCallerRequest, ondewo.vtsi.CallsOuterClass.UpdateCallerResponse> getUpdateCallerMethod;
    if ((getUpdateCallerMethod = CallsGrpc.getUpdateCallerMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getUpdateCallerMethod = CallsGrpc.getUpdateCallerMethod) == null) {
          CallsGrpc.getUpdateCallerMethod = getUpdateCallerMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.UpdateCallerRequest, ondewo.vtsi.CallsOuterClass.UpdateCallerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCaller"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.UpdateCallerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.UpdateCallerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("UpdateCaller"))
              .build();
        }
      }
    }
    return getUpdateCallerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateCallersRequest,
      ondewo.vtsi.CallsOuterClass.UpdateCallersResponse> getUpdateCallersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCallers",
      requestType = ondewo.vtsi.CallsOuterClass.UpdateCallersRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.UpdateCallersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateCallersRequest,
      ondewo.vtsi.CallsOuterClass.UpdateCallersResponse> getUpdateCallersMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateCallersRequest, ondewo.vtsi.CallsOuterClass.UpdateCallersResponse> getUpdateCallersMethod;
    if ((getUpdateCallersMethod = CallsGrpc.getUpdateCallersMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getUpdateCallersMethod = CallsGrpc.getUpdateCallersMethod) == null) {
          CallsGrpc.getUpdateCallersMethod = getUpdateCallersMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.UpdateCallersRequest, ondewo.vtsi.CallsOuterClass.UpdateCallersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCallers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.UpdateCallersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.UpdateCallersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("UpdateCallers"))
              .build();
        }
      }
    }
    return getUpdateCallersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.DeleteCallerRequest,
      ondewo.vtsi.CallsOuterClass.DeleteCallerResponse> getDeleteCallerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCaller",
      requestType = ondewo.vtsi.CallsOuterClass.DeleteCallerRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.DeleteCallerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.DeleteCallerRequest,
      ondewo.vtsi.CallsOuterClass.DeleteCallerResponse> getDeleteCallerMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.DeleteCallerRequest, ondewo.vtsi.CallsOuterClass.DeleteCallerResponse> getDeleteCallerMethod;
    if ((getDeleteCallerMethod = CallsGrpc.getDeleteCallerMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getDeleteCallerMethod = CallsGrpc.getDeleteCallerMethod) == null) {
          CallsGrpc.getDeleteCallerMethod = getDeleteCallerMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.DeleteCallerRequest, ondewo.vtsi.CallsOuterClass.DeleteCallerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCaller"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.DeleteCallerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.DeleteCallerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("DeleteCaller"))
              .build();
        }
      }
    }
    return getDeleteCallerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.DeleteCallersRequest,
      ondewo.vtsi.CallsOuterClass.DeleteCallersResponse> getDeleteCallersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCallers",
      requestType = ondewo.vtsi.CallsOuterClass.DeleteCallersRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.DeleteCallersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.DeleteCallersRequest,
      ondewo.vtsi.CallsOuterClass.DeleteCallersResponse> getDeleteCallersMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.DeleteCallersRequest, ondewo.vtsi.CallsOuterClass.DeleteCallersResponse> getDeleteCallersMethod;
    if ((getDeleteCallersMethod = CallsGrpc.getDeleteCallersMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getDeleteCallersMethod = CallsGrpc.getDeleteCallersMethod) == null) {
          CallsGrpc.getDeleteCallersMethod = getDeleteCallersMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.DeleteCallersRequest, ondewo.vtsi.CallsOuterClass.DeleteCallersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCallers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.DeleteCallersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.DeleteCallersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("DeleteCallers"))
              .build();
        }
      }
    }
    return getDeleteCallersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopCallerRequest,
      ondewo.vtsi.CallsOuterClass.StopCallerResponse> getStopCallerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopCaller",
      requestType = ondewo.vtsi.CallsOuterClass.StopCallerRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StopCallerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopCallerRequest,
      ondewo.vtsi.CallsOuterClass.StopCallerResponse> getStopCallerMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopCallerRequest, ondewo.vtsi.CallsOuterClass.StopCallerResponse> getStopCallerMethod;
    if ((getStopCallerMethod = CallsGrpc.getStopCallerMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getStopCallerMethod = CallsGrpc.getStopCallerMethod) == null) {
          CallsGrpc.getStopCallerMethod = getStopCallerMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.StopCallerRequest, ondewo.vtsi.CallsOuterClass.StopCallerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopCaller"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StopCallerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StopCallerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("StopCaller"))
              .build();
        }
      }
    }
    return getStopCallerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopCallersRequest,
      ondewo.vtsi.CallsOuterClass.StopCallersResponse> getStopCallersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopCallers",
      requestType = ondewo.vtsi.CallsOuterClass.StopCallersRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StopCallersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopCallersRequest,
      ondewo.vtsi.CallsOuterClass.StopCallersResponse> getStopCallersMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopCallersRequest, ondewo.vtsi.CallsOuterClass.StopCallersResponse> getStopCallersMethod;
    if ((getStopCallersMethod = CallsGrpc.getStopCallersMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getStopCallersMethod = CallsGrpc.getStopCallersMethod) == null) {
          CallsGrpc.getStopCallersMethod = getStopCallersMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.StopCallersRequest, ondewo.vtsi.CallsOuterClass.StopCallersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopCallers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StopCallersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StopCallersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("StopCallers"))
              .build();
        }
      }
    }
    return getStopCallersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartListenerRequest,
      ondewo.vtsi.CallsOuterClass.StartListenerResponse> getStartListenerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartListener",
      requestType = ondewo.vtsi.CallsOuterClass.StartListenerRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StartListenerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartListenerRequest,
      ondewo.vtsi.CallsOuterClass.StartListenerResponse> getStartListenerMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartListenerRequest, ondewo.vtsi.CallsOuterClass.StartListenerResponse> getStartListenerMethod;
    if ((getStartListenerMethod = CallsGrpc.getStartListenerMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getStartListenerMethod = CallsGrpc.getStartListenerMethod) == null) {
          CallsGrpc.getStartListenerMethod = getStartListenerMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.StartListenerRequest, ondewo.vtsi.CallsOuterClass.StartListenerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartListener"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StartListenerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StartListenerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("StartListener"))
              .build();
        }
      }
    }
    return getStartListenerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartListenersRequest,
      ondewo.vtsi.CallsOuterClass.StartListenersResponse> getStartListenersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartListeners",
      requestType = ondewo.vtsi.CallsOuterClass.StartListenersRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StartListenersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartListenersRequest,
      ondewo.vtsi.CallsOuterClass.StartListenersResponse> getStartListenersMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartListenersRequest, ondewo.vtsi.CallsOuterClass.StartListenersResponse> getStartListenersMethod;
    if ((getStartListenersMethod = CallsGrpc.getStartListenersMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getStartListenersMethod = CallsGrpc.getStartListenersMethod) == null) {
          CallsGrpc.getStartListenersMethod = getStartListenersMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.StartListenersRequest, ondewo.vtsi.CallsOuterClass.StartListenersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartListeners"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StartListenersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StartListenersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("StartListeners"))
              .build();
        }
      }
    }
    return getStartListenersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopListenerRequest,
      ondewo.vtsi.CallsOuterClass.StopListenerResponse> getStopListenerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopListener",
      requestType = ondewo.vtsi.CallsOuterClass.StopListenerRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StopListenerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopListenerRequest,
      ondewo.vtsi.CallsOuterClass.StopListenerResponse> getStopListenerMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopListenerRequest, ondewo.vtsi.CallsOuterClass.StopListenerResponse> getStopListenerMethod;
    if ((getStopListenerMethod = CallsGrpc.getStopListenerMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getStopListenerMethod = CallsGrpc.getStopListenerMethod) == null) {
          CallsGrpc.getStopListenerMethod = getStopListenerMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.StopListenerRequest, ondewo.vtsi.CallsOuterClass.StopListenerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopListener"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StopListenerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StopListenerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("StopListener"))
              .build();
        }
      }
    }
    return getStopListenerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopListenersRequest,
      ondewo.vtsi.CallsOuterClass.StopListenersResponse> getStopListenersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopListeners",
      requestType = ondewo.vtsi.CallsOuterClass.StopListenersRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StopListenersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopListenersRequest,
      ondewo.vtsi.CallsOuterClass.StopListenersResponse> getStopListenersMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopListenersRequest, ondewo.vtsi.CallsOuterClass.StopListenersResponse> getStopListenersMethod;
    if ((getStopListenersMethod = CallsGrpc.getStopListenersMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getStopListenersMethod = CallsGrpc.getStopListenersMethod) == null) {
          CallsGrpc.getStopListenersMethod = getStopListenersMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.StopListenersRequest, ondewo.vtsi.CallsOuterClass.StopListenersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopListeners"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StopListenersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StopListenersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("StopListeners"))
              .build();
        }
      }
    }
    return getStopListenersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.ListListenersRequest,
      ondewo.vtsi.CallsOuterClass.ListListenersResponse> getListListenersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListListeners",
      requestType = ondewo.vtsi.CallsOuterClass.ListListenersRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.ListListenersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.ListListenersRequest,
      ondewo.vtsi.CallsOuterClass.ListListenersResponse> getListListenersMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.ListListenersRequest, ondewo.vtsi.CallsOuterClass.ListListenersResponse> getListListenersMethod;
    if ((getListListenersMethod = CallsGrpc.getListListenersMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getListListenersMethod = CallsGrpc.getListListenersMethod) == null) {
          CallsGrpc.getListListenersMethod = getListListenersMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.ListListenersRequest, ondewo.vtsi.CallsOuterClass.ListListenersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListListeners"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.ListListenersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.ListListenersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("ListListeners"))
              .build();
        }
      }
    }
    return getListListenersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.GetListenerRequest,
      ondewo.vtsi.CallsOuterClass.Listener> getGetListenerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetListener",
      requestType = ondewo.vtsi.CallsOuterClass.GetListenerRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.Listener.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.GetListenerRequest,
      ondewo.vtsi.CallsOuterClass.Listener> getGetListenerMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.GetListenerRequest, ondewo.vtsi.CallsOuterClass.Listener> getGetListenerMethod;
    if ((getGetListenerMethod = CallsGrpc.getGetListenerMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getGetListenerMethod = CallsGrpc.getGetListenerMethod) == null) {
          CallsGrpc.getGetListenerMethod = getGetListenerMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.GetListenerRequest, ondewo.vtsi.CallsOuterClass.Listener>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetListener"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.GetListenerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.Listener.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("GetListener"))
              .build();
        }
      }
    }
    return getGetListenerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateListenerRequest,
      ondewo.vtsi.CallsOuterClass.UpdateListenerResponse> getUpdateListenerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateListener",
      requestType = ondewo.vtsi.CallsOuterClass.UpdateListenerRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.UpdateListenerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateListenerRequest,
      ondewo.vtsi.CallsOuterClass.UpdateListenerResponse> getUpdateListenerMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateListenerRequest, ondewo.vtsi.CallsOuterClass.UpdateListenerResponse> getUpdateListenerMethod;
    if ((getUpdateListenerMethod = CallsGrpc.getUpdateListenerMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getUpdateListenerMethod = CallsGrpc.getUpdateListenerMethod) == null) {
          CallsGrpc.getUpdateListenerMethod = getUpdateListenerMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.UpdateListenerRequest, ondewo.vtsi.CallsOuterClass.UpdateListenerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateListener"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.UpdateListenerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.UpdateListenerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("UpdateListener"))
              .build();
        }
      }
    }
    return getUpdateListenerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateListenersRequest,
      ondewo.vtsi.CallsOuterClass.UpdateListenersResponse> getUpdateListenersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateListeners",
      requestType = ondewo.vtsi.CallsOuterClass.UpdateListenersRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.UpdateListenersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateListenersRequest,
      ondewo.vtsi.CallsOuterClass.UpdateListenersResponse> getUpdateListenersMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateListenersRequest, ondewo.vtsi.CallsOuterClass.UpdateListenersResponse> getUpdateListenersMethod;
    if ((getUpdateListenersMethod = CallsGrpc.getUpdateListenersMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getUpdateListenersMethod = CallsGrpc.getUpdateListenersMethod) == null) {
          CallsGrpc.getUpdateListenersMethod = getUpdateListenersMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.UpdateListenersRequest, ondewo.vtsi.CallsOuterClass.UpdateListenersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateListeners"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.UpdateListenersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.UpdateListenersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("UpdateListeners"))
              .build();
        }
      }
    }
    return getUpdateListenersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.DeleteListenerRequest,
      ondewo.vtsi.CallsOuterClass.DeleteListenerResponse> getDeleteListenerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteListener",
      requestType = ondewo.vtsi.CallsOuterClass.DeleteListenerRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.DeleteListenerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.DeleteListenerRequest,
      ondewo.vtsi.CallsOuterClass.DeleteListenerResponse> getDeleteListenerMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.DeleteListenerRequest, ondewo.vtsi.CallsOuterClass.DeleteListenerResponse> getDeleteListenerMethod;
    if ((getDeleteListenerMethod = CallsGrpc.getDeleteListenerMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getDeleteListenerMethod = CallsGrpc.getDeleteListenerMethod) == null) {
          CallsGrpc.getDeleteListenerMethod = getDeleteListenerMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.DeleteListenerRequest, ondewo.vtsi.CallsOuterClass.DeleteListenerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteListener"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.DeleteListenerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.DeleteListenerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("DeleteListener"))
              .build();
        }
      }
    }
    return getDeleteListenerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.DeleteListenersRequest,
      ondewo.vtsi.CallsOuterClass.DeleteListenersResponse> getDeleteListenersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteListeners",
      requestType = ondewo.vtsi.CallsOuterClass.DeleteListenersRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.DeleteListenersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.DeleteListenersRequest,
      ondewo.vtsi.CallsOuterClass.DeleteListenersResponse> getDeleteListenersMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.DeleteListenersRequest, ondewo.vtsi.CallsOuterClass.DeleteListenersResponse> getDeleteListenersMethod;
    if ((getDeleteListenersMethod = CallsGrpc.getDeleteListenersMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getDeleteListenersMethod = CallsGrpc.getDeleteListenersMethod) == null) {
          CallsGrpc.getDeleteListenersMethod = getDeleteListenersMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.DeleteListenersRequest, ondewo.vtsi.CallsOuterClass.DeleteListenersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteListeners"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.DeleteListenersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.DeleteListenersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("DeleteListeners"))
              .build();
        }
      }
    }
    return getDeleteListenersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartScheduledCallerRequest,
      ondewo.vtsi.CallsOuterClass.StartScheduledCallerResponse> getStartScheduledCallerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartScheduledCaller",
      requestType = ondewo.vtsi.CallsOuterClass.StartScheduledCallerRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StartScheduledCallerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartScheduledCallerRequest,
      ondewo.vtsi.CallsOuterClass.StartScheduledCallerResponse> getStartScheduledCallerMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartScheduledCallerRequest, ondewo.vtsi.CallsOuterClass.StartScheduledCallerResponse> getStartScheduledCallerMethod;
    if ((getStartScheduledCallerMethod = CallsGrpc.getStartScheduledCallerMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getStartScheduledCallerMethod = CallsGrpc.getStartScheduledCallerMethod) == null) {
          CallsGrpc.getStartScheduledCallerMethod = getStartScheduledCallerMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.StartScheduledCallerRequest, ondewo.vtsi.CallsOuterClass.StartScheduledCallerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartScheduledCaller"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StartScheduledCallerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StartScheduledCallerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("StartScheduledCaller"))
              .build();
        }
      }
    }
    return getStartScheduledCallerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartScheduledCallersRequest,
      ondewo.vtsi.CallsOuterClass.StartScheduledCallersResponse> getStartScheduledCallersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartScheduledCallers",
      requestType = ondewo.vtsi.CallsOuterClass.StartScheduledCallersRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StartScheduledCallersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartScheduledCallersRequest,
      ondewo.vtsi.CallsOuterClass.StartScheduledCallersResponse> getStartScheduledCallersMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StartScheduledCallersRequest, ondewo.vtsi.CallsOuterClass.StartScheduledCallersResponse> getStartScheduledCallersMethod;
    if ((getStartScheduledCallersMethod = CallsGrpc.getStartScheduledCallersMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getStartScheduledCallersMethod = CallsGrpc.getStartScheduledCallersMethod) == null) {
          CallsGrpc.getStartScheduledCallersMethod = getStartScheduledCallersMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.StartScheduledCallersRequest, ondewo.vtsi.CallsOuterClass.StartScheduledCallersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartScheduledCallers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StartScheduledCallersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StartScheduledCallersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("StartScheduledCallers"))
              .build();
        }
      }
    }
    return getStartScheduledCallersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.AddCallersToCampaignRequest,
      ondewo.vtsi.CallsOuterClass.AddCallersToCampaignResponse> getAddCallersToCampaignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddCallersToCampaign",
      requestType = ondewo.vtsi.CallsOuterClass.AddCallersToCampaignRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.AddCallersToCampaignResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.AddCallersToCampaignRequest,
      ondewo.vtsi.CallsOuterClass.AddCallersToCampaignResponse> getAddCallersToCampaignMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.AddCallersToCampaignRequest, ondewo.vtsi.CallsOuterClass.AddCallersToCampaignResponse> getAddCallersToCampaignMethod;
    if ((getAddCallersToCampaignMethod = CallsGrpc.getAddCallersToCampaignMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getAddCallersToCampaignMethod = CallsGrpc.getAddCallersToCampaignMethod) == null) {
          CallsGrpc.getAddCallersToCampaignMethod = getAddCallersToCampaignMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.AddCallersToCampaignRequest, ondewo.vtsi.CallsOuterClass.AddCallersToCampaignResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddCallersToCampaign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.AddCallersToCampaignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.AddCallersToCampaignResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("AddCallersToCampaign"))
              .build();
        }
      }
    }
    return getAddCallersToCampaignMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignRequest,
      ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignResponse> getAddScheduledCallersToCampaignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddScheduledCallersToCampaign",
      requestType = ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignRequest,
      ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignResponse> getAddScheduledCallersToCampaignMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignRequest, ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignResponse> getAddScheduledCallersToCampaignMethod;
    if ((getAddScheduledCallersToCampaignMethod = CallsGrpc.getAddScheduledCallersToCampaignMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getAddScheduledCallersToCampaignMethod = CallsGrpc.getAddScheduledCallersToCampaignMethod) == null) {
          CallsGrpc.getAddScheduledCallersToCampaignMethod = getAddScheduledCallersToCampaignMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignRequest, ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddScheduledCallersToCampaign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("AddScheduledCallersToCampaign"))
              .build();
        }
      }
    }
    return getAddScheduledCallersToCampaignMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.GetScheduledCallerRequest,
      ondewo.vtsi.CallsOuterClass.ScheduledCaller> getGetScheduledCallerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetScheduledCaller",
      requestType = ondewo.vtsi.CallsOuterClass.GetScheduledCallerRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.ScheduledCaller.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.GetScheduledCallerRequest,
      ondewo.vtsi.CallsOuterClass.ScheduledCaller> getGetScheduledCallerMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.GetScheduledCallerRequest, ondewo.vtsi.CallsOuterClass.ScheduledCaller> getGetScheduledCallerMethod;
    if ((getGetScheduledCallerMethod = CallsGrpc.getGetScheduledCallerMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getGetScheduledCallerMethod = CallsGrpc.getGetScheduledCallerMethod) == null) {
          CallsGrpc.getGetScheduledCallerMethod = getGetScheduledCallerMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.GetScheduledCallerRequest, ondewo.vtsi.CallsOuterClass.ScheduledCaller>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetScheduledCaller"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.GetScheduledCallerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.ScheduledCaller.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("GetScheduledCaller"))
              .build();
        }
      }
    }
    return getGetScheduledCallerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.ListScheduledCallersRequest,
      ondewo.vtsi.CallsOuterClass.ListScheduledCallersResponse> getListScheduledCallersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListScheduledCallers",
      requestType = ondewo.vtsi.CallsOuterClass.ListScheduledCallersRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.ListScheduledCallersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.ListScheduledCallersRequest,
      ondewo.vtsi.CallsOuterClass.ListScheduledCallersResponse> getListScheduledCallersMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.ListScheduledCallersRequest, ondewo.vtsi.CallsOuterClass.ListScheduledCallersResponse> getListScheduledCallersMethod;
    if ((getListScheduledCallersMethod = CallsGrpc.getListScheduledCallersMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getListScheduledCallersMethod = CallsGrpc.getListScheduledCallersMethod) == null) {
          CallsGrpc.getListScheduledCallersMethod = getListScheduledCallersMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.ListScheduledCallersRequest, ondewo.vtsi.CallsOuterClass.ListScheduledCallersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListScheduledCallers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.ListScheduledCallersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.ListScheduledCallersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("ListScheduledCallers"))
              .build();
        }
      }
    }
    return getListScheduledCallersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateScheduledCallerRequest,
      ondewo.vtsi.CallsOuterClass.ScheduledCaller> getUpdateScheduledCallerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateScheduledCaller",
      requestType = ondewo.vtsi.CallsOuterClass.UpdateScheduledCallerRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.ScheduledCaller.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateScheduledCallerRequest,
      ondewo.vtsi.CallsOuterClass.ScheduledCaller> getUpdateScheduledCallerMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateScheduledCallerRequest, ondewo.vtsi.CallsOuterClass.ScheduledCaller> getUpdateScheduledCallerMethod;
    if ((getUpdateScheduledCallerMethod = CallsGrpc.getUpdateScheduledCallerMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getUpdateScheduledCallerMethod = CallsGrpc.getUpdateScheduledCallerMethod) == null) {
          CallsGrpc.getUpdateScheduledCallerMethod = getUpdateScheduledCallerMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.UpdateScheduledCallerRequest, ondewo.vtsi.CallsOuterClass.ScheduledCaller>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateScheduledCaller"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.UpdateScheduledCallerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.ScheduledCaller.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("UpdateScheduledCaller"))
              .build();
        }
      }
    }
    return getUpdateScheduledCallerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.CancelScheduledCallerRequest,
      ondewo.vtsi.CallsOuterClass.CancelScheduledCallerResponse> getCancelScheduledCallerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelScheduledCaller",
      requestType = ondewo.vtsi.CallsOuterClass.CancelScheduledCallerRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.CancelScheduledCallerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.CancelScheduledCallerRequest,
      ondewo.vtsi.CallsOuterClass.CancelScheduledCallerResponse> getCancelScheduledCallerMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.CancelScheduledCallerRequest, ondewo.vtsi.CallsOuterClass.CancelScheduledCallerResponse> getCancelScheduledCallerMethod;
    if ((getCancelScheduledCallerMethod = CallsGrpc.getCancelScheduledCallerMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getCancelScheduledCallerMethod = CallsGrpc.getCancelScheduledCallerMethod) == null) {
          CallsGrpc.getCancelScheduledCallerMethod = getCancelScheduledCallerMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.CancelScheduledCallerRequest, ondewo.vtsi.CallsOuterClass.CancelScheduledCallerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelScheduledCaller"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.CancelScheduledCallerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.CancelScheduledCallerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("CancelScheduledCaller"))
              .build();
        }
      }
    }
    return getCancelScheduledCallerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.CancelScheduledCallersRequest,
      ondewo.vtsi.CallsOuterClass.CancelScheduledCallersResponse> getCancelScheduledCallersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelScheduledCallers",
      requestType = ondewo.vtsi.CallsOuterClass.CancelScheduledCallersRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.CancelScheduledCallersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.CancelScheduledCallersRequest,
      ondewo.vtsi.CallsOuterClass.CancelScheduledCallersResponse> getCancelScheduledCallersMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.CancelScheduledCallersRequest, ondewo.vtsi.CallsOuterClass.CancelScheduledCallersResponse> getCancelScheduledCallersMethod;
    if ((getCancelScheduledCallersMethod = CallsGrpc.getCancelScheduledCallersMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getCancelScheduledCallersMethod = CallsGrpc.getCancelScheduledCallersMethod) == null) {
          CallsGrpc.getCancelScheduledCallersMethod = getCancelScheduledCallersMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.CancelScheduledCallersRequest, ondewo.vtsi.CallsOuterClass.CancelScheduledCallersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelScheduledCallers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.CancelScheduledCallersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.CancelScheduledCallersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("CancelScheduledCallers"))
              .build();
        }
      }
    }
    return getCancelScheduledCallersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.RetryScheduledCallerRequest,
      ondewo.vtsi.CallsOuterClass.ScheduledCaller> getRetryScheduledCallerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetryScheduledCaller",
      requestType = ondewo.vtsi.CallsOuterClass.RetryScheduledCallerRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.ScheduledCaller.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.RetryScheduledCallerRequest,
      ondewo.vtsi.CallsOuterClass.ScheduledCaller> getRetryScheduledCallerMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.RetryScheduledCallerRequest, ondewo.vtsi.CallsOuterClass.ScheduledCaller> getRetryScheduledCallerMethod;
    if ((getRetryScheduledCallerMethod = CallsGrpc.getRetryScheduledCallerMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getRetryScheduledCallerMethod = CallsGrpc.getRetryScheduledCallerMethod) == null) {
          CallsGrpc.getRetryScheduledCallerMethod = getRetryScheduledCallerMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.RetryScheduledCallerRequest, ondewo.vtsi.CallsOuterClass.ScheduledCaller>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RetryScheduledCaller"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.RetryScheduledCallerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.ScheduledCaller.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("RetryScheduledCaller"))
              .build();
        }
      }
    }
    return getRetryScheduledCallerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopCallRequest,
      ondewo.vtsi.CallsOuterClass.StopCallResponse> getStopCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopCall",
      requestType = ondewo.vtsi.CallsOuterClass.StopCallRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StopCallResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopCallRequest,
      ondewo.vtsi.CallsOuterClass.StopCallResponse> getStopCallMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopCallRequest, ondewo.vtsi.CallsOuterClass.StopCallResponse> getStopCallMethod;
    if ((getStopCallMethod = CallsGrpc.getStopCallMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getStopCallMethod = CallsGrpc.getStopCallMethod) == null) {
          CallsGrpc.getStopCallMethod = getStopCallMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.StopCallRequest, ondewo.vtsi.CallsOuterClass.StopCallResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopCall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StopCallRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StopCallResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("StopCall"))
              .build();
        }
      }
    }
    return getStopCallMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopCallsRequest,
      ondewo.vtsi.CallsOuterClass.StopCallsResponse> getStopCallsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopCalls",
      requestType = ondewo.vtsi.CallsOuterClass.StopCallsRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StopCallsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopCallsRequest,
      ondewo.vtsi.CallsOuterClass.StopCallsResponse> getStopCallsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopCallsRequest, ondewo.vtsi.CallsOuterClass.StopCallsResponse> getStopCallsMethod;
    if ((getStopCallsMethod = CallsGrpc.getStopCallsMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getStopCallsMethod = CallsGrpc.getStopCallsMethod) == null) {
          CallsGrpc.getStopCallsMethod = getStopCallsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.StopCallsRequest, ondewo.vtsi.CallsOuterClass.StopCallsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopCalls"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StopCallsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StopCallsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("StopCalls"))
              .build();
        }
      }
    }
    return getStopCallsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopAllCallsRequest,
      ondewo.vtsi.CallsOuterClass.StopCallsResponse> getStopAllCallsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopAllCalls",
      requestType = ondewo.vtsi.CallsOuterClass.StopAllCallsRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StopCallsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopAllCallsRequest,
      ondewo.vtsi.CallsOuterClass.StopCallsResponse> getStopAllCallsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StopAllCallsRequest, ondewo.vtsi.CallsOuterClass.StopCallsResponse> getStopAllCallsMethod;
    if ((getStopAllCallsMethod = CallsGrpc.getStopAllCallsMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getStopAllCallsMethod = CallsGrpc.getStopAllCallsMethod) == null) {
          CallsGrpc.getStopAllCallsMethod = getStopAllCallsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.StopAllCallsRequest, ondewo.vtsi.CallsOuterClass.StopCallsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopAllCalls"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StopAllCallsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StopCallsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("StopAllCalls"))
              .build();
        }
      }
    }
    return getStopAllCallsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.TransferCallRequest,
      ondewo.vtsi.CallsOuterClass.TransferCallResponse> getTransferCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TransferCall",
      requestType = ondewo.vtsi.CallsOuterClass.TransferCallRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.TransferCallResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.TransferCallRequest,
      ondewo.vtsi.CallsOuterClass.TransferCallResponse> getTransferCallMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.TransferCallRequest, ondewo.vtsi.CallsOuterClass.TransferCallResponse> getTransferCallMethod;
    if ((getTransferCallMethod = CallsGrpc.getTransferCallMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getTransferCallMethod = CallsGrpc.getTransferCallMethod) == null) {
          CallsGrpc.getTransferCallMethod = getTransferCallMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.TransferCallRequest, ondewo.vtsi.CallsOuterClass.TransferCallResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TransferCall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.TransferCallRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.TransferCallResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("TransferCall"))
              .build();
        }
      }
    }
    return getTransferCallMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.TransferCallsRequest,
      ondewo.vtsi.CallsOuterClass.TransferCallsResponse> getTransferCallsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TransferCalls",
      requestType = ondewo.vtsi.CallsOuterClass.TransferCallsRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.TransferCallsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.TransferCallsRequest,
      ondewo.vtsi.CallsOuterClass.TransferCallsResponse> getTransferCallsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.TransferCallsRequest, ondewo.vtsi.CallsOuterClass.TransferCallsResponse> getTransferCallsMethod;
    if ((getTransferCallsMethod = CallsGrpc.getTransferCallsMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getTransferCallsMethod = CallsGrpc.getTransferCallsMethod) == null) {
          CallsGrpc.getTransferCallsMethod = getTransferCallsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.TransferCallsRequest, ondewo.vtsi.CallsOuterClass.TransferCallsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TransferCalls"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.TransferCallsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.TransferCallsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("TransferCalls"))
              .build();
        }
      }
    }
    return getTransferCallsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.GetCallRequest,
      ondewo.vtsi.CallsOuterClass.Call> getGetCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCall",
      requestType = ondewo.vtsi.CallsOuterClass.GetCallRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.Call.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.GetCallRequest,
      ondewo.vtsi.CallsOuterClass.Call> getGetCallMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.GetCallRequest, ondewo.vtsi.CallsOuterClass.Call> getGetCallMethod;
    if ((getGetCallMethod = CallsGrpc.getGetCallMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getGetCallMethod = CallsGrpc.getGetCallMethod) == null) {
          CallsGrpc.getGetCallMethod = getGetCallMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.GetCallRequest, ondewo.vtsi.CallsOuterClass.Call>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.GetCallRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.Call.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("GetCall"))
              .build();
        }
      }
    }
    return getGetCallMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.ListCallsRequest,
      ondewo.vtsi.CallsOuterClass.ListCallsResponse> getListCallsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCalls",
      requestType = ondewo.vtsi.CallsOuterClass.ListCallsRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.ListCallsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.ListCallsRequest,
      ondewo.vtsi.CallsOuterClass.ListCallsResponse> getListCallsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.ListCallsRequest, ondewo.vtsi.CallsOuterClass.ListCallsResponse> getListCallsMethod;
    if ((getListCallsMethod = CallsGrpc.getListCallsMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getListCallsMethod = CallsGrpc.getListCallsMethod) == null) {
          CallsGrpc.getListCallsMethod = getListCallsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.ListCallsRequest, ondewo.vtsi.CallsOuterClass.ListCallsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCalls"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.ListCallsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.ListCallsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("ListCalls"))
              .build();
        }
      }
    }
    return getListCallsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.GetCallStatisticsRequest,
      ondewo.vtsi.CallsOuterClass.CallStatistics> getGetCallStatisticsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCallStatistics",
      requestType = ondewo.vtsi.CallsOuterClass.GetCallStatisticsRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.CallStatistics.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.GetCallStatisticsRequest,
      ondewo.vtsi.CallsOuterClass.CallStatistics> getGetCallStatisticsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.GetCallStatisticsRequest, ondewo.vtsi.CallsOuterClass.CallStatistics> getGetCallStatisticsMethod;
    if ((getGetCallStatisticsMethod = CallsGrpc.getGetCallStatisticsMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getGetCallStatisticsMethod = CallsGrpc.getGetCallStatisticsMethod) == null) {
          CallsGrpc.getGetCallStatisticsMethod = getGetCallStatisticsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.GetCallStatisticsRequest, ondewo.vtsi.CallsOuterClass.CallStatistics>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCallStatistics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.GetCallStatisticsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.CallStatistics.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("GetCallStatistics"))
              .build();
        }
      }
    }
    return getGetCallStatisticsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateCallRequest,
      ondewo.vtsi.CallsOuterClass.UpdateCallResponse> getUpdateCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCall",
      requestType = ondewo.vtsi.CallsOuterClass.UpdateCallRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.UpdateCallResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateCallRequest,
      ondewo.vtsi.CallsOuterClass.UpdateCallResponse> getUpdateCallMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateCallRequest, ondewo.vtsi.CallsOuterClass.UpdateCallResponse> getUpdateCallMethod;
    if ((getUpdateCallMethod = CallsGrpc.getUpdateCallMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getUpdateCallMethod = CallsGrpc.getUpdateCallMethod) == null) {
          CallsGrpc.getUpdateCallMethod = getUpdateCallMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.UpdateCallRequest, ondewo.vtsi.CallsOuterClass.UpdateCallResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.UpdateCallRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.UpdateCallResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("UpdateCall"))
              .build();
        }
      }
    }
    return getUpdateCallMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateCallsRequest,
      ondewo.vtsi.CallsOuterClass.UpdateCallsResponse> getUpdateCallsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCalls",
      requestType = ondewo.vtsi.CallsOuterClass.UpdateCallsRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.UpdateCallsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateCallsRequest,
      ondewo.vtsi.CallsOuterClass.UpdateCallsResponse> getUpdateCallsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.UpdateCallsRequest, ondewo.vtsi.CallsOuterClass.UpdateCallsResponse> getUpdateCallsMethod;
    if ((getUpdateCallsMethod = CallsGrpc.getUpdateCallsMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getUpdateCallsMethod = CallsGrpc.getUpdateCallsMethod) == null) {
          CallsGrpc.getUpdateCallsMethod = getUpdateCallsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.UpdateCallsRequest, ondewo.vtsi.CallsOuterClass.UpdateCallsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCalls"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.UpdateCallsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.UpdateCallsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("UpdateCalls"))
              .build();
        }
      }
    }
    return getUpdateCallsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StreamCallerStatusRequest,
      ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> getStreamCallerStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamCallerStatus",
      requestType = ondewo.vtsi.CallsOuterClass.StreamCallerStatusRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StreamCallerStatusRequest,
      ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> getStreamCallerStatusMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StreamCallerStatusRequest, ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> getStreamCallerStatusMethod;
    if ((getStreamCallerStatusMethod = CallsGrpc.getStreamCallerStatusMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getStreamCallerStatusMethod = CallsGrpc.getStreamCallerStatusMethod) == null) {
          CallsGrpc.getStreamCallerStatusMethod = getStreamCallerStatusMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.StreamCallerStatusRequest, ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamCallerStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StreamCallerStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("StreamCallerStatus"))
              .build();
        }
      }
    }
    return getStreamCallerStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StreamListenerStatusRequest,
      ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> getStreamListenerStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamListenerStatus",
      requestType = ondewo.vtsi.CallsOuterClass.StreamListenerStatusRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StreamListenerStatusRequest,
      ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> getStreamListenerStatusMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StreamListenerStatusRequest, ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> getStreamListenerStatusMethod;
    if ((getStreamListenerStatusMethod = CallsGrpc.getStreamListenerStatusMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getStreamListenerStatusMethod = CallsGrpc.getStreamListenerStatusMethod) == null) {
          CallsGrpc.getStreamListenerStatusMethod = getStreamListenerStatusMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.StreamListenerStatusRequest, ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamListenerStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StreamListenerStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("StreamListenerStatus"))
              .build();
        }
      }
    }
    return getStreamListenerStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StreamScheduledCallerStatusRequest,
      ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> getStreamScheduledCallerStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamScheduledCallerStatus",
      requestType = ondewo.vtsi.CallsOuterClass.StreamScheduledCallerStatusRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StreamScheduledCallerStatusRequest,
      ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> getStreamScheduledCallerStatusMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StreamScheduledCallerStatusRequest, ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> getStreamScheduledCallerStatusMethod;
    if ((getStreamScheduledCallerStatusMethod = CallsGrpc.getStreamScheduledCallerStatusMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getStreamScheduledCallerStatusMethod = CallsGrpc.getStreamScheduledCallerStatusMethod) == null) {
          CallsGrpc.getStreamScheduledCallerStatusMethod = getStreamScheduledCallerStatusMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.StreamScheduledCallerStatusRequest, ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamScheduledCallerStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StreamScheduledCallerStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("StreamScheduledCallerStatus"))
              .build();
        }
      }
    }
    return getStreamScheduledCallerStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.InviteToCallRequest,
      ondewo.vtsi.CallsOuterClass.InviteToCallResponse> getInviteToCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InviteToCall",
      requestType = ondewo.vtsi.CallsOuterClass.InviteToCallRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.InviteToCallResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.InviteToCallRequest,
      ondewo.vtsi.CallsOuterClass.InviteToCallResponse> getInviteToCallMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.InviteToCallRequest, ondewo.vtsi.CallsOuterClass.InviteToCallResponse> getInviteToCallMethod;
    if ((getInviteToCallMethod = CallsGrpc.getInviteToCallMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getInviteToCallMethod = CallsGrpc.getInviteToCallMethod) == null) {
          CallsGrpc.getInviteToCallMethod = getInviteToCallMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.InviteToCallRequest, ondewo.vtsi.CallsOuterClass.InviteToCallResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InviteToCall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.InviteToCallRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.InviteToCallResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("InviteToCall"))
              .build();
        }
      }
    }
    return getInviteToCallMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.RemoveCallParticipantRequest,
      ondewo.vtsi.CallsOuterClass.RemoveCallParticipantResponse> getRemoveCallParticipantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveCallParticipant",
      requestType = ondewo.vtsi.CallsOuterClass.RemoveCallParticipantRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.RemoveCallParticipantResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.RemoveCallParticipantRequest,
      ondewo.vtsi.CallsOuterClass.RemoveCallParticipantResponse> getRemoveCallParticipantMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.RemoveCallParticipantRequest, ondewo.vtsi.CallsOuterClass.RemoveCallParticipantResponse> getRemoveCallParticipantMethod;
    if ((getRemoveCallParticipantMethod = CallsGrpc.getRemoveCallParticipantMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getRemoveCallParticipantMethod = CallsGrpc.getRemoveCallParticipantMethod) == null) {
          CallsGrpc.getRemoveCallParticipantMethod = getRemoveCallParticipantMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.RemoveCallParticipantRequest, ondewo.vtsi.CallsOuterClass.RemoveCallParticipantResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveCallParticipant"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.RemoveCallParticipantRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.RemoveCallParticipantResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("RemoveCallParticipant"))
              .build();
        }
      }
    }
    return getRemoveCallParticipantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.SetCallMediaControlRequest,
      ondewo.vtsi.CallsOuterClass.SetCallMediaControlResponse> getSetCallMediaControlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetCallMediaControl",
      requestType = ondewo.vtsi.CallsOuterClass.SetCallMediaControlRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.SetCallMediaControlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.SetCallMediaControlRequest,
      ondewo.vtsi.CallsOuterClass.SetCallMediaControlResponse> getSetCallMediaControlMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.SetCallMediaControlRequest, ondewo.vtsi.CallsOuterClass.SetCallMediaControlResponse> getSetCallMediaControlMethod;
    if ((getSetCallMediaControlMethod = CallsGrpc.getSetCallMediaControlMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getSetCallMediaControlMethod = CallsGrpc.getSetCallMediaControlMethod) == null) {
          CallsGrpc.getSetCallMediaControlMethod = getSetCallMediaControlMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.SetCallMediaControlRequest, ondewo.vtsi.CallsOuterClass.SetCallMediaControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetCallMediaControl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.SetCallMediaControlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.SetCallMediaControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("SetCallMediaControl"))
              .build();
        }
      }
    }
    return getSetCallMediaControlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StreamCallAudioRequest,
      ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse> getStreamCallAudioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamCallAudio",
      requestType = ondewo.vtsi.CallsOuterClass.StreamCallAudioRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StreamCallAudioRequest,
      ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse> getStreamCallAudioMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.StreamCallAudioRequest, ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse> getStreamCallAudioMethod;
    if ((getStreamCallAudioMethod = CallsGrpc.getStreamCallAudioMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getStreamCallAudioMethod = CallsGrpc.getStreamCallAudioMethod) == null) {
          CallsGrpc.getStreamCallAudioMethod = getStreamCallAudioMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.StreamCallAudioRequest, ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamCallAudio"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StreamCallAudioRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("StreamCallAudio"))
              .build();
        }
      }
    }
    return getStreamCallAudioMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.ListenCallAudioRequest,
      ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse> getListenCallAudioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListenCallAudio",
      requestType = ondewo.vtsi.CallsOuterClass.ListenCallAudioRequest.class,
      responseType = ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.ListenCallAudioRequest,
      ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse> getListenCallAudioMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CallsOuterClass.ListenCallAudioRequest, ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse> getListenCallAudioMethod;
    if ((getListenCallAudioMethod = CallsGrpc.getListenCallAudioMethod) == null) {
      synchronized (CallsGrpc.class) {
        if ((getListenCallAudioMethod = CallsGrpc.getListenCallAudioMethod) == null) {
          CallsGrpc.getListenCallAudioMethod = getListenCallAudioMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CallsOuterClass.ListenCallAudioRequest, ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListenCallAudio"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.ListenCallAudioRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CallsMethodDescriptorSupplier("ListenCallAudio"))
              .build();
        }
      }
    }
    return getListenCallAudioMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CallsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CallsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CallsStub>() {
        @java.lang.Override
        public CallsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CallsStub(channel, callOptions);
        }
      };
    return CallsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static CallsBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CallsBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CallsBlockingV2Stub>() {
        @java.lang.Override
        public CallsBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CallsBlockingV2Stub(channel, callOptions);
        }
      };
    return CallsBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CallsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CallsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CallsBlockingStub>() {
        @java.lang.Override
        public CallsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CallsBlockingStub(channel, callOptions);
        }
      };
    return CallsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CallsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CallsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CallsFutureStub>() {
        @java.lang.Override
        public CallsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CallsFutureStub(channel, callOptions);
        }
      };
    return CallsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * &lt;p&gt;Starts one caller in a VTSI project: an ondewo-sip container that places one outbound call to
     * &lt;code&gt;sip_caller_config.callee_id&lt;/code&gt; (or a pooled caller of the server&amp;apos;s caller pool that runs the same
     * configuration). The configuration is validated first, including live checks against the upstream services;
     * nothing is started when it fails. Not idempotent: every successful request places a new call (send it as a
     * batch of one with an &lt;code&gt;idempotency_key&lt;/code&gt; to make it idempotent). &lt;code&gt;validate_only&lt;/code&gt; runs the
     * validation alone.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed or invalid request or
     * configuration (also when the NLU credentials are refused) or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when an upstream config lacks
     * the required TLS certificate (&lt;code&gt;UPSTREAM_TLS_REQUIRED&lt;/code&gt;) or the project is not deployed;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the project reached its caller limit; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when an
     * upstream service could not be reached; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_STARTED&lt;/code&gt; or &lt;code&gt;VTSI_EVENT_CALLER_START_FAILED&lt;/code&gt;, then the
     * events of the call (&lt;code&gt;VTSI_EVENT_CALL_*&lt;/code&gt;). None with &lt;code&gt;validate_only&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void startCaller(ondewo.vtsi.CallsOuterClass.StartCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartCallerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartCallerMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts several callers, each like &lt;code&gt;StartCaller&lt;/code&gt;. Not atomic: every caller is started on its own;
     * a caller that fails to start is rolled back and has no entry in the response, which accounts for it in
     * &lt;code&gt;StartCallersResponse.error_message&lt;/code&gt;. The project&amp;apos;s caller limit is checked for the batch as a
     * whole before anything is started (&lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;, nothing started). Idempotent per
     * &lt;code&gt;idempotency_key&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StartCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void startCallers(ondewo.vtsi.CallsOuterClass.StartCallersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartCallersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartCallersMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the callers of a VTSI project, ordered by the caller&amp;apos;s uuid (the last segment of
     * &lt;code&gt;name&lt;/code&gt;), ascending: a stable order, not a chronological one. Paged with &lt;code&gt;page_size&lt;/code&gt; /
     * &lt;code&gt;page_token&lt;/code&gt;; &lt;code&gt;total_size&lt;/code&gt; counts every match.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;campaign_name&lt;/code&gt; or &lt;code&gt;campaign_display_name&lt;/code&gt; set, lists only the callers of that
     * campaign: the callers that placed at least one attempt of one of its campaign calls (see
     * &lt;code&gt;ListCallersRequest.campaign_name&lt;/code&gt;). &lt;code&gt;active_only&lt;/code&gt; and &lt;code&gt;sip_status_types&lt;/code&gt;
     * narrow the listing further.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, an invalid selector, a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a &lt;code&gt;page_token&lt;/code&gt; of another listing or an unknown &lt;code&gt;field_mask&lt;/code&gt;
     * path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or campaign; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void listCallers(ondewo.vtsi.CallsOuterClass.ListCallersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ListCallersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCallersMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a caller, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or caller, or a caller of another project; with authorization
     * enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void getCaller(ondewo.vtsi.CallsOuterClass.GetCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.Caller> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCallerMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the STORED configuration of a caller: the fields named in &lt;code&gt;update_mask&lt;/code&gt;, i.e.
     * &lt;code&gt;sip_caller_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt; or any nested sub-path of them.
     * Allowed whether or not the caller has a call running.&lt;/p&gt;
     * &lt;p&gt;A running call and its container are NEVER changed: nothing is restarted, redeployed or reconfigured,
     * and the call goes on with the configuration its container was deployed with.&lt;/p&gt;
     * &lt;p&gt;When the stored configuration takes effect: a caller is ONE call (every &lt;code&gt;StartCaller&lt;/code&gt; creates
     * a new caller carrying its own configuration, and no RPC redeploys an existing one), so for a caller that
     * is not pooled the update changes ONLY the stored and returned configuration and never any present or
     * future call. The one case in which the server deploys a container from a caller&amp;apos;s stored
     * configuration is a POOLED (persistent) caller, which the server keeps warm between calls: when the server
     * recycles the pooled callers of a project onto its Asterisk (an &lt;code&gt;UpdateVtsiProject&lt;/code&gt; of a
     * deployed project, the recovery after the project&amp;apos;s Asterisk restarted, a change of the project&amp;apos;s
     * TLS trust anchor), the pooled caller it starts in place of this one is deployed from the stored, i.e.
     * updated, configuration. An in-place restart of a pooled caller&amp;apos;s container (the call monitor&amp;apos;s
     * health recovery) keeps the configuration the container was deployed with. Until it is recycled, an idle
     * pooled caller is matched to later &lt;code&gt;StartCaller&lt;/code&gt; requests by the configuration its container
     * RUNS, never by an updated stored configuration it does not run.&lt;/p&gt;
     * &lt;p&gt;Updating a caller never changes a campaign: the attempts of a campaign call take their configuration
     * from the campaign and the campaign call, never from a &lt;code&gt;Caller&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;A STOPPED caller (its call ended and its configuration was released) has no stored configuration left:
     * the update starts from an empty one, so it must state a complete configuration
     * (&lt;code&gt;sip_caller_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt;), and a partial one is refused as a
     * configuration a &lt;code&gt;StartCallerRequest&lt;/code&gt; would be refused for. Nothing is deployed.&lt;/p&gt;
     * &lt;p&gt;Credentials follow their endpoint: an update that MOVES an upstream (the &lt;code&gt;host&lt;/code&gt;,
     * &lt;code&gt;port&lt;/code&gt; or &lt;code&gt;grpc_cert&lt;/code&gt; of the NLU, S2T or T2S &lt;code&gt;*_base_config&lt;/code&gt;, or the
     * &lt;code&gt;host&lt;/code&gt; / ports of &lt;code&gt;csi_vtsi_config.message_broker_config.rabbit_mq_config&lt;/code&gt;) must
     * also write every credential path of that upstream that holds a stored value -- the NLU
     * &lt;code&gt;credentials&lt;/code&gt;, &lt;code&gt;auth_token&lt;/code&gt;, &lt;code&gt;http_basic_auth_token&lt;/code&gt; and
     * &lt;code&gt;contexts&lt;/code&gt;, the S2T &lt;code&gt;s2t_transcribe_request_config&lt;/code&gt;, the T2S
     * &lt;code&gt;t2s_request_config&lt;/code&gt;, the RabbitMQ &lt;code&gt;user&lt;/code&gt; and &lt;code&gt;password&lt;/code&gt; -- named itself
     * or by a shorter path, with the values to use. A stored credential is never sent to an endpoint the request
     * moved without restating it, also not for the live validation of the result.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;caller.name&lt;/code&gt;,
     * an empty &lt;code&gt;update_mask&lt;/code&gt;, an unknown, output-only or immutable &lt;code&gt;update_mask&lt;/code&gt; path, an
     * update that moves an upstream without restating its stored credentials (naming the paths to add), a
     * resulting configuration that a &lt;code&gt;StartCallerRequest&lt;/code&gt; carrying it would be refused for, or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path (each naming the path or field); &lt;code&gt;NOT_FOUND&lt;/code&gt; for an
     * unknown caller or project; &lt;code&gt;ABORTED&lt;/code&gt; when concurrent updates kept changing the caller, or while
     * an update, deploy or undeploy of its project is still running (an update waits for it, for a bounded time,
     * so that a recycle of the project cannot lose it), nothing being written (retry the request); with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; for a project the caller holds no role on.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_UPDATED&lt;/code&gt; (none with &lt;code&gt;validate_only&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: the role that may start and stop callers of the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;
     * or higher).&lt;/p&gt;
     * </pre>
     */
    default void updateCaller(ondewo.vtsi.CallsOuterClass.UpdateCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateCallerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCallerMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates several callers, each like &lt;code&gt;UpdateCaller&lt;/code&gt;. Not atomic: every entry is applied on its
     * own and reported in &lt;code&gt;UpdateCallersResponse.update_caller_responses&lt;/code&gt;, in request order; an entry
     * that fails changes nothing and does not stop the others. Errors of the request as a whole (see
     * &lt;code&gt;UpdateCallersRequest&lt;/code&gt;) are gRPC status codes, and then no entry is applied.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;UpdateCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void updateCallers(ondewo.vtsi.CallsOuterClass.UpdateCallersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateCallersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCallersMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a caller: stops it if it still runs (hanging up its call) and removes it, so it is no longer
     * listed or returned. Its call records (and their participants) are deleted with it and are no longer returned
     * by &lt;code&gt;GetCall&lt;/code&gt; / &lt;code&gt;ListCalls&lt;/code&gt;; stop it instead to keep them.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown caller, a caller of another project, or a
     * caller that was already deleted (so deleting is NOT idempotent: a repeat answers &lt;code&gt;NOT_FOUND&lt;/code&gt;);
     * with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_DELETED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void deleteCaller(ondewo.vtsi.CallsOuterClass.DeleteCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.DeleteCallerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCallerMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes several callers, each like &lt;code&gt;DeleteCaller&lt;/code&gt;. Not atomic: every caller is deleted on its own
     * and reported in its own entry, whose &lt;code&gt;error_message&lt;/code&gt; carries the gRPC status code name
     * &lt;code&gt;DeleteCaller&lt;/code&gt; would have answered (e.g. &lt;code&gt;NOT_FOUND: ...&lt;/code&gt;); an entry that fails does not
     * stop the others. The request as a whole is refused, nothing being deleted, for no entry or more than 1000
     * distinct names, and, when &lt;code&gt;vtsi_project_name&lt;/code&gt; is set, as described there.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;DeleteCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void deleteCallers(ondewo.vtsi.CallsOuterClass.DeleteCallersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.DeleteCallersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCallersMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a caller: hangs up its call if one is up and releases its container and SIP account. The caller
     * stays listed (with &lt;code&gt;active = false&lt;/code&gt;) until it is deleted, and its stored configuration stays
     * updatable (see &lt;code&gt;UpdateCaller&lt;/code&gt;). A pooled caller is taken out of the pool.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown caller, a caller of another project, or a
     * caller that is already stopped (so stopping is NOT idempotent: a repeat answers &lt;code&gt;NOT_FOUND&lt;/code&gt;); with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_STOPPED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void stopCaller(ondewo.vtsi.CallsOuterClass.StopCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopCallerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopCallerMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops several callers, each like &lt;code&gt;StopCaller&lt;/code&gt;, with the per-entry results and the request-level
     * errors of &lt;code&gt;DeleteCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StopCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void stopCallers(ondewo.vtsi.CallsOuterClass.StopCallersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopCallersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopCallersMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts one listener in a VTSI project: an ondewo-sip container registered on the project&amp;apos;s Asterisk
     * that answers inbound calls, one after the other (persistent). Validation, &lt;code&gt;validate_only&lt;/code&gt;, errors
     * (&lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; for the project&amp;apos;s listener limit) and idempotency as for
     * &lt;code&gt;StartCaller&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_STARTED&lt;/code&gt; or &lt;code&gt;VTSI_EVENT_LISTENER_START_FAILED&lt;/code&gt;. None with
     * &lt;code&gt;validate_only&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void startListener(ondewo.vtsi.CallsOuterClass.StartListenerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartListenerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartListenerMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts several listeners, each like &lt;code&gt;StartListener&lt;/code&gt;, with the batch semantics of
     * &lt;code&gt;StartCallers&lt;/code&gt; (a listener that fails to start has no entry and is accounted for in
     * &lt;code&gt;StartListenersResponse.error_message&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StartListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void startListeners(ondewo.vtsi.CallsOuterClass.StartListenersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartListenersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartListenersMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a listener: hangs up its call if one is up and releases its container and SIP account. A stopped
     * listener has no stored configuration left (see &lt;code&gt;UpdateListener&lt;/code&gt;). Errors and idempotency as for
     * &lt;code&gt;StopCaller&lt;/code&gt; (a listener that is already stopped is &lt;code&gt;NOT_FOUND&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_STOPPED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void stopListener(ondewo.vtsi.CallsOuterClass.StopListenerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopListenerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopListenerMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops several listeners, each like &lt;code&gt;StopListener&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;DeleteCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StopListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void stopListeners(ondewo.vtsi.CallsOuterClass.StopListenersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopListenersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopListenersMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the listeners of a VTSI project, ordered by the listener&amp;apos;s uuid (the last segment of
     * &lt;code&gt;name&lt;/code&gt;), ascending. Paging, &lt;code&gt;total_size&lt;/code&gt;, filters and errors as for
     * &lt;code&gt;ListCallers&lt;/code&gt; (without a campaign selector).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void listListeners(ondewo.vtsi.CallsOuterClass.ListListenersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ListListenersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListListenersMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a listener, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt;. Errors as for
     * &lt;code&gt;GetCaller&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void getListener(ondewo.vtsi.CallsOuterClass.GetListenerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.Listener> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetListenerMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the STORED configuration of a listener: the fields named in &lt;code&gt;update_mask&lt;/code&gt;, i.e.
     * &lt;code&gt;sip_base_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt; or any nested sub-path of them.
     * Allowed whether or not the listener&amp;apos;s container is running or has a call, as long as the listener is
     * DEPLOYED: a stopped listener has no stored configuration (it is deployed again only by a
     * &lt;code&gt;StartListener&lt;/code&gt; carrying a complete one) and is &lt;code&gt;NOT_FOUND&lt;/code&gt;, unlike a stopped caller,
     * which &lt;code&gt;UpdateCaller&lt;/code&gt; accepts with a complete configuration.&lt;/p&gt;
     * &lt;p&gt;A running container and every call it takes are NEVER changed: nothing is restarted, redeployed or
     * reconfigured, and the running container answers its calls with the configuration it was deployed with
     * until it is replaced.&lt;/p&gt;
     * &lt;p&gt;When the stored configuration takes effect: only when the server RECREATES the listener from it, i.e.
     * when it recycles the listeners of the project onto its Asterisk: an &lt;code&gt;UpdateVtsiProject&lt;/code&gt; of a
     * deployed project, the recovery after the project&amp;apos;s Asterisk restarted, or a change of the
     * project&amp;apos;s TLS trust anchor. The listener the server starts in place of this one is deployed from the
     * stored, i.e. updated, configuration. An in-place restart of the listener&amp;apos;s container (the
     * server&amp;apos;s restore of listener containers when it starts, the call monitor&amp;apos;s restart of an
     * unhealthy container, a &lt;code&gt;docker restart&lt;/code&gt;) keeps the configuration the container was deployed
     * with. A listener that is never recycled keeps the update only as its stored (and returned)
     * configuration.&lt;/p&gt;
     * &lt;p&gt;Errors as for &lt;code&gt;UpdateCaller&lt;/code&gt; (the credential rule included), with
     * &lt;code&gt;StartListenerRequest&lt;/code&gt; as the validation of the resulting configuration, and
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; also for a stopped listener.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_UPDATED&lt;/code&gt; (none with &lt;code&gt;validate_only&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: the role that may start and stop listeners of the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;
     * or higher).&lt;/p&gt;
     * </pre>
     */
    default void updateListener(ondewo.vtsi.CallsOuterClass.UpdateListenerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateListenerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateListenerMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates several listeners, each like &lt;code&gt;UpdateListener&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;UpdateCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;UpdateListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void updateListeners(ondewo.vtsi.CallsOuterClass.UpdateListenersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateListenersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateListenersMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a listener: stops it if it still runs (hanging up its call) and removes it, with its call
     * records, like &lt;code&gt;DeleteCaller&lt;/code&gt;. Errors and idempotency as for &lt;code&gt;DeleteCaller&lt;/code&gt; (a repeat
     * answers &lt;code&gt;NOT_FOUND&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_DELETED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void deleteListener(ondewo.vtsi.CallsOuterClass.DeleteListenerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.DeleteListenerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteListenerMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes several listeners, each like &lt;code&gt;DeleteListener&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;DeleteCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;DeleteListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void deleteListeners(ondewo.vtsi.CallsOuterClass.DeleteListenersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.DeleteListenersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteListenersMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a scheduled caller: a caller that the server starts at or after &lt;code&gt;scheduled_time&lt;/code&gt;, like a
     * &lt;code&gt;StartCaller&lt;/code&gt; of the stored request. The request is checked structurally now; the live checks of
     * the configuration run when it fires, and a failure then leaves the scheduled caller
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_FAILED&lt;/code&gt; with its &lt;code&gt;error_message&lt;/code&gt;. A &lt;code&gt;scheduled_time&lt;/code&gt; in
     * the past is due at once. Not idempotent (use &lt;code&gt;StartScheduledCallers&lt;/code&gt; with an
     * &lt;code&gt;idempotency_key&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, a missing
     * &lt;code&gt;scheduled_time&lt;/code&gt;, a nested request with its own &lt;code&gt;field_mask&lt;/code&gt; or
     * &lt;code&gt;validate_only&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown
     * project; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the project reached its caller limit; with authorization
     * enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CREATED&lt;/code&gt;; later &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_FIRED&lt;/code&gt;,
     * &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_RETRY_SCHEDULED&lt;/code&gt; or &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_FAILED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void startScheduledCaller(ondewo.vtsi.CallsOuterClass.StartScheduledCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartScheduledCallerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartScheduledCallerMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates several scheduled callers, each like &lt;code&gt;StartScheduledCaller&lt;/code&gt;, at most 1000. Not atomic: an
     * entry that fails is reported in its own &lt;code&gt;error_message&lt;/code&gt; and does not stop the others. Idempotent
     * per &lt;code&gt;idempotency_key&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StartScheduledCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void startScheduledCallers(ondewo.vtsi.CallsOuterClass.StartScheduledCallersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartScheduledCallersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartScheduledCallersMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Adds callers to a campaign instead of starting them. The campaign then starts them, at most
     * &lt;code&gt;max_parallel_calls&lt;/code&gt; at a time. The request is atomic: either the campaign (when new), every
     * campaign call is stored, or nothing is. Errors are gRPC status codes (see &lt;code&gt;CampaignAssignment&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Rolling updates: a VTSI server that predates this RPC answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; and starts
     * nothing. Do not fall back to &lt;code&gt;StartCallers&lt;/code&gt; on &lt;code&gt;UNIMPLEMENTED&lt;/code&gt;; retry later.&lt;/p&gt;
     * </pre>
     */
    default void addCallersToCampaign(ondewo.vtsi.CallsOuterClass.AddCallersToCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.AddCallersToCampaignResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddCallersToCampaignMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Adds scheduled callers to a campaign: each fires at or after its scheduled time AND when the campaign has a
     * free slot, and follows the campaign&amp;apos;s retries, stop and hard stop. Same atomicity, errors and rolling-update
     * behaviour as &lt;code&gt;AddCallersToCampaign&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void addScheduledCallersToCampaign(ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddScheduledCallersToCampaignMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a scheduled caller, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of another project; with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void getScheduledCaller(ondewo.vtsi.CallsOuterClass.GetScheduledCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ScheduledCaller> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetScheduledCallerMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the scheduled callers of a VTSI project, ordered by &lt;code&gt;scheduled_time&lt;/code&gt;, oldest first,
     * optionally narrowed by state, campaign and a &lt;code&gt;scheduled_time&lt;/code&gt; window. Paging,
     * &lt;code&gt;total_size&lt;/code&gt; and errors as for &lt;code&gt;ListCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void listScheduledCallers(ondewo.vtsi.CallsOuterClass.ListScheduledCallersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ListScheduledCallersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListScheduledCallersMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Changes the &lt;code&gt;scheduled_time&lt;/code&gt; and/or the &lt;code&gt;sip_caller_config.sip_headers&lt;/code&gt; of a scheduled
     * caller that has not fired yet; the only updatable &lt;code&gt;update_mask&lt;/code&gt; paths (see
     * &lt;code&gt;UpdateScheduledCallerRequest.update_mask&lt;/code&gt;). Allowed only while the status is
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_PENDING&lt;/code&gt;; for a scheduled caller of a campaign only while its campaign call
     * is &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; (a retry of a campaign call is timed by the campaign&amp;apos;s
     * &lt;code&gt;retry_delay&lt;/code&gt;). The check and the write are one atomic step, so a scheduled caller that fires
     * concurrently is either updated before it fires or refused. Updating to the stored values is accepted and
     * changes nothing.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, an empty
     * &lt;code&gt;update_mask&lt;/code&gt;, a path that is not updatable, an unset &lt;code&gt;scheduled_time&lt;/code&gt; named by the
     * mask, invalid &lt;code&gt;sip_headers&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path (each naming the path);
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of another project;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when it is no longer PENDING (&lt;code&gt;reason=not-pending&lt;/code&gt;) or its campaign
     * call has started (&lt;code&gt;reason=campaign-call-started&lt;/code&gt;); with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_UPDATED&lt;/code&gt; when something changed.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void updateScheduledCaller(ondewo.vtsi.CallsOuterClass.UpdateScheduledCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ScheduledCaller> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateScheduledCallerMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Cancels a scheduled caller that has not fired yet: a PENDING scheduled caller becomes
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_CANCELLED&lt;/code&gt; and never fires. A scheduled caller that is no longer PENDING
     * (firing, done, failed or already cancelled) is not an error: the response says &lt;code&gt;cancelled = false&lt;/code&gt;
     * and carries its current &lt;code&gt;status&lt;/code&gt;, so cancelling is idempotent.&lt;/p&gt;
     * &lt;p&gt;A scheduled caller of a campaign can be cancelled while its campaign call is
     * &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; or &lt;code&gt;CAMPAIGN_CALL_STATE_RETRY_PENDING&lt;/code&gt;;
     * the campaign call then becomes &lt;code&gt;CAMPAIGN_CALL_STATE_CANCELLED&lt;/code&gt;. While an attempt is
     * &lt;code&gt;DISPATCHING&lt;/code&gt; or &lt;code&gt;IN_PROGRESS&lt;/code&gt; the request is refused:
     * &lt;code&gt;cancelled = false&lt;/code&gt;, an &lt;code&gt;error_message&lt;/code&gt; saying why, and the scheduled caller keeps its
     * status.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of
     * another project; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CANCELLED&lt;/code&gt;, only when &lt;code&gt;cancelled = true&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void cancelScheduledCaller(ondewo.vtsi.CallsOuterClass.CancelScheduledCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.CancelScheduledCallerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelScheduledCallerMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Cancels several scheduled callers, each like &lt;code&gt;CancelScheduledCaller&lt;/code&gt;, at most 1000. Not atomic:
     * every entry is applied on its own and reported in &lt;code&gt;CancelScheduledCallersResponse&lt;/code&gt;, in request
     * order; a failed entry carries an &lt;code&gt;error_message&lt;/code&gt; prefixed with the gRPC status code name
     * &lt;code&gt;CancelScheduledCaller&lt;/code&gt; would have answered (e.g. &lt;code&gt;NOT_FOUND: ...&lt;/code&gt;) and does not stop
     * the others. Errors of the request as a whole (see &lt;code&gt;CancelScheduledCallersRequest&lt;/code&gt;) are gRPC status
     * codes, and then nothing is cancelled.&lt;/p&gt;
     * &lt;p&gt;Events: one &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CANCELLED&lt;/code&gt; per entry with &lt;code&gt;cancelled = true&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;CancelScheduledCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void cancelScheduledCallers(ondewo.vtsi.CallsOuterClass.CancelScheduledCallersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.CancelScheduledCallersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelScheduledCallersMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Retries a FAILED scheduled caller by creating a NEW scheduled caller from its stored request: the same
     * &lt;code&gt;sip_caller_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt;, &lt;code&gt;status = PENDING&lt;/code&gt;, the
     * &lt;code&gt;scheduled_time&lt;/code&gt; of the request (unset: now), and &lt;code&gt;retry_of_scheduled_caller_name&lt;/code&gt; naming
     * the failed one, whose &lt;code&gt;retried_by_scheduled_caller_name&lt;/code&gt; is set to the new one in the same atomic
     * step. The failed scheduled caller itself is not changed otherwise, so its &lt;code&gt;error_message&lt;/code&gt; and
     * &lt;code&gt;fired_at&lt;/code&gt; stay as the history of the failed attempt. Returns the new scheduled caller.&lt;/p&gt;
     * &lt;p&gt;Idempotency: a FAILED scheduled caller is retried at most once. A repeat of the request answers
     * &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; naming the retry in its message (read
     * &lt;code&gt;retried_by_scheduled_caller_name&lt;/code&gt;); to retry again after the retry failed too, retry the new
     * one.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of
     * another project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a scheduled caller that is not
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_FAILED&lt;/code&gt; (&lt;code&gt;reason=not-failed&lt;/code&gt;) or that belongs to a campaign
     * (&lt;code&gt;reason=campaign-scheduled-caller&lt;/code&gt;: a campaign call is retried by the campaign&amp;apos;s
     * &lt;code&gt;max_attempts&lt;/code&gt;); &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when it was already retried;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the project reached its caller limit; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CREATED&lt;/code&gt; for the new scheduled caller.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void retryScheduledCaller(ondewo.vtsi.CallsOuterClass.RetryScheduledCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ScheduledCaller> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRetryScheduledCallerMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a call: hangs it up if it is still active and stops (releases) the listener or caller that serves
     * it, like &lt;code&gt;StopCaller&lt;/code&gt; / &lt;code&gt;StopListener&lt;/code&gt;. A call that already ended is not an error: its
     * listener or caller is still released if it is deployed, and when there was nothing left to release the
     * response carries &lt;code&gt;error_message = Call ... was not released&lt;/code&gt;, so a repeat succeeds with that
     * message.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or call, or a call of another
     * project; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt;, and &lt;code&gt;VTSI_EVENT_CALLER_STOPPED&lt;/code&gt; /
     * &lt;code&gt;VTSI_EVENT_LISTENER_STOPPED&lt;/code&gt; for the released resource.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void stopCall(ondewo.vtsi.CallsOuterClass.StopCallRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopCallResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopCallMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops several calls of one project, each like &lt;code&gt;StopCall&lt;/code&gt;, at most 1000 distinct names. Not
     * atomic: every call is stopped on its own and reported in its own entry, in request order; a failed entry
     * carries an &lt;code&gt;error_message&lt;/code&gt; prefixed with the gRPC status code name &lt;code&gt;StopCall&lt;/code&gt; would have
     * answered and does not stop the others. No entry, more than 1000 names or a malformed
     * &lt;code&gt;vtsi_project_name&lt;/code&gt; is &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, an unknown project &lt;code&gt;NOT_FOUND&lt;/code&gt;, and
     * then nothing is stopped.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StopCall&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void stopCalls(ondewo.vtsi.CallsOuterClass.StopCallsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopCallsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopCallsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops every call of a VTSI project (listener and caller calls alike), or, with
     * &lt;code&gt;call_filter&lt;/code&gt;, those it matches, each like &lt;code&gt;StopCall&lt;/code&gt;. Not atomic and not bounded in
     * size; a project with nothing to stop answers an empty response, so the RPC is idempotent. If a stop fails
     * part-way, the remaining calls are still stopped one by one and every call gets its own entry.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, an invalid &lt;code&gt;call_filter&lt;/code&gt; or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or campaign; with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void stopAllCalls(ondewo.vtsi.CallsOuterClass.StopAllCallsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopCallsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopAllCallsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Transfer a call to a phone number, a softphone account, another listener or the listener queue.&lt;/p&gt;
     * &lt;p&gt;The target is either the typed &lt;code&gt;target&lt;/code&gt; or the legacy raw &lt;code&gt;transfer_id&lt;/code&gt;, never both. It is
     * resolved and validated before anything is sent; an invalid target is answered with
     * &lt;code&gt;TRANSFER_OUTCOME_TARGET_INVALID&lt;/code&gt; and an &lt;code&gt;error_reason&lt;/code&gt;, and the call is untouched.&lt;/p&gt;
     * &lt;p&gt;&lt;code&gt;TRANSFER_MODE_BLIND&lt;/code&gt; (default) sends a SIP REFER and reports its outcome: a refused REFER keeps the
     * call with the bot. &lt;code&gt;TRANSFER_MODE_WARM&lt;/code&gt; rings the target into the call first, and the bot leaves only
     * after the target joined (Asterisk 22 only).&lt;/p&gt;
     * &lt;p&gt;Telephony outcomes (busy, no answer, REFER rejected) are successful RPCs carrying an &lt;code&gt;outcome&lt;/code&gt;.
     * Refusals before any side effect also return a gRPC status with &lt;code&gt;reason=&amp;lt;token&amp;gt;&lt;/code&gt; in its details:
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; (both targets set, malformed target), &lt;code&gt;NOT_FOUND&lt;/code&gt; (call or target not
     * found, including another project&amp;apos;s), &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; (&lt;code&gt;call-not-connected&lt;/code&gt;,
     * &lt;code&gt;amd-in-progress&lt;/code&gt;, &lt;code&gt;call-not-yet-identified&lt;/code&gt;, &lt;code&gt;participants-present&lt;/code&gt;,
     * &lt;code&gt;asterisk-version-unsupported&lt;/code&gt;, &lt;code&gt;sip-image-too-old&lt;/code&gt;), &lt;code&gt;ABORTED&lt;/code&gt;
     * (&lt;code&gt;transfer-in-progress&lt;/code&gt;), &lt;code&gt;UNAVAILABLE&lt;/code&gt; (&lt;code&gt;sip-unreachable&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    default void transferCall(ondewo.vtsi.CallsOuterClass.TransferCallRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.TransferCallResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTransferCallMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Transfer several calls, each like &lt;code&gt;TransferCall&lt;/code&gt;, at most 1000. Not atomic: every transfer is
     * run on its own and reported in its own entry, in request order; an entry &lt;code&gt;TransferCall&lt;/code&gt; would have
     * refused with a gRPC status carries that refusal in its &lt;code&gt;error_message&lt;/code&gt; (prefixed with the status
     * code name) and does not stop the others. Idempotent per entry &lt;code&gt;request_id&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    default void transferCalls(ondewo.vtsi.CallsOuterClass.TransferCallsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.TransferCallsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTransferCallsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a call, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt; (the call&amp;apos;s log
     * lines are read with &lt;code&gt;Logs.ListCallLogs&lt;/code&gt;). &lt;code&gt;FULL&lt;/code&gt; also returns every participant ever
     * invited into the call (see &lt;code&gt;Call.participants&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or call, or a call of another project; with authorization
     * enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void getCall(ondewo.vtsi.CallsOuterClass.GetCallRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.Call> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCallMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the calls of a VTSI project, ended ones included, narrowed by &lt;code&gt;call_filter&lt;/code&gt;, ordered by
     * &lt;code&gt;call_sorting&lt;/code&gt; (default: by &lt;code&gt;start_time&lt;/code&gt;, oldest first) and paged with
     * &lt;code&gt;page_size&lt;/code&gt; / &lt;code&gt;page_token&lt;/code&gt;; &lt;code&gt;total_size&lt;/code&gt; counts every match.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;call_filter.campaign_name&lt;/code&gt; or &lt;code&gt;call_filter.campaign_display_name&lt;/code&gt; set, lists
     * only the calls of that campaign: the calls placed by the attempts of its campaign calls.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, an invalid filter, a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a &lt;code&gt;page_token&lt;/code&gt; of another listing or an unknown &lt;code&gt;field_mask&lt;/code&gt;
     * path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or campaign; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void listCalls(ondewo.vtsi.CallsOuterClass.ListCallsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ListCallsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCallsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Aggregate figures (totals, active calls, counts by SIP status type, by call type, by AMD verdict and by
     * transfer outcome, durations, redial recommendations) over the calls of a VTSI project that
     * &lt;code&gt;call_filter&lt;/code&gt; matches; see &lt;code&gt;CallStatistics&lt;/code&gt;. Read only, no side effect.&lt;/p&gt;
     * &lt;p&gt;Errors: as for &lt;code&gt;ListCalls&lt;/code&gt; (an invalid filter is &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, an unknown project
     * or campaign &lt;code&gt;NOT_FOUND&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;ListCalls&lt;/code&gt; (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project).&lt;/p&gt;
     * </pre>
     */
    default void getCallStatistics(ondewo.vtsi.CallsOuterClass.GetCallStatisticsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.CallStatistics> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCallStatisticsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the descriptive metadata of a call: the only updatable &lt;code&gt;update_mask&lt;/code&gt; path is
     * &lt;code&gt;labels&lt;/code&gt;. Allowed on active and ended calls. Refused for the WAITING call of a persistent
     * listener or a pooled caller (status &lt;code&gt;NO_ONGOING_CALL&lt;/code&gt;, not active: the record that waits for the
     * next call, which &lt;code&gt;ListCalls&lt;/code&gt; returns too) with &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; and
     * &lt;code&gt;reason=call-not-started&lt;/code&gt; in the details: label the call once it has started. It changes only
     * the stored call record: the live call, its SIP container, its status and its media are never touched, and
     * nothing is sent to the call. Idempotent: writing the stored labels again changes nothing.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_UPDATED&lt;/code&gt; when the labels changed.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;call.name&lt;/code&gt;, an
     * empty &lt;code&gt;update_mask&lt;/code&gt;, any path other than &lt;code&gt;labels&lt;/code&gt; (every other field of a
     * &lt;code&gt;Call&lt;/code&gt; is output only), a path below &lt;code&gt;labels&lt;/code&gt;, labels outside the bounds of
     * &lt;code&gt;Call.labels&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path (each naming the path or label);
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown call or project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;
     * (&lt;code&gt;reason=call-not-started&lt;/code&gt;) for a waiting call; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; for a project the caller holds no role on.&lt;/p&gt;
     * &lt;p&gt;Authorization: the role that may stop calls of the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or
     * higher).&lt;/p&gt;
     * </pre>
     */
    default void updateCall(ondewo.vtsi.CallsOuterClass.UpdateCallRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateCallResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCallMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates several calls, each like &lt;code&gt;UpdateCall&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;UpdateCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;UpdateCall&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void updateCalls(ondewo.vtsi.CallsOuterClass.UpdateCallsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateCallsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCallsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the status of the callers of a project: a snapshot first
     * (&lt;code&gt;snapshot = true&lt;/code&gt;), then every caller whose call or SIP status changed, plus
     * keep-alive messages. Ends when the client disconnects or at the server-side maximum stream
     * duration.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when
     * the server has no free stream slot.&lt;/p&gt;
     * </pre>
     */
    default void streamCallerStatus(ondewo.vtsi.CallsOuterClass.StreamCallerStatusRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamCallerStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the status of the listeners of a project, like &lt;code&gt;StreamCallerStatus&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void streamListenerStatus(ondewo.vtsi.CallsOuterClass.StreamListenerStatusRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamListenerStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the status of the scheduled callers of a project, like
     * &lt;code&gt;StreamCallerStatus&lt;/code&gt;. The snapshot holds every PENDING and FIRING scheduled caller
     * and those that finished in the last hour.&lt;/p&gt;
     * </pre>
     */
    default void streamScheduledCallerStatus(ondewo.vtsi.CallsOuterClass.StreamScheduledCallerStatusRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamScheduledCallerStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Invite a registered softphone account of the project into a connected call. Returns the participant in
     * &lt;code&gt;PARTICIPANT_STATE_RINGING&lt;/code&gt;; follow &lt;code&gt;Call.participants&lt;/code&gt; or the events
     * &lt;code&gt;VTSI_EVENT_CALL_PARTICIPANT_*&lt;/code&gt; for JOINED, FAILED and LEFT.&lt;/p&gt;
     * &lt;p&gt;&lt;code&gt;PARTICIPANT_MODE_CONFERENCE&lt;/code&gt; (default) joins the softphone into the call: Asterisk mixes the caller,
     * the bot and the participant, and by default the bot keeps talking and listening
     * (&lt;code&gt;BOT_POLICY_ON_JOIN_KEEP&lt;/code&gt;). &lt;code&gt;PARTICIPANT_MODE_MONITOR&lt;/code&gt; lets the participant listen only.
     * When the bot&amp;apos;s leg ends, every participant is hung up; the caller is handed over only by a WARM
     * &lt;code&gt;TransferCall&lt;/code&gt;. Idempotent per &lt;code&gt;request_id&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, &lt;code&gt;NOT_FOUND&lt;/code&gt; (call or softphone account, including another
     * project&amp;apos;s), &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; (&lt;code&gt;call-not-connected&lt;/code&gt;, &lt;code&gt;amd-in-progress&lt;/code&gt;,
     * &lt;code&gt;softphone-not-registered&lt;/code&gt;, &lt;code&gt;softphone-disabled&lt;/code&gt;, &lt;code&gt;softphone-unrouted&lt;/code&gt;,
     * &lt;code&gt;call-not-yet-identified&lt;/code&gt;, &lt;code&gt;bot-channel-ambiguous&lt;/code&gt;, &lt;code&gt;asterisk-not-local&lt;/code&gt;,
     * &lt;code&gt;asterisk-version-unsupported&lt;/code&gt;), &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; (the softphone is already ringing or joined),
     * &lt;code&gt;ABORTED&lt;/code&gt; (&lt;code&gt;transfer-in-progress&lt;/code&gt;), &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; (participant cap),
     * &lt;code&gt;UNAVAILABLE&lt;/code&gt; (&lt;code&gt;asterisk-unreachable&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    default void inviteToCall(ondewo.vtsi.CallsOuterClass.InviteToCallRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.InviteToCallResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInviteToCallMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Hang up a participant of a call (ringing or joined). The participant ends as
     * &lt;code&gt;PARTICIPANT_STATE_LEFT&lt;/code&gt; with &lt;code&gt;end_reason = REMOVED&lt;/code&gt;; the call and the bot are not
     * affected. Returns the participant after the request.&lt;/p&gt;
     * &lt;p&gt;Idempotent: a participant that already FAILED or LEFT (for whatever reason) is returned unchanged with OK,
     * and nothing is sent.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request; &lt;code&gt;NOT_FOUND&lt;/code&gt; with
     * &lt;code&gt;reason=call-not-found&lt;/code&gt; for an unknown call or a call of another project, and with
     * &lt;code&gt;reason=participant-not-found&lt;/code&gt; for an unknown &lt;code&gt;participant_id&lt;/code&gt; or a participant of
     * another call; &lt;code&gt;ABORTED&lt;/code&gt; with &lt;code&gt;reason=call-control-busy&lt;/code&gt; while another call-control
     * request for the call runs (retry); &lt;code&gt;UNAVAILABLE&lt;/code&gt; with &lt;code&gt;reason=asterisk-unreachable&lt;/code&gt; when
     * the hang-up could not be sent; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_PARTICIPANT_LEFT&lt;/code&gt; (or &lt;code&gt;VTSI_EVENT_CALL_PARTICIPANT_FAILED&lt;/code&gt;
     * for a participant that was still ringing).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher. Audited like &lt;code&gt;InviteToCall&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void removeCallParticipant(ondewo.vtsi.CallsOuterClass.RemoveCallParticipantRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.RemoveCallParticipantResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveCallParticipantMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Mute the bot of a connected call and/or stop it listening to the caller, or undo either. Every request sets a
     * desired level and never toggles: a repeat answers &lt;code&gt;changed = false&lt;/code&gt;. The bot stays muted while
     * anything else (a TALK take-over of &lt;code&gt;StreamCallAudio&lt;/code&gt;, a participant bot policy) also holds it muted.&lt;/p&gt;
     * &lt;p&gt;Both settings &lt;code&gt;CALL_MEDIA_SETTING_UNCHANGED&lt;/code&gt; is a valid read of the current state: it answers
     * the effective &lt;code&gt;state&lt;/code&gt; with &lt;code&gt;changed = false&lt;/code&gt;, changes nothing, and writes no audit record
     * and no event (see &lt;code&gt;SetCallMediaControlRequest.bot_voice&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_BOT_MUTED&lt;/code&gt; / &lt;code&gt;VTSI_EVENT_CALL_BOT_UNMUTED&lt;/code&gt; /
     * &lt;code&gt;VTSI_EVENT_CALL_LISTENING_PAUSED&lt;/code&gt; / &lt;code&gt;VTSI_EVENT_CALL_LISTENING_RESUMED&lt;/code&gt; when the
     * effective state changed.&lt;/p&gt;
     * &lt;p&gt;Errors as for &lt;code&gt;InviteToCall&lt;/code&gt;, plus &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=sip-image-too-old&lt;/code&gt;,
     * &lt;code&gt;ABORTED&lt;/code&gt; &lt;code&gt;reason=call-control-busy&lt;/code&gt; (another call-control request for the call is running)
     * and &lt;code&gt;UNAVAILABLE&lt;/code&gt; &lt;code&gt;reason=sip-unreachable&lt;/code&gt; or &lt;code&gt;reason=csi-media-control-failed&lt;/code&gt; (the
     * bot did not apply the level: a requested pause is rolled back, a requested mute is kept).&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    default void setCallMediaControl(ondewo.vtsi.CallsOuterClass.SetCallMediaControlRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.SetCallMediaControlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetCallMediaControlMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Live audio of a connected call, both ways. The first request MUST be &lt;code&gt;config&lt;/code&gt; (within 2 seconds).
     * LISTEN receives the caller mixed with the bot. TALK sends the agent&amp;apos;s audio to the caller and REQUIRES
     * &lt;code&gt;take_over&lt;/code&gt;: the bot is muted and does not listen while the stream is connected, and resumes when it
     * ends; in TALK the agent hears the caller only. Audio is LINEAR16 little-endian mono in 20 ms frames.&lt;/p&gt;
     * &lt;p&gt;Bidirectional streaming: available to native gRPC clients (python, nodejs) only. Browser (grpc-web) clients
     * use &lt;code&gt;ListenCallAudio&lt;/code&gt;, plus a softphone (&lt;code&gt;InviteToCall&lt;/code&gt;) to talk.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; (no or invalid &lt;code&gt;config&lt;/code&gt;, TALK without
     * &lt;code&gt;take_over&lt;/code&gt;, wrong frame size), &lt;code&gt;NOT_FOUND&lt;/code&gt;, &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;
     * (&lt;code&gt;call-not-connected&lt;/code&gt;, &lt;code&gt;amd-in-progress&lt;/code&gt;, &lt;code&gt;call-not-yet-identified&lt;/code&gt;,
     * &lt;code&gt;bot-still-speaking&lt;/code&gt;, &lt;code&gt;sip-image-too-old&lt;/code&gt;), &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; (stream cap, a
     * second TALK). A normal end sends one &lt;code&gt;ended&lt;/code&gt; message, then OK. A second &lt;code&gt;config&lt;/code&gt; or audio
     * sent in LISTEN mode ends the stream with &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;. A client half-close ends the stream
     * (&lt;code&gt;CALL_AUDIO_END_REASON_CLIENT_CLOSED&lt;/code&gt;), so a listening client keeps its request stream open.&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    default io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StreamCallAudioRequest> streamCallAudio(
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamCallAudioMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Listen-only live audio of a connected call, like &lt;code&gt;StreamCallAudio&lt;/code&gt; in LISTEN mode, as a server
     * stream that grpc-web (browser) clients can consume. &lt;code&gt;config.mode&lt;/code&gt; must be LISTEN or unspecified and
     * &lt;code&gt;config.take_over&lt;/code&gt; must be false, otherwise &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; &lt;code&gt;reason=listen-only&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    default void listenCallAudio(ondewo.vtsi.CallsOuterClass.ListenCallAudioRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListenCallAudioMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Calls.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public static abstract class CallsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CallsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Calls.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public static final class CallsStub
      extends io.grpc.stub.AbstractAsyncStub<CallsStub> {
    private CallsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CallsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CallsStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts one caller in a VTSI project: an ondewo-sip container that places one outbound call to
     * &lt;code&gt;sip_caller_config.callee_id&lt;/code&gt; (or a pooled caller of the server&amp;apos;s caller pool that runs the same
     * configuration). The configuration is validated first, including live checks against the upstream services;
     * nothing is started when it fails. Not idempotent: every successful request places a new call (send it as a
     * batch of one with an &lt;code&gt;idempotency_key&lt;/code&gt; to make it idempotent). &lt;code&gt;validate_only&lt;/code&gt; runs the
     * validation alone.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed or invalid request or
     * configuration (also when the NLU credentials are refused) or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when an upstream config lacks
     * the required TLS certificate (&lt;code&gt;UPSTREAM_TLS_REQUIRED&lt;/code&gt;) or the project is not deployed;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the project reached its caller limit; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when an
     * upstream service could not be reached; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_STARTED&lt;/code&gt; or &lt;code&gt;VTSI_EVENT_CALLER_START_FAILED&lt;/code&gt;, then the
     * events of the call (&lt;code&gt;VTSI_EVENT_CALL_*&lt;/code&gt;). None with &lt;code&gt;validate_only&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void startCaller(ondewo.vtsi.CallsOuterClass.StartCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartCallerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartCallerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts several callers, each like &lt;code&gt;StartCaller&lt;/code&gt;. Not atomic: every caller is started on its own;
     * a caller that fails to start is rolled back and has no entry in the response, which accounts for it in
     * &lt;code&gt;StartCallersResponse.error_message&lt;/code&gt;. The project&amp;apos;s caller limit is checked for the batch as a
     * whole before anything is started (&lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;, nothing started). Idempotent per
     * &lt;code&gt;idempotency_key&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StartCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void startCallers(ondewo.vtsi.CallsOuterClass.StartCallersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartCallersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartCallersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the callers of a VTSI project, ordered by the caller&amp;apos;s uuid (the last segment of
     * &lt;code&gt;name&lt;/code&gt;), ascending: a stable order, not a chronological one. Paged with &lt;code&gt;page_size&lt;/code&gt; /
     * &lt;code&gt;page_token&lt;/code&gt;; &lt;code&gt;total_size&lt;/code&gt; counts every match.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;campaign_name&lt;/code&gt; or &lt;code&gt;campaign_display_name&lt;/code&gt; set, lists only the callers of that
     * campaign: the callers that placed at least one attempt of one of its campaign calls (see
     * &lt;code&gt;ListCallersRequest.campaign_name&lt;/code&gt;). &lt;code&gt;active_only&lt;/code&gt; and &lt;code&gt;sip_status_types&lt;/code&gt;
     * narrow the listing further.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, an invalid selector, a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a &lt;code&gt;page_token&lt;/code&gt; of another listing or an unknown &lt;code&gt;field_mask&lt;/code&gt;
     * path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or campaign; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void listCallers(ondewo.vtsi.CallsOuterClass.ListCallersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ListCallersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCallersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a caller, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or caller, or a caller of another project; with authorization
     * enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void getCaller(ondewo.vtsi.CallsOuterClass.GetCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.Caller> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCallerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the STORED configuration of a caller: the fields named in &lt;code&gt;update_mask&lt;/code&gt;, i.e.
     * &lt;code&gt;sip_caller_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt; or any nested sub-path of them.
     * Allowed whether or not the caller has a call running.&lt;/p&gt;
     * &lt;p&gt;A running call and its container are NEVER changed: nothing is restarted, redeployed or reconfigured,
     * and the call goes on with the configuration its container was deployed with.&lt;/p&gt;
     * &lt;p&gt;When the stored configuration takes effect: a caller is ONE call (every &lt;code&gt;StartCaller&lt;/code&gt; creates
     * a new caller carrying its own configuration, and no RPC redeploys an existing one), so for a caller that
     * is not pooled the update changes ONLY the stored and returned configuration and never any present or
     * future call. The one case in which the server deploys a container from a caller&amp;apos;s stored
     * configuration is a POOLED (persistent) caller, which the server keeps warm between calls: when the server
     * recycles the pooled callers of a project onto its Asterisk (an &lt;code&gt;UpdateVtsiProject&lt;/code&gt; of a
     * deployed project, the recovery after the project&amp;apos;s Asterisk restarted, a change of the project&amp;apos;s
     * TLS trust anchor), the pooled caller it starts in place of this one is deployed from the stored, i.e.
     * updated, configuration. An in-place restart of a pooled caller&amp;apos;s container (the call monitor&amp;apos;s
     * health recovery) keeps the configuration the container was deployed with. Until it is recycled, an idle
     * pooled caller is matched to later &lt;code&gt;StartCaller&lt;/code&gt; requests by the configuration its container
     * RUNS, never by an updated stored configuration it does not run.&lt;/p&gt;
     * &lt;p&gt;Updating a caller never changes a campaign: the attempts of a campaign call take their configuration
     * from the campaign and the campaign call, never from a &lt;code&gt;Caller&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;A STOPPED caller (its call ended and its configuration was released) has no stored configuration left:
     * the update starts from an empty one, so it must state a complete configuration
     * (&lt;code&gt;sip_caller_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt;), and a partial one is refused as a
     * configuration a &lt;code&gt;StartCallerRequest&lt;/code&gt; would be refused for. Nothing is deployed.&lt;/p&gt;
     * &lt;p&gt;Credentials follow their endpoint: an update that MOVES an upstream (the &lt;code&gt;host&lt;/code&gt;,
     * &lt;code&gt;port&lt;/code&gt; or &lt;code&gt;grpc_cert&lt;/code&gt; of the NLU, S2T or T2S &lt;code&gt;*_base_config&lt;/code&gt;, or the
     * &lt;code&gt;host&lt;/code&gt; / ports of &lt;code&gt;csi_vtsi_config.message_broker_config.rabbit_mq_config&lt;/code&gt;) must
     * also write every credential path of that upstream that holds a stored value -- the NLU
     * &lt;code&gt;credentials&lt;/code&gt;, &lt;code&gt;auth_token&lt;/code&gt;, &lt;code&gt;http_basic_auth_token&lt;/code&gt; and
     * &lt;code&gt;contexts&lt;/code&gt;, the S2T &lt;code&gt;s2t_transcribe_request_config&lt;/code&gt;, the T2S
     * &lt;code&gt;t2s_request_config&lt;/code&gt;, the RabbitMQ &lt;code&gt;user&lt;/code&gt; and &lt;code&gt;password&lt;/code&gt; -- named itself
     * or by a shorter path, with the values to use. A stored credential is never sent to an endpoint the request
     * moved without restating it, also not for the live validation of the result.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;caller.name&lt;/code&gt;,
     * an empty &lt;code&gt;update_mask&lt;/code&gt;, an unknown, output-only or immutable &lt;code&gt;update_mask&lt;/code&gt; path, an
     * update that moves an upstream without restating its stored credentials (naming the paths to add), a
     * resulting configuration that a &lt;code&gt;StartCallerRequest&lt;/code&gt; carrying it would be refused for, or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path (each naming the path or field); &lt;code&gt;NOT_FOUND&lt;/code&gt; for an
     * unknown caller or project; &lt;code&gt;ABORTED&lt;/code&gt; when concurrent updates kept changing the caller, or while
     * an update, deploy or undeploy of its project is still running (an update waits for it, for a bounded time,
     * so that a recycle of the project cannot lose it), nothing being written (retry the request); with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; for a project the caller holds no role on.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_UPDATED&lt;/code&gt; (none with &lt;code&gt;validate_only&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: the role that may start and stop callers of the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;
     * or higher).&lt;/p&gt;
     * </pre>
     */
    public void updateCaller(ondewo.vtsi.CallsOuterClass.UpdateCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateCallerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCallerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates several callers, each like &lt;code&gt;UpdateCaller&lt;/code&gt;. Not atomic: every entry is applied on its
     * own and reported in &lt;code&gt;UpdateCallersResponse.update_caller_responses&lt;/code&gt;, in request order; an entry
     * that fails changes nothing and does not stop the others. Errors of the request as a whole (see
     * &lt;code&gt;UpdateCallersRequest&lt;/code&gt;) are gRPC status codes, and then no entry is applied.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;UpdateCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void updateCallers(ondewo.vtsi.CallsOuterClass.UpdateCallersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateCallersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCallersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a caller: stops it if it still runs (hanging up its call) and removes it, so it is no longer
     * listed or returned. Its call records (and their participants) are deleted with it and are no longer returned
     * by &lt;code&gt;GetCall&lt;/code&gt; / &lt;code&gt;ListCalls&lt;/code&gt;; stop it instead to keep them.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown caller, a caller of another project, or a
     * caller that was already deleted (so deleting is NOT idempotent: a repeat answers &lt;code&gt;NOT_FOUND&lt;/code&gt;);
     * with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_DELETED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void deleteCaller(ondewo.vtsi.CallsOuterClass.DeleteCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.DeleteCallerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCallerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes several callers, each like &lt;code&gt;DeleteCaller&lt;/code&gt;. Not atomic: every caller is deleted on its own
     * and reported in its own entry, whose &lt;code&gt;error_message&lt;/code&gt; carries the gRPC status code name
     * &lt;code&gt;DeleteCaller&lt;/code&gt; would have answered (e.g. &lt;code&gt;NOT_FOUND: ...&lt;/code&gt;); an entry that fails does not
     * stop the others. The request as a whole is refused, nothing being deleted, for no entry or more than 1000
     * distinct names, and, when &lt;code&gt;vtsi_project_name&lt;/code&gt; is set, as described there.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;DeleteCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void deleteCallers(ondewo.vtsi.CallsOuterClass.DeleteCallersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.DeleteCallersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCallersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a caller: hangs up its call if one is up and releases its container and SIP account. The caller
     * stays listed (with &lt;code&gt;active = false&lt;/code&gt;) until it is deleted, and its stored configuration stays
     * updatable (see &lt;code&gt;UpdateCaller&lt;/code&gt;). A pooled caller is taken out of the pool.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown caller, a caller of another project, or a
     * caller that is already stopped (so stopping is NOT idempotent: a repeat answers &lt;code&gt;NOT_FOUND&lt;/code&gt;); with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_STOPPED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void stopCaller(ondewo.vtsi.CallsOuterClass.StopCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopCallerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopCallerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops several callers, each like &lt;code&gt;StopCaller&lt;/code&gt;, with the per-entry results and the request-level
     * errors of &lt;code&gt;DeleteCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StopCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void stopCallers(ondewo.vtsi.CallsOuterClass.StopCallersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopCallersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopCallersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts one listener in a VTSI project: an ondewo-sip container registered on the project&amp;apos;s Asterisk
     * that answers inbound calls, one after the other (persistent). Validation, &lt;code&gt;validate_only&lt;/code&gt;, errors
     * (&lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; for the project&amp;apos;s listener limit) and idempotency as for
     * &lt;code&gt;StartCaller&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_STARTED&lt;/code&gt; or &lt;code&gt;VTSI_EVENT_LISTENER_START_FAILED&lt;/code&gt;. None with
     * &lt;code&gt;validate_only&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void startListener(ondewo.vtsi.CallsOuterClass.StartListenerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartListenerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartListenerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts several listeners, each like &lt;code&gt;StartListener&lt;/code&gt;, with the batch semantics of
     * &lt;code&gt;StartCallers&lt;/code&gt; (a listener that fails to start has no entry and is accounted for in
     * &lt;code&gt;StartListenersResponse.error_message&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StartListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void startListeners(ondewo.vtsi.CallsOuterClass.StartListenersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartListenersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartListenersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a listener: hangs up its call if one is up and releases its container and SIP account. A stopped
     * listener has no stored configuration left (see &lt;code&gt;UpdateListener&lt;/code&gt;). Errors and idempotency as for
     * &lt;code&gt;StopCaller&lt;/code&gt; (a listener that is already stopped is &lt;code&gt;NOT_FOUND&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_STOPPED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void stopListener(ondewo.vtsi.CallsOuterClass.StopListenerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopListenerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopListenerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops several listeners, each like &lt;code&gt;StopListener&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;DeleteCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StopListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void stopListeners(ondewo.vtsi.CallsOuterClass.StopListenersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopListenersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopListenersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the listeners of a VTSI project, ordered by the listener&amp;apos;s uuid (the last segment of
     * &lt;code&gt;name&lt;/code&gt;), ascending. Paging, &lt;code&gt;total_size&lt;/code&gt;, filters and errors as for
     * &lt;code&gt;ListCallers&lt;/code&gt; (without a campaign selector).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void listListeners(ondewo.vtsi.CallsOuterClass.ListListenersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ListListenersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListListenersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a listener, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt;. Errors as for
     * &lt;code&gt;GetCaller&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void getListener(ondewo.vtsi.CallsOuterClass.GetListenerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.Listener> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetListenerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the STORED configuration of a listener: the fields named in &lt;code&gt;update_mask&lt;/code&gt;, i.e.
     * &lt;code&gt;sip_base_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt; or any nested sub-path of them.
     * Allowed whether or not the listener&amp;apos;s container is running or has a call, as long as the listener is
     * DEPLOYED: a stopped listener has no stored configuration (it is deployed again only by a
     * &lt;code&gt;StartListener&lt;/code&gt; carrying a complete one) and is &lt;code&gt;NOT_FOUND&lt;/code&gt;, unlike a stopped caller,
     * which &lt;code&gt;UpdateCaller&lt;/code&gt; accepts with a complete configuration.&lt;/p&gt;
     * &lt;p&gt;A running container and every call it takes are NEVER changed: nothing is restarted, redeployed or
     * reconfigured, and the running container answers its calls with the configuration it was deployed with
     * until it is replaced.&lt;/p&gt;
     * &lt;p&gt;When the stored configuration takes effect: only when the server RECREATES the listener from it, i.e.
     * when it recycles the listeners of the project onto its Asterisk: an &lt;code&gt;UpdateVtsiProject&lt;/code&gt; of a
     * deployed project, the recovery after the project&amp;apos;s Asterisk restarted, or a change of the
     * project&amp;apos;s TLS trust anchor. The listener the server starts in place of this one is deployed from the
     * stored, i.e. updated, configuration. An in-place restart of the listener&amp;apos;s container (the
     * server&amp;apos;s restore of listener containers when it starts, the call monitor&amp;apos;s restart of an
     * unhealthy container, a &lt;code&gt;docker restart&lt;/code&gt;) keeps the configuration the container was deployed
     * with. A listener that is never recycled keeps the update only as its stored (and returned)
     * configuration.&lt;/p&gt;
     * &lt;p&gt;Errors as for &lt;code&gt;UpdateCaller&lt;/code&gt; (the credential rule included), with
     * &lt;code&gt;StartListenerRequest&lt;/code&gt; as the validation of the resulting configuration, and
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; also for a stopped listener.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_UPDATED&lt;/code&gt; (none with &lt;code&gt;validate_only&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: the role that may start and stop listeners of the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;
     * or higher).&lt;/p&gt;
     * </pre>
     */
    public void updateListener(ondewo.vtsi.CallsOuterClass.UpdateListenerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateListenerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateListenerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates several listeners, each like &lt;code&gt;UpdateListener&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;UpdateCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;UpdateListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void updateListeners(ondewo.vtsi.CallsOuterClass.UpdateListenersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateListenersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateListenersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a listener: stops it if it still runs (hanging up its call) and removes it, with its call
     * records, like &lt;code&gt;DeleteCaller&lt;/code&gt;. Errors and idempotency as for &lt;code&gt;DeleteCaller&lt;/code&gt; (a repeat
     * answers &lt;code&gt;NOT_FOUND&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_DELETED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void deleteListener(ondewo.vtsi.CallsOuterClass.DeleteListenerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.DeleteListenerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteListenerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes several listeners, each like &lt;code&gt;DeleteListener&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;DeleteCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;DeleteListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void deleteListeners(ondewo.vtsi.CallsOuterClass.DeleteListenersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.DeleteListenersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteListenersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a scheduled caller: a caller that the server starts at or after &lt;code&gt;scheduled_time&lt;/code&gt;, like a
     * &lt;code&gt;StartCaller&lt;/code&gt; of the stored request. The request is checked structurally now; the live checks of
     * the configuration run when it fires, and a failure then leaves the scheduled caller
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_FAILED&lt;/code&gt; with its &lt;code&gt;error_message&lt;/code&gt;. A &lt;code&gt;scheduled_time&lt;/code&gt; in
     * the past is due at once. Not idempotent (use &lt;code&gt;StartScheduledCallers&lt;/code&gt; with an
     * &lt;code&gt;idempotency_key&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, a missing
     * &lt;code&gt;scheduled_time&lt;/code&gt;, a nested request with its own &lt;code&gt;field_mask&lt;/code&gt; or
     * &lt;code&gt;validate_only&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown
     * project; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the project reached its caller limit; with authorization
     * enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CREATED&lt;/code&gt;; later &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_FIRED&lt;/code&gt;,
     * &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_RETRY_SCHEDULED&lt;/code&gt; or &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_FAILED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void startScheduledCaller(ondewo.vtsi.CallsOuterClass.StartScheduledCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartScheduledCallerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartScheduledCallerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates several scheduled callers, each like &lt;code&gt;StartScheduledCaller&lt;/code&gt;, at most 1000. Not atomic: an
     * entry that fails is reported in its own &lt;code&gt;error_message&lt;/code&gt; and does not stop the others. Idempotent
     * per &lt;code&gt;idempotency_key&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StartScheduledCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void startScheduledCallers(ondewo.vtsi.CallsOuterClass.StartScheduledCallersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartScheduledCallersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartScheduledCallersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Adds callers to a campaign instead of starting them. The campaign then starts them, at most
     * &lt;code&gt;max_parallel_calls&lt;/code&gt; at a time. The request is atomic: either the campaign (when new), every
     * campaign call is stored, or nothing is. Errors are gRPC status codes (see &lt;code&gt;CampaignAssignment&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Rolling updates: a VTSI server that predates this RPC answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; and starts
     * nothing. Do not fall back to &lt;code&gt;StartCallers&lt;/code&gt; on &lt;code&gt;UNIMPLEMENTED&lt;/code&gt;; retry later.&lt;/p&gt;
     * </pre>
     */
    public void addCallersToCampaign(ondewo.vtsi.CallsOuterClass.AddCallersToCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.AddCallersToCampaignResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddCallersToCampaignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Adds scheduled callers to a campaign: each fires at or after its scheduled time AND when the campaign has a
     * free slot, and follows the campaign&amp;apos;s retries, stop and hard stop. Same atomicity, errors and rolling-update
     * behaviour as &lt;code&gt;AddCallersToCampaign&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void addScheduledCallersToCampaign(ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddScheduledCallersToCampaignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a scheduled caller, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of another project; with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void getScheduledCaller(ondewo.vtsi.CallsOuterClass.GetScheduledCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ScheduledCaller> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetScheduledCallerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the scheduled callers of a VTSI project, ordered by &lt;code&gt;scheduled_time&lt;/code&gt;, oldest first,
     * optionally narrowed by state, campaign and a &lt;code&gt;scheduled_time&lt;/code&gt; window. Paging,
     * &lt;code&gt;total_size&lt;/code&gt; and errors as for &lt;code&gt;ListCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void listScheduledCallers(ondewo.vtsi.CallsOuterClass.ListScheduledCallersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ListScheduledCallersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListScheduledCallersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Changes the &lt;code&gt;scheduled_time&lt;/code&gt; and/or the &lt;code&gt;sip_caller_config.sip_headers&lt;/code&gt; of a scheduled
     * caller that has not fired yet; the only updatable &lt;code&gt;update_mask&lt;/code&gt; paths (see
     * &lt;code&gt;UpdateScheduledCallerRequest.update_mask&lt;/code&gt;). Allowed only while the status is
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_PENDING&lt;/code&gt;; for a scheduled caller of a campaign only while its campaign call
     * is &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; (a retry of a campaign call is timed by the campaign&amp;apos;s
     * &lt;code&gt;retry_delay&lt;/code&gt;). The check and the write are one atomic step, so a scheduled caller that fires
     * concurrently is either updated before it fires or refused. Updating to the stored values is accepted and
     * changes nothing.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, an empty
     * &lt;code&gt;update_mask&lt;/code&gt;, a path that is not updatable, an unset &lt;code&gt;scheduled_time&lt;/code&gt; named by the
     * mask, invalid &lt;code&gt;sip_headers&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path (each naming the path);
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of another project;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when it is no longer PENDING (&lt;code&gt;reason=not-pending&lt;/code&gt;) or its campaign
     * call has started (&lt;code&gt;reason=campaign-call-started&lt;/code&gt;); with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_UPDATED&lt;/code&gt; when something changed.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void updateScheduledCaller(ondewo.vtsi.CallsOuterClass.UpdateScheduledCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ScheduledCaller> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateScheduledCallerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Cancels a scheduled caller that has not fired yet: a PENDING scheduled caller becomes
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_CANCELLED&lt;/code&gt; and never fires. A scheduled caller that is no longer PENDING
     * (firing, done, failed or already cancelled) is not an error: the response says &lt;code&gt;cancelled = false&lt;/code&gt;
     * and carries its current &lt;code&gt;status&lt;/code&gt;, so cancelling is idempotent.&lt;/p&gt;
     * &lt;p&gt;A scheduled caller of a campaign can be cancelled while its campaign call is
     * &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; or &lt;code&gt;CAMPAIGN_CALL_STATE_RETRY_PENDING&lt;/code&gt;;
     * the campaign call then becomes &lt;code&gt;CAMPAIGN_CALL_STATE_CANCELLED&lt;/code&gt;. While an attempt is
     * &lt;code&gt;DISPATCHING&lt;/code&gt; or &lt;code&gt;IN_PROGRESS&lt;/code&gt; the request is refused:
     * &lt;code&gt;cancelled = false&lt;/code&gt;, an &lt;code&gt;error_message&lt;/code&gt; saying why, and the scheduled caller keeps its
     * status.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of
     * another project; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CANCELLED&lt;/code&gt;, only when &lt;code&gt;cancelled = true&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void cancelScheduledCaller(ondewo.vtsi.CallsOuterClass.CancelScheduledCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.CancelScheduledCallerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelScheduledCallerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Cancels several scheduled callers, each like &lt;code&gt;CancelScheduledCaller&lt;/code&gt;, at most 1000. Not atomic:
     * every entry is applied on its own and reported in &lt;code&gt;CancelScheduledCallersResponse&lt;/code&gt;, in request
     * order; a failed entry carries an &lt;code&gt;error_message&lt;/code&gt; prefixed with the gRPC status code name
     * &lt;code&gt;CancelScheduledCaller&lt;/code&gt; would have answered (e.g. &lt;code&gt;NOT_FOUND: ...&lt;/code&gt;) and does not stop
     * the others. Errors of the request as a whole (see &lt;code&gt;CancelScheduledCallersRequest&lt;/code&gt;) are gRPC status
     * codes, and then nothing is cancelled.&lt;/p&gt;
     * &lt;p&gt;Events: one &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CANCELLED&lt;/code&gt; per entry with &lt;code&gt;cancelled = true&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;CancelScheduledCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void cancelScheduledCallers(ondewo.vtsi.CallsOuterClass.CancelScheduledCallersRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.CancelScheduledCallersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelScheduledCallersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Retries a FAILED scheduled caller by creating a NEW scheduled caller from its stored request: the same
     * &lt;code&gt;sip_caller_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt;, &lt;code&gt;status = PENDING&lt;/code&gt;, the
     * &lt;code&gt;scheduled_time&lt;/code&gt; of the request (unset: now), and &lt;code&gt;retry_of_scheduled_caller_name&lt;/code&gt; naming
     * the failed one, whose &lt;code&gt;retried_by_scheduled_caller_name&lt;/code&gt; is set to the new one in the same atomic
     * step. The failed scheduled caller itself is not changed otherwise, so its &lt;code&gt;error_message&lt;/code&gt; and
     * &lt;code&gt;fired_at&lt;/code&gt; stay as the history of the failed attempt. Returns the new scheduled caller.&lt;/p&gt;
     * &lt;p&gt;Idempotency: a FAILED scheduled caller is retried at most once. A repeat of the request answers
     * &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; naming the retry in its message (read
     * &lt;code&gt;retried_by_scheduled_caller_name&lt;/code&gt;); to retry again after the retry failed too, retry the new
     * one.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of
     * another project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a scheduled caller that is not
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_FAILED&lt;/code&gt; (&lt;code&gt;reason=not-failed&lt;/code&gt;) or that belongs to a campaign
     * (&lt;code&gt;reason=campaign-scheduled-caller&lt;/code&gt;: a campaign call is retried by the campaign&amp;apos;s
     * &lt;code&gt;max_attempts&lt;/code&gt;); &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when it was already retried;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the project reached its caller limit; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CREATED&lt;/code&gt; for the new scheduled caller.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void retryScheduledCaller(ondewo.vtsi.CallsOuterClass.RetryScheduledCallerRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ScheduledCaller> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetryScheduledCallerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a call: hangs it up if it is still active and stops (releases) the listener or caller that serves
     * it, like &lt;code&gt;StopCaller&lt;/code&gt; / &lt;code&gt;StopListener&lt;/code&gt;. A call that already ended is not an error: its
     * listener or caller is still released if it is deployed, and when there was nothing left to release the
     * response carries &lt;code&gt;error_message = Call ... was not released&lt;/code&gt;, so a repeat succeeds with that
     * message.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or call, or a call of another
     * project; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt;, and &lt;code&gt;VTSI_EVENT_CALLER_STOPPED&lt;/code&gt; /
     * &lt;code&gt;VTSI_EVENT_LISTENER_STOPPED&lt;/code&gt; for the released resource.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void stopCall(ondewo.vtsi.CallsOuterClass.StopCallRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopCallResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopCallMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops several calls of one project, each like &lt;code&gt;StopCall&lt;/code&gt;, at most 1000 distinct names. Not
     * atomic: every call is stopped on its own and reported in its own entry, in request order; a failed entry
     * carries an &lt;code&gt;error_message&lt;/code&gt; prefixed with the gRPC status code name &lt;code&gt;StopCall&lt;/code&gt; would have
     * answered and does not stop the others. No entry, more than 1000 names or a malformed
     * &lt;code&gt;vtsi_project_name&lt;/code&gt; is &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, an unknown project &lt;code&gt;NOT_FOUND&lt;/code&gt;, and
     * then nothing is stopped.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StopCall&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void stopCalls(ondewo.vtsi.CallsOuterClass.StopCallsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopCallsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopCallsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops every call of a VTSI project (listener and caller calls alike), or, with
     * &lt;code&gt;call_filter&lt;/code&gt;, those it matches, each like &lt;code&gt;StopCall&lt;/code&gt;. Not atomic and not bounded in
     * size; a project with nothing to stop answers an empty response, so the RPC is idempotent. If a stop fails
     * part-way, the remaining calls are still stopped one by one and every call gets its own entry.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, an invalid &lt;code&gt;call_filter&lt;/code&gt; or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or campaign; with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void stopAllCalls(ondewo.vtsi.CallsOuterClass.StopAllCallsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopCallsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopAllCallsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Transfer a call to a phone number, a softphone account, another listener or the listener queue.&lt;/p&gt;
     * &lt;p&gt;The target is either the typed &lt;code&gt;target&lt;/code&gt; or the legacy raw &lt;code&gt;transfer_id&lt;/code&gt;, never both. It is
     * resolved and validated before anything is sent; an invalid target is answered with
     * &lt;code&gt;TRANSFER_OUTCOME_TARGET_INVALID&lt;/code&gt; and an &lt;code&gt;error_reason&lt;/code&gt;, and the call is untouched.&lt;/p&gt;
     * &lt;p&gt;&lt;code&gt;TRANSFER_MODE_BLIND&lt;/code&gt; (default) sends a SIP REFER and reports its outcome: a refused REFER keeps the
     * call with the bot. &lt;code&gt;TRANSFER_MODE_WARM&lt;/code&gt; rings the target into the call first, and the bot leaves only
     * after the target joined (Asterisk 22 only).&lt;/p&gt;
     * &lt;p&gt;Telephony outcomes (busy, no answer, REFER rejected) are successful RPCs carrying an &lt;code&gt;outcome&lt;/code&gt;.
     * Refusals before any side effect also return a gRPC status with &lt;code&gt;reason=&amp;lt;token&amp;gt;&lt;/code&gt; in its details:
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; (both targets set, malformed target), &lt;code&gt;NOT_FOUND&lt;/code&gt; (call or target not
     * found, including another project&amp;apos;s), &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; (&lt;code&gt;call-not-connected&lt;/code&gt;,
     * &lt;code&gt;amd-in-progress&lt;/code&gt;, &lt;code&gt;call-not-yet-identified&lt;/code&gt;, &lt;code&gt;participants-present&lt;/code&gt;,
     * &lt;code&gt;asterisk-version-unsupported&lt;/code&gt;, &lt;code&gt;sip-image-too-old&lt;/code&gt;), &lt;code&gt;ABORTED&lt;/code&gt;
     * (&lt;code&gt;transfer-in-progress&lt;/code&gt;), &lt;code&gt;UNAVAILABLE&lt;/code&gt; (&lt;code&gt;sip-unreachable&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public void transferCall(ondewo.vtsi.CallsOuterClass.TransferCallRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.TransferCallResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTransferCallMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Transfer several calls, each like &lt;code&gt;TransferCall&lt;/code&gt;, at most 1000. Not atomic: every transfer is
     * run on its own and reported in its own entry, in request order; an entry &lt;code&gt;TransferCall&lt;/code&gt; would have
     * refused with a gRPC status carries that refusal in its &lt;code&gt;error_message&lt;/code&gt; (prefixed with the status
     * code name) and does not stop the others. Idempotent per entry &lt;code&gt;request_id&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public void transferCalls(ondewo.vtsi.CallsOuterClass.TransferCallsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.TransferCallsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTransferCallsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a call, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt; (the call&amp;apos;s log
     * lines are read with &lt;code&gt;Logs.ListCallLogs&lt;/code&gt;). &lt;code&gt;FULL&lt;/code&gt; also returns every participant ever
     * invited into the call (see &lt;code&gt;Call.participants&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or call, or a call of another project; with authorization
     * enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void getCall(ondewo.vtsi.CallsOuterClass.GetCallRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.Call> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCallMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the calls of a VTSI project, ended ones included, narrowed by &lt;code&gt;call_filter&lt;/code&gt;, ordered by
     * &lt;code&gt;call_sorting&lt;/code&gt; (default: by &lt;code&gt;start_time&lt;/code&gt;, oldest first) and paged with
     * &lt;code&gt;page_size&lt;/code&gt; / &lt;code&gt;page_token&lt;/code&gt;; &lt;code&gt;total_size&lt;/code&gt; counts every match.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;call_filter.campaign_name&lt;/code&gt; or &lt;code&gt;call_filter.campaign_display_name&lt;/code&gt; set, lists
     * only the calls of that campaign: the calls placed by the attempts of its campaign calls.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, an invalid filter, a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a &lt;code&gt;page_token&lt;/code&gt; of another listing or an unknown &lt;code&gt;field_mask&lt;/code&gt;
     * path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or campaign; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void listCalls(ondewo.vtsi.CallsOuterClass.ListCallsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ListCallsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCallsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Aggregate figures (totals, active calls, counts by SIP status type, by call type, by AMD verdict and by
     * transfer outcome, durations, redial recommendations) over the calls of a VTSI project that
     * &lt;code&gt;call_filter&lt;/code&gt; matches; see &lt;code&gt;CallStatistics&lt;/code&gt;. Read only, no side effect.&lt;/p&gt;
     * &lt;p&gt;Errors: as for &lt;code&gt;ListCalls&lt;/code&gt; (an invalid filter is &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, an unknown project
     * or campaign &lt;code&gt;NOT_FOUND&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;ListCalls&lt;/code&gt; (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project).&lt;/p&gt;
     * </pre>
     */
    public void getCallStatistics(ondewo.vtsi.CallsOuterClass.GetCallStatisticsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.CallStatistics> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCallStatisticsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the descriptive metadata of a call: the only updatable &lt;code&gt;update_mask&lt;/code&gt; path is
     * &lt;code&gt;labels&lt;/code&gt;. Allowed on active and ended calls. Refused for the WAITING call of a persistent
     * listener or a pooled caller (status &lt;code&gt;NO_ONGOING_CALL&lt;/code&gt;, not active: the record that waits for the
     * next call, which &lt;code&gt;ListCalls&lt;/code&gt; returns too) with &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; and
     * &lt;code&gt;reason=call-not-started&lt;/code&gt; in the details: label the call once it has started. It changes only
     * the stored call record: the live call, its SIP container, its status and its media are never touched, and
     * nothing is sent to the call. Idempotent: writing the stored labels again changes nothing.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_UPDATED&lt;/code&gt; when the labels changed.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;call.name&lt;/code&gt;, an
     * empty &lt;code&gt;update_mask&lt;/code&gt;, any path other than &lt;code&gt;labels&lt;/code&gt; (every other field of a
     * &lt;code&gt;Call&lt;/code&gt; is output only), a path below &lt;code&gt;labels&lt;/code&gt;, labels outside the bounds of
     * &lt;code&gt;Call.labels&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path (each naming the path or label);
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown call or project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;
     * (&lt;code&gt;reason=call-not-started&lt;/code&gt;) for a waiting call; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; for a project the caller holds no role on.&lt;/p&gt;
     * &lt;p&gt;Authorization: the role that may stop calls of the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or
     * higher).&lt;/p&gt;
     * </pre>
     */
    public void updateCall(ondewo.vtsi.CallsOuterClass.UpdateCallRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateCallResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCallMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates several calls, each like &lt;code&gt;UpdateCall&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;UpdateCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;UpdateCall&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void updateCalls(ondewo.vtsi.CallsOuterClass.UpdateCallsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateCallsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCallsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the status of the callers of a project: a snapshot first
     * (&lt;code&gt;snapshot = true&lt;/code&gt;), then every caller whose call or SIP status changed, plus
     * keep-alive messages. Ends when the client disconnects or at the server-side maximum stream
     * duration.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when
     * the server has no free stream slot.&lt;/p&gt;
     * </pre>
     */
    public void streamCallerStatus(ondewo.vtsi.CallsOuterClass.StreamCallerStatusRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamCallerStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the status of the listeners of a project, like &lt;code&gt;StreamCallerStatus&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void streamListenerStatus(ondewo.vtsi.CallsOuterClass.StreamListenerStatusRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamListenerStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the status of the scheduled callers of a project, like
     * &lt;code&gt;StreamCallerStatus&lt;/code&gt;. The snapshot holds every PENDING and FIRING scheduled caller
     * and those that finished in the last hour.&lt;/p&gt;
     * </pre>
     */
    public void streamScheduledCallerStatus(ondewo.vtsi.CallsOuterClass.StreamScheduledCallerStatusRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamScheduledCallerStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Invite a registered softphone account of the project into a connected call. Returns the participant in
     * &lt;code&gt;PARTICIPANT_STATE_RINGING&lt;/code&gt;; follow &lt;code&gt;Call.participants&lt;/code&gt; or the events
     * &lt;code&gt;VTSI_EVENT_CALL_PARTICIPANT_*&lt;/code&gt; for JOINED, FAILED and LEFT.&lt;/p&gt;
     * &lt;p&gt;&lt;code&gt;PARTICIPANT_MODE_CONFERENCE&lt;/code&gt; (default) joins the softphone into the call: Asterisk mixes the caller,
     * the bot and the participant, and by default the bot keeps talking and listening
     * (&lt;code&gt;BOT_POLICY_ON_JOIN_KEEP&lt;/code&gt;). &lt;code&gt;PARTICIPANT_MODE_MONITOR&lt;/code&gt; lets the participant listen only.
     * When the bot&amp;apos;s leg ends, every participant is hung up; the caller is handed over only by a WARM
     * &lt;code&gt;TransferCall&lt;/code&gt;. Idempotent per &lt;code&gt;request_id&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, &lt;code&gt;NOT_FOUND&lt;/code&gt; (call or softphone account, including another
     * project&amp;apos;s), &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; (&lt;code&gt;call-not-connected&lt;/code&gt;, &lt;code&gt;amd-in-progress&lt;/code&gt;,
     * &lt;code&gt;softphone-not-registered&lt;/code&gt;, &lt;code&gt;softphone-disabled&lt;/code&gt;, &lt;code&gt;softphone-unrouted&lt;/code&gt;,
     * &lt;code&gt;call-not-yet-identified&lt;/code&gt;, &lt;code&gt;bot-channel-ambiguous&lt;/code&gt;, &lt;code&gt;asterisk-not-local&lt;/code&gt;,
     * &lt;code&gt;asterisk-version-unsupported&lt;/code&gt;), &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; (the softphone is already ringing or joined),
     * &lt;code&gt;ABORTED&lt;/code&gt; (&lt;code&gt;transfer-in-progress&lt;/code&gt;), &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; (participant cap),
     * &lt;code&gt;UNAVAILABLE&lt;/code&gt; (&lt;code&gt;asterisk-unreachable&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public void inviteToCall(ondewo.vtsi.CallsOuterClass.InviteToCallRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.InviteToCallResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInviteToCallMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Hang up a participant of a call (ringing or joined). The participant ends as
     * &lt;code&gt;PARTICIPANT_STATE_LEFT&lt;/code&gt; with &lt;code&gt;end_reason = REMOVED&lt;/code&gt;; the call and the bot are not
     * affected. Returns the participant after the request.&lt;/p&gt;
     * &lt;p&gt;Idempotent: a participant that already FAILED or LEFT (for whatever reason) is returned unchanged with OK,
     * and nothing is sent.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request; &lt;code&gt;NOT_FOUND&lt;/code&gt; with
     * &lt;code&gt;reason=call-not-found&lt;/code&gt; for an unknown call or a call of another project, and with
     * &lt;code&gt;reason=participant-not-found&lt;/code&gt; for an unknown &lt;code&gt;participant_id&lt;/code&gt; or a participant of
     * another call; &lt;code&gt;ABORTED&lt;/code&gt; with &lt;code&gt;reason=call-control-busy&lt;/code&gt; while another call-control
     * request for the call runs (retry); &lt;code&gt;UNAVAILABLE&lt;/code&gt; with &lt;code&gt;reason=asterisk-unreachable&lt;/code&gt; when
     * the hang-up could not be sent; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_PARTICIPANT_LEFT&lt;/code&gt; (or &lt;code&gt;VTSI_EVENT_CALL_PARTICIPANT_FAILED&lt;/code&gt;
     * for a participant that was still ringing).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher. Audited like &lt;code&gt;InviteToCall&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void removeCallParticipant(ondewo.vtsi.CallsOuterClass.RemoveCallParticipantRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.RemoveCallParticipantResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveCallParticipantMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Mute the bot of a connected call and/or stop it listening to the caller, or undo either. Every request sets a
     * desired level and never toggles: a repeat answers &lt;code&gt;changed = false&lt;/code&gt;. The bot stays muted while
     * anything else (a TALK take-over of &lt;code&gt;StreamCallAudio&lt;/code&gt;, a participant bot policy) also holds it muted.&lt;/p&gt;
     * &lt;p&gt;Both settings &lt;code&gt;CALL_MEDIA_SETTING_UNCHANGED&lt;/code&gt; is a valid read of the current state: it answers
     * the effective &lt;code&gt;state&lt;/code&gt; with &lt;code&gt;changed = false&lt;/code&gt;, changes nothing, and writes no audit record
     * and no event (see &lt;code&gt;SetCallMediaControlRequest.bot_voice&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_BOT_MUTED&lt;/code&gt; / &lt;code&gt;VTSI_EVENT_CALL_BOT_UNMUTED&lt;/code&gt; /
     * &lt;code&gt;VTSI_EVENT_CALL_LISTENING_PAUSED&lt;/code&gt; / &lt;code&gt;VTSI_EVENT_CALL_LISTENING_RESUMED&lt;/code&gt; when the
     * effective state changed.&lt;/p&gt;
     * &lt;p&gt;Errors as for &lt;code&gt;InviteToCall&lt;/code&gt;, plus &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=sip-image-too-old&lt;/code&gt;,
     * &lt;code&gt;ABORTED&lt;/code&gt; &lt;code&gt;reason=call-control-busy&lt;/code&gt; (another call-control request for the call is running)
     * and &lt;code&gt;UNAVAILABLE&lt;/code&gt; &lt;code&gt;reason=sip-unreachable&lt;/code&gt; or &lt;code&gt;reason=csi-media-control-failed&lt;/code&gt; (the
     * bot did not apply the level: a requested pause is rolled back, a requested mute is kept).&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public void setCallMediaControl(ondewo.vtsi.CallsOuterClass.SetCallMediaControlRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.SetCallMediaControlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetCallMediaControlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Live audio of a connected call, both ways. The first request MUST be &lt;code&gt;config&lt;/code&gt; (within 2 seconds).
     * LISTEN receives the caller mixed with the bot. TALK sends the agent&amp;apos;s audio to the caller and REQUIRES
     * &lt;code&gt;take_over&lt;/code&gt;: the bot is muted and does not listen while the stream is connected, and resumes when it
     * ends; in TALK the agent hears the caller only. Audio is LINEAR16 little-endian mono in 20 ms frames.&lt;/p&gt;
     * &lt;p&gt;Bidirectional streaming: available to native gRPC clients (python, nodejs) only. Browser (grpc-web) clients
     * use &lt;code&gt;ListenCallAudio&lt;/code&gt;, plus a softphone (&lt;code&gt;InviteToCall&lt;/code&gt;) to talk.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; (no or invalid &lt;code&gt;config&lt;/code&gt;, TALK without
     * &lt;code&gt;take_over&lt;/code&gt;, wrong frame size), &lt;code&gt;NOT_FOUND&lt;/code&gt;, &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;
     * (&lt;code&gt;call-not-connected&lt;/code&gt;, &lt;code&gt;amd-in-progress&lt;/code&gt;, &lt;code&gt;call-not-yet-identified&lt;/code&gt;,
     * &lt;code&gt;bot-still-speaking&lt;/code&gt;, &lt;code&gt;sip-image-too-old&lt;/code&gt;), &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; (stream cap, a
     * second TALK). A normal end sends one &lt;code&gt;ended&lt;/code&gt; message, then OK. A second &lt;code&gt;config&lt;/code&gt; or audio
     * sent in LISTEN mode ends the stream with &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;. A client half-close ends the stream
     * (&lt;code&gt;CALL_AUDIO_END_REASON_CLIENT_CLOSED&lt;/code&gt;), so a listening client keeps its request stream open.&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StreamCallAudioRequest> streamCallAudio(
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamCallAudioMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Listen-only live audio of a connected call, like &lt;code&gt;StreamCallAudio&lt;/code&gt; in LISTEN mode, as a server
     * stream that grpc-web (browser) clients can consume. &lt;code&gt;config.mode&lt;/code&gt; must be LISTEN or unspecified and
     * &lt;code&gt;config.take_over&lt;/code&gt; must be false, otherwise &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; &lt;code&gt;reason=listen-only&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public void listenCallAudio(ondewo.vtsi.CallsOuterClass.ListenCallAudioRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getListenCallAudioMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Calls.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public static final class CallsBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CallsBlockingV2Stub> {
    private CallsBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CallsBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CallsBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts one caller in a VTSI project: an ondewo-sip container that places one outbound call to
     * &lt;code&gt;sip_caller_config.callee_id&lt;/code&gt; (or a pooled caller of the server&amp;apos;s caller pool that runs the same
     * configuration). The configuration is validated first, including live checks against the upstream services;
     * nothing is started when it fails. Not idempotent: every successful request places a new call (send it as a
     * batch of one with an &lt;code&gt;idempotency_key&lt;/code&gt; to make it idempotent). &lt;code&gt;validate_only&lt;/code&gt; runs the
     * validation alone.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed or invalid request or
     * configuration (also when the NLU credentials are refused) or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when an upstream config lacks
     * the required TLS certificate (&lt;code&gt;UPSTREAM_TLS_REQUIRED&lt;/code&gt;) or the project is not deployed;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the project reached its caller limit; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when an
     * upstream service could not be reached; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_STARTED&lt;/code&gt; or &lt;code&gt;VTSI_EVENT_CALLER_START_FAILED&lt;/code&gt;, then the
     * events of the call (&lt;code&gt;VTSI_EVENT_CALL_*&lt;/code&gt;). None with &lt;code&gt;validate_only&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StartCallerResponse startCaller(ondewo.vtsi.CallsOuterClass.StartCallerRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStartCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts several callers, each like &lt;code&gt;StartCaller&lt;/code&gt;. Not atomic: every caller is started on its own;
     * a caller that fails to start is rolled back and has no entry in the response, which accounts for it in
     * &lt;code&gt;StartCallersResponse.error_message&lt;/code&gt;. The project&amp;apos;s caller limit is checked for the batch as a
     * whole before anything is started (&lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;, nothing started). Idempotent per
     * &lt;code&gt;idempotency_key&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StartCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StartCallersResponse startCallers(ondewo.vtsi.CallsOuterClass.StartCallersRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStartCallersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the callers of a VTSI project, ordered by the caller&amp;apos;s uuid (the last segment of
     * &lt;code&gt;name&lt;/code&gt;), ascending: a stable order, not a chronological one. Paged with &lt;code&gt;page_size&lt;/code&gt; /
     * &lt;code&gt;page_token&lt;/code&gt;; &lt;code&gt;total_size&lt;/code&gt; counts every match.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;campaign_name&lt;/code&gt; or &lt;code&gt;campaign_display_name&lt;/code&gt; set, lists only the callers of that
     * campaign: the callers that placed at least one attempt of one of its campaign calls (see
     * &lt;code&gt;ListCallersRequest.campaign_name&lt;/code&gt;). &lt;code&gt;active_only&lt;/code&gt; and &lt;code&gt;sip_status_types&lt;/code&gt;
     * narrow the listing further.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, an invalid selector, a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a &lt;code&gt;page_token&lt;/code&gt; of another listing or an unknown &lt;code&gt;field_mask&lt;/code&gt;
     * path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or campaign; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.ListCallersResponse listCallers(ondewo.vtsi.CallsOuterClass.ListCallersRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListCallersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a caller, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or caller, or a caller of another project; with authorization
     * enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.Caller getCaller(ondewo.vtsi.CallsOuterClass.GetCallerRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the STORED configuration of a caller: the fields named in &lt;code&gt;update_mask&lt;/code&gt;, i.e.
     * &lt;code&gt;sip_caller_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt; or any nested sub-path of them.
     * Allowed whether or not the caller has a call running.&lt;/p&gt;
     * &lt;p&gt;A running call and its container are NEVER changed: nothing is restarted, redeployed or reconfigured,
     * and the call goes on with the configuration its container was deployed with.&lt;/p&gt;
     * &lt;p&gt;When the stored configuration takes effect: a caller is ONE call (every &lt;code&gt;StartCaller&lt;/code&gt; creates
     * a new caller carrying its own configuration, and no RPC redeploys an existing one), so for a caller that
     * is not pooled the update changes ONLY the stored and returned configuration and never any present or
     * future call. The one case in which the server deploys a container from a caller&amp;apos;s stored
     * configuration is a POOLED (persistent) caller, which the server keeps warm between calls: when the server
     * recycles the pooled callers of a project onto its Asterisk (an &lt;code&gt;UpdateVtsiProject&lt;/code&gt; of a
     * deployed project, the recovery after the project&amp;apos;s Asterisk restarted, a change of the project&amp;apos;s
     * TLS trust anchor), the pooled caller it starts in place of this one is deployed from the stored, i.e.
     * updated, configuration. An in-place restart of a pooled caller&amp;apos;s container (the call monitor&amp;apos;s
     * health recovery) keeps the configuration the container was deployed with. Until it is recycled, an idle
     * pooled caller is matched to later &lt;code&gt;StartCaller&lt;/code&gt; requests by the configuration its container
     * RUNS, never by an updated stored configuration it does not run.&lt;/p&gt;
     * &lt;p&gt;Updating a caller never changes a campaign: the attempts of a campaign call take their configuration
     * from the campaign and the campaign call, never from a &lt;code&gt;Caller&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;A STOPPED caller (its call ended and its configuration was released) has no stored configuration left:
     * the update starts from an empty one, so it must state a complete configuration
     * (&lt;code&gt;sip_caller_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt;), and a partial one is refused as a
     * configuration a &lt;code&gt;StartCallerRequest&lt;/code&gt; would be refused for. Nothing is deployed.&lt;/p&gt;
     * &lt;p&gt;Credentials follow their endpoint: an update that MOVES an upstream (the &lt;code&gt;host&lt;/code&gt;,
     * &lt;code&gt;port&lt;/code&gt; or &lt;code&gt;grpc_cert&lt;/code&gt; of the NLU, S2T or T2S &lt;code&gt;*_base_config&lt;/code&gt;, or the
     * &lt;code&gt;host&lt;/code&gt; / ports of &lt;code&gt;csi_vtsi_config.message_broker_config.rabbit_mq_config&lt;/code&gt;) must
     * also write every credential path of that upstream that holds a stored value -- the NLU
     * &lt;code&gt;credentials&lt;/code&gt;, &lt;code&gt;auth_token&lt;/code&gt;, &lt;code&gt;http_basic_auth_token&lt;/code&gt; and
     * &lt;code&gt;contexts&lt;/code&gt;, the S2T &lt;code&gt;s2t_transcribe_request_config&lt;/code&gt;, the T2S
     * &lt;code&gt;t2s_request_config&lt;/code&gt;, the RabbitMQ &lt;code&gt;user&lt;/code&gt; and &lt;code&gt;password&lt;/code&gt; -- named itself
     * or by a shorter path, with the values to use. A stored credential is never sent to an endpoint the request
     * moved without restating it, also not for the live validation of the result.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;caller.name&lt;/code&gt;,
     * an empty &lt;code&gt;update_mask&lt;/code&gt;, an unknown, output-only or immutable &lt;code&gt;update_mask&lt;/code&gt; path, an
     * update that moves an upstream without restating its stored credentials (naming the paths to add), a
     * resulting configuration that a &lt;code&gt;StartCallerRequest&lt;/code&gt; carrying it would be refused for, or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path (each naming the path or field); &lt;code&gt;NOT_FOUND&lt;/code&gt; for an
     * unknown caller or project; &lt;code&gt;ABORTED&lt;/code&gt; when concurrent updates kept changing the caller, or while
     * an update, deploy or undeploy of its project is still running (an update waits for it, for a bounded time,
     * so that a recycle of the project cannot lose it), nothing being written (retry the request); with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; for a project the caller holds no role on.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_UPDATED&lt;/code&gt; (none with &lt;code&gt;validate_only&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: the role that may start and stop callers of the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;
     * or higher).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.UpdateCallerResponse updateCaller(ondewo.vtsi.CallsOuterClass.UpdateCallerRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates several callers, each like &lt;code&gt;UpdateCaller&lt;/code&gt;. Not atomic: every entry is applied on its
     * own and reported in &lt;code&gt;UpdateCallersResponse.update_caller_responses&lt;/code&gt;, in request order; an entry
     * that fails changes nothing and does not stop the others. Errors of the request as a whole (see
     * &lt;code&gt;UpdateCallersRequest&lt;/code&gt;) are gRPC status codes, and then no entry is applied.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;UpdateCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.UpdateCallersResponse updateCallers(ondewo.vtsi.CallsOuterClass.UpdateCallersRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateCallersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a caller: stops it if it still runs (hanging up its call) and removes it, so it is no longer
     * listed or returned. Its call records (and their participants) are deleted with it and are no longer returned
     * by &lt;code&gt;GetCall&lt;/code&gt; / &lt;code&gt;ListCalls&lt;/code&gt;; stop it instead to keep them.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown caller, a caller of another project, or a
     * caller that was already deleted (so deleting is NOT idempotent: a repeat answers &lt;code&gt;NOT_FOUND&lt;/code&gt;);
     * with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_DELETED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.DeleteCallerResponse deleteCaller(ondewo.vtsi.CallsOuterClass.DeleteCallerRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes several callers, each like &lt;code&gt;DeleteCaller&lt;/code&gt;. Not atomic: every caller is deleted on its own
     * and reported in its own entry, whose &lt;code&gt;error_message&lt;/code&gt; carries the gRPC status code name
     * &lt;code&gt;DeleteCaller&lt;/code&gt; would have answered (e.g. &lt;code&gt;NOT_FOUND: ...&lt;/code&gt;); an entry that fails does not
     * stop the others. The request as a whole is refused, nothing being deleted, for no entry or more than 1000
     * distinct names, and, when &lt;code&gt;vtsi_project_name&lt;/code&gt; is set, as described there.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;DeleteCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.DeleteCallersResponse deleteCallers(ondewo.vtsi.CallsOuterClass.DeleteCallersRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteCallersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a caller: hangs up its call if one is up and releases its container and SIP account. The caller
     * stays listed (with &lt;code&gt;active = false&lt;/code&gt;) until it is deleted, and its stored configuration stays
     * updatable (see &lt;code&gt;UpdateCaller&lt;/code&gt;). A pooled caller is taken out of the pool.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown caller, a caller of another project, or a
     * caller that is already stopped (so stopping is NOT idempotent: a repeat answers &lt;code&gt;NOT_FOUND&lt;/code&gt;); with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_STOPPED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StopCallerResponse stopCaller(ondewo.vtsi.CallsOuterClass.StopCallerRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStopCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops several callers, each like &lt;code&gt;StopCaller&lt;/code&gt;, with the per-entry results and the request-level
     * errors of &lt;code&gt;DeleteCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StopCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StopCallersResponse stopCallers(ondewo.vtsi.CallsOuterClass.StopCallersRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStopCallersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts one listener in a VTSI project: an ondewo-sip container registered on the project&amp;apos;s Asterisk
     * that answers inbound calls, one after the other (persistent). Validation, &lt;code&gt;validate_only&lt;/code&gt;, errors
     * (&lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; for the project&amp;apos;s listener limit) and idempotency as for
     * &lt;code&gt;StartCaller&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_STARTED&lt;/code&gt; or &lt;code&gt;VTSI_EVENT_LISTENER_START_FAILED&lt;/code&gt;. None with
     * &lt;code&gt;validate_only&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StartListenerResponse startListener(ondewo.vtsi.CallsOuterClass.StartListenerRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStartListenerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts several listeners, each like &lt;code&gt;StartListener&lt;/code&gt;, with the batch semantics of
     * &lt;code&gt;StartCallers&lt;/code&gt; (a listener that fails to start has no entry and is accounted for in
     * &lt;code&gt;StartListenersResponse.error_message&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StartListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StartListenersResponse startListeners(ondewo.vtsi.CallsOuterClass.StartListenersRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStartListenersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a listener: hangs up its call if one is up and releases its container and SIP account. A stopped
     * listener has no stored configuration left (see &lt;code&gt;UpdateListener&lt;/code&gt;). Errors and idempotency as for
     * &lt;code&gt;StopCaller&lt;/code&gt; (a listener that is already stopped is &lt;code&gt;NOT_FOUND&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_STOPPED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StopListenerResponse stopListener(ondewo.vtsi.CallsOuterClass.StopListenerRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStopListenerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops several listeners, each like &lt;code&gt;StopListener&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;DeleteCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StopListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StopListenersResponse stopListeners(ondewo.vtsi.CallsOuterClass.StopListenersRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStopListenersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the listeners of a VTSI project, ordered by the listener&amp;apos;s uuid (the last segment of
     * &lt;code&gt;name&lt;/code&gt;), ascending. Paging, &lt;code&gt;total_size&lt;/code&gt;, filters and errors as for
     * &lt;code&gt;ListCallers&lt;/code&gt; (without a campaign selector).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.ListListenersResponse listListeners(ondewo.vtsi.CallsOuterClass.ListListenersRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListListenersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a listener, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt;. Errors as for
     * &lt;code&gt;GetCaller&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.Listener getListener(ondewo.vtsi.CallsOuterClass.GetListenerRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetListenerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the STORED configuration of a listener: the fields named in &lt;code&gt;update_mask&lt;/code&gt;, i.e.
     * &lt;code&gt;sip_base_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt; or any nested sub-path of them.
     * Allowed whether or not the listener&amp;apos;s container is running or has a call, as long as the listener is
     * DEPLOYED: a stopped listener has no stored configuration (it is deployed again only by a
     * &lt;code&gt;StartListener&lt;/code&gt; carrying a complete one) and is &lt;code&gt;NOT_FOUND&lt;/code&gt;, unlike a stopped caller,
     * which &lt;code&gt;UpdateCaller&lt;/code&gt; accepts with a complete configuration.&lt;/p&gt;
     * &lt;p&gt;A running container and every call it takes are NEVER changed: nothing is restarted, redeployed or
     * reconfigured, and the running container answers its calls with the configuration it was deployed with
     * until it is replaced.&lt;/p&gt;
     * &lt;p&gt;When the stored configuration takes effect: only when the server RECREATES the listener from it, i.e.
     * when it recycles the listeners of the project onto its Asterisk: an &lt;code&gt;UpdateVtsiProject&lt;/code&gt; of a
     * deployed project, the recovery after the project&amp;apos;s Asterisk restarted, or a change of the
     * project&amp;apos;s TLS trust anchor. The listener the server starts in place of this one is deployed from the
     * stored, i.e. updated, configuration. An in-place restart of the listener&amp;apos;s container (the
     * server&amp;apos;s restore of listener containers when it starts, the call monitor&amp;apos;s restart of an
     * unhealthy container, a &lt;code&gt;docker restart&lt;/code&gt;) keeps the configuration the container was deployed
     * with. A listener that is never recycled keeps the update only as its stored (and returned)
     * configuration.&lt;/p&gt;
     * &lt;p&gt;Errors as for &lt;code&gt;UpdateCaller&lt;/code&gt; (the credential rule included), with
     * &lt;code&gt;StartListenerRequest&lt;/code&gt; as the validation of the resulting configuration, and
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; also for a stopped listener.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_UPDATED&lt;/code&gt; (none with &lt;code&gt;validate_only&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: the role that may start and stop listeners of the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;
     * or higher).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.UpdateListenerResponse updateListener(ondewo.vtsi.CallsOuterClass.UpdateListenerRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateListenerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates several listeners, each like &lt;code&gt;UpdateListener&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;UpdateCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;UpdateListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.UpdateListenersResponse updateListeners(ondewo.vtsi.CallsOuterClass.UpdateListenersRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateListenersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a listener: stops it if it still runs (hanging up its call) and removes it, with its call
     * records, like &lt;code&gt;DeleteCaller&lt;/code&gt;. Errors and idempotency as for &lt;code&gt;DeleteCaller&lt;/code&gt; (a repeat
     * answers &lt;code&gt;NOT_FOUND&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_DELETED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.DeleteListenerResponse deleteListener(ondewo.vtsi.CallsOuterClass.DeleteListenerRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteListenerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes several listeners, each like &lt;code&gt;DeleteListener&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;DeleteCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;DeleteListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.DeleteListenersResponse deleteListeners(ondewo.vtsi.CallsOuterClass.DeleteListenersRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteListenersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a scheduled caller: a caller that the server starts at or after &lt;code&gt;scheduled_time&lt;/code&gt;, like a
     * &lt;code&gt;StartCaller&lt;/code&gt; of the stored request. The request is checked structurally now; the live checks of
     * the configuration run when it fires, and a failure then leaves the scheduled caller
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_FAILED&lt;/code&gt; with its &lt;code&gt;error_message&lt;/code&gt;. A &lt;code&gt;scheduled_time&lt;/code&gt; in
     * the past is due at once. Not idempotent (use &lt;code&gt;StartScheduledCallers&lt;/code&gt; with an
     * &lt;code&gt;idempotency_key&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, a missing
     * &lt;code&gt;scheduled_time&lt;/code&gt;, a nested request with its own &lt;code&gt;field_mask&lt;/code&gt; or
     * &lt;code&gt;validate_only&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown
     * project; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the project reached its caller limit; with authorization
     * enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CREATED&lt;/code&gt;; later &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_FIRED&lt;/code&gt;,
     * &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_RETRY_SCHEDULED&lt;/code&gt; or &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_FAILED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StartScheduledCallerResponse startScheduledCaller(ondewo.vtsi.CallsOuterClass.StartScheduledCallerRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStartScheduledCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates several scheduled callers, each like &lt;code&gt;StartScheduledCaller&lt;/code&gt;, at most 1000. Not atomic: an
     * entry that fails is reported in its own &lt;code&gt;error_message&lt;/code&gt; and does not stop the others. Idempotent
     * per &lt;code&gt;idempotency_key&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StartScheduledCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StartScheduledCallersResponse startScheduledCallers(ondewo.vtsi.CallsOuterClass.StartScheduledCallersRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStartScheduledCallersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Adds callers to a campaign instead of starting them. The campaign then starts them, at most
     * &lt;code&gt;max_parallel_calls&lt;/code&gt; at a time. The request is atomic: either the campaign (when new), every
     * campaign call is stored, or nothing is. Errors are gRPC status codes (see &lt;code&gt;CampaignAssignment&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Rolling updates: a VTSI server that predates this RPC answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; and starts
     * nothing. Do not fall back to &lt;code&gt;StartCallers&lt;/code&gt; on &lt;code&gt;UNIMPLEMENTED&lt;/code&gt;; retry later.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.AddCallersToCampaignResponse addCallersToCampaign(ondewo.vtsi.CallsOuterClass.AddCallersToCampaignRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAddCallersToCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Adds scheduled callers to a campaign: each fires at or after its scheduled time AND when the campaign has a
     * free slot, and follows the campaign&amp;apos;s retries, stop and hard stop. Same atomicity, errors and rolling-update
     * behaviour as &lt;code&gt;AddCallersToCampaign&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignResponse addScheduledCallersToCampaign(ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAddScheduledCallersToCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a scheduled caller, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of another project; with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.ScheduledCaller getScheduledCaller(ondewo.vtsi.CallsOuterClass.GetScheduledCallerRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetScheduledCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the scheduled callers of a VTSI project, ordered by &lt;code&gt;scheduled_time&lt;/code&gt;, oldest first,
     * optionally narrowed by state, campaign and a &lt;code&gt;scheduled_time&lt;/code&gt; window. Paging,
     * &lt;code&gt;total_size&lt;/code&gt; and errors as for &lt;code&gt;ListCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.ListScheduledCallersResponse listScheduledCallers(ondewo.vtsi.CallsOuterClass.ListScheduledCallersRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListScheduledCallersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Changes the &lt;code&gt;scheduled_time&lt;/code&gt; and/or the &lt;code&gt;sip_caller_config.sip_headers&lt;/code&gt; of a scheduled
     * caller that has not fired yet; the only updatable &lt;code&gt;update_mask&lt;/code&gt; paths (see
     * &lt;code&gt;UpdateScheduledCallerRequest.update_mask&lt;/code&gt;). Allowed only while the status is
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_PENDING&lt;/code&gt;; for a scheduled caller of a campaign only while its campaign call
     * is &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; (a retry of a campaign call is timed by the campaign&amp;apos;s
     * &lt;code&gt;retry_delay&lt;/code&gt;). The check and the write are one atomic step, so a scheduled caller that fires
     * concurrently is either updated before it fires or refused. Updating to the stored values is accepted and
     * changes nothing.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, an empty
     * &lt;code&gt;update_mask&lt;/code&gt;, a path that is not updatable, an unset &lt;code&gt;scheduled_time&lt;/code&gt; named by the
     * mask, invalid &lt;code&gt;sip_headers&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path (each naming the path);
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of another project;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when it is no longer PENDING (&lt;code&gt;reason=not-pending&lt;/code&gt;) or its campaign
     * call has started (&lt;code&gt;reason=campaign-call-started&lt;/code&gt;); with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_UPDATED&lt;/code&gt; when something changed.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.ScheduledCaller updateScheduledCaller(ondewo.vtsi.CallsOuterClass.UpdateScheduledCallerRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateScheduledCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Cancels a scheduled caller that has not fired yet: a PENDING scheduled caller becomes
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_CANCELLED&lt;/code&gt; and never fires. A scheduled caller that is no longer PENDING
     * (firing, done, failed or already cancelled) is not an error: the response says &lt;code&gt;cancelled = false&lt;/code&gt;
     * and carries its current &lt;code&gt;status&lt;/code&gt;, so cancelling is idempotent.&lt;/p&gt;
     * &lt;p&gt;A scheduled caller of a campaign can be cancelled while its campaign call is
     * &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; or &lt;code&gt;CAMPAIGN_CALL_STATE_RETRY_PENDING&lt;/code&gt;;
     * the campaign call then becomes &lt;code&gt;CAMPAIGN_CALL_STATE_CANCELLED&lt;/code&gt;. While an attempt is
     * &lt;code&gt;DISPATCHING&lt;/code&gt; or &lt;code&gt;IN_PROGRESS&lt;/code&gt; the request is refused:
     * &lt;code&gt;cancelled = false&lt;/code&gt;, an &lt;code&gt;error_message&lt;/code&gt; saying why, and the scheduled caller keeps its
     * status.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of
     * another project; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CANCELLED&lt;/code&gt;, only when &lt;code&gt;cancelled = true&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.CancelScheduledCallerResponse cancelScheduledCaller(ondewo.vtsi.CallsOuterClass.CancelScheduledCallerRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCancelScheduledCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Cancels several scheduled callers, each like &lt;code&gt;CancelScheduledCaller&lt;/code&gt;, at most 1000. Not atomic:
     * every entry is applied on its own and reported in &lt;code&gt;CancelScheduledCallersResponse&lt;/code&gt;, in request
     * order; a failed entry carries an &lt;code&gt;error_message&lt;/code&gt; prefixed with the gRPC status code name
     * &lt;code&gt;CancelScheduledCaller&lt;/code&gt; would have answered (e.g. &lt;code&gt;NOT_FOUND: ...&lt;/code&gt;) and does not stop
     * the others. Errors of the request as a whole (see &lt;code&gt;CancelScheduledCallersRequest&lt;/code&gt;) are gRPC status
     * codes, and then nothing is cancelled.&lt;/p&gt;
     * &lt;p&gt;Events: one &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CANCELLED&lt;/code&gt; per entry with &lt;code&gt;cancelled = true&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;CancelScheduledCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.CancelScheduledCallersResponse cancelScheduledCallers(ondewo.vtsi.CallsOuterClass.CancelScheduledCallersRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCancelScheduledCallersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Retries a FAILED scheduled caller by creating a NEW scheduled caller from its stored request: the same
     * &lt;code&gt;sip_caller_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt;, &lt;code&gt;status = PENDING&lt;/code&gt;, the
     * &lt;code&gt;scheduled_time&lt;/code&gt; of the request (unset: now), and &lt;code&gt;retry_of_scheduled_caller_name&lt;/code&gt; naming
     * the failed one, whose &lt;code&gt;retried_by_scheduled_caller_name&lt;/code&gt; is set to the new one in the same atomic
     * step. The failed scheduled caller itself is not changed otherwise, so its &lt;code&gt;error_message&lt;/code&gt; and
     * &lt;code&gt;fired_at&lt;/code&gt; stay as the history of the failed attempt. Returns the new scheduled caller.&lt;/p&gt;
     * &lt;p&gt;Idempotency: a FAILED scheduled caller is retried at most once. A repeat of the request answers
     * &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; naming the retry in its message (read
     * &lt;code&gt;retried_by_scheduled_caller_name&lt;/code&gt;); to retry again after the retry failed too, retry the new
     * one.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of
     * another project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a scheduled caller that is not
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_FAILED&lt;/code&gt; (&lt;code&gt;reason=not-failed&lt;/code&gt;) or that belongs to a campaign
     * (&lt;code&gt;reason=campaign-scheduled-caller&lt;/code&gt;: a campaign call is retried by the campaign&amp;apos;s
     * &lt;code&gt;max_attempts&lt;/code&gt;); &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when it was already retried;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the project reached its caller limit; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CREATED&lt;/code&gt; for the new scheduled caller.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.ScheduledCaller retryScheduledCaller(ondewo.vtsi.CallsOuterClass.RetryScheduledCallerRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRetryScheduledCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a call: hangs it up if it is still active and stops (releases) the listener or caller that serves
     * it, like &lt;code&gt;StopCaller&lt;/code&gt; / &lt;code&gt;StopListener&lt;/code&gt;. A call that already ended is not an error: its
     * listener or caller is still released if it is deployed, and when there was nothing left to release the
     * response carries &lt;code&gt;error_message = Call ... was not released&lt;/code&gt;, so a repeat succeeds with that
     * message.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or call, or a call of another
     * project; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt;, and &lt;code&gt;VTSI_EVENT_CALLER_STOPPED&lt;/code&gt; /
     * &lt;code&gt;VTSI_EVENT_LISTENER_STOPPED&lt;/code&gt; for the released resource.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StopCallResponse stopCall(ondewo.vtsi.CallsOuterClass.StopCallRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStopCallMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops several calls of one project, each like &lt;code&gt;StopCall&lt;/code&gt;, at most 1000 distinct names. Not
     * atomic: every call is stopped on its own and reported in its own entry, in request order; a failed entry
     * carries an &lt;code&gt;error_message&lt;/code&gt; prefixed with the gRPC status code name &lt;code&gt;StopCall&lt;/code&gt; would have
     * answered and does not stop the others. No entry, more than 1000 names or a malformed
     * &lt;code&gt;vtsi_project_name&lt;/code&gt; is &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, an unknown project &lt;code&gt;NOT_FOUND&lt;/code&gt;, and
     * then nothing is stopped.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StopCall&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StopCallsResponse stopCalls(ondewo.vtsi.CallsOuterClass.StopCallsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStopCallsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops every call of a VTSI project (listener and caller calls alike), or, with
     * &lt;code&gt;call_filter&lt;/code&gt;, those it matches, each like &lt;code&gt;StopCall&lt;/code&gt;. Not atomic and not bounded in
     * size; a project with nothing to stop answers an empty response, so the RPC is idempotent. If a stop fails
     * part-way, the remaining calls are still stopped one by one and every call gets its own entry.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, an invalid &lt;code&gt;call_filter&lt;/code&gt; or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or campaign; with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StopCallsResponse stopAllCalls(ondewo.vtsi.CallsOuterClass.StopAllCallsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStopAllCallsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Transfer a call to a phone number, a softphone account, another listener or the listener queue.&lt;/p&gt;
     * &lt;p&gt;The target is either the typed &lt;code&gt;target&lt;/code&gt; or the legacy raw &lt;code&gt;transfer_id&lt;/code&gt;, never both. It is
     * resolved and validated before anything is sent; an invalid target is answered with
     * &lt;code&gt;TRANSFER_OUTCOME_TARGET_INVALID&lt;/code&gt; and an &lt;code&gt;error_reason&lt;/code&gt;, and the call is untouched.&lt;/p&gt;
     * &lt;p&gt;&lt;code&gt;TRANSFER_MODE_BLIND&lt;/code&gt; (default) sends a SIP REFER and reports its outcome: a refused REFER keeps the
     * call with the bot. &lt;code&gt;TRANSFER_MODE_WARM&lt;/code&gt; rings the target into the call first, and the bot leaves only
     * after the target joined (Asterisk 22 only).&lt;/p&gt;
     * &lt;p&gt;Telephony outcomes (busy, no answer, REFER rejected) are successful RPCs carrying an &lt;code&gt;outcome&lt;/code&gt;.
     * Refusals before any side effect also return a gRPC status with &lt;code&gt;reason=&amp;lt;token&amp;gt;&lt;/code&gt; in its details:
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; (both targets set, malformed target), &lt;code&gt;NOT_FOUND&lt;/code&gt; (call or target not
     * found, including another project&amp;apos;s), &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; (&lt;code&gt;call-not-connected&lt;/code&gt;,
     * &lt;code&gt;amd-in-progress&lt;/code&gt;, &lt;code&gt;call-not-yet-identified&lt;/code&gt;, &lt;code&gt;participants-present&lt;/code&gt;,
     * &lt;code&gt;asterisk-version-unsupported&lt;/code&gt;, &lt;code&gt;sip-image-too-old&lt;/code&gt;), &lt;code&gt;ABORTED&lt;/code&gt;
     * (&lt;code&gt;transfer-in-progress&lt;/code&gt;), &lt;code&gt;UNAVAILABLE&lt;/code&gt; (&lt;code&gt;sip-unreachable&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.TransferCallResponse transferCall(ondewo.vtsi.CallsOuterClass.TransferCallRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getTransferCallMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Transfer several calls, each like &lt;code&gt;TransferCall&lt;/code&gt;, at most 1000. Not atomic: every transfer is
     * run on its own and reported in its own entry, in request order; an entry &lt;code&gt;TransferCall&lt;/code&gt; would have
     * refused with a gRPC status carries that refusal in its &lt;code&gt;error_message&lt;/code&gt; (prefixed with the status
     * code name) and does not stop the others. Idempotent per entry &lt;code&gt;request_id&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.TransferCallsResponse transferCalls(ondewo.vtsi.CallsOuterClass.TransferCallsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getTransferCallsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a call, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt; (the call&amp;apos;s log
     * lines are read with &lt;code&gt;Logs.ListCallLogs&lt;/code&gt;). &lt;code&gt;FULL&lt;/code&gt; also returns every participant ever
     * invited into the call (see &lt;code&gt;Call.participants&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or call, or a call of another project; with authorization
     * enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.Call getCall(ondewo.vtsi.CallsOuterClass.GetCallRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetCallMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the calls of a VTSI project, ended ones included, narrowed by &lt;code&gt;call_filter&lt;/code&gt;, ordered by
     * &lt;code&gt;call_sorting&lt;/code&gt; (default: by &lt;code&gt;start_time&lt;/code&gt;, oldest first) and paged with
     * &lt;code&gt;page_size&lt;/code&gt; / &lt;code&gt;page_token&lt;/code&gt;; &lt;code&gt;total_size&lt;/code&gt; counts every match.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;call_filter.campaign_name&lt;/code&gt; or &lt;code&gt;call_filter.campaign_display_name&lt;/code&gt; set, lists
     * only the calls of that campaign: the calls placed by the attempts of its campaign calls.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, an invalid filter, a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a &lt;code&gt;page_token&lt;/code&gt; of another listing or an unknown &lt;code&gt;field_mask&lt;/code&gt;
     * path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or campaign; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.ListCallsResponse listCalls(ondewo.vtsi.CallsOuterClass.ListCallsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListCallsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Aggregate figures (totals, active calls, counts by SIP status type, by call type, by AMD verdict and by
     * transfer outcome, durations, redial recommendations) over the calls of a VTSI project that
     * &lt;code&gt;call_filter&lt;/code&gt; matches; see &lt;code&gt;CallStatistics&lt;/code&gt;. Read only, no side effect.&lt;/p&gt;
     * &lt;p&gt;Errors: as for &lt;code&gt;ListCalls&lt;/code&gt; (an invalid filter is &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, an unknown project
     * or campaign &lt;code&gt;NOT_FOUND&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;ListCalls&lt;/code&gt; (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.CallStatistics getCallStatistics(ondewo.vtsi.CallsOuterClass.GetCallStatisticsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetCallStatisticsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the descriptive metadata of a call: the only updatable &lt;code&gt;update_mask&lt;/code&gt; path is
     * &lt;code&gt;labels&lt;/code&gt;. Allowed on active and ended calls. Refused for the WAITING call of a persistent
     * listener or a pooled caller (status &lt;code&gt;NO_ONGOING_CALL&lt;/code&gt;, not active: the record that waits for the
     * next call, which &lt;code&gt;ListCalls&lt;/code&gt; returns too) with &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; and
     * &lt;code&gt;reason=call-not-started&lt;/code&gt; in the details: label the call once it has started. It changes only
     * the stored call record: the live call, its SIP container, its status and its media are never touched, and
     * nothing is sent to the call. Idempotent: writing the stored labels again changes nothing.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_UPDATED&lt;/code&gt; when the labels changed.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;call.name&lt;/code&gt;, an
     * empty &lt;code&gt;update_mask&lt;/code&gt;, any path other than &lt;code&gt;labels&lt;/code&gt; (every other field of a
     * &lt;code&gt;Call&lt;/code&gt; is output only), a path below &lt;code&gt;labels&lt;/code&gt;, labels outside the bounds of
     * &lt;code&gt;Call.labels&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path (each naming the path or label);
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown call or project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;
     * (&lt;code&gt;reason=call-not-started&lt;/code&gt;) for a waiting call; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; for a project the caller holds no role on.&lt;/p&gt;
     * &lt;p&gt;Authorization: the role that may stop calls of the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or
     * higher).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.UpdateCallResponse updateCall(ondewo.vtsi.CallsOuterClass.UpdateCallRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateCallMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates several calls, each like &lt;code&gt;UpdateCall&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;UpdateCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;UpdateCall&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.UpdateCallsResponse updateCalls(ondewo.vtsi.CallsOuterClass.UpdateCallsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateCallsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the status of the callers of a project: a snapshot first
     * (&lt;code&gt;snapshot = true&lt;/code&gt;), then every caller whose call or SIP status changed, plus
     * keep-alive messages. Ends when the client disconnects or at the server-side maximum stream
     * duration.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when
     * the server has no free stream slot.&lt;/p&gt;
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse>
        streamCallerStatus(ondewo.vtsi.CallsOuterClass.StreamCallerStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getStreamCallerStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the status of the listeners of a project, like &lt;code&gt;StreamCallerStatus&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse>
        streamListenerStatus(ondewo.vtsi.CallsOuterClass.StreamListenerStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getStreamListenerStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the status of the scheduled callers of a project, like
     * &lt;code&gt;StreamCallerStatus&lt;/code&gt;. The snapshot holds every PENDING and FIRING scheduled caller
     * and those that finished in the last hour.&lt;/p&gt;
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse>
        streamScheduledCallerStatus(ondewo.vtsi.CallsOuterClass.StreamScheduledCallerStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getStreamScheduledCallerStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Invite a registered softphone account of the project into a connected call. Returns the participant in
     * &lt;code&gt;PARTICIPANT_STATE_RINGING&lt;/code&gt;; follow &lt;code&gt;Call.participants&lt;/code&gt; or the events
     * &lt;code&gt;VTSI_EVENT_CALL_PARTICIPANT_*&lt;/code&gt; for JOINED, FAILED and LEFT.&lt;/p&gt;
     * &lt;p&gt;&lt;code&gt;PARTICIPANT_MODE_CONFERENCE&lt;/code&gt; (default) joins the softphone into the call: Asterisk mixes the caller,
     * the bot and the participant, and by default the bot keeps talking and listening
     * (&lt;code&gt;BOT_POLICY_ON_JOIN_KEEP&lt;/code&gt;). &lt;code&gt;PARTICIPANT_MODE_MONITOR&lt;/code&gt; lets the participant listen only.
     * When the bot&amp;apos;s leg ends, every participant is hung up; the caller is handed over only by a WARM
     * &lt;code&gt;TransferCall&lt;/code&gt;. Idempotent per &lt;code&gt;request_id&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, &lt;code&gt;NOT_FOUND&lt;/code&gt; (call or softphone account, including another
     * project&amp;apos;s), &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; (&lt;code&gt;call-not-connected&lt;/code&gt;, &lt;code&gt;amd-in-progress&lt;/code&gt;,
     * &lt;code&gt;softphone-not-registered&lt;/code&gt;, &lt;code&gt;softphone-disabled&lt;/code&gt;, &lt;code&gt;softphone-unrouted&lt;/code&gt;,
     * &lt;code&gt;call-not-yet-identified&lt;/code&gt;, &lt;code&gt;bot-channel-ambiguous&lt;/code&gt;, &lt;code&gt;asterisk-not-local&lt;/code&gt;,
     * &lt;code&gt;asterisk-version-unsupported&lt;/code&gt;), &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; (the softphone is already ringing or joined),
     * &lt;code&gt;ABORTED&lt;/code&gt; (&lt;code&gt;transfer-in-progress&lt;/code&gt;), &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; (participant cap),
     * &lt;code&gt;UNAVAILABLE&lt;/code&gt; (&lt;code&gt;asterisk-unreachable&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.InviteToCallResponse inviteToCall(ondewo.vtsi.CallsOuterClass.InviteToCallRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getInviteToCallMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Hang up a participant of a call (ringing or joined). The participant ends as
     * &lt;code&gt;PARTICIPANT_STATE_LEFT&lt;/code&gt; with &lt;code&gt;end_reason = REMOVED&lt;/code&gt;; the call and the bot are not
     * affected. Returns the participant after the request.&lt;/p&gt;
     * &lt;p&gt;Idempotent: a participant that already FAILED or LEFT (for whatever reason) is returned unchanged with OK,
     * and nothing is sent.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request; &lt;code&gt;NOT_FOUND&lt;/code&gt; with
     * &lt;code&gt;reason=call-not-found&lt;/code&gt; for an unknown call or a call of another project, and with
     * &lt;code&gt;reason=participant-not-found&lt;/code&gt; for an unknown &lt;code&gt;participant_id&lt;/code&gt; or a participant of
     * another call; &lt;code&gt;ABORTED&lt;/code&gt; with &lt;code&gt;reason=call-control-busy&lt;/code&gt; while another call-control
     * request for the call runs (retry); &lt;code&gt;UNAVAILABLE&lt;/code&gt; with &lt;code&gt;reason=asterisk-unreachable&lt;/code&gt; when
     * the hang-up could not be sent; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_PARTICIPANT_LEFT&lt;/code&gt; (or &lt;code&gt;VTSI_EVENT_CALL_PARTICIPANT_FAILED&lt;/code&gt;
     * for a participant that was still ringing).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher. Audited like &lt;code&gt;InviteToCall&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.RemoveCallParticipantResponse removeCallParticipant(ondewo.vtsi.CallsOuterClass.RemoveCallParticipantRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRemoveCallParticipantMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Mute the bot of a connected call and/or stop it listening to the caller, or undo either. Every request sets a
     * desired level and never toggles: a repeat answers &lt;code&gt;changed = false&lt;/code&gt;. The bot stays muted while
     * anything else (a TALK take-over of &lt;code&gt;StreamCallAudio&lt;/code&gt;, a participant bot policy) also holds it muted.&lt;/p&gt;
     * &lt;p&gt;Both settings &lt;code&gt;CALL_MEDIA_SETTING_UNCHANGED&lt;/code&gt; is a valid read of the current state: it answers
     * the effective &lt;code&gt;state&lt;/code&gt; with &lt;code&gt;changed = false&lt;/code&gt;, changes nothing, and writes no audit record
     * and no event (see &lt;code&gt;SetCallMediaControlRequest.bot_voice&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_BOT_MUTED&lt;/code&gt; / &lt;code&gt;VTSI_EVENT_CALL_BOT_UNMUTED&lt;/code&gt; /
     * &lt;code&gt;VTSI_EVENT_CALL_LISTENING_PAUSED&lt;/code&gt; / &lt;code&gt;VTSI_EVENT_CALL_LISTENING_RESUMED&lt;/code&gt; when the
     * effective state changed.&lt;/p&gt;
     * &lt;p&gt;Errors as for &lt;code&gt;InviteToCall&lt;/code&gt;, plus &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=sip-image-too-old&lt;/code&gt;,
     * &lt;code&gt;ABORTED&lt;/code&gt; &lt;code&gt;reason=call-control-busy&lt;/code&gt; (another call-control request for the call is running)
     * and &lt;code&gt;UNAVAILABLE&lt;/code&gt; &lt;code&gt;reason=sip-unreachable&lt;/code&gt; or &lt;code&gt;reason=csi-media-control-failed&lt;/code&gt; (the
     * bot did not apply the level: a requested pause is rolled back, a requested mute is kept).&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.SetCallMediaControlResponse setCallMediaControl(ondewo.vtsi.CallsOuterClass.SetCallMediaControlRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetCallMediaControlMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Live audio of a connected call, both ways. The first request MUST be &lt;code&gt;config&lt;/code&gt; (within 2 seconds).
     * LISTEN receives the caller mixed with the bot. TALK sends the agent&amp;apos;s audio to the caller and REQUIRES
     * &lt;code&gt;take_over&lt;/code&gt;: the bot is muted and does not listen while the stream is connected, and resumes when it
     * ends; in TALK the agent hears the caller only. Audio is LINEAR16 little-endian mono in 20 ms frames.&lt;/p&gt;
     * &lt;p&gt;Bidirectional streaming: available to native gRPC clients (python, nodejs) only. Browser (grpc-web) clients
     * use &lt;code&gt;ListenCallAudio&lt;/code&gt;, plus a softphone (&lt;code&gt;InviteToCall&lt;/code&gt;) to talk.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; (no or invalid &lt;code&gt;config&lt;/code&gt;, TALK without
     * &lt;code&gt;take_over&lt;/code&gt;, wrong frame size), &lt;code&gt;NOT_FOUND&lt;/code&gt;, &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;
     * (&lt;code&gt;call-not-connected&lt;/code&gt;, &lt;code&gt;amd-in-progress&lt;/code&gt;, &lt;code&gt;call-not-yet-identified&lt;/code&gt;,
     * &lt;code&gt;bot-still-speaking&lt;/code&gt;, &lt;code&gt;sip-image-too-old&lt;/code&gt;), &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; (stream cap, a
     * second TALK). A normal end sends one &lt;code&gt;ended&lt;/code&gt; message, then OK. A second &lt;code&gt;config&lt;/code&gt; or audio
     * sent in LISTEN mode ends the stream with &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;. A client half-close ends the stream
     * (&lt;code&gt;CALL_AUDIO_END_REASON_CLIENT_CLOSED&lt;/code&gt;), so a listening client keeps its request stream open.&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<ondewo.vtsi.CallsOuterClass.StreamCallAudioRequest, ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse>
        streamCallAudio() {
      return io.grpc.stub.ClientCalls.blockingBidiStreamingCall(
          getChannel(), getStreamCallAudioMethod(), getCallOptions());
    }

    /**
     * <pre>
     * &lt;p&gt;Listen-only live audio of a connected call, like &lt;code&gt;StreamCallAudio&lt;/code&gt; in LISTEN mode, as a server
     * stream that grpc-web (browser) clients can consume. &lt;code&gt;config.mode&lt;/code&gt; must be LISTEN or unspecified and
     * &lt;code&gt;config.take_over&lt;/code&gt; must be false, otherwise &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; &lt;code&gt;reason=listen-only&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse>
        listenCallAudio(ondewo.vtsi.CallsOuterClass.ListenCallAudioRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getListenCallAudioMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Calls.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public static final class CallsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CallsBlockingStub> {
    private CallsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CallsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CallsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts one caller in a VTSI project: an ondewo-sip container that places one outbound call to
     * &lt;code&gt;sip_caller_config.callee_id&lt;/code&gt; (or a pooled caller of the server&amp;apos;s caller pool that runs the same
     * configuration). The configuration is validated first, including live checks against the upstream services;
     * nothing is started when it fails. Not idempotent: every successful request places a new call (send it as a
     * batch of one with an &lt;code&gt;idempotency_key&lt;/code&gt; to make it idempotent). &lt;code&gt;validate_only&lt;/code&gt; runs the
     * validation alone.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed or invalid request or
     * configuration (also when the NLU credentials are refused) or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when an upstream config lacks
     * the required TLS certificate (&lt;code&gt;UPSTREAM_TLS_REQUIRED&lt;/code&gt;) or the project is not deployed;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the project reached its caller limit; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when an
     * upstream service could not be reached; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_STARTED&lt;/code&gt; or &lt;code&gt;VTSI_EVENT_CALLER_START_FAILED&lt;/code&gt;, then the
     * events of the call (&lt;code&gt;VTSI_EVENT_CALL_*&lt;/code&gt;). None with &lt;code&gt;validate_only&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StartCallerResponse startCaller(ondewo.vtsi.CallsOuterClass.StartCallerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts several callers, each like &lt;code&gt;StartCaller&lt;/code&gt;. Not atomic: every caller is started on its own;
     * a caller that fails to start is rolled back and has no entry in the response, which accounts for it in
     * &lt;code&gt;StartCallersResponse.error_message&lt;/code&gt;. The project&amp;apos;s caller limit is checked for the batch as a
     * whole before anything is started (&lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;, nothing started). Idempotent per
     * &lt;code&gt;idempotency_key&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StartCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StartCallersResponse startCallers(ondewo.vtsi.CallsOuterClass.StartCallersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartCallersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the callers of a VTSI project, ordered by the caller&amp;apos;s uuid (the last segment of
     * &lt;code&gt;name&lt;/code&gt;), ascending: a stable order, not a chronological one. Paged with &lt;code&gt;page_size&lt;/code&gt; /
     * &lt;code&gt;page_token&lt;/code&gt;; &lt;code&gt;total_size&lt;/code&gt; counts every match.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;campaign_name&lt;/code&gt; or &lt;code&gt;campaign_display_name&lt;/code&gt; set, lists only the callers of that
     * campaign: the callers that placed at least one attempt of one of its campaign calls (see
     * &lt;code&gt;ListCallersRequest.campaign_name&lt;/code&gt;). &lt;code&gt;active_only&lt;/code&gt; and &lt;code&gt;sip_status_types&lt;/code&gt;
     * narrow the listing further.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, an invalid selector, a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a &lt;code&gt;page_token&lt;/code&gt; of another listing or an unknown &lt;code&gt;field_mask&lt;/code&gt;
     * path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or campaign; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.ListCallersResponse listCallers(ondewo.vtsi.CallsOuterClass.ListCallersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCallersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a caller, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or caller, or a caller of another project; with authorization
     * enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.Caller getCaller(ondewo.vtsi.CallsOuterClass.GetCallerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the STORED configuration of a caller: the fields named in &lt;code&gt;update_mask&lt;/code&gt;, i.e.
     * &lt;code&gt;sip_caller_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt; or any nested sub-path of them.
     * Allowed whether or not the caller has a call running.&lt;/p&gt;
     * &lt;p&gt;A running call and its container are NEVER changed: nothing is restarted, redeployed or reconfigured,
     * and the call goes on with the configuration its container was deployed with.&lt;/p&gt;
     * &lt;p&gt;When the stored configuration takes effect: a caller is ONE call (every &lt;code&gt;StartCaller&lt;/code&gt; creates
     * a new caller carrying its own configuration, and no RPC redeploys an existing one), so for a caller that
     * is not pooled the update changes ONLY the stored and returned configuration and never any present or
     * future call. The one case in which the server deploys a container from a caller&amp;apos;s stored
     * configuration is a POOLED (persistent) caller, which the server keeps warm between calls: when the server
     * recycles the pooled callers of a project onto its Asterisk (an &lt;code&gt;UpdateVtsiProject&lt;/code&gt; of a
     * deployed project, the recovery after the project&amp;apos;s Asterisk restarted, a change of the project&amp;apos;s
     * TLS trust anchor), the pooled caller it starts in place of this one is deployed from the stored, i.e.
     * updated, configuration. An in-place restart of a pooled caller&amp;apos;s container (the call monitor&amp;apos;s
     * health recovery) keeps the configuration the container was deployed with. Until it is recycled, an idle
     * pooled caller is matched to later &lt;code&gt;StartCaller&lt;/code&gt; requests by the configuration its container
     * RUNS, never by an updated stored configuration it does not run.&lt;/p&gt;
     * &lt;p&gt;Updating a caller never changes a campaign: the attempts of a campaign call take their configuration
     * from the campaign and the campaign call, never from a &lt;code&gt;Caller&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;A STOPPED caller (its call ended and its configuration was released) has no stored configuration left:
     * the update starts from an empty one, so it must state a complete configuration
     * (&lt;code&gt;sip_caller_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt;), and a partial one is refused as a
     * configuration a &lt;code&gt;StartCallerRequest&lt;/code&gt; would be refused for. Nothing is deployed.&lt;/p&gt;
     * &lt;p&gt;Credentials follow their endpoint: an update that MOVES an upstream (the &lt;code&gt;host&lt;/code&gt;,
     * &lt;code&gt;port&lt;/code&gt; or &lt;code&gt;grpc_cert&lt;/code&gt; of the NLU, S2T or T2S &lt;code&gt;*_base_config&lt;/code&gt;, or the
     * &lt;code&gt;host&lt;/code&gt; / ports of &lt;code&gt;csi_vtsi_config.message_broker_config.rabbit_mq_config&lt;/code&gt;) must
     * also write every credential path of that upstream that holds a stored value -- the NLU
     * &lt;code&gt;credentials&lt;/code&gt;, &lt;code&gt;auth_token&lt;/code&gt;, &lt;code&gt;http_basic_auth_token&lt;/code&gt; and
     * &lt;code&gt;contexts&lt;/code&gt;, the S2T &lt;code&gt;s2t_transcribe_request_config&lt;/code&gt;, the T2S
     * &lt;code&gt;t2s_request_config&lt;/code&gt;, the RabbitMQ &lt;code&gt;user&lt;/code&gt; and &lt;code&gt;password&lt;/code&gt; -- named itself
     * or by a shorter path, with the values to use. A stored credential is never sent to an endpoint the request
     * moved without restating it, also not for the live validation of the result.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;caller.name&lt;/code&gt;,
     * an empty &lt;code&gt;update_mask&lt;/code&gt;, an unknown, output-only or immutable &lt;code&gt;update_mask&lt;/code&gt; path, an
     * update that moves an upstream without restating its stored credentials (naming the paths to add), a
     * resulting configuration that a &lt;code&gt;StartCallerRequest&lt;/code&gt; carrying it would be refused for, or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path (each naming the path or field); &lt;code&gt;NOT_FOUND&lt;/code&gt; for an
     * unknown caller or project; &lt;code&gt;ABORTED&lt;/code&gt; when concurrent updates kept changing the caller, or while
     * an update, deploy or undeploy of its project is still running (an update waits for it, for a bounded time,
     * so that a recycle of the project cannot lose it), nothing being written (retry the request); with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; for a project the caller holds no role on.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_UPDATED&lt;/code&gt; (none with &lt;code&gt;validate_only&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: the role that may start and stop callers of the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;
     * or higher).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.UpdateCallerResponse updateCaller(ondewo.vtsi.CallsOuterClass.UpdateCallerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates several callers, each like &lt;code&gt;UpdateCaller&lt;/code&gt;. Not atomic: every entry is applied on its
     * own and reported in &lt;code&gt;UpdateCallersResponse.update_caller_responses&lt;/code&gt;, in request order; an entry
     * that fails changes nothing and does not stop the others. Errors of the request as a whole (see
     * &lt;code&gt;UpdateCallersRequest&lt;/code&gt;) are gRPC status codes, and then no entry is applied.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;UpdateCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.UpdateCallersResponse updateCallers(ondewo.vtsi.CallsOuterClass.UpdateCallersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCallersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a caller: stops it if it still runs (hanging up its call) and removes it, so it is no longer
     * listed or returned. Its call records (and their participants) are deleted with it and are no longer returned
     * by &lt;code&gt;GetCall&lt;/code&gt; / &lt;code&gt;ListCalls&lt;/code&gt;; stop it instead to keep them.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown caller, a caller of another project, or a
     * caller that was already deleted (so deleting is NOT idempotent: a repeat answers &lt;code&gt;NOT_FOUND&lt;/code&gt;);
     * with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_DELETED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.DeleteCallerResponse deleteCaller(ondewo.vtsi.CallsOuterClass.DeleteCallerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes several callers, each like &lt;code&gt;DeleteCaller&lt;/code&gt;. Not atomic: every caller is deleted on its own
     * and reported in its own entry, whose &lt;code&gt;error_message&lt;/code&gt; carries the gRPC status code name
     * &lt;code&gt;DeleteCaller&lt;/code&gt; would have answered (e.g. &lt;code&gt;NOT_FOUND: ...&lt;/code&gt;); an entry that fails does not
     * stop the others. The request as a whole is refused, nothing being deleted, for no entry or more than 1000
     * distinct names, and, when &lt;code&gt;vtsi_project_name&lt;/code&gt; is set, as described there.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;DeleteCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.DeleteCallersResponse deleteCallers(ondewo.vtsi.CallsOuterClass.DeleteCallersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCallersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a caller: hangs up its call if one is up and releases its container and SIP account. The caller
     * stays listed (with &lt;code&gt;active = false&lt;/code&gt;) until it is deleted, and its stored configuration stays
     * updatable (see &lt;code&gt;UpdateCaller&lt;/code&gt;). A pooled caller is taken out of the pool.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown caller, a caller of another project, or a
     * caller that is already stopped (so stopping is NOT idempotent: a repeat answers &lt;code&gt;NOT_FOUND&lt;/code&gt;); with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_STOPPED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StopCallerResponse stopCaller(ondewo.vtsi.CallsOuterClass.StopCallerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops several callers, each like &lt;code&gt;StopCaller&lt;/code&gt;, with the per-entry results and the request-level
     * errors of &lt;code&gt;DeleteCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StopCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StopCallersResponse stopCallers(ondewo.vtsi.CallsOuterClass.StopCallersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopCallersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts one listener in a VTSI project: an ondewo-sip container registered on the project&amp;apos;s Asterisk
     * that answers inbound calls, one after the other (persistent). Validation, &lt;code&gt;validate_only&lt;/code&gt;, errors
     * (&lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; for the project&amp;apos;s listener limit) and idempotency as for
     * &lt;code&gt;StartCaller&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_STARTED&lt;/code&gt; or &lt;code&gt;VTSI_EVENT_LISTENER_START_FAILED&lt;/code&gt;. None with
     * &lt;code&gt;validate_only&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StartListenerResponse startListener(ondewo.vtsi.CallsOuterClass.StartListenerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartListenerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts several listeners, each like &lt;code&gt;StartListener&lt;/code&gt;, with the batch semantics of
     * &lt;code&gt;StartCallers&lt;/code&gt; (a listener that fails to start has no entry and is accounted for in
     * &lt;code&gt;StartListenersResponse.error_message&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StartListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StartListenersResponse startListeners(ondewo.vtsi.CallsOuterClass.StartListenersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartListenersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a listener: hangs up its call if one is up and releases its container and SIP account. A stopped
     * listener has no stored configuration left (see &lt;code&gt;UpdateListener&lt;/code&gt;). Errors and idempotency as for
     * &lt;code&gt;StopCaller&lt;/code&gt; (a listener that is already stopped is &lt;code&gt;NOT_FOUND&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_STOPPED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StopListenerResponse stopListener(ondewo.vtsi.CallsOuterClass.StopListenerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopListenerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops several listeners, each like &lt;code&gt;StopListener&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;DeleteCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StopListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StopListenersResponse stopListeners(ondewo.vtsi.CallsOuterClass.StopListenersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopListenersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the listeners of a VTSI project, ordered by the listener&amp;apos;s uuid (the last segment of
     * &lt;code&gt;name&lt;/code&gt;), ascending. Paging, &lt;code&gt;total_size&lt;/code&gt;, filters and errors as for
     * &lt;code&gt;ListCallers&lt;/code&gt; (without a campaign selector).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.ListListenersResponse listListeners(ondewo.vtsi.CallsOuterClass.ListListenersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListListenersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a listener, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt;. Errors as for
     * &lt;code&gt;GetCaller&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.Listener getListener(ondewo.vtsi.CallsOuterClass.GetListenerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetListenerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the STORED configuration of a listener: the fields named in &lt;code&gt;update_mask&lt;/code&gt;, i.e.
     * &lt;code&gt;sip_base_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt; or any nested sub-path of them.
     * Allowed whether or not the listener&amp;apos;s container is running or has a call, as long as the listener is
     * DEPLOYED: a stopped listener has no stored configuration (it is deployed again only by a
     * &lt;code&gt;StartListener&lt;/code&gt; carrying a complete one) and is &lt;code&gt;NOT_FOUND&lt;/code&gt;, unlike a stopped caller,
     * which &lt;code&gt;UpdateCaller&lt;/code&gt; accepts with a complete configuration.&lt;/p&gt;
     * &lt;p&gt;A running container and every call it takes are NEVER changed: nothing is restarted, redeployed or
     * reconfigured, and the running container answers its calls with the configuration it was deployed with
     * until it is replaced.&lt;/p&gt;
     * &lt;p&gt;When the stored configuration takes effect: only when the server RECREATES the listener from it, i.e.
     * when it recycles the listeners of the project onto its Asterisk: an &lt;code&gt;UpdateVtsiProject&lt;/code&gt; of a
     * deployed project, the recovery after the project&amp;apos;s Asterisk restarted, or a change of the
     * project&amp;apos;s TLS trust anchor. The listener the server starts in place of this one is deployed from the
     * stored, i.e. updated, configuration. An in-place restart of the listener&amp;apos;s container (the
     * server&amp;apos;s restore of listener containers when it starts, the call monitor&amp;apos;s restart of an
     * unhealthy container, a &lt;code&gt;docker restart&lt;/code&gt;) keeps the configuration the container was deployed
     * with. A listener that is never recycled keeps the update only as its stored (and returned)
     * configuration.&lt;/p&gt;
     * &lt;p&gt;Errors as for &lt;code&gt;UpdateCaller&lt;/code&gt; (the credential rule included), with
     * &lt;code&gt;StartListenerRequest&lt;/code&gt; as the validation of the resulting configuration, and
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; also for a stopped listener.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_UPDATED&lt;/code&gt; (none with &lt;code&gt;validate_only&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: the role that may start and stop listeners of the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;
     * or higher).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.UpdateListenerResponse updateListener(ondewo.vtsi.CallsOuterClass.UpdateListenerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateListenerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates several listeners, each like &lt;code&gt;UpdateListener&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;UpdateCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;UpdateListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.UpdateListenersResponse updateListeners(ondewo.vtsi.CallsOuterClass.UpdateListenersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateListenersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a listener: stops it if it still runs (hanging up its call) and removes it, with its call
     * records, like &lt;code&gt;DeleteCaller&lt;/code&gt;. Errors and idempotency as for &lt;code&gt;DeleteCaller&lt;/code&gt; (a repeat
     * answers &lt;code&gt;NOT_FOUND&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_DELETED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.DeleteListenerResponse deleteListener(ondewo.vtsi.CallsOuterClass.DeleteListenerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteListenerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes several listeners, each like &lt;code&gt;DeleteListener&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;DeleteCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;DeleteListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.DeleteListenersResponse deleteListeners(ondewo.vtsi.CallsOuterClass.DeleteListenersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteListenersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a scheduled caller: a caller that the server starts at or after &lt;code&gt;scheduled_time&lt;/code&gt;, like a
     * &lt;code&gt;StartCaller&lt;/code&gt; of the stored request. The request is checked structurally now; the live checks of
     * the configuration run when it fires, and a failure then leaves the scheduled caller
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_FAILED&lt;/code&gt; with its &lt;code&gt;error_message&lt;/code&gt;. A &lt;code&gt;scheduled_time&lt;/code&gt; in
     * the past is due at once. Not idempotent (use &lt;code&gt;StartScheduledCallers&lt;/code&gt; with an
     * &lt;code&gt;idempotency_key&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, a missing
     * &lt;code&gt;scheduled_time&lt;/code&gt;, a nested request with its own &lt;code&gt;field_mask&lt;/code&gt; or
     * &lt;code&gt;validate_only&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown
     * project; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the project reached its caller limit; with authorization
     * enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CREATED&lt;/code&gt;; later &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_FIRED&lt;/code&gt;,
     * &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_RETRY_SCHEDULED&lt;/code&gt; or &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_FAILED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StartScheduledCallerResponse startScheduledCaller(ondewo.vtsi.CallsOuterClass.StartScheduledCallerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartScheduledCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates several scheduled callers, each like &lt;code&gt;StartScheduledCaller&lt;/code&gt;, at most 1000. Not atomic: an
     * entry that fails is reported in its own &lt;code&gt;error_message&lt;/code&gt; and does not stop the others. Idempotent
     * per &lt;code&gt;idempotency_key&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StartScheduledCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StartScheduledCallersResponse startScheduledCallers(ondewo.vtsi.CallsOuterClass.StartScheduledCallersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartScheduledCallersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Adds callers to a campaign instead of starting them. The campaign then starts them, at most
     * &lt;code&gt;max_parallel_calls&lt;/code&gt; at a time. The request is atomic: either the campaign (when new), every
     * campaign call is stored, or nothing is. Errors are gRPC status codes (see &lt;code&gt;CampaignAssignment&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Rolling updates: a VTSI server that predates this RPC answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; and starts
     * nothing. Do not fall back to &lt;code&gt;StartCallers&lt;/code&gt; on &lt;code&gt;UNIMPLEMENTED&lt;/code&gt;; retry later.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.AddCallersToCampaignResponse addCallersToCampaign(ondewo.vtsi.CallsOuterClass.AddCallersToCampaignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddCallersToCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Adds scheduled callers to a campaign: each fires at or after its scheduled time AND when the campaign has a
     * free slot, and follows the campaign&amp;apos;s retries, stop and hard stop. Same atomicity, errors and rolling-update
     * behaviour as &lt;code&gt;AddCallersToCampaign&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignResponse addScheduledCallersToCampaign(ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddScheduledCallersToCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a scheduled caller, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of another project; with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.ScheduledCaller getScheduledCaller(ondewo.vtsi.CallsOuterClass.GetScheduledCallerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetScheduledCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the scheduled callers of a VTSI project, ordered by &lt;code&gt;scheduled_time&lt;/code&gt;, oldest first,
     * optionally narrowed by state, campaign and a &lt;code&gt;scheduled_time&lt;/code&gt; window. Paging,
     * &lt;code&gt;total_size&lt;/code&gt; and errors as for &lt;code&gt;ListCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.ListScheduledCallersResponse listScheduledCallers(ondewo.vtsi.CallsOuterClass.ListScheduledCallersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListScheduledCallersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Changes the &lt;code&gt;scheduled_time&lt;/code&gt; and/or the &lt;code&gt;sip_caller_config.sip_headers&lt;/code&gt; of a scheduled
     * caller that has not fired yet; the only updatable &lt;code&gt;update_mask&lt;/code&gt; paths (see
     * &lt;code&gt;UpdateScheduledCallerRequest.update_mask&lt;/code&gt;). Allowed only while the status is
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_PENDING&lt;/code&gt;; for a scheduled caller of a campaign only while its campaign call
     * is &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; (a retry of a campaign call is timed by the campaign&amp;apos;s
     * &lt;code&gt;retry_delay&lt;/code&gt;). The check and the write are one atomic step, so a scheduled caller that fires
     * concurrently is either updated before it fires or refused. Updating to the stored values is accepted and
     * changes nothing.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, an empty
     * &lt;code&gt;update_mask&lt;/code&gt;, a path that is not updatable, an unset &lt;code&gt;scheduled_time&lt;/code&gt; named by the
     * mask, invalid &lt;code&gt;sip_headers&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path (each naming the path);
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of another project;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when it is no longer PENDING (&lt;code&gt;reason=not-pending&lt;/code&gt;) or its campaign
     * call has started (&lt;code&gt;reason=campaign-call-started&lt;/code&gt;); with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_UPDATED&lt;/code&gt; when something changed.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.ScheduledCaller updateScheduledCaller(ondewo.vtsi.CallsOuterClass.UpdateScheduledCallerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateScheduledCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Cancels a scheduled caller that has not fired yet: a PENDING scheduled caller becomes
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_CANCELLED&lt;/code&gt; and never fires. A scheduled caller that is no longer PENDING
     * (firing, done, failed or already cancelled) is not an error: the response says &lt;code&gt;cancelled = false&lt;/code&gt;
     * and carries its current &lt;code&gt;status&lt;/code&gt;, so cancelling is idempotent.&lt;/p&gt;
     * &lt;p&gt;A scheduled caller of a campaign can be cancelled while its campaign call is
     * &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; or &lt;code&gt;CAMPAIGN_CALL_STATE_RETRY_PENDING&lt;/code&gt;;
     * the campaign call then becomes &lt;code&gt;CAMPAIGN_CALL_STATE_CANCELLED&lt;/code&gt;. While an attempt is
     * &lt;code&gt;DISPATCHING&lt;/code&gt; or &lt;code&gt;IN_PROGRESS&lt;/code&gt; the request is refused:
     * &lt;code&gt;cancelled = false&lt;/code&gt;, an &lt;code&gt;error_message&lt;/code&gt; saying why, and the scheduled caller keeps its
     * status.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of
     * another project; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CANCELLED&lt;/code&gt;, only when &lt;code&gt;cancelled = true&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.CancelScheduledCallerResponse cancelScheduledCaller(ondewo.vtsi.CallsOuterClass.CancelScheduledCallerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelScheduledCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Cancels several scheduled callers, each like &lt;code&gt;CancelScheduledCaller&lt;/code&gt;, at most 1000. Not atomic:
     * every entry is applied on its own and reported in &lt;code&gt;CancelScheduledCallersResponse&lt;/code&gt;, in request
     * order; a failed entry carries an &lt;code&gt;error_message&lt;/code&gt; prefixed with the gRPC status code name
     * &lt;code&gt;CancelScheduledCaller&lt;/code&gt; would have answered (e.g. &lt;code&gt;NOT_FOUND: ...&lt;/code&gt;) and does not stop
     * the others. Errors of the request as a whole (see &lt;code&gt;CancelScheduledCallersRequest&lt;/code&gt;) are gRPC status
     * codes, and then nothing is cancelled.&lt;/p&gt;
     * &lt;p&gt;Events: one &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CANCELLED&lt;/code&gt; per entry with &lt;code&gt;cancelled = true&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;CancelScheduledCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.CancelScheduledCallersResponse cancelScheduledCallers(ondewo.vtsi.CallsOuterClass.CancelScheduledCallersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelScheduledCallersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Retries a FAILED scheduled caller by creating a NEW scheduled caller from its stored request: the same
     * &lt;code&gt;sip_caller_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt;, &lt;code&gt;status = PENDING&lt;/code&gt;, the
     * &lt;code&gt;scheduled_time&lt;/code&gt; of the request (unset: now), and &lt;code&gt;retry_of_scheduled_caller_name&lt;/code&gt; naming
     * the failed one, whose &lt;code&gt;retried_by_scheduled_caller_name&lt;/code&gt; is set to the new one in the same atomic
     * step. The failed scheduled caller itself is not changed otherwise, so its &lt;code&gt;error_message&lt;/code&gt; and
     * &lt;code&gt;fired_at&lt;/code&gt; stay as the history of the failed attempt. Returns the new scheduled caller.&lt;/p&gt;
     * &lt;p&gt;Idempotency: a FAILED scheduled caller is retried at most once. A repeat of the request answers
     * &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; naming the retry in its message (read
     * &lt;code&gt;retried_by_scheduled_caller_name&lt;/code&gt;); to retry again after the retry failed too, retry the new
     * one.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of
     * another project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a scheduled caller that is not
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_FAILED&lt;/code&gt; (&lt;code&gt;reason=not-failed&lt;/code&gt;) or that belongs to a campaign
     * (&lt;code&gt;reason=campaign-scheduled-caller&lt;/code&gt;: a campaign call is retried by the campaign&amp;apos;s
     * &lt;code&gt;max_attempts&lt;/code&gt;); &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when it was already retried;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the project reached its caller limit; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CREATED&lt;/code&gt; for the new scheduled caller.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.ScheduledCaller retryScheduledCaller(ondewo.vtsi.CallsOuterClass.RetryScheduledCallerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetryScheduledCallerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a call: hangs it up if it is still active and stops (releases) the listener or caller that serves
     * it, like &lt;code&gt;StopCaller&lt;/code&gt; / &lt;code&gt;StopListener&lt;/code&gt;. A call that already ended is not an error: its
     * listener or caller is still released if it is deployed, and when there was nothing left to release the
     * response carries &lt;code&gt;error_message = Call ... was not released&lt;/code&gt;, so a repeat succeeds with that
     * message.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or call, or a call of another
     * project; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt;, and &lt;code&gt;VTSI_EVENT_CALLER_STOPPED&lt;/code&gt; /
     * &lt;code&gt;VTSI_EVENT_LISTENER_STOPPED&lt;/code&gt; for the released resource.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StopCallResponse stopCall(ondewo.vtsi.CallsOuterClass.StopCallRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopCallMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops several calls of one project, each like &lt;code&gt;StopCall&lt;/code&gt;, at most 1000 distinct names. Not
     * atomic: every call is stopped on its own and reported in its own entry, in request order; a failed entry
     * carries an &lt;code&gt;error_message&lt;/code&gt; prefixed with the gRPC status code name &lt;code&gt;StopCall&lt;/code&gt; would have
     * answered and does not stop the others. No entry, more than 1000 names or a malformed
     * &lt;code&gt;vtsi_project_name&lt;/code&gt; is &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, an unknown project &lt;code&gt;NOT_FOUND&lt;/code&gt;, and
     * then nothing is stopped.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StopCall&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StopCallsResponse stopCalls(ondewo.vtsi.CallsOuterClass.StopCallsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopCallsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops every call of a VTSI project (listener and caller calls alike), or, with
     * &lt;code&gt;call_filter&lt;/code&gt;, those it matches, each like &lt;code&gt;StopCall&lt;/code&gt;. Not atomic and not bounded in
     * size; a project with nothing to stop answers an empty response, so the RPC is idempotent. If a stop fails
     * part-way, the remaining calls are still stopped one by one and every call gets its own entry.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, an invalid &lt;code&gt;call_filter&lt;/code&gt; or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or campaign; with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.StopCallsResponse stopAllCalls(ondewo.vtsi.CallsOuterClass.StopAllCallsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopAllCallsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Transfer a call to a phone number, a softphone account, another listener or the listener queue.&lt;/p&gt;
     * &lt;p&gt;The target is either the typed &lt;code&gt;target&lt;/code&gt; or the legacy raw &lt;code&gt;transfer_id&lt;/code&gt;, never both. It is
     * resolved and validated before anything is sent; an invalid target is answered with
     * &lt;code&gt;TRANSFER_OUTCOME_TARGET_INVALID&lt;/code&gt; and an &lt;code&gt;error_reason&lt;/code&gt;, and the call is untouched.&lt;/p&gt;
     * &lt;p&gt;&lt;code&gt;TRANSFER_MODE_BLIND&lt;/code&gt; (default) sends a SIP REFER and reports its outcome: a refused REFER keeps the
     * call with the bot. &lt;code&gt;TRANSFER_MODE_WARM&lt;/code&gt; rings the target into the call first, and the bot leaves only
     * after the target joined (Asterisk 22 only).&lt;/p&gt;
     * &lt;p&gt;Telephony outcomes (busy, no answer, REFER rejected) are successful RPCs carrying an &lt;code&gt;outcome&lt;/code&gt;.
     * Refusals before any side effect also return a gRPC status with &lt;code&gt;reason=&amp;lt;token&amp;gt;&lt;/code&gt; in its details:
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; (both targets set, malformed target), &lt;code&gt;NOT_FOUND&lt;/code&gt; (call or target not
     * found, including another project&amp;apos;s), &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; (&lt;code&gt;call-not-connected&lt;/code&gt;,
     * &lt;code&gt;amd-in-progress&lt;/code&gt;, &lt;code&gt;call-not-yet-identified&lt;/code&gt;, &lt;code&gt;participants-present&lt;/code&gt;,
     * &lt;code&gt;asterisk-version-unsupported&lt;/code&gt;, &lt;code&gt;sip-image-too-old&lt;/code&gt;), &lt;code&gt;ABORTED&lt;/code&gt;
     * (&lt;code&gt;transfer-in-progress&lt;/code&gt;), &lt;code&gt;UNAVAILABLE&lt;/code&gt; (&lt;code&gt;sip-unreachable&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.TransferCallResponse transferCall(ondewo.vtsi.CallsOuterClass.TransferCallRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTransferCallMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Transfer several calls, each like &lt;code&gt;TransferCall&lt;/code&gt;, at most 1000. Not atomic: every transfer is
     * run on its own and reported in its own entry, in request order; an entry &lt;code&gt;TransferCall&lt;/code&gt; would have
     * refused with a gRPC status carries that refusal in its &lt;code&gt;error_message&lt;/code&gt; (prefixed with the status
     * code name) and does not stop the others. Idempotent per entry &lt;code&gt;request_id&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.TransferCallsResponse transferCalls(ondewo.vtsi.CallsOuterClass.TransferCallsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTransferCallsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a call, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt; (the call&amp;apos;s log
     * lines are read with &lt;code&gt;Logs.ListCallLogs&lt;/code&gt;). &lt;code&gt;FULL&lt;/code&gt; also returns every participant ever
     * invited into the call (see &lt;code&gt;Call.participants&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or call, or a call of another project; with authorization
     * enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.Call getCall(ondewo.vtsi.CallsOuterClass.GetCallRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCallMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the calls of a VTSI project, ended ones included, narrowed by &lt;code&gt;call_filter&lt;/code&gt;, ordered by
     * &lt;code&gt;call_sorting&lt;/code&gt; (default: by &lt;code&gt;start_time&lt;/code&gt;, oldest first) and paged with
     * &lt;code&gt;page_size&lt;/code&gt; / &lt;code&gt;page_token&lt;/code&gt;; &lt;code&gt;total_size&lt;/code&gt; counts every match.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;call_filter.campaign_name&lt;/code&gt; or &lt;code&gt;call_filter.campaign_display_name&lt;/code&gt; set, lists
     * only the calls of that campaign: the calls placed by the attempts of its campaign calls.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, an invalid filter, a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a &lt;code&gt;page_token&lt;/code&gt; of another listing or an unknown &lt;code&gt;field_mask&lt;/code&gt;
     * path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or campaign; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.ListCallsResponse listCalls(ondewo.vtsi.CallsOuterClass.ListCallsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCallsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Aggregate figures (totals, active calls, counts by SIP status type, by call type, by AMD verdict and by
     * transfer outcome, durations, redial recommendations) over the calls of a VTSI project that
     * &lt;code&gt;call_filter&lt;/code&gt; matches; see &lt;code&gt;CallStatistics&lt;/code&gt;. Read only, no side effect.&lt;/p&gt;
     * &lt;p&gt;Errors: as for &lt;code&gt;ListCalls&lt;/code&gt; (an invalid filter is &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, an unknown project
     * or campaign &lt;code&gt;NOT_FOUND&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;ListCalls&lt;/code&gt; (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.CallStatistics getCallStatistics(ondewo.vtsi.CallsOuterClass.GetCallStatisticsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCallStatisticsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the descriptive metadata of a call: the only updatable &lt;code&gt;update_mask&lt;/code&gt; path is
     * &lt;code&gt;labels&lt;/code&gt;. Allowed on active and ended calls. Refused for the WAITING call of a persistent
     * listener or a pooled caller (status &lt;code&gt;NO_ONGOING_CALL&lt;/code&gt;, not active: the record that waits for the
     * next call, which &lt;code&gt;ListCalls&lt;/code&gt; returns too) with &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; and
     * &lt;code&gt;reason=call-not-started&lt;/code&gt; in the details: label the call once it has started. It changes only
     * the stored call record: the live call, its SIP container, its status and its media are never touched, and
     * nothing is sent to the call. Idempotent: writing the stored labels again changes nothing.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_UPDATED&lt;/code&gt; when the labels changed.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;call.name&lt;/code&gt;, an
     * empty &lt;code&gt;update_mask&lt;/code&gt;, any path other than &lt;code&gt;labels&lt;/code&gt; (every other field of a
     * &lt;code&gt;Call&lt;/code&gt; is output only), a path below &lt;code&gt;labels&lt;/code&gt;, labels outside the bounds of
     * &lt;code&gt;Call.labels&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path (each naming the path or label);
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown call or project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;
     * (&lt;code&gt;reason=call-not-started&lt;/code&gt;) for a waiting call; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; for a project the caller holds no role on.&lt;/p&gt;
     * &lt;p&gt;Authorization: the role that may stop calls of the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or
     * higher).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.UpdateCallResponse updateCall(ondewo.vtsi.CallsOuterClass.UpdateCallRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCallMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates several calls, each like &lt;code&gt;UpdateCall&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;UpdateCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;UpdateCall&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.UpdateCallsResponse updateCalls(ondewo.vtsi.CallsOuterClass.UpdateCallsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCallsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the status of the callers of a project: a snapshot first
     * (&lt;code&gt;snapshot = true&lt;/code&gt;), then every caller whose call or SIP status changed, plus
     * keep-alive messages. Ends when the client disconnects or at the server-side maximum stream
     * duration.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when
     * the server has no free stream slot.&lt;/p&gt;
     * </pre>
     */
    public java.util.Iterator<ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> streamCallerStatus(
        ondewo.vtsi.CallsOuterClass.StreamCallerStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamCallerStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the status of the listeners of a project, like &lt;code&gt;StreamCallerStatus&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public java.util.Iterator<ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> streamListenerStatus(
        ondewo.vtsi.CallsOuterClass.StreamListenerStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamListenerStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the status of the scheduled callers of a project, like
     * &lt;code&gt;StreamCallerStatus&lt;/code&gt;. The snapshot holds every PENDING and FIRING scheduled caller
     * and those that finished in the last hour.&lt;/p&gt;
     * </pre>
     */
    public java.util.Iterator<ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse> streamScheduledCallerStatus(
        ondewo.vtsi.CallsOuterClass.StreamScheduledCallerStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamScheduledCallerStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Invite a registered softphone account of the project into a connected call. Returns the participant in
     * &lt;code&gt;PARTICIPANT_STATE_RINGING&lt;/code&gt;; follow &lt;code&gt;Call.participants&lt;/code&gt; or the events
     * &lt;code&gt;VTSI_EVENT_CALL_PARTICIPANT_*&lt;/code&gt; for JOINED, FAILED and LEFT.&lt;/p&gt;
     * &lt;p&gt;&lt;code&gt;PARTICIPANT_MODE_CONFERENCE&lt;/code&gt; (default) joins the softphone into the call: Asterisk mixes the caller,
     * the bot and the participant, and by default the bot keeps talking and listening
     * (&lt;code&gt;BOT_POLICY_ON_JOIN_KEEP&lt;/code&gt;). &lt;code&gt;PARTICIPANT_MODE_MONITOR&lt;/code&gt; lets the participant listen only.
     * When the bot&amp;apos;s leg ends, every participant is hung up; the caller is handed over only by a WARM
     * &lt;code&gt;TransferCall&lt;/code&gt;. Idempotent per &lt;code&gt;request_id&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, &lt;code&gt;NOT_FOUND&lt;/code&gt; (call or softphone account, including another
     * project&amp;apos;s), &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; (&lt;code&gt;call-not-connected&lt;/code&gt;, &lt;code&gt;amd-in-progress&lt;/code&gt;,
     * &lt;code&gt;softphone-not-registered&lt;/code&gt;, &lt;code&gt;softphone-disabled&lt;/code&gt;, &lt;code&gt;softphone-unrouted&lt;/code&gt;,
     * &lt;code&gt;call-not-yet-identified&lt;/code&gt;, &lt;code&gt;bot-channel-ambiguous&lt;/code&gt;, &lt;code&gt;asterisk-not-local&lt;/code&gt;,
     * &lt;code&gt;asterisk-version-unsupported&lt;/code&gt;), &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; (the softphone is already ringing or joined),
     * &lt;code&gt;ABORTED&lt;/code&gt; (&lt;code&gt;transfer-in-progress&lt;/code&gt;), &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; (participant cap),
     * &lt;code&gt;UNAVAILABLE&lt;/code&gt; (&lt;code&gt;asterisk-unreachable&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.InviteToCallResponse inviteToCall(ondewo.vtsi.CallsOuterClass.InviteToCallRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInviteToCallMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Hang up a participant of a call (ringing or joined). The participant ends as
     * &lt;code&gt;PARTICIPANT_STATE_LEFT&lt;/code&gt; with &lt;code&gt;end_reason = REMOVED&lt;/code&gt;; the call and the bot are not
     * affected. Returns the participant after the request.&lt;/p&gt;
     * &lt;p&gt;Idempotent: a participant that already FAILED or LEFT (for whatever reason) is returned unchanged with OK,
     * and nothing is sent.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request; &lt;code&gt;NOT_FOUND&lt;/code&gt; with
     * &lt;code&gt;reason=call-not-found&lt;/code&gt; for an unknown call or a call of another project, and with
     * &lt;code&gt;reason=participant-not-found&lt;/code&gt; for an unknown &lt;code&gt;participant_id&lt;/code&gt; or a participant of
     * another call; &lt;code&gt;ABORTED&lt;/code&gt; with &lt;code&gt;reason=call-control-busy&lt;/code&gt; while another call-control
     * request for the call runs (retry); &lt;code&gt;UNAVAILABLE&lt;/code&gt; with &lt;code&gt;reason=asterisk-unreachable&lt;/code&gt; when
     * the hang-up could not be sent; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_PARTICIPANT_LEFT&lt;/code&gt; (or &lt;code&gt;VTSI_EVENT_CALL_PARTICIPANT_FAILED&lt;/code&gt;
     * for a participant that was still ringing).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher. Audited like &lt;code&gt;InviteToCall&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.RemoveCallParticipantResponse removeCallParticipant(ondewo.vtsi.CallsOuterClass.RemoveCallParticipantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveCallParticipantMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Mute the bot of a connected call and/or stop it listening to the caller, or undo either. Every request sets a
     * desired level and never toggles: a repeat answers &lt;code&gt;changed = false&lt;/code&gt;. The bot stays muted while
     * anything else (a TALK take-over of &lt;code&gt;StreamCallAudio&lt;/code&gt;, a participant bot policy) also holds it muted.&lt;/p&gt;
     * &lt;p&gt;Both settings &lt;code&gt;CALL_MEDIA_SETTING_UNCHANGED&lt;/code&gt; is a valid read of the current state: it answers
     * the effective &lt;code&gt;state&lt;/code&gt; with &lt;code&gt;changed = false&lt;/code&gt;, changes nothing, and writes no audit record
     * and no event (see &lt;code&gt;SetCallMediaControlRequest.bot_voice&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_BOT_MUTED&lt;/code&gt; / &lt;code&gt;VTSI_EVENT_CALL_BOT_UNMUTED&lt;/code&gt; /
     * &lt;code&gt;VTSI_EVENT_CALL_LISTENING_PAUSED&lt;/code&gt; / &lt;code&gt;VTSI_EVENT_CALL_LISTENING_RESUMED&lt;/code&gt; when the
     * effective state changed.&lt;/p&gt;
     * &lt;p&gt;Errors as for &lt;code&gt;InviteToCall&lt;/code&gt;, plus &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=sip-image-too-old&lt;/code&gt;,
     * &lt;code&gt;ABORTED&lt;/code&gt; &lt;code&gt;reason=call-control-busy&lt;/code&gt; (another call-control request for the call is running)
     * and &lt;code&gt;UNAVAILABLE&lt;/code&gt; &lt;code&gt;reason=sip-unreachable&lt;/code&gt; or &lt;code&gt;reason=csi-media-control-failed&lt;/code&gt; (the
     * bot did not apply the level: a requested pause is rolled back, a requested mute is kept).&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CallsOuterClass.SetCallMediaControlResponse setCallMediaControl(ondewo.vtsi.CallsOuterClass.SetCallMediaControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetCallMediaControlMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Listen-only live audio of a connected call, like &lt;code&gt;StreamCallAudio&lt;/code&gt; in LISTEN mode, as a server
     * stream that grpc-web (browser) clients can consume. &lt;code&gt;config.mode&lt;/code&gt; must be LISTEN or unspecified and
     * &lt;code&gt;config.take_over&lt;/code&gt; must be false, otherwise &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; &lt;code&gt;reason=listen-only&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public java.util.Iterator<ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse> listenCallAudio(
        ondewo.vtsi.CallsOuterClass.ListenCallAudioRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getListenCallAudioMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Calls.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public static final class CallsFutureStub
      extends io.grpc.stub.AbstractFutureStub<CallsFutureStub> {
    private CallsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CallsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CallsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts one caller in a VTSI project: an ondewo-sip container that places one outbound call to
     * &lt;code&gt;sip_caller_config.callee_id&lt;/code&gt; (or a pooled caller of the server&amp;apos;s caller pool that runs the same
     * configuration). The configuration is validated first, including live checks against the upstream services;
     * nothing is started when it fails. Not idempotent: every successful request places a new call (send it as a
     * batch of one with an &lt;code&gt;idempotency_key&lt;/code&gt; to make it idempotent). &lt;code&gt;validate_only&lt;/code&gt; runs the
     * validation alone.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed or invalid request or
     * configuration (also when the NLU credentials are refused) or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when an upstream config lacks
     * the required TLS certificate (&lt;code&gt;UPSTREAM_TLS_REQUIRED&lt;/code&gt;) or the project is not deployed;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the project reached its caller limit; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when an
     * upstream service could not be reached; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_STARTED&lt;/code&gt; or &lt;code&gt;VTSI_EVENT_CALLER_START_FAILED&lt;/code&gt;, then the
     * events of the call (&lt;code&gt;VTSI_EVENT_CALL_*&lt;/code&gt;). None with &lt;code&gt;validate_only&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.StartCallerResponse> startCaller(
        ondewo.vtsi.CallsOuterClass.StartCallerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartCallerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts several callers, each like &lt;code&gt;StartCaller&lt;/code&gt;. Not atomic: every caller is started on its own;
     * a caller that fails to start is rolled back and has no entry in the response, which accounts for it in
     * &lt;code&gt;StartCallersResponse.error_message&lt;/code&gt;. The project&amp;apos;s caller limit is checked for the batch as a
     * whole before anything is started (&lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;, nothing started). Idempotent per
     * &lt;code&gt;idempotency_key&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StartCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.StartCallersResponse> startCallers(
        ondewo.vtsi.CallsOuterClass.StartCallersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartCallersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the callers of a VTSI project, ordered by the caller&amp;apos;s uuid (the last segment of
     * &lt;code&gt;name&lt;/code&gt;), ascending: a stable order, not a chronological one. Paged with &lt;code&gt;page_size&lt;/code&gt; /
     * &lt;code&gt;page_token&lt;/code&gt;; &lt;code&gt;total_size&lt;/code&gt; counts every match.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;campaign_name&lt;/code&gt; or &lt;code&gt;campaign_display_name&lt;/code&gt; set, lists only the callers of that
     * campaign: the callers that placed at least one attempt of one of its campaign calls (see
     * &lt;code&gt;ListCallersRequest.campaign_name&lt;/code&gt;). &lt;code&gt;active_only&lt;/code&gt; and &lt;code&gt;sip_status_types&lt;/code&gt;
     * narrow the listing further.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, an invalid selector, a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a &lt;code&gt;page_token&lt;/code&gt; of another listing or an unknown &lt;code&gt;field_mask&lt;/code&gt;
     * path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or campaign; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.ListCallersResponse> listCallers(
        ondewo.vtsi.CallsOuterClass.ListCallersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCallersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a caller, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or caller, or a caller of another project; with authorization
     * enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.Caller> getCaller(
        ondewo.vtsi.CallsOuterClass.GetCallerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCallerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the STORED configuration of a caller: the fields named in &lt;code&gt;update_mask&lt;/code&gt;, i.e.
     * &lt;code&gt;sip_caller_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt; or any nested sub-path of them.
     * Allowed whether or not the caller has a call running.&lt;/p&gt;
     * &lt;p&gt;A running call and its container are NEVER changed: nothing is restarted, redeployed or reconfigured,
     * and the call goes on with the configuration its container was deployed with.&lt;/p&gt;
     * &lt;p&gt;When the stored configuration takes effect: a caller is ONE call (every &lt;code&gt;StartCaller&lt;/code&gt; creates
     * a new caller carrying its own configuration, and no RPC redeploys an existing one), so for a caller that
     * is not pooled the update changes ONLY the stored and returned configuration and never any present or
     * future call. The one case in which the server deploys a container from a caller&amp;apos;s stored
     * configuration is a POOLED (persistent) caller, which the server keeps warm between calls: when the server
     * recycles the pooled callers of a project onto its Asterisk (an &lt;code&gt;UpdateVtsiProject&lt;/code&gt; of a
     * deployed project, the recovery after the project&amp;apos;s Asterisk restarted, a change of the project&amp;apos;s
     * TLS trust anchor), the pooled caller it starts in place of this one is deployed from the stored, i.e.
     * updated, configuration. An in-place restart of a pooled caller&amp;apos;s container (the call monitor&amp;apos;s
     * health recovery) keeps the configuration the container was deployed with. Until it is recycled, an idle
     * pooled caller is matched to later &lt;code&gt;StartCaller&lt;/code&gt; requests by the configuration its container
     * RUNS, never by an updated stored configuration it does not run.&lt;/p&gt;
     * &lt;p&gt;Updating a caller never changes a campaign: the attempts of a campaign call take their configuration
     * from the campaign and the campaign call, never from a &lt;code&gt;Caller&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;A STOPPED caller (its call ended and its configuration was released) has no stored configuration left:
     * the update starts from an empty one, so it must state a complete configuration
     * (&lt;code&gt;sip_caller_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt;), and a partial one is refused as a
     * configuration a &lt;code&gt;StartCallerRequest&lt;/code&gt; would be refused for. Nothing is deployed.&lt;/p&gt;
     * &lt;p&gt;Credentials follow their endpoint: an update that MOVES an upstream (the &lt;code&gt;host&lt;/code&gt;,
     * &lt;code&gt;port&lt;/code&gt; or &lt;code&gt;grpc_cert&lt;/code&gt; of the NLU, S2T or T2S &lt;code&gt;*_base_config&lt;/code&gt;, or the
     * &lt;code&gt;host&lt;/code&gt; / ports of &lt;code&gt;csi_vtsi_config.message_broker_config.rabbit_mq_config&lt;/code&gt;) must
     * also write every credential path of that upstream that holds a stored value -- the NLU
     * &lt;code&gt;credentials&lt;/code&gt;, &lt;code&gt;auth_token&lt;/code&gt;, &lt;code&gt;http_basic_auth_token&lt;/code&gt; and
     * &lt;code&gt;contexts&lt;/code&gt;, the S2T &lt;code&gt;s2t_transcribe_request_config&lt;/code&gt;, the T2S
     * &lt;code&gt;t2s_request_config&lt;/code&gt;, the RabbitMQ &lt;code&gt;user&lt;/code&gt; and &lt;code&gt;password&lt;/code&gt; -- named itself
     * or by a shorter path, with the values to use. A stored credential is never sent to an endpoint the request
     * moved without restating it, also not for the live validation of the result.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;caller.name&lt;/code&gt;,
     * an empty &lt;code&gt;update_mask&lt;/code&gt;, an unknown, output-only or immutable &lt;code&gt;update_mask&lt;/code&gt; path, an
     * update that moves an upstream without restating its stored credentials (naming the paths to add), a
     * resulting configuration that a &lt;code&gt;StartCallerRequest&lt;/code&gt; carrying it would be refused for, or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path (each naming the path or field); &lt;code&gt;NOT_FOUND&lt;/code&gt; for an
     * unknown caller or project; &lt;code&gt;ABORTED&lt;/code&gt; when concurrent updates kept changing the caller, or while
     * an update, deploy or undeploy of its project is still running (an update waits for it, for a bounded time,
     * so that a recycle of the project cannot lose it), nothing being written (retry the request); with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; for a project the caller holds no role on.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_UPDATED&lt;/code&gt; (none with &lt;code&gt;validate_only&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: the role that may start and stop callers of the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;
     * or higher).&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.UpdateCallerResponse> updateCaller(
        ondewo.vtsi.CallsOuterClass.UpdateCallerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCallerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates several callers, each like &lt;code&gt;UpdateCaller&lt;/code&gt;. Not atomic: every entry is applied on its
     * own and reported in &lt;code&gt;UpdateCallersResponse.update_caller_responses&lt;/code&gt;, in request order; an entry
     * that fails changes nothing and does not stop the others. Errors of the request as a whole (see
     * &lt;code&gt;UpdateCallersRequest&lt;/code&gt;) are gRPC status codes, and then no entry is applied.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;UpdateCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.UpdateCallersResponse> updateCallers(
        ondewo.vtsi.CallsOuterClass.UpdateCallersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCallersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a caller: stops it if it still runs (hanging up its call) and removes it, so it is no longer
     * listed or returned. Its call records (and their participants) are deleted with it and are no longer returned
     * by &lt;code&gt;GetCall&lt;/code&gt; / &lt;code&gt;ListCalls&lt;/code&gt;; stop it instead to keep them.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown caller, a caller of another project, or a
     * caller that was already deleted (so deleting is NOT idempotent: a repeat answers &lt;code&gt;NOT_FOUND&lt;/code&gt;);
     * with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_DELETED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.DeleteCallerResponse> deleteCaller(
        ondewo.vtsi.CallsOuterClass.DeleteCallerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCallerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes several callers, each like &lt;code&gt;DeleteCaller&lt;/code&gt;. Not atomic: every caller is deleted on its own
     * and reported in its own entry, whose &lt;code&gt;error_message&lt;/code&gt; carries the gRPC status code name
     * &lt;code&gt;DeleteCaller&lt;/code&gt; would have answered (e.g. &lt;code&gt;NOT_FOUND: ...&lt;/code&gt;); an entry that fails does not
     * stop the others. The request as a whole is refused, nothing being deleted, for no entry or more than 1000
     * distinct names, and, when &lt;code&gt;vtsi_project_name&lt;/code&gt; is set, as described there.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;DeleteCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.DeleteCallersResponse> deleteCallers(
        ondewo.vtsi.CallsOuterClass.DeleteCallersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCallersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a caller: hangs up its call if one is up and releases its container and SIP account. The caller
     * stays listed (with &lt;code&gt;active = false&lt;/code&gt;) until it is deleted, and its stored configuration stays
     * updatable (see &lt;code&gt;UpdateCaller&lt;/code&gt;). A pooled caller is taken out of the pool.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown caller, a caller of another project, or a
     * caller that is already stopped (so stopping is NOT idempotent: a repeat answers &lt;code&gt;NOT_FOUND&lt;/code&gt;); with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALLER_STOPPED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.StopCallerResponse> stopCaller(
        ondewo.vtsi.CallsOuterClass.StopCallerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopCallerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops several callers, each like &lt;code&gt;StopCaller&lt;/code&gt;, with the per-entry results and the request-level
     * errors of &lt;code&gt;DeleteCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StopCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.StopCallersResponse> stopCallers(
        ondewo.vtsi.CallsOuterClass.StopCallersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopCallersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts one listener in a VTSI project: an ondewo-sip container registered on the project&amp;apos;s Asterisk
     * that answers inbound calls, one after the other (persistent). Validation, &lt;code&gt;validate_only&lt;/code&gt;, errors
     * (&lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; for the project&amp;apos;s listener limit) and idempotency as for
     * &lt;code&gt;StartCaller&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_STARTED&lt;/code&gt; or &lt;code&gt;VTSI_EVENT_LISTENER_START_FAILED&lt;/code&gt;. None with
     * &lt;code&gt;validate_only&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.StartListenerResponse> startListener(
        ondewo.vtsi.CallsOuterClass.StartListenerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartListenerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts several listeners, each like &lt;code&gt;StartListener&lt;/code&gt;, with the batch semantics of
     * &lt;code&gt;StartCallers&lt;/code&gt; (a listener that fails to start has no entry and is accounted for in
     * &lt;code&gt;StartListenersResponse.error_message&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StartListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.StartListenersResponse> startListeners(
        ondewo.vtsi.CallsOuterClass.StartListenersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartListenersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a listener: hangs up its call if one is up and releases its container and SIP account. A stopped
     * listener has no stored configuration left (see &lt;code&gt;UpdateListener&lt;/code&gt;). Errors and idempotency as for
     * &lt;code&gt;StopCaller&lt;/code&gt; (a listener that is already stopped is &lt;code&gt;NOT_FOUND&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_STOPPED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.StopListenerResponse> stopListener(
        ondewo.vtsi.CallsOuterClass.StopListenerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopListenerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops several listeners, each like &lt;code&gt;StopListener&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;DeleteCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StopListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.StopListenersResponse> stopListeners(
        ondewo.vtsi.CallsOuterClass.StopListenersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopListenersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the listeners of a VTSI project, ordered by the listener&amp;apos;s uuid (the last segment of
     * &lt;code&gt;name&lt;/code&gt;), ascending. Paging, &lt;code&gt;total_size&lt;/code&gt;, filters and errors as for
     * &lt;code&gt;ListCallers&lt;/code&gt; (without a campaign selector).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.ListListenersResponse> listListeners(
        ondewo.vtsi.CallsOuterClass.ListListenersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListListenersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a listener, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt;. Errors as for
     * &lt;code&gt;GetCaller&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.Listener> getListener(
        ondewo.vtsi.CallsOuterClass.GetListenerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetListenerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the STORED configuration of a listener: the fields named in &lt;code&gt;update_mask&lt;/code&gt;, i.e.
     * &lt;code&gt;sip_base_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt; or any nested sub-path of them.
     * Allowed whether or not the listener&amp;apos;s container is running or has a call, as long as the listener is
     * DEPLOYED: a stopped listener has no stored configuration (it is deployed again only by a
     * &lt;code&gt;StartListener&lt;/code&gt; carrying a complete one) and is &lt;code&gt;NOT_FOUND&lt;/code&gt;, unlike a stopped caller,
     * which &lt;code&gt;UpdateCaller&lt;/code&gt; accepts with a complete configuration.&lt;/p&gt;
     * &lt;p&gt;A running container and every call it takes are NEVER changed: nothing is restarted, redeployed or
     * reconfigured, and the running container answers its calls with the configuration it was deployed with
     * until it is replaced.&lt;/p&gt;
     * &lt;p&gt;When the stored configuration takes effect: only when the server RECREATES the listener from it, i.e.
     * when it recycles the listeners of the project onto its Asterisk: an &lt;code&gt;UpdateVtsiProject&lt;/code&gt; of a
     * deployed project, the recovery after the project&amp;apos;s Asterisk restarted, or a change of the
     * project&amp;apos;s TLS trust anchor. The listener the server starts in place of this one is deployed from the
     * stored, i.e. updated, configuration. An in-place restart of the listener&amp;apos;s container (the
     * server&amp;apos;s restore of listener containers when it starts, the call monitor&amp;apos;s restart of an
     * unhealthy container, a &lt;code&gt;docker restart&lt;/code&gt;) keeps the configuration the container was deployed
     * with. A listener that is never recycled keeps the update only as its stored (and returned)
     * configuration.&lt;/p&gt;
     * &lt;p&gt;Errors as for &lt;code&gt;UpdateCaller&lt;/code&gt; (the credential rule included), with
     * &lt;code&gt;StartListenerRequest&lt;/code&gt; as the validation of the resulting configuration, and
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; also for a stopped listener.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_UPDATED&lt;/code&gt; (none with &lt;code&gt;validate_only&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: the role that may start and stop listeners of the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;
     * or higher).&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.UpdateListenerResponse> updateListener(
        ondewo.vtsi.CallsOuterClass.UpdateListenerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateListenerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates several listeners, each like &lt;code&gt;UpdateListener&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;UpdateCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;UpdateListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.UpdateListenersResponse> updateListeners(
        ondewo.vtsi.CallsOuterClass.UpdateListenersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateListenersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a listener: stops it if it still runs (hanging up its call) and removes it, with its call
     * records, like &lt;code&gt;DeleteCaller&lt;/code&gt;. Errors and idempotency as for &lt;code&gt;DeleteCaller&lt;/code&gt; (a repeat
     * answers &lt;code&gt;NOT_FOUND&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_LISTENER_DELETED&lt;/code&gt; (and &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt; for a call that
     * was hung up).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.DeleteListenerResponse> deleteListener(
        ondewo.vtsi.CallsOuterClass.DeleteListenerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteListenerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes several listeners, each like &lt;code&gt;DeleteListener&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;DeleteCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;DeleteListener&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.DeleteListenersResponse> deleteListeners(
        ondewo.vtsi.CallsOuterClass.DeleteListenersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteListenersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a scheduled caller: a caller that the server starts at or after &lt;code&gt;scheduled_time&lt;/code&gt;, like a
     * &lt;code&gt;StartCaller&lt;/code&gt; of the stored request. The request is checked structurally now; the live checks of
     * the configuration run when it fires, and a failure then leaves the scheduled caller
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_FAILED&lt;/code&gt; with its &lt;code&gt;error_message&lt;/code&gt;. A &lt;code&gt;scheduled_time&lt;/code&gt; in
     * the past is due at once. Not idempotent (use &lt;code&gt;StartScheduledCallers&lt;/code&gt; with an
     * &lt;code&gt;idempotency_key&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, a missing
     * &lt;code&gt;scheduled_time&lt;/code&gt;, a nested request with its own &lt;code&gt;field_mask&lt;/code&gt; or
     * &lt;code&gt;validate_only&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown
     * project; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the project reached its caller limit; with authorization
     * enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CREATED&lt;/code&gt;; later &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_FIRED&lt;/code&gt;,
     * &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_RETRY_SCHEDULED&lt;/code&gt; or &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_FAILED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.StartScheduledCallerResponse> startScheduledCaller(
        ondewo.vtsi.CallsOuterClass.StartScheduledCallerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartScheduledCallerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates several scheduled callers, each like &lt;code&gt;StartScheduledCaller&lt;/code&gt;, at most 1000. Not atomic: an
     * entry that fails is reported in its own &lt;code&gt;error_message&lt;/code&gt; and does not stop the others. Idempotent
     * per &lt;code&gt;idempotency_key&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StartScheduledCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.StartScheduledCallersResponse> startScheduledCallers(
        ondewo.vtsi.CallsOuterClass.StartScheduledCallersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartScheduledCallersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Adds callers to a campaign instead of starting them. The campaign then starts them, at most
     * &lt;code&gt;max_parallel_calls&lt;/code&gt; at a time. The request is atomic: either the campaign (when new), every
     * campaign call is stored, or nothing is. Errors are gRPC status codes (see &lt;code&gt;CampaignAssignment&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Rolling updates: a VTSI server that predates this RPC answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; and starts
     * nothing. Do not fall back to &lt;code&gt;StartCallers&lt;/code&gt; on &lt;code&gt;UNIMPLEMENTED&lt;/code&gt;; retry later.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.AddCallersToCampaignResponse> addCallersToCampaign(
        ondewo.vtsi.CallsOuterClass.AddCallersToCampaignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddCallersToCampaignMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Adds scheduled callers to a campaign: each fires at or after its scheduled time AND when the campaign has a
     * free slot, and follows the campaign&amp;apos;s retries, stop and hard stop. Same atomicity, errors and rolling-update
     * behaviour as &lt;code&gt;AddCallersToCampaign&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignResponse> addScheduledCallersToCampaign(
        ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddScheduledCallersToCampaignMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a scheduled caller, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of another project; with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.ScheduledCaller> getScheduledCaller(
        ondewo.vtsi.CallsOuterClass.GetScheduledCallerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetScheduledCallerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the scheduled callers of a VTSI project, ordered by &lt;code&gt;scheduled_time&lt;/code&gt;, oldest first,
     * optionally narrowed by state, campaign and a &lt;code&gt;scheduled_time&lt;/code&gt; window. Paging,
     * &lt;code&gt;total_size&lt;/code&gt; and errors as for &lt;code&gt;ListCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.ListScheduledCallersResponse> listScheduledCallers(
        ondewo.vtsi.CallsOuterClass.ListScheduledCallersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListScheduledCallersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Changes the &lt;code&gt;scheduled_time&lt;/code&gt; and/or the &lt;code&gt;sip_caller_config.sip_headers&lt;/code&gt; of a scheduled
     * caller that has not fired yet; the only updatable &lt;code&gt;update_mask&lt;/code&gt; paths (see
     * &lt;code&gt;UpdateScheduledCallerRequest.update_mask&lt;/code&gt;). Allowed only while the status is
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_PENDING&lt;/code&gt;; for a scheduled caller of a campaign only while its campaign call
     * is &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; (a retry of a campaign call is timed by the campaign&amp;apos;s
     * &lt;code&gt;retry_delay&lt;/code&gt;). The check and the write are one atomic step, so a scheduled caller that fires
     * concurrently is either updated before it fires or refused. Updating to the stored values is accepted and
     * changes nothing.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, an empty
     * &lt;code&gt;update_mask&lt;/code&gt;, a path that is not updatable, an unset &lt;code&gt;scheduled_time&lt;/code&gt; named by the
     * mask, invalid &lt;code&gt;sip_headers&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path (each naming the path);
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of another project;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when it is no longer PENDING (&lt;code&gt;reason=not-pending&lt;/code&gt;) or its campaign
     * call has started (&lt;code&gt;reason=campaign-call-started&lt;/code&gt;); with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_UPDATED&lt;/code&gt; when something changed.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.ScheduledCaller> updateScheduledCaller(
        ondewo.vtsi.CallsOuterClass.UpdateScheduledCallerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateScheduledCallerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Cancels a scheduled caller that has not fired yet: a PENDING scheduled caller becomes
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_CANCELLED&lt;/code&gt; and never fires. A scheduled caller that is no longer PENDING
     * (firing, done, failed or already cancelled) is not an error: the response says &lt;code&gt;cancelled = false&lt;/code&gt;
     * and carries its current &lt;code&gt;status&lt;/code&gt;, so cancelling is idempotent.&lt;/p&gt;
     * &lt;p&gt;A scheduled caller of a campaign can be cancelled while its campaign call is
     * &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; or &lt;code&gt;CAMPAIGN_CALL_STATE_RETRY_PENDING&lt;/code&gt;;
     * the campaign call then becomes &lt;code&gt;CAMPAIGN_CALL_STATE_CANCELLED&lt;/code&gt;. While an attempt is
     * &lt;code&gt;DISPATCHING&lt;/code&gt; or &lt;code&gt;IN_PROGRESS&lt;/code&gt; the request is refused:
     * &lt;code&gt;cancelled = false&lt;/code&gt;, an &lt;code&gt;error_message&lt;/code&gt; saying why, and the scheduled caller keeps its
     * status.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of
     * another project; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CANCELLED&lt;/code&gt;, only when &lt;code&gt;cancelled = true&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.CancelScheduledCallerResponse> cancelScheduledCaller(
        ondewo.vtsi.CallsOuterClass.CancelScheduledCallerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelScheduledCallerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Cancels several scheduled callers, each like &lt;code&gt;CancelScheduledCaller&lt;/code&gt;, at most 1000. Not atomic:
     * every entry is applied on its own and reported in &lt;code&gt;CancelScheduledCallersResponse&lt;/code&gt;, in request
     * order; a failed entry carries an &lt;code&gt;error_message&lt;/code&gt; prefixed with the gRPC status code name
     * &lt;code&gt;CancelScheduledCaller&lt;/code&gt; would have answered (e.g. &lt;code&gt;NOT_FOUND: ...&lt;/code&gt;) and does not stop
     * the others. Errors of the request as a whole (see &lt;code&gt;CancelScheduledCallersRequest&lt;/code&gt;) are gRPC status
     * codes, and then nothing is cancelled.&lt;/p&gt;
     * &lt;p&gt;Events: one &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CANCELLED&lt;/code&gt; per entry with &lt;code&gt;cancelled = true&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;CancelScheduledCaller&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.CancelScheduledCallersResponse> cancelScheduledCallers(
        ondewo.vtsi.CallsOuterClass.CancelScheduledCallersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelScheduledCallersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Retries a FAILED scheduled caller by creating a NEW scheduled caller from its stored request: the same
     * &lt;code&gt;sip_caller_config&lt;/code&gt; and &lt;code&gt;common_services_config&lt;/code&gt;, &lt;code&gt;status = PENDING&lt;/code&gt;, the
     * &lt;code&gt;scheduled_time&lt;/code&gt; of the request (unset: now), and &lt;code&gt;retry_of_scheduled_caller_name&lt;/code&gt; naming
     * the failed one, whose &lt;code&gt;retried_by_scheduled_caller_name&lt;/code&gt; is set to the new one in the same atomic
     * step. The failed scheduled caller itself is not changed otherwise, so its &lt;code&gt;error_message&lt;/code&gt; and
     * &lt;code&gt;fired_at&lt;/code&gt; stay as the history of the failed attempt. Returns the new scheduled caller.&lt;/p&gt;
     * &lt;p&gt;Idempotency: a FAILED scheduled caller is retried at most once. A repeat of the request answers
     * &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; naming the retry in its message (read
     * &lt;code&gt;retried_by_scheduled_caller_name&lt;/code&gt;); to retry again after the retry failed too, retry the new
     * one.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or scheduled caller, or one of
     * another project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a scheduled caller that is not
     * &lt;code&gt;SCHEDULED_CALLER_STATUS_FAILED&lt;/code&gt; (&lt;code&gt;reason=not-failed&lt;/code&gt;) or that belongs to a campaign
     * (&lt;code&gt;reason=campaign-scheduled-caller&lt;/code&gt;: a campaign call is retried by the campaign&amp;apos;s
     * &lt;code&gt;max_attempts&lt;/code&gt;); &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when it was already retried;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the project reached its caller limit; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CREATED&lt;/code&gt; for the new scheduled caller.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.ScheduledCaller> retryScheduledCaller(
        ondewo.vtsi.CallsOuterClass.RetryScheduledCallerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetryScheduledCallerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a call: hangs it up if it is still active and stops (releases) the listener or caller that serves
     * it, like &lt;code&gt;StopCaller&lt;/code&gt; / &lt;code&gt;StopListener&lt;/code&gt;. A call that already ended is not an error: its
     * listener or caller is still released if it is deployed, and when there was nothing left to release the
     * response carries &lt;code&gt;error_message = Call ... was not released&lt;/code&gt;, so a repeat succeeds with that
     * message.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or call, or a call of another
     * project; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_STOPPED&lt;/code&gt;, and &lt;code&gt;VTSI_EVENT_CALLER_STOPPED&lt;/code&gt; /
     * &lt;code&gt;VTSI_EVENT_LISTENER_STOPPED&lt;/code&gt; for the released resource.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.StopCallResponse> stopCall(
        ondewo.vtsi.CallsOuterClass.StopCallRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopCallMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops several calls of one project, each like &lt;code&gt;StopCall&lt;/code&gt;, at most 1000 distinct names. Not
     * atomic: every call is stopped on its own and reported in its own entry, in request order; a failed entry
     * carries an &lt;code&gt;error_message&lt;/code&gt; prefixed with the gRPC status code name &lt;code&gt;StopCall&lt;/code&gt; would have
     * answered and does not stop the others. No entry, more than 1000 names or a malformed
     * &lt;code&gt;vtsi_project_name&lt;/code&gt; is &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, an unknown project &lt;code&gt;NOT_FOUND&lt;/code&gt;, and
     * then nothing is stopped.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;StopCall&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.StopCallsResponse> stopCalls(
        ondewo.vtsi.CallsOuterClass.StopCallsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopCallsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops every call of a VTSI project (listener and caller calls alike), or, with
     * &lt;code&gt;call_filter&lt;/code&gt;, those it matches, each like &lt;code&gt;StopCall&lt;/code&gt;. Not atomic and not bounded in
     * size; a project with nothing to stop answers an empty response, so the RPC is idempotent. If a stop fails
     * part-way, the remaining calls are still stopped one by one and every call gets its own entry.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, an invalid &lt;code&gt;call_filter&lt;/code&gt; or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or campaign; with
     * authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.StopCallsResponse> stopAllCalls(
        ondewo.vtsi.CallsOuterClass.StopAllCallsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopAllCallsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Transfer a call to a phone number, a softphone account, another listener or the listener queue.&lt;/p&gt;
     * &lt;p&gt;The target is either the typed &lt;code&gt;target&lt;/code&gt; or the legacy raw &lt;code&gt;transfer_id&lt;/code&gt;, never both. It is
     * resolved and validated before anything is sent; an invalid target is answered with
     * &lt;code&gt;TRANSFER_OUTCOME_TARGET_INVALID&lt;/code&gt; and an &lt;code&gt;error_reason&lt;/code&gt;, and the call is untouched.&lt;/p&gt;
     * &lt;p&gt;&lt;code&gt;TRANSFER_MODE_BLIND&lt;/code&gt; (default) sends a SIP REFER and reports its outcome: a refused REFER keeps the
     * call with the bot. &lt;code&gt;TRANSFER_MODE_WARM&lt;/code&gt; rings the target into the call first, and the bot leaves only
     * after the target joined (Asterisk 22 only).&lt;/p&gt;
     * &lt;p&gt;Telephony outcomes (busy, no answer, REFER rejected) are successful RPCs carrying an &lt;code&gt;outcome&lt;/code&gt;.
     * Refusals before any side effect also return a gRPC status with &lt;code&gt;reason=&amp;lt;token&amp;gt;&lt;/code&gt; in its details:
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; (both targets set, malformed target), &lt;code&gt;NOT_FOUND&lt;/code&gt; (call or target not
     * found, including another project&amp;apos;s), &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; (&lt;code&gt;call-not-connected&lt;/code&gt;,
     * &lt;code&gt;amd-in-progress&lt;/code&gt;, &lt;code&gt;call-not-yet-identified&lt;/code&gt;, &lt;code&gt;participants-present&lt;/code&gt;,
     * &lt;code&gt;asterisk-version-unsupported&lt;/code&gt;, &lt;code&gt;sip-image-too-old&lt;/code&gt;), &lt;code&gt;ABORTED&lt;/code&gt;
     * (&lt;code&gt;transfer-in-progress&lt;/code&gt;), &lt;code&gt;UNAVAILABLE&lt;/code&gt; (&lt;code&gt;sip-unreachable&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.TransferCallResponse> transferCall(
        ondewo.vtsi.CallsOuterClass.TransferCallRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTransferCallMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Transfer several calls, each like &lt;code&gt;TransferCall&lt;/code&gt;, at most 1000. Not atomic: every transfer is
     * run on its own and reported in its own entry, in request order; an entry &lt;code&gt;TransferCall&lt;/code&gt; would have
     * refused with a gRPC status carries that refusal in its &lt;code&gt;error_message&lt;/code&gt; (prefixed with the status
     * code name) and does not stop the others. Idempotent per entry &lt;code&gt;request_id&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.TransferCallsResponse> transferCalls(
        ondewo.vtsi.CallsOuterClass.TransferCallsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTransferCallsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Gets a call, populated according to &lt;code&gt;call_view&lt;/code&gt; and &lt;code&gt;field_mask&lt;/code&gt; (the call&amp;apos;s log
     * lines are read with &lt;code&gt;Logs.ListCallLogs&lt;/code&gt;). &lt;code&gt;FULL&lt;/code&gt; also returns every participant ever
     * invited into the call (see &lt;code&gt;Call.participants&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or call, or a call of another project; with authorization
     * enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.Call> getCall(
        ondewo.vtsi.CallsOuterClass.GetCallRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCallMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the calls of a VTSI project, ended ones included, narrowed by &lt;code&gt;call_filter&lt;/code&gt;, ordered by
     * &lt;code&gt;call_sorting&lt;/code&gt; (default: by &lt;code&gt;start_time&lt;/code&gt;, oldest first) and paged with
     * &lt;code&gt;page_size&lt;/code&gt; / &lt;code&gt;page_token&lt;/code&gt;; &lt;code&gt;total_size&lt;/code&gt; counts every match.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;call_filter.campaign_name&lt;/code&gt; or &lt;code&gt;call_filter.campaign_display_name&lt;/code&gt; set, lists
     * only the calls of that campaign: the calls placed by the attempts of its campaign calls.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request, an invalid filter, a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a &lt;code&gt;page_token&lt;/code&gt; of another listing or an unknown &lt;code&gt;field_mask&lt;/code&gt;
     * path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or campaign; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.ListCallsResponse> listCalls(
        ondewo.vtsi.CallsOuterClass.ListCallsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCallsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Aggregate figures (totals, active calls, counts by SIP status type, by call type, by AMD verdict and by
     * transfer outcome, durations, redial recommendations) over the calls of a VTSI project that
     * &lt;code&gt;call_filter&lt;/code&gt; matches; see &lt;code&gt;CallStatistics&lt;/code&gt;. Read only, no side effect.&lt;/p&gt;
     * &lt;p&gt;Errors: as for &lt;code&gt;ListCalls&lt;/code&gt; (an invalid filter is &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, an unknown project
     * or campaign &lt;code&gt;NOT_FOUND&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;ListCalls&lt;/code&gt; (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher on the project).&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.CallStatistics> getCallStatistics(
        ondewo.vtsi.CallsOuterClass.GetCallStatisticsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCallStatisticsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the descriptive metadata of a call: the only updatable &lt;code&gt;update_mask&lt;/code&gt; path is
     * &lt;code&gt;labels&lt;/code&gt;. Allowed on active and ended calls. Refused for the WAITING call of a persistent
     * listener or a pooled caller (status &lt;code&gt;NO_ONGOING_CALL&lt;/code&gt;, not active: the record that waits for the
     * next call, which &lt;code&gt;ListCalls&lt;/code&gt; returns too) with &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; and
     * &lt;code&gt;reason=call-not-started&lt;/code&gt; in the details: label the call once it has started. It changes only
     * the stored call record: the live call, its SIP container, its status and its media are never touched, and
     * nothing is sent to the call. Idempotent: writing the stored labels again changes nothing.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_UPDATED&lt;/code&gt; when the labels changed.&lt;/p&gt;
     * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;call.name&lt;/code&gt;, an
     * empty &lt;code&gt;update_mask&lt;/code&gt;, any path other than &lt;code&gt;labels&lt;/code&gt; (every other field of a
     * &lt;code&gt;Call&lt;/code&gt; is output only), a path below &lt;code&gt;labels&lt;/code&gt;, labels outside the bounds of
     * &lt;code&gt;Call.labels&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path (each naming the path or label);
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown call or project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;
     * (&lt;code&gt;reason=call-not-started&lt;/code&gt;) for a waiting call; with authorization enforced
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; for a project the caller holds no role on.&lt;/p&gt;
     * &lt;p&gt;Authorization: the role that may stop calls of the project (&lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or
     * higher).&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.UpdateCallResponse> updateCall(
        ondewo.vtsi.CallsOuterClass.UpdateCallRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCallMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates several calls, each like &lt;code&gt;UpdateCall&lt;/code&gt;, with the per-entry results and the
     * request-level errors of &lt;code&gt;UpdateCallers&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Authorization: as &lt;code&gt;UpdateCall&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.UpdateCallsResponse> updateCalls(
        ondewo.vtsi.CallsOuterClass.UpdateCallsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCallsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Invite a registered softphone account of the project into a connected call. Returns the participant in
     * &lt;code&gt;PARTICIPANT_STATE_RINGING&lt;/code&gt;; follow &lt;code&gt;Call.participants&lt;/code&gt; or the events
     * &lt;code&gt;VTSI_EVENT_CALL_PARTICIPANT_*&lt;/code&gt; for JOINED, FAILED and LEFT.&lt;/p&gt;
     * &lt;p&gt;&lt;code&gt;PARTICIPANT_MODE_CONFERENCE&lt;/code&gt; (default) joins the softphone into the call: Asterisk mixes the caller,
     * the bot and the participant, and by default the bot keeps talking and listening
     * (&lt;code&gt;BOT_POLICY_ON_JOIN_KEEP&lt;/code&gt;). &lt;code&gt;PARTICIPANT_MODE_MONITOR&lt;/code&gt; lets the participant listen only.
     * When the bot&amp;apos;s leg ends, every participant is hung up; the caller is handed over only by a WARM
     * &lt;code&gt;TransferCall&lt;/code&gt;. Idempotent per &lt;code&gt;request_id&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, &lt;code&gt;NOT_FOUND&lt;/code&gt; (call or softphone account, including another
     * project&amp;apos;s), &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; (&lt;code&gt;call-not-connected&lt;/code&gt;, &lt;code&gt;amd-in-progress&lt;/code&gt;,
     * &lt;code&gt;softphone-not-registered&lt;/code&gt;, &lt;code&gt;softphone-disabled&lt;/code&gt;, &lt;code&gt;softphone-unrouted&lt;/code&gt;,
     * &lt;code&gt;call-not-yet-identified&lt;/code&gt;, &lt;code&gt;bot-channel-ambiguous&lt;/code&gt;, &lt;code&gt;asterisk-not-local&lt;/code&gt;,
     * &lt;code&gt;asterisk-version-unsupported&lt;/code&gt;), &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; (the softphone is already ringing or joined),
     * &lt;code&gt;ABORTED&lt;/code&gt; (&lt;code&gt;transfer-in-progress&lt;/code&gt;), &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; (participant cap),
     * &lt;code&gt;UNAVAILABLE&lt;/code&gt; (&lt;code&gt;asterisk-unreachable&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.InviteToCallResponse> inviteToCall(
        ondewo.vtsi.CallsOuterClass.InviteToCallRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInviteToCallMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Hang up a participant of a call (ringing or joined). The participant ends as
     * &lt;code&gt;PARTICIPANT_STATE_LEFT&lt;/code&gt; with &lt;code&gt;end_reason = REMOVED&lt;/code&gt;; the call and the bot are not
     * affected. Returns the participant after the request.&lt;/p&gt;
     * &lt;p&gt;Idempotent: a participant that already FAILED or LEFT (for whatever reason) is returned unchanged with OK,
     * and nothing is sent.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed request; &lt;code&gt;NOT_FOUND&lt;/code&gt; with
     * &lt;code&gt;reason=call-not-found&lt;/code&gt; for an unknown call or a call of another project, and with
     * &lt;code&gt;reason=participant-not-found&lt;/code&gt; for an unknown &lt;code&gt;participant_id&lt;/code&gt; or a participant of
     * another call; &lt;code&gt;ABORTED&lt;/code&gt; with &lt;code&gt;reason=call-control-busy&lt;/code&gt; while another call-control
     * request for the call runs (retry); &lt;code&gt;UNAVAILABLE&lt;/code&gt; with &lt;code&gt;reason=asterisk-unreachable&lt;/code&gt; when
     * the hang-up could not be sent; with authorization enforced &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_PARTICIPANT_LEFT&lt;/code&gt; (or &lt;code&gt;VTSI_EVENT_CALL_PARTICIPANT_FAILED&lt;/code&gt;
     * for a participant that was still ringing).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher. Audited like &lt;code&gt;InviteToCall&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.RemoveCallParticipantResponse> removeCallParticipant(
        ondewo.vtsi.CallsOuterClass.RemoveCallParticipantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveCallParticipantMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Mute the bot of a connected call and/or stop it listening to the caller, or undo either. Every request sets a
     * desired level and never toggles: a repeat answers &lt;code&gt;changed = false&lt;/code&gt;. The bot stays muted while
     * anything else (a TALK take-over of &lt;code&gt;StreamCallAudio&lt;/code&gt;, a participant bot policy) also holds it muted.&lt;/p&gt;
     * &lt;p&gt;Both settings &lt;code&gt;CALL_MEDIA_SETTING_UNCHANGED&lt;/code&gt; is a valid read of the current state: it answers
     * the effective &lt;code&gt;state&lt;/code&gt; with &lt;code&gt;changed = false&lt;/code&gt;, changes nothing, and writes no audit record
     * and no event (see &lt;code&gt;SetCallMediaControlRequest.bot_voice&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_CALL_BOT_MUTED&lt;/code&gt; / &lt;code&gt;VTSI_EVENT_CALL_BOT_UNMUTED&lt;/code&gt; /
     * &lt;code&gt;VTSI_EVENT_CALL_LISTENING_PAUSED&lt;/code&gt; / &lt;code&gt;VTSI_EVENT_CALL_LISTENING_RESUMED&lt;/code&gt; when the
     * effective state changed.&lt;/p&gt;
     * &lt;p&gt;Errors as for &lt;code&gt;InviteToCall&lt;/code&gt;, plus &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=sip-image-too-old&lt;/code&gt;,
     * &lt;code&gt;ABORTED&lt;/code&gt; &lt;code&gt;reason=call-control-busy&lt;/code&gt; (another call-control request for the call is running)
     * and &lt;code&gt;UNAVAILABLE&lt;/code&gt; &lt;code&gt;reason=sip-unreachable&lt;/code&gt; or &lt;code&gt;reason=csi-media-control-failed&lt;/code&gt; (the
     * bot did not apply the level: a requested pause is rolled back, a requested mute is kept).&lt;/p&gt;
     * &lt;p&gt;Authorization: requires the role &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project, and the server&amp;apos;s
     * Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;; otherwise &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, or
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; with &lt;code&gt;reason=call-supervision-requires-auth&lt;/code&gt; when auth is not enforced.
     * Every action writes an audit record (who, call, when, mode, target). No announcement is played to the caller.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CallsOuterClass.SetCallMediaControlResponse> setCallMediaControl(
        ondewo.vtsi.CallsOuterClass.SetCallMediaControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetCallMediaControlMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_START_CALLER = 0;
  private static final int METHODID_START_CALLERS = 1;
  private static final int METHODID_LIST_CALLERS = 2;
  private static final int METHODID_GET_CALLER = 3;
  private static final int METHODID_UPDATE_CALLER = 4;
  private static final int METHODID_UPDATE_CALLERS = 5;
  private static final int METHODID_DELETE_CALLER = 6;
  private static final int METHODID_DELETE_CALLERS = 7;
  private static final int METHODID_STOP_CALLER = 8;
  private static final int METHODID_STOP_CALLERS = 9;
  private static final int METHODID_START_LISTENER = 10;
  private static final int METHODID_START_LISTENERS = 11;
  private static final int METHODID_STOP_LISTENER = 12;
  private static final int METHODID_STOP_LISTENERS = 13;
  private static final int METHODID_LIST_LISTENERS = 14;
  private static final int METHODID_GET_LISTENER = 15;
  private static final int METHODID_UPDATE_LISTENER = 16;
  private static final int METHODID_UPDATE_LISTENERS = 17;
  private static final int METHODID_DELETE_LISTENER = 18;
  private static final int METHODID_DELETE_LISTENERS = 19;
  private static final int METHODID_START_SCHEDULED_CALLER = 20;
  private static final int METHODID_START_SCHEDULED_CALLERS = 21;
  private static final int METHODID_ADD_CALLERS_TO_CAMPAIGN = 22;
  private static final int METHODID_ADD_SCHEDULED_CALLERS_TO_CAMPAIGN = 23;
  private static final int METHODID_GET_SCHEDULED_CALLER = 24;
  private static final int METHODID_LIST_SCHEDULED_CALLERS = 25;
  private static final int METHODID_UPDATE_SCHEDULED_CALLER = 26;
  private static final int METHODID_CANCEL_SCHEDULED_CALLER = 27;
  private static final int METHODID_CANCEL_SCHEDULED_CALLERS = 28;
  private static final int METHODID_RETRY_SCHEDULED_CALLER = 29;
  private static final int METHODID_STOP_CALL = 30;
  private static final int METHODID_STOP_CALLS = 31;
  private static final int METHODID_STOP_ALL_CALLS = 32;
  private static final int METHODID_TRANSFER_CALL = 33;
  private static final int METHODID_TRANSFER_CALLS = 34;
  private static final int METHODID_GET_CALL = 35;
  private static final int METHODID_LIST_CALLS = 36;
  private static final int METHODID_GET_CALL_STATISTICS = 37;
  private static final int METHODID_UPDATE_CALL = 38;
  private static final int METHODID_UPDATE_CALLS = 39;
  private static final int METHODID_STREAM_CALLER_STATUS = 40;
  private static final int METHODID_STREAM_LISTENER_STATUS = 41;
  private static final int METHODID_STREAM_SCHEDULED_CALLER_STATUS = 42;
  private static final int METHODID_INVITE_TO_CALL = 43;
  private static final int METHODID_REMOVE_CALL_PARTICIPANT = 44;
  private static final int METHODID_SET_CALL_MEDIA_CONTROL = 45;
  private static final int METHODID_LISTEN_CALL_AUDIO = 46;
  private static final int METHODID_STREAM_CALL_AUDIO = 47;

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
        case METHODID_START_CALLER:
          serviceImpl.startCaller((ondewo.vtsi.CallsOuterClass.StartCallerRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartCallerResponse>) responseObserver);
          break;
        case METHODID_START_CALLERS:
          serviceImpl.startCallers((ondewo.vtsi.CallsOuterClass.StartCallersRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartCallersResponse>) responseObserver);
          break;
        case METHODID_LIST_CALLERS:
          serviceImpl.listCallers((ondewo.vtsi.CallsOuterClass.ListCallersRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ListCallersResponse>) responseObserver);
          break;
        case METHODID_GET_CALLER:
          serviceImpl.getCaller((ondewo.vtsi.CallsOuterClass.GetCallerRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.Caller>) responseObserver);
          break;
        case METHODID_UPDATE_CALLER:
          serviceImpl.updateCaller((ondewo.vtsi.CallsOuterClass.UpdateCallerRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateCallerResponse>) responseObserver);
          break;
        case METHODID_UPDATE_CALLERS:
          serviceImpl.updateCallers((ondewo.vtsi.CallsOuterClass.UpdateCallersRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateCallersResponse>) responseObserver);
          break;
        case METHODID_DELETE_CALLER:
          serviceImpl.deleteCaller((ondewo.vtsi.CallsOuterClass.DeleteCallerRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.DeleteCallerResponse>) responseObserver);
          break;
        case METHODID_DELETE_CALLERS:
          serviceImpl.deleteCallers((ondewo.vtsi.CallsOuterClass.DeleteCallersRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.DeleteCallersResponse>) responseObserver);
          break;
        case METHODID_STOP_CALLER:
          serviceImpl.stopCaller((ondewo.vtsi.CallsOuterClass.StopCallerRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopCallerResponse>) responseObserver);
          break;
        case METHODID_STOP_CALLERS:
          serviceImpl.stopCallers((ondewo.vtsi.CallsOuterClass.StopCallersRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopCallersResponse>) responseObserver);
          break;
        case METHODID_START_LISTENER:
          serviceImpl.startListener((ondewo.vtsi.CallsOuterClass.StartListenerRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartListenerResponse>) responseObserver);
          break;
        case METHODID_START_LISTENERS:
          serviceImpl.startListeners((ondewo.vtsi.CallsOuterClass.StartListenersRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartListenersResponse>) responseObserver);
          break;
        case METHODID_STOP_LISTENER:
          serviceImpl.stopListener((ondewo.vtsi.CallsOuterClass.StopListenerRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopListenerResponse>) responseObserver);
          break;
        case METHODID_STOP_LISTENERS:
          serviceImpl.stopListeners((ondewo.vtsi.CallsOuterClass.StopListenersRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopListenersResponse>) responseObserver);
          break;
        case METHODID_LIST_LISTENERS:
          serviceImpl.listListeners((ondewo.vtsi.CallsOuterClass.ListListenersRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ListListenersResponse>) responseObserver);
          break;
        case METHODID_GET_LISTENER:
          serviceImpl.getListener((ondewo.vtsi.CallsOuterClass.GetListenerRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.Listener>) responseObserver);
          break;
        case METHODID_UPDATE_LISTENER:
          serviceImpl.updateListener((ondewo.vtsi.CallsOuterClass.UpdateListenerRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateListenerResponse>) responseObserver);
          break;
        case METHODID_UPDATE_LISTENERS:
          serviceImpl.updateListeners((ondewo.vtsi.CallsOuterClass.UpdateListenersRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateListenersResponse>) responseObserver);
          break;
        case METHODID_DELETE_LISTENER:
          serviceImpl.deleteListener((ondewo.vtsi.CallsOuterClass.DeleteListenerRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.DeleteListenerResponse>) responseObserver);
          break;
        case METHODID_DELETE_LISTENERS:
          serviceImpl.deleteListeners((ondewo.vtsi.CallsOuterClass.DeleteListenersRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.DeleteListenersResponse>) responseObserver);
          break;
        case METHODID_START_SCHEDULED_CALLER:
          serviceImpl.startScheduledCaller((ondewo.vtsi.CallsOuterClass.StartScheduledCallerRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartScheduledCallerResponse>) responseObserver);
          break;
        case METHODID_START_SCHEDULED_CALLERS:
          serviceImpl.startScheduledCallers((ondewo.vtsi.CallsOuterClass.StartScheduledCallersRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StartScheduledCallersResponse>) responseObserver);
          break;
        case METHODID_ADD_CALLERS_TO_CAMPAIGN:
          serviceImpl.addCallersToCampaign((ondewo.vtsi.CallsOuterClass.AddCallersToCampaignRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.AddCallersToCampaignResponse>) responseObserver);
          break;
        case METHODID_ADD_SCHEDULED_CALLERS_TO_CAMPAIGN:
          serviceImpl.addScheduledCallersToCampaign((ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignResponse>) responseObserver);
          break;
        case METHODID_GET_SCHEDULED_CALLER:
          serviceImpl.getScheduledCaller((ondewo.vtsi.CallsOuterClass.GetScheduledCallerRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ScheduledCaller>) responseObserver);
          break;
        case METHODID_LIST_SCHEDULED_CALLERS:
          serviceImpl.listScheduledCallers((ondewo.vtsi.CallsOuterClass.ListScheduledCallersRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ListScheduledCallersResponse>) responseObserver);
          break;
        case METHODID_UPDATE_SCHEDULED_CALLER:
          serviceImpl.updateScheduledCaller((ondewo.vtsi.CallsOuterClass.UpdateScheduledCallerRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ScheduledCaller>) responseObserver);
          break;
        case METHODID_CANCEL_SCHEDULED_CALLER:
          serviceImpl.cancelScheduledCaller((ondewo.vtsi.CallsOuterClass.CancelScheduledCallerRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.CancelScheduledCallerResponse>) responseObserver);
          break;
        case METHODID_CANCEL_SCHEDULED_CALLERS:
          serviceImpl.cancelScheduledCallers((ondewo.vtsi.CallsOuterClass.CancelScheduledCallersRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.CancelScheduledCallersResponse>) responseObserver);
          break;
        case METHODID_RETRY_SCHEDULED_CALLER:
          serviceImpl.retryScheduledCaller((ondewo.vtsi.CallsOuterClass.RetryScheduledCallerRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ScheduledCaller>) responseObserver);
          break;
        case METHODID_STOP_CALL:
          serviceImpl.stopCall((ondewo.vtsi.CallsOuterClass.StopCallRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopCallResponse>) responseObserver);
          break;
        case METHODID_STOP_CALLS:
          serviceImpl.stopCalls((ondewo.vtsi.CallsOuterClass.StopCallsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopCallsResponse>) responseObserver);
          break;
        case METHODID_STOP_ALL_CALLS:
          serviceImpl.stopAllCalls((ondewo.vtsi.CallsOuterClass.StopAllCallsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StopCallsResponse>) responseObserver);
          break;
        case METHODID_TRANSFER_CALL:
          serviceImpl.transferCall((ondewo.vtsi.CallsOuterClass.TransferCallRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.TransferCallResponse>) responseObserver);
          break;
        case METHODID_TRANSFER_CALLS:
          serviceImpl.transferCalls((ondewo.vtsi.CallsOuterClass.TransferCallsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.TransferCallsResponse>) responseObserver);
          break;
        case METHODID_GET_CALL:
          serviceImpl.getCall((ondewo.vtsi.CallsOuterClass.GetCallRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.Call>) responseObserver);
          break;
        case METHODID_LIST_CALLS:
          serviceImpl.listCalls((ondewo.vtsi.CallsOuterClass.ListCallsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.ListCallsResponse>) responseObserver);
          break;
        case METHODID_GET_CALL_STATISTICS:
          serviceImpl.getCallStatistics((ondewo.vtsi.CallsOuterClass.GetCallStatisticsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.CallStatistics>) responseObserver);
          break;
        case METHODID_UPDATE_CALL:
          serviceImpl.updateCall((ondewo.vtsi.CallsOuterClass.UpdateCallRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateCallResponse>) responseObserver);
          break;
        case METHODID_UPDATE_CALLS:
          serviceImpl.updateCalls((ondewo.vtsi.CallsOuterClass.UpdateCallsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.UpdateCallsResponse>) responseObserver);
          break;
        case METHODID_STREAM_CALLER_STATUS:
          serviceImpl.streamCallerStatus((ondewo.vtsi.CallsOuterClass.StreamCallerStatusRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse>) responseObserver);
          break;
        case METHODID_STREAM_LISTENER_STATUS:
          serviceImpl.streamListenerStatus((ondewo.vtsi.CallsOuterClass.StreamListenerStatusRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse>) responseObserver);
          break;
        case METHODID_STREAM_SCHEDULED_CALLER_STATUS:
          serviceImpl.streamScheduledCallerStatus((ondewo.vtsi.CallsOuterClass.StreamScheduledCallerStatusRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse>) responseObserver);
          break;
        case METHODID_INVITE_TO_CALL:
          serviceImpl.inviteToCall((ondewo.vtsi.CallsOuterClass.InviteToCallRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.InviteToCallResponse>) responseObserver);
          break;
        case METHODID_REMOVE_CALL_PARTICIPANT:
          serviceImpl.removeCallParticipant((ondewo.vtsi.CallsOuterClass.RemoveCallParticipantRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.RemoveCallParticipantResponse>) responseObserver);
          break;
        case METHODID_SET_CALL_MEDIA_CONTROL:
          serviceImpl.setCallMediaControl((ondewo.vtsi.CallsOuterClass.SetCallMediaControlRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.SetCallMediaControlResponse>) responseObserver);
          break;
        case METHODID_LISTEN_CALL_AUDIO:
          serviceImpl.listenCallAudio((ondewo.vtsi.CallsOuterClass.ListenCallAudioRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse>) responseObserver);
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
        case METHODID_STREAM_CALL_AUDIO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamCallAudio(
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getStartCallerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.StartCallerRequest,
              ondewo.vtsi.CallsOuterClass.StartCallerResponse>(
                service, METHODID_START_CALLER)))
        .addMethod(
          getStartCallersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.StartCallersRequest,
              ondewo.vtsi.CallsOuterClass.StartCallersResponse>(
                service, METHODID_START_CALLERS)))
        .addMethod(
          getListCallersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.ListCallersRequest,
              ondewo.vtsi.CallsOuterClass.ListCallersResponse>(
                service, METHODID_LIST_CALLERS)))
        .addMethod(
          getGetCallerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.GetCallerRequest,
              ondewo.vtsi.CallsOuterClass.Caller>(
                service, METHODID_GET_CALLER)))
        .addMethod(
          getUpdateCallerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.UpdateCallerRequest,
              ondewo.vtsi.CallsOuterClass.UpdateCallerResponse>(
                service, METHODID_UPDATE_CALLER)))
        .addMethod(
          getUpdateCallersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.UpdateCallersRequest,
              ondewo.vtsi.CallsOuterClass.UpdateCallersResponse>(
                service, METHODID_UPDATE_CALLERS)))
        .addMethod(
          getDeleteCallerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.DeleteCallerRequest,
              ondewo.vtsi.CallsOuterClass.DeleteCallerResponse>(
                service, METHODID_DELETE_CALLER)))
        .addMethod(
          getDeleteCallersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.DeleteCallersRequest,
              ondewo.vtsi.CallsOuterClass.DeleteCallersResponse>(
                service, METHODID_DELETE_CALLERS)))
        .addMethod(
          getStopCallerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.StopCallerRequest,
              ondewo.vtsi.CallsOuterClass.StopCallerResponse>(
                service, METHODID_STOP_CALLER)))
        .addMethod(
          getStopCallersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.StopCallersRequest,
              ondewo.vtsi.CallsOuterClass.StopCallersResponse>(
                service, METHODID_STOP_CALLERS)))
        .addMethod(
          getStartListenerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.StartListenerRequest,
              ondewo.vtsi.CallsOuterClass.StartListenerResponse>(
                service, METHODID_START_LISTENER)))
        .addMethod(
          getStartListenersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.StartListenersRequest,
              ondewo.vtsi.CallsOuterClass.StartListenersResponse>(
                service, METHODID_START_LISTENERS)))
        .addMethod(
          getStopListenerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.StopListenerRequest,
              ondewo.vtsi.CallsOuterClass.StopListenerResponse>(
                service, METHODID_STOP_LISTENER)))
        .addMethod(
          getStopListenersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.StopListenersRequest,
              ondewo.vtsi.CallsOuterClass.StopListenersResponse>(
                service, METHODID_STOP_LISTENERS)))
        .addMethod(
          getListListenersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.ListListenersRequest,
              ondewo.vtsi.CallsOuterClass.ListListenersResponse>(
                service, METHODID_LIST_LISTENERS)))
        .addMethod(
          getGetListenerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.GetListenerRequest,
              ondewo.vtsi.CallsOuterClass.Listener>(
                service, METHODID_GET_LISTENER)))
        .addMethod(
          getUpdateListenerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.UpdateListenerRequest,
              ondewo.vtsi.CallsOuterClass.UpdateListenerResponse>(
                service, METHODID_UPDATE_LISTENER)))
        .addMethod(
          getUpdateListenersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.UpdateListenersRequest,
              ondewo.vtsi.CallsOuterClass.UpdateListenersResponse>(
                service, METHODID_UPDATE_LISTENERS)))
        .addMethod(
          getDeleteListenerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.DeleteListenerRequest,
              ondewo.vtsi.CallsOuterClass.DeleteListenerResponse>(
                service, METHODID_DELETE_LISTENER)))
        .addMethod(
          getDeleteListenersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.DeleteListenersRequest,
              ondewo.vtsi.CallsOuterClass.DeleteListenersResponse>(
                service, METHODID_DELETE_LISTENERS)))
        .addMethod(
          getStartScheduledCallerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.StartScheduledCallerRequest,
              ondewo.vtsi.CallsOuterClass.StartScheduledCallerResponse>(
                service, METHODID_START_SCHEDULED_CALLER)))
        .addMethod(
          getStartScheduledCallersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.StartScheduledCallersRequest,
              ondewo.vtsi.CallsOuterClass.StartScheduledCallersResponse>(
                service, METHODID_START_SCHEDULED_CALLERS)))
        .addMethod(
          getAddCallersToCampaignMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.AddCallersToCampaignRequest,
              ondewo.vtsi.CallsOuterClass.AddCallersToCampaignResponse>(
                service, METHODID_ADD_CALLERS_TO_CAMPAIGN)))
        .addMethod(
          getAddScheduledCallersToCampaignMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignRequest,
              ondewo.vtsi.CallsOuterClass.AddScheduledCallersToCampaignResponse>(
                service, METHODID_ADD_SCHEDULED_CALLERS_TO_CAMPAIGN)))
        .addMethod(
          getGetScheduledCallerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.GetScheduledCallerRequest,
              ondewo.vtsi.CallsOuterClass.ScheduledCaller>(
                service, METHODID_GET_SCHEDULED_CALLER)))
        .addMethod(
          getListScheduledCallersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.ListScheduledCallersRequest,
              ondewo.vtsi.CallsOuterClass.ListScheduledCallersResponse>(
                service, METHODID_LIST_SCHEDULED_CALLERS)))
        .addMethod(
          getUpdateScheduledCallerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.UpdateScheduledCallerRequest,
              ondewo.vtsi.CallsOuterClass.ScheduledCaller>(
                service, METHODID_UPDATE_SCHEDULED_CALLER)))
        .addMethod(
          getCancelScheduledCallerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.CancelScheduledCallerRequest,
              ondewo.vtsi.CallsOuterClass.CancelScheduledCallerResponse>(
                service, METHODID_CANCEL_SCHEDULED_CALLER)))
        .addMethod(
          getCancelScheduledCallersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.CancelScheduledCallersRequest,
              ondewo.vtsi.CallsOuterClass.CancelScheduledCallersResponse>(
                service, METHODID_CANCEL_SCHEDULED_CALLERS)))
        .addMethod(
          getRetryScheduledCallerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.RetryScheduledCallerRequest,
              ondewo.vtsi.CallsOuterClass.ScheduledCaller>(
                service, METHODID_RETRY_SCHEDULED_CALLER)))
        .addMethod(
          getStopCallMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.StopCallRequest,
              ondewo.vtsi.CallsOuterClass.StopCallResponse>(
                service, METHODID_STOP_CALL)))
        .addMethod(
          getStopCallsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.StopCallsRequest,
              ondewo.vtsi.CallsOuterClass.StopCallsResponse>(
                service, METHODID_STOP_CALLS)))
        .addMethod(
          getStopAllCallsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.StopAllCallsRequest,
              ondewo.vtsi.CallsOuterClass.StopCallsResponse>(
                service, METHODID_STOP_ALL_CALLS)))
        .addMethod(
          getTransferCallMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.TransferCallRequest,
              ondewo.vtsi.CallsOuterClass.TransferCallResponse>(
                service, METHODID_TRANSFER_CALL)))
        .addMethod(
          getTransferCallsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.TransferCallsRequest,
              ondewo.vtsi.CallsOuterClass.TransferCallsResponse>(
                service, METHODID_TRANSFER_CALLS)))
        .addMethod(
          getGetCallMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.GetCallRequest,
              ondewo.vtsi.CallsOuterClass.Call>(
                service, METHODID_GET_CALL)))
        .addMethod(
          getListCallsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.ListCallsRequest,
              ondewo.vtsi.CallsOuterClass.ListCallsResponse>(
                service, METHODID_LIST_CALLS)))
        .addMethod(
          getGetCallStatisticsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.GetCallStatisticsRequest,
              ondewo.vtsi.CallsOuterClass.CallStatistics>(
                service, METHODID_GET_CALL_STATISTICS)))
        .addMethod(
          getUpdateCallMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.UpdateCallRequest,
              ondewo.vtsi.CallsOuterClass.UpdateCallResponse>(
                service, METHODID_UPDATE_CALL)))
        .addMethod(
          getUpdateCallsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.UpdateCallsRequest,
              ondewo.vtsi.CallsOuterClass.UpdateCallsResponse>(
                service, METHODID_UPDATE_CALLS)))
        .addMethod(
          getStreamCallerStatusMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.StreamCallerStatusRequest,
              ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse>(
                service, METHODID_STREAM_CALLER_STATUS)))
        .addMethod(
          getStreamListenerStatusMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.StreamListenerStatusRequest,
              ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse>(
                service, METHODID_STREAM_LISTENER_STATUS)))
        .addMethod(
          getStreamScheduledCallerStatusMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.StreamScheduledCallerStatusRequest,
              ondewo.vtsi.CallsOuterClass.StreamCallResourceStatusResponse>(
                service, METHODID_STREAM_SCHEDULED_CALLER_STATUS)))
        .addMethod(
          getInviteToCallMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.InviteToCallRequest,
              ondewo.vtsi.CallsOuterClass.InviteToCallResponse>(
                service, METHODID_INVITE_TO_CALL)))
        .addMethod(
          getRemoveCallParticipantMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.RemoveCallParticipantRequest,
              ondewo.vtsi.CallsOuterClass.RemoveCallParticipantResponse>(
                service, METHODID_REMOVE_CALL_PARTICIPANT)))
        .addMethod(
          getSetCallMediaControlMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.SetCallMediaControlRequest,
              ondewo.vtsi.CallsOuterClass.SetCallMediaControlResponse>(
                service, METHODID_SET_CALL_MEDIA_CONTROL)))
        .addMethod(
          getStreamCallAudioMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.StreamCallAudioRequest,
              ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse>(
                service, METHODID_STREAM_CALL_AUDIO)))
        .addMethod(
          getListenCallAudioMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              ondewo.vtsi.CallsOuterClass.ListenCallAudioRequest,
              ondewo.vtsi.CallsOuterClass.StreamCallAudioResponse>(
                service, METHODID_LISTEN_CALL_AUDIO)))
        .build();
  }

  private static abstract class CallsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CallsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ondewo.vtsi.CallsOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Calls");
    }
  }

  private static final class CallsFileDescriptorSupplier
      extends CallsBaseDescriptorSupplier {
    CallsFileDescriptorSupplier() {}
  }

  private static final class CallsMethodDescriptorSupplier
      extends CallsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CallsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CallsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CallsFileDescriptorSupplier())
              .addMethod(getStartCallerMethod())
              .addMethod(getStartCallersMethod())
              .addMethod(getListCallersMethod())
              .addMethod(getGetCallerMethod())
              .addMethod(getUpdateCallerMethod())
              .addMethod(getUpdateCallersMethod())
              .addMethod(getDeleteCallerMethod())
              .addMethod(getDeleteCallersMethod())
              .addMethod(getStopCallerMethod())
              .addMethod(getStopCallersMethod())
              .addMethod(getStartListenerMethod())
              .addMethod(getStartListenersMethod())
              .addMethod(getStopListenerMethod())
              .addMethod(getStopListenersMethod())
              .addMethod(getListListenersMethod())
              .addMethod(getGetListenerMethod())
              .addMethod(getUpdateListenerMethod())
              .addMethod(getUpdateListenersMethod())
              .addMethod(getDeleteListenerMethod())
              .addMethod(getDeleteListenersMethod())
              .addMethod(getStartScheduledCallerMethod())
              .addMethod(getStartScheduledCallersMethod())
              .addMethod(getAddCallersToCampaignMethod())
              .addMethod(getAddScheduledCallersToCampaignMethod())
              .addMethod(getGetScheduledCallerMethod())
              .addMethod(getListScheduledCallersMethod())
              .addMethod(getUpdateScheduledCallerMethod())
              .addMethod(getCancelScheduledCallerMethod())
              .addMethod(getCancelScheduledCallersMethod())
              .addMethod(getRetryScheduledCallerMethod())
              .addMethod(getStopCallMethod())
              .addMethod(getStopCallsMethod())
              .addMethod(getStopAllCallsMethod())
              .addMethod(getTransferCallMethod())
              .addMethod(getTransferCallsMethod())
              .addMethod(getGetCallMethod())
              .addMethod(getListCallsMethod())
              .addMethod(getGetCallStatisticsMethod())
              .addMethod(getUpdateCallMethod())
              .addMethod(getUpdateCallsMethod())
              .addMethod(getStreamCallerStatusMethod())
              .addMethod(getStreamListenerStatusMethod())
              .addMethod(getStreamScheduledCallerStatusMethod())
              .addMethod(getInviteToCallMethod())
              .addMethod(getRemoveCallParticipantMethod())
              .addMethod(getSetCallMediaControlMethod())
              .addMethod(getStreamCallAudioMethod())
              .addMethod(getListenCallAudioMethod())
              .build();
        }
      }
    }
    return result;
  }
}
