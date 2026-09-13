package com.ondewo.vtsi.stubs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.protobuf.Timestamp;
import com.ondewo.nlu.Context;
import java.util.stream.Stream;
import ondewo.vtsi.CallsOuterClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Exercises the committed protoc output. These are the tests that catch a broken generator:
 * they build a message, push it through the real binary marshaller and read it back.
 *
 * <p>The protos of this product come in two java flavours and both are covered here: the
 * ondewo-nlu-api protos that ondewo-vtsi-api vendors and that set {@code java_multiple_files}
 * (context.proto, entity_type.proto, session.proto, common.proto) produce top-level classes in
 * {@code com.ondewo.nlu}, all the others - calls.proto included - nest their messages in an
 * outer class in {@code ondewo.<api>}.
 */
class GeneratedMessagesTest {

    @Test
    void roundTripsAMultiFileMessage() throws Exception {
        final Context original =
                Context.newBuilder()
                        .setName("welcome")
                        .setLifespanCount(5)
                        .putParameters(
                                "city",
                                Context.Parameter.newBuilder()
                                        .setName("city")
                                        .setDisplayName("City")
                                        .setValue("Vienna")
                                        .setCreatedAt(Timestamp.newBuilder().setSeconds(1_700_000_000L).build())
                                        .build())
                        .setCreatedBy("6a1b2c3d-0000-4000-8000-000000000000")
                        .build();

        final byte[] wire = original.toByteArray();
        final Context parsed = Context.parseFrom(wire);

        assertEquals(original, parsed);
        assertEquals("welcome", parsed.getName());
        assertEquals(5, parsed.getLifespanCount());
        assertEquals("Vienna", parsed.getParametersOrThrow("city").getValue());
        assertEquals(1_700_000_000L, parsed.getParametersOrThrow("city").getCreatedAt().getSeconds());
        assertTrue(wire.length > 0);
    }

    @Test
    void roundTripsAnOuterClassMessage() throws Exception {
        final CallsOuterClass.ListCallersResponse original =
                CallsOuterClass.ListCallersResponse.newBuilder()
                        .addCallers(
                                CallsOuterClass.Caller.newBuilder()
                                        .setName(
                                                "projects/6a1b2c3d-0000-4000-8000-000000000000"
                                                        + "/callers/1a2b3c4d")
                                        .setCallName("projects/6a1b2c3d/callers/1a2b3c4d/calls/x")
                                        .build())
                        .addCallers(CallsOuterClass.Caller.newBuilder().setName("second").build())
                        .setNextPageToken("current_index-2--page_size-20")
                        .build();

        final CallsOuterClass.ListCallersResponse parsed =
                CallsOuterClass.ListCallersResponse.parseFrom(original.toByteArray());

        assertEquals(original, parsed);
        assertEquals(2, parsed.getCallersCount());
        assertEquals("second", parsed.getCallers(1).getName());
        assertEquals("current_index-2--page_size-20", parsed.getNextPageToken());
    }

    /**
     * {@code optional string page_token = 2} in ondewo/vtsi/calls.proto. Explicit presence is
     * what lets a client send the zero value; losing it is the exact regression that broke the
     * angular target, so it is asserted on the wire here.
     */
    @Test
    void keepsExplicitPresenceOfAnOptionalScalar() throws Exception {
        final CallsOuterClass.ListCallersRequest unset =
                CallsOuterClass.ListCallersRequest.newBuilder()
                        .setVtsiProjectName("projects/6a1b2c3d/project")
                        .build();
        final CallsOuterClass.ListCallersRequest explicitEmpty =
                CallsOuterClass.ListCallersRequest.newBuilder()
                        .setVtsiProjectName("projects/6a1b2c3d/project")
                        .setPageToken("")
                        .build();

        assertFalse(
                CallsOuterClass.ListCallersRequest.parseFrom(unset.toByteArray()).hasPageToken());
        assertTrue(
                CallsOuterClass.ListCallersRequest.parseFrom(explicitEmpty.toByteArray())
                        .hasPageToken());
        assertEquals(
                "",
                CallsOuterClass.ListCallersRequest.parseFrom(explicitEmpty.toByteArray())
                        .getPageToken());
        // An explicitly set zero value has to reach the wire, an unset field must not.
        assertTrue(explicitEmpty.toByteArray().length > unset.toByteArray().length);
    }

    @Test
    void keepsTheProtoPackageInTheDescriptor() {
        // The java_package of the vendored nlu protos is rewritten to com.ondewo.nlu by the
        // compiler image, but the PROTO package - what goes on the wire - must stay ondewo.nlu,
        // and this product's own messages must stay ondewo.vtsi.
        assertEquals("ondewo.nlu.Context", Context.getDescriptor().getFullName());
        assertEquals(
                "ondewo.vtsi.ListCallersRequest",
                CallsOuterClass.ListCallersRequest.getDescriptor().getFullName());
        assertEquals(
                "ondewo.vtsi.Caller", CallsOuterClass.Caller.getDescriptor().getFullName());
    }

    @ParameterizedTest(name = "{0} has the zero value {1}")
    @MethodSource("zeroValues")
    void everyEnumDeclaresItsDefaultAtZero(final String name, final int number, final Object zeroValue) {
        assertEquals(0, number, name);
        assertEquals(name, zeroValue.toString());
    }

    /**
     * {@code CallStatus} and {@code ScheduledCallerStatus} spell their default
     * {@code *_UNSPECIFIED}; {@code CallView} predates that convention and names its zero member
     * {@code MINIMUM}. Either way the member carrying number 0 is what a proto3 field falls back
     * to, so that is what is pinned - a generator that loses the zero member makes that value
     * unrequestable.
     */
    private static Stream<Arguments> zeroValues() {
        return Stream.of(
                Arguments.of(
                        "CALL_STATUS_UNSPECIFIED",
                        CallsOuterClass.CallStatus.CALL_STATUS_UNSPECIFIED.getNumber(),
                        CallsOuterClass.CallStatus.forNumber(0)),
                Arguments.of(
                        "SCHEDULED_CALLER_STATUS_UNSPECIFIED",
                        CallsOuterClass.ScheduledCallerStatus.SCHEDULED_CALLER_STATUS_UNSPECIFIED
                                .getNumber(),
                        CallsOuterClass.ScheduledCallerStatus.forNumber(0)),
                Arguments.of(
                        "MINIMUM",
                        CallsOuterClass.CallView.MINIMUM.getNumber(),
                        CallsOuterClass.CallView.forNumber(0)));
    }

    @Test
    void defaultInstancesAreEmpty() {
        assertEquals("", CallsOuterClass.Caller.getDefaultInstance().getName());
        assertEquals("", CallsOuterClass.ListCallersResponse.getDefaultInstance().getNextPageToken());
        assertFalse(CallsOuterClass.ListCallersRequest.getDefaultInstance().hasPageToken());
        assertEquals(0, CallsOuterClass.Caller.getDefaultInstance().getSerializedSize());
    }
}
