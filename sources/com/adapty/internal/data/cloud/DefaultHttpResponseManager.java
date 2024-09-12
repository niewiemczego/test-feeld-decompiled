package com.adapty.internal.data.cloud;

import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.cache.ResponseCacheKeys;
import com.adapty.internal.data.cloud.AnalyticsTracker;
import com.adapty.internal.data.cloud.Response;
import com.adapty.internal.data.models.AnalyticsEvent;
import com.adapty.internal.utils.Logger;
import com.adapty.internal.utils.Logger$log$1;
import com.adapty.utils.AdaptyLogLevel;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ,\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\f\u0010\u0018\u001a\u00020\u0017*\u00020\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/adapty/internal/data/cloud/DefaultHttpResponseManager;", "Lcom/adapty/internal/data/cloud/HttpResponseManager;", "bodyConverter", "Lcom/adapty/internal/data/cloud/ResponseBodyConverter;", "cacheRepository", "Lcom/adapty/internal/data/cache/CacheRepository;", "analyticsTracker", "Lcom/adapty/internal/data/cloud/AnalyticsTracker;", "(Lcom/adapty/internal/data/cloud/ResponseBodyConverter;Lcom/adapty/internal/data/cache/CacheRepository;Lcom/adapty/internal/data/cloud/AnalyticsTracker;)V", "handleResponse", "Lcom/adapty/internal/data/cloud/Response;", "T", "connection", "Ljava/net/HttpURLConnection;", "request", "Lcom/adapty/internal/data/cloud/Request;", "typeOfT", "Ljava/lang/reflect/Type;", "toStringUtf8", "", "inputStream", "Ljava/io/InputStream;", "isInGzip", "", "isSuccessful", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HttpResponseManager.kt */
public final class DefaultHttpResponseManager implements HttpResponseManager {
    private final AnalyticsTracker analyticsTracker;
    private final ResponseBodyConverter bodyConverter;
    private final CacheRepository cacheRepository;

    public DefaultHttpResponseManager(ResponseBodyConverter responseBodyConverter, CacheRepository cacheRepository2, AnalyticsTracker analyticsTracker2) {
        Intrinsics.checkNotNullParameter(responseBodyConverter, "bodyConverter");
        Intrinsics.checkNotNullParameter(cacheRepository2, "cacheRepository");
        Intrinsics.checkNotNullParameter(analyticsTracker2, "analyticsTracker");
        this.bodyConverter = responseBodyConverter;
        this.cacheRepository = cacheRepository2;
        this.analyticsTracker = analyticsTracker2;
    }

