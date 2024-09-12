package com.launchdarkly.sdk.android;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: LDFutures */
class LDSuccessFuture<T> implements Future<T> {
    private final T result;

    public boolean cancel(boolean z) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    LDSuccessFuture(T t) {
        this.result = t;
    }

    public T get() {
        return this.result;
    }

    public T get(long j, TimeUnit timeUnit) {
        return this.result;
    }
}
