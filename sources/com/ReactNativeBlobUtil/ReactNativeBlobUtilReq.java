package com.ReactNativeBlobUtil;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import androidx.exifinterface.media.ExifInterface;
import com.ReactNativeBlobUtil.Utils.Tls12SocketFactory;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import io.sentry.ProfilingTraceData;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.TlsVersion;

public class ReactNativeBlobUtilReq extends BroadcastReceiver implements Runnable {
    public static HashMap<String, Long> androidDownloadManagerTaskTable = new HashMap<>();
    static ConnectionPool pool = new ConnectionPool();
    static HashMap<String, ReactNativeBlobUtilProgressConfig> progressReport = new HashMap<>();
    public static HashMap<String, Call> taskTable = new HashMap<>();
    static HashMap<String, ReactNativeBlobUtilProgressConfig> uploadProgressReport = new HashMap<>();
    private final int QUERY = 1314;
    Callback callback;
    boolean callbackfired;
    OkHttpClient client;
    long contentLength;
    String destPath;
    long downloadManagerId;
    /* access modifiers changed from: private */
    public Future<?> future;
    ReadableMap headers;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what == 1314 && message.getData().getLong("downloadManagerId") == ReactNativeBlobUtilReq.this.downloadManagerId) {
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(new long[]{ReactNativeBlobUtilReq.this.downloadManagerId});
                Cursor query2 = ((DownloadManager) ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getSystemService("download")).query(query);
                if (query2 != null && query2.moveToFirst()) {
                    long j = (long) query2.getInt(query2.getColumnIndex("bytes_so_far"));
                    long j2 = query2.getLong(query2.getColumnIndex("total_size"));
                    query2.close();
                    ReactNativeBlobUtilProgressConfig reportProgress = ReactNativeBlobUtilReq.getReportProgress(ReactNativeBlobUtilReq.this.taskId);
                    float f = j2 > 0 ? (float) (j / j2) : 0.0f;
                    if (reportProgress != null && reportProgress.shouldReport(f)) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("taskId", String.valueOf(ReactNativeBlobUtilReq.this.taskId));
                        createMap.putString("written", String.valueOf(j));
                        createMap.putString("total", String.valueOf(j2));
                        createMap.putString("chunk", "");
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilImpl.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_PROGRESS, createMap);
                    }
                    if (j2 == j) {
                        ReactNativeBlobUtilReq.this.future.cancel(true);
                    }
                }
            }
            return true;
        }
    });
    String method;
    ReactNativeBlobUtilConfig options;
    String rawRequestBody;
    ReadableArray rawRequestBodyArray;
    ArrayList<String> redirects = new ArrayList<>();
    ReactNativeBlobUtilBody requestBody;
    RequestType requestType;
    WritableMap respInfo;
    ResponseFormat responseFormat = ResponseFormat.Auto;
    ResponseType responseType;
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    String taskId;
    boolean timeout = false;
    String url;

    enum RequestType {
        Form,
        SingleFile,
        AsIs,
        WithoutBody,
        Others
    }

    enum ResponseFormat {
        Auto,
        UTF8,
        BASE64
    }

    enum ResponseType {
        KeepInMemory,
        FileStorage
    }

    private boolean shouldTransformFile() {
        return this.options.transformFile.booleanValue() && (this.options.fileCache.booleanValue() || this.options.path != null);
    }

    public ReactNativeBlobUtilReq(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, ReadableArray readableArray, OkHttpClient okHttpClient, Callback callback2) {
        this.method = str2.toUpperCase(Locale.ROOT);
        ReactNativeBlobUtilConfig reactNativeBlobUtilConfig = new ReactNativeBlobUtilConfig(readableMap);
        this.options = reactNativeBlobUtilConfig;
        this.taskId = str;
        this.url = str3;
        this.headers = readableMap2;
        this.callback = callback2;
        this.rawRequestBody = str4;
        this.rawRequestBodyArray = readableArray;
        this.client = okHttpClient;
        this.callbackfired = false;
        if ((reactNativeBlobUtilConfig.fileCache.booleanValue() || this.options.path != null) && !shouldTransformFile()) {
            this.responseType = ResponseType.FileStorage;
        } else {
            this.responseType = ResponseType.KeepInMemory;
        }
        if (str4 != null) {
            this.requestType = RequestType.SingleFile;
        } else if (readableArray != null) {
            this.requestType = RequestType.Form;
        } else {
            this.requestType = RequestType.WithoutBody;
        }
    }

    public static void cancelTask(String str) {
        Call call = taskTable.get(str);
        if (call != null) {
            call.cancel();
            taskTable.remove(str);
        }
        if (androidDownloadManagerTaskTable.containsKey(str)) {
            ((DownloadManager) ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getSystemService("download")).remove(new long[]{androidDownloadManagerTaskTable.get(str).longValue()});
        }
    }

    /* access modifiers changed from: private */
    public void invoke_callback(Object... objArr) {
        if (!this.callbackfired) {
            this.callback.invoke(objArr);
            this.callbackfired = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x0428 A[Catch:{ Exception -> 0x0574 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x04dc A[Catch:{ Exception -> 0x0574 }] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0524 A[Catch:{ Exception -> 0x0574 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = ";base64"
            java.lang.String r3 = "post"
            java.lang.String r4 = "Content-Type"
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r5 = "."
            java.lang.String r6 = "path"
            r7 = 2
            r8 = 1
            if (r0 == 0) goto L_0x01dc
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r9 = "useDownloadManager"
            boolean r0 = r0.hasKey(r9)
            if (r0 == 0) goto L_0x01dc
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.getBoolean(r9)
            if (r0 == 0) goto L_0x01dc
            java.lang.String r0 = r1.url
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.app.DownloadManager$Request r2 = new android.app.DownloadManager$Request
            r2.<init>(r0)
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r3 = "notification"
            boolean r0 = r0.hasKey(r3)
            if (r0 == 0) goto L_0x004f
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.getBoolean(r3)
            if (r0 == 0) goto L_0x004f
            r2.setNotificationVisibility(r8)
            goto L_0x0052
        L_0x004f:
            r2.setNotificationVisibility(r7)
        L_0x0052:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r3 = "title"
            boolean r0 = r0.hasKey(r3)
            if (r0 == 0) goto L_0x0069
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r0 = r0.getString(r3)
            r2.setTitle(r0)
        L_0x0069:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r4 = "description"
            boolean r0 = r0.hasKey(r4)
            if (r0 == 0) goto L_0x0080
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r0 = r0.getString(r4)
            r2.setDescription(r0)
        L_0x0080:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.hasKey(r6)
            if (r0 == 0) goto L_0x00ac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "file://"
            java.lang.StringBuilder r0 = r0.append(r4)
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r4 = r1.options
            com.facebook.react.bridge.ReadableMap r4 = r4.addAndroidDownloads
            java.lang.String r4 = r4.getString(r6)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r2.setDestinationUri(r0)
        L_0x00ac:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r4 = "mime"
            boolean r0 = r0.hasKey(r4)
            if (r0 == 0) goto L_0x00c3
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r0 = r0.getString(r4)
            r2.setMimeType(r0)
        L_0x00c3:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r4 = "mediaScannable"
            boolean r0 = r0.hasKey(r4)
            if (r0 == 0) goto L_0x00dc
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.getBoolean(r4)
            if (r0 == 0) goto L_0x00dc
            r2.allowScanningByMediaScanner()
        L_0x00dc:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 29
            if (r0 < r4) goto L_0x013e
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r4 = "storeInDownloads"
            boolean r0 = r0.hasKey(r4)
            if (r0 == 0) goto L_0x013e
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.getBoolean(r4)
            if (r0 == 0) goto L_0x013e
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r0 = r0.getString(r3)
            if (r0 == 0) goto L_0x0108
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x0110
        L_0x0108:
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
        L_0x0110:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r3 = r1.options
            java.lang.String r3 = r3.appendExt
            if (r3 == 0) goto L_0x0139
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r3 = r1.options
            java.lang.String r3 = r3.appendExt
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0139
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r5)
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r3 = r1.options
            java.lang.String r3 = r3.appendExt
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
        L_0x0139:
            java.lang.String r3 = android.os.Environment.DIRECTORY_DOWNLOADS
            r2.setDestinationInExternalPublicDir(r3, r0)
        L_0x013e:
            com.facebook.react.bridge.ReadableMap r0 = r1.headers
            com.facebook.react.bridge.ReadableMapKeySetIterator r0 = r0.keySetIterator()
        L_0x0144:
            boolean r3 = r0.hasNextKey()
            if (r3 == 0) goto L_0x0158
            java.lang.String r3 = r0.nextKey()
            com.facebook.react.bridge.ReadableMap r4 = r1.headers
            java.lang.String r4 = r4.getString(r3)
            r2.addRequestHeader(r3, r4)
            goto L_0x0144
        L_0x0158:
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x018c }
            java.lang.String r3 = r1.url     // Catch:{ MalformedURLException -> 0x018c }
            r0.<init>(r3)     // Catch:{ MalformedURLException -> 0x018c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x018c }
            r3.<init>()     // Catch:{ MalformedURLException -> 0x018c }
            java.lang.String r4 = r0.getProtocol()     // Catch:{ MalformedURLException -> 0x018c }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ MalformedURLException -> 0x018c }
            java.lang.String r4 = "://"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ MalformedURLException -> 0x018c }
            java.lang.String r0 = r0.getHost()     // Catch:{ MalformedURLException -> 0x018c }
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ MalformedURLException -> 0x018c }
            java.lang.String r0 = r0.toString()     // Catch:{ MalformedURLException -> 0x018c }
            android.webkit.CookieManager r3 = android.webkit.CookieManager.getInstance()     // Catch:{ MalformedURLException -> 0x018c }
            java.lang.String r0 = r3.getCookie(r0)     // Catch:{ MalformedURLException -> 0x018c }
            java.lang.String r3 = "Cookie"
            r2.addRequestHeader(r3, r0)     // Catch:{ MalformedURLException -> 0x018c }
            goto L_0x0190
        L_0x018c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0190:
            com.facebook.react.bridge.ReactApplicationContext r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r3 = "download"
            java.lang.Object r3 = r0.getSystemService(r3)
            android.app.DownloadManager r3 = (android.app.DownloadManager) r3
            long r2 = r3.enqueue(r2)
            r1.downloadManagerId = r2
            java.util.HashMap<java.lang.String, java.lang.Long> r4 = androidDownloadManagerTaskTable
            java.lang.String r5 = r1.taskId
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r4.put(r5, r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 34
            java.lang.String r4 = "android.intent.action.DOWNLOAD_COMPLETE"
            if (r2 < r3) goto L_0x01c0
            android.content.IntentFilter r2 = new android.content.IntentFilter
            r2.<init>(r4)
            r0.registerReceiver(r1, r2, r7)
            goto L_0x01c8
        L_0x01c0:
            android.content.IntentFilter r2 = new android.content.IntentFilter
            r2.<init>(r4)
            r0.registerReceiver(r1, r2)
        L_0x01c8:
            java.util.concurrent.ScheduledExecutorService r5 = r1.scheduledExecutorService
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$2 r6 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$2
            r6.<init>()
            r7 = 0
            r9 = 100
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.ScheduledFuture r0 = r5.scheduleAtFixedRate(r6, r7, r9, r11)
            r1.future = r0
            return
        L_0x01dc:
            java.lang.String r0 = r1.taskId
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r9 = r1.options
            java.lang.String r9 = r9.appendExt
            java.lang.String r10 = ""
            if (r9 == 0) goto L_0x0207
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r9 = r1.options
            java.lang.String r9 = r9.appendExt
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x01f1
            goto L_0x0207
        L_0x01f1:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.StringBuilder r5 = r9.append(r5)
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r9 = r1.options
            java.lang.String r9 = r9.appendExt
            java.lang.StringBuilder r5 = r5.append(r9)
            java.lang.String r5 = r5.toString()
            goto L_0x0208
        L_0x0207:
            r5 = r10
        L_0x0208:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r9 = r1.options
            java.lang.String r9 = r9.key
            r11 = 3
            r12 = 0
            r13 = 0
            if (r9 == 0) goto L_0x024d
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            java.lang.String r0 = r0.key
            java.lang.String r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.getMD5(r0)
            if (r0 != 0) goto L_0x021d
            java.lang.String r0 = r1.taskId
        L_0x021d:
            java.io.File r9 = new java.io.File
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.getTmpPath(r0)
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.StringBuilder r14 = r14.append(r5)
            java.lang.String r14 = r14.toString()
            r9.<init>(r14)
            boolean r14 = r9.exists()
            if (r14 == 0) goto L_0x024d
            java.lang.Object[] r0 = new java.lang.Object[r11]
            r0[r13] = r12
            r0[r8] = r6
            java.lang.String r2 = r9.getAbsolutePath()
            r0[r7] = r2
            r1.invoke_callback(r0)
            return
        L_0x024d:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r6 = r1.options
            java.lang.String r6 = r6.path
            if (r6 == 0) goto L_0x025a
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            java.lang.String r0 = r0.path
            r1.destPath = r0
            goto L_0x027b
        L_0x025a:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r6 = r1.options
            java.lang.Boolean r6 = r6.fileCache
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x027b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.getTmpPath(r0)
            java.lang.StringBuilder r0 = r6.append(r0)
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r0 = r0.toString()
            r1.destPath = r0
        L_0x027b:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options     // Catch:{ Exception -> 0x0574 }
            java.lang.Boolean r0 = r0.trusty     // Catch:{ Exception -> 0x0574 }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x0574 }
            if (r0 == 0) goto L_0x028c
            okhttp3.OkHttpClient r0 = r1.client     // Catch:{ Exception -> 0x0574 }
            okhttp3.OkHttpClient$Builder r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.getUnsafeOkHttpClient(r0)     // Catch:{ Exception -> 0x0574 }
            goto L_0x0292
        L_0x028c:
            okhttp3.OkHttpClient r0 = r1.client     // Catch:{ Exception -> 0x0574 }
            okhttp3.OkHttpClient$Builder r0 = r0.newBuilder()     // Catch:{ Exception -> 0x0574 }
        L_0x0292:
            r5 = r0
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options     // Catch:{ Exception -> 0x0574 }
            java.lang.Boolean r0 = r0.wifiOnly     // Catch:{ Exception -> 0x0574 }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x0574 }
            if (r0 == 0) goto L_0x02ff
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0574 }
            r6 = 21
            if (r0 < r6) goto L_0x02fa
            com.facebook.react.bridge.ReactApplicationContext r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext     // Catch:{ Exception -> 0x0574 }
            com.facebook.react.bridge.ReactApplicationContext r6 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext     // Catch:{ Exception -> 0x0574 }
            java.lang.String r6 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r6)     // Catch:{ Exception -> 0x0574 }
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ Exception -> 0x0574 }
            android.net.Network[] r6 = r0.getAllNetworks()     // Catch:{ Exception -> 0x0574 }
            int r9 = r6.length     // Catch:{ Exception -> 0x0574 }
            r14 = r13
        L_0x02b5:
            if (r14 >= r9) goto L_0x02e5
            r15 = r6[r14]     // Catch:{ Exception -> 0x0574 }
            android.net.NetworkInfo r16 = r0.getNetworkInfo(r15)     // Catch:{ Exception -> 0x0574 }
            android.net.NetworkCapabilities r7 = r0.getNetworkCapabilities(r15)     // Catch:{ Exception -> 0x0574 }
            if (r7 == 0) goto L_0x02e1
            if (r16 != 0) goto L_0x02c6
            goto L_0x02e1
        L_0x02c6:
            boolean r16 = r16.isConnected()     // Catch:{ Exception -> 0x0574 }
            if (r16 != 0) goto L_0x02cd
            goto L_0x02e1
        L_0x02cd:
            boolean r7 = r7.hasTransport(r8)     // Catch:{ Exception -> 0x0574 }
            if (r7 == 0) goto L_0x02e1
            java.net.Proxy r0 = java.net.Proxy.NO_PROXY     // Catch:{ Exception -> 0x0574 }
            r5.proxy(r0)     // Catch:{ Exception -> 0x0574 }
            javax.net.SocketFactory r0 = r15.getSocketFactory()     // Catch:{ Exception -> 0x0574 }
            r5.socketFactory(r0)     // Catch:{ Exception -> 0x0574 }
            r0 = r8
            goto L_0x02e6
        L_0x02e1:
            int r14 = r14 + 1
            r7 = 2
            goto L_0x02b5
        L_0x02e5:
            r0 = r13
        L_0x02e6:
            if (r0 != 0) goto L_0x02ff
            java.lang.Object[] r0 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x0574 }
            java.lang.String r2 = "No available WiFi connections."
            r0[r13] = r2     // Catch:{ Exception -> 0x0574 }
            r0[r8] = r12     // Catch:{ Exception -> 0x0574 }
            r2 = 2
            r0[r2] = r12     // Catch:{ Exception -> 0x0574 }
            r1.invoke_callback(r0)     // Catch:{ Exception -> 0x0574 }
            r17.releaseTaskResource()     // Catch:{ Exception -> 0x0574 }
            return
        L_0x02fa:
            java.lang.String r0 = "ReactNativeBlobUtil: wifiOnly was set, but SDK < 21. wifiOnly was ignored."
            com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.emitWarningEvent(r0)     // Catch:{ Exception -> 0x0574 }
        L_0x02ff:
            okhttp3.Request$Builder r6 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x0574 }
            r6.<init>()     // Catch:{ Exception -> 0x0574 }
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x030f }
            java.lang.String r7 = r1.url     // Catch:{ MalformedURLException -> 0x030f }
            r0.<init>(r7)     // Catch:{ MalformedURLException -> 0x030f }
            r6.url((java.net.URL) r0)     // Catch:{ MalformedURLException -> 0x030f }
            goto L_0x0313
        L_0x030f:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0574 }
        L_0x0313:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0574 }
            r0.<init>()     // Catch:{ Exception -> 0x0574 }
            com.facebook.react.bridge.ReadableMap r7 = r1.headers     // Catch:{ Exception -> 0x0574 }
            if (r7 == 0) goto L_0x0365
            com.facebook.react.bridge.ReadableMapKeySetIterator r7 = r7.keySetIterator()     // Catch:{ Exception -> 0x0574 }
        L_0x0320:
            boolean r9 = r7.hasNextKey()     // Catch:{ Exception -> 0x0574 }
            if (r9 == 0) goto L_0x0365
            java.lang.String r9 = r7.nextKey()     // Catch:{ Exception -> 0x0574 }
            com.facebook.react.bridge.ReadableMap r14 = r1.headers     // Catch:{ Exception -> 0x0574 }
            java.lang.String r14 = r14.getString(r9)     // Catch:{ Exception -> 0x0574 }
            java.lang.String r15 = "RNFB-Response"
            boolean r15 = r9.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x0574 }
            if (r15 == 0) goto L_0x0352
            java.lang.String r9 = "base64"
            boolean r9 = r14.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x0574 }
            if (r9 == 0) goto L_0x0345
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r9 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseFormat.BASE64     // Catch:{ Exception -> 0x0574 }
            r1.responseFormat = r9     // Catch:{ Exception -> 0x0574 }
            goto L_0x0320
        L_0x0345:
            java.lang.String r9 = "utf8"
            boolean r9 = r14.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x0574 }
            if (r9 == 0) goto L_0x0320
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r9 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseFormat.UTF8     // Catch:{ Exception -> 0x0574 }
            r1.responseFormat = r9     // Catch:{ Exception -> 0x0574 }
            goto L_0x0320
        L_0x0352:
            java.util.Locale r15 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x0574 }
            java.lang.String r15 = r9.toLowerCase(r15)     // Catch:{ Exception -> 0x0574 }
            r6.header(r15, r14)     // Catch:{ Exception -> 0x0574 }
            java.util.Locale r15 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x0574 }
            java.lang.String r9 = r9.toLowerCase(r15)     // Catch:{ Exception -> 0x0574 }
            r0.put(r9, r14)     // Catch:{ Exception -> 0x0574 }
            goto L_0x0320
        L_0x0365:
            java.lang.String r7 = r1.method     // Catch:{ Exception -> 0x0574 }
            boolean r7 = r7.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0574 }
            java.lang.String r9 = "patch"
            java.lang.String r14 = "put"
            java.lang.String r15 = "content-type"
            if (r7 != 0) goto L_0x038a
            java.lang.String r7 = r1.method     // Catch:{ Exception -> 0x0574 }
            boolean r7 = r7.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x0574 }
            if (r7 != 0) goto L_0x038a
            java.lang.String r7 = r1.method     // Catch:{ Exception -> 0x0574 }
            boolean r7 = r7.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x0574 }
            if (r7 == 0) goto L_0x0384
            goto L_0x038a
        L_0x0384:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.WithoutBody     // Catch:{ Exception -> 0x0574 }
            r1.requestType = r2     // Catch:{ Exception -> 0x0574 }
            goto L_0x0410
        L_0x038a:
            java.lang.String r7 = r1.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r0, (java.lang.String) r4)     // Catch:{ Exception -> 0x0574 }
            java.util.Locale r13 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x0574 }
            java.lang.String r7 = r7.toLowerCase(r13)     // Catch:{ Exception -> 0x0574 }
            com.facebook.react.bridge.ReadableArray r13 = r1.rawRequestBodyArray     // Catch:{ Exception -> 0x0574 }
            if (r13 == 0) goto L_0x039d
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r13 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.Form     // Catch:{ Exception -> 0x0574 }
            r1.requestType = r13     // Catch:{ Exception -> 0x0574 }
            goto L_0x03b4
        L_0x039d:
            if (r7 == 0) goto L_0x03a5
            boolean r13 = r7.isEmpty()     // Catch:{ Exception -> 0x0574 }
            if (r13 == 0) goto L_0x03b4
        L_0x03a5:
            boolean r13 = r7.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x0574 }
            if (r13 != 0) goto L_0x03b0
            java.lang.String r13 = "application/octet-stream"
            r6.header(r4, r13)     // Catch:{ Exception -> 0x0574 }
        L_0x03b0:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r13 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.SingleFile     // Catch:{ Exception -> 0x0574 }
            r1.requestType = r13     // Catch:{ Exception -> 0x0574 }
        L_0x03b4:
            java.lang.String r13 = r1.rawRequestBody     // Catch:{ Exception -> 0x0574 }
            if (r13 == 0) goto L_0x0410
            java.lang.String r12 = "ReactNativeBlobUtil-file://"
            boolean r12 = r13.startsWith(r12)     // Catch:{ Exception -> 0x0574 }
            if (r12 != 0) goto L_0x040c
            java.lang.String r12 = r1.rawRequestBody     // Catch:{ Exception -> 0x0574 }
            java.lang.String r13 = "ReactNativeBlobUtil-content://"
            boolean r12 = r12.startsWith(r13)     // Catch:{ Exception -> 0x0574 }
            if (r12 == 0) goto L_0x03cb
            goto L_0x040c
        L_0x03cb:
            java.util.Locale r12 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x0574 }
            java.lang.String r12 = r7.toLowerCase(r12)     // Catch:{ Exception -> 0x0574 }
            boolean r12 = r12.contains(r2)     // Catch:{ Exception -> 0x0574 }
            if (r12 != 0) goto L_0x03eb
            java.util.Locale r12 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x0574 }
            java.lang.String r12 = r7.toLowerCase(r12)     // Catch:{ Exception -> 0x0574 }
            java.lang.String r13 = "application/octet"
            boolean r12 = r12.startsWith(r13)     // Catch:{ Exception -> 0x0574 }
            if (r12 == 0) goto L_0x03e6
            goto L_0x03eb
        L_0x03e6:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.AsIs     // Catch:{ Exception -> 0x0574 }
            r1.requestType = r2     // Catch:{ Exception -> 0x0574 }
            goto L_0x0410
        L_0x03eb:
            java.lang.String r2 = r7.replace(r2, r10)     // Catch:{ Exception -> 0x0574 }
            java.lang.String r7 = ";BASE64"
            java.lang.String r2 = r2.replace(r7, r10)     // Catch:{ Exception -> 0x0574 }
            boolean r7 = r0.containsKey(r15)     // Catch:{ Exception -> 0x0574 }
            if (r7 == 0) goto L_0x03fe
            r0.put(r15, r2)     // Catch:{ Exception -> 0x0574 }
        L_0x03fe:
            boolean r7 = r0.containsKey(r4)     // Catch:{ Exception -> 0x0574 }
            if (r7 == 0) goto L_0x0407
            r0.put(r4, r2)     // Catch:{ Exception -> 0x0574 }
        L_0x0407:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.SingleFile     // Catch:{ Exception -> 0x0574 }
            r1.requestType = r2     // Catch:{ Exception -> 0x0574 }
            goto L_0x0410
        L_0x040c:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.SingleFile     // Catch:{ Exception -> 0x0574 }
            r1.requestType = r2     // Catch:{ Exception -> 0x0574 }
        L_0x0410:
            java.lang.String r2 = "Transfer-Encoding"
            java.lang.String r2 = r1.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x0574 }
            java.lang.String r4 = "chunked"
            boolean r2 = r2.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0574 }
            int[] r4 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.AnonymousClass6.$SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r7 = r1.requestType     // Catch:{ Exception -> 0x0574 }
            int r7 = r7.ordinal()     // Catch:{ Exception -> 0x0574 }
            r4 = r4[r7]     // Catch:{ Exception -> 0x0574 }
            if (r4 == r8) goto L_0x04dc
            r7 = 2
            if (r4 == r7) goto L_0x04b1
            if (r4 == r11) goto L_0x0462
            r0 = 4
            if (r4 == r0) goto L_0x0432
            goto L_0x0506
        L_0x0432:
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x0574 }
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0574 }
            if (r0 != 0) goto L_0x0453
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x0574 }
            boolean r0 = r0.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x0574 }
            if (r0 != 0) goto L_0x0453
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x0574 }
            boolean r0 = r0.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x0574 }
            if (r0 == 0) goto L_0x044b
            goto L_0x0453
        L_0x044b:
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x0574 }
            r2 = 0
            r6.method(r0, r2)     // Catch:{ Exception -> 0x0574 }
            goto L_0x0506
        L_0x0453:
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x0574 }
            r2 = 0
            byte[] r3 = new byte[r2]     // Catch:{ Exception -> 0x0574 }
            r2 = 0
            okhttp3.RequestBody r2 = okhttp3.RequestBody.create((okhttp3.MediaType) r2, (byte[]) r3)     // Catch:{ Exception -> 0x0574 }
            r6.method(r0, r2)     // Catch:{ Exception -> 0x0574 }
            goto L_0x0506
        L_0x0462:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0574 }
            r0.<init>()     // Catch:{ Exception -> 0x0574 }
            java.lang.String r3 = "ReactNativeBlobUtil-"
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x0574 }
            java.lang.String r3 = r1.taskId     // Catch:{ Exception -> 0x0574 }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x0574 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r3 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilBody     // Catch:{ Exception -> 0x0574 }
            java.lang.String r4 = r1.taskId     // Catch:{ Exception -> 0x0574 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r3.chunkedEncoding(r2)     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r3 = r1.requestType     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setRequestType(r3)     // Catch:{ Exception -> 0x0574 }
            com.facebook.react.bridge.ReadableArray r3 = r1.rawRequestBodyArray     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setBody((com.facebook.react.bridge.ReadableArray) r3)     // Catch:{ Exception -> 0x0574 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0574 }
            r3.<init>()     // Catch:{ Exception -> 0x0574 }
            java.lang.String r4 = "multipart/form-data; boundary="
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x0574 }
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ Exception -> 0x0574 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0574 }
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r0 = r2.setMIME(r0)     // Catch:{ Exception -> 0x0574 }
            r1.requestBody = r0     // Catch:{ Exception -> 0x0574 }
            java.lang.String r2 = r1.method     // Catch:{ Exception -> 0x0574 }
            r6.method(r2, r0)     // Catch:{ Exception -> 0x0574 }
            goto L_0x0506
        L_0x04b1:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r3 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilBody     // Catch:{ Exception -> 0x0574 }
            java.lang.String r4 = r1.taskId     // Catch:{ Exception -> 0x0574 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r3.chunkedEncoding(r2)     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r3 = r1.requestType     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setRequestType(r3)     // Catch:{ Exception -> 0x0574 }
            java.lang.String r3 = r1.rawRequestBody     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setBody((java.lang.String) r3)     // Catch:{ Exception -> 0x0574 }
            java.lang.String r0 = r1.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r0, (java.lang.String) r15)     // Catch:{ Exception -> 0x0574 }
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r0 = r2.setMIME(r0)     // Catch:{ Exception -> 0x0574 }
            r1.requestBody = r0     // Catch:{ Exception -> 0x0574 }
            java.lang.String r2 = r1.method     // Catch:{ Exception -> 0x0574 }
            r6.method(r2, r0)     // Catch:{ Exception -> 0x0574 }
            goto L_0x0506
        L_0x04dc:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r3 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilBody     // Catch:{ Exception -> 0x0574 }
            java.lang.String r4 = r1.taskId     // Catch:{ Exception -> 0x0574 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r3.chunkedEncoding(r2)     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r3 = r1.requestType     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setRequestType(r3)     // Catch:{ Exception -> 0x0574 }
            java.lang.String r3 = r1.rawRequestBody     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setBody((java.lang.String) r3)     // Catch:{ Exception -> 0x0574 }
            java.lang.String r0 = r1.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r0, (java.lang.String) r15)     // Catch:{ Exception -> 0x0574 }
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r0 = r2.setMIME(r0)     // Catch:{ Exception -> 0x0574 }
            r1.requestBody = r0     // Catch:{ Exception -> 0x0574 }
            java.lang.String r2 = r1.method     // Catch:{ Exception -> 0x0574 }
            r6.method(r2, r0)     // Catch:{ Exception -> 0x0574 }
        L_0x0506:
            okhttp3.Request r0 = r6.build()     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$3 r2 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$3     // Catch:{ Exception -> 0x0574 }
            r2.<init>()     // Catch:{ Exception -> 0x0574 }
            r5.addNetworkInterceptor(r2)     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$4 r2 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$4     // Catch:{ Exception -> 0x0574 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0574 }
            r5.addInterceptor(r2)     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r2 = r1.options     // Catch:{ Exception -> 0x0574 }
            long r2 = r2.timeout     // Catch:{ Exception -> 0x0574 }
            r6 = 0
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x0536
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r2 = r1.options     // Catch:{ Exception -> 0x0574 }
            long r2 = r2.timeout     // Catch:{ Exception -> 0x0574 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0574 }
            r5.connectTimeout(r2, r4)     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r2 = r1.options     // Catch:{ Exception -> 0x0574 }
            long r2 = r2.timeout     // Catch:{ Exception -> 0x0574 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0574 }
            r5.readTimeout(r2, r4)     // Catch:{ Exception -> 0x0574 }
        L_0x0536:
            okhttp3.ConnectionPool r2 = pool     // Catch:{ Exception -> 0x0574 }
            r5.connectionPool(r2)     // Catch:{ Exception -> 0x0574 }
            r2 = 0
            r5.retryOnConnectionFailure(r2)     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r2 = r1.options     // Catch:{ Exception -> 0x0574 }
            java.lang.Boolean r2 = r2.followRedirect     // Catch:{ Exception -> 0x0574 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0574 }
            r5.followRedirects(r2)     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r2 = r1.options     // Catch:{ Exception -> 0x0574 }
            java.lang.Boolean r2 = r2.followRedirect     // Catch:{ Exception -> 0x0574 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0574 }
            r5.followSslRedirects(r2)     // Catch:{ Exception -> 0x0574 }
            r5.retryOnConnectionFailure(r8)     // Catch:{ Exception -> 0x0574 }
            okhttp3.OkHttpClient$Builder r2 = enableTls12OnPreLollipop(r5)     // Catch:{ Exception -> 0x0574 }
            okhttp3.OkHttpClient r2 = r2.build()     // Catch:{ Exception -> 0x0574 }
            okhttp3.Call r0 = r2.newCall(r0)     // Catch:{ Exception -> 0x0574 }
            java.util.HashMap<java.lang.String, okhttp3.Call> r2 = taskTable     // Catch:{ Exception -> 0x0574 }
            java.lang.String r3 = r1.taskId     // Catch:{ Exception -> 0x0574 }
            r2.put(r3, r0)     // Catch:{ Exception -> 0x0574 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$5 r2 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$5     // Catch:{ Exception -> 0x0574 }
            r2.<init>()     // Catch:{ Exception -> 0x0574 }
            r0.enqueue(r2)     // Catch:{ Exception -> 0x0574 }
            goto L_0x05a2
        L_0x0574:
            r0 = move-exception
            r0.printStackTrace()
            r17.releaseTaskResource()
            java.lang.Object[] r2 = new java.lang.Object[r8]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "ReactNativeBlobUtil request error: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = r0.getMessage()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.Throwable r0 = r0.getCause()
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            r3 = 0
            r2[r3] = r0
            r1.invoke_callback(r2)
        L_0x05a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.run():void");
    }

    /* renamed from: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType;
        static final /* synthetic */ int[] $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        static {
            /*
                com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseType[] r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType = r0
                r1 = 1
                com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseType r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseType.KeepInMemory     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseType r3 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseType.FileStorage     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType[] r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType = r2
                com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r3 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.SingleFile     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.AsIs     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r1 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.Form     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType     // Catch:{ NoSuchFieldError -> 0x004e }
                com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r1 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.WithoutBody     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.AnonymousClass6.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void releaseTaskResource() {
        if (taskTable.containsKey(this.taskId)) {
            taskTable.remove(this.taskId);
        }
        if (androidDownloadManagerTaskTable.containsKey(this.taskId)) {
            androidDownloadManagerTaskTable.remove(this.taskId);
        }
        if (uploadProgressReport.containsKey(this.taskId)) {
            uploadProgressReport.remove(this.taskId);
        }
        if (progressReport.containsKey(this.taskId)) {
            progressReport.remove(this.taskId);
        }
        ReactNativeBlobUtilBody reactNativeBlobUtilBody = this.requestBody;
        if (reactNativeBlobUtilBody != null) {
            reactNativeBlobUtilBody.clearRequestBody();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:80|81|82|83|(1:85)(1:86)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x006c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:82:0x0217 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x021d A[Catch:{ IOException -> 0x024a }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0234 A[Catch:{ IOException -> 0x024a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void done(okhttp3.Response r15) {
        /*
            r14 = this;
            boolean r0 = r14.isBlobResponse(r15)
            com.facebook.react.bridge.WritableMap r1 = r14.getResponseInfo(r15, r0)
            com.facebook.react.bridge.WritableMap r2 = r1.copy()
            r14.emitStateEvent(r2)
            com.facebook.react.bridge.WritableMap r2 = r14.getResponseInfo(r15, r0)
            r14.emitStateEvent(r2)
            int[] r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.AnonymousClass6.$SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseType r3 = r14.responseType
            int r3 = r3.ordinal()
            r2 = r2[r3]
            java.lang.String r3 = "UTF-8"
            java.lang.String r4 = ""
            java.lang.String r5 = "?append=true"
            java.lang.String r6 = "path"
            java.lang.String r7 = "utf8"
            r8 = 4
            r9 = 3
            r10 = 0
            r11 = 0
            r12 = 2
            r13 = 1
            if (r2 == r13) goto L_0x0103
            if (r2 == r12) goto L_0x0065
            java.lang.Object[] r0 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x0054 }
            r0[r11] = r10     // Catch:{ IOException -> 0x0054 }
            r0[r13] = r7     // Catch:{ IOException -> 0x0054 }
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x0054 }
            okhttp3.ResponseBody r4 = r15.body()     // Catch:{ IOException -> 0x0054 }
            byte[] r4 = r4.bytes()     // Catch:{ IOException -> 0x0054 }
            r2.<init>(r4, r3)     // Catch:{ IOException -> 0x0054 }
            r0[r12] = r2     // Catch:{ IOException -> 0x0054 }
            com.facebook.react.bridge.WritableMap r2 = r1.copy()     // Catch:{ IOException -> 0x0054 }
            r0[r9] = r2     // Catch:{ IOException -> 0x0054 }
            r14.invoke_callback(r0)     // Catch:{ IOException -> 0x0054 }
            goto L_0x0259
        L_0x0054:
            java.lang.Object[] r0 = new java.lang.Object[r12]
            java.lang.String r2 = "ReactNativeBlobUtil failed to encode response data to UTF8 string."
            r0[r11] = r2
            com.facebook.react.bridge.WritableMap r1 = r1.copy()
            r0[r13] = r1
            r14.invoke_callback(r0)
            goto L_0x0259
        L_0x0065:
            okhttp3.ResponseBody r0 = r15.body()
            r0.bytes()     // Catch:{ Exception -> 0x006c }
        L_0x006c:
            com.ReactNativeBlobUtil.Response.ReactNativeBlobUtilFileResp r0 = (com.ReactNativeBlobUtil.Response.ReactNativeBlobUtilFileResp) r0     // Catch:{ ClassCastException -> 0x00a2 }
            if (r0 == 0) goto L_0x0087
            boolean r0 = r0.isDownloadComplete()
            if (r0 != 0) goto L_0x0087
            java.lang.Object[] r0 = new java.lang.Object[r12]
            java.lang.String r2 = "Download interrupted."
            r0[r11] = r2
            com.facebook.react.bridge.WritableMap r1 = r1.copy()
            r0[r13] = r1
            r14.invoke_callback(r0)
            goto L_0x0259
        L_0x0087:
            java.lang.String r0 = r14.destPath
            java.lang.String r0 = r0.replace(r5, r4)
            r14.destPath = r0
            java.lang.Object[] r2 = new java.lang.Object[r8]
            r2[r11] = r10
            r2[r13] = r6
            r2[r12] = r0
            com.facebook.react.bridge.WritableMap r0 = r1.copy()
            r2[r9] = r0
            r14.invoke_callback(r2)
            goto L_0x0259
        L_0x00a2:
            if (r0 == 0) goto L_0x00f3
            okio.BufferedSource r15 = r0.source()     // Catch:{ IOException -> 0x00ce }
            okio.Buffer r15 = r15.buffer()     // Catch:{ IOException -> 0x00ce }
            long r2 = r15.size()     // Catch:{ IOException -> 0x00ce }
            r4 = 0
            int r15 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r15 <= 0) goto L_0x00b8
            r15 = r13
            goto L_0x00b9
        L_0x00b8:
            r15 = r11
        L_0x00b9:
            long r2 = r0.contentLength()     // Catch:{ IOException -> 0x00ce }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x00c3
            r2 = r13
            goto L_0x00c4
        L_0x00c3:
            r2 = r11
        L_0x00c4:
            if (r15 == 0) goto L_0x00d2
            if (r2 == 0) goto L_0x00d2
            java.lang.String r15 = r0.string()     // Catch:{ IOException -> 0x00ce }
            r10 = r15
            goto L_0x00d2
        L_0x00ce:
            r15 = move-exception
            r15.printStackTrace()
        L_0x00d2:
            java.lang.Object[] r15 = new java.lang.Object[r12]
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Unexpected FileStorage response file: "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r0 = r0.toString()
            r15[r11] = r0
            com.facebook.react.bridge.WritableMap r0 = r1.copy()
            r15[r13] = r0
            r14.invoke_callback(r15)
            goto L_0x0102
        L_0x00f3:
            java.lang.Object[] r15 = new java.lang.Object[r12]
            java.lang.String r0 = "Unexpected FileStorage response with no file."
            r15[r11] = r0
            com.facebook.react.bridge.WritableMap r0 = r1.copy()
            r15[r13] = r0
            r14.invoke_callback(r15)
        L_0x0102:
            return
        L_0x0103:
            if (r0 == 0) goto L_0x0152
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r14.options     // Catch:{ IOException -> 0x024a }
            java.lang.Boolean r0 = r0.auto     // Catch:{ IOException -> 0x024a }
            boolean r0 = r0.booleanValue()     // Catch:{ IOException -> 0x024a }
            if (r0 == 0) goto L_0x0152
            java.lang.String r0 = r14.taskId     // Catch:{ IOException -> 0x024a }
            java.lang.String r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.getTmpPath(r0)     // Catch:{ IOException -> 0x024a }
            okhttp3.ResponseBody r2 = r15.body()     // Catch:{ IOException -> 0x024a }
            java.io.InputStream r2 = r2.byteStream()     // Catch:{ IOException -> 0x024a }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x024a }
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x024a }
            r4.<init>(r0)     // Catch:{ IOException -> 0x024a }
            r3.<init>(r4)     // Catch:{ IOException -> 0x024a }
            r4 = 10240(0x2800, float:1.4349E-41)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x024a }
        L_0x012b:
            int r5 = r2.read(r4)     // Catch:{ IOException -> 0x024a }
            r7 = -1
            if (r5 == r7) goto L_0x0136
            r3.write(r4, r11, r5)     // Catch:{ IOException -> 0x024a }
            goto L_0x012b
        L_0x0136:
            r2.close()     // Catch:{ IOException -> 0x024a }
            r3.flush()     // Catch:{ IOException -> 0x024a }
            r3.close()     // Catch:{ IOException -> 0x024a }
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x024a }
            r2[r11] = r10     // Catch:{ IOException -> 0x024a }
            r2[r13] = r6     // Catch:{ IOException -> 0x024a }
            r2[r12] = r0     // Catch:{ IOException -> 0x024a }
            com.facebook.react.bridge.WritableMap r0 = r1.copy()     // Catch:{ IOException -> 0x024a }
            r2[r9] = r0     // Catch:{ IOException -> 0x024a }
            r14.invoke_callback(r2)     // Catch:{ IOException -> 0x024a }
            goto L_0x0259
        L_0x0152:
            okhttp3.ResponseBody r0 = r15.body()     // Catch:{ IOException -> 0x024a }
            byte[] r0 = r0.bytes()     // Catch:{ IOException -> 0x024a }
            boolean r2 = r14.shouldTransformFile()     // Catch:{ IOException -> 0x024a }
            if (r2 == 0) goto L_0x01d9
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ IOException -> 0x024a }
            if (r2 == 0) goto L_0x01d1
            java.lang.String r2 = r14.destPath     // Catch:{ IOException -> 0x024a }
            java.lang.String r2 = r2.replace(r5, r4)     // Catch:{ IOException -> 0x024a }
            r14.destPath = r2     // Catch:{ IOException -> 0x024a }
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x024a }
            java.lang.String r3 = r14.destPath     // Catch:{ IOException -> 0x024a }
            r2.<init>(r3)     // Catch:{ IOException -> 0x024a }
            boolean r3 = r2.exists()     // Catch:{ IOException -> 0x024a }
            if (r3 != 0) goto L_0x017c
            r2.createNewFile()     // Catch:{ IOException -> 0x024a }
        L_0x017c:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x01ab }
            r3.<init>(r2)     // Catch:{ Exception -> 0x01ab }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ all -> 0x01a1 }
            byte[] r0 = r2.onWriteFile(r0)     // Catch:{ all -> 0x01a1 }
            r3.write(r0)     // Catch:{ all -> 0x01a1 }
            r3.close()     // Catch:{ Exception -> 0x01ab }
            java.lang.Object[] r0 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x024a }
            r0[r11] = r10     // Catch:{ IOException -> 0x024a }
            r0[r13] = r6     // Catch:{ IOException -> 0x024a }
            java.lang.String r2 = r14.destPath     // Catch:{ IOException -> 0x024a }
            r0[r12] = r2     // Catch:{ IOException -> 0x024a }
            com.facebook.react.bridge.WritableMap r2 = r1.copy()     // Catch:{ IOException -> 0x024a }
            r0[r9] = r2     // Catch:{ IOException -> 0x024a }
            r14.invoke_callback(r0)     // Catch:{ IOException -> 0x024a }
            return
        L_0x01a1:
            r0 = move-exception
            r3.close()     // Catch:{ all -> 0x01a6 }
            goto L_0x01aa
        L_0x01a6:
            r2 = move-exception
            r0.addSuppressed(r2)     // Catch:{ Exception -> 0x01ab }
        L_0x01aa:
            throw r0     // Catch:{ Exception -> 0x01ab }
        L_0x01ab:
            r0 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r12]     // Catch:{ IOException -> 0x024a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x024a }
            r3.<init>()     // Catch:{ IOException -> 0x024a }
            java.lang.String r4 = "Error from file transformer:"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IOException -> 0x024a }
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ IOException -> 0x024a }
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ IOException -> 0x024a }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x024a }
            r2[r11] = r0     // Catch:{ IOException -> 0x024a }
            com.facebook.react.bridge.WritableMap r0 = r1.copy()     // Catch:{ IOException -> 0x024a }
            r2[r13] = r0     // Catch:{ IOException -> 0x024a }
            r14.invoke_callback(r2)     // Catch:{ IOException -> 0x024a }
            return
        L_0x01d1:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x024a }
            java.lang.String r2 = "Write file with transform was specified but the shared file transformer is not set"
            r0.<init>(r2)     // Catch:{ IOException -> 0x024a }
            throw r0     // Catch:{ IOException -> 0x024a }
        L_0x01d9:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r2 = r14.responseFormat     // Catch:{ IOException -> 0x024a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r4 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseFormat.BASE64     // Catch:{ IOException -> 0x024a }
            java.lang.String r5 = "base64"
            if (r2 != r4) goto L_0x01f7
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x024a }
            r2[r11] = r10     // Catch:{ IOException -> 0x024a }
            r2[r13] = r5     // Catch:{ IOException -> 0x024a }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r12)     // Catch:{ IOException -> 0x024a }
            r2[r12] = r0     // Catch:{ IOException -> 0x024a }
            com.facebook.react.bridge.WritableMap r0 = r1.copy()     // Catch:{ IOException -> 0x024a }
            r2[r9] = r0     // Catch:{ IOException -> 0x024a }
            r14.invoke_callback(r2)     // Catch:{ IOException -> 0x024a }
            return
        L_0x01f7:
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r3)     // Catch:{ CharacterCodingException -> 0x0217 }
            java.nio.charset.CharsetDecoder r3 = r2.newDecoder()     // Catch:{ CharacterCodingException -> 0x0217 }
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.wrap(r0)     // Catch:{ CharacterCodingException -> 0x0217 }
            r3.decode(r4)     // Catch:{ CharacterCodingException -> 0x0217 }
            java.lang.String r3 = new java.lang.String     // Catch:{ CharacterCodingException -> 0x0217 }
            r3.<init>(r0, r2)     // Catch:{ CharacterCodingException -> 0x0217 }
            java.lang.Object[] r2 = new java.lang.Object[r9]     // Catch:{ CharacterCodingException -> 0x0217 }
            r2[r11] = r10     // Catch:{ CharacterCodingException -> 0x0217 }
            r2[r13] = r7     // Catch:{ CharacterCodingException -> 0x0217 }
            r2[r12] = r3     // Catch:{ CharacterCodingException -> 0x0217 }
            r14.invoke_callback(r2)     // Catch:{ CharacterCodingException -> 0x0217 }
            goto L_0x0259
        L_0x0217:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r2 = r14.responseFormat     // Catch:{ IOException -> 0x024a }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r3 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseFormat.UTF8     // Catch:{ IOException -> 0x024a }
            if (r2 != r3) goto L_0x0234
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x024a }
            r2.<init>(r0)     // Catch:{ IOException -> 0x024a }
            java.lang.Object[] r0 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x024a }
            r0[r11] = r10     // Catch:{ IOException -> 0x024a }
            r0[r13] = r7     // Catch:{ IOException -> 0x024a }
            r0[r12] = r2     // Catch:{ IOException -> 0x024a }
            com.facebook.react.bridge.WritableMap r2 = r1.copy()     // Catch:{ IOException -> 0x024a }
            r0[r9] = r2     // Catch:{ IOException -> 0x024a }
            r14.invoke_callback(r0)     // Catch:{ IOException -> 0x024a }
            goto L_0x0259
        L_0x0234:
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x024a }
            r2[r11] = r10     // Catch:{ IOException -> 0x024a }
            r2[r13] = r5     // Catch:{ IOException -> 0x024a }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r12)     // Catch:{ IOException -> 0x024a }
            r2[r12] = r0     // Catch:{ IOException -> 0x024a }
            com.facebook.react.bridge.WritableMap r0 = r1.copy()     // Catch:{ IOException -> 0x024a }
            r2[r9] = r0     // Catch:{ IOException -> 0x024a }
            r14.invoke_callback(r2)     // Catch:{ IOException -> 0x024a }
            goto L_0x0259
        L_0x024a:
            java.lang.Object[] r0 = new java.lang.Object[r12]
            java.lang.String r2 = "ReactNativeBlobUtil failed to encode response data to BASE64 string."
            r0[r11] = r2
            com.facebook.react.bridge.WritableMap r1 = r1.copy()
            r0[r13] = r1
            r14.invoke_callback(r0)
        L_0x0259:
            okhttp3.ResponseBody r15 = r15.body()
            r15.close()
            r14.releaseTaskResource()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.done(okhttp3.Response):void");
    }

    public static ReactNativeBlobUtilProgressConfig getReportProgress(String str) {
        if (!progressReport.containsKey(str)) {
            return null;
        }
        return progressReport.get(str);
    }

    public static ReactNativeBlobUtilProgressConfig getReportUploadProgress(String str) {
        if (!uploadProgressReport.containsKey(str)) {
            return null;
        }
        return uploadProgressReport.get(str);
    }

    private WritableMap getResponseInfo(Response response, boolean z) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("status", response.code());
        createMap.putString("state", ExifInterface.GPS_MEASUREMENT_2D);
        createMap.putString("taskId", this.taskId);
        createMap.putBoolean(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, this.timeout);
        WritableMap createMap2 = Arguments.createMap();
        for (int i = 0; i < response.headers().size(); i++) {
            createMap2.putString(response.headers().name(i), response.headers().value(i));
        }
        WritableArray createArray = Arguments.createArray();
        Iterator<String> it = this.redirects.iterator();
        while (it.hasNext()) {
            createArray.pushString(it.next());
        }
        createMap.putArray("redirects", createArray);
        createMap.putMap("headers", createMap2);
        Headers headers2 = response.headers();
        if (z) {
            createMap.putString("respType", "blob");
        } else if (getHeaderIgnoreCases(headers2, "content-type").equalsIgnoreCase("text/")) {
            createMap.putString("respType", "text");
        } else if (getHeaderIgnoreCases(headers2, "content-type").contains("application/json")) {
            createMap.putString("respType", "json");
        } else {
            createMap.putString("respType", "");
        }
        return createMap;
    }

    private boolean isBlobResponse(Response response) {
        boolean z;
        String headerIgnoreCases = getHeaderIgnoreCases(response.headers(), "Content-Type");
        boolean z2 = !headerIgnoreCases.equalsIgnoreCase("text/");
        boolean z3 = !headerIgnoreCases.equalsIgnoreCase("application/json");
        if (this.options.binaryContentTypes != null) {
            int i = 0;
            while (true) {
                if (i >= this.options.binaryContentTypes.size()) {
                    break;
                } else if (headerIgnoreCases.toLowerCase(Locale.ROOT).contains(this.options.binaryContentTypes.getString(i).toLowerCase(Locale.ROOT))) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        z = false;
        if ((z3 || z2) && !z) {
            return false;
        }
        return true;
    }

    private String getHeaderIgnoreCases(Headers headers2, String str) {
        String str2 = headers2.get(str);
        if (str2 != null) {
            return str2;
        }
        return headers2.get(str.toLowerCase(Locale.ROOT)) == null ? "" : headers2.get(str.toLowerCase(Locale.ROOT));
    }

    private String getHeaderIgnoreCases(HashMap<String, String> hashMap, String str) {
        String str2 = hashMap.get(str);
        if (str2 != null) {
            return str2;
        }
        String str3 = hashMap.get(str.toLowerCase(Locale.ROOT));
        return str3 == null ? "" : str3;
    }

    private void emitStateEvent(WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilImpl.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_HTTP_STATE, writableMap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f2 A[SYNTHETIC, Splitter:B:28:0x00f2] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x012c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r14, android.content.Intent r15) {
        /*
            r13 = this;
            java.lang.String r14 = r15.getAction()
            java.lang.String r0 = "android.intent.action.DOWNLOAD_COMPLETE"
            boolean r14 = r0.equals(r14)
            if (r14 == 0) goto L_0x0191
            com.facebook.react.bridge.ReactApplicationContext r14 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext
            android.content.Context r14 = r14.getApplicationContext()
            android.os.Bundle r15 = r15.getExtras()
            java.lang.String r0 = "extra_download_id"
            long r0 = r15.getLong(r0)
            long r2 = r13.downloadManagerId
            int r15 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r15 != 0) goto L_0x0191
            r13.releaseTaskResource()
            android.app.DownloadManager$Query r15 = new android.app.DownloadManager$Query
            r15.<init>()
            r0 = 1
            long[] r1 = new long[r0]
            long r2 = r13.downloadManagerId
            r4 = 0
            r1[r4] = r2
            r15.setFilterById(r1)
            java.lang.String r1 = "download"
            java.lang.Object r1 = r14.getSystemService(r1)
            android.app.DownloadManager r1 = (android.app.DownloadManager) r1
            r1.query(r15)
            android.database.Cursor r15 = r1.query(r15)
            java.lang.String r2 = "Download manager failed to download from  "
            r3 = 3
            r5 = 2
            r6 = 0
            if (r15 != 0) goto L_0x0070
            java.lang.Object[] r14 = new java.lang.Object[r3]
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.StringBuilder r15 = r15.append(r2)
            java.lang.String r1 = r13.url
            java.lang.StringBuilder r15 = r15.append(r1)
            java.lang.String r1 = ". Query was unsuccessful "
            java.lang.StringBuilder r15 = r15.append(r1)
            java.lang.String r15 = r15.toString()
            r14[r4] = r15
            r14[r0] = r6
            r14[r5] = r6
            r13.invoke_callback(r14)
            return
        L_0x0070:
            boolean r7 = r15.moveToFirst()     // Catch:{ all -> 0x018a }
            if (r7 == 0) goto L_0x00e0
            java.lang.String r7 = "status"
            int r7 = r15.getColumnIndex(r7)     // Catch:{ all -> 0x018a }
            int r7 = r15.getInt(r7)     // Catch:{ all -> 0x018a }
            r8 = 16
            if (r7 != r8) goto L_0x00b2
            java.lang.Object[] r14 = new java.lang.Object[r3]     // Catch:{ all -> 0x018a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x018a }
            r1.<init>()     // Catch:{ all -> 0x018a }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x018a }
            java.lang.String r2 = r13.url     // Catch:{ all -> 0x018a }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x018a }
            java.lang.String r2 = ". Status Code = "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x018a }
            java.lang.StringBuilder r1 = r1.append(r7)     // Catch:{ all -> 0x018a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x018a }
            r14[r4] = r1     // Catch:{ all -> 0x018a }
            r14[r0] = r6     // Catch:{ all -> 0x018a }
            r14[r5] = r6     // Catch:{ all -> 0x018a }
            r13.invoke_callback(r14)     // Catch:{ all -> 0x018a }
            if (r15 == 0) goto L_0x00b1
            r15.close()
        L_0x00b1:
            return
        L_0x00b2:
            java.lang.String r2 = "local_uri"
            int r2 = r15.getColumnIndex(r2)     // Catch:{ all -> 0x018a }
            java.lang.String r2 = r15.getString(r2)     // Catch:{ all -> 0x018a }
            if (r2 == 0) goto L_0x00e0
            android.net.Uri r8 = android.net.Uri.parse(r2)     // Catch:{ all -> 0x018a }
            android.content.ContentResolver r7 = r14.getContentResolver()     // Catch:{ all -> 0x018a }
            java.lang.String r14 = "_data"
            java.lang.String[] r9 = new java.lang.String[]{r14}     // Catch:{ all -> 0x018a }
            r10 = 0
            r11 = 0
            r12 = 0
            android.database.Cursor r14 = r7.query(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x018a }
            if (r14 == 0) goto L_0x00e0
            r14.moveToFirst()     // Catch:{ all -> 0x018a }
            java.lang.String r2 = r14.getString(r4)     // Catch:{ all -> 0x018a }
            r14.close()     // Catch:{ all -> 0x018a }
            goto L_0x00e1
        L_0x00e0:
            r2 = r6
        L_0x00e1:
            if (r15 == 0) goto L_0x00e6
            r15.close()
        L_0x00e6:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r14 = r13.options
            com.facebook.react.bridge.ReadableMap r14 = r14.addAndroidDownloads
            java.lang.String r15 = "path"
            boolean r14 = r14.hasKey(r15)
            if (r14 == 0) goto L_0x012c
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r14 = r13.options     // Catch:{ Exception -> 0x011a }
            com.facebook.react.bridge.ReadableMap r14 = r14.addAndroidDownloads     // Catch:{ Exception -> 0x011a }
            java.lang.String r14 = r14.getString(r15)     // Catch:{ Exception -> 0x011a }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x011a }
            r1.<init>(r14)     // Catch:{ Exception -> 0x011a }
            boolean r1 = r1.exists()     // Catch:{ Exception -> 0x011a }
            if (r1 == 0) goto L_0x0112
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x011a }
            r1[r4] = r6     // Catch:{ Exception -> 0x011a }
            r1[r0] = r15     // Catch:{ Exception -> 0x011a }
            r1[r5] = r14     // Catch:{ Exception -> 0x011a }
            r13.invoke_callback(r1)     // Catch:{ Exception -> 0x011a }
            goto L_0x0191
        L_0x0112:
            java.lang.Exception r14 = new java.lang.Exception     // Catch:{ Exception -> 0x011a }
            java.lang.String r15 = "Download manager download failed, the file does not downloaded to destination."
            r14.<init>(r15)     // Catch:{ Exception -> 0x011a }
            throw r14     // Catch:{ Exception -> 0x011a }
        L_0x011a:
            r14 = move-exception
            r14.printStackTrace()
            java.lang.Object[] r15 = new java.lang.Object[r5]
            java.lang.String r14 = r14.getLocalizedMessage()
            r15[r4] = r14
            r15[r0] = r6
            r13.invoke_callback(r15)
            goto L_0x0191
        L_0x012c:
            int r14 = android.os.Build.VERSION.SDK_INT
            r7 = 29
            if (r14 < r7) goto L_0x016e
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r14 = r13.options
            com.facebook.react.bridge.ReadableMap r14 = r14.addAndroidDownloads
            java.lang.String r7 = "storeInDownloads"
            boolean r14 = r14.hasKey(r7)
            if (r14 == 0) goto L_0x016e
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r14 = r13.options
            com.facebook.react.bridge.ReadableMap r14 = r14.addAndroidDownloads
            boolean r14 = r14.getBoolean(r7)
            if (r14 == 0) goto L_0x016e
            long r7 = r13.downloadManagerId
            android.net.Uri r14 = r1.getUriForDownloadedFile(r7)
            if (r14 != 0) goto L_0x015e
            java.lang.Object[] r14 = new java.lang.Object[r3]
            java.lang.String r1 = "Download manager could not resolve downloaded file uri."
            r14[r4] = r1
            r14[r0] = r15
            r14[r5] = r6
            r13.invoke_callback(r14)
            goto L_0x0191
        L_0x015e:
            java.lang.Object[] r1 = new java.lang.Object[r3]
            r1[r4] = r6
            r1[r0] = r15
            java.lang.String r14 = r14.toString()
            r1[r5] = r14
            r13.invoke_callback(r1)
            goto L_0x0191
        L_0x016e:
            if (r2 != 0) goto L_0x017e
            java.lang.Object[] r14 = new java.lang.Object[r3]
            java.lang.String r1 = "Download manager could not resolve downloaded file path."
            r14[r4] = r1
            r14[r0] = r15
            r14[r5] = r6
            r13.invoke_callback(r14)
            goto L_0x0191
        L_0x017e:
            java.lang.Object[] r14 = new java.lang.Object[r3]
            r14[r4] = r6
            r14[r0] = r15
            r14[r5] = r2
            r13.invoke_callback(r14)
            goto L_0x0191
        L_0x018a:
            r14 = move-exception
            if (r15 == 0) goto L_0x0190
            r15.close()
        L_0x0190:
            throw r14
        L_0x0191:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.onReceive(android.content.Context, android.content.Intent):void");
    }

    public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder builder) {
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19) {
            try {
                SSLContext instance = SSLContext.getInstance("TLSv1.2");
                instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
                builder.sslSocketFactory(new Tls12SocketFactory(instance.getSocketFactory()));
                ConnectionSpec build = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(TlsVersion.TLS_1_2).build();
                ArrayList arrayList = new ArrayList();
                arrayList.add(build);
                arrayList.add(ConnectionSpec.COMPATIBLE_TLS);
                arrayList.add(ConnectionSpec.CLEARTEXT);
                builder.connectionSpecs(arrayList);
            } catch (Exception e) {
                FLog.e("OkHttpTLSCompat", "Error while setting TLS 1.2", (Throwable) e);
            }
        }
        return builder;
    }
}
