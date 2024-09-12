package bo.app;

import com.braze.Braze;
import com.braze.enums.SdkFlavor;
import com.braze.events.BrazeSdkAuthenticationErrorEvent;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public abstract class r extends u4 implements a2 {
    public static final a s = new a((DefaultConstructorMarker) null);
    private String b;
    private final l5 c;
    private Long d;
    private String e;
    private String f;
    private String g;
    private i0 h;
    private String i;
    private String j;
    private SdkFlavor k;
    private z3 l;
    private y3 m;

    /* renamed from: n  reason: collision with root package name */
    private k f19n;
    private String o;
    private EnumSet p;
    private final w1 q;
    private final boolean r;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger dispatch completed. Alerting subscribers.";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error occurred while executing Braze request: " + this.b;
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "******************************************************************";
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "**                        !! WARNING !!                         **";
        }
    }

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "**  The current API key/endpoint combination is invalid. This   **";
        }
    }

    static final class g extends Lambda implements Function0 {
        public static final g b = new g();

        g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "** is potentially an integration error. Please ensure that your **";
        }
    }

    static final class h extends Lambda implements Function0 {
        public static final h b = new h();

        h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "**     API key AND custom endpoint information are correct.     **";
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ r b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(r rVar) {
            super(0);
            this.b = rVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return ">> API key    : " + this.b.n();
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ r b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(r rVar) {
            super(0);
            this.b = rVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return ">> Request Uri: " + this.b.i();
        }
    }

    static final class k extends Lambda implements Function0 {
        public static final k b = new k();

        k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "******************************************************************";
        }
    }

    static final class l extends Lambda implements Function0 {
        public static final l b = new l();

        l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced JSONException while retrieving parameters. Returning null.";
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(b5 b5Var, String str, l5 l5Var, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(b5Var, (i2 & 2) != 0 ? null : str, l5Var);
    }

    public boolean a(p2 p2Var) {
        Intrinsics.checkNotNullParameter(p2Var, "responseError");
        return false;
    }

    public void b(String str) {
        this.g = str;
    }

    public void c(String str) {
        this.e = str;
    }

    public void d(String str) {
        this.i = str;
    }

    public void e(String str) {
        this.o = str;
    }

    public void f(String str) {
        this.j = str;
    }

    public void g(String str) {
        this.f = str;
    }

    public boolean h() {
        return this.r;
    }

    public b5 i() {
        return new b5(Braze.Companion.getApiEndpoint(this.a.a()));
    }

    public EnumSet j() {
        return this.p;
    }

    public Long k() {
        return this.d;
    }

    public String l() {
        return this.o;
    }

    public w1 m() {
        return this.q;
    }

    public String n() {
        return this.f;
    }

    public String o() {
        return this.e;
    }

    public String p() {
        return this.j;
    }

    public String q() {
        return this.i;
    }

    public SdkFlavor r() {
        return this.k;
    }

    public String s() {
        return this.g;
    }

    public String toString() {
        return JsonUtils.getPrettyPrintedString(e()) + "\nto target: " + i();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected r(b5 b5Var, String str, l5 l5Var) {
        super(b5Var);
        Intrinsics.checkNotNullParameter(b5Var, "requestTarget");
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        this.b = str;
        this.c = l5Var;
        this.q = new i1(l5Var.j(), 0, l5Var.k(), l5Var.l(), 2, (DefaultConstructorMarker) null);
    }

    public String a() {
        return this.b;
    }

    public i0 b() {
        return this.h;
    }

    public boolean c() {
        ArrayList<h2> arrayList = new ArrayList<>();
        arrayList.add(b());
        arrayList.add(d());
        arrayList.add(g());
        for (h2 h2Var : arrayList) {
            if (h2Var != null && !h2Var.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public z3 d() {
        return this.l;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062 A[Catch:{ JSONException -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b4 A[Catch:{ JSONException -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c3 A[Catch:{ JSONException -> 0x00cf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject e() {
        /*
            r4 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = r4.o()     // Catch:{ JSONException -> 0x00cf }
            if (r1 == 0) goto L_0x0014
            java.lang.String r1 = "device_id"
            java.lang.String r2 = r4.o()     // Catch:{ JSONException -> 0x00cf }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00cf }
        L_0x0014:
            java.lang.Long r1 = r4.k()     // Catch:{ JSONException -> 0x00cf }
            if (r1 == 0) goto L_0x0023
            java.lang.String r1 = "time"
            java.lang.Long r2 = r4.k()     // Catch:{ JSONException -> 0x00cf }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00cf }
        L_0x0023:
            java.lang.String r1 = r4.n()     // Catch:{ JSONException -> 0x00cf }
            if (r1 == 0) goto L_0x0032
            java.lang.String r1 = "api_key"
            java.lang.String r2 = r4.n()     // Catch:{ JSONException -> 0x00cf }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00cf }
        L_0x0032:
            java.lang.String r1 = r4.s()     // Catch:{ JSONException -> 0x00cf }
            if (r1 == 0) goto L_0x0041
            java.lang.String r1 = "sdk_version"
            java.lang.String r2 = r4.s()     // Catch:{ JSONException -> 0x00cf }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00cf }
        L_0x0041:
            java.lang.String r1 = r4.q()     // Catch:{ JSONException -> 0x00cf }
            if (r1 == 0) goto L_0x0050
            java.lang.String r1 = "app_version"
            java.lang.String r2 = r4.q()     // Catch:{ JSONException -> 0x00cf }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00cf }
        L_0x0050:
            java.lang.String r1 = r4.p()     // Catch:{ JSONException -> 0x00cf }
            if (r1 == 0) goto L_0x005f
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)     // Catch:{ JSONException -> 0x00cf }
            if (r1 == 0) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r1 = 0
            goto L_0x0060
        L_0x005f:
            r1 = 1
        L_0x0060:
            if (r1 != 0) goto L_0x006b
            java.lang.String r1 = "app_version_code"
            java.lang.String r2 = r4.p()     // Catch:{ JSONException -> 0x00cf }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x00cf }
        L_0x006b:
            bo.app.i0 r1 = r4.b()     // Catch:{ JSONException -> 0x00cf }
            if (r1 == 0) goto L_0x0080
            boolean r2 = r1.isEmpty()     // Catch:{ JSONException -> 0x00cf }
            if (r2 != 0) goto L_0x0080
            java.lang.String r2 = "device"
            org.json.JSONObject r1 = r1.forJsonPut()     // Catch:{ JSONException -> 0x00cf }
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x00cf }
        L_0x0080:
            bo.app.z3 r1 = r4.d()     // Catch:{ JSONException -> 0x00cf }
            if (r1 == 0) goto L_0x0095
            boolean r2 = r1.isEmpty()     // Catch:{ JSONException -> 0x00cf }
            if (r2 != 0) goto L_0x0095
            java.lang.String r2 = "attributes"
            org.json.JSONArray r1 = r1.forJsonPut()     // Catch:{ JSONException -> 0x00cf }
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x00cf }
        L_0x0095:
            bo.app.k r1 = r4.g()     // Catch:{ JSONException -> 0x00cf }
            if (r1 == 0) goto L_0x00ae
            boolean r2 = r1.isEmpty()     // Catch:{ JSONException -> 0x00cf }
            if (r2 != 0) goto L_0x00ae
            java.lang.String r2 = "events"
            java.util.Set r1 = r1.b()     // Catch:{ JSONException -> 0x00cf }
            org.json.JSONArray r1 = com.braze.support.JsonUtils.constructJsonArray(r1)     // Catch:{ JSONException -> 0x00cf }
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x00cf }
        L_0x00ae:
            com.braze.enums.SdkFlavor r1 = r4.r()     // Catch:{ JSONException -> 0x00cf }
            if (r1 == 0) goto L_0x00bd
            java.lang.String r2 = "sdk_flavor"
            java.lang.String r1 = r1.forJsonPut()     // Catch:{ JSONException -> 0x00cf }
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x00cf }
        L_0x00bd:
            java.util.EnumSet r1 = r4.j()     // Catch:{ JSONException -> 0x00cf }
            if (r1 == 0) goto L_0x00ce
            java.lang.String r2 = "sdk_metadata"
            com.braze.enums.BrazeSdkMetadata$a r3 = com.braze.enums.BrazeSdkMetadata.Companion     // Catch:{ JSONException -> 0x00cf }
            org.json.JSONArray r1 = r3.a(r1)     // Catch:{ JSONException -> 0x00cf }
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x00cf }
        L_0x00ce:
            return r0
        L_0x00cf:
            r0 = move-exception
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.W
            bo.app.r$l r3 = bo.app.r.l.b
            r1.brazelog((java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r3)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.r.e():org.json.JSONObject");
    }

    public y3 f() {
        return this.m;
    }

    public k g() {
        return this.f19n;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(i2 i2Var) {
        Intrinsics.checkNotNullParameter(i2Var, "internalPublisher");
        y3 f2 = f();
        boolean z = true;
        if (f2 == null || !f2.x()) {
            z = false;
        }
        if (z) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) b.b, 3, (Object) null);
            i2Var.a((Object) new h6(this), h6.class);
        }
        i2Var.a((Object) new v4(this), v4.class);
    }

    public void a(Long l2) {
        this.d = l2;
    }

    public void a(i0 i0Var) {
        this.h = i0Var;
    }

    public void a(SdkFlavor sdkFlavor) {
        this.k = sdkFlavor;
    }

    public void a(z3 z3Var) {
        this.l = z3Var;
    }

    public void a(k kVar) {
        this.f19n = kVar;
    }

    public void a(EnumSet enumSet) {
        this.p = enumSet;
    }

    public void a(i2 i2Var, i2 i2Var2, p2 p2Var) {
        Intrinsics.checkNotNullParameter(i2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(i2Var2, "externalPublisher");
        Intrinsics.checkNotNullParameter(p2Var, "responseError");
        String a2 = p2Var.a();
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.W;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, (Function0) new c(a2), 2, (Object) null);
        if (p2Var instanceof h3) {
            i2Var.a((Object) p2Var, h3.class);
            BrazeLogger brazeLogger2 = brazeLogger;
            BrazeLogger.Priority priority2 = priority;
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority2, (Throwable) null, (Function0) d.b, 2, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority2, (Throwable) null, (Function0) e.b, 2, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority2, (Throwable) null, (Function0) f.b, 2, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority2, (Throwable) null, (Function0) g.b, 2, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority2, (Throwable) null, (Function0) h.b, 2, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority2, (Throwable) null, (Function0) new i(this), 2, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority2, (Throwable) null, (Function0) new j(this), 2, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority2, (Throwable) null, (Function0) k.b, 2, (Object) null);
        }
        if (p2Var instanceof e5) {
            i2Var2.a((Object) new BrazeSdkAuthenticationErrorEvent((e5) p2Var), BrazeSdkAuthenticationErrorEvent.class);
        }
    }

    public void a(i2 i2Var) {
        Intrinsics.checkNotNullParameter(i2Var, "internalPublisher");
        y3 f2 = f();
        boolean z = true;
        if (f2 == null || !f2.x()) {
            z = false;
        }
        if (z) {
            i2Var.a((Object) new i6(this), i6.class);
        }
        i2Var.a((Object) new w4(this), w4.class);
    }

    public void a(Map map) {
        Intrinsics.checkNotNullParameter(map, "existingHeaders");
        map.put("X-Braze-Api-Key", n());
        String l2 = l();
        if (!(l2 == null || l2.length() == 0)) {
            map.put("X-Braze-Auth-Signature", l());
        }
    }
}
