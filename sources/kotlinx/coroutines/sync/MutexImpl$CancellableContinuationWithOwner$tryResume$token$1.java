package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.sync.MutexImpl;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Mutex.kt */
final class MutexImpl$CancellableContinuationWithOwner$tryResume$token$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ MutexImpl this$0;
    final /* synthetic */ MutexImpl.CancellableContinuationWithOwner this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MutexImpl$CancellableContinuationWithOwner$tryResume$token$1(MutexImpl mutexImpl, MutexImpl.CancellableContinuationWithOwner cancellableContinuationWithOwner) {
        super(1);
        this.this$0 = mutexImpl;
        this.this$1 = cancellableContinuationWithOwner;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        MutexImpl mutexImpl = this.this$0;
        MutexImpl.CancellableContinuationWithOwner cancellableContinuationWithOwner = this.this$1;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            Object obj = MutexImpl.owner$FU.get(mutexImpl);
            if (!(obj == MutexKt.NO_OWNER || obj == cancellableContinuationWithOwner.owner)) {
                throw new AssertionError();
            }
        }
        MutexImpl.owner$FU.set(this.this$0, this.this$1.owner);
        this.this$0.unlock(this.this$1.owner);
    }
}
