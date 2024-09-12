package com.launchdarkly.sdk.android.integrations;

import com.launchdarkly.sdk.AttributeRef;
import com.launchdarkly.sdk.android.subsystems.ComponentConfigurer;
import com.launchdarkly.sdk.android.subsystems.EventProcessor;
import java.util.HashSet;
import java.util.Set;

public abstract class EventProcessorBuilder implements ComponentConfigurer<EventProcessor> {
    public static final int DEFAULT_CAPACITY = 100;
    public static final int DEFAULT_DIAGNOSTIC_RECORDING_INTERVAL_MILLIS = 900000;
    public static final int DEFAULT_FLUSH_INTERVAL_MILLIS = 30000;
    public static final int MIN_DIAGNOSTIC_RECORDING_INTERVAL_MILLIS = 300000;
    protected boolean allAttributesPrivate = false;
    protected int capacity = 100;
    protected int diagnosticRecordingIntervalMillis = 900000;
    protected int flushIntervalMillis = 30000;
    protected Set<AttributeRef> privateAttributes;

    public EventProcessorBuilder allAttributesPrivate(boolean z) {
        this.allAttributesPrivate = z;
        return this;
    }

    public EventProcessorBuilder capacity(int i) {
        this.capacity = i;
        return this;
    }

    public EventProcessorBuilder diagnosticRecordingIntervalMillis(int i) {
        if (i < 300000) {
            i = 300000;
        }
        this.diagnosticRecordingIntervalMillis = i;
        return this;
    }

    public EventProcessorBuilder flushIntervalMillis(int i) {
        if (i <= 0) {
            i = 30000;
        }
        this.flushIntervalMillis = i;
        return this;
    }

    public EventProcessorBuilder privateAttributes(String... strArr) {
        this.privateAttributes = new HashSet();
        for (String fromPath : strArr) {
            this.privateAttributes.add(AttributeRef.fromPath(fromPath));
        }
        return this;
    }
}
