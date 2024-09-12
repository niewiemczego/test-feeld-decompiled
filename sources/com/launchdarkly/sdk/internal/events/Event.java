package com.launchdarkly.sdk.internal.events;

import com.launchdarkly.sdk.EvaluationReason;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.LDValue;

public class Event {
    private final LDContext context;
    private final long creationDate;

    public Event(long j, LDContext lDContext) {
        this.creationDate = j;
        this.context = lDContext;
    }

    public long getCreationDate() {
        return this.creationDate;
    }

    public LDContext getContext() {
        return this.context;
    }

    public static final class Custom extends Event {
        private final LDValue data;
        private final String key;
        private final Double metricValue;

        public Custom(long j, String str, LDContext lDContext, LDValue lDValue, Double d) {
            super(j, lDContext);
            this.key = str;
            this.data = LDValue.normalize(lDValue);
            this.metricValue = d;
        }

        public String getKey() {
            return this.key;
        }

        public LDValue getData() {
            return this.data;
        }

        public Double getMetricValue() {
            return this.metricValue;
        }
    }

    public static final class Identify extends Event {
        public Identify(long j, LDContext lDContext) {
            super(j, lDContext);
        }
    }

    public static final class Index extends Event {
        public Index(long j, LDContext lDContext) {
            super(j, lDContext);
        }
    }

    public static final class FeatureRequest extends Event {
        private final boolean debug;
        private final Long debugEventsUntilDate;
        private final LDValue defaultVal;
        private final String key;
        private final String prereqOf;
        private final EvaluationReason reason;
        private final boolean trackEvents;
        private final LDValue value;
        private final int variation;
        private final int version;

        public FeatureRequest(long j, String str, LDContext lDContext, int i, int i2, LDValue lDValue, LDValue lDValue2, EvaluationReason evaluationReason, String str2, boolean z, Long l, boolean z2) {
            super(j, lDContext);
            this.key = str;
            this.version = i;
            this.variation = i2;
            this.value = lDValue;
            this.defaultVal = lDValue2;
            this.prereqOf = str2;
            this.trackEvents = z;
            this.debugEventsUntilDate = l;
            this.reason = evaluationReason;
            this.debug = z2;
        }

        public String getKey() {
            return this.key;
        }

        public int getVariation() {
            return this.variation;
        }

        public LDValue getValue() {
            return this.value;
        }

        public LDValue getDefaultVal() {
            return this.defaultVal;
        }

        public int getVersion() {
            return this.version;
        }

        public String getPrereqOf() {
            return this.prereqOf;
        }

        public boolean isTrackEvents() {
            return this.trackEvents;
        }

        public Long getDebugEventsUntilDate() {
            return this.debugEventsUntilDate;
        }

        public EvaluationReason getReason() {
            return this.reason;
        }

        public boolean isDebug() {
            return this.debug;
        }

        public FeatureRequest toDebugEvent() {
            return new FeatureRequest(getCreationDate(), getKey(), getContext(), getVersion(), getVariation(), getValue(), getDefaultVal(), getReason(), getPrereqOf(), false, (Long) null, true);
        }
    }
}
