package com.launchdarkly.sdk.internal.events;

import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.logging.LogValues;
import com.launchdarkly.sdk.internal.events.EventSender;
import com.launchdarkly.sdk.internal.http.HttpProperties;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public final class DefaultEventSender implements EventSender {
    public static final String DEFAULT_ANALYTICS_REQUEST_PATH = "/bulk";
    public static final String DEFAULT_DIAGNOSTIC_REQUEST_PATH = "/diagnostic";
    public static final long DEFAULT_RETRY_DELAY_MILLIS = 1000;
    private static final String EVENT_PAYLOAD_ID_HEADER = "X-LaunchDarkly-Payload-ID";
    private static final String EVENT_SCHEMA_HEADER = "X-LaunchDarkly-Event-Schema";
    private static final String EVENT_SCHEMA_VERSION = "4";
    private static final SimpleDateFormat HTTP_DATE_FORMAT = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
    private static final Object HTTP_DATE_FORMAT_LOCK = new Object();
    private static final MediaType JSON_CONTENT_TYPE = MediaType.parse("application/json; charset=utf-8");
    private final String analyticsRequestPath;
    private final Headers baseHeaders;
    private final String diagnosticRequestPath;
    private final OkHttpClient httpClient;
    private final LDLogger logger;
    final long retryDelayMillis;
    private final boolean shouldCloseHttpClient;

    public DefaultEventSender(HttpProperties httpProperties, String str, String str2, long j, LDLogger lDLogger) {
        if (httpProperties.getSharedHttpClient() == null) {
            this.httpClient = httpProperties.toHttpClientBuilder().build();
            this.shouldCloseHttpClient = true;
        } else {
            this.httpClient = httpProperties.getSharedHttpClient();
            this.shouldCloseHttpClient = false;
        }
        this.logger = lDLogger;
        this.baseHeaders = httpProperties.toHeadersBuilder().add("Content-Type", "application/json").build();
        this.analyticsRequestPath = str == null ? DEFAULT_ANALYTICS_REQUEST_PATH : str;
        this.diagnosticRequestPath = str2 == null ? DEFAULT_DIAGNOSTIC_REQUEST_PATH : str2;
        this.retryDelayMillis = j <= 0 ? 1000 : j;
    }

    public void close() throws IOException {
        if (this.shouldCloseHttpClient) {
            HttpProperties.shutdownHttpClient(this.httpClient);
        }
    }

    public EventSender.Result sendAnalyticsEvents(byte[] bArr, int i, URI uri) {
        return sendEventData(false, bArr, i, uri);
    }

    public EventSender.Result sendDiagnosticEvent(byte[] bArr, URI uri) {
        return sendEventData(true, bArr, 1, uri);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0119, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0154, code lost:
        return new com.launchdarkly.sdk.internal.events.EventSender.Result(false, r3, (java.util.Date) null);
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012c A[SYNTHETIC, Splitter:B:55:0x012c] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0135 A[EDGE_INSN: B:76:0x0135->B:61:0x0135 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.launchdarkly.sdk.internal.events.EventSender.Result sendEventData(boolean r19, byte[] r20, int r21, java.net.URI r22) {
        /*
            r18 = this;
            r1 = r18
            r0 = r20
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x0155
            int r5 = r0.length
            if (r5 != 0) goto L_0x000d
            goto L_0x0155
        L_0x000d:
            okhttp3.Headers r5 = r1.baseHeaders
            okhttp3.Headers$Builder r5 = r5.newBuilder()
            if (r19 == 0) goto L_0x001a
            java.lang.String r6 = r1.diagnosticRequestPath
            java.lang.String r7 = "diagnostic event"
            goto L_0x003e
        L_0x001a:
            java.lang.String r6 = r1.analyticsRequestPath
            java.util.UUID r7 = java.util.UUID.randomUUID()
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "X-LaunchDarkly-Payload-ID"
            r5.add((java.lang.String) r8, (java.lang.String) r7)
            java.lang.String r7 = "X-LaunchDarkly-Event-Schema"
            java.lang.String r8 = "4"
            r5.add((java.lang.String) r7, (java.lang.String) r8)
            java.lang.Object[] r7 = new java.lang.Object[r3]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r21)
            r7[r4] = r8
            java.lang.String r8 = "%d event(s)"
            java.lang.String r7 = java.lang.String.format(r8, r7)
        L_0x003e:
            r8 = r22
            java.net.URI r6 = com.launchdarkly.sdk.internal.http.HttpHelpers.concatenateUriPath(r8, r6)
            okhttp3.Headers r5 = r5.build()
            okhttp3.MediaType r8 = JSON_CONTENT_TYPE
            okhttp3.RequestBody r8 = okhttp3.RequestBody.create((byte[]) r0, (okhttp3.MediaType) r8)
            com.launchdarkly.logging.LDLogger r9 = r1.logger
            r10 = 3
            java.lang.Object[] r11 = new java.lang.Object[r10]
            r11[r4] = r7
            r11[r3] = r6
            com.launchdarkly.sdk.internal.events.DefaultEventSender$LazilyPrintedUtf8Data r12 = new com.launchdarkly.sdk.internal.events.DefaultEventSender$LazilyPrintedUtf8Data
            r12.<init>(r0)
            java.lang.Object r0 = com.launchdarkly.logging.LogValues.defer(r12)
            r12 = 2
            r11[r12] = r0
            java.lang.String r0 = "Posting {} to {} with payload: {}"
            r9.debug((java.lang.String) r0, (java.lang.Object[]) r11)
            r9 = r4
            r11 = r9
        L_0x006a:
            if (r9 >= r12) goto L_0x014d
            if (r9 <= 0) goto L_0x0080
            com.launchdarkly.logging.LDLogger r0 = r1.logger
            long r13 = r1.retryDelayMillis
            java.lang.Long r13 = java.lang.Long.valueOf(r13)
            java.lang.String r14 = "Will retry posting {} after {}ms"
            r0.warn(r14, r7, r13)
            long r13 = r1.retryDelayMillis     // Catch:{ InterruptedException -> 0x0080 }
            java.lang.Thread.sleep(r13)     // Catch:{ InterruptedException -> 0x0080 }
        L_0x0080:
            okhttp3.Request$Builder r0 = new okhttp3.Request$Builder
            r0.<init>()
            java.lang.String r13 = r6.toASCIIString()
            okhttp3.Request$Builder r0 = r0.url((java.lang.String) r13)
            okhttp3.Request$Builder r0 = r0.post(r8)
            okhttp3.Request$Builder r0 = r0.headers(r5)
            okhttp3.Request r0 = r0.build()
            long r13 = java.lang.System.currentTimeMillis()
            if (r9 != 0) goto L_0x00a2
            java.lang.String r15 = "will retry"
            goto L_0x00a4
        L_0x00a2:
            java.lang.String r15 = "some events were dropped"
        L_0x00a4:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r12 = "posting "
            java.lang.StringBuilder r2 = r2.append(r12)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r2 = r2.toString()
            okhttp3.OkHttpClient r12 = r1.httpClient     // Catch:{ IOException -> 0x0138 }
            okhttp3.Call r0 = r12.newCall(r0)     // Catch:{ IOException -> 0x0138 }
            okhttp3.Response r12 = r0.execute()     // Catch:{ IOException -> 0x0138 }
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0125 }
            com.launchdarkly.logging.LDLogger r0 = r1.logger     // Catch:{ all -> 0x0125 }
            java.lang.String r3 = "{} delivery took {} ms, response status {}"
            r21 = r5
            java.lang.Object[] r5 = new java.lang.Object[r10]     // Catch:{ all -> 0x0123 }
            r5[r4] = r7     // Catch:{ all -> 0x0123 }
            long r16 = r16 - r13
            java.lang.Long r13 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0123 }
            r14 = 1
            r5[r14] = r13     // Catch:{ all -> 0x0123 }
            int r13 = r12.code()     // Catch:{ all -> 0x0123 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0123 }
            r14 = 2
            r5[r14] = r13     // Catch:{ all -> 0x0121 }
            r0.debug((java.lang.String) r3, (java.lang.Object[]) r5)     // Catch:{ all -> 0x0121 }
            boolean r0 = r12.isSuccessful()     // Catch:{ all -> 0x0121 }
            if (r0 == 0) goto L_0x00fc
            com.launchdarkly.sdk.internal.events.EventSender$Result r0 = new com.launchdarkly.sdk.internal.events.EventSender$Result     // Catch:{ all -> 0x0121 }
            java.util.Date r3 = r1.parseResponseDate(r12)     // Catch:{ all -> 0x0121 }
            r5 = 1
            r0.<init>(r5, r4, r3)     // Catch:{ all -> 0x0121 }
            if (r12 == 0) goto L_0x00fb
            r12.close()     // Catch:{ IOException -> 0x0136 }
        L_0x00fb:
            return r0
        L_0x00fc:
            int r0 = r12.code()     // Catch:{ all -> 0x0121 }
            java.lang.String r0 = com.launchdarkly.sdk.internal.http.HttpErrors.httpErrorDescription(r0)     // Catch:{ all -> 0x0121 }
            com.launchdarkly.logging.LDLogger r3 = r1.logger     // Catch:{ all -> 0x0121 }
            int r5 = r12.code()     // Catch:{ all -> 0x0121 }
            boolean r0 = com.launchdarkly.sdk.internal.http.HttpErrors.checkIfErrorIsRecoverableAndLog(r3, r0, r2, r5, r15)     // Catch:{ all -> 0x0121 }
            if (r0 != 0) goto L_0x011b
            if (r12 == 0) goto L_0x0119
            r12.close()     // Catch:{ IOException -> 0x0116 }
            goto L_0x0119
        L_0x0116:
            r0 = move-exception
            r11 = 1
            goto L_0x013c
        L_0x0119:
            r3 = 1
            goto L_0x014e
        L_0x011b:
            if (r12 == 0) goto L_0x0145
            r12.close()     // Catch:{ IOException -> 0x0136 }
            goto L_0x0145
        L_0x0121:
            r0 = move-exception
            goto L_0x0129
        L_0x0123:
            r0 = move-exception
            goto L_0x0128
        L_0x0125:
            r0 = move-exception
            r21 = r5
        L_0x0128:
            r14 = 2
        L_0x0129:
            r3 = r0
            if (r12 == 0) goto L_0x0135
            r12.close()     // Catch:{ all -> 0x0130 }
            goto L_0x0135
        L_0x0130:
            r0 = move-exception
            r5 = r0
            r3.addSuppressed(r5)     // Catch:{ IOException -> 0x0136 }
        L_0x0135:
            throw r3     // Catch:{ IOException -> 0x0136 }
        L_0x0136:
            r0 = move-exception
            goto L_0x013c
        L_0x0138:
            r0 = move-exception
            r21 = r5
            r14 = 2
        L_0x013c:
            com.launchdarkly.logging.LDLogger r3 = r1.logger
            java.lang.String r0 = r0.toString()
            com.launchdarkly.sdk.internal.http.HttpErrors.checkIfErrorIsRecoverableAndLog(r3, r0, r2, r4, r15)
        L_0x0145:
            int r9 = r9 + 1
            r5 = r21
            r12 = r14
            r3 = 1
            goto L_0x006a
        L_0x014d:
            r3 = r11
        L_0x014e:
            com.launchdarkly.sdk.internal.events.EventSender$Result r0 = new com.launchdarkly.sdk.internal.events.EventSender$Result
            r2 = 0
            r0.<init>(r4, r3, r2)
            return r0
        L_0x0155:
            r2 = 0
            com.launchdarkly.sdk.internal.events.EventSender$Result r0 = new com.launchdarkly.sdk.internal.events.EventSender$Result
            r3 = 1
            r0.<init>(r3, r4, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.internal.events.DefaultEventSender.sendEventData(boolean, byte[], int, java.net.URI):com.launchdarkly.sdk.internal.events.EventSender$Result");
    }

    private final Date parseResponseDate(Response response) {
        Date parse;
        String header = response.header("Date");
        if (header == null) {
            return null;
        }
        try {
            synchronized (HTTP_DATE_FORMAT_LOCK) {
                parse = HTTP_DATE_FORMAT.parse(header);
            }
            return parse;
        } catch (ParseException unused) {
            this.logger.warn("Received invalid Date header from events service");
            return null;
        }
    }

    private final class LazilyPrintedUtf8Data implements LogValues.StringProvider {
        private final byte[] data;

        LazilyPrintedUtf8Data(byte[] bArr) {
            this.data = bArr;
        }

        public String get() {
            return this.data == null ? "" : new String(this.data, Charset.forName("UTF-8"));
        }
    }
}
