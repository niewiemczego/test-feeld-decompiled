package bo.app;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import bo.app.n4;
import bo.app.y3;
import com.braze.BrazeFlushPushDeliveryReceiver;
import com.braze.Constants;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.models.IBrazeLocation;
import com.braze.support.BrazeLogger;
import com.braze.support.IntentUtils;
import com.braze.support.JsonUtils;
import com.google.android.exoplayer2.C;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.json.JSONObject;

public final class o implements z1 {
    public static final a x = new a((DefaultConstructorMarker) null);
    private static final String[] y = {"android.os.deadsystemexception"};
    private final Context a;
    private final String b;
    /* access modifiers changed from: private */
    public final t c;
    private final i2 d;
    private final BrazeConfigurationProvider e;
    private final l5 f;
    private final g1 g;
    private boolean h;
    private final p i;
    private final g5 j;
    private final n4 k;
    private final k4 l;
    private final m4 m;

    /* renamed from: n  reason: collision with root package name */
    private final AtomicInteger f18n = new AtomicInteger(0);
    private final AtomicInteger o = new AtomicInteger(0);
    private final ReentrantLock p = new ReentrantLock();
    private Job q = JobKt.Job$default((Job) null, 1, (Object) null);
    private final c1 r;
    /* access modifiers changed from: private */
    public final e6 s;
    private volatile String t;
    /* access modifiers changed from: private */
    public final AtomicBoolean u;
    /* access modifiers changed from: private */
    public final AtomicBoolean v;
    private Class w;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }

        /* access modifiers changed from: private */
        public final boolean a(boolean z, x1 x1Var) {
            if (!z) {
                return false;
            }
            if (x1Var.a() == h1.PUSH_ACTION_BUTTON_CLICKED) {
                Intrinsics.checkNotNull(x1Var, "null cannot be cast to non-null type com.braze.models.outgoing.event.push.PushActionButtonClickedEvent");
                return !((f4) x1Var).x();
            } else if (x1Var.a() == h1.PUSH_CLICKED || x1Var.a() == h1.PUSH_STORY_PAGE_CLICK) {
                return true;
            } else {
                return false;
            }
        }
    }

    static final class a0 extends Lambda implements Function0 {
        public static final a0 b = new a0();

        a0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Posting geofence report for geofence event.";
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "SDK is disabled. Not adding request to dispatch.";
        }
    }

    static final class b0 extends Lambda implements Function0 {
        public static final b0 b = new b0();

        b0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Posting feature flags refresh request.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "SDK is disabled. Not closing session.";
        }
    }

    static final class c0 extends Lambda implements Function0 {
        public static final c0 b = new c0();

        c0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Disallowing Content Cards sync due to Content Cards not being enabled.";
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ Activity b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Activity activity) {
            super(0);
            this.b = activity;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Closed session with activity: " + this.b.getLocalClassName();
        }
    }

    static final class d0 extends Lambda implements Function0 {
        final /* synthetic */ o b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d0(o oVar) {
            super(0);
            this.b = oVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Content card sync proceeding: " + this.b.s;
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "SDK is disabled. Not force closing session.";
        }
    }

    static final class e0 extends Lambda implements Function0 {
        final /* synthetic */ o b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e0(o oVar) {
            super(0);
            this.b = oVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Content card sync being throttled: " + this.b.s;
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ Throwable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(Throwable th) {
            super(0);
            this.b = th;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not logging duplicate error: " + this.b;
        }
    }

    static final class f0 extends Lambda implements Function0 {
        public static final f0 b = new f0();

        f0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Requesting DUST mite";
        }
    }

    static final class g extends Lambda implements Function0 {
        public static final g b = new g();

        g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log error.";
        }
    }

    static final class g0 extends Lambda implements Function0 {
        public static final g0 b = new g0();

        g0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Posting geofence request for location.";
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ x1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(x1 x1Var) {
            super(0);
            this.b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "SDK is disabled. Not logging event: " + this.b;
        }
    }

    static final class h0 extends Lambda implements Function0 {
        public static final h0 b = new h0();

        h0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Sending Push Max data";
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ x1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(x1 x1Var) {
            super(0);
            this.b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not processing event after validation failed: " + this.b;
        }
    }

    static final class i0 extends Lambda implements Function0 {
        final /* synthetic */ o b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i0(o oVar) {
            super(0);
            this.b = oVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Updated shouldRequestFeedInNextRequest to: " + this.b.v;
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ x1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(x1 x1Var) {
            super(0);
            this.b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not adding user id to event: " + JsonUtils.getPrettyPrintedString((JSONObject) this.b.forJsonPut());
        }
    }

    static final class j0 extends Lambda implements Function0 {
        final /* synthetic */ o b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j0(o oVar) {
            super(0);
            this.b = oVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Updated shouldRequestTriggersInNextRequest to: " + this.b.u;
        }
    }

    static final class k extends Lambda implements Function0 {
        final /* synthetic */ x1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(x1 x1Var) {
            super(0);
            this.b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Attempting to log event: " + JsonUtils.getPrettyPrintedString((JSONObject) this.b.forJsonPut());
        }
    }

    static final class l extends Lambda implements Function0 {
        public static final l b = new l();

        l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Publishing an internal push body clicked event for any awaiting triggers.";
        }
    }

    static final class m extends Lambda implements Function0 {
        public static final m b = new m();

        m() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Adding push click to dispatcher pending list";
        }
    }

    static final class n extends Lambda implements Function0 {
        public static final n b = new n();

        n() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Session in background, data syncing event on delay";
        }
    }

    /* renamed from: bo.app.o$o  reason: collision with other inner class name */
    static final class C0020o extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ o c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0020o(o oVar, Continuation continuation) {
            super(2, continuation);
            this.c = oVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C0020o) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new C0020o(this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.b = 1;
                if (DelayKt.delay(1000, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.c.e();
            return Unit.INSTANCE;
        }
    }

    static final class p extends Lambda implements Function0 {
        final /* synthetic */ x1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(x1 x1Var) {
            super(0);
            this.b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not adding session id to event: " + JsonUtils.getPrettyPrintedString((JSONObject) this.b.forJsonPut());
        }
    }

    static final class q extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Logging push delivery event for campaign id: " + this.b;
        }
    }

    static final class r extends Lambda implements Function0 {
        public static final r b = new r();

        r() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Logging push max campaign";
        }
    }

    static final class s extends Lambda implements Function0 {
        public static final s b = new s();

        s() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "SDK is disabled. Not opening session.";
        }
    }

    static final class t extends Lambda implements Function0 {
        final /* synthetic */ o b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(o oVar) {
            super(0);
            this.b = oVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Completed the openSession call. Starting or continuing session " + this.b.c.g();
        }
    }

    static final class u extends Lambda implements Function0 {
        public static final u b = new u();

        u() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "SDK is disabled. Not opening session.";
        }
    }

    static final class v extends Lambda implements Function0 {
        final /* synthetic */ Activity b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(Activity activity) {
            super(0);
            this.b = activity;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Opened session with activity: " + this.b.getLocalClassName();
        }
    }

    static final class w extends Lambda implements Function0 {
        public static final w b = new w();

        w() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get local class name for activity when opening session";
        }
    }

    static final class x extends Lambda implements Function0 {
        public static final x b = new x();

        x() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Flushing Push Delivery Events now";
        }
    }

    static final class y extends Lambda implements Function0 {
        public static final y b = new y();

        y() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Attempted to flush Push Delivery events, but no events are available";
        }
    }

    static final class z extends Lambda implements Function0 {
        final /* synthetic */ long b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z(long j) {
            super(0);
            this.b = j;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Scheduling Push Delivery Events Flush in " + this.b + " ms";
        }
    }

    public o(Context context, String str, String str2, t tVar, i2 i2Var, BrazeConfigurationProvider brazeConfigurationProvider, l5 l5Var, g1 g1Var, boolean z2, p pVar, g5 g5Var, n4 n4Var, k4 k4Var, m4 m4Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str2, DynamicLink.Builder.KEY_API_KEY);
        Intrinsics.checkNotNullParameter(tVar, "sessionManager");
        Intrinsics.checkNotNullParameter(i2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(g1Var, "eventStorageManager");
        Intrinsics.checkNotNullParameter(pVar, "messagingSessionManager");
        Intrinsics.checkNotNullParameter(g5Var, "sdkEnablementProvider");
        Intrinsics.checkNotNullParameter(n4Var, "pushMaxManager");
        Intrinsics.checkNotNullParameter(k4Var, "pushDeliveryManager");
        Intrinsics.checkNotNullParameter(m4Var, "pushIdentifierStorageProvider");
        this.a = context;
        this.b = str;
        this.c = tVar;
        this.d = i2Var;
        this.e = brazeConfigurationProvider;
        this.f = l5Var;
        this.g = g1Var;
        this.h = z2;
        this.i = pVar;
        this.j = g5Var;
        this.k = n4Var;
        this.l = k4Var;
        this.m = m4Var;
        this.r = new c1(context, a(), str2);
        this.s = new e6(l5Var.h(), l5Var.i());
        this.t = "";
        this.u = new AtomicBoolean(false);
        this.v = new AtomicBoolean(false);
        i2Var.c(d5.class, new o$$ExternalSyntheticLambda0(this));
    }

    public void closeSession(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.j.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) c.b, 2, (Object) null);
        } else if (this.w == null || Intrinsics.areEqual((Object) activity.getClass(), (Object) this.w)) {
            this.i.c();
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new d(activity), 2, (Object) null);
            this.c.n();
        }
    }

    public void e() {
        a(new y3.a((String) null, (Boolean) null, (Boolean) null, (x3) null, 15, (DefaultConstructorMarker) null));
    }

    public void f() {
        if (this.j.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) s.b, 2, (Object) null);
            return;
        }
        this.c.l();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new t(this), 2, (Object) null);
    }

    public void g() {
        if (this.j.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) e.b, 2, (Object) null);
            return;
        }
        this.w = null;
        this.c.k();
    }

    public void h() {
        if (this.f.E()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) h0.b, 3, (Object) null);
            l5 l5Var = this.f;
            String baseUrlForRequests = this.e.getBaseUrlForRequests();
            String a2 = a();
            List<n4.a> a3 = this.k.a();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a3, 10));
            for (n4.a a4 : a3) {
                arrayList.add(a4.a());
            }
            a((a2) new p4(l5Var, baseUrlForRequests, a2, arrayList, this.k.b(), this.m.a(this.f.u())));
        }
    }

    public p5 i() {
        return this.c.g();
    }

    public void openSession(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.j.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) u.b, 2, (Object) null);
            return;
        }
        f();
        this.w = activity.getClass();
        this.i.b();
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new v(activity), 2, (Object) null);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) w.b);
        }
    }

    public void refreshFeatureFlags() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) b0.b, 3, (Object) null);
        a((a2) new n1(this.f, this.e.getBaseUrlForRequests(), a()));
    }

    public String a() {
        return this.b;
    }

    public boolean b() {
        return this.u.get();
    }

    public void c(boolean z2) {
        this.h = z2;
    }

    public void d() {
        if (this.f.y()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) f0.b, 2, (Object) null);
            a((a2) new r0(this.f, this.e.getBaseUrlForRequests(), a()));
        }
    }

    /* access modifiers changed from: private */
    public static final void a(o oVar, d5 d5Var) {
        Intrinsics.checkNotNullParameter(oVar, "this$0");
        Intrinsics.checkNotNullParameter(d5Var, "it");
        oVar.a(d5Var.a());
    }

    public void b(boolean z2) {
        this.u.set(z2);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new j0(this), 2, (Object) null);
    }

    public boolean c() {
        return this.v.get();
    }

    /* JADX INFO: finally extract failed */
    private final boolean c(Throwable th) {
        ReentrantLock reentrantLock = this.p;
        reentrantLock.lock();
        try {
            this.f18n.getAndIncrement();
            if (!Intrinsics.areEqual((Object) this.t, (Object) th.getMessage()) || this.o.get() <= 3 || this.f18n.get() >= 100) {
                if (Intrinsics.areEqual((Object) this.t, (Object) th.getMessage())) {
                    this.o.getAndIncrement();
                } else {
                    this.o.set(0);
                }
                if (this.f18n.get() >= 100) {
                    this.f18n.set(0);
                }
                this.t = th.getMessage();
                reentrantLock.unlock();
                return false;
            }
            reentrantLock.unlock();
            return true;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public void a(boolean z2) {
        this.v.set(z2);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new i0(this), 2, (Object) null);
    }

    public void b(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        a(th, false);
    }

    public boolean a(x1 x1Var) {
        boolean z2;
        x1 x1Var2 = x1Var;
        Intrinsics.checkNotNullParameter(x1Var2, "event");
        boolean z3 = false;
        if (this.j.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new h(x1Var2), 2, (Object) null);
            return false;
        } else if (!this.r.a(x1Var2)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new i(x1Var2), 2, (Object) null);
            return false;
        } else {
            if (this.c.i() || this.c.g() == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new p(x1Var2), 3, (Object) null);
                z2 = true;
            } else {
                x1Var2.a(this.c.g());
                z2 = false;
            }
            String a2 = a();
            if (a2 == null || a2.length() == 0) {
                z3 = true;
            }
            if (!z3) {
                x1Var2.a(a());
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new j(x1Var2), 3, (Object) null);
            }
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.Priority priority = BrazeLogger.Priority.V;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, (Function0) new k(x1Var2), 2, (Object) null);
            if (x1Var.a() == h1.PUSH_CLICKED) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) l.b, 3, (Object) null);
                a((i4) x1Var2);
            }
            if (!x1Var.m()) {
                this.g.a(x1Var2);
            }
            if (x.a(z2, x1Var2)) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) m.b, 3, (Object) null);
                this.d.a((Object) n0.e.b(x1Var2), n0.class);
            } else {
                this.d.a((Object) n0.e.a(x1Var2), n0.class);
            }
            if (x1Var.a() == h1.SESSION_START) {
                this.d.a((Object) n0.e.a(x1Var.s()), n0.class);
            }
            if (z2) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, (Function0) n.b, 2, (Object) null);
                Job.DefaultImpls.cancel$default(this.q, (CancellationException) null, 1, (Object) null);
                this.q = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new C0020o(this, (Continuation) null), 3, (Object) null);
            }
            return true;
        }
    }

    public void b(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "geofenceEvent");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) a0.b, 3, (Object) null);
        a((a2) new s1(this.f, this.e.getBaseUrlForRequests(), x1Var));
    }

    public void b(String str) {
        Intrinsics.checkNotNullParameter(str, "campaignId");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) r.b, 3, (Object) null);
        this.k.a(str);
    }

    public void a(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        a(th, true);
    }

    public void a(y3.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "respondWithBuilder");
        Pair c2 = this.f.c();
        if (c2 != null) {
            aVar.a(new x3(((Number) c2.getFirst()).longValue(), ((Boolean) c2.getSecond()).booleanValue()));
        }
        if (this.u.get()) {
            aVar.e();
        }
        aVar.a(a());
        a((a2) new h0(this.f, this.e.getBaseUrlForRequests(), aVar.a()));
        this.u.set(false);
    }

    public void a(IBrazeLocation iBrazeLocation) {
        Intrinsics.checkNotNullParameter(iBrazeLocation, FirebaseAnalytics.Param.LOCATION);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) g0.b, 3, (Object) null);
        a((a2) new r1(this.f, this.e.getBaseUrlForRequests(), iBrazeLocation));
    }

    public void a(a2 a2Var) {
        Intrinsics.checkNotNullParameter(a2Var, "request");
        if (this.j.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
            return;
        }
        a2Var.a(a());
        this.d.a((Object) n0.e.a(a2Var), n0.class);
    }

    public void a(b6 b6Var, u2 u2Var) {
        Intrinsics.checkNotNullParameter(b6Var, "templatedTriggeredAction");
        Intrinsics.checkNotNullParameter(u2Var, "triggerEvent");
        a((a2) new a6(this.f, this.e.getBaseUrlForRequests(), b6Var, u2Var, a()));
    }

    public void a(u2 u2Var) {
        Intrinsics.checkNotNullParameter(u2Var, "triggerEvent");
        this.d.a((Object) new l6(u2Var), l6.class);
    }

    public void a(long j2, long j3, int i2, boolean z2) {
        if (!this.f.x()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) c0.b, 2, (Object) null);
            return;
        }
        if ((!z2 || !this.f.w()) ? true : this.s.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new d0(this), 2, (Object) null);
            a((a2) new b0(this.f, this.e.getBaseUrlForRequests(), j2, j3, a(), i2));
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new e0(this), 2, (Object) null);
    }

    public final void a(Throwable th, boolean z2) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        try {
            if (c(th)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new f(th), 2, (Object) null);
                return;
            }
            String th2 = th.toString();
            String[] strArr = y;
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length) {
                String str = strArr[i2];
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "US");
                String lowerCase = th2.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (!StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) str, false, 2, (Object) null)) {
                    i2++;
                } else {
                    return;
                }
            }
            x1 a2 = j.h.a(th, i(), z2);
            if (a2 != null) {
                a(a2);
            }
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) g.b);
        }
    }

    public final void a(i4 i4Var) {
        Intrinsics.checkNotNullParameter(i4Var, "notificationTrackingBrazeEvent");
        String optString = i4Var.q().optString(Constants.BRAZE_PUSH_CAMPAIGN_ID_KEY, "");
        i2 i2Var = this.d;
        Intrinsics.checkNotNullExpressionValue(optString, "campaignId");
        i2Var.a((Object) new j6(optString, i4Var), j6.class);
    }

    public void a(long j2) {
        Object systemService = this.a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager alarmManager = (AlarmManager) systemService;
        Intent intent = new Intent(this.a, BrazeFlushPushDeliveryReceiver.class);
        intent.setAction(BrazeFlushPushDeliveryReceiver.FLUSH_BRAZE_PUSH_DELIVERIES_ACTION);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.a, 0, intent, IntentUtils.getImmutablePendingIntentFlags() | C.BUFFER_FLAG_FIRST_SAMPLE);
        if (j2 <= 0) {
            alarmManager.cancel(broadcast);
            List a2 = this.l.a();
            if (!a2.isEmpty()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) x.b, 3, (Object) null);
                a((a2) new l4(this.f, this.e.getBaseUrlForRequests(), a(), a2));
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) y.b, 3, (Object) null);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new z(j2), 3, (Object) null);
        alarmManager.set(2, SystemClock.elapsedRealtime() + j2, broadcast);
    }

    public void a(String str) {
        Intrinsics.checkNotNullParameter(str, "campaignId");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new q(str), 3, (Object) null);
        this.l.a(str);
    }
}
