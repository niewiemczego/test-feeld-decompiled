package bo.app;

import com.braze.support.BrazeLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

public abstract class a {
    /* access modifiers changed from: private */
    public final Semaphore a = SemaphoreKt.Semaphore$default(1, 0, 2, (Object) null);

    /* renamed from: bo.app.a$a  reason: collision with other inner class name */
    static final class C0001a extends Lambda implements Function0 {
        final /* synthetic */ Object b;
        final /* synthetic */ boolean c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0001a(Object obj, boolean z) {
            super(0);
            this.b = obj;
            this.c = z;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Tried to confirm outboundObject [" + this.b + "] with success [" + this.c + "], but the cache wasn't locked, so not doing anything.";
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ a b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(0);
            this.b = aVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Notifying confirmAndUnlock listeners for cache: " + this.b;
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ a b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(0);
            this.b = aVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cache locked successfully for export: " + this.b;
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received call to export dirty object, but the cache was already locked.";
        }
    }

    static final class e extends SuspendLambda implements Function2 {
        Object b;
        int c;
        final /* synthetic */ a d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a aVar, Continuation continuation) {
            super(2, continuation);
            this.d = aVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new e(this.d, continuation);
        }

        /* JADX INFO: finally extract failed */
        public final Object invokeSuspend(Object obj) {
            Semaphore semaphore;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Semaphore a = this.d.a;
                this.b = a;
                this.c = 1;
                if (a.acquire(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                semaphore = a;
            } else if (i == 1) {
                semaphore = (Semaphore) this.b;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                Unit unit = Unit.INSTANCE;
                semaphore.release();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                semaphore.release();
                throw th;
            }
        }
    }

    public abstract void b(Object obj, boolean z);

    public final boolean b() {
        return this.a.getAvailablePermits() == 0;
    }

    public final void c() {
        Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new e(this, (Continuation) null), 1, (Object) null);
    }

    public abstract Object d();

    public final synchronized Object a() {
        Object obj;
        if (this.a.tryAcquire()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new c(this), 3, (Object) null);
            obj = d();
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) d.b, 3, (Object) null);
            obj = null;
        }
        return obj;
    }

    public final synchronized boolean a(Object obj, boolean z) {
        if (this.a.getAvailablePermits() != 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new C0001a(obj, z), 2, (Object) null);
            return false;
        }
        b(obj, z);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new b(this), 2, (Object) null);
        this.a.release();
        return true;
    }
}
