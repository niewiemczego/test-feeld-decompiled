package com.facebook.appevents.cloudbridge;

import androidx.browser.trusted.sharing.ShareTarget;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UninitializedPropertyAccessException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001@B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010 \u001a\u00020!2\u001a\u0010\"\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u001b\u0018\u00010#H\u0000¢\u0006\u0002\b$J \u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\fH\u0007J\n\u0010)\u001a\u0004\u0018\u00010\fH\u0007J=\u0010*\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010\u00052\u0018\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u001b0#2\b\b\u0002\u0010-\u001a\u00020\u0005H\u0000¢\u0006\u0004\b.\u0010/J\u0001\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\b\u00103\u001a\u0004\u0018\u00010\f2\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001b2\b\b\u0002\u00105\u001a\u00020\u00052<\u00106\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020!\u0018\u000107H\u0000¢\u0006\u0002\b;J$\u0010<\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u001b\u0018\u00010#2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020!2\u0006\u0010=\u001a\u00020>H\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R,\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u001b0\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006A"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests;", "", "()V", "ACCEPTABLE_HTTP_RESPONSE", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "MAX_CACHED_TRANSFORMED_EVENTS", "MAX_PROCESSED_TRANSFORMED_EVENTS", "MAX_RETRY_COUNT", "RETRY_EVENTS_HTTP_RESPONSE", "TAG", "", "TIMEOUT_INTERVAL", "credentials", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "getCredentials$facebook_core_release", "()Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "setCredentials$facebook_core_release", "(Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;)V", "currentRetryCount", "getCurrentRetryCount$facebook_core_release", "()I", "setCurrentRetryCount$facebook_core_release", "(I)V", "transformedEvents", "", "", "getTransformedEvents$facebook_core_release", "()Ljava/util/List;", "setTransformedEvents$facebook_core_release", "(Ljava/util/List;)V", "appendEvents", "", "events", "", "appendEvents$facebook_core_release", "configure", "datasetID", "url", "accessKey", "getCredentials", "handleError", "responseCode", "processedEvents", "maxRetryCount", "handleError$facebook_core_release", "(Ljava/lang/Integer;Ljava/util/List;I)V", "makeHttpRequest", "urlStr", "requestMethod", "jsonBodyStr", "requestProperties", "timeOutInterval", "requestCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "requestResult", "makeHttpRequest$facebook_core_release", "transformAppEventRequestForCAPIG", "request", "Lcom/facebook/GraphRequest;", "transformGraphRequestAndSendToCAPIGEndPoint", "CloudBridgeCredentials", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppEventsConversionsAPITransformerWebRequests.kt */
public final class AppEventsConversionsAPITransformerWebRequests {
    /* access modifiers changed from: private */
    public static final HashSet<Integer> ACCEPTABLE_HTTP_RESPONSE = SetsKt.hashSetOf(200, 202);
    public static final AppEventsConversionsAPITransformerWebRequests INSTANCE = new AppEventsConversionsAPITransformerWebRequests();
    public static final int MAX_CACHED_TRANSFORMED_EVENTS = 1000;
    private static final int MAX_PROCESSED_TRANSFORMED_EVENTS = 10;
    public static final int MAX_RETRY_COUNT = 5;
    private static final HashSet<Integer> RETRY_EVENTS_HTTP_RESPONSE = SetsKt.hashSetOf(503, 504, 429);
    private static final String TAG = "CAPITransformerWebRequests";
    private static final int TIMEOUT_INTERVAL = 60000;
    public static CloudBridgeCredentials credentials;
    private static int currentRetryCount;
    public static List<Map<String, Object>> transformedEvents;

