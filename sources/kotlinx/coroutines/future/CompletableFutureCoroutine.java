package kotlinx.coroutines.future;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0018\u0012\u0006\u0012\u0004\u0018\u0001H\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00018\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u0015\u0010\u0013\u001a\u00020\u00052\u0006\u0010\f\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0014R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/future/CompletableFutureCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Ljava/util/function/BiFunction;", "", "", "context", "Lkotlin/coroutines/CoroutineContext;", "future", "Ljava/util/concurrent/CompletableFuture;", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/CompletableFuture;)V", "apply", "value", "exception", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "onCancelled", "cause", "handled", "", "onCompleted", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Future.kt */
final class CompletableFutureCoroutine<T> extends AbstractCoroutine<T> implements BiFunction<T, Throwable, Unit> {
    private final CompletableFuture<T> future;

    public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) {
        apply(obj, (Throwable) obj2);
        return Unit.INSTANCE;
    }

    public CompletableFutureCoroutine(CoroutineContext coroutineContext, CompletableFuture<T> completableFuture) {
        super(coroutineContext, true, true);
        this.future = completableFuture;
    }

    public void apply(T t, Throwable th) {
        Job.DefaultImpls.cancel$default((Job) this, (CancellationException) null, 1, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onCompleted(T t) {
        this.future.complete(t);
    }

    /* access modifiers changed from: protected */
    public void onCancelled(Throwable th, boolean z) {
        this.future.completeExceptionally(th);
    }
}
