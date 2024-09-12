package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "", "", "<anonymous parameter 0>", "Lkotlinx/coroutines/selects/SelectInstance;", "owner", "", "<anonymous parameter 2>", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Mutex.kt */
final class MutexImpl$onSelectCancellationUnlockConstructor$1 extends Lambda implements Function3<SelectInstance<?>, Object, Object, Function1<? super Throwable, ? extends Unit>> {
    final /* synthetic */ MutexImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MutexImpl$onSelectCancellationUnlockConstructor$1(MutexImpl mutexImpl) {
        super(3);
        this.this$0 = mutexImpl;
    }

    public final Function1<Throwable, Unit> invoke(SelectInstance<?> selectInstance, final Object obj, Object obj2) {
        final MutexImpl mutexImpl = this.this$0;
        return new Function1<Throwable, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                mutexImpl.unlock(obj);
            }
        };
    }
}
