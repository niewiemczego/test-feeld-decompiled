package bo.app;

import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.JsonUtils;
import io.sentry.clientreport.DiscardedEvent;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    public static final e l = new e((DefaultConstructorMarker) null);
    private final JSONObject a;
    private final Map b;
    private final z c;
    private final IInAppMessage d;
    private final List e;
    private final j5 f;
    private final List g;
    private final JSONArray h;
    private final String i;
    private final JSONArray j;
    private final p2 k;

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ d b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(d dVar) {
            super(0);
            this.b = dVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Encountered Exception processing Content Cards response: " + this.b.h();
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ d b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar) {
            super(0);
            this.b = dVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Found " + this.b.k().size() + " triggered actions in server response.";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(JSONObject jSONObject) {
            super(0);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Got server config: " + JsonUtils.getPrettyPrintedString(this.b);
        }
    }

    /* renamed from: bo.app.d$d  reason: collision with other inner class name */
    static final class C0005d extends Lambda implements Function0 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0005d(JSONObject jSONObject) {
            super(0);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Encountered Exception processing server config: " + this.b;
        }
    }

    public static final class e {
        public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final p2 a(JSONObject jSONObject, a2 a2Var) {
            Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
            Intrinsics.checkNotNullParameter(a2Var, "request");
            String optionalString = JsonUtils.getOptionalString(jSONObject, "error");
            JSONObject optJSONObject = jSONObject.optJSONObject("auth_error");
            if (optJSONObject != null) {
                return new e5(a2Var, optJSONObject.optInt("error_code", -1), JsonUtils.getOptionalString(optJSONObject, DiscardedEvent.JsonKeys.REASON), optionalString);
            } else if (Intrinsics.areEqual((Object) optionalString, (Object) "invalid_api_key")) {
                return new h3(optionalString, a2Var);
            } else {
                if (optionalString != null) {
                    return new g(optionalString, a2Var);
                }
                return null;
            }
        }

        private e() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0083 A[SYNTHETIC, Splitter:B:14:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(kotlin.Pair r10, bo.app.a2 r11, bo.app.z1 r12) {
        /*
            r9 = this;
            java.lang.String r0 = "responseData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "brazeManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r9.<init>()
            java.lang.Object r0 = r10.getFirst()
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            r9.a = r0
            java.lang.Object r10 = r10.getSecond()
            java.util.Map r10 = (java.util.Map) r10
            r9.b = r10
            java.lang.String r10 = "feature_flags"
            org.json.JSONArray r10 = r0.optJSONArray(r10)
            r9.h = r10
            java.lang.String r10 = "feed"
            org.json.JSONArray r10 = r0.optJSONArray(r10)
            r9.j = r10
            bo.app.d$e r10 = l
            bo.app.p2 r10 = r10.a(r0, r11)
            r9.k = r10
            r1 = 0
            if (r10 != 0) goto L_0x0054
            boolean r10 = r11 instanceof bo.app.b0
            if (r10 == 0) goto L_0x0054
            bo.app.z r10 = new bo.app.z     // Catch:{ Exception -> 0x0047 }
            r10.<init>((org.json.JSONObject) r0)     // Catch:{ Exception -> 0x0047 }
            goto L_0x0055
        L_0x0047:
            r10 = move-exception
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.W
            bo.app.d$a r3 = new bo.app.d$a
            r3.<init>(r9)
            r0.brazelog((java.lang.Object) r9, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r10, (kotlin.jvm.functions.Function0<java.lang.String>) r3)
        L_0x0054:
            r10 = r1
        L_0x0055:
            r9.c = r10
            org.json.JSONObject r10 = r9.a
            java.lang.String r0 = "triggers"
            org.json.JSONArray r10 = r10.optJSONArray(r0)
            bo.app.p6 r0 = bo.app.p6.a
            java.util.List r10 = r0.a((org.json.JSONArray) r10, (bo.app.z1) r12)
            r9.e = r10
            if (r10 == 0) goto L_0x0079
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.V
            bo.app.d$b r6 = new bo.app.d$b
            r6.<init>(r9)
            r5 = 0
            r7 = 2
            r8 = 0
            r3 = r9
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
        L_0x0079:
            org.json.JSONObject r10 = r9.a
            java.lang.String r0 = "config"
            org.json.JSONObject r10 = r10.optJSONObject(r0)
            if (r10 == 0) goto L_0x00ab
            bo.app.j5 r0 = new bo.app.j5     // Catch:{ Exception -> 0x009b }
            r0.<init>(r10)     // Catch:{ Exception -> 0x009b }
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0099 }
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.V     // Catch:{ Exception -> 0x0099 }
            r5 = 0
            bo.app.d$c r6 = new bo.app.d$c     // Catch:{ Exception -> 0x0099 }
            r6.<init>(r10)     // Catch:{ Exception -> 0x0099 }
            r7 = 2
            r8 = 0
            r3 = r9
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)     // Catch:{ Exception -> 0x0099 }
            goto L_0x00ac
        L_0x0099:
            r2 = move-exception
            goto L_0x009e
        L_0x009b:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L_0x009e:
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.W
            bo.app.d$d r5 = new bo.app.d$d
            r5.<init>(r10)
            r3.brazelog((java.lang.Object) r9, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r2, (kotlin.jvm.functions.Function0<java.lang.String>) r5)
            goto L_0x00ac
        L_0x00ab:
            r0 = r1
        L_0x00ac:
            r9.f = r0
            org.json.JSONObject r10 = r9.a
            java.lang.String r0 = "templated_message"
            org.json.JSONObject r10 = r10.optJSONObject(r0)
            bo.app.p6 r0 = bo.app.p6.a
            com.braze.models.inappmessage.IInAppMessage r10 = r0.a((org.json.JSONObject) r10, (bo.app.z1) r12)
            r9.d = r10
            org.json.JSONObject r10 = r9.a
            java.lang.String r12 = "geofences"
            org.json.JSONArray r10 = r10.optJSONArray(r12)
            if (r10 == 0) goto L_0x00cd
            java.util.List r10 = com.braze.support.e.a(r10)
            goto L_0x00ce
        L_0x00cd:
            r10 = r1
        L_0x00ce:
            r9.g = r10
            boolean r10 = r11 instanceof bo.app.r0
            if (r10 == 0) goto L_0x00dc
            org.json.JSONObject r10 = r9.a
            java.lang.String r11 = "mite"
            java.lang.String r1 = com.braze.support.JsonUtils.getOptionalString(r10, r11)
        L_0x00dc:
            r9.i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.d.<init>(kotlin.Pair, bo.app.a2, bo.app.z1):void");
    }

    public final z a() {
        return this.c;
    }

    public final String b() {
        return this.i;
    }

    public final p2 c() {
        return this.k;
    }

    public final JSONArray d() {
        return this.h;
    }

    public final JSONArray e() {
        return this.j;
    }

    public final List f() {
        return this.g;
    }

    public final Map g() {
        return this.b;
    }

    public final JSONObject h() {
        return this.a;
    }

    public final j5 i() {
        return this.f;
    }

    public final IInAppMessage j() {
        return this.d;
    }

    public final List k() {
        return this.e;
    }
}
