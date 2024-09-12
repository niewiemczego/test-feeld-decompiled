package bo.app;

import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

public final class a6 extends r {
    public static final a D = new a((DefaultConstructorMarker) null);
    private y3 A;
    private final w1 B;
    private final boolean C;
    private final b6 t;
    private final u2 u;
    private final String v;
    private final long w;
    private final long x;
    private final long y;
    private final z2 z;

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
            return "Experienced JSONException while retrieving parameters. Returning null.";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ long b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(long j) {
            super(0);
            this.b = j;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Template request has not yet expired. It expires at time: " + this.b + ". Proceeding with retry.";
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ long b;
        final /* synthetic */ a6 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(long j, a6 a6Var) {
            super(0);
            this.b = j;
            this.c = a6Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Template request expired at time: " + this.b + " and is not eligible for a response retry. Not retrying or performing any fallback triggers. " + this.c;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a6(bo.app.l5 r18, java.lang.String r19, bo.app.b6 r20, bo.app.u2 r21, java.lang.String r22) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            java.lang.String r6 = "serverConfigStorageProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r6)
            java.lang.String r6 = "urlBase"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r6)
            java.lang.String r6 = "templatedTriggeredAction"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r6)
            java.lang.String r6 = "triggerEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r6)
            bo.app.b5 r6 = new bo.app.b5
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.StringBuilder r2 = r7.append(r2)
            java.lang.String r7 = "template"
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r2 = r2.toString()
            r6.<init>((java.lang.String) r2)
            r0.<init>(r6, r5, r1)
            r0.t = r3
            r0.u = r4
            java.lang.String r2 = r20.z()
            r0.v = r2
            bo.app.q2 r2 = r20.n()
            long r6 = r0.a((bo.app.q2) r2)
            r0.w = r6
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MINUTES
            r8 = 1
            long r8 = r2.toMillis(r8)
            long r6 = java.lang.Math.min(r6, r8)
            r0.x = r6
            long r8 = r20.A()
            r0.y = r8
            r0.z = r3
            bo.app.y3$a r2 = new bo.app.y3$a
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 15
            r16 = 0
            r10 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16)
            bo.app.y3$a r2 = r2.b(r5)
            bo.app.y3 r2 = r2.a()
            r0.A = r2
            int r11 = r18.k()
            int r9 = (int) r6
            int r12 = r18.l()
            bo.app.i1 r1 = new bo.app.i1
            r10 = 0
            r13 = 2
            r8 = r1
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r0.B = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.a6.<init>(bo.app.l5, java.lang.String, bo.app.b6, bo.app.u2, java.lang.String):void");
    }

    public void a(i2 i2Var, i2 i2Var2, d dVar) {
        Intrinsics.checkNotNullParameter(i2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(i2Var2, "externalPublisher");
        m().b();
        if ((dVar != null ? dVar.j() : null) != null) {
            dVar.j().setLocalPrefetchedAssetPaths(this.t.y());
        }
    }

    public boolean c() {
        return this.C;
    }

    public JSONObject e() {
        JSONObject e = super.e();
        if (e == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(InAppMessageBase.TRIGGER_ID, (Object) this.v);
            jSONObject.put("trigger_event_type", (Object) this.u.d());
            x1 a2 = this.u.a();
            jSONObject.put("data", (Object) a2 != null ? (JSONObject) a2.forJsonPut() : null);
            e.put(SDKConstants.PARAM_UPDATE_TEMPLATE, (Object) jSONObject);
            y3 f = f();
            boolean z2 = true;
            if (f == null || !f.y()) {
                z2 = false;
            }
            if (z2) {
                y3 f2 = f();
                e.put("respond_with", (Object) f2 != null ? f2.forJsonPut() : null);
            }
            return e;
        } catch (JSONException e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) b.b);
            return null;
        }
    }

    public y3 f() {
        return this.A;
    }

    public w1 m() {
        return this.B;
    }

    public final long t() {
        return this.y;
    }

    public final u2 u() {
        return this.u;
    }

    public final z2 v() {
        return this.z;
    }

    public void a(i2 i2Var, i2 i2Var2, p2 p2Var) {
        Intrinsics.checkNotNullParameter(i2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(i2Var2, "externalPublisher");
        Intrinsics.checkNotNullParameter(p2Var, "responseError");
        super.a(i2Var, i2Var2, p2Var);
        if (p2Var instanceof g) {
            i2Var.a((Object) new s6(this.u, this.t), s6.class);
        }
    }

    public boolean a(p2 p2Var) {
        Intrinsics.checkNotNullParameter(p2Var, "responseError");
        if (!(p2Var instanceof p3) && !(p2Var instanceof e5)) {
            return false;
        }
        long e = this.u.e() + this.w;
        if (DateTimeUtils.nowInMilliseconds() < e) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new c(e), 2, (Object) null);
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new d(e, this), 3, (Object) null);
        return false;
    }

    private final long a(q2 q2Var) {
        if (q2Var.k() == -1) {
            return TimeUnit.SECONDS.toMillis((long) (q2Var.o() + 30));
        }
        return (long) q2Var.k();
    }
}
