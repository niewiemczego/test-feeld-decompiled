package io.sentry.android.core;

import io.sentry.IHub;
import io.sentry.ILogger;
import io.sentry.Integration;
import io.sentry.OutboxSender;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.util.Objects;
import java.io.Closeable;

public abstract class EnvelopeFileObserverIntegration implements Integration, Closeable {
    private boolean isClosed = false;
    private ILogger logger;
    private EnvelopeFileObserver observer;
    private final Object startLock = new Object();

    /* access modifiers changed from: package-private */
    public abstract String getPath(SentryOptions sentryOptions);

    public static EnvelopeFileObserverIntegration getOutboxFileObserver() {
        return new OutboxEnvelopeFileObserverIntegration();
    }

    public final void register(IHub iHub, SentryOptions sentryOptions) {
        Objects.requireNonNull(iHub, "Hub is required");
        Objects.requireNonNull(sentryOptions, "SentryOptions is required");
        this.logger = sentryOptions.getLogger();
        String path = getPath(sentryOptions);
        if (path == null) {
            this.logger.log(SentryLevel.WARNING, "Null given as a path to EnvelopeFileObserverIntegration. Nothing will be registered.", new Object[0]);
            return;
        }
        this.logger.log(SentryLevel.DEBUG, "Registering EnvelopeFileObserverIntegration for path: %s", path);
        try {
            sentryOptions.getExecutorService().submit((Runnable) new EnvelopeFileObserverIntegration$$ExternalSyntheticLambda0(this, iHub, sentryOptions, path));
        } catch (Throwable th) {
            this.logger.log(SentryLevel.DEBUG, "Failed to start EnvelopeFileObserverIntegration on executor thread.", th);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$register$0$io-sentry-android-core-EnvelopeFileObserverIntegration  reason: not valid java name */
    public /* synthetic */ void m899lambda$register$0$iosentryandroidcoreEnvelopeFileObserverIntegration(IHub iHub, SentryOptions sentryOptions, String str) {
        synchronized (this.startLock) {
            if (!this.isClosed) {
                startOutboxSender(iHub, sentryOptions, str);
            }
        }
    }

    private void startOutboxSender(IHub iHub, SentryOptions sentryOptions, String str) {
        OutboxSender outboxSender = new OutboxSender(iHub, sentryOptions.getEnvelopeReader(), sentryOptions.getSerializer(), sentryOptions.getLogger(), sentryOptions.getFlushTimeoutMillis(), sentryOptions.getMaxQueueSize());
        EnvelopeFileObserver envelopeFileObserver = new EnvelopeFileObserver(str, outboxSender, sentryOptions.getLogger(), sentryOptions.getFlushTimeoutMillis());
        this.observer = envelopeFileObserver;
        try {
            envelopeFileObserver.startWatching();
            sentryOptions.getLogger().log(SentryLevel.DEBUG, "EnvelopeFileObserverIntegration installed.", new Object[0]);
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "Failed to initialize EnvelopeFileObserverIntegration.", th);
        }
    }

    public void close() {
        synchronized (this.startLock) {
            this.isClosed = true;
        }
        EnvelopeFileObserver envelopeFileObserver = this.observer;
        if (envelopeFileObserver != null) {
            envelopeFileObserver.stopWatching();
            ILogger iLogger = this.logger;
            if (iLogger != null) {
                iLogger.log(SentryLevel.DEBUG, "EnvelopeFileObserverIntegration removed.", new Object[0]);
            }
        }
    }

    private static final class OutboxEnvelopeFileObserverIntegration extends EnvelopeFileObserverIntegration {
        private OutboxEnvelopeFileObserverIntegration() {
        }

        /* access modifiers changed from: protected */
        public String getPath(SentryOptions sentryOptions) {
            return sentryOptions.getOutboxPath();
        }
    }
}
