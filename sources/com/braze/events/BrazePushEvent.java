package com.braze.events;

import com.braze.enums.BrazePushEventType;
import com.braze.models.push.BrazeNotificationPayload;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/braze/events/BrazePushEvent;", "", "eventType", "Lcom/braze/enums/BrazePushEventType;", "notificationPayload", "Lcom/braze/models/push/BrazeNotificationPayload;", "(Lcom/braze/enums/BrazePushEventType;Lcom/braze/models/push/BrazeNotificationPayload;)V", "getEventType", "()Lcom/braze/enums/BrazePushEventType;", "getNotificationPayload", "()Lcom/braze/models/push/BrazeNotificationPayload;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BrazePushEvent {
    private final BrazePushEventType eventType;
    private final BrazeNotificationPayload notificationPayload;

    public BrazePushEvent(BrazePushEventType brazePushEventType, BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(brazePushEventType, "eventType");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "notificationPayload");
        this.eventType = brazePushEventType;
        this.notificationPayload = brazeNotificationPayload;
    }

    public static /* synthetic */ BrazePushEvent copy$default(BrazePushEvent brazePushEvent, BrazePushEventType brazePushEventType, BrazeNotificationPayload brazeNotificationPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            brazePushEventType = brazePushEvent.eventType;
        }
        if ((i & 2) != 0) {
            brazeNotificationPayload = brazePushEvent.notificationPayload;
        }
        return brazePushEvent.copy(brazePushEventType, brazeNotificationPayload);
    }

    public final BrazePushEventType component1() {
        return this.eventType;
    }

    public final BrazeNotificationPayload component2() {
        return this.notificationPayload;
    }

    public final BrazePushEvent copy(BrazePushEventType brazePushEventType, BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(brazePushEventType, "eventType");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "notificationPayload");
        return new BrazePushEvent(brazePushEventType, brazeNotificationPayload);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrazePushEvent)) {
            return false;
        }
        BrazePushEvent brazePushEvent = (BrazePushEvent) obj;
        return this.eventType == brazePushEvent.eventType && Intrinsics.areEqual((Object) this.notificationPayload, (Object) brazePushEvent.notificationPayload);
    }

    public final BrazePushEventType getEventType() {
        return this.eventType;
    }

    public final BrazeNotificationPayload getNotificationPayload() {
        return this.notificationPayload;
    }

    public int hashCode() {
        return (this.eventType.hashCode() * 31) + this.notificationPayload.hashCode();
    }

    public String toString() {
        return "BrazePushEvent(eventType=" + this.eventType + ", notificationPayload=" + this.notificationPayload + ')';
    }
}
