package fr.bamlab.rnimageresizer;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ImageResizerModule extends ReactContextBaseJavaModule {
    private Context context;

    public String getName() {
        return "ImageResizerAndroid";
    }

    public ImageResizerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.context = reactApplicationContext;
    }

    @ReactMethod
    public void createResizedImage(String str, int i, int i2, String str2, int i3, int i4, String str3, boolean z, ReadableMap readableMap, Callback callback, Callback callback2) {
        final String str4 = str;
        final int i5 = i;
        final int i6 = i2;
        final String str5 = str2;
        final int i7 = i3;
        final int i8 = i4;
        final String str6 = str3;
        final boolean z2 = z;
        final ReadableMap readableMap2 = readableMap;
        final Callback callback3 = callback;
        final Callback callback4 = callback2;
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                try {
                    ImageResizerModule.this.createResizedImageWithExceptions(str4, i5, i6, str5, i7, i8, str6, z2, readableMap2, callback3, callback4);
                } catch (IOException e) {
                    callback4.invoke(e.getMessage());
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* access modifiers changed from: private */
    public void createResizedImageWithExceptions(String str, int i, int i2, String str2, int i3, int i4, String str3, boolean z, ReadableMap readableMap, Callback callback, Callback callback2) throws IOException {
        String str4 = str3;
        ReadableMap readableMap2 = readableMap;
        Bitmap.CompressFormat valueOf = Bitmap.CompressFormat.valueOf(str2);
        Uri parse = Uri.parse(str);
        Bitmap createResizedImage = ImageResizer.createResizedImage(this.context, parse, i, i2, i3, i4, readableMap2.getString("mode"), readableMap2.getBoolean("onlyScaleDown"));
        if (createResizedImage != null) {
            File cacheDir = this.context.getCacheDir();
            if (str4 != null) {
                cacheDir = new File(str4);
            }
            File saveImage = ImageResizer.saveImage(createResizedImage, cacheDir, UUID.randomUUID().toString(), valueOf, i3);
            if (saveImage.isFile()) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, saveImage.getAbsolutePath());
                createMap.putString("uri", Uri.fromFile(saveImage).toString());
                createMap.putString("name", saveImage.getName());
                createMap.putDouble("size", (double) saveImage.length());
                createMap.putDouble("width", (double) createResizedImage.getWidth());
                createMap.putDouble("height", (double) createResizedImage.getHeight());
                if (z) {
                    try {
                        ImageResizer.copyExif(this.context, parse, saveImage.getAbsolutePath());
                    } catch (Exception e) {
                        Log.e("ImageResizer::createResizedImageWithExceptions", "EXIF copy failed", e);
                    }
                }
                callback.invoke(createMap);
            } else {
                callback2.invoke("Error getting resized image path");
            }
            createResizedImage.recycle();
            return;
        }
        throw new IOException("The image failed to be resized; invalid Bitmap result.");
    }
}
