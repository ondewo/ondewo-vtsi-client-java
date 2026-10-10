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
 * &lt;p&gt;Every RPC about ONE campaign accepts either its resource name or its display name
 * (&lt;a href="index.html#ondewo.vtsi.CampaignDisplayName"&gt;CampaignDisplayName&lt;/a&gt;); display names are
 * unique within a project.&lt;/p&gt;
 * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
 * filter, field mask or value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign
 * call; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a &lt;code&gt;display_name&lt;/code&gt; already used in the project;
 * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a state that does not allow the operation (each RPC names its
 * cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change won, nothing was stored and the request can
 * be retried; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the server has no free stream slot.&lt;/p&gt;
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
   * &lt;p&gt;Every RPC about ONE campaign accepts either its resource name or its display name
   * (&lt;a href="index.html#ondewo.vtsi.CampaignDisplayName"&gt;CampaignDisplayName&lt;/a&gt;); display names are
   * unique within a project.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, field mask or value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign
   * call; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a &lt;code&gt;display_name&lt;/code&gt; already used in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a state that does not allow the operation (each RPC names its
   * cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change won, nothing was stored and the request can
   * be retried; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the server has no free stream slot.&lt;/p&gt;
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * &lt;p&gt;Creates a campaign in state &lt;code&gt;CAMPAIGN_STATE_CREATED&lt;/code&gt;. Calls are added with
     * &lt;code&gt;AddCallersToCampaign&lt;/code&gt; / &lt;code&gt;AddScheduledCallersToCampaign&lt;/code&gt;; nothing is dialled before
     * &lt;code&gt;StartCampaign&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; if
     * the &lt;code&gt;display_name&lt;/code&gt; is used in the project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an
     * output-only field that was set or an out-of-range value.&lt;/p&gt;
     * </pre>
     */
    default void createCampaign(ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCampaignMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a campaign including its statistics.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name.&lt;/p&gt;
     * </pre>
     */
    default void getCampaign(ondewo.vtsi.CampaignsOuterClass.GetCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCampaignMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;max_parallel_calls&lt;/code&gt;, &lt;code&gt;max_attempts&lt;/code&gt;, &lt;code&gt;retry_delay&lt;/code&gt;. Allowed in
     * every state. Lowering &lt;code&gt;max_parallel_calls&lt;/code&gt; never ends a running call: the campaign
     * starts no new call until fewer than the new maximum are running.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty mask, an unknown,
     * output-only or immutable path, or an out-of-range value; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a
     * &lt;code&gt;display_name&lt;/code&gt; used by another campaign of the project.&lt;/p&gt;
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
     * &lt;code&gt;ListCalls&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the campaign is
     * &lt;code&gt;RUNNING&lt;/code&gt;, &lt;code&gt;STOPPING&lt;/code&gt; or &lt;code&gt;HARD_STOPPING&lt;/code&gt; (stop or hard stop it
     * first).&lt;/p&gt;
     * </pre>
     */
    default void deleteCampaign(ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCampaignMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the campaigns of a project, newest first, filtered and paged, each with its
     * statistics.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for a negative &lt;code&gt;page_size&lt;/code&gt; or a foreign &lt;code&gt;page_token&lt;/code&gt;.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a negative
     * &lt;code&gt;page_size&lt;/code&gt; or a foreign &lt;code&gt;page_token&lt;/code&gt;.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; in any other state (use
     * &lt;code&gt;ResumeCampaign&lt;/code&gt; for a stopped campaign).&lt;/p&gt;
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
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign.&lt;/p&gt;
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
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign.&lt;/p&gt;
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
     * &lt;code&gt;HARD_STOPPED&lt;/code&gt;) and &lt;code&gt;COMPLETED&lt;/code&gt;.&lt;/p&gt;
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
     * changed. An empty message is sent as a keep-alive. The stream ends when the client
     * disconnects or the server-side maximum stream duration is reached
     * (&lt;code&gt;end_reason&lt;/code&gt; set on the last message).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;
     * when the server has no free stream slot.&lt;/p&gt;
     * </pre>
     */
    default void streamCampaignStatus(ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamCampaignStatusMethod(), responseObserver);
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
   * &lt;p&gt;Every RPC about ONE campaign accepts either its resource name or its display name
   * (&lt;a href="index.html#ondewo.vtsi.CampaignDisplayName"&gt;CampaignDisplayName&lt;/a&gt;); display names are
   * unique within a project.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, field mask or value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign
   * call; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a &lt;code&gt;display_name&lt;/code&gt; already used in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a state that does not allow the operation (each RPC names its
   * cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change won, nothing was stored and the request can
   * be retried; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the server has no free stream slot.&lt;/p&gt;
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
   * &lt;p&gt;Every RPC about ONE campaign accepts either its resource name or its display name
   * (&lt;a href="index.html#ondewo.vtsi.CampaignDisplayName"&gt;CampaignDisplayName&lt;/a&gt;); display names are
   * unique within a project.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, field mask or value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign
   * call; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a &lt;code&gt;display_name&lt;/code&gt; already used in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a state that does not allow the operation (each RPC names its
   * cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change won, nothing was stored and the request can
   * be retried; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the server has no free stream slot.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; if
     * the &lt;code&gt;display_name&lt;/code&gt; is used in the project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an
     * output-only field that was set or an out-of-range value.&lt;/p&gt;
     * </pre>
     */
    public void createCampaign(ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.Campaign> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCampaignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a campaign including its statistics.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name.&lt;/p&gt;
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
     * &lt;code&gt;max_parallel_calls&lt;/code&gt;, &lt;code&gt;max_attempts&lt;/code&gt;, &lt;code&gt;retry_delay&lt;/code&gt;. Allowed in
     * every state. Lowering &lt;code&gt;max_parallel_calls&lt;/code&gt; never ends a running call: the campaign
     * starts no new call until fewer than the new maximum are running.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty mask, an unknown,
     * output-only or immutable path, or an out-of-range value; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a
     * &lt;code&gt;display_name&lt;/code&gt; used by another campaign of the project.&lt;/p&gt;
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
     * &lt;code&gt;ListCalls&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the campaign is
     * &lt;code&gt;RUNNING&lt;/code&gt;, &lt;code&gt;STOPPING&lt;/code&gt; or &lt;code&gt;HARD_STOPPING&lt;/code&gt; (stop or hard stop it
     * first).&lt;/p&gt;
     * </pre>
     */
    public void deleteCampaign(ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCampaignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the campaigns of a project, newest first, filtered and paged, each with its
     * statistics.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for a negative &lt;code&gt;page_size&lt;/code&gt; or a foreign &lt;code&gt;page_token&lt;/code&gt;.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a negative
     * &lt;code&gt;page_size&lt;/code&gt; or a foreign &lt;code&gt;page_token&lt;/code&gt;.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; in any other state (use
     * &lt;code&gt;ResumeCampaign&lt;/code&gt; for a stopped campaign).&lt;/p&gt;
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
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign.&lt;/p&gt;
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
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign.&lt;/p&gt;
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
     * &lt;code&gt;HARD_STOPPED&lt;/code&gt;) and &lt;code&gt;COMPLETED&lt;/code&gt;.&lt;/p&gt;
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
     * changed. An empty message is sent as a keep-alive. The stream ends when the client
     * disconnects or the server-side maximum stream duration is reached
     * (&lt;code&gt;end_reason&lt;/code&gt; set on the last message).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;
     * when the server has no free stream slot.&lt;/p&gt;
     * </pre>
     */
    public void streamCampaignStatus(ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamCampaignStatusMethod(), getCallOptions()), request, responseObserver);
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
   * &lt;p&gt;Every RPC about ONE campaign accepts either its resource name or its display name
   * (&lt;a href="index.html#ondewo.vtsi.CampaignDisplayName"&gt;CampaignDisplayName&lt;/a&gt;); display names are
   * unique within a project.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, field mask or value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign
   * call; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a &lt;code&gt;display_name&lt;/code&gt; already used in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a state that does not allow the operation (each RPC names its
   * cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change won, nothing was stored and the request can
   * be retried; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the server has no free stream slot.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; if
     * the &lt;code&gt;display_name&lt;/code&gt; is used in the project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an
     * output-only field that was set or an out-of-range value.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign createCampaign(ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a campaign including its statistics.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign getCampaign(ondewo.vtsi.CampaignsOuterClass.GetCampaignRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;max_parallel_calls&lt;/code&gt;, &lt;code&gt;max_attempts&lt;/code&gt;, &lt;code&gt;retry_delay&lt;/code&gt;. Allowed in
     * every state. Lowering &lt;code&gt;max_parallel_calls&lt;/code&gt; never ends a running call: the campaign
     * starts no new call until fewer than the new maximum are running.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty mask, an unknown,
     * output-only or immutable path, or an out-of-range value; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a
     * &lt;code&gt;display_name&lt;/code&gt; used by another campaign of the project.&lt;/p&gt;
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
     * &lt;code&gt;ListCalls&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the campaign is
     * &lt;code&gt;RUNNING&lt;/code&gt;, &lt;code&gt;STOPPING&lt;/code&gt; or &lt;code&gt;HARD_STOPPING&lt;/code&gt; (stop or hard stop it
     * first).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse deleteCampaign(ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the campaigns of a project, newest first, filtered and paged, each with its
     * statistics.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for a negative &lt;code&gt;page_size&lt;/code&gt; or a foreign &lt;code&gt;page_token&lt;/code&gt;.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a negative
     * &lt;code&gt;page_size&lt;/code&gt; or a foreign &lt;code&gt;page_token&lt;/code&gt;.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; in any other state (use
     * &lt;code&gt;ResumeCampaign&lt;/code&gt; for a stopped campaign).&lt;/p&gt;
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
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign.&lt;/p&gt;
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
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign.&lt;/p&gt;
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
     * &lt;code&gt;HARD_STOPPED&lt;/code&gt;) and &lt;code&gt;COMPLETED&lt;/code&gt;.&lt;/p&gt;
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
     * changed. An empty message is sent as a keep-alive. The stream ends when the client
     * disconnects or the server-side maximum stream duration is reached
     * (&lt;code&gt;end_reason&lt;/code&gt; set on the last message).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;
     * when the server has no free stream slot.&lt;/p&gt;
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusResponse>
        streamCampaignStatus(ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getStreamCampaignStatusMethod(), getCallOptions(), request);
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
   * &lt;p&gt;Every RPC about ONE campaign accepts either its resource name or its display name
   * (&lt;a href="index.html#ondewo.vtsi.CampaignDisplayName"&gt;CampaignDisplayName&lt;/a&gt;); display names are
   * unique within a project.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, field mask or value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign
   * call; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a &lt;code&gt;display_name&lt;/code&gt; already used in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a state that does not allow the operation (each RPC names its
   * cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change won, nothing was stored and the request can
   * be retried; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the server has no free stream slot.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; if
     * the &lt;code&gt;display_name&lt;/code&gt; is used in the project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an
     * output-only field that was set or an out-of-range value.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign createCampaign(ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a campaign including its statistics.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.Campaign getCampaign(ondewo.vtsi.CampaignsOuterClass.GetCampaignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;max_parallel_calls&lt;/code&gt;, &lt;code&gt;max_attempts&lt;/code&gt;, &lt;code&gt;retry_delay&lt;/code&gt;. Allowed in
     * every state. Lowering &lt;code&gt;max_parallel_calls&lt;/code&gt; never ends a running call: the campaign
     * starts no new call until fewer than the new maximum are running.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty mask, an unknown,
     * output-only or immutable path, or an out-of-range value; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a
     * &lt;code&gt;display_name&lt;/code&gt; used by another campaign of the project.&lt;/p&gt;
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
     * &lt;code&gt;ListCalls&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the campaign is
     * &lt;code&gt;RUNNING&lt;/code&gt;, &lt;code&gt;STOPPING&lt;/code&gt; or &lt;code&gt;HARD_STOPPING&lt;/code&gt; (stop or hard stop it
     * first).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse deleteCampaign(ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCampaignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the campaigns of a project, newest first, filtered and paged, each with its
     * statistics.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for a negative &lt;code&gt;page_size&lt;/code&gt; or a foreign &lt;code&gt;page_token&lt;/code&gt;.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a negative
     * &lt;code&gt;page_size&lt;/code&gt; or a foreign &lt;code&gt;page_token&lt;/code&gt;.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; in any other state (use
     * &lt;code&gt;ResumeCampaign&lt;/code&gt; for a stopped campaign).&lt;/p&gt;
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
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign.&lt;/p&gt;
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
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign.&lt;/p&gt;
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
     * &lt;code&gt;HARD_STOPPED&lt;/code&gt;) and &lt;code&gt;COMPLETED&lt;/code&gt;.&lt;/p&gt;
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
     * changed. An empty message is sent as a keep-alive. The stream ends when the client
     * disconnects or the server-side maximum stream duration is reached
     * (&lt;code&gt;end_reason&lt;/code&gt; set on the last message).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;
     * when the server has no free stream slot.&lt;/p&gt;
     * </pre>
     */
    public java.util.Iterator<ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusResponse> streamCampaignStatus(
        ondewo.vtsi.CampaignsOuterClass.StreamCampaignStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamCampaignStatusMethod(), getCallOptions(), request);
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
   * &lt;p&gt;Every RPC about ONE campaign accepts either its resource name or its display name
   * (&lt;a href="index.html#ondewo.vtsi.CampaignDisplayName"&gt;CampaignDisplayName&lt;/a&gt;); display names are
   * unique within a project.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name,
   * filter, field mask or value; &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, campaign or campaign
   * call; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a &lt;code&gt;display_name&lt;/code&gt; already used in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a state that does not allow the operation (each RPC names its
   * cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change won, nothing was stored and the request can
   * be retried; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; when the server has no free stream slot.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; if
     * the &lt;code&gt;display_name&lt;/code&gt; is used in the project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an
     * output-only field that was set or an out-of-range value.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.Campaign> createCampaign(
        ondewo.vtsi.CampaignsOuterClass.CreateCampaignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCampaignMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a campaign including its statistics.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name.&lt;/p&gt;
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
     * &lt;code&gt;max_parallel_calls&lt;/code&gt;, &lt;code&gt;max_attempts&lt;/code&gt;, &lt;code&gt;retry_delay&lt;/code&gt;. Allowed in
     * every state. Lowering &lt;code&gt;max_parallel_calls&lt;/code&gt; never ends a running call: the campaign
     * starts no new call until fewer than the new maximum are running.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an empty mask, an unknown,
     * output-only or immutable path, or an out-of-range value; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a
     * &lt;code&gt;display_name&lt;/code&gt; used by another campaign of the project.&lt;/p&gt;
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
     * &lt;code&gt;ListCalls&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; while the campaign is
     * &lt;code&gt;RUNNING&lt;/code&gt;, &lt;code&gt;STOPPING&lt;/code&gt; or &lt;code&gt;HARD_STOPPING&lt;/code&gt; (stop or hard stop it
     * first).&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.DeleteCampaignResponse> deleteCampaign(
        ondewo.vtsi.CampaignsOuterClass.DeleteCampaignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCampaignMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the campaigns of a project, newest first, filtered and paged, each with its
     * statistics.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for a negative &lt;code&gt;page_size&lt;/code&gt; or a foreign &lt;code&gt;page_token&lt;/code&gt;.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a negative
     * &lt;code&gt;page_size&lt;/code&gt; or a foreign &lt;code&gt;page_token&lt;/code&gt;.&lt;/p&gt;
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
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; in any other state (use
     * &lt;code&gt;ResumeCampaign&lt;/code&gt; for a stopped campaign).&lt;/p&gt;
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
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign.&lt;/p&gt;
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
     * &lt;code&gt;COMPLETED&lt;/code&gt; campaign.&lt;/p&gt;
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
     * &lt;code&gt;HARD_STOPPED&lt;/code&gt;) and &lt;code&gt;COMPLETED&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.CampaignsOuterClass.Campaign> resumeCampaign(
        ondewo.vtsi.CampaignsOuterClass.ResumeCampaignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResumeCampaignMethod(), getCallOptions()), request);
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
              .build();
        }
      }
    }
    return result;
  }
}
