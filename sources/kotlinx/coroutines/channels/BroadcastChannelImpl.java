package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u000245B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!H\u0010¢\u0006\u0002\b\"J\u0012\u0010#\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u001e\u0010&\u001a\u00020'2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030\u00132\b\u0010)\u001a\u0004\u0018\u00010\rH\u0014J\u0016\u0010*\u001a\u00020'2\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0002J\u0019\u0010,\u001a\u00020'2\u0006\u0010)\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020/H\u0016J&\u00100\u001a\b\u0012\u0004\u0012\u00020'012\u0006\u0010)\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010X\u0004¢\u0006\u0002\n\u0000R6\u0010\u0011\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r`\u0014X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\u0004\u0018\u00018\u00008F¢\u0006\f\u0012\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl;", "E", "Lkotlinx/coroutines/channels/BufferedChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "capacity", "", "(I)V", "getCapacity", "()I", "isClosedForSend", "", "()Z", "lastConflatedElement", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "onSendInternalResult", "Ljava/util/HashMap;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/collections/HashMap;", "subscribers", "", "value", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "valueOrNull", "getValueOrNull$annotations", "getValueOrNull", "cancelImpl", "cause", "", "cancelImpl$kotlinx_coroutines_core", "close", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "registerSelectForSend", "", "select", "element", "removeSubscriber", "s", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "SubscriberBuffered", "SubscriberConflated", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BroadcastChannel.kt */
public final class BroadcastChannelImpl<E> extends BufferedChannel<E> implements BroadcastChannel<E> {
    private final int capacity;
    private Object lastConflatedElement;
    /* access modifiers changed from: private */
    public final ReentrantLock lock;
    /* access modifiers changed from: private */
    public final HashMap<SelectInstance<?>, Object> onSendInternalResult;
    private List<? extends BufferedChannel<E>> subscribers;

    public static /* synthetic */ void getValue$annotations() {
    }

    public static /* synthetic */ void getValueOrNull$annotations() {
    }

