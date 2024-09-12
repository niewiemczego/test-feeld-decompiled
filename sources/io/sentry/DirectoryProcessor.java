package io.sentry;

import io.sentry.hints.Cached;
import io.sentry.hints.Enqueable;
import io.sentry.hints.Flushable;
import io.sentry.hints.Retryable;
import io.sentry.hints.SubmissionResult;
import io.sentry.transport.RateLimiter;
import io.sentry.util.HintUtils;
import java.io.File;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

abstract class DirectoryProcessor {
    private static final long ENVELOPE_PROCESSING_DELAY = 100;
    private final long flushTimeoutMillis;
    private final IHub hub;
    private final ILogger logger;
    private final Queue<String> processedEnvelopes;

    /* access modifiers changed from: protected */
    public abstract boolean isRelevantFileName(String str);

    /* access modifiers changed from: protected */
    public abstract void processFile(File file, Hint hint);

    DirectoryProcessor(IHub iHub, ILogger iLogger, long j, int i) {
        this.hub = iHub;
        this.logger = iLogger;
        this.flushTimeoutMillis = j;
        this.processedEnvelopes = SynchronizedQueue.synchronizedQueue(new CircularFifoQueue(i));
    }

    public void processDirectory(File file) {
        try {
            this.logger.log(SentryLevel.DEBUG, "Processing dir. %s", file.getAbsolutePath());
            if (!file.exists()) {
                this.logger.log(SentryLevel.WARNING, "Directory '%s' doesn't exist. No cached events to send.", file.getAbsolutePath());
            } else if (!file.isDirectory()) {
                this.logger.log(SentryLevel.ERROR, "Cache dir %s is not a directory.", file.getAbsolutePath());
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    this.logger.log(SentryLevel.ERROR, "Cache dir %s is null.", file.getAbsolutePath());
                    return;
                }
                File[] listFiles2 = file.listFiles(new DirectoryProcessor$$ExternalSyntheticLambda0(this));
                ILogger iLogger = this.logger;
                SentryLevel sentryLevel = SentryLevel.DEBUG;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(listFiles2 != null ? listFiles2.length : 0);
                objArr[1] = file.getAbsolutePath();
                iLogger.log(sentryLevel, "Processing %d items from cache dir %s", objArr);
                for (File file2 : listFiles) {
                    if (!file2.isFile()) {
                        this.logger.log(SentryLevel.DEBUG, "File %s is not a File.", file2.getAbsolutePath());
                    } else {
                        String absolutePath = file2.getAbsolutePath();
                        if (this.processedEnvelopes.contains(absolutePath)) {
                            this.logger.log(SentryLevel.DEBUG, "File '%s' has already been processed so it will not be processed again.", absolutePath);
                        } else {
                            RateLimiter rateLimiter = this.hub.getRateLimiter();
                            if (rateLimiter == null || !rateLimiter.isActiveForCategory(DataCategory.All)) {
                                this.logger.log(SentryLevel.DEBUG, "Processing file: %s", absolutePath);
                                processFile(file2, HintUtils.createWithTypeCheckHint(new SendCachedEnvelopeHint(this.flushTimeoutMillis, this.logger, absolutePath, this.processedEnvelopes)));
                                Thread.sleep(ENVELOPE_PROCESSING_DELAY);
                            } else {
                                this.logger.log(SentryLevel.INFO, "DirectoryProcessor, rate limiting active.", new Object[0]);
                                return;
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            this.logger.log(SentryLevel.ERROR, th, "Failed processing '%s'", file.getAbsolutePath());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$processDirectory$0$io-sentry-DirectoryProcessor  reason: not valid java name */
    public /* synthetic */ boolean m867lambda$processDirectory$0$iosentryDirectoryProcessor(File file, String str) {
        return isRelevantFileName(str);
    }

    private static final class SendCachedEnvelopeHint implements Cached, Retryable, SubmissionResult, Flushable, Enqueable {
        private final String filePath;
        private final long flushTimeoutMillis;
        private final CountDownLatch latch;
        private final ILogger logger;
        private final Queue<String> processedEnvelopes;
        boolean retry = false;
        boolean succeeded = false;

        public SendCachedEnvelopeHint(long j, ILogger iLogger, String str, Queue<String> queue) {
            this.flushTimeoutMillis = j;
            this.filePath = str;
            this.processedEnvelopes = queue;
            this.latch = new CountDownLatch(1);
            this.logger = iLogger;
        }

        public boolean isRetry() {
            return this.retry;
        }

        public void setRetry(boolean z) {
            this.retry = z;
        }

        public boolean waitFlush() {
            try {
                return this.latch.await(this.flushTimeoutMillis, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                this.logger.log(SentryLevel.ERROR, "Exception while awaiting on lock.", (Throwable) e);
                return false;
            }
        }

        public void setResult(boolean z) {
            this.succeeded = z;
            this.latch.countDown();
        }

        public boolean isSuccess() {
            return this.succeeded;
        }

        public void markEnqueued() {
            this.processedEnvelopes.add(this.filePath);
        }
    }
}
