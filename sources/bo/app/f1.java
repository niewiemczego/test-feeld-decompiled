package bo.app;

import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.support.BrazeLogger;
import com.oblador.keychain.KeychainModule;
import java.util.Collection;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
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

public final class f1 implements y1 {
    /* access modifiers changed from: private */
    public final y1 a;
    private final i2 b;
    private boolean c;

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ f1 b;
        final /* synthetic */ x1 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(f1 f1Var, x1 x1Var) {
            super(0);
            this.b = f1Var;
            this.c = x1Var;
        }

        public final void a() {
            this.b.a.a(this.c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Storage provider is closed. Not getting all events.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get all events from storage.";
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ f1 b;
        final /* synthetic */ Set c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(f1 f1Var, Set set) {
            super(0);
            this.b = f1Var;
            this.c = set;
        }

        public final void a() {
            this.b.a.a(this.c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Storage provider is closed. Failed to " + this.b;
        }
    }

    static final class f extends SuspendLambda implements Function2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ Function0 d;
        final /* synthetic */ f1 e;
        final /* synthetic */ String f;

        static final class a extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to " + this.b;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(Function0 function0, f1 f1Var, String str, Continuation continuation) {
            super(2, continuation);
            this.d = function0;
            this.e = f1Var;
            this.f = str;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            f fVar = new f(this.d, this.e, this.f, continuation);
            fVar.c = obj;
            return fVar;
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.c;
                try {
                    this.d.invoke();
                } catch (Exception e2) {
                    BrazeLogger.INSTANCE.brazelog((Object) coroutineScope, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new a(this.f));
                    this.e.a((Throwable) e2);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class g extends Lambda implements Function0 {
        public static final g b = new g();

        g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log storage exception";
        }
    }

    public f1(y1 y1Var, i2 i2Var) {
        Intrinsics.checkNotNullParameter(y1Var, KeychainModule.Maps.STORAGE);
        Intrinsics.checkNotNullParameter(i2Var, "eventPublisher");
        this.a = y1Var;
        this.b = i2Var;
    }

    public void close() {
        this.c = true;
    }

    public Collection a() {
        if (this.c) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
            return SetsKt.emptySet();
        }
        try {
            return this.a.a();
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) c.b);
            a((Throwable) e2);
            return SetsKt.emptySet();
        }
    }

    public void a(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "event");
        a("add event " + x1Var, (Function0) new a(this, x1Var));
    }

    public void a(Set set) {
        Intrinsics.checkNotNullParameter(set, "events");
        a("delete events " + set, (Function0) new d(this, set));
    }

    /* access modifiers changed from: private */
    public final void a(Throwable th) {
        try {
            this.b.a((Object) new w5("A storage exception has occurred!", th), w5.class);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) g.b);
        }
    }

    private final void a(String str, Function0 function0) {
        String str2 = str;
        if (this.c) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new e(str), 2, (Object) null);
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new f(function0, this, str, (Continuation) null), 3, (Object) null);
    }
}
