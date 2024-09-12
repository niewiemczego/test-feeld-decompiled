package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import bo.app.g2;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;

public final class t0 {
    public static final f f = new f((DefaultConstructorMarker) null);
    private static final long g = TimeUnit.SECONDS.toMillis(5);
    private final l5 a;
    private final i2 b;
    private final SharedPreferences c;
    private final v0 d = new v0();
    private Job e;

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cancelling ending of DUST subscription on delay and resuming stream";
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Ending DUST subscription on delay";
        }
    }

    static final class c extends SuspendLambda implements Function1 {
        int b;
        final /* synthetic */ t0 c;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Ending subscription on a delay";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(t0 t0Var, Continuation continuation) {
            super(1, continuation);
            this.c = t0Var;
        }

        /* renamed from: a */
        public final Object invoke(Continuation continuation) {
            return ((c) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Continuation continuation) {
            return new c(this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.c, (BrazeLogger.Priority) null, (Throwable) null, (Function0) a.b, 3, (Object) null);
                this.c.a();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ r3 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(r3 r3Var) {
            super(0);
            this.b = r3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Got network change event: " + this.b;
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received MITE value. Starting/resuming a new subscription";
        }
    }

    public static final class f {
        public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private f() {
        }
    }

    public /* synthetic */ class g {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[g2.b.values().length];
            try {
                iArr[g2.b.CONTENT_CARD_REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    static final class h extends Lambda implements Function0 {
        public static final h b = new h();

        h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Ending DUST subscription";
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ g2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(g2 g2Var) {
            super(0);
            this.b = g2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Ingesting DUST message\n" + this.b;
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ g2.b b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(g2.b bVar) {
            super(0);
            this.b = bVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Lacked logic to ingest message! Type: " + this.b;
        }
    }

    static final class k extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "setting mite value to " + this.b;
        }
    }

    static final class l extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ t0 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(String str, t0 t0Var) {
            super(0);
            this.b = str;
            this.c = t0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot start a dust subscription with mite " + this.b + " and enabled " + this.c.c().y();
        }
    }

    static final class m extends Lambda implements Function0 {
        final /* synthetic */ boolean b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(boolean z, String str, String str2) {
            super(0);
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Starting (resume = " + this.b + ") DUST subscription for mite: " + this.c + " to url: " + this.d;
        }
    }

    /* synthetic */ class n extends FunctionReferenceImpl implements Function1 {
        n(Object obj) {
            super(1, obj, t0.class, "ingestDustMessages", "ingestDustMessages(Lcom/braze/models/dust/IDustMessage;)V", 0);
        }

        public final void a(g2 g2Var) {
            Intrinsics.checkNotNullParameter(g2Var, "p0");
            ((t0) this.receiver).a(g2Var);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((g2) obj);
            return Unit.INSTANCE;
        }
    }

    public t0(l5 l5Var, i2 i2Var, Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(i2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = l5Var;
        this.b = i2Var;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.managers.dust.metadata" + StringUtils.getCacheFileSuffix(context, str, str2), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        this.c = sharedPreferences;
        i2Var.c(r5.class, new t0$$ExternalSyntheticLambda0(this));
        i2Var.c(t5.class, new t0$$ExternalSyntheticLambda1(this));
        i2Var.c(r3.class, new t0$$ExternalSyntheticLambda2(this));
        i2Var.c(u0.class, new t0$$ExternalSyntheticLambda3(this));
    }

    private final String b() {
        return this.c.getString("mite", (String) null);
    }

    public final l5 c() {
        return this.a;
    }

    /* access modifiers changed from: private */
    public static final void a(t0 t0Var, r5 r5Var) {
        Intrinsics.checkNotNullParameter(t0Var, "this$0");
        Intrinsics.checkNotNullParameter(r5Var, "it");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) t0Var, (BrazeLogger.Priority) null, (Throwable) null, (Function0) a.b, 3, (Object) null);
        Job job = t0Var.e;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        t0Var.a(true);
    }

    /* access modifiers changed from: private */
    public static final void a(t0 t0Var, t5 t5Var) {
        Intrinsics.checkNotNullParameter(t0Var, "this$0");
        Intrinsics.checkNotNullParameter(t5Var, "it");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) t0Var, (BrazeLogger.Priority) null, (Throwable) null, (Function0) b.b, 3, (Object) null);
        t0Var.e = BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, Long.valueOf(g), (CoroutineContext) null, new c(t0Var, (Continuation) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void a(t0 t0Var, r3 r3Var) {
        Intrinsics.checkNotNullParameter(t0Var, "this$0");
        Intrinsics.checkNotNullParameter(r3Var, "it");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) t0Var, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new d(r3Var), 3, (Object) null);
        q3 a2 = r3Var.a();
        q3 q3Var = q3.NONE;
        if (a2 == q3Var) {
            t0Var.a();
        } else if (r3Var.b() == q3Var) {
            t0Var.a(true);
        }
    }

    /* access modifiers changed from: private */
    public static final void a(t0 t0Var, u0 u0Var) {
        Intrinsics.checkNotNullParameter(t0Var, "this$0");
        Intrinsics.checkNotNullParameter(u0Var, "it");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) t0Var, (BrazeLogger.Priority) null, (Throwable) null, (Function0) e.b, 3, (Object) null);
        String b2 = t0Var.b();
        t0Var.a(u0Var.a());
        t0Var.a(Intrinsics.areEqual((Object) b2, (Object) u0Var.a()));
    }

    private final void a(String str) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new k(str), 3, (Object) null);
        this.c.edit().putString("mite", str).apply();
    }

    private final void a(boolean z) {
        String b2 = b();
        if (b2 == null || !this.a.y()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new l(b2, this), 3, (Object) null);
            return;
        }
        String str = "https://dust.k8s.test-001.d-usw-2.braze.com/sse?mite=" + b2;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new m(z, b2, str), 3, (Object) null);
        this.d.a(str, (Function1) new n(this), z);
    }

    public final void a() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) h.b, 3, (Object) null);
        this.d.b();
    }

    /* access modifiers changed from: private */
    public final void a(g2 g2Var) {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new i(g2Var), 3, (Object) null);
        g2.b a2 = g2Var.a();
        if (g.a[a2.ordinal()] == 1) {
            this.b.a((Object) new v(), v.class);
            return;
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new j(a2), 2, (Object) null);
    }
}
