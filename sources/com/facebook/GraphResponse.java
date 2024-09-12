package com.facebook;

import android.util.Log;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0002'(B+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010BA\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0012J\b\u0010!\u001a\u0004\u0018\u00010\fJ\b\u0010\"\u001a\u0004\u0018\u00010\tJ\u0010\u0010#\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\u0007H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006)"}, d2 = {"Lcom/facebook/GraphResponse;", "", "request", "Lcom/facebook/GraphRequest;", "connection", "Ljava/net/HttpURLConnection;", "rawResponse", "", "graphObject", "Lorg/json/JSONObject;", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/JSONObject;)V", "graphObjects", "Lorg/json/JSONArray;", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/JSONArray;)V", "error", "Lcom/facebook/FacebookRequestError;", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookRequestError;)V", "graphObjectArray", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONArray;Lcom/facebook/FacebookRequestError;)V", "getConnection", "()Ljava/net/HttpURLConnection;", "getError", "()Lcom/facebook/FacebookRequestError;", "jsonArray", "getJsonArray", "()Lorg/json/JSONArray;", "jsonObject", "getJsonObject", "()Lorg/json/JSONObject;", "getRawResponse", "()Ljava/lang/String;", "getRequest", "()Lcom/facebook/GraphRequest;", "getJSONArray", "getJSONObject", "getRequestForPagedResults", "direction", "Lcom/facebook/GraphResponse$PagingDirection;", "toString", "Companion", "PagingDirection", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GraphResponse.kt */
public final class GraphResponse {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
    private static final String RESPONSE_LOG_TAG = "Response";
    public static final String SUCCESS_KEY = "success";
    /* access modifiers changed from: private */
    public static final String TAG = GraphResponse.class.getCanonicalName();
    private final HttpURLConnection connection;
    private final FacebookRequestError error;
    private final JSONObject graphObject;
    private final JSONArray graphObjectArray;
    private final JSONArray jsonArray;
    private final JSONObject jsonObject;
    private final String rawResponse;
    private final GraphRequest request;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/GraphResponse$PagingDirection;", "", "(Ljava/lang/String;I)V", "NEXT", "PREVIOUS", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphResponse.kt */
    public enum PagingDirection {
        NEXT,
        PREVIOUS
    }

    @JvmStatic
    public static final List<GraphResponse> constructErrorResponses(List<GraphRequest> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        return Companion.constructErrorResponses(list, httpURLConnection, facebookException);
    }

