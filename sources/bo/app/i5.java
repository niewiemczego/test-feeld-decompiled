package bo.app;

import com.braze.support.BrazeLogger;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

public final class i5 implements CoroutineScope {
    public static final i5 a = new i5();
    private static e1 b;
    private static final CoroutineExceptionHandler c;
    private static final ExecutorCoroutineDispatcher d;
    private static final CoroutineContext e;

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cancelling children of SerialCoroutineScope";
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ Throwable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Throwable th) {
            super(0);
            this.b = th;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Child job of SerialCoroutineScope got exception: " + this.b;
        }
    }

    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.Key key) {
            super(key);
        }

        public void handleException(CoroutineContext coroutineContext, Throwable th) {
            try {
                BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                i5 i5Var = i5.a;
                brazeLogger.brazelog((Object) i5Var, BrazeLogger.Priority.E, th, (Function0<String>) new b(th));
                e1 b = i5Var.b();
                if (b != null) {
                    b.a((Object) th, Throwable.class);
                }
            } catch (Exception unused) {
            }
        }
    }

    static {
        c cVar = new c(CoroutineExceptionHandler.Key);
        c = cVar;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        ExecutorCoroutineDispatcher from = ExecutorsKt.from(newSingleThreadExecutor);
        d = from;
        e = from.plus(cVar).plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));
    }

    private i5() {
    }

    public final void a(e1 e1Var) {
        b = e1Var;
    }

    public final e1 b() {
        return b;
    }

    public CoroutineContext getCoroutineContext() {
        return e;
    }

    public final void a() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) a.b, 2, (Object) null);
        JobKt__JobKt.cancelChildren$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }
}
