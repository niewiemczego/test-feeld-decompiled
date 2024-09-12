package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class DelegatingScheduledExecutorService implements ScheduledExecutorService {
    private final ExecutorService delegate;
    private final ScheduledExecutorService scheduler;

    DelegatingScheduledExecutorService(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.delegate = executorService;
        this.scheduler = scheduledExecutorService;
    }

    public void shutdown() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.awaitTermination(j, timeUnit);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.delegate.submit(callable);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.delegate.submit(runnable, t);
    }

    public Future<?> submit(Runnable runnable) {
        return this.delegate.submit(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.delegate.invokeAll(collection);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.invokeAll(collection, j, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return this.delegate.invokeAny(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.delegate.invokeAny(collection, j, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.delegate.execute(runnable);
    }

    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda6(this, runnable, j, timeUnit));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$schedule$2$com-google-firebase-concurrent-DelegatingScheduledExecutorService  reason: not valid java name */
    public /* synthetic */ ScheduledFuture m573lambda$schedule$2$comgooglefirebaseconcurrentDelegatingScheduledExecutorService(Runnable runnable, long j, TimeUnit timeUnit, DelegatingScheduledFuture.Completer completer) {
        return this.scheduler.schedule(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda10(this, runnable, completer), j, timeUnit);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$schedule$1$com-google-firebase-concurrent-DelegatingScheduledExecutorService  reason: not valid java name */
    public /* synthetic */ void m572lambda$schedule$1$comgooglefirebaseconcurrentDelegatingScheduledExecutorService(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.delegate.execute(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda11(runnable, completer));
    }

    static /* synthetic */ void lambda$schedule$0(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        try {
            runnable.run();
            completer.set(null);
        } catch (Exception e) {
            completer.setException(e);
        }
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda0(this, callable, j, timeUnit));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$schedule$5$com-google-firebase-concurrent-DelegatingScheduledExecutorService  reason: not valid java name */
    public /* synthetic */ ScheduledFuture m575lambda$schedule$5$comgooglefirebaseconcurrentDelegatingScheduledExecutorService(Callable callable, long j, TimeUnit timeUnit, DelegatingScheduledFuture.Completer completer) {
        return this.scheduler.schedule(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda2(this, callable, completer), j, timeUnit);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$schedule$4$com-google-firebase-concurrent-DelegatingScheduledExecutorService  reason: not valid java name */
    public /* synthetic */ Future m574lambda$schedule$4$comgooglefirebaseconcurrentDelegatingScheduledExecutorService(Callable callable, DelegatingScheduledFuture.Completer completer) throws Exception {
        return this.delegate.submit(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda3(callable, completer));
    }

    static /* synthetic */ void lambda$schedule$3(Callable callable, DelegatingScheduledFuture.Completer completer) {
        try {
            completer.set(callable.call());
        } catch (Exception e) {
            completer.setException(e);
        }
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda9(this, runnable, j, j2, timeUnit));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$scheduleAtFixedRate$8$com-google-firebase-concurrent-DelegatingScheduledExecutorService  reason: not valid java name */
    public /* synthetic */ ScheduledFuture m577lambda$scheduleAtFixedRate$8$comgooglefirebaseconcurrentDelegatingScheduledExecutorService(Runnable runnable, long j, long j2, TimeUnit timeUnit, DelegatingScheduledFuture.Completer completer) {
        return this.scheduler.scheduleAtFixedRate(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda5(this, runnable, completer), j, j2, timeUnit);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$scheduleAtFixedRate$7$com-google-firebase-concurrent-DelegatingScheduledExecutorService  reason: not valid java name */
    public /* synthetic */ void m576lambda$scheduleAtFixedRate$7$comgooglefirebaseconcurrentDelegatingScheduledExecutorService(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.delegate.execute(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda4(runnable, completer));
    }

    static /* synthetic */ void lambda$scheduleAtFixedRate$6(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        try {
            runnable.run();
        } catch (Exception e) {
            completer.setException(e);
            throw e;
        }
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda7(this, runnable, j, j2, timeUnit));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$scheduleWithFixedDelay$11$com-google-firebase-concurrent-DelegatingScheduledExecutorService  reason: not valid java name */
    public /* synthetic */ ScheduledFuture m579lambda$scheduleWithFixedDelay$11$comgooglefirebaseconcurrentDelegatingScheduledExecutorService(Runnable runnable, long j, long j2, TimeUnit timeUnit, DelegatingScheduledFuture.Completer completer) {
        return this.scheduler.scheduleWithFixedDelay(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda8(this, runnable, completer), j, j2, timeUnit);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$scheduleWithFixedDelay$10$com-google-firebase-concurrent-DelegatingScheduledExecutorService  reason: not valid java name */
    public /* synthetic */ void m578lambda$scheduleWithFixedDelay$10$comgooglefirebaseconcurrentDelegatingScheduledExecutorService(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.delegate.execute(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda1(runnable, completer));
    }

    static /* synthetic */ void lambda$scheduleWithFixedDelay$9(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        try {
            runnable.run();
        } catch (Exception e) {
            completer.setException(e);
        }
    }
}
