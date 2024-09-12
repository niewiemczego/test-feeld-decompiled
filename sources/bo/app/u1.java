package bo.app;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONException;

public final class u1 implements j2 {
    public static final a b = new a((DefaultConstructorMarker) null);
    private static final int c = ((int) TimeUnit.SECONDS.toMillis(15));
    private final int a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }

        /* access modifiers changed from: private */
        public final InputStream a(HttpURLConnection httpURLConnection) {
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode / 100 != 2) {
                throw new o3("Bad HTTP response code from Braze: [" + responseCode + "] to url: " + httpURLConnection.getURL());
            } else if (StringsKt.equals("gzip", httpURLConnection.getContentEncoding(), true)) {
                return new GZIPInputStream(httpURLConnection.getInputStream());
            } else {
                return new BufferedInputStream(httpURLConnection.getInputStream());
            }
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ JSONException b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(JSONException jSONException) {
            super(0);
            this.b = jSONException;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unable to parse json response from server. Response: [" + this.b + ']';
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ URL b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(URL url) {
            super(0);
            this.b = url;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get result from [" + this.b + "].";
        }
    }

    public u1(int i) {
        this.a = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005c, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
        throw r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.Pair a(bo.app.b5 r9, java.util.Map r10, org.json.JSONObject r11) {
        /*
            r8 = this;
            java.lang.String r0 = "requestTarget"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "requestHeaders"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "payload"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 1337(0x539, float:1.874E-42)
            android.net.TrafficStats.setThreadStatsTag(r0)
            java.net.URL r9 = r9.b()
            r0 = 93
            java.net.HttpURLConnection r10 = r8.a((java.net.URL) r9, (org.json.JSONObject) r11, (java.util.Map) r10)     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            bo.app.u1$a r11 = b     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            java.io.InputStream r11 = r11.a(r10)     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            java.nio.charset.Charset r1 = kotlin.text.Charsets.UTF_8     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            r2.<init>(r11, r1)     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            r11 = 8192(0x2000, float:1.14794E-41)
            boolean r1 = r2 instanceof java.io.BufferedReader     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            if (r1 == 0) goto L_0x0034
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            goto L_0x003a
        L_0x0034:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            r1.<init>(r2, r11)     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            r2 = r1
        L_0x003a:
            r11 = 0
            java.lang.String r1 = kotlin.io.TextStreamsKt.readText(r2)     // Catch:{ all -> 0x005a }
            kotlin.io.CloseableKt.closeFinally(r2, r11)     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            r11.<init>((java.lang.String) r1)     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            java.util.Map r10 = r10.getHeaderFields()     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            java.lang.String r1 = "connection.headerFields"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r1)     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            java.util.Map r10 = com.braze.support.g.a((java.util.Map) r10)     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            kotlin.Pair r1 = new kotlin.Pair     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            r1.<init>(r11, r10)     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            return r1
        L_0x005a:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x005c }
        L_0x005c:
            r11 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r10)     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
            throw r11     // Catch:{ IOException -> 0x009a, JSONException -> 0x0061 }
        L_0x0061:
            r10 = move-exception
            com.braze.support.BrazeLogger r11 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.E
            bo.app.u1$b r5 = new bo.app.u1$b
            r5.<init>(r10)
            r4 = 0
            r6 = 2
            r7 = 0
            r1 = r11
            r2 = r8
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W
            bo.app.u1$c r5 = new bo.app.u1$c
            r5.<init>(r9)
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "Failed to get result from ["
            java.lang.StringBuilder r11 = r11.append(r1)
            java.lang.StringBuilder r9 = r11.append(r9)
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        L_0x009a:
            r10 = move-exception
            bo.app.o3 r11 = new bo.app.o3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed request to ["
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r9 = r1.append(r9)
            java.lang.String r1 = "], with message: ["
            java.lang.StringBuilder r9 = r9.append(r1)
            java.lang.String r1 = r10.getMessage()
            java.lang.StringBuilder r9 = r9.append(r1)
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.String r9 = r9.toString()
            r11.<init>(r9, r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.u1.a(bo.app.b5, java.util.Map, org.json.JSONObject):kotlin.Pair");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0075, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0076, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0079, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.net.HttpURLConnection a(java.net.URL r3, org.json.JSONObject r4, java.util.Map r5) {
        /*
            r2 = this;
            java.lang.String r4 = r4.toString()
            java.lang.String r0 = "payload.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            java.lang.String r0 = "UTF-8"
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)
            java.lang.String r1 = "forName(charsetName)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            byte[] r4 = r4.getBytes(r0)
            java.lang.String r0 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            bo.app.v6 r0 = bo.app.v6.a
            java.net.HttpURLConnection r3 = r0.a(r3)
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x002b:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0047
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.setRequestProperty(r1, r0)
            goto L_0x002b
        L_0x0047:
            int r5 = c
            r3.setConnectTimeout(r5)
            int r5 = r2.a
            r3.setReadTimeout(r5)
            r5 = 0
            r3.setUseCaches(r5)
            r3.setInstanceFollowRedirects(r5)
            java.lang.String r5 = "POST"
            r3.setRequestMethod(r5)
            r5 = 1
            r3.setDoOutput(r5)
            int r5 = r4.length
            r3.setFixedLengthStreamingMode(r5)
            java.io.OutputStream r5 = r3.getOutputStream()
            r0 = 0
            r5.write(r4)     // Catch:{ all -> 0x0073 }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0073 }
            kotlin.io.CloseableKt.closeFinally(r5, r0)
            return r3
        L_0x0073:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.u1.a(java.net.URL, org.json.JSONObject, java.util.Map):java.net.HttpURLConnection");
    }
}
