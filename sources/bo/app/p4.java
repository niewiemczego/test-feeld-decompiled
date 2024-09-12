package bo.app;

import com.braze.support.BrazeLogger;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

public final class p4 extends r {
    public static final a y = new a((DefaultConstructorMarker) null);
    private final List t;
    private final long u;
    private final List v;
    private final boolean w;
    private final boolean x;

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
            return "PushMaxSendRequest failed.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "PushMaxSendRequest executed successfully.";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced JSONException while creating PushMaxSendRequest. Returning null.";
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ p4 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(p4 p4Var) {
            super(0);
            this.b = p4Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Retrying PushMaxSendRequest " + this.b + '.';
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p4(l5 l5Var, String str, String str2, List list, long j, List list2) {
        super(new b5(str + "push/redeliver"), str2, l5Var);
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(str, "urlBase");
        Intrinsics.checkNotNullParameter(list, "campaignIds");
        Intrinsics.checkNotNullParameter(list2, "dedupeIds");
        this.t = list;
        this.u = j;
        this.v = list2;
    }

    public void a(i2 i2Var, i2 i2Var2, d dVar) {
        JSONObject h;
        Intrinsics.checkNotNullParameter(i2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(i2Var2, "externalPublisher");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) c.b, 3, (Object) null);
        if (dVar != null && (h = dVar.h()) != null) {
            i2Var.a((Object) new o4(h.getLong("last_sync_at")), o4.class);
        }
    }

    public boolean c() {
        return this.w;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001b A[Catch:{ JSONException -> 0x004d }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040 A[Catch:{ JSONException -> 0x004d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject e() {
        /*
            r6 = this;
            org.json.JSONObject r0 = super.e()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String r2 = r6.a()     // Catch:{ JSONException -> 0x004d }
            r3 = 1
            if (r2 == 0) goto L_0x0018
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)     // Catch:{ JSONException -> 0x004d }
            if (r2 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r2 = 0
            goto L_0x0019
        L_0x0018:
            r2 = r3
        L_0x0019:
            if (r2 != 0) goto L_0x0024
            java.lang.String r2 = "user_id"
            java.lang.String r4 = r6.a()     // Catch:{ JSONException -> 0x004d }
            r0.put((java.lang.String) r2, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x004d }
        L_0x0024:
            java.lang.String r2 = "campaign_ids"
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x004d }
            java.util.List r5 = r6.t     // Catch:{ JSONException -> 0x004d }
            r4.<init>((java.util.Collection<?>) r5)     // Catch:{ JSONException -> 0x004d }
            r0.put((java.lang.String) r2, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x004d }
            java.lang.String r2 = "last_sync_at"
            long r4 = r6.u     // Catch:{ JSONException -> 0x004d }
            r0.put((java.lang.String) r2, (long) r4)     // Catch:{ JSONException -> 0x004d }
            java.util.List r2 = r6.v     // Catch:{ JSONException -> 0x004d }
            boolean r2 = r2.isEmpty()     // Catch:{ JSONException -> 0x004d }
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x004c
            java.lang.String r2 = "dedupe_ids"
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x004d }
            java.util.List r4 = r6.v     // Catch:{ JSONException -> 0x004d }
            r3.<init>((java.util.Collection<?>) r4)     // Catch:{ JSONException -> 0x004d }
            r0.put((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x004d }
        L_0x004c:
            return r0
        L_0x004d:
            r0 = move-exception
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W
            bo.app.p4$d r4 = bo.app.p4.d.b
            r2.brazelog((java.lang.Object) r6, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.p4.e():org.json.JSONObject");
    }

    public boolean h() {
        return this.x;
    }

    public void a(i2 i2Var, i2 i2Var2, p2 p2Var) {
        Intrinsics.checkNotNullParameter(i2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(i2Var2, "externalPublisher");
        Intrinsics.checkNotNullParameter(p2Var, "responseError");
        super.a(i2Var, i2Var2, p2Var);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
    }

    public boolean a(p2 p2Var) {
        Intrinsics.checkNotNullParameter(p2Var, "responseError");
        if (!(p2Var instanceof p3) && !(p2Var instanceof e5)) {
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new e(this), 2, (Object) null);
        return true;
    }
}
