package io.sentry.cache;

import io.sentry.ISerializer;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryItemType;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.clientreport.DiscardReason;
import io.sentry.util.Objects;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

abstract class CacheStrategy {
    protected static final Charset UTF_8 = Charset.forName("UTF-8");
    protected final File directory;
    private final int maxSize;
    protected final SentryOptions options;
    protected final ISerializer serializer;

    CacheStrategy(SentryOptions sentryOptions, String str, int i) {
        Objects.requireNonNull(str, "Directory is required.");
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "SentryOptions is required.");
        this.serializer = sentryOptions.getSerializer();
        this.directory = new File(str);
        this.maxSize = i;
    }

    /* access modifiers changed from: protected */
    public boolean isDirectoryValid() {
        if (this.directory.isDirectory() && this.directory.canWrite() && this.directory.canRead()) {
            return true;
        }
        this.options.getLogger().log(SentryLevel.ERROR, "The directory for caching files is inaccessible.: %s", this.directory.getAbsolutePath());
        return false;
    }

    private void sortFilesOldestToNewest(File[] fileArr) {
        if (fileArr.length > 1) {
            Arrays.sort(fileArr, new CacheStrategy$$ExternalSyntheticLambda0());
        }
    }

    /* access modifiers changed from: protected */
    public void rotateCacheIfNeeded(File[] fileArr) {
        int length = fileArr.length;
        if (length >= this.maxSize) {
            this.options.getLogger().log(SentryLevel.WARNING, "Cache folder if full (respecting maxSize). Rotating files", new Object[0]);
            int i = (length - this.maxSize) + 1;
            sortFilesOldestToNewest(fileArr);
            File[] fileArr2 = (File[]) Arrays.copyOfRange(fileArr, i, length);
            for (int i2 = 0; i2 < i; i2++) {
                File file = fileArr[i2];
                moveInitFlagIfNecessary(file, fileArr2);
                if (!file.delete()) {
                    this.options.getLogger().log(SentryLevel.WARNING, "File can't be deleted: %s", file.getAbsolutePath());
                }
            }
        }
    }

    private void moveInitFlagIfNecessary(File file, File[] fileArr) {
        Boolean init;
        Session readSession;
        SentryEnvelope readEnvelope = readEnvelope(file);
        if (readEnvelope != null && isValidEnvelope(readEnvelope)) {
            this.options.getClientReportRecorder().recordLostEnvelope(DiscardReason.CACHE_OVERFLOW, readEnvelope);
            Session firstSession = getFirstSession(readEnvelope);
            if (firstSession != null && isValidSession(firstSession) && (init = firstSession.getInit()) != null && init.booleanValue()) {
                for (File file2 : fileArr) {
                    SentryEnvelope readEnvelope2 = readEnvelope(file2);
                    if (readEnvelope2 != null && isValidEnvelope(readEnvelope2)) {
                        SentryEnvelopeItem sentryEnvelopeItem = null;
                        Iterator<SentryEnvelopeItem> it = readEnvelope2.getItems().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            SentryEnvelopeItem next = it.next();
                            if (isSessionType(next) && (readSession = readSession(next)) != null && isValidSession(readSession)) {
                                Boolean init2 = readSession.getInit();
                                if (init2 != null && init2.booleanValue()) {
                                    this.options.getLogger().log(SentryLevel.ERROR, "Session %s has 2 times the init flag.", firstSession.getSessionId());
                                    return;
                                } else if (firstSession.getSessionId() != null && firstSession.getSessionId().equals(readSession.getSessionId())) {
                                    readSession.setInitAsTrue();
                                    try {
                                        sentryEnvelopeItem = SentryEnvelopeItem.fromSession(this.serializer, readSession);
                                        it.remove();
                                        break;
                                    } catch (IOException e) {
                                        this.options.getLogger().log(SentryLevel.ERROR, e, "Failed to create new envelope item for the session %s", firstSession.getSessionId());
                                    }
                                }
                            }
                        }
                        if (sentryEnvelopeItem != null) {
                            SentryEnvelope buildNewEnvelope = buildNewEnvelope(readEnvelope2, sentryEnvelopeItem);
                            long lastModified = file2.lastModified();
                            if (!file2.delete()) {
                                this.options.getLogger().log(SentryLevel.WARNING, "File can't be deleted: %s", file2.getAbsolutePath());
                            }
                            saveNewEnvelope(buildNewEnvelope, file2, lastModified);
                            return;
                        }
                    }
                }
            }
        }
    }

    private SentryEnvelope readEnvelope(File file) {
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            SentryEnvelope deserializeEnvelope = this.serializer.deserializeEnvelope(bufferedInputStream);
            bufferedInputStream.close();
            return deserializeEnvelope;
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to deserialize the envelope.", (Throwable) e);
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private Session getFirstSession(SentryEnvelope sentryEnvelope) {
        for (SentryEnvelopeItem next : sentryEnvelope.getItems()) {
            if (isSessionType(next)) {
                return readSession(next);
            }
        }
        return null;
    }

    private boolean isValidSession(Session session) {
        if (session.getStatus().equals(Session.State.Ok) && session.getSessionId() != null) {
            return true;
        }
        return false;
    }

    private boolean isSessionType(SentryEnvelopeItem sentryEnvelopeItem) {
        if (sentryEnvelopeItem == null) {
            return false;
        }
        return sentryEnvelopeItem.getHeader().getType().equals(SentryItemType.Session);
    }

    private Session readSession(SentryEnvelopeItem sentryEnvelopeItem) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(sentryEnvelopeItem.getData()), UTF_8));
            Session session = (Session) this.serializer.deserialize(bufferedReader, Session.class);
            bufferedReader.close();
            return session;
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to deserialize the session.", th);
            return null;
        }
        throw th;
    }

    private void saveNewEnvelope(SentryEnvelope sentryEnvelope, File file, long j) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            this.serializer.serialize(sentryEnvelope, (OutputStream) fileOutputStream);
            file.setLastModified(j);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to serialize the new envelope to the disk.", th);
            return;
        }
        throw th;
    }

    private SentryEnvelope buildNewEnvelope(SentryEnvelope sentryEnvelope, SentryEnvelopeItem sentryEnvelopeItem) {
        ArrayList arrayList = new ArrayList();
        for (SentryEnvelopeItem add : sentryEnvelope.getItems()) {
            arrayList.add(add);
        }
        arrayList.add(sentryEnvelopeItem);
        return new SentryEnvelope(sentryEnvelope.getHeader(), arrayList);
    }

    private boolean isValidEnvelope(SentryEnvelope sentryEnvelope) {
        return sentryEnvelope.getItems().iterator().hasNext();
    }
}
