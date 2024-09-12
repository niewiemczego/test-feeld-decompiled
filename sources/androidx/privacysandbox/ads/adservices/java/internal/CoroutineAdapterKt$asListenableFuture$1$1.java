package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoroutineAdapter.kt */
final class CoroutineAdapterKt$asListenableFuture$1$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CallbackToFutureAdapter.Completer<T> $completer;
    final /* synthetic */ Deferred<T> $this_asListenableFuture;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutineAdapterKt$asListenableFuture$1$1(CallbackToFutureAdapter.Completer<T> completer, Deferred<? extends T> deferred) {
        super(1);
        this.$completer = completer;
        this.$this_asListenableFuture = deferred;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        if (th == null) {
            this.$completer.set(this.$this_asListenableFuture.getCompleted());
        } else if (th instanceof CancellationException) {
            this.$completer.setCancelled();
        } else {
            this.$completer.setException(th);
        }
    }
}
