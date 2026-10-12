package ondewo.vtsi;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
 * &lt;p&gt;Manages the CAMPAIGNS of a VTSI project. A campaign is a named set of outbound calls that VTSI
 * places for the client while keeping at most &lt;code&gt;max_parallel_calls&lt;/code&gt; of them running at
 * the same time. If 100 callers are added to a campaign with &lt;code&gt;max_parallel_calls = 10&lt;/code&gt;,
 * at any moment at most 10 of those calls are being set up or are connected; the next one starts
 * when one ends.&lt;/p&gt;
 * &lt;p&gt;Calls are added to a campaign with
 * &lt;a href="index.html#ondewo.vtsi.Calls.AddCallersToCampaign"&gt;Calls.AddCallersToCampaign&lt;/a&gt; or
 * &lt;a href="index.html#ondewo.vtsi.Calls.AddScheduledCallersToCampaign"&gt;Calls.AddScheduledCallersToCampaign&lt;/a&gt;
 * (a server that predates them answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; and starts nothing); a scheduled call of a campaign is started at or after its scheduled time AND when the campaign has
 * a free slot.&lt;/p&gt;
 * &lt;p&gt;A call that fails is retried up to &lt;code&gt;max_attempts&lt;/code&gt; times in total, waiting
 * &lt;code&gt;retry_delay&lt;/code&gt; between attempts. A call counts as failed only after its last attempt.
 * A failure that cannot succeed by repetition (for example a rejected credential, an invalid
 * configuration) is never retried.&lt;/p&gt;
 * &lt;p&gt;Lifecycle: &lt;code&gt;StartCampaign&lt;/code&gt; starts a created campaign; &lt;code&gt;StopCampaign&lt;/code&gt; lets
 * the ongoing calls finish and starts no new ones; &lt;code&gt;HardStopCampaign&lt;/code&gt; ends the ongoing
 * calls immediately and starts no new ones; &lt;code&gt;ResumeCampaign&lt;/code&gt; continues a stopped or hard
 * stopped campaign with the calls that have not finished yet.&lt;/p&gt;
 * &lt;p&gt;Every RPC about ONE campaign accepts either its resource name or its display name. Display names
 * are unique within a project, so a display name is resolved within the project named by the
 * request&amp;apos;s top-level &lt;code&gt;vtsi_project_name&lt;/code&gt;, which is REQUIRED with a display name
 * (&lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; when it is empty or malformed) and checked against the campaign
 * when a resource name is used. (The &lt;code&gt;CampaignDisplayName&lt;/code&gt; message of 9.0.0, which
 * carried the project and the display name together, was removed in 9.1.0; its field numbers are
 * &lt;code&gt;reserved&lt;/code&gt;.)&lt;/p&gt;
 * &lt;p&gt;A malformed selector is &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for every authenticated caller, with or
 * without authorization enforced (also when authorization could resolve no project from it): neither
 * the resource name nor the display name set (also how an old 9.0.0 client&amp;apos;s removed
 * &lt;code&gt;CampaignDisplayName&lt;/code&gt; arrives), a malformed resource name, a display name with an empty
 * or malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, and a &lt;code&gt;vtsi_project_name&lt;/code&gt; that is not the
 * project of the resource name. With authorization enforced, a well-formed request naming a project
 * the caller holds no role on (an unknown project included) is refused with
 * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; before any lookup, so it is not answered &lt;code&gt;NOT_FOUND&lt;/code&gt;, and
 * a caller without a credential is &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; whatever it sent.&lt;/p&gt;
 * &lt;p&gt;Campaign-level call defaults: &lt;code&gt;campaign_common_services_config&lt;/code&gt; and
 * &lt;code&gt;campaign_sip_caller_config&lt;/code&gt; of a &lt;code&gt;Campaign&lt;/code&gt; are the defaults of EVERY call of
 * the campaign. They are read LIVE when a campaign call is dispatched (every attempt, retries
 * included): the effective configuration of the call is a copy of the campaign&amp;apos;s config with the
 * call&amp;apos;s own &lt;code&gt;StartCallerRequest&lt;/code&gt; config merged over it (protobuf
 * &lt;code&gt;MergeFrom&lt;/code&gt;), see &lt;a href="index.html#ondewo.vtsi.Campaign"&gt;Campaign&lt;/a&gt;. The one exception
 * is the callee: &lt;code&gt;campaign_sip_caller_config.callee_id&lt;/code&gt; is resolved and FIXED when a call is
 * added (it is that call&amp;apos;s &lt;code&gt;CampaignCall.phone_number&lt;/code&gt;), so every attempt of a call dials the
 * number its campaign call reports.&lt;/p&gt;
 * &lt;p&gt;Partial responses: &lt;code&gt;ListCampaigns&lt;/code&gt;, &lt;code&gt;ListCampaignCalls&lt;/code&gt;,
 * &lt;code&gt;CreateCampaign&lt;/code&gt;, &lt;code&gt;GetCampaign&lt;/code&gt;, &lt;code&gt;UpdateCampaign&lt;/code&gt;,
 * &lt;code&gt;DeleteCampaign&lt;/code&gt; (paths of &lt;code&gt;DeleteCampaignResponse&lt;/code&gt;), the four lifecycle RPCs
 * &lt;code&gt;StartCampaign&lt;/code&gt;, &lt;code&gt;StopCampaign&lt;/code&gt;, &lt;code&gt;HardStopCampaign&lt;/code&gt; and
 * &lt;code&gt;ResumeCampaign&lt;/code&gt;, &lt;code&gt;CloneCampaign&lt;/code&gt; and &lt;code&gt;GetCampaignCall&lt;/code&gt; accept an optional
 * &lt;code&gt;field_mask&lt;/code&gt; naming the field paths of the returned resource (for a listing: of each listed
 * element) to populate. A mask never changes what the RPC does. Unset or empty returns every
 * field (one exception: &lt;code&gt;ListCampaigns&lt;/code&gt; returns &lt;code&gt;campaign_callers&lt;/code&gt; and
 * &lt;code&gt;campaign_callers_truncated&lt;/code&gt; only when its mask names them); the identifying &lt;code&gt;name&lt;/code&gt; is always populated; an unknown path is rejected with
 * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; naming it; nested paths through singular message fields (e.g.
 * &lt;code&gt;statistics.completed&lt;/code&gt;) are allowed, a path below a repeated or map field is not. The
 * mask is applied after any role-based redaction, so it can only narrow what the caller may see.&lt;/p&gt;
 * &lt;p&gt;Callers and calls of a campaign: &lt;code&gt;Campaign.campaign_callers&lt;/code&gt; names the callers that placed
 * its calls (bounded); &lt;code&gt;Calls.ListCallers&lt;/code&gt; with &lt;code&gt;ListCallersRequest.campaign_name&lt;/code&gt; /
 * &lt;code&gt;campaign_display_name&lt;/code&gt; lists them paginated as &lt;code&gt;Caller&lt;/code&gt; resources, and
 * &lt;code&gt;Calls.ListCalls&lt;/code&gt; with &lt;code&gt;CallFilter.campaign_name&lt;/code&gt; /
 * &lt;code&gt;campaign_display_name&lt;/code&gt; lists the calls they placed as &lt;code&gt;Call&lt;/code&gt; resources.&lt;/p&gt;
 * &lt;p&gt;Calling window: a campaign with a &lt;code&gt;calling_window&lt;/code&gt; starts calls (first attempts, retries and
 * due scheduled calls alike) only inside one of the window&amp;apos;s weekly slots, in the window&amp;apos;s time zone.
 * Outside every slot it stays &lt;code&gt;RUNNING&lt;/code&gt; and reports &lt;code&gt;outside_calling_window = true&lt;/code&gt;; calls
 * already running are never ended by a slot ending. See
 * &lt;a href="index.html#ondewo.vtsi.CampaignCallingWindow"&gt;CampaignCallingWindow&lt;/a&gt;.&lt;/p&gt;
 * &lt;p&gt;Limits and defaults of the server (environment variables of ondewo-vtsi, read at start-up): at most
 * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_CALLS&lt;/code&gt; (100000) calls per campaign; &lt;code&gt;max_parallel_calls&lt;/code&gt;
 * defaults to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_DEFAULT_MAX_PARALLEL_CALLS&lt;/code&gt; (1) and is at most
 * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_PARALLEL_CALLS_LIMIT&lt;/code&gt; (1000); &lt;code&gt;max_attempts&lt;/code&gt; defaults to 1
 * and is at most &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_ATTEMPTS_LIMIT&lt;/code&gt; (10); &lt;code&gt;retry_delay&lt;/code&gt; defaults
 * to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_DEFAULT_RETRY_DELAY_S&lt;/code&gt; (60 s); one &lt;code&gt;AddCallersToCampaign&lt;/code&gt; /
 * &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; request carries at most 1000 entries (a fixed server limit,
 * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; above it); &lt;code&gt;CancelCampaignCalls&lt;/code&gt; and &lt;code&gt;RetryCampaignCalls&lt;/code&gt;
 * act on at most 1000 calls per request. The status stream is bounded by
 * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_DURATION_S&lt;/code&gt; (3600 s), sends a keep-alive after
 * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_KEEPALIVE_S&lt;/code&gt; (15 s) without a change and at most
 * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_CONCURRENT&lt;/code&gt; (16) status streams are open per server replica.&lt;/p&gt;
 * &lt;p&gt;Authorization (when enforced): every RPC of this service needs &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or a
 * higher role (&lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt;, &lt;code&gt;PROJECT_ADMIN&lt;/code&gt;) on the campaign&amp;apos;s project, or
 * &lt;code&gt;SERVER_ADMIN&lt;/code&gt;; credential-bearing call defaults are returned only to the roles named at
 * &lt;code&gt;Campaign.campaign_common_services_config&lt;/code&gt;.&lt;/p&gt;
 * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
 * filter, field mask or value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign
 * call (with authorization enforced: &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; for a project the caller holds
 * no role on, or a role below &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;); &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; for a request
 * without a valid credential while authorization is enforced; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a
 * &lt;code&gt;display_name&lt;/code&gt; already used in the project;
 * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a state that does not allow the operation (each RPC names its
 * cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change won, nothing was stored and the request can
 * be retried; &lt;code&gt;DEADLINE_EXCEEDED&lt;/code&gt; for a forced &lt;code&gt;DeleteCampaign&lt;/code&gt; whose hang-ups were not
 * confirmed in time (the hard stop stays in effect, retry the request); &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when
 * the server has no free stream slot.&lt;/p&gt;
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class CampaignsGrpc {

  private CampaignsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ondewo.vtsi.Campaigns";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.Campaign> getCreateCampaignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCampaign",
      requestType = ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest.class,
      responseType = ondewo.vtsi.CampaignsOuterClass.Campaign.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.Campaign> getCreateCampaignMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest, ondewo.vtsi.CampaignsOuterClass.Campaign> getCreateCampaignMethod;
    if ((getCreateCampaignMethod = CampaignsGrpc.getCreateCampaignMethod) == null) {
      synchronized (CampaignsGrpc.class) {
        if ((getCreateCampaignMethod = CampaignsGrpc.getCreateCampaignMethod) == null) {
          CampaignsGrpc.getCreateCampaignMethod = getCreateCampaignMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest, ondewo.vtsi.CampaignsOuterClass.Campaign>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCampaign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.Campaign.getDefaultInstance()))
              .setSchemaDescriptor(new CampaignsMethodDescriptorSupplier("CreateCampaign"))
              .build();
        }
      }
    }
    return getCreateCampaignMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.GetCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.Campaign> getGetCampaignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCampaign",
      requestType = ondewo.vtsi.CampaignsOuterClass.GetCampaignRequest.class,
      responseType = ondewo.vtsi.CampaignsOuterClass.Campaign.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.GetCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.Campaign> getGetCampaignMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.GetCampaignRequest, ondewo.vtsi.CampaignsOuterClass.Campaign> getGetCampaignMethod;
    if ((getGetCampaignMethod = CampaignsGrpc.getGetCampaignMethod) == null) {
      synchronized (CampaignsGrpc.class) {
        if ((getGetCampaignMethod = CampaignsGrpc.getGetCampaignMethod) == null) {
          CampaignsGrpc.getGetCampaignMethod = getGetCampaignMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CampaignsOuterClass.GetCampaignRequest, ondewo.vtsi.CampaignsOuterClass.Campaign>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCampaign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.GetCampaignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.Campaign.getDefaultInstance()))
              .setSchemaDescriptor(new CampaignsMethodDescriptorSupplier("GetCampaign"))
              .build();
        }
      }
    }
    return getGetCampaignMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.UpdateCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.Campaign> getUpdateCampaignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCampaign",
      requestType = ondewo.vtsi.CampaignsOuterClass.UpdateCampaignRequest.class,
      responseType = ondewo.vtsi.CampaignsOuterClass.Campaign.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.UpdateCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.Campaign> getUpdateCampaignMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.UpdateCampaignRequest, ondewo.vtsi.CampaignsOuterClass.Campaign> getUpdateCampaignMethod;
    if ((getUpdateCampaignMethod = CampaignsGrpc.getUpdateCampaignMethod) == null) {
      synchronized (CampaignsGrpc.class) {
        if ((getUpdateCampaignMethod = CampaignsGrpc.getUpdateCampaignMethod) == null) {
          CampaignsGrpc.getUpdateCampaignMethod = getUpdateCampaignMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CampaignsOuterClass.UpdateCampaignRequest, ondewo.vtsi.CampaignsOuterClass.Campaign>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCampaign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.UpdateCampaignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.Campaign.getDefaultInstance()))
              .setSchemaDescriptor(new CampaignsMethodDescriptorSupplier("UpdateCampaign"))
              .build();
        }
      }
    }
    return getUpdateCampaignMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse> getDeleteCampaignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCampaign",
      requestType = ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest.class,
      responseType = ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse> getDeleteCampaignMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest, ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse> getDeleteCampaignMethod;
    if ((getDeleteCampaignMethod = CampaignsGrpc.getDeleteCampaignMethod) == null) {
      synchronized (CampaignsGrpc.class) {
        if ((getDeleteCampaignMethod = CampaignsGrpc.getDeleteCampaignMethod) == null) {
          CampaignsGrpc.getDeleteCampaignMethod = getDeleteCampaignMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest, ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCampaign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CampaignsMethodDescriptorSupplier("DeleteCampaign"))
              .build();
        }
      }
    }
    return getDeleteCampaignMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.ListCampaignsRequest,
      ondewo.vtsi.CampaignsOuterClass.ListCampaignsResponse> getListCampaignsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCampaigns",
      requestType = ondewo.vtsi.CampaignsOuterClass.ListCampaignsRequest.class,
      responseType = ondewo.vtsi.CampaignsOuterClass.ListCampaignsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.ListCampaignsRequest,
      ondewo.vtsi.CampaignsOuterClass.ListCampaignsResponse> getListCampaignsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.ListCampaignsRequest, ondewo.vtsi.CampaignsOuterClass.ListCampaignsResponse> getListCampaignsMethod;
    if ((getListCampaignsMethod = CampaignsGrpc.getListCampaignsMethod) == null) {
      synchronized (CampaignsGrpc.class) {
        if ((getListCampaignsMethod = CampaignsGrpc.getListCampaignsMethod) == null) {
          CampaignsGrpc.getListCampaignsMethod = getListCampaignsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CampaignsOuterClass.ListCampaignsRequest, ondewo.vtsi.CampaignsOuterClass.ListCampaignsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCampaigns"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.ListCampaignsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.ListCampaignsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CampaignsMethodDescriptorSupplier("ListCampaigns"))
              .build();
        }
      }
    }
    return getListCampaignsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.GetCampaignStatisticsRequest,
      ondewo.vtsi.CampaignsOuterClass.CampaignStatistics> getGetCampaignStatisticsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCampaignStatistics",
      requestType = ondewo.vtsi.CampaignsOuterClass.GetCampaignStatisticsRequest.class,
      responseType = ondewo.vtsi.CampaignsOuterClass.CampaignStatistics.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.GetCampaignStatisticsRequest,
      ondewo.vtsi.CampaignsOuterClass.CampaignStatistics> getGetCampaignStatisticsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.GetCampaignStatisticsRequest, ondewo.vtsi.CampaignsOuterClass.CampaignStatistics> getGetCampaignStatisticsMethod;
    if ((getGetCampaignStatisticsMethod = CampaignsGrpc.getGetCampaignStatisticsMethod) == null) {
      synchronized (CampaignsGrpc.class) {
        if ((getGetCampaignStatisticsMethod = CampaignsGrpc.getGetCampaignStatisticsMethod) == null) {
          CampaignsGrpc.getGetCampaignStatisticsMethod = getGetCampaignStatisticsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CampaignsOuterClass.GetCampaignStatisticsRequest, ondewo.vtsi.CampaignsOuterClass.CampaignStatistics>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCampaignStatistics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.GetCampaignStatisticsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.CampaignStatistics.getDefaultInstance()))
              .setSchemaDescriptor(new CampaignsMethodDescriptorSupplier("GetCampaignStatistics"))
              .build();
        }
      }
    }
    return getGetCampaignStatisticsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsRequest,
      ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsResponse> getListCampaignCallsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCampaignCalls",
      requestType = ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsRequest.class,
      responseType = ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsRequest,
      ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsResponse> getListCampaignCallsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsRequest, ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsResponse> getListCampaignCallsMethod;
    if ((getListCampaignCallsMethod = CampaignsGrpc.getListCampaignCallsMethod) == null) {
      synchronized (CampaignsGrpc.class) {
        if ((getListCampaignCallsMethod = CampaignsGrpc.getListCampaignCallsMethod) == null) {
          CampaignsGrpc.getListCampaignCallsMethod = getListCampaignCallsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsRequest, ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCampaignCalls"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CampaignsMethodDescriptorSupplier("ListCampaignCalls"))
              .build();
        }
      }
    }
    return getListCampaignCallsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.StartCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.Campaign> getStartCampaignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartCampaign",
      requestType = ondewo.vtsi.CampaignsOuterClass.StartCampaignRequest.class,
      responseType = ondewo.vtsi.CampaignsOuterClass.Campaign.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.StartCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.Campaign> getStartCampaignMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.StartCampaignRequest, ondewo.vtsi.CampaignsOuterClass.Campaign> getStartCampaignMethod;
    if ((getStartCampaignMethod = CampaignsGrpc.getStartCampaignMethod) == null) {
      synchronized (CampaignsGrpc.class) {
        if ((getStartCampaignMethod = CampaignsGrpc.getStartCampaignMethod) == null) {
          CampaignsGrpc.getStartCampaignMethod = getStartCampaignMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CampaignsOuterClass.StartCampaignRequest, ondewo.vtsi.CampaignsOuterClass.Campaign>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartCampaign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.StartCampaignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.Campaign.getDefaultInstance()))
              .setSchemaDescriptor(new CampaignsMethodDescriptorSupplier("StartCampaign"))
              .build();
        }
      }
    }
    return getStartCampaignMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.StopCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.Campaign> getStopCampaignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopCampaign",
      requestType = ondewo.vtsi.CampaignsOuterClass.StopCampaignRequest.class,
      responseType = ondewo.vtsi.CampaignsOuterClass.Campaign.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.StopCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.Campaign> getStopCampaignMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.StopCampaignRequest, ondewo.vtsi.CampaignsOuterClass.Campaign> getStopCampaignMethod;
    if ((getStopCampaignMethod = CampaignsGrpc.getStopCampaignMethod) == null) {
      synchronized (CampaignsGrpc.class) {
        if ((getStopCampaignMethod = CampaignsGrpc.getStopCampaignMethod) == null) {
          CampaignsGrpc.getStopCampaignMethod = getStopCampaignMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CampaignsOuterClass.StopCampaignRequest, ondewo.vtsi.CampaignsOuterClass.Campaign>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopCampaign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.StopCampaignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.Campaign.getDefaultInstance()))
              .setSchemaDescriptor(new CampaignsMethodDescriptorSupplier("StopCampaign"))
              .build();
        }
      }
    }
    return getStopCampaignMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.HardStopCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.Campaign> getHardStopCampaignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HardStopCampaign",
      requestType = ondewo.vtsi.CampaignsOuterClass.HardStopCampaignRequest.class,
      responseType = ondewo.vtsi.CampaignsOuterClass.Campaign.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.HardStopCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.Campaign> getHardStopCampaignMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.HardStopCampaignRequest, ondewo.vtsi.CampaignsOuterClass.Campaign> getHardStopCampaignMethod;
    if ((getHardStopCampaignMethod = CampaignsGrpc.getHardStopCampaignMethod) == null) {
      synchronized (CampaignsGrpc.class) {
        if ((getHardStopCampaignMethod = CampaignsGrpc.getHardStopCampaignMethod) == null) {
          CampaignsGrpc.getHardStopCampaignMethod = getHardStopCampaignMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CampaignsOuterClass.HardStopCampaignRequest, ondewo.vtsi.CampaignsOuterClass.Campaign>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HardStopCampaign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.HardStopCampaignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.Campaign.getDefaultInstance()))
              .setSchemaDescriptor(new CampaignsMethodDescriptorSupplier("HardStopCampaign"))
              .build();
        }
      }
    }
    return getHardStopCampaignMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.ResumeCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.Campaign> getResumeCampaignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResumeCampaign",
      requestType = ondewo.vtsi.CampaignsOuterClass.ResumeCampaignRequest.class,
      responseType = ondewo.vtsi.CampaignsOuterClass.Campaign.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.ResumeCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.Campaign> getResumeCampaignMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.ResumeCampaignRequest, ondewo.vtsi.CampaignsOuterClass.Campaign> getResumeCampaignMethod;
    if ((getResumeCampaignMethod = CampaignsGrpc.getResumeCampaignMethod) == null) {
      synchronized (CampaignsGrpc.class) {
        if ((getResumeCampaignMethod = CampaignsGrpc.getResumeCampaignMethod) == null) {
          CampaignsGrpc.getResumeCampaignMethod = getResumeCampaignMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CampaignsOuterClass.ResumeCampaignRequest, ondewo.vtsi.CampaignsOuterClass.Campaign>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResumeCampaign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.ResumeCampaignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.Campaign.getDefaultInstance()))
              .setSchemaDescriptor(new CampaignsMethodDescriptorSupplier("ResumeCampaign"))
              .build();
        }
      }
    }
    return getResumeCampaignMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusRequest,
      ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusResponse> getStreamCampaignStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamCampaignStatus",
      requestType = ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusRequest.class,
      responseType = ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusRequest,
      ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusResponse> getStreamCampaignStatusMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusRequest, ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusResponse> getStreamCampaignStatusMethod;
    if ((getStreamCampaignStatusMethod = CampaignsGrpc.getStreamCampaignStatusMethod) == null) {
      synchronized (CampaignsGrpc.class) {
        if ((getStreamCampaignStatusMethod = CampaignsGrpc.getStreamCampaignStatusMethod) == null) {
          CampaignsGrpc.getStreamCampaignStatusMethod = getStreamCampaignStatusMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusRequest, ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamCampaignStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CampaignsMethodDescriptorSupplier("StreamCampaignStatus"))
              .build();
        }
      }
    }
    return getStreamCampaignStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.GetCampaignCallRequest,
      ondewo.vtsi.CampaignsOuterClass.CampaignCall> getGetCampaignCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCampaignCall",
      requestType = ondewo.vtsi.CampaignsOuterClass.GetCampaignCallRequest.class,
      responseType = ondewo.vtsi.CampaignsOuterClass.CampaignCall.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.GetCampaignCallRequest,
      ondewo.vtsi.CampaignsOuterClass.CampaignCall> getGetCampaignCallMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.GetCampaignCallRequest, ondewo.vtsi.CampaignsOuterClass.CampaignCall> getGetCampaignCallMethod;
    if ((getGetCampaignCallMethod = CampaignsGrpc.getGetCampaignCallMethod) == null) {
      synchronized (CampaignsGrpc.class) {
        if ((getGetCampaignCallMethod = CampaignsGrpc.getGetCampaignCallMethod) == null) {
          CampaignsGrpc.getGetCampaignCallMethod = getGetCampaignCallMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CampaignsOuterClass.GetCampaignCallRequest, ondewo.vtsi.CampaignsOuterClass.CampaignCall>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCampaignCall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.GetCampaignCallRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.CampaignCall.getDefaultInstance()))
              .setSchemaDescriptor(new CampaignsMethodDescriptorSupplier("GetCampaignCall"))
              .build();
        }
      }
    }
    return getGetCampaignCallMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsRequest,
      ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsResponse> getCancelCampaignCallsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelCampaignCalls",
      requestType = ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsRequest.class,
      responseType = ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsRequest,
      ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsResponse> getCancelCampaignCallsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsRequest, ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsResponse> getCancelCampaignCallsMethod;
    if ((getCancelCampaignCallsMethod = CampaignsGrpc.getCancelCampaignCallsMethod) == null) {
      synchronized (CampaignsGrpc.class) {
        if ((getCancelCampaignCallsMethod = CampaignsGrpc.getCancelCampaignCallsMethod) == null) {
          CampaignsGrpc.getCancelCampaignCallsMethod = getCancelCampaignCallsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsRequest, ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelCampaignCalls"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CampaignsMethodDescriptorSupplier("CancelCampaignCalls"))
              .build();
        }
      }
    }
    return getCancelCampaignCallsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsRequest,
      ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsResponse> getRetryCampaignCallsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetryCampaignCalls",
      requestType = ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsRequest.class,
      responseType = ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsRequest,
      ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsResponse> getRetryCampaignCallsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsRequest, ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsResponse> getRetryCampaignCallsMethod;
    if ((getRetryCampaignCallsMethod = CampaignsGrpc.getRetryCampaignCallsMethod) == null) {
      synchronized (CampaignsGrpc.class) {
        if ((getRetryCampaignCallsMethod = CampaignsGrpc.getRetryCampaignCallsMethod) == null) {
          CampaignsGrpc.getRetryCampaignCallsMethod = getRetryCampaignCallsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsRequest, ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RetryCampaignCalls"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CampaignsMethodDescriptorSupplier("RetryCampaignCalls"))
              .build();
        }
      }
    }
    return getRetryCampaignCallsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.CloneCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.Campaign> getCloneCampaignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CloneCampaign",
      requestType = ondewo.vtsi.CampaignsOuterClass.CloneCampaignRequest.class,
      responseType = ondewo.vtsi.CampaignsOuterClass.Campaign.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.CloneCampaignRequest,
      ondewo.vtsi.CampaignsOuterClass.Campaign> getCloneCampaignMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.CampaignsOuterClass.CloneCampaignRequest, ondewo.vtsi.CampaignsOuterClass.Campaign> getCloneCampaignMethod;
    if ((getCloneCampaignMethod = CampaignsGrpc.getCloneCampaignMethod) == null) {
      synchronized (CampaignsGrpc.class) {
        if ((getCloneCampaignMethod = CampaignsGrpc.getCloneCampaignMethod) == null) {
          CampaignsGrpc.getCloneCampaignMethod = getCloneCampaignMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.CampaignsOuterClass.CloneCampaignRequest, ondewo.vtsi.CampaignsOuterClass.Campaign>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloneCampaign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.CloneCampaignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.CampaignsOuterClass.Campaign.getDefaultInstance()))
              .setSchemaDescriptor(new CampaignsMethodDescriptorSupplier("CloneCampaign"))
              .build();
        }
      }
    }
    return getCloneCampaignMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CampaignsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CampaignsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CampaignsStub>() {
        @java.lang.Override
        public CampaignsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CampaignsStub(channel, callOptions);
        }
      };
    return CampaignsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static CampaignsBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CampaignsBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CampaignsBlockingV2Stub>() {
        @java.lang.Override
        public CampaignsBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CampaignsBlockingV2Stub(channel, callOptions);
        }
      };
    return CampaignsBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CampaignsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CampaignsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CampaignsBlockingStub>() {
        @java.lang.Override
        public CampaignsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CampaignsBlockingStub(channel, callOptions);
        }
      };
    return CampaignsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CampaignsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CampaignsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CampaignsFutureStub>() {
        @java.lang.Override
        public CampaignsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CampaignsFutureStub(channel, callOptions);
        }
      };
    return CampaignsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the CAMPAIGNS of a VTSI project. A campaign is a named set of outbound calls that VTSI
   * places for the client while keeping at most &lt;code&gt;max_parallel_calls&lt;/code&gt; of them running at
   * the same time. If 100 callers are added to a campaign with &lt;code&gt;max_parallel_calls = 10&lt;/code&gt;,
   * at any moment at most 10 of those calls are being set up or are connected; the next one starts
   * when one ends.&lt;/p&gt;
   * &lt;p&gt;Calls are added to a campaign with
   * &lt;a href="index.html#ondewo.vtsi.Calls.AddCallersToCampaign"&gt;Calls.AddCallersToCampaign&lt;/a&gt; or
   * &lt;a href="index.html#ondewo.vtsi.Calls.AddScheduledCallersToCampaign"&gt;Calls.AddScheduledCallersToCampaign&lt;/a&gt;
   * (a server that predates them answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; and starts nothing); a scheduled call of a campaign is started at or after its scheduled time AND when the campaign has
   * a free slot.&lt;/p&gt;
   * &lt;p&gt;A call that fails is retried up to &lt;code&gt;max_attempts&lt;/code&gt; times in total, waiting
   * &lt;code&gt;retry_delay&lt;/code&gt; between attempts. A call counts as failed only after its last attempt.
   * A failure that cannot succeed by repetition (for example a rejected credential, an invalid
   * configuration) is never retried.&lt;/p&gt;
   * &lt;p&gt;Lifecycle: &lt;code&gt;StartCampaign&lt;/code&gt; starts a created campaign; &lt;code&gt;StopCampaign&lt;/code&gt; lets
   * the ongoing calls finish and starts no new ones; &lt;code&gt;HardStopCampaign&lt;/code&gt; ends the ongoing
   * calls immediately and starts no new ones; &lt;code&gt;ResumeCampaign&lt;/code&gt; continues a stopped or hard
   * stopped campaign with the calls that have not finished yet.&lt;/p&gt;
   * &lt;p&gt;Every RPC about ONE campaign accepts either its resource name or its display name. Display names
   * are unique within a project, so a display name is resolved within the project named by the
   * request&amp;apos;s top-level &lt;code&gt;vtsi_project_name&lt;/code&gt;, which is REQUIRED with a display name
   * (&lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; when it is empty or malformed) and checked against the campaign
   * when a resource name is used. (The &lt;code&gt;CampaignDisplayName&lt;/code&gt; message of 9.0.0, which
   * carried the project and the display name together, was removed in 9.1.0; its field numbers are
   * &lt;code&gt;reserved&lt;/code&gt;.)&lt;/p&gt;
   * &lt;p&gt;A malformed selector is &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for every authenticated caller, with or
   * without authorization enforced (also when authorization could resolve no project from it): neither
   * the resource name nor the display name set (also how an old 9.0.0 client&amp;apos;s removed
   * &lt;code&gt;CampaignDisplayName&lt;/code&gt; arrives), a malformed resource name, a display name with an empty
   * or malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, and a &lt;code&gt;vtsi_project_name&lt;/code&gt; that is not the
   * project of the resource name. With authorization enforced, a well-formed request naming a project
   * the caller holds no role on (an unknown project included) is refused with
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; before any lookup, so it is not answered &lt;code&gt;NOT_FOUND&lt;/code&gt;, and
   * a caller without a credential is &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; whatever it sent.&lt;/p&gt;
   * &lt;p&gt;Campaign-level call defaults: &lt;code&gt;campaign_common_services_config&lt;/code&gt; and
   * &lt;code&gt;campaign_sip_caller_config&lt;/code&gt; of a &lt;code&gt;Campaign&lt;/code&gt; are the defaults of EVERY call of
   * the campaign. They are read LIVE when a campaign call is dispatched (every attempt, retries
   * included): the effective configuration of the call is a copy of the campaign&amp;apos;s config with the
   * call&amp;apos;s own &lt;code&gt;StartCallerRequest&lt;/code&gt; config merged over it (protobuf
   * &lt;code&gt;MergeFrom&lt;/code&gt;), see &lt;a href="index.html#ondewo.vtsi.Campaign"&gt;Campaign&lt;/a&gt;. The one exception
   * is the callee: &lt;code&gt;campaign_sip_caller_config.callee_id&lt;/code&gt; is resolved and FIXED when a call is
   * added (it is that call&amp;apos;s &lt;code&gt;CampaignCall.phone_number&lt;/code&gt;), so every attempt of a call dials the
   * number its campaign call reports.&lt;/p&gt;
   * &lt;p&gt;Partial responses: &lt;code&gt;ListCampaigns&lt;/code&gt;, &lt;code&gt;ListCampaignCalls&lt;/code&gt;,
   * &lt;code&gt;CreateCampaign&lt;/code&gt;, &lt;code&gt;GetCampaign&lt;/code&gt;, &lt;code&gt;UpdateCampaign&lt;/code&gt;,
   * &lt;code&gt;DeleteCampaign&lt;/code&gt; (paths of &lt;code&gt;DeleteCampaignResponse&lt;/code&gt;), the four lifecycle RPCs
   * &lt;code&gt;StartCampaign&lt;/code&gt;, &lt;code&gt;StopCampaign&lt;/code&gt;, &lt;code&gt;HardStopCampaign&lt;/code&gt; and
   * &lt;code&gt;ResumeCampaign&lt;/code&gt;, &lt;code&gt;CloneCampaign&lt;/code&gt; and &lt;code&gt;GetCampaignCall&lt;/code&gt; accept an optional
   * &lt;code&gt;field_mask&lt;/code&gt; naming the field paths of the returned resource (for a listing: of each listed
   * element) to populate. A mask never changes what the RPC does. Unset or empty returns every
   * field (one exception: &lt;code&gt;ListCampaigns&lt;/code&gt; returns &lt;code&gt;campaign_callers&lt;/code&gt; and
   * &lt;code&gt;campaign_callers_truncated&lt;/code&gt; only when its mask names them); the identifying &lt;code&gt;name&lt;/code&gt; is always populated; an unknown path is rejected with
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; naming it; nested paths through singular message fields (e.g.
   * &lt;code&gt;statistics.completed&lt;/code&gt;) are allowed, a path below a repeated or map field is not. The
   * mask is applied after any role-based redaction, so it can only narrow what the caller may see.&lt;/p&gt;
   * &lt;p&gt;Callers and calls of a campaign: &lt;code&gt;Campaign.campaign_callers&lt;/code&gt; names the callers that placed
   * its calls (bounded); &lt;code&gt;Calls.ListCallers&lt;/code&gt; with &lt;code&gt;ListCallersRequest.campaign_name&lt;/code&gt; /
   * &lt;code&gt;campaign_display_name&lt;/code&gt; lists them paginated as &lt;code&gt;Caller&lt;/code&gt; resources, and
   * &lt;code&gt;Calls.ListCalls&lt;/code&gt; with &lt;code&gt;CallFilter.campaign_name&lt;/code&gt; /
   * &lt;code&gt;campaign_display_name&lt;/code&gt; lists the calls they placed as &lt;code&gt;Call&lt;/code&gt; resources.&lt;/p&gt;
   * &lt;p&gt;Calling window: a campaign with a &lt;code&gt;calling_window&lt;/code&gt; starts calls (first attempts, retries and
   * due scheduled calls alike) only inside one of the window&amp;apos;s weekly slots, in the window&amp;apos;s time zone.
   * Outside every slot it stays &lt;code&gt;RUNNING&lt;/code&gt; and reports &lt;code&gt;outside_calling_window = true&lt;/code&gt;; calls
   * already running are never ended by a slot ending. See
   * &lt;a href="index.html#ondewo.vtsi.CampaignCallingWindow"&gt;CampaignCallingWindow&lt;/a&gt;.&lt;/p&gt;
   * &lt;p&gt;Limits and defaults of the server (environment variables of ondewo-vtsi, read at start-up): at most
   * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_CALLS&lt;/code&gt; (100000) calls per campaign; &lt;code&gt;max_parallel_calls&lt;/code&gt;
   * defaults to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_DEFAULT_MAX_PARALLEL_CALLS&lt;/code&gt; (1) and is at most
   * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_PARALLEL_CALLS_LIMIT&lt;/code&gt; (1000); &lt;code&gt;max_attempts&lt;/code&gt; defaults to 1
   * and is at most &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_ATTEMPTS_LIMIT&lt;/code&gt; (10); &lt;code&gt;retry_delay&lt;/code&gt; defaults
   * to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_DEFAULT_RETRY_DELAY_S&lt;/code&gt; (60 s); one &lt;code&gt;AddCallersToCampaign&lt;/code&gt; /
   * &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; request carries at most 1000 entries (a fixed server limit,
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; above it); &lt;code&gt;CancelCampaignCalls&lt;/code&gt; and &lt;code&gt;RetryCampaignCalls&lt;/code&gt;
   * act on at most 1000 calls per request. The status stream is bounded by
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_DURATION_S&lt;/code&gt; (3600 s), sends a keep-alive after
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_KEEPALIVE_S&lt;/code&gt; (15 s) without a change and at most
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_CONCURRENT&lt;/code&gt; (16) status streams are open per server replica.&lt;/p&gt;
   * &lt;p&gt;Authorization (when enforced): every RPC of this service needs &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or a
   * higher role (&lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt;, &lt;code&gt;PROJECT_ADMIN&lt;/code&gt;) on the campaign&amp;apos;s project, or
   * &lt;code&gt;SERVER_ADMIN&lt;/code&gt;; credential-bearing call defaults are returned only to the roles named at
   * &lt;code&gt;Campaign.campaign_common_services_config&lt;/code&gt;.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, field mask or value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign
   * call (with authorization enforced: &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; for a project the caller holds
   * no role on, or a role below &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;); &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; for a request
   * without a valid credential while authorization is enforced; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a
   * &lt;code&gt;display_name&lt;/code&gt; already used in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a state that does not allow the operation (each RPC names its
   * cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change won, nothing was stored and the request can
   * be retried; &lt;code&gt;DEADLINE_EXCEEDED&lt;/code&gt; for a forced &lt;code&gt;DeleteCampaign&lt;/code&gt; whose hang-ups were not
   * confirmed in time (the hard stop stays in effect, retry the request); &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when
   * the server has no free stream slot.&lt;/p&gt;
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * &lt;p&gt;Creates a campaign in state &lt;code&gt;CAMPAIGN_STATE_CREATED&lt;/code&gt;. Calls are added with
     * &lt;code&gt;AddCallersToCampaign&lt;/code&gt; / &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt;; nothing is dialled before
     * &lt;code&gt;StartCampaign&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;With an &lt;code&gt;idempotency_key&lt;/code&gt;, a retry of the same request returns the first attempt&amp;apos;s
     * campaign instead of creating a second one (see &lt;code&gt;CreateCampaignRequest.idempotency_key&lt;/code&gt;).
     * Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_CREATED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; if
     * the &lt;code&gt;display_name&lt;/code&gt; is used in the project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed
     * &lt;code&gt;vtsi_project_name&lt;/code&gt;, an output-only field that was set, an out-of-range value, an invalid
     * &lt;code&gt;calling_window&lt;/code&gt;, a malformed &lt;code&gt;idempotency_key&lt;/code&gt;, an &lt;code&gt;idempotency_key&lt;/code&gt;
     * reused with a different request or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;ABORTED&lt;/code&gt; while
     * a first attempt with the same &lt;code&gt;idempotency_key&lt;/code&gt; is still running.&lt;/p&gt;
     * </pre>
     */
    default void createCampaign(ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCampaignMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a campaign including its statistics, its call defaults and its callers
     * (&lt;code&gt;campaign_callers&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    default void getCampaign(ondewo.vtsi.CampaignsOuterClass.GetCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCampaignMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;max_parallel_calls&lt;/code&gt;, &lt;code&gt;max_attempts&lt;/code&gt;, &lt;code&gt;retry_delay&lt;/code&gt;,
     * &lt;code&gt;campaign_common_services_config&lt;/code&gt;, &lt;code&gt;campaign_sip_caller_config&lt;/code&gt; and
     * &lt;code&gt;calling_window&lt;/code&gt; (each also by a nested sub-path). Allowed in every state. A changed
     * &lt;code&gt;calling_window&lt;/code&gt; applies from the next dispatch decision (within about one second); it never
     * ends a running call. Lowering &lt;code&gt;max_parallel_calls&lt;/code&gt;
     * never ends a running call: the campaign starts no new call until fewer than the new maximum are
     * running. A changed call default applies to every campaign call dispatched after the update,
     * retries included; a call already dispatched keeps the configuration it was started with. The
     * exception is &lt;code&gt;campaign_sip_caller_config.callee_id&lt;/code&gt;, which is fixed per call when the call
     * is added and therefore applies only to calls added after the update.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_UPDATED&lt;/code&gt; (attribute &lt;code&gt;updated_fields&lt;/code&gt;) and, when
     * &lt;code&gt;max_parallel_calls&lt;/code&gt; changed, &lt;code&gt;VTSI_EVENT_CAMPAIGN_MAX_PARALLEL_CALLS_CHANGED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty mask, an unknown,
     * output-only or immutable path, an out-of-range value, an invalid &lt;code&gt;calling_window&lt;/code&gt; or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a
     * &lt;code&gt;display_name&lt;/code&gt; used by another campaign of the project; &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent
     * update of the same campaign won (nothing was written; retry).&lt;/p&gt;
     * </pre>
     */
    default void updateCampaign(ondewo.vtsi.CampaignsOuterClass.UpdateCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCampaignMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a campaign and its campaign calls. Its scheduled callers that have not fired yet are
     * cancelled. Calls that already ran are not touched and stay visible through
     * &lt;code&gt;ListCalls&lt;/code&gt;, but no longer as calls OF the campaign: the attempt history that linked them
     * to it is deleted with it, so &lt;code&gt;ListCalls&lt;/code&gt; with &lt;code&gt;CallFilter.campaign_name&lt;/code&gt; /
     * &lt;code&gt;campaign_display_name&lt;/code&gt; of a deleted campaign answers &lt;code&gt;NOT_FOUND&lt;/code&gt; (list them by
     * caller or without the campaign selector), and &lt;code&gt;Calls.ListCallers&lt;/code&gt; with the campaign selector
     * likewise.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;force&lt;/code&gt;, a campaign that is &lt;code&gt;RUNNING&lt;/code&gt;, &lt;code&gt;STOPPING&lt;/code&gt; or
     * &lt;code&gt;HARD_STOPPING&lt;/code&gt; is hard stopped first (exactly as by &lt;code&gt;HardStopCampaign&lt;/code&gt;) and deleted
     * as soon as the end of each of its calls is confirmed. The RPC waits for that, at most
     * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_FORCE_DELETE_WAIT_S&lt;/code&gt; (30 s by default) and never past the client&amp;apos;s
     * deadline; when the hang-ups are not confirmed by then it answers &lt;code&gt;DEADLINE_EXCEEDED&lt;/code&gt;, the
     * campaign stays &lt;code&gt;HARD_STOPPING&lt;/code&gt; (then &lt;code&gt;HARD_STOPPED&lt;/code&gt;) and is NOT deleted: repeat the
     * request. Idempotent: a repeated forced delete of a campaign that is still hard stopping waits again.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_DELETED&lt;/code&gt; (preceded, with &lt;code&gt;force&lt;/code&gt; on a running
     * campaign, by &lt;code&gt;VTSI_EVENT_CAMPAIGN_HARD_STOP_REQUESTED&lt;/code&gt; and
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_HARD_STOPPED&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; without &lt;code&gt;force&lt;/code&gt; while
     * the campaign is &lt;code&gt;RUNNING&lt;/code&gt;, &lt;code&gt;STOPPING&lt;/code&gt; or &lt;code&gt;HARD_STOPPING&lt;/code&gt; (stop or hard
     * stop it first, or set &lt;code&gt;force&lt;/code&gt;); &lt;code&gt;DEADLINE_EXCEEDED&lt;/code&gt; with &lt;code&gt;force&lt;/code&gt; as
     * described above; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, a &lt;code&gt;display_name&lt;/code&gt; without
     * &lt;code&gt;vtsi_project_name&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    default void deleteCampaign(ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCampaignMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the campaigns of a project, filtered, ordered by &lt;code&gt;ListCampaignsRequest.order_by&lt;/code&gt;
     * (newest first by default) and paged, each with its
     * statistics. &lt;code&gt;campaign_callers&lt;/code&gt; and &lt;code&gt;campaign_callers_truncated&lt;/code&gt; are left empty
     * unless &lt;code&gt;field_mask&lt;/code&gt; names them, and a page that carries them holds at most 20 campaigns (see
     * &lt;code&gt;ListCampaignsRequest.field_mask&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a negative &lt;code&gt;page_size&lt;/code&gt;, a foreign
     * &lt;code&gt;page_token&lt;/code&gt; (also one issued for another filter or &lt;code&gt;order_by&lt;/code&gt;), an unknown
     * &lt;code&gt;order_by&lt;/code&gt; or &lt;code&gt;states&lt;/code&gt; value, &lt;code&gt;created_after&lt;/code&gt; not before
     * &lt;code&gt;created_before&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    default void listCampaigns(ondewo.vtsi.CampaignsOuterClass.ListCampaignsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.ListCampaignsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCampaignsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns the progress of a campaign: how many of its calls are not started, in progress,
     * waiting for a retry, completed, failed and cancelled, and how many attempts were made.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void getCampaignStatistics(ondewo.vtsi.CampaignsOuterClass.GetCampaignStatisticsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.CampaignStatistics> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCampaignStatisticsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the calls of a campaign in the order they were added, filtered and paged, each with
     * its current SIP status, the SIP status description and its attempts.&lt;/p&gt;
     * &lt;p&gt;The filters of &lt;code&gt;ListCampaignCallsRequest&lt;/code&gt; are combined by AND; the values of one
     * repeated filter by OR.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a foreign &lt;code&gt;page_token&lt;/code&gt; (also one issued for another filter), a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt;, a malformed campaign call name or one
     * of another campaign in &lt;code&gt;campaign_call_names&lt;/code&gt;, more than 1000 &lt;code&gt;phone_numbers&lt;/code&gt; or
     * &lt;code&gt;campaign_call_names&lt;/code&gt;, a negative &lt;code&gt;min_attempts&lt;/code&gt;, an unknown enum value in
     * &lt;code&gt;states&lt;/code&gt; / &lt;code&gt;sources&lt;/code&gt;, &lt;code&gt;finish_time_min&lt;/code&gt; not before
     * &lt;code&gt;finish_time_max&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    default void listCampaignCalls(ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCampaignCallsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts a &lt;code&gt;CAMPAIGN_STATE_CREATED&lt;/code&gt; campaign. Idempotent on a
     * &lt;code&gt;RUNNING&lt;/code&gt; campaign.&lt;/p&gt;
     * &lt;p&gt;A campaign with a &lt;code&gt;calling_window&lt;/code&gt; started outside every slot is &lt;code&gt;RUNNING&lt;/code&gt;
     * with &lt;code&gt;outside_calling_window = true&lt;/code&gt; and dials from the next slot on. Emits
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_STARTED&lt;/code&gt; (nothing on the idempotent repeat).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; in any other state (use
     * &lt;code&gt;ResumeCampaign&lt;/code&gt; for a stopped campaign); &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    default void startCampaign(ondewo.vtsi.CampaignsOuterClass.StartCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartCampaignMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a campaign gracefully: no new call is started, the calls that are running continue
     * until they end, then the campaign is &lt;code&gt;CAMPAIGN_STATE_STOPPED&lt;/code&gt;. Returns the campaign
     * in &lt;code&gt;STOPPING&lt;/code&gt; (or already &lt;code&gt;STOPPED&lt;/code&gt; when no call was running).
     * Idempotent on &lt;code&gt;STOPPING&lt;/code&gt;, &lt;code&gt;STOPPED&lt;/code&gt;, &lt;code&gt;HARD_STOPPING&lt;/code&gt; and
     * &lt;code&gt;HARD_STOPPED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; on a
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    default void stopCampaign(ondewo.vtsi.CampaignsOuterClass.StopCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopCampaignMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a campaign immediately: no new call is started and the server hangs up every running
     * call of the campaign right away. The campaign stays &lt;code&gt;CAMPAIGN_STATE_HARD_STOPPING&lt;/code&gt;
     * until the end of each of those calls is CONFIRMED (its call record is no longer active), then
     * becomes &lt;code&gt;CAMPAIGN_STATE_HARD_STOPPED&lt;/code&gt;; with a reachable call infrastructure this
     * takes seconds, scaled by the number of running calls. A hang-up that fails is repeated every
     * few seconds, and the campaign does not report &lt;code&gt;HARD_STOPPED&lt;/code&gt; while one of its calls
     * is still up. Calls ended this way are &lt;code&gt;CAMPAIGN_CALL_STATE_CANCELLED&lt;/code&gt;; a call that
     * finished on its own before the hard stop keeps its own outcome. Calls not started yet stay
     * &lt;code&gt;NOT_STARTED&lt;/code&gt; / &lt;code&gt;RETRY_PENDING&lt;/code&gt; and run after &lt;code&gt;ResumeCampaign&lt;/code&gt;.
     * Returns the campaign in &lt;code&gt;HARD_STOPPING&lt;/code&gt; (or already &lt;code&gt;HARD_STOPPED&lt;/code&gt;).
     * Idempotent on &lt;code&gt;HARD_STOPPING&lt;/code&gt; and &lt;code&gt;HARD_STOPPED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; on a
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    default void hardStopCampaign(ondewo.vtsi.CampaignsOuterClass.HardStopCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHardStopCampaignMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Resumes a &lt;code&gt;STOPPING&lt;/code&gt;, &lt;code&gt;STOPPED&lt;/code&gt; or &lt;code&gt;HARD_STOPPED&lt;/code&gt;
     * campaign: it becomes &lt;code&gt;RUNNING&lt;/code&gt; and continues with the calls that are not finished.
     * Idempotent on &lt;code&gt;RUNNING&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; on &lt;code&gt;CREATED&lt;/code&gt;
     * (use &lt;code&gt;StartCampaign&lt;/code&gt;), &lt;code&gt;HARD_STOPPING&lt;/code&gt; (wait until it is
     * &lt;code&gt;HARD_STOPPED&lt;/code&gt;) and &lt;code&gt;COMPLETED&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    default void resumeCampaign(ondewo.vtsi.CampaignsOuterClass.ResumeCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResumeCampaignMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the status and progress of the campaigns of a project. The first message is a
     * snapshot (&lt;code&gt;snapshot = true&lt;/code&gt;) of every matching campaign; every later message
     * carries only the campaigns (and, with &lt;code&gt;include_calls&lt;/code&gt;, the campaign calls) that
     * changed. Changes are polled every &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_POLL_INTERVAL_S&lt;/code&gt; (1 s by
     * default). An empty message is sent as a keep-alive when nothing changed for
     * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_KEEPALIVE_S&lt;/code&gt; (15 s by default).&lt;/p&gt;
     * &lt;p&gt;The stream ends when the client disconnects, or the server ends it with a last message carrying
     * &lt;code&gt;end_reason&lt;/code&gt; and &lt;code&gt;end_reason_type&lt;/code&gt;: at the maximum stream duration
     * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_DURATION_S&lt;/code&gt; (3600 s by default,
     * &lt;code&gt;STREAM_END_REASON_MAX_DURATION&lt;/code&gt;), when the server shuts down
     * (&lt;code&gt;STREAM_END_REASON_SERVER_SHUTDOWN&lt;/code&gt;) and when the project is deleted
     * (&lt;code&gt;STREAM_END_REASON_PROJECT_DELETED&lt;/code&gt;). Reconnect and treat the new snapshot as authoritative.
     * A client that blocks one send for longer than &lt;code&gt;ONDEWO_VTSI_STREAM_STALL_TIMEOUT_S&lt;/code&gt; (30 s by
     * default) is disconnected without a last message (the RPC ends &lt;code&gt;CANCELLED&lt;/code&gt;). While
     * authorization is enforced, the caller&amp;apos;s role is re-checked periodically; a revoked role ends the
     * RPC with &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, an expired credential with &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a
     * malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a malformed entry of &lt;code&gt;campaign_names&lt;/code&gt;, a campaign
     * name of another project, or an unknown value or &lt;code&gt;CAMPAIGN_STATE_UNSPECIFIED&lt;/code&gt; in
     * &lt;code&gt;states&lt;/code&gt; (a well-formed campaign name of the project that names no campaign is accepted and
     * matches nothing); &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the server has no free stream slot
     * (&lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_CONCURRENT&lt;/code&gt;, 16 per replica by default).&lt;/p&gt;
     * </pre>
     */
    default void streamCampaignStatus(ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamCampaignStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns one call of a campaign, with its current SIP status and, with
     * &lt;code&gt;include_attempts&lt;/code&gt;, its attempts. Read-only, no event.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;name&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign call
     * (also one deleted with its campaign); &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; / &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; as
     * for every RPC of this service.&lt;/p&gt;
     * </pre>
     */
    default void getCampaignCall(ondewo.vtsi.CampaignsOuterClass.GetCampaignCallRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.CampaignCall> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCampaignCallMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Cancels calls of a campaign that have not started an attempt that is still running: each selected
     * call in &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; or &lt;code&gt;CAMPAIGN_CALL_STATE_RETRY_PENDING&lt;/code&gt;
     * becomes &lt;code&gt;CAMPAIGN_CALL_STATE_CANCELLED&lt;/code&gt; (its &lt;code&gt;finish_time&lt;/code&gt; set, counted in
     * &lt;code&gt;CampaignStatistics.cancelled&lt;/code&gt;); the scheduled caller of a call added by
     * &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; is cancelled with it. Mirrors
     * &lt;code&gt;Calls.CancelScheduledCaller&lt;/code&gt;: a call whose attempt is &lt;code&gt;DISPATCHING&lt;/code&gt; or
     * &lt;code&gt;IN_PROGRESS&lt;/code&gt; is NOT cancelled (and its call is not hung up; use
     * &lt;code&gt;HardStopCampaign&lt;/code&gt; or &lt;code&gt;Calls.StopCall&lt;/code&gt;) and is reported in &lt;code&gt;refused&lt;/code&gt;,
     * like a call that is already finished; a refusal is not an error.&lt;/p&gt;
     * &lt;p&gt;Selection: &lt;code&gt;campaign_call_names&lt;/code&gt;, &lt;code&gt;states&lt;/code&gt;, or both (then a named call must
     * also be in one of the states). At most 1000 calls are acted on per request: with &lt;code&gt;states&lt;/code&gt;
     * the first 1000 matching calls by &lt;code&gt;position&lt;/code&gt;, and &lt;code&gt;remaining_count&lt;/code&gt; says how many
     * more match; repeat the request until it is 0. Each call is cancelled atomically on its own (the request
     * as a whole is not atomic); a call that a replica starts dispatching while the request runs is refused,
     * never cancelled half-way. Allowed in every campaign state. When it leaves a &lt;code&gt;RUNNING&lt;/code&gt;
     * campaign without an unfinished call, the campaign becomes &lt;code&gt;COMPLETED&lt;/code&gt; at the next engine
     * tick. Idempotent: a repeat refuses the calls it already cancelled with
     * &lt;code&gt;reason=already-finished&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_CALL_CANCELLED&lt;/code&gt; per cancelled call,
     * &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CANCELLED&lt;/code&gt; per cancelled scheduled caller, and the usual
     * throttled &lt;code&gt;VTSI_EVENT_CAMPAIGN_PROGRESS&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed selector (as &lt;code&gt;GetCampaign&lt;/code&gt;), neither
     * &lt;code&gt;campaign_call_names&lt;/code&gt; nor &lt;code&gt;states&lt;/code&gt; set, more than 1000 names, a malformed campaign
     * call name or one of another campaign, a state other than &lt;code&gt;NOT_STARTED&lt;/code&gt; /
     * &lt;code&gt;RETRY_PENDING&lt;/code&gt; in &lt;code&gt;states&lt;/code&gt;; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or
     * campaign (an unknown but well-formed campaign call name of the campaign is a refusal with
     * &lt;code&gt;reason=not-found&lt;/code&gt;, not an error).&lt;/p&gt;
     * </pre>
     */
    default void cancelCampaignCalls(ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelCampaignCallsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Puts FAILED or CANCELLED calls of a campaign back into the queue with a fresh attempt budget: each
     * selected call gets &lt;code&gt;additional_attempts&lt;/code&gt; more attempts on top of the attempts it already
     * made, and becomes &lt;code&gt;CAMPAIGN_CALL_STATE_RETRY_PENDING&lt;/code&gt; with &lt;code&gt;next_attempt_time&lt;/code&gt; =
     * the later of now and &lt;code&gt;not_before&lt;/code&gt; (or &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; when it
     * never made an attempt, e.g. a scheduled call cancelled before it fired). &lt;code&gt;finish_time&lt;/code&gt; and
     * &lt;code&gt;last_error&lt;/code&gt; are cleared; &lt;code&gt;attempt_history&lt;/code&gt; is kept and continues with the next
     * &lt;code&gt;attempt_number&lt;/code&gt;. The call keeps its &lt;code&gt;phone_number&lt;/code&gt; and its own configuration;
     * the campaign&amp;apos;s call defaults are read live at the next dispatch as for every attempt.&lt;/p&gt;
     * &lt;p&gt;A call added by &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; keeps following its scheduled caller,
     * which returns to &lt;code&gt;SCHEDULED&lt;/code&gt; with its scheduled time moved to the call&amp;apos;s
     * &lt;code&gt;next_attempt_time&lt;/code&gt; (&lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_UPDATED&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Effect on the campaign: a &lt;code&gt;COMPLETED&lt;/code&gt; campaign becomes &lt;code&gt;RUNNING&lt;/code&gt; again (as when
     * calls are added by a &lt;code&gt;CampaignAssignment&lt;/code&gt;); every other state is kept, so a stopped campaign
     * runs the calls after &lt;code&gt;ResumeCampaign&lt;/code&gt; and a &lt;code&gt;CREATED&lt;/code&gt; one after
     * &lt;code&gt;StartCampaign&lt;/code&gt;. The calls are dispatched under &lt;code&gt;max_parallel_calls&lt;/code&gt; and the
     * &lt;code&gt;calling_window&lt;/code&gt; like any other.&lt;/p&gt;
     * &lt;p&gt;Selection exactly as &lt;code&gt;CancelCampaignCalls&lt;/code&gt; (names, states or both; at most 1000 calls per
     * request, &lt;code&gt;remaining_count&lt;/code&gt;); a selected call that is not &lt;code&gt;FAILED&lt;/code&gt; or
     * &lt;code&gt;CANCELLED&lt;/code&gt; is reported in &lt;code&gt;refused&lt;/code&gt;. A failure that cannot succeed by repetition
     * (e.g. a rejected credential) is retried too: fix its cause first, otherwise the campaign may be
     * auto-stopped again. Not idempotent: each request adds a new budget to the calls it requeues, but a
     * repeat finds them &lt;code&gt;RETRY_PENDING&lt;/code&gt; / &lt;code&gt;NOT_STARTED&lt;/code&gt; and refuses them.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_CALL_REQUEUED&lt;/code&gt; per requeued call (attributes
     * &lt;code&gt;attempt_limit&lt;/code&gt;, &lt;code&gt;next_attempt_time&lt;/code&gt;), &lt;code&gt;VTSI_EVENT_CAMPAIGN_RESUMED&lt;/code&gt;
     * when a &lt;code&gt;COMPLETED&lt;/code&gt; campaign became &lt;code&gt;RUNNING&lt;/code&gt;, and the throttled
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_PROGRESS&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; as &lt;code&gt;CancelCampaignCalls&lt;/code&gt;, except that
     * &lt;code&gt;states&lt;/code&gt; may only hold &lt;code&gt;FAILED&lt;/code&gt; / &lt;code&gt;CANCELLED&lt;/code&gt;, plus
     * &lt;code&gt;additional_attempts&lt;/code&gt; outside 0 to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_ATTEMPTS_LIMIT&lt;/code&gt; (10)
     * and &lt;code&gt;not_before&lt;/code&gt; more than 7 days ahead; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or
     * campaign; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the campaign is &lt;code&gt;HARD_STOPPING&lt;/code&gt; (wait until it
     * is &lt;code&gt;HARD_STOPPED&lt;/code&gt;).&lt;/p&gt;
     * </pre>
     */
    default void retryCampaignCalls(ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRetryCampaignCallsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a new campaign in the same project as a copy of an existing one, server side, so the
     * stored credentials of its call defaults are preserved without ever being returned to the client (a
     * Get-then-Create round trip would copy the REDACTED defaults). Copied: &lt;code&gt;max_parallel_calls&lt;/code&gt;,
     * &lt;code&gt;max_attempts&lt;/code&gt;, &lt;code&gt;retry_delay&lt;/code&gt;, &lt;code&gt;campaign_common_services_config&lt;/code&gt;,
     * &lt;code&gt;campaign_sip_caller_config&lt;/code&gt; and &lt;code&gt;calling_window&lt;/code&gt;. Not copied: the state (the
     * clone is &lt;code&gt;CAMPAIGN_STATE_CREATED&lt;/code&gt;), statistics, callers and every other output-only
     * field.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;include_calls&lt;/code&gt;, the source&amp;apos;s calls whose state is in &lt;code&gt;call_states&lt;/code&gt;
     * (empty: every state) are copied as new &lt;code&gt;NOT_STARTED&lt;/code&gt; calls in their original order
     * (&lt;code&gt;position&lt;/code&gt; renumbered from 1), each with its own stored configuration and its fixed
     * &lt;code&gt;phone_number&lt;/code&gt;, no attempt and no history. A copied call that was added by
     * &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; gets a new scheduled caller with the same scheduled time
     * (a time in the past is due as soon as the clone runs). The whole clone is atomic: the campaign and every
     * copied call (and scheduled caller) are stored, or nothing is. The source is read in one consistent
     * snapshot and is not changed.&lt;/p&gt;
     * &lt;p&gt;With an &lt;code&gt;idempotency_key&lt;/code&gt;, a retry of the same request returns the first attempt&amp;apos;s
     * clone (see &lt;code&gt;CreateCampaignRequest.idempotency_key&lt;/code&gt;). Emits
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_CREATED&lt;/code&gt; for the clone with the attributes &lt;code&gt;cloned_from&lt;/code&gt;
     * (the source&amp;apos;s resource name) and &lt;code&gt;copied_call_count&lt;/code&gt;, and, when calls were copied,
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_CALLS_ADDED&lt;/code&gt; and one &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CREATED&lt;/code&gt; per
     * new scheduled caller.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed source selector (as &lt;code&gt;GetCampaign&lt;/code&gt;),
     * a &lt;code&gt;new_display_name&lt;/code&gt; over 128 characters, &lt;code&gt;call_states&lt;/code&gt; without
     * &lt;code&gt;include_calls&lt;/code&gt; or holding an unknown value, a malformed or reused
     * &lt;code&gt;idempotency_key&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an
     * unknown project or source campaign; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when &lt;code&gt;new_display_name&lt;/code&gt; is used
     * in the project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the copied calls would exceed
     * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_CALLS&lt;/code&gt;; &lt;code&gt;ABORTED&lt;/code&gt; while a first attempt with the same
     * &lt;code&gt;idempotency_key&lt;/code&gt; is still running.&lt;/p&gt;
     * </pre>
     */
    default void cloneCampaign(ondewo.vtsi.CampaignsOuterClass.CloneCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCloneCampaignMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Campaigns.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the CAMPAIGNS of a VTSI project. A campaign is a named set of outbound calls that VTSI
   * places for the client while keeping at most &lt;code&gt;max_parallel_calls&lt;/code&gt; of them running at
   * the same time. If 100 callers are added to a campaign with &lt;code&gt;max_parallel_calls = 10&lt;/code&gt;,
   * at any moment at most 10 of those calls are being set up or are connected; the next one starts
   * when one ends.&lt;/p&gt;
   * &lt;p&gt;Calls are added to a campaign with
   * &lt;a href="index.html#ondewo.vtsi.Calls.AddCallersToCampaign"&gt;Calls.AddCallersToCampaign&lt;/a&gt; or
   * &lt;a href="index.html#ondewo.vtsi.Calls.AddScheduledCallersToCampaign"&gt;Calls.AddScheduledCallersToCampaign&lt;/a&gt;
   * (a server that predates them answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; and starts nothing); a scheduled call of a campaign is started at or after its scheduled time AND when the campaign has
   * a free slot.&lt;/p&gt;
   * &lt;p&gt;A call that fails is retried up to &lt;code&gt;max_attempts&lt;/code&gt; times in total, waiting
   * &lt;code&gt;retry_delay&lt;/code&gt; between attempts. A call counts as failed only after its last attempt.
   * A failure that cannot succeed by repetition (for example a rejected credential, an invalid
   * configuration) is never retried.&lt;/p&gt;
   * &lt;p&gt;Lifecycle: &lt;code&gt;StartCampaign&lt;/code&gt; starts a created campaign; &lt;code&gt;StopCampaign&lt;/code&gt; lets
   * the ongoing calls finish and starts no new ones; &lt;code&gt;HardStopCampaign&lt;/code&gt; ends the ongoing
   * calls immediately and starts no new ones; &lt;code&gt;ResumeCampaign&lt;/code&gt; continues a stopped or hard
   * stopped campaign with the calls that have not finished yet.&lt;/p&gt;
   * &lt;p&gt;Every RPC about ONE campaign accepts either its resource name or its display name. Display names
   * are unique within a project, so a display name is resolved within the project named by the
   * request&amp;apos;s top-level &lt;code&gt;vtsi_project_name&lt;/code&gt;, which is REQUIRED with a display name
   * (&lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; when it is empty or malformed) and checked against the campaign
   * when a resource name is used. (The &lt;code&gt;CampaignDisplayName&lt;/code&gt; message of 9.0.0, which
   * carried the project and the display name together, was removed in 9.1.0; its field numbers are
   * &lt;code&gt;reserved&lt;/code&gt;.)&lt;/p&gt;
   * &lt;p&gt;A malformed selector is &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for every authenticated caller, with or
   * without authorization enforced (also when authorization could resolve no project from it): neither
   * the resource name nor the display name set (also how an old 9.0.0 client&amp;apos;s removed
   * &lt;code&gt;CampaignDisplayName&lt;/code&gt; arrives), a malformed resource name, a display name with an empty
   * or malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, and a &lt;code&gt;vtsi_project_name&lt;/code&gt; that is not the
   * project of the resource name. With authorization enforced, a well-formed request naming a project
   * the caller holds no role on (an unknown project included) is refused with
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; before any lookup, so it is not answered &lt;code&gt;NOT_FOUND&lt;/code&gt;, and
   * a caller without a credential is &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; whatever it sent.&lt;/p&gt;
   * &lt;p&gt;Campaign-level call defaults: &lt;code&gt;campaign_common_services_config&lt;/code&gt; and
   * &lt;code&gt;campaign_sip_caller_config&lt;/code&gt; of a &lt;code&gt;Campaign&lt;/code&gt; are the defaults of EVERY call of
   * the campaign. They are read LIVE when a campaign call is dispatched (every attempt, retries
   * included): the effective configuration of the call is a copy of the campaign&amp;apos;s config with the
   * call&amp;apos;s own &lt;code&gt;StartCallerRequest&lt;/code&gt; config merged over it (protobuf
   * &lt;code&gt;MergeFrom&lt;/code&gt;), see &lt;a href="index.html#ondewo.vtsi.Campaign"&gt;Campaign&lt;/a&gt;. The one exception
   * is the callee: &lt;code&gt;campaign_sip_caller_config.callee_id&lt;/code&gt; is resolved and FIXED when a call is
   * added (it is that call&amp;apos;s &lt;code&gt;CampaignCall.phone_number&lt;/code&gt;), so every attempt of a call dials the
   * number its campaign call reports.&lt;/p&gt;
   * &lt;p&gt;Partial responses: &lt;code&gt;ListCampaigns&lt;/code&gt;, &lt;code&gt;ListCampaignCalls&lt;/code&gt;,
   * &lt;code&gt;CreateCampaign&lt;/code&gt;, &lt;code&gt;GetCampaign&lt;/code&gt;, &lt;code&gt;UpdateCampaign&lt;/code&gt;,
   * &lt;code&gt;DeleteCampaign&lt;/code&gt; (paths of &lt;code&gt;DeleteCampaignResponse&lt;/code&gt;), the four lifecycle RPCs
   * &lt;code&gt;StartCampaign&lt;/code&gt;, &lt;code&gt;StopCampaign&lt;/code&gt;, &lt;code&gt;HardStopCampaign&lt;/code&gt; and
   * &lt;code&gt;ResumeCampaign&lt;/code&gt;, &lt;code&gt;CloneCampaign&lt;/code&gt; and &lt;code&gt;GetCampaignCall&lt;/code&gt; accept an optional
   * &lt;code&gt;field_mask&lt;/code&gt; naming the field paths of the returned resource (for a listing: of each listed
   * element) to populate. A mask never changes what the RPC does. Unset or empty returns every
   * field (one exception: &lt;code&gt;ListCampaigns&lt;/code&gt; returns &lt;code&gt;campaign_callers&lt;/code&gt; and
   * &lt;code&gt;campaign_callers_truncated&lt;/code&gt; only when its mask names them); the identifying &lt;code&gt;name&lt;/code&gt; is always populated; an unknown path is rejected with
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; naming it; nested paths through singular message fields (e.g.
   * &lt;code&gt;statistics.completed&lt;/code&gt;) are allowed, a path below a repeated or map field is not. The
   * mask is applied after any role-based redaction, so it can only narrow what the caller may see.&lt;/p&gt;
   * &lt;p&gt;Callers and calls of a campaign: &lt;code&gt;Campaign.campaign_callers&lt;/code&gt; names the callers that placed
   * its calls (bounded); &lt;code&gt;Calls.ListCallers&lt;/code&gt; with &lt;code&gt;ListCallersRequest.campaign_name&lt;/code&gt; /
   * &lt;code&gt;campaign_display_name&lt;/code&gt; lists them paginated as &lt;code&gt;Caller&lt;/code&gt; resources, and
   * &lt;code&gt;Calls.ListCalls&lt;/code&gt; with &lt;code&gt;CallFilter.campaign_name&lt;/code&gt; /
   * &lt;code&gt;campaign_display_name&lt;/code&gt; lists the calls they placed as &lt;code&gt;Call&lt;/code&gt; resources.&lt;/p&gt;
   * &lt;p&gt;Calling window: a campaign with a &lt;code&gt;calling_window&lt;/code&gt; starts calls (first attempts, retries and
   * due scheduled calls alike) only inside one of the window&amp;apos;s weekly slots, in the window&amp;apos;s time zone.
   * Outside every slot it stays &lt;code&gt;RUNNING&lt;/code&gt; and reports &lt;code&gt;outside_calling_window = true&lt;/code&gt;; calls
   * already running are never ended by a slot ending. See
   * &lt;a href="index.html#ondewo.vtsi.CampaignCallingWindow"&gt;CampaignCallingWindow&lt;/a&gt;.&lt;/p&gt;
   * &lt;p&gt;Limits and defaults of the server (environment variables of ondewo-vtsi, read at start-up): at most
   * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_CALLS&lt;/code&gt; (100000) calls per campaign; &lt;code&gt;max_parallel_calls&lt;/code&gt;
   * defaults to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_DEFAULT_MAX_PARALLEL_CALLS&lt;/code&gt; (1) and is at most
   * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_PARALLEL_CALLS_LIMIT&lt;/code&gt; (1000); &lt;code&gt;max_attempts&lt;/code&gt; defaults to 1
   * and is at most &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_ATTEMPTS_LIMIT&lt;/code&gt; (10); &lt;code&gt;retry_delay&lt;/code&gt; defaults
   * to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_DEFAULT_RETRY_DELAY_S&lt;/code&gt; (60 s); one &lt;code&gt;AddCallersToCampaign&lt;/code&gt; /
   * &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; request carries at most 1000 entries (a fixed server limit,
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; above it); &lt;code&gt;CancelCampaignCalls&lt;/code&gt; and &lt;code&gt;RetryCampaignCalls&lt;/code&gt;
   * act on at most 1000 calls per request. The status stream is bounded by
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_DURATION_S&lt;/code&gt; (3600 s), sends a keep-alive after
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_KEEPALIVE_S&lt;/code&gt; (15 s) without a change and at most
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_CONCURRENT&lt;/code&gt; (16) status streams are open per server replica.&lt;/p&gt;
   * &lt;p&gt;Authorization (when enforced): every RPC of this service needs &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or a
   * higher role (&lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt;, &lt;code&gt;PROJECT_ADMIN&lt;/code&gt;) on the campaign&amp;apos;s project, or
   * &lt;code&gt;SERVER_ADMIN&lt;/code&gt;; credential-bearing call defaults are returned only to the roles named at
   * &lt;code&gt;Campaign.campaign_common_services_config&lt;/code&gt;.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, field mask or value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign
   * call (with authorization enforced: &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; for a project the caller holds
   * no role on, or a role below &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;); &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; for a request
   * without a valid credential while authorization is enforced; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a
   * &lt;code&gt;display_name&lt;/code&gt; already used in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a state that does not allow the operation (each RPC names its
   * cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change won, nothing was stored and the request can
   * be retried; &lt;code&gt;DEADLINE_EXCEEDED&lt;/code&gt; for a forced &lt;code&gt;DeleteCampaign&lt;/code&gt; whose hang-ups were not
   * confirmed in time (the hard stop stays in effect, retry the request); &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when
   * the server has no free stream slot.&lt;/p&gt;
   * </pre>
   */
  public static abstract class CampaignsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CampaignsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Campaigns.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the CAMPAIGNS of a VTSI project. A campaign is a named set of outbound calls that VTSI
   * places for the client while keeping at most &lt;code&gt;max_parallel_calls&lt;/code&gt; of them running at
   * the same time. If 100 callers are added to a campaign with &lt;code&gt;max_parallel_calls = 10&lt;/code&gt;,
   * at any moment at most 10 of those calls are being set up or are connected; the next one starts
   * when one ends.&lt;/p&gt;
   * &lt;p&gt;Calls are added to a campaign with
   * &lt;a href="index.html#ondewo.vtsi.Calls.AddCallersToCampaign"&gt;Calls.AddCallersToCampaign&lt;/a&gt; or
   * &lt;a href="index.html#ondewo.vtsi.Calls.AddScheduledCallersToCampaign"&gt;Calls.AddScheduledCallersToCampaign&lt;/a&gt;
   * (a server that predates them answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; and starts nothing); a scheduled call of a campaign is started at or after its scheduled time AND when the campaign has
   * a free slot.&lt;/p&gt;
   * &lt;p&gt;A call that fails is retried up to &lt;code&gt;max_attempts&lt;/code&gt; times in total, waiting
   * &lt;code&gt;retry_delay&lt;/code&gt; between attempts. A call counts as failed only after its last attempt.
   * A failure that cannot succeed by repetition (for example a rejected credential, an invalid
   * configuration) is never retried.&lt;/p&gt;
   * &lt;p&gt;Lifecycle: &lt;code&gt;StartCampaign&lt;/code&gt; starts a created campaign; &lt;code&gt;StopCampaign&lt;/code&gt; lets
   * the ongoing calls finish and starts no new ones; &lt;code&gt;HardStopCampaign&lt;/code&gt; ends the ongoing
   * calls immediately and starts no new ones; &lt;code&gt;ResumeCampaign&lt;/code&gt; continues a stopped or hard
   * stopped campaign with the calls that have not finished yet.&lt;/p&gt;
   * &lt;p&gt;Every RPC about ONE campaign accepts either its resource name or its display name. Display names
   * are unique within a project, so a display name is resolved within the project named by the
   * request&amp;apos;s top-level &lt;code&gt;vtsi_project_name&lt;/code&gt;, which is REQUIRED with a display name
   * (&lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; when it is empty or malformed) and checked against the campaign
   * when a resource name is used. (The &lt;code&gt;CampaignDisplayName&lt;/code&gt; message of 9.0.0, which
   * carried the project and the display name together, was removed in 9.1.0; its field numbers are
   * &lt;code&gt;reserved&lt;/code&gt;.)&lt;/p&gt;
   * &lt;p&gt;A malformed selector is &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for every authenticated caller, with or
   * without authorization enforced (also when authorization could resolve no project from it): neither
   * the resource name nor the display name set (also how an old 9.0.0 client&amp;apos;s removed
   * &lt;code&gt;CampaignDisplayName&lt;/code&gt; arrives), a malformed resource name, a display name with an empty
   * or malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, and a &lt;code&gt;vtsi_project_name&lt;/code&gt; that is not the
   * project of the resource name. With authorization enforced, a well-formed request naming a project
   * the caller holds no role on (an unknown project included) is refused with
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; before any lookup, so it is not answered &lt;code&gt;NOT_FOUND&lt;/code&gt;, and
   * a caller without a credential is &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; whatever it sent.&lt;/p&gt;
   * &lt;p&gt;Campaign-level call defaults: &lt;code&gt;campaign_common_services_config&lt;/code&gt; and
   * &lt;code&gt;campaign_sip_caller_config&lt;/code&gt; of a &lt;code&gt;Campaign&lt;/code&gt; are the defaults of EVERY call of
   * the campaign. They are read LIVE when a campaign call is dispatched (every attempt, retries
   * included): the effective configuration of the call is a copy of the campaign&amp;apos;s config with the
   * call&amp;apos;s own &lt;code&gt;StartCallerRequest&lt;/code&gt; config merged over it (protobuf
   * &lt;code&gt;MergeFrom&lt;/code&gt;), see &lt;a href="index.html#ondewo.vtsi.Campaign"&gt;Campaign&lt;/a&gt;. The one exception
   * is the callee: &lt;code&gt;campaign_sip_caller_config.callee_id&lt;/code&gt; is resolved and FIXED when a call is
   * added (it is that call&amp;apos;s &lt;code&gt;CampaignCall.phone_number&lt;/code&gt;), so every attempt of a call dials the
   * number its campaign call reports.&lt;/p&gt;
   * &lt;p&gt;Partial responses: &lt;code&gt;ListCampaigns&lt;/code&gt;, &lt;code&gt;ListCampaignCalls&lt;/code&gt;,
   * &lt;code&gt;CreateCampaign&lt;/code&gt;, &lt;code&gt;GetCampaign&lt;/code&gt;, &lt;code&gt;UpdateCampaign&lt;/code&gt;,
   * &lt;code&gt;DeleteCampaign&lt;/code&gt; (paths of &lt;code&gt;DeleteCampaignResponse&lt;/code&gt;), the four lifecycle RPCs
   * &lt;code&gt;StartCampaign&lt;/code&gt;, &lt;code&gt;StopCampaign&lt;/code&gt;, &lt;code&gt;HardStopCampaign&lt;/code&gt; and
   * &lt;code&gt;ResumeCampaign&lt;/code&gt;, &lt;code&gt;CloneCampaign&lt;/code&gt; and &lt;code&gt;GetCampaignCall&lt;/code&gt; accept an optional
   * &lt;code&gt;field_mask&lt;/code&gt; naming the field paths of the returned resource (for a listing: of each listed
   * element) to populate. A mask never changes what the RPC does. Unset or empty returns every
   * field (one exception: &lt;code&gt;ListCampaigns&lt;/code&gt; returns &lt;code&gt;campaign_callers&lt;/code&gt; and
   * &lt;code&gt;campaign_callers_truncated&lt;/code&gt; only when its mask names them); the identifying &lt;code&gt;name&lt;/code&gt; is always populated; an unknown path is rejected with
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; naming it; nested paths through singular message fields (e.g.
   * &lt;code&gt;statistics.completed&lt;/code&gt;) are allowed, a path below a repeated or map field is not. The
   * mask is applied after any role-based redaction, so it can only narrow what the caller may see.&lt;/p&gt;
   * &lt;p&gt;Callers and calls of a campaign: &lt;code&gt;Campaign.campaign_callers&lt;/code&gt; names the callers that placed
   * its calls (bounded); &lt;code&gt;Calls.ListCallers&lt;/code&gt; with &lt;code&gt;ListCallersRequest.campaign_name&lt;/code&gt; /
   * &lt;code&gt;campaign_display_name&lt;/code&gt; lists them paginated as &lt;code&gt;Caller&lt;/code&gt; resources, and
   * &lt;code&gt;Calls.ListCalls&lt;/code&gt; with &lt;code&gt;CallFilter.campaign_name&lt;/code&gt; /
   * &lt;code&gt;campaign_display_name&lt;/code&gt; lists the calls they placed as &lt;code&gt;Call&lt;/code&gt; resources.&lt;/p&gt;
   * &lt;p&gt;Calling window: a campaign with a &lt;code&gt;calling_window&lt;/code&gt; starts calls (first attempts, retries and
   * due scheduled calls alike) only inside one of the window&amp;apos;s weekly slots, in the window&amp;apos;s time zone.
   * Outside every slot it stays &lt;code&gt;RUNNING&lt;/code&gt; and reports &lt;code&gt;outside_calling_window = true&lt;/code&gt;; calls
   * already running are never ended by a slot ending. See
   * &lt;a href="index.html#ondewo.vtsi.CampaignCallingWindow"&gt;CampaignCallingWindow&lt;/a&gt;.&lt;/p&gt;
   * &lt;p&gt;Limits and defaults of the server (environment variables of ondewo-vtsi, read at start-up): at most
   * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_CALLS&lt;/code&gt; (100000) calls per campaign; &lt;code&gt;max_parallel_calls&lt;/code&gt;
   * defaults to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_DEFAULT_MAX_PARALLEL_CALLS&lt;/code&gt; (1) and is at most
   * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_PARALLEL_CALLS_LIMIT&lt;/code&gt; (1000); &lt;code&gt;max_attempts&lt;/code&gt; defaults to 1
   * and is at most &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_ATTEMPTS_LIMIT&lt;/code&gt; (10); &lt;code&gt;retry_delay&lt;/code&gt; defaults
   * to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_DEFAULT_RETRY_DELAY_S&lt;/code&gt; (60 s); one &lt;code&gt;AddCallersToCampaign&lt;/code&gt; /
   * &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; request carries at most 1000 entries (a fixed server limit,
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; above it); &lt;code&gt;CancelCampaignCalls&lt;/code&gt; and &lt;code&gt;RetryCampaignCalls&lt;/code&gt;
   * act on at most 1000 calls per request. The status stream is bounded by
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_DURATION_S&lt;/code&gt; (3600 s), sends a keep-alive after
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_KEEPALIVE_S&lt;/code&gt; (15 s) without a change and at most
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_CONCURRENT&lt;/code&gt; (16) status streams are open per server replica.&lt;/p&gt;
   * &lt;p&gt;Authorization (when enforced): every RPC of this service needs &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or a
   * higher role (&lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt;, &lt;code&gt;PROJECT_ADMIN&lt;/code&gt;) on the campaign&amp;apos;s project, or
   * &lt;code&gt;SERVER_ADMIN&lt;/code&gt;; credential-bearing call defaults are returned only to the roles named at
   * &lt;code&gt;Campaign.campaign_common_services_config&lt;/code&gt;.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, field mask or value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign
   * call (with authorization enforced: &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; for a project the caller holds
   * no role on, or a role below &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;); &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; for a request
   * without a valid credential while authorization is enforced; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a
   * &lt;code&gt;display_name&lt;/code&gt; already used in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a state that does not allow the operation (each RPC names its
   * cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change won, nothing was stored and the request can
   * be retried; &lt;code&gt;DEADLINE_EXCEEDED&lt;/code&gt; for a forced &lt;code&gt;DeleteCampaign&lt;/code&gt; whose hang-ups were not
   * confirmed in time (the hard stop stays in effect, retry the request); &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when
   * the server has no free stream slot.&lt;/p&gt;
   * </pre>
   */
  public static final class CampaignsStub
      extends io.grpc.stub.AbstractAsyncStub<CampaignsStub> {
    private CampaignsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CampaignsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CampaignsStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a campaign in state &lt;code&gt;CAMPAIGN_STATE_CREATED&lt;/code&gt;. Calls are added with
     * &lt;code&gt;AddCallersToCampaign&lt;/code&gt; / &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt;; nothing is dialled before
     * &lt;code&gt;StartCampaign&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;With an &lt;code&gt;idempotency_key&lt;/code&gt;, a retry of the same request returns the first attempt&amp;apos;s
     * campaign instead of creating a second one (see &lt;code&gt;CreateCampaignRequest.idempotency_key&lt;/code&gt;).
     * Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_CREATED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; if
     * the &lt;code&gt;display_name&lt;/code&gt; is used in the project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed
     * &lt;code&gt;vtsi_project_name&lt;/code&gt;, an output-only field that was set, an out-of-range value, an invalid
     * &lt;code&gt;calling_window&lt;/code&gt;, a malformed &lt;code&gt;idempotency_key&lt;/code&gt;, an &lt;code&gt;idempotency_key&lt;/code&gt;
     * reused with a different request or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;ABORTED&lt;/code&gt; while
     * a first attempt with the same &lt;code&gt;idempotency_key&lt;/code&gt; is still running.&lt;/p&gt;
     * </pre>
     */
    public void createCampaign(ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCampaignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a campaign including its statistics, its call defaults and its callers
     * (&lt;code&gt;campaign_callers&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public void getCampaign(ondewo.vtsi.CampaignsOuterClass.GetCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCampaignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;max_parallel_calls&lt;/code&gt;, &lt;code&gt;max_attempts&lt;/code&gt;, &lt;code&gt;retry_delay&lt;/code&gt;,
     * &lt;code&gt;campaign_common_services_config&lt;/code&gt;, &lt;code&gt;campaign_sip_caller_config&lt;/code&gt; and
     * &lt;code&gt;calling_window&lt;/code&gt; (each also by a nested sub-path). Allowed in every state. A changed
     * &lt;code&gt;calling_window&lt;/code&gt; applies from the next dispatch decision (within about one second); it never
     * ends a running call. Lowering &lt;code&gt;max_parallel_calls&lt;/code&gt;
     * never ends a running call: the campaign starts no new call until fewer than the new maximum are
     * running. A changed call default applies to every campaign call dispatched after the update,
     * retries included; a call already dispatched keeps the configuration it was started with. The
     * exception is &lt;code&gt;campaign_sip_caller_config.callee_id&lt;/code&gt;, which is fixed per call when the call
     * is added and therefore applies only to calls added after the update.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_UPDATED&lt;/code&gt; (attribute &lt;code&gt;updated_fields&lt;/code&gt;) and, when
     * &lt;code&gt;max_parallel_calls&lt;/code&gt; changed, &lt;code&gt;VTSI_EVENT_CAMPAIGN_MAX_PARALLEL_CALLS_CHANGED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty mask, an unknown,
     * output-only or immutable path, an out-of-range value, an invalid &lt;code&gt;calling_window&lt;/code&gt; or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a
     * &lt;code&gt;display_name&lt;/code&gt; used by another campaign of the project; &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent
     * update of the same campaign won (nothing was written; retry).&lt;/p&gt;
     * </pre>
     */
    public void updateCampaign(ondewo.vtsi.CampaignsOuterClass.UpdateCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCampaignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a campaign and its campaign calls. Its scheduled callers that have not fired yet are
     * cancelled. Calls that already ran are not touched and stay visible through
     * &lt;code&gt;ListCalls&lt;/code&gt;, but no longer as calls OF the campaign: the attempt history that linked them
     * to it is deleted with it, so &lt;code&gt;ListCalls&lt;/code&gt; with &lt;code&gt;CallFilter.campaign_name&lt;/code&gt; /
     * &lt;code&gt;campaign_display_name&lt;/code&gt; of a deleted campaign answers &lt;code&gt;NOT_FOUND&lt;/code&gt; (list them by
     * caller or without the campaign selector), and &lt;code&gt;Calls.ListCallers&lt;/code&gt; with the campaign selector
     * likewise.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;force&lt;/code&gt;, a campaign that is &lt;code&gt;RUNNING&lt;/code&gt;, &lt;code&gt;STOPPING&lt;/code&gt; or
     * &lt;code&gt;HARD_STOPPING&lt;/code&gt; is hard stopped first (exactly as by &lt;code&gt;HardStopCampaign&lt;/code&gt;) and deleted
     * as soon as the end of each of its calls is confirmed. The RPC waits for that, at most
     * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_FORCE_DELETE_WAIT_S&lt;/code&gt; (30 s by default) and never past the client&amp;apos;s
     * deadline; when the hang-ups are not confirmed by then it answers &lt;code&gt;DEADLINE_EXCEEDED&lt;/code&gt;, the
     * campaign stays &lt;code&gt;HARD_STOPPING&lt;/code&gt; (then &lt;code&gt;HARD_STOPPED&lt;/code&gt;) and is NOT deleted: repeat the
     * request. Idempotent: a repeated forced delete of a campaign that is still hard stopping waits again.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_DELETED&lt;/code&gt; (preceded, with &lt;code&gt;force&lt;/code&gt; on a running
     * campaign, by &lt;code&gt;VTSI_EVENT_CAMPAIGN_HARD_STOP_REQUESTED&lt;/code&gt; and
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_HARD_STOPPED&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; without &lt;code&gt;force&lt;/code&gt; while
     * the campaign is &lt;code&gt;RUNNING&lt;/code&gt;, &lt;code&gt;STOPPING&lt;/code&gt; or &lt;code&gt;HARD_STOPPING&lt;/code&gt; (stop or hard
     * stop it first, or set &lt;code&gt;force&lt;/code&gt;); &lt;code&gt;DEADLINE_EXCEEDED&lt;/code&gt; with &lt;code&gt;force&lt;/code&gt; as
     * described above; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, a &lt;code&gt;display_name&lt;/code&gt; without
     * &lt;code&gt;vtsi_project_name&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public void deleteCampaign(ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCampaignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the campaigns of a project, filtered, ordered by &lt;code&gt;ListCampaignsRequest.order_by&lt;/code&gt;
     * (newest first by default) and paged, each with its
     * statistics. &lt;code&gt;campaign_callers&lt;/code&gt; and &lt;code&gt;campaign_callers_truncated&lt;/code&gt; are left empty
     * unless &lt;code&gt;field_mask&lt;/code&gt; names them, and a page that carries them holds at most 20 campaigns (see
     * &lt;code&gt;ListCampaignsRequest.field_mask&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a negative &lt;code&gt;page_size&lt;/code&gt;, a foreign
     * &lt;code&gt;page_token&lt;/code&gt; (also one issued for another filter or &lt;code&gt;order_by&lt;/code&gt;), an unknown
     * &lt;code&gt;order_by&lt;/code&gt; or &lt;code&gt;states&lt;/code&gt; value, &lt;code&gt;created_after&lt;/code&gt; not before
     * &lt;code&gt;created_before&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public void listCampaigns(ondewo.vtsi.CampaignsOuterClass.ListCampaignsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.ListCampaignsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCampaignsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns the progress of a campaign: how many of its calls are not started, in progress,
     * waiting for a retry, completed, failed and cancelled, and how many attempts were made.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void getCampaignStatistics(ondewo.vtsi.CampaignsOuterClass.GetCampaignStatisticsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.CampaignStatistics> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCampaignStatisticsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the calls of a campaign in the order they were added, filtered and paged, each with
     * its current SIP status, the SIP status description and its attempts.&lt;/p&gt;
     * &lt;p&gt;The filters of &lt;code&gt;ListCampaignCallsRequest&lt;/code&gt; are combined by AND; the values of one
     * repeated filter by OR.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a foreign &lt;code&gt;page_token&lt;/code&gt; (also one issued for another filter), a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt;, a malformed campaign call name or one
     * of another campaign in &lt;code&gt;campaign_call_names&lt;/code&gt;, more than 1000 &lt;code&gt;phone_numbers&lt;/code&gt; or
     * &lt;code&gt;campaign_call_names&lt;/code&gt;, a negative &lt;code&gt;min_attempts&lt;/code&gt;, an unknown enum value in
     * &lt;code&gt;states&lt;/code&gt; / &lt;code&gt;sources&lt;/code&gt;, &lt;code&gt;finish_time_min&lt;/code&gt; not before
     * &lt;code&gt;finish_time_max&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public void listCampaignCalls(ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCampaignCallsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts a &lt;code&gt;CAMPAIGN_STATE_CREATED&lt;/code&gt; campaign. Idempotent on a
     * &lt;code&gt;RUNNING&lt;/code&gt; campaign.&lt;/p&gt;
     * &lt;p&gt;A campaign with a &lt;code&gt;calling_window&lt;/code&gt; started outside every slot is &lt;code&gt;RUNNING&lt;/code&gt;
     * with &lt;code&gt;outside_calling_window = true&lt;/code&gt; and dials from the next slot on. Emits
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_STARTED&lt;/code&gt; (nothing on the idempotent repeat).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; in any other state (use
     * &lt;code&gt;ResumeCampaign&lt;/code&gt; for a stopped campaign); &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public void startCampaign(ondewo.vtsi.CampaignsOuterClass.StartCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartCampaignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a campaign gracefully: no new call is started, the calls that are running continue
     * until they end, then the campaign is &lt;code&gt;CAMPAIGN_STATE_STOPPED&lt;/code&gt;. Returns the campaign
     * in &lt;code&gt;STOPPING&lt;/code&gt; (or already &lt;code&gt;STOPPED&lt;/code&gt; when no call was running).
     * Idempotent on &lt;code&gt;STOPPING&lt;/code&gt;, &lt;code&gt;STOPPED&lt;/code&gt;, &lt;code&gt;HARD_STOPPING&lt;/code&gt; and
     * &lt;code&gt;HARD_STOPPED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; on a
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public void stopCampaign(ondewo.vtsi.CampaignsOuterClass.StopCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopCampaignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a campaign immediately: no new call is started and the server hangs up every running
     * call of the campaign right away. The campaign stays &lt;code&gt;CAMPAIGN_STATE_HARD_STOPPING&lt;/code&gt;
     * until the end of each of those calls is CONFIRMED (its call record is no longer active), then
     * becomes &lt;code&gt;CAMPAIGN_STATE_HARD_STOPPED&lt;/code&gt;; with a reachable call infrastructure this
     * takes seconds, scaled by the number of running calls. A hang-up that fails is repeated every
     * few seconds, and the campaign does not report &lt;code&gt;HARD_STOPPED&lt;/code&gt; while one of its calls
     * is still up. Calls ended this way are &lt;code&gt;CAMPAIGN_CALL_STATE_CANCELLED&lt;/code&gt;; a call that
     * finished on its own before the hard stop keeps its own outcome. Calls not started yet stay
     * &lt;code&gt;NOT_STARTED&lt;/code&gt; / &lt;code&gt;RETRY_PENDING&lt;/code&gt; and run after &lt;code&gt;ResumeCampaign&lt;/code&gt;.
     * Returns the campaign in &lt;code&gt;HARD_STOPPING&lt;/code&gt; (or already &lt;code&gt;HARD_STOPPED&lt;/code&gt;).
     * Idempotent on &lt;code&gt;HARD_STOPPING&lt;/code&gt; and &lt;code&gt;HARD_STOPPED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; on a
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public void hardStopCampaign(ondewo.vtsi.CampaignsOuterClass.HardStopCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHardStopCampaignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Resumes a &lt;code&gt;STOPPING&lt;/code&gt;, &lt;code&gt;STOPPED&lt;/code&gt; or &lt;code&gt;HARD_STOPPED&lt;/code&gt;
     * campaign: it becomes &lt;code&gt;RUNNING&lt;/code&gt; and continues with the calls that are not finished.
     * Idempotent on &lt;code&gt;RUNNING&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; on &lt;code&gt;CREATED&lt;/code&gt;
     * (use &lt;code&gt;StartCampaign&lt;/code&gt;), &lt;code&gt;HARD_STOPPING&lt;/code&gt; (wait until it is
     * &lt;code&gt;HARD_STOPPED&lt;/code&gt;) and &lt;code&gt;COMPLETED&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public void resumeCampaign(ondewo.vtsi.CampaignsOuterClass.ResumeCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResumeCampaignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the status and progress of the campaigns of a project. The first message is a
     * snapshot (&lt;code&gt;snapshot = true&lt;/code&gt;) of every matching campaign; every later message
     * carries only the campaigns (and, with &lt;code&gt;include_calls&lt;/code&gt;, the campaign calls) that
     * changed. Changes are polled every &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_POLL_INTERVAL_S&lt;/code&gt; (1 s by
     * default). An empty message is sent as a keep-alive when nothing changed for
     * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_KEEPALIVE_S&lt;/code&gt; (15 s by default).&lt;/p&gt;
     * &lt;p&gt;The stream ends when the client disconnects, or the server ends it with a last message carrying
     * &lt;code&gt;end_reason&lt;/code&gt; and &lt;code&gt;end_reason_type&lt;/code&gt;: at the maximum stream duration
     * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_DURATION_S&lt;/code&gt; (3600 s by default,
     * &lt;code&gt;STREAM_END_REASON_MAX_DURATION&lt;/code&gt;), when the server shuts down
     * (&lt;code&gt;STREAM_END_REASON_SERVER_SHUTDOWN&lt;/code&gt;) and when the project is deleted
     * (&lt;code&gt;STREAM_END_REASON_PROJECT_DELETED&lt;/code&gt;). Reconnect and treat the new snapshot as authoritative.
     * A client that blocks one send for longer than &lt;code&gt;ONDEWO_VTSI_STREAM_STALL_TIMEOUT_S&lt;/code&gt; (30 s by
     * default) is disconnected without a last message (the RPC ends &lt;code&gt;CANCELLED&lt;/code&gt;). While
     * authorization is enforced, the caller&amp;apos;s role is re-checked periodically; a revoked role ends the
     * RPC with &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, an expired credential with &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a
     * malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a malformed entry of &lt;code&gt;campaign_names&lt;/code&gt;, a campaign
     * name of another project, or an unknown value or &lt;code&gt;CAMPAIGN_STATE_UNSPECIFIED&lt;/code&gt; in
     * &lt;code&gt;states&lt;/code&gt; (a well-formed campaign name of the project that names no campaign is accepted and
     * matches nothing); &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the server has no free stream slot
     * (&lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_CONCURRENT&lt;/code&gt;, 16 per replica by default).&lt;/p&gt;
     * </pre>
     */
    public void streamCampaignStatus(ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamCampaignStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns one call of a campaign, with its current SIP status and, with
     * &lt;code&gt;include_attempts&lt;/code&gt;, its attempts. Read-only, no event.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;name&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign call
     * (also one deleted with its campaign); &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; / &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; as
     * for every RPC of this service.&lt;/p&gt;
     * </pre>
     */
    public void getCampaignCall(ondewo.vtsi.CampaignsOuterClass.GetCampaignCallRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.CampaignCall> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCampaignCallMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Cancels calls of a campaign that have not started an attempt that is still running: each selected
     * call in &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; or &lt;code&gt;CAMPAIGN_CALL_STATE_RETRY_PENDING&lt;/code&gt;
     * becomes &lt;code&gt;CAMPAIGN_CALL_STATE_CANCELLED&lt;/code&gt; (its &lt;code&gt;finish_time&lt;/code&gt; set, counted in
     * &lt;code&gt;CampaignStatistics.cancelled&lt;/code&gt;); the scheduled caller of a call added by
     * &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; is cancelled with it. Mirrors
     * &lt;code&gt;Calls.CancelScheduledCaller&lt;/code&gt;: a call whose attempt is &lt;code&gt;DISPATCHING&lt;/code&gt; or
     * &lt;code&gt;IN_PROGRESS&lt;/code&gt; is NOT cancelled (and its call is not hung up; use
     * &lt;code&gt;HardStopCampaign&lt;/code&gt; or &lt;code&gt;Calls.StopCall&lt;/code&gt;) and is reported in &lt;code&gt;refused&lt;/code&gt;,
     * like a call that is already finished; a refusal is not an error.&lt;/p&gt;
     * &lt;p&gt;Selection: &lt;code&gt;campaign_call_names&lt;/code&gt;, &lt;code&gt;states&lt;/code&gt;, or both (then a named call must
     * also be in one of the states). At most 1000 calls are acted on per request: with &lt;code&gt;states&lt;/code&gt;
     * the first 1000 matching calls by &lt;code&gt;position&lt;/code&gt;, and &lt;code&gt;remaining_count&lt;/code&gt; says how many
     * more match; repeat the request until it is 0. Each call is cancelled atomically on its own (the request
     * as a whole is not atomic); a call that a replica starts dispatching while the request runs is refused,
     * never cancelled half-way. Allowed in every campaign state. When it leaves a &lt;code&gt;RUNNING&lt;/code&gt;
     * campaign without an unfinished call, the campaign becomes &lt;code&gt;COMPLETED&lt;/code&gt; at the next engine
     * tick. Idempotent: a repeat refuses the calls it already cancelled with
     * &lt;code&gt;reason=already-finished&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_CALL_CANCELLED&lt;/code&gt; per cancelled call,
     * &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CANCELLED&lt;/code&gt; per cancelled scheduled caller, and the usual
     * throttled &lt;code&gt;VTSI_EVENT_CAMPAIGN_PROGRESS&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed selector (as &lt;code&gt;GetCampaign&lt;/code&gt;), neither
     * &lt;code&gt;campaign_call_names&lt;/code&gt; nor &lt;code&gt;states&lt;/code&gt; set, more than 1000 names, a malformed campaign
     * call name or one of another campaign, a state other than &lt;code&gt;NOT_STARTED&lt;/code&gt; /
     * &lt;code&gt;RETRY_PENDING&lt;/code&gt; in &lt;code&gt;states&lt;/code&gt;; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or
     * campaign (an unknown but well-formed campaign call name of the campaign is a refusal with
     * &lt;code&gt;reason=not-found&lt;/code&gt;, not an error).&lt;/p&gt;
     * </pre>
     */
    public void cancelCampaignCalls(ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelCampaignCallsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Puts FAILED or CANCELLED calls of a campaign back into the queue with a fresh attempt budget: each
     * selected call gets &lt;code&gt;additional_attempts&lt;/code&gt; more attempts on top of the attempts it already
     * made, and becomes &lt;code&gt;CAMPAIGN_CALL_STATE_RETRY_PENDING&lt;/code&gt; with &lt;code&gt;next_attempt_time&lt;/code&gt; =
     * the later of now and &lt;code&gt;not_before&lt;/code&gt; (or &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; when it
     * never made an attempt, e.g. a scheduled call cancelled before it fired). &lt;code&gt;finish_time&lt;/code&gt; and
     * &lt;code&gt;last_error&lt;/code&gt; are cleared; &lt;code&gt;attempt_history&lt;/code&gt; is kept and continues with the next
     * &lt;code&gt;attempt_number&lt;/code&gt;. The call keeps its &lt;code&gt;phone_number&lt;/code&gt; and its own configuration;
     * the campaign&amp;apos;s call defaults are read live at the next dispatch as for every attempt.&lt;/p&gt;
     * &lt;p&gt;A call added by &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; keeps following its scheduled caller,
     * which returns to &lt;code&gt;SCHEDULED&lt;/code&gt; with its scheduled time moved to the call&amp;apos;s
     * &lt;code&gt;next_attempt_time&lt;/code&gt; (&lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_UPDATED&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Effect on the campaign: a &lt;code&gt;COMPLETED&lt;/code&gt; campaign becomes &lt;code&gt;RUNNING&lt;/code&gt; again (as when
     * calls are added by a &lt;code&gt;CampaignAssignment&lt;/code&gt;); every other state is kept, so a stopped campaign
     * runs the calls after &lt;code&gt;ResumeCampaign&lt;/code&gt; and a &lt;code&gt;CREATED&lt;/code&gt; one after
     * &lt;code&gt;StartCampaign&lt;/code&gt;. The calls are dispatched under &lt;code&gt;max_parallel_calls&lt;/code&gt; and the
     * &lt;code&gt;calling_window&lt;/code&gt; like any other.&lt;/p&gt;
     * &lt;p&gt;Selection exactly as &lt;code&gt;CancelCampaignCalls&lt;/code&gt; (names, states or both; at most 1000 calls per
     * request, &lt;code&gt;remaining_count&lt;/code&gt;); a selected call that is not &lt;code&gt;FAILED&lt;/code&gt; or
     * &lt;code&gt;CANCELLED&lt;/code&gt; is reported in &lt;code&gt;refused&lt;/code&gt;. A failure that cannot succeed by repetition
     * (e.g. a rejected credential) is retried too: fix its cause first, otherwise the campaign may be
     * auto-stopped again. Not idempotent: each request adds a new budget to the calls it requeues, but a
     * repeat finds them &lt;code&gt;RETRY_PENDING&lt;/code&gt; / &lt;code&gt;NOT_STARTED&lt;/code&gt; and refuses them.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_CALL_REQUEUED&lt;/code&gt; per requeued call (attributes
     * &lt;code&gt;attempt_limit&lt;/code&gt;, &lt;code&gt;next_attempt_time&lt;/code&gt;), &lt;code&gt;VTSI_EVENT_CAMPAIGN_RESUMED&lt;/code&gt;
     * when a &lt;code&gt;COMPLETED&lt;/code&gt; campaign became &lt;code&gt;RUNNING&lt;/code&gt;, and the throttled
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_PROGRESS&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; as &lt;code&gt;CancelCampaignCalls&lt;/code&gt;, except that
     * &lt;code&gt;states&lt;/code&gt; may only hold &lt;code&gt;FAILED&lt;/code&gt; / &lt;code&gt;CANCELLED&lt;/code&gt;, plus
     * &lt;code&gt;additional_attempts&lt;/code&gt; outside 0 to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_ATTEMPTS_LIMIT&lt;/code&gt; (10)
     * and &lt;code&gt;not_before&lt;/code&gt; more than 7 days ahead; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or
     * campaign; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the campaign is &lt;code&gt;HARD_STOPPING&lt;/code&gt; (wait until it
     * is &lt;code&gt;HARD_STOPPED&lt;/code&gt;).&lt;/p&gt;
     * </pre>
     */
    public void retryCampaignCalls(ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetryCampaignCallsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a new campaign in the same project as a copy of an existing one, server side, so the
     * stored credentials of its call defaults are preserved without ever being returned to the client (a
     * Get-then-Create round trip would copy the REDACTED defaults). Copied: &lt;code&gt;max_parallel_calls&lt;/code&gt;,
     * &lt;code&gt;max_attempts&lt;/code&gt;, &lt;code&gt;retry_delay&lt;/code&gt;, &lt;code&gt;campaign_common_services_config&lt;/code&gt;,
     * &lt;code&gt;campaign_sip_caller_config&lt;/code&gt; and &lt;code&gt;calling_window&lt;/code&gt;. Not copied: the state (the
     * clone is &lt;code&gt;CAMPAIGN_STATE_CREATED&lt;/code&gt;), statistics, callers and every other output-only
     * field.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;include_calls&lt;/code&gt;, the source&amp;apos;s calls whose state is in &lt;code&gt;call_states&lt;/code&gt;
     * (empty: every state) are copied as new &lt;code&gt;NOT_STARTED&lt;/code&gt; calls in their original order
     * (&lt;code&gt;position&lt;/code&gt; renumbered from 1), each with its own stored configuration and its fixed
     * &lt;code&gt;phone_number&lt;/code&gt;, no attempt and no history. A copied call that was added by
     * &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; gets a new scheduled caller with the same scheduled time
     * (a time in the past is due as soon as the clone runs). The whole clone is atomic: the campaign and every
     * copied call (and scheduled caller) are stored, or nothing is. The source is read in one consistent
     * snapshot and is not changed.&lt;/p&gt;
     * &lt;p&gt;With an &lt;code&gt;idempotency_key&lt;/code&gt;, a retry of the same request returns the first attempt&amp;apos;s
     * clone (see &lt;code&gt;CreateCampaignRequest.idempotency_key&lt;/code&gt;). Emits
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_CREATED&lt;/code&gt; for the clone with the attributes &lt;code&gt;cloned_from&lt;/code&gt;
     * (the source&amp;apos;s resource name) and &lt;code&gt;copied_call_count&lt;/code&gt;, and, when calls were copied,
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_CALLS_ADDED&lt;/code&gt; and one &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CREATED&lt;/code&gt; per
     * new scheduled caller.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed source selector (as &lt;code&gt;GetCampaign&lt;/code&gt;),
     * a &lt;code&gt;new_display_name&lt;/code&gt; over 128 characters, &lt;code&gt;call_states&lt;/code&gt; without
     * &lt;code&gt;include_calls&lt;/code&gt; or holding an unknown value, a malformed or reused
     * &lt;code&gt;idempotency_key&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an
     * unknown project or source campaign; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when &lt;code&gt;new_display_name&lt;/code&gt; is used
     * in the project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the copied calls would exceed
     * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_CALLS&lt;/code&gt;; &lt;code&gt;ABORTED&lt;/code&gt; while a first attempt with the same
     * &lt;code&gt;idempotency_key&lt;/code&gt; is still running.&lt;/p&gt;
     * </pre>
     */
    public void cloneCampaign(ondewo.vtsi.CampaignsOuterClass.CloneCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloneCampaignMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Campaigns.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the CAMPAIGNS of a VTSI project. A campaign is a named set of outbound calls that VTSI
   * places for the client while keeping at most &lt;code&gt;max_parallel_calls&lt;/code&gt; of them running at
   * the same time. If 100 callers are added to a campaign with &lt;code&gt;max_parallel_calls = 10&lt;/code&gt;,
   * at any moment at most 10 of those calls are being set up or are connected; the next one starts
   * when one ends.&lt;/p&gt;
   * &lt;p&gt;Calls are added to a campaign with
   * &lt;a href="index.html#ondewo.vtsi.Calls.AddCallersToCampaign"&gt;Calls.AddCallersToCampaign&lt;/a&gt; or
   * &lt;a href="index.html#ondewo.vtsi.Calls.AddScheduledCallersToCampaign"&gt;Calls.AddScheduledCallersToCampaign&lt;/a&gt;
   * (a server that predates them answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; and starts nothing); a scheduled call of a campaign is started at or after its scheduled time AND when the campaign has
   * a free slot.&lt;/p&gt;
   * &lt;p&gt;A call that fails is retried up to &lt;code&gt;max_attempts&lt;/code&gt; times in total, waiting
   * &lt;code&gt;retry_delay&lt;/code&gt; between attempts. A call counts as failed only after its last attempt.
   * A failure that cannot succeed by repetition (for example a rejected credential, an invalid
   * configuration) is never retried.&lt;/p&gt;
   * &lt;p&gt;Lifecycle: &lt;code&gt;StartCampaign&lt;/code&gt; starts a created campaign; &lt;code&gt;StopCampaign&lt;/code&gt; lets
   * the ongoing calls finish and starts no new ones; &lt;code&gt;HardStopCampaign&lt;/code&gt; ends the ongoing
   * calls immediately and starts no new ones; &lt;code&gt;ResumeCampaign&lt;/code&gt; continues a stopped or hard
   * stopped campaign with the calls that have not finished yet.&lt;/p&gt;
   * &lt;p&gt;Every RPC about ONE campaign accepts either its resource name or its display name. Display names
   * are unique within a project, so a display name is resolved within the project named by the
   * request&amp;apos;s top-level &lt;code&gt;vtsi_project_name&lt;/code&gt;, which is REQUIRED with a display name
   * (&lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; when it is empty or malformed) and checked against the campaign
   * when a resource name is used. (The &lt;code&gt;CampaignDisplayName&lt;/code&gt; message of 9.0.0, which
   * carried the project and the display name together, was removed in 9.1.0; its field numbers are
   * &lt;code&gt;reserved&lt;/code&gt;.)&lt;/p&gt;
   * &lt;p&gt;A malformed selector is &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for every authenticated caller, with or
   * without authorization enforced (also when authorization could resolve no project from it): neither
   * the resource name nor the display name set (also how an old 9.0.0 client&amp;apos;s removed
   * &lt;code&gt;CampaignDisplayName&lt;/code&gt; arrives), a malformed resource name, a display name with an empty
   * or malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, and a &lt;code&gt;vtsi_project_name&lt;/code&gt; that is not the
   * project of the resource name. With authorization enforced, a well-formed request naming a project
   * the caller holds no role on (an unknown project included) is refused with
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; before any lookup, so it is not answered &lt;code&gt;NOT_FOUND&lt;/code&gt;, and
   * a caller without a credential is &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; whatever it sent.&lt;/p&gt;
   * &lt;p&gt;Campaign-level call defaults: &lt;code&gt;campaign_common_services_config&lt;/code&gt; and
   * &lt;code&gt;campaign_sip_caller_config&lt;/code&gt; of a &lt;code&gt;Campaign&lt;/code&gt; are the defaults of EVERY call of
   * the campaign. They are read LIVE when a campaign call is dispatched (every attempt, retries
   * included): the effective configuration of the call is a copy of the campaign&amp;apos;s config with the
   * call&amp;apos;s own &lt;code&gt;StartCallerRequest&lt;/code&gt; config merged over it (protobuf
   * &lt;code&gt;MergeFrom&lt;/code&gt;), see &lt;a href="index.html#ondewo.vtsi.Campaign"&gt;Campaign&lt;/a&gt;. The one exception
   * is the callee: &lt;code&gt;campaign_sip_caller_config.callee_id&lt;/code&gt; is resolved and FIXED when a call is
   * added (it is that call&amp;apos;s &lt;code&gt;CampaignCall.phone_number&lt;/code&gt;), so every attempt of a call dials the
   * number its campaign call reports.&lt;/p&gt;
   * &lt;p&gt;Partial responses: &lt;code&gt;ListCampaigns&lt;/code&gt;, &lt;code&gt;ListCampaignCalls&lt;/code&gt;,
   * &lt;code&gt;CreateCampaign&lt;/code&gt;, &lt;code&gt;GetCampaign&lt;/code&gt;, &lt;code&gt;UpdateCampaign&lt;/code&gt;,
   * &lt;code&gt;DeleteCampaign&lt;/code&gt; (paths of &lt;code&gt;DeleteCampaignResponse&lt;/code&gt;), the four lifecycle RPCs
   * &lt;code&gt;StartCampaign&lt;/code&gt;, &lt;code&gt;StopCampaign&lt;/code&gt;, &lt;code&gt;HardStopCampaign&lt;/code&gt; and
   * &lt;code&gt;ResumeCampaign&lt;/code&gt;, &lt;code&gt;CloneCampaign&lt;/code&gt; and &lt;code&gt;GetCampaignCall&lt;/code&gt; accept an optional
   * &lt;code&gt;field_mask&lt;/code&gt; naming the field paths of the returned resource (for a listing: of each listed
   * element) to populate. A mask never changes what the RPC does. Unset or empty returns every
   * field (one exception: &lt;code&gt;ListCampaigns&lt;/code&gt; returns &lt;code&gt;campaign_callers&lt;/code&gt; and
   * &lt;code&gt;campaign_callers_truncated&lt;/code&gt; only when its mask names them); the identifying &lt;code&gt;name&lt;/code&gt; is always populated; an unknown path is rejected with
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; naming it; nested paths through singular message fields (e.g.
   * &lt;code&gt;statistics.completed&lt;/code&gt;) are allowed, a path below a repeated or map field is not. The
   * mask is applied after any role-based redaction, so it can only narrow what the caller may see.&lt;/p&gt;
   * &lt;p&gt;Callers and calls of a campaign: &lt;code&gt;Campaign.campaign_callers&lt;/code&gt; names the callers that placed
   * its calls (bounded); &lt;code&gt;Calls.ListCallers&lt;/code&gt; with &lt;code&gt;ListCallersRequest.campaign_name&lt;/code&gt; /
   * &lt;code&gt;campaign_display_name&lt;/code&gt; lists them paginated as &lt;code&gt;Caller&lt;/code&gt; resources, and
   * &lt;code&gt;Calls.ListCalls&lt;/code&gt; with &lt;code&gt;CallFilter.campaign_name&lt;/code&gt; /
   * &lt;code&gt;campaign_display_name&lt;/code&gt; lists the calls they placed as &lt;code&gt;Call&lt;/code&gt; resources.&lt;/p&gt;
   * &lt;p&gt;Calling window: a campaign with a &lt;code&gt;calling_window&lt;/code&gt; starts calls (first attempts, retries and
   * due scheduled calls alike) only inside one of the window&amp;apos;s weekly slots, in the window&amp;apos;s time zone.
   * Outside every slot it stays &lt;code&gt;RUNNING&lt;/code&gt; and reports &lt;code&gt;outside_calling_window = true&lt;/code&gt;; calls
   * already running are never ended by a slot ending. See
   * &lt;a href="index.html#ondewo.vtsi.CampaignCallingWindow"&gt;CampaignCallingWindow&lt;/a&gt;.&lt;/p&gt;
   * &lt;p&gt;Limits and defaults of the server (environment variables of ondewo-vtsi, read at start-up): at most
   * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_CALLS&lt;/code&gt; (100000) calls per campaign; &lt;code&gt;max_parallel_calls&lt;/code&gt;
   * defaults to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_DEFAULT_MAX_PARALLEL_CALLS&lt;/code&gt; (1) and is at most
   * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_PARALLEL_CALLS_LIMIT&lt;/code&gt; (1000); &lt;code&gt;max_attempts&lt;/code&gt; defaults to 1
   * and is at most &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_ATTEMPTS_LIMIT&lt;/code&gt; (10); &lt;code&gt;retry_delay&lt;/code&gt; defaults
   * to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_DEFAULT_RETRY_DELAY_S&lt;/code&gt; (60 s); one &lt;code&gt;AddCallersToCampaign&lt;/code&gt; /
   * &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; request carries at most 1000 entries (a fixed server limit,
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; above it); &lt;code&gt;CancelCampaignCalls&lt;/code&gt; and &lt;code&gt;RetryCampaignCalls&lt;/code&gt;
   * act on at most 1000 calls per request. The status stream is bounded by
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_DURATION_S&lt;/code&gt; (3600 s), sends a keep-alive after
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_KEEPALIVE_S&lt;/code&gt; (15 s) without a change and at most
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_CONCURRENT&lt;/code&gt; (16) status streams are open per server replica.&lt;/p&gt;
   * &lt;p&gt;Authorization (when enforced): every RPC of this service needs &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or a
   * higher role (&lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt;, &lt;code&gt;PROJECT_ADMIN&lt;/code&gt;) on the campaign&amp;apos;s project, or
   * &lt;code&gt;SERVER_ADMIN&lt;/code&gt;; credential-bearing call defaults are returned only to the roles named at
   * &lt;code&gt;Campaign.campaign_common_services_config&lt;/code&gt;.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, field mask or value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign
   * call (with authorization enforced: &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; for a project the caller holds
   * no role on, or a role below &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;); &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; for a request
   * without a valid credential while authorization is enforced; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a
   * &lt;code&gt;display_name&lt;/code&gt; already used in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a state that does not allow the operation (each RPC names its
   * cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change won, nothing was stored and the request can
   * be retried; &lt;code&gt;DEADLINE_EXCEEDED&lt;/code&gt; for a forced &lt;code&gt;DeleteCampaign&lt;/code&gt; whose hang-ups were not
   * confirmed in time (the hard stop stays in effect, retry the request); &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when
   * the server has no free stream slot.&lt;/p&gt;
   * </pre>
   */
  public static final class CampaignsBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CampaignsBlockingV2Stub> {
    private CampaignsBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CampaignsBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CampaignsBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a campaign in state &lt;code&gt;CAMPAIGN_STATE_CREATED&lt;/code&gt;. Calls are added with
     * &lt;code&gt;AddCallersToCampaign&lt;/code&gt; / &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt;; nothing is dialled before
     * &lt;code&gt;StartCampaign&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;With an &lt;code&gt;idempotency_key&lt;/code&gt;, a retry of the same request returns the first attempt&amp;apos;s
     * campaign instead of creating a second one (see &lt;code&gt;CreateCampaignRequest.idempotency_key&lt;/code&gt;).
     * Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_CREATED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; if
     * the &lt;code&gt;display_name&lt;/code&gt; is used in the project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed
     * &lt;code&gt;vtsi_project_name&lt;/code&gt;, an output-only field that was set, an out-of-range value, an invalid
     * &lt;code&gt;calling_window&lt;/code&gt;, a malformed &lt;code&gt;idempotency_key&lt;/code&gt;, an &lt;code&gt;idempotency_key&lt;/code&gt;
     * reused with a different request or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;ABORTED&lt;/code&gt; while
     * a first attempt with the same &lt;code&gt;idempotency_key&lt;/code&gt; is still running.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign createCampaign(ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a campaign including its statistics, its call defaults and its callers
     * (&lt;code&gt;campaign_callers&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign getCampaign(ondewo.vtsi.CampaignsOuterClass.GetCampaignRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;max_parallel_calls&lt;/code&gt;, &lt;code&gt;max_attempts&lt;/code&gt;, &lt;code&gt;retry_delay&lt;/code&gt;,
     * &lt;code&gt;campaign_common_services_config&lt;/code&gt;, &lt;code&gt;campaign_sip_caller_config&lt;/code&gt; and
     * &lt;code&gt;calling_window&lt;/code&gt; (each also by a nested sub-path). Allowed in every state. A changed
     * &lt;code&gt;calling_window&lt;/code&gt; applies from the next dispatch decision (within about one second); it never
     * ends a running call. Lowering &lt;code&gt;max_parallel_calls&lt;/code&gt;
     * never ends a running call: the campaign starts no new call until fewer than the new maximum are
     * running. A changed call default applies to every campaign call dispatched after the update,
     * retries included; a call already dispatched keeps the configuration it was started with. The
     * exception is &lt;code&gt;campaign_sip_caller_config.callee_id&lt;/code&gt;, which is fixed per call when the call
     * is added and therefore applies only to calls added after the update.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_UPDATED&lt;/code&gt; (attribute &lt;code&gt;updated_fields&lt;/code&gt;) and, when
     * &lt;code&gt;max_parallel_calls&lt;/code&gt; changed, &lt;code&gt;VTSI_EVENT_CAMPAIGN_MAX_PARALLEL_CALLS_CHANGED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty mask, an unknown,
     * output-only or immutable path, an out-of-range value, an invalid &lt;code&gt;calling_window&lt;/code&gt; or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a
     * &lt;code&gt;display_name&lt;/code&gt; used by another campaign of the project; &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent
     * update of the same campaign won (nothing was written; retry).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign updateCampaign(ondewo.vtsi.CampaignsOuterClass.UpdateCampaignRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a campaign and its campaign calls. Its scheduled callers that have not fired yet are
     * cancelled. Calls that already ran are not touched and stay visible through
     * &lt;code&gt;ListCalls&lt;/code&gt;, but no longer as calls OF the campaign: the attempt history that linked them
     * to it is deleted with it, so &lt;code&gt;ListCalls&lt;/code&gt; with &lt;code&gt;CallFilter.campaign_name&lt;/code&gt; /
     * &lt;code&gt;campaign_display_name&lt;/code&gt; of a deleted campaign answers &lt;code&gt;NOT_FOUND&lt;/code&gt; (list them by
     * caller or without the campaign selector), and &lt;code&gt;Calls.ListCallers&lt;/code&gt; with the campaign selector
     * likewise.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;force&lt;/code&gt;, a campaign that is &lt;code&gt;RUNNING&lt;/code&gt;, &lt;code&gt;STOPPING&lt;/code&gt; or
     * &lt;code&gt;HARD_STOPPING&lt;/code&gt; is hard stopped first (exactly as by &lt;code&gt;HardStopCampaign&lt;/code&gt;) and deleted
     * as soon as the end of each of its calls is confirmed. The RPC waits for that, at most
     * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_FORCE_DELETE_WAIT_S&lt;/code&gt; (30 s by default) and never past the client&amp;apos;s
     * deadline; when the hang-ups are not confirmed by then it answers &lt;code&gt;DEADLINE_EXCEEDED&lt;/code&gt;, the
     * campaign stays &lt;code&gt;HARD_STOPPING&lt;/code&gt; (then &lt;code&gt;HARD_STOPPED&lt;/code&gt;) and is NOT deleted: repeat the
     * request. Idempotent: a repeated forced delete of a campaign that is still hard stopping waits again.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_DELETED&lt;/code&gt; (preceded, with &lt;code&gt;force&lt;/code&gt; on a running
     * campaign, by &lt;code&gt;VTSI_EVENT_CAMPAIGN_HARD_STOP_REQUESTED&lt;/code&gt; and
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_HARD_STOPPED&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; without &lt;code&gt;force&lt;/code&gt; while
     * the campaign is &lt;code&gt;RUNNING&lt;/code&gt;, &lt;code&gt;STOPPING&lt;/code&gt; or &lt;code&gt;HARD_STOPPING&lt;/code&gt; (stop or hard
     * stop it first, or set &lt;code&gt;force&lt;/code&gt;); &lt;code&gt;DEADLINE_EXCEEDED&lt;/code&gt; with &lt;code&gt;force&lt;/code&gt; as
     * described above; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, a &lt;code&gt;display_name&lt;/code&gt; without
     * &lt;code&gt;vtsi_project_name&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse deleteCampaign(ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the campaigns of a project, filtered, ordered by &lt;code&gt;ListCampaignsRequest.order_by&lt;/code&gt;
     * (newest first by default) and paged, each with its
     * statistics. &lt;code&gt;campaign_callers&lt;/code&gt; and &lt;code&gt;campaign_callers_truncated&lt;/code&gt; are left empty
     * unless &lt;code&gt;field_mask&lt;/code&gt; names them, and a page that carries them holds at most 20 campaigns (see
     * &lt;code&gt;ListCampaignsRequest.field_mask&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a negative &lt;code&gt;page_size&lt;/code&gt;, a foreign
     * &lt;code&gt;page_token&lt;/code&gt; (also one issued for another filter or &lt;code&gt;order_by&lt;/code&gt;), an unknown
     * &lt;code&gt;order_by&lt;/code&gt; or &lt;code&gt;states&lt;/code&gt; value, &lt;code&gt;created_after&lt;/code&gt; not before
     * &lt;code&gt;created_before&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.ListCampaignsResponse listCampaigns(ondewo.vtsi.CampaignsOuterClass.ListCampaignsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListCampaignsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns the progress of a campaign: how many of its calls are not started, in progress,
     * waiting for a retry, completed, failed and cancelled, and how many attempts were made.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.CampaignStatistics getCampaignStatistics(ondewo.vtsi.CampaignsOuterClass.GetCampaignStatisticsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetCampaignStatisticsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the calls of a campaign in the order they were added, filtered and paged, each with
     * its current SIP status, the SIP status description and its attempts.&lt;/p&gt;
     * &lt;p&gt;The filters of &lt;code&gt;ListCampaignCallsRequest&lt;/code&gt; are combined by AND; the values of one
     * repeated filter by OR.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a foreign &lt;code&gt;page_token&lt;/code&gt; (also one issued for another filter), a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt;, a malformed campaign call name or one
     * of another campaign in &lt;code&gt;campaign_call_names&lt;/code&gt;, more than 1000 &lt;code&gt;phone_numbers&lt;/code&gt; or
     * &lt;code&gt;campaign_call_names&lt;/code&gt;, a negative &lt;code&gt;min_attempts&lt;/code&gt;, an unknown enum value in
     * &lt;code&gt;states&lt;/code&gt; / &lt;code&gt;sources&lt;/code&gt;, &lt;code&gt;finish_time_min&lt;/code&gt; not before
     * &lt;code&gt;finish_time_max&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsResponse listCampaignCalls(ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListCampaignCallsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts a &lt;code&gt;CAMPAIGN_STATE_CREATED&lt;/code&gt; campaign. Idempotent on a
     * &lt;code&gt;RUNNING&lt;/code&gt; campaign.&lt;/p&gt;
     * &lt;p&gt;A campaign with a &lt;code&gt;calling_window&lt;/code&gt; started outside every slot is &lt;code&gt;RUNNING&lt;/code&gt;
     * with &lt;code&gt;outside_calling_window = true&lt;/code&gt; and dials from the next slot on. Emits
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_STARTED&lt;/code&gt; (nothing on the idempotent repeat).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; in any other state (use
     * &lt;code&gt;ResumeCampaign&lt;/code&gt; for a stopped campaign); &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign startCampaign(ondewo.vtsi.CampaignsOuterClass.StartCampaignRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStartCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a campaign gracefully: no new call is started, the calls that are running continue
     * until they end, then the campaign is &lt;code&gt;CAMPAIGN_STATE_STOPPED&lt;/code&gt;. Returns the campaign
     * in &lt;code&gt;STOPPING&lt;/code&gt; (or already &lt;code&gt;STOPPED&lt;/code&gt; when no call was running).
     * Idempotent on &lt;code&gt;STOPPING&lt;/code&gt;, &lt;code&gt;STOPPED&lt;/code&gt;, &lt;code&gt;HARD_STOPPING&lt;/code&gt; and
     * &lt;code&gt;HARD_STOPPED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; on a
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign stopCampaign(ondewo.vtsi.CampaignsOuterClass.StopCampaignRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStopCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a campaign immediately: no new call is started and the server hangs up every running
     * call of the campaign right away. The campaign stays &lt;code&gt;CAMPAIGN_STATE_HARD_STOPPING&lt;/code&gt;
     * until the end of each of those calls is CONFIRMED (its call record is no longer active), then
     * becomes &lt;code&gt;CAMPAIGN_STATE_HARD_STOPPED&lt;/code&gt;; with a reachable call infrastructure this
     * takes seconds, scaled by the number of running calls. A hang-up that fails is repeated every
     * few seconds, and the campaign does not report &lt;code&gt;HARD_STOPPED&lt;/code&gt; while one of its calls
     * is still up. Calls ended this way are &lt;code&gt;CAMPAIGN_CALL_STATE_CANCELLED&lt;/code&gt;; a call that
     * finished on its own before the hard stop keeps its own outcome. Calls not started yet stay
     * &lt;code&gt;NOT_STARTED&lt;/code&gt; / &lt;code&gt;RETRY_PENDING&lt;/code&gt; and run after &lt;code&gt;ResumeCampaign&lt;/code&gt;.
     * Returns the campaign in &lt;code&gt;HARD_STOPPING&lt;/code&gt; (or already &lt;code&gt;HARD_STOPPED&lt;/code&gt;).
     * Idempotent on &lt;code&gt;HARD_STOPPING&lt;/code&gt; and &lt;code&gt;HARD_STOPPED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; on a
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign hardStopCampaign(ondewo.vtsi.CampaignsOuterClass.HardStopCampaignRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getHardStopCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Resumes a &lt;code&gt;STOPPING&lt;/code&gt;, &lt;code&gt;STOPPED&lt;/code&gt; or &lt;code&gt;HARD_STOPPED&lt;/code&gt;
     * campaign: it becomes &lt;code&gt;RUNNING&lt;/code&gt; and continues with the calls that are not finished.
     * Idempotent on &lt;code&gt;RUNNING&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; on &lt;code&gt;CREATED&lt;/code&gt;
     * (use &lt;code&gt;StartCampaign&lt;/code&gt;), &lt;code&gt;HARD_STOPPING&lt;/code&gt; (wait until it is
     * &lt;code&gt;HARD_STOPPED&lt;/code&gt;) and &lt;code&gt;COMPLETED&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign resumeCampaign(ondewo.vtsi.CampaignsOuterClass.ResumeCampaignRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getResumeCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the status and progress of the campaigns of a project. The first message is a
     * snapshot (&lt;code&gt;snapshot = true&lt;/code&gt;) of every matching campaign; every later message
     * carries only the campaigns (and, with &lt;code&gt;include_calls&lt;/code&gt;, the campaign calls) that
     * changed. Changes are polled every &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_POLL_INTERVAL_S&lt;/code&gt; (1 s by
     * default). An empty message is sent as a keep-alive when nothing changed for
     * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_KEEPALIVE_S&lt;/code&gt; (15 s by default).&lt;/p&gt;
     * &lt;p&gt;The stream ends when the client disconnects, or the server ends it with a last message carrying
     * &lt;code&gt;end_reason&lt;/code&gt; and &lt;code&gt;end_reason_type&lt;/code&gt;: at the maximum stream duration
     * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_DURATION_S&lt;/code&gt; (3600 s by default,
     * &lt;code&gt;STREAM_END_REASON_MAX_DURATION&lt;/code&gt;), when the server shuts down
     * (&lt;code&gt;STREAM_END_REASON_SERVER_SHUTDOWN&lt;/code&gt;) and when the project is deleted
     * (&lt;code&gt;STREAM_END_REASON_PROJECT_DELETED&lt;/code&gt;). Reconnect and treat the new snapshot as authoritative.
     * A client that blocks one send for longer than &lt;code&gt;ONDEWO_VTSI_STREAM_STALL_TIMEOUT_S&lt;/code&gt; (30 s by
     * default) is disconnected without a last message (the RPC ends &lt;code&gt;CANCELLED&lt;/code&gt;). While
     * authorization is enforced, the caller&amp;apos;s role is re-checked periodically; a revoked role ends the
     * RPC with &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, an expired credential with &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a
     * malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a malformed entry of &lt;code&gt;campaign_names&lt;/code&gt;, a campaign
     * name of another project, or an unknown value or &lt;code&gt;CAMPAIGN_STATE_UNSPECIFIED&lt;/code&gt; in
     * &lt;code&gt;states&lt;/code&gt; (a well-formed campaign name of the project that names no campaign is accepted and
     * matches nothing); &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the server has no free stream slot
     * (&lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_CONCURRENT&lt;/code&gt;, 16 per replica by default).&lt;/p&gt;
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusResponse>
        streamCampaignStatus(ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getStreamCampaignStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns one call of a campaign, with its current SIP status and, with
     * &lt;code&gt;include_attempts&lt;/code&gt;, its attempts. Read-only, no event.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;name&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign call
     * (also one deleted with its campaign); &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; / &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; as
     * for every RPC of this service.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.CampaignCall getCampaignCall(ondewo.vtsi.CampaignsOuterClass.GetCampaignCallRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetCampaignCallMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Cancels calls of a campaign that have not started an attempt that is still running: each selected
     * call in &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; or &lt;code&gt;CAMPAIGN_CALL_STATE_RETRY_PENDING&lt;/code&gt;
     * becomes &lt;code&gt;CAMPAIGN_CALL_STATE_CANCELLED&lt;/code&gt; (its &lt;code&gt;finish_time&lt;/code&gt; set, counted in
     * &lt;code&gt;CampaignStatistics.cancelled&lt;/code&gt;); the scheduled caller of a call added by
     * &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; is cancelled with it. Mirrors
     * &lt;code&gt;Calls.CancelScheduledCaller&lt;/code&gt;: a call whose attempt is &lt;code&gt;DISPATCHING&lt;/code&gt; or
     * &lt;code&gt;IN_PROGRESS&lt;/code&gt; is NOT cancelled (and its call is not hung up; use
     * &lt;code&gt;HardStopCampaign&lt;/code&gt; or &lt;code&gt;Calls.StopCall&lt;/code&gt;) and is reported in &lt;code&gt;refused&lt;/code&gt;,
     * like a call that is already finished; a refusal is not an error.&lt;/p&gt;
     * &lt;p&gt;Selection: &lt;code&gt;campaign_call_names&lt;/code&gt;, &lt;code&gt;states&lt;/code&gt;, or both (then a named call must
     * also be in one of the states). At most 1000 calls are acted on per request: with &lt;code&gt;states&lt;/code&gt;
     * the first 1000 matching calls by &lt;code&gt;position&lt;/code&gt;, and &lt;code&gt;remaining_count&lt;/code&gt; says how many
     * more match; repeat the request until it is 0. Each call is cancelled atomically on its own (the request
     * as a whole is not atomic); a call that a replica starts dispatching while the request runs is refused,
     * never cancelled half-way. Allowed in every campaign state. When it leaves a &lt;code&gt;RUNNING&lt;/code&gt;
     * campaign without an unfinished call, the campaign becomes &lt;code&gt;COMPLETED&lt;/code&gt; at the next engine
     * tick. Idempotent: a repeat refuses the calls it already cancelled with
     * &lt;code&gt;reason=already-finished&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_CALL_CANCELLED&lt;/code&gt; per cancelled call,
     * &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CANCELLED&lt;/code&gt; per cancelled scheduled caller, and the usual
     * throttled &lt;code&gt;VTSI_EVENT_CAMPAIGN_PROGRESS&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed selector (as &lt;code&gt;GetCampaign&lt;/code&gt;), neither
     * &lt;code&gt;campaign_call_names&lt;/code&gt; nor &lt;code&gt;states&lt;/code&gt; set, more than 1000 names, a malformed campaign
     * call name or one of another campaign, a state other than &lt;code&gt;NOT_STARTED&lt;/code&gt; /
     * &lt;code&gt;RETRY_PENDING&lt;/code&gt; in &lt;code&gt;states&lt;/code&gt;; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or
     * campaign (an unknown but well-formed campaign call name of the campaign is a refusal with
     * &lt;code&gt;reason=not-found&lt;/code&gt;, not an error).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsResponse cancelCampaignCalls(ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCancelCampaignCallsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Puts FAILED or CANCELLED calls of a campaign back into the queue with a fresh attempt budget: each
     * selected call gets &lt;code&gt;additional_attempts&lt;/code&gt; more attempts on top of the attempts it already
     * made, and becomes &lt;code&gt;CAMPAIGN_CALL_STATE_RETRY_PENDING&lt;/code&gt; with &lt;code&gt;next_attempt_time&lt;/code&gt; =
     * the later of now and &lt;code&gt;not_before&lt;/code&gt; (or &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; when it
     * never made an attempt, e.g. a scheduled call cancelled before it fired). &lt;code&gt;finish_time&lt;/code&gt; and
     * &lt;code&gt;last_error&lt;/code&gt; are cleared; &lt;code&gt;attempt_history&lt;/code&gt; is kept and continues with the next
     * &lt;code&gt;attempt_number&lt;/code&gt;. The call keeps its &lt;code&gt;phone_number&lt;/code&gt; and its own configuration;
     * the campaign&amp;apos;s call defaults are read live at the next dispatch as for every attempt.&lt;/p&gt;
     * &lt;p&gt;A call added by &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; keeps following its scheduled caller,
     * which returns to &lt;code&gt;SCHEDULED&lt;/code&gt; with its scheduled time moved to the call&amp;apos;s
     * &lt;code&gt;next_attempt_time&lt;/code&gt; (&lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_UPDATED&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Effect on the campaign: a &lt;code&gt;COMPLETED&lt;/code&gt; campaign becomes &lt;code&gt;RUNNING&lt;/code&gt; again (as when
     * calls are added by a &lt;code&gt;CampaignAssignment&lt;/code&gt;); every other state is kept, so a stopped campaign
     * runs the calls after &lt;code&gt;ResumeCampaign&lt;/code&gt; and a &lt;code&gt;CREATED&lt;/code&gt; one after
     * &lt;code&gt;StartCampaign&lt;/code&gt;. The calls are dispatched under &lt;code&gt;max_parallel_calls&lt;/code&gt; and the
     * &lt;code&gt;calling_window&lt;/code&gt; like any other.&lt;/p&gt;
     * &lt;p&gt;Selection exactly as &lt;code&gt;CancelCampaignCalls&lt;/code&gt; (names, states or both; at most 1000 calls per
     * request, &lt;code&gt;remaining_count&lt;/code&gt;); a selected call that is not &lt;code&gt;FAILED&lt;/code&gt; or
     * &lt;code&gt;CANCELLED&lt;/code&gt; is reported in &lt;code&gt;refused&lt;/code&gt;. A failure that cannot succeed by repetition
     * (e.g. a rejected credential) is retried too: fix its cause first, otherwise the campaign may be
     * auto-stopped again. Not idempotent: each request adds a new budget to the calls it requeues, but a
     * repeat finds them &lt;code&gt;RETRY_PENDING&lt;/code&gt; / &lt;code&gt;NOT_STARTED&lt;/code&gt; and refuses them.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_CALL_REQUEUED&lt;/code&gt; per requeued call (attributes
     * &lt;code&gt;attempt_limit&lt;/code&gt;, &lt;code&gt;next_attempt_time&lt;/code&gt;), &lt;code&gt;VTSI_EVENT_CAMPAIGN_RESUMED&lt;/code&gt;
     * when a &lt;code&gt;COMPLETED&lt;/code&gt; campaign became &lt;code&gt;RUNNING&lt;/code&gt;, and the throttled
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_PROGRESS&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; as &lt;code&gt;CancelCampaignCalls&lt;/code&gt;, except that
     * &lt;code&gt;states&lt;/code&gt; may only hold &lt;code&gt;FAILED&lt;/code&gt; / &lt;code&gt;CANCELLED&lt;/code&gt;, plus
     * &lt;code&gt;additional_attempts&lt;/code&gt; outside 0 to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_ATTEMPTS_LIMIT&lt;/code&gt; (10)
     * and &lt;code&gt;not_before&lt;/code&gt; more than 7 days ahead; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or
     * campaign; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the campaign is &lt;code&gt;HARD_STOPPING&lt;/code&gt; (wait until it
     * is &lt;code&gt;HARD_STOPPED&lt;/code&gt;).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsResponse retryCampaignCalls(ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRetryCampaignCallsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a new campaign in the same project as a copy of an existing one, server side, so the
     * stored credentials of its call defaults are preserved without ever being returned to the client (a
     * Get-then-Create round trip would copy the REDACTED defaults). Copied: &lt;code&gt;max_parallel_calls&lt;/code&gt;,
     * &lt;code&gt;max_attempts&lt;/code&gt;, &lt;code&gt;retry_delay&lt;/code&gt;, &lt;code&gt;campaign_common_services_config&lt;/code&gt;,
     * &lt;code&gt;campaign_sip_caller_config&lt;/code&gt; and &lt;code&gt;calling_window&lt;/code&gt;. Not copied: the state (the
     * clone is &lt;code&gt;CAMPAIGN_STATE_CREATED&lt;/code&gt;), statistics, callers and every other output-only
     * field.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;include_calls&lt;/code&gt;, the source&amp;apos;s calls whose state is in &lt;code&gt;call_states&lt;/code&gt;
     * (empty: every state) are copied as new &lt;code&gt;NOT_STARTED&lt;/code&gt; calls in their original order
     * (&lt;code&gt;position&lt;/code&gt; renumbered from 1), each with its own stored configuration and its fixed
     * &lt;code&gt;phone_number&lt;/code&gt;, no attempt and no history. A copied call that was added by
     * &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; gets a new scheduled caller with the same scheduled time
     * (a time in the past is due as soon as the clone runs). The whole clone is atomic: the campaign and every
     * copied call (and scheduled caller) are stored, or nothing is. The source is read in one consistent
     * snapshot and is not changed.&lt;/p&gt;
     * &lt;p&gt;With an &lt;code&gt;idempotency_key&lt;/code&gt;, a retry of the same request returns the first attempt&amp;apos;s
     * clone (see &lt;code&gt;CreateCampaignRequest.idempotency_key&lt;/code&gt;). Emits
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_CREATED&lt;/code&gt; for the clone with the attributes &lt;code&gt;cloned_from&lt;/code&gt;
     * (the source&amp;apos;s resource name) and &lt;code&gt;copied_call_count&lt;/code&gt;, and, when calls were copied,
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_CALLS_ADDED&lt;/code&gt; and one &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CREATED&lt;/code&gt; per
     * new scheduled caller.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed source selector (as &lt;code&gt;GetCampaign&lt;/code&gt;),
     * a &lt;code&gt;new_display_name&lt;/code&gt; over 128 characters, &lt;code&gt;call_states&lt;/code&gt; without
     * &lt;code&gt;include_calls&lt;/code&gt; or holding an unknown value, a malformed or reused
     * &lt;code&gt;idempotency_key&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an
     * unknown project or source campaign; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when &lt;code&gt;new_display_name&lt;/code&gt; is used
     * in the project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the copied calls would exceed
     * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_CALLS&lt;/code&gt;; &lt;code&gt;ABORTED&lt;/code&gt; while a first attempt with the same
     * &lt;code&gt;idempotency_key&lt;/code&gt; is still running.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign cloneCampaign(ondewo.vtsi.CampaignsOuterClass.CloneCampaignRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCloneCampaignMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Campaigns.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the CAMPAIGNS of a VTSI project. A campaign is a named set of outbound calls that VTSI
   * places for the client while keeping at most &lt;code&gt;max_parallel_calls&lt;/code&gt; of them running at
   * the same time. If 100 callers are added to a campaign with &lt;code&gt;max_parallel_calls = 10&lt;/code&gt;,
   * at any moment at most 10 of those calls are being set up or are connected; the next one starts
   * when one ends.&lt;/p&gt;
   * &lt;p&gt;Calls are added to a campaign with
   * &lt;a href="index.html#ondewo.vtsi.Calls.AddCallersToCampaign"&gt;Calls.AddCallersToCampaign&lt;/a&gt; or
   * &lt;a href="index.html#ondewo.vtsi.Calls.AddScheduledCallersToCampaign"&gt;Calls.AddScheduledCallersToCampaign&lt;/a&gt;
   * (a server that predates them answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; and starts nothing); a scheduled call of a campaign is started at or after its scheduled time AND when the campaign has
   * a free slot.&lt;/p&gt;
   * &lt;p&gt;A call that fails is retried up to &lt;code&gt;max_attempts&lt;/code&gt; times in total, waiting
   * &lt;code&gt;retry_delay&lt;/code&gt; between attempts. A call counts as failed only after its last attempt.
   * A failure that cannot succeed by repetition (for example a rejected credential, an invalid
   * configuration) is never retried.&lt;/p&gt;
   * &lt;p&gt;Lifecycle: &lt;code&gt;StartCampaign&lt;/code&gt; starts a created campaign; &lt;code&gt;StopCampaign&lt;/code&gt; lets
   * the ongoing calls finish and starts no new ones; &lt;code&gt;HardStopCampaign&lt;/code&gt; ends the ongoing
   * calls immediately and starts no new ones; &lt;code&gt;ResumeCampaign&lt;/code&gt; continues a stopped or hard
   * stopped campaign with the calls that have not finished yet.&lt;/p&gt;
   * &lt;p&gt;Every RPC about ONE campaign accepts either its resource name or its display name. Display names
   * are unique within a project, so a display name is resolved within the project named by the
   * request&amp;apos;s top-level &lt;code&gt;vtsi_project_name&lt;/code&gt;, which is REQUIRED with a display name
   * (&lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; when it is empty or malformed) and checked against the campaign
   * when a resource name is used. (The &lt;code&gt;CampaignDisplayName&lt;/code&gt; message of 9.0.0, which
   * carried the project and the display name together, was removed in 9.1.0; its field numbers are
   * &lt;code&gt;reserved&lt;/code&gt;.)&lt;/p&gt;
   * &lt;p&gt;A malformed selector is &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for every authenticated caller, with or
   * without authorization enforced (also when authorization could resolve no project from it): neither
   * the resource name nor the display name set (also how an old 9.0.0 client&amp;apos;s removed
   * &lt;code&gt;CampaignDisplayName&lt;/code&gt; arrives), a malformed resource name, a display name with an empty
   * or malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, and a &lt;code&gt;vtsi_project_name&lt;/code&gt; that is not the
   * project of the resource name. With authorization enforced, a well-formed request naming a project
   * the caller holds no role on (an unknown project included) is refused with
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; before any lookup, so it is not answered &lt;code&gt;NOT_FOUND&lt;/code&gt;, and
   * a caller without a credential is &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; whatever it sent.&lt;/p&gt;
   * &lt;p&gt;Campaign-level call defaults: &lt;code&gt;campaign_common_services_config&lt;/code&gt; and
   * &lt;code&gt;campaign_sip_caller_config&lt;/code&gt; of a &lt;code&gt;Campaign&lt;/code&gt; are the defaults of EVERY call of
   * the campaign. They are read LIVE when a campaign call is dispatched (every attempt, retries
   * included): the effective configuration of the call is a copy of the campaign&amp;apos;s config with the
   * call&amp;apos;s own &lt;code&gt;StartCallerRequest&lt;/code&gt; config merged over it (protobuf
   * &lt;code&gt;MergeFrom&lt;/code&gt;), see &lt;a href="index.html#ondewo.vtsi.Campaign"&gt;Campaign&lt;/a&gt;. The one exception
   * is the callee: &lt;code&gt;campaign_sip_caller_config.callee_id&lt;/code&gt; is resolved and FIXED when a call is
   * added (it is that call&amp;apos;s &lt;code&gt;CampaignCall.phone_number&lt;/code&gt;), so every attempt of a call dials the
   * number its campaign call reports.&lt;/p&gt;
   * &lt;p&gt;Partial responses: &lt;code&gt;ListCampaigns&lt;/code&gt;, &lt;code&gt;ListCampaignCalls&lt;/code&gt;,
   * &lt;code&gt;CreateCampaign&lt;/code&gt;, &lt;code&gt;GetCampaign&lt;/code&gt;, &lt;code&gt;UpdateCampaign&lt;/code&gt;,
   * &lt;code&gt;DeleteCampaign&lt;/code&gt; (paths of &lt;code&gt;DeleteCampaignResponse&lt;/code&gt;), the four lifecycle RPCs
   * &lt;code&gt;StartCampaign&lt;/code&gt;, &lt;code&gt;StopCampaign&lt;/code&gt;, &lt;code&gt;HardStopCampaign&lt;/code&gt; and
   * &lt;code&gt;ResumeCampaign&lt;/code&gt;, &lt;code&gt;CloneCampaign&lt;/code&gt; and &lt;code&gt;GetCampaignCall&lt;/code&gt; accept an optional
   * &lt;code&gt;field_mask&lt;/code&gt; naming the field paths of the returned resource (for a listing: of each listed
   * element) to populate. A mask never changes what the RPC does. Unset or empty returns every
   * field (one exception: &lt;code&gt;ListCampaigns&lt;/code&gt; returns &lt;code&gt;campaign_callers&lt;/code&gt; and
   * &lt;code&gt;campaign_callers_truncated&lt;/code&gt; only when its mask names them); the identifying &lt;code&gt;name&lt;/code&gt; is always populated; an unknown path is rejected with
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; naming it; nested paths through singular message fields (e.g.
   * &lt;code&gt;statistics.completed&lt;/code&gt;) are allowed, a path below a repeated or map field is not. The
   * mask is applied after any role-based redaction, so it can only narrow what the caller may see.&lt;/p&gt;
   * &lt;p&gt;Callers and calls of a campaign: &lt;code&gt;Campaign.campaign_callers&lt;/code&gt; names the callers that placed
   * its calls (bounded); &lt;code&gt;Calls.ListCallers&lt;/code&gt; with &lt;code&gt;ListCallersRequest.campaign_name&lt;/code&gt; /
   * &lt;code&gt;campaign_display_name&lt;/code&gt; lists them paginated as &lt;code&gt;Caller&lt;/code&gt; resources, and
   * &lt;code&gt;Calls.ListCalls&lt;/code&gt; with &lt;code&gt;CallFilter.campaign_name&lt;/code&gt; /
   * &lt;code&gt;campaign_display_name&lt;/code&gt; lists the calls they placed as &lt;code&gt;Call&lt;/code&gt; resources.&lt;/p&gt;
   * &lt;p&gt;Calling window: a campaign with a &lt;code&gt;calling_window&lt;/code&gt; starts calls (first attempts, retries and
   * due scheduled calls alike) only inside one of the window&amp;apos;s weekly slots, in the window&amp;apos;s time zone.
   * Outside every slot it stays &lt;code&gt;RUNNING&lt;/code&gt; and reports &lt;code&gt;outside_calling_window = true&lt;/code&gt;; calls
   * already running are never ended by a slot ending. See
   * &lt;a href="index.html#ondewo.vtsi.CampaignCallingWindow"&gt;CampaignCallingWindow&lt;/a&gt;.&lt;/p&gt;
   * &lt;p&gt;Limits and defaults of the server (environment variables of ondewo-vtsi, read at start-up): at most
   * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_CALLS&lt;/code&gt; (100000) calls per campaign; &lt;code&gt;max_parallel_calls&lt;/code&gt;
   * defaults to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_DEFAULT_MAX_PARALLEL_CALLS&lt;/code&gt; (1) and is at most
   * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_PARALLEL_CALLS_LIMIT&lt;/code&gt; (1000); &lt;code&gt;max_attempts&lt;/code&gt; defaults to 1
   * and is at most &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_ATTEMPTS_LIMIT&lt;/code&gt; (10); &lt;code&gt;retry_delay&lt;/code&gt; defaults
   * to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_DEFAULT_RETRY_DELAY_S&lt;/code&gt; (60 s); one &lt;code&gt;AddCallersToCampaign&lt;/code&gt; /
   * &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; request carries at most 1000 entries (a fixed server limit,
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; above it); &lt;code&gt;CancelCampaignCalls&lt;/code&gt; and &lt;code&gt;RetryCampaignCalls&lt;/code&gt;
   * act on at most 1000 calls per request. The status stream is bounded by
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_DURATION_S&lt;/code&gt; (3600 s), sends a keep-alive after
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_KEEPALIVE_S&lt;/code&gt; (15 s) without a change and at most
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_CONCURRENT&lt;/code&gt; (16) status streams are open per server replica.&lt;/p&gt;
   * &lt;p&gt;Authorization (when enforced): every RPC of this service needs &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or a
   * higher role (&lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt;, &lt;code&gt;PROJECT_ADMIN&lt;/code&gt;) on the campaign&amp;apos;s project, or
   * &lt;code&gt;SERVER_ADMIN&lt;/code&gt;; credential-bearing call defaults are returned only to the roles named at
   * &lt;code&gt;Campaign.campaign_common_services_config&lt;/code&gt;.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, field mask or value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign
   * call (with authorization enforced: &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; for a project the caller holds
   * no role on, or a role below &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;); &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; for a request
   * without a valid credential while authorization is enforced; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a
   * &lt;code&gt;display_name&lt;/code&gt; already used in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a state that does not allow the operation (each RPC names its
   * cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change won, nothing was stored and the request can
   * be retried; &lt;code&gt;DEADLINE_EXCEEDED&lt;/code&gt; for a forced &lt;code&gt;DeleteCampaign&lt;/code&gt; whose hang-ups were not
   * confirmed in time (the hard stop stays in effect, retry the request); &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when
   * the server has no free stream slot.&lt;/p&gt;
   * </pre>
   */
  public static final class CampaignsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CampaignsBlockingStub> {
    private CampaignsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CampaignsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CampaignsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a campaign in state &lt;code&gt;CAMPAIGN_STATE_CREATED&lt;/code&gt;. Calls are added with
     * &lt;code&gt;AddCallersToCampaign&lt;/code&gt; / &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt;; nothing is dialled before
     * &lt;code&gt;StartCampaign&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;With an &lt;code&gt;idempotency_key&lt;/code&gt;, a retry of the same request returns the first attempt&amp;apos;s
     * campaign instead of creating a second one (see &lt;code&gt;CreateCampaignRequest.idempotency_key&lt;/code&gt;).
     * Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_CREATED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; if
     * the &lt;code&gt;display_name&lt;/code&gt; is used in the project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed
     * &lt;code&gt;vtsi_project_name&lt;/code&gt;, an output-only field that was set, an out-of-range value, an invalid
     * &lt;code&gt;calling_window&lt;/code&gt;, a malformed &lt;code&gt;idempotency_key&lt;/code&gt;, an &lt;code&gt;idempotency_key&lt;/code&gt;
     * reused with a different request or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;ABORTED&lt;/code&gt; while
     * a first attempt with the same &lt;code&gt;idempotency_key&lt;/code&gt; is still running.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign createCampaign(ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a campaign including its statistics, its call defaults and its callers
     * (&lt;code&gt;campaign_callers&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign getCampaign(ondewo.vtsi.CampaignsOuterClass.GetCampaignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;max_parallel_calls&lt;/code&gt;, &lt;code&gt;max_attempts&lt;/code&gt;, &lt;code&gt;retry_delay&lt;/code&gt;,
     * &lt;code&gt;campaign_common_services_config&lt;/code&gt;, &lt;code&gt;campaign_sip_caller_config&lt;/code&gt; and
     * &lt;code&gt;calling_window&lt;/code&gt; (each also by a nested sub-path). Allowed in every state. A changed
     * &lt;code&gt;calling_window&lt;/code&gt; applies from the next dispatch decision (within about one second); it never
     * ends a running call. Lowering &lt;code&gt;max_parallel_calls&lt;/code&gt;
     * never ends a running call: the campaign starts no new call until fewer than the new maximum are
     * running. A changed call default applies to every campaign call dispatched after the update,
     * retries included; a call already dispatched keeps the configuration it was started with. The
     * exception is &lt;code&gt;campaign_sip_caller_config.callee_id&lt;/code&gt;, which is fixed per call when the call
     * is added and therefore applies only to calls added after the update.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_UPDATED&lt;/code&gt; (attribute &lt;code&gt;updated_fields&lt;/code&gt;) and, when
     * &lt;code&gt;max_parallel_calls&lt;/code&gt; changed, &lt;code&gt;VTSI_EVENT_CAMPAIGN_MAX_PARALLEL_CALLS_CHANGED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty mask, an unknown,
     * output-only or immutable path, an out-of-range value, an invalid &lt;code&gt;calling_window&lt;/code&gt; or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a
     * &lt;code&gt;display_name&lt;/code&gt; used by another campaign of the project; &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent
     * update of the same campaign won (nothing was written; retry).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign updateCampaign(ondewo.vtsi.CampaignsOuterClass.UpdateCampaignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a campaign and its campaign calls. Its scheduled callers that have not fired yet are
     * cancelled. Calls that already ran are not touched and stay visible through
     * &lt;code&gt;ListCalls&lt;/code&gt;, but no longer as calls OF the campaign: the attempt history that linked them
     * to it is deleted with it, so &lt;code&gt;ListCalls&lt;/code&gt; with &lt;code&gt;CallFilter.campaign_name&lt;/code&gt; /
     * &lt;code&gt;campaign_display_name&lt;/code&gt; of a deleted campaign answers &lt;code&gt;NOT_FOUND&lt;/code&gt; (list them by
     * caller or without the campaign selector), and &lt;code&gt;Calls.ListCallers&lt;/code&gt; with the campaign selector
     * likewise.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;force&lt;/code&gt;, a campaign that is &lt;code&gt;RUNNING&lt;/code&gt;, &lt;code&gt;STOPPING&lt;/code&gt; or
     * &lt;code&gt;HARD_STOPPING&lt;/code&gt; is hard stopped first (exactly as by &lt;code&gt;HardStopCampaign&lt;/code&gt;) and deleted
     * as soon as the end of each of its calls is confirmed. The RPC waits for that, at most
     * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_FORCE_DELETE_WAIT_S&lt;/code&gt; (30 s by default) and never past the client&amp;apos;s
     * deadline; when the hang-ups are not confirmed by then it answers &lt;code&gt;DEADLINE_EXCEEDED&lt;/code&gt;, the
     * campaign stays &lt;code&gt;HARD_STOPPING&lt;/code&gt; (then &lt;code&gt;HARD_STOPPED&lt;/code&gt;) and is NOT deleted: repeat the
     * request. Idempotent: a repeated forced delete of a campaign that is still hard stopping waits again.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_DELETED&lt;/code&gt; (preceded, with &lt;code&gt;force&lt;/code&gt; on a running
     * campaign, by &lt;code&gt;VTSI_EVENT_CAMPAIGN_HARD_STOP_REQUESTED&lt;/code&gt; and
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_HARD_STOPPED&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; without &lt;code&gt;force&lt;/code&gt; while
     * the campaign is &lt;code&gt;RUNNING&lt;/code&gt;, &lt;code&gt;STOPPING&lt;/code&gt; or &lt;code&gt;HARD_STOPPING&lt;/code&gt; (stop or hard
     * stop it first, or set &lt;code&gt;force&lt;/code&gt;); &lt;code&gt;DEADLINE_EXCEEDED&lt;/code&gt; with &lt;code&gt;force&lt;/code&gt; as
     * described above; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, a &lt;code&gt;display_name&lt;/code&gt; without
     * &lt;code&gt;vtsi_project_name&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse deleteCampaign(ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the campaigns of a project, filtered, ordered by &lt;code&gt;ListCampaignsRequest.order_by&lt;/code&gt;
     * (newest first by default) and paged, each with its
     * statistics. &lt;code&gt;campaign_callers&lt;/code&gt; and &lt;code&gt;campaign_callers_truncated&lt;/code&gt; are left empty
     * unless &lt;code&gt;field_mask&lt;/code&gt; names them, and a page that carries them holds at most 20 campaigns (see
     * &lt;code&gt;ListCampaignsRequest.field_mask&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a negative &lt;code&gt;page_size&lt;/code&gt;, a foreign
     * &lt;code&gt;page_token&lt;/code&gt; (also one issued for another filter or &lt;code&gt;order_by&lt;/code&gt;), an unknown
     * &lt;code&gt;order_by&lt;/code&gt; or &lt;code&gt;states&lt;/code&gt; value, &lt;code&gt;created_after&lt;/code&gt; not before
     * &lt;code&gt;created_before&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.ListCampaignsResponse listCampaigns(ondewo.vtsi.CampaignsOuterClass.ListCampaignsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCampaignsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns the progress of a campaign: how many of its calls are not started, in progress,
     * waiting for a retry, completed, failed and cancelled, and how many attempts were made.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.CampaignStatistics getCampaignStatistics(ondewo.vtsi.CampaignsOuterClass.GetCampaignStatisticsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCampaignStatisticsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the calls of a campaign in the order they were added, filtered and paged, each with
     * its current SIP status, the SIP status description and its attempts.&lt;/p&gt;
     * &lt;p&gt;The filters of &lt;code&gt;ListCampaignCallsRequest&lt;/code&gt; are combined by AND; the values of one
     * repeated filter by OR.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a foreign &lt;code&gt;page_token&lt;/code&gt; (also one issued for another filter), a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt;, a malformed campaign call name or one
     * of another campaign in &lt;code&gt;campaign_call_names&lt;/code&gt;, more than 1000 &lt;code&gt;phone_numbers&lt;/code&gt; or
     * &lt;code&gt;campaign_call_names&lt;/code&gt;, a negative &lt;code&gt;min_attempts&lt;/code&gt;, an unknown enum value in
     * &lt;code&gt;states&lt;/code&gt; / &lt;code&gt;sources&lt;/code&gt;, &lt;code&gt;finish_time_min&lt;/code&gt; not before
     * &lt;code&gt;finish_time_max&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsResponse listCampaignCalls(ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCampaignCallsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts a &lt;code&gt;CAMPAIGN_STATE_CREATED&lt;/code&gt; campaign. Idempotent on a
     * &lt;code&gt;RUNNING&lt;/code&gt; campaign.&lt;/p&gt;
     * &lt;p&gt;A campaign with a &lt;code&gt;calling_window&lt;/code&gt; started outside every slot is &lt;code&gt;RUNNING&lt;/code&gt;
     * with &lt;code&gt;outside_calling_window = true&lt;/code&gt; and dials from the next slot on. Emits
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_STARTED&lt;/code&gt; (nothing on the idempotent repeat).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; in any other state (use
     * &lt;code&gt;ResumeCampaign&lt;/code&gt; for a stopped campaign); &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign startCampaign(ondewo.vtsi.CampaignsOuterClass.StartCampaignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a campaign gracefully: no new call is started, the calls that are running continue
     * until they end, then the campaign is &lt;code&gt;CAMPAIGN_STATE_STOPPED&lt;/code&gt;. Returns the campaign
     * in &lt;code&gt;STOPPING&lt;/code&gt; (or already &lt;code&gt;STOPPED&lt;/code&gt; when no call was running).
     * Idempotent on &lt;code&gt;STOPPING&lt;/code&gt;, &lt;code&gt;STOPPED&lt;/code&gt;, &lt;code&gt;HARD_STOPPING&lt;/code&gt; and
     * &lt;code&gt;HARD_STOPPED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; on a
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign stopCampaign(ondewo.vtsi.CampaignsOuterClass.StopCampaignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a campaign immediately: no new call is started and the server hangs up every running
     * call of the campaign right away. The campaign stays &lt;code&gt;CAMPAIGN_STATE_HARD_STOPPING&lt;/code&gt;
     * until the end of each of those calls is CONFIRMED (its call record is no longer active), then
     * becomes &lt;code&gt;CAMPAIGN_STATE_HARD_STOPPED&lt;/code&gt;; with a reachable call infrastructure this
     * takes seconds, scaled by the number of running calls. A hang-up that fails is repeated every
     * few seconds, and the campaign does not report &lt;code&gt;HARD_STOPPED&lt;/code&gt; while one of its calls
     * is still up. Calls ended this way are &lt;code&gt;CAMPAIGN_CALL_STATE_CANCELLED&lt;/code&gt;; a call that
     * finished on its own before the hard stop keeps its own outcome. Calls not started yet stay
     * &lt;code&gt;NOT_STARTED&lt;/code&gt; / &lt;code&gt;RETRY_PENDING&lt;/code&gt; and run after &lt;code&gt;ResumeCampaign&lt;/code&gt;.
     * Returns the campaign in &lt;code&gt;HARD_STOPPING&lt;/code&gt; (or already &lt;code&gt;HARD_STOPPED&lt;/code&gt;).
     * Idempotent on &lt;code&gt;HARD_STOPPING&lt;/code&gt; and &lt;code&gt;HARD_STOPPED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; on a
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign hardStopCampaign(ondewo.vtsi.CampaignsOuterClass.HardStopCampaignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHardStopCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Resumes a &lt;code&gt;STOPPING&lt;/code&gt;, &lt;code&gt;STOPPED&lt;/code&gt; or &lt;code&gt;HARD_STOPPED&lt;/code&gt;
     * campaign: it becomes &lt;code&gt;RUNNING&lt;/code&gt; and continues with the calls that are not finished.
     * Idempotent on &lt;code&gt;RUNNING&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; on &lt;code&gt;CREATED&lt;/code&gt;
     * (use &lt;code&gt;StartCampaign&lt;/code&gt;), &lt;code&gt;HARD_STOPPING&lt;/code&gt; (wait until it is
     * &lt;code&gt;HARD_STOPPED&lt;/code&gt;) and &lt;code&gt;COMPLETED&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign resumeCampaign(ondewo.vtsi.CampaignsOuterClass.ResumeCampaignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the status and progress of the campaigns of a project. The first message is a
     * snapshot (&lt;code&gt;snapshot = true&lt;/code&gt;) of every matching campaign; every later message
     * carries only the campaigns (and, with &lt;code&gt;include_calls&lt;/code&gt;, the campaign calls) that
     * changed. Changes are polled every &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_POLL_INTERVAL_S&lt;/code&gt; (1 s by
     * default). An empty message is sent as a keep-alive when nothing changed for
     * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_KEEPALIVE_S&lt;/code&gt; (15 s by default).&lt;/p&gt;
     * &lt;p&gt;The stream ends when the client disconnects, or the server ends it with a last message carrying
     * &lt;code&gt;end_reason&lt;/code&gt; and &lt;code&gt;end_reason_type&lt;/code&gt;: at the maximum stream duration
     * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_DURATION_S&lt;/code&gt; (3600 s by default,
     * &lt;code&gt;STREAM_END_REASON_MAX_DURATION&lt;/code&gt;), when the server shuts down
     * (&lt;code&gt;STREAM_END_REASON_SERVER_SHUTDOWN&lt;/code&gt;) and when the project is deleted
     * (&lt;code&gt;STREAM_END_REASON_PROJECT_DELETED&lt;/code&gt;). Reconnect and treat the new snapshot as authoritative.
     * A client that blocks one send for longer than &lt;code&gt;ONDEWO_VTSI_STREAM_STALL_TIMEOUT_S&lt;/code&gt; (30 s by
     * default) is disconnected without a last message (the RPC ends &lt;code&gt;CANCELLED&lt;/code&gt;). While
     * authorization is enforced, the caller&amp;apos;s role is re-checked periodically; a revoked role ends the
     * RPC with &lt;code&gt;PERMISSION_DENIED&lt;/code&gt;, an expired credential with &lt;code&gt;UNAUTHENTICATED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a
     * malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a malformed entry of &lt;code&gt;campaign_names&lt;/code&gt;, a campaign
     * name of another project, or an unknown value or &lt;code&gt;CAMPAIGN_STATE_UNSPECIFIED&lt;/code&gt; in
     * &lt;code&gt;states&lt;/code&gt; (a well-formed campaign name of the project that names no campaign is accepted and
     * matches nothing); &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the server has no free stream slot
     * (&lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_CONCURRENT&lt;/code&gt;, 16 per replica by default).&lt;/p&gt;
     * </pre>
     */
    public java.util.Iterator<ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusResponse> streamCampaignStatus(
        ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamCampaignStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns one call of a campaign, with its current SIP status and, with
     * &lt;code&gt;include_attempts&lt;/code&gt;, its attempts. Read-only, no event.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;name&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign call
     * (also one deleted with its campaign); &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; / &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; as
     * for every RPC of this service.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.CampaignCall getCampaignCall(ondewo.vtsi.CampaignsOuterClass.GetCampaignCallRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCampaignCallMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Cancels calls of a campaign that have not started an attempt that is still running: each selected
     * call in &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; or &lt;code&gt;CAMPAIGN_CALL_STATE_RETRY_PENDING&lt;/code&gt;
     * becomes &lt;code&gt;CAMPAIGN_CALL_STATE_CANCELLED&lt;/code&gt; (its &lt;code&gt;finish_time&lt;/code&gt; set, counted in
     * &lt;code&gt;CampaignStatistics.cancelled&lt;/code&gt;); the scheduled caller of a call added by
     * &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; is cancelled with it. Mirrors
     * &lt;code&gt;Calls.CancelScheduledCaller&lt;/code&gt;: a call whose attempt is &lt;code&gt;DISPATCHING&lt;/code&gt; or
     * &lt;code&gt;IN_PROGRESS&lt;/code&gt; is NOT cancelled (and its call is not hung up; use
     * &lt;code&gt;HardStopCampaign&lt;/code&gt; or &lt;code&gt;Calls.StopCall&lt;/code&gt;) and is reported in &lt;code&gt;refused&lt;/code&gt;,
     * like a call that is already finished; a refusal is not an error.&lt;/p&gt;
     * &lt;p&gt;Selection: &lt;code&gt;campaign_call_names&lt;/code&gt;, &lt;code&gt;states&lt;/code&gt;, or both (then a named call must
     * also be in one of the states). At most 1000 calls are acted on per request: with &lt;code&gt;states&lt;/code&gt;
     * the first 1000 matching calls by &lt;code&gt;position&lt;/code&gt;, and &lt;code&gt;remaining_count&lt;/code&gt; says how many
     * more match; repeat the request until it is 0. Each call is cancelled atomically on its own (the request
     * as a whole is not atomic); a call that a replica starts dispatching while the request runs is refused,
     * never cancelled half-way. Allowed in every campaign state. When it leaves a &lt;code&gt;RUNNING&lt;/code&gt;
     * campaign without an unfinished call, the campaign becomes &lt;code&gt;COMPLETED&lt;/code&gt; at the next engine
     * tick. Idempotent: a repeat refuses the calls it already cancelled with
     * &lt;code&gt;reason=already-finished&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_CALL_CANCELLED&lt;/code&gt; per cancelled call,
     * &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CANCELLED&lt;/code&gt; per cancelled scheduled caller, and the usual
     * throttled &lt;code&gt;VTSI_EVENT_CAMPAIGN_PROGRESS&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed selector (as &lt;code&gt;GetCampaign&lt;/code&gt;), neither
     * &lt;code&gt;campaign_call_names&lt;/code&gt; nor &lt;code&gt;states&lt;/code&gt; set, more than 1000 names, a malformed campaign
     * call name or one of another campaign, a state other than &lt;code&gt;NOT_STARTED&lt;/code&gt; /
     * &lt;code&gt;RETRY_PENDING&lt;/code&gt; in &lt;code&gt;states&lt;/code&gt;; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or
     * campaign (an unknown but well-formed campaign call name of the campaign is a refusal with
     * &lt;code&gt;reason=not-found&lt;/code&gt;, not an error).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsResponse cancelCampaignCalls(ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelCampaignCallsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Puts FAILED or CANCELLED calls of a campaign back into the queue with a fresh attempt budget: each
     * selected call gets &lt;code&gt;additional_attempts&lt;/code&gt; more attempts on top of the attempts it already
     * made, and becomes &lt;code&gt;CAMPAIGN_CALL_STATE_RETRY_PENDING&lt;/code&gt; with &lt;code&gt;next_attempt_time&lt;/code&gt; =
     * the later of now and &lt;code&gt;not_before&lt;/code&gt; (or &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; when it
     * never made an attempt, e.g. a scheduled call cancelled before it fired). &lt;code&gt;finish_time&lt;/code&gt; and
     * &lt;code&gt;last_error&lt;/code&gt; are cleared; &lt;code&gt;attempt_history&lt;/code&gt; is kept and continues with the next
     * &lt;code&gt;attempt_number&lt;/code&gt;. The call keeps its &lt;code&gt;phone_number&lt;/code&gt; and its own configuration;
     * the campaign&amp;apos;s call defaults are read live at the next dispatch as for every attempt.&lt;/p&gt;
     * &lt;p&gt;A call added by &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; keeps following its scheduled caller,
     * which returns to &lt;code&gt;SCHEDULED&lt;/code&gt; with its scheduled time moved to the call&amp;apos;s
     * &lt;code&gt;next_attempt_time&lt;/code&gt; (&lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_UPDATED&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Effect on the campaign: a &lt;code&gt;COMPLETED&lt;/code&gt; campaign becomes &lt;code&gt;RUNNING&lt;/code&gt; again (as when
     * calls are added by a &lt;code&gt;CampaignAssignment&lt;/code&gt;); every other state is kept, so a stopped campaign
     * runs the calls after &lt;code&gt;ResumeCampaign&lt;/code&gt; and a &lt;code&gt;CREATED&lt;/code&gt; one after
     * &lt;code&gt;StartCampaign&lt;/code&gt;. The calls are dispatched under &lt;code&gt;max_parallel_calls&lt;/code&gt; and the
     * &lt;code&gt;calling_window&lt;/code&gt; like any other.&lt;/p&gt;
     * &lt;p&gt;Selection exactly as &lt;code&gt;CancelCampaignCalls&lt;/code&gt; (names, states or both; at most 1000 calls per
     * request, &lt;code&gt;remaining_count&lt;/code&gt;); a selected call that is not &lt;code&gt;FAILED&lt;/code&gt; or
     * &lt;code&gt;CANCELLED&lt;/code&gt; is reported in &lt;code&gt;refused&lt;/code&gt;. A failure that cannot succeed by repetition
     * (e.g. a rejected credential) is retried too: fix its cause first, otherwise the campaign may be
     * auto-stopped again. Not idempotent: each request adds a new budget to the calls it requeues, but a
     * repeat finds them &lt;code&gt;RETRY_PENDING&lt;/code&gt; / &lt;code&gt;NOT_STARTED&lt;/code&gt; and refuses them.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_CALL_REQUEUED&lt;/code&gt; per requeued call (attributes
     * &lt;code&gt;attempt_limit&lt;/code&gt;, &lt;code&gt;next_attempt_time&lt;/code&gt;), &lt;code&gt;VTSI_EVENT_CAMPAIGN_RESUMED&lt;/code&gt;
     * when a &lt;code&gt;COMPLETED&lt;/code&gt; campaign became &lt;code&gt;RUNNING&lt;/code&gt;, and the throttled
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_PROGRESS&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; as &lt;code&gt;CancelCampaignCalls&lt;/code&gt;, except that
     * &lt;code&gt;states&lt;/code&gt; may only hold &lt;code&gt;FAILED&lt;/code&gt; / &lt;code&gt;CANCELLED&lt;/code&gt;, plus
     * &lt;code&gt;additional_attempts&lt;/code&gt; outside 0 to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_ATTEMPTS_LIMIT&lt;/code&gt; (10)
     * and &lt;code&gt;not_before&lt;/code&gt; more than 7 days ahead; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or
     * campaign; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the campaign is &lt;code&gt;HARD_STOPPING&lt;/code&gt; (wait until it
     * is &lt;code&gt;HARD_STOPPED&lt;/code&gt;).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsResponse retryCampaignCalls(ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetryCampaignCallsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a new campaign in the same project as a copy of an existing one, server side, so the
     * stored credentials of its call defaults are preserved without ever being returned to the client (a
     * Get-then-Create round trip would copy the REDACTED defaults). Copied: &lt;code&gt;max_parallel_calls&lt;/code&gt;,
     * &lt;code&gt;max_attempts&lt;/code&gt;, &lt;code&gt;retry_delay&lt;/code&gt;, &lt;code&gt;campaign_common_services_config&lt;/code&gt;,
     * &lt;code&gt;campaign_sip_caller_config&lt;/code&gt; and &lt;code&gt;calling_window&lt;/code&gt;. Not copied: the state (the
     * clone is &lt;code&gt;CAMPAIGN_STATE_CREATED&lt;/code&gt;), statistics, callers and every other output-only
     * field.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;include_calls&lt;/code&gt;, the source&amp;apos;s calls whose state is in &lt;code&gt;call_states&lt;/code&gt;
     * (empty: every state) are copied as new &lt;code&gt;NOT_STARTED&lt;/code&gt; calls in their original order
     * (&lt;code&gt;position&lt;/code&gt; renumbered from 1), each with its own stored configuration and its fixed
     * &lt;code&gt;phone_number&lt;/code&gt;, no attempt and no history. A copied call that was added by
     * &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; gets a new scheduled caller with the same scheduled time
     * (a time in the past is due as soon as the clone runs). The whole clone is atomic: the campaign and every
     * copied call (and scheduled caller) are stored, or nothing is. The source is read in one consistent
     * snapshot and is not changed.&lt;/p&gt;
     * &lt;p&gt;With an &lt;code&gt;idempotency_key&lt;/code&gt;, a retry of the same request returns the first attempt&amp;apos;s
     * clone (see &lt;code&gt;CreateCampaignRequest.idempotency_key&lt;/code&gt;). Emits
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_CREATED&lt;/code&gt; for the clone with the attributes &lt;code&gt;cloned_from&lt;/code&gt;
     * (the source&amp;apos;s resource name) and &lt;code&gt;copied_call_count&lt;/code&gt;, and, when calls were copied,
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_CALLS_ADDED&lt;/code&gt; and one &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CREATED&lt;/code&gt; per
     * new scheduled caller.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed source selector (as &lt;code&gt;GetCampaign&lt;/code&gt;),
     * a &lt;code&gt;new_display_name&lt;/code&gt; over 128 characters, &lt;code&gt;call_states&lt;/code&gt; without
     * &lt;code&gt;include_calls&lt;/code&gt; or holding an unknown value, a malformed or reused
     * &lt;code&gt;idempotency_key&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an
     * unknown project or source campaign; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when &lt;code&gt;new_display_name&lt;/code&gt; is used
     * in the project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the copied calls would exceed
     * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_CALLS&lt;/code&gt;; &lt;code&gt;ABORTED&lt;/code&gt; while a first attempt with the same
     * &lt;code&gt;idempotency_key&lt;/code&gt; is still running.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign cloneCampaign(ondewo.vtsi.CampaignsOuterClass.CloneCampaignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloneCampaignMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Campaigns.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the CAMPAIGNS of a VTSI project. A campaign is a named set of outbound calls that VTSI
   * places for the client while keeping at most &lt;code&gt;max_parallel_calls&lt;/code&gt; of them running at
   * the same time. If 100 callers are added to a campaign with &lt;code&gt;max_parallel_calls = 10&lt;/code&gt;,
   * at any moment at most 10 of those calls are being set up or are connected; the next one starts
   * when one ends.&lt;/p&gt;
   * &lt;p&gt;Calls are added to a campaign with
   * &lt;a href="index.html#ondewo.vtsi.Calls.AddCallersToCampaign"&gt;Calls.AddCallersToCampaign&lt;/a&gt; or
   * &lt;a href="index.html#ondewo.vtsi.Calls.AddScheduledCallersToCampaign"&gt;Calls.AddScheduledCallersToCampaign&lt;/a&gt;
   * (a server that predates them answers &lt;code&gt;UNIMPLEMENTED&lt;/code&gt; and starts nothing); a scheduled call of a campaign is started at or after its scheduled time AND when the campaign has
   * a free slot.&lt;/p&gt;
   * &lt;p&gt;A call that fails is retried up to &lt;code&gt;max_attempts&lt;/code&gt; times in total, waiting
   * &lt;code&gt;retry_delay&lt;/code&gt; between attempts. A call counts as failed only after its last attempt.
   * A failure that cannot succeed by repetition (for example a rejected credential, an invalid
   * configuration) is never retried.&lt;/p&gt;
   * &lt;p&gt;Lifecycle: &lt;code&gt;StartCampaign&lt;/code&gt; starts a created campaign; &lt;code&gt;StopCampaign&lt;/code&gt; lets
   * the ongoing calls finish and starts no new ones; &lt;code&gt;HardStopCampaign&lt;/code&gt; ends the ongoing
   * calls immediately and starts no new ones; &lt;code&gt;ResumeCampaign&lt;/code&gt; continues a stopped or hard
   * stopped campaign with the calls that have not finished yet.&lt;/p&gt;
   * &lt;p&gt;Every RPC about ONE campaign accepts either its resource name or its display name. Display names
   * are unique within a project, so a display name is resolved within the project named by the
   * request&amp;apos;s top-level &lt;code&gt;vtsi_project_name&lt;/code&gt;, which is REQUIRED with a display name
   * (&lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; when it is empty or malformed) and checked against the campaign
   * when a resource name is used. (The &lt;code&gt;CampaignDisplayName&lt;/code&gt; message of 9.0.0, which
   * carried the project and the display name together, was removed in 9.1.0; its field numbers are
   * &lt;code&gt;reserved&lt;/code&gt;.)&lt;/p&gt;
   * &lt;p&gt;A malformed selector is &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for every authenticated caller, with or
   * without authorization enforced (also when authorization could resolve no project from it): neither
   * the resource name nor the display name set (also how an old 9.0.0 client&amp;apos;s removed
   * &lt;code&gt;CampaignDisplayName&lt;/code&gt; arrives), a malformed resource name, a display name with an empty
   * or malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, and a &lt;code&gt;vtsi_project_name&lt;/code&gt; that is not the
   * project of the resource name. With authorization enforced, a well-formed request naming a project
   * the caller holds no role on (an unknown project included) is refused with
   * &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; before any lookup, so it is not answered &lt;code&gt;NOT_FOUND&lt;/code&gt;, and
   * a caller without a credential is &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; whatever it sent.&lt;/p&gt;
   * &lt;p&gt;Campaign-level call defaults: &lt;code&gt;campaign_common_services_config&lt;/code&gt; and
   * &lt;code&gt;campaign_sip_caller_config&lt;/code&gt; of a &lt;code&gt;Campaign&lt;/code&gt; are the defaults of EVERY call of
   * the campaign. They are read LIVE when a campaign call is dispatched (every attempt, retries
   * included): the effective configuration of the call is a copy of the campaign&amp;apos;s config with the
   * call&amp;apos;s own &lt;code&gt;StartCallerRequest&lt;/code&gt; config merged over it (protobuf
   * &lt;code&gt;MergeFrom&lt;/code&gt;), see &lt;a href="index.html#ondewo.vtsi.Campaign"&gt;Campaign&lt;/a&gt;. The one exception
   * is the callee: &lt;code&gt;campaign_sip_caller_config.callee_id&lt;/code&gt; is resolved and FIXED when a call is
   * added (it is that call&amp;apos;s &lt;code&gt;CampaignCall.phone_number&lt;/code&gt;), so every attempt of a call dials the
   * number its campaign call reports.&lt;/p&gt;
   * &lt;p&gt;Partial responses: &lt;code&gt;ListCampaigns&lt;/code&gt;, &lt;code&gt;ListCampaignCalls&lt;/code&gt;,
   * &lt;code&gt;CreateCampaign&lt;/code&gt;, &lt;code&gt;GetCampaign&lt;/code&gt;, &lt;code&gt;UpdateCampaign&lt;/code&gt;,
   * &lt;code&gt;DeleteCampaign&lt;/code&gt; (paths of &lt;code&gt;DeleteCampaignResponse&lt;/code&gt;), the four lifecycle RPCs
   * &lt;code&gt;StartCampaign&lt;/code&gt;, &lt;code&gt;StopCampaign&lt;/code&gt;, &lt;code&gt;HardStopCampaign&lt;/code&gt; and
   * &lt;code&gt;ResumeCampaign&lt;/code&gt;, &lt;code&gt;CloneCampaign&lt;/code&gt; and &lt;code&gt;GetCampaignCall&lt;/code&gt; accept an optional
   * &lt;code&gt;field_mask&lt;/code&gt; naming the field paths of the returned resource (for a listing: of each listed
   * element) to populate. A mask never changes what the RPC does. Unset or empty returns every
   * field (one exception: &lt;code&gt;ListCampaigns&lt;/code&gt; returns &lt;code&gt;campaign_callers&lt;/code&gt; and
   * &lt;code&gt;campaign_callers_truncated&lt;/code&gt; only when its mask names them); the identifying &lt;code&gt;name&lt;/code&gt; is always populated; an unknown path is rejected with
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; naming it; nested paths through singular message fields (e.g.
   * &lt;code&gt;statistics.completed&lt;/code&gt;) are allowed, a path below a repeated or map field is not. The
   * mask is applied after any role-based redaction, so it can only narrow what the caller may see.&lt;/p&gt;
   * &lt;p&gt;Callers and calls of a campaign: &lt;code&gt;Campaign.campaign_callers&lt;/code&gt; names the callers that placed
   * its calls (bounded); &lt;code&gt;Calls.ListCallers&lt;/code&gt; with &lt;code&gt;ListCallersRequest.campaign_name&lt;/code&gt; /
   * &lt;code&gt;campaign_display_name&lt;/code&gt; lists them paginated as &lt;code&gt;Caller&lt;/code&gt; resources, and
   * &lt;code&gt;Calls.ListCalls&lt;/code&gt; with &lt;code&gt;CallFilter.campaign_name&lt;/code&gt; /
   * &lt;code&gt;campaign_display_name&lt;/code&gt; lists the calls they placed as &lt;code&gt;Call&lt;/code&gt; resources.&lt;/p&gt;
   * &lt;p&gt;Calling window: a campaign with a &lt;code&gt;calling_window&lt;/code&gt; starts calls (first attempts, retries and
   * due scheduled calls alike) only inside one of the window&amp;apos;s weekly slots, in the window&amp;apos;s time zone.
   * Outside every slot it stays &lt;code&gt;RUNNING&lt;/code&gt; and reports &lt;code&gt;outside_calling_window = true&lt;/code&gt;; calls
   * already running are never ended by a slot ending. See
   * &lt;a href="index.html#ondewo.vtsi.CampaignCallingWindow"&gt;CampaignCallingWindow&lt;/a&gt;.&lt;/p&gt;
   * &lt;p&gt;Limits and defaults of the server (environment variables of ondewo-vtsi, read at start-up): at most
   * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_CALLS&lt;/code&gt; (100000) calls per campaign; &lt;code&gt;max_parallel_calls&lt;/code&gt;
   * defaults to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_DEFAULT_MAX_PARALLEL_CALLS&lt;/code&gt; (1) and is at most
   * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_PARALLEL_CALLS_LIMIT&lt;/code&gt; (1000); &lt;code&gt;max_attempts&lt;/code&gt; defaults to 1
   * and is at most &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_ATTEMPTS_LIMIT&lt;/code&gt; (10); &lt;code&gt;retry_delay&lt;/code&gt; defaults
   * to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_DEFAULT_RETRY_DELAY_S&lt;/code&gt; (60 s); one &lt;code&gt;AddCallersToCampaign&lt;/code&gt; /
   * &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; request carries at most 1000 entries (a fixed server limit,
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; above it); &lt;code&gt;CancelCampaignCalls&lt;/code&gt; and &lt;code&gt;RetryCampaignCalls&lt;/code&gt;
   * act on at most 1000 calls per request. The status stream is bounded by
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_DURATION_S&lt;/code&gt; (3600 s), sends a keep-alive after
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_KEEPALIVE_S&lt;/code&gt; (15 s) without a change and at most
   * &lt;code&gt;ONDEWO_VTSI_STATUS_STREAM_MAX_CONCURRENT&lt;/code&gt; (16) status streams are open per server replica.&lt;/p&gt;
   * &lt;p&gt;Authorization (when enforced): every RPC of this service needs &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt; or a
   * higher role (&lt;code&gt;PROJECT_DEVELOPER&lt;/code&gt;, &lt;code&gt;PROJECT_ADMIN&lt;/code&gt;) on the campaign&amp;apos;s project, or
   * &lt;code&gt;SERVER_ADMIN&lt;/code&gt;; credential-bearing call defaults are returned only to the roles named at
   * &lt;code&gt;Campaign.campaign_common_services_config&lt;/code&gt;.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, field mask or value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign
   * call (with authorization enforced: &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; for a project the caller holds
   * no role on, or a role below &lt;code&gt;PROJECT_EXECUTOR&lt;/code&gt;); &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; for a request
   * without a valid credential while authorization is enforced; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a
   * &lt;code&gt;display_name&lt;/code&gt; already used in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a state that does not allow the operation (each RPC names its
   * cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change won, nothing was stored and the request can
   * be retried; &lt;code&gt;DEADLINE_EXCEEDED&lt;/code&gt; for a forced &lt;code&gt;DeleteCampaign&lt;/code&gt; whose hang-ups were not
   * confirmed in time (the hard stop stays in effect, retry the request); &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when
   * the server has no free stream slot.&lt;/p&gt;
   * </pre>
   */
  public static final class CampaignsFutureStub
      extends io.grpc.stub.AbstractFutureStub<CampaignsFutureStub> {
    private CampaignsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CampaignsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CampaignsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a campaign in state &lt;code&gt;CAMPAIGN_STATE_CREATED&lt;/code&gt;. Calls are added with
     * &lt;code&gt;AddCallersToCampaign&lt;/code&gt; / &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt;; nothing is dialled before
     * &lt;code&gt;StartCampaign&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;With an &lt;code&gt;idempotency_key&lt;/code&gt;, a retry of the same request returns the first attempt&amp;apos;s
     * campaign instead of creating a second one (see &lt;code&gt;CreateCampaignRequest.idempotency_key&lt;/code&gt;).
     * Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_CREATED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; if
     * the &lt;code&gt;display_name&lt;/code&gt; is used in the project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed
     * &lt;code&gt;vtsi_project_name&lt;/code&gt;, an output-only field that was set, an out-of-range value, an invalid
     * &lt;code&gt;calling_window&lt;/code&gt;, a malformed &lt;code&gt;idempotency_key&lt;/code&gt;, an &lt;code&gt;idempotency_key&lt;/code&gt;
     * reused with a different request or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;ABORTED&lt;/code&gt; while
     * a first attempt with the same &lt;code&gt;idempotency_key&lt;/code&gt; is still running.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.Campaign> createCampaign(
        ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCampaignMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a campaign including its statistics, its call defaults and its callers
     * (&lt;code&gt;campaign_callers&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.Campaign> getCampaign(
        ondewo.vtsi.CampaignsOuterClass.GetCampaignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCampaignMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;max_parallel_calls&lt;/code&gt;, &lt;code&gt;max_attempts&lt;/code&gt;, &lt;code&gt;retry_delay&lt;/code&gt;,
     * &lt;code&gt;campaign_common_services_config&lt;/code&gt;, &lt;code&gt;campaign_sip_caller_config&lt;/code&gt; and
     * &lt;code&gt;calling_window&lt;/code&gt; (each also by a nested sub-path). Allowed in every state. A changed
     * &lt;code&gt;calling_window&lt;/code&gt; applies from the next dispatch decision (within about one second); it never
     * ends a running call. Lowering &lt;code&gt;max_parallel_calls&lt;/code&gt;
     * never ends a running call: the campaign starts no new call until fewer than the new maximum are
     * running. A changed call default applies to every campaign call dispatched after the update,
     * retries included; a call already dispatched keeps the configuration it was started with. The
     * exception is &lt;code&gt;campaign_sip_caller_config.callee_id&lt;/code&gt;, which is fixed per call when the call
     * is added and therefore applies only to calls added after the update.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_UPDATED&lt;/code&gt; (attribute &lt;code&gt;updated_fields&lt;/code&gt;) and, when
     * &lt;code&gt;max_parallel_calls&lt;/code&gt; changed, &lt;code&gt;VTSI_EVENT_CAMPAIGN_MAX_PARALLEL_CALLS_CHANGED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty mask, an unknown,
     * output-only or immutable path, an out-of-range value, an invalid &lt;code&gt;calling_window&lt;/code&gt; or an
     * unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a
     * &lt;code&gt;display_name&lt;/code&gt; used by another campaign of the project; &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent
     * update of the same campaign won (nothing was written; retry).&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.Campaign> updateCampaign(
        ondewo.vtsi.CampaignsOuterClass.UpdateCampaignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCampaignMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a campaign and its campaign calls. Its scheduled callers that have not fired yet are
     * cancelled. Calls that already ran are not touched and stay visible through
     * &lt;code&gt;ListCalls&lt;/code&gt;, but no longer as calls OF the campaign: the attempt history that linked them
     * to it is deleted with it, so &lt;code&gt;ListCalls&lt;/code&gt; with &lt;code&gt;CallFilter.campaign_name&lt;/code&gt; /
     * &lt;code&gt;campaign_display_name&lt;/code&gt; of a deleted campaign answers &lt;code&gt;NOT_FOUND&lt;/code&gt; (list them by
     * caller or without the campaign selector), and &lt;code&gt;Calls.ListCallers&lt;/code&gt; with the campaign selector
     * likewise.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;force&lt;/code&gt;, a campaign that is &lt;code&gt;RUNNING&lt;/code&gt;, &lt;code&gt;STOPPING&lt;/code&gt; or
     * &lt;code&gt;HARD_STOPPING&lt;/code&gt; is hard stopped first (exactly as by &lt;code&gt;HardStopCampaign&lt;/code&gt;) and deleted
     * as soon as the end of each of its calls is confirmed. The RPC waits for that, at most
     * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_FORCE_DELETE_WAIT_S&lt;/code&gt; (30 s by default) and never past the client&amp;apos;s
     * deadline; when the hang-ups are not confirmed by then it answers &lt;code&gt;DEADLINE_EXCEEDED&lt;/code&gt;, the
     * campaign stays &lt;code&gt;HARD_STOPPING&lt;/code&gt; (then &lt;code&gt;HARD_STOPPED&lt;/code&gt;) and is NOT deleted: repeat the
     * request. Idempotent: a repeated forced delete of a campaign that is still hard stopping waits again.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_DELETED&lt;/code&gt; (preceded, with &lt;code&gt;force&lt;/code&gt; on a running
     * campaign, by &lt;code&gt;VTSI_EVENT_CAMPAIGN_HARD_STOP_REQUESTED&lt;/code&gt; and
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_HARD_STOPPED&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; without &lt;code&gt;force&lt;/code&gt; while
     * the campaign is &lt;code&gt;RUNNING&lt;/code&gt;, &lt;code&gt;STOPPING&lt;/code&gt; or &lt;code&gt;HARD_STOPPING&lt;/code&gt; (stop or hard
     * stop it first, or set &lt;code&gt;force&lt;/code&gt;); &lt;code&gt;DEADLINE_EXCEEDED&lt;/code&gt; with &lt;code&gt;force&lt;/code&gt; as
     * described above; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, a &lt;code&gt;display_name&lt;/code&gt; without
     * &lt;code&gt;vtsi_project_name&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse> deleteCampaign(
        ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCampaignMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the campaigns of a project, filtered, ordered by &lt;code&gt;ListCampaignsRequest.order_by&lt;/code&gt;
     * (newest first by default) and paged, each with its
     * statistics. &lt;code&gt;campaign_callers&lt;/code&gt; and &lt;code&gt;campaign_callers_truncated&lt;/code&gt; are left empty
     * unless &lt;code&gt;field_mask&lt;/code&gt; names them, and a page that carries them holds at most 20 campaigns (see
     * &lt;code&gt;ListCampaignsRequest.field_mask&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for a malformed &lt;code&gt;vtsi_project_name&lt;/code&gt;, a negative &lt;code&gt;page_size&lt;/code&gt;, a foreign
     * &lt;code&gt;page_token&lt;/code&gt; (also one issued for another filter or &lt;code&gt;order_by&lt;/code&gt;), an unknown
     * &lt;code&gt;order_by&lt;/code&gt; or &lt;code&gt;states&lt;/code&gt; value, &lt;code&gt;created_after&lt;/code&gt; not before
     * &lt;code&gt;created_before&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.ListCampaignsResponse> listCampaigns(
        ondewo.vtsi.CampaignsOuterClass.ListCampaignsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCampaignsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns the progress of a campaign: how many of its calls are not started, in progress,
     * waiting for a retry, completed, failed and cancelled, and how many attempts were made.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name or a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.CampaignStatistics> getCampaignStatistics(
        ondewo.vtsi.CampaignsOuterClass.GetCampaignStatisticsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCampaignStatisticsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the calls of a campaign in the order they were added, filtered and paged, each with
     * its current SIP status, the SIP status description and its attempts.&lt;/p&gt;
     * &lt;p&gt;The filters of &lt;code&gt;ListCampaignCallsRequest&lt;/code&gt; are combined by AND; the values of one
     * repeated filter by OR.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a negative
     * &lt;code&gt;page_size&lt;/code&gt;, a foreign &lt;code&gt;page_token&lt;/code&gt; (also one issued for another filter), a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt;, a malformed campaign call name or one
     * of another campaign in &lt;code&gt;campaign_call_names&lt;/code&gt;, more than 1000 &lt;code&gt;phone_numbers&lt;/code&gt; or
     * &lt;code&gt;campaign_call_names&lt;/code&gt;, a negative &lt;code&gt;min_attempts&lt;/code&gt;, an unknown enum value in
     * &lt;code&gt;states&lt;/code&gt; / &lt;code&gt;sources&lt;/code&gt;, &lt;code&gt;finish_time_min&lt;/code&gt; not before
     * &lt;code&gt;finish_time_max&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsResponse> listCampaignCalls(
        ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCampaignCallsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Starts a &lt;code&gt;CAMPAIGN_STATE_CREATED&lt;/code&gt; campaign. Idempotent on a
     * &lt;code&gt;RUNNING&lt;/code&gt; campaign.&lt;/p&gt;
     * &lt;p&gt;A campaign with a &lt;code&gt;calling_window&lt;/code&gt; started outside every slot is &lt;code&gt;RUNNING&lt;/code&gt;
     * with &lt;code&gt;outside_calling_window = true&lt;/code&gt; and dials from the next slot on. Emits
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_STARTED&lt;/code&gt; (nothing on the idempotent repeat).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; in any other state (use
     * &lt;code&gt;ResumeCampaign&lt;/code&gt; for a stopped campaign); &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.Campaign> startCampaign(
        ondewo.vtsi.CampaignsOuterClass.StartCampaignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartCampaignMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a campaign gracefully: no new call is started, the calls that are running continue
     * until they end, then the campaign is &lt;code&gt;CAMPAIGN_STATE_STOPPED&lt;/code&gt;. Returns the campaign
     * in &lt;code&gt;STOPPING&lt;/code&gt; (or already &lt;code&gt;STOPPED&lt;/code&gt; when no call was running).
     * Idempotent on &lt;code&gt;STOPPING&lt;/code&gt;, &lt;code&gt;STOPPED&lt;/code&gt;, &lt;code&gt;HARD_STOPPING&lt;/code&gt; and
     * &lt;code&gt;HARD_STOPPED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; on a
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.Campaign> stopCampaign(
        ondewo.vtsi.CampaignsOuterClass.StopCampaignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopCampaignMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Stops a campaign immediately: no new call is started and the server hangs up every running
     * call of the campaign right away. The campaign stays &lt;code&gt;CAMPAIGN_STATE_HARD_STOPPING&lt;/code&gt;
     * until the end of each of those calls is CONFIRMED (its call record is no longer active), then
     * becomes &lt;code&gt;CAMPAIGN_STATE_HARD_STOPPED&lt;/code&gt;; with a reachable call infrastructure this
     * takes seconds, scaled by the number of running calls. A hang-up that fails is repeated every
     * few seconds, and the campaign does not report &lt;code&gt;HARD_STOPPED&lt;/code&gt; while one of its calls
     * is still up. Calls ended this way are &lt;code&gt;CAMPAIGN_CALL_STATE_CANCELLED&lt;/code&gt;; a call that
     * finished on its own before the hard stop keeps its own outcome. Calls not started yet stay
     * &lt;code&gt;NOT_STARTED&lt;/code&gt; / &lt;code&gt;RETRY_PENDING&lt;/code&gt; and run after &lt;code&gt;ResumeCampaign&lt;/code&gt;.
     * Returns the campaign in &lt;code&gt;HARD_STOPPING&lt;/code&gt; (or already &lt;code&gt;HARD_STOPPED&lt;/code&gt;).
     * Idempotent on &lt;code&gt;HARD_STOPPING&lt;/code&gt; and &lt;code&gt;HARD_STOPPED&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; on a
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.Campaign> hardStopCampaign(
        ondewo.vtsi.CampaignsOuterClass.HardStopCampaignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHardStopCampaignMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Resumes a &lt;code&gt;STOPPING&lt;/code&gt;, &lt;code&gt;STOPPED&lt;/code&gt; or &lt;code&gt;HARD_STOPPED&lt;/code&gt;
     * campaign: it becomes &lt;code&gt;RUNNING&lt;/code&gt; and continues with the calls that are not finished.
     * Idempotent on &lt;code&gt;RUNNING&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; on &lt;code&gt;CREATED&lt;/code&gt;
     * (use &lt;code&gt;StartCampaign&lt;/code&gt;), &lt;code&gt;HARD_STOPPING&lt;/code&gt; (wait until it is
     * &lt;code&gt;HARD_STOPPED&lt;/code&gt;) and &lt;code&gt;COMPLETED&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, neither selector set, a
     * &lt;code&gt;display_name&lt;/code&gt; without &lt;code&gt;vtsi_project_name&lt;/code&gt; or a &lt;code&gt;vtsi_project_name&lt;/code&gt;
     * that is not the campaign&amp;apos;s project, or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.Campaign> resumeCampaign(
        ondewo.vtsi.CampaignsOuterClass.ResumeCampaignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResumeCampaignMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns one call of a campaign, with its current SIP status and, with
     * &lt;code&gt;include_attempts&lt;/code&gt;, its attempts. Read-only, no event.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;name&lt;/code&gt; or an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign call
     * (also one deleted with its campaign); &lt;code&gt;PERMISSION_DENIED&lt;/code&gt; / &lt;code&gt;UNAUTHENTICATED&lt;/code&gt; as
     * for every RPC of this service.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.CampaignCall> getCampaignCall(
        ondewo.vtsi.CampaignsOuterClass.GetCampaignCallRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCampaignCallMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Cancels calls of a campaign that have not started an attempt that is still running: each selected
     * call in &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; or &lt;code&gt;CAMPAIGN_CALL_STATE_RETRY_PENDING&lt;/code&gt;
     * becomes &lt;code&gt;CAMPAIGN_CALL_STATE_CANCELLED&lt;/code&gt; (its &lt;code&gt;finish_time&lt;/code&gt; set, counted in
     * &lt;code&gt;CampaignStatistics.cancelled&lt;/code&gt;); the scheduled caller of a call added by
     * &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; is cancelled with it. Mirrors
     * &lt;code&gt;Calls.CancelScheduledCaller&lt;/code&gt;: a call whose attempt is &lt;code&gt;DISPATCHING&lt;/code&gt; or
     * &lt;code&gt;IN_PROGRESS&lt;/code&gt; is NOT cancelled (and its call is not hung up; use
     * &lt;code&gt;HardStopCampaign&lt;/code&gt; or &lt;code&gt;Calls.StopCall&lt;/code&gt;) and is reported in &lt;code&gt;refused&lt;/code&gt;,
     * like a call that is already finished; a refusal is not an error.&lt;/p&gt;
     * &lt;p&gt;Selection: &lt;code&gt;campaign_call_names&lt;/code&gt;, &lt;code&gt;states&lt;/code&gt;, or both (then a named call must
     * also be in one of the states). At most 1000 calls are acted on per request: with &lt;code&gt;states&lt;/code&gt;
     * the first 1000 matching calls by &lt;code&gt;position&lt;/code&gt;, and &lt;code&gt;remaining_count&lt;/code&gt; says how many
     * more match; repeat the request until it is 0. Each call is cancelled atomically on its own (the request
     * as a whole is not atomic); a call that a replica starts dispatching while the request runs is refused,
     * never cancelled half-way. Allowed in every campaign state. When it leaves a &lt;code&gt;RUNNING&lt;/code&gt;
     * campaign without an unfinished call, the campaign becomes &lt;code&gt;COMPLETED&lt;/code&gt; at the next engine
     * tick. Idempotent: a repeat refuses the calls it already cancelled with
     * &lt;code&gt;reason=already-finished&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_CALL_CANCELLED&lt;/code&gt; per cancelled call,
     * &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CANCELLED&lt;/code&gt; per cancelled scheduled caller, and the usual
     * throttled &lt;code&gt;VTSI_EVENT_CAMPAIGN_PROGRESS&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed selector (as &lt;code&gt;GetCampaign&lt;/code&gt;), neither
     * &lt;code&gt;campaign_call_names&lt;/code&gt; nor &lt;code&gt;states&lt;/code&gt; set, more than 1000 names, a malformed campaign
     * call name or one of another campaign, a state other than &lt;code&gt;NOT_STARTED&lt;/code&gt; /
     * &lt;code&gt;RETRY_PENDING&lt;/code&gt; in &lt;code&gt;states&lt;/code&gt;; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or
     * campaign (an unknown but well-formed campaign call name of the campaign is a refusal with
     * &lt;code&gt;reason=not-found&lt;/code&gt;, not an error).&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsResponse> cancelCampaignCalls(
        ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelCampaignCallsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Puts FAILED or CANCELLED calls of a campaign back into the queue with a fresh attempt budget: each
     * selected call gets &lt;code&gt;additional_attempts&lt;/code&gt; more attempts on top of the attempts it already
     * made, and becomes &lt;code&gt;CAMPAIGN_CALL_STATE_RETRY_PENDING&lt;/code&gt; with &lt;code&gt;next_attempt_time&lt;/code&gt; =
     * the later of now and &lt;code&gt;not_before&lt;/code&gt; (or &lt;code&gt;CAMPAIGN_CALL_STATE_NOT_STARTED&lt;/code&gt; when it
     * never made an attempt, e.g. a scheduled call cancelled before it fired). &lt;code&gt;finish_time&lt;/code&gt; and
     * &lt;code&gt;last_error&lt;/code&gt; are cleared; &lt;code&gt;attempt_history&lt;/code&gt; is kept and continues with the next
     * &lt;code&gt;attempt_number&lt;/code&gt;. The call keeps its &lt;code&gt;phone_number&lt;/code&gt; and its own configuration;
     * the campaign&amp;apos;s call defaults are read live at the next dispatch as for every attempt.&lt;/p&gt;
     * &lt;p&gt;A call added by &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; keeps following its scheduled caller,
     * which returns to &lt;code&gt;SCHEDULED&lt;/code&gt; with its scheduled time moved to the call&amp;apos;s
     * &lt;code&gt;next_attempt_time&lt;/code&gt; (&lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_UPDATED&lt;/code&gt;).&lt;/p&gt;
     * &lt;p&gt;Effect on the campaign: a &lt;code&gt;COMPLETED&lt;/code&gt; campaign becomes &lt;code&gt;RUNNING&lt;/code&gt; again (as when
     * calls are added by a &lt;code&gt;CampaignAssignment&lt;/code&gt;); every other state is kept, so a stopped campaign
     * runs the calls after &lt;code&gt;ResumeCampaign&lt;/code&gt; and a &lt;code&gt;CREATED&lt;/code&gt; one after
     * &lt;code&gt;StartCampaign&lt;/code&gt;. The calls are dispatched under &lt;code&gt;max_parallel_calls&lt;/code&gt; and the
     * &lt;code&gt;calling_window&lt;/code&gt; like any other.&lt;/p&gt;
     * &lt;p&gt;Selection exactly as &lt;code&gt;CancelCampaignCalls&lt;/code&gt; (names, states or both; at most 1000 calls per
     * request, &lt;code&gt;remaining_count&lt;/code&gt;); a selected call that is not &lt;code&gt;FAILED&lt;/code&gt; or
     * &lt;code&gt;CANCELLED&lt;/code&gt; is reported in &lt;code&gt;refused&lt;/code&gt;. A failure that cannot succeed by repetition
     * (e.g. a rejected credential) is retried too: fix its cause first, otherwise the campaign may be
     * auto-stopped again. Not idempotent: each request adds a new budget to the calls it requeues, but a
     * repeat finds them &lt;code&gt;RETRY_PENDING&lt;/code&gt; / &lt;code&gt;NOT_STARTED&lt;/code&gt; and refuses them.&lt;/p&gt;
     * &lt;p&gt;Emits &lt;code&gt;VTSI_EVENT_CAMPAIGN_CALL_REQUEUED&lt;/code&gt; per requeued call (attributes
     * &lt;code&gt;attempt_limit&lt;/code&gt;, &lt;code&gt;next_attempt_time&lt;/code&gt;), &lt;code&gt;VTSI_EVENT_CAMPAIGN_RESUMED&lt;/code&gt;
     * when a &lt;code&gt;COMPLETED&lt;/code&gt; campaign became &lt;code&gt;RUNNING&lt;/code&gt;, and the throttled
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_PROGRESS&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; as &lt;code&gt;CancelCampaignCalls&lt;/code&gt;, except that
     * &lt;code&gt;states&lt;/code&gt; may only hold &lt;code&gt;FAILED&lt;/code&gt; / &lt;code&gt;CANCELLED&lt;/code&gt;, plus
     * &lt;code&gt;additional_attempts&lt;/code&gt; outside 0 to &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_ATTEMPTS_LIMIT&lt;/code&gt; (10)
     * and &lt;code&gt;not_before&lt;/code&gt; more than 7 days ahead; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or
     * campaign; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the campaign is &lt;code&gt;HARD_STOPPING&lt;/code&gt; (wait until it
     * is &lt;code&gt;HARD_STOPPED&lt;/code&gt;).&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsResponse> retryCampaignCalls(
        ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetryCampaignCallsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a new campaign in the same project as a copy of an existing one, server side, so the
     * stored credentials of its call defaults are preserved without ever being returned to the client (a
     * Get-then-Create round trip would copy the REDACTED defaults). Copied: &lt;code&gt;max_parallel_calls&lt;/code&gt;,
     * &lt;code&gt;max_attempts&lt;/code&gt;, &lt;code&gt;retry_delay&lt;/code&gt;, &lt;code&gt;campaign_common_services_config&lt;/code&gt;,
     * &lt;code&gt;campaign_sip_caller_config&lt;/code&gt; and &lt;code&gt;calling_window&lt;/code&gt;. Not copied: the state (the
     * clone is &lt;code&gt;CAMPAIGN_STATE_CREATED&lt;/code&gt;), statistics, callers and every other output-only
     * field.&lt;/p&gt;
     * &lt;p&gt;With &lt;code&gt;include_calls&lt;/code&gt;, the source&amp;apos;s calls whose state is in &lt;code&gt;call_states&lt;/code&gt;
     * (empty: every state) are copied as new &lt;code&gt;NOT_STARTED&lt;/code&gt; calls in their original order
     * (&lt;code&gt;position&lt;/code&gt; renumbered from 1), each with its own stored configuration and its fixed
     * &lt;code&gt;phone_number&lt;/code&gt;, no attempt and no history. A copied call that was added by
     * &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt; gets a new scheduled caller with the same scheduled time
     * (a time in the past is due as soon as the clone runs). The whole clone is atomic: the campaign and every
     * copied call (and scheduled caller) are stored, or nothing is. The source is read in one consistent
     * snapshot and is not changed.&lt;/p&gt;
     * &lt;p&gt;With an &lt;code&gt;idempotency_key&lt;/code&gt;, a retry of the same request returns the first attempt&amp;apos;s
     * clone (see &lt;code&gt;CreateCampaignRequest.idempotency_key&lt;/code&gt;). Emits
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_CREATED&lt;/code&gt; for the clone with the attributes &lt;code&gt;cloned_from&lt;/code&gt;
     * (the source&amp;apos;s resource name) and &lt;code&gt;copied_call_count&lt;/code&gt;, and, when calls were copied,
     * &lt;code&gt;VTSI_EVENT_CAMPAIGN_CALLS_ADDED&lt;/code&gt; and one &lt;code&gt;VTSI_EVENT_SCHEDULED_CALLER_CREATED&lt;/code&gt; per
     * new scheduled caller.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed source selector (as &lt;code&gt;GetCampaign&lt;/code&gt;),
     * a &lt;code&gt;new_display_name&lt;/code&gt; over 128 characters, &lt;code&gt;call_states&lt;/code&gt; without
     * &lt;code&gt;include_calls&lt;/code&gt; or holding an unknown value, a malformed or reused
     * &lt;code&gt;idempotency_key&lt;/code&gt; or an unknown &lt;code&gt;field_mask&lt;/code&gt; path; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an
     * unknown project or source campaign; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; when &lt;code&gt;new_display_name&lt;/code&gt; is used
     * in the project; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the copied calls would exceed
     * &lt;code&gt;ONDEWO_VTSI_CAMPAIGN_MAX_CALLS&lt;/code&gt;; &lt;code&gt;ABORTED&lt;/code&gt; while a first attempt with the same
     * &lt;code&gt;idempotency_key&lt;/code&gt; is still running.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.Campaign> cloneCampaign(
        ondewo.vtsi.CampaignsOuterClass.CloneCampaignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCloneCampaignMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CAMPAIGN = 0;
  private static final int METHODID_GET_CAMPAIGN = 1;
  private static final int METHODID_UPDATE_CAMPAIGN = 2;
  private static final int METHODID_DELETE_CAMPAIGN = 3;
  private static final int METHODID_LIST_CAMPAIGNS = 4;
  private static final int METHODID_GET_CAMPAIGN_STATISTICS = 5;
  private static final int METHODID_LIST_CAMPAIGN_CALLS = 6;
  private static final int METHODID_START_CAMPAIGN = 7;
  private static final int METHODID_STOP_CAMPAIGN = 8;
  private static final int METHODID_HARD_STOP_CAMPAIGN = 9;
  private static final int METHODID_RESUME_CAMPAIGN = 10;
  private static final int METHODID_STREAM_CAMPAIGN_STATUS = 11;
  private static final int METHODID_GET_CAMPAIGN_CALL = 12;
  private static final int METHODID_CANCEL_CAMPAIGN_CALLS = 13;
  private static final int METHODID_RETRY_CAMPAIGN_CALLS = 14;
  private static final int METHODID_CLONE_CAMPAIGN = 15;

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
        case METHODID_CREATE_CAMPAIGN:
          serviceImpl.createCampaign((ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign>) responseObserver);
          break;
        case METHODID_GET_CAMPAIGN:
          serviceImpl.getCampaign((ondewo.vtsi.CampaignsOuterClass.GetCampaignRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign>) responseObserver);
          break;
        case METHODID_UPDATE_CAMPAIGN:
          serviceImpl.updateCampaign((ondewo.vtsi.CampaignsOuterClass.UpdateCampaignRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign>) responseObserver);
          break;
        case METHODID_DELETE_CAMPAIGN:
          serviceImpl.deleteCampaign((ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse>) responseObserver);
          break;
        case METHODID_LIST_CAMPAIGNS:
          serviceImpl.listCampaigns((ondewo.vtsi.CampaignsOuterClass.ListCampaignsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.ListCampaignsResponse>) responseObserver);
          break;
        case METHODID_GET_CAMPAIGN_STATISTICS:
          serviceImpl.getCampaignStatistics((ondewo.vtsi.CampaignsOuterClass.GetCampaignStatisticsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.CampaignStatistics>) responseObserver);
          break;
        case METHODID_LIST_CAMPAIGN_CALLS:
          serviceImpl.listCampaignCalls((ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsResponse>) responseObserver);
          break;
        case METHODID_START_CAMPAIGN:
          serviceImpl.startCampaign((ondewo.vtsi.CampaignsOuterClass.StartCampaignRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign>) responseObserver);
          break;
        case METHODID_STOP_CAMPAIGN:
          serviceImpl.stopCampaign((ondewo.vtsi.CampaignsOuterClass.StopCampaignRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign>) responseObserver);
          break;
        case METHODID_HARD_STOP_CAMPAIGN:
          serviceImpl.hardStopCampaign((ondewo.vtsi.CampaignsOuterClass.HardStopCampaignRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign>) responseObserver);
          break;
        case METHODID_RESUME_CAMPAIGN:
          serviceImpl.resumeCampaign((ondewo.vtsi.CampaignsOuterClass.ResumeCampaignRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign>) responseObserver);
          break;
        case METHODID_STREAM_CAMPAIGN_STATUS:
          serviceImpl.streamCampaignStatus((ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusResponse>) responseObserver);
          break;
        case METHODID_GET_CAMPAIGN_CALL:
          serviceImpl.getCampaignCall((ondewo.vtsi.CampaignsOuterClass.GetCampaignCallRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.CampaignCall>) responseObserver);
          break;
        case METHODID_CANCEL_CAMPAIGN_CALLS:
          serviceImpl.cancelCampaignCalls((ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsResponse>) responseObserver);
          break;
        case METHODID_RETRY_CAMPAIGN_CALLS:
          serviceImpl.retryCampaignCalls((ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsResponse>) responseObserver);
          break;
        case METHODID_CLONE_CAMPAIGN:
          serviceImpl.cloneCampaign((ondewo.vtsi.CampaignsOuterClass.CloneCampaignRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign>) responseObserver);
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
          getCreateCampaignMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest,
              ondewo.vtsi.CampaignsOuterClass.Campaign>(
                service, METHODID_CREATE_CAMPAIGN)))
        .addMethod(
          getGetCampaignMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CampaignsOuterClass.GetCampaignRequest,
              ondewo.vtsi.CampaignsOuterClass.Campaign>(
                service, METHODID_GET_CAMPAIGN)))
        .addMethod(
          getUpdateCampaignMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CampaignsOuterClass.UpdateCampaignRequest,
              ondewo.vtsi.CampaignsOuterClass.Campaign>(
                service, METHODID_UPDATE_CAMPAIGN)))
        .addMethod(
          getDeleteCampaignMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest,
              ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse>(
                service, METHODID_DELETE_CAMPAIGN)))
        .addMethod(
          getListCampaignsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CampaignsOuterClass.ListCampaignsRequest,
              ondewo.vtsi.CampaignsOuterClass.ListCampaignsResponse>(
                service, METHODID_LIST_CAMPAIGNS)))
        .addMethod(
          getGetCampaignStatisticsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CampaignsOuterClass.GetCampaignStatisticsRequest,
              ondewo.vtsi.CampaignsOuterClass.CampaignStatistics>(
                service, METHODID_GET_CAMPAIGN_STATISTICS)))
        .addMethod(
          getListCampaignCallsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsRequest,
              ondewo.vtsi.CampaignsOuterClass.ListCampaignCallsResponse>(
                service, METHODID_LIST_CAMPAIGN_CALLS)))
        .addMethod(
          getStartCampaignMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CampaignsOuterClass.StartCampaignRequest,
              ondewo.vtsi.CampaignsOuterClass.Campaign>(
                service, METHODID_START_CAMPAIGN)))
        .addMethod(
          getStopCampaignMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CampaignsOuterClass.StopCampaignRequest,
              ondewo.vtsi.CampaignsOuterClass.Campaign>(
                service, METHODID_STOP_CAMPAIGN)))
        .addMethod(
          getHardStopCampaignMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CampaignsOuterClass.HardStopCampaignRequest,
              ondewo.vtsi.CampaignsOuterClass.Campaign>(
                service, METHODID_HARD_STOP_CAMPAIGN)))
        .addMethod(
          getResumeCampaignMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CampaignsOuterClass.ResumeCampaignRequest,
              ondewo.vtsi.CampaignsOuterClass.Campaign>(
                service, METHODID_RESUME_CAMPAIGN)))
        .addMethod(
          getStreamCampaignStatusMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusRequest,
              ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusResponse>(
                service, METHODID_STREAM_CAMPAIGN_STATUS)))
        .addMethod(
          getGetCampaignCallMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CampaignsOuterClass.GetCampaignCallRequest,
              ondewo.vtsi.CampaignsOuterClass.CampaignCall>(
                service, METHODID_GET_CAMPAIGN_CALL)))
        .addMethod(
          getCancelCampaignCallsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsRequest,
              ondewo.vtsi.CampaignsOuterClass.CancelCampaignCallsResponse>(
                service, METHODID_CANCEL_CAMPAIGN_CALLS)))
        .addMethod(
          getRetryCampaignCallsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsRequest,
              ondewo.vtsi.CampaignsOuterClass.RetryCampaignCallsResponse>(
                service, METHODID_RETRY_CAMPAIGN_CALLS)))
        .addMethod(
          getCloneCampaignMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.CampaignsOuterClass.CloneCampaignRequest,
              ondewo.vtsi.CampaignsOuterClass.Campaign>(
                service, METHODID_CLONE_CAMPAIGN)))
        .build();
  }

  private static abstract class CampaignsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CampaignsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ondewo.vtsi.CampaignsOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Campaigns");
    }
  }

  private static final class CampaignsFileDescriptorSupplier
      extends CampaignsBaseDescriptorSupplier {
    CampaignsFileDescriptorSupplier() {}
  }

  private static final class CampaignsMethodDescriptorSupplier
      extends CampaignsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CampaignsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CampaignsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CampaignsFileDescriptorSupplier())
              .addMethod(getCreateCampaignMethod())
              .addMethod(getGetCampaignMethod())
              .addMethod(getUpdateCampaignMethod())
              .addMethod(getDeleteCampaignMethod())
              .addMethod(getListCampaignsMethod())
              .addMethod(getGetCampaignStatisticsMethod())
              .addMethod(getListCampaignCallsMethod())
              .addMethod(getStartCampaignMethod())
              .addMethod(getStopCampaignMethod())
              .addMethod(getHardStopCampaignMethod())
              .addMethod(getResumeCampaignMethod())
              .addMethod(getStreamCampaignStatusMethod())
              .addMethod(getGetCampaignCallMethod())
              .addMethod(getCancelCampaignCallsMethod())
              .addMethod(getRetryCampaignCallsMethod())
              .addMethod(getCloneCampaignMethod())
              .build();
        }
      }
    }
    return result;
  }
}
