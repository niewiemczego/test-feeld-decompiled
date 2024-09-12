package io.sentry.android.core;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import io.sentry.Attachment;
import io.sentry.DateUtils;
import io.sentry.Hint;
import io.sentry.IHub;
import io.sentry.ILogger;
import io.sentry.Integration;
import io.sentry.SentryEvent;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.cache.AndroidEnvelopeCache;
import io.sentry.android.core.internal.threaddump.Lines;
import io.sentry.android.core.internal.threaddump.ThreadDumpParser;
import io.sentry.cache.EnvelopeCache;
import io.sentry.cache.IEnvelopeCache;
import io.sentry.hints.AbnormalExit;
import io.sentry.hints.Backfillable;
import io.sentry.hints.BlockingFlushHint;
import io.sentry.protocol.Message;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryThread;
import io.sentry.transport.CurrentDateProvider;
import io.sentry.transport.ICurrentDateProvider;
import io.sentry.util.HintUtils;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AnrV2Integration implements Integration, Closeable {
    static final long NINETY_DAYS_THRESHOLD = TimeUnit.DAYS.toMillis(91);
    private final Context context;
    private final ICurrentDateProvider dateProvider;
    private SentryAndroidOptions options;

    public AnrV2Integration(Context context2) {
        this(context2, CurrentDateProvider.getInstance());
    }

    AnrV2Integration(Context context2, ICurrentDateProvider iCurrentDateProvider) {
        this.context = context2;
        this.dateProvider = iCurrentDateProvider;
    }

    public void register(IHub iHub, SentryOptions sentryOptions) {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) Objects.requireNonNull(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.options = sentryAndroidOptions;
        sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "AnrIntegration enabled: %s", Boolean.valueOf(this.options.isAnrEnabled()));
        if (this.options.getCacheDirPath() == null) {
            this.options.getLogger().log(SentryLevel.INFO, "Cache dir is not set, unable to process ANRs", new Object[0]);
        } else if (this.options.isAnrEnabled()) {
            try {
                sentryOptions.getExecutorService().submit((Runnable) new AnrProcessor(this.context, iHub, this.options, this.dateProvider));
            } catch (Throwable th) {
                sentryOptions.getLogger().log(SentryLevel.DEBUG, "Failed to start AnrProcessor.", th);
            }
            sentryOptions.getLogger().log(SentryLevel.DEBUG, "AnrV2Integration installed.", new Object[0]);
            IntegrationUtils.addIntegrationToSdkVersion(getClass());
        }
    }

    public void close() throws IOException {
        SentryAndroidOptions sentryAndroidOptions = this.options;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "AnrV2Integration removed.", new Object[0]);
        }
    }

    static class AnrProcessor implements Runnable {
        private final Context context;
        private final IHub hub;
        private final SentryAndroidOptions options;
        private final long threshold;

        AnrProcessor(Context context2, IHub iHub, SentryAndroidOptions sentryAndroidOptions, ICurrentDateProvider iCurrentDateProvider) {
            this.context = context2;
            this.hub = iHub;
            this.options = sentryAndroidOptions;
            this.threshold = iCurrentDateProvider.getCurrentTimeMillis() - AnrV2Integration.NINETY_DAYS_THRESHOLD;
        }

        public void run() {
            ApplicationExitInfo applicationExitInfo = null;
            List historicalProcessExitReasons = ((ActivityManager) this.context.getSystemService("activity")).getHistoricalProcessExitReasons((String) null, 0, 0);
            if (historicalProcessExitReasons.size() == 0) {
                this.options.getLogger().log(SentryLevel.DEBUG, "No records in historical exit reasons.", new Object[0]);
                return;
            }
            IEnvelopeCache envelopeDiskCache = this.options.getEnvelopeDiskCache();
            if ((envelopeDiskCache instanceof EnvelopeCache) && this.options.isEnableAutoSessionTracking()) {
                EnvelopeCache envelopeCache = (EnvelopeCache) envelopeDiskCache;
                if (!envelopeCache.waitPreviousSessionFlush()) {
                    this.options.getLogger().log(SentryLevel.WARNING, "Timed out waiting to flush previous session to its own file.", new Object[0]);
                    envelopeCache.flushPreviousSession();
                }
            }
            ArrayList arrayList = new ArrayList(historicalProcessExitReasons);
            Long lastReportedAnr = AndroidEnvelopeCache.lastReportedAnr(this.options);
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ApplicationExitInfo applicationExitInfo2 = (ApplicationExitInfo) it.next();
                if (applicationExitInfo2.getReason() == 6) {
                    arrayList.remove(applicationExitInfo2);
                    applicationExitInfo = applicationExitInfo2;
                    break;
                }
            }
            if (applicationExitInfo == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, "No ANRs have been found in the historical exit reasons list.", new Object[0]);
            } else if (applicationExitInfo.getTimestamp() < this.threshold) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Latest ANR happened too long ago, returning early.", new Object[0]);
            } else if (lastReportedAnr == null || applicationExitInfo.getTimestamp() > lastReportedAnr.longValue()) {
                if (this.options.isReportHistoricalAnrs()) {
                    reportNonEnrichedHistoricalAnrs(arrayList, lastReportedAnr);
                }
                reportAsSentryEvent(applicationExitInfo, true);
            } else {
                this.options.getLogger().log(SentryLevel.DEBUG, "Latest ANR has already been reported, returning early.", new Object[0]);
            }
        }

        private void reportNonEnrichedHistoricalAnrs(List<ApplicationExitInfo> list, Long l) {
            Collections.reverse(list);
            for (ApplicationExitInfo next : list) {
                if (next.getReason() == 6) {
                    if (next.getTimestamp() < this.threshold) {
                        this.options.getLogger().log(SentryLevel.DEBUG, "ANR happened too long ago %s.", next);
                    } else if (l == null || next.getTimestamp() > l.longValue()) {
                        reportAsSentryEvent(next, false);
                    } else {
                        this.options.getLogger().log(SentryLevel.DEBUG, "ANR has already been reported %s.", next);
                    }
                }
            }
        }

        private void reportAsSentryEvent(ApplicationExitInfo applicationExitInfo, boolean z) {
            long timestamp = applicationExitInfo.getTimestamp();
            boolean z2 = applicationExitInfo.getImportance() != 100;
            ParseResult parseThreadDump = parseThreadDump(applicationExitInfo, z2);
            if (parseThreadDump.type == ParseResult.Type.NO_DUMP) {
                this.options.getLogger().log(SentryLevel.WARNING, "Not reporting ANR event as there was no thread dump for the ANR %s", applicationExitInfo.toString());
                return;
            }
            AnrV2Hint anrV2Hint = new AnrV2Hint(this.options.getFlushTimeoutMillis(), this.options.getLogger(), timestamp, z, z2);
            Hint createWithTypeCheckHint = HintUtils.createWithTypeCheckHint(anrV2Hint);
            SentryEvent sentryEvent = new SentryEvent();
            if (parseThreadDump.type == ParseResult.Type.ERROR) {
                Message message = new Message();
                message.setFormatted("Sentry Android SDK failed to parse system thread dump for this ANR. We recommend enabling [SentryOptions.isAttachAnrThreadDump] option to attach the thread dump as plain text and report this issue on GitHub.");
                sentryEvent.setMessage(message);
            } else if (parseThreadDump.type == ParseResult.Type.DUMP) {
                sentryEvent.setThreads(parseThreadDump.threads);
            }
            sentryEvent.setLevel(SentryLevel.FATAL);
            sentryEvent.setTimestamp(DateUtils.getDateTime(timestamp));
            if (this.options.isAttachAnrThreadDump() && parseThreadDump.dump != null) {
                createWithTypeCheckHint.setThreadDump(Attachment.fromThreadDump(parseThreadDump.dump));
            }
            if (!this.hub.captureEvent(sentryEvent, createWithTypeCheckHint).equals(SentryId.EMPTY_ID) && !anrV2Hint.waitFlush()) {
                this.options.getLogger().log(SentryLevel.WARNING, "Timed out waiting to flush ANR event to disk. Event: %s", sentryEvent.getEventId());
            }
        }

        private ParseResult parseThreadDump(ApplicationExitInfo applicationExitInfo, boolean z) {
            InputStream traceInputStream;
            BufferedReader bufferedReader;
            try {
                traceInputStream = applicationExitInfo.getTraceInputStream();
                if (traceInputStream == null) {
                    ParseResult parseResult = new ParseResult(ParseResult.Type.NO_DUMP);
                    if (traceInputStream != null) {
                        traceInputStream.close();
                    }
                    return parseResult;
                }
                byte[] dumpBytes = getDumpBytes(traceInputStream);
                if (traceInputStream != null) {
                    traceInputStream.close();
                }
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(dumpBytes)));
                    List<SentryThread> parse = new ThreadDumpParser(this.options, z).parse(Lines.readLines(bufferedReader));
                    if (parse.isEmpty()) {
                        ParseResult parseResult2 = new ParseResult(ParseResult.Type.ERROR, dumpBytes);
                        bufferedReader.close();
                        return parseResult2;
                    }
                    ParseResult parseResult3 = new ParseResult(ParseResult.Type.DUMP, dumpBytes, parse);
                    bufferedReader.close();
                    return parseResult3;
                } catch (Throwable th) {
                    this.options.getLogger().log(SentryLevel.WARNING, "Failed to parse ANR thread dump", th);
                    return new ParseResult(ParseResult.Type.ERROR, dumpBytes);
                }
                throw th;
                throw th;
            } catch (Throwable th2) {
                this.options.getLogger().log(SentryLevel.WARNING, "Failed to read ANR thread dump", th2);
                return new ParseResult(ParseResult.Type.NO_DUMP);
            }
        }

        private byte[] getDumpBytes(InputStream inputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        return byteArray;
                    }
                }
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }
    }

    public static final class AnrV2Hint extends BlockingFlushHint implements Backfillable, AbnormalExit {
        private final boolean isBackgroundAnr;
        private final boolean shouldEnrich;
        private final long timestamp;

        public boolean ignoreCurrentThread() {
            return false;
        }

        public boolean isFlushable(SentryId sentryId) {
            return true;
        }

        public void setFlushable(SentryId sentryId) {
        }

        public AnrV2Hint(long j, ILogger iLogger, long j2, boolean z, boolean z2) {
            super(j, iLogger);
            this.timestamp = j2;
            this.shouldEnrich = z;
            this.isBackgroundAnr = z2;
        }

        public Long timestamp() {
            return Long.valueOf(this.timestamp);
        }

        public boolean shouldEnrich() {
            return this.shouldEnrich;
        }

        public String mechanism() {
            return this.isBackgroundAnr ? "anr_background" : "anr_foreground";
        }
    }

    static final class ParseResult {
        final byte[] dump;
        final List<SentryThread> threads;
        final Type type;

        enum Type {
            DUMP,
            NO_DUMP,
            ERROR
        }

        ParseResult(Type type2) {
            this.type = type2;
            this.dump = null;
            this.threads = null;
        }

        ParseResult(Type type2, byte[] bArr) {
            this.type = type2;
            this.dump = bArr;
            this.threads = null;
        }

        ParseResult(Type type2, byte[] bArr, List<SentryThread> list) {
            this.type = type2;
            this.dump = bArr;
            this.threads = list;
        }
    }
}
