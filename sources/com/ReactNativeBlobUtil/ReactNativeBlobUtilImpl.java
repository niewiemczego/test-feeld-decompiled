package com.ReactNativeBlobUtil;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.content.FileProvider;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilMediaCollection;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilProgressConfig;
import com.ReactNativeBlobUtil.Utils.FileDescription;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.network.CookieJarContainer;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.modules.network.OkHttpClientProvider;
import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

class ReactNativeBlobUtilImpl {
    /* access modifiers changed from: private */
    public static boolean ActionViewVisible = false;
    public static final String NAME = "ReactNativeBlobUtil";
    static ReactApplicationContext RCTContext;
    static LinkedBlockingQueue<Runnable> fsTaskQueue = new LinkedBlockingQueue<>();
    private static final ThreadPoolExecutor fsThreadPool;
    /* access modifiers changed from: private */
    public static final SparseArray<Promise> promiseTable = new SparseArray<>();
    private static final LinkedBlockingQueue<Runnable> taskQueue;
    private static final ThreadPoolExecutor threadPool;
    private final OkHttpClient mClient;

    static {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        taskQueue = linkedBlockingQueue;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue2 = linkedBlockingQueue;
        threadPool = new ThreadPoolExecutor(5, 10, 5000, TimeUnit.MILLISECONDS, linkedBlockingQueue2);
        fsThreadPool = new ThreadPoolExecutor(2, 10, 5000, TimeUnit.MILLISECONDS, linkedBlockingQueue2);
    }

