package bo.app;

import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.support.BrazeLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

public final class x4 implements o2 {
    private final j2 a;
    private final i2 b;
    private final i2 c;
    private final p1 d;
    private final l5 e;
    private final a0 f;
    private final z1 g;
    private final y0 h;
    private final g0 i;

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Request is null. Cannot execute request.";
        }
    }

    static final class b extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ x4 c;
        final /* synthetic */ a2 d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(x4 x4Var, a2 a2Var, Continuation continuation) {
            super(2, continuation);
            this.c = x4Var;
            this.d = a2Var;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new b(this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                this.c.a(this.d);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Request is null. Cannot execute request.";
        }
    }

    public x4(j2 j2Var, i2 i2Var, i2 i2Var2, p1 p1Var, l5 l5Var, a0 a0Var, z1 z1Var, y0 y0Var, g0 g0Var) {
        Intrinsics.checkNotNullParameter(j2Var, "httpConnector");
        Intrinsics.checkNotNullParameter(i2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(i2Var2, "externalEventPublisher");
        Intrinsics.checkNotNullParameter(p1Var, "feedStorageProvider");
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(a0Var, "contentCardsStorageProvider");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        Intrinsics.checkNotNullParameter(y0Var, "endpointMetadataProvider");
        Intrinsics.checkNotNullParameter(g0Var, "dataSyncPolicyProvider");
        this.a = j2Var;
        this.b = i2Var;
        this.c = i2Var2;
        this.d = p1Var;
        this.e = l5Var;
        this.f = a0Var;
        this.g = z1Var;
        this.h = y0Var;
        this.i = g0Var;
    }

    public void b(n2 n2Var) {
        Intrinsics.checkNotNullParameter(n2Var, "request");
        a2 a2Var = n2Var instanceof a2 ? (a2) n2Var : null;
        if (a2Var == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) c.b, 2, (Object) null);
        } else {
            a(a2Var);
        }
    }

    public void a(n2 n2Var) {
        n2 n2Var2 = n2Var;
        Intrinsics.checkNotNullParameter(n2Var2, "request");
        a2 a2Var = n2Var2 instanceof a2 ? (a2) n2Var2 : null;
        if (a2Var == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) a.b, 2, (Object) null);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new b(this, a2Var, (Continuation) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void a(a2 a2Var) {
        new s(a2Var, this.a, this.b, this.c, this.d, this.g, this.e, this.f, this.h, this.i).c();
    }
}
