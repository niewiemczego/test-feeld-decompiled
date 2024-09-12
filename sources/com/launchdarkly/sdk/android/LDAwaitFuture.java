package com.launchdarkly.sdk.android;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: LDFutures */
class LDAwaitFuture<T> implements Future<T> {
    private volatile boolean completed = false;
    private volatile Throwable error = null;
    private final Object notifier = new Object();
    private volatile T result = null;

    public boolean cancel(boolean z) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    LDAwaitFuture() {
    }

    /* access modifiers changed from: package-private */
    public synchronized void set(T t) {
        if (!this.completed) {
            this.result = t;
            synchronized (this.notifier) {
                this.completed = true;
                this.notifier.notifyAll();
            }
        } else {
            LDClient.getSharedLogger().warn("LDAwaitFuture set twice");
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void setException(Throwable th) {
        if (!this.completed) {
            this.error = th;
            synchronized (this.notifier) {
                this.completed = true;
                this.notifier.notifyAll();
            }
        } else {
            LDClient.getSharedLogger().warn("LDAwaitFuture set twice");
        }
    }

    public boolean isDone() {
        return this.completed;
    }

    public T get() throws ExecutionException, InterruptedException {
        synchronized (this.notifier) {
            while (!this.completed) {
                this.notifier.wait();
            }
        }
        if (this.error == null) {
            return this.result;
        }
        throw new ExecutionException(this.error);
    }

    public T get(long j, TimeUnit timeUnit) throws ExecutionException, TimeoutException, InterruptedException {
        long nanos = timeUnit.toNanos(j);
        long nanoTime = System.nanoTime() + nanos;
        synchronized (this.notifier) {
            while (true) {
                boolean z = true;
                boolean z2 = !this.completed;
                if (nanos <= 0) {
                    z = false;
                }
                if (z2 && z) {
                    TimeUnit.NANOSECONDS.timedWait(this.notifier, nanos);
                    nanos = nanoTime - System.nanoTime();
                }
            }
            while (true) {
            }
        }
        if (!this.completed) {
            throw new TimeoutException("LDAwaitFuture timed out awaiting completion");
        } else if (this.error == null) {
            return this.result;
        } else {
            throw new ExecutionException(this.error);
        }
    }
}