    public ReactNativeBlobUtilImpl(ReactApplicationContext reactApplicationContext) {
        OkHttpClient okHttpClient = OkHttpClientProvider.getOkHttpClient();
        this.mClient = okHttpClient;
        ((CookieJarContainer) okHttpClient.cookieJar()).setCookieJar(new JavaNetCookieJar(new ForwardingCookieHandler(reactApplicationContext)));
        RCTContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(new ActivityEventListener() {
            public void onNewIntent(Intent intent) {
            }

            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                if (i == ReactNativeBlobUtilConst.GET_CONTENT_INTENT.intValue() && i2 == -1) {
                    ((Promise) ReactNativeBlobUtilImpl.promiseTable.get(ReactNativeBlobUtilConst.GET_CONTENT_INTENT.intValue())).resolve(intent.getData().toString());
                    ReactNativeBlobUtilImpl.promiseTable.remove(ReactNativeBlobUtilConst.GET_CONTENT_INTENT.intValue());
                }
            }
        });
    }

    public void createFile(String str, String str2, String str3, Promise promise) {
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final Promise promise2 = promise;
        threadPool.execute(new Runnable() {
            public void run() {
                ReactNativeBlobUtilFS.createFile(str4, str5, str6, promise2);
            }
        });
    }

    public void createFileASCII(final String str, final ReadableArray readableArray, final Promise promise) {
        threadPool.execute(new Runnable() {
            public void run() {
                ReactNativeBlobUtilFS.createFileASCII(str, readableArray, promise);
            }
        });
    }

    public void actionViewIntent(String str, String str2, @Nullable String str3, final Promise promise) {
        Uri uri;
        try {
            if (!ReactNativeBlobUtilUtils.isContentUri(str)) {
                uri = FileProvider.getUriForFile(RCTContext, RCTContext.getPackageName() + ".provider", new File(str));
            } else {
                uri = Uri.parse(str);
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            if (Build.VERSION.SDK_INT >= 24) {
                intent.setDataAndType(uri, str2);
                intent.setFlags(1);
                intent.addFlags(268435456);
            } else {
                intent.setDataAndType(Uri.parse("file://" + str), str2).setFlags(268435456);
            }
            if (str3 != null) {
                intent = Intent.createChooser(intent, str3);
            }
            try {
                RCTContext.startActivity(intent);
                promise.resolve(true);
            } catch (ActivityNotFoundException unused) {
                promise.reject("ENOAPP", "No app installed for " + str2);
            }
            ActionViewVisible = true;
            RCTContext.addLifecycleEventListener(new LifecycleEventListener() {
                public void onHostDestroy() {
                }

                public void onHostPause() {
                }

                public void onHostResume() {
                    if (ReactNativeBlobUtilImpl.ActionViewVisible) {
                        promise.resolve((Object) null);
                    }
                    ReactNativeBlobUtilImpl.RCTContext.removeLifecycleEventListener(this);
                }
            });
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    public void writeArrayChunk(String str, ReadableArray readableArray, Callback callback) {
        ReactNativeBlobUtilStream.writeArrayChunk(str, readableArray, callback);
    }

    public void unlink(String str, Callback callback) {
        ReactNativeBlobUtilFS.unlink(str, callback);
    }

    public void mkdir(String str, Promise promise) {
        ReactNativeBlobUtilFS.mkdir(str, promise);
    }

    public void exists(String str, Callback callback) {
        ReactNativeBlobUtilFS.exists(str, callback);
    }

    public void cp(final String str, final String str2, final Callback callback) {
        threadPool.execute(new Runnable() {
            public void run() {
                ReactNativeBlobUtilFS.cp(str, str2, callback);
            }
        });
    }

    public void mv(String str, String str2, Callback callback) {
        ReactNativeBlobUtilFS.mv(str, str2, callback);
    }

    public void ls(String str, Promise promise) {
        ReactNativeBlobUtilFS.ls(str, promise);
    }

    public void writeStream(String str, String str2, boolean z, Callback callback) {
        new ReactNativeBlobUtilStream(RCTContext).writeStream(str, str2, z, callback);
    }

    public void writeChunk(String str, String str2, Callback callback) {
        ReactNativeBlobUtilStream.writeChunk(str, str2, callback);
    }

    public void closeStream(String str, Callback callback) {
        ReactNativeBlobUtilStream.closeStream(str, callback);
    }

    public void removeSession(ReadableArray readableArray, Callback callback) {
        ReactNativeBlobUtilFS.removeSession(readableArray, callback);
    }

    public void readFile(String str, String str2, boolean z, Promise promise) {
        final String str3 = str;
        final String str4 = str2;
        final boolean z2 = z;
        final Promise promise2 = promise;
        threadPool.execute(new Runnable() {
            public void run() {
                ReactNativeBlobUtilFS.readFile(str3, str4, z2, promise2);
            }
        });
    }

    public void writeFileArray(String str, ReadableArray readableArray, boolean z, Promise promise) {
        final String str2 = str;
        final ReadableArray readableArray2 = readableArray;
        final boolean z2 = z;
        final Promise promise2 = promise;
        threadPool.execute(new Runnable() {
            public void run() {
                ReactNativeBlobUtilFS.writeFile(str2, readableArray2, z2, promise2);
            }
        });
    }

    public void writeFile(String str, String str2, String str3, boolean z, boolean z2, Promise promise) {
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final boolean z3 = z;
        final boolean z4 = z2;
        final Promise promise2 = promise;
        threadPool.execute(new Runnable() {
            public void run() {
                ReactNativeBlobUtilFS.writeFile(str4, str5, str6, z3, z4, promise2);
            }
        });
    }

    public void lstat(String str, Callback callback) {
        ReactNativeBlobUtilFS.lstat(str, callback);
    }

    public void stat(String str, Callback callback) {
        ReactNativeBlobUtilFS.stat(str, callback);
    }

    public void scanFile(final ReadableArray readableArray, final Callback callback) {
        final ReactApplicationContext reactApplicationContext = RCTContext;
        threadPool.execute(new Runnable() {
            public void run() {
                int size = readableArray.size();
                String[] strArr = new String[size];
                String[] strArr2 = new String[size];
                for (int i = 0; i < size; i++) {
                    ReadableMap map = readableArray.getMap(i);
                    if (map.hasKey(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH)) {
                        strArr[i] = map.getString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
                        if (map.hasKey("mime")) {
                            strArr2[i] = map.getString("mime");
                        } else {
                            strArr2[i] = null;
                        }
                    }
                }
                new ReactNativeBlobUtilFS(reactApplicationContext).scanFile(strArr, strArr2, callback);
            }
        });
    }

    public void hash(final String str, final String str2, final Promise promise) {
        threadPool.execute(new Runnable() {
            public void run() {
                ReactNativeBlobUtilFS.hash(str, str2, promise);
            }
        });
    }

    public void readStream(String str, String str2, int i, int i2, String str3) {
        final ReactApplicationContext reactApplicationContext = RCTContext;
        final String str4 = str;
        final String str5 = str2;
        final int i3 = i;
        final int i4 = i2;
        final String str6 = str3;
        fsThreadPool.execute(new Runnable() {
            public void run() {
                new ReactNativeBlobUtilStream(reactApplicationContext).readStream(str4, str5, i3, i4, str6, ReactNativeBlobUtilImpl.RCTContext);
            }
        });
    }

    public void cancelRequest(String str, Callback callback) {
        try {
            ReactNativeBlobUtilReq.cancelTask(str);
            callback.invoke(null, str);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), null);
        }
    }

    public void slice(String str, String str2, int i, int i2, Promise promise) {
        ReactNativeBlobUtilFS.slice(str, str2, i, i2, "", promise);
    }

    public void enableProgressReport(String str, int i, int i2) {
        ReactNativeBlobUtilReq.progressReport.put(str, new ReactNativeBlobUtilProgressConfig(true, i, i2, ReactNativeBlobUtilProgressConfig.ReportType.Download));
    }

    public void df(final Callback callback) {
        fsThreadPool.execute(new Runnable() {
            public void run() {
                ReactNativeBlobUtilFS.df(callback, ReactNativeBlobUtilImpl.RCTContext);
            }
        });
    }

    public void enableUploadProgressReport(String str, int i, int i2) {
        ReactNativeBlobUtilReq.uploadProgressReport.put(str, new ReactNativeBlobUtilProgressConfig(true, i, i2, ReactNativeBlobUtilProgressConfig.ReportType.Upload));
    }

    public void fetchBlob(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, Callback callback) {
        new ReactNativeBlobUtilReq(readableMap, str, str2, str3, readableMap2, str4, (ReadableArray) null, this.mClient, callback).run();
    }

    public void fetchBlobForm(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, ReadableArray readableArray, Callback callback) {
        new ReactNativeBlobUtilReq(readableMap, str, str2, str3, readableMap2, (String) null, readableArray, this.mClient, callback).run();
    }

    public void getContentIntent(String str, Promise promise) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        if (str != null) {
            intent.setType(str);
        } else {
            intent.setType("*/*");
        }
        promiseTable.put(ReactNativeBlobUtilConst.GET_CONTENT_INTENT.intValue(), promise);
        RCTContext.startActivityForResult(intent, ReactNativeBlobUtilConst.GET_CONTENT_INTENT.intValue(), (Bundle) null);
    }

    public void addCompleteDownload(ReadableMap readableMap, Promise promise) {
        ReadableMap readableMap2 = readableMap;
        Promise promise2 = promise;
        DownloadManager downloadManager = (DownloadManager) RCTContext.getSystemService("download");
        if (readableMap2 == null || !readableMap2.hasKey(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH)) {
            promise2.reject("EINVAL", "ReactNativeBlobUtil.addCompleteDownload config or path missing.");
            return;
        }
        String normalizePath = ReactNativeBlobUtilUtils.normalizePath(readableMap2.getString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH));
        if (normalizePath == null) {
            promise2.reject("EINVAL", "ReactNativeBlobUtil.addCompleteDownload can not resolve URI:" + readableMap2.getString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH));
            return;
        }
        try {
            WritableMap statFile = ReactNativeBlobUtilFS.statFile(normalizePath);
            String str = "";
            String string = readableMap2.hasKey("title") ? readableMap2.getString("title") : str;
            if (readableMap2.hasKey("description")) {
                str = readableMap2.getString("description");
            }
            downloadManager.addCompletedDownload(string, str, true, readableMap2.hasKey("mime") ? readableMap2.getString("mime") : null, normalizePath, Long.valueOf(statFile.getString("size")).longValue(), readableMap2.hasKey("showNotification") && readableMap2.getBoolean("showNotification"));
            promise2.resolve((Object) null);
        } catch (Exception e) {
            promise2.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    public void getSDCardDir(Promise promise) {
        ReactNativeBlobUtilFS.getSDCardDir(RCTContext, promise);
    }

    public void getSDCardApplicationDir(Promise promise) {
        ReactNativeBlobUtilFS.getSDCardApplicationDir(RCTContext, promise);
    }

    public void createMediaFile(ReadableMap readableMap, String str, Promise promise) {
        if (!readableMap.hasKey("name") || !readableMap.hasKey("parentFolder") || !readableMap.hasKey("mimeType")) {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "invalid filedata: " + readableMap.toString());
            return;
        }
        if (str == null) {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "invalid mediatype");
        }
        Uri createNewMediaFile = ReactNativeBlobUtilMediaCollection.createNewMediaFile(new FileDescription(readableMap.getString("name"), readableMap.getString("mimeType"), readableMap.getString("parentFolder")), ReactNativeBlobUtilMediaCollection.MediaType.valueOf(str), RCTContext);
        if (createNewMediaFile != null) {
            promise.resolve(createNewMediaFile.toString());
        } else {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "File could not be created");
        }
    }

    public void writeToMediaFile(String str, String str2, boolean z, Promise promise) {
        if (ReactNativeBlobUtilMediaCollection.writeToMediaFile(Uri.parse(str), str2, z, promise, RCTContext)) {
            promise.resolve("Success");
        }
    }

    public void copyToInternal(String str, String str2, Promise promise) {
        ReactNativeBlobUtilMediaCollection.copyToInternal(Uri.parse(str), str2, promise);
    }

    public void getBlob(String str, String str2, Promise promise) {
        ReactNativeBlobUtilMediaCollection.getBlob(Uri.parse(str), str2, promise);
    }

    public void copyToMediaStore(ReadableMap readableMap, String str, String str2, Promise promise) {
        if (!readableMap.hasKey("name") || !readableMap.hasKey("parentFolder") || !readableMap.hasKey("mimeType")) {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "invalid filedata: " + readableMap.toString());
        } else if (str == null) {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "invalid mediatype");
        } else if (str2 == null) {
            promise.reject("ReactNativeBlobUtil.createMediaFile", "invalid path");
        } else {
            Uri createNewMediaFile = ReactNativeBlobUtilMediaCollection.createNewMediaFile(new FileDescription(readableMap.getString("name"), readableMap.getString("mimeType"), readableMap.getString("parentFolder")), ReactNativeBlobUtilMediaCollection.MediaType.valueOf(str), RCTContext);
            if (createNewMediaFile == null) {
                promise.reject("ReactNativeBlobUtil.createMediaFile", "File could not be created");
            } else if (ReactNativeBlobUtilMediaCollection.writeToMediaFile(createNewMediaFile, str2, false, promise, RCTContext)) {
                promise.resolve(createNewMediaFile.toString());
            }
        }
    }
}
