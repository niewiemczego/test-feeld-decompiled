package kotlinx.coroutines.channels;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\"\b\u0002\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u000f\u001a\u00020\t2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0019\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0015J\r\u0010\u0018\u001a\u00020\rH\u0010¢\u0006\u0002\b\u0019J&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ.\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!J&\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u0000H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b#\u0010\u001dJ.\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8TX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "E", "Lkotlinx/coroutines/channels/BufferedChannel;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "isConflatedDropOldest", "", "()Z", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "element", "", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "shouldSendSuspend", "shouldSendSuspend$kotlinx_coroutines_core", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySendDropLatest", "isSendOp", "trySendDropLatest-Mj0NB7M", "(Ljava/lang/Object;Z)Ljava/lang/Object;", "trySendDropOldest", "trySendDropOldest-JP2dKIU", "trySendImpl", "trySendImpl-Mj0NB7M", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ConflatedBufferedChannel.kt */
public class ConflatedBufferedChannel<E> extends BufferedChannel<E> {
    private final int capacity;
    private final BufferOverflow onBufferOverflow;

    public Object send(E e, Continuation<? super Unit> continuation) {
        return send$suspendImpl(this, e, continuation);
    }

    public Object sendBroadcast$kotlinx_coroutines_core(E e, Continuation<? super Boolean> continuation) {
        return sendBroadcast$suspendImpl(this, e, continuation);
    }

    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConflatedBufferedChannel(int i, BufferOverflow bufferOverflow, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, bufferOverflow, (i2 & 4) != 0 ? null : function1);
    }

    public ConflatedBufferedChannel(int i, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        super(i, function1);
        this.capacity = i;
        this.onBufferOverflow = bufferOverflow;
        boolean z = false;
        if (bufferOverflow != BufferOverflow.SUSPEND) {
            if (!(i >= 1 ? true : z)) {
                throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i + " was specified").toString());
            }
            return;
        }
        throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName() + " instead").toString());
    }

    /* access modifiers changed from: protected */
    public boolean isConflatedDropOldest() {
        return this.onBufferOverflow == BufferOverflow.DROP_OLDEST;
    }

    static /* synthetic */ <E> Object send$suspendImpl(ConflatedBufferedChannel<E> conflatedBufferedChannel, E e, Continuation<? super Unit> continuation) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        Object r4 = conflatedBufferedChannel.m2541trySendImplMj0NB7M(e, true);
        if (!(r4 instanceof ChannelResult.Closed)) {
            return Unit.INSTANCE;
        }
        ChannelResult.m2526exceptionOrNullimpl(r4);
        Function1 function1 = conflatedBufferedChannel.onUndeliveredElement;
        if (function1 == null || (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, (UndeliveredElementException) null, 2, (Object) null)) == null) {
            throw conflatedBufferedChannel.getSendException();
        }
        ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException$default, conflatedBufferedChannel.getSendException());
        throw callUndeliveredElementCatchingException$default;
    }

    static /* synthetic */ <E> Object sendBroadcast$suspendImpl(ConflatedBufferedChannel<E> conflatedBufferedChannel, E e, Continuation<? super Boolean> continuation) {
        Object r0 = conflatedBufferedChannel.m2541trySendImplMj0NB7M(e, true);
        if (r0 instanceof ChannelResult.Failed) {
            return Boxing.boxBoolean(false);
        }
        Unit unit = (Unit) r0;
        return Boxing.boxBoolean(true);
    }

    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    public Object m2542trySendJP2dKIU(E e) {
        return m2541trySendImplMj0NB7M(e, false);
    }

    /* renamed from: trySendImpl-Mj0NB7M  reason: not valid java name */
    private final Object m2541trySendImplMj0NB7M(E e, boolean z) {
        if (this.onBufferOverflow == BufferOverflow.DROP_LATEST) {
            return m2539trySendDropLatestMj0NB7M(e, z);
        }
        return m2540trySendDropOldestJP2dKIU(e);
    }

    /* renamed from: trySendDropLatest-Mj0NB7M  reason: not valid java name */
    private final Object m2539trySendDropLatestMj0NB7M(E e, boolean z) {
        Function1 function1;
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        Object r0 = super.m2514trySendJP2dKIU(e);
        if (ChannelResult.m2532isSuccessimpl(r0) || ChannelResult.m2530isClosedimpl(r0)) {
            return r0;
        }
        if (!z || (function1 = this.onUndeliveredElement) == null || (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, (UndeliveredElementException) null, 2, (Object) null)) == null) {
            return ChannelResult.Companion.m2537successJP2dKIU(Unit.INSTANCE);
        }
        throw callUndeliveredElementCatchingException$default;
    }

    /* renamed from: trySendDropOldest-JP2dKIU  reason: not valid java name */
    private final Object m2540trySendDropOldestJP2dKIU(E e) {
        ChannelSegment channelSegment;
        Symbol symbol = BufferedChannelKt.BUFFERED;
        BufferedChannel bufferedChannel = this;
        ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.sendSegment$FU.get(bufferedChannel);
        while (true) {
            long andIncrement = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement(bufferedChannel);
            long j = andIncrement & 1152921504606846975L;
            boolean access$isClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
            long j2 = j / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (j % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j2) {
                ChannelSegment access$findSegmentSend = bufferedChannel.findSegmentSend(j2, channelSegment2);
                if (access$findSegmentSend != null) {
                    channelSegment = access$findSegmentSend;
                } else if (access$isClosedForSend0) {
                    return ChannelResult.Companion.m2535closedJP2dKIU(getSendException());
                }
            } else {
                channelSegment = channelSegment2;
            }
            int access$updateCellSend = bufferedChannel.updateCellSend(channelSegment, i, e, j, symbol, access$isClosedForSend0);
            if (access$updateCellSend == 0) {
                channelSegment.cleanPrev();
                return ChannelResult.Companion.m2537successJP2dKIU(Unit.INSTANCE);
            } else if (access$updateCellSend == 1) {
                return ChannelResult.Companion.m2537successJP2dKIU(Unit.INSTANCE);
            } else {
                if (access$updateCellSend != 2) {
                    if (access$updateCellSend == 3) {
                        throw new IllegalStateException("unexpected".toString());
                    } else if (access$updateCellSend != 4) {
                        if (access$updateCellSend == 5) {
                            channelSegment.cleanPrev();
                        }
                        channelSegment2 = channelSegment;
                    } else {
                        if (j < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        return ChannelResult.Companion.m2535closedJP2dKIU(getSendException());
                    }
                } else if (access$isClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    return ChannelResult.Companion.m2535closedJP2dKIU(getSendException());
                } else {
                    Waiter waiter = symbol instanceof Waiter ? (Waiter) symbol : null;
                    if (waiter != null) {
                        bufferedChannel.prepareSenderForSuspension(waiter, channelSegment, i);
                    }
                    dropFirstElementUntilTheSpecifiedCellIsInTheBuffer((channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i));
                    return ChannelResult.Companion.m2537successJP2dKIU(Unit.INSTANCE);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void registerSelectForSend(SelectInstance<?> selectInstance, Object obj) {
        Object r3 = m2542trySendJP2dKIU(obj);
        if (!(r3 instanceof ChannelResult.Failed)) {
            Unit unit = (Unit) r3;
            selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
        } else if (r3 instanceof ChannelResult.Closed) {
            ChannelResult.m2526exceptionOrNullimpl(r3);
            selectInstance.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
        } else {
            throw new IllegalStateException("unreachable".toString());
        }
    }
}
