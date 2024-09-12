package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLog;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public class PriorityNetworkFetcher<FETCH_STATE extends FetchState> implements NetworkFetcher<PriorityFetchState<FETCH_STATE>> {
    static final int INFINITE_REQUEUE = -1;
    static final int NO_DELAYED_REQUESTS = -1;
    public static final String TAG = "PriorityNetworkFetcher";
    /* access modifiers changed from: private */
    public final boolean doNotCancelRequests;
    private long firstDelayedRequestEnqueuedTimeStamp;
    private final int immediateRequeueCount;
    /* access modifiers changed from: private */
    public final boolean inflightFetchesCanBeCancelled;
    private volatile boolean isRunning;
    private final MonotonicClock mClock;
    /* access modifiers changed from: private */
    public final HashSet<PriorityFetchState<FETCH_STATE>> mCurrentlyFetching;
    private final LinkedList<PriorityFetchState<FETCH_STATE>> mDelayedQueue;
    private final NetworkFetcher<FETCH_STATE> mDelegate;
    private final LinkedList<PriorityFetchState<FETCH_STATE>> mHiPriQueue;
    private final boolean mIsHiPriFifo;
    private final Object mLock;
    private final LinkedList<PriorityFetchState<FETCH_STATE>> mLowPriQueue;
    private final int mMaxOutstandingHiPri;
    private final int mMaxOutstandingLowPri;
    /* access modifiers changed from: private */
    public final int maxNumberOfRequeue;
    private final boolean multipleDequeue;
    private final long requeueDelayTimeInMillis;

    public PriorityNetworkFetcher(NetworkFetcher<FETCH_STATE> networkFetcher, boolean z, int i, int i2, boolean z2, int i3, boolean z3, int i4, int i5, boolean z4) {
        this(networkFetcher, z, i, i2, z2, i3, z3, i4, i5, z4, RealtimeSinceBootClock.get());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PriorityNetworkFetcher(NetworkFetcher<FETCH_STATE> networkFetcher, boolean z, int i, int i2, boolean z2, boolean z3, boolean z4) {
        this(networkFetcher, z, i, i2, z2, z3 ? -1 : 0, z4, -1, 0, false, RealtimeSinceBootClock.get());
    }

    public PriorityNetworkFetcher(NetworkFetcher<FETCH_STATE> networkFetcher, boolean z, int i, int i2, boolean z2, int i3, boolean z3, int i4, int i5, boolean z4, MonotonicClock monotonicClock) {
        this.mLock = new Object();
        this.mHiPriQueue = new LinkedList<>();
        this.mLowPriQueue = new LinkedList<>();
        this.mCurrentlyFetching = new HashSet<>();
        this.mDelayedQueue = new LinkedList<>();
        this.isRunning = true;
        this.mDelegate = networkFetcher;
        this.mIsHiPriFifo = z;
        this.mMaxOutstandingHiPri = i;
        this.mMaxOutstandingLowPri = i2;
        if (i > i2) {
            this.inflightFetchesCanBeCancelled = z2;
            this.maxNumberOfRequeue = i3;
            this.doNotCancelRequests = z3;
            this.immediateRequeueCount = i4;
            this.requeueDelayTimeInMillis = (long) i5;
            this.multipleDequeue = z4;
            this.mClock = monotonicClock;
            return;
        }
        throw new IllegalArgumentException("maxOutstandingHiPri should be > maxOutstandingLowPri");
    }

    public void pause() {
        this.isRunning = false;
    }

    public void resume() {
        this.isRunning = true;
        dequeueIfAvailableSlots();
    }

    public void fetch(final PriorityFetchState<FETCH_STATE> priorityFetchState, final NetworkFetcher.Callback callback) {
        priorityFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() {
            public void onCancellationRequested() {
                if (!PriorityNetworkFetcher.this.doNotCancelRequests) {
                    if (PriorityNetworkFetcher.this.inflightFetchesCanBeCancelled || !PriorityNetworkFetcher.this.mCurrentlyFetching.contains(priorityFetchState)) {
                        PriorityNetworkFetcher.this.removeFromQueue(priorityFetchState, "CANCEL");
                        callback.onCancellation();
                    }
                }
            }

            public void onPriorityChanged() {
                PriorityNetworkFetcher priorityNetworkFetcher = PriorityNetworkFetcher.this;
                PriorityFetchState priorityFetchState = priorityFetchState;
                priorityNetworkFetcher.changePriority(priorityFetchState, priorityFetchState.getContext().getPriority() == Priority.HIGH);
            }
        });
        synchronized (this.mLock) {
            if (this.mCurrentlyFetching.contains(priorityFetchState)) {
                FLog.e(TAG, "fetch state was enqueued twice: " + priorityFetchState);
                return;
            }
            boolean z = priorityFetchState.getContext().getPriority() == Priority.HIGH;
            FLog.v(TAG, "enqueue: %s %s", (Object) z ? "HI-PRI" : "LOW-PRI", (Object) priorityFetchState.getUri());
            priorityFetchState.callback = callback;
            putInQueue(priorityFetchState, z);
            dequeueIfAvailableSlots();
        }
    }

    public void onFetchCompletion(PriorityFetchState<FETCH_STATE> priorityFetchState, int i) {
        removeFromQueue(priorityFetchState, "SUCCESS");
        this.mDelegate.onFetchCompletion(priorityFetchState.delegatedState, i);
    }

    /* access modifiers changed from: private */
    public void removeFromQueue(PriorityFetchState<FETCH_STATE> priorityFetchState, String str) {
        synchronized (this.mLock) {
            FLog.v(TAG, "remove: %s %s", (Object) str, (Object) priorityFetchState.getUri());
            this.mCurrentlyFetching.remove(priorityFetchState);
            if (!this.mHiPriQueue.remove(priorityFetchState)) {
                this.mLowPriQueue.remove(priorityFetchState);
            }
        }
        dequeueIfAvailableSlots();
    }

    private void moveDelayedRequestsToPriorityQueues() {
        if (!this.mDelayedQueue.isEmpty() && this.mClock.now() - this.firstDelayedRequestEnqueuedTimeStamp > this.requeueDelayTimeInMillis) {
            Iterator it = this.mDelayedQueue.iterator();
            while (it.hasNext()) {
                PriorityFetchState priorityFetchState = (PriorityFetchState) it.next();
                putInQueue(priorityFetchState, priorityFetchState.getContext().getPriority() == Priority.HIGH);
            }
            this.mDelayedQueue.clear();
        }
    }

    private void putInDelayedQueue(PriorityFetchState<FETCH_STATE> priorityFetchState) {
        if (this.mDelayedQueue.isEmpty()) {
            this.firstDelayedRequestEnqueuedTimeStamp = this.mClock.now();
        }
        priorityFetchState.delayCount++;
        this.mDelayedQueue.addLast(priorityFetchState);
    }

    /* access modifiers changed from: private */
    public void requeue(PriorityFetchState<FETCH_STATE> priorityFetchState) {
        synchronized (this.mLock) {
            FLog.v(TAG, "requeue: %s", (Object) priorityFetchState.getUri());
            boolean z = true;
            priorityFetchState.requeueCount++;
            priorityFetchState.delegatedState = this.mDelegate.createFetchState(priorityFetchState.getConsumer(), priorityFetchState.getContext());
            this.mCurrentlyFetching.remove(priorityFetchState);
            if (!this.mHiPriQueue.remove(priorityFetchState)) {
                this.mLowPriQueue.remove(priorityFetchState);
            }
            if (this.immediateRequeueCount == -1 || priorityFetchState.requeueCount <= this.immediateRequeueCount) {
                if (priorityFetchState.getContext().getPriority() != Priority.HIGH) {
                    z = false;
                }
                putInQueue(priorityFetchState, z);
            } else {
                putInDelayedQueue(priorityFetchState);
            }
        }
        dequeueIfAvailableSlots();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0061, code lost:
        delegateFetch(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0066, code lost:
        if (r10.multipleDequeue == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
        dequeueIfAvailableSlots();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dequeueIfAvailableSlots() {
        /*
            r10 = this;
            boolean r0 = r10.isRunning
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            java.lang.Object r1 = r10.mLock
            monitor-enter(r1)
            r10.moveDelayedRequestsToPriorityQueues()     // Catch:{ all -> 0x006c }
            java.util.HashSet<com.facebook.imagepipeline.producers.PriorityNetworkFetcher$PriorityFetchState<FETCH_STATE>> r2 = r10.mCurrentlyFetching     // Catch:{ all -> 0x006c }
            int r2 = r2.size()     // Catch:{ all -> 0x006c }
            int r3 = r10.mMaxOutstandingHiPri     // Catch:{ all -> 0x006c }
            if (r2 >= r3) goto L_0x001e
            java.util.LinkedList<com.facebook.imagepipeline.producers.PriorityNetworkFetcher$PriorityFetchState<FETCH_STATE>> r0 = r10.mHiPriQueue     // Catch:{ all -> 0x006c }
            java.lang.Object r0 = r0.pollFirst()     // Catch:{ all -> 0x006c }
            com.facebook.imagepipeline.producers.PriorityNetworkFetcher$PriorityFetchState r0 = (com.facebook.imagepipeline.producers.PriorityNetworkFetcher.PriorityFetchState) r0     // Catch:{ all -> 0x006c }
        L_0x001e:
            if (r0 != 0) goto L_0x002c
            int r3 = r10.mMaxOutstandingLowPri     // Catch:{ all -> 0x006c }
            if (r2 >= r3) goto L_0x002c
            java.util.LinkedList<com.facebook.imagepipeline.producers.PriorityNetworkFetcher$PriorityFetchState<FETCH_STATE>> r0 = r10.mLowPriQueue     // Catch:{ all -> 0x006c }
            java.lang.Object r0 = r0.pollFirst()     // Catch:{ all -> 0x006c }
            com.facebook.imagepipeline.producers.PriorityNetworkFetcher$PriorityFetchState r0 = (com.facebook.imagepipeline.producers.PriorityNetworkFetcher.PriorityFetchState) r0     // Catch:{ all -> 0x006c }
        L_0x002c:
            if (r0 != 0) goto L_0x0030
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            return
        L_0x0030:
            com.facebook.common.time.MonotonicClock r3 = r10.mClock     // Catch:{ all -> 0x006c }
            long r3 = r3.now()     // Catch:{ all -> 0x006c }
            r0.dequeuedTimestamp = r3     // Catch:{ all -> 0x006c }
            java.util.HashSet<com.facebook.imagepipeline.producers.PriorityNetworkFetcher$PriorityFetchState<FETCH_STATE>> r3 = r10.mCurrentlyFetching     // Catch:{ all -> 0x006c }
            r3.add(r0)     // Catch:{ all -> 0x006c }
            java.lang.String r4 = TAG     // Catch:{ all -> 0x006c }
            java.lang.String r5 = "fetching: %s (concurrent: %s hi-pri queue: %s low-pri queue: %s)"
            android.net.Uri r6 = r0.getUri()     // Catch:{ all -> 0x006c }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x006c }
            java.util.LinkedList<com.facebook.imagepipeline.producers.PriorityNetworkFetcher$PriorityFetchState<FETCH_STATE>> r2 = r10.mHiPriQueue     // Catch:{ all -> 0x006c }
            int r2 = r2.size()     // Catch:{ all -> 0x006c }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x006c }
            java.util.LinkedList<com.facebook.imagepipeline.producers.PriorityNetworkFetcher$PriorityFetchState<FETCH_STATE>> r2 = r10.mLowPriQueue     // Catch:{ all -> 0x006c }
            int r2 = r2.size()     // Catch:{ all -> 0x006c }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x006c }
            com.facebook.common.logging.FLog.v((java.lang.String) r4, (java.lang.String) r5, (java.lang.Object) r6, (java.lang.Object) r7, (java.lang.Object) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x006c }
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            r10.delegateFetch(r0)
            boolean r0 = r10.multipleDequeue
            if (r0 == 0) goto L_0x006b
            r10.dequeueIfAvailableSlots()
        L_0x006b:
            return
        L_0x006c:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.PriorityNetworkFetcher.dequeueIfAvailableSlots():void");
    }

    private void delegateFetch(final PriorityFetchState<FETCH_STATE> priorityFetchState) {
        try {
            this.mDelegate.fetch(priorityFetchState.delegatedState, new NetworkFetcher.Callback() {
                public void onResponse(InputStream inputStream, int i) throws IOException {
                    NetworkFetcher.Callback callback = priorityFetchState.callback;
                    if (callback != null) {
                        callback.onResponse(inputStream, i);
                    }
                }

                public void onFailure(Throwable th) {
                    if (!(PriorityNetworkFetcher.this.maxNumberOfRequeue == -1 || priorityFetchState.requeueCount < PriorityNetworkFetcher.this.maxNumberOfRequeue) || (th instanceof NonrecoverableException)) {
                        PriorityNetworkFetcher.this.removeFromQueue(priorityFetchState, "FAIL");
                        NetworkFetcher.Callback callback = priorityFetchState.callback;
                        if (callback != null) {
                            callback.onFailure(th);
                            return;
                        }
                        return;
                    }
                    PriorityNetworkFetcher.this.requeue(priorityFetchState);
                }

                public void onCancellation() {
                    PriorityNetworkFetcher.this.removeFromQueue(priorityFetchState, "CANCEL");
                    NetworkFetcher.Callback callback = priorityFetchState.callback;
                    if (callback != null) {
                        callback.onCancellation();
                    }
                }
            });
        } catch (Exception unused) {
            removeFromQueue(priorityFetchState, "FAIL");
        }
    }

    private void changePriorityInDelayedQueue(PriorityFetchState<FETCH_STATE> priorityFetchState) {
        if (this.mDelayedQueue.remove(priorityFetchState)) {
            priorityFetchState.priorityChangedCount++;
            this.mDelayedQueue.addLast(priorityFetchState);
        }
    }

    /* access modifiers changed from: private */
    public void changePriority(PriorityFetchState<FETCH_STATE> priorityFetchState, boolean z) {
        LinkedList<PriorityFetchState<FETCH_STATE>> linkedList;
        synchronized (this.mLock) {
            if (z) {
                linkedList = this.mLowPriQueue;
            } else {
                linkedList = this.mHiPriQueue;
            }
            if (!linkedList.remove(priorityFetchState)) {
                changePriorityInDelayedQueue(priorityFetchState);
                return;
            }
            FLog.v(TAG, "change-pri: %s %s", (Object) z ? "HIPRI" : "LOWPRI", (Object) priorityFetchState.getUri());
            priorityFetchState.priorityChangedCount++;
            putInQueue(priorityFetchState, z);
            dequeueIfAvailableSlots();
        }
    }

    private void putInQueue(PriorityFetchState<FETCH_STATE> priorityFetchState, boolean z) {
        if (!z) {
            this.mLowPriQueue.addLast(priorityFetchState);
        } else if (this.mIsHiPriFifo) {
            this.mHiPriQueue.addLast(priorityFetchState);
        } else {
            this.mHiPriQueue.addFirst(priorityFetchState);
        }
    }

    /* access modifiers changed from: package-private */
    public List<PriorityFetchState<FETCH_STATE>> getHiPriQueue() {
        return this.mHiPriQueue;
    }

    /* access modifiers changed from: package-private */
    public List<PriorityFetchState<FETCH_STATE>> getLowPriQueue() {
        return this.mLowPriQueue;
    }

    /* access modifiers changed from: package-private */
    public List<PriorityFetchState<FETCH_STATE>> getDelayedQeueue() {
        return this.mDelayedQueue;
    }

    /* access modifiers changed from: package-private */
    public HashSet<PriorityFetchState<FETCH_STATE>> getCurrentlyFetching() {
        return this.mCurrentlyFetching;
    }

    public static class PriorityFetchState<FETCH_STATE extends FetchState> extends FetchState {
        @Nullable
        NetworkFetcher.Callback callback;
        final int currentlyFetchingCountWhenCreated;
        int delayCount;
        public FETCH_STATE delegatedState;
        long dequeuedTimestamp;
        final long enqueuedTimestamp;
        final int hiPriCountWhenCreated;
        final boolean isInitialPriorityHigh;
        final int lowPriCountWhenCreated;
        int priorityChangedCount;
        int requeueCount;

        private PriorityFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext, FETCH_STATE fetch_state, long j, int i, int i2, int i3) {
            super(consumer, producerContext);
            boolean z = false;
            this.requeueCount = 0;
            this.delayCount = 0;
            this.priorityChangedCount = 0;
            this.delegatedState = fetch_state;
            this.enqueuedTimestamp = j;
            this.hiPriCountWhenCreated = i;
            this.lowPriCountWhenCreated = i2;
            this.isInitialPriorityHigh = producerContext.getPriority() == Priority.HIGH ? true : z;
            this.currentlyFetchingCountWhenCreated = i3;
        }
    }

    public static class NonrecoverableException extends Throwable {
        public NonrecoverableException(String str) {
            super(str);
        }
    }

    public PriorityFetchState<FETCH_STATE> createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new PriorityFetchState(consumer, producerContext, this.mDelegate.createFetchState(consumer, producerContext), this.mClock.now(), this.mHiPriQueue.size(), this.mLowPriQueue.size(), this.mCurrentlyFetching.size());
    }

    public boolean shouldPropagate(PriorityFetchState<FETCH_STATE> priorityFetchState) {
        return this.mDelegate.shouldPropagate(priorityFetchState.delegatedState);
    }

    @Nullable
    public Map<String, String> getExtraMap(PriorityFetchState<FETCH_STATE> priorityFetchState, int i) {
        HashMap hashMap;
        Map<String, String> extraMap = this.mDelegate.getExtraMap(priorityFetchState.delegatedState, i);
        if (extraMap == null) {
            hashMap = new HashMap();
        }
        hashMap.put("pri_queue_time", "" + (priorityFetchState.dequeuedTimestamp - priorityFetchState.enqueuedTimestamp));
        hashMap.put("hipri_queue_size", "" + priorityFetchState.hiPriCountWhenCreated);
        hashMap.put("lowpri_queue_size", "" + priorityFetchState.lowPriCountWhenCreated);
        hashMap.put("requeueCount", "" + priorityFetchState.requeueCount);
        hashMap.put("priority_changed_count", "" + priorityFetchState.priorityChangedCount);
        hashMap.put("request_initial_priority_is_high", "" + priorityFetchState.isInitialPriorityHigh);
        hashMap.put("currently_fetching_size", "" + priorityFetchState.currentlyFetchingCountWhenCreated);
        hashMap.put("delay_count", "" + priorityFetchState.delayCount);
        return hashMap;
    }
}
