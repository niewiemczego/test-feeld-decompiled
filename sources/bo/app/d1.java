package bo.app;

import android.content.Context;
import bo.app.y3;
import com.braze.Braze;
import com.braze.BrazeInternal;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.events.FeatureFlagsUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.events.InAppMessageEvent;
import com.braze.managers.BrazeGeofenceManager;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import java.util.EnumSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;

public final class d1 {
    private final Context a;
    private final k2 b;
    private final f2 c;
    public final z1 d;
    private final w6 e;
    private final j0 f;
    private final v2 g;
    private final y2 h;
    private final g1 i;
    private final BrazeGeofenceManager j;
    private final i2 k;
    private final BrazeConfigurationProvider l;
    /* access modifiers changed from: private */
    public final a0 m;

    /* renamed from: n  reason: collision with root package name */
    private final h5 f11n;
    private l5 o;
    private final j1 p;
    private final k4 q;
    public final AtomicBoolean r = new AtomicBoolean(false);
    private final AtomicBoolean s = new AtomicBoolean(false);
    private j6 t;
    private Job u;
    private final AtomicBoolean v = new AtomicBoolean(false);
    private final AtomicBoolean w = new AtomicBoolean(false);
    private final AtomicBoolean x = new AtomicBoolean(false);
    private final AtomicBoolean y = new AtomicBoolean(false);
    private final AtomicBoolean z = new AtomicBoolean(false);

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to request a content card refresh.";
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log error.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Requesting Content Card refresh on session created event due to configuration.";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Content Cards already initialized. Not retrieving.";
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Starting DUST subscription due to configuration.";
        }
    }

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "DUST initial subscription already started. Not starting again.";
        }
    }

    static final class g extends Lambda implements Function0 {
        public static final g b = new g();

        g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Requesting Feature Flags refresh on session created event due to configuration.";
        }
    }

    static final class h extends Lambda implements Function0 {
        public static final h b = new h();

        h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Feature Flags already initialized. Not retrieving.";
        }
    }

    static final class i extends Lambda implements Function0 {
        public static final i b = new i();

        i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Requesting Push Max request on session created event due to configuration.";
        }
    }

    static final class j extends Lambda implements Function0 {
        public static final j b = new j();

        j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Push Max already requested for this session. Not requesting again.";
        }
    }

    static final class k extends Lambda implements Function0 {
        final /* synthetic */ z2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(z2 z2Var) {
            super(0);
            this.b = z2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not publish in-app message with trigger action id: " + this.b.getId();
        }
    }

    static final class l extends Lambda implements Function0 {
        public static final l b = new l();

        l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Performing push delivery event flush";
        }
    }

    static final class m extends Lambda implements Function0 {
        public static final m b = new m();

        m() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Requesting feed refresh in next sync";
        }
    }

    static final class n extends Lambda implements Function0 {
        public static final n b = new n();

        n() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Requesting trigger refresh in next sync";
        }
    }

    static final class o extends Lambda implements Function0 {
        final /* synthetic */ long b;
        final /* synthetic */ int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(long j, int i) {
            super(0);
            this.b = j;
            this.c = i;
        }

        /* renamed from: a */
        public final String invoke() {
            return "ContentCardRetryEvent received. timeInMS: " + this.b + ", retryCount: " + this.c;
        }
    }

    static final class p extends SuspendLambda implements Function1 {
        int b;
        final /* synthetic */ d1 c;
        final /* synthetic */ int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(d1 d1Var, int i, Continuation continuation) {
            super(1, continuation);
            this.c = d1Var;
            this.d = i;
        }

        /* renamed from: a */
        public final Object invoke(Continuation continuation) {
            return ((p) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Continuation continuation) {
            return new p(this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                d1 d1Var = this.c;
                z1.a(d1Var.d, d1Var.m.e(), this.c.m.f(), this.d, false, 8, (Object) null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class q extends Lambda implements Function0 {
        public static final q b = new q();

        q() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Session created event for new session received.";
        }
    }

    static final class r extends Lambda implements Function0 {
        public static final r b = new r();

        r() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Requesting Braze Geofence refresh on session created event due to configuration.";
        }
    }

    static final class s extends Lambda implements Function0 {
        public static final s b = new s();

        s() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not automatically requesting Braze Geofence refresh on session created event due to configuration.";
        }
    }

    static final class t extends Lambda implements Function0 {
        public static final t b = new t();

        t() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Session start event for new session received.";
        }
    }

    static final class u extends Lambda implements Function0 {
        public static final u b = new u();

        u() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not automatically requesting Content Card refresh on session created event due to server configuration.";
        }
    }

    static final class v extends Lambda implements Function0 {
        public static final v b = new v();

        v() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not automatically requesting Feature Flags refresh on session created event due to server configuration.";
        }
    }

    static final class w extends Lambda implements Function0 {
        public static final w b = new w();

        w() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not automatically requesting Push Max on session created event due to server configuration.";
        }
    }

    static final class x extends Lambda implements Function0 {
        public static final x b = new x();

        x() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not automatically starting DUST subscription on session created event due to server configuration.";
        }
    }

    static final class y extends Lambda implements Function0 {
        public static final y b = new y();

        y() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log the storage exception.";
        }
    }

    static final class z extends Lambda implements Function0 {
        public static final z b = new z();

        z() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Requesting trigger update due to trigger-eligible push click event";
        }
    }

    public d1(Context context, k2 k2Var, f2 f2Var, z1 z1Var, w6 w6Var, j0 j0Var, v2 v2Var, y2 y2Var, g1 g1Var, BrazeGeofenceManager brazeGeofenceManager, i2 i2Var, BrazeConfigurationProvider brazeConfigurationProvider, a0 a0Var, h5 h5Var, l5 l5Var, j1 j1Var, k4 k4Var) {
        Context context2 = context;
        k2 k2Var2 = k2Var;
        f2 f2Var2 = f2Var;
        z1 z1Var2 = z1Var;
        w6 w6Var2 = w6Var;
        j0 j0Var2 = j0Var;
        v2 v2Var2 = v2Var;
        y2 y2Var2 = y2Var;
        g1 g1Var2 = g1Var;
        BrazeGeofenceManager brazeGeofenceManager2 = brazeGeofenceManager;
        i2 i2Var2 = i2Var;
        BrazeConfigurationProvider brazeConfigurationProvider2 = brazeConfigurationProvider;
        a0 a0Var2 = a0Var;
        h5 h5Var2 = h5Var;
        j1 j1Var2 = j1Var;
        Intrinsics.checkNotNullParameter(context2, "applicationContext");
        Intrinsics.checkNotNullParameter(k2Var2, "locationManager");
        Intrinsics.checkNotNullParameter(f2Var2, "dispatchManager");
        Intrinsics.checkNotNullParameter(z1Var2, "brazeManager");
        Intrinsics.checkNotNullParameter(w6Var2, "userCache");
        Intrinsics.checkNotNullParameter(j0Var2, "deviceCache");
        Intrinsics.checkNotNullParameter(v2Var2, "triggerManager");
        Intrinsics.checkNotNullParameter(y2Var2, "triggerReEligibilityManager");
        Intrinsics.checkNotNullParameter(g1Var2, "eventStorageManager");
        Intrinsics.checkNotNullParameter(brazeGeofenceManager2, "geofenceManager");
        Intrinsics.checkNotNullParameter(i2Var2, "externalEventPublisher");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider2, "configurationProvider");
        Intrinsics.checkNotNullParameter(a0Var2, "contentCardsStorageProvider");
        Intrinsics.checkNotNullParameter(h5Var2, "sdkMetadataCache");
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(j1Var, "featureFlagsManager");
        Intrinsics.checkNotNullParameter(k4Var, "pushDeliveryManager");
        this.a = context2;
        this.b = k2Var2;
        this.c = f2Var2;
        this.d = z1Var2;
        this.e = w6Var2;
        this.f = j0Var2;
        this.g = v2Var2;
        this.h = y2Var2;
        this.i = g1Var2;
        this.j = brazeGeofenceManager2;
        this.k = i2Var2;
        this.l = brazeConfigurationProvider2;
        this.m = a0Var2;
        this.f11n = h5Var2;
        this.o = l5Var;
        this.p = j1Var;
        this.q = k4Var;
    }

    private final IEventSubscriber b() {
        return new d1$$ExternalSyntheticLambda2(this);
    }

    private final IEventSubscriber h() {
        return new d1$$ExternalSyntheticLambda15(this);
    }

    private final IEventSubscriber i() {
        return new d1$$ExternalSyntheticLambda10(this);
    }

    private final IEventSubscriber n() {
        return new d1$$ExternalSyntheticLambda4(this);
    }

    private final IEventSubscriber p() {
        return new d1$$ExternalSyntheticLambda13(this);
    }

    private final IEventSubscriber q() {
        return new d1$$ExternalSyntheticLambda18(this);
    }

    private final void s() {
        if (this.w.compareAndSet(false, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) c.b, 3, (Object) null);
            z1.a(this.d, this.m.e(), this.m.f(), 0, false, 12, (Object) null);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) d.b, 3, (Object) null);
    }

    private final void t() {
        if (this.z.compareAndSet(false, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) e.b, 3, (Object) null);
            this.d.d();
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) f.b, 3, (Object) null);
    }

    private final void u() {
        if (this.x.compareAndSet(false, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) g.b, 3, (Object) null);
            this.p.a();
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) h.b, 3, (Object) null);
    }

    private final void v() {
        if (this.y.compareAndSet(false, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) i.b, 3, (Object) null);
            this.d.h();
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) j.b, 3, (Object) null);
    }

    private final void w() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) l.b, 3, (Object) null);
        z1.a(this.d, 0, 1, (Object) null);
    }

    public final IEventSubscriber c() {
        return new d1$$ExternalSyntheticLambda8(this);
    }

    public final IEventSubscriber d() {
        return new d1$$ExternalSyntheticLambda16(this);
    }

    public final IEventSubscriber e() {
        return new d1$$ExternalSyntheticLambda17(this);
    }

    public final IEventSubscriber f() {
        return new d1$$ExternalSyntheticLambda5(this);
    }

    public final IEventSubscriber g() {
        return new d1$$ExternalSyntheticLambda12(this);
    }

    public final IEventSubscriber j() {
        return new d1$$ExternalSyntheticLambda0(this);
    }

    public final IEventSubscriber k() {
        return new d1$$ExternalSyntheticLambda6(this);
    }

    public final IEventSubscriber l() {
        return new d1$$ExternalSyntheticLambda9(this);
    }

    public final IEventSubscriber m() {
        return new d1$$ExternalSyntheticLambda14(this);
    }

    public final IEventSubscriber o() {
        return new d1$$ExternalSyntheticLambda11(this);
    }

    public final IEventSubscriber r() {
        return new d1$$ExternalSyntheticLambda1(this);
    }

    public final void x() {
        j6 j6Var;
        if (this.s.compareAndSet(true, false) && (j6Var = this.t) != null) {
            this.g.a((u2) new h4(j6Var.a(), j6Var.b()));
            this.t = null;
        }
    }

    public final void y() {
        if (this.r.compareAndSet(true, false)) {
            this.g.a((u2) new v3());
        }
    }

    public final void z() {
        y3.a aVar = new y3.a((String) null, (Boolean) null, (Boolean) null, (x3) null, 15, (DefaultConstructorMarker) null);
        if (this.d.c()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) m.b, 3, (Object) null);
            aVar.d();
            this.d.a(false);
        }
        if (this.d.b()) {
            this.r.set(true);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) n.b, 3, (Object) null);
            aVar.e();
            this.d.b(false);
        }
        Boolean c2 = aVar.c();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual((Object) c2, (Object) bool) || Intrinsics.areEqual((Object) aVar.b(), (Object) bool)) {
            this.d.a(aVar);
        }
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, q0 q0Var) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(q0Var, "<name for destructuring parameter 0>");
        a2 a2 = q0Var.a();
        i0 b2 = a2.b();
        boolean z2 = true;
        if (b2 != null) {
            d1Var.f.a(b2, true);
        }
        z3 d2 = a2.d();
        if (d2 != null) {
            d1Var.e.a(d2, true);
        }
        k g2 = a2.g();
        if (g2 != null) {
            d1Var.i.a(g2.b());
        }
        y3 f2 = a2.f();
        if (f2 != null && f2.x()) {
            d1Var.d.b(false);
        }
        EnumSet j2 = a2.j();
        if (j2 != null) {
            d1Var.f11n.a(j2);
        }
        y3 f3 = a2.f();
        if (f3 == null || !f3.v()) {
            z2 = false;
        }
        if (z2) {
            d1Var.o.G();
        }
        if (a2 instanceof l4) {
            d1Var.q.a(((l4) a2).t());
        }
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, o0 o0Var) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(o0Var, "<name for destructuring parameter 0>");
        a2 a2 = o0Var.a();
        y3 f2 = a2.f();
        boolean z2 = false;
        if (f2 != null && f2.x()) {
            d1Var.y();
            d1Var.x();
            d1Var.d.b(true);
        }
        i0 b2 = a2.b();
        if (b2 != null) {
            d1Var.f.a(b2, false);
        }
        z3 d2 = a2.d();
        if (d2 != null) {
            d1Var.e.a(d2, false);
            if (d2.v().has("push_token")) {
                d1Var.e.g();
                d1Var.f.e();
            }
        }
        k g2 = a2.g();
        if (g2 != null) {
            for (x1 a3 : g2.b()) {
                d1Var.c.a(a3);
            }
        }
        y3 f3 = a2.f();
        if (f3 != null && f3.v()) {
            z2 = true;
        }
        if (z2) {
            d1Var.o.G();
        }
        if (a2 instanceof l4) {
            d1Var.q.b(((l4) a2).t());
        }
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, o5 o5Var) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(o5Var, "it");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) d1Var, (BrazeLogger.Priority) null, (Throwable) null, (Function0) q.b, 3, (Object) null);
        d1Var.b.a();
        x1 a2 = j.h.a(o5Var.a().s());
        if (a2 != null) {
            a2.a(o5Var.a().s());
        }
        if (a2 != null) {
            d1Var.d.a(a2);
        }
        d1Var.d.b(true);
        d1Var.d.a(true);
        d1Var.e.g();
        d1Var.f.e();
        d1Var.w();
        if (d1Var.l.isAutomaticGeofenceRequestsEnabled()) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) d1Var, (BrazeLogger.Priority) null, (Throwable) null, (Function0) r.b, 3, (Object) null);
            BrazeInternal.requestGeofenceRefresh(d1Var.a, false);
        } else {
            BrazeLogger.brazelog$default(brazeLogger, (Object) d1Var, (BrazeLogger.Priority) null, (Throwable) null, (Function0) s.b, 3, (Object) null);
        }
        d1Var.p.i();
        d1Var.z();
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, r5 r5Var) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(r5Var, "it");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) d1Var, (BrazeLogger.Priority) null, (Throwable) null, (Function0) t.b, 3, (Object) null);
        d1Var.v.set(true);
        if (d1Var.o.x()) {
            d1Var.s();
        } else {
            BrazeLogger.brazelog$default(brazeLogger, (Object) d1Var, (BrazeLogger.Priority) null, (Throwable) null, (Function0) u.b, 3, (Object) null);
        }
        if (d1Var.o.A()) {
            d1Var.u();
        } else {
            BrazeLogger.brazelog$default(brazeLogger, (Object) d1Var, (BrazeLogger.Priority) null, (Throwable) null, (Function0) v.b, 3, (Object) null);
        }
        if (d1Var.o.E()) {
            d1Var.v();
        } else {
            BrazeLogger.brazelog$default(brazeLogger, (Object) d1Var, (BrazeLogger.Priority) null, (Throwable) null, (Function0) w.b, 3, (Object) null);
        }
        if (d1Var.o.y()) {
            d1Var.t();
            return;
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) d1Var, (BrazeLogger.Priority) null, (Throwable) null, (Function0) x.b, 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, m3 m3Var) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(m3Var, "it");
        d1Var.d.b(true);
        d1Var.z();
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, q5 q5Var) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(q5Var, "message");
        d1Var.a(q5Var);
        Braze.Companion.getInstance(d1Var.a).requestImmediateDataFlush();
        d1Var.w();
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, k5 k5Var) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(k5Var, "<name for destructuring parameter 0>");
        j5 a2 = k5Var.a();
        d1Var.j.configureFromServerConfig(a2);
        if (d1Var.v.get()) {
            if (a2.z()) {
                d1Var.s();
            }
            if (a2.l()) {
                d1Var.u();
            }
            if (a2.w()) {
                d1Var.v();
            }
            if (a2.A()) {
                d1Var.t();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, t1 t1Var) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(t1Var, "<name for destructuring parameter 0>");
        d1Var.j.registerGeofences(t1Var.a());
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, k1 k1Var) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(k1Var, "<name for destructuring parameter 0>");
        d1Var.k.a((Object) d1Var.p.a(k1Var.a()), FeatureFlagsUpdatedEvent.class);
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, j6 j6Var) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(j6Var, "message");
        d1Var.s.set(true);
        d1Var.t = j6Var;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) d1Var, BrazeLogger.Priority.I, (Throwable) null, (Function0) z.b, 2, (Object) null);
        d1Var.d.a(new y3.a((String) null, (Boolean) null, (Boolean) null, (x3) null, 15, (DefaultConstructorMarker) null).e());
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, u6 u6Var) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(u6Var, "<name for destructuring parameter 0>");
        d1Var.g.a(u6Var.a());
        d1Var.y();
        d1Var.x();
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, l6 l6Var) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(l6Var, "<name for destructuring parameter 0>");
        d1Var.g.a(l6Var.a());
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, d3 d3Var) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(d3Var, "<name for destructuring parameter 0>");
        u2 a2 = d3Var.a();
        z2 b2 = d3Var.b();
        IInAppMessage c2 = d3Var.c();
        String d2 = d3Var.d();
        synchronized (d1Var.h) {
            if (d1Var.h.b(b2)) {
                d1Var.k.a((Object) new InAppMessageEvent(a2, b2, c2, d2), InAppMessageEvent.class);
                d1Var.h.a(b2, DateTimeUtils.nowInSeconds());
                d1Var.g.a(DateTimeUtils.nowInSeconds());
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) d1Var, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new k(b2), 3, (Object) null);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, s6 s6Var) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(s6Var, "<name for destructuring parameter 0>");
        d1Var.g.a(s6Var.a(), s6Var.b());
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, x xVar) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(xVar, "<name for destructuring parameter 0>");
        long a2 = xVar.a();
        int b2 = xVar.b();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) d1Var, BrazeLogger.Priority.V, (Throwable) null, (Function0) new o(a2, b2), 2, (Object) null);
        Job job = d1Var.u;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        d1Var.u = BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, Long.valueOf(a2), (CoroutineContext) null, new p(d1Var, b2, (Continuation) null), 2, (Object) null);
    }

    private final IEventSubscriber a() {
        return new d1$$ExternalSyntheticLambda3(this);
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, w wVar) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(wVar, "it");
        Job job = d1Var.u;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        d1Var.u = null;
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, w5 w5Var) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(w5Var, "storageException");
        try {
            d1Var.d.b((Throwable) w5Var);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) d1Var, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) y.b);
        }
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, v vVar) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        Intrinsics.checkNotNullParameter(vVar, "it");
        try {
            z1.a(d1Var.d, d1Var.m.e(), d1Var.m.f(), 0, false, 4, (Object) null);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) d1Var, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) a.b);
        }
    }

    public final void a(i2 i2Var) {
        Intrinsics.checkNotNullParameter(i2Var, "eventMessenger");
        i2Var.c(o0.class, c());
        i2Var.c(q0.class, d());
        i2Var.c(o5.class, k());
        i2Var.c(r5.class, m());
        i2Var.c(q5.class, l());
        i2Var.c(j6.class, o());
        i2Var.c(k5.class, j());
        i2Var.c(Throwable.class, a((Semaphore) null));
        i2Var.c(w5.class, n());
        i2Var.c(u6.class, r());
        i2Var.c(m3.class, h());
        i2Var.c(t1.class, f());
        i2Var.c(k1.class, e());
        i2Var.c(l6.class, p());
        i2Var.c(d3.class, g());
        i2Var.c(s6.class, q());
        i2Var.c(x.class, i());
        i2Var.c(w.class, a());
        i2Var.c(v.class, b());
    }

    public final IEventSubscriber a(Semaphore semaphore) {
        return new d1$$ExternalSyntheticLambda7(this, semaphore);
    }

    /* access modifiers changed from: private */
    public static final void a(d1 d1Var, Semaphore semaphore, Throwable th) {
        Intrinsics.checkNotNullParameter(d1Var, "this$0");
        if (th != null) {
            try {
                d1Var.d.a(th);
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) d1Var, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) b.b);
                if (semaphore == null) {
                    return;
                }
            } catch (Throwable th2) {
                if (semaphore != null) {
                    semaphore.release();
                }
                throw th2;
            }
        }
        if (semaphore == null) {
            return;
        }
        semaphore.release();
    }

    private final void a(q5 q5Var) {
        n5 a2 = q5Var.a();
        x1 a3 = j.h.a(a2.v());
        if (a3 != null) {
            a3.a(a2.s());
            this.d.a(a3);
        }
    }
}
