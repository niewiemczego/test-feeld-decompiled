package io.sentry;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

final class NoOpSentryExecutorService implements ISentryExecutorService {
    private static final NoOpSentryExecutorService instance = new NoOpSentryExecutorService();

    static /* synthetic */ Object lambda$schedule$2() throws Exception {
        return null;
    }

    static /* synthetic */ Object lambda$submit$0() throws Exception {
        return null;
    }

    static /* synthetic */ Object lambda$submit$1() throws Exception {
        return null;
    }

    public void close(long j) {
    }

    public boolean isClosed() {
        return false;
    }

    private NoOpSentryExecutorService() {
    }

    public static ISentryExecutorService getInstance() {
        return instance;
    }

    public Future<?> submit(Runnable runnable) {
        return new FutureTask(new NoOpSentryExecutorService$$ExternalSyntheticLambda1());
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return new FutureTask(new NoOpSentryExecutorService$$ExternalSyntheticLambda0());
    }

    public Future<?> schedule(Runnable runnable, long j) {
        return new FutureTask(new NoOpSentryExecutorService$$ExternalSyntheticLambda2());
    }
}