    public final int getCapacity() {
        return this.capacity;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BroadcastChannelImpl(int i) {
        super(0, (Function1) null);
        boolean z = false;
        this.capacity = i;
        if ((i >= 1 || i == -1) ? true : z) {
            this.lock = new ReentrantLock();
            this.subscribers = CollectionsKt.emptyList();
            this.lastConflatedElement = BroadcastChannelKt.NO_ELEMENT;
            this.onSendInternalResult = new HashMap<>();
            return;
        }
        throw new IllegalArgumentException(("BroadcastChannel capacity must be positive or Channel.CONFLATED, but " + i + " was specified").toString());
    }

    public ReceiveChannel<E> openSubscription() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            BufferedChannel subscriberConflated = this.capacity == -1 ? new SubscriberConflated() : new SubscriberBuffered();
            if (!isClosedForSend() || this.lastConflatedElement != BroadcastChannelKt.NO_ELEMENT) {
                if (this.lastConflatedElement != BroadcastChannelKt.NO_ELEMENT) {
                    subscriberConflated.m2514trySendJP2dKIU(getValue());
                }
                this.subscribers = CollectionsKt.plus(this.subscribers, subscriberConflated);
                lock2.unlock();
                return subscriberConflated;
            }
            subscriberConflated.close(getCloseCause());
            return subscriberConflated;
        } finally {
            lock2.unlock();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: kotlinx.coroutines.channels.BufferedChannel} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void removeSubscriber(kotlinx.coroutines.channels.ReceiveChannel<? extends E> r6) {
        /*
            r5 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r5.lock
            java.util.concurrent.locks.Lock r0 = (java.util.concurrent.locks.Lock) r0
            r0.lock()
            java.util.List<? extends kotlinx.coroutines.channels.BufferedChannel<E>> r1 = r5.subscribers     // Catch:{ all -> 0x0038 }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ all -> 0x0038 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0038 }
            r2.<init>()     // Catch:{ all -> 0x0038 }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x0038 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0038 }
        L_0x0016:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0038 }
            if (r3 == 0) goto L_0x002e
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0038 }
            r4 = r3
            kotlinx.coroutines.channels.BufferedChannel r4 = (kotlinx.coroutines.channels.BufferedChannel) r4     // Catch:{ all -> 0x0038 }
            if (r4 == r6) goto L_0x0027
            r4 = 1
            goto L_0x0028
        L_0x0027:
            r4 = 0
        L_0x0028:
            if (r4 == 0) goto L_0x0016
            r2.add(r3)     // Catch:{ all -> 0x0038 }
            goto L_0x0016
        L_0x002e:
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x0038 }
            r5.subscribers = r2     // Catch:{ all -> 0x0038 }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0038 }
            r0.unlock()
            return
        L_0x0038:
            r6 = move-exception
            r0.unlock()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastChannelImpl.removeSubscriber(kotlinx.coroutines.channels.ReceiveChannel):void");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object send(E r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.BroadcastChannelImpl$send$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 r0 = (kotlinx.coroutines.channels.BroadcastChannelImpl$send$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 r0 = new kotlinx.coroutines.channels.BroadcastChannelImpl$send$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$1
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.channels.BroadcastChannelImpl r4 = (kotlinx.coroutines.channels.BroadcastChannelImpl) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0080
        L_0x0034:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.concurrent.locks.ReentrantLock r8 = r6.lock
            java.util.concurrent.locks.Lock r8 = (java.util.concurrent.locks.Lock) r8
            r8.lock()
            boolean r2 = r6.isClosedForSend()     // Catch:{ all -> 0x009e }
            if (r2 != 0) goto L_0x0099
            int r2 = r6.capacity     // Catch:{ all -> 0x009e }
            r4 = -1
            if (r2 != r4) goto L_0x0053
            r6.lastConflatedElement = r7     // Catch:{ all -> 0x009e }
        L_0x0053:
            java.util.List<? extends kotlinx.coroutines.channels.BufferedChannel<E>> r2 = r6.subscribers     // Catch:{ all -> 0x009e }
            r8.unlock()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r8 = r2.iterator()
            r4 = r6
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x0062:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L_0x0096
            java.lang.Object r2 = r7.next()
            kotlinx.coroutines.channels.BufferedChannel r2 = (kotlinx.coroutines.channels.BufferedChannel) r2
            r0.L$0 = r4
            r0.L$1 = r8
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r2 = r2.sendBroadcast$kotlinx_coroutines_core(r8, r0)
            if (r2 != r1) goto L_0x007d
            return r1
        L_0x007d:
            r5 = r2
            r2 = r8
            r8 = r5
        L_0x0080:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x0094
            boolean r8 = r4.isClosedForSend()
            if (r8 != 0) goto L_0x008f
            goto L_0x0094
        L_0x008f:
            java.lang.Throwable r7 = r4.getSendException()
            throw r7
        L_0x0094:
            r8 = r2
            goto L_0x0062
        L_0x0096:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0099:
            java.lang.Throwable r7 = r6.getSendException()     // Catch:{ all -> 0x009e }
            throw r7     // Catch:{ all -> 0x009e }
        L_0x009e:
            r7 = move-exception
            r8.unlock()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastChannelImpl.send(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    public Object m2507trySendJP2dKIU(E e) {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            if (isClosedForSend()) {
                return super.m2514trySendJP2dKIU(e);
            }
            Iterable iterable = this.subscribers;
            boolean z = false;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((BufferedChannel) it.next()).shouldSendSuspend$kotlinx_coroutines_core()) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z) {
                Object r5 = ChannelResult.Companion.m2536failurePtdJZtk();
                lock2.unlock();
                return r5;
            }
            if (this.capacity == -1) {
                this.lastConflatedElement = e;
            }
            for (BufferedChannel r2 : this.subscribers) {
                r2.m2514trySendJP2dKIU(e);
            }
            Object r52 = ChannelResult.Companion.m2537successJP2dKIU(Unit.INSTANCE);
            lock2.unlock();
            return r52;
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public void registerSelectForSend(SelectInstance<?> selectInstance, Object obj) {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            Object remove = this.onSendInternalResult.remove(selectInstance);
            if (remove != null) {
                selectInstance.selectInRegistrationPhase(remove);
                return;
            }
            Unit unit = Unit.INSTANCE;
            lock2.unlock();
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(selectInstance.getContext()), (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new BroadcastChannelImpl$registerSelectForSend$2(this, obj, selectInstance, (Continuation<? super BroadcastChannelImpl$registerSelectForSend$2>) null), 1, (Object) null);
        } finally {
            lock2.unlock();
        }
    }

    public boolean close(Throwable th) {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            for (BufferedChannel close : this.subscribers) {
                close.close(th);
            }
            Collection arrayList = new ArrayList();
            for (Object next : this.subscribers) {
                if (((BufferedChannel) next).hasElements$kotlinx_coroutines_core()) {
                    arrayList.add(next);
                }
            }
            this.subscribers = (List) arrayList;
            return super.close(th);
        } finally {
            lock2.unlock();
        }
    }

    public boolean cancelImpl$kotlinx_coroutines_core(Throwable th) {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            for (BufferedChannel cancelImpl$kotlinx_coroutines_core : this.subscribers) {
                cancelImpl$kotlinx_coroutines_core.cancelImpl$kotlinx_coroutines_core(th);
            }
            this.lastConflatedElement = BroadcastChannelKt.NO_ELEMENT;
            return super.cancelImpl$kotlinx_coroutines_core(th);
        } finally {
            lock2.unlock();
        }
    }

    public boolean isClosedForSend() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            return super.isClosedForSend();
        } finally {
            lock2.unlock();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered;", "Lkotlinx/coroutines/channels/BufferedChannel;", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "cancelImpl", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BroadcastChannel.kt */
    private final class SubscriberBuffered extends BufferedChannel<E> {
        public SubscriberBuffered() {
            super(BroadcastChannelImpl.this.getCapacity(), (Function1) null, 2, (DefaultConstructorMarker) null);
        }

        /* renamed from: cancelImpl */
        public boolean cancelImpl$kotlinx_coroutines_core(Throwable th) {
            ReentrantLock access$getLock$p = BroadcastChannelImpl.this.lock;
            BroadcastChannelImpl<E> broadcastChannelImpl = BroadcastChannelImpl.this;
            Lock lock = access$getLock$p;
            lock.lock();
            try {
                broadcastChannelImpl.removeSubscriber(this);
                return super.cancelImpl$kotlinx_coroutines_core(th);
            } finally {
                lock.unlock();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberConflated;", "Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "cancelImpl", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BroadcastChannel.kt */
    private final class SubscriberConflated extends ConflatedBufferedChannel<E> {
        public SubscriberConflated() {
            super(1, BufferOverflow.DROP_OLDEST, (Function1) null, 4, (DefaultConstructorMarker) null);
        }

        /* renamed from: cancelImpl */
        public boolean cancelImpl$kotlinx_coroutines_core(Throwable th) {
            BroadcastChannelImpl.this.removeSubscriber(this);
            return super.cancelImpl$kotlinx_coroutines_core(th);
        }
    }

    public final E getValue() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            if (isClosedForSend()) {
                Throwable closeCause = getCloseCause();
                if (closeCause == null) {
                    closeCause = new IllegalStateException("This broadcast channel is closed");
                }
                throw closeCause;
            } else if (this.lastConflatedElement != BroadcastChannelKt.NO_ELEMENT) {
                return this.lastConflatedElement;
            } else {
                throw new IllegalStateException("No value".toString());
            }
        } finally {
            lock2.unlock();
        }
    }

    public final E getValueOrNull() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            E e = null;
            if (!isClosedForReceive()) {
                if (this.lastConflatedElement != BroadcastChannelKt.NO_ELEMENT) {
                    e = this.lastConflatedElement;
                }
            }
            return e;
        } finally {
            lock2.unlock();
        }
    }

    public String toString() {
        return (this.lastConflatedElement != BroadcastChannelKt.NO_ELEMENT ? "CONFLATED_ELEMENT=" + this.lastConflatedElement + "; " : "") + "BROADCAST=<" + super.toString() + ">; SUBSCRIBERS=" + CollectionsKt.joinToString$default(this.subscribers, ";", "<", ">", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }
}
