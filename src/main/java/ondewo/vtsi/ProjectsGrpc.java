package ondewo.vtsi;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
 * &lt;p&gt;Manages VTSI (Virtual Telephone System Integration) PROJECTS: the per-project configuration of an
 * Asterisk SIP server (its SIP trunk, its ports, its Asterisk version) together with the caller and
 * listener capacity of the project and the ONDEWO NLU agents it serves. Deploying a project starts its
 * Asterisk container; callers, listeners, campaigns and softphone accounts of the project need a
 * &lt;code&gt;DEPLOYED&lt;/code&gt; project to place or take calls.&lt;/p&gt;
 * &lt;p&gt;Errors are reported as gRPC status codes. The &lt;code&gt;error_message&lt;/code&gt; fields of the responses
 * are never set, neither on success nor on failure (they predate the status codes and are kept for wire
 * compatibility): &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, an unknown &lt;code&gt;update_mask&lt;/code&gt;
 * or &lt;code&gt;field_mask&lt;/code&gt; path, a malformed &lt;code&gt;page_token&lt;/code&gt; or an out-of-range value (each
 * naming the field); &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when
 * &lt;code&gt;CreateVtsiProject&lt;/code&gt; names a project that exists; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the
 * project is in a status that does not allow the operation (each RPC names its cases);
 * &lt;code&gt;ABORTED&lt;/code&gt; when another create, update, deploy, undeploy or delete of the same project held
 * it for longer than the server waits (about 30 seconds), in which case nothing was changed and the
 * request can be retried; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the docker daemon or the database cannot be
 * reached.&lt;/p&gt;
 * &lt;p&gt;Authorization (only when the server enforces it, i.e. &lt;code&gt;ONDEWO_VTSI_KEYCLOAK_AUTH_ENABLED&lt;/code&gt;
 * and &lt;code&gt;ONDEWO_VTSI_AUTH_REQUIRED&lt;/code&gt; are both true): a caller without a credential is
 * &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; whatever it sent. A caller needs a server role (&lt;code&gt;SERVER_ADMIN&lt;/code&gt;,
 * &lt;code&gt;SERVER_MANAGER&lt;/code&gt; or &lt;code&gt;SERVER_USER&lt;/code&gt;), else every RPC is
 * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;. The project roles are derived from the caller&amp;apos;s roles on the
 * project&amp;apos;s &lt;code&gt;nlu_agent_names&lt;/code&gt;: &lt;code&gt;CreateVtsiProject&lt;/code&gt;,
 * &lt;code&gt;GetVtsiProject&lt;/code&gt;, &lt;code&gt;UpdateVtsiProject&lt;/code&gt;, &lt;code&gt;DeleteVtsiProject&lt;/code&gt;,
 * &lt;code&gt;DeployVtsiProject&lt;/code&gt; and &lt;code&gt;UndeployVtsiProject&lt;/code&gt; require
 * &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher (&lt;code&gt;PROJECT_ADMIN&lt;/code&gt;); &lt;code&gt;ListVtsiProjects&lt;/code&gt;
 * is open to every project role and returns only the projects the caller holds a role on.
 * &lt;code&gt;SERVER_ADMIN&lt;/code&gt; passes every project check. With enforcement on, a well-formed request naming
 * a project the caller holds no role on, an unknown project included, is answered
 * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; rather than &lt;code&gt;NOT_FOUND&lt;/code&gt;, so the answer does not reveal
 * whether the project exists; &lt;code&gt;NOT_FOUND&lt;/code&gt; is then reserved to &lt;code&gt;SERVER_ADMIN&lt;/code&gt;. With
 * enforcement off (the default) every request is served and only logged.&lt;/p&gt;
 * &lt;p&gt;&lt;b&gt;Credentials.&lt;/b&gt; &lt;code&gt;AsteriskConfigsVariables.sip_trunk_password&lt;/code&gt; is stored and returned
 * as sent (it is not write-only): &lt;code&gt;GetVtsiProject&lt;/code&gt;, &lt;code&gt;CreateVtsiProject&lt;/code&gt;,
 * &lt;code&gt;UpdateVtsiProject&lt;/code&gt; and &lt;code&gt;ListVtsiProjects&lt;/code&gt; return it to every caller allowed to
 * call them with a view that populates &lt;code&gt;asterisk_configs&lt;/code&gt;. With enforcement on,
 * &lt;code&gt;ListVtsiProjects&lt;/code&gt; withholds the whole &lt;code&gt;asterisk_configs&lt;/code&gt; (and every other
 * configuration field) from a caller whose highest role on the project is &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;
 * or &lt;code&gt;PROJECT_USER&lt;/code&gt;. Use a &lt;code&gt;field_mask&lt;/code&gt; without &lt;code&gt;asterisk_configs&lt;/code&gt; where
 * the password is not needed.&lt;/p&gt;
 * &lt;p&gt;Events: every change emits the matching &lt;code&gt;VtsiEvent&lt;/code&gt; of the project
 * (&lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UPDATED&lt;/code&gt;, &lt;code&gt;_DEPLOYED&lt;/code&gt;, &lt;code&gt;_DEPLOY_FAILED&lt;/code&gt;,
 * &lt;code&gt;_UNDEPLOYED&lt;/code&gt;, &lt;code&gt;_UNDEPLOY_FAILED&lt;/code&gt;, &lt;code&gt;_DELETED&lt;/code&gt;) and, for every change
 * of &lt;code&gt;vtsi_project_status&lt;/code&gt;, &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_STATUS_CHANGED&lt;/code&gt;. A request
 * with &lt;code&gt;validate_only&lt;/code&gt; emits nothing.&lt;/p&gt;
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
   * &lt;p&gt;Manages VTSI (Virtual Telephone System Integration) PROJECTS: the per-project configuration of an
   * Asterisk SIP server (its SIP trunk, its ports, its Asterisk version) together with the caller and
   * listener capacity of the project and the ONDEWO NLU agents it serves. Deploying a project starts its
   * Asterisk container; callers, listeners, campaigns and softphone accounts of the project need a
   * &lt;code&gt;DEPLOYED&lt;/code&gt; project to place or take calls.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes. The &lt;code&gt;error_message&lt;/code&gt; fields of the responses
   * are never set, neither on success nor on failure (they predate the status codes and are kept for wire
   * compatibility): &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, an unknown &lt;code&gt;update_mask&lt;/code&gt;
   * or &lt;code&gt;field_mask&lt;/code&gt; path, a malformed &lt;code&gt;page_token&lt;/code&gt; or an out-of-range value (each
   * naming the field); &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when
   * &lt;code&gt;CreateVtsiProject&lt;/code&gt; names a project that exists; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the
   * project is in a status that does not allow the operation (each RPC names its cases);
   * &lt;code&gt;ABORTED&lt;/code&gt; when another create, update, deploy, undeploy or delete of the same project held
   * it for longer than the server waits (about 30 seconds), in which case nothing was changed and the
   * request can be retried; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the docker daemon or the database cannot be
   * reached.&lt;/p&gt;
   * &lt;p&gt;Authorization (only when the server enforces it, i.e. &lt;code&gt;ONDEWO_VTSI_KEYCLOAK_AUTH_ENABLED&lt;/code&gt;
   * and &lt;code&gt;ONDEWO_VTSI_AUTH_REQUIRED&lt;/code&gt; are both true): a caller without a credential is
   * &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; whatever it sent. A caller needs a server role (&lt;code&gt;SERVER_ADMIN&lt;/code&gt;,
   * &lt;code&gt;SERVER_MANAGER&lt;/code&gt; or &lt;code&gt;SERVER_USER&lt;/code&gt;), else every RPC is
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;. The project roles are derived from the caller&amp;apos;s roles on the
   * project&amp;apos;s &lt;code&gt;nlu_agent_names&lt;/code&gt;: &lt;code&gt;CreateVtsiProject&lt;/code&gt;,
   * &lt;code&gt;GetVtsiProject&lt;/code&gt;, &lt;code&gt;UpdateVtsiProject&lt;/code&gt;, &lt;code&gt;DeleteVtsiProject&lt;/code&gt;,
   * &lt;code&gt;DeployVtsiProject&lt;/code&gt; and &lt;code&gt;UndeployVtsiProject&lt;/code&gt; require
   * &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher (&lt;code&gt;PROJECT_ADMIN&lt;/code&gt;); &lt;code&gt;ListVtsiProjects&lt;/code&gt;
   * is open to every project role and returns only the projects the caller holds a role on.
   * &lt;code&gt;SERVER_ADMIN&lt;/code&gt; passes every project check. With enforcement on, a well-formed request naming
   * a project the caller holds no role on, an unknown project included, is answered
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; rather than &lt;code&gt;NOT_FOUND&lt;/code&gt;, so the answer does not reveal
   * whether the project exists; &lt;code&gt;NOT_FOUND&lt;/code&gt; is then reserved to &lt;code&gt;SERVER_ADMIN&lt;/code&gt;. With
   * enforcement off (the default) every request is served and only logged.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Credentials.&lt;/b&gt; &lt;code&gt;AsteriskConfigsVariables.sip_trunk_password&lt;/code&gt; is stored and returned
   * as sent (it is not write-only): &lt;code&gt;GetVtsiProject&lt;/code&gt;, &lt;code&gt;CreateVtsiProject&lt;/code&gt;,
   * &lt;code&gt;UpdateVtsiProject&lt;/code&gt; and &lt;code&gt;ListVtsiProjects&lt;/code&gt; return it to every caller allowed to
   * call them with a view that populates &lt;code&gt;asterisk_configs&lt;/code&gt;. With enforcement on,
   * &lt;code&gt;ListVtsiProjects&lt;/code&gt; withholds the whole &lt;code&gt;asterisk_configs&lt;/code&gt; (and every other
   * configuration field) from a caller whose highest role on the project is &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;
   * or &lt;code&gt;PROJECT_USER&lt;/code&gt;. Use a &lt;code&gt;field_mask&lt;/code&gt; without &lt;code&gt;asterisk_configs&lt;/code&gt; where
   * the password is not needed.&lt;/p&gt;
   * &lt;p&gt;Events: every change emits the matching &lt;code&gt;VtsiEvent&lt;/code&gt; of the project
   * (&lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UPDATED&lt;/code&gt;, &lt;code&gt;_DEPLOYED&lt;/code&gt;, &lt;code&gt;_DEPLOY_FAILED&lt;/code&gt;,
   * &lt;code&gt;_UNDEPLOYED&lt;/code&gt;, &lt;code&gt;_UNDEPLOY_FAILED&lt;/code&gt;, &lt;code&gt;_DELETED&lt;/code&gt;) and, for every change
   * of &lt;code&gt;vtsi_project_status&lt;/code&gt;, &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_STATUS_CHANGED&lt;/code&gt;. A request
   * with &lt;code&gt;validate_only&lt;/code&gt; emits nothing.&lt;/p&gt;
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * &lt;p&gt;Creates a VTSI project with its configuration. The project is created
     * &lt;code&gt;UNDEPLOYED&lt;/code&gt;; nothing is started. &lt;code&gt;max_callers&lt;/code&gt; caller and
     * &lt;code&gt;max_listeners&lt;/code&gt; listener SIP accounts are provisioned for it and an Asterisk port is
     * assigned when none was given.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;validate_only&lt;/code&gt; every check of a real create runs (authorization included) and
     * nothing is written, reserved or emitted; the would-be project is returned.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or over-long (more than 256 characters)
     * &lt;code&gt;display_name&lt;/code&gt;, a negative &lt;code&gt;max_callers&lt;/code&gt; or &lt;code&gt;max_listeners&lt;/code&gt;, a port
     * outside 0..65535, &lt;code&gt;asterisk_port&lt;/code&gt; and &lt;code&gt;asterisk_configs.asterisk_port&lt;/code&gt; both set
     * and different, a malformed &lt;code&gt;name&lt;/code&gt;, an invalid &lt;code&gt;asterisk_configs&lt;/code&gt; (each naming
     * the field); &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when
     * &lt;code&gt;vtsi_project.name&lt;/code&gt; names an existing project (also when two creates of the same name
     * race); &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;, &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the
     * service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on EVERY agent of
     * &lt;code&gt;nlu_agent_names&lt;/code&gt;; a project with no agent can only be created by
     * &lt;code&gt;SERVER_ADMIN&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Idempotency: none. A retry after a lost response creates a second project unless
     * &lt;code&gt;vtsi_project.name&lt;/code&gt; is set, in which case the retry is answered
     * &lt;code&gt;ALREADY_EXISTS&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void createVtsiProject(ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateVtsiProjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a VTSI project with its configuration.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project;
     * &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;, &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    default void getVtsiProject(ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.VtsiProject> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVtsiProjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates a VTSI project: the fields named in &lt;code&gt;update_mask&lt;/code&gt;, or, with no mask, the
     * fields &lt;code&gt;vtsi_project&lt;/code&gt; sets (see &lt;code&gt;UpdateVtsiProjectRequest.update_mask&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;An update of an &lt;code&gt;UNDEPLOYED&lt;/code&gt; project only writes it. An update of a
     * &lt;code&gt;DEPLOYED&lt;/code&gt; project is applied to the running Asterisk by the cheapest path that applies
     * every change, chosen by the server: &lt;code&gt;display_name&lt;/code&gt;, &lt;code&gt;nlu_agent_names&lt;/code&gt; and
     * &lt;code&gt;transfer_phone_number_allowlist&lt;/code&gt; touch no Asterisk; a configuration change that Asterisk
     * measurably applies on a reload is reloaded in place and keeps every call; every other change is a
     * RESTART of the Asterisk container or a REDEPLOY of the project (a changed &lt;code&gt;max_callers&lt;/code&gt;,
     * &lt;code&gt;max_listeners&lt;/code&gt;, Asterisk port, &lt;code&gt;asterisk_version&lt;/code&gt; or managed account), and
     * ENDS EVERY CALL of the project: a redeploy undeploys and deploys the project and recycles its
     * listeners and pooled callers. Use &lt;code&gt;validate_only&lt;/code&gt; to check an update first.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;vtsi_project.name&lt;/code&gt;,
     * an unknown &lt;code&gt;update_mask&lt;/code&gt; path (also the prefixed form &lt;code&gt;vtsi_project.x&lt;/code&gt;), a mask
     * that clears the configuration source (&lt;code&gt;asterisk_configs&lt;/code&gt; with no arm set), an out-of-range
     * value (as on create) or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an
     * unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the project is &lt;code&gt;DELETING&lt;/code&gt;;
     * &lt;code&gt;ABORTED&lt;/code&gt; when another lifecycle operation of the project held it too long or the
     * project changed concurrently, nothing being written; &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;,
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description. When a deployed project&amp;apos;s
     * Asterisk cannot be reloaded, restarted or redeployed the RPC fails (&lt;code&gt;INTERNAL&lt;/code&gt; or
     * &lt;code&gt;UNAVAILABLE&lt;/code&gt;) and the project is left as the failure left it (see
     * &lt;code&gt;status_message&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project and on every agent of the
     * stored AND of the resulting &lt;code&gt;nlu_agent_names&lt;/code&gt; (removing an agent needs the same role as
     * adding it).&lt;/p&gt;
     * &lt;p&gt;Idempotency: an update is a set of absolute values, so a retry with the same request converges
     * to the same project (a redeploying update ends the calls of the retry&amp;apos;s moment too).&lt;/p&gt;
     * </pre>
     */
    default void updateVtsiProject(ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateVtsiProjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a VTSI project and its configuration. A project that is deployed, deploying,
     * undeploying or &lt;code&gt;DEPLOY_FAILED&lt;/code&gt; is UNDEPLOYED FIRST, automatically, exactly as by &lt;code&gt;UndeployVtsiProject&lt;/code&gt;:
     * every call of the project ends and its listeners, callers and Asterisk container are removed. The
     * undeploy is best effort: a failing teardown is logged and the deletion goes on. The project then
     * moves to &lt;code&gt;DELETING&lt;/code&gt;, its stored configuration is removed and the project no longer
     * exists (&lt;code&gt;DELETED&lt;/code&gt; is never returned: a deleted
     * project is &lt;code&gt;NOT_FOUND&lt;/code&gt;). Deletion is permanent.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, also for a retry of a deletion that succeeded (the
     * RPC is not idempotent); &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;,
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UNDEPLOYED&lt;/code&gt; when it had to undeploy, then
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DELETED&lt;/code&gt;, the last event of the project.&lt;/p&gt;
     * </pre>
     */
    default void deleteVtsiProject(ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteVtsiProjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deploys a VTSI project: starts its Asterisk container with the stored configuration and waits
     * until the container runs. SYNCHRONOUS: the RPC returns when the project is &lt;code&gt;DEPLOYED&lt;/code&gt;
     * or the deployment failed. The status moves &lt;code&gt;UNDEPLOYED&lt;/code&gt; (or &lt;code&gt;DEPLOY_FAILED&lt;/code&gt;)
     * &amp;gt; &lt;code&gt;DEPLOYING&lt;/code&gt; &amp;gt; &lt;code&gt;DEPLOYED&lt;/code&gt;; on failure the half-started container is
     * removed, the status becomes &lt;code&gt;DEPLOY_FAILED&lt;/code&gt; with the reason in
     * &lt;code&gt;status_message&lt;/code&gt;, and the RPC fails. The server waits about 30 seconds for the container
     * to run, plus the docker API timeout of each docker call (&lt;code&gt;ONDEWO_VTSI_DOCKER_API_TIMEOUT_S&lt;/code&gt;,
     * default 90 seconds); a client deadline of at least 3 minutes is recommended. Deploying applies the
     * project&amp;apos;s softphone accounts to the new Asterisk. No caller or listener is started: start them
     * with the &lt;code&gt;Calls&lt;/code&gt; service.&lt;/p&gt;
     * &lt;p&gt;Idempotent: deploying a &lt;code&gt;DEPLOYED&lt;/code&gt; project changes nothing and succeeds (nothing is
     * restarted); a deploy that arrives while another deploy of the project runs waits for it and then
     * finds the project &lt;code&gt;DEPLOYED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the project is
     * &lt;code&gt;DELETING&lt;/code&gt;, or &lt;code&gt;DEPLOYING&lt;/code&gt; / &lt;code&gt;UNDEPLOYING&lt;/code&gt; after the operation that
     * set the status was interrupted (undeploy the project first); &lt;code&gt;INTERNAL&lt;/code&gt; or
     * &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the deployment failed (the project is then
     * &lt;code&gt;DEPLOY_FAILED&lt;/code&gt;); &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;,
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DEPLOYED&lt;/code&gt; or
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DEPLOY_FAILED&lt;/code&gt;, and
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_STATUS_CHANGED&lt;/code&gt; per status change.&lt;/p&gt;
     * </pre>
     */
    default void deployVtsiProject(ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeployVtsiProjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Undeploys a VTSI project. SYNCHRONOUS: the status moves to &lt;code&gt;UNDEPLOYING&lt;/code&gt;, EVERY CALL
     * of the project is ended (callers and listeners alike, campaign calls included), the listeners and
     * the pooled callers are undeployed, the Asterisk container is removed, and the status becomes
     * &lt;code&gt;UNDEPLOYED&lt;/code&gt;. The registrations of the project&amp;apos;s softphone accounts end with the
     * container; the accounts themselves are kept and are applied again on the next deploy. The stored
     * configuration, callers, listeners and campaigns are kept. A failed undeploy restores the previous
     * status (or &lt;code&gt;UNDEPLOYED&lt;/code&gt; when the container is already gone) and fails the RPC.&lt;/p&gt;
     * &lt;p&gt;Idempotent: undeploying an &lt;code&gt;UNDEPLOYED&lt;/code&gt; project changes nothing and succeeds.
     * Undeploying a &lt;code&gt;DEPLOY_FAILED&lt;/code&gt; project removes what the failed deployment left and makes it
     * &lt;code&gt;UNDEPLOYED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the project is
     * &lt;code&gt;DELETING&lt;/code&gt;; &lt;code&gt;INTERNAL&lt;/code&gt; or &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the teardown failed;
     * &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;, &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service
     * description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UNDEPLOYED&lt;/code&gt; or
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UNDEPLOY_FAILED&lt;/code&gt;, and
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_STATUS_CHANGED&lt;/code&gt; per status change.&lt;/p&gt;
     * </pre>
     */
    default void undeployVtsiProject(ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUndeployVtsiProjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists VTSI projects, filtered, sorted and paged. With authorization enforced, only the projects
     * the caller holds a project role on are listed (every project for &lt;code&gt;SERVER_ADMIN&lt;/code&gt;), and
     * the configuration fields are withheld from a &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or
     * &lt;code&gt;PROJECT_USER&lt;/code&gt; (see the service description); a caller without a usable credential gets an
     * empty page.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a negative &lt;code&gt;page_size&lt;/code&gt;, a malformed
     * &lt;code&gt;page_token&lt;/code&gt;, an unspecified status in &lt;code&gt;statuses&lt;/code&gt;, an over-long
     * &lt;code&gt;display_name_contains&lt;/code&gt;, a &lt;code&gt;created_after&lt;/code&gt; that is not before
     * &lt;code&gt;created_before&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: any project role (&lt;code&gt;PROJECT_USER&lt;/code&gt; or higher).&lt;/p&gt;
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
   * &lt;p&gt;Manages VTSI (Virtual Telephone System Integration) PROJECTS: the per-project configuration of an
   * Asterisk SIP server (its SIP trunk, its ports, its Asterisk version) together with the caller and
   * listener capacity of the project and the ONDEWO NLU agents it serves. Deploying a project starts its
   * Asterisk container; callers, listeners, campaigns and softphone accounts of the project need a
   * &lt;code&gt;DEPLOYED&lt;/code&gt; project to place or take calls.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes. The &lt;code&gt;error_message&lt;/code&gt; fields of the responses
   * are never set, neither on success nor on failure (they predate the status codes and are kept for wire
   * compatibility): &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, an unknown &lt;code&gt;update_mask&lt;/code&gt;
   * or &lt;code&gt;field_mask&lt;/code&gt; path, a malformed &lt;code&gt;page_token&lt;/code&gt; or an out-of-range value (each
   * naming the field); &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when
   * &lt;code&gt;CreateVtsiProject&lt;/code&gt; names a project that exists; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the
   * project is in a status that does not allow the operation (each RPC names its cases);
   * &lt;code&gt;ABORTED&lt;/code&gt; when another create, update, deploy, undeploy or delete of the same project held
   * it for longer than the server waits (about 30 seconds), in which case nothing was changed and the
   * request can be retried; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the docker daemon or the database cannot be
   * reached.&lt;/p&gt;
   * &lt;p&gt;Authorization (only when the server enforces it, i.e. &lt;code&gt;ONDEWO_VTSI_KEYCLOAK_AUTH_ENABLED&lt;/code&gt;
   * and &lt;code&gt;ONDEWO_VTSI_AUTH_REQUIRED&lt;/code&gt; are both true): a caller without a credential is
   * &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; whatever it sent. A caller needs a server role (&lt;code&gt;SERVER_ADMIN&lt;/code&gt;,
   * &lt;code&gt;SERVER_MANAGER&lt;/code&gt; or &lt;code&gt;SERVER_USER&lt;/code&gt;), else every RPC is
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;. The project roles are derived from the caller&amp;apos;s roles on the
   * project&amp;apos;s &lt;code&gt;nlu_agent_names&lt;/code&gt;: &lt;code&gt;CreateVtsiProject&lt;/code&gt;,
   * &lt;code&gt;GetVtsiProject&lt;/code&gt;, &lt;code&gt;UpdateVtsiProject&lt;/code&gt;, &lt;code&gt;DeleteVtsiProject&lt;/code&gt;,
   * &lt;code&gt;DeployVtsiProject&lt;/code&gt; and &lt;code&gt;UndeployVtsiProject&lt;/code&gt; require
   * &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher (&lt;code&gt;PROJECT_ADMIN&lt;/code&gt;); &lt;code&gt;ListVtsiProjects&lt;/code&gt;
   * is open to every project role and returns only the projects the caller holds a role on.
   * &lt;code&gt;SERVER_ADMIN&lt;/code&gt; passes every project check. With enforcement on, a well-formed request naming
   * a project the caller holds no role on, an unknown project included, is answered
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; rather than &lt;code&gt;NOT_FOUND&lt;/code&gt;, so the answer does not reveal
   * whether the project exists; &lt;code&gt;NOT_FOUND&lt;/code&gt; is then reserved to &lt;code&gt;SERVER_ADMIN&lt;/code&gt;. With
   * enforcement off (the default) every request is served and only logged.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Credentials.&lt;/b&gt; &lt;code&gt;AsteriskConfigsVariables.sip_trunk_password&lt;/code&gt; is stored and returned
   * as sent (it is not write-only): &lt;code&gt;GetVtsiProject&lt;/code&gt;, &lt;code&gt;CreateVtsiProject&lt;/code&gt;,
   * &lt;code&gt;UpdateVtsiProject&lt;/code&gt; and &lt;code&gt;ListVtsiProjects&lt;/code&gt; return it to every caller allowed to
   * call them with a view that populates &lt;code&gt;asterisk_configs&lt;/code&gt;. With enforcement on,
   * &lt;code&gt;ListVtsiProjects&lt;/code&gt; withholds the whole &lt;code&gt;asterisk_configs&lt;/code&gt; (and every other
   * configuration field) from a caller whose highest role on the project is &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;
   * or &lt;code&gt;PROJECT_USER&lt;/code&gt;. Use a &lt;code&gt;field_mask&lt;/code&gt; without &lt;code&gt;asterisk_configs&lt;/code&gt; where
   * the password is not needed.&lt;/p&gt;
   * &lt;p&gt;Events: every change emits the matching &lt;code&gt;VtsiEvent&lt;/code&gt; of the project
   * (&lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UPDATED&lt;/code&gt;, &lt;code&gt;_DEPLOYED&lt;/code&gt;, &lt;code&gt;_DEPLOY_FAILED&lt;/code&gt;,
   * &lt;code&gt;_UNDEPLOYED&lt;/code&gt;, &lt;code&gt;_UNDEPLOY_FAILED&lt;/code&gt;, &lt;code&gt;_DELETED&lt;/code&gt;) and, for every change
   * of &lt;code&gt;vtsi_project_status&lt;/code&gt;, &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_STATUS_CHANGED&lt;/code&gt;. A request
   * with &lt;code&gt;validate_only&lt;/code&gt; emits nothing.&lt;/p&gt;
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
   * &lt;p&gt;Manages VTSI (Virtual Telephone System Integration) PROJECTS: the per-project configuration of an
   * Asterisk SIP server (its SIP trunk, its ports, its Asterisk version) together with the caller and
   * listener capacity of the project and the ONDEWO NLU agents it serves. Deploying a project starts its
   * Asterisk container; callers, listeners, campaigns and softphone accounts of the project need a
   * &lt;code&gt;DEPLOYED&lt;/code&gt; project to place or take calls.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes. The &lt;code&gt;error_message&lt;/code&gt; fields of the responses
   * are never set, neither on success nor on failure (they predate the status codes and are kept for wire
   * compatibility): &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, an unknown &lt;code&gt;update_mask&lt;/code&gt;
   * or &lt;code&gt;field_mask&lt;/code&gt; path, a malformed &lt;code&gt;page_token&lt;/code&gt; or an out-of-range value (each
   * naming the field); &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when
   * &lt;code&gt;CreateVtsiProject&lt;/code&gt; names a project that exists; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the
   * project is in a status that does not allow the operation (each RPC names its cases);
   * &lt;code&gt;ABORTED&lt;/code&gt; when another create, update, deploy, undeploy or delete of the same project held
   * it for longer than the server waits (about 30 seconds), in which case nothing was changed and the
   * request can be retried; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the docker daemon or the database cannot be
   * reached.&lt;/p&gt;
   * &lt;p&gt;Authorization (only when the server enforces it, i.e. &lt;code&gt;ONDEWO_VTSI_KEYCLOAK_AUTH_ENABLED&lt;/code&gt;
   * and &lt;code&gt;ONDEWO_VTSI_AUTH_REQUIRED&lt;/code&gt; are both true): a caller without a credential is
   * &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; whatever it sent. A caller needs a server role (&lt;code&gt;SERVER_ADMIN&lt;/code&gt;,
   * &lt;code&gt;SERVER_MANAGER&lt;/code&gt; or &lt;code&gt;SERVER_USER&lt;/code&gt;), else every RPC is
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;. The project roles are derived from the caller&amp;apos;s roles on the
   * project&amp;apos;s &lt;code&gt;nlu_agent_names&lt;/code&gt;: &lt;code&gt;CreateVtsiProject&lt;/code&gt;,
   * &lt;code&gt;GetVtsiProject&lt;/code&gt;, &lt;code&gt;UpdateVtsiProject&lt;/code&gt;, &lt;code&gt;DeleteVtsiProject&lt;/code&gt;,
   * &lt;code&gt;DeployVtsiProject&lt;/code&gt; and &lt;code&gt;UndeployVtsiProject&lt;/code&gt; require
   * &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher (&lt;code&gt;PROJECT_ADMIN&lt;/code&gt;); &lt;code&gt;ListVtsiProjects&lt;/code&gt;
   * is open to every project role and returns only the projects the caller holds a role on.
   * &lt;code&gt;SERVER_ADMIN&lt;/code&gt; passes every project check. With enforcement on, a well-formed request naming
   * a project the caller holds no role on, an unknown project included, is answered
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; rather than &lt;code&gt;NOT_FOUND&lt;/code&gt;, so the answer does not reveal
   * whether the project exists; &lt;code&gt;NOT_FOUND&lt;/code&gt; is then reserved to &lt;code&gt;SERVER_ADMIN&lt;/code&gt;. With
   * enforcement off (the default) every request is served and only logged.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Credentials.&lt;/b&gt; &lt;code&gt;AsteriskConfigsVariables.sip_trunk_password&lt;/code&gt; is stored and returned
   * as sent (it is not write-only): &lt;code&gt;GetVtsiProject&lt;/code&gt;, &lt;code&gt;CreateVtsiProject&lt;/code&gt;,
   * &lt;code&gt;UpdateVtsiProject&lt;/code&gt; and &lt;code&gt;ListVtsiProjects&lt;/code&gt; return it to every caller allowed to
   * call them with a view that populates &lt;code&gt;asterisk_configs&lt;/code&gt;. With enforcement on,
   * &lt;code&gt;ListVtsiProjects&lt;/code&gt; withholds the whole &lt;code&gt;asterisk_configs&lt;/code&gt; (and every other
   * configuration field) from a caller whose highest role on the project is &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;
   * or &lt;code&gt;PROJECT_USER&lt;/code&gt;. Use a &lt;code&gt;field_mask&lt;/code&gt; without &lt;code&gt;asterisk_configs&lt;/code&gt; where
   * the password is not needed.&lt;/p&gt;
   * &lt;p&gt;Events: every change emits the matching &lt;code&gt;VtsiEvent&lt;/code&gt; of the project
   * (&lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UPDATED&lt;/code&gt;, &lt;code&gt;_DEPLOYED&lt;/code&gt;, &lt;code&gt;_DEPLOY_FAILED&lt;/code&gt;,
   * &lt;code&gt;_UNDEPLOYED&lt;/code&gt;, &lt;code&gt;_UNDEPLOY_FAILED&lt;/code&gt;, &lt;code&gt;_DELETED&lt;/code&gt;) and, for every change
   * of &lt;code&gt;vtsi_project_status&lt;/code&gt;, &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_STATUS_CHANGED&lt;/code&gt;. A request
   * with &lt;code&gt;validate_only&lt;/code&gt; emits nothing.&lt;/p&gt;
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
     * &lt;p&gt;Creates a VTSI project with its configuration. The project is created
     * &lt;code&gt;UNDEPLOYED&lt;/code&gt;; nothing is started. &lt;code&gt;max_callers&lt;/code&gt; caller and
     * &lt;code&gt;max_listeners&lt;/code&gt; listener SIP accounts are provisioned for it and an Asterisk port is
     * assigned when none was given.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;validate_only&lt;/code&gt; every check of a real create runs (authorization included) and
     * nothing is written, reserved or emitted; the would-be project is returned.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or over-long (more than 256 characters)
     * &lt;code&gt;display_name&lt;/code&gt;, a negative &lt;code&gt;max_callers&lt;/code&gt; or &lt;code&gt;max_listeners&lt;/code&gt;, a port
     * outside 0..65535, &lt;code&gt;asterisk_port&lt;/code&gt; and &lt;code&gt;asterisk_configs.asterisk_port&lt;/code&gt; both set
     * and different, a malformed &lt;code&gt;name&lt;/code&gt;, an invalid &lt;code&gt;asterisk_configs&lt;/code&gt; (each naming
     * the field); &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when
     * &lt;code&gt;vtsi_project.name&lt;/code&gt; names an existing project (also when two creates of the same name
     * race); &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;, &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the
     * service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on EVERY agent of
     * &lt;code&gt;nlu_agent_names&lt;/code&gt;; a project with no agent can only be created by
     * &lt;code&gt;SERVER_ADMIN&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Idempotency: none. A retry after a lost response creates a second project unless
     * &lt;code&gt;vtsi_project.name&lt;/code&gt; is set, in which case the retry is answered
     * &lt;code&gt;ALREADY_EXISTS&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void createVtsiProject(ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVtsiProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a VTSI project with its configuration.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project;
     * &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;, &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public void getVtsiProject(ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.VtsiProject> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVtsiProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates a VTSI project: the fields named in &lt;code&gt;update_mask&lt;/code&gt;, or, with no mask, the
     * fields &lt;code&gt;vtsi_project&lt;/code&gt; sets (see &lt;code&gt;UpdateVtsiProjectRequest.update_mask&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;An update of an &lt;code&gt;UNDEPLOYED&lt;/code&gt; project only writes it. An update of a
     * &lt;code&gt;DEPLOYED&lt;/code&gt; project is applied to the running Asterisk by the cheapest path that applies
     * every change, chosen by the server: &lt;code&gt;display_name&lt;/code&gt;, &lt;code&gt;nlu_agent_names&lt;/code&gt; and
     * &lt;code&gt;transfer_phone_number_allowlist&lt;/code&gt; touch no Asterisk; a configuration change that Asterisk
     * measurably applies on a reload is reloaded in place and keeps every call; every other change is a
     * RESTART of the Asterisk container or a REDEPLOY of the project (a changed &lt;code&gt;max_callers&lt;/code&gt;,
     * &lt;code&gt;max_listeners&lt;/code&gt;, Asterisk port, &lt;code&gt;asterisk_version&lt;/code&gt; or managed account), and
     * ENDS EVERY CALL of the project: a redeploy undeploys and deploys the project and recycles its
     * listeners and pooled callers. Use &lt;code&gt;validate_only&lt;/code&gt; to check an update first.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;vtsi_project.name&lt;/code&gt;,
     * an unknown &lt;code&gt;update_mask&lt;/code&gt; path (also the prefixed form &lt;code&gt;vtsi_project.x&lt;/code&gt;), a mask
     * that clears the configuration source (&lt;code&gt;asterisk_configs&lt;/code&gt; with no arm set), an out-of-range
     * value (as on create) or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an
     * unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the project is &lt;code&gt;DELETING&lt;/code&gt;;
     * &lt;code&gt;ABORTED&lt;/code&gt; when another lifecycle operation of the project held it too long or the
     * project changed concurrently, nothing being written; &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;,
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description. When a deployed project&amp;apos;s
     * Asterisk cannot be reloaded, restarted or redeployed the RPC fails (&lt;code&gt;INTERNAL&lt;/code&gt; or
     * &lt;code&gt;UNAVAILABLE&lt;/code&gt;) and the project is left as the failure left it (see
     * &lt;code&gt;status_message&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project and on every agent of the
     * stored AND of the resulting &lt;code&gt;nlu_agent_names&lt;/code&gt; (removing an agent needs the same role as
     * adding it).&lt;/p&gt;
     * &lt;p&gt;Idempotency: an update is a set of absolute values, so a retry with the same request converges
     * to the same project (a redeploying update ends the calls of the retry&amp;apos;s moment too).&lt;/p&gt;
     * </pre>
     */
    public void updateVtsiProject(ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVtsiProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a VTSI project and its configuration. A project that is deployed, deploying,
     * undeploying or &lt;code&gt;DEPLOY_FAILED&lt;/code&gt; is UNDEPLOYED FIRST, automatically, exactly as by &lt;code&gt;UndeployVtsiProject&lt;/code&gt;:
     * every call of the project ends and its listeners, callers and Asterisk container are removed. The
     * undeploy is best effort: a failing teardown is logged and the deletion goes on. The project then
     * moves to &lt;code&gt;DELETING&lt;/code&gt;, its stored configuration is removed and the project no longer
     * exists (&lt;code&gt;DELETED&lt;/code&gt; is never returned: a deleted
     * project is &lt;code&gt;NOT_FOUND&lt;/code&gt;). Deletion is permanent.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, also for a retry of a deletion that succeeded (the
     * RPC is not idempotent); &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;,
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UNDEPLOYED&lt;/code&gt; when it had to undeploy, then
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DELETED&lt;/code&gt;, the last event of the project.&lt;/p&gt;
     * </pre>
     */
    public void deleteVtsiProject(ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVtsiProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deploys a VTSI project: starts its Asterisk container with the stored configuration and waits
     * until the container runs. SYNCHRONOUS: the RPC returns when the project is &lt;code&gt;DEPLOYED&lt;/code&gt;
     * or the deployment failed. The status moves &lt;code&gt;UNDEPLOYED&lt;/code&gt; (or &lt;code&gt;DEPLOY_FAILED&lt;/code&gt;)
     * &amp;gt; &lt;code&gt;DEPLOYING&lt;/code&gt; &amp;gt; &lt;code&gt;DEPLOYED&lt;/code&gt;; on failure the half-started container is
     * removed, the status becomes &lt;code&gt;DEPLOY_FAILED&lt;/code&gt; with the reason in
     * &lt;code&gt;status_message&lt;/code&gt;, and the RPC fails. The server waits about 30 seconds for the container
     * to run, plus the docker API timeout of each docker call (&lt;code&gt;ONDEWO_VTSI_DOCKER_API_TIMEOUT_S&lt;/code&gt;,
     * default 90 seconds); a client deadline of at least 3 minutes is recommended. Deploying applies the
     * project&amp;apos;s softphone accounts to the new Asterisk. No caller or listener is started: start them
     * with the &lt;code&gt;Calls&lt;/code&gt; service.&lt;/p&gt;
     * &lt;p&gt;Idempotent: deploying a &lt;code&gt;DEPLOYED&lt;/code&gt; project changes nothing and succeeds (nothing is
     * restarted); a deploy that arrives while another deploy of the project runs waits for it and then
     * finds the project &lt;code&gt;DEPLOYED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the project is
     * &lt;code&gt;DELETING&lt;/code&gt;, or &lt;code&gt;DEPLOYING&lt;/code&gt; / &lt;code&gt;UNDEPLOYING&lt;/code&gt; after the operation that
     * set the status was interrupted (undeploy the project first); &lt;code&gt;INTERNAL&lt;/code&gt; or
     * &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the deployment failed (the project is then
     * &lt;code&gt;DEPLOY_FAILED&lt;/code&gt;); &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;,
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DEPLOYED&lt;/code&gt; or
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DEPLOY_FAILED&lt;/code&gt;, and
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_STATUS_CHANGED&lt;/code&gt; per status change.&lt;/p&gt;
     * </pre>
     */
    public void deployVtsiProject(ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeployVtsiProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Undeploys a VTSI project. SYNCHRONOUS: the status moves to &lt;code&gt;UNDEPLOYING&lt;/code&gt;, EVERY CALL
     * of the project is ended (callers and listeners alike, campaign calls included), the listeners and
     * the pooled callers are undeployed, the Asterisk container is removed, and the status becomes
     * &lt;code&gt;UNDEPLOYED&lt;/code&gt;. The registrations of the project&amp;apos;s softphone accounts end with the
     * container; the accounts themselves are kept and are applied again on the next deploy. The stored
     * configuration, callers, listeners and campaigns are kept. A failed undeploy restores the previous
     * status (or &lt;code&gt;UNDEPLOYED&lt;/code&gt; when the container is already gone) and fails the RPC.&lt;/p&gt;
     * &lt;p&gt;Idempotent: undeploying an &lt;code&gt;UNDEPLOYED&lt;/code&gt; project changes nothing and succeeds.
     * Undeploying a &lt;code&gt;DEPLOY_FAILED&lt;/code&gt; project removes what the failed deployment left and makes it
     * &lt;code&gt;UNDEPLOYED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the project is
     * &lt;code&gt;DELETING&lt;/code&gt;; &lt;code&gt;INTERNAL&lt;/code&gt; or &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the teardown failed;
     * &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;, &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service
     * description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UNDEPLOYED&lt;/code&gt; or
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UNDEPLOY_FAILED&lt;/code&gt;, and
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_STATUS_CHANGED&lt;/code&gt; per status change.&lt;/p&gt;
     * </pre>
     */
    public void undeployVtsiProject(ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeployVtsiProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists VTSI projects, filtered, sorted and paged. With authorization enforced, only the projects
     * the caller holds a project role on are listed (every project for &lt;code&gt;SERVER_ADMIN&lt;/code&gt;), and
     * the configuration fields are withheld from a &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or
     * &lt;code&gt;PROJECT_USER&lt;/code&gt; (see the service description); a caller without a usable credential gets an
     * empty page.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a negative &lt;code&gt;page_size&lt;/code&gt;, a malformed
     * &lt;code&gt;page_token&lt;/code&gt;, an unspecified status in &lt;code&gt;statuses&lt;/code&gt;, an over-long
     * &lt;code&gt;display_name_contains&lt;/code&gt;, a &lt;code&gt;created_after&lt;/code&gt; that is not before
     * &lt;code&gt;created_before&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: any project role (&lt;code&gt;PROJECT_USER&lt;/code&gt; or higher).&lt;/p&gt;
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
   * &lt;p&gt;Manages VTSI (Virtual Telephone System Integration) PROJECTS: the per-project configuration of an
   * Asterisk SIP server (its SIP trunk, its ports, its Asterisk version) together with the caller and
   * listener capacity of the project and the ONDEWO NLU agents it serves. Deploying a project starts its
   * Asterisk container; callers, listeners, campaigns and softphone accounts of the project need a
   * &lt;code&gt;DEPLOYED&lt;/code&gt; project to place or take calls.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes. The &lt;code&gt;error_message&lt;/code&gt; fields of the responses
   * are never set, neither on success nor on failure (they predate the status codes and are kept for wire
   * compatibility): &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, an unknown &lt;code&gt;update_mask&lt;/code&gt;
   * or &lt;code&gt;field_mask&lt;/code&gt; path, a malformed &lt;code&gt;page_token&lt;/code&gt; or an out-of-range value (each
   * naming the field); &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when
   * &lt;code&gt;CreateVtsiProject&lt;/code&gt; names a project that exists; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the
   * project is in a status that does not allow the operation (each RPC names its cases);
   * &lt;code&gt;ABORTED&lt;/code&gt; when another create, update, deploy, undeploy or delete of the same project held
   * it for longer than the server waits (about 30 seconds), in which case nothing was changed and the
   * request can be retried; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the docker daemon or the database cannot be
   * reached.&lt;/p&gt;
   * &lt;p&gt;Authorization (only when the server enforces it, i.e. &lt;code&gt;ONDEWO_VTSI_KEYCLOAK_AUTH_ENABLED&lt;/code&gt;
   * and &lt;code&gt;ONDEWO_VTSI_AUTH_REQUIRED&lt;/code&gt; are both true): a caller without a credential is
   * &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; whatever it sent. A caller needs a server role (&lt;code&gt;SERVER_ADMIN&lt;/code&gt;,
   * &lt;code&gt;SERVER_MANAGER&lt;/code&gt; or &lt;code&gt;SERVER_USER&lt;/code&gt;), else every RPC is
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;. The project roles are derived from the caller&amp;apos;s roles on the
   * project&amp;apos;s &lt;code&gt;nlu_agent_names&lt;/code&gt;: &lt;code&gt;CreateVtsiProject&lt;/code&gt;,
   * &lt;code&gt;GetVtsiProject&lt;/code&gt;, &lt;code&gt;UpdateVtsiProject&lt;/code&gt;, &lt;code&gt;DeleteVtsiProject&lt;/code&gt;,
   * &lt;code&gt;DeployVtsiProject&lt;/code&gt; and &lt;code&gt;UndeployVtsiProject&lt;/code&gt; require
   * &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher (&lt;code&gt;PROJECT_ADMIN&lt;/code&gt;); &lt;code&gt;ListVtsiProjects&lt;/code&gt;
   * is open to every project role and returns only the projects the caller holds a role on.
   * &lt;code&gt;SERVER_ADMIN&lt;/code&gt; passes every project check. With enforcement on, a well-formed request naming
   * a project the caller holds no role on, an unknown project included, is answered
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; rather than &lt;code&gt;NOT_FOUND&lt;/code&gt;, so the answer does not reveal
   * whether the project exists; &lt;code&gt;NOT_FOUND&lt;/code&gt; is then reserved to &lt;code&gt;SERVER_ADMIN&lt;/code&gt;. With
   * enforcement off (the default) every request is served and only logged.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Credentials.&lt;/b&gt; &lt;code&gt;AsteriskConfigsVariables.sip_trunk_password&lt;/code&gt; is stored and returned
   * as sent (it is not write-only): &lt;code&gt;GetVtsiProject&lt;/code&gt;, &lt;code&gt;CreateVtsiProject&lt;/code&gt;,
   * &lt;code&gt;UpdateVtsiProject&lt;/code&gt; and &lt;code&gt;ListVtsiProjects&lt;/code&gt; return it to every caller allowed to
   * call them with a view that populates &lt;code&gt;asterisk_configs&lt;/code&gt;. With enforcement on,
   * &lt;code&gt;ListVtsiProjects&lt;/code&gt; withholds the whole &lt;code&gt;asterisk_configs&lt;/code&gt; (and every other
   * configuration field) from a caller whose highest role on the project is &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;
   * or &lt;code&gt;PROJECT_USER&lt;/code&gt;. Use a &lt;code&gt;field_mask&lt;/code&gt; without &lt;code&gt;asterisk_configs&lt;/code&gt; where
   * the password is not needed.&lt;/p&gt;
   * &lt;p&gt;Events: every change emits the matching &lt;code&gt;VtsiEvent&lt;/code&gt; of the project
   * (&lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UPDATED&lt;/code&gt;, &lt;code&gt;_DEPLOYED&lt;/code&gt;, &lt;code&gt;_DEPLOY_FAILED&lt;/code&gt;,
   * &lt;code&gt;_UNDEPLOYED&lt;/code&gt;, &lt;code&gt;_UNDEPLOY_FAILED&lt;/code&gt;, &lt;code&gt;_DELETED&lt;/code&gt;) and, for every change
   * of &lt;code&gt;vtsi_project_status&lt;/code&gt;, &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_STATUS_CHANGED&lt;/code&gt;. A request
   * with &lt;code&gt;validate_only&lt;/code&gt; emits nothing.&lt;/p&gt;
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
     * &lt;p&gt;Creates a VTSI project with its configuration. The project is created
     * &lt;code&gt;UNDEPLOYED&lt;/code&gt;; nothing is started. &lt;code&gt;max_callers&lt;/code&gt; caller and
     * &lt;code&gt;max_listeners&lt;/code&gt; listener SIP accounts are provisioned for it and an Asterisk port is
     * assigned when none was given.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;validate_only&lt;/code&gt; every check of a real create runs (authorization included) and
     * nothing is written, reserved or emitted; the would-be project is returned.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or over-long (more than 256 characters)
     * &lt;code&gt;display_name&lt;/code&gt;, a negative &lt;code&gt;max_callers&lt;/code&gt; or &lt;code&gt;max_listeners&lt;/code&gt;, a port
     * outside 0..65535, &lt;code&gt;asterisk_port&lt;/code&gt; and &lt;code&gt;asterisk_configs.asterisk_port&lt;/code&gt; both set
     * and different, a malformed &lt;code&gt;name&lt;/code&gt;, an invalid &lt;code&gt;asterisk_configs&lt;/code&gt; (each naming
     * the field); &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when
     * &lt;code&gt;vtsi_project.name&lt;/code&gt; names an existing project (also when two creates of the same name
     * race); &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;, &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the
     * service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on EVERY agent of
     * &lt;code&gt;nlu_agent_names&lt;/code&gt;; a project with no agent can only be created by
     * &lt;code&gt;SERVER_ADMIN&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Idempotency: none. A retry after a lost response creates a second project unless
     * &lt;code&gt;vtsi_project.name&lt;/code&gt; is set, in which case the retry is answered
     * &lt;code&gt;ALREADY_EXISTS&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse createVtsiProject(ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a VTSI project with its configuration.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project;
     * &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;, &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.VtsiProject getVtsiProject(ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates a VTSI project: the fields named in &lt;code&gt;update_mask&lt;/code&gt;, or, with no mask, the
     * fields &lt;code&gt;vtsi_project&lt;/code&gt; sets (see &lt;code&gt;UpdateVtsiProjectRequest.update_mask&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;An update of an &lt;code&gt;UNDEPLOYED&lt;/code&gt; project only writes it. An update of a
     * &lt;code&gt;DEPLOYED&lt;/code&gt; project is applied to the running Asterisk by the cheapest path that applies
     * every change, chosen by the server: &lt;code&gt;display_name&lt;/code&gt;, &lt;code&gt;nlu_agent_names&lt;/code&gt; and
     * &lt;code&gt;transfer_phone_number_allowlist&lt;/code&gt; touch no Asterisk; a configuration change that Asterisk
     * measurably applies on a reload is reloaded in place and keeps every call; every other change is a
     * RESTART of the Asterisk container or a REDEPLOY of the project (a changed &lt;code&gt;max_callers&lt;/code&gt;,
     * &lt;code&gt;max_listeners&lt;/code&gt;, Asterisk port, &lt;code&gt;asterisk_version&lt;/code&gt; or managed account), and
     * ENDS EVERY CALL of the project: a redeploy undeploys and deploys the project and recycles its
     * listeners and pooled callers. Use &lt;code&gt;validate_only&lt;/code&gt; to check an update first.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;vtsi_project.name&lt;/code&gt;,
     * an unknown &lt;code&gt;update_mask&lt;/code&gt; path (also the prefixed form &lt;code&gt;vtsi_project.x&lt;/code&gt;), a mask
     * that clears the configuration source (&lt;code&gt;asterisk_configs&lt;/code&gt; with no arm set), an out-of-range
     * value (as on create) or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an
     * unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the project is &lt;code&gt;DELETING&lt;/code&gt;;
     * &lt;code&gt;ABORTED&lt;/code&gt; when another lifecycle operation of the project held it too long or the
     * project changed concurrently, nothing being written; &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;,
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description. When a deployed project&amp;apos;s
     * Asterisk cannot be reloaded, restarted or redeployed the RPC fails (&lt;code&gt;INTERNAL&lt;/code&gt; or
     * &lt;code&gt;UNAVAILABLE&lt;/code&gt;) and the project is left as the failure left it (see
     * &lt;code&gt;status_message&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project and on every agent of the
     * stored AND of the resulting &lt;code&gt;nlu_agent_names&lt;/code&gt; (removing an agent needs the same role as
     * adding it).&lt;/p&gt;
     * &lt;p&gt;Idempotency: an update is a set of absolute values, so a retry with the same request converges
     * to the same project (a redeploying update ends the calls of the retry&amp;apos;s moment too).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse updateVtsiProject(ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a VTSI project and its configuration. A project that is deployed, deploying,
     * undeploying or &lt;code&gt;DEPLOY_FAILED&lt;/code&gt; is UNDEPLOYED FIRST, automatically, exactly as by &lt;code&gt;UndeployVtsiProject&lt;/code&gt;:
     * every call of the project ends and its listeners, callers and Asterisk container are removed. The
     * undeploy is best effort: a failing teardown is logged and the deletion goes on. The project then
     * moves to &lt;code&gt;DELETING&lt;/code&gt;, its stored configuration is removed and the project no longer
     * exists (&lt;code&gt;DELETED&lt;/code&gt; is never returned: a deleted
     * project is &lt;code&gt;NOT_FOUND&lt;/code&gt;). Deletion is permanent.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, also for a retry of a deletion that succeeded (the
     * RPC is not idempotent); &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;,
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UNDEPLOYED&lt;/code&gt; when it had to undeploy, then
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DELETED&lt;/code&gt;, the last event of the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse deleteVtsiProject(ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deploys a VTSI project: starts its Asterisk container with the stored configuration and waits
     * until the container runs. SYNCHRONOUS: the RPC returns when the project is &lt;code&gt;DEPLOYED&lt;/code&gt;
     * or the deployment failed. The status moves &lt;code&gt;UNDEPLOYED&lt;/code&gt; (or &lt;code&gt;DEPLOY_FAILED&lt;/code&gt;)
     * &amp;gt; &lt;code&gt;DEPLOYING&lt;/code&gt; &amp;gt; &lt;code&gt;DEPLOYED&lt;/code&gt;; on failure the half-started container is
     * removed, the status becomes &lt;code&gt;DEPLOY_FAILED&lt;/code&gt; with the reason in
     * &lt;code&gt;status_message&lt;/code&gt;, and the RPC fails. The server waits about 30 seconds for the container
     * to run, plus the docker API timeout of each docker call (&lt;code&gt;ONDEWO_VTSI_DOCKER_API_TIMEOUT_S&lt;/code&gt;,
     * default 90 seconds); a client deadline of at least 3 minutes is recommended. Deploying applies the
     * project&amp;apos;s softphone accounts to the new Asterisk. No caller or listener is started: start them
     * with the &lt;code&gt;Calls&lt;/code&gt; service.&lt;/p&gt;
     * &lt;p&gt;Idempotent: deploying a &lt;code&gt;DEPLOYED&lt;/code&gt; project changes nothing and succeeds (nothing is
     * restarted); a deploy that arrives while another deploy of the project runs waits for it and then
     * finds the project &lt;code&gt;DEPLOYED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the project is
     * &lt;code&gt;DELETING&lt;/code&gt;, or &lt;code&gt;DEPLOYING&lt;/code&gt; / &lt;code&gt;UNDEPLOYING&lt;/code&gt; after the operation that
     * set the status was interrupted (undeploy the project first); &lt;code&gt;INTERNAL&lt;/code&gt; or
     * &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the deployment failed (the project is then
     * &lt;code&gt;DEPLOY_FAILED&lt;/code&gt;); &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;,
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DEPLOYED&lt;/code&gt; or
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DEPLOY_FAILED&lt;/code&gt;, and
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_STATUS_CHANGED&lt;/code&gt; per status change.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse deployVtsiProject(ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeployVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Undeploys a VTSI project. SYNCHRONOUS: the status moves to &lt;code&gt;UNDEPLOYING&lt;/code&gt;, EVERY CALL
     * of the project is ended (callers and listeners alike, campaign calls included), the listeners and
     * the pooled callers are undeployed, the Asterisk container is removed, and the status becomes
     * &lt;code&gt;UNDEPLOYED&lt;/code&gt;. The registrations of the project&amp;apos;s softphone accounts end with the
     * container; the accounts themselves are kept and are applied again on the next deploy. The stored
     * configuration, callers, listeners and campaigns are kept. A failed undeploy restores the previous
     * status (or &lt;code&gt;UNDEPLOYED&lt;/code&gt; when the container is already gone) and fails the RPC.&lt;/p&gt;
     * &lt;p&gt;Idempotent: undeploying an &lt;code&gt;UNDEPLOYED&lt;/code&gt; project changes nothing and succeeds.
     * Undeploying a &lt;code&gt;DEPLOY_FAILED&lt;/code&gt; project removes what the failed deployment left and makes it
     * &lt;code&gt;UNDEPLOYED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the project is
     * &lt;code&gt;DELETING&lt;/code&gt;; &lt;code&gt;INTERNAL&lt;/code&gt; or &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the teardown failed;
     * &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;, &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service
     * description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UNDEPLOYED&lt;/code&gt; or
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UNDEPLOY_FAILED&lt;/code&gt;, and
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_STATUS_CHANGED&lt;/code&gt; per status change.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse undeployVtsiProject(ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUndeployVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists VTSI projects, filtered, sorted and paged. With authorization enforced, only the projects
     * the caller holds a project role on are listed (every project for &lt;code&gt;SERVER_ADMIN&lt;/code&gt;), and
     * the configuration fields are withheld from a &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or
     * &lt;code&gt;PROJECT_USER&lt;/code&gt; (see the service description); a caller without a usable credential gets an
     * empty page.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a negative &lt;code&gt;page_size&lt;/code&gt;, a malformed
     * &lt;code&gt;page_token&lt;/code&gt;, an unspecified status in &lt;code&gt;statuses&lt;/code&gt;, an over-long
     * &lt;code&gt;display_name_contains&lt;/code&gt;, a &lt;code&gt;created_after&lt;/code&gt; that is not before
     * &lt;code&gt;created_before&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: any project role (&lt;code&gt;PROJECT_USER&lt;/code&gt; or higher).&lt;/p&gt;
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
   * &lt;p&gt;Manages VTSI (Virtual Telephone System Integration) PROJECTS: the per-project configuration of an
   * Asterisk SIP server (its SIP trunk, its ports, its Asterisk version) together with the caller and
   * listener capacity of the project and the ONDEWO NLU agents it serves. Deploying a project starts its
   * Asterisk container; callers, listeners, campaigns and softphone accounts of the project need a
   * &lt;code&gt;DEPLOYED&lt;/code&gt; project to place or take calls.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes. The &lt;code&gt;error_message&lt;/code&gt; fields of the responses
   * are never set, neither on success nor on failure (they predate the status codes and are kept for wire
   * compatibility): &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, an unknown &lt;code&gt;update_mask&lt;/code&gt;
   * or &lt;code&gt;field_mask&lt;/code&gt; path, a malformed &lt;code&gt;page_token&lt;/code&gt; or an out-of-range value (each
   * naming the field); &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when
   * &lt;code&gt;CreateVtsiProject&lt;/code&gt; names a project that exists; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the
   * project is in a status that does not allow the operation (each RPC names its cases);
   * &lt;code&gt;ABORTED&lt;/code&gt; when another create, update, deploy, undeploy or delete of the same project held
   * it for longer than the server waits (about 30 seconds), in which case nothing was changed and the
   * request can be retried; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the docker daemon or the database cannot be
   * reached.&lt;/p&gt;
   * &lt;p&gt;Authorization (only when the server enforces it, i.e. &lt;code&gt;ONDEWO_VTSI_KEYCLOAK_AUTH_ENABLED&lt;/code&gt;
   * and &lt;code&gt;ONDEWO_VTSI_AUTH_REQUIRED&lt;/code&gt; are both true): a caller without a credential is
   * &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; whatever it sent. A caller needs a server role (&lt;code&gt;SERVER_ADMIN&lt;/code&gt;,
   * &lt;code&gt;SERVER_MANAGER&lt;/code&gt; or &lt;code&gt;SERVER_USER&lt;/code&gt;), else every RPC is
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;. The project roles are derived from the caller&amp;apos;s roles on the
   * project&amp;apos;s &lt;code&gt;nlu_agent_names&lt;/code&gt;: &lt;code&gt;CreateVtsiProject&lt;/code&gt;,
   * &lt;code&gt;GetVtsiProject&lt;/code&gt;, &lt;code&gt;UpdateVtsiProject&lt;/code&gt;, &lt;code&gt;DeleteVtsiProject&lt;/code&gt;,
   * &lt;code&gt;DeployVtsiProject&lt;/code&gt; and &lt;code&gt;UndeployVtsiProject&lt;/code&gt; require
   * &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher (&lt;code&gt;PROJECT_ADMIN&lt;/code&gt;); &lt;code&gt;ListVtsiProjects&lt;/code&gt;
   * is open to every project role and returns only the projects the caller holds a role on.
   * &lt;code&gt;SERVER_ADMIN&lt;/code&gt; passes every project check. With enforcement on, a well-formed request naming
   * a project the caller holds no role on, an unknown project included, is answered
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; rather than &lt;code&gt;NOT_FOUND&lt;/code&gt;, so the answer does not reveal
   * whether the project exists; &lt;code&gt;NOT_FOUND&lt;/code&gt; is then reserved to &lt;code&gt;SERVER_ADMIN&lt;/code&gt;. With
   * enforcement off (the default) every request is served and only logged.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Credentials.&lt;/b&gt; &lt;code&gt;AsteriskConfigsVariables.sip_trunk_password&lt;/code&gt; is stored and returned
   * as sent (it is not write-only): &lt;code&gt;GetVtsiProject&lt;/code&gt;, &lt;code&gt;CreateVtsiProject&lt;/code&gt;,
   * &lt;code&gt;UpdateVtsiProject&lt;/code&gt; and &lt;code&gt;ListVtsiProjects&lt;/code&gt; return it to every caller allowed to
   * call them with a view that populates &lt;code&gt;asterisk_configs&lt;/code&gt;. With enforcement on,
   * &lt;code&gt;ListVtsiProjects&lt;/code&gt; withholds the whole &lt;code&gt;asterisk_configs&lt;/code&gt; (and every other
   * configuration field) from a caller whose highest role on the project is &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;
   * or &lt;code&gt;PROJECT_USER&lt;/code&gt;. Use a &lt;code&gt;field_mask&lt;/code&gt; without &lt;code&gt;asterisk_configs&lt;/code&gt; where
   * the password is not needed.&lt;/p&gt;
   * &lt;p&gt;Events: every change emits the matching &lt;code&gt;VtsiEvent&lt;/code&gt; of the project
   * (&lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UPDATED&lt;/code&gt;, &lt;code&gt;_DEPLOYED&lt;/code&gt;, &lt;code&gt;_DEPLOY_FAILED&lt;/code&gt;,
   * &lt;code&gt;_UNDEPLOYED&lt;/code&gt;, &lt;code&gt;_UNDEPLOY_FAILED&lt;/code&gt;, &lt;code&gt;_DELETED&lt;/code&gt;) and, for every change
   * of &lt;code&gt;vtsi_project_status&lt;/code&gt;, &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_STATUS_CHANGED&lt;/code&gt;. A request
   * with &lt;code&gt;validate_only&lt;/code&gt; emits nothing.&lt;/p&gt;
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
     * &lt;p&gt;Creates a VTSI project with its configuration. The project is created
     * &lt;code&gt;UNDEPLOYED&lt;/code&gt;; nothing is started. &lt;code&gt;max_callers&lt;/code&gt; caller and
     * &lt;code&gt;max_listeners&lt;/code&gt; listener SIP accounts are provisioned for it and an Asterisk port is
     * assigned when none was given.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;validate_only&lt;/code&gt; every check of a real create runs (authorization included) and
     * nothing is written, reserved or emitted; the would-be project is returned.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or over-long (more than 256 characters)
     * &lt;code&gt;display_name&lt;/code&gt;, a negative &lt;code&gt;max_callers&lt;/code&gt; or &lt;code&gt;max_listeners&lt;/code&gt;, a port
     * outside 0..65535, &lt;code&gt;asterisk_port&lt;/code&gt; and &lt;code&gt;asterisk_configs.asterisk_port&lt;/code&gt; both set
     * and different, a malformed &lt;code&gt;name&lt;/code&gt;, an invalid &lt;code&gt;asterisk_configs&lt;/code&gt; (each naming
     * the field); &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when
     * &lt;code&gt;vtsi_project.name&lt;/code&gt; names an existing project (also when two creates of the same name
     * race); &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;, &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the
     * service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on EVERY agent of
     * &lt;code&gt;nlu_agent_names&lt;/code&gt;; a project with no agent can only be created by
     * &lt;code&gt;SERVER_ADMIN&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Idempotency: none. A retry after a lost response creates a second project unless
     * &lt;code&gt;vtsi_project.name&lt;/code&gt; is set, in which case the retry is answered
     * &lt;code&gt;ALREADY_EXISTS&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse createVtsiProject(ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a VTSI project with its configuration.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project;
     * &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;, &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.VtsiProject getVtsiProject(ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates a VTSI project: the fields named in &lt;code&gt;update_mask&lt;/code&gt;, or, with no mask, the
     * fields &lt;code&gt;vtsi_project&lt;/code&gt; sets (see &lt;code&gt;UpdateVtsiProjectRequest.update_mask&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;An update of an &lt;code&gt;UNDEPLOYED&lt;/code&gt; project only writes it. An update of a
     * &lt;code&gt;DEPLOYED&lt;/code&gt; project is applied to the running Asterisk by the cheapest path that applies
     * every change, chosen by the server: &lt;code&gt;display_name&lt;/code&gt;, &lt;code&gt;nlu_agent_names&lt;/code&gt; and
     * &lt;code&gt;transfer_phone_number_allowlist&lt;/code&gt; touch no Asterisk; a configuration change that Asterisk
     * measurably applies on a reload is reloaded in place and keeps every call; every other change is a
     * RESTART of the Asterisk container or a REDEPLOY of the project (a changed &lt;code&gt;max_callers&lt;/code&gt;,
     * &lt;code&gt;max_listeners&lt;/code&gt;, Asterisk port, &lt;code&gt;asterisk_version&lt;/code&gt; or managed account), and
     * ENDS EVERY CALL of the project: a redeploy undeploys and deploys the project and recycles its
     * listeners and pooled callers. Use &lt;code&gt;validate_only&lt;/code&gt; to check an update first.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;vtsi_project.name&lt;/code&gt;,
     * an unknown &lt;code&gt;update_mask&lt;/code&gt; path (also the prefixed form &lt;code&gt;vtsi_project.x&lt;/code&gt;), a mask
     * that clears the configuration source (&lt;code&gt;asterisk_configs&lt;/code&gt; with no arm set), an out-of-range
     * value (as on create) or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an
     * unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the project is &lt;code&gt;DELETING&lt;/code&gt;;
     * &lt;code&gt;ABORTED&lt;/code&gt; when another lifecycle operation of the project held it too long or the
     * project changed concurrently, nothing being written; &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;,
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description. When a deployed project&amp;apos;s
     * Asterisk cannot be reloaded, restarted or redeployed the RPC fails (&lt;code&gt;INTERNAL&lt;/code&gt; or
     * &lt;code&gt;UNAVAILABLE&lt;/code&gt;) and the project is left as the failure left it (see
     * &lt;code&gt;status_message&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project and on every agent of the
     * stored AND of the resulting &lt;code&gt;nlu_agent_names&lt;/code&gt; (removing an agent needs the same role as
     * adding it).&lt;/p&gt;
     * &lt;p&gt;Idempotency: an update is a set of absolute values, so a retry with the same request converges
     * to the same project (a redeploying update ends the calls of the retry&amp;apos;s moment too).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse updateVtsiProject(ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a VTSI project and its configuration. A project that is deployed, deploying,
     * undeploying or &lt;code&gt;DEPLOY_FAILED&lt;/code&gt; is UNDEPLOYED FIRST, automatically, exactly as by &lt;code&gt;UndeployVtsiProject&lt;/code&gt;:
     * every call of the project ends and its listeners, callers and Asterisk container are removed. The
     * undeploy is best effort: a failing teardown is logged and the deletion goes on. The project then
     * moves to &lt;code&gt;DELETING&lt;/code&gt;, its stored configuration is removed and the project no longer
     * exists (&lt;code&gt;DELETED&lt;/code&gt; is never returned: a deleted
     * project is &lt;code&gt;NOT_FOUND&lt;/code&gt;). Deletion is permanent.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, also for a retry of a deletion that succeeded (the
     * RPC is not idempotent); &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;,
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UNDEPLOYED&lt;/code&gt; when it had to undeploy, then
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DELETED&lt;/code&gt;, the last event of the project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse deleteVtsiProject(ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deploys a VTSI project: starts its Asterisk container with the stored configuration and waits
     * until the container runs. SYNCHRONOUS: the RPC returns when the project is &lt;code&gt;DEPLOYED&lt;/code&gt;
     * or the deployment failed. The status moves &lt;code&gt;UNDEPLOYED&lt;/code&gt; (or &lt;code&gt;DEPLOY_FAILED&lt;/code&gt;)
     * &amp;gt; &lt;code&gt;DEPLOYING&lt;/code&gt; &amp;gt; &lt;code&gt;DEPLOYED&lt;/code&gt;; on failure the half-started container is
     * removed, the status becomes &lt;code&gt;DEPLOY_FAILED&lt;/code&gt; with the reason in
     * &lt;code&gt;status_message&lt;/code&gt;, and the RPC fails. The server waits about 30 seconds for the container
     * to run, plus the docker API timeout of each docker call (&lt;code&gt;ONDEWO_VTSI_DOCKER_API_TIMEOUT_S&lt;/code&gt;,
     * default 90 seconds); a client deadline of at least 3 minutes is recommended. Deploying applies the
     * project&amp;apos;s softphone accounts to the new Asterisk. No caller or listener is started: start them
     * with the &lt;code&gt;Calls&lt;/code&gt; service.&lt;/p&gt;
     * &lt;p&gt;Idempotent: deploying a &lt;code&gt;DEPLOYED&lt;/code&gt; project changes nothing and succeeds (nothing is
     * restarted); a deploy that arrives while another deploy of the project runs waits for it and then
     * finds the project &lt;code&gt;DEPLOYED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the project is
     * &lt;code&gt;DELETING&lt;/code&gt;, or &lt;code&gt;DEPLOYING&lt;/code&gt; / &lt;code&gt;UNDEPLOYING&lt;/code&gt; after the operation that
     * set the status was interrupted (undeploy the project first); &lt;code&gt;INTERNAL&lt;/code&gt; or
     * &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the deployment failed (the project is then
     * &lt;code&gt;DEPLOY_FAILED&lt;/code&gt;); &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;,
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DEPLOYED&lt;/code&gt; or
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DEPLOY_FAILED&lt;/code&gt;, and
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_STATUS_CHANGED&lt;/code&gt; per status change.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse deployVtsiProject(ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Undeploys a VTSI project. SYNCHRONOUS: the status moves to &lt;code&gt;UNDEPLOYING&lt;/code&gt;, EVERY CALL
     * of the project is ended (callers and listeners alike, campaign calls included), the listeners and
     * the pooled callers are undeployed, the Asterisk container is removed, and the status becomes
     * &lt;code&gt;UNDEPLOYED&lt;/code&gt;. The registrations of the project&amp;apos;s softphone accounts end with the
     * container; the accounts themselves are kept and are applied again on the next deploy. The stored
     * configuration, callers, listeners and campaigns are kept. A failed undeploy restores the previous
     * status (or &lt;code&gt;UNDEPLOYED&lt;/code&gt; when the container is already gone) and fails the RPC.&lt;/p&gt;
     * &lt;p&gt;Idempotent: undeploying an &lt;code&gt;UNDEPLOYED&lt;/code&gt; project changes nothing and succeeds.
     * Undeploying a &lt;code&gt;DEPLOY_FAILED&lt;/code&gt; project removes what the failed deployment left and makes it
     * &lt;code&gt;UNDEPLOYED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the project is
     * &lt;code&gt;DELETING&lt;/code&gt;; &lt;code&gt;INTERNAL&lt;/code&gt; or &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the teardown failed;
     * &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;, &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service
     * description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UNDEPLOYED&lt;/code&gt; or
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UNDEPLOY_FAILED&lt;/code&gt;, and
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_STATUS_CHANGED&lt;/code&gt; per status change.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse undeployVtsiProject(ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeployVtsiProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists VTSI projects, filtered, sorted and paged. With authorization enforced, only the projects
     * the caller holds a project role on are listed (every project for &lt;code&gt;SERVER_ADMIN&lt;/code&gt;), and
     * the configuration fields are withheld from a &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or
     * &lt;code&gt;PROJECT_USER&lt;/code&gt; (see the service description); a caller without a usable credential gets an
     * empty page.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a negative &lt;code&gt;page_size&lt;/code&gt;, a malformed
     * &lt;code&gt;page_token&lt;/code&gt;, an unspecified status in &lt;code&gt;statuses&lt;/code&gt;, an over-long
     * &lt;code&gt;display_name_contains&lt;/code&gt;, a &lt;code&gt;created_after&lt;/code&gt; that is not before
     * &lt;code&gt;created_before&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: any project role (&lt;code&gt;PROJECT_USER&lt;/code&gt; or higher).&lt;/p&gt;
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
   * &lt;p&gt;Manages VTSI (Virtual Telephone System Integration) PROJECTS: the per-project configuration of an
   * Asterisk SIP server (its SIP trunk, its ports, its Asterisk version) together with the caller and
   * listener capacity of the project and the ONDEWO NLU agents it serves. Deploying a project starts its
   * Asterisk container; callers, listeners, campaigns and softphone accounts of the project need a
   * &lt;code&gt;DEPLOYED&lt;/code&gt; project to place or take calls.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes. The &lt;code&gt;error_message&lt;/code&gt; fields of the responses
   * are never set, neither on success nor on failure (they predate the status codes and are kept for wire
   * compatibility): &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, an unknown &lt;code&gt;update_mask&lt;/code&gt;
   * or &lt;code&gt;field_mask&lt;/code&gt; path, a malformed &lt;code&gt;page_token&lt;/code&gt; or an out-of-range value (each
   * naming the field); &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when
   * &lt;code&gt;CreateVtsiProject&lt;/code&gt; names a project that exists; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the
   * project is in a status that does not allow the operation (each RPC names its cases);
   * &lt;code&gt;ABORTED&lt;/code&gt; when another create, update, deploy, undeploy or delete of the same project held
   * it for longer than the server waits (about 30 seconds), in which case nothing was changed and the
   * request can be retried; &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the docker daemon or the database cannot be
   * reached.&lt;/p&gt;
   * &lt;p&gt;Authorization (only when the server enforces it, i.e. &lt;code&gt;ONDEWO_VTSI_KEYCLOAK_AUTH_ENABLED&lt;/code&gt;
   * and &lt;code&gt;ONDEWO_VTSI_AUTH_REQUIRED&lt;/code&gt; are both true): a caller without a credential is
   * &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; whatever it sent. A caller needs a server role (&lt;code&gt;SERVER_ADMIN&lt;/code&gt;,
   * &lt;code&gt;SERVER_MANAGER&lt;/code&gt; or &lt;code&gt;SERVER_USER&lt;/code&gt;), else every RPC is
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;. The project roles are derived from the caller&amp;apos;s roles on the
   * project&amp;apos;s &lt;code&gt;nlu_agent_names&lt;/code&gt;: &lt;code&gt;CreateVtsiProject&lt;/code&gt;,
   * &lt;code&gt;GetVtsiProject&lt;/code&gt;, &lt;code&gt;UpdateVtsiProject&lt;/code&gt;, &lt;code&gt;DeleteVtsiProject&lt;/code&gt;,
   * &lt;code&gt;DeployVtsiProject&lt;/code&gt; and &lt;code&gt;UndeployVtsiProject&lt;/code&gt; require
   * &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher (&lt;code&gt;PROJECT_ADMIN&lt;/code&gt;); &lt;code&gt;ListVtsiProjects&lt;/code&gt;
   * is open to every project role and returns only the projects the caller holds a role on.
   * &lt;code&gt;SERVER_ADMIN&lt;/code&gt; passes every project check. With enforcement on, a well-formed request naming
   * a project the caller holds no role on, an unknown project included, is answered
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; rather than &lt;code&gt;NOT_FOUND&lt;/code&gt;, so the answer does not reveal
   * whether the project exists; &lt;code&gt;NOT_FOUND&lt;/code&gt; is then reserved to &lt;code&gt;SERVER_ADMIN&lt;/code&gt;. With
   * enforcement off (the default) every request is served and only logged.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Credentials.&lt;/b&gt; &lt;code&gt;AsteriskConfigsVariables.sip_trunk_password&lt;/code&gt; is stored and returned
   * as sent (it is not write-only): &lt;code&gt;GetVtsiProject&lt;/code&gt;, &lt;code&gt;CreateVtsiProject&lt;/code&gt;,
   * &lt;code&gt;UpdateVtsiProject&lt;/code&gt; and &lt;code&gt;ListVtsiProjects&lt;/code&gt; return it to every caller allowed to
   * call them with a view that populates &lt;code&gt;asterisk_configs&lt;/code&gt;. With enforcement on,
   * &lt;code&gt;ListVtsiProjects&lt;/code&gt; withholds the whole &lt;code&gt;asterisk_configs&lt;/code&gt; (and every other
   * configuration field) from a caller whose highest role on the project is &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;
   * or &lt;code&gt;PROJECT_USER&lt;/code&gt;. Use a &lt;code&gt;field_mask&lt;/code&gt; without &lt;code&gt;asterisk_configs&lt;/code&gt; where
   * the password is not needed.&lt;/p&gt;
   * &lt;p&gt;Events: every change emits the matching &lt;code&gt;VtsiEvent&lt;/code&gt; of the project
   * (&lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UPDATED&lt;/code&gt;, &lt;code&gt;_DEPLOYED&lt;/code&gt;, &lt;code&gt;_DEPLOY_FAILED&lt;/code&gt;,
   * &lt;code&gt;_UNDEPLOYED&lt;/code&gt;, &lt;code&gt;_UNDEPLOY_FAILED&lt;/code&gt;, &lt;code&gt;_DELETED&lt;/code&gt;) and, for every change
   * of &lt;code&gt;vtsi_project_status&lt;/code&gt;, &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_STATUS_CHANGED&lt;/code&gt;. A request
   * with &lt;code&gt;validate_only&lt;/code&gt; emits nothing.&lt;/p&gt;
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
     * &lt;p&gt;Creates a VTSI project with its configuration. The project is created
     * &lt;code&gt;UNDEPLOYED&lt;/code&gt;; nothing is started. &lt;code&gt;max_callers&lt;/code&gt; caller and
     * &lt;code&gt;max_listeners&lt;/code&gt; listener SIP accounts are provisioned for it and an Asterisk port is
     * assigned when none was given.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;validate_only&lt;/code&gt; every check of a real create runs (authorization included) and
     * nothing is written, reserved or emitted; the would-be project is returned.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or over-long (more than 256 characters)
     * &lt;code&gt;display_name&lt;/code&gt;, a negative &lt;code&gt;max_callers&lt;/code&gt; or &lt;code&gt;max_listeners&lt;/code&gt;, a port
     * outside 0..65535, &lt;code&gt;asterisk_port&lt;/code&gt; and &lt;code&gt;asterisk_configs.asterisk_port&lt;/code&gt; both set
     * and different, a malformed &lt;code&gt;name&lt;/code&gt;, an invalid &lt;code&gt;asterisk_configs&lt;/code&gt; (each naming
     * the field); &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when
     * &lt;code&gt;vtsi_project.name&lt;/code&gt; names an existing project (also when two creates of the same name
     * race); &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;, &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the
     * service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on EVERY agent of
     * &lt;code&gt;nlu_agent_names&lt;/code&gt;; a project with no agent can only be created by
     * &lt;code&gt;SERVER_ADMIN&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Idempotency: none. A retry after a lost response creates a second project unless
     * &lt;code&gt;vtsi_project.name&lt;/code&gt; is set, in which case the retry is answered
     * &lt;code&gt;ALREADY_EXISTS&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectResponse> createVtsiProject(
        ondewo.vtsi.ProjectsOuterClass.CreateVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVtsiProjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a VTSI project with its configuration.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project;
     * &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;, &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.ProjectsOuterClass.VtsiProject> getVtsiProject(
        ondewo.vtsi.ProjectsOuterClass.GetVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVtsiProjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates a VTSI project: the fields named in &lt;code&gt;update_mask&lt;/code&gt;, or, with no mask, the
     * fields &lt;code&gt;vtsi_project&lt;/code&gt; sets (see &lt;code&gt;UpdateVtsiProjectRequest.update_mask&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;An update of an &lt;code&gt;UNDEPLOYED&lt;/code&gt; project only writes it. An update of a
     * &lt;code&gt;DEPLOYED&lt;/code&gt; project is applied to the running Asterisk by the cheapest path that applies
     * every change, chosen by the server: &lt;code&gt;display_name&lt;/code&gt;, &lt;code&gt;nlu_agent_names&lt;/code&gt; and
     * &lt;code&gt;transfer_phone_number_allowlist&lt;/code&gt; touch no Asterisk; a configuration change that Asterisk
     * measurably applies on a reload is reloaded in place and keeps every call; every other change is a
     * RESTART of the Asterisk container or a REDEPLOY of the project (a changed &lt;code&gt;max_callers&lt;/code&gt;,
     * &lt;code&gt;max_listeners&lt;/code&gt;, Asterisk port, &lt;code&gt;asterisk_version&lt;/code&gt; or managed account), and
     * ENDS EVERY CALL of the project: a redeploy undeploys and deploys the project and recycles its
     * listeners and pooled callers. Use &lt;code&gt;validate_only&lt;/code&gt; to check an update first.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;vtsi_project.name&lt;/code&gt;,
     * an unknown &lt;code&gt;update_mask&lt;/code&gt; path (also the prefixed form &lt;code&gt;vtsi_project.x&lt;/code&gt;), a mask
     * that clears the configuration source (&lt;code&gt;asterisk_configs&lt;/code&gt; with no arm set), an out-of-range
     * value (as on create) or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an
     * unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the project is &lt;code&gt;DELETING&lt;/code&gt;;
     * &lt;code&gt;ABORTED&lt;/code&gt; when another lifecycle operation of the project held it too long or the
     * project changed concurrently, nothing being written; &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;,
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description. When a deployed project&amp;apos;s
     * Asterisk cannot be reloaded, restarted or redeployed the RPC fails (&lt;code&gt;INTERNAL&lt;/code&gt; or
     * &lt;code&gt;UNAVAILABLE&lt;/code&gt;) and the project is left as the failure left it (see
     * &lt;code&gt;status_message&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project and on every agent of the
     * stored AND of the resulting &lt;code&gt;nlu_agent_names&lt;/code&gt; (removing an agent needs the same role as
     * adding it).&lt;/p&gt;
     * &lt;p&gt;Idempotency: an update is a set of absolute values, so a retry with the same request converges
     * to the same project (a redeploying update ends the calls of the retry&amp;apos;s moment too).&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectResponse> updateVtsiProject(
        ondewo.vtsi.ProjectsOuterClass.UpdateVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVtsiProjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a VTSI project and its configuration. A project that is deployed, deploying,
     * undeploying or &lt;code&gt;DEPLOY_FAILED&lt;/code&gt; is UNDEPLOYED FIRST, automatically, exactly as by &lt;code&gt;UndeployVtsiProject&lt;/code&gt;:
     * every call of the project ends and its listeners, callers and Asterisk container are removed. The
     * undeploy is best effort: a failing teardown is logged and the deletion goes on. The project then
     * moves to &lt;code&gt;DELETING&lt;/code&gt;, its stored configuration is removed and the project no longer
     * exists (&lt;code&gt;DELETED&lt;/code&gt; is never returned: a deleted
     * project is &lt;code&gt;NOT_FOUND&lt;/code&gt;). Deletion is permanent.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, also for a retry of a deletion that succeeded (the
     * RPC is not idempotent); &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;,
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UNDEPLOYED&lt;/code&gt; when it had to undeploy, then
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DELETED&lt;/code&gt;, the last event of the project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectResponse> deleteVtsiProject(
        ondewo.vtsi.ProjectsOuterClass.DeleteVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVtsiProjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deploys a VTSI project: starts its Asterisk container with the stored configuration and waits
     * until the container runs. SYNCHRONOUS: the RPC returns when the project is &lt;code&gt;DEPLOYED&lt;/code&gt;
     * or the deployment failed. The status moves &lt;code&gt;UNDEPLOYED&lt;/code&gt; (or &lt;code&gt;DEPLOY_FAILED&lt;/code&gt;)
     * &amp;gt; &lt;code&gt;DEPLOYING&lt;/code&gt; &amp;gt; &lt;code&gt;DEPLOYED&lt;/code&gt;; on failure the half-started container is
     * removed, the status becomes &lt;code&gt;DEPLOY_FAILED&lt;/code&gt; with the reason in
     * &lt;code&gt;status_message&lt;/code&gt;, and the RPC fails. The server waits about 30 seconds for the container
     * to run, plus the docker API timeout of each docker call (&lt;code&gt;ONDEWO_VTSI_DOCKER_API_TIMEOUT_S&lt;/code&gt;,
     * default 90 seconds); a client deadline of at least 3 minutes is recommended. Deploying applies the
     * project&amp;apos;s softphone accounts to the new Asterisk. No caller or listener is started: start them
     * with the &lt;code&gt;Calls&lt;/code&gt; service.&lt;/p&gt;
     * &lt;p&gt;Idempotent: deploying a &lt;code&gt;DEPLOYED&lt;/code&gt; project changes nothing and succeeds (nothing is
     * restarted); a deploy that arrives while another deploy of the project runs waits for it and then
     * finds the project &lt;code&gt;DEPLOYED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the project is
     * &lt;code&gt;DELETING&lt;/code&gt;, or &lt;code&gt;DEPLOYING&lt;/code&gt; / &lt;code&gt;UNDEPLOYING&lt;/code&gt; after the operation that
     * set the status was interrupted (undeploy the project first); &lt;code&gt;INTERNAL&lt;/code&gt; or
     * &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the deployment failed (the project is then
     * &lt;code&gt;DEPLOY_FAILED&lt;/code&gt;); &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;,
     * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DEPLOYED&lt;/code&gt; or
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DEPLOY_FAILED&lt;/code&gt;, and
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_STATUS_CHANGED&lt;/code&gt; per status change.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectResponse> deployVtsiProject(
        ondewo.vtsi.ProjectsOuterClass.DeployVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeployVtsiProjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Undeploys a VTSI project. SYNCHRONOUS: the status moves to &lt;code&gt;UNDEPLOYING&lt;/code&gt;, EVERY CALL
     * of the project is ended (callers and listeners alike, campaign calls included), the listeners and
     * the pooled callers are undeployed, the Asterisk container is removed, and the status becomes
     * &lt;code&gt;UNDEPLOYED&lt;/code&gt;. The registrations of the project&amp;apos;s softphone accounts end with the
     * container; the accounts themselves are kept and are applied again on the next deploy. The stored
     * configuration, callers, listeners and campaigns are kept. A failed undeploy restores the previous
     * status (or &lt;code&gt;UNDEPLOYED&lt;/code&gt; when the container is already gone) and fails the RPC.&lt;/p&gt;
     * &lt;p&gt;Idempotent: undeploying an &lt;code&gt;UNDEPLOYED&lt;/code&gt; project changes nothing and succeeds.
     * Undeploying a &lt;code&gt;DEPLOY_FAILED&lt;/code&gt; project removes what the failed deployment left and makes it
     * &lt;code&gt;UNDEPLOYED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty or malformed &lt;code&gt;name&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the project is
     * &lt;code&gt;DELETING&lt;/code&gt;; &lt;code&gt;INTERNAL&lt;/code&gt; or &lt;code&gt;UNAVAILABLE&lt;/code&gt; when the teardown failed;
     * &lt;code&gt;ABORTED&lt;/code&gt;, &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;, &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; as in the service
     * description.&lt;/p&gt;
     * &lt;p&gt;Authorization: &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher on the project.&lt;/p&gt;
     * &lt;p&gt;Events: &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UNDEPLOYED&lt;/code&gt; or
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_UNDEPLOY_FAILED&lt;/code&gt;, and
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_STATUS_CHANGED&lt;/code&gt; per status change.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectResponse> undeployVtsiProject(
        ondewo.vtsi.ProjectsOuterClass.UndeployVtsiProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeployVtsiProjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists VTSI projects, filtered, sorted and paged. With authorization enforced, only the projects
     * the caller holds a project role on are listed (every project for &lt;code&gt;SERVER_ADMIN&lt;/code&gt;), and
     * the configuration fields are withheld from a &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or
     * &lt;code&gt;PROJECT_USER&lt;/code&gt; (see the service description); a caller without a usable credential gets an
     * empty page.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a negative &lt;code&gt;page_size&lt;/code&gt;, a malformed
     * &lt;code&gt;page_token&lt;/code&gt;, an unspecified status in &lt;code&gt;statuses&lt;/code&gt;, an over-long
     * &lt;code&gt;display_name_contains&lt;/code&gt;, a &lt;code&gt;created_after&lt;/code&gt; that is not before
     * &lt;code&gt;created_before&lt;/code&gt;, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path;
     * &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; as in the service description.&lt;/p&gt;
     * &lt;p&gt;Authorization: any project role (&lt;code&gt;PROJECT_USER&lt;/code&gt; or higher).&lt;/p&gt;
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
