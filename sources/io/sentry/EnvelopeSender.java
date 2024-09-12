package io.sentry;

import io.sentry.cache.EnvelopeCache;
import io.sentry.hints.Flushable;
import io.sentry.hints.Retryable;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class EnvelopeSender extends DirectoryProcessor implements IEnvelopeSender {
    private final IHub hub;
    private final ILogger logger;
    private final ISerializer serializer;

    public /* bridge */ /* synthetic */ void processDirectory(File file) {
        super.processDirectory(file);
    }

    public EnvelopeSender(IHub iHub, ISerializer iSerializer, ILogger iLogger, long j, int i) {
        super(iHub, iLogger, j, i);
        this.hub = (IHub) Objects.requireNonNull(iHub, "Hub is required.");
        this.serializer = (ISerializer) Objects.requireNonNull(iSerializer, "Serializer is required.");
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "Logger is required.");
    }

    /* access modifiers changed from: protected */
    public void processFile(File file, Hint hint) {
        EnvelopeSender$$ExternalSyntheticLambda1 envelopeSender$$ExternalSyntheticLambda1;
        ILogger iLogger;
        Class<Retryable> cls;
        BufferedInputStream bufferedInputStream;
        if (!file.isFile()) {
            this.logger.log(SentryLevel.DEBUG, "'%s' is not a file.", file.getAbsolutePath());
            return;
        } else if (!isRelevantFileName(file.getName())) {
            this.logger.log(SentryLevel.DEBUG, "File '%s' doesn't match extension expected.", file.getAbsolutePath());
            return;
        } else if (!file.getParentFile().canWrite()) {
            this.logger.log(SentryLevel.WARNING, "File '%s' cannot be deleted so it will not be processed.", file.getAbsolutePath());
            return;
        } else {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                SentryEnvelope deserializeEnvelope = this.serializer.deserializeEnvelope(bufferedInputStream);
                if (deserializeEnvelope == null) {
                    this.logger.log(SentryLevel.ERROR, "Failed to deserialize cached envelope %s", file.getAbsolutePath());
                } else {
                    this.hub.captureEnvelope(deserializeEnvelope, hint);
                }
                HintUtils.runIfHasTypeLogIfNot(hint, Flushable.class, this.logger, new EnvelopeSender$$ExternalSyntheticLambda0(this));
                bufferedInputStream.close();
                cls = Retryable.class;
                iLogger = this.logger;
                envelopeSender$$ExternalSyntheticLambda1 = new EnvelopeSender$$ExternalSyntheticLambda1(this, file);
            } catch (FileNotFoundException e) {
                this.logger.log(SentryLevel.ERROR, e, "File '%s' cannot be found.", file.getAbsolutePath());
                cls = Retryable.class;
                iLogger = this.logger;
                envelopeSender$$ExternalSyntheticLambda1 = new EnvelopeSender$$ExternalSyntheticLambda1(this, file);
            } catch (IOException e2) {
                this.logger.log(SentryLevel.ERROR, e2, "I/O on file '%s' failed.", file.getAbsolutePath());
                cls = Retryable.class;
                iLogger = this.logger;
                envelopeSender$$ExternalSyntheticLambda1 = new EnvelopeSender$$ExternalSyntheticLambda1(this, file);
            } catch (Throwable th) {
                try {
                    this.logger.log(SentryLevel.ERROR, th, "Failed to capture cached envelope %s", file.getAbsolutePath());
                    HintUtils.runIfHasTypeLogIfNot(hint, Retryable.class, this.logger, new EnvelopeSender$$ExternalSyntheticLambda2(this, th, file));
                    cls = Retryable.class;
                    iLogger = this.logger;
                    envelopeSender$$ExternalSyntheticLambda1 = new EnvelopeSender$$ExternalSyntheticLambda1(this, file);
                } catch (Throwable th2) {
                    HintUtils.runIfHasTypeLogIfNot(hint, Retryable.class, this.logger, new EnvelopeSender$$ExternalSyntheticLambda1(this, file));
                    throw th2;
                }
            }
            HintUtils.runIfHasTypeLogIfNot(hint, cls, iLogger, envelopeSender$$ExternalSyntheticLambda1);
            return;
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$processFile$0$io-sentry-EnvelopeSender  reason: not valid java name */
    public /* synthetic */ void m868lambda$processFile$0$iosentryEnvelopeSender(Flushable flushable) {
        if (!flushable.waitFlush()) {
            this.logger.log(SentryLevel.WARNING, "Timed out waiting for envelope submission.", new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$processFile$1$io-sentry-EnvelopeSender  reason: not valid java name */
    public /* synthetic */ void m869lambda$processFile$1$iosentryEnvelopeSender(Throwable th, File file, Retryable retryable) {
        retryable.setRetry(false);
        this.logger.log(SentryLevel.INFO, th, "File '%s' won't retry.", file.getAbsolutePath());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$processFile$2$io-sentry-EnvelopeSender  reason: not valid java name */
    public /* synthetic */ void m870lambda$processFile$2$iosentryEnvelopeSender(File file, Retryable retryable) {
        if (!retryable.isRetry()) {
            safeDelete(file, "after trying to capture it");
            this.logger.log(SentryLevel.DEBUG, "Deleted file %s.", file.getAbsolutePath());
            return;
        }
        this.logger.log(SentryLevel.INFO, "File not deleted since retry was marked. %s.", file.getAbsolutePath());
    }

    /* access modifiers changed from: protected */
    public boolean isRelevantFileName(String str) {
        return str.endsWith(EnvelopeCache.SUFFIX_ENVELOPE_FILE);
    }

    public void processEnvelopeFile(String str, Hint hint) {
        Objects.requireNonNull(str, "Path is required.");
        processFile(new File(str), hint);
    }

    private void safeDelete(File file, String str) {
        try {
            if (!file.delete()) {
                this.logger.log(SentryLevel.ERROR, "Failed to delete '%s' %s", file.getAbsolutePath(), str);
            }
        } catch (Throwable th) {
            this.logger.log(SentryLevel.ERROR, th, "Failed to delete '%s' %s", file.getAbsolutePath(), str);
        }
    }
}
