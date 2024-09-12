package com.reactlibrary.createthumbnail;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedResultAsyncTask;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.io.comparator.LastModifiedFileComparator;

public class CreateThumbnailModule extends ReactContextBaseJavaModule {
    private final ReactApplicationContext reactContext;

    public String getName() {
        return "CreateThumbnail";
    }

    public CreateThumbnailModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod
    public void create(ReadableMap readableMap, Promise promise) {
        new ProcessDataTask(this.reactContext, promise, readableMap).execute(new Void[0]);
    }

    private static class ProcessDataTask extends GuardedResultAsyncTask<ReadableMap> {
        private final ReadableMap options;
        private final Promise promise;
        private final WeakReference<Context> weakContext;

        protected ProcessDataTask(ReactContext reactContext, Promise promise2, ReadableMap readableMap) {
            super(reactContext.getExceptionHandler());
            this.weakContext = new WeakReference<>(reactContext.getApplicationContext());
            this.promise = promise2;
            this.options = readableMap;
        }

        /* access modifiers changed from: protected */
        public ReadableMap doInBackgroundGuarded() {
            String string = this.options.hasKey("format") ? this.options.getString("format") : "jpeg";
            String str = "";
            String string2 = this.options.hasKey("cacheName") ? this.options.getString("cacheName") : str;
            String str2 = ((Context) this.weakContext.get()).getApplicationContext().getCacheDir().getAbsolutePath() + "/thumbnails";
            File access$000 = CreateThumbnailModule.createDirIfNotExists(str2);
            if (!TextUtils.isEmpty(string2)) {
                File file = new File(str2, string2 + "." + string);
                if (file.exists()) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, "file://" + file.getAbsolutePath());
                    Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                    createMap.putDouble("size", (double) decodeFile.getByteCount());
                    createMap.putString("mime", "image/" + string);
                    createMap.putDouble("width", (double) decodeFile.getWidth());
                    createMap.putDouble("height", (double) decodeFile.getHeight());
                    return createMap;
                }
            }
            if (this.options.hasKey("url")) {
                str = this.options.getString("url");
            }
            int i = this.options.hasKey("dirSize") ? this.options.getInt("dirSize") : 100;
            int i2 = this.options.hasKey("timeStamp") ? this.options.getInt("timeStamp") : 0;
            String str3 = "height";
            HashMap<String, Object> hashMap = this.options.hasKey("headers") ? this.options.getMap("headers").toHashMap() : new HashMap<>();
            try {
                File file2 = new File(access$000, (TextUtils.isEmpty(string2) ? new StringBuilder().append("thumb-").append(UUID.randomUUID().toString()) : new StringBuilder().append(string2).append(".").append(string)).toString());
                Bitmap access$100 = CreateThumbnailModule.getBitmapAtTime((Context) this.weakContext.get(), str, i2, hashMap);
                file2.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                if (string.equals("png")) {
                    access$100.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                } else {
                    access$100.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                long j = ((long) i) * 1024 * 1024;
                if (((long) access$100.getByteCount()) + CreateThumbnailModule.getDirSize(access$000) > j) {
                    CreateThumbnailModule.cleanDir(access$000, j / 2);
                }
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, "file://" + file2.getAbsolutePath());
                createMap2.putDouble("size", (double) access$100.getByteCount());
                createMap2.putString("mime", "image/" + string);
                createMap2.putDouble("width", (double) access$100.getWidth());
                createMap2.putDouble(str3, (double) access$100.getHeight());
                return createMap2;
            } catch (Exception e) {
                this.promise.reject("CreateThumbnail_ERROR", (Throwable) e);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecuteGuarded(ReadableMap readableMap) {
            this.promise.resolve(readableMap);
        }
    }

    /* access modifiers changed from: private */
    public static void cleanDir(File file, long j) {
        File[] listFiles = file.listFiles();
        Arrays.sort(listFiles, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
        int length = listFiles.length;
        long j2 = 0;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            j2 += file2.length();
            file2.delete();
            if (j2 < j) {
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public static File createDirIfNotExists(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        try {
            file.mkdirs();
            new File(str, ".nomedia").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /* access modifiers changed from: private */
    public static Bitmap getBitmapAtTime(Context context, String str, int i, Map map) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        if (URLUtil.isFileUrl(str)) {
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
            mediaMetadataRetriever.setDataSource(str.replace("file://", ""));
        } else if (str.contains(ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT)) {
            mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
        } else if (Build.VERSION.SDK_INT >= 14) {
            mediaMetadataRetriever.setDataSource(str, map);
        } else {
            throw new IllegalStateException("Remote videos aren't supported on sdk_version < 14");
        }
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime((long) (i * 1000), 2);
        try {
            mediaMetadataRetriever.release();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (frameAtTime != null) {
            return frameAtTime;
        }
        throw new IllegalStateException("File doesn't exist or not supported");
    }

    /* access modifiers changed from: private */
    public static long getDirSize(File file) {
        long j = 0;
        for (File file2 : file.listFiles()) {
            if (file2.isFile()) {
                j += file2.length();
            }
        }
        return j;
    }
}
