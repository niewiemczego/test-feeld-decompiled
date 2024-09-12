package com.braze.models.inappmessage;

import bo.app.j;
import bo.app.x1;
import bo.app.z1;
import com.braze.enums.inappmessage.MessageType;
import com.braze.support.BrazeLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/braze/models/inappmessage/InAppMessageControl;", "Lcom/braze/models/inappmessage/InAppMessageBase;", "", "logImpression", "Ljava/util/concurrent/atomic/AtomicBoolean;", "controlImpressionLogged", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lcom/braze/enums/inappmessage/MessageType;", "getMessageType", "()Lcom/braze/enums/inappmessage/MessageType;", "messageType", "Lorg/json/JSONObject;", "jsonObject", "Lbo/app/z1;", "brazeManager", "<init>", "(Lorg/json/JSONObject;Lbo/app/z1;)V", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public class InAppMessageControl extends InAppMessageBase {
    private final AtomicBoolean controlImpressionLogged = new AtomicBoolean(false);

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Control impression already logged for this in-app message. Ignoring.";
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger Id not found (this is expected for test sends). Not logging in-app message control impression.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot log an in-app message control impression because the BrazeManager is null.";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Logging control in-app message impression event";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InAppMessageControl(JSONObject jSONObject, z1 z1Var) {
        super(jSONObject, z1Var, false, false, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
    }

    public MessageType getMessageType() {
        return MessageType.CONTROL;
    }

    public boolean logImpression() {
        if (this.controlImpressionLogged.get()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) a.b, 2, (Object) null);
            return false;
        }
        String triggerId = getTriggerId();
        if (triggerId == null || triggerId.length() == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
            return false;
        } else if (getBrazeManager() == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) c.b, 2, (Object) null);
            return false;
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) d.b, 2, (Object) null);
            String triggerId2 = getTriggerId();
            x1 h = triggerId2 != null ? j.h.h(triggerId2) : null;
            if (h != null) {
                z1 brazeManager = getBrazeManager();
                if (brazeManager != null) {
                    brazeManager.a(h);
                }
                this.controlImpressionLogged.set(true);
            }
            return true;
        }
    }
}
