package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BufferedChannel.kt */
/* synthetic */ class BufferedChannelKt$createSegmentFunction$1 extends FunctionReferenceImpl implements Function2<Long, ChannelSegment<E>, ChannelSegment<E>> {
    public static final BufferedChannelKt$createSegmentFunction$1 INSTANCE = new BufferedChannelKt$createSegmentFunction$1();

    BufferedChannelKt$createSegmentFunction$1() {
        super(2, BufferedChannelKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).longValue(), (ChannelSegment) obj2);
    }

    public final ChannelSegment<E> invoke(long j, ChannelSegment<E> channelSegment) {
        return BufferedChannelKt.createSegment(j, channelSegment);
    }
}
