package io.sentry.util.thread;

import io.sentry.protocol.SentryThread;

public final class MainThreadChecker implements IMainThreadChecker {
    private static final MainThreadChecker instance = new MainThreadChecker();
    private static final long mainThreadId = Thread.currentThread().getId();

    public static MainThreadChecker getInstance() {
        return instance;
    }

    private MainThreadChecker() {
    }

    public boolean isMainThread(long j) {
        return mainThreadId == j;
    }

    public boolean isMainThread(Thread thread) {
        return isMainThread(thread.getId());
    }

    public boolean isMainThread() {
        return isMainThread(Thread.currentThread());
    }

    public boolean isMainThread(SentryThread sentryThread) {
        Long id = sentryThread.getId();
        return id != null && isMainThread(id.longValue());
    }
}
