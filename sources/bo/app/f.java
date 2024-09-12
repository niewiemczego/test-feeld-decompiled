package bo.app;

import bo.app.n0;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.enums.BrazeDateFormat;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import java.util.TimeZone;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

public final class f implements f2 {
    public static final a k = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String l = BrazeLogger.getBrazeLogTag((Class<?>) f.class);
    private final BrazeConfigurationProvider a;
    private final o2 b;
    /* access modifiers changed from: private */
    public final p0 c;
    /* access modifiers changed from: private */
    public final l5 d;
    private final boolean e;
    private final ReentrantLock f = new ReentrantLock();
    /* access modifiers changed from: private */
    public final e6 g;
    private final x0 h;
    private volatile boolean i;
    private volatile Job j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                bo.app.n0$b[] r0 = bo.app.n0.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                bo.app.n0$b r1 = bo.app.n0.b.ADD_PENDING_BRAZE_EVENT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                bo.app.n0$b r1 = bo.app.n0.b.ADD_BRAZE_EVENT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                bo.app.n0$b r1 = bo.app.n0.b.FLUSH_PENDING_BRAZE_EVENTS     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                bo.app.n0$b r1 = bo.app.n0.b.ADD_REQUEST     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.f.b.<clinit>():void");
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ a2 b;
        final /* synthetic */ f c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a2 a2Var, f fVar) {
            super(0);
            this.b = a2Var;
            this.c = fVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Invoked addRequest for (hc: " + this.b.hashCode() + ")\n" + this.c.g;
        }
    }

    static final class d extends SuspendLambda implements Function2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ f d;

        static final class a extends Lambda implements Function0 {
            final /* synthetic */ a2 b;
            final /* synthetic */ long c;
            final /* synthetic */ f d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(a2 a2Var, long j, f fVar) {
                super(0);
                this.b = a2Var;
                this.c = j;
                this.d = fVar;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Delaying next request after (hc: " + this.b.hashCode() + ") until next token is available in " + this.c + "ms - '" + DateTimeUtils.formatDateFromMillis$default(DateTimeUtils.nowInMilliseconds() + this.c, (BrazeDateFormat) null, (TimeZone) null, 3, (Object) null) + "'\n" + this.d.g;
            }
        }

        static final class b extends Lambda implements Function0 {
            final /* synthetic */ a2 b;
            final /* synthetic */ f c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a2 a2Var, f fVar) {
                super(0);
                this.b = a2Var;
                this.c = fVar;
            }

            /* renamed from: a */
            public final String invoke() {
                return "The next request after (hc: " + this.b.hashCode() + ") can proceed without delaying - " + this.c.g;
            }
        }

        static final class c extends Lambda implements Function0 {
            final /* synthetic */ Exception b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(Exception exc) {
                super(0);
                this.b = exc;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Automatic thread interrupted! This is usually the result of calling changeUser(). [" + this.b + ']';
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(f fVar, Continuation continuation) {
            super(2, continuation);
            this.d = fVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            d dVar = new d(this.d, continuation);
            dVar.c = obj;
            return dVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: kotlinx.coroutines.CoroutineScope} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: kotlinx.coroutines.CoroutineScope} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0041 A[SYNTHETIC, Splitter:B:19:0x0041] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0079 A[Catch:{ Exception -> 0x00b9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00a3 A[Catch:{ Exception -> 0x00b9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00cc  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                r16 = this;
                r1 = r16
                java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r1.b
                r3 = 2
                r4 = 1
                if (r0 == 0) goto L_0x0032
                if (r0 == r4) goto L_0x0023
                if (r0 != r3) goto L_0x001b
                java.lang.Object r0 = r1.c
                r5 = r0
                kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
                kotlin.ResultKt.throwOnFailure(r17)     // Catch:{ Exception -> 0x0019 }
                goto L_0x003a
            L_0x0019:
                r0 = move-exception
                goto L_0x002f
            L_0x001b:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0023:
                java.lang.Object r0 = r1.c
                r5 = r0
                kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
                kotlin.ResultKt.throwOnFailure(r17)     // Catch:{ Exception -> 0x0019 }
                r0 = r17
                r6 = r1
                goto L_0x0052
            L_0x002f:
                r6 = r1
                goto L_0x00ba
            L_0x0032:
                kotlin.ResultKt.throwOnFailure(r17)
                java.lang.Object r0 = r1.c
                kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                r5 = r0
            L_0x003a:
                r6 = r1
            L_0x003b:
                boolean r0 = kotlinx.coroutines.CoroutineScopeKt.isActive(r5)
                if (r0 == 0) goto L_0x00cc
                bo.app.f r0 = r6.d     // Catch:{ Exception -> 0x00b9 }
                bo.app.p0 r0 = r0.c     // Catch:{ Exception -> 0x00b9 }
                r6.c = r5     // Catch:{ Exception -> 0x00b9 }
                r6.b = r4     // Catch:{ Exception -> 0x00b9 }
                java.lang.Object r0 = r0.a((kotlin.coroutines.Continuation) r6)     // Catch:{ Exception -> 0x00b9 }
                if (r0 != r2) goto L_0x0052
                return r2
            L_0x0052:
                bo.app.a2 r0 = (bo.app.a2) r0     // Catch:{ Exception -> 0x00b9 }
                bo.app.f r7 = r6.d     // Catch:{ Exception -> 0x00b9 }
                r7.a((bo.app.a2) r0)     // Catch:{ Exception -> 0x00b9 }
                bo.app.f r7 = r6.d     // Catch:{ Exception -> 0x00b9 }
                boolean r7 = r7.c((bo.app.a2) r0)     // Catch:{ Exception -> 0x00b9 }
                if (r7 != 0) goto L_0x003b
                bo.app.f r7 = r6.d     // Catch:{ Exception -> 0x00b9 }
                bo.app.l5 r7 = r7.d     // Catch:{ Exception -> 0x00b9 }
                boolean r7 = r7.D()     // Catch:{ Exception -> 0x00b9 }
                if (r7 == 0) goto L_0x003b
                bo.app.f r7 = r6.d     // Catch:{ Exception -> 0x00b9 }
                bo.app.e6 r7 = r7.g     // Catch:{ Exception -> 0x00b9 }
                boolean r7 = r7.a()     // Catch:{ Exception -> 0x00b9 }
                if (r7 != 0) goto L_0x00a3
                bo.app.f r7 = r6.d     // Catch:{ Exception -> 0x00b9 }
                bo.app.e6 r7 = r7.g     // Catch:{ Exception -> 0x00b9 }
                long r7 = r7.b()     // Catch:{ Exception -> 0x00b9 }
                com.braze.support.BrazeLogger r9 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r10 = bo.app.f.l     // Catch:{ Exception -> 0x00b9 }
                com.braze.support.BrazeLogger$Priority r11 = com.braze.support.BrazeLogger.Priority.V     // Catch:{ Exception -> 0x00b9 }
                r12 = 0
                bo.app.f$d$a r13 = new bo.app.f$d$a     // Catch:{ Exception -> 0x00b9 }
                bo.app.f r14 = r6.d     // Catch:{ Exception -> 0x00b9 }
                r13.<init>(r0, r7, r14)     // Catch:{ Exception -> 0x00b9 }
                r14 = 4
                r15 = 0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r9, (java.lang.String) r10, (com.braze.support.BrazeLogger.Priority) r11, (java.lang.Throwable) r12, (kotlin.jvm.functions.Function0) r13, (int) r14, (java.lang.Object) r15)     // Catch:{ Exception -> 0x00b9 }
                r6.c = r5     // Catch:{ Exception -> 0x00b9 }
                r6.b = r3     // Catch:{ Exception -> 0x00b9 }
                java.lang.Object r0 = kotlinx.coroutines.DelayKt.delay(r7, r6)     // Catch:{ Exception -> 0x00b9 }
                if (r0 != r2) goto L_0x003b
                return r2
            L_0x00a3:
                com.braze.support.BrazeLogger r7 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00b9 }
                java.lang.String r8 = bo.app.f.l     // Catch:{ Exception -> 0x00b9 }
                com.braze.support.BrazeLogger$Priority r9 = com.braze.support.BrazeLogger.Priority.V     // Catch:{ Exception -> 0x00b9 }
                r10 = 0
                bo.app.f$d$b r11 = new bo.app.f$d$b     // Catch:{ Exception -> 0x00b9 }
                bo.app.f r12 = r6.d     // Catch:{ Exception -> 0x00b9 }
                r11.<init>(r0, r12)     // Catch:{ Exception -> 0x00b9 }
                r12 = 4
                r13 = 0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r7, (java.lang.String) r8, (com.braze.support.BrazeLogger.Priority) r9, (java.lang.Throwable) r10, (kotlin.jvm.functions.Function0) r11, (int) r12, (java.lang.Object) r13)     // Catch:{ Exception -> 0x00b9 }
                goto L_0x003b
            L_0x00b9:
                r0 = move-exception
            L_0x00ba:
                com.braze.support.BrazeLogger r7 = com.braze.support.BrazeLogger.INSTANCE
                java.lang.String r8 = bo.app.f.l
                com.braze.support.BrazeLogger$Priority r9 = com.braze.support.BrazeLogger.Priority.V
                bo.app.f$d$c r10 = new bo.app.f$d$c
                r10.<init>(r0)
                r7.brazelog((java.lang.String) r8, (com.braze.support.BrazeLogger.Priority) r9, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r10)
                goto L_0x003b
            L_0x00cc:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.f.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Automatic request execution start was previously requested, continuing without action.";
        }
    }

    public f(BrazeConfigurationProvider brazeConfigurationProvider, i2 i2Var, o2 o2Var, p0 p0Var, l5 l5Var, boolean z) {
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "appConfigurationProvider");
        Intrinsics.checkNotNullParameter(i2Var, "internalIEventMessenger");
        Intrinsics.checkNotNullParameter(o2Var, "requestExecutor");
        Intrinsics.checkNotNullParameter(p0Var, "dispatchManager");
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        this.a = brazeConfigurationProvider;
        this.b = o2Var;
        this.c = p0Var;
        this.d = l5Var;
        this.e = z;
        this.g = new e6(l5Var.n(), l5Var.o());
        this.h = new x0(i2Var, z);
        i2Var.c(n0.class, new f$$ExternalSyntheticLambda0(this, i2Var));
    }

    public final void d() {
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            if (this.i) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, l, (BrazeLogger.Priority) null, (Throwable) null, (Function0) e.b, 6, (Object) null);
                return;
            }
            this.j = c();
            this.i = true;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } finally {
            reentrantLock.unlock();
        }
    }

    private final Job c() {
        return BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new d(this, (Continuation) null), 3, (Object) null);
    }

    private final h0 b() {
        return new h0(this.d, this.a.getBaseUrlForRequests(), (y3) null, 4, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public final boolean c(a2 a2Var) {
        return a2Var.c() || this.e;
    }

    /* access modifiers changed from: private */
    public static final void a(f fVar, i2 i2Var, n0 n0Var) {
        Intrinsics.checkNotNullParameter(fVar, "this$0");
        Intrinsics.checkNotNullParameter(i2Var, "$internalIEventMessenger");
        Intrinsics.checkNotNullParameter(n0Var, "<name for destructuring parameter 0>");
        n0.b a2 = n0Var.a();
        x1 b2 = n0Var.b();
        p5 c2 = n0Var.c();
        a2 d2 = n0Var.d();
        int i2 = b.a[a2.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4 && d2 != null) {
                        fVar.a(i2Var, d2);
                    }
                } else if (c2 != null) {
                    fVar.a(c2);
                }
            } else if (b2 != null) {
                fVar.a(b2);
            }
        } else if (b2 != null) {
            fVar.b(b2);
        }
    }

    public void b(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "event");
        this.c.b(x1Var);
    }

    private final void b(a2 a2Var) {
        if (c(a2Var)) {
            this.h.b(a2Var);
        } else {
            this.b.b(a2Var);
        }
    }

    public void a(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "event");
        this.c.a(x1Var);
    }

    public void a(i2 i2Var, a2 a2Var) {
        Intrinsics.checkNotNullParameter(i2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(a2Var, "request");
        this.c.a(i2Var, a2Var);
        if (!c(a2Var) && this.d.D()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, l, BrazeLogger.Priority.V, (Throwable) null, (Function0) new c(a2Var, this), 4, (Object) null);
        }
    }

    public void a(p5 p5Var) {
        Intrinsics.checkNotNullParameter(p5Var, "sessionId");
        this.c.a(p5Var);
    }

    /* JADX INFO: finally extract failed */
    public final void a(i2 i2Var) {
        Intrinsics.checkNotNullParameter(i2Var, "eventMessenger");
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            Job job = this.j;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.j = null;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            if (!this.c.b()) {
                this.c.a(i2Var, (a2) b());
            }
            a2 d2 = this.c.d();
            if (d2 != null) {
                b(d2);
            }
            b(this.c.b((a2) b()));
            i2Var.a();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final void a(a2 a2Var) {
        if (c(a2Var)) {
            this.h.a(a2Var);
        } else {
            this.b.a(a2Var);
        }
    }
}
