package ondewo.vtsi;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
 * &lt;p&gt;Manages the IVR MENUS of a VTSI project: keypad (DTMF) menus that a caller dialling one of the project&amp;apos;s
 * inbound phone numbers goes through BEFORE a bot or a person takes the call (&amp;quot;press 1 for sales, 2 for
 * billing&amp;quot;). A menu is a graph of nodes (&lt;code&gt;IvrNode&lt;/code&gt;): MENU (a prompt and one key), PLAY (a prompt),
 * SCHEDULE (opening hours), ROUTE (to a listener, the listener queue, a softphone account or a phone number),
 * GOTO_MENU (into another menu of the project) and HANGUP. The project&amp;apos;s Asterisk executes a menu as generated
 * dialplan: a menu keeps running while VTSI is down, and no user text ever reaches the dialplan.&lt;/p&gt;
 * &lt;p&gt;Lifecycle: &lt;code&gt;CreateIvrMenu&lt;/code&gt; / &lt;code&gt;UpdateIvrMenu&lt;/code&gt; save a DRAFT revision (every save is
 * validated; &lt;code&gt;ValidateIvrMenu&lt;/code&gt; returns every issue at once). Nothing routes until
 * &lt;code&gt;PublishIvrMenu&lt;/code&gt; renders a revision into the project&amp;apos;s Asterisk and switches the menu&amp;apos;s
 * &lt;code&gt;inbound_phone_numbers&lt;/code&gt; to it; a failed publish leaves the previous published revision live. A caller
 * inside a menu during a publish finishes on the revision they entered. &lt;code&gt;TestIvrMenu&lt;/code&gt; runs a scripted
 * test call through the published revision inside the Asterisk, and &lt;code&gt;GetIvrMenuTest&lt;/code&gt; reports it.&lt;/p&gt;
 * &lt;p&gt;A bot reached through a menu learns the path: the headers &lt;code&gt;X-ondewo-ivr-menu&lt;/code&gt; (the menu&amp;apos;s
 * display name, sanitized), &lt;code&gt;X-ondewo-ivr-path&lt;/code&gt; (the option labels taken, e.g.
 * &lt;code&gt;main:1&amp;gt;billing:2&lt;/code&gt;) and &lt;code&gt;X-ondewo-dialed-number&lt;/code&gt; become parameters of the bot&amp;apos;s
 * SIP context, and the call records them in &lt;code&gt;Call.ivr_menu_display_name&lt;/code&gt; / &lt;code&gt;Call.ivr_path&lt;/code&gt;,
 * and the menu&amp;apos;s resource name in &lt;code&gt;Call.ivr_menu_name&lt;/code&gt;.
 * Labels therefore must never carry a secret.&lt;/p&gt;
 * &lt;p&gt;Deployment switch: with &lt;code&gt;ONDEWO_VTSI_IVR_ACTIVE=false&lt;/code&gt; (the default) every RPC of this service
 * answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; with &lt;code&gt;reason=ivr-disabled&lt;/code&gt;. &lt;code&gt;VtsiProject.ivr_menus_enabled&lt;/code&gt;
 * switches the routes of one project off, and &lt;code&gt;VtsiProject.feature_availability.ivr&lt;/code&gt; says whether a project
 * can use IVR menus at all (a project whose Asterisk is not run by this server cannot: Publish is refused with
 * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=asterisk-not-local&lt;/code&gt;).&lt;/p&gt;
 * &lt;p&gt;Limits: &lt;code&gt;ONDEWO_VTSI_IVR_MAX_NODES&lt;/code&gt; nodes per menu (100),
 * &lt;code&gt;ONDEWO_VTSI_IVR_MAX_MENUS_PER_PROJECT&lt;/code&gt; menus (50), &lt;code&gt;ONDEWO_VTSI_IVR_MAX_PROMPT_BYTES&lt;/code&gt; per uploaded prompt (1048576),
 * &lt;code&gt;ONDEWO_VTSI_IVR_MAX_PROMPTS_TOTAL_BYTES&lt;/code&gt; per menu (52428800), &lt;code&gt;ONDEWO_VTSI_IVR_MAX_HOPS&lt;/code&gt; node
 * entries per call across menus (50; the call is then hung up).&lt;/p&gt;
 * &lt;p&gt;Every RPC about ONE menu accepts its resource name; Get and Delete also accept its display name, unique within a
 * project and resolved within &lt;code&gt;vtsi_project_name&lt;/code&gt;, which is then REQUIRED.&lt;/p&gt;
 * &lt;p&gt;Authorization (Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;, as Campaigns): &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher
 * for Create, Update, Delete, Publish, Clone and Test; &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher for Get, List,
 * Validate, ListRevisions, GetDialplan and GetIvrMenuTest. Every change emits its &lt;code&gt;VTSI_EVENT_IVR_MENU_*&lt;/code&gt;
 * event; a request with &lt;code&gt;validate_only&lt;/code&gt; emits nothing.&lt;/p&gt;
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class IvrMenusGrpc {

  private IvrMenusGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ondewo.vtsi.IvrMenus";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.CreateIvrMenuRequest,
      ondewo.vtsi.IvrMenusOuterClass.IvrMenu> getCreateIvrMenuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIvrMenu",
      requestType = ondewo.vtsi.IvrMenusOuterClass.CreateIvrMenuRequest.class,
      responseType = ondewo.vtsi.IvrMenusOuterClass.IvrMenu.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.CreateIvrMenuRequest,
      ondewo.vtsi.IvrMenusOuterClass.IvrMenu> getCreateIvrMenuMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.CreateIvrMenuRequest, ondewo.vtsi.IvrMenusOuterClass.IvrMenu> getCreateIvrMenuMethod;
    if ((getCreateIvrMenuMethod = IvrMenusGrpc.getCreateIvrMenuMethod) == null) {
      synchronized (IvrMenusGrpc.class) {
        if ((getCreateIvrMenuMethod = IvrMenusGrpc.getCreateIvrMenuMethod) == null) {
          IvrMenusGrpc.getCreateIvrMenuMethod = getCreateIvrMenuMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.IvrMenusOuterClass.CreateIvrMenuRequest, ondewo.vtsi.IvrMenusOuterClass.IvrMenu>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateIvrMenu"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.CreateIvrMenuRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.IvrMenu.getDefaultInstance()))
              .setSchemaDescriptor(new IvrMenusMethodDescriptorSupplier("CreateIvrMenu"))
              .build();
        }
      }
    }
    return getCreateIvrMenuMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuRequest,
      ondewo.vtsi.IvrMenusOuterClass.IvrMenu> getGetIvrMenuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIvrMenu",
      requestType = ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuRequest.class,
      responseType = ondewo.vtsi.IvrMenusOuterClass.IvrMenu.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuRequest,
      ondewo.vtsi.IvrMenusOuterClass.IvrMenu> getGetIvrMenuMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuRequest, ondewo.vtsi.IvrMenusOuterClass.IvrMenu> getGetIvrMenuMethod;
    if ((getGetIvrMenuMethod = IvrMenusGrpc.getGetIvrMenuMethod) == null) {
      synchronized (IvrMenusGrpc.class) {
        if ((getGetIvrMenuMethod = IvrMenusGrpc.getGetIvrMenuMethod) == null) {
          IvrMenusGrpc.getGetIvrMenuMethod = getGetIvrMenuMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuRequest, ondewo.vtsi.IvrMenusOuterClass.IvrMenu>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIvrMenu"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.IvrMenu.getDefaultInstance()))
              .setSchemaDescriptor(new IvrMenusMethodDescriptorSupplier("GetIvrMenu"))
              .build();
        }
      }
    }
    return getGetIvrMenuMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.UpdateIvrMenuRequest,
      ondewo.vtsi.IvrMenusOuterClass.IvrMenu> getUpdateIvrMenuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateIvrMenu",
      requestType = ondewo.vtsi.IvrMenusOuterClass.UpdateIvrMenuRequest.class,
      responseType = ondewo.vtsi.IvrMenusOuterClass.IvrMenu.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.UpdateIvrMenuRequest,
      ondewo.vtsi.IvrMenusOuterClass.IvrMenu> getUpdateIvrMenuMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.UpdateIvrMenuRequest, ondewo.vtsi.IvrMenusOuterClass.IvrMenu> getUpdateIvrMenuMethod;
    if ((getUpdateIvrMenuMethod = IvrMenusGrpc.getUpdateIvrMenuMethod) == null) {
      synchronized (IvrMenusGrpc.class) {
        if ((getUpdateIvrMenuMethod = IvrMenusGrpc.getUpdateIvrMenuMethod) == null) {
          IvrMenusGrpc.getUpdateIvrMenuMethod = getUpdateIvrMenuMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.IvrMenusOuterClass.UpdateIvrMenuRequest, ondewo.vtsi.IvrMenusOuterClass.IvrMenu>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateIvrMenu"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.UpdateIvrMenuRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.IvrMenu.getDefaultInstance()))
              .setSchemaDescriptor(new IvrMenusMethodDescriptorSupplier("UpdateIvrMenu"))
              .build();
        }
      }
    }
    return getUpdateIvrMenuMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuRequest,
      ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuResponse> getDeleteIvrMenuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIvrMenu",
      requestType = ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuRequest.class,
      responseType = ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuRequest,
      ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuResponse> getDeleteIvrMenuMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuRequest, ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuResponse> getDeleteIvrMenuMethod;
    if ((getDeleteIvrMenuMethod = IvrMenusGrpc.getDeleteIvrMenuMethod) == null) {
      synchronized (IvrMenusGrpc.class) {
        if ((getDeleteIvrMenuMethod = IvrMenusGrpc.getDeleteIvrMenuMethod) == null) {
          IvrMenusGrpc.getDeleteIvrMenuMethod = getDeleteIvrMenuMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuRequest, ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteIvrMenu"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IvrMenusMethodDescriptorSupplier("DeleteIvrMenu"))
              .build();
        }
      }
    }
    return getDeleteIvrMenuMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusRequest,
      ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusResponse> getListIvrMenusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIvrMenus",
      requestType = ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusRequest.class,
      responseType = ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusRequest,
      ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusResponse> getListIvrMenusMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusRequest, ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusResponse> getListIvrMenusMethod;
    if ((getListIvrMenusMethod = IvrMenusGrpc.getListIvrMenusMethod) == null) {
      synchronized (IvrMenusGrpc.class) {
        if ((getListIvrMenusMethod = IvrMenusGrpc.getListIvrMenusMethod) == null) {
          IvrMenusGrpc.getListIvrMenusMethod = getListIvrMenusMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusRequest, ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListIvrMenus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IvrMenusMethodDescriptorSupplier("ListIvrMenus"))
              .build();
        }
      }
    }
    return getListIvrMenusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuRequest,
      ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuResponse> getValidateIvrMenuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateIvrMenu",
      requestType = ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuRequest.class,
      responseType = ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuRequest,
      ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuResponse> getValidateIvrMenuMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuRequest, ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuResponse> getValidateIvrMenuMethod;
    if ((getValidateIvrMenuMethod = IvrMenusGrpc.getValidateIvrMenuMethod) == null) {
      synchronized (IvrMenusGrpc.class) {
        if ((getValidateIvrMenuMethod = IvrMenusGrpc.getValidateIvrMenuMethod) == null) {
          IvrMenusGrpc.getValidateIvrMenuMethod = getValidateIvrMenuMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuRequest, ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateIvrMenu"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IvrMenusMethodDescriptorSupplier("ValidateIvrMenu"))
              .build();
        }
      }
    }
    return getValidateIvrMenuMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.PublishIvrMenuRequest,
      ondewo.vtsi.IvrMenusOuterClass.IvrMenu> getPublishIvrMenuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PublishIvrMenu",
      requestType = ondewo.vtsi.IvrMenusOuterClass.PublishIvrMenuRequest.class,
      responseType = ondewo.vtsi.IvrMenusOuterClass.IvrMenu.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.PublishIvrMenuRequest,
      ondewo.vtsi.IvrMenusOuterClass.IvrMenu> getPublishIvrMenuMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.PublishIvrMenuRequest, ondewo.vtsi.IvrMenusOuterClass.IvrMenu> getPublishIvrMenuMethod;
    if ((getPublishIvrMenuMethod = IvrMenusGrpc.getPublishIvrMenuMethod) == null) {
      synchronized (IvrMenusGrpc.class) {
        if ((getPublishIvrMenuMethod = IvrMenusGrpc.getPublishIvrMenuMethod) == null) {
          IvrMenusGrpc.getPublishIvrMenuMethod = getPublishIvrMenuMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.IvrMenusOuterClass.PublishIvrMenuRequest, ondewo.vtsi.IvrMenusOuterClass.IvrMenu>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PublishIvrMenu"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.PublishIvrMenuRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.IvrMenu.getDefaultInstance()))
              .setSchemaDescriptor(new IvrMenusMethodDescriptorSupplier("PublishIvrMenu"))
              .build();
        }
      }
    }
    return getPublishIvrMenuMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.CloneIvrMenuRequest,
      ondewo.vtsi.IvrMenusOuterClass.IvrMenu> getCloneIvrMenuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CloneIvrMenu",
      requestType = ondewo.vtsi.IvrMenusOuterClass.CloneIvrMenuRequest.class,
      responseType = ondewo.vtsi.IvrMenusOuterClass.IvrMenu.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.CloneIvrMenuRequest,
      ondewo.vtsi.IvrMenusOuterClass.IvrMenu> getCloneIvrMenuMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.CloneIvrMenuRequest, ondewo.vtsi.IvrMenusOuterClass.IvrMenu> getCloneIvrMenuMethod;
    if ((getCloneIvrMenuMethod = IvrMenusGrpc.getCloneIvrMenuMethod) == null) {
      synchronized (IvrMenusGrpc.class) {
        if ((getCloneIvrMenuMethod = IvrMenusGrpc.getCloneIvrMenuMethod) == null) {
          IvrMenusGrpc.getCloneIvrMenuMethod = getCloneIvrMenuMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.IvrMenusOuterClass.CloneIvrMenuRequest, ondewo.vtsi.IvrMenusOuterClass.IvrMenu>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloneIvrMenu"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.CloneIvrMenuRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.IvrMenu.getDefaultInstance()))
              .setSchemaDescriptor(new IvrMenusMethodDescriptorSupplier("CloneIvrMenu"))
              .build();
        }
      }
    }
    return getCloneIvrMenuMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsRequest,
      ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsResponse> getListIvrMenuRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIvrMenuRevisions",
      requestType = ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsRequest.class,
      responseType = ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsRequest,
      ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsResponse> getListIvrMenuRevisionsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsRequest, ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsResponse> getListIvrMenuRevisionsMethod;
    if ((getListIvrMenuRevisionsMethod = IvrMenusGrpc.getListIvrMenuRevisionsMethod) == null) {
      synchronized (IvrMenusGrpc.class) {
        if ((getListIvrMenuRevisionsMethod = IvrMenusGrpc.getListIvrMenuRevisionsMethod) == null) {
          IvrMenusGrpc.getListIvrMenuRevisionsMethod = getListIvrMenuRevisionsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsRequest, ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListIvrMenuRevisions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IvrMenusMethodDescriptorSupplier("ListIvrMenuRevisions"))
              .build();
        }
      }
    }
    return getListIvrMenuRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.TestIvrMenuRequest,
      ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest> getTestIvrMenuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIvrMenu",
      requestType = ondewo.vtsi.IvrMenusOuterClass.TestIvrMenuRequest.class,
      responseType = ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.TestIvrMenuRequest,
      ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest> getTestIvrMenuMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.TestIvrMenuRequest, ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest> getTestIvrMenuMethod;
    if ((getTestIvrMenuMethod = IvrMenusGrpc.getTestIvrMenuMethod) == null) {
      synchronized (IvrMenusGrpc.class) {
        if ((getTestIvrMenuMethod = IvrMenusGrpc.getTestIvrMenuMethod) == null) {
          IvrMenusGrpc.getTestIvrMenuMethod = getTestIvrMenuMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.IvrMenusOuterClass.TestIvrMenuRequest, ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIvrMenu"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.TestIvrMenuRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest.getDefaultInstance()))
              .setSchemaDescriptor(new IvrMenusMethodDescriptorSupplier("TestIvrMenu"))
              .build();
        }
      }
    }
    return getTestIvrMenuMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuTestRequest,
      ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest> getGetIvrMenuTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIvrMenuTest",
      requestType = ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuTestRequest.class,
      responseType = ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuTestRequest,
      ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest> getGetIvrMenuTestMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuTestRequest, ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest> getGetIvrMenuTestMethod;
    if ((getGetIvrMenuTestMethod = IvrMenusGrpc.getGetIvrMenuTestMethod) == null) {
      synchronized (IvrMenusGrpc.class) {
        if ((getGetIvrMenuTestMethod = IvrMenusGrpc.getGetIvrMenuTestMethod) == null) {
          IvrMenusGrpc.getGetIvrMenuTestMethod = getGetIvrMenuTestMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuTestRequest, ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIvrMenuTest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuTestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest.getDefaultInstance()))
              .setSchemaDescriptor(new IvrMenusMethodDescriptorSupplier("GetIvrMenuTest"))
              .build();
        }
      }
    }
    return getGetIvrMenuTestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanRequest,
      ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanResponse> getGetIvrMenuDialplanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIvrMenuDialplan",
      requestType = ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanRequest.class,
      responseType = ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanRequest,
      ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanResponse> getGetIvrMenuDialplanMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanRequest, ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanResponse> getGetIvrMenuDialplanMethod;
    if ((getGetIvrMenuDialplanMethod = IvrMenusGrpc.getGetIvrMenuDialplanMethod) == null) {
      synchronized (IvrMenusGrpc.class) {
        if ((getGetIvrMenuDialplanMethod = IvrMenusGrpc.getGetIvrMenuDialplanMethod) == null) {
          IvrMenusGrpc.getGetIvrMenuDialplanMethod = getGetIvrMenuDialplanMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanRequest, ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIvrMenuDialplan"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IvrMenusMethodDescriptorSupplier("GetIvrMenuDialplan"))
              .build();
        }
      }
    }
    return getGetIvrMenuDialplanMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IvrMenusStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IvrMenusStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IvrMenusStub>() {
        @java.lang.Override
        public IvrMenusStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IvrMenusStub(channel, callOptions);
        }
      };
    return IvrMenusStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static IvrMenusBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IvrMenusBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IvrMenusBlockingV2Stub>() {
        @java.lang.Override
        public IvrMenusBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IvrMenusBlockingV2Stub(channel, callOptions);
        }
      };
    return IvrMenusBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IvrMenusBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IvrMenusBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IvrMenusBlockingStub>() {
        @java.lang.Override
        public IvrMenusBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IvrMenusBlockingStub(channel, callOptions);
        }
      };
    return IvrMenusBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IvrMenusFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IvrMenusFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IvrMenusFutureStub>() {
        @java.lang.Override
        public IvrMenusFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IvrMenusFutureStub(channel, callOptions);
        }
      };
    return IvrMenusFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the IVR MENUS of a VTSI project: keypad (DTMF) menus that a caller dialling one of the project&amp;apos;s
   * inbound phone numbers goes through BEFORE a bot or a person takes the call (&amp;quot;press 1 for sales, 2 for
   * billing&amp;quot;). A menu is a graph of nodes (&lt;code&gt;IvrNode&lt;/code&gt;): MENU (a prompt and one key), PLAY (a prompt),
   * SCHEDULE (opening hours), ROUTE (to a listener, the listener queue, a softphone account or a phone number),
   * GOTO_MENU (into another menu of the project) and HANGUP. The project&amp;apos;s Asterisk executes a menu as generated
   * dialplan: a menu keeps running while VTSI is down, and no user text ever reaches the dialplan.&lt;/p&gt;
   * &lt;p&gt;Lifecycle: &lt;code&gt;CreateIvrMenu&lt;/code&gt; / &lt;code&gt;UpdateIvrMenu&lt;/code&gt; save a DRAFT revision (every save is
   * validated; &lt;code&gt;ValidateIvrMenu&lt;/code&gt; returns every issue at once). Nothing routes until
   * &lt;code&gt;PublishIvrMenu&lt;/code&gt; renders a revision into the project&amp;apos;s Asterisk and switches the menu&amp;apos;s
   * &lt;code&gt;inbound_phone_numbers&lt;/code&gt; to it; a failed publish leaves the previous published revision live. A caller
   * inside a menu during a publish finishes on the revision they entered. &lt;code&gt;TestIvrMenu&lt;/code&gt; runs a scripted
   * test call through the published revision inside the Asterisk, and &lt;code&gt;GetIvrMenuTest&lt;/code&gt; reports it.&lt;/p&gt;
   * &lt;p&gt;A bot reached through a menu learns the path: the headers &lt;code&gt;X-ondewo-ivr-menu&lt;/code&gt; (the menu&amp;apos;s
   * display name, sanitized), &lt;code&gt;X-ondewo-ivr-path&lt;/code&gt; (the option labels taken, e.g.
   * &lt;code&gt;main:1&amp;gt;billing:2&lt;/code&gt;) and &lt;code&gt;X-ondewo-dialed-number&lt;/code&gt; become parameters of the bot&amp;apos;s
   * SIP context, and the call records them in &lt;code&gt;Call.ivr_menu_display_name&lt;/code&gt; / &lt;code&gt;Call.ivr_path&lt;/code&gt;,
   * and the menu&amp;apos;s resource name in &lt;code&gt;Call.ivr_menu_name&lt;/code&gt;.
   * Labels therefore must never carry a secret.&lt;/p&gt;
   * &lt;p&gt;Deployment switch: with &lt;code&gt;ONDEWO_VTSI_IVR_ACTIVE=false&lt;/code&gt; (the default) every RPC of this service
   * answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; with &lt;code&gt;reason=ivr-disabled&lt;/code&gt;. &lt;code&gt;VtsiProject.ivr_menus_enabled&lt;/code&gt;
   * switches the routes of one project off, and &lt;code&gt;VtsiProject.feature_availability.ivr&lt;/code&gt; says whether a project
   * can use IVR menus at all (a project whose Asterisk is not run by this server cannot: Publish is refused with
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=asterisk-not-local&lt;/code&gt;).&lt;/p&gt;
   * &lt;p&gt;Limits: &lt;code&gt;ONDEWO_VTSI_IVR_MAX_NODES&lt;/code&gt; nodes per menu (100),
   * &lt;code&gt;ONDEWO_VTSI_IVR_MAX_MENUS_PER_PROJECT&lt;/code&gt; menus (50), &lt;code&gt;ONDEWO_VTSI_IVR_MAX_PROMPT_BYTES&lt;/code&gt; per uploaded prompt (1048576),
   * &lt;code&gt;ONDEWO_VTSI_IVR_MAX_PROMPTS_TOTAL_BYTES&lt;/code&gt; per menu (52428800), &lt;code&gt;ONDEWO_VTSI_IVR_MAX_HOPS&lt;/code&gt; node
   * entries per call across menus (50; the call is then hung up).&lt;/p&gt;
   * &lt;p&gt;Every RPC about ONE menu accepts its resource name; Get and Delete also accept its display name, unique within a
   * project and resolved within &lt;code&gt;vtsi_project_name&lt;/code&gt;, which is then REQUIRED.&lt;/p&gt;
   * &lt;p&gt;Authorization (Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;, as Campaigns): &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher
   * for Create, Update, Delete, Publish, Clone and Test; &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher for Get, List,
   * Validate, ListRevisions, GetDialplan and GetIvrMenuTest. Every change emits its &lt;code&gt;VTSI_EVENT_IVR_MENU_*&lt;/code&gt;
   * event; a request with &lt;code&gt;validate_only&lt;/code&gt; emits nothing.&lt;/p&gt;
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * &lt;p&gt;Creates an IVR menu as a DRAFT (revision 1). Nothing routes until it is published.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; with the code and path of the FIRST error issue (see
     * &lt;code&gt;IvrMenuIssue&lt;/code&gt;; &lt;code&gt;ValidateIvrMenu&lt;/code&gt; returns all of them), a set output-only field, or a
     * malformed &lt;code&gt;idempotency_key&lt;/code&gt;; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a display name the project already has;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; beyond &lt;code&gt;ONDEWO_VTSI_IVR_MAX_MENUS_PER_PROJECT&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project.&lt;/p&gt;
     * </pre>
     */
    default void createIvrMenu(ondewo.vtsi.IvrMenusOuterClass.CreateIvrMenuRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenu> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateIvrMenuMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns an IVR menu at its current revision.&lt;/p&gt;
     * </pre>
     */
    default void getIvrMenu(ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenu> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIvrMenuMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt; and saves a new DRAFT revision (+1) when a graph field
     * changed. &lt;code&gt;layout&lt;/code&gt; alone is saved without a new revision.&lt;/p&gt;
     * &lt;p&gt;Errors: as &lt;code&gt;CreateIvrMenu&lt;/code&gt;, plus &lt;code&gt;ABORTED&lt;/code&gt; &lt;code&gt;reason=revision-mismatch&lt;/code&gt; when
     * &lt;code&gt;expected_revision&lt;/code&gt; is set and not the current revision.&lt;/p&gt;
     * </pre>
     */
    default void updateIvrMenu(ondewo.vtsi.IvrMenusOuterClass.UpdateIvrMenuRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenu> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateIvrMenuMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes an IVR menu and all its revisions; its bound phone numbers fall back to the project&amp;apos;s routing
     * without a menu at once.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=menu-published&lt;/code&gt; for a PUBLISHED menu with bound
     * phone numbers unless &lt;code&gt;force&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=menu-referenced&lt;/code&gt;
     * while a GOTO_MENU node of another menu names it; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown menu.&lt;/p&gt;
     * </pre>
     */
    default void deleteIvrMenu(ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteIvrMenuMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the IVR menus of a project.&lt;/p&gt;
     * </pre>
     */
    default void listIvrMenus(ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListIvrMenusMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Runs every check of Create, Update and Publish on the given draft and returns ALL issues with their node
     * paths. Writes nothing and emits nothing.&lt;/p&gt;
     * </pre>
     */
    default void validateIvrMenu(ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateIvrMenuMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Renders the given (or the current) revision into the project&amp;apos;s Asterisk: prompts synthesized or copied,
     * the dialplan reloaded and read back, every prompt checked, and only then the bound phone numbers switched to
     * it. Any failure restores the previous dialplan, leaves the previous published revision live and answers the
     * menu with &lt;code&gt;IVR_MENU_STATE_PUBLISH_FAILED&lt;/code&gt; and &lt;code&gt;state_message&lt;/code&gt;. Re-validates first,
     * because the allowlist, the softphone accounts or the listeners may have changed since the save. Binding or
     * unbinding a phone number ends no call.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an error issue; &lt;code&gt;ABORTED&lt;/code&gt;
     * &lt;code&gt;reason=revision-mismatch&lt;/code&gt; for a revision that is not current; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;
     * &lt;code&gt;reason=asterisk-not-local&lt;/code&gt;, &lt;code&gt;reason=project-not-deployed&lt;/code&gt; or
     * &lt;code&gt;reason=ivr-entry-hook-missing&lt;/code&gt; (a project whose own dialplan lacks the IVR entry hook);
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=target-menu-not-published&lt;/code&gt; when a GOTO_MENU node names a
     * menu that is not published.&lt;/p&gt;
     * </pre>
     */
    default void publishIvrMenu(ondewo.vtsi.IvrMenusOuterClass.PublishIvrMenuRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenu> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPublishIvrMenuMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Copies a menu (its current or a given revision) into a new DRAFT menu without phone numbers.&lt;/p&gt;
     * </pre>
     */
    default void cloneIvrMenu(ondewo.vtsi.IvrMenusOuterClass.CloneIvrMenuRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenu> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCloneIvrMenuMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the saved revisions of a menu, newest first.&lt;/p&gt;
     * </pre>
     */
    default void listIvrMenuRevisions(ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListIvrMenuRevisionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts a test call through the PUBLISHED revision of a menu and returns at once with the test in
     * &lt;code&gt;IVR_MENU_TEST_STATE_RUNNING&lt;/code&gt;; poll &lt;code&gt;GetIvrMenuTest&lt;/code&gt; for the result. The test call runs
     * INSIDE the project&amp;apos;s Asterisk: a local channel enters the menu, presses the scripted keys and records the
     * nodes it passes. No SIP container, no bot and no NLU session take part, and every ROUTE node is a stub that
     * records the target and hangs up: a test NEVER dials a listener, a softphone or a phone number.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=menu-not-published&lt;/code&gt;,
     * &lt;code&gt;reason=asterisk-not-local&lt;/code&gt; or &lt;code&gt;reason=project-not-deployed&lt;/code&gt;;
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for invalid steps or a &lt;code&gt;max_duration_s&lt;/code&gt; above
     * &lt;code&gt;ONDEWO_VTSI_IVR_TEST_MAX_DURATION_S&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void testIvrMenu(ondewo.vtsi.IvrMenusOuterClass.TestIvrMenuRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTestIvrMenuMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a test started by &lt;code&gt;TestIvrMenu&lt;/code&gt;: its state and the path traversed so far. A test is kept
     * for 24 hours after it finished, then &lt;code&gt;NOT_FOUND&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void getIvrMenuTest(ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuTestRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIvrMenuTestMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns the rendered dialplan of one revision, read-only, for support.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=revision-not-rendered&lt;/code&gt; for a revision that is no
     * longer (or was never) in the project&amp;apos;s Asterisk.&lt;/p&gt;
     * </pre>
     */
    default void getIvrMenuDialplan(ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIvrMenuDialplanMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service IvrMenus.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the IVR MENUS of a VTSI project: keypad (DTMF) menus that a caller dialling one of the project&amp;apos;s
   * inbound phone numbers goes through BEFORE a bot or a person takes the call (&amp;quot;press 1 for sales, 2 for
   * billing&amp;quot;). A menu is a graph of nodes (&lt;code&gt;IvrNode&lt;/code&gt;): MENU (a prompt and one key), PLAY (a prompt),
   * SCHEDULE (opening hours), ROUTE (to a listener, the listener queue, a softphone account or a phone number),
   * GOTO_MENU (into another menu of the project) and HANGUP. The project&amp;apos;s Asterisk executes a menu as generated
   * dialplan: a menu keeps running while VTSI is down, and no user text ever reaches the dialplan.&lt;/p&gt;
   * &lt;p&gt;Lifecycle: &lt;code&gt;CreateIvrMenu&lt;/code&gt; / &lt;code&gt;UpdateIvrMenu&lt;/code&gt; save a DRAFT revision (every save is
   * validated; &lt;code&gt;ValidateIvrMenu&lt;/code&gt; returns every issue at once). Nothing routes until
   * &lt;code&gt;PublishIvrMenu&lt;/code&gt; renders a revision into the project&amp;apos;s Asterisk and switches the menu&amp;apos;s
   * &lt;code&gt;inbound_phone_numbers&lt;/code&gt; to it; a failed publish leaves the previous published revision live. A caller
   * inside a menu during a publish finishes on the revision they entered. &lt;code&gt;TestIvrMenu&lt;/code&gt; runs a scripted
   * test call through the published revision inside the Asterisk, and &lt;code&gt;GetIvrMenuTest&lt;/code&gt; reports it.&lt;/p&gt;
   * &lt;p&gt;A bot reached through a menu learns the path: the headers &lt;code&gt;X-ondewo-ivr-menu&lt;/code&gt; (the menu&amp;apos;s
   * display name, sanitized), &lt;code&gt;X-ondewo-ivr-path&lt;/code&gt; (the option labels taken, e.g.
   * &lt;code&gt;main:1&amp;gt;billing:2&lt;/code&gt;) and &lt;code&gt;X-ondewo-dialed-number&lt;/code&gt; become parameters of the bot&amp;apos;s
   * SIP context, and the call records them in &lt;code&gt;Call.ivr_menu_display_name&lt;/code&gt; / &lt;code&gt;Call.ivr_path&lt;/code&gt;,
   * and the menu&amp;apos;s resource name in &lt;code&gt;Call.ivr_menu_name&lt;/code&gt;.
   * Labels therefore must never carry a secret.&lt;/p&gt;
   * &lt;p&gt;Deployment switch: with &lt;code&gt;ONDEWO_VTSI_IVR_ACTIVE=false&lt;/code&gt; (the default) every RPC of this service
   * answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; with &lt;code&gt;reason=ivr-disabled&lt;/code&gt;. &lt;code&gt;VtsiProject.ivr_menus_enabled&lt;/code&gt;
   * switches the routes of one project off, and &lt;code&gt;VtsiProject.feature_availability.ivr&lt;/code&gt; says whether a project
   * can use IVR menus at all (a project whose Asterisk is not run by this server cannot: Publish is refused with
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=asterisk-not-local&lt;/code&gt;).&lt;/p&gt;
   * &lt;p&gt;Limits: &lt;code&gt;ONDEWO_VTSI_IVR_MAX_NODES&lt;/code&gt; nodes per menu (100),
   * &lt;code&gt;ONDEWO_VTSI_IVR_MAX_MENUS_PER_PROJECT&lt;/code&gt; menus (50), &lt;code&gt;ONDEWO_VTSI_IVR_MAX_PROMPT_BYTES&lt;/code&gt; per uploaded prompt (1048576),
   * &lt;code&gt;ONDEWO_VTSI_IVR_MAX_PROMPTS_TOTAL_BYTES&lt;/code&gt; per menu (52428800), &lt;code&gt;ONDEWO_VTSI_IVR_MAX_HOPS&lt;/code&gt; node
   * entries per call across menus (50; the call is then hung up).&lt;/p&gt;
   * &lt;p&gt;Every RPC about ONE menu accepts its resource name; Get and Delete also accept its display name, unique within a
   * project and resolved within &lt;code&gt;vtsi_project_name&lt;/code&gt;, which is then REQUIRED.&lt;/p&gt;
   * &lt;p&gt;Authorization (Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;, as Campaigns): &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher
   * for Create, Update, Delete, Publish, Clone and Test; &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher for Get, List,
   * Validate, ListRevisions, GetDialplan and GetIvrMenuTest. Every change emits its &lt;code&gt;VTSI_EVENT_IVR_MENU_*&lt;/code&gt;
   * event; a request with &lt;code&gt;validate_only&lt;/code&gt; emits nothing.&lt;/p&gt;
   * </pre>
   */
  public static abstract class IvrMenusImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return IvrMenusGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service IvrMenus.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the IVR MENUS of a VTSI project: keypad (DTMF) menus that a caller dialling one of the project&amp;apos;s
   * inbound phone numbers goes through BEFORE a bot or a person takes the call (&amp;quot;press 1 for sales, 2 for
   * billing&amp;quot;). A menu is a graph of nodes (&lt;code&gt;IvrNode&lt;/code&gt;): MENU (a prompt and one key), PLAY (a prompt),
   * SCHEDULE (opening hours), ROUTE (to a listener, the listener queue, a softphone account or a phone number),
   * GOTO_MENU (into another menu of the project) and HANGUP. The project&amp;apos;s Asterisk executes a menu as generated
   * dialplan: a menu keeps running while VTSI is down, and no user text ever reaches the dialplan.&lt;/p&gt;
   * &lt;p&gt;Lifecycle: &lt;code&gt;CreateIvrMenu&lt;/code&gt; / &lt;code&gt;UpdateIvrMenu&lt;/code&gt; save a DRAFT revision (every save is
   * validated; &lt;code&gt;ValidateIvrMenu&lt;/code&gt; returns every issue at once). Nothing routes until
   * &lt;code&gt;PublishIvrMenu&lt;/code&gt; renders a revision into the project&amp;apos;s Asterisk and switches the menu&amp;apos;s
   * &lt;code&gt;inbound_phone_numbers&lt;/code&gt; to it; a failed publish leaves the previous published revision live. A caller
   * inside a menu during a publish finishes on the revision they entered. &lt;code&gt;TestIvrMenu&lt;/code&gt; runs a scripted
   * test call through the published revision inside the Asterisk, and &lt;code&gt;GetIvrMenuTest&lt;/code&gt; reports it.&lt;/p&gt;
   * &lt;p&gt;A bot reached through a menu learns the path: the headers &lt;code&gt;X-ondewo-ivr-menu&lt;/code&gt; (the menu&amp;apos;s
   * display name, sanitized), &lt;code&gt;X-ondewo-ivr-path&lt;/code&gt; (the option labels taken, e.g.
   * &lt;code&gt;main:1&amp;gt;billing:2&lt;/code&gt;) and &lt;code&gt;X-ondewo-dialed-number&lt;/code&gt; become parameters of the bot&amp;apos;s
   * SIP context, and the call records them in &lt;code&gt;Call.ivr_menu_display_name&lt;/code&gt; / &lt;code&gt;Call.ivr_path&lt;/code&gt;,
   * and the menu&amp;apos;s resource name in &lt;code&gt;Call.ivr_menu_name&lt;/code&gt;.
   * Labels therefore must never carry a secret.&lt;/p&gt;
   * &lt;p&gt;Deployment switch: with &lt;code&gt;ONDEWO_VTSI_IVR_ACTIVE=false&lt;/code&gt; (the default) every RPC of this service
   * answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; with &lt;code&gt;reason=ivr-disabled&lt;/code&gt;. &lt;code&gt;VtsiProject.ivr_menus_enabled&lt;/code&gt;
   * switches the routes of one project off, and &lt;code&gt;VtsiProject.feature_availability.ivr&lt;/code&gt; says whether a project
   * can use IVR menus at all (a project whose Asterisk is not run by this server cannot: Publish is refused with
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=asterisk-not-local&lt;/code&gt;).&lt;/p&gt;
   * &lt;p&gt;Limits: &lt;code&gt;ONDEWO_VTSI_IVR_MAX_NODES&lt;/code&gt; nodes per menu (100),
   * &lt;code&gt;ONDEWO_VTSI_IVR_MAX_MENUS_PER_PROJECT&lt;/code&gt; menus (50), &lt;code&gt;ONDEWO_VTSI_IVR_MAX_PROMPT_BYTES&lt;/code&gt; per uploaded prompt (1048576),
   * &lt;code&gt;ONDEWO_VTSI_IVR_MAX_PROMPTS_TOTAL_BYTES&lt;/code&gt; per menu (52428800), &lt;code&gt;ONDEWO_VTSI_IVR_MAX_HOPS&lt;/code&gt; node
   * entries per call across menus (50; the call is then hung up).&lt;/p&gt;
   * &lt;p&gt;Every RPC about ONE menu accepts its resource name; Get and Delete also accept its display name, unique within a
   * project and resolved within &lt;code&gt;vtsi_project_name&lt;/code&gt;, which is then REQUIRED.&lt;/p&gt;
   * &lt;p&gt;Authorization (Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;, as Campaigns): &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher
   * for Create, Update, Delete, Publish, Clone and Test; &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher for Get, List,
   * Validate, ListRevisions, GetDialplan and GetIvrMenuTest. Every change emits its &lt;code&gt;VTSI_EVENT_IVR_MENU_*&lt;/code&gt;
   * event; a request with &lt;code&gt;validate_only&lt;/code&gt; emits nothing.&lt;/p&gt;
   * </pre>
   */
  public static final class IvrMenusStub
      extends io.grpc.stub.AbstractAsyncStub<IvrMenusStub> {
    private IvrMenusStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IvrMenusStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IvrMenusStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates an IVR menu as a DRAFT (revision 1). Nothing routes until it is published.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; with the code and path of the FIRST error issue (see
     * &lt;code&gt;IvrMenuIssue&lt;/code&gt;; &lt;code&gt;ValidateIvrMenu&lt;/code&gt; returns all of them), a set output-only field, or a
     * malformed &lt;code&gt;idempotency_key&lt;/code&gt;; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a display name the project already has;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; beyond &lt;code&gt;ONDEWO_VTSI_IVR_MAX_MENUS_PER_PROJECT&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project.&lt;/p&gt;
     * </pre>
     */
    public void createIvrMenu(ondewo.vtsi.IvrMenusOuterClass.CreateIvrMenuRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenu> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIvrMenuMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns an IVR menu at its current revision.&lt;/p&gt;
     * </pre>
     */
    public void getIvrMenu(ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenu> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIvrMenuMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt; and saves a new DRAFT revision (+1) when a graph field
     * changed. &lt;code&gt;layout&lt;/code&gt; alone is saved without a new revision.&lt;/p&gt;
     * &lt;p&gt;Errors: as &lt;code&gt;CreateIvrMenu&lt;/code&gt;, plus &lt;code&gt;ABORTED&lt;/code&gt; &lt;code&gt;reason=revision-mismatch&lt;/code&gt; when
     * &lt;code&gt;expected_revision&lt;/code&gt; is set and not the current revision.&lt;/p&gt;
     * </pre>
     */
    public void updateIvrMenu(ondewo.vtsi.IvrMenusOuterClass.UpdateIvrMenuRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenu> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateIvrMenuMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes an IVR menu and all its revisions; its bound phone numbers fall back to the project&amp;apos;s routing
     * without a menu at once.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=menu-published&lt;/code&gt; for a PUBLISHED menu with bound
     * phone numbers unless &lt;code&gt;force&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=menu-referenced&lt;/code&gt;
     * while a GOTO_MENU node of another menu names it; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown menu.&lt;/p&gt;
     * </pre>
     */
    public void deleteIvrMenu(ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIvrMenuMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the IVR menus of a project.&lt;/p&gt;
     * </pre>
     */
    public void listIvrMenus(ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIvrMenusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Runs every check of Create, Update and Publish on the given draft and returns ALL issues with their node
     * paths. Writes nothing and emits nothing.&lt;/p&gt;
     * </pre>
     */
    public void validateIvrMenu(ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateIvrMenuMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Renders the given (or the current) revision into the project&amp;apos;s Asterisk: prompts synthesized or copied,
     * the dialplan reloaded and read back, every prompt checked, and only then the bound phone numbers switched to
     * it. Any failure restores the previous dialplan, leaves the previous published revision live and answers the
     * menu with &lt;code&gt;IVR_MENU_STATE_PUBLISH_FAILED&lt;/code&gt; and &lt;code&gt;state_message&lt;/code&gt;. Re-validates first,
     * because the allowlist, the softphone accounts or the listeners may have changed since the save. Binding or
     * unbinding a phone number ends no call.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an error issue; &lt;code&gt;ABORTED&lt;/code&gt;
     * &lt;code&gt;reason=revision-mismatch&lt;/code&gt; for a revision that is not current; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;
     * &lt;code&gt;reason=asterisk-not-local&lt;/code&gt;, &lt;code&gt;reason=project-not-deployed&lt;/code&gt; or
     * &lt;code&gt;reason=ivr-entry-hook-missing&lt;/code&gt; (a project whose own dialplan lacks the IVR entry hook);
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=target-menu-not-published&lt;/code&gt; when a GOTO_MENU node names a
     * menu that is not published.&lt;/p&gt;
     * </pre>
     */
    public void publishIvrMenu(ondewo.vtsi.IvrMenusOuterClass.PublishIvrMenuRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenu> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPublishIvrMenuMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Copies a menu (its current or a given revision) into a new DRAFT menu without phone numbers.&lt;/p&gt;
     * </pre>
     */
    public void cloneIvrMenu(ondewo.vtsi.IvrMenusOuterClass.CloneIvrMenuRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenu> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloneIvrMenuMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the saved revisions of a menu, newest first.&lt;/p&gt;
     * </pre>
     */
    public void listIvrMenuRevisions(ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIvrMenuRevisionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts a test call through the PUBLISHED revision of a menu and returns at once with the test in
     * &lt;code&gt;IVR_MENU_TEST_STATE_RUNNING&lt;/code&gt;; poll &lt;code&gt;GetIvrMenuTest&lt;/code&gt; for the result. The test call runs
     * INSIDE the project&amp;apos;s Asterisk: a local channel enters the menu, presses the scripted keys and records the
     * nodes it passes. No SIP container, no bot and no NLU session take part, and every ROUTE node is a stub that
     * records the target and hangs up: a test NEVER dials a listener, a softphone or a phone number.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=menu-not-published&lt;/code&gt;,
     * &lt;code&gt;reason=asterisk-not-local&lt;/code&gt; or &lt;code&gt;reason=project-not-deployed&lt;/code&gt;;
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for invalid steps or a &lt;code&gt;max_duration_s&lt;/code&gt; above
     * &lt;code&gt;ONDEWO_VTSI_IVR_TEST_MAX_DURATION_S&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void testIvrMenu(ondewo.vtsi.IvrMenusOuterClass.TestIvrMenuRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIvrMenuMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a test started by &lt;code&gt;TestIvrMenu&lt;/code&gt;: its state and the path traversed so far. A test is kept
     * for 24 hours after it finished, then &lt;code&gt;NOT_FOUND&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void getIvrMenuTest(ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuTestRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIvrMenuTestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns the rendered dialplan of one revision, read-only, for support.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=revision-not-rendered&lt;/code&gt; for a revision that is no
     * longer (or was never) in the project&amp;apos;s Asterisk.&lt;/p&gt;
     * </pre>
     */
    public void getIvrMenuDialplan(ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIvrMenuDialplanMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service IvrMenus.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the IVR MENUS of a VTSI project: keypad (DTMF) menus that a caller dialling one of the project&amp;apos;s
   * inbound phone numbers goes through BEFORE a bot or a person takes the call (&amp;quot;press 1 for sales, 2 for
   * billing&amp;quot;). A menu is a graph of nodes (&lt;code&gt;IvrNode&lt;/code&gt;): MENU (a prompt and one key), PLAY (a prompt),
   * SCHEDULE (opening hours), ROUTE (to a listener, the listener queue, a softphone account or a phone number),
   * GOTO_MENU (into another menu of the project) and HANGUP. The project&amp;apos;s Asterisk executes a menu as generated
   * dialplan: a menu keeps running while VTSI is down, and no user text ever reaches the dialplan.&lt;/p&gt;
   * &lt;p&gt;Lifecycle: &lt;code&gt;CreateIvrMenu&lt;/code&gt; / &lt;code&gt;UpdateIvrMenu&lt;/code&gt; save a DRAFT revision (every save is
   * validated; &lt;code&gt;ValidateIvrMenu&lt;/code&gt; returns every issue at once). Nothing routes until
   * &lt;code&gt;PublishIvrMenu&lt;/code&gt; renders a revision into the project&amp;apos;s Asterisk and switches the menu&amp;apos;s
   * &lt;code&gt;inbound_phone_numbers&lt;/code&gt; to it; a failed publish leaves the previous published revision live. A caller
   * inside a menu during a publish finishes on the revision they entered. &lt;code&gt;TestIvrMenu&lt;/code&gt; runs a scripted
   * test call through the published revision inside the Asterisk, and &lt;code&gt;GetIvrMenuTest&lt;/code&gt; reports it.&lt;/p&gt;
   * &lt;p&gt;A bot reached through a menu learns the path: the headers &lt;code&gt;X-ondewo-ivr-menu&lt;/code&gt; (the menu&amp;apos;s
   * display name, sanitized), &lt;code&gt;X-ondewo-ivr-path&lt;/code&gt; (the option labels taken, e.g.
   * &lt;code&gt;main:1&amp;gt;billing:2&lt;/code&gt;) and &lt;code&gt;X-ondewo-dialed-number&lt;/code&gt; become parameters of the bot&amp;apos;s
   * SIP context, and the call records them in &lt;code&gt;Call.ivr_menu_display_name&lt;/code&gt; / &lt;code&gt;Call.ivr_path&lt;/code&gt;,
   * and the menu&amp;apos;s resource name in &lt;code&gt;Call.ivr_menu_name&lt;/code&gt;.
   * Labels therefore must never carry a secret.&lt;/p&gt;
   * &lt;p&gt;Deployment switch: with &lt;code&gt;ONDEWO_VTSI_IVR_ACTIVE=false&lt;/code&gt; (the default) every RPC of this service
   * answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; with &lt;code&gt;reason=ivr-disabled&lt;/code&gt;. &lt;code&gt;VtsiProject.ivr_menus_enabled&lt;/code&gt;
   * switches the routes of one project off, and &lt;code&gt;VtsiProject.feature_availability.ivr&lt;/code&gt; says whether a project
   * can use IVR menus at all (a project whose Asterisk is not run by this server cannot: Publish is refused with
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=asterisk-not-local&lt;/code&gt;).&lt;/p&gt;
   * &lt;p&gt;Limits: &lt;code&gt;ONDEWO_VTSI_IVR_MAX_NODES&lt;/code&gt; nodes per menu (100),
   * &lt;code&gt;ONDEWO_VTSI_IVR_MAX_MENUS_PER_PROJECT&lt;/code&gt; menus (50), &lt;code&gt;ONDEWO_VTSI_IVR_MAX_PROMPT_BYTES&lt;/code&gt; per uploaded prompt (1048576),
   * &lt;code&gt;ONDEWO_VTSI_IVR_MAX_PROMPTS_TOTAL_BYTES&lt;/code&gt; per menu (52428800), &lt;code&gt;ONDEWO_VTSI_IVR_MAX_HOPS&lt;/code&gt; node
   * entries per call across menus (50; the call is then hung up).&lt;/p&gt;
   * &lt;p&gt;Every RPC about ONE menu accepts its resource name; Get and Delete also accept its display name, unique within a
   * project and resolved within &lt;code&gt;vtsi_project_name&lt;/code&gt;, which is then REQUIRED.&lt;/p&gt;
   * &lt;p&gt;Authorization (Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;, as Campaigns): &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher
   * for Create, Update, Delete, Publish, Clone and Test; &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher for Get, List,
   * Validate, ListRevisions, GetDialplan and GetIvrMenuTest. Every change emits its &lt;code&gt;VTSI_EVENT_IVR_MENU_*&lt;/code&gt;
   * event; a request with &lt;code&gt;validate_only&lt;/code&gt; emits nothing.&lt;/p&gt;
   * </pre>
   */
  public static final class IvrMenusBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<IvrMenusBlockingV2Stub> {
    private IvrMenusBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IvrMenusBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IvrMenusBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates an IVR menu as a DRAFT (revision 1). Nothing routes until it is published.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; with the code and path of the FIRST error issue (see
     * &lt;code&gt;IvrMenuIssue&lt;/code&gt;; &lt;code&gt;ValidateIvrMenu&lt;/code&gt; returns all of them), a set output-only field, or a
     * malformed &lt;code&gt;idempotency_key&lt;/code&gt;; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a display name the project already has;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; beyond &lt;code&gt;ONDEWO_VTSI_IVR_MAX_MENUS_PER_PROJECT&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.IvrMenu createIvrMenu(ondewo.vtsi.IvrMenusOuterClass.CreateIvrMenuRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateIvrMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns an IVR menu at its current revision.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.IvrMenu getIvrMenu(ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetIvrMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt; and saves a new DRAFT revision (+1) when a graph field
     * changed. &lt;code&gt;layout&lt;/code&gt; alone is saved without a new revision.&lt;/p&gt;
     * &lt;p&gt;Errors: as &lt;code&gt;CreateIvrMenu&lt;/code&gt;, plus &lt;code&gt;ABORTED&lt;/code&gt; &lt;code&gt;reason=revision-mismatch&lt;/code&gt; when
     * &lt;code&gt;expected_revision&lt;/code&gt; is set and not the current revision.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.IvrMenu updateIvrMenu(ondewo.vtsi.IvrMenusOuterClass.UpdateIvrMenuRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateIvrMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes an IVR menu and all its revisions; its bound phone numbers fall back to the project&amp;apos;s routing
     * without a menu at once.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=menu-published&lt;/code&gt; for a PUBLISHED menu with bound
     * phone numbers unless &lt;code&gt;force&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=menu-referenced&lt;/code&gt;
     * while a GOTO_MENU node of another menu names it; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown menu.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuResponse deleteIvrMenu(ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteIvrMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the IVR menus of a project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusResponse listIvrMenus(ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListIvrMenusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Runs every check of Create, Update and Publish on the given draft and returns ALL issues with their node
     * paths. Writes nothing and emits nothing.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuResponse validateIvrMenu(ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getValidateIvrMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Renders the given (or the current) revision into the project&amp;apos;s Asterisk: prompts synthesized or copied,
     * the dialplan reloaded and read back, every prompt checked, and only then the bound phone numbers switched to
     * it. Any failure restores the previous dialplan, leaves the previous published revision live and answers the
     * menu with &lt;code&gt;IVR_MENU_STATE_PUBLISH_FAILED&lt;/code&gt; and &lt;code&gt;state_message&lt;/code&gt;. Re-validates first,
     * because the allowlist, the softphone accounts or the listeners may have changed since the save. Binding or
     * unbinding a phone number ends no call.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an error issue; &lt;code&gt;ABORTED&lt;/code&gt;
     * &lt;code&gt;reason=revision-mismatch&lt;/code&gt; for a revision that is not current; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;
     * &lt;code&gt;reason=asterisk-not-local&lt;/code&gt;, &lt;code&gt;reason=project-not-deployed&lt;/code&gt; or
     * &lt;code&gt;reason=ivr-entry-hook-missing&lt;/code&gt; (a project whose own dialplan lacks the IVR entry hook);
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=target-menu-not-published&lt;/code&gt; when a GOTO_MENU node names a
     * menu that is not published.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.IvrMenu publishIvrMenu(ondewo.vtsi.IvrMenusOuterClass.PublishIvrMenuRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPublishIvrMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Copies a menu (its current or a given revision) into a new DRAFT menu without phone numbers.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.IvrMenu cloneIvrMenu(ondewo.vtsi.IvrMenusOuterClass.CloneIvrMenuRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCloneIvrMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the saved revisions of a menu, newest first.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsResponse listIvrMenuRevisions(ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListIvrMenuRevisionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts a test call through the PUBLISHED revision of a menu and returns at once with the test in
     * &lt;code&gt;IVR_MENU_TEST_STATE_RUNNING&lt;/code&gt;; poll &lt;code&gt;GetIvrMenuTest&lt;/code&gt; for the result. The test call runs
     * INSIDE the project&amp;apos;s Asterisk: a local channel enters the menu, presses the scripted keys and records the
     * nodes it passes. No SIP container, no bot and no NLU session take part, and every ROUTE node is a stub that
     * records the target and hangs up: a test NEVER dials a listener, a softphone or a phone number.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=menu-not-published&lt;/code&gt;,
     * &lt;code&gt;reason=asterisk-not-local&lt;/code&gt; or &lt;code&gt;reason=project-not-deployed&lt;/code&gt;;
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for invalid steps or a &lt;code&gt;max_duration_s&lt;/code&gt; above
     * &lt;code&gt;ONDEWO_VTSI_IVR_TEST_MAX_DURATION_S&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest testIvrMenu(ondewo.vtsi.IvrMenusOuterClass.TestIvrMenuRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getTestIvrMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a test started by &lt;code&gt;TestIvrMenu&lt;/code&gt;: its state and the path traversed so far. A test is kept
     * for 24 hours after it finished, then &lt;code&gt;NOT_FOUND&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest getIvrMenuTest(ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuTestRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetIvrMenuTestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns the rendered dialplan of one revision, read-only, for support.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=revision-not-rendered&lt;/code&gt; for a revision that is no
     * longer (or was never) in the project&amp;apos;s Asterisk.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanResponse getIvrMenuDialplan(ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetIvrMenuDialplanMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service IvrMenus.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the IVR MENUS of a VTSI project: keypad (DTMF) menus that a caller dialling one of the project&amp;apos;s
   * inbound phone numbers goes through BEFORE a bot or a person takes the call (&amp;quot;press 1 for sales, 2 for
   * billing&amp;quot;). A menu is a graph of nodes (&lt;code&gt;IvrNode&lt;/code&gt;): MENU (a prompt and one key), PLAY (a prompt),
   * SCHEDULE (opening hours), ROUTE (to a listener, the listener queue, a softphone account or a phone number),
   * GOTO_MENU (into another menu of the project) and HANGUP. The project&amp;apos;s Asterisk executes a menu as generated
   * dialplan: a menu keeps running while VTSI is down, and no user text ever reaches the dialplan.&lt;/p&gt;
   * &lt;p&gt;Lifecycle: &lt;code&gt;CreateIvrMenu&lt;/code&gt; / &lt;code&gt;UpdateIvrMenu&lt;/code&gt; save a DRAFT revision (every save is
   * validated; &lt;code&gt;ValidateIvrMenu&lt;/code&gt; returns every issue at once). Nothing routes until
   * &lt;code&gt;PublishIvrMenu&lt;/code&gt; renders a revision into the project&amp;apos;s Asterisk and switches the menu&amp;apos;s
   * &lt;code&gt;inbound_phone_numbers&lt;/code&gt; to it; a failed publish leaves the previous published revision live. A caller
   * inside a menu during a publish finishes on the revision they entered. &lt;code&gt;TestIvrMenu&lt;/code&gt; runs a scripted
   * test call through the published revision inside the Asterisk, and &lt;code&gt;GetIvrMenuTest&lt;/code&gt; reports it.&lt;/p&gt;
   * &lt;p&gt;A bot reached through a menu learns the path: the headers &lt;code&gt;X-ondewo-ivr-menu&lt;/code&gt; (the menu&amp;apos;s
   * display name, sanitized), &lt;code&gt;X-ondewo-ivr-path&lt;/code&gt; (the option labels taken, e.g.
   * &lt;code&gt;main:1&amp;gt;billing:2&lt;/code&gt;) and &lt;code&gt;X-ondewo-dialed-number&lt;/code&gt; become parameters of the bot&amp;apos;s
   * SIP context, and the call records them in &lt;code&gt;Call.ivr_menu_display_name&lt;/code&gt; / &lt;code&gt;Call.ivr_path&lt;/code&gt;,
   * and the menu&amp;apos;s resource name in &lt;code&gt;Call.ivr_menu_name&lt;/code&gt;.
   * Labels therefore must never carry a secret.&lt;/p&gt;
   * &lt;p&gt;Deployment switch: with &lt;code&gt;ONDEWO_VTSI_IVR_ACTIVE=false&lt;/code&gt; (the default) every RPC of this service
   * answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; with &lt;code&gt;reason=ivr-disabled&lt;/code&gt;. &lt;code&gt;VtsiProject.ivr_menus_enabled&lt;/code&gt;
   * switches the routes of one project off, and &lt;code&gt;VtsiProject.feature_availability.ivr&lt;/code&gt; says whether a project
   * can use IVR menus at all (a project whose Asterisk is not run by this server cannot: Publish is refused with
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=asterisk-not-local&lt;/code&gt;).&lt;/p&gt;
   * &lt;p&gt;Limits: &lt;code&gt;ONDEWO_VTSI_IVR_MAX_NODES&lt;/code&gt; nodes per menu (100),
   * &lt;code&gt;ONDEWO_VTSI_IVR_MAX_MENUS_PER_PROJECT&lt;/code&gt; menus (50), &lt;code&gt;ONDEWO_VTSI_IVR_MAX_PROMPT_BYTES&lt;/code&gt; per uploaded prompt (1048576),
   * &lt;code&gt;ONDEWO_VTSI_IVR_MAX_PROMPTS_TOTAL_BYTES&lt;/code&gt; per menu (52428800), &lt;code&gt;ONDEWO_VTSI_IVR_MAX_HOPS&lt;/code&gt; node
   * entries per call across menus (50; the call is then hung up).&lt;/p&gt;
   * &lt;p&gt;Every RPC about ONE menu accepts its resource name; Get and Delete also accept its display name, unique within a
   * project and resolved within &lt;code&gt;vtsi_project_name&lt;/code&gt;, which is then REQUIRED.&lt;/p&gt;
   * &lt;p&gt;Authorization (Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;, as Campaigns): &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher
   * for Create, Update, Delete, Publish, Clone and Test; &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher for Get, List,
   * Validate, ListRevisions, GetDialplan and GetIvrMenuTest. Every change emits its &lt;code&gt;VTSI_EVENT_IVR_MENU_*&lt;/code&gt;
   * event; a request with &lt;code&gt;validate_only&lt;/code&gt; emits nothing.&lt;/p&gt;
   * </pre>
   */
  public static final class IvrMenusBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IvrMenusBlockingStub> {
    private IvrMenusBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IvrMenusBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IvrMenusBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates an IVR menu as a DRAFT (revision 1). Nothing routes until it is published.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; with the code and path of the FIRST error issue (see
     * &lt;code&gt;IvrMenuIssue&lt;/code&gt;; &lt;code&gt;ValidateIvrMenu&lt;/code&gt; returns all of them), a set output-only field, or a
     * malformed &lt;code&gt;idempotency_key&lt;/code&gt;; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a display name the project already has;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; beyond &lt;code&gt;ONDEWO_VTSI_IVR_MAX_MENUS_PER_PROJECT&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.IvrMenu createIvrMenu(ondewo.vtsi.IvrMenusOuterClass.CreateIvrMenuRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIvrMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns an IVR menu at its current revision.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.IvrMenu getIvrMenu(ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIvrMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt; and saves a new DRAFT revision (+1) when a graph field
     * changed. &lt;code&gt;layout&lt;/code&gt; alone is saved without a new revision.&lt;/p&gt;
     * &lt;p&gt;Errors: as &lt;code&gt;CreateIvrMenu&lt;/code&gt;, plus &lt;code&gt;ABORTED&lt;/code&gt; &lt;code&gt;reason=revision-mismatch&lt;/code&gt; when
     * &lt;code&gt;expected_revision&lt;/code&gt; is set and not the current revision.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.IvrMenu updateIvrMenu(ondewo.vtsi.IvrMenusOuterClass.UpdateIvrMenuRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIvrMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes an IVR menu and all its revisions; its bound phone numbers fall back to the project&amp;apos;s routing
     * without a menu at once.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=menu-published&lt;/code&gt; for a PUBLISHED menu with bound
     * phone numbers unless &lt;code&gt;force&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=menu-referenced&lt;/code&gt;
     * while a GOTO_MENU node of another menu names it; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown menu.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuResponse deleteIvrMenu(ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIvrMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the IVR menus of a project.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusResponse listIvrMenus(ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIvrMenusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Runs every check of Create, Update and Publish on the given draft and returns ALL issues with their node
     * paths. Writes nothing and emits nothing.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuResponse validateIvrMenu(ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateIvrMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Renders the given (or the current) revision into the project&amp;apos;s Asterisk: prompts synthesized or copied,
     * the dialplan reloaded and read back, every prompt checked, and only then the bound phone numbers switched to
     * it. Any failure restores the previous dialplan, leaves the previous published revision live and answers the
     * menu with &lt;code&gt;IVR_MENU_STATE_PUBLISH_FAILED&lt;/code&gt; and &lt;code&gt;state_message&lt;/code&gt;. Re-validates first,
     * because the allowlist, the softphone accounts or the listeners may have changed since the save. Binding or
     * unbinding a phone number ends no call.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an error issue; &lt;code&gt;ABORTED&lt;/code&gt;
     * &lt;code&gt;reason=revision-mismatch&lt;/code&gt; for a revision that is not current; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;
     * &lt;code&gt;reason=asterisk-not-local&lt;/code&gt;, &lt;code&gt;reason=project-not-deployed&lt;/code&gt; or
     * &lt;code&gt;reason=ivr-entry-hook-missing&lt;/code&gt; (a project whose own dialplan lacks the IVR entry hook);
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=target-menu-not-published&lt;/code&gt; when a GOTO_MENU node names a
     * menu that is not published.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.IvrMenu publishIvrMenu(ondewo.vtsi.IvrMenusOuterClass.PublishIvrMenuRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPublishIvrMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Copies a menu (its current or a given revision) into a new DRAFT menu without phone numbers.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.IvrMenu cloneIvrMenu(ondewo.vtsi.IvrMenusOuterClass.CloneIvrMenuRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloneIvrMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the saved revisions of a menu, newest first.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsResponse listIvrMenuRevisions(ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIvrMenuRevisionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts a test call through the PUBLISHED revision of a menu and returns at once with the test in
     * &lt;code&gt;IVR_MENU_TEST_STATE_RUNNING&lt;/code&gt;; poll &lt;code&gt;GetIvrMenuTest&lt;/code&gt; for the result. The test call runs
     * INSIDE the project&amp;apos;s Asterisk: a local channel enters the menu, presses the scripted keys and records the
     * nodes it passes. No SIP container, no bot and no NLU session take part, and every ROUTE node is a stub that
     * records the target and hangs up: a test NEVER dials a listener, a softphone or a phone number.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=menu-not-published&lt;/code&gt;,
     * &lt;code&gt;reason=asterisk-not-local&lt;/code&gt; or &lt;code&gt;reason=project-not-deployed&lt;/code&gt;;
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for invalid steps or a &lt;code&gt;max_duration_s&lt;/code&gt; above
     * &lt;code&gt;ONDEWO_VTSI_IVR_TEST_MAX_DURATION_S&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest testIvrMenu(ondewo.vtsi.IvrMenusOuterClass.TestIvrMenuRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIvrMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a test started by &lt;code&gt;TestIvrMenu&lt;/code&gt;: its state and the path traversed so far. A test is kept
     * for 24 hours after it finished, then &lt;code&gt;NOT_FOUND&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest getIvrMenuTest(ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuTestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIvrMenuTestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns the rendered dialplan of one revision, read-only, for support.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=revision-not-rendered&lt;/code&gt; for a revision that is no
     * longer (or was never) in the project&amp;apos;s Asterisk.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanResponse getIvrMenuDialplan(ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIvrMenuDialplanMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service IvrMenus.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the IVR MENUS of a VTSI project: keypad (DTMF) menus that a caller dialling one of the project&amp;apos;s
   * inbound phone numbers goes through BEFORE a bot or a person takes the call (&amp;quot;press 1 for sales, 2 for
   * billing&amp;quot;). A menu is a graph of nodes (&lt;code&gt;IvrNode&lt;/code&gt;): MENU (a prompt and one key), PLAY (a prompt),
   * SCHEDULE (opening hours), ROUTE (to a listener, the listener queue, a softphone account or a phone number),
   * GOTO_MENU (into another menu of the project) and HANGUP. The project&amp;apos;s Asterisk executes a menu as generated
   * dialplan: a menu keeps running while VTSI is down, and no user text ever reaches the dialplan.&lt;/p&gt;
   * &lt;p&gt;Lifecycle: &lt;code&gt;CreateIvrMenu&lt;/code&gt; / &lt;code&gt;UpdateIvrMenu&lt;/code&gt; save a DRAFT revision (every save is
   * validated; &lt;code&gt;ValidateIvrMenu&lt;/code&gt; returns every issue at once). Nothing routes until
   * &lt;code&gt;PublishIvrMenu&lt;/code&gt; renders a revision into the project&amp;apos;s Asterisk and switches the menu&amp;apos;s
   * &lt;code&gt;inbound_phone_numbers&lt;/code&gt; to it; a failed publish leaves the previous published revision live. A caller
   * inside a menu during a publish finishes on the revision they entered. &lt;code&gt;TestIvrMenu&lt;/code&gt; runs a scripted
   * test call through the published revision inside the Asterisk, and &lt;code&gt;GetIvrMenuTest&lt;/code&gt; reports it.&lt;/p&gt;
   * &lt;p&gt;A bot reached through a menu learns the path: the headers &lt;code&gt;X-ondewo-ivr-menu&lt;/code&gt; (the menu&amp;apos;s
   * display name, sanitized), &lt;code&gt;X-ondewo-ivr-path&lt;/code&gt; (the option labels taken, e.g.
   * &lt;code&gt;main:1&amp;gt;billing:2&lt;/code&gt;) and &lt;code&gt;X-ondewo-dialed-number&lt;/code&gt; become parameters of the bot&amp;apos;s
   * SIP context, and the call records them in &lt;code&gt;Call.ivr_menu_display_name&lt;/code&gt; / &lt;code&gt;Call.ivr_path&lt;/code&gt;,
   * and the menu&amp;apos;s resource name in &lt;code&gt;Call.ivr_menu_name&lt;/code&gt;.
   * Labels therefore must never carry a secret.&lt;/p&gt;
   * &lt;p&gt;Deployment switch: with &lt;code&gt;ONDEWO_VTSI_IVR_ACTIVE=false&lt;/code&gt; (the default) every RPC of this service
   * answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; with &lt;code&gt;reason=ivr-disabled&lt;/code&gt;. &lt;code&gt;VtsiProject.ivr_menus_enabled&lt;/code&gt;
   * switches the routes of one project off, and &lt;code&gt;VtsiProject.feature_availability.ivr&lt;/code&gt; says whether a project
   * can use IVR menus at all (a project whose Asterisk is not run by this server cannot: Publish is refused with
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=asterisk-not-local&lt;/code&gt;).&lt;/p&gt;
   * &lt;p&gt;Limits: &lt;code&gt;ONDEWO_VTSI_IVR_MAX_NODES&lt;/code&gt; nodes per menu (100),
   * &lt;code&gt;ONDEWO_VTSI_IVR_MAX_MENUS_PER_PROJECT&lt;/code&gt; menus (50), &lt;code&gt;ONDEWO_VTSI_IVR_MAX_PROMPT_BYTES&lt;/code&gt; per uploaded prompt (1048576),
   * &lt;code&gt;ONDEWO_VTSI_IVR_MAX_PROMPTS_TOTAL_BYTES&lt;/code&gt; per menu (52428800), &lt;code&gt;ONDEWO_VTSI_IVR_MAX_HOPS&lt;/code&gt; node
   * entries per call across menus (50; the call is then hung up).&lt;/p&gt;
   * &lt;p&gt;Every RPC about ONE menu accepts its resource name; Get and Delete also accept its display name, unique within a
   * project and resolved within &lt;code&gt;vtsi_project_name&lt;/code&gt;, which is then REQUIRED.&lt;/p&gt;
   * &lt;p&gt;Authorization (Keycloak auth mode &lt;code&gt;ENFORCE&lt;/code&gt;, as Campaigns): &lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt; or higher
   * for Create, Update, Delete, Publish, Clone and Test; &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or higher for Get, List,
   * Validate, ListRevisions, GetDialplan and GetIvrMenuTest. Every change emits its &lt;code&gt;VTSI_EVENT_IVR_MENU_*&lt;/code&gt;
   * event; a request with &lt;code&gt;validate_only&lt;/code&gt; emits nothing.&lt;/p&gt;
   * </pre>
   */
  public static final class IvrMenusFutureStub
      extends io.grpc.stub.AbstractFutureStub<IvrMenusFutureStub> {
    private IvrMenusFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IvrMenusFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IvrMenusFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates an IVR menu as a DRAFT (revision 1). Nothing routes until it is published.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; with the code and path of the FIRST error issue (see
     * &lt;code&gt;IvrMenuIssue&lt;/code&gt;; &lt;code&gt;ValidateIvrMenu&lt;/code&gt; returns all of them), a set output-only field, or a
     * malformed &lt;code&gt;idempotency_key&lt;/code&gt;; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a display name the project already has;
     * &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; beyond &lt;code&gt;ONDEWO_VTSI_IVR_MAX_MENUS_PER_PROJECT&lt;/code&gt;;
     * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.IvrMenusOuterClass.IvrMenu> createIvrMenu(
        ondewo.vtsi.IvrMenusOuterClass.CreateIvrMenuRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIvrMenuMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns an IVR menu at its current revision.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.IvrMenusOuterClass.IvrMenu> getIvrMenu(
        ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIvrMenuMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt; and saves a new DRAFT revision (+1) when a graph field
     * changed. &lt;code&gt;layout&lt;/code&gt; alone is saved without a new revision.&lt;/p&gt;
     * &lt;p&gt;Errors: as &lt;code&gt;CreateIvrMenu&lt;/code&gt;, plus &lt;code&gt;ABORTED&lt;/code&gt; &lt;code&gt;reason=revision-mismatch&lt;/code&gt; when
     * &lt;code&gt;expected_revision&lt;/code&gt; is set and not the current revision.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.IvrMenusOuterClass.IvrMenu> updateIvrMenu(
        ondewo.vtsi.IvrMenusOuterClass.UpdateIvrMenuRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateIvrMenuMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes an IVR menu and all its revisions; its bound phone numbers fall back to the project&amp;apos;s routing
     * without a menu at once.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=menu-published&lt;/code&gt; for a PUBLISHED menu with bound
     * phone numbers unless &lt;code&gt;force&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=menu-referenced&lt;/code&gt;
     * while a GOTO_MENU node of another menu names it; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown menu.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuResponse> deleteIvrMenu(
        ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIvrMenuMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the IVR menus of a project.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusResponse> listIvrMenus(
        ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIvrMenusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Runs every check of Create, Update and Publish on the given draft and returns ALL issues with their node
     * paths. Writes nothing and emits nothing.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuResponse> validateIvrMenu(
        ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateIvrMenuMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Renders the given (or the current) revision into the project&amp;apos;s Asterisk: prompts synthesized or copied,
     * the dialplan reloaded and read back, every prompt checked, and only then the bound phone numbers switched to
     * it. Any failure restores the previous dialplan, leaves the previous published revision live and answers the
     * menu with &lt;code&gt;IVR_MENU_STATE_PUBLISH_FAILED&lt;/code&gt; and &lt;code&gt;state_message&lt;/code&gt;. Re-validates first,
     * because the allowlist, the softphone accounts or the listeners may have changed since the save. Binding or
     * unbinding a phone number ends no call.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an error issue; &lt;code&gt;ABORTED&lt;/code&gt;
     * &lt;code&gt;reason=revision-mismatch&lt;/code&gt; for a revision that is not current; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;
     * &lt;code&gt;reason=asterisk-not-local&lt;/code&gt;, &lt;code&gt;reason=project-not-deployed&lt;/code&gt; or
     * &lt;code&gt;reason=ivr-entry-hook-missing&lt;/code&gt; (a project whose own dialplan lacks the IVR entry hook);
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=target-menu-not-published&lt;/code&gt; when a GOTO_MENU node names a
     * menu that is not published.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.IvrMenusOuterClass.IvrMenu> publishIvrMenu(
        ondewo.vtsi.IvrMenusOuterClass.PublishIvrMenuRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPublishIvrMenuMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Copies a menu (its current or a given revision) into a new DRAFT menu without phone numbers.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.IvrMenusOuterClass.IvrMenu> cloneIvrMenu(
        ondewo.vtsi.IvrMenusOuterClass.CloneIvrMenuRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCloneIvrMenuMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the saved revisions of a menu, newest first.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsResponse> listIvrMenuRevisions(
        ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIvrMenuRevisionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts a test call through the PUBLISHED revision of a menu and returns at once with the test in
     * &lt;code&gt;IVR_MENU_TEST_STATE_RUNNING&lt;/code&gt;; poll &lt;code&gt;GetIvrMenuTest&lt;/code&gt; for the result. The test call runs
     * INSIDE the project&amp;apos;s Asterisk: a local channel enters the menu, presses the scripted keys and records the
     * nodes it passes. No SIP container, no bot and no NLU session take part, and every ROUTE node is a stub that
     * records the target and hangs up: a test NEVER dials a listener, a softphone or a phone number.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=menu-not-published&lt;/code&gt;,
     * &lt;code&gt;reason=asterisk-not-local&lt;/code&gt; or &lt;code&gt;reason=project-not-deployed&lt;/code&gt;;
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for invalid steps or a &lt;code&gt;max_duration_s&lt;/code&gt; above
     * &lt;code&gt;ONDEWO_VTSI_IVR_TEST_MAX_DURATION_S&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest> testIvrMenu(
        ondewo.vtsi.IvrMenusOuterClass.TestIvrMenuRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIvrMenuMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a test started by &lt;code&gt;TestIvrMenu&lt;/code&gt;: its state and the path traversed so far. A test is kept
     * for 24 hours after it finished, then &lt;code&gt;NOT_FOUND&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest> getIvrMenuTest(
        ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuTestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIvrMenuTestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns the rendered dialplan of one revision, read-only, for support.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; &lt;code&gt;reason=revision-not-rendered&lt;/code&gt; for a revision that is no
     * longer (or was never) in the project&amp;apos;s Asterisk.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanResponse> getIvrMenuDialplan(
        ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIvrMenuDialplanMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_IVR_MENU = 0;
  private static final int METHODID_GET_IVR_MENU = 1;
  private static final int METHODID_UPDATE_IVR_MENU = 2;
  private static final int METHODID_DELETE_IVR_MENU = 3;
  private static final int METHODID_LIST_IVR_MENUS = 4;
  private static final int METHODID_VALIDATE_IVR_MENU = 5;
  private static final int METHODID_PUBLISH_IVR_MENU = 6;
  private static final int METHODID_CLONE_IVR_MENU = 7;
  private static final int METHODID_LIST_IVR_MENU_REVISIONS = 8;
  private static final int METHODID_TEST_IVR_MENU = 9;
  private static final int METHODID_GET_IVR_MENU_TEST = 10;
  private static final int METHODID_GET_IVR_MENU_DIALPLAN = 11;

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
        case METHODID_CREATE_IVR_MENU:
          serviceImpl.createIvrMenu((ondewo.vtsi.IvrMenusOuterClass.CreateIvrMenuRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenu>) responseObserver);
          break;
        case METHODID_GET_IVR_MENU:
          serviceImpl.getIvrMenu((ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenu>) responseObserver);
          break;
        case METHODID_UPDATE_IVR_MENU:
          serviceImpl.updateIvrMenu((ondewo.vtsi.IvrMenusOuterClass.UpdateIvrMenuRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenu>) responseObserver);
          break;
        case METHODID_DELETE_IVR_MENU:
          serviceImpl.deleteIvrMenu((ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuResponse>) responseObserver);
          break;
        case METHODID_LIST_IVR_MENUS:
          serviceImpl.listIvrMenus((ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_IVR_MENU:
          serviceImpl.validateIvrMenu((ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuResponse>) responseObserver);
          break;
        case METHODID_PUBLISH_IVR_MENU:
          serviceImpl.publishIvrMenu((ondewo.vtsi.IvrMenusOuterClass.PublishIvrMenuRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenu>) responseObserver);
          break;
        case METHODID_CLONE_IVR_MENU:
          serviceImpl.cloneIvrMenu((ondewo.vtsi.IvrMenusOuterClass.CloneIvrMenuRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenu>) responseObserver);
          break;
        case METHODID_LIST_IVR_MENU_REVISIONS:
          serviceImpl.listIvrMenuRevisions((ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsResponse>) responseObserver);
          break;
        case METHODID_TEST_IVR_MENU:
          serviceImpl.testIvrMenu((ondewo.vtsi.IvrMenusOuterClass.TestIvrMenuRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest>) responseObserver);
          break;
        case METHODID_GET_IVR_MENU_TEST:
          serviceImpl.getIvrMenuTest((ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuTestRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest>) responseObserver);
          break;
        case METHODID_GET_IVR_MENU_DIALPLAN:
          serviceImpl.getIvrMenuDialplan((ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanResponse>) responseObserver);
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
          getCreateIvrMenuMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.IvrMenusOuterClass.CreateIvrMenuRequest,
              ondewo.vtsi.IvrMenusOuterClass.IvrMenu>(
                service, METHODID_CREATE_IVR_MENU)))
        .addMethod(
          getGetIvrMenuMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuRequest,
              ondewo.vtsi.IvrMenusOuterClass.IvrMenu>(
                service, METHODID_GET_IVR_MENU)))
        .addMethod(
          getUpdateIvrMenuMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.IvrMenusOuterClass.UpdateIvrMenuRequest,
              ondewo.vtsi.IvrMenusOuterClass.IvrMenu>(
                service, METHODID_UPDATE_IVR_MENU)))
        .addMethod(
          getDeleteIvrMenuMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuRequest,
              ondewo.vtsi.IvrMenusOuterClass.DeleteIvrMenuResponse>(
                service, METHODID_DELETE_IVR_MENU)))
        .addMethod(
          getListIvrMenusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusRequest,
              ondewo.vtsi.IvrMenusOuterClass.ListIvrMenusResponse>(
                service, METHODID_LIST_IVR_MENUS)))
        .addMethod(
          getValidateIvrMenuMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuRequest,
              ondewo.vtsi.IvrMenusOuterClass.ValidateIvrMenuResponse>(
                service, METHODID_VALIDATE_IVR_MENU)))
        .addMethod(
          getPublishIvrMenuMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.IvrMenusOuterClass.PublishIvrMenuRequest,
              ondewo.vtsi.IvrMenusOuterClass.IvrMenu>(
                service, METHODID_PUBLISH_IVR_MENU)))
        .addMethod(
          getCloneIvrMenuMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.IvrMenusOuterClass.CloneIvrMenuRequest,
              ondewo.vtsi.IvrMenusOuterClass.IvrMenu>(
                service, METHODID_CLONE_IVR_MENU)))
        .addMethod(
          getListIvrMenuRevisionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsRequest,
              ondewo.vtsi.IvrMenusOuterClass.ListIvrMenuRevisionsResponse>(
                service, METHODID_LIST_IVR_MENU_REVISIONS)))
        .addMethod(
          getTestIvrMenuMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.IvrMenusOuterClass.TestIvrMenuRequest,
              ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest>(
                service, METHODID_TEST_IVR_MENU)))
        .addMethod(
          getGetIvrMenuTestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuTestRequest,
              ondewo.vtsi.IvrMenusOuterClass.IvrMenuTest>(
                service, METHODID_GET_IVR_MENU_TEST)))
        .addMethod(
          getGetIvrMenuDialplanMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanRequest,
              ondewo.vtsi.IvrMenusOuterClass.GetIvrMenuDialplanResponse>(
                service, METHODID_GET_IVR_MENU_DIALPLAN)))
        .build();
  }

  private static abstract class IvrMenusBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IvrMenusBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ondewo.vtsi.IvrMenusOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IvrMenus");
    }
  }

  private static final class IvrMenusFileDescriptorSupplier
      extends IvrMenusBaseDescriptorSupplier {
    IvrMenusFileDescriptorSupplier() {}
  }

  private static final class IvrMenusMethodDescriptorSupplier
      extends IvrMenusBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    IvrMenusMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (IvrMenusGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IvrMenusFileDescriptorSupplier())
              .addMethod(getCreateIvrMenuMethod())
              .addMethod(getGetIvrMenuMethod())
              .addMethod(getUpdateIvrMenuMethod())
              .addMethod(getDeleteIvrMenuMethod())
              .addMethod(getListIvrMenusMethod())
              .addMethod(getValidateIvrMenuMethod())
              .addMethod(getPublishIvrMenuMethod())
              .addMethod(getCloneIvrMenuMethod())
              .addMethod(getListIvrMenuRevisionsMethod())
              .addMethod(getTestIvrMenuMethod())
              .addMethod(getGetIvrMenuTestMethod())
              .addMethod(getGetIvrMenuDialplanMethod())
              .build();
        }
      }
    }
    return result;
  }
}
