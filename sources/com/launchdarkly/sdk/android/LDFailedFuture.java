package com.launchdarkly.sdk.android;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: LDFutures */
class LDFailedFuture<T> implements Future<T> {
    private final Throwable error;

    public boolean cancel(boolean z) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    LDFailedFuture(Throwable th) {
        this.error = th;
    }

    public T get() throws ExecutionException {
        throw new ExecutionException(this.error);
    }

    public T get(long j, TimeUnit timeUnit) throws ExecutionException {
        throw new ExecutionException(this.error);
    }
}
