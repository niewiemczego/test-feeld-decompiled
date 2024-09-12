package io.sentry.util.thread;

import io.sentry.protocol.SentryThread;

public final class NoOpMainThreadChecker implements IMainThreadChecker {
    private static final NoOpMainThreadChecker instance = new NoOpMainThreadChecker();

    public boolean isMainThread() {
        return false;
    }

    public boolean isMainThread(long j) {
        return false;
    }

    public boolean isMainThread(SentryThread sentryThread) {
        return false;
    }

    public boolean isMainThread(Thread thread) {
        return false;
    }

    public static NoOpMainThreadChecker getInstance() {
        return instance;
    }
}
