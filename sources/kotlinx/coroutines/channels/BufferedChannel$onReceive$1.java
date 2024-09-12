package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BufferedChannel.kt */
/* synthetic */ class BufferedChannel$onReceive$1 extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, SelectInstance<?>, Object, Unit> {
    public static final BufferedChannel$onReceive$1 INSTANCE = new BufferedChannel$onReceive$1();

    BufferedChannel$onReceive$1() {
        super(3, BufferedChannel.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BufferedChannel<?>) (BufferedChannel) obj, (SelectInstance<?>) (SelectInstance) obj2, obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(BufferedChannel<?> bufferedChannel, SelectInstance<?> selectInstance, Object obj) {
        bufferedChannel.registerSelectForReceive(selectInstance, obj);
    }
}
