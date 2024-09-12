package io.sentry;

import io.sentry.IConnectionStatusProvider;
import io.sentry.transport.RateLimiter;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SendCachedEnvelopeFireAndForgetIntegration implements Integration, IConnectionStatusProvider.IConnectionStatusObserver, Closeable {
    private IConnectionStatusProvider connectionStatusProvider;
    private final SendFireAndForgetFactory factory;
    private IHub hub;
    private final AtomicBoolean isClosed = new AtomicBoolean(false);
    private final AtomicBoolean isInitialized = new AtomicBoolean(false);
    private SentryOptions options;
    private SendFireAndForget sender;

    public interface SendFireAndForget {
        void send();
    }

    public interface SendFireAndForgetDirPath {
        String getDirPath();
    }

    public interface SendFireAndForgetFactory {
        SendFireAndForget create(IHub iHub, SentryOptions sentryOptions);

        boolean hasValidPath(String str, ILogger iLogger) {
            if (str != null && !str.isEmpty()) {
                return true;
            }
            iLogger.log(SentryLevel.INFO, "No cached dir path is defined in options.", new Object[0]);
            return false;
        }

        SendFireAndForget processDir(DirectoryProcessor directoryProcessor, String str, ILogger iLogger) {
            return new SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForgetFactory$$ExternalSyntheticLambda0(iLogger, str, directoryProcessor, new File(str));
        }

        static /* synthetic */ void lambda$processDir$0(ILogger iLogger, String str, DirectoryProcessor directoryProcessor, File file) {
            iLogger.log(SentryLevel.DEBUG, "Started processing cached files from %s", str);
            directoryProcessor.processDirectory(file);
            iLogger.log(SentryLevel.DEBUG, "Finished processing cached files from %s", str);
        }
    }

    public SendCachedEnvelopeFireAndForgetIntegration(SendFireAndForgetFactory sendFireAndForgetFactory) {
        this.factory = (SendFireAndForgetFactory) Objects.requireNonNull(sendFireAndForgetFactory, "SendFireAndForgetFactory is required");
    }

    public void register(IHub iHub, SentryOptions sentryOptions) {
        this.hub = (IHub) Objects.requireNonNull(iHub, "Hub is required");
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "SentryOptions is required");
        if (!this.factory.hasValidPath(sentryOptions.getCacheDirPath(), sentryOptions.getLogger())) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "No cache dir path is defined in options.", new Object[0]);
            return;
        }
        sentryOptions.getLogger().log(SentryLevel.DEBUG, "SendCachedEventFireAndForgetIntegration installed.", new Object[0]);
        IntegrationUtils.addIntegrationToSdkVersion(getClass());
        sendCachedEnvelopes(iHub, sentryOptions);
    }

    public void close() throws IOException {
        this.isClosed.set(true);
        IConnectionStatusProvider iConnectionStatusProvider = this.connectionStatusProvider;
        if (iConnectionStatusProvider != null) {
            iConnectionStatusProvider.removeConnectionStatusObserver(this);
        }
    }

    public void onConnectionStatusChanged(IConnectionStatusProvider.ConnectionStatus connectionStatus) {
        SentryOptions sentryOptions;
        IHub iHub = this.hub;
        if (iHub != null && (sentryOptions = this.options) != null) {
            sendCachedEnvelopes(iHub, sentryOptions);
        }
    }

    private synchronized void sendCachedEnvelopes(IHub iHub, SentryOptions sentryOptions) {
        try {
            sentryOptions.getExecutorService().submit((Runnable) new SendCachedEnvelopeFireAndForgetIntegration$$ExternalSyntheticLambda0(this, sentryOptions, iHub));
        } catch (RejectedExecutionException e) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "Failed to call the executor. Cached events will not be sent. Did you call Sentry.close()?", (Throwable) e);
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "Failed to call the executor. Cached events will not be sent", th);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$sendCachedEnvelopes$0$io-sentry-SendCachedEnvelopeFireAndForgetIntegration  reason: not valid java name */
    public /* synthetic */ void m875lambda$sendCachedEnvelopes$0$iosentrySendCachedEnvelopeFireAndForgetIntegration(SentryOptions sentryOptions, IHub iHub) {
        try {
            if (this.isClosed.get()) {
                sentryOptions.getLogger().log(SentryLevel.INFO, "SendCachedEnvelopeFireAndForgetIntegration, not trying to send after closing.", new Object[0]);
                return;
            }
            if (!this.isInitialized.getAndSet(true)) {
                IConnectionStatusProvider connectionStatusProvider2 = sentryOptions.getConnectionStatusProvider();
                this.connectionStatusProvider = connectionStatusProvider2;
                connectionStatusProvider2.addConnectionStatusObserver(this);
                this.sender = this.factory.create(iHub, sentryOptions);
            }
            IConnectionStatusProvider iConnectionStatusProvider = this.connectionStatusProvider;
            if (iConnectionStatusProvider == null || iConnectionStatusProvider.getConnectionStatus() != IConnectionStatusProvider.ConnectionStatus.DISCONNECTED) {
                RateLimiter rateLimiter = iHub.getRateLimiter();
                if (rateLimiter == null || !rateLimiter.isActiveForCategory(DataCategory.All)) {
                    SendFireAndForget sendFireAndForget = this.sender;
                    if (sendFireAndForget == null) {
                        sentryOptions.getLogger().log(SentryLevel.ERROR, "SendFireAndForget factory is null.", new Object[0]);
                    } else {
                        sendFireAndForget.send();
                    }
                } else {
                    sentryOptions.getLogger().log(SentryLevel.INFO, "SendCachedEnvelopeFireAndForgetIntegration, rate limiting active.", new Object[0]);
                }
            } else {
                sentryOptions.getLogger().log(SentryLevel.INFO, "SendCachedEnvelopeFireAndForgetIntegration, no connection.", new Object[0]);
            }
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "Failed trying to send cached events.", th);
        }
    }
}
