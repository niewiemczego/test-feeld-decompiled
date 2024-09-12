package bo.app;

import com.braze.support.BrazeLogger;
import com.facebook.internal.ServerProtocol;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class n1 extends r {
    public static final a u = new a((DefaultConstructorMarker) null);
    private final boolean t;

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
            return "FeatureFlagsSyncRequest failed.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "FeatureFlagsSyncRequest executed successfully.";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced JSONException while creating Feature Flags request. Returning null.";
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ n1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(n1 n1Var) {
            super(0);
            this.b = n1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Retrying FeatureFlagsSyncRequest " + this.b + '.';
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n1(l5 l5Var, String str, String str2) {
        super(new b5(str + "feature_flags/sync"), str2, l5Var);
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(str, "urlBase");
    }

    public void a(i2 i2Var, i2 i2Var2, d dVar) {
        Intrinsics.checkNotNullParameter(i2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(i2Var2, "externalPublisher");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) c.b, 3, (Object) null);
        i2Var.a((Object) new m1(this), m1.class);
    }

    public boolean c() {
        return this.t;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001a A[Catch:{ JSONException -> 0x0024 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject e() {
        /*
            r5 = this;
            org.json.JSONObject r0 = super.e()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String r2 = r5.a()     // Catch:{ JSONException -> 0x0024 }
            if (r2 == 0) goto L_0x0017
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)     // Catch:{ JSONException -> 0x0024 }
            if (r2 == 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r2 = 0
            goto L_0x0018
        L_0x0017:
            r2 = 1
        L_0x0018:
            if (r2 != 0) goto L_0x0023
            java.lang.String r2 = "user_id"
            java.lang.String r3 = r5.a()     // Catch:{ JSONException -> 0x0024 }
            r0.put((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x0024 }
        L_0x0023:
            return r0
        L_0x0024:
            r0 = move-exception
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W
            bo.app.n1$d r4 = bo.app.n1.d.b
            r2.brazelog((java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.n1.e():org.json.JSONObject");
    }

    public void a(i2 i2Var, i2 i2Var2, p2 p2Var) {
        Intrinsics.checkNotNullParameter(i2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(i2Var2, "externalPublisher");
        Intrinsics.checkNotNullParameter(p2Var, "responseError");
        super.a(i2Var, i2Var2, p2Var);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
        i2Var.a((Object) new l1(), l1.class);
    }

    public boolean a(p2 p2Var) {
        Intrinsics.checkNotNullParameter(p2Var, "responseError");
        if (!(p2Var instanceof p3) && !(p2Var instanceof e5)) {
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new e(this), 2, (Object) null);
        return true;
    }

    public void a(Map map) {
        Intrinsics.checkNotNullParameter(map, "existingHeaders");
        super.a(map);
        map.put("X-Braze-DataRequest", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        map.put("X-Braze-FeatureFlagsRequest", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
    }
}
