package io.sentry.android.core;

import io.sentry.DataCategory;
import io.sentry.IConnectionStatusProvider;
import io.sentry.IHub;
import io.sentry.Integration;
import io.sentry.SendCachedEnvelopeFireAndForgetIntegration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.transport.RateLimiter;
import io.sentry.util.LazyEvaluator;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

final class SendCachedEnvelopeIntegration implements Integration, IConnectionStatusProvider.IConnectionStatusObserver, Closeable {
    private IConnectionStatusProvider connectionStatusProvider;
    private final SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory factory;
    private IHub hub;
    private final AtomicBoolean isClosed = new AtomicBoolean(false);
    private final AtomicBoolean isInitialized = new AtomicBoolean(false);
    private SentryAndroidOptions options;
    private SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForget sender;
    private final AtomicBoolean startupCrashHandled = new AtomicBoolean(false);
    private final LazyEvaluator<Boolean> startupCrashMarkerEvaluator;

    public SendCachedEnvelopeIntegration(SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory sendFireAndForgetFactory, LazyEvaluator<Boolean> lazyEvaluator) {
        this.factory = (SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory) Objects.requireNonNull(sendFireAndForgetFactory, "SendFireAndForgetFactory is required");
        this.startupCrashMarkerEvaluator = lazyEvaluator;
    }