    @JvmStatic
    public static final List<GraphResponse> createResponsesFromStream$facebook_core_release(InputStream inputStream, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws FacebookException, JSONException, IOException {
        return Companion.createResponsesFromStream$facebook_core_release(inputStream, httpURLConnection, graphRequestBatch);
    }

    @JvmStatic
    public static final List<GraphResponse> createResponsesFromString$facebook_core_release(String str, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws FacebookException, JSONException, IOException {
        return Companion.createResponsesFromString$facebook_core_release(str, httpURLConnection, graphRequestBatch);
    }

    @JvmStatic
    public static final List<GraphResponse> fromHttpConnection$facebook_core_release(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        return Companion.fromHttpConnection$facebook_core_release(httpURLConnection, graphRequestBatch);
    }

    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        Intrinsics.checkNotNullParameter(graphRequest, "request");
        this.request = graphRequest;
        this.connection = httpURLConnection;
        this.rawResponse = str;
        this.graphObject = jSONObject;
        this.graphObjectArray = jSONArray;
        this.error = facebookRequestError;
        this.jsonObject = jSONObject;
        this.jsonArray = jSONArray;
    }

    public final GraphRequest getRequest() {
        return this.request;
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public final String getRawResponse() {
        return this.rawResponse;
    }

    public final FacebookRequestError getError() {
        return this.error;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject) {
        this(graphRequest, httpURLConnection, str, jSONObject, (JSONArray) null, (FacebookRequestError) null);
        Intrinsics.checkNotNullParameter(graphRequest, "request");
        Intrinsics.checkNotNullParameter(str, "rawResponse");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONArray jSONArray) {
        this(graphRequest, httpURLConnection, str, (JSONObject) null, jSONArray, (FacebookRequestError) null);
        Intrinsics.checkNotNullParameter(graphRequest, "request");
        Intrinsics.checkNotNullParameter(str, "rawResponse");
        Intrinsics.checkNotNullParameter(jSONArray, "graphObjects");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(graphRequest, httpURLConnection, (String) null, (JSONObject) null, (JSONArray) null, facebookRequestError);
        Intrinsics.checkNotNullParameter(graphRequest, "request");
        Intrinsics.checkNotNullParameter(facebookRequestError, "error");
    }

    public final JSONObject getJSONObject() {
        return this.graphObject;
    }

    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public final JSONArray getJSONArray() {
        return this.graphObjectArray;
    }

    public final JSONArray getJsonArray() {
        return this.jsonArray;
    }

    public final GraphRequest getRequestForPagedResults(PagingDirection pagingDirection) {
        String str;
        JSONObject optJSONObject;
        Intrinsics.checkNotNullParameter(pagingDirection, "direction");
        JSONObject jSONObject = this.graphObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("paging")) == null) {
            str = null;
        } else {
            str = pagingDirection == PagingDirection.NEXT ? optJSONObject.optString("next") : optJSONObject.optString("previous");
        }
        Utility utility = Utility.INSTANCE;
        if (Utility.isNullOrEmpty(str)) {
            return null;
        }
        if (str != null && Intrinsics.areEqual((Object) str, (Object) this.request.getUrlForSingleRequest())) {
            return null;
        }
        try {
            return new GraphRequest(this.request.getAccessToken(), new URL(str));
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public String toString() {
        String str;
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            HttpURLConnection httpURLConnection = this.connection;
            objArr[0] = Integer.valueOf(httpURLConnection == null ? 200 : httpURLConnection.getResponseCode());
            str = String.format(locale, TimeModel.NUMBER_FORMAT, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(locale, format, *args)");
        } catch (IOException unused) {
            str = "unknown";
        }
        String str2 = "{Response: " + " responseCode: " + str + ", graphObject: " + this.graphObject + ", error: " + this.error + "}";
        Intrinsics.checkNotNullExpressionValue(str2, "StringBuilder()\n        .append(\"{Response: \")\n        .append(\" responseCode: \")\n        .append(responseCode)\n        .append(\", graphObject: \")\n        .append(graphObject)\n        .append(\", error: \")\n        .append(error)\n        .append(\"}\")\n        .toString()");
        return str2;
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J*\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001H\u0002J.\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\u0015\u001a\u00020\u0001H\u0002J/\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001cJ-\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001fJ#\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u001bH\u0001¢\u0006\u0002\b!R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/facebook/GraphResponse$Companion;", "", "()V", "BODY_KEY", "", "CODE_KEY", "NON_JSON_RESPONSE_PROPERTY", "RESPONSE_LOG_TAG", "SUCCESS_KEY", "TAG", "constructErrorResponses", "", "Lcom/facebook/GraphResponse;", "requests", "Lcom/facebook/GraphRequest;", "connection", "Ljava/net/HttpURLConnection;", "error", "Lcom/facebook/FacebookException;", "createResponseFromObject", "request", "sourceObject", "originalResult", "createResponsesFromObject", "createResponsesFromStream", "stream", "Ljava/io/InputStream;", "Lcom/facebook/GraphRequestBatch;", "createResponsesFromStream$facebook_core_release", "createResponsesFromString", "responseString", "createResponsesFromString$facebook_core_release", "fromHttpConnection", "fromHttpConnection$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphResponse.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final List<GraphResponse> fromHttpConnection$facebook_core_release(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
            List<GraphResponse> constructErrorResponses;
            Intrinsics.checkNotNullParameter(httpURLConnection, "connection");
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            InputStream inputStream = null;
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (FacebookSdk.isFullyInitialized()) {
                    if (httpURLConnection.getResponseCode() >= 400) {
                        inputStream = httpURLConnection.getErrorStream();
                    } else {
                        inputStream = httpURLConnection.getInputStream();
                    }
                    constructErrorResponses = createResponsesFromStream$facebook_core_release(inputStream, httpURLConnection, graphRequestBatch);
                    Utility utility = Utility.INSTANCE;
                    Utility.closeQuietly(inputStream);
                    return constructErrorResponses;
                }
                Log.e(GraphResponse.TAG, "GraphRequest can't be used when Facebook SDK isn't fully initialized");
                throw new FacebookException("GraphRequest can't be used when Facebook SDK isn't fully initialized");
            } catch (FacebookException e) {
                Logger.Companion.log(LoggingBehavior.REQUESTS, GraphResponse.RESPONSE_LOG_TAG, "Response <Error>: %s", e);
                constructErrorResponses = constructErrorResponses(graphRequestBatch, httpURLConnection, e);
            } catch (Exception e2) {
                Logger.Companion.log(LoggingBehavior.REQUESTS, GraphResponse.RESPONSE_LOG_TAG, "Response <Error>: %s", e2);
                constructErrorResponses = constructErrorResponses(graphRequestBatch, httpURLConnection, new FacebookException((Throwable) e2));
            } catch (Throwable th) {
                Utility utility2 = Utility.INSTANCE;
                Utility.closeQuietly((Closeable) null);
                throw th;
            }
        }

        @JvmStatic
        public final List<GraphResponse> createResponsesFromStream$facebook_core_release(InputStream inputStream, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws FacebookException, JSONException, IOException {
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            Utility utility = Utility.INSTANCE;
            String readStreamToString = Utility.readStreamToString(inputStream);
            Logger.Companion.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, GraphResponse.RESPONSE_LOG_TAG, "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(readStreamToString.length()), readStreamToString);
            return createResponsesFromString$facebook_core_release(readStreamToString, httpURLConnection, graphRequestBatch);
        }

        @JvmStatic
        public final List<GraphResponse> createResponsesFromString$facebook_core_release(String str, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws FacebookException, JSONException, IOException {
            Intrinsics.checkNotNullParameter(str, "responseString");
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            Object nextValue = new JSONTokener(str).nextValue();
            Intrinsics.checkNotNullExpressionValue(nextValue, "resultObject");
            List<GraphResponse> createResponsesFromObject = createResponsesFromObject(httpURLConnection, graphRequestBatch, nextValue);
            Logger.Companion.log(LoggingBehavior.REQUESTS, GraphResponse.RESPONSE_LOG_TAG, "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", graphRequestBatch.getId(), Integer.valueOf(str.length()), createResponsesFromObject);
            return createResponsesFromObject;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x005c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final java.util.List<com.facebook.GraphResponse> createResponsesFromObject(java.net.HttpURLConnection r9, java.util.List<com.facebook.GraphRequest> r10, java.lang.Object r11) throws com.facebook.FacebookException, org.json.JSONException {
            /*
                r8 = this;
                int r0 = r10.size()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r0)
                java.util.List r1 = (java.util.List) r1
                r2 = 0
                r3 = 1
                if (r0 != r3) goto L_0x0057
                java.lang.Object r3 = r10.get(r2)
                com.facebook.GraphRequest r3 = (com.facebook.GraphRequest) r3
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0047, IOException -> 0x0036 }
                r4.<init>()     // Catch:{ JSONException -> 0x0047, IOException -> 0x0036 }
                java.lang.String r5 = "body"
                r4.put((java.lang.String) r5, (java.lang.Object) r11)     // Catch:{ JSONException -> 0x0047, IOException -> 0x0036 }
                if (r9 != 0) goto L_0x0024
                r5 = 200(0xc8, float:2.8E-43)
                goto L_0x0028
            L_0x0024:
                int r5 = r9.getResponseCode()     // Catch:{ JSONException -> 0x0047, IOException -> 0x0036 }
            L_0x0028:
                java.lang.String r6 = "code"
                r4.put((java.lang.String) r6, (int) r5)     // Catch:{ JSONException -> 0x0047, IOException -> 0x0036 }
                org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0047, IOException -> 0x0036 }
                r5.<init>()     // Catch:{ JSONException -> 0x0047, IOException -> 0x0036 }
                r5.put((java.lang.Object) r4)     // Catch:{ JSONException -> 0x0047, IOException -> 0x0036 }
                goto L_0x0058
            L_0x0036:
                r4 = move-exception
                com.facebook.GraphResponse r5 = new com.facebook.GraphResponse
                com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
                java.lang.Exception r4 = (java.lang.Exception) r4
                r6.<init>((java.net.HttpURLConnection) r9, (java.lang.Exception) r4)
                r5.<init>(r3, r9, r6)
                r1.add(r5)
                goto L_0x0057
            L_0x0047:
                r4 = move-exception
                com.facebook.GraphResponse r5 = new com.facebook.GraphResponse
                com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
                java.lang.Exception r4 = (java.lang.Exception) r4
                r6.<init>((java.net.HttpURLConnection) r9, (java.lang.Exception) r4)
                r5.<init>(r3, r9, r6)
                r1.add(r5)
            L_0x0057:
                r5 = r11
            L_0x0058:
                boolean r3 = r5 instanceof org.json.JSONArray
                if (r3 == 0) goto L_0x00ae
                r3 = r5
                org.json.JSONArray r3 = (org.json.JSONArray) r3
                int r4 = r3.length()
                if (r4 != r0) goto L_0x00ae
                int r0 = r3.length()
                if (r0 <= 0) goto L_0x00ad
            L_0x006b:
                int r3 = r2 + 1
                java.lang.Object r4 = r10.get(r2)
                com.facebook.GraphRequest r4 = (com.facebook.GraphRequest) r4
                r6 = r5
                org.json.JSONArray r6 = (org.json.JSONArray) r6     // Catch:{ JSONException -> 0x0098, FacebookException -> 0x0087 }
                java.lang.Object r2 = r6.get(r2)     // Catch:{ JSONException -> 0x0098, FacebookException -> 0x0087 }
                java.lang.String r6 = "obj"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)     // Catch:{ JSONException -> 0x0098, FacebookException -> 0x0087 }
                com.facebook.GraphResponse r2 = r8.createResponseFromObject(r4, r9, r2, r11)     // Catch:{ JSONException -> 0x0098, FacebookException -> 0x0087 }
                r1.add(r2)     // Catch:{ JSONException -> 0x0098, FacebookException -> 0x0087 }
                goto L_0x00a8
            L_0x0087:
                r2 = move-exception
                com.facebook.GraphResponse r6 = new com.facebook.GraphResponse
                com.facebook.FacebookRequestError r7 = new com.facebook.FacebookRequestError
                java.lang.Exception r2 = (java.lang.Exception) r2
                r7.<init>((java.net.HttpURLConnection) r9, (java.lang.Exception) r2)
                r6.<init>(r4, r9, r7)
                r1.add(r6)
                goto L_0x00a8
            L_0x0098:
                r2 = move-exception
                com.facebook.GraphResponse r6 = new com.facebook.GraphResponse
                com.facebook.FacebookRequestError r7 = new com.facebook.FacebookRequestError
                java.lang.Exception r2 = (java.lang.Exception) r2
                r7.<init>((java.net.HttpURLConnection) r9, (java.lang.Exception) r2)
                r6.<init>(r4, r9, r7)
                r1.add(r6)
            L_0x00a8:
                if (r3 < r0) goto L_0x00ab
                goto L_0x00ad
            L_0x00ab:
                r2 = r3
                goto L_0x006b
            L_0x00ad:
                return r1
            L_0x00ae:
                com.facebook.FacebookException r9 = new com.facebook.FacebookException
                java.lang.String r10 = "Unexpected number of results"
                r9.<init>((java.lang.String) r10)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphResponse.Companion.createResponsesFromObject(java.net.HttpURLConnection, java.util.List, java.lang.Object):java.util.List");
        }

        private final GraphResponse createResponseFromObject(GraphRequest graphRequest, HttpURLConnection httpURLConnection, Object obj, Object obj2) throws JSONException {
            Boolean bool = null;
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                FacebookRequestError checkResponseAndCreateError = FacebookRequestError.Companion.checkResponseAndCreateError(jSONObject, obj2, httpURLConnection);
                if (checkResponseAndCreateError != null) {
                    Log.e(GraphResponse.TAG, checkResponseAndCreateError.toString());
                    if (checkResponseAndCreateError.getErrorCode() == 190) {
                        Utility utility = Utility.INSTANCE;
                        if (Utility.isCurrentAccessToken(graphRequest.getAccessToken())) {
                            if (checkResponseAndCreateError.getSubErrorCode() != 493) {
                                AccessToken.Companion.setCurrentAccessToken((AccessToken) null);
                            } else {
                                AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
                                if (currentAccessToken != null) {
                                    bool = Boolean.valueOf(currentAccessToken.isExpired());
                                }
                                if (Intrinsics.areEqual((Object) bool, (Object) false)) {
                                    AccessToken.Companion.expireCurrentAccessToken();
                                }
                            }
                        }
                    }
                    return new GraphResponse(graphRequest, httpURLConnection, checkResponseAndCreateError);
                }
                Utility utility2 = Utility.INSTANCE;
                Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject, "body", GraphResponse.NON_JSON_RESPONSE_PROPERTY);
                if (stringPropertyAsJSON instanceof JSONObject) {
                    JSONObject jSONObject2 = (JSONObject) stringPropertyAsJSON;
                    return new GraphResponse(graphRequest, httpURLConnection, jSONObject2.toString(), jSONObject2);
                } else if (stringPropertyAsJSON instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) stringPropertyAsJSON;
                    return new GraphResponse(graphRequest, httpURLConnection, jSONArray.toString(), jSONArray);
                } else {
                    obj = JSONObject.NULL;
                    Intrinsics.checkNotNullExpressionValue(obj, "NULL");
                }
            }
            if (obj == JSONObject.NULL) {
                JSONObject jSONObject3 = null;
                return new GraphResponse(graphRequest, httpURLConnection, obj.toString(), (JSONObject) null);
            }
            throw new FacebookException(Intrinsics.stringPlus("Got unexpected object type in response, class: ", obj.getClass().getSimpleName()));
        }

        @JvmStatic
        public final List<GraphResponse> constructErrorResponses(List<GraphRequest> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
            Intrinsics.checkNotNullParameter(list, "requests");
            Iterable<GraphRequest> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (GraphRequest graphResponse : iterable) {
                arrayList.add(new GraphResponse(graphResponse, httpURLConnection, new FacebookRequestError(httpURLConnection, (Exception) facebookException)));
            }
            return (List) arrayList;
        }
    }
}
