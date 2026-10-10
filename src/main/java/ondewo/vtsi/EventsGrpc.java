package ondewo.vtsi;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
 * &lt;p&gt;Notifies other systems of VTSI events: calls, callers, listeners, scheduled callers,
 * campaigns, VTSI projects, the project&amp;apos;s Asterisk and softphone accounts. Every event is one
 * value of &lt;a href="index.html#ondewo.vtsi.VtsiEvent"&gt;VtsiEvent&lt;/a&gt; and is delivered as a
 * &lt;a href="index.html#ondewo.vtsi.VtsiEventMessage"&gt;VtsiEventMessage&lt;/a&gt;.&lt;/p&gt;
 * &lt;p&gt;Two delivery paths: the server-streaming &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt; RPC, and WEBHOOKS
 * (an HTTP request per event to a URL of the client&amp;apos;s choice). Which events go to which
 * webhooks is configured per project with EVENT SUBSCRIPTIONS.&lt;/p&gt;
 * &lt;p&gt;&lt;b&gt;Webhooks are best effort.&lt;/b&gt; Each event is sent to a webhook as at most
 * &lt;code&gt;ONDEWO_VTSI_WEBHOOK_MAX_ATTEMPTS&lt;/code&gt; HTTP requests (3 by default) with backoff between
 * them; after the last one fails, the event is dropped for that webhook. Pending webhook requests
 * live in the memory of the server replica that produced the event and are lost when it restarts.
 * An overloaded server, or a webhook that keeps timing out, drops events rather than slowing calls
 * down. The same event can arrive more than once (a request whose answer was lost is sent again):
 * de-duplicate by &lt;code&gt;event_id&lt;/code&gt;. Requests of one webhook can arrive out of order, because
 * several server replicas send independently: order by &lt;code&gt;resource_sequence&lt;/code&gt; per
 * &lt;code&gt;resource_name&lt;/code&gt;, then &lt;code&gt;event_time&lt;/code&gt;.&lt;/p&gt;
 * &lt;p&gt;&lt;b&gt;Streams can be resumed.&lt;/b&gt; While a project has an open &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt;
 * stream or an enabled event subscription, its events are also written to a short-lived journal
 * (24 h by default). A stream that reconnects with its last &lt;code&gt;resume_token&lt;/code&gt; receives the
 * events it missed, provided they are still in the journal; nothing else is persisted for
 * redelivery.&lt;/p&gt;
 * &lt;p&gt;Use the status RPCs (&lt;code&gt;GetCampaign&lt;/code&gt;, &lt;code&gt;ListCalls&lt;/code&gt;, the status streams) to
 * reconcile.&lt;/p&gt;
 * &lt;p&gt;&lt;b&gt;Custom header values are write-only.&lt;/b&gt; They are returned as &lt;code&gt;********&lt;/code&gt; by every
 * RPC and are never logged.&lt;/p&gt;
 * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, &lt;code&gt;NOT_FOUND&lt;/code&gt;,
 * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;, &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; (no free stream slot).&lt;/p&gt;
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class EventsGrpc {

  private EventsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ondewo.vtsi.Events";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.CreateVtsiEventSubscriptionRequest,
      ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> getCreateVtsiEventSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateVtsiEventSubscription",
      requestType = ondewo.vtsi.EventsOuterClass.CreateVtsiEventSubscriptionRequest.class,
      responseType = ondewo.vtsi.EventsOuterClass.VtsiEventSubscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.CreateVtsiEventSubscriptionRequest,
      ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> getCreateVtsiEventSubscriptionMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.CreateVtsiEventSubscriptionRequest, ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> getCreateVtsiEventSubscriptionMethod;
    if ((getCreateVtsiEventSubscriptionMethod = EventsGrpc.getCreateVtsiEventSubscriptionMethod) == null) {
      synchronized (EventsGrpc.class) {
        if ((getCreateVtsiEventSubscriptionMethod = EventsGrpc.getCreateVtsiEventSubscriptionMethod) == null) {
          EventsGrpc.getCreateVtsiEventSubscriptionMethod = getCreateVtsiEventSubscriptionMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.EventsOuterClass.CreateVtsiEventSubscriptionRequest, ondewo.vtsi.EventsOuterClass.VtsiEventSubscription>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateVtsiEventSubscription"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.CreateVtsiEventSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.VtsiEventSubscription.getDefaultInstance()))
              .setSchemaDescriptor(new EventsMethodDescriptorSupplier("CreateVtsiEventSubscription"))
              .build();
        }
      }
    }
    return getCreateVtsiEventSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.GetVtsiEventSubscriptionRequest,
      ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> getGetVtsiEventSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVtsiEventSubscription",
      requestType = ondewo.vtsi.EventsOuterClass.GetVtsiEventSubscriptionRequest.class,
      responseType = ondewo.vtsi.EventsOuterClass.VtsiEventSubscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.GetVtsiEventSubscriptionRequest,
      ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> getGetVtsiEventSubscriptionMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.GetVtsiEventSubscriptionRequest, ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> getGetVtsiEventSubscriptionMethod;
    if ((getGetVtsiEventSubscriptionMethod = EventsGrpc.getGetVtsiEventSubscriptionMethod) == null) {
      synchronized (EventsGrpc.class) {
        if ((getGetVtsiEventSubscriptionMethod = EventsGrpc.getGetVtsiEventSubscriptionMethod) == null) {
          EventsGrpc.getGetVtsiEventSubscriptionMethod = getGetVtsiEventSubscriptionMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.EventsOuterClass.GetVtsiEventSubscriptionRequest, ondewo.vtsi.EventsOuterClass.VtsiEventSubscription>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVtsiEventSubscription"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.GetVtsiEventSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.VtsiEventSubscription.getDefaultInstance()))
              .setSchemaDescriptor(new EventsMethodDescriptorSupplier("GetVtsiEventSubscription"))
              .build();
        }
      }
    }
    return getGetVtsiEventSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.UpdateVtsiEventSubscriptionRequest,
      ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> getUpdateVtsiEventSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVtsiEventSubscription",
      requestType = ondewo.vtsi.EventsOuterClass.UpdateVtsiEventSubscriptionRequest.class,
      responseType = ondewo.vtsi.EventsOuterClass.VtsiEventSubscription.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.UpdateVtsiEventSubscriptionRequest,
      ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> getUpdateVtsiEventSubscriptionMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.UpdateVtsiEventSubscriptionRequest, ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> getUpdateVtsiEventSubscriptionMethod;
    if ((getUpdateVtsiEventSubscriptionMethod = EventsGrpc.getUpdateVtsiEventSubscriptionMethod) == null) {
      synchronized (EventsGrpc.class) {
        if ((getUpdateVtsiEventSubscriptionMethod = EventsGrpc.getUpdateVtsiEventSubscriptionMethod) == null) {
          EventsGrpc.getUpdateVtsiEventSubscriptionMethod = getUpdateVtsiEventSubscriptionMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.EventsOuterClass.UpdateVtsiEventSubscriptionRequest, ondewo.vtsi.EventsOuterClass.VtsiEventSubscription>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateVtsiEventSubscription"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.UpdateVtsiEventSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.VtsiEventSubscription.getDefaultInstance()))
              .setSchemaDescriptor(new EventsMethodDescriptorSupplier("UpdateVtsiEventSubscription"))
              .build();
        }
      }
    }
    return getUpdateVtsiEventSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionRequest,
      ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionResponse> getDeleteVtsiEventSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteVtsiEventSubscription",
      requestType = ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionRequest.class,
      responseType = ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionRequest,
      ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionResponse> getDeleteVtsiEventSubscriptionMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionRequest, ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionResponse> getDeleteVtsiEventSubscriptionMethod;
    if ((getDeleteVtsiEventSubscriptionMethod = EventsGrpc.getDeleteVtsiEventSubscriptionMethod) == null) {
      synchronized (EventsGrpc.class) {
        if ((getDeleteVtsiEventSubscriptionMethod = EventsGrpc.getDeleteVtsiEventSubscriptionMethod) == null) {
          EventsGrpc.getDeleteVtsiEventSubscriptionMethod = getDeleteVtsiEventSubscriptionMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionRequest, ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteVtsiEventSubscription"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EventsMethodDescriptorSupplier("DeleteVtsiEventSubscription"))
              .build();
        }
      }
    }
    return getDeleteVtsiEventSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsRequest,
      ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsResponse> getListVtsiEventSubscriptionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVtsiEventSubscriptions",
      requestType = ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsRequest.class,
      responseType = ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsRequest,
      ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsResponse> getListVtsiEventSubscriptionsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsRequest, ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsResponse> getListVtsiEventSubscriptionsMethod;
    if ((getListVtsiEventSubscriptionsMethod = EventsGrpc.getListVtsiEventSubscriptionsMethod) == null) {
      synchronized (EventsGrpc.class) {
        if ((getListVtsiEventSubscriptionsMethod = EventsGrpc.getListVtsiEventSubscriptionsMethod) == null) {
          EventsGrpc.getListVtsiEventSubscriptionsMethod = getListVtsiEventSubscriptionsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsRequest, ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVtsiEventSubscriptions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EventsMethodDescriptorSupplier("ListVtsiEventSubscriptions"))
              .build();
        }
      }
    }
    return getListVtsiEventSubscriptionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.CreateWebhookRequest,
      ondewo.vtsi.EventsOuterClass.Webhook> getCreateWebhookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateWebhook",
      requestType = ondewo.vtsi.EventsOuterClass.CreateWebhookRequest.class,
      responseType = ondewo.vtsi.EventsOuterClass.Webhook.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.CreateWebhookRequest,
      ondewo.vtsi.EventsOuterClass.Webhook> getCreateWebhookMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.CreateWebhookRequest, ondewo.vtsi.EventsOuterClass.Webhook> getCreateWebhookMethod;
    if ((getCreateWebhookMethod = EventsGrpc.getCreateWebhookMethod) == null) {
      synchronized (EventsGrpc.class) {
        if ((getCreateWebhookMethod = EventsGrpc.getCreateWebhookMethod) == null) {
          EventsGrpc.getCreateWebhookMethod = getCreateWebhookMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.EventsOuterClass.CreateWebhookRequest, ondewo.vtsi.EventsOuterClass.Webhook>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateWebhook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.CreateWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.Webhook.getDefaultInstance()))
              .setSchemaDescriptor(new EventsMethodDescriptorSupplier("CreateWebhook"))
              .build();
        }
      }
    }
    return getCreateWebhookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.GetWebhookRequest,
      ondewo.vtsi.EventsOuterClass.Webhook> getGetWebhookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWebhook",
      requestType = ondewo.vtsi.EventsOuterClass.GetWebhookRequest.class,
      responseType = ondewo.vtsi.EventsOuterClass.Webhook.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.GetWebhookRequest,
      ondewo.vtsi.EventsOuterClass.Webhook> getGetWebhookMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.GetWebhookRequest, ondewo.vtsi.EventsOuterClass.Webhook> getGetWebhookMethod;
    if ((getGetWebhookMethod = EventsGrpc.getGetWebhookMethod) == null) {
      synchronized (EventsGrpc.class) {
        if ((getGetWebhookMethod = EventsGrpc.getGetWebhookMethod) == null) {
          EventsGrpc.getGetWebhookMethod = getGetWebhookMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.EventsOuterClass.GetWebhookRequest, ondewo.vtsi.EventsOuterClass.Webhook>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWebhook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.GetWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.Webhook.getDefaultInstance()))
              .setSchemaDescriptor(new EventsMethodDescriptorSupplier("GetWebhook"))
              .build();
        }
      }
    }
    return getGetWebhookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.UpdateWebhookRequest,
      ondewo.vtsi.EventsOuterClass.Webhook> getUpdateWebhookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWebhook",
      requestType = ondewo.vtsi.EventsOuterClass.UpdateWebhookRequest.class,
      responseType = ondewo.vtsi.EventsOuterClass.Webhook.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.UpdateWebhookRequest,
      ondewo.vtsi.EventsOuterClass.Webhook> getUpdateWebhookMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.UpdateWebhookRequest, ondewo.vtsi.EventsOuterClass.Webhook> getUpdateWebhookMethod;
    if ((getUpdateWebhookMethod = EventsGrpc.getUpdateWebhookMethod) == null) {
      synchronized (EventsGrpc.class) {
        if ((getUpdateWebhookMethod = EventsGrpc.getUpdateWebhookMethod) == null) {
          EventsGrpc.getUpdateWebhookMethod = getUpdateWebhookMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.EventsOuterClass.UpdateWebhookRequest, ondewo.vtsi.EventsOuterClass.Webhook>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateWebhook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.UpdateWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.Webhook.getDefaultInstance()))
              .setSchemaDescriptor(new EventsMethodDescriptorSupplier("UpdateWebhook"))
              .build();
        }
      }
    }
    return getUpdateWebhookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.DeleteWebhookRequest,
      ondewo.vtsi.EventsOuterClass.DeleteWebhookResponse> getDeleteWebhookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteWebhook",
      requestType = ondewo.vtsi.EventsOuterClass.DeleteWebhookRequest.class,
      responseType = ondewo.vtsi.EventsOuterClass.DeleteWebhookResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.DeleteWebhookRequest,
      ondewo.vtsi.EventsOuterClass.DeleteWebhookResponse> getDeleteWebhookMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.DeleteWebhookRequest, ondewo.vtsi.EventsOuterClass.DeleteWebhookResponse> getDeleteWebhookMethod;
    if ((getDeleteWebhookMethod = EventsGrpc.getDeleteWebhookMethod) == null) {
      synchronized (EventsGrpc.class) {
        if ((getDeleteWebhookMethod = EventsGrpc.getDeleteWebhookMethod) == null) {
          EventsGrpc.getDeleteWebhookMethod = getDeleteWebhookMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.EventsOuterClass.DeleteWebhookRequest, ondewo.vtsi.EventsOuterClass.DeleteWebhookResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteWebhook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.DeleteWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.DeleteWebhookResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EventsMethodDescriptorSupplier("DeleteWebhook"))
              .build();
        }
      }
    }
    return getDeleteWebhookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.ListWebhooksRequest,
      ondewo.vtsi.EventsOuterClass.ListWebhooksResponse> getListWebhooksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWebhooks",
      requestType = ondewo.vtsi.EventsOuterClass.ListWebhooksRequest.class,
      responseType = ondewo.vtsi.EventsOuterClass.ListWebhooksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.ListWebhooksRequest,
      ondewo.vtsi.EventsOuterClass.ListWebhooksResponse> getListWebhooksMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.ListWebhooksRequest, ondewo.vtsi.EventsOuterClass.ListWebhooksResponse> getListWebhooksMethod;
    if ((getListWebhooksMethod = EventsGrpc.getListWebhooksMethod) == null) {
      synchronized (EventsGrpc.class) {
        if ((getListWebhooksMethod = EventsGrpc.getListWebhooksMethod) == null) {
          EventsGrpc.getListWebhooksMethod = getListWebhooksMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.EventsOuterClass.ListWebhooksRequest, ondewo.vtsi.EventsOuterClass.ListWebhooksResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListWebhooks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.ListWebhooksRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.ListWebhooksResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EventsMethodDescriptorSupplier("ListWebhooks"))
              .build();
        }
      }
    }
    return getListWebhooksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.TestWebhookRequest,
      ondewo.vtsi.EventsOuterClass.TestWebhookResponse> getTestWebhookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestWebhook",
      requestType = ondewo.vtsi.EventsOuterClass.TestWebhookRequest.class,
      responseType = ondewo.vtsi.EventsOuterClass.TestWebhookResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.TestWebhookRequest,
      ondewo.vtsi.EventsOuterClass.TestWebhookResponse> getTestWebhookMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.TestWebhookRequest, ondewo.vtsi.EventsOuterClass.TestWebhookResponse> getTestWebhookMethod;
    if ((getTestWebhookMethod = EventsGrpc.getTestWebhookMethod) == null) {
      synchronized (EventsGrpc.class) {
        if ((getTestWebhookMethod = EventsGrpc.getTestWebhookMethod) == null) {
          EventsGrpc.getTestWebhookMethod = getTestWebhookMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.EventsOuterClass.TestWebhookRequest, ondewo.vtsi.EventsOuterClass.TestWebhookResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestWebhook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.TestWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.TestWebhookResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EventsMethodDescriptorSupplier("TestWebhook"))
              .build();
        }
      }
    }
    return getTestWebhookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsRequest,
      ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsResponse> getSubscribeVtsiEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubscribeVtsiEvents",
      requestType = ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsRequest.class,
      responseType = ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsRequest,
      ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsResponse> getSubscribeVtsiEventsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsRequest, ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsResponse> getSubscribeVtsiEventsMethod;
    if ((getSubscribeVtsiEventsMethod = EventsGrpc.getSubscribeVtsiEventsMethod) == null) {
      synchronized (EventsGrpc.class) {
        if ((getSubscribeVtsiEventsMethod = EventsGrpc.getSubscribeVtsiEventsMethod) == null) {
          EventsGrpc.getSubscribeVtsiEventsMethod = getSubscribeVtsiEventsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsRequest, ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubscribeVtsiEvents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EventsMethodDescriptorSupplier("SubscribeVtsiEvents"))
              .build();
        }
      }
    }
    return getSubscribeVtsiEventsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EventsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventsStub>() {
        @java.lang.Override
        public EventsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventsStub(channel, callOptions);
        }
      };
    return EventsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static EventsBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventsBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventsBlockingV2Stub>() {
        @java.lang.Override
        public EventsBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventsBlockingV2Stub(channel, callOptions);
        }
      };
    return EventsBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventsBlockingStub>() {
        @java.lang.Override
        public EventsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventsBlockingStub(channel, callOptions);
        }
      };
    return EventsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EventsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventsFutureStub>() {
        @java.lang.Override
        public EventsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventsFutureStub(channel, callOptions);
        }
      };
    return EventsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Notifies other systems of VTSI events: calls, callers, listeners, scheduled callers,
   * campaigns, VTSI projects, the project&amp;apos;s Asterisk and softphone accounts. Every event is one
   * value of &lt;a href="index.html#ondewo.vtsi.VtsiEvent"&gt;VtsiEvent&lt;/a&gt; and is delivered as a
   * &lt;a href="index.html#ondewo.vtsi.VtsiEventMessage"&gt;VtsiEventMessage&lt;/a&gt;.&lt;/p&gt;
   * &lt;p&gt;Two delivery paths: the server-streaming &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt; RPC, and WEBHOOKS
   * (an HTTP request per event to a URL of the client&amp;apos;s choice). Which events go to which
   * webhooks is configured per project with EVENT SUBSCRIPTIONS.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Webhooks are best effort.&lt;/b&gt; Each event is sent to a webhook as at most
   * &lt;code&gt;ONDEWO_VTSI_WEBHOOK_MAX_ATTEMPTS&lt;/code&gt; HTTP requests (3 by default) with backoff between
   * them; after the last one fails, the event is dropped for that webhook. Pending webhook requests
   * live in the memory of the server replica that produced the event and are lost when it restarts.
   * An overloaded server, or a webhook that keeps timing out, drops events rather than slowing calls
   * down. The same event can arrive more than once (a request whose answer was lost is sent again):
   * de-duplicate by &lt;code&gt;event_id&lt;/code&gt;. Requests of one webhook can arrive out of order, because
   * several server replicas send independently: order by &lt;code&gt;resource_sequence&lt;/code&gt; per
   * &lt;code&gt;resource_name&lt;/code&gt;, then &lt;code&gt;event_time&lt;/code&gt;.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Streams can be resumed.&lt;/b&gt; While a project has an open &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt;
   * stream or an enabled event subscription, its events are also written to a short-lived journal
   * (24 h by default). A stream that reconnects with its last &lt;code&gt;resume_token&lt;/code&gt; receives the
   * events it missed, provided they are still in the journal; nothing else is persisted for
   * redelivery.&lt;/p&gt;
   * &lt;p&gt;Use the status RPCs (&lt;code&gt;GetCampaign&lt;/code&gt;, &lt;code&gt;ListCalls&lt;/code&gt;, the status streams) to
   * reconcile.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Custom header values are write-only.&lt;/b&gt; They are returned as &lt;code&gt;********&lt;/code&gt; by every
   * RPC and are never logged.&lt;/p&gt;
   * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, &lt;code&gt;NOT_FOUND&lt;/code&gt;,
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;, &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; (no free stream slot).&lt;/p&gt;
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * &lt;p&gt;Creates an event subscription: which events of the project are delivered to which
     * webhooks. A subscription without webhooks is usable by &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or webhook; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for no events and &lt;code&gt;all_events&lt;/code&gt; unset, &lt;code&gt;events&lt;/code&gt; together with
     * &lt;code&gt;all_events&lt;/code&gt;, &lt;code&gt;VTSI_EVENT_UNSPECIFIED&lt;/code&gt; or a reserved value, a webhook or a
     * campaign name of another project, a malformed campaign name, or an output-only field that was
     * set. A campaign named in &lt;code&gt;campaign_names&lt;/code&gt; need not exist (it may be created later
     * or deleted since).&lt;/p&gt;
     * </pre>
     */
    default void createVtsiEventSubscription(ondewo.vtsi.EventsOuterClass.CreateVtsiEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateVtsiEventSubscriptionMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns an event subscription.&lt;/p&gt;
     * </pre>
     */
    default void getVtsiEventSubscription(ondewo.vtsi.EventsOuterClass.GetVtsiEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVtsiEventSubscriptionMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;events&lt;/code&gt;, &lt;code&gt;all_events&lt;/code&gt;, &lt;code&gt;resource_name_prefixes&lt;/code&gt;,
     * &lt;code&gt;campaign_names&lt;/code&gt;, &lt;code&gt;webhook_names&lt;/code&gt;, &lt;code&gt;disabled&lt;/code&gt;. Takes effect
     * within a few seconds on every server replica.&lt;/p&gt;
     * </pre>
     */
    default void updateVtsiEventSubscription(ondewo.vtsi.EventsOuterClass.UpdateVtsiEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateVtsiEventSubscriptionMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes an event subscription. Open &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt; streams that name it
     * end with &lt;code&gt;end_reason&lt;/code&gt; set.&lt;/p&gt;
     * </pre>
     */
    default void deleteVtsiEventSubscription(ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteVtsiEventSubscriptionMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the event subscriptions of a project, paged.&lt;/p&gt;
     * </pre>
     */
    default void listVtsiEventSubscriptions(ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListVtsiEventSubscriptionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a webhook: an HTTP(S) endpoint that receives one request per event, with a JSON
     * body holding the &lt;code&gt;VtsiEventMessage&lt;/code&gt; (proto3 JSON, original field names).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a
     * URL that is not http(s), has no host, carries user information (use a custom header for
     * credentials) or exceeds 2048 characters; for a reserved or malformed header name, a header
     * value with a line break, too many or too long headers; or for a timeout outside
     * 1 s to 30 s.&lt;/p&gt;
     * </pre>
     */
    default void createWebhook(ondewo.vtsi.EventsOuterClass.CreateWebhookRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.Webhook> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateWebhookMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a webhook. Custom header values are masked.&lt;/p&gt;
     * </pre>
     */
    default void getWebhook(ondewo.vtsi.EventsOuterClass.GetWebhookRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.Webhook> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWebhookMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;url&lt;/code&gt;, &lt;code&gt;http_method&lt;/code&gt;, &lt;code&gt;custom_headers&lt;/code&gt;, &lt;code&gt;disabled&lt;/code&gt;,
     * &lt;code&gt;timeout&lt;/code&gt;. &lt;code&gt;custom_headers&lt;/code&gt; replaces the whole map; a value equal to the
     * mask &lt;code&gt;********&lt;/code&gt; keeps the stored value of that header, so a Get-modify-Update
     * round trip does not overwrite secrets with the mask.&lt;/p&gt;
     * &lt;p&gt;Moving the webhook to another origin (scheme, host or port of &lt;code&gt;url&lt;/code&gt;) while custom
     * headers are stored requires re-sending &lt;code&gt;custom_headers&lt;/code&gt; in the same request, with
     * their REAL values (or an empty map to drop them): the stored values are never carried to a new
     * origin, and an update that leaves &lt;code&gt;custom_headers&lt;/code&gt; out of the mask or sends the mask
     * value &lt;code&gt;********&lt;/code&gt; for any header is rejected with &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; naming
     * the headers. A new path on the same origin keeps the stored values.&lt;/p&gt;
     * </pre>
     */
    default void updateWebhook(ondewo.vtsi.EventsOuterClass.UpdateWebhookRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.Webhook> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateWebhookMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a webhook and removes it from every event subscription.&lt;/p&gt;
     * </pre>
     */
    default void deleteWebhook(ondewo.vtsi.EventsOuterClass.DeleteWebhookRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.DeleteWebhookResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteWebhookMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the webhooks of a project, paged. Custom header values are masked.&lt;/p&gt;
     * </pre>
     */
    default void listWebhooks(ondewo.vtsi.EventsOuterClass.ListWebhooksRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.ListWebhooksResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListWebhooksMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Sends one &lt;code&gt;VTSI_EVENT_WEBHOOK_TEST&lt;/code&gt; event to a webhook now, without retries,
     * and reports the outcome. Works on a disabled webhook too, and ignores an open circuit.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;. A failed delivery is reported in the response, not as an
     * error status.&lt;/p&gt;
     * </pre>
     */
    default void testWebhook(ondewo.vtsi.EventsOuterClass.TestWebhookRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.TestWebhookResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTestWebhookMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the events of a project as they happen, selected either by a named event
     * subscription or by an inline filter. An empty message is sent as a keep-alive. After a
     * disconnect, pass the last &lt;code&gt;resume_token&lt;/code&gt; to continue where the stream stopped;
     * events older than the server&amp;apos;s retention (24 h by default) are no longer available, and
     * the journal records a project&amp;apos;s events only while it has an open stream (and for 1 h
     * after the last one closed) or an enabled event subscription. A stream sees events of other
     * server replicas from at most a few seconds after it opened. A client that stops reading for
     * longer than the server&amp;apos;s stall timeout (30 s by default) is disconnected; reconnect with
     * the &lt;code&gt;resume_token&lt;/code&gt;. When the project is deleted, the stream delivers
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DELETED&lt;/code&gt; and ends.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or subscription;
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;resume_token&lt;/code&gt;;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a disabled subscription; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;
     * when the server has no free stream slot.&lt;/p&gt;
     * </pre>
     */
    default void subscribeVtsiEvents(ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeVtsiEventsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Events.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Notifies other systems of VTSI events: calls, callers, listeners, scheduled callers,
   * campaigns, VTSI projects, the project&amp;apos;s Asterisk and softphone accounts. Every event is one
   * value of &lt;a href="index.html#ondewo.vtsi.VtsiEvent"&gt;VtsiEvent&lt;/a&gt; and is delivered as a
   * &lt;a href="index.html#ondewo.vtsi.VtsiEventMessage"&gt;VtsiEventMessage&lt;/a&gt;.&lt;/p&gt;
   * &lt;p&gt;Two delivery paths: the server-streaming &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt; RPC, and WEBHOOKS
   * (an HTTP request per event to a URL of the client&amp;apos;s choice). Which events go to which
   * webhooks is configured per project with EVENT SUBSCRIPTIONS.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Webhooks are best effort.&lt;/b&gt; Each event is sent to a webhook as at most
   * &lt;code&gt;ONDEWO_VTSI_WEBHOOK_MAX_ATTEMPTS&lt;/code&gt; HTTP requests (3 by default) with backoff between
   * them; after the last one fails, the event is dropped for that webhook. Pending webhook requests
   * live in the memory of the server replica that produced the event and are lost when it restarts.
   * An overloaded server, or a webhook that keeps timing out, drops events rather than slowing calls
   * down. The same event can arrive more than once (a request whose answer was lost is sent again):
   * de-duplicate by &lt;code&gt;event_id&lt;/code&gt;. Requests of one webhook can arrive out of order, because
   * several server replicas send independently: order by &lt;code&gt;resource_sequence&lt;/code&gt; per
   * &lt;code&gt;resource_name&lt;/code&gt;, then &lt;code&gt;event_time&lt;/code&gt;.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Streams can be resumed.&lt;/b&gt; While a project has an open &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt;
   * stream or an enabled event subscription, its events are also written to a short-lived journal
   * (24 h by default). A stream that reconnects with its last &lt;code&gt;resume_token&lt;/code&gt; receives the
   * events it missed, provided they are still in the journal; nothing else is persisted for
   * redelivery.&lt;/p&gt;
   * &lt;p&gt;Use the status RPCs (&lt;code&gt;GetCampaign&lt;/code&gt;, &lt;code&gt;ListCalls&lt;/code&gt;, the status streams) to
   * reconcile.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Custom header values are write-only.&lt;/b&gt; They are returned as &lt;code&gt;********&lt;/code&gt; by every
   * RPC and are never logged.&lt;/p&gt;
   * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, &lt;code&gt;NOT_FOUND&lt;/code&gt;,
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;, &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; (no free stream slot).&lt;/p&gt;
   * </pre>
   */
  public static abstract class EventsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return EventsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Events.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Notifies other systems of VTSI events: calls, callers, listeners, scheduled callers,
   * campaigns, VTSI projects, the project&amp;apos;s Asterisk and softphone accounts. Every event is one
   * value of &lt;a href="index.html#ondewo.vtsi.VtsiEvent"&gt;VtsiEvent&lt;/a&gt; and is delivered as a
   * &lt;a href="index.html#ondewo.vtsi.VtsiEventMessage"&gt;VtsiEventMessage&lt;/a&gt;.&lt;/p&gt;
   * &lt;p&gt;Two delivery paths: the server-streaming &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt; RPC, and WEBHOOKS
   * (an HTTP request per event to a URL of the client&amp;apos;s choice). Which events go to which
   * webhooks is configured per project with EVENT SUBSCRIPTIONS.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Webhooks are best effort.&lt;/b&gt; Each event is sent to a webhook as at most
   * &lt;code&gt;ONDEWO_VTSI_WEBHOOK_MAX_ATTEMPTS&lt;/code&gt; HTTP requests (3 by default) with backoff between
   * them; after the last one fails, the event is dropped for that webhook. Pending webhook requests
   * live in the memory of the server replica that produced the event and are lost when it restarts.
   * An overloaded server, or a webhook that keeps timing out, drops events rather than slowing calls
   * down. The same event can arrive more than once (a request whose answer was lost is sent again):
   * de-duplicate by &lt;code&gt;event_id&lt;/code&gt;. Requests of one webhook can arrive out of order, because
   * several server replicas send independently: order by &lt;code&gt;resource_sequence&lt;/code&gt; per
   * &lt;code&gt;resource_name&lt;/code&gt;, then &lt;code&gt;event_time&lt;/code&gt;.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Streams can be resumed.&lt;/b&gt; While a project has an open &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt;
   * stream or an enabled event subscription, its events are also written to a short-lived journal
   * (24 h by default). A stream that reconnects with its last &lt;code&gt;resume_token&lt;/code&gt; receives the
   * events it missed, provided they are still in the journal; nothing else is persisted for
   * redelivery.&lt;/p&gt;
   * &lt;p&gt;Use the status RPCs (&lt;code&gt;GetCampaign&lt;/code&gt;, &lt;code&gt;ListCalls&lt;/code&gt;, the status streams) to
   * reconcile.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Custom header values are write-only.&lt;/b&gt; They are returned as &lt;code&gt;********&lt;/code&gt; by every
   * RPC and are never logged.&lt;/p&gt;
   * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, &lt;code&gt;NOT_FOUND&lt;/code&gt;,
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;, &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; (no free stream slot).&lt;/p&gt;
   * </pre>
   */
  public static final class EventsStub
      extends io.grpc.stub.AbstractAsyncStub<EventsStub> {
    private EventsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventsStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates an event subscription: which events of the project are delivered to which
     * webhooks. A subscription without webhooks is usable by &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or webhook; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for no events and &lt;code&gt;all_events&lt;/code&gt; unset, &lt;code&gt;events&lt;/code&gt; together with
     * &lt;code&gt;all_events&lt;/code&gt;, &lt;code&gt;VTSI_EVENT_UNSPECIFIED&lt;/code&gt; or a reserved value, a webhook or a
     * campaign name of another project, a malformed campaign name, or an output-only field that was
     * set. A campaign named in &lt;code&gt;campaign_names&lt;/code&gt; need not exist (it may be created later
     * or deleted since).&lt;/p&gt;
     * </pre>
     */
    public void createVtsiEventSubscription(ondewo.vtsi.EventsOuterClass.CreateVtsiEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVtsiEventSubscriptionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns an event subscription.&lt;/p&gt;
     * </pre>
     */
    public void getVtsiEventSubscription(ondewo.vtsi.EventsOuterClass.GetVtsiEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVtsiEventSubscriptionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;events&lt;/code&gt;, &lt;code&gt;all_events&lt;/code&gt;, &lt;code&gt;resource_name_prefixes&lt;/code&gt;,
     * &lt;code&gt;campaign_names&lt;/code&gt;, &lt;code&gt;webhook_names&lt;/code&gt;, &lt;code&gt;disabled&lt;/code&gt;. Takes effect
     * within a few seconds on every server replica.&lt;/p&gt;
     * </pre>
     */
    public void updateVtsiEventSubscription(ondewo.vtsi.EventsOuterClass.UpdateVtsiEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVtsiEventSubscriptionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes an event subscription. Open &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt; streams that name it
     * end with &lt;code&gt;end_reason&lt;/code&gt; set.&lt;/p&gt;
     * </pre>
     */
    public void deleteVtsiEventSubscription(ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVtsiEventSubscriptionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the event subscriptions of a project, paged.&lt;/p&gt;
     * </pre>
     */
    public void listVtsiEventSubscriptions(ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVtsiEventSubscriptionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a webhook: an HTTP(S) endpoint that receives one request per event, with a JSON
     * body holding the &lt;code&gt;VtsiEventMessage&lt;/code&gt; (proto3 JSON, original field names).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a
     * URL that is not http(s), has no host, carries user information (use a custom header for
     * credentials) or exceeds 2048 characters; for a reserved or malformed header name, a header
     * value with a line break, too many or too long headers; or for a timeout outside
     * 1 s to 30 s.&lt;/p&gt;
     * </pre>
     */
    public void createWebhook(ondewo.vtsi.EventsOuterClass.CreateWebhookRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.Webhook> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWebhookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a webhook. Custom header values are masked.&lt;/p&gt;
     * </pre>
     */
    public void getWebhook(ondewo.vtsi.EventsOuterClass.GetWebhookRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.Webhook> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWebhookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;url&lt;/code&gt;, &lt;code&gt;http_method&lt;/code&gt;, &lt;code&gt;custom_headers&lt;/code&gt;, &lt;code&gt;disabled&lt;/code&gt;,
     * &lt;code&gt;timeout&lt;/code&gt;. &lt;code&gt;custom_headers&lt;/code&gt; replaces the whole map; a value equal to the
     * mask &lt;code&gt;********&lt;/code&gt; keeps the stored value of that header, so a Get-modify-Update
     * round trip does not overwrite secrets with the mask.&lt;/p&gt;
     * &lt;p&gt;Moving the webhook to another origin (scheme, host or port of &lt;code&gt;url&lt;/code&gt;) while custom
     * headers are stored requires re-sending &lt;code&gt;custom_headers&lt;/code&gt; in the same request, with
     * their REAL values (or an empty map to drop them): the stored values are never carried to a new
     * origin, and an update that leaves &lt;code&gt;custom_headers&lt;/code&gt; out of the mask or sends the mask
     * value &lt;code&gt;********&lt;/code&gt; for any header is rejected with &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; naming
     * the headers. A new path on the same origin keeps the stored values.&lt;/p&gt;
     * </pre>
     */
    public void updateWebhook(ondewo.vtsi.EventsOuterClass.UpdateWebhookRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.Webhook> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateWebhookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a webhook and removes it from every event subscription.&lt;/p&gt;
     * </pre>
     */
    public void deleteWebhook(ondewo.vtsi.EventsOuterClass.DeleteWebhookRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.DeleteWebhookResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteWebhookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the webhooks of a project, paged. Custom header values are masked.&lt;/p&gt;
     * </pre>
     */
    public void listWebhooks(ondewo.vtsi.EventsOuterClass.ListWebhooksRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.ListWebhooksResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWebhooksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Sends one &lt;code&gt;VTSI_EVENT_WEBHOOK_TEST&lt;/code&gt; event to a webhook now, without retries,
     * and reports the outcome. Works on a disabled webhook too, and ignores an open circuit.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;. A failed delivery is reported in the response, not as an
     * error status.&lt;/p&gt;
     * </pre>
     */
    public void testWebhook(ondewo.vtsi.EventsOuterClass.TestWebhookRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.TestWebhookResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestWebhookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the events of a project as they happen, selected either by a named event
     * subscription or by an inline filter. An empty message is sent as a keep-alive. After a
     * disconnect, pass the last &lt;code&gt;resume_token&lt;/code&gt; to continue where the stream stopped;
     * events older than the server&amp;apos;s retention (24 h by default) are no longer available, and
     * the journal records a project&amp;apos;s events only while it has an open stream (and for 1 h
     * after the last one closed) or an enabled event subscription. A stream sees events of other
     * server replicas from at most a few seconds after it opened. A client that stops reading for
     * longer than the server&amp;apos;s stall timeout (30 s by default) is disconnected; reconnect with
     * the &lt;code&gt;resume_token&lt;/code&gt;. When the project is deleted, the stream delivers
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DELETED&lt;/code&gt; and ends.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or subscription;
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;resume_token&lt;/code&gt;;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a disabled subscription; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;
     * when the server has no free stream slot.&lt;/p&gt;
     * </pre>
     */
    public void subscribeVtsiEvents(ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSubscribeVtsiEventsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Events.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Notifies other systems of VTSI events: calls, callers, listeners, scheduled callers,
   * campaigns, VTSI projects, the project&amp;apos;s Asterisk and softphone accounts. Every event is one
   * value of &lt;a href="index.html#ondewo.vtsi.VtsiEvent"&gt;VtsiEvent&lt;/a&gt; and is delivered as a
   * &lt;a href="index.html#ondewo.vtsi.VtsiEventMessage"&gt;VtsiEventMessage&lt;/a&gt;.&lt;/p&gt;
   * &lt;p&gt;Two delivery paths: the server-streaming &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt; RPC, and WEBHOOKS
   * (an HTTP request per event to a URL of the client&amp;apos;s choice). Which events go to which
   * webhooks is configured per project with EVENT SUBSCRIPTIONS.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Webhooks are best effort.&lt;/b&gt; Each event is sent to a webhook as at most
   * &lt;code&gt;ONDEWO_VTSI_WEBHOOK_MAX_ATTEMPTS&lt;/code&gt; HTTP requests (3 by default) with backoff between
   * them; after the last one fails, the event is dropped for that webhook. Pending webhook requests
   * live in the memory of the server replica that produced the event and are lost when it restarts.
   * An overloaded server, or a webhook that keeps timing out, drops events rather than slowing calls
   * down. The same event can arrive more than once (a request whose answer was lost is sent again):
   * de-duplicate by &lt;code&gt;event_id&lt;/code&gt;. Requests of one webhook can arrive out of order, because
   * several server replicas send independently: order by &lt;code&gt;resource_sequence&lt;/code&gt; per
   * &lt;code&gt;resource_name&lt;/code&gt;, then &lt;code&gt;event_time&lt;/code&gt;.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Streams can be resumed.&lt;/b&gt; While a project has an open &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt;
   * stream or an enabled event subscription, its events are also written to a short-lived journal
   * (24 h by default). A stream that reconnects with its last &lt;code&gt;resume_token&lt;/code&gt; receives the
   * events it missed, provided they are still in the journal; nothing else is persisted for
   * redelivery.&lt;/p&gt;
   * &lt;p&gt;Use the status RPCs (&lt;code&gt;GetCampaign&lt;/code&gt;, &lt;code&gt;ListCalls&lt;/code&gt;, the status streams) to
   * reconcile.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Custom header values are write-only.&lt;/b&gt; They are returned as &lt;code&gt;********&lt;/code&gt; by every
   * RPC and are never logged.&lt;/p&gt;
   * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, &lt;code&gt;NOT_FOUND&lt;/code&gt;,
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;, &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; (no free stream slot).&lt;/p&gt;
   * </pre>
   */
  public static final class EventsBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<EventsBlockingV2Stub> {
    private EventsBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventsBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventsBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates an event subscription: which events of the project are delivered to which
     * webhooks. A subscription without webhooks is usable by &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or webhook; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for no events and &lt;code&gt;all_events&lt;/code&gt; unset, &lt;code&gt;events&lt;/code&gt; together with
     * &lt;code&gt;all_events&lt;/code&gt;, &lt;code&gt;VTSI_EVENT_UNSPECIFIED&lt;/code&gt; or a reserved value, a webhook or a
     * campaign name of another project, a malformed campaign name, or an output-only field that was
     * set. A campaign named in &lt;code&gt;campaign_names&lt;/code&gt; need not exist (it may be created later
     * or deleted since).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.VtsiEventSubscription createVtsiEventSubscription(ondewo.vtsi.EventsOuterClass.CreateVtsiEventSubscriptionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateVtsiEventSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns an event subscription.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.VtsiEventSubscription getVtsiEventSubscription(ondewo.vtsi.EventsOuterClass.GetVtsiEventSubscriptionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetVtsiEventSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;events&lt;/code&gt;, &lt;code&gt;all_events&lt;/code&gt;, &lt;code&gt;resource_name_prefixes&lt;/code&gt;,
     * &lt;code&gt;campaign_names&lt;/code&gt;, &lt;code&gt;webhook_names&lt;/code&gt;, &lt;code&gt;disabled&lt;/code&gt;. Takes effect
     * within a few seconds on every server replica.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.VtsiEventSubscription updateVtsiEventSubscription(ondewo.vtsi.EventsOuterClass.UpdateVtsiEventSubscriptionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateVtsiEventSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes an event subscription. Open &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt; streams that name it
     * end with &lt;code&gt;end_reason&lt;/code&gt; set.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionResponse deleteVtsiEventSubscription(ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteVtsiEventSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the event subscriptions of a project, paged.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsResponse listVtsiEventSubscriptions(ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListVtsiEventSubscriptionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a webhook: an HTTP(S) endpoint that receives one request per event, with a JSON
     * body holding the &lt;code&gt;VtsiEventMessage&lt;/code&gt; (proto3 JSON, original field names).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a
     * URL that is not http(s), has no host, carries user information (use a custom header for
     * credentials) or exceeds 2048 characters; for a reserved or malformed header name, a header
     * value with a line break, too many or too long headers; or for a timeout outside
     * 1 s to 30 s.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.Webhook createWebhook(ondewo.vtsi.EventsOuterClass.CreateWebhookRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a webhook. Custom header values are masked.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.Webhook getWebhook(ondewo.vtsi.EventsOuterClass.GetWebhookRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;url&lt;/code&gt;, &lt;code&gt;http_method&lt;/code&gt;, &lt;code&gt;custom_headers&lt;/code&gt;, &lt;code&gt;disabled&lt;/code&gt;,
     * &lt;code&gt;timeout&lt;/code&gt;. &lt;code&gt;custom_headers&lt;/code&gt; replaces the whole map; a value equal to the
     * mask &lt;code&gt;********&lt;/code&gt; keeps the stored value of that header, so a Get-modify-Update
     * round trip does not overwrite secrets with the mask.&lt;/p&gt;
     * &lt;p&gt;Moving the webhook to another origin (scheme, host or port of &lt;code&gt;url&lt;/code&gt;) while custom
     * headers are stored requires re-sending &lt;code&gt;custom_headers&lt;/code&gt; in the same request, with
     * their REAL values (or an empty map to drop them): the stored values are never carried to a new
     * origin, and an update that leaves &lt;code&gt;custom_headers&lt;/code&gt; out of the mask or sends the mask
     * value &lt;code&gt;********&lt;/code&gt; for any header is rejected with &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; naming
     * the headers. A new path on the same origin keeps the stored values.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.Webhook updateWebhook(ondewo.vtsi.EventsOuterClass.UpdateWebhookRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a webhook and removes it from every event subscription.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.DeleteWebhookResponse deleteWebhook(ondewo.vtsi.EventsOuterClass.DeleteWebhookRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the webhooks of a project, paged. Custom header values are masked.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.ListWebhooksResponse listWebhooks(ondewo.vtsi.EventsOuterClass.ListWebhooksRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListWebhooksMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Sends one &lt;code&gt;VTSI_EVENT_WEBHOOK_TEST&lt;/code&gt; event to a webhook now, without retries,
     * and reports the outcome. Works on a disabled webhook too, and ignores an open circuit.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;. A failed delivery is reported in the response, not as an
     * error status.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.TestWebhookResponse testWebhook(ondewo.vtsi.EventsOuterClass.TestWebhookRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getTestWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the events of a project as they happen, selected either by a named event
     * subscription or by an inline filter. An empty message is sent as a keep-alive. After a
     * disconnect, pass the last &lt;code&gt;resume_token&lt;/code&gt; to continue where the stream stopped;
     * events older than the server&amp;apos;s retention (24 h by default) are no longer available, and
     * the journal records a project&amp;apos;s events only while it has an open stream (and for 1 h
     * after the last one closed) or an enabled event subscription. A stream sees events of other
     * server replicas from at most a few seconds after it opened. A client that stops reading for
     * longer than the server&amp;apos;s stall timeout (30 s by default) is disconnected; reconnect with
     * the &lt;code&gt;resume_token&lt;/code&gt;. When the project is deleted, the stream delivers
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DELETED&lt;/code&gt; and ends.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or subscription;
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;resume_token&lt;/code&gt;;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a disabled subscription; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;
     * when the server has no free stream slot.&lt;/p&gt;
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsResponse>
        subscribeVtsiEvents(ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getSubscribeVtsiEventsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Events.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Notifies other systems of VTSI events: calls, callers, listeners, scheduled callers,
   * campaigns, VTSI projects, the project&amp;apos;s Asterisk and softphone accounts. Every event is one
   * value of &lt;a href="index.html#ondewo.vtsi.VtsiEvent"&gt;VtsiEvent&lt;/a&gt; and is delivered as a
   * &lt;a href="index.html#ondewo.vtsi.VtsiEventMessage"&gt;VtsiEventMessage&lt;/a&gt;.&lt;/p&gt;
   * &lt;p&gt;Two delivery paths: the server-streaming &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt; RPC, and WEBHOOKS
   * (an HTTP request per event to a URL of the client&amp;apos;s choice). Which events go to which
   * webhooks is configured per project with EVENT SUBSCRIPTIONS.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Webhooks are best effort.&lt;/b&gt; Each event is sent to a webhook as at most
   * &lt;code&gt;ONDEWO_VTSI_WEBHOOK_MAX_ATTEMPTS&lt;/code&gt; HTTP requests (3 by default) with backoff between
   * them; after the last one fails, the event is dropped for that webhook. Pending webhook requests
   * live in the memory of the server replica that produced the event and are lost when it restarts.
   * An overloaded server, or a webhook that keeps timing out, drops events rather than slowing calls
   * down. The same event can arrive more than once (a request whose answer was lost is sent again):
   * de-duplicate by &lt;code&gt;event_id&lt;/code&gt;. Requests of one webhook can arrive out of order, because
   * several server replicas send independently: order by &lt;code&gt;resource_sequence&lt;/code&gt; per
   * &lt;code&gt;resource_name&lt;/code&gt;, then &lt;code&gt;event_time&lt;/code&gt;.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Streams can be resumed.&lt;/b&gt; While a project has an open &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt;
   * stream or an enabled event subscription, its events are also written to a short-lived journal
   * (24 h by default). A stream that reconnects with its last &lt;code&gt;resume_token&lt;/code&gt; receives the
   * events it missed, provided they are still in the journal; nothing else is persisted for
   * redelivery.&lt;/p&gt;
   * &lt;p&gt;Use the status RPCs (&lt;code&gt;GetCampaign&lt;/code&gt;, &lt;code&gt;ListCalls&lt;/code&gt;, the status streams) to
   * reconcile.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Custom header values are write-only.&lt;/b&gt; They are returned as &lt;code&gt;********&lt;/code&gt; by every
   * RPC and are never logged.&lt;/p&gt;
   * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, &lt;code&gt;NOT_FOUND&lt;/code&gt;,
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;, &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; (no free stream slot).&lt;/p&gt;
   * </pre>
   */
  public static final class EventsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EventsBlockingStub> {
    private EventsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates an event subscription: which events of the project are delivered to which
     * webhooks. A subscription without webhooks is usable by &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or webhook; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for no events and &lt;code&gt;all_events&lt;/code&gt; unset, &lt;code&gt;events&lt;/code&gt; together with
     * &lt;code&gt;all_events&lt;/code&gt;, &lt;code&gt;VTSI_EVENT_UNSPECIFIED&lt;/code&gt; or a reserved value, a webhook or a
     * campaign name of another project, a malformed campaign name, or an output-only field that was
     * set. A campaign named in &lt;code&gt;campaign_names&lt;/code&gt; need not exist (it may be created later
     * or deleted since).&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.VtsiEventSubscription createVtsiEventSubscription(ondewo.vtsi.EventsOuterClass.CreateVtsiEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVtsiEventSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns an event subscription.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.VtsiEventSubscription getVtsiEventSubscription(ondewo.vtsi.EventsOuterClass.GetVtsiEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVtsiEventSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;events&lt;/code&gt;, &lt;code&gt;all_events&lt;/code&gt;, &lt;code&gt;resource_name_prefixes&lt;/code&gt;,
     * &lt;code&gt;campaign_names&lt;/code&gt;, &lt;code&gt;webhook_names&lt;/code&gt;, &lt;code&gt;disabled&lt;/code&gt;. Takes effect
     * within a few seconds on every server replica.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.VtsiEventSubscription updateVtsiEventSubscription(ondewo.vtsi.EventsOuterClass.UpdateVtsiEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVtsiEventSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes an event subscription. Open &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt; streams that name it
     * end with &lt;code&gt;end_reason&lt;/code&gt; set.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionResponse deleteVtsiEventSubscription(ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVtsiEventSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the event subscriptions of a project, paged.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsResponse listVtsiEventSubscriptions(ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVtsiEventSubscriptionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a webhook: an HTTP(S) endpoint that receives one request per event, with a JSON
     * body holding the &lt;code&gt;VtsiEventMessage&lt;/code&gt; (proto3 JSON, original field names).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a
     * URL that is not http(s), has no host, carries user information (use a custom header for
     * credentials) or exceeds 2048 characters; for a reserved or malformed header name, a header
     * value with a line break, too many or too long headers; or for a timeout outside
     * 1 s to 30 s.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.Webhook createWebhook(ondewo.vtsi.EventsOuterClass.CreateWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a webhook. Custom header values are masked.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.Webhook getWebhook(ondewo.vtsi.EventsOuterClass.GetWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;url&lt;/code&gt;, &lt;code&gt;http_method&lt;/code&gt;, &lt;code&gt;custom_headers&lt;/code&gt;, &lt;code&gt;disabled&lt;/code&gt;,
     * &lt;code&gt;timeout&lt;/code&gt;. &lt;code&gt;custom_headers&lt;/code&gt; replaces the whole map; a value equal to the
     * mask &lt;code&gt;********&lt;/code&gt; keeps the stored value of that header, so a Get-modify-Update
     * round trip does not overwrite secrets with the mask.&lt;/p&gt;
     * &lt;p&gt;Moving the webhook to another origin (scheme, host or port of &lt;code&gt;url&lt;/code&gt;) while custom
     * headers are stored requires re-sending &lt;code&gt;custom_headers&lt;/code&gt; in the same request, with
     * their REAL values (or an empty map to drop them): the stored values are never carried to a new
     * origin, and an update that leaves &lt;code&gt;custom_headers&lt;/code&gt; out of the mask or sends the mask
     * value &lt;code&gt;********&lt;/code&gt; for any header is rejected with &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; naming
     * the headers. A new path on the same origin keeps the stored values.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.Webhook updateWebhook(ondewo.vtsi.EventsOuterClass.UpdateWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a webhook and removes it from every event subscription.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.DeleteWebhookResponse deleteWebhook(ondewo.vtsi.EventsOuterClass.DeleteWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the webhooks of a project, paged. Custom header values are masked.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.ListWebhooksResponse listWebhooks(ondewo.vtsi.EventsOuterClass.ListWebhooksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWebhooksMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Sends one &lt;code&gt;VTSI_EVENT_WEBHOOK_TEST&lt;/code&gt; event to a webhook now, without retries,
     * and reports the outcome. Works on a disabled webhook too, and ignores an open circuit.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;. A failed delivery is reported in the response, not as an
     * error status.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.EventsOuterClass.TestWebhookResponse testWebhook(ondewo.vtsi.EventsOuterClass.TestWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Streams the events of a project as they happen, selected either by a named event
     * subscription or by an inline filter. An empty message is sent as a keep-alive. After a
     * disconnect, pass the last &lt;code&gt;resume_token&lt;/code&gt; to continue where the stream stopped;
     * events older than the server&amp;apos;s retention (24 h by default) are no longer available, and
     * the journal records a project&amp;apos;s events only while it has an open stream (and for 1 h
     * after the last one closed) or an enabled event subscription. A stream sees events of other
     * server replicas from at most a few seconds after it opened. A client that stops reading for
     * longer than the server&amp;apos;s stall timeout (30 s by default) is disconnected; reconnect with
     * the &lt;code&gt;resume_token&lt;/code&gt;. When the project is deleted, the stream delivers
     * &lt;code&gt;VTSI_EVENT_VTSI_PROJECT_DELETED&lt;/code&gt; and ends.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or subscription;
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed &lt;code&gt;resume_token&lt;/code&gt;;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; for a disabled subscription; &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt;
     * when the server has no free stream slot.&lt;/p&gt;
     * </pre>
     */
    public java.util.Iterator<ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsResponse> subscribeVtsiEvents(
        ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSubscribeVtsiEventsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Events.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Notifies other systems of VTSI events: calls, callers, listeners, scheduled callers,
   * campaigns, VTSI projects, the project&amp;apos;s Asterisk and softphone accounts. Every event is one
   * value of &lt;a href="index.html#ondewo.vtsi.VtsiEvent"&gt;VtsiEvent&lt;/a&gt; and is delivered as a
   * &lt;a href="index.html#ondewo.vtsi.VtsiEventMessage"&gt;VtsiEventMessage&lt;/a&gt;.&lt;/p&gt;
   * &lt;p&gt;Two delivery paths: the server-streaming &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt; RPC, and WEBHOOKS
   * (an HTTP request per event to a URL of the client&amp;apos;s choice). Which events go to which
   * webhooks is configured per project with EVENT SUBSCRIPTIONS.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Webhooks are best effort.&lt;/b&gt; Each event is sent to a webhook as at most
   * &lt;code&gt;ONDEWO_VTSI_WEBHOOK_MAX_ATTEMPTS&lt;/code&gt; HTTP requests (3 by default) with backoff between
   * them; after the last one fails, the event is dropped for that webhook. Pending webhook requests
   * live in the memory of the server replica that produced the event and are lost when it restarts.
   * An overloaded server, or a webhook that keeps timing out, drops events rather than slowing calls
   * down. The same event can arrive more than once (a request whose answer was lost is sent again):
   * de-duplicate by &lt;code&gt;event_id&lt;/code&gt;. Requests of one webhook can arrive out of order, because
   * several server replicas send independently: order by &lt;code&gt;resource_sequence&lt;/code&gt; per
   * &lt;code&gt;resource_name&lt;/code&gt;, then &lt;code&gt;event_time&lt;/code&gt;.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Streams can be resumed.&lt;/b&gt; While a project has an open &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt;
   * stream or an enabled event subscription, its events are also written to a short-lived journal
   * (24 h by default). A stream that reconnects with its last &lt;code&gt;resume_token&lt;/code&gt; receives the
   * events it missed, provided they are still in the journal; nothing else is persisted for
   * redelivery.&lt;/p&gt;
   * &lt;p&gt;Use the status RPCs (&lt;code&gt;GetCampaign&lt;/code&gt;, &lt;code&gt;ListCalls&lt;/code&gt;, the status streams) to
   * reconcile.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Custom header values are write-only.&lt;/b&gt; They are returned as &lt;code&gt;********&lt;/code&gt; by every
   * RPC and are never logged.&lt;/p&gt;
   * &lt;p&gt;Errors are gRPC status codes: &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;, &lt;code&gt;NOT_FOUND&lt;/code&gt;,
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;, &lt;code&gt;RESOURCE_EXHAUSTED&lt;/code&gt; (no free stream slot).&lt;/p&gt;
   * </pre>
   */
  public static final class EventsFutureStub
      extends io.grpc.stub.AbstractFutureStub<EventsFutureStub> {
    private EventsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates an event subscription: which events of the project are delivered to which
     * webhooks. A subscription without webhooks is usable by &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project or webhook; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for no events and &lt;code&gt;all_events&lt;/code&gt; unset, &lt;code&gt;events&lt;/code&gt; together with
     * &lt;code&gt;all_events&lt;/code&gt;, &lt;code&gt;VTSI_EVENT_UNSPECIFIED&lt;/code&gt; or a reserved value, a webhook or a
     * campaign name of another project, a malformed campaign name, or an output-only field that was
     * set. A campaign named in &lt;code&gt;campaign_names&lt;/code&gt; need not exist (it may be created later
     * or deleted since).&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> createVtsiEventSubscription(
        ondewo.vtsi.EventsOuterClass.CreateVtsiEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVtsiEventSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns an event subscription.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> getVtsiEventSubscription(
        ondewo.vtsi.EventsOuterClass.GetVtsiEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVtsiEventSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;events&lt;/code&gt;, &lt;code&gt;all_events&lt;/code&gt;, &lt;code&gt;resource_name_prefixes&lt;/code&gt;,
     * &lt;code&gt;campaign_names&lt;/code&gt;, &lt;code&gt;webhook_names&lt;/code&gt;, &lt;code&gt;disabled&lt;/code&gt;. Takes effect
     * within a few seconds on every server replica.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.EventsOuterClass.VtsiEventSubscription> updateVtsiEventSubscription(
        ondewo.vtsi.EventsOuterClass.UpdateVtsiEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVtsiEventSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes an event subscription. Open &lt;code&gt;SubscribeVtsiEvents&lt;/code&gt; streams that name it
     * end with &lt;code&gt;end_reason&lt;/code&gt; set.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionResponse> deleteVtsiEventSubscription(
        ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVtsiEventSubscriptionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the event subscriptions of a project, paged.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsResponse> listVtsiEventSubscriptions(
        ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVtsiEventSubscriptionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a webhook: an HTTP(S) endpoint that receives one request per event, with a JSON
     * body holding the &lt;code&gt;VtsiEventMessage&lt;/code&gt; (proto3 JSON, original field names).&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a
     * URL that is not http(s), has no host, carries user information (use a custom header for
     * credentials) or exceeds 2048 characters; for a reserved or malformed header name, a header
     * value with a line break, too many or too long headers; or for a timeout outside
     * 1 s to 30 s.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.EventsOuterClass.Webhook> createWebhook(
        ondewo.vtsi.EventsOuterClass.CreateWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWebhookMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a webhook. Custom header values are masked.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.EventsOuterClass.Webhook> getWebhook(
        ondewo.vtsi.EventsOuterClass.GetWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWebhookMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the fields named in &lt;code&gt;update_mask&lt;/code&gt;: &lt;code&gt;display_name&lt;/code&gt;,
     * &lt;code&gt;url&lt;/code&gt;, &lt;code&gt;http_method&lt;/code&gt;, &lt;code&gt;custom_headers&lt;/code&gt;, &lt;code&gt;disabled&lt;/code&gt;,
     * &lt;code&gt;timeout&lt;/code&gt;. &lt;code&gt;custom_headers&lt;/code&gt; replaces the whole map; a value equal to the
     * mask &lt;code&gt;********&lt;/code&gt; keeps the stored value of that header, so a Get-modify-Update
     * round trip does not overwrite secrets with the mask.&lt;/p&gt;
     * &lt;p&gt;Moving the webhook to another origin (scheme, host or port of &lt;code&gt;url&lt;/code&gt;) while custom
     * headers are stored requires re-sending &lt;code&gt;custom_headers&lt;/code&gt; in the same request, with
     * their REAL values (or an empty map to drop them): the stored values are never carried to a new
     * origin, and an update that leaves &lt;code&gt;custom_headers&lt;/code&gt; out of the mask or sends the mask
     * value &lt;code&gt;********&lt;/code&gt; for any header is rejected with &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; naming
     * the headers. A new path on the same origin keeps the stored values.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.EventsOuterClass.Webhook> updateWebhook(
        ondewo.vtsi.EventsOuterClass.UpdateWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateWebhookMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a webhook and removes it from every event subscription.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.EventsOuterClass.DeleteWebhookResponse> deleteWebhook(
        ondewo.vtsi.EventsOuterClass.DeleteWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteWebhookMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the webhooks of a project, paged. Custom header values are masked.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.EventsOuterClass.ListWebhooksResponse> listWebhooks(
        ondewo.vtsi.EventsOuterClass.ListWebhooksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWebhooksMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Sends one &lt;code&gt;VTSI_EVENT_WEBHOOK_TEST&lt;/code&gt; event to a webhook now, without retries,
     * and reports the outcome. Works on a disabled webhook too, and ignores an open circuit.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt;. A failed delivery is reported in the response, not as an
     * error status.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.EventsOuterClass.TestWebhookResponse> testWebhook(
        ondewo.vtsi.EventsOuterClass.TestWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestWebhookMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_VTSI_EVENT_SUBSCRIPTION = 0;
  private static final int METHODID_GET_VTSI_EVENT_SUBSCRIPTION = 1;
  private static final int METHODID_UPDATE_VTSI_EVENT_SUBSCRIPTION = 2;
  private static final int METHODID_DELETE_VTSI_EVENT_SUBSCRIPTION = 3;
  private static final int METHODID_LIST_VTSI_EVENT_SUBSCRIPTIONS = 4;
  private static final int METHODID_CREATE_WEBHOOK = 5;
  private static final int METHODID_GET_WEBHOOK = 6;
  private static final int METHODID_UPDATE_WEBHOOK = 7;
  private static final int METHODID_DELETE_WEBHOOK = 8;
  private static final int METHODID_LIST_WEBHOOKS = 9;
  private static final int METHODID_TEST_WEBHOOK = 10;
  private static final int METHODID_SUBSCRIBE_VTSI_EVENTS = 11;

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
        case METHODID_CREATE_VTSI_EVENT_SUBSCRIPTION:
          serviceImpl.createVtsiEventSubscription((ondewo.vtsi.EventsOuterClass.CreateVtsiEventSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.VtsiEventSubscription>) responseObserver);
          break;
        case METHODID_GET_VTSI_EVENT_SUBSCRIPTION:
          serviceImpl.getVtsiEventSubscription((ondewo.vtsi.EventsOuterClass.GetVtsiEventSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.VtsiEventSubscription>) responseObserver);
          break;
        case METHODID_UPDATE_VTSI_EVENT_SUBSCRIPTION:
          serviceImpl.updateVtsiEventSubscription((ondewo.vtsi.EventsOuterClass.UpdateVtsiEventSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.VtsiEventSubscription>) responseObserver);
          break;
        case METHODID_DELETE_VTSI_EVENT_SUBSCRIPTION:
          serviceImpl.deleteVtsiEventSubscription((ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionResponse>) responseObserver);
          break;
        case METHODID_LIST_VTSI_EVENT_SUBSCRIPTIONS:
          serviceImpl.listVtsiEventSubscriptions((ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsResponse>) responseObserver);
          break;
        case METHODID_CREATE_WEBHOOK:
          serviceImpl.createWebhook((ondewo.vtsi.EventsOuterClass.CreateWebhookRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.Webhook>) responseObserver);
          break;
        case METHODID_GET_WEBHOOK:
          serviceImpl.getWebhook((ondewo.vtsi.EventsOuterClass.GetWebhookRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.Webhook>) responseObserver);
          break;
        case METHODID_UPDATE_WEBHOOK:
          serviceImpl.updateWebhook((ondewo.vtsi.EventsOuterClass.UpdateWebhookRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.Webhook>) responseObserver);
          break;
        case METHODID_DELETE_WEBHOOK:
          serviceImpl.deleteWebhook((ondewo.vtsi.EventsOuterClass.DeleteWebhookRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.DeleteWebhookResponse>) responseObserver);
          break;
        case METHODID_LIST_WEBHOOKS:
          serviceImpl.listWebhooks((ondewo.vtsi.EventsOuterClass.ListWebhooksRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.ListWebhooksResponse>) responseObserver);
          break;
        case METHODID_TEST_WEBHOOK:
          serviceImpl.testWebhook((ondewo.vtsi.EventsOuterClass.TestWebhookRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.TestWebhookResponse>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_VTSI_EVENTS:
          serviceImpl.subscribeVtsiEvents((ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsResponse>) responseObserver);
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
          getCreateVtsiEventSubscriptionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.EventsOuterClass.CreateVtsiEventSubscriptionRequest,
              ondewo.vtsi.EventsOuterClass.VtsiEventSubscription>(
                service, METHODID_CREATE_VTSI_EVENT_SUBSCRIPTION)))
        .addMethod(
          getGetVtsiEventSubscriptionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.EventsOuterClass.GetVtsiEventSubscriptionRequest,
              ondewo.vtsi.EventsOuterClass.VtsiEventSubscription>(
                service, METHODID_GET_VTSI_EVENT_SUBSCRIPTION)))
        .addMethod(
          getUpdateVtsiEventSubscriptionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.EventsOuterClass.UpdateVtsiEventSubscriptionRequest,
              ondewo.vtsi.EventsOuterClass.VtsiEventSubscription>(
                service, METHODID_UPDATE_VTSI_EVENT_SUBSCRIPTION)))
        .addMethod(
          getDeleteVtsiEventSubscriptionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionRequest,
              ondewo.vtsi.EventsOuterClass.DeleteVtsiEventSubscriptionResponse>(
                service, METHODID_DELETE_VTSI_EVENT_SUBSCRIPTION)))
        .addMethod(
          getListVtsiEventSubscriptionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsRequest,
              ondewo.vtsi.EventsOuterClass.ListVtsiEventSubscriptionsResponse>(
                service, METHODID_LIST_VTSI_EVENT_SUBSCRIPTIONS)))
        .addMethod(
          getCreateWebhookMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.EventsOuterClass.CreateWebhookRequest,
              ondewo.vtsi.EventsOuterClass.Webhook>(
                service, METHODID_CREATE_WEBHOOK)))
        .addMethod(
          getGetWebhookMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.EventsOuterClass.GetWebhookRequest,
              ondewo.vtsi.EventsOuterClass.Webhook>(
                service, METHODID_GET_WEBHOOK)))
        .addMethod(
          getUpdateWebhookMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.EventsOuterClass.UpdateWebhookRequest,
              ondewo.vtsi.EventsOuterClass.Webhook>(
                service, METHODID_UPDATE_WEBHOOK)))
        .addMethod(
          getDeleteWebhookMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.EventsOuterClass.DeleteWebhookRequest,
              ondewo.vtsi.EventsOuterClass.DeleteWebhookResponse>(
                service, METHODID_DELETE_WEBHOOK)))
        .addMethod(
          getListWebhooksMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.EventsOuterClass.ListWebhooksRequest,
              ondewo.vtsi.EventsOuterClass.ListWebhooksResponse>(
                service, METHODID_LIST_WEBHOOKS)))
        .addMethod(
          getTestWebhookMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.EventsOuterClass.TestWebhookRequest,
              ondewo.vtsi.EventsOuterClass.TestWebhookResponse>(
                service, METHODID_TEST_WEBHOOK)))
        .addMethod(
          getSubscribeVtsiEventsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsRequest,
              ondewo.vtsi.EventsOuterClass.SubscribeVtsiEventsResponse>(
                service, METHODID_SUBSCRIBE_VTSI_EVENTS)))
        .build();
  }

  private static abstract class EventsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EventsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ondewo.vtsi.EventsOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Events");
    }
  }

  private static final class EventsFileDescriptorSupplier
      extends EventsBaseDescriptorSupplier {
    EventsFileDescriptorSupplier() {}
  }

  private static final class EventsMethodDescriptorSupplier
      extends EventsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EventsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EventsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EventsFileDescriptorSupplier())
              .addMethod(getCreateVtsiEventSubscriptionMethod())
              .addMethod(getGetVtsiEventSubscriptionMethod())
              .addMethod(getUpdateVtsiEventSubscriptionMethod())
              .addMethod(getDeleteVtsiEventSubscriptionMethod())
              .addMethod(getListVtsiEventSubscriptionsMethod())
              .addMethod(getCreateWebhookMethod())
              .addMethod(getGetWebhookMethod())
              .addMethod(getUpdateWebhookMethod())
              .addMethod(getDeleteWebhookMethod())
              .addMethod(getListWebhooksMethod())
              .addMethod(getTestWebhookMethod())
              .addMethod(getSubscribeVtsiEventsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
