package com.adapty.internal.data.cloud;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/adapty/internal/data/cloud/BaseHttpClient;", "Lcom/adapty/internal/data/cloud/HttpClient;", "connectionCreator", "Lcom/adapty/internal/data/cloud/NetworkConnectionCreator;", "responseManager", "Lcom/adapty/internal/data/cloud/HttpResponseManager;", "analyticsTracker", "Lcom/adapty/internal/data/cloud/AnalyticsTracker;", "(Lcom/adapty/internal/data/cloud/NetworkConnectionCreator;Lcom/adapty/internal/data/cloud/HttpResponseManager;Lcom/adapty/internal/data/cloud/AnalyticsTracker;)V", "newCall", "Lcom/adapty/internal/data/cloud/Response;", "T", "request", "Lcom/adapty/internal/data/cloud/Request;", "typeOfT", "Ljava/lang/reflect/Type;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BaseHttpClient.kt */
public final class BaseHttpClient implements HttpClient {
    private final AnalyticsTracker analyticsTracker;
    private final NetworkConnectionCreator connectionCreator;
    private final HttpResponseManager responseManager;

    public BaseHttpClient(NetworkConnectionCreator networkConnectionCreator, HttpResponseManager httpResponseManager, AnalyticsTracker analyticsTracker2) {
        Intrinsics.checkNotNullParameter(networkConnectionCreator, "connectionCreator");
        Intrinsics.checkNotNullParameter(httpResponseManager, "responseManager");
        Intrinsics.checkNotNullParameter(analyticsTracker2, "analyticsTracker");
        this.connectionCreator = networkConnectionCreator;
        this.responseManager = httpResponseManager;
        this.analyticsTracker = analyticsTracker2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bd A[Catch:{ all -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d5 A[Catch:{ all -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e7 A[Catch:{ all -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0111  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ com.adapty.internal.data.cloud.Response newCall(com.adapty.internal.data.cloud.Request r9, java.lang.reflect.Type r10) {
        /*
            r8 = this;
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "typeOfT"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            com.adapty.internal.utils.Logger r0 = com.adapty.internal.utils.Logger.INSTANCE
            com.adapty.utils.AdaptyLogLevel r1 = com.adapty.utils.AdaptyLogLevel.VERBOSE
            int r2 = r1.value
            boolean r2 = r0.canLog(r2)
            java.lang.String r3 = ""
            r4 = 0
            if (r2 == 0) goto L_0x0082
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.adapty.internal.data.cloud.Request$Method r5 = r9.getMethod()
            java.lang.String r5 = r5.name()
            java.lang.StringBuilder r2 = r2.append(r5)
            r5 = 32
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r5 = r9.getUrl()
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r5 = r9.body
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x0045
            r6 = 1
            goto L_0x0046
        L_0x0045:
            r6 = 0
        L_0x0046:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r5 = r4
        L_0x0052:
            if (r5 == 0) goto L_0x0068
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = " Body: "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r5 = r6.append(r5)
            java.lang.String r5 = r5.toString()
            goto L_0x0069
        L_0x0068:
            r5 = r4
        L_0x0069:
            if (r5 != 0) goto L_0x006c
            r5 = r3
        L_0x006c:
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r2 = r2.toString()
            java.util.concurrent.ExecutorService r0 = r0.getLogExecutor()
            com.adapty.internal.utils.Logger$log$1 r5 = new com.adapty.internal.utils.Logger$log$1
            r5.<init>(r1, r2)
            java.lang.Runnable r5 = (java.lang.Runnable) r5
            r0.execute(r5)
        L_0x0082:
            com.adapty.internal.data.models.AnalyticsEvent$BackendAPIRequestData r0 = r9.systemLog
            r1 = 2
            if (r0 == 0) goto L_0x0091
            r0.resetFlowId()
            com.adapty.internal.data.cloud.AnalyticsTracker r2 = r8.analyticsTracker
            com.adapty.internal.data.models.AnalyticsEvent$CustomData r0 = (com.adapty.internal.data.models.AnalyticsEvent.CustomData) r0
            com.adapty.internal.data.cloud.AnalyticsTracker.DefaultImpls.trackSystemEvent$default(r2, r0, r4, r1, r4)
        L_0x0091:
            com.adapty.internal.data.cloud.NetworkConnectionCreator r0 = r8.connectionCreator     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            java.net.HttpURLConnection r0 = r0.createUrlConnection(r9)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            r0.connect()     // Catch:{ Exception -> 0x00a6 }
            com.adapty.internal.data.cloud.HttpResponseManager r2 = r8.responseManager     // Catch:{ Exception -> 0x00a6 }
            com.adapty.internal.data.cloud.Response r9 = r2.handleResponse(r0, r9, r10)     // Catch:{ Exception -> 0x00a6 }
            if (r0 == 0) goto L_0x00a5
            r0.disconnect()
        L_0x00a5:
            return r9
        L_0x00a6:
            r10 = move-exception
            goto L_0x00ac
        L_0x00a8:
            r9 = move-exception
            goto L_0x010f
        L_0x00aa:
            r10 = move-exception
            r0 = r4
        L_0x00ac:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x010d }
            r2.<init>()     // Catch:{ all -> 0x010d }
            java.lang.String r5 = "Request Error: "
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x010d }
            java.lang.String r5 = r10.getLocalizedMessage()     // Catch:{ all -> 0x010d }
            if (r5 != 0) goto L_0x00c1
            java.lang.String r5 = r10.getMessage()     // Catch:{ all -> 0x010d }
        L_0x00c1:
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x010d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x010d }
            com.adapty.internal.utils.Logger r5 = com.adapty.internal.utils.Logger.INSTANCE     // Catch:{ all -> 0x010d }
            com.adapty.utils.AdaptyLogLevel r6 = com.adapty.utils.AdaptyLogLevel.WARN     // Catch:{ all -> 0x010d }
            int r7 = r6.value     // Catch:{ all -> 0x010d }
            boolean r7 = r5.canLog(r7)     // Catch:{ all -> 0x010d }
            if (r7 == 0) goto L_0x00e3
            java.util.concurrent.ExecutorService r5 = r5.getLogExecutor()     // Catch:{ all -> 0x010d }
            com.adapty.internal.utils.Logger$log$1 r7 = new com.adapty.internal.utils.Logger$log$1     // Catch:{ all -> 0x010d }
            r7.<init>(r6, r2)     // Catch:{ all -> 0x010d }
            java.lang.Runnable r7 = (java.lang.Runnable) r7     // Catch:{ all -> 0x010d }
            r5.execute(r7)     // Catch:{ all -> 0x010d }
        L_0x00e3:
            com.adapty.internal.data.models.AnalyticsEvent$BackendAPIRequestData r9 = r9.systemLog     // Catch:{ all -> 0x010d }
            if (r9 == 0) goto L_0x00f7
            com.adapty.internal.data.cloud.AnalyticsTracker r5 = r8.analyticsTracker     // Catch:{ all -> 0x010d }
            com.adapty.internal.data.models.AnalyticsEvent$BackendAPIResponseData$Companion r6 = com.adapty.internal.data.models.AnalyticsEvent.BackendAPIResponseData.Companion     // Catch:{ all -> 0x010d }
            r7 = r10
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x010d }
            com.adapty.internal.data.models.AnalyticsEvent$BackendAPIResponseData r9 = r6.create(r3, r9, r7)     // Catch:{ all -> 0x010d }
            com.adapty.internal.data.models.AnalyticsEvent$CustomData r9 = (com.adapty.internal.data.models.AnalyticsEvent.CustomData) r9     // Catch:{ all -> 0x010d }
            com.adapty.internal.data.cloud.AnalyticsTracker.DefaultImpls.trackSystemEvent$default(r5, r9, r4, r1, r4)     // Catch:{ all -> 0x010d }
        L_0x00f7:
            com.adapty.internal.data.cloud.Response$Error r9 = new com.adapty.internal.data.cloud.Response$Error     // Catch:{ all -> 0x010d }
            com.adapty.errors.AdaptyError r1 = new com.adapty.errors.AdaptyError     // Catch:{ all -> 0x010d }
            java.lang.Throwable r10 = (java.lang.Throwable) r10     // Catch:{ all -> 0x010d }
            com.adapty.errors.AdaptyErrorCode r3 = com.adapty.errors.AdaptyErrorCode.REQUEST_FAILED     // Catch:{ all -> 0x010d }
            r1.<init>(r10, r2, r3)     // Catch:{ all -> 0x010d }
            r9.<init>(r1)     // Catch:{ all -> 0x010d }
            com.adapty.internal.data.cloud.Response r9 = (com.adapty.internal.data.cloud.Response) r9     // Catch:{ all -> 0x010d }
            if (r0 == 0) goto L_0x010c
            r0.disconnect()
        L_0x010c:
            return r9
        L_0x010d:
            r9 = move-exception
            r4 = r0
        L_0x010f:
            if (r4 == 0) goto L_0x0114
            r4.disconnect()
        L_0x0114:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cloud.BaseHttpClient.newCall(com.adapty.internal.data.cloud.Request, java.lang.reflect.Type):com.adapty.internal.data.cloud.Response");
    }
}