    private AppEventsConversionsAPITransformerWebRequests() {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "", "datasetID", "", "cloudBridgeURL", "accessKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKey", "()Ljava/lang/String;", "getCloudBridgeURL", "getDatasetID", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AppEventsConversionsAPITransformerWebRequests.kt */
    public static final class CloudBridgeCredentials {
        private final String accessKey;
        private final String cloudBridgeURL;
        private final String datasetID;

        public static /* synthetic */ CloudBridgeCredentials copy$default(CloudBridgeCredentials cloudBridgeCredentials, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cloudBridgeCredentials.datasetID;
            }
            if ((i & 2) != 0) {
                str2 = cloudBridgeCredentials.cloudBridgeURL;
            }
            if ((i & 4) != 0) {
                str3 = cloudBridgeCredentials.accessKey;
            }
            return cloudBridgeCredentials.copy(str, str2, str3);
        }

        public final String component1() {
            return this.datasetID;
        }

        public final String component2() {
            return this.cloudBridgeURL;
        }

        public final String component3() {
            return this.accessKey;
        }

        public final CloudBridgeCredentials copy(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "datasetID");
            Intrinsics.checkNotNullParameter(str2, "cloudBridgeURL");
            Intrinsics.checkNotNullParameter(str3, "accessKey");
            return new CloudBridgeCredentials(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CloudBridgeCredentials)) {
                return false;
            }
            CloudBridgeCredentials cloudBridgeCredentials = (CloudBridgeCredentials) obj;
            return Intrinsics.areEqual((Object) this.datasetID, (Object) cloudBridgeCredentials.datasetID) && Intrinsics.areEqual((Object) this.cloudBridgeURL, (Object) cloudBridgeCredentials.cloudBridgeURL) && Intrinsics.areEqual((Object) this.accessKey, (Object) cloudBridgeCredentials.accessKey);
        }

        public int hashCode() {
            return (((this.datasetID.hashCode() * 31) + this.cloudBridgeURL.hashCode()) * 31) + this.accessKey.hashCode();
        }

        public String toString() {
            return "CloudBridgeCredentials(datasetID=" + this.datasetID + ", cloudBridgeURL=" + this.cloudBridgeURL + ", accessKey=" + this.accessKey + ')';
        }

        public CloudBridgeCredentials(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "datasetID");
            Intrinsics.checkNotNullParameter(str2, "cloudBridgeURL");
            Intrinsics.checkNotNullParameter(str3, "accessKey");
            this.datasetID = str;
            this.cloudBridgeURL = str2;
            this.accessKey = str3;
        }

        public final String getDatasetID() {
            return this.datasetID;
        }

        public final String getCloudBridgeURL() {
            return this.cloudBridgeURL;
        }

        public final String getAccessKey() {
            return this.accessKey;
        }
    }

    public final CloudBridgeCredentials getCredentials$facebook_core_release() {
        CloudBridgeCredentials cloudBridgeCredentials = credentials;
        if (cloudBridgeCredentials != null) {
            return cloudBridgeCredentials;
        }
        Intrinsics.throwUninitializedPropertyAccessException("credentials");
        throw null;
    }

    public final void setCredentials$facebook_core_release(CloudBridgeCredentials cloudBridgeCredentials) {
        Intrinsics.checkNotNullParameter(cloudBridgeCredentials, "<set-?>");
        credentials = cloudBridgeCredentials;
    }

    public final List<Map<String, Object>> getTransformedEvents$facebook_core_release() {
        List<Map<String, Object>> list = transformedEvents;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("transformedEvents");
        throw null;
    }

    public final void setTransformedEvents$facebook_core_release(List<Map<String, Object>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        transformedEvents = list;
    }

    public final int getCurrentRetryCount$facebook_core_release() {
        return currentRetryCount;
    }

    public final void setCurrentRetryCount$facebook_core_release(int i) {
        currentRetryCount = i;
    }

    @JvmStatic
    public static final void configure(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "datasetID");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(str3, "accessKey");
        Logger.Companion companion = Logger.Companion;
        LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
        AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = INSTANCE;
        companion.log(loggingBehavior, TAG, " \n\nCloudbridge Configured: \n================\ndatasetID: %s\nurl: %s\naccessKey: %s\n\n", str, str2, str3);
        appEventsConversionsAPITransformerWebRequests.setCredentials$facebook_core_release(new CloudBridgeCredentials(str, str2, str3));
        appEventsConversionsAPITransformerWebRequests.setTransformedEvents$facebook_core_release(new ArrayList());
    }

    @JvmStatic
    public static final String getCredentials() {
        try {
            CloudBridgeCredentials credentials$facebook_core_release = INSTANCE.getCredentials$facebook_core_release();
            if (credentials$facebook_core_release == null) {
                return null;
            }
            return credentials$facebook_core_release.toString();
        } catch (UninitializedPropertyAccessException unused) {
            String str = null;
            return null;
        }
    }

    @JvmStatic
    public static final void transformGraphRequestAndSendToCAPIGEndPoint(GraphRequest graphRequest) {
        Intrinsics.checkNotNullParameter(graphRequest, "request");
        Utility utility = Utility.INSTANCE;
        Utility.runOnNonUiThread(new AppEventsConversionsAPITransformerWebRequests$$ExternalSyntheticLambda0(graphRequest));
    }

    /* access modifiers changed from: private */
    /* renamed from: transformGraphRequestAndSendToCAPIGEndPoint$lambda-0  reason: not valid java name */
    public static final void m250transformGraphRequestAndSendToCAPIGEndPoint$lambda0(GraphRequest graphRequest) {
        Intrinsics.checkNotNullParameter(graphRequest, "$request");
        String graphPath = graphRequest.getGraphPath();
        List split$default = graphPath == null ? null : StringsKt.split$default((CharSequence) graphPath, new String[]{"/"}, false, 0, 6, (Object) null);
        if (split$default == null || split$default.size() != 2) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "\n GraphPathComponents Error when logging: \n%s", graphRequest);
            return;
        }
        try {
            AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = INSTANCE;
            String str = appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getCloudBridgeURL() + "/capi/" + appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getDatasetID() + "/events";
            List<Map<String, Object>> transformAppEventRequestForCAPIG = appEventsConversionsAPITransformerWebRequests.transformAppEventRequestForCAPIG(graphRequest);
            if (transformAppEventRequestForCAPIG != null) {
                appEventsConversionsAPITransformerWebRequests.appendEvents$facebook_core_release(transformAppEventRequestForCAPIG);
                int min = Math.min(appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().size(), 10);
                List<T> slice = CollectionsKt.slice(appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release(), new IntRange(0, min - 1));
                appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().subList(0, min).clear();
                JSONArray jSONArray = new JSONArray((Collection<?>) slice);
                Map linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("data", jSONArray);
                linkedHashMap.put("accessKey", appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getAccessKey());
                JSONObject jSONObject = new JSONObject((Map<?, ?>) linkedHashMap);
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                String jSONObject2 = jSONObject.toString(2);
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonBodyStr.toString(2)");
                companion.log(loggingBehavior, TAG, "\nTransformed_CAPI_JSON:\nURL: %s\nFROM=========\n%s\n>>>>>>TO>>>>>>\n%s\n=============\n", str, graphRequest, jSONObject2);
                appEventsConversionsAPITransformerWebRequests.makeHttpRequest$facebook_core_release(str, ShareTarget.METHOD_POST, jSONObject.toString(), MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json")), TIMEOUT_INTERVAL, new AppEventsConversionsAPITransformerWebRequests$transformGraphRequestAndSendToCAPIGEndPoint$1$1(slice));
            }
        } catch (UninitializedPropertyAccessException e) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "\n Credentials not initialized Error when logging: \n%s", e);
        }
    }

    private final List<Map<String, Object>> transformAppEventRequestForCAPIG(GraphRequest graphRequest) {
        JSONObject graphObject = graphRequest.getGraphObject();
        if (graphObject == null) {
            return null;
        }
        Utility utility = Utility.INSTANCE;
        Map<String, Object> mutableMap = MapsKt.toMutableMap(Utility.convertJSONObjectToHashMap(graphObject));
        Object tag = graphRequest.getTag();
        if (tag != null) {
            mutableMap.put("custom_events", tag);
            StringBuilder sb = new StringBuilder();
            for (String next : mutableMap.keySet()) {
                sb.append(next);
                sb.append(" : ");
                sb.append(mutableMap.get(next));
                sb.append(System.getProperty("line.separator"));
            }
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "\nGraph Request data: \n\n%s \n\n", sb);
            return AppEventsConversionsAPITransformer.INSTANCE.conversionsAPICompatibleEvent$facebook_core_release(mutableMap);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    }

    public static /* synthetic */ void handleError$facebook_core_release$default(AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests, Integer num, List list, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 5;
        }
        appEventsConversionsAPITransformerWebRequests.handleError$facebook_core_release(num, list, i);
    }

    public final void handleError$facebook_core_release(Integer num, List<? extends Map<String, ? extends Object>> list, int i) {
        Intrinsics.checkNotNullParameter(list, "processedEvents");
        if (!CollectionsKt.contains(RETRY_EVENTS_HTTP_RESPONSE, num)) {
            return;
        }
        if (currentRetryCount >= i) {
            getTransformedEvents$facebook_core_release().clear();
            currentRetryCount = 0;
            return;
        }
        getTransformedEvents$facebook_core_release().addAll(0, list);
        currentRetryCount++;
    }

    public final void appendEvents$facebook_core_release(List<? extends Map<String, ? extends Object>> list) {
        if (list != null) {
            getTransformedEvents$facebook_core_release().addAll(list);
        }
        int max = Math.max(0, getTransformedEvents$facebook_core_release().size() - 1000);
        if (max > 0) {
            setTransformedEvents$facebook_core_release(TypeIntrinsics.asMutableList(CollectionsKt.drop(getTransformedEvents$facebook_core_release(), max)));
        }
    }

    public static /* synthetic */ void makeHttpRequest$facebook_core_release$default(AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests, String str, String str2, String str3, Map map, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            i = TIMEOUT_INTERVAL;
        }
        appEventsConversionsAPITransformerWebRequests.makeHttpRequest$facebook_core_release(str, str2, str3, map, i, function2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cb, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cf, code lost:
        throw r9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a1 A[Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f3 A[Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void makeHttpRequest$facebook_core_release(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11, int r12, kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> r13) {
        /*
            r7 = this;
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = "CAPITransformerWebRequests"
            java.lang.String r2 = "urlStr"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)
            java.lang.String r2 = "requestMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)
            r2 = 0
            r3 = 0
            r4 = 1
            java.net.URL r5 = new java.net.URL     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r5.<init>(r8)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.net.URLConnection r8 = r5.openConnection()     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            if (r8 == 0) goto L_0x00ff
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r8.setRequestMethod(r9)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            if (r11 != 0) goto L_0x0024
            goto L_0x0047
        L_0x0024:
            java.util.Set r9 = r11.keySet()     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            if (r9 != 0) goto L_0x002b
            goto L_0x0047
        L_0x002b:
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
        L_0x0031:
            boolean r5 = r9.hasNext()     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            if (r5 == 0) goto L_0x0047
            java.lang.Object r5 = r9.next()     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.lang.Object r6 = r11.get(r5)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r8.setRequestProperty(r5, r6)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            goto L_0x0031
        L_0x0047:
            java.lang.String r9 = r8.getRequestMethod()     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.lang.String r11 = "POST"
            boolean r9 = r9.equals(r11)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            if (r9 != 0) goto L_0x0062
            java.lang.String r9 = r8.getRequestMethod()     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.lang.String r11 = "PUT"
            boolean r9 = r9.equals(r11)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            if (r9 == 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r9 = r3
            goto L_0x0063
        L_0x0062:
            r9 = r4
        L_0x0063:
            r8.setDoOutput(r9)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r8.setConnectTimeout(r12)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.io.OutputStream r11 = r8.getOutputStream()     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r9.<init>(r11)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.io.OutputStream r9 = (java.io.OutputStream) r9     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.io.BufferedWriter r11 = new java.io.BufferedWriter     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.io.OutputStreamWriter r12 = new java.io.OutputStreamWriter     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r12.<init>(r9, r0)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.io.Writer r12 = (java.io.Writer) r12     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r11.<init>(r12)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r11.write(r10)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r11.flush()     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r11.close()     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r9.close()     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r9.<init>()     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.util.HashSet<java.lang.Integer> r10 = ACCEPTABLE_HTTP_RESPONSE     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            int r11 = r8.getResponseCode()     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            boolean r10 = r10.contains(r11)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            if (r10 == 0) goto L_0x00d0
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.io.InputStreamReader r11 = new java.io.InputStreamReader     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.io.InputStream r12 = r8.getInputStream()     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r11.<init>(r12, r0)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.io.Reader r11 = (java.io.Reader) r11     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r10.<init>(r11)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.io.Closeable r10 = (java.io.Closeable) r10     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r11 = r2
            java.lang.Throwable r11 = (java.lang.Throwable) r11     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r11 = r10
            java.io.BufferedReader r11 = (java.io.BufferedReader) r11     // Catch:{ all -> 0x00c9 }
        L_0x00b9:
            java.lang.String r12 = r11.readLine()     // Catch:{ all -> 0x00c9 }
            if (r12 == 0) goto L_0x00c3
            r9.append(r12)     // Catch:{ all -> 0x00c9 }
            goto L_0x00b9
        L_0x00c3:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c9 }
            kotlin.io.CloseableKt.closeFinally(r10, r2)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            goto L_0x00d0
        L_0x00c9:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x00cb }
        L_0x00cb:
            r9 = move-exception
            kotlin.io.CloseableKt.closeFinally(r10, r8)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            throw r9     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
        L_0x00d0:
            java.lang.String r9 = r9.toString()     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.lang.String r10 = "connResponseSB.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            com.facebook.internal.Logger$Companion r10 = com.facebook.internal.Logger.Companion     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            com.facebook.LoggingBehavior r11 = com.facebook.LoggingBehavior.APP_EVENTS     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.lang.String r12 = "\nResponse Received: \n%s\n%s"
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r0[r3] = r9     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            int r5 = r8.getResponseCode()     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r0[r4] = r5     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r10.log((com.facebook.LoggingBehavior) r11, (java.lang.String) r1, (java.lang.String) r12, (java.lang.Object[]) r0)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            if (r13 == 0) goto L_0x0137
            int r8 = r8.getResponseCode()     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            r13.invoke(r9, r8)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            goto L_0x0137
        L_0x00ff:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            java.lang.String r9 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r8.<init>(r9)     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
            throw r8     // Catch:{ UnknownHostException -> 0x011a, IOException -> 0x0107 }
        L_0x0107:
            r8 = move-exception
            com.facebook.internal.Logger$Companion r9 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r10 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            java.lang.Object[] r11 = new java.lang.Object[r4]
            java.lang.String r8 = r8.toString()
            r11[r3] = r8
            java.lang.String r8 = "Send to server failed: \n%s"
            r9.log((com.facebook.LoggingBehavior) r10, (java.lang.String) r1, (java.lang.String) r8, (java.lang.Object[]) r11)
            goto L_0x0137
        L_0x011a:
            r8 = move-exception
            com.facebook.internal.Logger$Companion r9 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r10 = com.facebook.LoggingBehavior.APP_EVENTS
            java.lang.Object[] r11 = new java.lang.Object[r4]
            java.lang.String r8 = r8.toString()
            r11[r3] = r8
            java.lang.String r8 = "Connection failed, retrying: \n%s"
            r9.log((com.facebook.LoggingBehavior) r10, (java.lang.String) r1, (java.lang.String) r8, (java.lang.Object[]) r11)
            if (r13 == 0) goto L_0x0137
            r8 = 503(0x1f7, float:7.05E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r13.invoke(r2, r8)
        L_0x0137:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests.makeHttpRequest$facebook_core_release(java.lang.String, java.lang.String, java.lang.String, java.util.Map, int, kotlin.jvm.functions.Function2):void");
    }
}