    public void register(IHub iHub, SentryOptions sentryOptions) {
        this.hub = (IHub) Objects.requireNonNull(iHub, "Hub is required");
        this.options = (SentryAndroidOptions) Objects.requireNonNull(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        if (!this.factory.hasValidPath(sentryOptions.getCacheDirPath(), sentryOptions.getLogger())) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "No cache dir path is defined in options.", new Object[0]);
        } else {
            sendCachedEnvelopes(iHub, this.options);
        }
    }

    public void close() throws IOException {
        this.isClosed.set(true);
        IConnectionStatusProvider iConnectionStatusProvider = this.connectionStatusProvider;
        if (iConnectionStatusProvider != null) {
            iConnectionStatusProvider.removeConnectionStatusObserver(this);
        }
    }

    public void onConnectionStatusChanged(IConnectionStatusProvider.ConnectionStatus connectionStatus) {
        SentryAndroidOptions sentryAndroidOptions;
        IHub iHub = this.hub;
        if (iHub != null && (sentryAndroidOptions = this.options) != null) {
            sendCachedEnvelopes(iHub, sentryAndroidOptions);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:6|7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void sendCachedEnvelopes(io.sentry.IHub r6, io.sentry.android.core.SentryAndroidOptions r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            io.sentry.ISentryExecutorService r0 = r7.getExecutorService()     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            io.sentry.android.core.SendCachedEnvelopeIntegration$$ExternalSyntheticLambda0 r1 = new io.sentry.android.core.SendCachedEnvelopeIntegration$$ExternalSyntheticLambda0     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            r1.<init>(r5, r7, r6)     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            java.util.concurrent.Future r6 = r0.submit((java.lang.Runnable) r1)     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            io.sentry.util.LazyEvaluator<java.lang.Boolean> r0 = r5.startupCrashMarkerEvaluator     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            boolean r0 = r0.booleanValue()     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            r1 = 0
            if (r0 == 0) goto L_0x004a
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.startupCrashHandled     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            if (r0 == 0) goto L_0x004a
            io.sentry.ILogger r0 = r7.getLogger()     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            io.sentry.SentryLevel r2 = io.sentry.SentryLevel.DEBUG     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            java.lang.String r3 = "Startup Crash marker exists, blocking flush."
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            r0.log((io.sentry.SentryLevel) r2, (java.lang.String) r3, (java.lang.Object[]) r4)     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            long r2 = r7.getStartupCrashFlushTimeoutMillis()     // Catch:{ TimeoutException -> 0x003d }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ TimeoutException -> 0x003d }
            r6.get(r2, r0)     // Catch:{ TimeoutException -> 0x003d }
            goto L_0x004a
        L_0x003d:
            io.sentry.ILogger r6 = r7.getLogger()     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.DEBUG     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            java.lang.String r2 = "Synchronous send timed out, continuing in the background."
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            r6.log((io.sentry.SentryLevel) r0, (java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
        L_0x004a:
            io.sentry.ILogger r6 = r7.getLogger()     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.DEBUG     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            java.lang.String r2 = "SendCachedEnvelopeIntegration installed."
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            r6.log((io.sentry.SentryLevel) r0, (java.lang.String) r2, (java.lang.Object[]) r1)     // Catch:{ RejectedExecutionException -> 0x0065, all -> 0x0058 }
            goto L_0x0071
        L_0x0058:
            r6 = move-exception
            io.sentry.ILogger r7 = r7.getLogger()     // Catch:{ all -> 0x0073 }
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = "Failed to call the executor. Cached events will not be sent"
            r7.log((io.sentry.SentryLevel) r0, (java.lang.String) r1, (java.lang.Throwable) r6)     // Catch:{ all -> 0x0073 }
            goto L_0x0071
        L_0x0065:
            r6 = move-exception
            io.sentry.ILogger r7 = r7.getLogger()     // Catch:{ all -> 0x0073 }
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = "Failed to call the executor. Cached events will not be sent. Did you call Sentry.close()?"
            r7.log((io.sentry.SentryLevel) r0, (java.lang.String) r1, (java.lang.Throwable) r6)     // Catch:{ all -> 0x0073 }
        L_0x0071:
            monitor-exit(r5)
            return
        L_0x0073:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.SendCachedEnvelopeIntegration.sendCachedEnvelopes(io.sentry.IHub, io.sentry.android.core.SentryAndroidOptions):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$sendCachedEnvelopes$0$io-sentry-android-core-SendCachedEnvelopeIntegration  reason: not valid java name */
    public /* synthetic */ void m902lambda$sendCachedEnvelopes$0$iosentryandroidcoreSendCachedEnvelopeIntegration(SentryAndroidOptions sentryAndroidOptions, IHub iHub) {
        try {
            if (this.isClosed.get()) {
                sentryAndroidOptions.getLogger().log(SentryLevel.INFO, "SendCachedEnvelopeIntegration, not trying to send after closing.", new Object[0]);
                return;
            }
            if (!this.isInitialized.getAndSet(true)) {
                IConnectionStatusProvider connectionStatusProvider2 = sentryAndroidOptions.getConnectionStatusProvider();
                this.connectionStatusProvider = connectionStatusProvider2;
                connectionStatusProvider2.addConnectionStatusObserver(this);
                this.sender = this.factory.create(iHub, sentryAndroidOptions);
            }
            IConnectionStatusProvider iConnectionStatusProvider = this.connectionStatusProvider;
            if (iConnectionStatusProvider == null || iConnectionStatusProvider.getConnectionStatus() != IConnectionStatusProvider.ConnectionStatus.DISCONNECTED) {
                RateLimiter rateLimiter = iHub.getRateLimiter();
                if (rateLimiter == null || !rateLimiter.isActiveForCategory(DataCategory.All)) {
                    SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForget sendFireAndForget = this.sender;
                    if (sendFireAndForget == null) {
                        sentryAndroidOptions.getLogger().log(SentryLevel.ERROR, "SendCachedEnvelopeIntegration factory is null.", new Object[0]);
                    } else {
                        sendFireAndForget.send();
                    }
                } else {
                    sentryAndroidOptions.getLogger().log(SentryLevel.INFO, "SendCachedEnvelopeIntegration, rate limiting active.", new Object[0]);
                }
            } else {
                sentryAndroidOptions.getLogger().log(SentryLevel.INFO, "SendCachedEnvelopeIntegration, no connection.", new Object[0]);
            }
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().log(SentryLevel.ERROR, "Failed trying to send cached events.", th);
        }
    }
}
