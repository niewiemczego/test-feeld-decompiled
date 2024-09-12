package bo.app;

import android.content.Context;
import com.braze.enums.inappmessage.MessageType;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

public final class f3 extends t6 {
    public static final c l = new c((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final IInAppMessage i;
    private final JSONObject j;
    private final z1 k;

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(JSONObject jSONObject) {
            super(0);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Attempting to parse in-app message triggered action with JSON: " + JsonUtils.getPrettyPrintedString(this.b);
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to parse in-app message triggered action.";
        }
    }

    public static final class c {
        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private c() {
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.braze.enums.inappmessage.MessageType[] r0 = com.braze.enums.inappmessage.MessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.HTML_FULL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.FULL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.MODAL     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.SLIDEUP     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.HTML     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.f3.d.<clinit>():void");
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ f3 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(f3 f3Var) {
            super(0);
            this.b = f3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Attempting to publish in-app message after delay of " + this.b.n().o() + " seconds.";
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ u2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(u2 u2Var) {
            super(0);
            this.b = u2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot perform triggered action for " + this.b + " due to in-app message json being null";
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ u2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(u2 u2Var) {
            super(0);
            this.b = u2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot perform triggered action for " + this.b + " due to deserialized in-app message being null";
        }
    }

    static final class h extends Lambda implements Function0 {
        public static final h b = new h();

        h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception while performing triggered action.";
        }
    }

    static final class i extends Lambda implements Function0 {
        public static final i b = new i();

        i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "In-app message has no remote assets for prefetch. Returning empty list.";
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ f3 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(f3 f3Var) {
            super(0);
            this.b = f3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            StringBuilder append = new StringBuilder().append("Failed to return remote paths to assets for type: ");
            IInAppMessage a = this.b.i;
            return append.append(a != null ? a.getMessageType() : null).toString();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f3(JSONObject jSONObject, z1 z1Var) {
        super(jSONObject);
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new a(jSONObject), 2, (Object) null);
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        this.k = z1Var;
        this.j = jSONObject2;
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "inAppMessageObject");
        IInAppMessage a2 = com.braze.support.h.a(jSONObject2, z1Var);
        this.i = a2;
        if (a2 == null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
            throw new IllegalArgumentException("Failed to parse in-app message triggered action with JSON: " + JsonUtils.getPrettyPrintedString(jSONObject));
        }
    }

    public List l() {
        ArrayList arrayList = new ArrayList();
        IInAppMessage iInAppMessage = this.i;
        MessageType messageType = null;
        List<String> remoteAssetPathsForPrefetch = iInAppMessage != null ? iInAppMessage.getRemoteAssetPathsForPrefetch() : null;
        if (remoteAssetPathsForPrefetch == null || remoteAssetPathsForPrefetch.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) i.b, 3, (Object) null);
            return arrayList;
        }
        IInAppMessage iInAppMessage2 = this.i;
        if (iInAppMessage2 != null) {
            messageType = iInAppMessage2.getMessageType();
        }
        int i2 = messageType == null ? -1 : d.a[messageType.ordinal()];
        if (i2 == 1) {
            arrayList.add(new s4(t4.ZIP, remoteAssetPathsForPrefetch.get(0)));
        } else if (i2 == 2 || i2 == 3 || i2 == 4) {
            arrayList.add(new s4(t4.IMAGE, remoteAssetPathsForPrefetch.get(0)));
        } else if (i2 != 5) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new j(this), 2, (Object) null);
        } else {
            for (String s4Var : remoteAssetPathsForPrefetch) {
                arrayList.add(new s4(t4.FILE, s4Var));
            }
        }
        return arrayList;
    }

    /* renamed from: u */
    public JSONObject forJsonPut() {
        try {
            JSONObject u = super.u();
            if (u == null) {
                return null;
            }
            IInAppMessage iInAppMessage = this.i;
            u.put("data", (Object) iInAppMessage != null ? (JSONObject) iInAppMessage.forJsonPut() : null);
            u.put("type", (Object) "inapp");
            return u;
        } catch (JSONException unused) {
            return null;
        }
    }

    public void a(Context context, i2 i2Var, u2 u2Var, long j2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(i2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(u2Var, "triggerEvent");
        try {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new e(this), 3, (Object) null);
            JSONObject jSONObject = this.j;
            if (jSONObject == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new f(u2Var), 2, (Object) null);
                return;
            }
            IInAppMessage a2 = com.braze.support.h.a(jSONObject, this.k);
            if (a2 == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new g(u2Var), 2, (Object) null);
                return;
            }
            a2.setLocalPrefetchedAssetPaths(y());
            a2.setExpirationTimestamp(j2);
            i2Var.a((Object) new d3(u2Var, this, a2, this.k.a()), d3.class);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) h.b);
        }
    }
}
