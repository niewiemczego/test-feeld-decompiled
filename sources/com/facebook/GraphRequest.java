package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.browser.trusted.sharing.ShareTarget;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.reactnativecommunity.clipboard.ClipboardModule;
import io.sentry.protocol.Response;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 `2\u00020\u0001:\t^_`abcdefBO\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rB\u0019\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010F\u001a\u00020GH\u0002J\u0018\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u001eH\u0002J\u0006\u0010K\u001a\u00020LJ\u0006\u0010M\u001a\u00020NJ\n\u0010O\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010P\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010Q\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u0005H\u0002J\b\u0010R\u001a\u00020\u001eH\u0002J\b\u0010S\u001a\u00020\u001eH\u0002J$\u0010T\u001a\u00020G2\u0006\u0010U\u001a\u00020V2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020Y0XH\u0002J\u000e\u0010Z\u001a\u00020G2\u0006\u0010[\u001a\u00020\u001eJ\b\u0010\\\u001a\u00020\u001eH\u0002J\b\u0010]\u001a\u00020\u0005H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R\u0016\u00100\u001a\u0004\u0018\u00010\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0017R(\u0010\b\u001a\u0004\u0018\u00010\t2\b\u00102\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0011\u0010;\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b<\u0010\u0017R\u001c\u0010=\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0011\u0010B\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bC\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0017\"\u0004\bE\u0010\u0019¨\u0006g"}, d2 = {"Lcom/facebook/GraphRequest;", "", "accessToken", "Lcom/facebook/AccessToken;", "graphPath", "", "parameters", "Landroid/os/Bundle;", "httpMethod", "Lcom/facebook/HttpMethod;", "callback", "Lcom/facebook/GraphRequest$Callback;", "version", "(Lcom/facebook/AccessToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/HttpMethod;Lcom/facebook/GraphRequest$Callback;Ljava/lang/String;)V", "overriddenURL", "Ljava/net/URL;", "(Lcom/facebook/AccessToken;Ljava/net/URL;)V", "getAccessToken", "()Lcom/facebook/AccessToken;", "setAccessToken", "(Lcom/facebook/AccessToken;)V", "batchEntryDependsOn", "getBatchEntryDependsOn", "()Ljava/lang/String;", "setBatchEntryDependsOn", "(Ljava/lang/String;)V", "batchEntryName", "getBatchEntryName", "setBatchEntryName", "batchEntryOmitResultOnSuccess", "", "getBatchEntryOmitResultOnSuccess", "()Z", "setBatchEntryOmitResultOnSuccess", "(Z)V", "getCallback", "()Lcom/facebook/GraphRequest$Callback;", "setCallback", "(Lcom/facebook/GraphRequest$Callback;)V", "forceApplicationRequest", "graphObject", "Lorg/json/JSONObject;", "getGraphObject", "()Lorg/json/JSONObject;", "setGraphObject", "(Lorg/json/JSONObject;)V", "getGraphPath", "setGraphPath", "graphPathWithVersion", "getGraphPathWithVersion", "value", "getHttpMethod", "()Lcom/facebook/HttpMethod;", "setHttpMethod", "(Lcom/facebook/HttpMethod;)V", "getParameters", "()Landroid/os/Bundle;", "setParameters", "(Landroid/os/Bundle;)V", "relativeUrlForBatchedRequest", "getRelativeUrlForBatchedRequest", "tag", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "urlForSingleRequest", "getUrlForSingleRequest", "getVersion", "setVersion", "addCommonParameters", "", "appendParametersToBaseUrl", "baseUrl", "isBatch", "executeAndWait", "Lcom/facebook/GraphResponse;", "executeAsync", "Lcom/facebook/GraphRequestAsyncTask;", "getAccessTokenToUseForRequest", "getClientTokenForRequest", "getUrlWithGraphPath", "isApplicationRequest", "isValidGraphRequestForDomain", "serializeToBatch", "batch", "Lorg/json/JSONArray;", "attachments", "", "Lcom/facebook/GraphRequest$Attachment;", "setForceApplicationRequest", "forceOverride", "shouldForceClientTokenForRequest", "toString", "Attachment", "Callback", "Companion", "GraphJSONArrayCallback", "GraphJSONObjectCallback", "KeyValueSerializer", "OnProgressCallback", "ParcelableResourceWithMimeType", "Serializer", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GraphRequest.kt */
public final class GraphRequest {
    private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
    public static final String ACCESS_TOKEN_PARAM = "access_token";
    private static final String ATTACHED_FILES_PARAM = "attached_files";
    private static final String ATTACHMENT_FILENAME_PREFIX = "file";
    private static final String BATCH_APP_ID_PARAM = "batch_app_id";
    private static final String BATCH_BODY_PARAM = "body";
    private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
    private static final String BATCH_ENTRY_NAME_PARAM = "name";
    private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
    private static final String BATCH_METHOD_PARAM = "method";
    private static final String BATCH_PARAM = "batch";
    private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
    private static final String CAPTION_PARAM = "caption";
    private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEBUG_KEY = "__debug__";
    private static final String DEBUG_MESSAGES_KEY = "messages";
    private static final String DEBUG_MESSAGE_KEY = "message";
    private static final String DEBUG_MESSAGE_LINK_KEY = "link";
    private static final String DEBUG_MESSAGE_TYPE_KEY = "type";
    private static final String DEBUG_PARAM = "debug";
    private static final String DEBUG_SEVERITY_INFO = "info";
    private static final String DEBUG_SEVERITY_WARNING = "warning";
    public static final String FIELDS_PARAM = "fields";
    private static final String FORMAT_JSON = "json";
    private static final String FORMAT_PARAM = "format";
    private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final int MAXIMUM_BATCH_SIZE = 50;
    private static final String ME = "me";
    /* access modifiers changed from: private */
    public static final String MIME_BOUNDARY;
    private static final String MY_FRIENDS = "me/friends";
    private static final String MY_PHOTOS = "me/photos";
    private static final String PICTURE_PARAM = "picture";
    private static final String SDK_ANDROID = "android";
    private static final String SDK_PARAM = "sdk";
    private static final String SEARCH = "search";
    public static final String TAG = "GraphRequest";
    private static final String USER_AGENT_BASE = "FBAndroidSDK";
    private static final String USER_AGENT_HEADER = "User-Agent";
    private static final String VIDEOS_SUFFIX = "/videos";
    /* access modifiers changed from: private */
    public static String defaultBatchApplicationId;
    /* access modifiers changed from: private */
    public static volatile String userAgent;
    /* access modifiers changed from: private */
    public static final Pattern versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    private AccessToken accessToken;
    private String batchEntryDependsOn;
    private String batchEntryName;
    private boolean batchEntryOmitResultOnSuccess;
    private Callback callback;
    private boolean forceApplicationRequest;
    private JSONObject graphObject;
    private String graphPath;
    private HttpMethod httpMethod;
    private String overriddenURL;
    private Bundle parameters;
    private Object tag;
    private String version;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/GraphRequest$Callback;", "", "onCompleted", "", "response", "Lcom/facebook/GraphResponse;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequest.kt */
    public interface Callback {
        void onCompleted(GraphResponse graphResponse);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/facebook/GraphRequest$GraphJSONArrayCallback;", "", "onCompleted", "", "objects", "Lorg/json/JSONArray;", "response", "Lcom/facebook/GraphResponse;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequest.kt */
    public interface GraphJSONArrayCallback {
        void onCompleted(JSONArray jSONArray, GraphResponse graphResponse);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/facebook/GraphRequest$GraphJSONObjectCallback;", "", "onCompleted", "", "obj", "Lorg/json/JSONObject;", "response", "Lcom/facebook/GraphResponse;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequest.kt */
    public interface GraphJSONObjectCallback {
        void onCompleted(JSONObject jSONObject, GraphResponse graphResponse);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bâ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/facebook/GraphRequest$KeyValueSerializer;", "", "writeString", "", "key", "", "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequest.kt */
    private interface KeyValueSerializer {
        void writeString(String str, String str2);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/facebook/GraphRequest$OnProgressCallback;", "Lcom/facebook/GraphRequest$Callback;", "onProgress", "", "current", "", "max", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequest.kt */
    public interface OnProgressCallback extends Callback {
        void onProgress(long j, long j2);
    }

    public GraphRequest() {
        this((AccessToken) null, (String) null, (Bundle) null, (HttpMethod) null, (Callback) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public GraphRequest(AccessToken accessToken2) {
        this(accessToken2, (String) null, (Bundle) null, (HttpMethod) null, (Callback) null, (String) null, 62, (DefaultConstructorMarker) null);
    }

    public GraphRequest(AccessToken accessToken2, String str) {
        this(accessToken2, str, (Bundle) null, (HttpMethod) null, (Callback) null, (String) null, 60, (DefaultConstructorMarker) null);
    }

    public GraphRequest(AccessToken accessToken2, String str, Bundle bundle) {
        this(accessToken2, str, bundle, (HttpMethod) null, (Callback) null, (String) null, 56, (DefaultConstructorMarker) null);
    }

    public GraphRequest(AccessToken accessToken2, String str, Bundle bundle, HttpMethod httpMethod2) {
        this(accessToken2, str, bundle, httpMethod2, (Callback) null, (String) null, 48, (DefaultConstructorMarker) null);
    }

    public GraphRequest(AccessToken accessToken2, String str, Bundle bundle, HttpMethod httpMethod2, Callback callback2) {
        this(accessToken2, str, bundle, httpMethod2, callback2, (String) null, 32, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final GraphResponse executeAndWait(GraphRequest graphRequest) {
        return Companion.executeAndWait(graphRequest);
    }

    @JvmStatic
    public static final List<GraphResponse> executeBatchAndWait(GraphRequestBatch graphRequestBatch) {
        return Companion.executeBatchAndWait(graphRequestBatch);
    }

    @JvmStatic
    public static final List<GraphResponse> executeBatchAndWait(Collection<GraphRequest> collection) {
        return Companion.executeBatchAndWait(collection);
    }

    @JvmStatic
    public static final List<GraphResponse> executeBatchAndWait(GraphRequest... graphRequestArr) {
        return Companion.executeBatchAndWait(graphRequestArr);
    }

    @JvmStatic
    public static final GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch graphRequestBatch) {
        return Companion.executeBatchAsync(graphRequestBatch);
    }

    @JvmStatic
    public static final GraphRequestAsyncTask executeBatchAsync(Collection<GraphRequest> collection) {
        return Companion.executeBatchAsync(collection);
    }

    @JvmStatic
    public static final GraphRequestAsyncTask executeBatchAsync(GraphRequest... graphRequestArr) {
        return Companion.executeBatchAsync(graphRequestArr);
    }

    @JvmStatic
    public static final List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        return Companion.executeConnectionAndWait(httpURLConnection, graphRequestBatch);
    }

    @JvmStatic
    public static final List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, Collection<GraphRequest> collection) {
        return Companion.executeConnectionAndWait(httpURLConnection, collection);
    }

    @JvmStatic
    public static final GraphRequestAsyncTask executeConnectionAsync(Handler handler, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        return Companion.executeConnectionAsync(handler, httpURLConnection, graphRequestBatch);
    }

    @JvmStatic
    public static final GraphRequestAsyncTask executeConnectionAsync(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        return Companion.executeConnectionAsync(httpURLConnection, graphRequestBatch);
    }

    @JvmStatic
    public static final String getDefaultBatchApplicationId() {
        return Companion.getDefaultBatchApplicationId();
    }

    @JvmStatic
    public static final GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken2, Context context, Callback callback2) {
        return Companion.newCustomAudienceThirdPartyIdRequest(accessToken2, context, callback2);
    }

    @JvmStatic
    public static final GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken2, Context context, String str, Callback callback2) {
        return Companion.newCustomAudienceThirdPartyIdRequest(accessToken2, context, str, callback2);
    }

    @JvmStatic
    public static final GraphRequest newDeleteObjectRequest(AccessToken accessToken2, String str, Callback callback2) {
        return Companion.newDeleteObjectRequest(accessToken2, str, callback2);
    }

    @JvmStatic
    public static final GraphRequest newGraphPathRequest(AccessToken accessToken2, String str, Callback callback2) {
        return Companion.newGraphPathRequest(accessToken2, str, callback2);
    }

    @JvmStatic
    public static final GraphRequest newMeRequest(AccessToken accessToken2, GraphJSONObjectCallback graphJSONObjectCallback) {
        return Companion.newMeRequest(accessToken2, graphJSONObjectCallback);
    }

    @JvmStatic
    public static final GraphRequest newMyFriendsRequest(AccessToken accessToken2, GraphJSONArrayCallback graphJSONArrayCallback) {
        return Companion.newMyFriendsRequest(accessToken2, graphJSONArrayCallback);
    }

    @JvmStatic
    public static final GraphRequest newPlacesSearchRequest(AccessToken accessToken2, Location location, int i, int i2, String str, GraphJSONArrayCallback graphJSONArrayCallback) {
        return Companion.newPlacesSearchRequest(accessToken2, location, i, i2, str, graphJSONArrayCallback);
    }

    @JvmStatic
    public static final GraphRequest newPostRequest(AccessToken accessToken2, String str, JSONObject jSONObject, Callback callback2) {
        return Companion.newPostRequest(accessToken2, str, jSONObject, callback2);
    }

    @JvmStatic
    public static final GraphRequest newPostRequestWithBundle(AccessToken accessToken2, String str, Bundle bundle, Callback callback2) {
        return Companion.newPostRequestWithBundle(accessToken2, str, bundle, callback2);
    }

    @JvmStatic
    public static final GraphRequest newUploadPhotoRequest(AccessToken accessToken2, String str, Bitmap bitmap, String str2, Bundle bundle, Callback callback2) {
        return Companion.newUploadPhotoRequest(accessToken2, str, bitmap, str2, bundle, callback2);
    }

    @JvmStatic
    public static final GraphRequest newUploadPhotoRequest(AccessToken accessToken2, String str, Uri uri, String str2, Bundle bundle, Callback callback2) throws FileNotFoundException, FacebookException {
        return Companion.newUploadPhotoRequest(accessToken2, str, uri, str2, bundle, callback2);
    }

    @JvmStatic
    public static final GraphRequest newUploadPhotoRequest(AccessToken accessToken2, String str, File file, String str2, Bundle bundle, Callback callback2) throws FileNotFoundException {
        return Companion.newUploadPhotoRequest(accessToken2, str, file, str2, bundle, callback2);
    }

    @JvmStatic
    public static final void runCallbacks$facebook_core_release(GraphRequestBatch graphRequestBatch, List<GraphResponse> list) {
        Companion.runCallbacks$facebook_core_release(graphRequestBatch, list);
    }

    @JvmStatic
    public static final void serializeToUrlConnection$facebook_core_release(GraphRequestBatch graphRequestBatch, HttpURLConnection httpURLConnection) throws IOException, JSONException {
        Companion.serializeToUrlConnection$facebook_core_release(graphRequestBatch, httpURLConnection);
    }

    @JvmStatic
    public static final void setDefaultBatchApplicationId(String str) {
        Companion.setDefaultBatchApplicationId(str);
    }

    @JvmStatic
    public static final HttpURLConnection toHttpConnection(GraphRequestBatch graphRequestBatch) {
        return Companion.toHttpConnection(graphRequestBatch);
    }

    @JvmStatic
    public static final HttpURLConnection toHttpConnection(Collection<GraphRequest> collection) {
        return Companion.toHttpConnection(collection);
    }

    @JvmStatic
    public static final HttpURLConnection toHttpConnection(GraphRequest... graphRequestArr) {
        return Companion.toHttpConnection(graphRequestArr);
    }

    @JvmStatic
    public static final void validateFieldsParamForGetRequests$facebook_core_release(GraphRequestBatch graphRequestBatch) {
        Companion.validateFieldsParamForGetRequests$facebook_core_release(graphRequestBatch);
    }

    public final AccessToken getAccessToken() {
        return this.accessToken;
    }

    public final void setAccessToken(AccessToken accessToken2) {
        this.accessToken = accessToken2;
    }

    public final String getGraphPath() {
        return this.graphPath;
    }

    public final void setGraphPath(String str) {
        this.graphPath = str;
    }

    public final JSONObject getGraphObject() {
        return this.graphObject;
    }

    public final void setGraphObject(JSONObject jSONObject) {
        this.graphObject = jSONObject;
    }

    public final String getBatchEntryName() {
        return this.batchEntryName;
    }

    public final void setBatchEntryName(String str) {
        this.batchEntryName = str;
    }

    public final String getBatchEntryDependsOn() {
        return this.batchEntryDependsOn;
    }

    public final void setBatchEntryDependsOn(String str) {
        this.batchEntryDependsOn = str;
    }

    public final boolean getBatchEntryOmitResultOnSuccess() {
        return this.batchEntryOmitResultOnSuccess;
    }

    public final void setBatchEntryOmitResultOnSuccess(boolean z) {
        this.batchEntryOmitResultOnSuccess = z;
    }

    public final Bundle getParameters() {
        return this.parameters;
    }

    public final void setParameters(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<set-?>");
        this.parameters = bundle;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(Callback callback2) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
                this.callback = callback2;
                return;
            }
        }
        this.callback = new GraphRequest$$ExternalSyntheticLambda0(callback2);
    }

    /* access modifiers changed from: private */
    /* renamed from: _set_callback_$lambda-0  reason: not valid java name */
    public static final void m209_set_callback_$lambda0(Callback callback2, GraphResponse graphResponse) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(graphResponse, Response.TYPE);
        JSONObject jSONObject2 = graphResponse.getJSONObject();
        if (jSONObject2 == null) {
            jSONObject = null;
        } else {
            jSONObject = jSONObject2.optJSONObject(DEBUG_KEY);
        }
        if (jSONObject == null) {
            jSONArray = null;
        } else {
            jSONArray = jSONObject.optJSONArray(DEBUG_MESSAGES_KEY);
        }
        if (jSONArray != null) {
            int i = 0;
            int length = jSONArray.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject == null) {
                        str = null;
                    } else {
                        str = optJSONObject.optString("message");
                    }
                    if (optJSONObject == null) {
                        str2 = null;
                    } else {
                        str2 = optJSONObject.optString("type");
                    }
                    if (optJSONObject == null) {
                        str3 = null;
                    } else {
                        str3 = optJSONObject.optString("link");
                    }
                    if (!(str == null || str2 == null)) {
                        LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                        if (Intrinsics.areEqual((Object) str2, (Object) DEBUG_SEVERITY_WARNING)) {
                            loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                        }
                        Utility utility = Utility.INSTANCE;
                        if (!Utility.isNullOrEmpty(str3)) {
                            str = str + " Link: " + str3;
                        }
                        Logger.Companion companion = Logger.Companion;
                        String str4 = TAG;
                        Intrinsics.checkNotNullExpressionValue(str4, "TAG");
                        companion.log(loggingBehavior, str4, str);
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
        }
        if (callback2 != null) {
            callback2.onCompleted(graphResponse);
        }
    }

    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public final void setHttpMethod(HttpMethod httpMethod2) {
        if (this.overriddenURL == null || httpMethod2 == HttpMethod.GET) {
            if (httpMethod2 == null) {
                httpMethod2 = HttpMethod.GET;
            }
            this.httpMethod = httpMethod2;
            return;
        }
        throw new FacebookException("Can't change HTTP method on request with overridden URL.");
    }

    @Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0007J\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020<0@2\u0006\u0010A\u001a\u00020BH\u0007J'\u0010?\u001a\b\u0012\u0004\u0012\u00020<0@2\u0012\u0010A\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0C\"\u00020>H\u0007¢\u0006\u0002\u0010DJ\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020<0@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020>0EH\u0007J\u0010\u0010F\u001a\u00020G2\u0006\u0010A\u001a\u00020BH\u0007J!\u0010F\u001a\u00020G2\u0012\u0010A\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0C\"\u00020>H\u0007¢\u0006\u0002\u0010HJ\u0016\u0010F\u001a\u00020G2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020>0EH\u0007J\u001e\u0010I\u001a\b\u0012\u0004\u0012\u00020<0@2\u0006\u0010J\u001a\u0002082\u0006\u0010A\u001a\u00020BH\u0007J$\u0010I\u001a\b\u0012\u0004\u0012\u00020<0@2\u0006\u0010J\u001a\u0002082\f\u0010A\u001a\b\u0012\u0004\u0012\u00020>0EH\u0007J\"\u0010K\u001a\u00020G2\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010J\u001a\u0002082\u0006\u0010A\u001a\u00020BH\u0007J\u0018\u0010K\u001a\u00020G2\u0006\u0010J\u001a\u0002082\u0006\u0010A\u001a\u00020BH\u0007J\u0010\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020BH\u0002J\n\u0010P\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010Q\u001a\u00020\u00042\b\u0010R\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010S\u001a\u00020T2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010U\u001a\u00020T2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010V\u001a\u00020T2\u0006\u0010W\u001a\u00020\u0004H\u0002J\u0012\u0010X\u001a\u00020T2\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010Z\u001a\u00020T2\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u0002J$\u0010[\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0007J.\u0010[\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010^\u001a\u00020_2\b\u0010b\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010aH\u0007J&\u0010c\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010d\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010aH\u0007J&\u0010e\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010R\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010aH\u0007J\u001c\u0010f\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010`\u001a\u0004\u0018\u00010gH\u0007J\u001c\u0010h\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010`\u001a\u0004\u0018\u00010iH\u0007J@\u0010j\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010k\u001a\u0004\u0018\u00010l2\u0006\u0010m\u001a\u00020 2\u0006\u0010n\u001a\u00020 2\b\u0010o\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010iH\u0007J0\u0010p\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010R\u001a\u0004\u0018\u00010\u00042\b\u0010q\u001a\u0004\u0018\u00010r2\b\u0010`\u001a\u0004\u0018\u00010aH\u0007J0\u0010s\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010R\u001a\u0004\u0018\u00010\u00042\b\u0010t\u001a\u0004\u0018\u00010u2\b\u0010`\u001a\u0004\u0018\u00010aH\u0007JB\u0010v\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010R\u001a\u0004\u0018\u00010\u00042\u0006\u0010w\u001a\u00020x2\b\u0010y\u001a\u0004\u0018\u00010\u00042\b\u0010z\u001a\u0004\u0018\u00010u2\b\u0010`\u001a\u0004\u0018\u00010aH\u0007JB\u0010v\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010R\u001a\u0004\u0018\u00010\u00042\u0006\u0010{\u001a\u00020|2\b\u0010y\u001a\u0004\u0018\u00010\u00042\b\u0010z\u001a\u0004\u0018\u00010u2\b\u0010`\u001a\u0004\u0018\u00010aH\u0007JB\u0010v\u001a\u00020>2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010R\u001a\u0004\u0018\u00010\u00042\u0006\u0010}\u001a\u00020~2\b\u0010y\u001a\u0004\u0018\u00010\u00042\b\u0010z\u001a\u0004\u0018\u00010u2\b\u0010`\u001a\u0004\u0018\u00010aH\u0007J\u0012\u0010\u001a\u00020\u00042\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u0002J$\u0010\u0001\u001a\u00030\u00012\u0006\u0010q\u001a\u00020r2\u0006\u0010W\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u0001H\u0002J.\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020TH\u0002JB\u0010\u0001\u001a\u00030\u00012\u0006\u0010A\u001a\u00020B2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020 2\u0006\u00109\u001a\u00020:2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020TH\u0002J'\u0010\u0001\u001a\u00030\u00012\u0006\u0010A\u001a\u00020B2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020<0@H\u0001¢\u0006\u0003\b\u0001J+\u0010\u0001\u001a\u00030\u00012\u0015\u0010\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u00010\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J%\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020u2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010=\u001a\u00020>H\u0002J9\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020>0E2\u0015\u0010\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u00010\u0001H\u0002J \u0010\u0001\u001a\u00030\u00012\u0006\u0010A\u001a\u00020B2\u0006\u0010J\u001a\u000208H\u0001¢\u0006\u0003\b\u0001J\u001b\u0010\u0001\u001a\u00030\u00012\u0006\u0010J\u001a\u0002082\u0007\u0010\u0001\u001a\u00020TH\u0002J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0011\u0010\u0001\u001a\u0002082\u0006\u0010A\u001a\u00020BH\u0007J#\u0010\u0001\u001a\u0002082\u0012\u0010A\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0C\"\u00020>H\u0007¢\u0006\u0003\u0010\u0001J\u0017\u0010\u0001\u001a\u0002082\f\u0010A\u001a\b\u0012\u0004\u0012\u00020>0EH\u0007J\u0018\u0010 \u0001\u001a\u00030\u00012\u0006\u0010A\u001a\u00020BH\u0001¢\u0006\u0003\b¡\u0001R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\n **\u0004\u0018\u00010\u00040\u00048\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b+\u0010\u0002R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u00048BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u00102R\u0016\u00105\u001a\n **\u0004\u0018\u00010606X\u0004¢\u0006\u0002\n\u0000¨\u0006¢\u0001"}, d2 = {"Lcom/facebook/GraphRequest$Companion;", "", "()V", "ACCEPT_LANGUAGE_HEADER", "", "ACCESS_TOKEN_PARAM", "ATTACHED_FILES_PARAM", "ATTACHMENT_FILENAME_PREFIX", "BATCH_APP_ID_PARAM", "BATCH_BODY_PARAM", "BATCH_ENTRY_DEPENDS_ON_PARAM", "BATCH_ENTRY_NAME_PARAM", "BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM", "BATCH_METHOD_PARAM", "BATCH_PARAM", "BATCH_RELATIVE_URL_PARAM", "CAPTION_PARAM", "CONTENT_ENCODING_HEADER", "CONTENT_TYPE_HEADER", "DEBUG_KEY", "DEBUG_MESSAGES_KEY", "DEBUG_MESSAGE_KEY", "DEBUG_MESSAGE_LINK_KEY", "DEBUG_MESSAGE_TYPE_KEY", "DEBUG_PARAM", "DEBUG_SEVERITY_INFO", "DEBUG_SEVERITY_WARNING", "FIELDS_PARAM", "FORMAT_JSON", "FORMAT_PARAM", "ISO_8601_FORMAT_STRING", "MAXIMUM_BATCH_SIZE", "", "ME", "MIME_BOUNDARY", "MY_FRIENDS", "MY_PHOTOS", "PICTURE_PARAM", "SDK_ANDROID", "SDK_PARAM", "SEARCH", "TAG", "kotlin.jvm.PlatformType", "getTAG$facebook_core_release$annotations", "USER_AGENT_BASE", "USER_AGENT_HEADER", "VIDEOS_SUFFIX", "defaultBatchApplicationId", "mimeContentType", "getMimeContentType", "()Ljava/lang/String;", "userAgent", "getUserAgent", "versionPattern", "Ljava/util/regex/Pattern;", "createConnection", "Ljava/net/HttpURLConnection;", "url", "Ljava/net/URL;", "executeAndWait", "Lcom/facebook/GraphResponse;", "request", "Lcom/facebook/GraphRequest;", "executeBatchAndWait", "", "requests", "Lcom/facebook/GraphRequestBatch;", "", "([Lcom/facebook/GraphRequest;)Ljava/util/List;", "", "executeBatchAsync", "Lcom/facebook/GraphRequestAsyncTask;", "([Lcom/facebook/GraphRequest;)Lcom/facebook/GraphRequestAsyncTask;", "executeConnectionAndWait", "connection", "executeConnectionAsync", "callbackHandler", "Landroid/os/Handler;", "getBatchAppId", "batch", "getDefaultBatchApplicationId", "getDefaultPhotoPathIfNull", "graphPath", "hasOnProgressCallbacks", "", "isGzipCompressible", "isMeRequest", "path", "isSupportedAttachmentType", "value", "isSupportedParameterType", "newCustomAudienceThirdPartyIdRequest", "accessToken", "Lcom/facebook/AccessToken;", "context", "Landroid/content/Context;", "callback", "Lcom/facebook/GraphRequest$Callback;", "applicationId", "newDeleteObjectRequest", "id", "newGraphPathRequest", "newMeRequest", "Lcom/facebook/GraphRequest$GraphJSONObjectCallback;", "newMyFriendsRequest", "Lcom/facebook/GraphRequest$GraphJSONArrayCallback;", "newPlacesSearchRequest", "location", "Landroid/location/Location;", "radiusInMeters", "resultsLimit", "searchText", "newPostRequest", "graphObject", "Lorg/json/JSONObject;", "newPostRequestWithBundle", "parameters", "Landroid/os/Bundle;", "newUploadPhotoRequest", "image", "Landroid/graphics/Bitmap;", "caption", "params", "photoUri", "Landroid/net/Uri;", "file", "Ljava/io/File;", "parameterToString", "processGraphObject", "", "serializer", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "processGraphObjectProperty", "key", "passByValue", "processRequest", "logger", "Lcom/facebook/internal/Logger;", "numRequests", "outputStream", "Ljava/io/OutputStream;", "shouldUseGzip", "runCallbacks", "responses", "runCallbacks$facebook_core_release", "serializeAttachments", "attachments", "", "Lcom/facebook/GraphRequest$Attachment;", "Lcom/facebook/GraphRequest$Serializer;", "serializeParameters", "bundle", "serializeRequestsAsJSON", "", "serializeToUrlConnection", "serializeToUrlConnection$facebook_core_release", "setConnectionContentType", "setDefaultBatchApplicationId", "toHttpConnection", "([Lcom/facebook/GraphRequest;)Ljava/net/HttpURLConnection;", "validateFieldsParamForGetRequests", "validateFieldsParamForGetRequests$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String getDefaultPhotoPathIfNull(String str) {
            return str == null ? GraphRequest.MY_PHOTOS : str;
        }

        public static /* synthetic */ void getTAG$facebook_core_release$annotations() {
        }

        private Companion() {
        }

        @JvmStatic
        public final String getDefaultBatchApplicationId() {
            return GraphRequest.defaultBatchApplicationId;
        }

        @JvmStatic
        public final void setDefaultBatchApplicationId(String str) {
            GraphRequest.defaultBatchApplicationId = str;
        }

        @JvmStatic
        public final GraphRequest newDeleteObjectRequest(AccessToken accessToken, String str, Callback callback) {
            return new GraphRequest(accessToken, str, (Bundle) null, HttpMethod.DELETE, callback, (String) null, 32, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final GraphRequest newMeRequest(AccessToken accessToken, GraphJSONObjectCallback graphJSONObjectCallback) {
            return new GraphRequest(accessToken, "me", (Bundle) null, (HttpMethod) null, new GraphRequest$Companion$$ExternalSyntheticLambda1(graphJSONObjectCallback), (String) null, 32, (DefaultConstructorMarker) null);
        }

        /* access modifiers changed from: private */
        /* renamed from: newMeRequest$lambda-0  reason: not valid java name */
        public static final void m210newMeRequest$lambda0(GraphJSONObjectCallback graphJSONObjectCallback, GraphResponse graphResponse) {
            Intrinsics.checkNotNullParameter(graphResponse, Response.TYPE);
            if (graphJSONObjectCallback != null) {
                graphJSONObjectCallback.onCompleted(graphResponse.getJSONObject(), graphResponse);
            }
        }

        @JvmStatic
        public final GraphRequest newPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, Callback callback) {
            GraphRequest graphRequest = new GraphRequest(accessToken, str, (Bundle) null, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
            graphRequest.setGraphObject(jSONObject);
            return graphRequest;
        }

        @JvmStatic
        public final GraphRequest newPostRequestWithBundle(AccessToken accessToken, String str, Bundle bundle, Callback callback) {
            return new GraphRequest(accessToken, str, bundle, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final GraphRequest newMyFriendsRequest(AccessToken accessToken, GraphJSONArrayCallback graphJSONArrayCallback) {
            return new GraphRequest(accessToken, GraphRequest.MY_FRIENDS, (Bundle) null, (HttpMethod) null, new GraphRequest$Companion$newMyFriendsRequest$wrapper$1(graphJSONArrayCallback), (String) null, 32, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final GraphRequest newGraphPathRequest(AccessToken accessToken, String str, Callback callback) {
            return new GraphRequest(accessToken, str, (Bundle) null, (HttpMethod) null, callback, (String) null, 32, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final GraphRequest newPlacesSearchRequest(AccessToken accessToken, Location location, int i, int i2, String str, GraphJSONArrayCallback graphJSONArrayCallback) {
            if (location == null) {
                Utility utility = Utility.INSTANCE;
                if (Utility.isNullOrEmpty(str)) {
                    throw new FacebookException("Either location or searchText must be specified.");
                }
            }
            Bundle bundle = new Bundle(5);
            bundle.putString("type", "place");
            bundle.putInt("limit", i2);
            if (location != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.US, "%f,%f", Arrays.copyOf(new Object[]{Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                bundle.putString(TtmlNode.CENTER, format);
                bundle.putInt("distance", i);
            }
            Utility utility2 = Utility.INSTANCE;
            if (!Utility.isNullOrEmpty(str)) {
                bundle.putString("q", str);
            }
            return new GraphRequest(accessToken, "search", bundle, HttpMethod.GET, new GraphRequest$Companion$$ExternalSyntheticLambda2(graphJSONArrayCallback), (String) null, 32, (DefaultConstructorMarker) null);
        }

        /* access modifiers changed from: private */
        /* renamed from: newPlacesSearchRequest$lambda-1  reason: not valid java name */
        public static final void m211newPlacesSearchRequest$lambda1(GraphJSONArrayCallback graphJSONArrayCallback, GraphResponse graphResponse) {
            JSONArray jSONArray;
            Intrinsics.checkNotNullParameter(graphResponse, Response.TYPE);
            if (graphJSONArrayCallback != null) {
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    jSONArray = null;
                } else {
                    jSONArray = jSONObject.optJSONArray("data");
                }
                graphJSONArrayCallback.onCompleted(jSONArray, graphResponse);
            }
        }

        @JvmStatic
        public final GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, Bitmap bitmap, String str2, Bundle bundle, Callback callback) {
            Bitmap bitmap2 = bitmap;
            String str3 = str2;
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bitmap2, "image");
            Bundle bundle3 = new Bundle();
            if (bundle2 != null) {
                bundle3.putAll(bundle2);
            }
            bundle3.putParcelable("picture", bitmap2);
            if (str3 != null) {
                if (str3.length() > 0) {
                    bundle3.putString("caption", str3);
                }
            }
            String str4 = str;
            return new GraphRequest(accessToken, getDefaultPhotoPathIfNull(str), bundle3, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, File file, String str2, Bundle bundle, Callback callback) throws FileNotFoundException {
            Intrinsics.checkNotNullParameter(file, "file");
            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            bundle2.putParcelable("picture", open);
            if (str2 != null) {
                if (str2.length() > 0) {
                    bundle2.putString("caption", str2);
                }
            }
            return new GraphRequest(accessToken, getDefaultPhotoPathIfNull(str), bundle2, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, Uri uri, String str2, Bundle bundle, Callback callback) throws FileNotFoundException, FacebookException {
            Uri uri2 = uri;
            String str3 = str2;
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(uri, "photoUri");
            Utility utility = Utility.INSTANCE;
            if (Utility.isFileUri(uri)) {
                return newUploadPhotoRequest(accessToken, str, new File(uri.getPath()), str2, bundle, callback);
            }
            Utility utility2 = Utility.INSTANCE;
            if (Utility.isContentUri(uri)) {
                Bundle bundle3 = new Bundle();
                if (bundle2 != null) {
                    bundle3.putAll(bundle2);
                }
                bundle3.putParcelable("picture", uri2);
                if (str3 != null) {
                    if (str3.length() > 0) {
                        bundle3.putString("caption", str3);
                    }
                }
                String str4 = str;
                return new GraphRequest(accessToken, getDefaultPhotoPathIfNull(str), bundle3, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
            }
            throw new FacebookException("The photo Uri must be either a file:// or content:// Uri");
        }

        @JvmStatic
        public final GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken, Context context, String str, Callback callback) {
            String str2;
            Intrinsics.checkNotNullParameter(context, "context");
            if (str == null && accessToken != null) {
                str = accessToken.getApplicationId();
            }
            if (str == null) {
                Utility utility = Utility.INSTANCE;
                str = Utility.getMetadataApplicationId(context);
            }
            if (str != null) {
                String stringPlus = Intrinsics.stringPlus(str, "/custom_audience_third_party_id");
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(context);
                Bundle bundle = new Bundle();
                if (accessToken == null) {
                    if (attributionIdentifiers != null) {
                        if (attributionIdentifiers.getAttributionId() != null) {
                            str2 = attributionIdentifiers.getAttributionId();
                        } else {
                            str2 = attributionIdentifiers.getAndroidAdvertiserId();
                        }
                        if (str2 != null) {
                            bundle.putString("udid", str2);
                        }
                    } else {
                        throw new FacebookException("There is no access token and attribution identifiers could not be retrieved");
                    }
                }
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (FacebookSdk.getLimitEventAndDataUsage(context) || (attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited())) {
                    bundle.putString("limit_event_usage", "1");
                }
                return new GraphRequest(accessToken, stringPlus, bundle, HttpMethod.GET, callback, (String) null, 32, (DefaultConstructorMarker) null);
            }
            throw new FacebookException("Facebook App ID cannot be determined");
        }

        @JvmStatic
        public final GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken, Context context, Callback callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            return newCustomAudienceThirdPartyIdRequest(accessToken, context, (String) null, callback);
        }

        @JvmStatic
        public final HttpURLConnection toHttpConnection(GraphRequest... graphRequestArr) {
            Intrinsics.checkNotNullParameter(graphRequestArr, "requests");
            return toHttpConnection((Collection<GraphRequest>) ArraysKt.toList((T[]) graphRequestArr));
        }

        @JvmStatic
        public final HttpURLConnection toHttpConnection(Collection<GraphRequest> collection) {
            Intrinsics.checkNotNullParameter(collection, "requests");
            Validate validate = Validate.INSTANCE;
            Validate.notEmpty(collection, "requests");
            return toHttpConnection(new GraphRequestBatch(collection));
        }

        @JvmStatic
        public final HttpURLConnection toHttpConnection(GraphRequestBatch graphRequestBatch) {
            URL url;
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            validateFieldsParamForGetRequests$facebook_core_release(graphRequestBatch);
            try {
                if (graphRequestBatch.size() == 1) {
                    url = new URL(graphRequestBatch.get(0).getUrlForSingleRequest());
                } else {
                    ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
                    url = new URL(ServerProtocol.getGraphUrlBase());
                }
                HttpURLConnection httpURLConnection = null;
                try {
                    httpURLConnection = createConnection(url);
                    serializeToUrlConnection$facebook_core_release(graphRequestBatch, httpURLConnection);
                    return httpURLConnection;
                } catch (IOException e) {
                    Utility utility = Utility.INSTANCE;
                    Utility.disconnectQuietly(httpURLConnection);
                    throw new FacebookException("could not construct request body", (Throwable) e);
                } catch (JSONException e2) {
                    Utility utility2 = Utility.INSTANCE;
                    Utility.disconnectQuietly(httpURLConnection);
                    throw new FacebookException("could not construct request body", (Throwable) e2);
                }
            } catch (MalformedURLException e3) {
                throw new FacebookException("could not construct URL for request", (Throwable) e3);
            }
        }

        @JvmStatic
        public final GraphResponse executeAndWait(GraphRequest graphRequest) {
            Intrinsics.checkNotNullParameter(graphRequest, "request");
            List<GraphResponse> executeBatchAndWait = executeBatchAndWait(graphRequest);
            if (executeBatchAndWait.size() == 1) {
                return executeBatchAndWait.get(0);
            }
            throw new FacebookException("invalid state: expected a single response");
        }

        @JvmStatic
        public final List<GraphResponse> executeBatchAndWait(GraphRequest... graphRequestArr) {
            Intrinsics.checkNotNullParameter(graphRequestArr, "requests");
            return executeBatchAndWait((Collection<GraphRequest>) ArraysKt.toList((T[]) graphRequestArr));
        }

        @JvmStatic
        public final List<GraphResponse> executeBatchAndWait(Collection<GraphRequest> collection) {
            Intrinsics.checkNotNullParameter(collection, "requests");
            return executeBatchAndWait(new GraphRequestBatch(collection));
        }

        @JvmStatic
        public final List<GraphResponse> executeBatchAndWait(GraphRequestBatch graphRequestBatch) {
            Exception exc;
            HttpURLConnection httpURLConnection;
            List<GraphResponse> list;
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            Validate validate = Validate.INSTANCE;
            Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
            HttpURLConnection httpURLConnection2 = null;
            try {
                httpURLConnection = toHttpConnection(graphRequestBatch);
                exc = null;
            } catch (Exception e) {
                HttpURLConnection httpURLConnection3 = null;
                exc = e;
                httpURLConnection = null;
            } catch (Throwable th) {
                th = th;
                Utility utility = Utility.INSTANCE;
                Utility.disconnectQuietly(httpURLConnection2);
                throw th;
            }
            if (httpURLConnection != null) {
                try {
                    list = executeConnectionAndWait(httpURLConnection, graphRequestBatch);
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    Utility utility2 = Utility.INSTANCE;
                    Utility.disconnectQuietly(httpURLConnection2);
                    throw th;
                }
            } else {
                List<GraphResponse> constructErrorResponses = GraphResponse.Companion.constructErrorResponses(graphRequestBatch.getRequests(), (HttpURLConnection) null, new FacebookException((Throwable) exc));
                runCallbacks$facebook_core_release(graphRequestBatch, constructErrorResponses);
                list = constructErrorResponses;
            }
            Utility utility3 = Utility.INSTANCE;
            Utility.disconnectQuietly(httpURLConnection);
            return list;
        }

        @JvmStatic
        public final GraphRequestAsyncTask executeBatchAsync(GraphRequest... graphRequestArr) {
            Intrinsics.checkNotNullParameter(graphRequestArr, "requests");
            return executeBatchAsync((Collection<GraphRequest>) ArraysKt.toList((T[]) graphRequestArr));
        }

        @JvmStatic
        public final GraphRequestAsyncTask executeBatchAsync(Collection<GraphRequest> collection) {
            Intrinsics.checkNotNullParameter(collection, "requests");
            return executeBatchAsync(new GraphRequestBatch(collection));
        }

        @JvmStatic
        public final GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch graphRequestBatch) {
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            Validate validate = Validate.INSTANCE;
            Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
            GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(graphRequestBatch);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
            return graphRequestAsyncTask;
        }

        @JvmStatic
        public final List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, Collection<GraphRequest> collection) {
            Intrinsics.checkNotNullParameter(httpURLConnection, "connection");
            Intrinsics.checkNotNullParameter(collection, "requests");
            return executeConnectionAndWait(httpURLConnection, new GraphRequestBatch(collection));
        }

        @JvmStatic
        public final List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
            Intrinsics.checkNotNullParameter(httpURLConnection, "connection");
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            List<GraphResponse> fromHttpConnection$facebook_core_release = GraphResponse.Companion.fromHttpConnection$facebook_core_release(httpURLConnection, graphRequestBatch);
            Utility utility = Utility.INSTANCE;
            Utility.disconnectQuietly(httpURLConnection);
            int size = graphRequestBatch.size();
            if (size == fromHttpConnection$facebook_core_release.size()) {
                runCallbacks$facebook_core_release(graphRequestBatch, fromHttpConnection$facebook_core_release);
                AccessTokenManager.Companion.getInstance().extendAccessTokenIfNeeded();
                return fromHttpConnection$facebook_core_release;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "Received %d responses while expecting %d", Arrays.copyOf(new Object[]{Integer.valueOf(fromHttpConnection$facebook_core_release.size()), Integer.valueOf(size)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            throw new FacebookException(format);
        }

        @JvmStatic
        public final GraphRequestAsyncTask executeConnectionAsync(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
            Intrinsics.checkNotNullParameter(httpURLConnection, "connection");
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            return executeConnectionAsync((Handler) null, httpURLConnection, graphRequestBatch);
        }

        @JvmStatic
        public final GraphRequestAsyncTask executeConnectionAsync(Handler handler, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
            Intrinsics.checkNotNullParameter(httpURLConnection, "connection");
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(httpURLConnection, graphRequestBatch);
            graphRequestBatch.setCallbackHandler(handler);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
            return graphRequestAsyncTask;
        }

        @JvmStatic
        public final void runCallbacks$facebook_core_release(GraphRequestBatch graphRequestBatch, List<GraphResponse> list) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            Intrinsics.checkNotNullParameter(list, "responses");
            int size = graphRequestBatch.size();
            ArrayList arrayList = new ArrayList();
            if (size > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    GraphRequest graphRequest = graphRequestBatch.get(i);
                    if (graphRequest.getCallback() != null) {
                        arrayList.add(new Pair(graphRequest.getCallback(), list.get(i)));
                    }
                    if (i2 >= size) {
                        break;
                    }
                    i = i2;
                }
            }
            if (arrayList.size() > 0) {
                GraphRequest$Companion$$ExternalSyntheticLambda0 graphRequest$Companion$$ExternalSyntheticLambda0 = new GraphRequest$Companion$$ExternalSyntheticLambda0(arrayList, graphRequestBatch);
                Handler callbackHandler = graphRequestBatch.getCallbackHandler();
                if (callbackHandler == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(callbackHandler.post(graphRequest$Companion$$ExternalSyntheticLambda0));
                }
                if (bool == null) {
                    graphRequest$Companion$$ExternalSyntheticLambda0.run();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: runCallbacks$lambda-2  reason: not valid java name */
        public static final void m212runCallbacks$lambda2(ArrayList arrayList, GraphRequestBatch graphRequestBatch) {
            Intrinsics.checkNotNullParameter(arrayList, "$callbacks");
            Intrinsics.checkNotNullParameter(graphRequestBatch, "$requests");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                Object obj = pair.second;
                Intrinsics.checkNotNullExpressionValue(obj, "pair.second");
                ((Callback) pair.first).onCompleted((GraphResponse) obj);
            }
            for (GraphRequestBatch.Callback onBatchCompleted : graphRequestBatch.getCallbacks()) {
                onBatchCompleted.onBatchCompleted(graphRequestBatch);
            }
        }

        private final HttpURLConnection createConnection(URL url) throws IOException {
            URLConnection openConnection = url.openConnection();
            if (openConnection != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
                httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
                httpURLConnection.setChunkedStreamingMode(0);
                return httpURLConnection;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        }

        private final boolean hasOnProgressCallbacks(GraphRequestBatch graphRequestBatch) {
            for (GraphRequestBatch.Callback callback : graphRequestBatch.getCallbacks()) {
                if (callback instanceof GraphRequestBatch.OnProgressCallback) {
                    return true;
                }
            }
            Iterator it = graphRequestBatch.iterator();
            while (it.hasNext()) {
                if (((GraphRequest) it.next()).getCallback() instanceof OnProgressCallback) {
                    return true;
                }
            }
            return false;
        }

        private final void setConnectionContentType(HttpURLConnection httpURLConnection, boolean z) {
            if (z) {
                httpURLConnection.setRequestProperty("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                return;
            }
            httpURLConnection.setRequestProperty("Content-Type", getMimeContentType());
        }

        private final boolean isGzipCompressible(GraphRequestBatch graphRequestBatch) {
            Iterator it = graphRequestBatch.iterator();
            while (it.hasNext()) {
                GraphRequest graphRequest = (GraphRequest) it.next();
                Iterator it2 = graphRequest.getParameters().keySet().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (isSupportedAttachmentType(graphRequest.getParameters().get((String) it2.next()))) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        @JvmStatic
        public final void validateFieldsParamForGetRequests$facebook_core_release(GraphRequestBatch graphRequestBatch) {
            Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
            Iterator it = graphRequestBatch.iterator();
            while (it.hasNext()) {
                GraphRequest graphRequest = (GraphRequest) it.next();
                if (HttpMethod.GET == graphRequest.getHttpMethod()) {
                    Utility utility = Utility.INSTANCE;
                    if (Utility.isNullOrEmpty(graphRequest.getParameters().getString(GraphRequest.FIELDS_PARAM))) {
                        Logger.Companion companion = Logger.Companion;
                        LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
                        StringBuilder append = new StringBuilder().append("GET requests for /");
                        String graphPath = graphRequest.getGraphPath();
                        if (graphPath == null) {
                            graphPath = "";
                        }
                        companion.log(loggingBehavior, 5, "Request", append.append(graphPath).append(" should contain an explicit \"fields\" parameter.").toString());
                    }
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x00fa  */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void serializeToUrlConnection$facebook_core_release(com.facebook.GraphRequestBatch r14, java.net.HttpURLConnection r15) throws java.io.IOException, org.json.JSONException {
            /*
                r13 = this;
                java.lang.String r0 = "requests"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
                java.lang.String r0 = "connection"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
                com.facebook.internal.Logger r0 = new com.facebook.internal.Logger
                com.facebook.LoggingBehavior r1 = com.facebook.LoggingBehavior.REQUESTS
                java.lang.String r2 = "Request"
                r0.<init>(r1, r2)
                int r10 = r14.size()
                boolean r11 = r13.isGzipCompressible(r14)
                r1 = 0
                r2 = 0
                r3 = 1
                if (r10 != r3) goto L_0x0029
                com.facebook.GraphRequest r4 = r14.get((int) r1)
                com.facebook.HttpMethod r4 = r4.getHttpMethod()
                goto L_0x002a
            L_0x0029:
                r4 = r2
            L_0x002a:
                if (r4 != 0) goto L_0x002e
                com.facebook.HttpMethod r4 = com.facebook.HttpMethod.POST
            L_0x002e:
                java.lang.String r5 = r4.name()
                r15.setRequestMethod(r5)
                r13.setConnectionContentType(r15, r11)
                java.net.URL r12 = r15.getURL()
                java.lang.String r5 = "Request:\n"
                r0.append((java.lang.String) r5)
                java.lang.String r5 = r14.getId()
                java.lang.String r6 = "Id"
                r0.appendKeyValue(r6, r5)
                java.lang.String r5 = "url"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r5)
                java.lang.String r5 = "URL"
                r0.appendKeyValue(r5, r12)
                java.lang.String r5 = r15.getRequestMethod()
                java.lang.String r6 = "connection.requestMethod"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
                java.lang.String r6 = "Method"
                r0.appendKeyValue(r6, r5)
                java.lang.String r5 = "User-Agent"
                java.lang.String r6 = r15.getRequestProperty(r5)
                java.lang.String r7 = "connection.getRequestProperty(\"User-Agent\")"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
                r0.appendKeyValue(r5, r6)
                java.lang.String r5 = "Content-Type"
                java.lang.String r6 = r15.getRequestProperty(r5)
                java.lang.String r7 = "connection.getRequestProperty(\"Content-Type\")"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
                r0.appendKeyValue(r5, r6)
                int r5 = r14.getTimeout()
                r15.setConnectTimeout(r5)
                int r5 = r14.getTimeout()
                r15.setReadTimeout(r5)
                com.facebook.HttpMethod r5 = com.facebook.HttpMethod.POST
                if (r4 != r5) goto L_0x0091
                r1 = r3
            L_0x0091:
                if (r1 != 0) goto L_0x0097
                r0.log()
                return
            L_0x0097:
                r15.setDoOutput(r3)
                java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00f6 }
                java.io.OutputStream r15 = r15.getOutputStream()     // Catch:{ all -> 0x00f6 }
                r1.<init>(r15)     // Catch:{ all -> 0x00f6 }
                java.io.OutputStream r1 = (java.io.OutputStream) r1     // Catch:{ all -> 0x00f6 }
                if (r11 == 0) goto L_0x00b2
                java.util.zip.GZIPOutputStream r15 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x00af }
                r15.<init>(r1)     // Catch:{ all -> 0x00af }
                java.io.OutputStream r15 = (java.io.OutputStream) r15     // Catch:{ all -> 0x00af }
                goto L_0x00b3
            L_0x00af:
                r14 = move-exception
                r2 = r1
                goto L_0x00f7
            L_0x00b2:
                r15 = r1
            L_0x00b3:
                boolean r1 = r13.hasOnProgressCallbacks(r14)     // Catch:{ all -> 0x00f3 }
                if (r1 == 0) goto L_0x00e2
                com.facebook.ProgressNoopOutputStream r1 = new com.facebook.ProgressNoopOutputStream     // Catch:{ all -> 0x00f3 }
                android.os.Handler r2 = r14.getCallbackHandler()     // Catch:{ all -> 0x00f3 }
                r1.<init>(r2)     // Catch:{ all -> 0x00f3 }
                r5 = 0
                r8 = r1
                java.io.OutputStream r8 = (java.io.OutputStream) r8     // Catch:{ all -> 0x00f3 }
                r3 = r13
                r4 = r14
                r6 = r10
                r7 = r12
                r9 = r11
                r3.processRequest(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00f3 }
                int r2 = r1.getMaxProgress()     // Catch:{ all -> 0x00f3 }
                java.util.Map r5 = r1.getProgressMap()     // Catch:{ all -> 0x00f3 }
                com.facebook.ProgressOutputStream r1 = new com.facebook.ProgressOutputStream     // Catch:{ all -> 0x00f3 }
                long r6 = (long) r2     // Catch:{ all -> 0x00f3 }
                r2 = r1
                r3 = r15
                r4 = r14
                r2.<init>(r3, r4, r5, r6)     // Catch:{ all -> 0x00f3 }
                java.io.OutputStream r1 = (java.io.OutputStream) r1     // Catch:{ all -> 0x00f3 }
                r15 = r1
            L_0x00e2:
                r1 = r13
                r2 = r14
                r3 = r0
                r4 = r10
                r5 = r12
                r6 = r15
                r7 = r11
                r1.processRequest(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00f3 }
                r15.close()
                r0.log()
                return
            L_0x00f3:
                r14 = move-exception
                r2 = r15
                goto L_0x00f7
            L_0x00f6:
                r14 = move-exception
            L_0x00f7:
                if (r2 != 0) goto L_0x00fa
                goto L_0x00fd
            L_0x00fa:
                r2.close()
            L_0x00fd:
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.Companion.serializeToUrlConnection$facebook_core_release(com.facebook.GraphRequestBatch, java.net.HttpURLConnection):void");
        }

        private final void processRequest(GraphRequestBatch graphRequestBatch, Logger logger, int i, URL url, OutputStream outputStream, boolean z) {
            Serializer serializer = new Serializer(outputStream, logger, z);
            boolean z2 = false;
            if (i == 1) {
                GraphRequest graphRequest = graphRequestBatch.get(0);
                Map hashMap = new HashMap();
                for (String str : graphRequest.getParameters().keySet()) {
                    Object obj = graphRequest.getParameters().get(str);
                    if (isSupportedAttachmentType(obj)) {
                        Intrinsics.checkNotNullExpressionValue(str, "key");
                        hashMap.put(str, new Attachment(graphRequest, obj));
                    }
                }
                if (logger != null) {
                    logger.append("  Parameters:\n");
                }
                serializeParameters(graphRequest.getParameters(), serializer, graphRequest);
                if (logger != null) {
                    logger.append("  Attachments:\n");
                }
                serializeAttachments(hashMap, serializer);
                JSONObject graphObject = graphRequest.getGraphObject();
                if (graphObject != null) {
                    String path = url.getPath();
                    Intrinsics.checkNotNullExpressionValue(path, "url.path");
                    processGraphObject(graphObject, path, serializer);
                    return;
                }
                return;
            }
            String batchAppId = getBatchAppId(graphRequestBatch);
            if (batchAppId.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                serializer.writeString(GraphRequest.BATCH_APP_ID_PARAM, batchAppId);
                Map hashMap2 = new HashMap();
                serializeRequestsAsJSON(serializer, graphRequestBatch, hashMap2);
                if (logger != null) {
                    logger.append("  Attachments:\n");
                }
                serializeAttachments(hashMap2, serializer);
                return;
            }
            throw new FacebookException("App ID was not specified at the request or Settings.");
        }

        private final boolean isMeRequest(String str) {
            Matcher matcher = GraphRequest.versionPattern.matcher(str);
            if (matcher.matches()) {
                str = matcher.group(1);
                Intrinsics.checkNotNullExpressionValue(str, "matcher.group(1)");
            }
            if (StringsKt.startsWith$default(str, "me/", false, 2, (Object) null) || StringsKt.startsWith$default(str, "/me/", false, 2, (Object) null)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void processGraphObject(org.json.JSONObject r10, java.lang.String r11, com.facebook.GraphRequest.KeyValueSerializer r12) {
            /*
                r9 = this;
                boolean r0 = r9.isMeRequest(r11)
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x0025
                java.lang.CharSequence r11 = (java.lang.CharSequence) r11
                r5 = 0
                r6 = 0
                r7 = 6
                r8 = 0
                java.lang.String r4 = ":"
                r3 = r11
                int r0 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r3, (java.lang.String) r4, (int) r5, (boolean) r6, (int) r7, (java.lang.Object) r8)
                java.lang.String r4 = "?"
                int r11 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r3, (java.lang.String) r4, (int) r5, (boolean) r6, (int) r7, (java.lang.Object) r8)
                r3 = 3
                if (r0 <= r3) goto L_0x0025
                r3 = -1
                if (r11 == r3) goto L_0x0023
                if (r0 >= r11) goto L_0x0025
            L_0x0023:
                r11 = r1
                goto L_0x0026
            L_0x0025:
                r11 = r2
            L_0x0026:
                java.util.Iterator r0 = r10.keys()
            L_0x002a:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L_0x0055
                java.lang.Object r3 = r0.next()
                java.lang.String r3 = (java.lang.String) r3
                java.lang.Object r4 = r10.opt(r3)
                if (r11 == 0) goto L_0x0046
                java.lang.String r5 = "image"
                boolean r5 = kotlin.text.StringsKt.equals(r3, r5, r1)
                if (r5 == 0) goto L_0x0046
                r5 = r1
                goto L_0x0047
            L_0x0046:
                r5 = r2
            L_0x0047:
                java.lang.String r6 = "key"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
                java.lang.String r6 = "value"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
                r9.processGraphObjectProperty(r3, r4, r12, r5)
                goto L_0x002a
            L_0x0055:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.Companion.processGraphObject(org.json.JSONObject, java.lang.String, com.facebook.GraphRequest$KeyValueSerializer):void");
        }

        private final void processGraphObjectProperty(String str, Object obj, KeyValueSerializer keyValueSerializer, boolean z) {
            Class<?> cls = obj.getClass();
            if (JSONObject.class.isAssignableFrom(cls)) {
                JSONObject jSONObject = (JSONObject) obj;
                if (z) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("%s[%s]", Arrays.copyOf(new Object[]{str, next}, 2));
                        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                        Object opt = jSONObject.opt(next);
                        Intrinsics.checkNotNullExpressionValue(opt, "jsonObject.opt(propertyName)");
                        processGraphObjectProperty(format, opt, keyValueSerializer, z);
                    }
                } else if (jSONObject.has("id")) {
                    String optString = jSONObject.optString("id");
                    Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"id\")");
                    processGraphObjectProperty(str, optString, keyValueSerializer, z);
                } else if (jSONObject.has("url")) {
                    String optString2 = jSONObject.optString("url");
                    Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"url\")");
                    processGraphObjectProperty(str, optString2, keyValueSerializer, z);
                } else if (jSONObject.has(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY)) {
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
                    processGraphObjectProperty(str, jSONObject2, keyValueSerializer, z);
                }
            } else if (JSONArray.class.isAssignableFrom(cls)) {
                JSONArray jSONArray = (JSONArray) obj;
                int length = jSONArray.length();
                if (length > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        String format2 = String.format(Locale.ROOT, "%s[%d]", Arrays.copyOf(new Object[]{str, Integer.valueOf(i)}, 2));
                        Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, format, *args)");
                        Object opt2 = jSONArray.opt(i);
                        Intrinsics.checkNotNullExpressionValue(opt2, "jsonArray.opt(i)");
                        processGraphObjectProperty(format2, opt2, keyValueSerializer, z);
                        if (i2 < length) {
                            i = i2;
                        } else {
                            return;
                        }
                    }
                }
            } else if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
                keyValueSerializer.writeString(str, obj.toString());
            } else if (Date.class.isAssignableFrom(cls)) {
                String format3 = new SimpleDateFormat(GraphRequest.ISO_8601_FORMAT_STRING, Locale.US).format((Date) obj);
                Intrinsics.checkNotNullExpressionValue(format3, "iso8601DateFormat.format(date)");
                keyValueSerializer.writeString(str, format3);
            } else {
                Utility utility = Utility.INSTANCE;
                Utility.logd(GraphRequest.TAG, "The type of property " + str + " in the graph object is unknown. It won't be sent in the request.");
            }
        }

        private final void serializeParameters(Bundle bundle, Serializer serializer, GraphRequest graphRequest) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (isSupportedParameterType(obj)) {
                    Intrinsics.checkNotNullExpressionValue(str, "key");
                    serializer.writeObject(str, obj, graphRequest);
                }
            }
        }

        private final void serializeRequestsAsJSON(Serializer serializer, Collection<GraphRequest> collection, Map<String, Attachment> map) {
            JSONArray jSONArray = new JSONArray();
            for (GraphRequest access$serializeToBatch : collection) {
                access$serializeToBatch.serializeToBatch(jSONArray, map);
            }
            serializer.writeRequestsAsJson(GraphRequest.BATCH_PARAM, jSONArray, collection);
        }

        private final String getMimeContentType() {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("multipart/form-data; boundary=%s", Arrays.copyOf(new Object[]{GraphRequest.MIME_BOUNDARY}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            return format;
        }

        private final String getUserAgent() {
            if (GraphRequest.userAgent == null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%s.%s", Arrays.copyOf(new Object[]{GraphRequest.USER_AGENT_BASE, FacebookSdkVersion.BUILD}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                GraphRequest.userAgent = format;
                InternalSettings internalSettings = InternalSettings.INSTANCE;
                String customUserAgent = InternalSettings.getCustomUserAgent();
                Utility utility = Utility.INSTANCE;
                if (!Utility.isNullOrEmpty(customUserAgent)) {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String format2 = String.format(Locale.ROOT, "%s/%s", Arrays.copyOf(new Object[]{GraphRequest.userAgent, customUserAgent}, 2));
                    Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, format, *args)");
                    GraphRequest.userAgent = format2;
                }
            }
            return GraphRequest.userAgent;
        }

        private final String getBatchAppId(GraphRequestBatch graphRequestBatch) {
            String batchApplicationId = graphRequestBatch.getBatchApplicationId();
            boolean z = true;
            if (batchApplicationId != null && (!graphRequestBatch.isEmpty())) {
                return batchApplicationId;
            }
            Iterator it = graphRequestBatch.iterator();
            while (it.hasNext()) {
                AccessToken accessToken = ((GraphRequest) it.next()).getAccessToken();
                if (accessToken != null) {
                    return accessToken.getApplicationId();
                }
            }
            String access$getDefaultBatchApplicationId$cp = GraphRequest.defaultBatchApplicationId;
            if (access$getDefaultBatchApplicationId$cp != null) {
                if (access$getDefaultBatchApplicationId$cp.length() <= 0) {
                    z = false;
                }
                if (z) {
                    return access$getDefaultBatchApplicationId$cp;
                }
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            return FacebookSdk.getApplicationId();
        }

        /* access modifiers changed from: private */
        public final boolean isSupportedAttachmentType(Object obj) {
            return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType);
        }

        /* access modifiers changed from: private */
        public final boolean isSupportedParameterType(Object obj) {
            return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
        }

        /* access modifiers changed from: private */
        public final String parameterToString(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if ((obj instanceof Boolean) || (obj instanceof Number)) {
                return obj.toString();
            }
            if (obj instanceof Date) {
                String format = new SimpleDateFormat(GraphRequest.ISO_8601_FORMAT_STRING, Locale.US).format((Date) obj);
                Intrinsics.checkNotNullExpressionValue(format, "iso8601DateFormat.format(value)");
                return format;
            }
            throw new IllegalArgumentException("Unsupported parameter type.");
        }

        private final void serializeAttachments(Map<String, Attachment> map, Serializer serializer) {
            for (Map.Entry next : map.entrySet()) {
                if (GraphRequest.Companion.isSupportedAttachmentType(((Attachment) next.getValue()).getValue())) {
                    serializer.writeObject((String) next.getKey(), ((Attachment) next.getValue()).getValue(), ((Attachment) next.getValue()).getRequest());
                }
            }
        }
    }

    static {
        char[] charArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "(this as java.lang.String).toCharArray()");
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt(11) + 30;
        if (nextInt > 0) {
            int i = 0;
            do {
                i++;
                sb.append(charArray[secureRandom.nextInt(charArray.length)]);
            } while (i < nextInt);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "buffer.toString()");
        MIME_BOUNDARY = sb2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GraphRequest(com.facebook.AccessToken r6, java.lang.String r7, android.os.Bundle r8, com.facebook.HttpMethod r9, com.facebook.GraphRequest.Callback r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.<init>(com.facebook.AccessToken, java.lang.String, android.os.Bundle, com.facebook.HttpMethod, com.facebook.GraphRequest$Callback, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public GraphRequest(AccessToken accessToken2, String str, Bundle bundle, HttpMethod httpMethod2, Callback callback2, String str2) {
        this.batchEntryOmitResultOnSuccess = true;
        this.accessToken = accessToken2;
        this.graphPath = str;
        this.version = str2;
        setCallback(callback2);
        setHttpMethod(httpMethod2);
        if (bundle != null) {
            this.parameters = new Bundle(bundle);
        } else {
            this.parameters = new Bundle();
        }
        if (this.version == null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            this.version = FacebookSdk.getGraphApiVersion();
        }
    }

    public GraphRequest(AccessToken accessToken2, URL url) {
        Intrinsics.checkNotNullParameter(url, "overriddenURL");
        this.batchEntryOmitResultOnSuccess = true;
        this.accessToken = accessToken2;
        this.overriddenURL = url.toString();
        setHttpMethod(HttpMethod.GET);
        this.parameters = new Bundle();
    }

    public final void setForceApplicationRequest(boolean z) {
        this.forceApplicationRequest = z;
    }

    public final GraphResponse executeAndWait() {
        return Companion.executeAndWait(this);
    }

    public final GraphRequestAsyncTask executeAsync() {
        return Companion.executeBatchAsync(this);
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("{Request: ").append(" accessToken: ");
        Object obj = this.accessToken;
        if (obj == null) {
            obj = "null";
        }
        String sb = append.append(obj).append(", graphPath: ").append(this.graphPath).append(", graphObject: ").append(this.graphObject).append(", httpMethod: ").append(this.httpMethod).append(", parameters: ").append(this.parameters).append("}").toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder()\n        .append(\"{Request: \")\n        .append(\" accessToken: \")\n        .append(if (accessToken == null) \"null\" else accessToken)\n        .append(\", graphPath: \")\n        .append(graphPath)\n        .append(\", graphObject: \")\n        .append(graphObject)\n        .append(\", httpMethod: \")\n        .append(httpMethod)\n        .append(\", parameters: \")\n        .append(parameters)\n        .append(\"}\")\n        .toString()");
        return sb;
    }

    private final void addCommonParameters() {
        Bundle bundle = this.parameters;
        if (shouldForceClientTokenForRequest()) {
            bundle.putString("access_token", getClientTokenForRequest());
        } else {
            String accessTokenToUseForRequest = getAccessTokenToUseForRequest();
            if (accessTokenToUseForRequest != null) {
                bundle.putString("access_token", accessTokenToUseForRequest);
            }
        }
        if (!bundle.containsKey("access_token")) {
            Utility utility = Utility.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (Utility.isNullOrEmpty(FacebookSdk.getClientToken())) {
                Log.w(TAG, "Starting with v13 of the SDK, a client token must be embedded in your client code before making Graph API calls. Visit https://developers.facebook.com/docs/android/getting-started#client-token to learn how to implement this change.");
            }
        }
        bundle.putString("sdk", "android");
        bundle.putString(FORMAT_PARAM, FORMAT_JSON);
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            bundle.putString("debug", "info");
            return;
        }
        FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            bundle.putString("debug", DEBUG_SEVERITY_WARNING);
        }
    }

    private final String getAccessTokenToUseForRequest() {
        AccessToken accessToken2 = this.accessToken;
        if (accessToken2 != null) {
            if (!this.parameters.containsKey("access_token")) {
                String token = accessToken2.getToken();
                Logger.Companion.registerAccessToken(token);
                return token;
            }
        } else if (!this.parameters.containsKey("access_token")) {
            return getClientTokenForRequest();
        }
        return this.parameters.getString("access_token");
    }

    private final String getClientTokenForRequest() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        String clientToken = FacebookSdk.getClientToken();
        boolean z = true;
        if (applicationId.length() > 0) {
            if (clientToken.length() <= 0) {
                z = false;
            }
            if (z) {
                return applicationId + '|' + clientToken;
            }
        }
        Utility utility = Utility.INSTANCE;
        Utility.logd(TAG, "Warning: Request without access token missing application ID or client token.");
        return null;
    }

    private final String appendParametersToBaseUrl(String str, boolean z) {
        if (!z && this.httpMethod == HttpMethod.POST) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (String str2 : this.parameters.keySet()) {
            Object obj = this.parameters.get(str2);
            if (obj == null) {
                obj = "";
            }
            Companion companion = Companion;
            if (companion.isSupportedParameterType(obj)) {
                buildUpon.appendQueryParameter(str2, companion.parameterToString(obj).toString());
            } else if (this.httpMethod != HttpMethod.GET) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.US, "Unsupported parameter type for GET request: %s", Arrays.copyOf(new Object[]{obj.getClass().getSimpleName()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                throw new IllegalArgumentException(format);
            }
        }
        String builder = buildUpon.toString();
        Intrinsics.checkNotNullExpressionValue(builder, "uriBuilder.toString()");
        return builder;
    }

    public final String getRelativeUrlForBatchedRequest() {
        if (this.overriddenURL == null) {
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            String urlWithGraphPath = getUrlWithGraphPath(ServerProtocol.getGraphUrlBase());
            addCommonParameters();
            Uri parse = Uri.parse(appendParametersToBaseUrl(urlWithGraphPath, true));
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s?%s", Arrays.copyOf(new Object[]{parse.getPath(), parse.getQuery()}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            return format;
        }
        throw new FacebookException("Can't override URL for a batch request");
    }

    public final String getUrlForSingleRequest() {
        String str;
        String str2 = this.overriddenURL;
        if (str2 != null) {
            return String.valueOf(str2);
        }
        String str3 = this.graphPath;
        if (this.httpMethod != HttpMethod.POST || str3 == null || !StringsKt.endsWith$default(str3, VIDEOS_SUFFIX, false, 2, (Object) null)) {
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = ServerProtocol.getGraphUrlBaseForSubdomain(FacebookSdk.getGraphDomain());
        } else {
            ServerProtocol serverProtocol2 = ServerProtocol.INSTANCE;
            str = ServerProtocol.getGraphVideoUrlBase();
        }
        String urlWithGraphPath = getUrlWithGraphPath(str);
        addCommonParameters();
        return appendParametersToBaseUrl(urlWithGraphPath, false);
    }

    private final String getGraphPathWithVersion() {
        if (versionPattern.matcher(this.graphPath).matches()) {
            return this.graphPath;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s/%s", Arrays.copyOf(new Object[]{this.version, this.graphPath}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    private final String getUrlWithGraphPath(String str) {
        if (!isValidGraphRequestForDomain()) {
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            str = ServerProtocol.getFacebookGraphUrlBase();
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s/%s", Arrays.copyOf(new Object[]{str, getGraphPathWithVersion()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    private final boolean shouldForceClientTokenForRequest() {
        boolean z;
        String accessTokenToUseForRequest = getAccessTokenToUseForRequest();
        if (accessTokenToUseForRequest == null) {
            z = false;
        } else {
            z = StringsKt.contains$default((CharSequence) accessTokenToUseForRequest, (CharSequence) "|", false, 2, (Object) null);
        }
        if ((accessTokenToUseForRequest != null && StringsKt.startsWith$default(accessTokenToUseForRequest, "IG", false, 2, (Object) null) && !z) && isApplicationRequest()) {
            return true;
        }
        if (isValidGraphRequestForDomain() || z) {
            return false;
        }
        return true;
    }

    private final boolean isValidGraphRequestForDomain() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (!Intrinsics.areEqual((Object) FacebookSdk.getGraphDomain(), (Object) FacebookSdk.INSTAGRAM_COM)) {
            return true;
        }
        return !isApplicationRequest();
    }

    private final boolean isApplicationRequest() {
        if (this.graphPath == null) {
            return false;
        }
        StringBuilder append = new StringBuilder().append("^/?");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String sb = append.append(FacebookSdk.getApplicationId()).append("/?.*").toString();
        if (this.forceApplicationRequest || Pattern.matches(sb, this.graphPath) || Pattern.matches("^/?app/?.*", this.graphPath)) {
            return true;
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/facebook/GraphRequest$Attachment;", "", "request", "Lcom/facebook/GraphRequest;", "value", "(Lcom/facebook/GraphRequest;Ljava/lang/Object;)V", "getRequest", "()Lcom/facebook/GraphRequest;", "getValue", "()Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequest.kt */
    private static final class Attachment {
        private final GraphRequest request;
        private final Object value;

        public Attachment(GraphRequest graphRequest, Object obj) {
            Intrinsics.checkNotNullParameter(graphRequest, "request");
            this.request = graphRequest;
            this.value = obj;
        }

        public final GraphRequest getRequest() {
            return this.request;
        }

        public final Object getValue() {
            return this.value;
        }
    }

    /* access modifiers changed from: private */
    public final void serializeToBatch(JSONArray jSONArray, Map<String, Attachment> map) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        String str = this.batchEntryName;
        if (str != null) {
            jSONObject.put("name", (Object) str);
            jSONObject.put(BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM, this.batchEntryOmitResultOnSuccess);
        }
        String str2 = this.batchEntryDependsOn;
        if (str2 != null) {
            jSONObject.put(BATCH_ENTRY_DEPENDS_ON_PARAM, (Object) str2);
        }
        String relativeUrlForBatchedRequest = getRelativeUrlForBatchedRequest();
        jSONObject.put(BATCH_RELATIVE_URL_PARAM, (Object) relativeUrlForBatchedRequest);
        jSONObject.put("method", (Object) this.httpMethod);
        AccessToken accessToken2 = this.accessToken;
        if (accessToken2 != null) {
            Logger.Companion.registerAccessToken(accessToken2.getToken());
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : this.parameters.keySet()) {
            Object obj = this.parameters.get(str3);
            if (Companion.isSupportedAttachmentType(obj)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.ROOT, "%s%d", Arrays.copyOf(new Object[]{"file", Integer.valueOf(map.size())}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                arrayList.add(format);
                map.put(format, new Attachment(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put(ATTACHED_FILES_PARAM, (Object) TextUtils.join(",", arrayList));
        }
        JSONObject jSONObject2 = this.graphObject;
        if (jSONObject2 != null) {
            ArrayList arrayList2 = new ArrayList();
            Companion.processGraphObject(jSONObject2, relativeUrlForBatchedRequest, new GraphRequest$serializeToBatch$1(arrayList2));
            jSONObject.put("body", (Object) TextUtils.join("&", arrayList2));
        }
        jSONArray.put((Object) jSONObject);
    }

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150\u0014\"\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dJ$\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u00122\b\u0010 \u001a\u0004\u0018\u00010\u00122\b\u0010!\u001a\u0004\u0018\u00010\u0012J \u0010\"\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0012J \u0010&\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010\u0012J+\u0010)\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150\u0014\"\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\"\u0010*\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010\u00152\b\u0010,\u001a\u0004\u0018\u00010-J\u0006\u0010.\u001a\u00020\u0010J$\u0010/\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020-03J\u0018\u00104\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0012H\u0016R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\u00060\u000bj\u0002`\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/facebook/GraphRequest$Serializer;", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "outputStream", "Ljava/io/OutputStream;", "logger", "Lcom/facebook/internal/Logger;", "useUrlEncode", "", "(Ljava/io/OutputStream;Lcom/facebook/internal/Logger;Z)V", "firstWrite", "invalidTypeError", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "getInvalidTypeError", "()Ljava/lang/RuntimeException;", "write", "", "format", "", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "writeBitmap", "key", "bitmap", "Landroid/graphics/Bitmap;", "writeBytes", "bytes", "", "writeContentDisposition", "name", "filename", "contentType", "writeContentUri", "contentUri", "Landroid/net/Uri;", "mimeType", "writeFile", "descriptor", "Landroid/os/ParcelFileDescriptor;", "writeLine", "writeObject", "value", "request", "Lcom/facebook/GraphRequest;", "writeRecordBoundary", "writeRequestsAsJson", "requestJsonArray", "Lorg/json/JSONArray;", "requests", "", "writeString", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequest.kt */
    private static final class Serializer implements KeyValueSerializer {
        private boolean firstWrite = true;
        private final Logger logger;
        private final OutputStream outputStream;
        private final boolean useUrlEncode;

        public Serializer(OutputStream outputStream2, Logger logger2, boolean z) {
            Intrinsics.checkNotNullParameter(outputStream2, "outputStream");
            this.outputStream = outputStream2;
            this.logger = logger2;
            this.useUrlEncode = z;
        }

        public final void writeObject(String str, Object obj, GraphRequest graphRequest) {
            Intrinsics.checkNotNullParameter(str, "key");
            OutputStream outputStream2 = this.outputStream;
            if (outputStream2 instanceof RequestOutputStream) {
                ((RequestOutputStream) outputStream2).setCurrentRequest(graphRequest);
            }
            if (GraphRequest.Companion.isSupportedParameterType(obj)) {
                writeString(str, GraphRequest.Companion.parameterToString(obj));
            } else if (obj instanceof Bitmap) {
                writeBitmap(str, (Bitmap) obj);
            } else if (obj instanceof byte[]) {
                writeBytes(str, (byte[]) obj);
            } else if (obj instanceof Uri) {
                writeContentUri(str, (Uri) obj, (String) null);
            } else if (obj instanceof ParcelFileDescriptor) {
                writeFile(str, (ParcelFileDescriptor) obj, (String) null);
            } else if (obj instanceof ParcelableResourceWithMimeType) {
                ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
                Parcelable resource = parcelableResourceWithMimeType.getResource();
                String mimeType = parcelableResourceWithMimeType.getMimeType();
                if (resource instanceof ParcelFileDescriptor) {
                    writeFile(str, (ParcelFileDescriptor) resource, mimeType);
                } else if (resource instanceof Uri) {
                    writeContentUri(str, (Uri) resource, mimeType);
                } else {
                    throw getInvalidTypeError();
                }
            } else {
                throw getInvalidTypeError();
            }
        }

        private final RuntimeException getInvalidTypeError() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        public final void writeRequestsAsJson(String str, JSONArray jSONArray, Collection<GraphRequest> collection) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(jSONArray, "requestJsonArray");
            Intrinsics.checkNotNullParameter(collection, "requests");
            OutputStream outputStream2 = this.outputStream;
            if (!(outputStream2 instanceof RequestOutputStream)) {
                String jSONArray2 = jSONArray.toString();
                Intrinsics.checkNotNullExpressionValue(jSONArray2, "requestJsonArray.toString()");
                writeString(str, jSONArray2);
                return;
            }
            RequestOutputStream requestOutputStream = (RequestOutputStream) outputStream2;
            writeContentDisposition(str, (String) null, (String) null);
            write("[", new Object[0]);
            int i = 0;
            for (GraphRequest currentRequest : collection) {
                int i2 = i + 1;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                requestOutputStream.setCurrentRequest(currentRequest);
                if (i > 0) {
                    write(",%s", jSONObject.toString());
                } else {
                    write("%s", jSONObject.toString());
                }
                i = i2;
            }
            write("]", new Object[0]);
            Logger logger2 = this.logger;
            if (logger2 != null) {
                String stringPlus = Intrinsics.stringPlus("    ", str);
                String jSONArray3 = jSONArray.toString();
                Intrinsics.checkNotNullExpressionValue(jSONArray3, "requestJsonArray.toString()");
                logger2.appendKeyValue(stringPlus, jSONArray3);
            }
        }

        public void writeString(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, "value");
            writeContentDisposition(str, (String) null, (String) null);
            writeLine("%s", str2);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                logger2.appendKeyValue(Intrinsics.stringPlus("    ", str), str2);
            }
        }

        public final void writeBitmap(String str, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            writeContentDisposition(str, str, ClipboardModule.MIMETYPE_PNG);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.outputStream);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                logger2.appendKeyValue(Intrinsics.stringPlus("    ", str), "<Image>");
            }
        }

        public final void writeBytes(String str, byte[] bArr) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(bArr, "bytes");
            writeContentDisposition(str, str, "content/unknown");
            this.outputStream.write(bArr);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                String stringPlus = Intrinsics.stringPlus("    ", str);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(bArr.length)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                logger2.appendKeyValue(stringPlus, format);
            }
        }

        public final void writeContentUri(String str, Uri uri, String str2) {
            int i;
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(uri, "contentUri");
            if (str2 == null) {
                str2 = "content/unknown";
            }
            writeContentDisposition(str, str, str2);
            if (this.outputStream instanceof ProgressNoopOutputStream) {
                Utility utility = Utility.INSTANCE;
                ((ProgressNoopOutputStream) this.outputStream).addProgress(Utility.getContentSize(uri));
                i = 0;
            } else {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                InputStream openInputStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri);
                Utility utility2 = Utility.INSTANCE;
                i = Utility.copyAndCloseInputStream(openInputStream, this.outputStream) + 0;
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                String stringPlus = Intrinsics.stringPlus("    ", str);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                logger2.appendKeyValue(stringPlus, format);
            }
        }

        public final void writeFile(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) {
            int i;
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(parcelFileDescriptor, "descriptor");
            if (str2 == null) {
                str2 = "content/unknown";
            }
            writeContentDisposition(str, str, str2);
            OutputStream outputStream2 = this.outputStream;
            if (outputStream2 instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) outputStream2).addProgress(parcelFileDescriptor.getStatSize());
                i = 0;
            } else {
                ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
                Utility utility = Utility.INSTANCE;
                i = Utility.copyAndCloseInputStream(autoCloseInputStream, this.outputStream) + 0;
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                String stringPlus = Intrinsics.stringPlus("    ", str);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                logger2.appendKeyValue(stringPlus, format);
            }
        }

        public final void writeRecordBoundary() {
            if (!this.useUrlEncode) {
                writeLine("--%s", GraphRequest.MIME_BOUNDARY);
                return;
            }
            OutputStream outputStream2 = this.outputStream;
            byte[] bytes = "&".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream2.write(bytes);
        }

        public final void writeContentDisposition(String str, String str2, String str3) {
            if (!this.useUrlEncode) {
                write("Content-Disposition: form-data; name=\"%s\"", str);
                if (str2 != null) {
                    write("; filename=\"%s\"", str2);
                }
                writeLine("", new Object[0]);
                if (str3 != null) {
                    writeLine("%s: %s", "Content-Type", str3);
                }
                writeLine("", new Object[0]);
                return;
            }
            OutputStream outputStream2 = this.outputStream;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s=", Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            Charset charset = Charsets.UTF_8;
            if (format != null) {
                byte[] bytes = format.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                outputStream2.write(bytes);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }

        public final void write(String str, Object... objArr) {
            Intrinsics.checkNotNullParameter(str, GraphRequest.FORMAT_PARAM);
            Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
            if (!this.useUrlEncode) {
                if (this.firstWrite) {
                    OutputStream outputStream2 = this.outputStream;
                    byte[] bytes = "--".getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    outputStream2.write(bytes);
                    OutputStream outputStream3 = this.outputStream;
                    String access$getMIME_BOUNDARY$cp = GraphRequest.MIME_BOUNDARY;
                    Charset charset = Charsets.UTF_8;
                    if (access$getMIME_BOUNDARY$cp != null) {
                        byte[] bytes2 = access$getMIME_BOUNDARY$cp.getBytes(charset);
                        Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                        outputStream3.write(bytes2);
                        OutputStream outputStream4 = this.outputStream;
                        byte[] bytes3 = "\r\n".getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes3, "(this as java.lang.String).getBytes(charset)");
                        outputStream4.write(bytes3);
                        this.firstWrite = false;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                OutputStream outputStream5 = this.outputStream;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                String format = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                Charset charset2 = Charsets.UTF_8;
                if (format != null) {
                    byte[] bytes4 = format.getBytes(charset2);
                    Intrinsics.checkNotNullExpressionValue(bytes4, "(this as java.lang.String).getBytes(charset)");
                    outputStream5.write(bytes4);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            OutputStream outputStream6 = this.outputStream;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            Locale locale = Locale.US;
            Object[] copyOf2 = Arrays.copyOf(objArr, objArr.length);
            String format2 = String.format(locale, str, Arrays.copyOf(copyOf2, copyOf2.length));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, format, *args)");
            String encode = URLEncoder.encode(format2, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(encode, "encode(String.format(Locale.US, format, *args), \"UTF-8\")");
            byte[] bytes5 = encode.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes5, "(this as java.lang.String).getBytes(charset)");
            outputStream6.write(bytes5);
        }

        public final void writeLine(String str, Object... objArr) {
            Intrinsics.checkNotNullParameter(str, GraphRequest.FORMAT_PARAM);
            Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
            write(str, Arrays.copyOf(objArr, objArr.length));
            if (!this.useUrlEncode) {
                write("\r\n", new Object[0]);
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u0015*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0002:\u0001\u0015B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0012\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType;", "RESOURCE", "Landroid/os/Parcelable;", "resource", "mimeType", "", "(Landroid/os/Parcelable;Ljava/lang/String;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getMimeType", "()Ljava/lang/String;", "getResource", "()Landroid/os/Parcelable;", "Landroid/os/Parcelable;", "describeContents", "", "writeToParcel", "", "out", "flags", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GraphRequest.kt */
    public static final class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        public static final Parcelable.Creator<ParcelableResourceWithMimeType<?>> CREATOR = new GraphRequest$ParcelableResourceWithMimeType$Companion$CREATOR$1();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String mimeType;
        private final RESOURCE resource;

        public /* synthetic */ ParcelableResourceWithMimeType(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        public int describeContents() {
            return 1;
        }

        public final String getMimeType() {
            return this.mimeType;
        }

        public final RESOURCE getResource() {
            return this.resource;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.mimeType);
            parcel.writeParcelable(this.resource, i);
        }

        public ParcelableResourceWithMimeType(RESOURCE resource2, String str) {
            this.mimeType = str;
            this.resource = resource2;
        }

        private ParcelableResourceWithMimeType(Parcel parcel) {
            this.mimeType = parcel.readString();
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            this.resource = parcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: GraphRequest.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
