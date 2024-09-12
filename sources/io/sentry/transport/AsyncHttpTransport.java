package io.sentry.transport;

import io.sentry.DateUtils;
import io.sentry.Hint;
import io.sentry.ILogger;
import io.sentry.RequestDetails;
import io.sentry.SentryDateProvider;
import io.sentry.SentryEnvelope;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.cache.IEnvelopeCache;
import io.sentry.clientreport.DiscardReason;
import io.sentry.hints.Cached;
import io.sentry.hints.DiskFlushNotification;
import io.sentry.hints.Enqueable;
import io.sentry.hints.Retryable;
import io.sentry.hints.SubmissionResult;
import io.sentry.util.HintUtils;
import io.sentry.util.LogUtils;
import io.sentry.util.Objects;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class AsyncHttpTransport implements ITransport {
    /* access modifiers changed from: private */
    public final HttpConnection connection;
    /* access modifiers changed from: private */
    public volatile Runnable currentRunnable;
    private final IEnvelopeCache envelopeCache;
    private final QueuedThreadPoolExecutor executor;
    /* access modifiers changed from: private */
    public final SentryOptions options;
    private final RateLimiter rateLimiter;
    /* access modifiers changed from: private */
    public final ITransportGate transportGate;

    public AsyncHttpTransport(SentryOptions sentryOptions, RateLimiter rateLimiter2, ITransportGate iTransportGate, RequestDetails requestDetails) {
        this(initExecutor(sentryOptions.getMaxQueueSize(), sentryOptions.getEnvelopeDiskCache(), sentryOptions.getLogger(), sentryOptions.getDateProvider()), sentryOptions, rateLimiter2, iTransportGate, new HttpConnection(sentryOptions, requestDetails, rateLimiter2));
    }

    public AsyncHttpTransport(QueuedThreadPoolExecutor queuedThreadPoolExecutor, SentryOptions sentryOptions, RateLimiter rateLimiter2, ITransportGate iTransportGate, HttpConnection httpConnection) {
        this.currentRunnable = null;
        this.executor = (QueuedThreadPoolExecutor) Objects.requireNonNull(queuedThreadPoolExecutor, "executor is required");
        this.envelopeCache = (IEnvelopeCache) Objects.requireNonNull(sentryOptions.getEnvelopeDiskCache(), "envelopeCache is required");
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "options is required");
        this.rateLimiter = (RateLimiter) Objects.requireNonNull(rateLimiter2, "rateLimiter is required");
        this.transportGate = (ITransportGate) Objects.requireNonNull(iTransportGate, "transportGate is required");
        this.connection = (HttpConnection) Objects.requireNonNull(httpConnection, "httpConnection is required");
    }

    public void send(SentryEnvelope sentryEnvelope, Hint hint) throws IOException {
        IEnvelopeCache iEnvelopeCache = this.envelopeCache;
        boolean z = false;
        if (HintUtils.hasType(hint, Cached.class)) {
            iEnvelopeCache = NoOpEnvelopeCache.getInstance();
            this.options.getLogger().log(SentryLevel.DEBUG, "Captured Envelope is already cached", new Object[0]);
            z = true;
        }
        SentryEnvelope filter = this.rateLimiter.filter(sentryEnvelope, hint);
        if (filter != null) {
            if (HintUtils.hasType(hint, UncaughtExceptionHandlerIntegration.UncaughtExceptionHint.class)) {
                filter = this.options.getClientReportRecorder().attachReportToEnvelope(filter);
            }
            Future<?> submit = this.executor.submit(new EnvelopeSender(filter, hint, iEnvelopeCache));
            if (submit == null || !submit.isCancelled()) {
                HintUtils.runIfHasType(hint, Enqueable.class, new AsyncHttpTransport$$ExternalSyntheticLambda2(this));
            } else {
                this.options.getClientReportRecorder().recordLostEnvelope(DiscardReason.QUEUE_OVERFLOW, filter);
            }
        } else if (z) {
            this.envelopeCache.discard(sentryEnvelope);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$send$0$io-sentry-transport-AsyncHttpTransport  reason: not valid java name */
    public /* synthetic */ void m937lambda$send$0$iosentrytransportAsyncHttpTransport(Enqueable enqueable) {
        enqueable.markEnqueued();
        this.options.getLogger().log(SentryLevel.DEBUG, "Envelope enqueued", new Object[0]);
    }

    public void flush(long j) {
        this.executor.waitTillIdle(j);
    }

    private static QueuedThreadPoolExecutor initExecutor(int i, IEnvelopeCache iEnvelopeCache, ILogger iLogger, SentryDateProvider sentryDateProvider) {
        return new QueuedThreadPoolExecutor(1, i, new AsyncConnectionThreadFactory(), new AsyncHttpTransport$$ExternalSyntheticLambda3(iEnvelopeCache, iLogger), iLogger, sentryDateProvider);
    }

    static /* synthetic */ void lambda$initExecutor$1(IEnvelopeCache iEnvelopeCache, ILogger iLogger, Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        if (runnable instanceof EnvelopeSender) {
            EnvelopeSender envelopeSender = (EnvelopeSender) runnable;
            if (!HintUtils.hasType(envelopeSender.hint, Cached.class)) {
                iEnvelopeCache.store(envelopeSender.envelope, envelopeSender.hint);
            }
            markHintWhenSendingFailed(envelopeSender.hint, true);
            iLogger.log(SentryLevel.WARNING, "Envelope rejected", new Object[0]);
        }
    }

    public RateLimiter getRateLimiter() {
        return this.rateLimiter;
    }

    public boolean isHealthy() {
        return !this.rateLimiter.isAnyRateLimitActive() && !this.executor.didRejectRecently();
    }

    public void close() throws IOException {
        close(false);
    }

    public void close(boolean z) throws IOException {
        long j;
        this.executor.shutdown();
        this.options.getLogger().log(SentryLevel.DEBUG, "Shutting down", new Object[0]);
        if (z) {
            j = 0;
        } else {
            try {
                j = this.options.getFlushTimeoutMillis();
            } catch (InterruptedException unused) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Thread interrupted while closing the connection.", new Object[0]);
                Thread.currentThread().interrupt();
                return;
            }
        }
        if (!this.executor.awaitTermination(j, TimeUnit.MILLISECONDS)) {
            this.options.getLogger().log(SentryLevel.WARNING, "Failed to shutdown the async connection async sender  within " + j + " ms. Trying to force it now.", new Object[0]);
            this.executor.shutdownNow();
            if (this.currentRunnable != null) {
                this.executor.getRejectedExecutionHandler().rejectedExecution(this.currentRunnable, this.executor);
            }
        }
    }

    private static void markHintWhenSendingFailed(Hint hint, boolean z) {
        HintUtils.runIfHasType(hint, SubmissionResult.class, new AsyncHttpTransport$$ExternalSyntheticLambda0());
        HintUtils.runIfHasType(hint, Retryable.class, new AsyncHttpTransport$$ExternalSyntheticLambda1(z));
    }

    private static final class AsyncConnectionThreadFactory implements ThreadFactory {
        private int cnt;

        private AsyncConnectionThreadFactory() {
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder append = new StringBuilder().append("SentryAsyncConnection-");
            int i = this.cnt;
            this.cnt = i + 1;
            Thread thread = new Thread(runnable, append.append(i).toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    private final class EnvelopeSender implements Runnable {
        /* access modifiers changed from: private */
        public final SentryEnvelope envelope;
        private final IEnvelopeCache envelopeCache;
        private final TransportResult failedResult = TransportResult.error();
        /* access modifiers changed from: private */
        public final Hint hint;

        EnvelopeSender(SentryEnvelope sentryEnvelope, Hint hint2, IEnvelopeCache iEnvelopeCache) {
            this.envelope = (SentryEnvelope) Objects.requireNonNull(sentryEnvelope, "Envelope is required.");
            this.hint = hint2;
            this.envelopeCache = (IEnvelopeCache) Objects.requireNonNull(iEnvelopeCache, "EnvelopeCache is required.");
        }

        public void run() {
            Runnable unused = AsyncHttpTransport.this.currentRunnable = this;
            TransportResult transportResult = this.failedResult;
            try {
                transportResult = flush();
                AsyncHttpTransport.this.options.getLogger().log(SentryLevel.DEBUG, "Envelope flushed", new Object[0]);
                HintUtils.runIfHasType(this.hint, SubmissionResult.class, new AsyncHttpTransport$EnvelopeSender$$ExternalSyntheticLambda0(this, transportResult));
                Runnable unused2 = AsyncHttpTransport.this.currentRunnable = null;
            } catch (Throwable th) {
                HintUtils.runIfHasType(this.hint, SubmissionResult.class, new AsyncHttpTransport$EnvelopeSender$$ExternalSyntheticLambda0(this, transportResult));
                Runnable unused3 = AsyncHttpTransport.this.currentRunnable = null;
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$run$0$io-sentry-transport-AsyncHttpTransport$EnvelopeSender  reason: not valid java name */
        public /* synthetic */ void m942lambda$run$0$iosentrytransportAsyncHttpTransport$EnvelopeSender(TransportResult transportResult, SubmissionResult submissionResult) {
            AsyncHttpTransport.this.options.getLogger().log(SentryLevel.DEBUG, "Marking envelope submission result: %s", Boolean.valueOf(transportResult.isSuccess()));
            submissionResult.setResult(transportResult.isSuccess());
        }

        private TransportResult flush() {
            TransportResult transportResult = this.failedResult;
            this.envelope.getHeader().setSentAt((Date) null);
            this.envelopeCache.store(this.envelope, this.hint);
            HintUtils.runIfHasType(this.hint, DiskFlushNotification.class, new AsyncHttpTransport$EnvelopeSender$$ExternalSyntheticLambda1(this));
            if (AsyncHttpTransport.this.transportGate.isConnected()) {
                SentryEnvelope attachReportToEnvelope = AsyncHttpTransport.this.options.getClientReportRecorder().attachReportToEnvelope(this.envelope);
                try {
                    attachReportToEnvelope.getHeader().setSentAt(DateUtils.nanosToDate(AsyncHttpTransport.this.options.getDateProvider().now().nanoTimestamp()));
                    TransportResult send = AsyncHttpTransport.this.connection.send(attachReportToEnvelope);
                    if (send.isSuccess()) {
                        this.envelopeCache.discard(this.envelope);
                        return send;
                    }
                    String str = "The transport failed to send the envelope with response code " + send.getResponseCode();
                    AsyncHttpTransport.this.options.getLogger().log(SentryLevel.ERROR, str, new Object[0]);
                    if (send.getResponseCode() >= 400 && send.getResponseCode() != 429) {
                        HintUtils.runIfDoesNotHaveType(this.hint, Retryable.class, new AsyncHttpTransport$EnvelopeSender$$ExternalSyntheticLambda2(this, attachReportToEnvelope));
                    }
                    throw new IllegalStateException(str);
                } catch (IOException e) {
                    HintUtils.runIfHasType(this.hint, Retryable.class, new AsyncHttpTransport$EnvelopeSender$$ExternalSyntheticLambda3(), new AsyncHttpTransport$EnvelopeSender$$ExternalSyntheticLambda4(this, attachReportToEnvelope));
                    throw new IllegalStateException("Sending the event failed.", e);
                }
            } else {
                HintUtils.runIfHasType(this.hint, Retryable.class, new AsyncHttpTransport$EnvelopeSender$$ExternalSyntheticLambda5(), new AsyncHttpTransport$EnvelopeSender$$ExternalSyntheticLambda6(this));
                return transportResult;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$flush$1$io-sentry-transport-AsyncHttpTransport$EnvelopeSender  reason: not valid java name */
        public /* synthetic */ void m938lambda$flush$1$iosentrytransportAsyncHttpTransport$EnvelopeSender(DiskFlushNotification diskFlushNotification) {
            if (diskFlushNotification.isFlushable(this.envelope.getHeader().getEventId())) {
                diskFlushNotification.markFlushed();
                AsyncHttpTransport.this.options.getLogger().log(SentryLevel.DEBUG, "Disk flush envelope fired", new Object[0]);
                return;
            }
            AsyncHttpTransport.this.options.getLogger().log(SentryLevel.DEBUG, "Not firing envelope flush as there's an ongoing transaction", new Object[0]);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$flush$2$io-sentry-transport-AsyncHttpTransport$EnvelopeSender  reason: not valid java name */
        public /* synthetic */ void m939lambda$flush$2$iosentrytransportAsyncHttpTransport$EnvelopeSender(SentryEnvelope sentryEnvelope, Object obj) {
            AsyncHttpTransport.this.options.getClientReportRecorder().recordLostEnvelope(DiscardReason.NETWORK_ERROR, sentryEnvelope);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$flush$4$io-sentry-transport-AsyncHttpTransport$EnvelopeSender  reason: not valid java name */
        public /* synthetic */ void m940lambda$flush$4$iosentrytransportAsyncHttpTransport$EnvelopeSender(SentryEnvelope sentryEnvelope, Object obj, Class cls) {
            LogUtils.logNotInstanceOf(cls, obj, AsyncHttpTransport.this.options.getLogger());
            AsyncHttpTransport.this.options.getClientReportRecorder().recordLostEnvelope(DiscardReason.NETWORK_ERROR, sentryEnvelope);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$flush$6$io-sentry-transport-AsyncHttpTransport$EnvelopeSender  reason: not valid java name */
        public /* synthetic */ void m941lambda$flush$6$iosentrytransportAsyncHttpTransport$EnvelopeSender(Object obj, Class cls) {
            LogUtils.logNotInstanceOf(cls, obj, AsyncHttpTransport.this.options.getLogger());
            AsyncHttpTransport.this.options.getClientReportRecorder().recordLostEnvelope(DiscardReason.NETWORK_ERROR, this.envelope);
        }
    }
}
