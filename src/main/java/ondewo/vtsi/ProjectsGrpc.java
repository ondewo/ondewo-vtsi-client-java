package ondewo.vtsi;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class ProjectsGrpc {

  private ProjectsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ondewo.vtsi.Projects";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest,
      ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse> getCreateVtsiProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateVtsiProject",
      requestType = ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest.class,
      responseType = ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest,
      ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse> getCreateVtsiProjectMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest, ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse> getCreateVtsiProjectMethod;
    if ((getCreateVtsiProjectMethod = ProjectsGrpc.getCreateVtsiProjectMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getCreateVtsiProjectMethod = ProjectsGrpc.getCreateVtsiProjectMethod) == null) {
          ProjectsGrpc.getCreateVtsiProjectMethod = getCreateVtsiProjectMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest, ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateVtsiProject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectsMethodDescriptorSupplier("CreateVtsiProject"))
              .build();
        }
      }
    }
    return getCreateVtsiProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest,
      ondewo.vtsi.ProjectsOuterClass.VtsiProject> getGetVtsiProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVtsiProject",
      requestType = ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest.class,
      responseType = ondewo.vtsi.ProjectsOuterClass.VtsiProject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest,
      ondewo.vtsi.ProjectsOuterClass.VtsiProject> getGetVtsiProjectMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest, ondewo.vtsi.ProjectsOuterClass.VtsiProject> getGetVtsiProjectMethod;
    if ((getGetVtsiProjectMethod = ProjectsGrpc.getGetVtsiProjectMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getGetVtsiProjectMethod = ProjectsGrpc.getGetVtsiProjectMethod) == null) {
          ProjectsGrpc.getGetVtsiProjectMethod = getGetVtsiProjectMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest, ondewo.vtsi.ProjectsOuterClass.VtsiProject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVtsiProject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.ProjectsOuterClass.VtsiProject.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectsMethodDescriptorSupplier("GetVtsiProject"))
              .build();
        }
      }
    }
    return getGetVtsiProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest,
      ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse> getUpdateVtsiProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVtsiProject",
      requestType = ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest.class,
      responseType = ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest,
      ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse> getUpdateVtsiProjectMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest, ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse> getUpdateVtsiProjectMethod;
    if ((getUpdateVtsiProjectMethod = ProjectsGrpc.getUpdateVtsiProjectMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getUpdateVtsiProjectMethod = ProjectsGrpc.getUpdateVtsiProjectMethod) == null) {
          ProjectsGrpc.getUpdateVtsiProjectMethod = getUpdateVtsiProjectMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest, ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateVtsiProject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectsMethodDescriptorSupplier("UpdateVtsiProject"))
              .build();
        }
      }
    }
    return getUpdateVtsiProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest,
      ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse> getDeleteVtsiProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteVtsiProject",
      requestType = ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest.class,
      responseType = ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest,
      ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse> getDeleteVtsiProjectMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest, ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse> getDeleteVtsiProjectMethod;
    if ((getDeleteVtsiProjectMethod = ProjectsGrpc.getDeleteVtsiProjectMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getDeleteVtsiProjectMethod = ProjectsGrpc.getDeleteVtsiProjectMethod) == null) {
          ProjectsGrpc.getDeleteVtsiProjectMethod = getDeleteVtsiProjectMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest, ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteVtsiProject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectsMethodDescriptorSupplier("DeleteVtsiProject"))
              .build();
        }
      }
    }
    return getDeleteVtsiProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest,
      ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse> getDeployVtsiProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeployVtsiProject",
      requestType = ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest.class,
      responseType = ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest,
      ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse> getDeployVtsiProjectMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest, ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse> getDeployVtsiProjectMethod;
    if ((getDeployVtsiProjectMethod = ProjectsGrpc.getDeployVtsiProjectMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getDeployVtsiProjectMethod = ProjectsGrpc.getDeployVtsiProjectMethod) == null) {
          ProjectsGrpc.getDeployVtsiProjectMethod = getDeployVtsiProjectMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest, ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeployVtsiProject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectsMethodDescriptorSupplier("DeployVtsiProject"))
              .build();
        }
      }
    }
    return getDeployVtsiProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest,
      ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse> getUndeployVtsiProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeployVtsiProject",
      requestType = ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest.class,
      responseType = ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest,
      ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse> getUndeployVtsiProjectMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest, ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse> getUndeployVtsiProjectMethod;
    if ((getUndeployVtsiProjectMethod = ProjectsGrpc.getUndeployVtsiProjectMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getUndeployVtsiProjectMethod = ProjectsGrpc.getUndeployVtsiProjectMethod) == null) {
          ProjectsGrpc.getUndeployVtsiProjectMethod = getUndeployVtsiProjectMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest, ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeployVtsiProject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectsMethodDescriptorSupplier("UndeployVtsiProject"))
              .build();
        }
      }
    }
    return getUndeployVtsiProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsRequest,
      ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsResponse> getListVtsiProjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVtsiProjects",
      requestType = ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsRequest.class,
      responseType = ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsRequest,
      ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsResponse> getListVtsiProjectsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsRequest, ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsResponse> getListVtsiProjectsMethod;
    if ((getListVtsiProjectsMethod = ProjectsGrpc.getListVtsiProjectsMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getListVtsiProjectsMethod = ProjectsGrpc.getListVtsiProjectsMethod) == null) {
          ProjectsGrpc.getListVtsiProjectsMethod = getListVtsiProjectsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsRequest, ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVtsiProjects"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectsMethodDescriptorSupplier("ListVtsiProjects"))
              .build();
        }
      }
    }
    return getListVtsiProjectsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProjectsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProjectsStub>() {
        @java.lang.Override
        public ProjectsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProjectsStub(channel, callOptions);
        }
      };
    return ProjectsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static ProjectsBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectsBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProjectsBlockingV2Stub>() {
        @java.lang.Override
        public ProjectsBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProjectsBlockingV2Stub(channel, callOptions);
        }
      };
    return ProjectsBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProjectsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProjectsBlockingStub>() {
        @java.lang.Override
        public ProjectsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProjectsBlockingStub(channel, callOptions);
        }
      };
    return ProjectsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProjectsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProjectsFutureStub>() {
        @java.lang.Override
        public ProjectsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProjectsFutureStub(channel, callOptions);
        }
      };
    return ProjectsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * &lt;p&gt;Create a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    default void createVtsiProject(ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateVtsiProjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Get a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    default void getVtsiProject(ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.VtsiProject> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVtsiProjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Update a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    default void updateVtsiProject(ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateVtsiProjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Delete a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    default void deleteVtsiProject(ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteVtsiProjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deploy a VTSI project&lt;/p&gt;
     * </pre>
     */
    default void deployVtsiProject(ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeployVtsiProjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Undeploy a VTSI project&lt;/p&gt;
     * </pre>
     */
    default void undeployVtsiProject(ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUndeployVtsiProjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Get a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    default void listVtsiProjects(ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListVtsiProjectsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Projects.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public static abstract class ProjectsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ProjectsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Projects.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public static final class ProjectsStub
      extends io.grpc.stub.AbstractAsyncStub<ProjectsStub> {
    private ProjectsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectsStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Create a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public void createVtsiProject(ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVtsiProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Get a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public void getVtsiProject(ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.VtsiProject> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVtsiProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Update a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public void updateVtsiProject(ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVtsiProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Delete a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public void deleteVtsiProject(ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVtsiProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deploy a VTSI project&lt;/p&gt;
     * </pre>
     */
    public void deployVtsiProject(ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeployVtsiProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Undeploy a VTSI project&lt;/p&gt;
     * </pre>
     */
    public void undeployVtsiProject(ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeployVtsiProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Get a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public void listVtsiProjects(ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVtsiProjectsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Projects.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public static final class ProjectsBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ProjectsBlockingV2Stub> {
    private ProjectsBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectsBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectsBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Create a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse createVtsiProject(ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Get a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.VtsiProject getVtsiProject(ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Update a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse updateVtsiProject(ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Delete a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse deleteVtsiProject(ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deploy a VTSI project&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse deployVtsiProject(ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeployVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Undeploy a VTSI project&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse undeployVtsiProject(ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUndeployVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Get a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsResponse listVtsiProjects(ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListVtsiProjectsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Projects.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public static final class ProjectsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProjectsBlockingStub> {
    private ProjectsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Create a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse createVtsiProject(ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Get a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.VtsiProject getVtsiProject(ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Update a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse updateVtsiProject(ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Delete a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse deleteVtsiProject(ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deploy a VTSI project&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse deployVtsiProject(ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Undeploy a VTSI project&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse undeployVtsiProject(ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeployVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Get a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsResponse listVtsiProjects(ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVtsiProjectsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Projects.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * </pre>
   */
  public static final class ProjectsFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProjectsFutureStub> {
    private ProjectsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Create a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse> createVtsiProject(
        ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVtsiProjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Get a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.ProjectsOuterClass.VtsiProject> getVtsiProject(
        ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVtsiProjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Update a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse> updateVtsiProject(
        ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVtsiProjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Delete a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse> deleteVtsiProject(
        ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVtsiProjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deploy a VTSI project&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse> deployVtsiProject(
        ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeployVtsiProjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Undeploy a VTSI project&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse> undeployVtsiProject(
        ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeployVtsiProjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Get a VTSI project with configs&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsResponse> listVtsiProjects(
        ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVtsiProjectsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_VTSI_PROJECT = 0;
  private static final int METHODID_GET_VTSI_PROJECT = 1;
  private static final int METHODID_UPDATE_VTSI_PROJECT = 2;
  private static final int METHODID_DELETE_VTSI_PROJECT = 3;
  private static final int METHODID_DEPLOY_VTSI_PROJECT = 4;
  private static final int METHODID_UNDEPLOY_VTSI_PROJECT = 5;
  private static final int METHODID_LIST_VTSI_PROJECTS = 6;

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
        case METHODID_CREATE_VTSI_PROJECT:
          serviceImpl.createVtsiProject((ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse>) responseObserver);
          break;
        case METHODID_GET_VTSI_PROJECT:
          serviceImpl.getVtsiProject((ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.VtsiProject>) responseObserver);
          break;
        case METHODID_UPDATE_VTSI_PROJECT:
          serviceImpl.updateVtsiProject((ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse>) responseObserver);
          break;
        case METHODID_DELETE_VTSI_PROJECT:
          serviceImpl.deleteVtsiProject((ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse>) responseObserver);
          break;
        case METHODID_DEPLOY_VTSI_PROJECT:
          serviceImpl.deployVtsiProject((ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse>) responseObserver);
          break;
        case METHODID_UNDEPLOY_VTSI_PROJECT:
          serviceImpl.undeployVtsiProject((ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse>) responseObserver);
          break;
        case METHODID_LIST_VTSI_PROJECTS:
          serviceImpl.listVtsiProjects((ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsResponse>) responseObserver);
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
          getCreateVtsiProjectMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest,
              ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse>(
                service, METHODID_CREATE_VTSI_PROJECT)))
        .addMethod(
          getGetVtsiProjectMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest,
              ondewo.vtsi.ProjectsOuterClass.VtsiProject>(
                service, METHODID_GET_VTSI_PROJECT)))
        .addMethod(
          getUpdateVtsiProjectMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest,
              ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse>(
                service, METHODID_UPDATE_VTSI_PROJECT)))
        .addMethod(
          getDeleteVtsiProjectMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest,
              ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse>(
                service, METHODID_DELETE_VTSI_PROJECT)))
        .addMethod(
          getDeployVtsiProjectMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest,
              ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse>(
                service, METHODID_DEPLOY_VTSI_PROJECT)))
        .addMethod(
          getUndeployVtsiProjectMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest,
              ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse>(
                service, METHODID_UNDEPLOY_VTSI_PROJECT)))
        .addMethod(
          getListVtsiProjectsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsRequest,
              ondewo.vtsi.ProjectsOuterClass.ListVtsiProjectsResponse>(
                service, METHODID_LIST_VTSI_PROJECTS)))
        .build();
  }

  private static abstract class ProjectsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProjectsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ondewo.vtsi.ProjectsOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Projects");
    }
  }

  private static final class ProjectsFileDescriptorSupplier
      extends ProjectsBaseDescriptorSupplier {
    ProjectsFileDescriptorSupplier() {}
  }

  private static final class ProjectsMethodDescriptorSupplier
      extends ProjectsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ProjectsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ProjectsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProjectsFileDescriptorSupplier())
              .addMethod(getCreateVtsiProjectMethod())
              .addMethod(getGetVtsiProjectMethod())
              .addMethod(getUpdateVtsiProjectMethod())
              .addMethod(getDeleteVtsiProjectMethod())
              .addMethod(getDeployVtsiProjectMethod())
              .addMethod(getUndeployVtsiProjectMethod())
              .addMethod(getListVtsiProjectsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
