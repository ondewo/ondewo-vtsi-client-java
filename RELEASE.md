# Release History

*****************

## Release ONDEWO VTSI Java Client 8.7.0

### New Features

* Initial release of the ONDEWO VTSI (Virtual Telephony Server Interface) gRPC client for Java. The library
  is generated from the protobuf definitions of [ondewo-vtsi-api](https://github.com/ondewo/ondewo-vtsi-api)
  by the `ondewo-java-proto-compiler` image of the
  [ONDEWO proto compiler](https://github.com/ondewo/ondewo-proto-compiler) release
  `5.15.0`: `protoc --java_out` for the message classes, `protoc-gen-grpc-java` for the
  service stubs, and a rendered `pom.xml` that pins the gRPC, protobuf and
  `proto-google-common-protos` versions the stubs were generated against. The packaged artifact is
  `com.ondewo:ondewo-vtsi-client-java`, compiled with `maven.compiler.release=11`, and ships a
  sources jar alongside the binary jar.
* `make build` regenerates the whole client from the pinned submodules - api protos and proto
  compiler - and `make test` verifies that every `.proto` produced java code before running
  `mvn verify`: the JUnit 5 suite over the **committed** stubs (432 generated java files, 23 gRPC
  services) plus the JaCoCo gate. Both run in CI on JDK 11 and JDK 21, unconditionally - a
  missing or truncated client turns the run red instead of skipping a step.
* Adds the one hand-written class of this client, `com/ondewo/vtsi/auth/BearerToken.java`, which wraps the
  `authorization: Bearer <token>` header every ONDEWO server expects and decorates any generated
  stub with it. Coverage is measured over the hand-written sources only and the build fails below
  100% instruction, branch and method coverage.

*****************
