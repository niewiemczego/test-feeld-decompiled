package io.sentry.util.thread;

import io.sentry.protocol.SentryThread;

public interface IMainThreadChecker {
    boolean isMainThread();

    boolean isMainThread(long j);

    boolean isMainThread(SentryThread sentryThread);

    boolean isMainThread(Thread thread);
}
