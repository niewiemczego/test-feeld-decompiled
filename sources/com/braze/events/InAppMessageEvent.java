package com.braze.events;

import bo.app.u2;
import bo.app.z2;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003J3\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/braze/events/InAppMessageEvent;", "", "", "toString", "Lbo/app/u2;", "component1", "Lbo/app/z2;", "component2", "Lcom/braze/models/inappmessage/IInAppMessage;", "component3", "component4", "triggerEvent", "triggerAction", "inAppMessage", "userId", "copy", "", "hashCode", "other", "", "equals", "Lbo/app/u2;", "getTriggerEvent", "()Lbo/app/u2;", "Lbo/app/z2;", "getTriggerAction", "()Lbo/app/z2;", "Lcom/braze/models/inappmessage/IInAppMessage;", "getInAppMessage", "()Lcom/braze/models/inappmessage/IInAppMessage;", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "<init>", "(Lbo/app/u2;Lbo/app/z2;Lcom/braze/models/inappmessage/IInAppMessage;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public final class InAppMessageEvent {
    private final IInAppMessage inAppMessage;
    private final z2 triggerAction;
    private final u2 triggerEvent;
    private final String userId;

    public InAppMessageEvent(u2 u2Var, z2 z2Var, IInAppMessage iInAppMessage, String str) {
        Intrinsics.checkNotNullParameter(u2Var, "triggerEvent");
        Intrinsics.checkNotNullParameter(z2Var, "triggerAction");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        this.triggerEvent = u2Var;
        this.triggerAction = z2Var;
        this.inAppMessage = iInAppMessage;
        this.userId = str;
    }

    public static /* synthetic */ InAppMessageEvent copy$default(InAppMessageEvent inAppMessageEvent, u2 u2Var, z2 z2Var, IInAppMessage iInAppMessage, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            u2Var = inAppMessageEvent.triggerEvent;
        }
        if ((i & 2) != 0) {
            z2Var = inAppMessageEvent.triggerAction;
        }
        if ((i & 4) != 0) {
            iInAppMessage = inAppMessageEvent.inAppMessage;
        }
        if ((i & 8) != 0) {
            str = inAppMessageEvent.userId;
        }
        return inAppMessageEvent.copy(u2Var, z2Var, iInAppMessage, str);
    }

    public final u2 component1() {
        return this.triggerEvent;
    }

    public final z2 component2() {
        return this.triggerAction;
    }

    public final IInAppMessage component3() {
        return this.inAppMessage;
    }

    public final String component4() {
        return this.userId;
    }

    public final InAppMessageEvent copy(u2 u2Var, z2 z2Var, IInAppMessage iInAppMessage, String str) {
        Intrinsics.checkNotNullParameter(u2Var, "triggerEvent");
        Intrinsics.checkNotNullParameter(z2Var, "triggerAction");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        return new InAppMessageEvent(u2Var, z2Var, iInAppMessage, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InAppMessageEvent)) {
            return false;
        }
        InAppMessageEvent inAppMessageEvent = (InAppMessageEvent) obj;
        return Intrinsics.areEqual((Object) this.triggerEvent, (Object) inAppMessageEvent.triggerEvent) && Intrinsics.areEqual((Object) this.triggerAction, (Object) inAppMessageEvent.triggerAction) && Intrinsics.areEqual((Object) this.inAppMessage, (Object) inAppMessageEvent.inAppMessage) && Intrinsics.areEqual((Object) this.userId, (Object) inAppMessageEvent.userId);
    }

    public final IInAppMessage getInAppMessage() {
        return this.inAppMessage;
    }

    public final z2 getTriggerAction() {
        return this.triggerAction;
    }

    public final u2 getTriggerEvent() {
        return this.triggerEvent;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int hashCode = ((((this.triggerEvent.hashCode() * 31) + this.triggerAction.hashCode()) * 31) + this.inAppMessage.hashCode()) * 31;
        String str = this.userId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return JsonUtils.getPrettyPrintedString((JSONObject) this.inAppMessage.forJsonPut());
    }
}
