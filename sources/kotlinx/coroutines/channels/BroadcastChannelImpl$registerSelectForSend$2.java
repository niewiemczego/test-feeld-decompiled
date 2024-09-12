package kotlinx.coroutines.channels;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2", f = "BroadcastChannel.kt", i = {}, l = {291}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BroadcastChannel.kt */
final class BroadcastChannelImpl$registerSelectForSend$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $element;
    final /* synthetic */ SelectInstance<?> $select;
    int label;
    final /* synthetic */ BroadcastChannelImpl<E> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BroadcastChannelImpl$registerSelectForSend$2(BroadcastChannelImpl<E> broadcastChannelImpl, Object obj, SelectInstance<?> selectInstance, Continuation<? super BroadcastChannelImpl$registerSelectForSend$2> continuation) {
        super(2, continuation);
        this.this$0 = broadcastChannelImpl;
        this.$element = obj;
        this.$select = selectInstance;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BroadcastChannelImpl$registerSelectForSend$2(this.this$0, this.$element, this.$select, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BroadcastChannelImpl$registerSelectForSend$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z2 = false;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.send(this.$element, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                if (!this.this$0.isClosedForSend() || (!(th instanceof ClosedSendChannelException) && this.this$0.getSendException() != th)) {
                    throw th;
                }
                z = false;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        z = true;
        ReentrantLock access$getLock$p = this.this$0.lock;
        BroadcastChannelImpl<E> broadcastChannelImpl = this.this$0;
        SelectInstance<?> selectInstance = this.$select;
        Lock lock = access$getLock$p;
        lock.lock();
        try {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (broadcastChannelImpl.onSendInternalResult.get(selectInstance) == null) {
                    z2 = true;
                }
                if (!z2) {
                    throw new AssertionError();
                }
            }
            broadcastChannelImpl.onSendInternalResult.put(selectInstance, z ? Unit.INSTANCE : BufferedChannelKt.getCHANNEL_CLOSED());
            Intrinsics.checkNotNull(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            SelectImplementation selectImplementation = (SelectImplementation) selectInstance;
            if (((SelectImplementation) selectInstance).trySelectDetailed(broadcastChannelImpl, Unit.INSTANCE) != TrySelectDetailedResult.REREGISTER) {
                broadcastChannelImpl.onSendInternalResult.remove(selectInstance);
            }
            Unit unit = Unit.INSTANCE;
            lock.unlock();
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            lock.unlock();
            throw th2;
        }
    }
}
