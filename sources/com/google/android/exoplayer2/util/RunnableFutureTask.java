package com.google.android.exoplayer2.util;

import java.lang.Exception;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class RunnableFutureTask<R, E extends Exception> implements RunnableFuture<R> {
    private final Object cancelLock = new Object();
    private boolean canceled;
    private Exception exception;
    private final ConditionVariable finished = new ConditionVariable();
    private R result;
    private final ConditionVariable started = new ConditionVariable();
    private Thread workThread;

    /* access modifiers changed from: protected */
    public void cancelWork() {
    }

    /* access modifiers changed from: protected */
    public abstract R doWork() throws Exception;

    protected RunnableFutureTask() {
    }

    public final void blockUntilStarted() {
        this.started.blockUninterruptible();
    }

    public final void blockUntilFinished() {
        this.finished.blockUninterruptible();
    }

    public final R get() throws ExecutionException, InterruptedException {
        this.finished.block();
        return getResult();
    }

    public final R get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.finished.block(TimeUnit.MILLISECONDS.convert(j, timeUnit))) {
            return getResult();
        }
        throw new TimeoutException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.cancelLock
            monitor-enter(r0)
            boolean r1 = r3.canceled     // Catch:{ all -> 0x002f }
            if (r1 != 0) goto L_0x002c
            com.google.android.exoplayer2.util.ConditionVariable r1 = r3.finished     // Catch:{ all -> 0x002f }
            boolean r1 = r1.isOpen()     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0010
            goto L_0x002c
        L_0x0010:
            r1 = 1
            r3.canceled = r1     // Catch:{ all -> 0x002f }
            r3.cancelWork()     // Catch:{ all -> 0x002f }
            java.lang.Thread r2 = r3.workThread     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x0020
            if (r4 == 0) goto L_0x002a
            r2.interrupt()     // Catch:{ all -> 0x002f }
            goto L_0x002a
        L_0x0020:
            com.google.android.exoplayer2.util.ConditionVariable r4 = r3.started     // Catch:{ all -> 0x002f }
            r4.open()     // Catch:{ all -> 0x002f }
            com.google.android.exoplayer2.util.ConditionVariable r4 = r3.finished     // Catch:{ all -> 0x002f }
            r4.open()     // Catch:{ all -> 0x002f }
        L_0x002a:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r1
        L_0x002c:
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r4
        L_0x002f:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.RunnableFutureTask.cancel(boolean):boolean");
    }

    public final boolean isDone() {
        return this.finished.isOpen();
    }

    public final boolean isCancelled() {
        return this.canceled;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.cancelLock
            monitor-enter(r0)
            boolean r1 = r4.canceled     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            return
        L_0x0009:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0057 }
            r4.workThread = r1     // Catch:{ all -> 0x0057 }
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            com.google.android.exoplayer2.util.ConditionVariable r0 = r4.started
            r0.open()
            r0 = 0
            java.lang.Object r1 = r4.doWork()     // Catch:{ Exception -> 0x0030 }
            r4.result = r1     // Catch:{ Exception -> 0x0030 }
            java.lang.Object r1 = r4.cancelLock
            monitor-enter(r1)
            com.google.android.exoplayer2.util.ConditionVariable r2 = r4.finished     // Catch:{ all -> 0x002b }
            r2.open()     // Catch:{ all -> 0x002b }
            r4.workThread = r0     // Catch:{ all -> 0x002b }
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x002b }
            monitor-exit(r1)     // Catch:{ all -> 0x002b }
            goto L_0x0041
        L_0x002b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002b }
            throw r0
        L_0x002e:
            r1 = move-exception
            goto L_0x0045
        L_0x0030:
            r1 = move-exception
            r4.exception = r1     // Catch:{ all -> 0x002e }
            java.lang.Object r1 = r4.cancelLock
            monitor-enter(r1)
            com.google.android.exoplayer2.util.ConditionVariable r2 = r4.finished     // Catch:{ all -> 0x0042 }
            r2.open()     // Catch:{ all -> 0x0042 }
            r4.workThread = r0     // Catch:{ all -> 0x0042 }
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x0042 }
            monitor-exit(r1)     // Catch:{ all -> 0x0042 }
        L_0x0041:
            return
        L_0x0042:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0042 }
            throw r0
        L_0x0045:
            java.lang.Object r2 = r4.cancelLock
            monitor-enter(r2)
            com.google.android.exoplayer2.util.ConditionVariable r3 = r4.finished     // Catch:{ all -> 0x0054 }
            r3.open()     // Catch:{ all -> 0x0054 }
            r4.workThread = r0     // Catch:{ all -> 0x0054 }
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x0054 }
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            throw r1
        L_0x0054:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            throw r0
        L_0x0057:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.RunnableFutureTask.run():void");
    }

    private R getResult() throws ExecutionException {
        if (this.canceled) {
            throw new CancellationException();
        } else if (this.exception == null) {
            return this.result;
        } else {
            throw new ExecutionException(this.exception);
        }
    }
}
