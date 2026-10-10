package ondewo.vtsi;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
 * &lt;p&gt;Manages the SOFTPHONE ACCOUNTS of a VTSI project: SIP accounts on the project&amp;apos;s Asterisk that
 * a human uses from a softphone such as Zoiper, to call into the project&amp;apos;s listeners or to be reached
 * by the project.&lt;/p&gt;
 * &lt;p&gt;A softphone account is NEVER one of the &lt;code&gt;ondewo000N&lt;/code&gt; accounts the per-call ondewo-sip
 * containers register with: it has its own SIP credentials, its own endpoint on the Asterisk and, for
 * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, its own client certificate issued by the
 * project&amp;apos;s SOFTPHONE certificate authority.&lt;/p&gt;
 * &lt;p&gt;&lt;b&gt;Secrets are handed out exactly once.&lt;/b&gt; The SIP password and the password-protected PKCS#12
 * bundle carrying the client private key appear only in the responses of
 * &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; and &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt;. VTSI keeps no copy of
 * the private key or of the PKCS#12 password, and stores the SIP password only in the form the Asterisk
 * needs to verify a SIP digest. No other RPC returns a secret; a lost private key or password is
 * recovered by rotating it.&lt;/p&gt;
 * &lt;p&gt;Errors are reported as gRPC status codes, not as &lt;code&gt;error_message&lt;/code&gt; fields:
 * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, filter, field mask or value;
 * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, account or certificate;
 * &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a &lt;code&gt;sip_username&lt;/code&gt; already taken in the project;
 * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the project or the account is in a state that does not allow the
 * operation (each RPC names its cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change to the same account
 * won, in which case nothing was stored and the request can be retried.&lt;/p&gt;
 * &lt;p&gt;&lt;b&gt;A change that reduces access is enforced before it is acknowledged.&lt;/b&gt; When
 * &lt;code&gt;UpdateSoftphoneAccount&lt;/code&gt;, &lt;code&gt;DeleteSoftphoneAccount&lt;/code&gt; or
 * &lt;code&gt;RevokeSoftphoneCertificate&lt;/code&gt; is stored but the running Asterisk of a deployed project could
 * not be updated, the RPC fails with &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;; the stored change is applied by
 * the next successful change or deployment. &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; and
 * &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt; return their one-time secrets even then.&lt;/p&gt;
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SoftphonesGrpc {

  private SoftphonesGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ondewo.vtsi.Softphones";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountRequest,
      ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountResponse> getCreateSoftphoneAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSoftphoneAccount",
      requestType = ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountRequest.class,
      responseType = ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountRequest,
      ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountResponse> getCreateSoftphoneAccountMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountRequest, ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountResponse> getCreateSoftphoneAccountMethod;
    if ((getCreateSoftphoneAccountMethod = SoftphonesGrpc.getCreateSoftphoneAccountMethod) == null) {
      synchronized (SoftphonesGrpc.class) {
        if ((getCreateSoftphoneAccountMethod = SoftphonesGrpc.getCreateSoftphoneAccountMethod) == null) {
          SoftphonesGrpc.getCreateSoftphoneAccountMethod = getCreateSoftphoneAccountMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountRequest, ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSoftphoneAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SoftphonesMethodDescriptorSupplier("CreateSoftphoneAccount"))
              .build();
        }
      }
    }
    return getCreateSoftphoneAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneAccountRequest,
      ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount> getGetSoftphoneAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSoftphoneAccount",
      requestType = ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneAccountRequest.class,
      responseType = ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneAccountRequest,
      ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount> getGetSoftphoneAccountMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneAccountRequest, ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount> getGetSoftphoneAccountMethod;
    if ((getGetSoftphoneAccountMethod = SoftphonesGrpc.getGetSoftphoneAccountMethod) == null) {
      synchronized (SoftphonesGrpc.class) {
        if ((getGetSoftphoneAccountMethod = SoftphonesGrpc.getGetSoftphoneAccountMethod) == null) {
          SoftphonesGrpc.getGetSoftphoneAccountMethod = getGetSoftphoneAccountMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneAccountRequest, ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSoftphoneAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount.getDefaultInstance()))
              .setSchemaDescriptor(new SoftphonesMethodDescriptorSupplier("GetSoftphoneAccount"))
              .build();
        }
      }
    }
    return getGetSoftphoneAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.UpdateSoftphoneAccountRequest,
      ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount> getUpdateSoftphoneAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSoftphoneAccount",
      requestType = ondewo.vtsi.SoftphonesOuterClass.UpdateSoftphoneAccountRequest.class,
      responseType = ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.UpdateSoftphoneAccountRequest,
      ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount> getUpdateSoftphoneAccountMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.UpdateSoftphoneAccountRequest, ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount> getUpdateSoftphoneAccountMethod;
    if ((getUpdateSoftphoneAccountMethod = SoftphonesGrpc.getUpdateSoftphoneAccountMethod) == null) {
      synchronized (SoftphonesGrpc.class) {
        if ((getUpdateSoftphoneAccountMethod = SoftphonesGrpc.getUpdateSoftphoneAccountMethod) == null) {
          SoftphonesGrpc.getUpdateSoftphoneAccountMethod = getUpdateSoftphoneAccountMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.SoftphonesOuterClass.UpdateSoftphoneAccountRequest, ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSoftphoneAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.UpdateSoftphoneAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount.getDefaultInstance()))
              .setSchemaDescriptor(new SoftphonesMethodDescriptorSupplier("UpdateSoftphoneAccount"))
              .build();
        }
      }
    }
    return getUpdateSoftphoneAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountRequest,
      ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountResponse> getDeleteSoftphoneAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSoftphoneAccount",
      requestType = ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountRequest.class,
      responseType = ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountRequest,
      ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountResponse> getDeleteSoftphoneAccountMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountRequest, ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountResponse> getDeleteSoftphoneAccountMethod;
    if ((getDeleteSoftphoneAccountMethod = SoftphonesGrpc.getDeleteSoftphoneAccountMethod) == null) {
      synchronized (SoftphonesGrpc.class) {
        if ((getDeleteSoftphoneAccountMethod = SoftphonesGrpc.getDeleteSoftphoneAccountMethod) == null) {
          SoftphonesGrpc.getDeleteSoftphoneAccountMethod = getDeleteSoftphoneAccountMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountRequest, ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSoftphoneAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SoftphonesMethodDescriptorSupplier("DeleteSoftphoneAccount"))
              .build();
        }
      }
    }
    return getDeleteSoftphoneAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsRequest,
      ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsResponse> getListSoftphoneAccountsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSoftphoneAccounts",
      requestType = ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsRequest.class,
      responseType = ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsRequest,
      ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsResponse> getListSoftphoneAccountsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsRequest, ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsResponse> getListSoftphoneAccountsMethod;
    if ((getListSoftphoneAccountsMethod = SoftphonesGrpc.getListSoftphoneAccountsMethod) == null) {
      synchronized (SoftphonesGrpc.class) {
        if ((getListSoftphoneAccountsMethod = SoftphonesGrpc.getListSoftphoneAccountsMethod) == null) {
          SoftphonesGrpc.getListSoftphoneAccountsMethod = getListSoftphoneAccountsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsRequest, ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSoftphoneAccounts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SoftphonesMethodDescriptorSupplier("ListSoftphoneAccounts"))
              .build();
        }
      }
    }
    return getListSoftphoneAccountsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsRequest,
      ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsResponse> getRotateSoftphoneCredentialsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RotateSoftphoneCredentials",
      requestType = ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsRequest.class,
      responseType = ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsRequest,
      ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsResponse> getRotateSoftphoneCredentialsMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsRequest, ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsResponse> getRotateSoftphoneCredentialsMethod;
    if ((getRotateSoftphoneCredentialsMethod = SoftphonesGrpc.getRotateSoftphoneCredentialsMethod) == null) {
      synchronized (SoftphonesGrpc.class) {
        if ((getRotateSoftphoneCredentialsMethod = SoftphonesGrpc.getRotateSoftphoneCredentialsMethod) == null) {
          SoftphonesGrpc.getRotateSoftphoneCredentialsMethod = getRotateSoftphoneCredentialsMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsRequest, ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RotateSoftphoneCredentials"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SoftphonesMethodDescriptorSupplier("RotateSoftphoneCredentials"))
              .build();
        }
      }
    }
    return getRotateSoftphoneCredentialsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesRequest,
      ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesResponse> getListSoftphoneCertificatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSoftphoneCertificates",
      requestType = ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesRequest.class,
      responseType = ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesRequest,
      ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesResponse> getListSoftphoneCertificatesMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesRequest, ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesResponse> getListSoftphoneCertificatesMethod;
    if ((getListSoftphoneCertificatesMethod = SoftphonesGrpc.getListSoftphoneCertificatesMethod) == null) {
      synchronized (SoftphonesGrpc.class) {
        if ((getListSoftphoneCertificatesMethod = SoftphonesGrpc.getListSoftphoneCertificatesMethod) == null) {
          SoftphonesGrpc.getListSoftphoneCertificatesMethod = getListSoftphoneCertificatesMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesRequest, ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSoftphoneCertificates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SoftphonesMethodDescriptorSupplier("ListSoftphoneCertificates"))
              .build();
        }
      }
    }
    return getListSoftphoneCertificatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneCertificateRequest,
      ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate> getGetSoftphoneCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSoftphoneCertificate",
      requestType = ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneCertificateRequest.class,
      responseType = ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneCertificateRequest,
      ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate> getGetSoftphoneCertificateMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneCertificateRequest, ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate> getGetSoftphoneCertificateMethod;
    if ((getGetSoftphoneCertificateMethod = SoftphonesGrpc.getGetSoftphoneCertificateMethod) == null) {
      synchronized (SoftphonesGrpc.class) {
        if ((getGetSoftphoneCertificateMethod = SoftphonesGrpc.getGetSoftphoneCertificateMethod) == null) {
          SoftphonesGrpc.getGetSoftphoneCertificateMethod = getGetSoftphoneCertificateMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneCertificateRequest, ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSoftphoneCertificate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate.getDefaultInstance()))
              .setSchemaDescriptor(new SoftphonesMethodDescriptorSupplier("GetSoftphoneCertificate"))
              .build();
        }
      }
    }
    return getGetSoftphoneCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.RevokeSoftphoneCertificateRequest,
      ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate> getRevokeSoftphoneCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RevokeSoftphoneCertificate",
      requestType = ondewo.vtsi.SoftphonesOuterClass.RevokeSoftphoneCertificateRequest.class,
      responseType = ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.RevokeSoftphoneCertificateRequest,
      ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate> getRevokeSoftphoneCertificateMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.RevokeSoftphoneCertificateRequest, ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate> getRevokeSoftphoneCertificateMethod;
    if ((getRevokeSoftphoneCertificateMethod = SoftphonesGrpc.getRevokeSoftphoneCertificateMethod) == null) {
      synchronized (SoftphonesGrpc.class) {
        if ((getRevokeSoftphoneCertificateMethod = SoftphonesGrpc.getRevokeSoftphoneCertificateMethod) == null) {
          SoftphonesGrpc.getRevokeSoftphoneCertificateMethod = getRevokeSoftphoneCertificateMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.SoftphonesOuterClass.RevokeSoftphoneCertificateRequest, ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RevokeSoftphoneCertificate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.RevokeSoftphoneCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate.getDefaultInstance()))
              .setSchemaDescriptor(new SoftphonesMethodDescriptorSupplier("RevokeSoftphoneCertificate"))
              .build();
        }
      }
    }
    return getRevokeSoftphoneCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneProvisioningRequest,
      ondewo.vtsi.SoftphonesOuterClass.SoftphoneProvisioning> getGetSoftphoneProvisioningMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSoftphoneProvisioning",
      requestType = ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneProvisioningRequest.class,
      responseType = ondewo.vtsi.SoftphonesOuterClass.SoftphoneProvisioning.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneProvisioningRequest,
      ondewo.vtsi.SoftphonesOuterClass.SoftphoneProvisioning> getGetSoftphoneProvisioningMethod() {
    io.grpc.MethodDescriptor<ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneProvisioningRequest, ondewo.vtsi.SoftphonesOuterClass.SoftphoneProvisioning> getGetSoftphoneProvisioningMethod;
    if ((getGetSoftphoneProvisioningMethod = SoftphonesGrpc.getGetSoftphoneProvisioningMethod) == null) {
      synchronized (SoftphonesGrpc.class) {
        if ((getGetSoftphoneProvisioningMethod = SoftphonesGrpc.getGetSoftphoneProvisioningMethod) == null) {
          SoftphonesGrpc.getGetSoftphoneProvisioningMethod = getGetSoftphoneProvisioningMethod =
              io.grpc.MethodDescriptor.<ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneProvisioningRequest, ondewo.vtsi.SoftphonesOuterClass.SoftphoneProvisioning>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSoftphoneProvisioning"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneProvisioningRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.vtsi.SoftphonesOuterClass.SoftphoneProvisioning.getDefaultInstance()))
              .setSchemaDescriptor(new SoftphonesMethodDescriptorSupplier("GetSoftphoneProvisioning"))
              .build();
        }
      }
    }
    return getGetSoftphoneProvisioningMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SoftphonesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SoftphonesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SoftphonesStub>() {
        @java.lang.Override
        public SoftphonesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SoftphonesStub(channel, callOptions);
        }
      };
    return SoftphonesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static SoftphonesBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SoftphonesBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SoftphonesBlockingV2Stub>() {
        @java.lang.Override
        public SoftphonesBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SoftphonesBlockingV2Stub(channel, callOptions);
        }
      };
    return SoftphonesBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SoftphonesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SoftphonesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SoftphonesBlockingStub>() {
        @java.lang.Override
        public SoftphonesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SoftphonesBlockingStub(channel, callOptions);
        }
      };
    return SoftphonesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SoftphonesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SoftphonesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SoftphonesFutureStub>() {
        @java.lang.Override
        public SoftphonesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SoftphonesFutureStub(channel, callOptions);
        }
      };
    return SoftphonesFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the SOFTPHONE ACCOUNTS of a VTSI project: SIP accounts on the project&amp;apos;s Asterisk that
   * a human uses from a softphone such as Zoiper, to call into the project&amp;apos;s listeners or to be reached
   * by the project.&lt;/p&gt;
   * &lt;p&gt;A softphone account is NEVER one of the &lt;code&gt;ondewo000N&lt;/code&gt; accounts the per-call ondewo-sip
   * containers register with: it has its own SIP credentials, its own endpoint on the Asterisk and, for
   * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, its own client certificate issued by the
   * project&amp;apos;s SOFTPHONE certificate authority.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Secrets are handed out exactly once.&lt;/b&gt; The SIP password and the password-protected PKCS#12
   * bundle carrying the client private key appear only in the responses of
   * &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; and &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt;. VTSI keeps no copy of
   * the private key or of the PKCS#12 password, and stores the SIP password only in the form the Asterisk
   * needs to verify a SIP digest. No other RPC returns a secret; a lost private key or password is
   * recovered by rotating it.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes, not as &lt;code&gt;error_message&lt;/code&gt; fields:
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, filter, field mask or value;
   * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, account or certificate;
   * &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a &lt;code&gt;sip_username&lt;/code&gt; already taken in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the project or the account is in a state that does not allow the
   * operation (each RPC names its cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change to the same account
   * won, in which case nothing was stored and the request can be retried.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;A change that reduces access is enforced before it is acknowledged.&lt;/b&gt; When
   * &lt;code&gt;UpdateSoftphoneAccount&lt;/code&gt;, &lt;code&gt;DeleteSoftphoneAccount&lt;/code&gt; or
   * &lt;code&gt;RevokeSoftphoneCertificate&lt;/code&gt; is stored but the running Asterisk of a deployed project could
   * not be updated, the RPC fails with &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;; the stored change is applied by
   * the next successful change or deployment. &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; and
   * &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt; return their one-time secrets even then.&lt;/p&gt;
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * &lt;p&gt;Creates a softphone account in a VTSI project, generates its SIP password and, for
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, issues its first client certificate.
     * The response carries the ONE-TIME secrets; they cannot be retrieved again.&lt;/p&gt;
     * &lt;p&gt;If the project is deployed the account is applied to the running Asterisk; otherwise it is
     * applied on the next deployment.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; if the
     * &lt;code&gt;sip_username&lt;/code&gt; is taken in the project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an invalid or
     * reserved &lt;code&gt;sip_username&lt;/code&gt;, an output-only field that was set, or an out-of-range value;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; if the project is being deleted, or, for
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, if the project has no Asterisk port yet
     * or its SOFTPHONE certificate authority is unusable (a redeployment mints a new one).&lt;/p&gt;
     * &lt;p&gt;The account is reachable on either TLS port only from the project&amp;apos;s
     * &lt;code&gt;softphone_permit_cidrs&lt;/code&gt; (default: the server&amp;apos;s list, private networks unless the
     * operator changed it); see &lt;code&gt;AsteriskConfigsVariables.softphone_permit_cidrs&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void createSoftphoneAccount(ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSoftphoneAccountMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a softphone account. Never returns a secret.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a
     * malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    default void getSoftphoneAccount(ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneAccountRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSoftphoneAccountMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the mutable fields of a softphone account named by &lt;code&gt;update_mask&lt;/code&gt;. Credentials
     * are not changed here; use &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an
     * empty mask, an unknown, output-only or immutable path, or an out-of-range value;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when switching to
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt; while the account has no
     * &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_ACTIVE&lt;/code&gt; certificate, or if the project is being deleted.&lt;/p&gt;
     * &lt;p&gt;The account is reachable on either TLS port only from the project&amp;apos;s
     * &lt;code&gt;softphone_permit_cidrs&lt;/code&gt; (default: the server&amp;apos;s list, private networks unless the
     * operator changed it); see &lt;code&gt;AsteriskConfigsVariables.softphone_permit_cidrs&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void updateSoftphoneAccount(ondewo.vtsi.SoftphonesOuterClass.UpdateSoftphoneAccountRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateSoftphoneAccountMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a softphone account. Its endpoint is removed from the Asterisk, its registrations are
     * dropped and every certificate it holds is revoked. Deletion is permanent.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist.&lt;/p&gt;
     * </pre>
     */
    default void deleteSoftphoneAccount(ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteSoftphoneAccountMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the softphone accounts of a VTSI project, filtered, sorted and paged. Never returns a
     * secret.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an
     * invalid filter, an unknown &lt;code&gt;field_mask&lt;/code&gt; path, a negative &lt;code&gt;page_size&lt;/code&gt; or a
     * &lt;code&gt;page_token&lt;/code&gt; that was not issued for the same project, filter and sorting.&lt;/p&gt;
     * </pre>
     */
    default void listSoftphoneAccounts(ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSoftphoneAccountsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Rotates the SIP password and/or the client certificate of a softphone account and returns the new
     * ONE-TIME secrets. &lt;b&gt;Every rotation rotates the SIP password&lt;/b&gt;, including one that asked only for
     * &lt;code&gt;rotate_certificate&lt;/code&gt;: the Asterisk has no certificate revocation list, so a previous
     * certificate stops being usable for this account only because the password it was issued with
     * stops working. The new password takes effect immediately and drops the account&amp;apos;s current
     * registrations, so every softphone using it must be reconfigured. A rotated certificate moves the
     * previous &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_ACTIVE&lt;/code&gt; certificate to
     * &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_SUPERSEDED&lt;/code&gt;. A rotation also unlocks an account that
     * &lt;code&gt;RevokeSoftphoneCertificate&lt;/code&gt; locked (a &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;
     * account only once it again holds an ACTIVE certificate).&lt;/p&gt;
     * &lt;p&gt;Rotating the certificate of a &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_SERVER_TLS_ONLY&lt;/code&gt; account is
     * allowed: it issues the certificate that a later switch to
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt; requires, and rotates the password too.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; if
     * neither &lt;code&gt;rotate_sip_password&lt;/code&gt; nor &lt;code&gt;rotate_certificate&lt;/code&gt; is set;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; if the project is being deleted, or, for
     * &lt;code&gt;rotate_certificate&lt;/code&gt;, if the project has no Asterisk port yet or its SOFTPHONE
     * certificate authority is unusable.&lt;/p&gt;
     * </pre>
     */
    default void rotateSoftphoneCredentials(ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRotateSoftphoneCredentialsMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists softphone client certificates, either of one softphone account or of a whole VTSI project,
     * filtered and paged, newest first. Only public material is returned.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project or account does not exist;
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; if no scope is set, for an invalid filter, an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path, a negative &lt;code&gt;page_size&lt;/code&gt; or a foreign
     * &lt;code&gt;page_token&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    default void listSoftphoneCertificates(ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSoftphoneCertificatesMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns one softphone client certificate. Only public material is returned.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the certificate does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for
     * a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    default void getSoftphoneCertificate(ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneCertificateRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSoftphoneCertificateMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Revokes a softphone client certificate. The Asterisk has no certificate revocation list, so
     * revocation is enforced on the account&amp;apos;s SIP password rather than on the certificate: a revoked
     * certificate still completes the TLS handshake on the project&amp;apos;s mutual-TLS port, but it no longer
     * gets its holder an account.&lt;/p&gt;
     * &lt;p&gt;Revoking the ACTIVE certificate of an account LOCKS the account, whatever its transport
     * security: it is removed from the Asterisk and its registrations are dropped until
     * &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt; issues a new password (and, for
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, a new certificate). Revoking a
     * SUPERSEDED certificate records the revocation only; its password was already rotated away.
     * Revoking an already revoked certificate is idempotent and keeps the original revocation time and
     * reason.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the certificate does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for a malformed name or an over-long reason.&lt;/p&gt;
     * </pre>
     */
    default void revokeSoftphoneCertificate(ondewo.vtsi.SoftphonesOuterClass.RevokeSoftphoneCertificateRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRevokeSoftphoneCertificateMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns everything needed to configure a softphone for an account: server, port, transport,
     * outbound proxy, SIP identity, SRTP mode, codecs, the certificate authority to trust, which client
     * certificate to import, and step-by-step Zoiper instructions. It never contains the SIP password or
     * the private key; those were returned once by &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; or
     * &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; if
     * the project is not &lt;code&gt;DEPLOYED&lt;/code&gt; (the host and ports describe a running Asterisk), or if a
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt; account has no
     * &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_ACTIVE&lt;/code&gt; certificate.&lt;/p&gt;
     * </pre>
     */
    default void getSoftphoneProvisioning(ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneProvisioningRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.SoftphoneProvisioning> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSoftphoneProvisioningMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Softphones.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the SOFTPHONE ACCOUNTS of a VTSI project: SIP accounts on the project&amp;apos;s Asterisk that
   * a human uses from a softphone such as Zoiper, to call into the project&amp;apos;s listeners or to be reached
   * by the project.&lt;/p&gt;
   * &lt;p&gt;A softphone account is NEVER one of the &lt;code&gt;ondewo000N&lt;/code&gt; accounts the per-call ondewo-sip
   * containers register with: it has its own SIP credentials, its own endpoint on the Asterisk and, for
   * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, its own client certificate issued by the
   * project&amp;apos;s SOFTPHONE certificate authority.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Secrets are handed out exactly once.&lt;/b&gt; The SIP password and the password-protected PKCS#12
   * bundle carrying the client private key appear only in the responses of
   * &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; and &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt;. VTSI keeps no copy of
   * the private key or of the PKCS#12 password, and stores the SIP password only in the form the Asterisk
   * needs to verify a SIP digest. No other RPC returns a secret; a lost private key or password is
   * recovered by rotating it.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes, not as &lt;code&gt;error_message&lt;/code&gt; fields:
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, filter, field mask or value;
   * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, account or certificate;
   * &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a &lt;code&gt;sip_username&lt;/code&gt; already taken in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the project or the account is in a state that does not allow the
   * operation (each RPC names its cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change to the same account
   * won, in which case nothing was stored and the request can be retried.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;A change that reduces access is enforced before it is acknowledged.&lt;/b&gt; When
   * &lt;code&gt;UpdateSoftphoneAccount&lt;/code&gt;, &lt;code&gt;DeleteSoftphoneAccount&lt;/code&gt; or
   * &lt;code&gt;RevokeSoftphoneCertificate&lt;/code&gt; is stored but the running Asterisk of a deployed project could
   * not be updated, the RPC fails with &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;; the stored change is applied by
   * the next successful change or deployment. &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; and
   * &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt; return their one-time secrets even then.&lt;/p&gt;
   * </pre>
   */
  public static abstract class SoftphonesImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SoftphonesGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Softphones.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the SOFTPHONE ACCOUNTS of a VTSI project: SIP accounts on the project&amp;apos;s Asterisk that
   * a human uses from a softphone such as Zoiper, to call into the project&amp;apos;s listeners or to be reached
   * by the project.&lt;/p&gt;
   * &lt;p&gt;A softphone account is NEVER one of the &lt;code&gt;ondewo000N&lt;/code&gt; accounts the per-call ondewo-sip
   * containers register with: it has its own SIP credentials, its own endpoint on the Asterisk and, for
   * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, its own client certificate issued by the
   * project&amp;apos;s SOFTPHONE certificate authority.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Secrets are handed out exactly once.&lt;/b&gt; The SIP password and the password-protected PKCS#12
   * bundle carrying the client private key appear only in the responses of
   * &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; and &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt;. VTSI keeps no copy of
   * the private key or of the PKCS#12 password, and stores the SIP password only in the form the Asterisk
   * needs to verify a SIP digest. No other RPC returns a secret; a lost private key or password is
   * recovered by rotating it.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes, not as &lt;code&gt;error_message&lt;/code&gt; fields:
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, filter, field mask or value;
   * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, account or certificate;
   * &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a &lt;code&gt;sip_username&lt;/code&gt; already taken in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the project or the account is in a state that does not allow the
   * operation (each RPC names its cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change to the same account
   * won, in which case nothing was stored and the request can be retried.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;A change that reduces access is enforced before it is acknowledged.&lt;/b&gt; When
   * &lt;code&gt;UpdateSoftphoneAccount&lt;/code&gt;, &lt;code&gt;DeleteSoftphoneAccount&lt;/code&gt; or
   * &lt;code&gt;RevokeSoftphoneCertificate&lt;/code&gt; is stored but the running Asterisk of a deployed project could
   * not be updated, the RPC fails with &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;; the stored change is applied by
   * the next successful change or deployment. &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; and
   * &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt; return their one-time secrets even then.&lt;/p&gt;
   * </pre>
   */
  public static final class SoftphonesStub
      extends io.grpc.stub.AbstractAsyncStub<SoftphonesStub> {
    private SoftphonesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SoftphonesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SoftphonesStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a softphone account in a VTSI project, generates its SIP password and, for
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, issues its first client certificate.
     * The response carries the ONE-TIME secrets; they cannot be retrieved again.&lt;/p&gt;
     * &lt;p&gt;If the project is deployed the account is applied to the running Asterisk; otherwise it is
     * applied on the next deployment.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; if the
     * &lt;code&gt;sip_username&lt;/code&gt; is taken in the project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an invalid or
     * reserved &lt;code&gt;sip_username&lt;/code&gt;, an output-only field that was set, or an out-of-range value;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; if the project is being deleted, or, for
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, if the project has no Asterisk port yet
     * or its SOFTPHONE certificate authority is unusable (a redeployment mints a new one).&lt;/p&gt;
     * &lt;p&gt;The account is reachable on either TLS port only from the project&amp;apos;s
     * &lt;code&gt;softphone_permit_cidrs&lt;/code&gt; (default: the server&amp;apos;s list, private networks unless the
     * operator changed it); see &lt;code&gt;AsteriskConfigsVariables.softphone_permit_cidrs&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void createSoftphoneAccount(ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSoftphoneAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a softphone account. Never returns a secret.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a
     * malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public void getSoftphoneAccount(ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneAccountRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSoftphoneAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the mutable fields of a softphone account named by &lt;code&gt;update_mask&lt;/code&gt;. Credentials
     * are not changed here; use &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an
     * empty mask, an unknown, output-only or immutable path, or an out-of-range value;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when switching to
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt; while the account has no
     * &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_ACTIVE&lt;/code&gt; certificate, or if the project is being deleted.&lt;/p&gt;
     * &lt;p&gt;The account is reachable on either TLS port only from the project&amp;apos;s
     * &lt;code&gt;softphone_permit_cidrs&lt;/code&gt; (default: the server&amp;apos;s list, private networks unless the
     * operator changed it); see &lt;code&gt;AsteriskConfigsVariables.softphone_permit_cidrs&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void updateSoftphoneAccount(ondewo.vtsi.SoftphonesOuterClass.UpdateSoftphoneAccountRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSoftphoneAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a softphone account. Its endpoint is removed from the Asterisk, its registrations are
     * dropped and every certificate it holds is revoked. Deletion is permanent.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist.&lt;/p&gt;
     * </pre>
     */
    public void deleteSoftphoneAccount(ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSoftphoneAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the softphone accounts of a VTSI project, filtered, sorted and paged. Never returns a
     * secret.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an
     * invalid filter, an unknown &lt;code&gt;field_mask&lt;/code&gt; path, a negative &lt;code&gt;page_size&lt;/code&gt; or a
     * &lt;code&gt;page_token&lt;/code&gt; that was not issued for the same project, filter and sorting.&lt;/p&gt;
     * </pre>
     */
    public void listSoftphoneAccounts(ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSoftphoneAccountsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Rotates the SIP password and/or the client certificate of a softphone account and returns the new
     * ONE-TIME secrets. &lt;b&gt;Every rotation rotates the SIP password&lt;/b&gt;, including one that asked only for
     * &lt;code&gt;rotate_certificate&lt;/code&gt;: the Asterisk has no certificate revocation list, so a previous
     * certificate stops being usable for this account only because the password it was issued with
     * stops working. The new password takes effect immediately and drops the account&amp;apos;s current
     * registrations, so every softphone using it must be reconfigured. A rotated certificate moves the
     * previous &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_ACTIVE&lt;/code&gt; certificate to
     * &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_SUPERSEDED&lt;/code&gt;. A rotation also unlocks an account that
     * &lt;code&gt;RevokeSoftphoneCertificate&lt;/code&gt; locked (a &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;
     * account only once it again holds an ACTIVE certificate).&lt;/p&gt;
     * &lt;p&gt;Rotating the certificate of a &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_SERVER_TLS_ONLY&lt;/code&gt; account is
     * allowed: it issues the certificate that a later switch to
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt; requires, and rotates the password too.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; if
     * neither &lt;code&gt;rotate_sip_password&lt;/code&gt; nor &lt;code&gt;rotate_certificate&lt;/code&gt; is set;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; if the project is being deleted, or, for
     * &lt;code&gt;rotate_certificate&lt;/code&gt;, if the project has no Asterisk port yet or its SOFTPHONE
     * certificate authority is unusable.&lt;/p&gt;
     * </pre>
     */
    public void rotateSoftphoneCredentials(ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRotateSoftphoneCredentialsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists softphone client certificates, either of one softphone account or of a whole VTSI project,
     * filtered and paged, newest first. Only public material is returned.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project or account does not exist;
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; if no scope is set, for an invalid filter, an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path, a negative &lt;code&gt;page_size&lt;/code&gt; or a foreign
     * &lt;code&gt;page_token&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public void listSoftphoneCertificates(ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSoftphoneCertificatesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns one softphone client certificate. Only public material is returned.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the certificate does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for
     * a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public void getSoftphoneCertificate(ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneCertificateRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSoftphoneCertificateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Revokes a softphone client certificate. The Asterisk has no certificate revocation list, so
     * revocation is enforced on the account&amp;apos;s SIP password rather than on the certificate: a revoked
     * certificate still completes the TLS handshake on the project&amp;apos;s mutual-TLS port, but it no longer
     * gets its holder an account.&lt;/p&gt;
     * &lt;p&gt;Revoking the ACTIVE certificate of an account LOCKS the account, whatever its transport
     * security: it is removed from the Asterisk and its registrations are dropped until
     * &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt; issues a new password (and, for
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, a new certificate). Revoking a
     * SUPERSEDED certificate records the revocation only; its password was already rotated away.
     * Revoking an already revoked certificate is idempotent and keeps the original revocation time and
     * reason.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the certificate does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for a malformed name or an over-long reason.&lt;/p&gt;
     * </pre>
     */
    public void revokeSoftphoneCertificate(ondewo.vtsi.SoftphonesOuterClass.RevokeSoftphoneCertificateRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRevokeSoftphoneCertificateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns everything needed to configure a softphone for an account: server, port, transport,
     * outbound proxy, SIP identity, SRTP mode, codecs, the certificate authority to trust, which client
     * certificate to import, and step-by-step Zoiper instructions. It never contains the SIP password or
     * the private key; those were returned once by &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; or
     * &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; if
     * the project is not &lt;code&gt;DEPLOYED&lt;/code&gt; (the host and ports describe a running Asterisk), or if a
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt; account has no
     * &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_ACTIVE&lt;/code&gt; certificate.&lt;/p&gt;
     * </pre>
     */
    public void getSoftphoneProvisioning(ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneProvisioningRequest request,
        io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.SoftphoneProvisioning> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSoftphoneProvisioningMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Softphones.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the SOFTPHONE ACCOUNTS of a VTSI project: SIP accounts on the project&amp;apos;s Asterisk that
   * a human uses from a softphone such as Zoiper, to call into the project&amp;apos;s listeners or to be reached
   * by the project.&lt;/p&gt;
   * &lt;p&gt;A softphone account is NEVER one of the &lt;code&gt;ondewo000N&lt;/code&gt; accounts the per-call ondewo-sip
   * containers register with: it has its own SIP credentials, its own endpoint on the Asterisk and, for
   * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, its own client certificate issued by the
   * project&amp;apos;s SOFTPHONE certificate authority.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Secrets are handed out exactly once.&lt;/b&gt; The SIP password and the password-protected PKCS#12
   * bundle carrying the client private key appear only in the responses of
   * &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; and &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt;. VTSI keeps no copy of
   * the private key or of the PKCS#12 password, and stores the SIP password only in the form the Asterisk
   * needs to verify a SIP digest. No other RPC returns a secret; a lost private key or password is
   * recovered by rotating it.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes, not as &lt;code&gt;error_message&lt;/code&gt; fields:
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, filter, field mask or value;
   * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, account or certificate;
   * &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a &lt;code&gt;sip_username&lt;/code&gt; already taken in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the project or the account is in a state that does not allow the
   * operation (each RPC names its cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change to the same account
   * won, in which case nothing was stored and the request can be retried.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;A change that reduces access is enforced before it is acknowledged.&lt;/b&gt; When
   * &lt;code&gt;UpdateSoftphoneAccount&lt;/code&gt;, &lt;code&gt;DeleteSoftphoneAccount&lt;/code&gt; or
   * &lt;code&gt;RevokeSoftphoneCertificate&lt;/code&gt; is stored but the running Asterisk of a deployed project could
   * not be updated, the RPC fails with &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;; the stored change is applied by
   * the next successful change or deployment. &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; and
   * &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt; return their one-time secrets even then.&lt;/p&gt;
   * </pre>
   */
  public static final class SoftphonesBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SoftphonesBlockingV2Stub> {
    private SoftphonesBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SoftphonesBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SoftphonesBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a softphone account in a VTSI project, generates its SIP password and, for
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, issues its first client certificate.
     * The response carries the ONE-TIME secrets; they cannot be retrieved again.&lt;/p&gt;
     * &lt;p&gt;If the project is deployed the account is applied to the running Asterisk; otherwise it is
     * applied on the next deployment.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; if the
     * &lt;code&gt;sip_username&lt;/code&gt; is taken in the project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an invalid or
     * reserved &lt;code&gt;sip_username&lt;/code&gt;, an output-only field that was set, or an out-of-range value;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; if the project is being deleted, or, for
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, if the project has no Asterisk port yet
     * or its SOFTPHONE certificate authority is unusable (a redeployment mints a new one).&lt;/p&gt;
     * &lt;p&gt;The account is reachable on either TLS port only from the project&amp;apos;s
     * &lt;code&gt;softphone_permit_cidrs&lt;/code&gt; (default: the server&amp;apos;s list, private networks unless the
     * operator changed it); see &lt;code&gt;AsteriskConfigsVariables.softphone_permit_cidrs&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountResponse createSoftphoneAccount(ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSoftphoneAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a softphone account. Never returns a secret.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a
     * malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount getSoftphoneAccount(ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneAccountRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSoftphoneAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the mutable fields of a softphone account named by &lt;code&gt;update_mask&lt;/code&gt;. Credentials
     * are not changed here; use &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an
     * empty mask, an unknown, output-only or immutable path, or an out-of-range value;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when switching to
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt; while the account has no
     * &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_ACTIVE&lt;/code&gt; certificate, or if the project is being deleted.&lt;/p&gt;
     * &lt;p&gt;The account is reachable on either TLS port only from the project&amp;apos;s
     * &lt;code&gt;softphone_permit_cidrs&lt;/code&gt; (default: the server&amp;apos;s list, private networks unless the
     * operator changed it); see &lt;code&gt;AsteriskConfigsVariables.softphone_permit_cidrs&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount updateSoftphoneAccount(ondewo.vtsi.SoftphonesOuterClass.UpdateSoftphoneAccountRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateSoftphoneAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a softphone account. Its endpoint is removed from the Asterisk, its registrations are
     * dropped and every certificate it holds is revoked. Deletion is permanent.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountResponse deleteSoftphoneAccount(ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteSoftphoneAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the softphone accounts of a VTSI project, filtered, sorted and paged. Never returns a
     * secret.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an
     * invalid filter, an unknown &lt;code&gt;field_mask&lt;/code&gt; path, a negative &lt;code&gt;page_size&lt;/code&gt; or a
     * &lt;code&gt;page_token&lt;/code&gt; that was not issued for the same project, filter and sorting.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsResponse listSoftphoneAccounts(ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSoftphoneAccountsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Rotates the SIP password and/or the client certificate of a softphone account and returns the new
     * ONE-TIME secrets. &lt;b&gt;Every rotation rotates the SIP password&lt;/b&gt;, including one that asked only for
     * &lt;code&gt;rotate_certificate&lt;/code&gt;: the Asterisk has no certificate revocation list, so a previous
     * certificate stops being usable for this account only because the password it was issued with
     * stops working. The new password takes effect immediately and drops the account&amp;apos;s current
     * registrations, so every softphone using it must be reconfigured. A rotated certificate moves the
     * previous &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_ACTIVE&lt;/code&gt; certificate to
     * &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_SUPERSEDED&lt;/code&gt;. A rotation also unlocks an account that
     * &lt;code&gt;RevokeSoftphoneCertificate&lt;/code&gt; locked (a &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;
     * account only once it again holds an ACTIVE certificate).&lt;/p&gt;
     * &lt;p&gt;Rotating the certificate of a &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_SERVER_TLS_ONLY&lt;/code&gt; account is
     * allowed: it issues the certificate that a later switch to
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt; requires, and rotates the password too.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; if
     * neither &lt;code&gt;rotate_sip_password&lt;/code&gt; nor &lt;code&gt;rotate_certificate&lt;/code&gt; is set;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; if the project is being deleted, or, for
     * &lt;code&gt;rotate_certificate&lt;/code&gt;, if the project has no Asterisk port yet or its SOFTPHONE
     * certificate authority is unusable.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsResponse rotateSoftphoneCredentials(ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRotateSoftphoneCredentialsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists softphone client certificates, either of one softphone account or of a whole VTSI project,
     * filtered and paged, newest first. Only public material is returned.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project or account does not exist;
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; if no scope is set, for an invalid filter, an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path, a negative &lt;code&gt;page_size&lt;/code&gt; or a foreign
     * &lt;code&gt;page_token&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesResponse listSoftphoneCertificates(ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSoftphoneCertificatesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns one softphone client certificate. Only public material is returned.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the certificate does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for
     * a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate getSoftphoneCertificate(ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneCertificateRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSoftphoneCertificateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Revokes a softphone client certificate. The Asterisk has no certificate revocation list, so
     * revocation is enforced on the account&amp;apos;s SIP password rather than on the certificate: a revoked
     * certificate still completes the TLS handshake on the project&amp;apos;s mutual-TLS port, but it no longer
     * gets its holder an account.&lt;/p&gt;
     * &lt;p&gt;Revoking the ACTIVE certificate of an account LOCKS the account, whatever its transport
     * security: it is removed from the Asterisk and its registrations are dropped until
     * &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt; issues a new password (and, for
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, a new certificate). Revoking a
     * SUPERSEDED certificate records the revocation only; its password was already rotated away.
     * Revoking an already revoked certificate is idempotent and keeps the original revocation time and
     * reason.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the certificate does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for a malformed name or an over-long reason.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate revokeSoftphoneCertificate(ondewo.vtsi.SoftphonesOuterClass.RevokeSoftphoneCertificateRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRevokeSoftphoneCertificateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns everything needed to configure a softphone for an account: server, port, transport,
     * outbound proxy, SIP identity, SRTP mode, codecs, the certificate authority to trust, which client
     * certificate to import, and step-by-step Zoiper instructions. It never contains the SIP password or
     * the private key; those were returned once by &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; or
     * &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; if
     * the project is not &lt;code&gt;DEPLOYED&lt;/code&gt; (the host and ports describe a running Asterisk), or if a
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt; account has no
     * &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_ACTIVE&lt;/code&gt; certificate.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.SoftphoneProvisioning getSoftphoneProvisioning(ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneProvisioningRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSoftphoneProvisioningMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Softphones.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the SOFTPHONE ACCOUNTS of a VTSI project: SIP accounts on the project&amp;apos;s Asterisk that
   * a human uses from a softphone such as Zoiper, to call into the project&amp;apos;s listeners or to be reached
   * by the project.&lt;/p&gt;
   * &lt;p&gt;A softphone account is NEVER one of the &lt;code&gt;ondewo000N&lt;/code&gt; accounts the per-call ondewo-sip
   * containers register with: it has its own SIP credentials, its own endpoint on the Asterisk and, for
   * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, its own client certificate issued by the
   * project&amp;apos;s SOFTPHONE certificate authority.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Secrets are handed out exactly once.&lt;/b&gt; The SIP password and the password-protected PKCS#12
   * bundle carrying the client private key appear only in the responses of
   * &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; and &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt;. VTSI keeps no copy of
   * the private key or of the PKCS#12 password, and stores the SIP password only in the form the Asterisk
   * needs to verify a SIP digest. No other RPC returns a secret; a lost private key or password is
   * recovered by rotating it.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes, not as &lt;code&gt;error_message&lt;/code&gt; fields:
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, filter, field mask or value;
   * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, account or certificate;
   * &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a &lt;code&gt;sip_username&lt;/code&gt; already taken in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the project or the account is in a state that does not allow the
   * operation (each RPC names its cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change to the same account
   * won, in which case nothing was stored and the request can be retried.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;A change that reduces access is enforced before it is acknowledged.&lt;/b&gt; When
   * &lt;code&gt;UpdateSoftphoneAccount&lt;/code&gt;, &lt;code&gt;DeleteSoftphoneAccount&lt;/code&gt; or
   * &lt;code&gt;RevokeSoftphoneCertificate&lt;/code&gt; is stored but the running Asterisk of a deployed project could
   * not be updated, the RPC fails with &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;; the stored change is applied by
   * the next successful change or deployment. &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; and
   * &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt; return their one-time secrets even then.&lt;/p&gt;
   * </pre>
   */
  public static final class SoftphonesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SoftphonesBlockingStub> {
    private SoftphonesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SoftphonesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SoftphonesBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a softphone account in a VTSI project, generates its SIP password and, for
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, issues its first client certificate.
     * The response carries the ONE-TIME secrets; they cannot be retrieved again.&lt;/p&gt;
     * &lt;p&gt;If the project is deployed the account is applied to the running Asterisk; otherwise it is
     * applied on the next deployment.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; if the
     * &lt;code&gt;sip_username&lt;/code&gt; is taken in the project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an invalid or
     * reserved &lt;code&gt;sip_username&lt;/code&gt;, an output-only field that was set, or an out-of-range value;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; if the project is being deleted, or, for
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, if the project has no Asterisk port yet
     * or its SOFTPHONE certificate authority is unusable (a redeployment mints a new one).&lt;/p&gt;
     * &lt;p&gt;The account is reachable on either TLS port only from the project&amp;apos;s
     * &lt;code&gt;softphone_permit_cidrs&lt;/code&gt; (default: the server&amp;apos;s list, private networks unless the
     * operator changed it); see &lt;code&gt;AsteriskConfigsVariables.softphone_permit_cidrs&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountResponse createSoftphoneAccount(ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSoftphoneAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a softphone account. Never returns a secret.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a
     * malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount getSoftphoneAccount(ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSoftphoneAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the mutable fields of a softphone account named by &lt;code&gt;update_mask&lt;/code&gt;. Credentials
     * are not changed here; use &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an
     * empty mask, an unknown, output-only or immutable path, or an out-of-range value;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when switching to
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt; while the account has no
     * &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_ACTIVE&lt;/code&gt; certificate, or if the project is being deleted.&lt;/p&gt;
     * &lt;p&gt;The account is reachable on either TLS port only from the project&amp;apos;s
     * &lt;code&gt;softphone_permit_cidrs&lt;/code&gt; (default: the server&amp;apos;s list, private networks unless the
     * operator changed it); see &lt;code&gt;AsteriskConfigsVariables.softphone_permit_cidrs&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount updateSoftphoneAccount(ondewo.vtsi.SoftphonesOuterClass.UpdateSoftphoneAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSoftphoneAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a softphone account. Its endpoint is removed from the Asterisk, its registrations are
     * dropped and every certificate it holds is revoked. Deletion is permanent.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountResponse deleteSoftphoneAccount(ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSoftphoneAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the softphone accounts of a VTSI project, filtered, sorted and paged. Never returns a
     * secret.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an
     * invalid filter, an unknown &lt;code&gt;field_mask&lt;/code&gt; path, a negative &lt;code&gt;page_size&lt;/code&gt; or a
     * &lt;code&gt;page_token&lt;/code&gt; that was not issued for the same project, filter and sorting.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsResponse listSoftphoneAccounts(ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSoftphoneAccountsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Rotates the SIP password and/or the client certificate of a softphone account and returns the new
     * ONE-TIME secrets. &lt;b&gt;Every rotation rotates the SIP password&lt;/b&gt;, including one that asked only for
     * &lt;code&gt;rotate_certificate&lt;/code&gt;: the Asterisk has no certificate revocation list, so a previous
     * certificate stops being usable for this account only because the password it was issued with
     * stops working. The new password takes effect immediately and drops the account&amp;apos;s current
     * registrations, so every softphone using it must be reconfigured. A rotated certificate moves the
     * previous &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_ACTIVE&lt;/code&gt; certificate to
     * &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_SUPERSEDED&lt;/code&gt;. A rotation also unlocks an account that
     * &lt;code&gt;RevokeSoftphoneCertificate&lt;/code&gt; locked (a &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;
     * account only once it again holds an ACTIVE certificate).&lt;/p&gt;
     * &lt;p&gt;Rotating the certificate of a &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_SERVER_TLS_ONLY&lt;/code&gt; account is
     * allowed: it issues the certificate that a later switch to
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt; requires, and rotates the password too.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; if
     * neither &lt;code&gt;rotate_sip_password&lt;/code&gt; nor &lt;code&gt;rotate_certificate&lt;/code&gt; is set;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; if the project is being deleted, or, for
     * &lt;code&gt;rotate_certificate&lt;/code&gt;, if the project has no Asterisk port yet or its SOFTPHONE
     * certificate authority is unusable.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsResponse rotateSoftphoneCredentials(ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRotateSoftphoneCredentialsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists softphone client certificates, either of one softphone account or of a whole VTSI project,
     * filtered and paged, newest first. Only public material is returned.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project or account does not exist;
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; if no scope is set, for an invalid filter, an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path, a negative &lt;code&gt;page_size&lt;/code&gt; or a foreign
     * &lt;code&gt;page_token&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesResponse listSoftphoneCertificates(ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSoftphoneCertificatesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns one softphone client certificate. Only public material is returned.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the certificate does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for
     * a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate getSoftphoneCertificate(ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSoftphoneCertificateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Revokes a softphone client certificate. The Asterisk has no certificate revocation list, so
     * revocation is enforced on the account&amp;apos;s SIP password rather than on the certificate: a revoked
     * certificate still completes the TLS handshake on the project&amp;apos;s mutual-TLS port, but it no longer
     * gets its holder an account.&lt;/p&gt;
     * &lt;p&gt;Revoking the ACTIVE certificate of an account LOCKS the account, whatever its transport
     * security: it is removed from the Asterisk and its registrations are dropped until
     * &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt; issues a new password (and, for
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, a new certificate). Revoking a
     * SUPERSEDED certificate records the revocation only; its password was already rotated away.
     * Revoking an already revoked certificate is idempotent and keeps the original revocation time and
     * reason.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the certificate does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for a malformed name or an over-long reason.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate revokeSoftphoneCertificate(ondewo.vtsi.SoftphonesOuterClass.RevokeSoftphoneCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRevokeSoftphoneCertificateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns everything needed to configure a softphone for an account: server, port, transport,
     * outbound proxy, SIP identity, SRTP mode, codecs, the certificate authority to trust, which client
     * certificate to import, and step-by-step Zoiper instructions. It never contains the SIP password or
     * the private key; those were returned once by &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; or
     * &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; if
     * the project is not &lt;code&gt;DEPLOYED&lt;/code&gt; (the host and ports describe a running Asterisk), or if a
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt; account has no
     * &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_ACTIVE&lt;/code&gt; certificate.&lt;/p&gt;
     * </pre>
     */
    public ondewo.vtsi.SoftphonesOuterClass.SoftphoneProvisioning getSoftphoneProvisioning(ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneProvisioningRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSoftphoneProvisioningMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Softphones.
   * <pre>
   * &lt;p&gt;ONDEWO VTSI API&lt;/p&gt;
   * &lt;p&gt;Manages the SOFTPHONE ACCOUNTS of a VTSI project: SIP accounts on the project&amp;apos;s Asterisk that
   * a human uses from a softphone such as Zoiper, to call into the project&amp;apos;s listeners or to be reached
   * by the project.&lt;/p&gt;
   * &lt;p&gt;A softphone account is NEVER one of the &lt;code&gt;ondewo000N&lt;/code&gt; accounts the per-call ondewo-sip
   * containers register with: it has its own SIP credentials, its own endpoint on the Asterisk and, for
   * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, its own client certificate issued by the
   * project&amp;apos;s SOFTPHONE certificate authority.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;Secrets are handed out exactly once.&lt;/b&gt; The SIP password and the password-protected PKCS#12
   * bundle carrying the client private key appear only in the responses of
   * &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; and &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt;. VTSI keeps no copy of
   * the private key or of the PKCS#12 password, and stores the SIP password only in the form the Asterisk
   * needs to verify a SIP digest. No other RPC returns a secret; a lost private key or password is
   * recovered by rotating it.&lt;/p&gt;
   * &lt;p&gt;Errors are reported as gRPC status codes, not as &lt;code&gt;error_message&lt;/code&gt; fields:
   * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a malformed name, filter, field mask or value;
   * &lt;code&gt;NOT_FOUND&lt;/code&gt; for an unknown project, account or certificate;
   * &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; for a &lt;code&gt;sip_username&lt;/code&gt; already taken in the project;
   * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when the project or the account is in a state that does not allow the
   * operation (each RPC names its cases); &lt;code&gt;ABORTED&lt;/code&gt; when a concurrent change to the same account
   * won, in which case nothing was stored and the request can be retried.&lt;/p&gt;
   * &lt;p&gt;&lt;b&gt;A change that reduces access is enforced before it is acknowledged.&lt;/b&gt; When
   * &lt;code&gt;UpdateSoftphoneAccount&lt;/code&gt;, &lt;code&gt;DeleteSoftphoneAccount&lt;/code&gt; or
   * &lt;code&gt;RevokeSoftphoneCertificate&lt;/code&gt; is stored but the running Asterisk of a deployed project could
   * not be updated, the RPC fails with &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt;; the stored change is applied by
   * the next successful change or deployment. &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; and
   * &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt; return their one-time secrets even then.&lt;/p&gt;
   * </pre>
   */
  public static final class SoftphonesFutureStub
      extends io.grpc.stub.AbstractFutureStub<SoftphonesFutureStub> {
    private SoftphonesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SoftphonesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SoftphonesFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Creates a softphone account in a VTSI project, generates its SIP password and, for
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, issues its first client certificate.
     * The response carries the ONE-TIME secrets; they cannot be retrieved again.&lt;/p&gt;
     * &lt;p&gt;If the project is deployed the account is applied to the running Asterisk; otherwise it is
     * applied on the next deployment.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;ALREADY_EXISTS&lt;/code&gt; if the
     * &lt;code&gt;sip_username&lt;/code&gt; is taken in the project; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an invalid or
     * reserved &lt;code&gt;sip_username&lt;/code&gt;, an output-only field that was set, or an out-of-range value;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; if the project is being deleted, or, for
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, if the project has no Asterisk port yet
     * or its SOFTPHONE certificate authority is unusable (a redeployment mints a new one).&lt;/p&gt;
     * &lt;p&gt;The account is reachable on either TLS port only from the project&amp;apos;s
     * &lt;code&gt;softphone_permit_cidrs&lt;/code&gt; (default: the server&amp;apos;s list, private networks unless the
     * operator changed it); see &lt;code&gt;AsteriskConfigsVariables.softphone_permit_cidrs&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountResponse> createSoftphoneAccount(
        ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSoftphoneAccountMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns a softphone account. Never returns a secret.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for a
     * malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount> getSoftphoneAccount(
        ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSoftphoneAccountMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Updates the mutable fields of a softphone account named by &lt;code&gt;update_mask&lt;/code&gt;. Credentials
     * are not changed here; use &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an
     * empty mask, an unknown, output-only or immutable path, or an out-of-range value;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; when switching to
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt; while the account has no
     * &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_ACTIVE&lt;/code&gt; certificate, or if the project is being deleted.&lt;/p&gt;
     * &lt;p&gt;The account is reachable on either TLS port only from the project&amp;apos;s
     * &lt;code&gt;softphone_permit_cidrs&lt;/code&gt; (default: the server&amp;apos;s list, private networks unless the
     * operator changed it); see &lt;code&gt;AsteriskConfigsVariables.softphone_permit_cidrs&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount> updateSoftphoneAccount(
        ondewo.vtsi.SoftphonesOuterClass.UpdateSoftphoneAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSoftphoneAccountMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Deletes a softphone account. Its endpoint is removed from the Asterisk, its registrations are
     * dropped and every certificate it holds is revoked. Deletion is permanent.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountResponse> deleteSoftphoneAccount(
        ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSoftphoneAccountMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists the softphone accounts of a VTSI project, filtered, sorted and paged. Never returns a
     * secret.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for an
     * invalid filter, an unknown &lt;code&gt;field_mask&lt;/code&gt; path, a negative &lt;code&gt;page_size&lt;/code&gt; or a
     * &lt;code&gt;page_token&lt;/code&gt; that was not issued for the same project, filter and sorting.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsResponse> listSoftphoneAccounts(
        ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSoftphoneAccountsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Rotates the SIP password and/or the client certificate of a softphone account and returns the new
     * ONE-TIME secrets. &lt;b&gt;Every rotation rotates the SIP password&lt;/b&gt;, including one that asked only for
     * &lt;code&gt;rotate_certificate&lt;/code&gt;: the Asterisk has no certificate revocation list, so a previous
     * certificate stops being usable for this account only because the password it was issued with
     * stops working. The new password takes effect immediately and drops the account&amp;apos;s current
     * registrations, so every softphone using it must be reconfigured. A rotated certificate moves the
     * previous &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_ACTIVE&lt;/code&gt; certificate to
     * &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_SUPERSEDED&lt;/code&gt;. A rotation also unlocks an account that
     * &lt;code&gt;RevokeSoftphoneCertificate&lt;/code&gt; locked (a &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;
     * account only once it again holds an ACTIVE certificate).&lt;/p&gt;
     * &lt;p&gt;Rotating the certificate of a &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_SERVER_TLS_ONLY&lt;/code&gt; account is
     * allowed: it issues the certificate that a later switch to
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt; requires, and rotates the password too.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; if
     * neither &lt;code&gt;rotate_sip_password&lt;/code&gt; nor &lt;code&gt;rotate_certificate&lt;/code&gt; is set;
     * &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; if the project is being deleted, or, for
     * &lt;code&gt;rotate_certificate&lt;/code&gt;, if the project has no Asterisk port yet or its SOFTPHONE
     * certificate authority is unusable.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsResponse> rotateSoftphoneCredentials(
        ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRotateSoftphoneCredentialsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Lists softphone client certificates, either of one softphone account or of a whole VTSI project,
     * filtered and paged, newest first. Only public material is returned.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the project or account does not exist;
     * &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; if no scope is set, for an invalid filter, an unknown
     * &lt;code&gt;field_mask&lt;/code&gt; path, a negative &lt;code&gt;page_size&lt;/code&gt; or a foreign
     * &lt;code&gt;page_token&lt;/code&gt;.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesResponse> listSoftphoneCertificates(
        ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSoftphoneCertificatesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns one softphone client certificate. Only public material is returned.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the certificate does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt; for
     * a malformed name or an unknown &lt;code&gt;field_mask&lt;/code&gt; path.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate> getSoftphoneCertificate(
        ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSoftphoneCertificateMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Revokes a softphone client certificate. The Asterisk has no certificate revocation list, so
     * revocation is enforced on the account&amp;apos;s SIP password rather than on the certificate: a revoked
     * certificate still completes the TLS handshake on the project&amp;apos;s mutual-TLS port, but it no longer
     * gets its holder an account.&lt;/p&gt;
     * &lt;p&gt;Revoking the ACTIVE certificate of an account LOCKS the account, whatever its transport
     * security: it is removed from the Asterisk and its registrations are dropped until
     * &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt; issues a new password (and, for
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt;, a new certificate). Revoking a
     * SUPERSEDED certificate records the revocation only; its password was already rotated away.
     * Revoking an already revoked certificate is idempotent and keeps the original revocation time and
     * reason.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the certificate does not exist; &lt;code&gt;INVALID_ARGUMENT&lt;/code&gt;
     * for a malformed name or an over-long reason.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate> revokeSoftphoneCertificate(
        ondewo.vtsi.SoftphonesOuterClass.RevokeSoftphoneCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRevokeSoftphoneCertificateMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Returns everything needed to configure a softphone for an account: server, port, transport,
     * outbound proxy, SIP identity, SRTP mode, codecs, the certificate authority to trust, which client
     * certificate to import, and step-by-step Zoiper instructions. It never contains the SIP password or
     * the private key; those were returned once by &lt;code&gt;CreateSoftphoneAccount&lt;/code&gt; or
     * &lt;code&gt;RotateSoftphoneCredentials&lt;/code&gt;.&lt;/p&gt;
     * &lt;p&gt;Errors: &lt;code&gt;NOT_FOUND&lt;/code&gt; if the account does not exist; &lt;code&gt;FAILED_PRECONDITION&lt;/code&gt; if
     * the project is not &lt;code&gt;DEPLOYED&lt;/code&gt; (the host and ports describe a running Asterisk), or if a
     * &lt;code&gt;SOFTPHONE_TRANSPORT_SECURITY_CLIENT_CERTIFICATE&lt;/code&gt; account has no
     * &lt;code&gt;SOFTPHONE_CERTIFICATE_STATUS_ACTIVE&lt;/code&gt; certificate.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.vtsi.SoftphonesOuterClass.SoftphoneProvisioning> getSoftphoneProvisioning(
        ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneProvisioningRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSoftphoneProvisioningMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SOFTPHONE_ACCOUNT = 0;
  private static final int METHODID_GET_SOFTPHONE_ACCOUNT = 1;
  private static final int METHODID_UPDATE_SOFTPHONE_ACCOUNT = 2;
  private static final int METHODID_DELETE_SOFTPHONE_ACCOUNT = 3;
  private static final int METHODID_LIST_SOFTPHONE_ACCOUNTS = 4;
  private static final int METHODID_ROTATE_SOFTPHONE_CREDENTIALS = 5;
  private static final int METHODID_LIST_SOFTPHONE_CERTIFICATES = 6;
  private static final int METHODID_GET_SOFTPHONE_CERTIFICATE = 7;
  private static final int METHODID_REVOKE_SOFTPHONE_CERTIFICATE = 8;
  private static final int METHODID_GET_SOFTPHONE_PROVISIONING = 9;

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
        case METHODID_CREATE_SOFTPHONE_ACCOUNT:
          serviceImpl.createSoftphoneAccount((ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountResponse>) responseObserver);
          break;
        case METHODID_GET_SOFTPHONE_ACCOUNT:
          serviceImpl.getSoftphoneAccount((ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneAccountRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount>) responseObserver);
          break;
        case METHODID_UPDATE_SOFTPHONE_ACCOUNT:
          serviceImpl.updateSoftphoneAccount((ondewo.vtsi.SoftphonesOuterClass.UpdateSoftphoneAccountRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount>) responseObserver);
          break;
        case METHODID_DELETE_SOFTPHONE_ACCOUNT:
          serviceImpl.deleteSoftphoneAccount((ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountResponse>) responseObserver);
          break;
        case METHODID_LIST_SOFTPHONE_ACCOUNTS:
          serviceImpl.listSoftphoneAccounts((ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsResponse>) responseObserver);
          break;
        case METHODID_ROTATE_SOFTPHONE_CREDENTIALS:
          serviceImpl.rotateSoftphoneCredentials((ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsResponse>) responseObserver);
          break;
        case METHODID_LIST_SOFTPHONE_CERTIFICATES:
          serviceImpl.listSoftphoneCertificates((ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesResponse>) responseObserver);
          break;
        case METHODID_GET_SOFTPHONE_CERTIFICATE:
          serviceImpl.getSoftphoneCertificate((ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneCertificateRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate>) responseObserver);
          break;
        case METHODID_REVOKE_SOFTPHONE_CERTIFICATE:
          serviceImpl.revokeSoftphoneCertificate((ondewo.vtsi.SoftphonesOuterClass.RevokeSoftphoneCertificateRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate>) responseObserver);
          break;
        case METHODID_GET_SOFTPHONE_PROVISIONING:
          serviceImpl.getSoftphoneProvisioning((ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneProvisioningRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.vtsi.SoftphonesOuterClass.SoftphoneProvisioning>) responseObserver);
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
          getCreateSoftphoneAccountMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountRequest,
              ondewo.vtsi.SoftphonesOuterClass.CreateSoftphoneAccountResponse>(
                service, METHODID_CREATE_SOFTPHONE_ACCOUNT)))
        .addMethod(
          getGetSoftphoneAccountMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneAccountRequest,
              ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount>(
                service, METHODID_GET_SOFTPHONE_ACCOUNT)))
        .addMethod(
          getUpdateSoftphoneAccountMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.SoftphonesOuterClass.UpdateSoftphoneAccountRequest,
              ondewo.vtsi.SoftphonesOuterClass.SoftphoneAccount>(
                service, METHODID_UPDATE_SOFTPHONE_ACCOUNT)))
        .addMethod(
          getDeleteSoftphoneAccountMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountRequest,
              ondewo.vtsi.SoftphonesOuterClass.DeleteSoftphoneAccountResponse>(
                service, METHODID_DELETE_SOFTPHONE_ACCOUNT)))
        .addMethod(
          getListSoftphoneAccountsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsRequest,
              ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneAccountsResponse>(
                service, METHODID_LIST_SOFTPHONE_ACCOUNTS)))
        .addMethod(
          getRotateSoftphoneCredentialsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsRequest,
              ondewo.vtsi.SoftphonesOuterClass.RotateSoftphoneCredentialsResponse>(
                service, METHODID_ROTATE_SOFTPHONE_CREDENTIALS)))
        .addMethod(
          getListSoftphoneCertificatesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesRequest,
              ondewo.vtsi.SoftphonesOuterClass.ListSoftphoneCertificatesResponse>(
                service, METHODID_LIST_SOFTPHONE_CERTIFICATES)))
        .addMethod(
          getGetSoftphoneCertificateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneCertificateRequest,
              ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate>(
                service, METHODID_GET_SOFTPHONE_CERTIFICATE)))
        .addMethod(
          getRevokeSoftphoneCertificateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.SoftphonesOuterClass.RevokeSoftphoneCertificateRequest,
              ondewo.vtsi.SoftphonesOuterClass.SoftphoneCertificate>(
                service, METHODID_REVOKE_SOFTPHONE_CERTIFICATE)))
        .addMethod(
          getGetSoftphoneProvisioningMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.vtsi.SoftphonesOuterClass.GetSoftphoneProvisioningRequest,
              ondewo.vtsi.SoftphonesOuterClass.SoftphoneProvisioning>(
                service, METHODID_GET_SOFTPHONE_PROVISIONING)))
        .build();
  }

  private static abstract class SoftphonesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SoftphonesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ondewo.vtsi.SoftphonesOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Softphones");
    }
  }

  private static final class SoftphonesFileDescriptorSupplier
      extends SoftphonesBaseDescriptorSupplier {
    SoftphonesFileDescriptorSupplier() {}
  }

  private static final class SoftphonesMethodDescriptorSupplier
      extends SoftphonesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SoftphonesMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SoftphonesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SoftphonesFileDescriptorSupplier())
              .addMethod(getCreateSoftphoneAccountMethod())
              .addMethod(getGetSoftphoneAccountMethod())
              .addMethod(getUpdateSoftphoneAccountMethod())
              .addMethod(getDeleteSoftphoneAccountMethod())
              .addMethod(getListSoftphoneAccountsMethod())
              .addMethod(getRotateSoftphoneCredentialsMethod())
              .addMethod(getListSoftphoneCertificatesMethod())
              .addMethod(getGetSoftphoneCertificateMethod())
              .addMethod(getRevokeSoftphoneCertificateMethod())
              .addMethod(getGetSoftphoneProvisioningMethod())
              .build();
        }
      }
    }
    return result;
  }
}