    public <T> Response<T> handleResponse(HttpURLConnection httpURLConnection, Request request, Type type) {
        String str;
        String responseKey;
        HttpURLConnection httpURLConnection2 = httpURLConnection;
        Request request2 = request;
        Type type2 = type;
        Intrinsics.checkNotNullParameter(httpURLConnection2, "connection");
        Intrinsics.checkNotNullParameter(request2, "request");
        Intrinsics.checkNotNullParameter(type2, "typeOfT");
        String headerField = httpURLConnection2.getHeaderField("Content-Encoding");
        boolean contains = headerField != null ? StringsKt.contains((CharSequence) headerField, (CharSequence) "gzip", true) : false;
        String headerField2 = httpURLConnection2.getHeaderField("request-id");
        if (headerField2 == null) {
            headerField2 = "";
        }
        String str2 = headerField2;
        if (isSuccessful(httpURLConnection)) {
            String requestProperty = httpURLConnection2.getRequestProperty("ADAPTY-SDK-PREVIOUS-RESPONSE-HASH");
            String headerField3 = httpURLConnection2.getHeaderField("X-Response-Hash");
            String headerField4 = httpURLConnection2.getHeaderField("CF-Cache-Status");
            if (headerField4 != null) {
                Logger logger = Logger.INSTANCE;
                AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.INFO;
                if (logger.canLog(adaptyLogLevel.value)) {
                    logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "CF-Cache-Status: " + headerField4));
                }
            }
            ResponseCacheKeys responseCacheKeys = request2.responseCacheKeys;
            CharSequence charSequence = requestProperty;
            if ((charSequence == null || charSequence.length() == 0) || !Intrinsics.areEqual((Object) requestProperty, (Object) headerField3)) {
                InputStream inputStream = httpURLConnection.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream, "connection.inputStream");
                String stringUtf8 = toStringUtf8(inputStream, contains);
                if (!(responseCacheKeys == null || headerField3 == null)) {
                    this.cacheRepository.saveRequestOrResponseLatestData$adapty_release(MapsKt.mapOf(TuplesKt.to(responseCacheKeys.getResponseKey(), stringUtf8), TuplesKt.to(responseCacheKeys.getResponseHashKey(), headerField3)));
                }
                str = stringUtf8;
            } else if (responseCacheKeys == null || (responseKey = responseCacheKeys.getResponseKey()) == null || (str = this.cacheRepository.getString$adapty_release(responseKey)) == null) {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream2, "connection.inputStream");
                str = toStringUtf8(inputStream2, contains);
            }
            Logger logger2 = Logger.INSTANCE;
            AdaptyLogLevel adaptyLogLevel2 = AdaptyLogLevel.VERBOSE;
            if (logger2.canLog(adaptyLogLevel2.value)) {
                logger2.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel2, "Request is successful. " + httpURLConnection.getURL() + " Response: " + str));
            }
            AnalyticsEvent.BackendAPIRequestData backendAPIRequestData = request2.systemLog;
            if (backendAPIRequestData != null) {
                AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, AnalyticsEvent.BackendAPIResponseData.Companion.create$default(AnalyticsEvent.BackendAPIResponseData.Companion, str2, backendAPIRequestData, (Throwable) null, 4, (Object) null), (Function2) null, 2, (Object) null);
            }
            return new Response.Success<>(this.bodyConverter.convertSuccess(str, type2));
        }
        InputStream errorStream = httpURLConnection.getErrorStream();
        Intrinsics.checkNotNullExpressionValue(errorStream, "connection.errorStream");
        String str3 = "Request is unsuccessful. " + httpURLConnection.getURL() + " Code: " + httpURLConnection.getResponseCode() + ", Response: " + toStringUtf8(errorStream, contains);
        Logger logger3 = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel3 = AdaptyLogLevel.ERROR;
        if (logger3.canLog(adaptyLogLevel3.value)) {
            logger3.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel3, str3));
        }
        AdaptyError adaptyError = new AdaptyError((Throwable) null, str3, AdaptyErrorCode.Companion.fromNetwork$adapty_release(httpURLConnection.getResponseCode()), 1, (DefaultConstructorMarker) null);
        AnalyticsEvent.BackendAPIRequestData backendAPIRequestData2 = request2.systemLog;
        if (backendAPIRequestData2 != null) {
            AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, AnalyticsEvent.BackendAPIResponseData.Companion.create(str2, backendAPIRequestData2, adaptyError), (Function2) null, 2, (Object) null);
        }
        return new Response.Error(adaptyError);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0068, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String toStringUtf8(java.io.InputStream r5, boolean r6) {
        /*
            r4 = this;
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            if (r6 == 0) goto L_0x000e
            java.util.zip.GZIPInputStream r6 = new java.util.zip.GZIPInputStream
            r6.<init>(r5)
            r5 = r6
            java.io.InputStream r5 = (java.io.InputStream) r5
        L_0x000e:
            java.nio.charset.Charset r6 = kotlin.text.Charsets.UTF_8
            r1.<init>(r5, r6)
            java.io.Reader r1 = (java.io.Reader) r1
            r0.<init>(r1)
            java.io.Reader r0 = (java.io.Reader) r0
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            java.io.Closeable r0 = (java.io.Closeable) r0
            r5 = 0
            r6 = r0
            java.io.BufferedReader r6 = (java.io.BufferedReader) r6     // Catch:{ all -> 0x0065 }
            kotlin.sequences.Sequence r6 = kotlin.io.TextStreamsKt.lineSequence(r6)     // Catch:{ all -> 0x0065 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r1.<init>()     // Catch:{ all -> 0x0065 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0065 }
        L_0x002f:
            boolean r2 = r6.hasNext()     // Catch:{ all -> 0x0065 }
            if (r2 == 0) goto L_0x0058
            java.lang.Object r2 = r6.next()     // Catch:{ all -> 0x0065 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0065 }
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0065 }
            int r3 = r3.length()     // Catch:{ all -> 0x0065 }
            if (r3 <= 0) goto L_0x0046
            r3 = 1
            goto L_0x0047
        L_0x0046:
            r3 = 0
        L_0x0047:
            if (r3 == 0) goto L_0x004e
            r3 = 10
            r1.append(r3)     // Catch:{ all -> 0x0065 }
        L_0x004e:
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0065 }
            java.lang.String r2 = "total.append(line)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x0065 }
            goto L_0x002f
        L_0x0058:
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x0065 }
            kotlin.io.CloseableKt.closeFinally(r0, r5)
            java.lang.String r5 = "BufferedReader(\n        …   }.toString()\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
            return r6
        L_0x0065:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r6 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cloud.DefaultHttpResponseManager.toStringUtf8(java.io.InputStream, boolean):java.lang.String");
    }

    private final boolean isSuccessful(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        return 200 <= responseCode && responseCode < 300;
    }
}
