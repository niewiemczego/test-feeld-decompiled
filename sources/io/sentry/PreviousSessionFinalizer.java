package io.sentry;

import io.sentry.Session;
import io.sentry.cache.EnvelopeCache;
import io.sentry.cache.IEnvelopeCache;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Date;

final class PreviousSessionFinalizer implements Runnable {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final IHub hub;
    private final SentryOptions options;

    PreviousSessionFinalizer(SentryOptions sentryOptions, IHub iHub) {
        this.options = sentryOptions;
        this.hub = iHub;
    }

    public void run() {
        BufferedReader bufferedReader;
        String cacheDirPath = this.options.getCacheDirPath();
        if (cacheDirPath == null) {
            this.options.getLogger().log(SentryLevel.INFO, "Cache dir is not set, not finalizing the previous session.", new Object[0]);
            return;
        } else if (!this.options.isEnableAutoSessionTracking()) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Session tracking is disabled, bailing from previous session finalizer.", new Object[0]);
            return;
        } else {
            IEnvelopeCache envelopeDiskCache = this.options.getEnvelopeDiskCache();
            if (!(envelopeDiskCache instanceof EnvelopeCache) || ((EnvelopeCache) envelopeDiskCache).waitPreviousSessionFlush()) {
                File previousSessionFile = EnvelopeCache.getPreviousSessionFile(cacheDirPath);
                ISerializer serializer = this.options.getSerializer();
                if (previousSessionFile.exists()) {
                    this.options.getLogger().log(SentryLevel.WARNING, "Current session is not ended, we'd need to end it.", new Object[0]);
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(previousSessionFile), UTF_8));
                        Session session = (Session) serializer.deserialize(bufferedReader, Session.class);
                        if (session == null) {
                            this.options.getLogger().log(SentryLevel.ERROR, "Stream from path %s resulted in a null envelope.", previousSessionFile.getAbsolutePath());
                        } else {
                            File file = new File(this.options.getCacheDirPath(), EnvelopeCache.NATIVE_CRASH_MARKER_FILE);
                            Date date = null;
                            if (file.exists()) {
                                this.options.getLogger().log(SentryLevel.INFO, "Crash marker file exists, last Session is gonna be Crashed.", new Object[0]);
                                Date timestampFromCrashMarkerFile = getTimestampFromCrashMarkerFile(file);
                                if (!file.delete()) {
                                    this.options.getLogger().log(SentryLevel.ERROR, "Failed to delete the crash marker file. %s.", file.getAbsolutePath());
                                }
                                session.update(Session.State.Crashed, (String) null, true);
                                date = timestampFromCrashMarkerFile;
                            }
                            if (session.getAbnormalMechanism() == null) {
                                session.end(date);
                            }
                            this.hub.captureEnvelope(SentryEnvelope.from(serializer, session, this.options.getSdkVersion()));
                        }
                        bufferedReader.close();
                    } catch (Throwable th) {
                        this.options.getLogger().log(SentryLevel.ERROR, "Error processing previous session.", th);
                    }
                    if (!previousSessionFile.delete()) {
                        this.options.getLogger().log(SentryLevel.WARNING, "Failed to delete the previous session file.", new Object[0]);
                        return;
                    }
                    return;
                }
                return;
            }
            this.options.getLogger().log(SentryLevel.WARNING, "Timed out waiting to flush previous session to its own file in session finalizer.", new Object[0]);
            return;
        }
        throw th;
    }

    private Date getTimestampFromCrashMarkerFile(File file) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), UTF_8));
            String readLine = bufferedReader.readLine();
            this.options.getLogger().log(SentryLevel.DEBUG, "Crash marker file has %s timestamp.", readLine);
            Date dateTime = DateUtils.getDateTime(readLine);
            bufferedReader.close();
            return dateTime;
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error reading the crash marker file.", (Throwable) e);
            return null;
        } catch (IllegalArgumentException e2) {
            this.options.getLogger().log(SentryLevel.ERROR, e2, "Error converting the crash timestamp.", new Object[0]);
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
