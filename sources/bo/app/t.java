package bo.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.braze.Braze;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.events.SessionStateChangedEvent;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.IntentUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

public final class t {
    public static final a l = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static final long f20n;
    /* access modifiers changed from: private */
    public final Context a;
    private final r2 b;
    /* access modifiers changed from: private */
    public final i2 c;
    private final i2 d;
    private final AlarmManager e;
    private final int f;
    private final boolean g;
    /* access modifiers changed from: private */
    public final ReentrantLock h = new ReentrantLock();
    private final String i;
    private Job j = JobKt.Job$default((Job) null, 1, (Object) null);
    private n3 k;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return t.f20n;
        }

        private a() {
        }

        public final boolean a(double d, double d2, int i, boolean z) {
            long nowInMilliseconds = DateTimeUtils.nowInMilliseconds();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long millis = timeUnit.toMillis((long) i);
            return !z ? timeUnit.toMillis((long) d2) + millis <= nowInMilliseconds : (timeUnit.toMillis((long) d) + millis) + a() <= nowInMilliseconds;
        }

        public final long a(n3 n3Var, int i, boolean z) {
            Intrinsics.checkNotNullParameter(n3Var, "mutableSession");
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long millis = timeUnit.toMillis((long) i);
            if (!z) {
                return millis;
            }
            long millis2 = timeUnit.toMillis((long) n3Var.x());
            return Math.max(a(), (millis2 + millis) - DateTimeUtils.nowInMilliseconds());
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cancelling session seal alarm";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to cancel session seal alarm";
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ long b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(long j) {
            super(0);
            this.b = j;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Creating a session seal alarm with a delay of " + this.b + " ms";
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to create session seal alarm";
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ n3 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(n3 n3Var) {
            super(0);
            this.b = n3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Clearing completely dispatched sealed session " + this.b.s();
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ n3 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(n3 n3Var) {
            super(0);
            this.b = n3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "New session created with ID: " + this.b.s();
        }
    }

    static final class h extends Lambda implements Function0 {
        public static final h b = new h();

        h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Getting the stored open session";
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ n3 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(n3 n3Var) {
            super(0);
            this.b = n3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Checking if this session needs to be sealed: " + this.b.s();
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ n3 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(n3 n3Var) {
            super(0);
            this.b = n3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Session [" + this.b.s() + "] being sealed because its end time is over the grace period. Session: " + this.b;
        }
    }

    public static final class k extends BroadcastReceiver {
        final /* synthetic */ t a;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Session seal logic executing in broadcast";
            }
        }

        static final class b extends SuspendLambda implements Function2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ t d;
            final /* synthetic */ BroadcastReceiver.PendingResult e;

            static final class a extends Lambda implements Function0 {
                public static final a b = new a();

                a() {
                    super(0);
                }

                /* renamed from: a */
                public final String invoke() {
                    return "Failed to log throwable during seal session.";
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(t tVar, BroadcastReceiver.PendingResult pendingResult, Continuation continuation) {
                super(2, continuation);
                this.d = tVar;
                this.e = pendingResult;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation create(Object obj, Continuation continuation) {
                b bVar = new b(this.d, this.e, continuation);
                bVar.c = obj;
                return bVar;
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.b == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.c;
                    ReentrantLock a2 = this.d.h;
                    t tVar = this.d;
                    a2.lock();
                    try {
                        tVar.j();
                    } catch (Exception e2) {
                        try {
                            tVar.c.a((Object) e2, Throwable.class);
                        } catch (Exception e3) {
                            BrazeLogger.INSTANCE.brazelog((Object) coroutineScope, BrazeLogger.Priority.E, (Throwable) e3, (Function0<String>) a.b);
                        } catch (Throwable th) {
                            a2.unlock();
                            throw th;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    a2.unlock();
                    this.e.finish();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        k(t tVar) {
            this.a = tVar;
        }

        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) a.b, 2, (Object) null);
            Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new b(this.a, goAsync(), (Continuation) null), 3, (Object) null);
        }
    }

    static final class l extends SuspendLambda implements Function2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ t d;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Requesting data flush on internal session close flush timer.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(t tVar, Continuation continuation) {
            super(2, continuation);
            this.d = tVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((l) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            l lVar = new l(this.d, continuation);
            lVar.c = obj;
            return lVar;
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.c;
                long a2 = t.m;
                this.c = coroutineScope2;
                this.b = 1;
                if (DelayKt.delay(a2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.c;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) coroutineScope, (BrazeLogger.Priority) null, (Throwable) null, (Function0) a.b, 3, (Object) null);
            Braze.Companion.getInstance(this.d.a).requestImmediateDataFlush();
            return Unit.INSTANCE;
        }
    }

    static final class m extends Lambda implements Function0 {
        final /* synthetic */ n3 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(n3 n3Var) {
            super(0);
            this.b = n3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Closed session with id " + this.b.s();
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        m = timeUnit.toMillis(10);
        f20n = timeUnit.toMillis(10);
    }

    public t(Context context, r2 r2Var, i2 i2Var, i2 i2Var2, AlarmManager alarmManager, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        Intrinsics.checkNotNullParameter(r2Var, "sessionStorageManager");
        Intrinsics.checkNotNullParameter(i2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(i2Var2, "externalEventPublisher");
        Intrinsics.checkNotNullParameter(alarmManager, "alarmManager");
        this.a = context;
        this.b = r2Var;
        this.c = i2Var;
        this.d = i2Var2;
        this.e = alarmManager;
        this.f = i2;
        this.g = z;
        k kVar = new k(this);
        String str = context.getPackageName() + ".intent.BRAZE_SESSION_SHOULD_SEAL";
        this.i = str;
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(kVar, new IntentFilter(str), 4);
        } else {
            context.registerReceiver(kVar, new IntentFilter(str));
        }
    }

    private final void e() {
        n3 n3Var = this.k;
        if (n3Var != null) {
            long a2 = l.a(n3Var, this.f, this.g);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new d(a2), 3, (Object) null);
            try {
                Intent intent = new Intent(this.i);
                intent.putExtra("session_id", n3Var.toString());
                this.e.set(1, DateTimeUtils.nowInMilliseconds() + a2, PendingIntent.getBroadcast(this.a, 0, intent, 1073741824 | IntentUtils.getImmutablePendingIntentFlags()));
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) e.b);
            }
        }
    }

    private final boolean f() {
        ReentrantLock reentrantLock = this.h;
        reentrantLock.lock();
        try {
            j();
            n3 n3Var = this.k;
            boolean z = false;
            if (n3Var != null) {
                if (!n3Var.y()) {
                    if (n3Var.w() != null) {
                        n3Var.a((Double) null);
                        z = true;
                    }
                    return z;
                }
            }
            h();
            if (n3Var != null && n3Var.y()) {
                z = true;
            }
            if (z) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new f(n3Var), 3, (Object) null);
                this.b.a(n3Var.s().toString());
            }
            z = true;
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void h() {
        n3 n3Var = new n3((p5) null, 0.0d, (Double) null, false, 15, (DefaultConstructorMarker) null);
        this.k = n3Var;
        n3 n3Var2 = n3Var;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new g(n3Var), 2, (Object) null);
        this.c.a((Object) new o5(n3Var2), o5.class);
        this.d.a((Object) new SessionStateChangedEvent(n3Var2.s().toString(), SessionStateChangedEvent.ChangeType.SESSION_STARTED), SessionStateChangedEvent.class);
    }

    /* access modifiers changed from: private */
    public final void j() {
        ReentrantLock reentrantLock = this.h;
        reentrantLock.lock();
        try {
            if (this.k == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) h.b, 3, (Object) null);
                n5 a2 = this.b.a();
                this.k = a2 != null ? a2.z() : null;
            }
            n3 n3Var = this.k;
            if (n3Var != null) {
                BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new i(n3Var), 3, (Object) null);
                Double w = n3Var.w();
                if (w != null && !n3Var.y()) {
                    if (l.a(n3Var.x(), w.doubleValue(), this.f, this.g)) {
                        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new j(n3Var), 2, (Object) null);
                        k();
                        r2 r2Var = this.b;
                        n3 n3Var2 = this.k;
                        r2Var.a(String.valueOf(n3Var2 != null ? n3Var2.s() : null));
                        this.k = null;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final p5 g() {
        ReentrantLock reentrantLock = this.h;
        reentrantLock.lock();
        try {
            j();
            n3 n3Var = this.k;
            return n3Var != null ? n3Var.s() : null;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean i() {
        ReentrantLock reentrantLock = this.h;
        reentrantLock.lock();
        try {
            n3 n3Var = this.k;
            boolean z = true;
            if (n3Var == null || !n3Var.y()) {
                z = false;
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void k() {
        n3 n3Var = this.k;
        if (n3Var != null) {
            ReentrantLock reentrantLock = this.h;
            reentrantLock.lock();
            try {
                n3Var.A();
                this.b.a((n5) n3Var);
                this.c.a((Object) new q5(n3Var), q5.class);
                this.d.a((Object) new SessionStateChangedEvent(n3Var.s().toString(), SessionStateChangedEvent.ChangeType.SESSION_ENDED), SessionStateChangedEvent.class);
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void l() {
        n3 n3Var;
        ReentrantLock reentrantLock = this.h;
        reentrantLock.lock();
        try {
            if (f() && (n3Var = this.k) != null) {
                this.b.a((n5) n3Var);
            }
            d();
            c();
            this.c.a((Object) r5.b, r5.class);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void m() {
        Job.DefaultImpls.cancel$default(this.j, (CancellationException) null, 1, (Object) null);
        this.j = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new l(this, (Continuation) null), 3, (Object) null);
    }

    public final void n() {
        ReentrantLock reentrantLock = this.h;
        reentrantLock.lock();
        try {
            f();
            n3 n3Var = this.k;
            if (n3Var != null) {
                n3Var.a(Double.valueOf(DateTimeUtils.nowInSecondsPrecise()));
                this.b.a((n5) n3Var);
                m();
                e();
                this.c.a((Object) t5.b, t5.class);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new m(n3Var), 3, (Object) null);
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void c() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) b.b, 3, (Object) null);
        try {
            Intent intent = new Intent(this.i);
            intent.putExtra("session_id", String.valueOf(this.k));
            this.e.cancel(PendingIntent.getBroadcast(this.a, 0, intent, 1073741824 | IntentUtils.getImmutablePendingIntentFlags()));
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) c.b);
        }
    }

    public final void d() {
        Job.DefaultImpls.cancel$default(this.j, (CancellationException) null, 1, (Object) null);
    }
}
