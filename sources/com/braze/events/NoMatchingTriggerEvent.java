package com.braze.events;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/braze/events/NoMatchingTriggerEvent;", "", "sourceEventType", "", "(Ljava/lang/String;)V", "getSourceEventType", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoMatchingTriggerEvent {
    private final String sourceEventType;

    public NoMatchingTriggerEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "sourceEventType");
        this.sourceEventType = str;
    }

    public static /* synthetic */ NoMatchingTriggerEvent copy$default(NoMatchingTriggerEvent noMatchingTriggerEvent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = noMatchingTriggerEvent.sourceEventType;
        }
        return noMatchingTriggerEvent.copy(str);
    }

    public final String component1() {
        return this.sourceEventType;
    }

    public final NoMatchingTriggerEvent copy(String str) {
        Intrinsics.checkNotNullParameter(str, "sourceEventType");
        return new NoMatchingTriggerEvent(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NoMatchingTriggerEvent) && Intrinsics.areEqual((Object) this.sourceEventType, (Object) ((NoMatchingTriggerEvent) obj).sourceEventType);
    }

    public final String getSourceEventType() {
        return this.sourceEventType;
    }

    public int hashCode() {
        return this.sourceEventType.hashCode();
    }

    public String toString() {
        return "NoMatchingTriggerEvent(sourceEventType=" + this.sourceEventType + ')';
    }
}
