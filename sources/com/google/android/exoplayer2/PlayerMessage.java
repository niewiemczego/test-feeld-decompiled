package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;

public final class PlayerMessage {
    private final Clock clock;
    private boolean deleteAfterDelivery = true;
    private boolean isCanceled;
    private boolean isDelivered;
    private boolean isProcessed;
    private boolean isSent;
    private Looper looper;
    private int mediaItemIndex;
    private Object payload;
    private long positionMs = C.TIME_UNSET;
    private final Sender sender;
    private final Target target;
    private final Timeline timeline;
    private int type;

    public interface Sender {
        void sendMessage(PlayerMessage playerMessage);
    }

    public interface Target {
        void handleMessage(int i, Object obj) throws ExoPlaybackException;
    }

    public PlayerMessage(Sender sender2, Target target2, Timeline timeline2, int i, Clock clock2, Looper looper2) {
        this.sender = sender2;
        this.target = target2;
        this.timeline = timeline2;
        this.looper = looper2;
        this.clock = clock2;
        this.mediaItemIndex = i;
    }

    public Timeline getTimeline() {
        return this.timeline;
    }

    public Target getTarget() {
        return this.target;
    }

    public PlayerMessage setType(int i) {
        Assertions.checkState(!this.isSent);
        this.type = i;
        return this;
    }

    public int getType() {
        return this.type;
    }

    public PlayerMessage setPayload(Object obj) {
        Assertions.checkState(!this.isSent);
        this.payload = obj;
        return this;
    }

    public Object getPayload() {
        return this.payload;
    }

    @Deprecated
    public PlayerMessage setHandler(Handler handler) {
        return setLooper(handler.getLooper());
    }

    public PlayerMessage setLooper(Looper looper2) {
        Assertions.checkState(!this.isSent);
        this.looper = looper2;
        return this;
    }

    public Looper getLooper() {
        return this.looper;
    }

    public long getPositionMs() {
        return this.positionMs;
    }

    public PlayerMessage setPosition(long j) {
        Assertions.checkState(!this.isSent);
        this.positionMs = j;
        return this;
    }

    public PlayerMessage setPosition(int i, long j) {
        boolean z = true;
        Assertions.checkState(!this.isSent);
        if (j == C.TIME_UNSET) {
            z = false;
        }
        Assertions.checkArgument(z);
        if (i < 0 || (!this.timeline.isEmpty() && i >= this.timeline.getWindowCount())) {
            throw new IllegalSeekPositionException(this.timeline, i, j);
        }
        this.mediaItemIndex = i;
        this.positionMs = j;
        return this;
    }

    public int getMediaItemIndex() {
        return this.mediaItemIndex;
    }

    public PlayerMessage setDeleteAfterDelivery(boolean z) {
        Assertions.checkState(!this.isSent);
        this.deleteAfterDelivery = z;
        return this;
    }

    public boolean getDeleteAfterDelivery() {
        return this.deleteAfterDelivery;
    }

    public PlayerMessage send() {
        Assertions.checkState(!this.isSent);
        if (this.positionMs == C.TIME_UNSET) {
            Assertions.checkArgument(this.deleteAfterDelivery);
        }
        this.isSent = true;
        this.sender.sendMessage(this);
        return this;
    }

    public synchronized PlayerMessage cancel() {
        Assertions.checkState(this.isSent);
        this.isCanceled = true;
        markAsProcessed(false);
        return this;
    }

    public synchronized boolean isCanceled() {
        return this.isCanceled;
    }

    public synchronized void markAsProcessed(boolean z) {
        this.isDelivered = z | this.isDelivered;
        this.isProcessed = true;
        notifyAll();
    }

    public synchronized boolean blockUntilDelivered() throws InterruptedException {
        Assertions.checkState(this.isSent);
        Assertions.checkState(this.looper.getThread() != Thread.currentThread());
        while (!this.isProcessed) {
            wait();
        }
        return this.isDelivered;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040 A[SYNTHETIC, Splitter:B:16:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean blockUntilDelivered(long r6) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.isSent     // Catch:{ all -> 0x0048 }
            com.google.android.exoplayer2.util.Assertions.checkState(r0)     // Catch:{ all -> 0x0048 }
            android.os.Looper r0 = r5.looper     // Catch:{ all -> 0x0048 }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ all -> 0x0048 }
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0048 }
            if (r0 == r1) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            com.google.android.exoplayer2.util.Assertions.checkState(r0)     // Catch:{ all -> 0x0048 }
            com.google.android.exoplayer2.util.Clock r0 = r5.clock     // Catch:{ all -> 0x0048 }
            long r0 = r0.elapsedRealtime()     // Catch:{ all -> 0x0048 }
            long r0 = r0 + r6
        L_0x001f:
            boolean r2 = r5.isProcessed     // Catch:{ all -> 0x0048 }
            if (r2 != 0) goto L_0x003a
            r3 = 0
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x003a
            com.google.android.exoplayer2.util.Clock r2 = r5.clock     // Catch:{ all -> 0x0048 }
            r2.onThreadBlocked()     // Catch:{ all -> 0x0048 }
            r5.wait(r6)     // Catch:{ all -> 0x0048 }
            com.google.android.exoplayer2.util.Clock r6 = r5.clock     // Catch:{ all -> 0x0048 }
            long r6 = r6.elapsedRealtime()     // Catch:{ all -> 0x0048 }
            long r6 = r0 - r6
            goto L_0x001f
        L_0x003a:
            if (r2 == 0) goto L_0x0040
            boolean r6 = r5.isDelivered     // Catch:{ all -> 0x0048 }
            monitor-exit(r5)
            return r6
        L_0x0040:
            java.util.concurrent.TimeoutException r6 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x0048 }
            java.lang.String r7 = "Message delivery timed out."
            r6.<init>(r7)     // Catch:{ all -> 0x0048 }
            throw r6     // Catch:{ all -> 0x0048 }
        L_0x0048:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.PlayerMessage.blockUntilDelivered(long):boolean");
    }
}
