package io.sentry;

import io.sentry.clientreport.ClientReport;
import io.sentry.exception.SentryEnvelopeException;
import io.sentry.metrics.EncodedMetrics;
import io.sentry.protocol.SentryTransaction;
import io.sentry.util.FileUtils;
import io.sentry.util.JsonSerializationUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.Base64;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;

public final class SentryEnvelopeItem {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private byte[] data;
    private final Callable<byte[]> dataFactory;
    private final SentryEnvelopeItemHeader header;

    SentryEnvelopeItem(SentryEnvelopeItemHeader sentryEnvelopeItemHeader, byte[] bArr) {
        this.header = (SentryEnvelopeItemHeader) Objects.requireNonNull(sentryEnvelopeItemHeader, "SentryEnvelopeItemHeader is required.");
        this.data = bArr;
        this.dataFactory = null;
    }

    SentryEnvelopeItem(SentryEnvelopeItemHeader sentryEnvelopeItemHeader, Callable<byte[]> callable) {
        this.header = (SentryEnvelopeItemHeader) Objects.requireNonNull(sentryEnvelopeItemHeader, "SentryEnvelopeItemHeader is required.");
        this.dataFactory = (Callable) Objects.requireNonNull(callable, "DataFactory is required.");
        this.data = null;
    }

    public byte[] getData() throws Exception {
        Callable<byte[]> callable;
        if (this.data == null && (callable = this.dataFactory) != null) {
            this.data = callable.call();
        }
        return this.data;
    }

    public SentryEnvelopeItemHeader getHeader() {
        return this.header;
    }

