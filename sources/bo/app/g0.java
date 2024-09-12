package bo.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import com.braze.Braze;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.support.BrazeLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

public final class g0 {
    public static final c o = new c((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final Context a;
    /* access modifiers changed from: private */
    public final i2 b;
    private final f0 c;
    private BroadcastReceiver d;
    private ConnectivityManager.NetworkCallback e;
    private final i1 f;
    /* access modifiers changed from: private */
    public s5 g = s5.NO_SESSION;
    private long h = -1;
    private volatile boolean i;
    /* access modifiers changed from: private */
    public final ConnectivityManager j;
    /* access modifiers changed from: private */
    public q3 k;
    private Job l;
    private int m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f12n;

    public static final class a extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ g0 a;

        a(g0 g0Var) {
            this.a = g0Var;
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.checkNotNullParameter(network, "network");
            Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
            super.onCapabilitiesChanged(network, networkCapabilities);
            this.a.a(networkCapabilities);
        }

        public void onLost(Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            super.onLost(network);
            Network activeNetwork = this.a.j.getActiveNetwork();
            g0 g0Var = this.a;
            g0Var.a(g0Var.j.getNetworkCapabilities(activeNetwork));
        }
    }

    public static final class b extends BroadcastReceiver {
        final /* synthetic */ g0 a;

        static final class a extends SuspendLambda implements Function2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ g0 d;
            final /* synthetic */ Intent e;
            final /* synthetic */ BroadcastReceiver.PendingResult f;

            /* renamed from: bo.app.g0$b$a$a  reason: collision with other inner class name */
            static final class C0009a extends Lambda implements Function0 {
                public static final C0009a b = new C0009a();

                C0009a() {
                    super(0);
                }

                /* renamed from: a */
                public final String invoke() {
                    return "Retrieving connectivity event data in background";
                }
            }

            /* renamed from: bo.app.g0$b$a$b  reason: collision with other inner class name */
            static final class C0010b extends Lambda implements Function0 {
                public static final C0010b b = new C0010b();

                C0010b() {
                    super(0);
                }

                /* renamed from: a */
                public final String invoke() {
                    return "Failed to process connectivity event.";
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(g0 g0Var, Intent intent, BroadcastReceiver.PendingResult pendingResult, Continuation continuation) {
                super(2, continuation);
                this.d = g0Var;
                this.e = intent;
                this.f = pendingResult;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation create(Object obj, Continuation continuation) {
                a aVar = new a(this.d, this.e, this.f, continuation);
                aVar.c = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.b == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.c;
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) coroutineScope, BrazeLogger.Priority.V, (Throwable) null, (Function0) C0009a.b, 2, (Object) null);
                    try {
                        q3 d2 = this.d.k;
                        g0 g0Var = this.d;
                        g0Var.k = com.braze.support.a.a(this.e, g0Var.j);
                        if (d2 != this.d.k) {
                            this.d.b.a((Object) new r3(d2, this.d.k), r3.class);
                        }
                        this.d.d();
                    } catch (Exception e2) {
                        BrazeLogger.INSTANCE.brazelog((Object) coroutineScope, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) C0010b.b);
                        g0 g0Var2 = this.d;
                        g0Var2.a(g0Var2.b, (Throwable) e2);
                    }
                    this.f.finish();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        b(g0 g0Var) {
            this.a = g0Var;
        }

        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
            Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new a(this.a, intent, goAsync(), (Continuation) null), 3, (Object) null);
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

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                bo.app.q3[] r0 = bo.app.q3.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                bo.app.q3 r1 = bo.app.q3.NONE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                bo.app.q3 r1 = bo.app.q3.BAD     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                bo.app.q3 r1 = bo.app.q3.GREAT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                bo.app.q3 r1 = bo.app.q3.GOOD     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.g0.d.<clinit>():void");
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ g0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(g0 g0Var) {
            super(0);
            this.b = g0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received successful request flush. Default flush interval reset to " + this.b.b();
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ long b;
        final /* synthetic */ g0 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(long j, g0 g0Var) {
            super(0);
            this.b = j;
            this.c = g0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Kicking off the Sync Job. initialDelaysMs: " + this.b + ": currentIntervalMs " + this.c.b() + " ms";
        }
    }

    static final class g extends SuspendLambda implements Function2 {
        long b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ g0 e;
        final /* synthetic */ long f;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Requesting data flush from automatic sync policy";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(g0 g0Var, long j, Continuation continuation) {
            super(2, continuation);
            this.e = g0Var;
            this.f = j;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            g gVar = new g(this.e, this.f, continuation);
            gVar.d = obj;
            return gVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlinx.coroutines.CoroutineScope} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0060  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x002c
                if (r1 == r3) goto L_0x0022
                if (r1 != r2) goto L_0x001a
                long r3 = r12.b
                java.lang.Object r1 = r12.d
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r13)
                r13 = r12
            L_0x0018:
                r10 = r3
                goto L_0x006d
            L_0x001a:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x0022:
                long r3 = r12.b
                java.lang.Object r1 = r12.d
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r13)
                goto L_0x004a
            L_0x002c:
                kotlin.ResultKt.throwOnFailure(r13)
                java.lang.Object r13 = r12.d
                r1 = r13
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                bo.app.g0 r13 = r12.e
                long r4 = r13.b()
                long r6 = r12.f
                r12.d = r1
                r12.b = r4
                r12.c = r3
                java.lang.Object r13 = kotlinx.coroutines.DelayKt.delay(r6, r12)
                if (r13 != r0) goto L_0x0049
                return r0
            L_0x0049:
                r3 = r4
            L_0x004a:
                com.braze.Braze$Companion r13 = com.braze.Braze.Companion
                bo.app.g0 r5 = r12.e
                android.content.Context r5 = r5.a
                com.braze.Braze r13 = r13.getInstance(r5)
                r13.requestImmediateDataFlush()
                r13 = r12
            L_0x005a:
                boolean r5 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
                if (r5 == 0) goto L_0x008b
                r13.d = r1
                r13.b = r3
                r13.c = r2
                java.lang.Object r5 = kotlinx.coroutines.DelayKt.delay(r3, r13)
                if (r5 != r0) goto L_0x0018
                return r0
            L_0x006d:
                com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.V
                bo.app.g0$g$a r7 = bo.app.g0.g.a.b
                r6 = 0
                r8 = 2
                r9 = 0
                r4 = r1
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
                com.braze.Braze$Companion r3 = com.braze.Braze.Companion
                bo.app.g0 r4 = r13.e
                android.content.Context r4 = r4.a
                com.braze.Braze r3 = r3.getInstance(r4)
                r3.requestImmediateDataFlush()
                r3 = r10
                goto L_0x005a
            L_0x008b:
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.g0.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ g0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(g0 g0Var) {
            super(0);
            this.b = g0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Data flush interval is " + this.b.b() + " ms. Not scheduling a proceeding data flush.";
        }
    }

    static final class i extends Lambda implements Function0 {
        public static final i b = new i();

        i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log throwable.";
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ g0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(g0 g0Var) {
            super(0);
            this.b = g0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "recalculateDispatchState called with session state: " + this.b.g + " lastNetworkLevel: " + this.b.k;
        }
    }

    static final class k extends Lambda implements Function0 {
        final /* synthetic */ g0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(g0 g0Var) {
            super(0);
            this.b = g0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Flush interval was too low (" + this.b.b() + "), moving to minimum of 1000 ms";
        }
    }

    static final class l extends Lambda implements Function0 {
        final /* synthetic */ g0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(g0 g0Var) {
            super(0);
            this.b = g0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "currentIntervalMs: " + this.b.b();
        }
    }

    static final class m extends Lambda implements Function0 {
        final /* synthetic */ long b;
        final /* synthetic */ g0 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(long j, g0 g0Var) {
            super(0);
            this.b = j;
            this.c = g0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Data flush interval has changed from " + this.b + " ms to " + this.c.b() + " ms after connectivity state change to: " + this.c.k + " and session state: " + this.c.g;
        }
    }

    static final class n extends Lambda implements Function0 {
        final /* synthetic */ long b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(long j) {
            super(0);
            this.b = j;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Posting new sync runnable with delay " + this.b + " ms";
        }
    }

    static final class o extends Lambda implements Function0 {
        public static final o b = new o();

        o() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The data sync policy is already running. Ignoring request.";
        }
    }

    static final class p extends Lambda implements Function0 {
        public static final p b = new p();

        p() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Data sync started";
        }
    }

    static final class q extends Lambda implements Function0 {
        public static final q b = new q();

        q() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The data sync policy is not running. Ignoring request.";
        }
    }

    static final class r extends Lambda implements Function0 {
        public static final r b = new r();

        r() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Data sync stopped";
        }
    }

    static final class s extends Lambda implements Function0 {
        public static final s b = new s();

        s() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to unregister Connectivity callback";
        }
    }

    public g0(Context context, i2 i2Var, f0 f0Var, l5 l5Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(i2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(f0Var, "dataSyncConfigurationProvider");
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        this.a = context;
        this.b = i2Var;
        this.c = f0Var;
        int k2 = l5Var.k();
        this.f = new i1(l5Var.j(), (int) TimeUnit.SECONDS.toMillis(10), k2, l5Var.l());
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.j = (ConnectivityManager) systemService;
        this.k = q3.NONE;
        if (Build.VERSION.SDK_INT >= 30) {
            this.e = new a(this);
        } else {
            this.d = new b(this);
        }
        a(i2Var);
    }

    public final synchronized boolean f() {
        if (this.i) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) o.b, 3, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) p.b, 3, (Object) null);
        e();
        b(this.h);
        this.i = true;
        return true;
    }

    public final synchronized boolean g() {
        if (!this.i) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) q.b, 3, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) r.b, 3, (Object) null);
        a();
        h();
        this.i = false;
        return true;
    }

    public final void h() {
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                ConnectivityManager connectivityManager = this.j;
                ConnectivityManager.NetworkCallback networkCallback = this.e;
                if (networkCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("connectivityNetworkCallback");
                    networkCallback = null;
                }
                connectivityManager.unregisterNetworkCallback(networkCallback);
                return;
            }
            this.a.unregisterReceiver(this.d);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) s.b);
        }
    }

    public final long b() {
        return this.h;
    }

    public final boolean c() {
        return this.f.c();
    }

    public final void d() {
        long j2;
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, (Function0) new j(this), 2, (Object) null);
        long j3 = this.h;
        if (this.g == s5.NO_SESSION || this.f12n || this.m >= 50) {
            this.h = -1;
        } else {
            int i2 = d.a[this.k.ordinal()];
            if (i2 == 1) {
                j2 = -1;
            } else if (i2 == 2) {
                j2 = this.c.a();
            } else if (i2 == 3) {
                j2 = this.c.c();
            } else if (i2 == 4) {
                j2 = this.c.b();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.h = j2;
            if (j2 != -1 && j2 < 1000) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new k(this), 2, (Object) null);
                this.h = 1000;
            }
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, (Function0) new l(this), 2, (Object) null);
        if (j3 != this.h) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new m(j3, this), 3, (Object) null);
            b(this.h);
        }
    }

    public final void e() {
        if (Build.VERSION.SDK_INT >= 30) {
            ConnectivityManager connectivityManager = this.j;
            ConnectivityManager.NetworkCallback networkCallback = this.e;
            if (networkCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("connectivityNetworkCallback");
                networkCallback = null;
            }
            connectivityManager.registerDefaultNetworkCallback(networkCallback);
            a(this.j.getNetworkCapabilities(this.j.getActiveNetwork()));
            return;
        }
        this.a.registerReceiver(this.d, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
    }

    private final void b(long j2) {
        a();
        if (this.h >= 1000) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new n(j2), 3, (Object) null);
            this.l = a(j2);
        }
    }

    public final synchronized void a(boolean z) {
        this.f12n = z;
        d();
        if (z) {
            g();
        } else {
            f();
        }
    }

    private final Job a(long j2) {
        long j3 = j2;
        if (this.h >= 1000) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new f(j3, this), 2, (Object) null);
            return BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new g(this, j3, (Continuation) null), 3, (Object) null);
        }
        Braze.Companion.getInstance(this.a).requestImmediateDataFlush();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new h(this), 3, (Object) null);
        return null;
    }

    private final void a() {
        Job job = this.l;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.l = null;
    }

    /* access modifiers changed from: private */
    public final void a(i2 i2Var, Throwable th) {
        try {
            i2Var.a((Object) th, Throwable.class);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) i.b);
        }
    }

    /* access modifiers changed from: private */
    public final void a(NetworkCapabilities networkCapabilities) {
        q3 q3Var = this.k;
        q3 a2 = com.braze.support.a.a(networkCapabilities);
        this.k = a2;
        if (q3Var != a2) {
            this.b.a((Object) new r3(q3Var, a2), r3.class);
        }
        d();
    }

    public final void a(i2 i2Var) {
        Intrinsics.checkNotNullParameter(i2Var, "eventManager");
        i2Var.c(r5.class, new g0$$ExternalSyntheticLambda0(this));
        i2Var.c(t5.class, new g0$$ExternalSyntheticLambda1(this));
        i2Var.c(z4.class, new g0$$ExternalSyntheticLambda2(this));
        i2Var.c(a5.class, new g0$$ExternalSyntheticLambda3(this));
        i2Var.c(m5.class, new g0$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    public static final void a(g0 g0Var, r5 r5Var) {
        Intrinsics.checkNotNullParameter(g0Var, "this$0");
        Intrinsics.checkNotNullParameter(r5Var, "it");
        g0Var.g = s5.OPEN_SESSION;
        g0Var.m = 0;
        g0Var.d();
    }

    /* access modifiers changed from: private */
    public static final void a(g0 g0Var, t5 t5Var) {
        Intrinsics.checkNotNullParameter(g0Var, "this$0");
        Intrinsics.checkNotNullParameter(t5Var, "it");
        g0Var.g = s5.NO_SESSION;
        g0Var.d();
    }

    /* access modifiers changed from: private */
    public static final void a(g0 g0Var, z4 z4Var) {
        Intrinsics.checkNotNullParameter(g0Var, "this$0");
        Intrinsics.checkNotNullParameter(z4Var, "it");
        long j2 = g0Var.h;
        g0Var.b(j2 + ((long) g0Var.f.a((int) j2)));
    }

    /* access modifiers changed from: private */
    public static final void a(g0 g0Var, a5 a5Var) {
        Intrinsics.checkNotNullParameter(g0Var, "this$0");
        Intrinsics.checkNotNullParameter(a5Var, "it");
        if (g0Var.f.c()) {
            g0Var.f.b();
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) g0Var, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new e(g0Var), 3, (Object) null);
            g0Var.b(g0Var.h);
        }
        g0Var.m = 0;
    }

    /* access modifiers changed from: private */
    public static final void a(g0 g0Var, m5 m5Var) {
        Intrinsics.checkNotNullParameter(g0Var, "this$0");
        Intrinsics.checkNotNullParameter(m5Var, "<name for destructuring parameter 0>");
        if (m5Var.a() instanceof e5) {
            g0Var.m++;
            g0Var.d();
        }
    }
}
