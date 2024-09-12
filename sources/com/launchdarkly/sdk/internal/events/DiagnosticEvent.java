package com.launchdarkly.sdk.internal.events;

import com.launchdarkly.sdk.ArrayBuilder;
import com.launchdarkly.sdk.LDValue;
import com.launchdarkly.sdk.ObjectBuilder;
import java.util.List;

public class DiagnosticEvent {
    final boolean initEvent;
    final LDValue value;

    private DiagnosticEvent(boolean z, LDValue lDValue) {
        this.initEvent = z;
        this.value = lDValue;
    }

    public LDValue getJsonValue() {
        return this.value;
    }

    static DiagnosticEvent makeInit(long j, DiagnosticId diagnosticId, LDValue lDValue, LDValue lDValue2, LDValue lDValue3) {
        return new DiagnosticEvent(true, baseBuilder("diagnostic-init", j, diagnosticId).put("sdk", lDValue).put("configuration", lDValue2).put("platform", lDValue3).build());
    }

    static DiagnosticEvent makeStatistics(long j, DiagnosticId diagnosticId, long j2, long j3, long j4, long j5, List<StreamInit> list) {
        ObjectBuilder put = baseBuilder("diagnostic", j, diagnosticId).put("dataSinceDate", j2).put("droppedEvents", j3).put("deduplicatedUsers", j4).put("eventsInLastBatch", j5);
        ArrayBuilder buildArray = LDValue.buildArray();
        if (list != null) {
            for (StreamInit next : list) {
                buildArray.add(LDValue.buildObject().put("timestamp", next.timestamp).put("durationMillis", next.durationMillis).put("failed", next.failed).build());
            }
        }
        put.put("streamInits", buildArray.build());
        return new DiagnosticEvent(false, put.build());
    }

    private static ObjectBuilder baseBuilder(String str, long j, DiagnosticId diagnosticId) {
        return LDValue.buildObject().put("kind", str).put("creationDate", j).put("id", LDValue.buildObject().put("diagnosticId", diagnosticId.diagnosticId).put("sdkKeySuffix", diagnosticId.sdkKeySuffix).build());
    }

    static class StreamInit {
        final long durationMillis;
        final boolean failed;
        final long timestamp;

        StreamInit(long j, long j2, boolean z) {
            this.timestamp = j;
            this.durationMillis = j2;
            this.failed = z;
        }
    }
}
