package io.sentry.cache;

import io.sentry.DateUtils;
import io.sentry.Hint;
import io.sentry.SentryCrashLastRunState;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryItemType;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.hints.AbnormalExit;
import io.sentry.hints.SessionEnd;
import io.sentry.hints.SessionStart;
import io.sentry.transport.NoOpEnvelopeCache;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class EnvelopeCache extends CacheStrategy implements IEnvelopeCache {
    public static final String CRASH_MARKER_FILE = "last_crash";
    public static final String NATIVE_CRASH_MARKER_FILE = ".sentry-native/last_crash";
    public static final String PREFIX_CURRENT_SESSION_FILE = "session";
    public static final String PREFIX_PREVIOUS_SESSION_FILE = "previous_session";
    public static final String STARTUP_CRASH_MARKER_FILE = "startup_crash";
    public static final String SUFFIX_ENVELOPE_FILE = ".envelope";
    static final String SUFFIX_SESSION_FILE = ".json";
    private final Map<SentryEnvelope, String> fileNameMap = new WeakHashMap();
    private final CountDownLatch previousSessionLatch = new CountDownLatch(1);

    public static IEnvelopeCache create(SentryOptions sentryOptions) {
        String cacheDirPath = sentryOptions.getCacheDirPath();
        int maxCacheItems = sentryOptions.getMaxCacheItems();
        if (cacheDirPath != null) {
            return new EnvelopeCache(sentryOptions, cacheDirPath, maxCacheItems);
        }
        sentryOptions.getLogger().log(SentryLevel.WARNING, "cacheDirPath is null, returning NoOpEnvelopeCache", new Object[0]);
        return NoOpEnvelopeCache.getInstance();
    }

    public EnvelopeCache(SentryOptions sentryOptions, String str, int i) {
        super(sentryOptions, str, i);
    }

    public void store(SentryEnvelope sentryEnvelope, Hint hint) {
        BufferedReader bufferedReader;
        Objects.requireNonNull(sentryEnvelope, "Envelope is required.");
        rotateCacheIfNeeded(allEnvelopeFiles());
        File currentSessionFile = getCurrentSessionFile(this.directory.getAbsolutePath());
        File previousSessionFile = getPreviousSessionFile(this.directory.getAbsolutePath());
        if (HintUtils.hasType(hint, SessionEnd.class) && !currentSessionFile.delete()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Current envelope doesn't exist.", new Object[0]);
        }
        if (HintUtils.hasType(hint, AbnormalExit.class)) {
            tryEndPreviousSession(hint);
        }
        if (HintUtils.hasType(hint, SessionStart.class)) {
            if (currentSessionFile.exists()) {
                this.options.getLogger().log(SentryLevel.WARNING, "Current session is not ended, we'd need to end it.", new Object[0]);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(currentSessionFile), UTF_8));
                    Session session = (Session) this.serializer.deserialize(bufferedReader, Session.class);
                    if (session != null) {
                        writeSessionToDisk(previousSessionFile, session);
                    }
                    bufferedReader.close();
                } catch (Throwable th) {
                    this.options.getLogger().log(SentryLevel.ERROR, "Error processing session.", th);
                }
            }
            updateCurrentSession(currentSessionFile, sentryEnvelope);
            boolean exists = new File(this.options.getCacheDirPath(), NATIVE_CRASH_MARKER_FILE).exists();
            if (!exists) {
                File file = new File(this.options.getCacheDirPath(), CRASH_MARKER_FILE);
                if (file.exists()) {
                    this.options.getLogger().log(SentryLevel.INFO, "Crash marker file exists, crashedLastRun will return true.", new Object[0]);
                    if (!file.delete()) {
                        this.options.getLogger().log(SentryLevel.ERROR, "Failed to delete the crash marker file. %s.", file.getAbsolutePath());
                    }
                    exists = true;
                }
            }
            SentryCrashLastRunState.getInstance().setCrashedLastRun(exists);
            flushPreviousSession();
        }
        File envelopeFile = getEnvelopeFile(sentryEnvelope);
        if (envelopeFile.exists()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Not adding Envelope to offline storage because it already exists: %s", envelopeFile.getAbsolutePath());
            return;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Adding Envelope to offline storage: %s", envelopeFile.getAbsolutePath());
        writeEnvelopeToDisk(envelopeFile, sentryEnvelope);
        if (HintUtils.hasType(hint, UncaughtExceptionHandlerIntegration.UncaughtExceptionHint.class)) {
            writeCrashMarkerFile();
            return;
        }
        return;
        throw th;
    }

    private void tryEndPreviousSession(Hint hint) {
        BufferedReader bufferedReader;
        Date date;
        Object sentrySdkHint = HintUtils.getSentrySdkHint(hint);
        if (sentrySdkHint instanceof AbnormalExit) {
            File previousSessionFile = getPreviousSessionFile(this.directory.getAbsolutePath());
            if (previousSessionFile.exists()) {
                this.options.getLogger().log(SentryLevel.WARNING, "Previous session is not ended, we'd need to end it.", new Object[0]);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(previousSessionFile), UTF_8));
                    Session session = (Session) this.serializer.deserialize(bufferedReader, Session.class);
                    if (session != null) {
                        AbnormalExit abnormalExit = (AbnormalExit) sentrySdkHint;
                        Long timestamp = abnormalExit.timestamp();
                        if (timestamp != null) {
                            date = DateUtils.getDateTime(timestamp.longValue());
                            Date started = session.getStarted();
                            if (started == null || date.before(started)) {
                                this.options.getLogger().log(SentryLevel.WARNING, "Abnormal exit happened before previous session start, not ending the session.", new Object[0]);
                                bufferedReader.close();
                                return;
                            }
                        } else {
                            date = null;
                        }
                        session.update(Session.State.Abnormal, (String) null, true, abnormalExit.mechanism());
                        session.end(date);
                        writeSessionToDisk(previousSessionFile, session);
                    }
                    bufferedReader.close();
                    return;
                } catch (Throwable th) {
                    this.options.getLogger().log(SentryLevel.ERROR, "Error processing previous session.", th);
                    return;
                }
            } else {
                this.options.getLogger().log(SentryLevel.DEBUG, "No previous session file to end.", new Object[0]);
                return;
            }
        } else {
            return;
        }
        throw th;
    }

    private void writeCrashMarkerFile() {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File(this.options.getCacheDirPath(), CRASH_MARKER_FILE));
            fileOutputStream.write(DateUtils.getTimestamp(DateUtils.getCurrentDateTime()).getBytes(UTF_8));
            fileOutputStream.flush();
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error writing the crash marker file to the disk", th);
            return;
        }
        throw th;
    }

    private void updateCurrentSession(File file, SentryEnvelope sentryEnvelope) {
        BufferedReader bufferedReader;
        Iterable<SentryEnvelopeItem> items = sentryEnvelope.getItems();
        if (items.iterator().hasNext()) {
            SentryEnvelopeItem next = items.iterator().next();
            if (SentryItemType.Session.equals(next.getHeader().getType())) {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(next.getData()), UTF_8));
                    Session session = (Session) this.serializer.deserialize(bufferedReader, Session.class);
                    if (session == null) {
                        this.options.getLogger().log(SentryLevel.ERROR, "Item of type %s returned null by the parser.", next.getHeader().getType());
                    } else {
                        writeSessionToDisk(file, session);
                    }
                    bufferedReader.close();
                    return;
                } catch (Throwable th) {
                    this.options.getLogger().log(SentryLevel.ERROR, "Item failed to process.", th);
                    return;
                }
            } else {
                this.options.getLogger().log(SentryLevel.INFO, "Current envelope has a different envelope type %s", next.getHeader().getType());
                return;
            }
        } else {
            this.options.getLogger().log(SentryLevel.INFO, "Current envelope %s is empty", file.getAbsolutePath());
            return;
        }
        throw th;
    }

    private void writeEnvelopeToDisk(File file, SentryEnvelope sentryEnvelope) {
        FileOutputStream fileOutputStream;
        if (file.exists()) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Overwriting envelope to offline storage: %s", file.getAbsolutePath());
            if (!file.delete()) {
                this.options.getLogger().log(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
        try {
            fileOutputStream = new FileOutputStream(file);
            this.serializer.serialize(sentryEnvelope, (OutputStream) fileOutputStream);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, th, "Error writing Envelope %s to offline storage", file.getAbsolutePath());
            return;
        }
        throw th;
    }

    private void writeSessionToDisk(File file, Session session) {
        BufferedWriter bufferedWriter;
        if (file.exists()) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Overwriting session to offline storage: %s", session.getSessionId());
            if (!file.delete()) {
                this.options.getLogger().log(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, UTF_8));
                this.serializer.serialize(session, (Writer) bufferedWriter);
                bufferedWriter.close();
                fileOutputStream.close();
                return;
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
            throw th;
        } catch (Throwable th2) {
            this.options.getLogger().log(SentryLevel.ERROR, th2, "Error writing Session to offline storage: %s", session.getSessionId());
        }
    }

    public void discard(SentryEnvelope sentryEnvelope) {
        Objects.requireNonNull(sentryEnvelope, "Envelope is required.");
        File envelopeFile = getEnvelopeFile(sentryEnvelope);
        if (envelopeFile.exists()) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Discarding envelope from cache: %s", envelopeFile.getAbsolutePath());
            if (!envelopeFile.delete()) {
                this.options.getLogger().log(SentryLevel.ERROR, "Failed to delete envelope: %s", envelopeFile.getAbsolutePath());
                return;
            }
            return;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Envelope was not cached: %s", envelopeFile.getAbsolutePath());
    }

    private synchronized File getEnvelopeFile(SentryEnvelope sentryEnvelope) {
        String str;
        if (this.fileNameMap.containsKey(sentryEnvelope)) {
            str = this.fileNameMap.get(sentryEnvelope);
        } else {
            String str2 = UUID.randomUUID() + SUFFIX_ENVELOPE_FILE;
            this.fileNameMap.put(sentryEnvelope, str2);
            str = str2;
        }
        return new File(this.directory.getAbsolutePath(), str);
    }

    public static File getCurrentSessionFile(String str) {
        return new File(str, "session.json");
    }

    public static File getPreviousSessionFile(String str) {
        return new File(str, "previous_session.json");
    }

    public Iterator<SentryEnvelope> iterator() {
        BufferedInputStream bufferedInputStream;
        File[] allEnvelopeFiles = allEnvelopeFiles();
        ArrayList arrayList = new ArrayList(allEnvelopeFiles.length);
        for (File file : allEnvelopeFiles) {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                arrayList.add(this.serializer.deserializeEnvelope(bufferedInputStream));
                bufferedInputStream.close();
            } catch (FileNotFoundException unused) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Envelope file '%s' disappeared while converting all cached files to envelopes.", file.getAbsolutePath());
            } catch (IOException e) {
                this.options.getLogger().log(SentryLevel.ERROR, String.format("Error while reading cached envelope from file %s", new Object[]{file.getAbsolutePath()}), (Throwable) e);
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        return arrayList.iterator();
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r2.directory.listFiles(new io.sentry.cache.EnvelopeCache$$ExternalSyntheticLambda0());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File[] allEnvelopeFiles() {
        /*
            r2 = this;
            boolean r0 = r2.isDirectoryValid()
            if (r0 == 0) goto L_0x0014
            java.io.File r0 = r2.directory
            io.sentry.cache.EnvelopeCache$$ExternalSyntheticLambda0 r1 = new io.sentry.cache.EnvelopeCache$$ExternalSyntheticLambda0
            r1.<init>()
            java.io.File[] r0 = r0.listFiles(r1)
            if (r0 == 0) goto L_0x0014
            return r0
        L_0x0014:
            r0 = 0
            java.io.File[] r0 = new java.io.File[r0]
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.cache.EnvelopeCache.allEnvelopeFiles():java.io.File[]");
    }

    public boolean waitPreviousSessionFlush() {
        try {
            return this.previousSessionLatch.await(this.options.getSessionFlushTimeoutMillis(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            this.options.getLogger().log(SentryLevel.DEBUG, "Timed out waiting for previous session to flush.", new Object[0]);
            return false;
        }
    }

    public void flushPreviousSession() {
        this.previousSessionLatch.countDown();
    }
}
