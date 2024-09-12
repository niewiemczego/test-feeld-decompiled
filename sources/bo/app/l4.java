package bo.app;

import com.braze.support.BrazeLogger;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class l4 extends r {
    public static final a x = new a((DefaultConstructorMarker) null);
    private final List t;
    private final boolean u;
    private final boolean v;
    private final w1 w;

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
            return "PushDeliverySendRequest failed.";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ long b;
        final /* synthetic */ l4 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(long j, l4 l4Var) {
            super(0);
            this.b = j;
            this.c = l4Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Scheduling a retry of PushDeliverySendRequest after a delay of " + this.b + " ms. " + this.c;
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "PushDeliverySendRequest executed successfully.";
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced JSONException while creating PushDeliverySendRequest. Returning null.";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l4(l5 l5Var, String str, String str2, List list) {
        super(new b5(str + "push/delivery_events"), str2, l5Var);
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(str, "urlBase");
        Intrinsics.checkNotNullParameter(list, "pushDeliveryEvents");
        this.t = list;
        this.w = new i1(l5Var.j() * 2, 0, l5Var.k(), l5Var.l(), 2, (DefaultConstructorMarker) null);
    }

    public void a(i2 i2Var, i2 i2Var2, d dVar) {
        Intrinsics.checkNotNullParameter(i2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(i2Var2, "externalPublisher");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) d.b, 3, (Object) null);
    }

    public boolean c() {
        return this.u;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040 A[Catch:{ JSONException -> 0x004f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject e() {
        /*
            r6 = this;
            org.json.JSONObject r0 = super.e()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x004f }
            r2.<init>()     // Catch:{ JSONException -> 0x004f }
            java.util.List r3 = r6.t     // Catch:{ JSONException -> 0x004f }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ JSONException -> 0x004f }
        L_0x0013:
            boolean r4 = r3.hasNext()     // Catch:{ JSONException -> 0x004f }
            if (r4 == 0) goto L_0x002e
            java.lang.Object r4 = r3.next()     // Catch:{ JSONException -> 0x004f }
            bo.app.j4 r4 = (bo.app.j4) r4     // Catch:{ JSONException -> 0x004f }
            java.lang.String r5 = r6.a()     // Catch:{ JSONException -> 0x004f }
            r4.a((java.lang.String) r5)     // Catch:{ JSONException -> 0x004f }
            org.json.JSONObject r4 = r4.forJsonPut()     // Catch:{ JSONException -> 0x004f }
            r2.put((java.lang.Object) r4)     // Catch:{ JSONException -> 0x004f }
            goto L_0x0013
        L_0x002e:
            java.lang.String r3 = r6.a()     // Catch:{ JSONException -> 0x004f }
            if (r3 == 0) goto L_0x003d
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)     // Catch:{ JSONException -> 0x004f }
            if (r3 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r3 = 0
            goto L_0x003e
        L_0x003d:
            r3 = 1
        L_0x003e:
            if (r3 != 0) goto L_0x0049
            java.lang.String r3 = "user_id"
            java.lang.String r4 = r6.a()     // Catch:{ JSONException -> 0x004f }
            r0.put((java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x004f }
        L_0x0049:
            java.lang.String r3 = "events"
            r0.put((java.lang.String) r3, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x004f }
            return r0
        L_0x004f:
            r0 = move-exception
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W
            bo.app.l4$e r4 = bo.app.l4.e.b
            r2.brazelog((java.lang.Object) r6, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.l4.e():org.json.JSONObject");
    }

    public boolean h() {
        return this.v;
    }

    public w1 m() {
        return this.w;
    }

    public final List t() {
        return this.t;
    }

    public void a(i2 i2Var, i2 i2Var2, p2 p2Var) {
        Intrinsics.checkNotNullParameter(i2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(i2Var2, "externalPublisher");
        Intrinsics.checkNotNullParameter(p2Var, "responseError");
        super.a(i2Var, i2Var2, p2Var);
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
        if ((p2Var instanceof p3) || (p2Var instanceof e5)) {
            long a2 = (long) m().a();
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new c(a2, this), 2, (Object) null);
            i2Var.a((Object) new d5(a2), d5.class);
        }
    }
}
