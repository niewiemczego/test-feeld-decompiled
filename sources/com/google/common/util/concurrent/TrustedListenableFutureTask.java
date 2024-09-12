package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
class TrustedListenableFutureTask<V> extends FluentFuture.TrustedFuture<V> implements RunnableFuture<V> {
    @CheckForNull
    private volatile InterruptibleTask<?> task;

    static <V> TrustedListenableFutureTask<V> create(AsyncCallable<V> asyncCallable) {
        return new TrustedListenableFutureTask<>(asyncCallable);
    }

    static <V> TrustedListenableFutureTask<V> create(Callable<V> callable) {
        return new TrustedListenableFutureTask<>(callable);
    }

    static <V> TrustedListenableFutureTask<V> create(Runnable runnable, @ParametricNullness V v) {
        return new TrustedListenableFutureTask<>(Executors.callable(runnable, v));
    }

    TrustedListenableFutureTask(Callable<V> callable) {
        this.task = new TrustedFutureInterruptibleTask(callable);
    }

    TrustedListenableFutureTask(AsyncCallable<V> asyncCallable) {
        this.task = new TrustedFutureInterruptibleAsyncTask(asyncCallable);
    }

    public void run() {
        InterruptibleTask<?> interruptibleTask = this.task;
        if (interruptibleTask != null) {
            interruptibleTask.run();
        }
        this.task = null;
    }

    /* access modifiers changed from: protected */
    public void afterDone() {
        InterruptibleTask<?> interruptibleTask;
        super.afterDone();
        if (wasInterrupted() && (interruptibleTask = this.task) != null) {
            interruptibleTask.interruptTask();
        }
        this.task = null;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public String pendingToString() {
        InterruptibleTask<?> interruptibleTask = this.task;
        if (interruptibleTask == null) {
            return super.pendingToString();
        }
        String valueOf = String.valueOf(interruptibleTask);
        return new StringBuilder(String.valueOf(valueOf).length() + 7).append("task=[").append(valueOf).append("]").toString();
    }

    private final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> callable;

        TrustedFutureInterruptibleTask(Callable<V> callable2) {
            this.callable = (Callable) Preconditions.checkNotNull(callable2);
        }

        /* access modifiers changed from: package-private */
        public final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        /* access modifiers changed from: package-private */
        public void afterRanInterruptiblySuccess(@ParametricNullness V v) {
            TrustedListenableFutureTask.this.set(v);
        }

        /* access modifiers changed from: package-private */
        public void afterRanInterruptiblyFailure(Throwable th) {
            TrustedListenableFutureTask.this.setException(th);
        }

        /* access modifiers changed from: package-private */
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    private final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<ListenableFuture<V>> {
        private final AsyncCallable<V> callable;

        TrustedFutureInterruptibleAsyncTask(AsyncCallable<V> asyncCallable) {
            this.callable = (AsyncCallable) Preconditions.checkNotNull(asyncCallable);
        }

        /* access modifiers changed from: package-private */
        public final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        /* access modifiers changed from: package-private */
        public ListenableFuture<V> runInterruptibly() throws Exception {
            return (ListenableFuture) Preconditions.checkNotNull(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", (Object) this.callable);
        }

        /* access modifiers changed from: package-private */
        public void afterRanInterruptiblySuccess(ListenableFuture<V> listenableFuture) {
            TrustedListenableFutureTask.this.setFuture(listenableFuture);
        }

        /* access modifiers changed from: package-private */
        public void afterRanInterruptiblyFailure(Throwable th) {
            TrustedListenableFutureTask.this.setException(th);
        }

        /* access modifiers changed from: package-private */
        public String toPendingString() {
            return this.callable.toString();
        }
    }
}
