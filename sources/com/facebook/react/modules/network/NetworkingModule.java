package com.facebook.react.modules.network;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeNetworkingAndroidSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.StandardCharsets;
import com.facebook.react.common.network.OkHttpCallUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

@ReactModule(name = "Networking")
public final class NetworkingModule extends NativeNetworkingAndroidSpec {
    private static final int CHUNK_TIMEOUT_NS = 100000000;
    private static final String CONTENT_ENCODING_HEADER_NAME = "content-encoding";
    private static final String CONTENT_TYPE_HEADER_NAME = "content-type";
    private static final int MAX_CHUNK_SIZE_BETWEEN_FLUSHES = 8192;
    public static final String NAME = "Networking";
    private static final String REQUEST_BODY_KEY_BASE64 = "base64";
    private static final String REQUEST_BODY_KEY_FORMDATA = "formData";
    private static final String REQUEST_BODY_KEY_STRING = "string";
    private static final String REQUEST_BODY_KEY_URI = "uri";
    private static final String TAG = "NetworkingModule";
    private static final String USER_AGENT_HEADER_NAME = "user-agent";
    private static CustomClientBuilder customClientBuilder;
    /* access modifiers changed from: private */
    public final OkHttpClient mClient;
    private final ForwardingCookieHandler mCookieHandler;
    private final CookieJarContainer mCookieJarContainer;
    private final String mDefaultUserAgent;
    private final List<RequestBodyHandler> mRequestBodyHandlers;
    private final Set<Integer> mRequestIds;
    /* access modifiers changed from: private */
    public final List<ResponseHandler> mResponseHandlers;
    /* access modifiers changed from: private */
    public boolean mShuttingDown;
    private final List<UriHandler> mUriHandlers;

    public interface CustomClientBuilder {
        void apply(OkHttpClient.Builder builder);
    }

    public interface RequestBodyHandler {
        boolean supports(ReadableMap readableMap);

        RequestBody toRequestBody(ReadableMap readableMap, String str);
    }

    public interface ResponseHandler {
        boolean supports(String str);

        WritableMap toResponseData(ResponseBody responseBody) throws IOException;
    }

    public interface UriHandler {
        WritableMap fetch(Uri uri) throws IOException;

        boolean supports(Uri uri, String str);
    }

    /* access modifiers changed from: private */
    public static boolean shouldDispatch(long j, long j2) {
        return j2 + 100000000 < j;
    }

    public void addListener(String str) {
    }

    public String getName() {
        return NAME;
    }

    public void removeListeners(double d) {
    }

    NetworkingModule(ReactApplicationContext reactApplicationContext, String str, OkHttpClient okHttpClient, List<NetworkInterceptorCreator> list) {
        super(reactApplicationContext);
        this.mRequestBodyHandlers = new ArrayList();
        this.mUriHandlers = new ArrayList();
        this.mResponseHandlers = new ArrayList();
        if (list != null) {
            OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
            for (NetworkInterceptorCreator create : list) {
                newBuilder.addNetworkInterceptor(create.create());
            }
            okHttpClient = newBuilder.build();
        }
        this.mClient = okHttpClient;
        this.mCookieHandler = new ForwardingCookieHandler(reactApplicationContext);
        this.mCookieJarContainer = (CookieJarContainer) okHttpClient.cookieJar();
        this.mShuttingDown = false;
        this.mDefaultUserAgent = str;
        this.mRequestIds = new HashSet();
    }