    public static SentryEnvelopeItem fromSession(ISerializer iSerializer, Session session) throws IOException {
        Objects.requireNonNull(iSerializer, "ISerializer is required.");
        Objects.requireNonNull(session, "Session is required.");
        CachedItem cachedItem = new CachedItem(new SentryEnvelopeItem$$ExternalSyntheticLambda23(iSerializer, session));
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.Session, new SentryEnvelopeItem$$ExternalSyntheticLambda1(cachedItem), "application/json", (String) null), (Callable<byte[]>) new SentryEnvelopeItem$$ExternalSyntheticLambda2(cachedItem));
    }

    static /* synthetic */ byte[] lambda$fromSession$0(ISerializer iSerializer, Session session) throws Exception {
        BufferedWriter bufferedWriter;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, UTF_8));
            iSerializer.serialize(session, (Writer) bufferedWriter);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bufferedWriter.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        throw th;
    }

    public SentryEvent getEvent(ISerializer iSerializer) throws Exception {
        SentryEnvelopeItemHeader sentryEnvelopeItemHeader = this.header;
        if (sentryEnvelopeItemHeader == null || sentryEnvelopeItemHeader.getType() != SentryItemType.Event) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(getData()), UTF_8));
        try {
            SentryEvent sentryEvent = (SentryEvent) iSerializer.deserialize(bufferedReader, SentryEvent.class);
            bufferedReader.close();
            return sentryEvent;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static SentryEnvelopeItem fromEvent(ISerializer iSerializer, SentryBaseEvent sentryBaseEvent) throws IOException {
        Objects.requireNonNull(iSerializer, "ISerializer is required.");
        Objects.requireNonNull(sentryBaseEvent, "SentryEvent is required.");
        CachedItem cachedItem = new CachedItem(new SentryEnvelopeItem$$ExternalSyntheticLambda0(iSerializer, sentryBaseEvent));
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.resolve(sentryBaseEvent), new SentryEnvelopeItem$$ExternalSyntheticLambda11(cachedItem), "application/json", (String) null), (Callable<byte[]>) new SentryEnvelopeItem$$ExternalSyntheticLambda16(cachedItem));
    }

    static /* synthetic */ byte[] lambda$fromEvent$3(ISerializer iSerializer, SentryBaseEvent sentryBaseEvent) throws Exception {
        BufferedWriter bufferedWriter;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, UTF_8));
            iSerializer.serialize(sentryBaseEvent, (Writer) bufferedWriter);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bufferedWriter.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        throw th;
    }

    public SentryTransaction getTransaction(ISerializer iSerializer) throws Exception {
        SentryEnvelopeItemHeader sentryEnvelopeItemHeader = this.header;
        if (sentryEnvelopeItemHeader == null || sentryEnvelopeItemHeader.getType() != SentryItemType.Transaction) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(getData()), UTF_8));
        try {
            SentryTransaction sentryTransaction = (SentryTransaction) iSerializer.deserialize(bufferedReader, SentryTransaction.class);
            bufferedReader.close();
            return sentryTransaction;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static SentryEnvelopeItem fromUserFeedback(ISerializer iSerializer, UserFeedback userFeedback) {
        Objects.requireNonNull(iSerializer, "ISerializer is required.");
        Objects.requireNonNull(userFeedback, "UserFeedback is required.");
        CachedItem cachedItem = new CachedItem(new SentryEnvelopeItem$$ExternalSyntheticLambda20(iSerializer, userFeedback));
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.UserFeedback, new SentryEnvelopeItem$$ExternalSyntheticLambda21(cachedItem), "application/json", (String) null), (Callable<byte[]>) new SentryEnvelopeItem$$ExternalSyntheticLambda22(cachedItem));
    }

    static /* synthetic */ byte[] lambda$fromUserFeedback$6(ISerializer iSerializer, UserFeedback userFeedback) throws Exception {
        BufferedWriter bufferedWriter;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, UTF_8));
            iSerializer.serialize(userFeedback, (Writer) bufferedWriter);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bufferedWriter.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        throw th;
    }

    public static SentryEnvelopeItem fromCheckIn(ISerializer iSerializer, CheckIn checkIn) {
        Objects.requireNonNull(iSerializer, "ISerializer is required.");
        Objects.requireNonNull(checkIn, "CheckIn is required.");
        CachedItem cachedItem = new CachedItem(new SentryEnvelopeItem$$ExternalSyntheticLambda17(iSerializer, checkIn));
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.CheckIn, new SentryEnvelopeItem$$ExternalSyntheticLambda18(cachedItem), "application/json", (String) null), (Callable<byte[]>) new SentryEnvelopeItem$$ExternalSyntheticLambda19(cachedItem));
    }

    static /* synthetic */ byte[] lambda$fromCheckIn$9(ISerializer iSerializer, CheckIn checkIn) throws Exception {
        BufferedWriter bufferedWriter;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, UTF_8));
            iSerializer.serialize(checkIn, (Writer) bufferedWriter);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bufferedWriter.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        throw th;
    }

    public static SentryEnvelopeItem fromMetrics(EncodedMetrics encodedMetrics) {
        CachedItem cachedItem = new CachedItem(new SentryEnvelopeItem$$ExternalSyntheticLambda3(encodedMetrics));
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.Statsd, new SentryEnvelopeItem$$ExternalSyntheticLambda4(cachedItem), "application/octet-stream", (String) null), (Callable<byte[]>) new SentryEnvelopeItem$$ExternalSyntheticLambda5(cachedItem));
    }

    public static SentryEnvelopeItem fromAttachment(ISerializer iSerializer, ILogger iLogger, Attachment attachment, long j) {
        CachedItem cachedItem = new CachedItem(new SentryEnvelopeItem$$ExternalSyntheticLambda6(attachment, j, iSerializer, iLogger));
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.Attachment, (Callable<Integer>) new SentryEnvelopeItem$$ExternalSyntheticLambda7(cachedItem), attachment.getContentType(), attachment.getFilename(), attachment.getAttachmentType()), (Callable<byte[]>) new SentryEnvelopeItem$$ExternalSyntheticLambda8(cachedItem));
    }

    static /* synthetic */ byte[] lambda$fromAttachment$15(Attachment attachment, long j, ISerializer iSerializer, ILogger iLogger) throws Exception {
        if (attachment.getBytes() != null) {
            byte[] bytes = attachment.getBytes();
            ensureAttachmentSizeLimit((long) bytes.length, j, attachment.getFilename());
            return bytes;
        }
        if (attachment.getSerializable() != null) {
            byte[] bytesFrom = JsonSerializationUtils.bytesFrom(iSerializer, iLogger, attachment.getSerializable());
            if (bytesFrom != null) {
                ensureAttachmentSizeLimit((long) bytesFrom.length, j, attachment.getFilename());
                return bytesFrom;
            }
        } else if (attachment.getPathname() != null) {
            return FileUtils.readBytesFromFile(attachment.getPathname(), j);
        }
        throw new SentryEnvelopeException(String.format("Couldn't attach the attachment %s.\nPlease check that either bytes, serializable or a path is set.", new Object[]{attachment.getFilename()}));
    }

    private static void ensureAttachmentSizeLimit(long j, long j2, String str) throws SentryEnvelopeException {
        if (j > j2) {
            throw new SentryEnvelopeException(String.format("Dropping attachment with filename '%s', because the size of the passed bytes with %d bytes is bigger than the maximum allowed attachment size of %d bytes.", new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}));
        }
    }

    public static SentryEnvelopeItem fromProfilingTrace(ProfilingTraceData profilingTraceData, long j, ISerializer iSerializer) throws SentryEnvelopeException {
        File traceFile = profilingTraceData.getTraceFile();
        CachedItem cachedItem = new CachedItem(new SentryEnvelopeItem$$ExternalSyntheticLambda13(traceFile, j, profilingTraceData, iSerializer));
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.Profile, new SentryEnvelopeItem$$ExternalSyntheticLambda14(cachedItem), "application-json", traceFile.getName()), (Callable<byte[]>) new SentryEnvelopeItem$$ExternalSyntheticLambda15(cachedItem));
    }

    static /* synthetic */ byte[] lambda$fromProfilingTrace$18(File file, long j, ProfilingTraceData profilingTraceData, ISerializer iSerializer) throws Exception {
        BufferedWriter bufferedWriter;
        if (file.exists()) {
            String encodeToString = Base64.encodeToString(FileUtils.readBytesFromFile(file.getPath(), j), 3);
            if (!encodeToString.isEmpty()) {
                profilingTraceData.setSampledProfile(encodeToString);
                profilingTraceData.readDeviceCpuFrequencies();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, UTF_8));
                        iSerializer.serialize(profilingTraceData, (Writer) bufferedWriter);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        bufferedWriter.close();
                        byteArrayOutputStream.close();
                        file.delete();
                        return byteArray;
                    } catch (Throwable th) {
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (IOException e) {
                    try {
                        throw new SentryEnvelopeException(String.format("Failed to serialize profiling trace data\n%s", new Object[]{e.getMessage()}));
                    } catch (Throwable th2) {
                        file.delete();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
            } else {
                throw new SentryEnvelopeException("Profiling trace file is empty");
            }
        } else {
            throw new SentryEnvelopeException(String.format("Dropping profiling trace data, because the file '%s' doesn't exists", new Object[]{file.getName()}));
        }
        throw th;
    }

    public static SentryEnvelopeItem fromClientReport(ISerializer iSerializer, ClientReport clientReport) throws IOException {
        Objects.requireNonNull(iSerializer, "ISerializer is required.");
        Objects.requireNonNull(clientReport, "ClientReport is required.");
        CachedItem cachedItem = new CachedItem(new SentryEnvelopeItem$$ExternalSyntheticLambda9(iSerializer, clientReport));
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.resolve(clientReport), new SentryEnvelopeItem$$ExternalSyntheticLambda10(cachedItem), "application/json", (String) null), (Callable<byte[]>) new SentryEnvelopeItem$$ExternalSyntheticLambda12(cachedItem));
    }

    static /* synthetic */ byte[] lambda$fromClientReport$21(ISerializer iSerializer, ClientReport clientReport) throws Exception {
        BufferedWriter bufferedWriter;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, UTF_8));
            iSerializer.serialize(clientReport, (Writer) bufferedWriter);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bufferedWriter.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        throw th;
    }

    public ClientReport getClientReport(ISerializer iSerializer) throws Exception {
        SentryEnvelopeItemHeader sentryEnvelopeItemHeader = this.header;
        if (sentryEnvelopeItemHeader == null || sentryEnvelopeItemHeader.getType() != SentryItemType.ClientReport) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(getData()), UTF_8));
        try {
            ClientReport clientReport = (ClientReport) iSerializer.deserialize(bufferedReader, ClientReport.class);
            bufferedReader.close();
            return clientReport;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static class CachedItem {
        private byte[] bytes;
        private final Callable<byte[]> dataFactory;

        private static byte[] orEmptyArray(byte[] bArr) {
            return bArr != null ? bArr : new byte[0];
        }

        public CachedItem(Callable<byte[]> callable) {
            this.dataFactory = callable;
        }

        public byte[] getBytes() throws Exception {
            Callable<byte[]> callable;
            if (this.bytes == null && (callable = this.dataFactory) != null) {
                this.bytes = callable.call();
            }
            return orEmptyArray(this.bytes);
        }
    }
}
