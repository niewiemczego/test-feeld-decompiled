package com.launchdarkly.sdk.android;

import com.launchdarkly.sdk.EvaluationReason;
import com.launchdarkly.sdk.LDValue;
import com.launchdarkly.sdk.internal.GsonHelpers;
import com.launchdarkly.sdk.json.SerializationException;
import java.util.Objects;

public abstract class DataModel {
    private DataModel() {
    }

    public static final class Flag {
        private final Long debugEventsUntilDate;
        private final Boolean deleted;
        private final Integer flagVersion;
        private final String key;
        private final EvaluationReason reason;
        private final Boolean trackEvents;
        private final Boolean trackReason;
        private final LDValue value;
        private final Integer variation;
        private final int version;

        private Flag(String str, LDValue lDValue, int i, Integer num, Integer num2, EvaluationReason evaluationReason, boolean z, boolean z2, Long l, boolean z3) {
            this.key = str;
            this.value = lDValue;
            this.version = i;
            this.flagVersion = num;
            this.variation = num2;
            this.reason = evaluationReason;
            Boolean bool = null;
            this.trackEvents = z ? Boolean.TRUE : null;
            this.trackReason = z2 ? Boolean.TRUE : null;
            this.debugEventsUntilDate = l;
            this.deleted = z3 ? Boolean.TRUE : bool;
        }

        public Flag(String str, LDValue lDValue, int i, Integer num, Integer num2, boolean z, boolean z2, Long l, EvaluationReason evaluationReason) {
            this(str, lDValue, i, num, num2, evaluationReason, z, z2, l, false);
        }

        public static Flag deletedItemPlaceholder(String str, int i) {
            return new Flag(str, (LDValue) null, i, (Integer) null, (Integer) null, (EvaluationReason) null, false, false, (Long) null, true);
        }

        /* access modifiers changed from: package-private */
        public String getKey() {
            return this.key;
        }

        /* access modifiers changed from: package-private */
        public LDValue getValue() {
            return LDValue.normalize(this.value);
        }

        /* access modifiers changed from: package-private */
        public int getVersion() {
            return this.version;
        }

        /* access modifiers changed from: package-private */
        public Integer getFlagVersion() {
            return this.flagVersion;
        }

        /* access modifiers changed from: package-private */
        public Integer getVariation() {
            return this.variation;
        }

        /* access modifiers changed from: package-private */
        public EvaluationReason getReason() {
            return this.reason;
        }

        /* access modifiers changed from: package-private */
        public boolean isTrackEvents() {
            Boolean bool = this.trackEvents;
            return bool != null && bool.booleanValue();
        }

        /* access modifiers changed from: package-private */
        public boolean isTrackReason() {
            Boolean bool = this.trackReason;
            return bool != null && bool.booleanValue();
        }

        /* access modifiers changed from: package-private */
        public Long getDebugEventsUntilDate() {
            return this.debugEventsUntilDate;
        }

        /* access modifiers changed from: package-private */
        public int getVersionForEvents() {
            Integer num = this.flagVersion;
            return num == null ? this.version : num.intValue();
        }

        /* access modifiers changed from: package-private */
        public boolean isDeleted() {
            Boolean bool = this.deleted;
            return bool != null && bool.booleanValue();
        }

        public String toString() {
            return toJson();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Flag)) {
                return false;
            }
            Flag flag = (Flag) obj;
            if (!Objects.equals(this.key, flag.key) || !Objects.equals(this.value, flag.value) || this.version != flag.version || !Objects.equals(this.variation, flag.variation) || !Objects.equals(this.reason, flag.reason) || this.trackEvents != flag.trackEvents || this.trackReason != flag.trackReason || !Objects.equals(this.debugEventsUntilDate, flag.debugEventsUntilDate) || this.deleted != flag.deleted) {
                return false;
            }
            return true;
        }

        public static Flag fromJson(String str) throws SerializationException {
            try {
                return (Flag) GsonHelpers.gsonInstance().fromJson(str, Flag.class);
            } catch (Exception e) {
                throw new SerializationException((Throwable) e);
            }
        }

        public String toJson() {
            return GsonHelpers.gsonInstance().toJson((Object) this);
        }
    }
}