    NetworkingModule(ReactApplicationContext reactApplicationContext, String str, OkHttpClient okHttpClient) {
        this(reactApplicationContext, str, okHttpClient, (List<NetworkInterceptorCreator>) null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, (String) null, OkHttpClientProvider.createClient(reactApplicationContext), (List<NetworkInterceptorCreator>) null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, List<NetworkInterceptorCreator> list) {
        this(reactApplicationContext, (String) null, OkHttpClientProvider.createClient(reactApplicationContext), list);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, String str) {
        this(reactApplicationContext, str, OkHttpClientProvider.createClient(reactApplicationContext), (List<NetworkInterceptorCreator>) null);
    }

    public static void setCustomClientBuilder(CustomClientBuilder customClientBuilder2) {
        customClientBuilder = customClientBuilder2;
    }

    private static void applyCustomBuilder(OkHttpClient.Builder builder) {
        CustomClientBuilder customClientBuilder2 = customClientBuilder;
        if (customClientBuilder2 != null) {
            customClientBuilder2.apply(builder);
        }
    }

    public void initialize() {
        this.mCookieJarContainer.setCookieJar(new JavaNetCookieJar(this.mCookieHandler));
    }

    public void invalidate() {
        this.mShuttingDown = true;
        cancelAllRequests();
        this.mCookieHandler.destroy();
        this.mCookieJarContainer.removeCookieJar();
        this.mRequestBodyHandlers.clear();
        this.mResponseHandlers.clear();
        this.mUriHandlers.clear();
    }

    public void addUriHandler(UriHandler uriHandler) {
        this.mUriHandlers.add(uriHandler);
    }

    public void addRequestBodyHandler(RequestBodyHandler requestBodyHandler) {
        this.mRequestBodyHandlers.add(requestBodyHandler);
    }

    public void addResponseHandler(ResponseHandler responseHandler) {
        this.mResponseHandlers.add(responseHandler);
    }

    public void removeUriHandler(UriHandler uriHandler) {
        this.mUriHandlers.remove(uriHandler);
    }

    public void removeRequestBodyHandler(RequestBodyHandler requestBodyHandler) {
        this.mRequestBodyHandlers.remove(requestBodyHandler);
    }

    public void removeResponseHandler(ResponseHandler responseHandler) {
        this.mResponseHandlers.remove(responseHandler);
    }

    public void sendRequest(String str, String str2, double d, ReadableArray readableArray, ReadableMap readableMap, String str3, boolean z, double d2, boolean z2) {
        int i = (int) d;
        try {
            sendRequestInternal(str, str2, i, readableArray, readableMap, str3, z, (int) d2, z2);
        } catch (Throwable th) {
            Throwable th2 = th;
            String str4 = str2;
            FLog.e(TAG, "Failed to send url request: " + str2, th2);
            DeviceEventManagerModule.RCTDeviceEventEmitter eventEmitter = getEventEmitter("sendRequest error");
            if (eventEmitter != null) {
                ResponseUtil.onRequestError(eventEmitter, i, th2.getMessage(), th2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0194  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendRequestInternal(java.lang.String r15, java.lang.String r16, int r17, com.facebook.react.bridge.ReadableArray r18, com.facebook.react.bridge.ReadableMap r19, java.lang.String r20, boolean r21, int r22, boolean r23) {
        /*
            r14 = this;
            r7 = r14
            r0 = r15
            r3 = r17
            r1 = r19
            r5 = r20
            r2 = r22
            java.lang.String r4 = "sendRequestInternal"
            com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter r4 = r14.getEventEmitter(r4)
            android.net.Uri r6 = android.net.Uri.parse(r16)     // Catch:{ IOException -> 0x01c4 }
            java.util.List<com.facebook.react.modules.network.NetworkingModule$UriHandler> r8 = r7.mUriHandlers     // Catch:{ IOException -> 0x01c4 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ IOException -> 0x01c4 }
        L_0x001a:
            boolean r9 = r8.hasNext()     // Catch:{ IOException -> 0x01c4 }
            if (r9 == 0) goto L_0x0037
            java.lang.Object r9 = r8.next()     // Catch:{ IOException -> 0x01c4 }
            com.facebook.react.modules.network.NetworkingModule$UriHandler r9 = (com.facebook.react.modules.network.NetworkingModule.UriHandler) r9     // Catch:{ IOException -> 0x01c4 }
            boolean r10 = r9.supports(r6, r5)     // Catch:{ IOException -> 0x01c4 }
            if (r10 == 0) goto L_0x001a
            com.facebook.react.bridge.WritableMap r0 = r9.fetch(r6)     // Catch:{ IOException -> 0x01c4 }
            com.facebook.react.modules.network.ResponseUtil.onDataReceived((com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter) r4, (int) r3, (com.facebook.react.bridge.WritableMap) r0)     // Catch:{ IOException -> 0x01c4 }
            com.facebook.react.modules.network.ResponseUtil.onRequestSuccess(r4, r3)     // Catch:{ IOException -> 0x01c4 }
            return
        L_0x0037:
            r6 = 0
            okhttp3.Request$Builder r8 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x01bb }
            r8.<init>()     // Catch:{ Exception -> 0x01bb }
            r9 = r16
            okhttp3.Request$Builder r8 = r8.url((java.lang.String) r9)     // Catch:{ Exception -> 0x01bb }
            if (r3 == 0) goto L_0x004c
            java.lang.Integer r9 = java.lang.Integer.valueOf(r17)
            r8.tag(r9)
        L_0x004c:
            okhttp3.OkHttpClient r9 = r7.mClient
            okhttp3.OkHttpClient$Builder r9 = r9.newBuilder()
            applyCustomBuilder(r9)
            if (r23 != 0) goto L_0x005c
            okhttp3.CookieJar r10 = okhttp3.CookieJar.NO_COOKIES
            r9.cookieJar(r10)
        L_0x005c:
            if (r21 == 0) goto L_0x0066
            com.facebook.react.modules.network.NetworkingModule$1 r10 = new com.facebook.react.modules.network.NetworkingModule$1
            r10.<init>(r5, r4, r3)
            r9.addNetworkInterceptor(r10)
        L_0x0066:
            okhttp3.OkHttpClient r10 = r7.mClient
            int r10 = r10.connectTimeoutMillis()
            if (r2 == r10) goto L_0x0074
            long r10 = (long) r2
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r9.connectTimeout(r10, r2)
        L_0x0074:
            okhttp3.OkHttpClient r2 = r9.build()
            r9 = r18
            okhttp3.Headers r9 = r14.extractHeaders(r9, r1)
            if (r9 != 0) goto L_0x0086
            java.lang.String r0 = "Unrecognized headers format"
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r4, r3, r0, r6)
            return
        L_0x0086:
            java.lang.String r10 = "content-type"
            java.lang.String r10 = r9.get(r10)
            java.lang.String r11 = "content-encoding"
            java.lang.String r11 = r9.get(r11)
            r8.headers(r9)
            if (r1 == 0) goto L_0x00b0
            java.util.List<com.facebook.react.modules.network.NetworkingModule$RequestBodyHandler> r9 = r7.mRequestBodyHandlers
            java.util.Iterator r9 = r9.iterator()
        L_0x009d:
            boolean r12 = r9.hasNext()
            if (r12 == 0) goto L_0x00b0
            java.lang.Object r12 = r9.next()
            com.facebook.react.modules.network.NetworkingModule$RequestBodyHandler r12 = (com.facebook.react.modules.network.NetworkingModule.RequestBodyHandler) r12
            boolean r13 = r12.supports(r1)
            if (r13 == 0) goto L_0x009d
            goto L_0x00b1
        L_0x00b0:
            r12 = r6
        L_0x00b1:
            if (r1 == 0) goto L_0x0194
            java.util.Locale r9 = java.util.Locale.ROOT
            java.lang.String r9 = r15.toLowerCase(r9)
            java.lang.String r13 = "get"
            boolean r9 = r9.equals(r13)
            if (r9 != 0) goto L_0x0194
            java.util.Locale r9 = java.util.Locale.ROOT
            java.lang.String r9 = r15.toLowerCase(r9)
            java.lang.String r13 = "head"
            boolean r9 = r9.equals(r13)
            if (r9 == 0) goto L_0x00d1
            goto L_0x0194
        L_0x00d1:
            if (r12 == 0) goto L_0x00d9
            okhttp3.RequestBody r1 = r12.toRequestBody(r1, r10)
            goto L_0x0198
        L_0x00d9:
            java.lang.String r9 = "string"
            boolean r12 = r1.hasKey(r9)
            java.lang.String r13 = "Payload is set but no content-type header specified"
            if (r12 == 0) goto L_0x0118
            if (r10 != 0) goto L_0x00e9
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r4, r3, r13, r6)
            return
        L_0x00e9:
            java.lang.String r1 = r1.getString(r9)
            okhttp3.MediaType r9 = okhttp3.MediaType.parse(r10)
            boolean r10 = com.facebook.react.modules.network.RequestBodyUtil.isGzipEncoding(r11)
            if (r10 == 0) goto L_0x0103
            okhttp3.RequestBody r1 = com.facebook.react.modules.network.RequestBodyUtil.createGzip(r9, r1)
            if (r1 != 0) goto L_0x0198
            java.lang.String r0 = "Failed to gzip request body"
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r4, r3, r0, r6)
            return
        L_0x0103:
            if (r9 != 0) goto L_0x0108
            java.nio.charset.Charset r6 = com.facebook.react.common.StandardCharsets.UTF_8
            goto L_0x010e
        L_0x0108:
            java.nio.charset.Charset r6 = com.facebook.react.common.StandardCharsets.UTF_8
            java.nio.charset.Charset r6 = r9.charset(r6)
        L_0x010e:
            byte[] r1 = r1.getBytes(r6)
            okhttp3.RequestBody r1 = okhttp3.RequestBody.create((okhttp3.MediaType) r9, (byte[]) r1)
            goto L_0x0198
        L_0x0118:
            java.lang.String r9 = "base64"
            boolean r11 = r1.hasKey(r9)
            if (r11 == 0) goto L_0x0137
            if (r10 != 0) goto L_0x0126
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r4, r3, r13, r6)
            return
        L_0x0126:
            java.lang.String r1 = r1.getString(r9)
            okhttp3.MediaType r6 = okhttp3.MediaType.parse(r10)
            okio.ByteString r1 = okio.ByteString.decodeBase64(r1)
            okhttp3.RequestBody r1 = okhttp3.RequestBody.create((okhttp3.MediaType) r6, (okio.ByteString) r1)
            goto L_0x0198
        L_0x0137:
            java.lang.String r9 = "uri"
            boolean r11 = r1.hasKey(r9)
            if (r11 == 0) goto L_0x0173
            if (r10 != 0) goto L_0x0145
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r4, r3, r13, r6)
            return
        L_0x0145:
            java.lang.String r1 = r1.getString(r9)
            com.facebook.react.bridge.ReactApplicationContext r9 = r14.getReactApplicationContext()
            java.io.InputStream r9 = com.facebook.react.modules.network.RequestBodyUtil.getFileInputStream(r9, r1)
            if (r9 != 0) goto L_0x016a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Could not retrieve file for uri "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r4, r3, r0, r6)
            return
        L_0x016a:
            okhttp3.MediaType r1 = okhttp3.MediaType.parse(r10)
            okhttp3.RequestBody r1 = com.facebook.react.modules.network.RequestBodyUtil.create(r1, r9)
            goto L_0x0198
        L_0x0173:
            java.lang.String r6 = "formData"
            boolean r9 = r1.hasKey(r6)
            if (r9 == 0) goto L_0x018f
            if (r10 != 0) goto L_0x017f
            java.lang.String r10 = "multipart/form-data"
        L_0x017f:
            com.facebook.react.bridge.ReadableArray r1 = r1.getArray(r6)
            okhttp3.MultipartBody$Builder r1 = r14.constructMultipartBody(r1, r10, r3)
            if (r1 != 0) goto L_0x018a
            return
        L_0x018a:
            okhttp3.MultipartBody r1 = r1.build()
            goto L_0x0198
        L_0x018f:
            okhttp3.RequestBody r1 = com.facebook.react.modules.network.RequestBodyUtil.getEmptyBody(r15)
            goto L_0x0198
        L_0x0194:
            okhttp3.RequestBody r1 = com.facebook.react.modules.network.RequestBodyUtil.getEmptyBody(r15)
        L_0x0198:
            okhttp3.RequestBody r1 = r14.wrapRequestBodyWithProgressEmitter(r1, r4, r3)
            r8.method(r15, r1)
            r14.addRequest(r3)
            okhttp3.Request r0 = r8.build()
            okhttp3.Call r0 = r2.newCall(r0)
            com.facebook.react.modules.network.NetworkingModule$2 r8 = new com.facebook.react.modules.network.NetworkingModule$2
            r1 = r8
            r2 = r14
            r3 = r17
            r5 = r20
            r6 = r21
            r1.<init>(r3, r4, r5, r6)
            r0.enqueue(r8)
            return
        L_0x01bb:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r4, r3, r0, r6)
            return
        L_0x01c4:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            com.facebook.react.modules.network.ResponseUtil.onRequestError(r4, r3, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.network.NetworkingModule.sendRequestInternal(java.lang.String, java.lang.String, int, com.facebook.react.bridge.ReadableArray, com.facebook.react.bridge.ReadableMap, java.lang.String, boolean, int, boolean):void");
    }

    private RequestBody wrapRequestBodyWithProgressEmitter(RequestBody requestBody, final DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, final int i) {
        if (requestBody == null) {
            return null;
        }
        return RequestBodyUtil.createProgressRequest(requestBody, new ProgressListener() {
            long last = System.nanoTime();

            public void onProgress(long j, long j2, boolean z) {
                long nanoTime = System.nanoTime();
                if (z || NetworkingModule.shouldDispatch(nanoTime, this.last)) {
                    ResponseUtil.onDataSend(rCTDeviceEventEmitter, i, j, j2);
                    this.last = nanoTime;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void readWithProgress(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i, ResponseBody responseBody) throws IOException {
        long j;
        Charset charset;
        long j2 = -1;
        try {
            ProgressResponseBody progressResponseBody = (ProgressResponseBody) responseBody;
            j = progressResponseBody.totalBytesRead();
            try {
                j2 = progressResponseBody.contentLength();
            } catch (ClassCastException unused) {
            }
        } catch (ClassCastException unused2) {
            j = -1;
        }
        if (responseBody.contentType() == null) {
            charset = StandardCharsets.UTF_8;
        } else {
            charset = responseBody.contentType().charset(StandardCharsets.UTF_8);
        }
        ProgressiveStringDecoder progressiveStringDecoder = new ProgressiveStringDecoder(charset);
        InputStream byteStream = responseBody.byteStream();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = byteStream.read(bArr);
                if (read != -1) {
                    ResponseUtil.onIncrementalDataReceived(rCTDeviceEventEmitter, i, progressiveStringDecoder.decodeNext(bArr, read), j, j2);
                } else {
                    return;
                }
            }
        } finally {
            byteStream.close();
        }
    }

    private synchronized void addRequest(int i) {
        this.mRequestIds.add(Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    public synchronized void removeRequest(int i) {
        this.mRequestIds.remove(Integer.valueOf(i));
    }

    private synchronized void cancelAllRequests() {
        for (Integer intValue : this.mRequestIds) {
            cancelRequest(intValue.intValue());
        }
        this.mRequestIds.clear();
    }

    /* access modifiers changed from: private */
    public static WritableMap translateHeaders(Headers headers) {
        Bundle bundle = new Bundle();
        for (int i = 0; i < headers.size(); i++) {
            String name = headers.name(i);
            if (bundle.containsKey(name)) {
                bundle.putString(name, bundle.getString(name) + ", " + headers.value(i));
            } else {
                bundle.putString(name, headers.value(i));
            }
        }
        return Arguments.fromBundle(bundle);
    }

    public void abortRequest(double d) {
        int i = (int) d;
        cancelRequest(i);
        removeRequest(i);
    }

    private void cancelRequest(final int i) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                OkHttpCallUtil.cancelTag(NetworkingModule.this.mClient, Integer.valueOf(i));
            }
        }.execute(new Void[0]);
    }

    @ReactMethod
    public void clearCookies(Callback callback) {
        this.mCookieHandler.clearCookies(callback);
    }

    private MultipartBody.Builder constructMultipartBody(ReadableArray readableArray, String str, int i) {
        MediaType mediaType;
        DeviceEventManagerModule.RCTDeviceEventEmitter eventEmitter = getEventEmitter("constructMultipartBody");
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MediaType.parse(str));
        int size = readableArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            ReadableMap map = readableArray.getMap(i2);
            Headers extractHeaders = extractHeaders(map.getArray("headers"), (ReadableMap) null);
            if (extractHeaders == null) {
                ResponseUtil.onRequestError(eventEmitter, i, "Missing or invalid header format for FormData part.", (Throwable) null);
                return null;
            }
            String str2 = extractHeaders.get(CONTENT_TYPE_HEADER_NAME);
            if (str2 != null) {
                mediaType = MediaType.parse(str2);
                extractHeaders = extractHeaders.newBuilder().removeAll(CONTENT_TYPE_HEADER_NAME).build();
            } else {
                mediaType = null;
            }
            if (map.hasKey("string")) {
                builder.addPart(extractHeaders, RequestBody.create(mediaType, map.getString("string")));
            } else if (!map.hasKey("uri")) {
                ResponseUtil.onRequestError(eventEmitter, i, "Unrecognized FormData part.", (Throwable) null);
            } else if (mediaType == null) {
                ResponseUtil.onRequestError(eventEmitter, i, "Binary FormData part needs a content-type header.", (Throwable) null);
                return null;
            } else {
                String string = map.getString("uri");
                InputStream fileInputStream = RequestBodyUtil.getFileInputStream(getReactApplicationContext(), string);
                if (fileInputStream == null) {
                    ResponseUtil.onRequestError(eventEmitter, i, "Could not retrieve file for uri " + string, (Throwable) null);
                    return null;
                }
                builder.addPart(extractHeaders, RequestBodyUtil.create(mediaType, fileInputStream));
            }
        }
        return builder;
    }

    private Headers extractHeaders(ReadableArray readableArray, ReadableMap readableMap) {
        String str;
        if (readableArray == null) {
            return null;
        }
        Headers.Builder builder = new Headers.Builder();
        int size = readableArray.size();
        boolean z = false;
        int i = 0;
        while (i < size) {
            ReadableArray array = readableArray.getArray(i);
            if (array != null && array.size() == 2) {
                String stripHeaderName = HeaderUtil.stripHeaderName(array.getString(0));
                String stripHeaderValue = HeaderUtil.stripHeaderValue(array.getString(1));
                if (!(stripHeaderName == null || stripHeaderValue == null)) {
                    builder.add(stripHeaderName, stripHeaderValue);
                    i++;
                }
            }
            return null;
        }
        if (builder.get(USER_AGENT_HEADER_NAME) == null && (str = this.mDefaultUserAgent) != null) {
            builder.add(USER_AGENT_HEADER_NAME, str);
        }
        if (readableMap != null && readableMap.hasKey("string")) {
            z = true;
        }
        if (!z) {
            builder.removeAll(CONTENT_ENCODING_HEADER_NAME);
        }
        return builder.build();
    }

    private DeviceEventManagerModule.RCTDeviceEventEmitter getEventEmitter(String str) {
        if (getReactApplicationContextIfActiveOrWarn() != null) {
            return (DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        }
        return null;
    }
}
