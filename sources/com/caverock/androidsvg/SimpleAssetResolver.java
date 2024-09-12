package com.caverock.androidsvg;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.reactnativecommunity.clipboard.ClipboardModule;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SimpleAssetResolver extends SVGExternalFileResolver {
    private static final String TAG = "SimpleAssetResolver";
    private static final Set<String> supportedFormats;
    private AssetManager assetManager;

    public SimpleAssetResolver(AssetManager assetManager2) {
        this.assetManager = assetManager2;
    }

    static {
        HashSet hashSet = new HashSet(8);
        supportedFormats = hashSet;
        hashSet.add("image/svg+xml");
        hashSet.add("image/jpeg");
        hashSet.add(ClipboardModule.MIMETYPE_PNG);
        hashSet.add("image/pjpeg");
        hashSet.add("image/gif");
        hashSet.add("image/bmp");
        hashSet.add("image/x-windows-bmp");
        if (Build.VERSION.SDK_INT >= 14) {
            hashSet.add("image/webp");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0063, code lost:
        return android.graphics.Typeface.createFromAsset(r2.assetManager, r3 + ".otf");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0064, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x004a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface resolveFont(java.lang.String r3, int r4, java.lang.String r5) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "resolveFont("
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r1 = ","
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r4 = r0.append(r4)
            java.lang.StringBuilder r4 = r4.append(r1)
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = ")"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "SimpleAssetResolver"
            android.util.Log.i(r5, r4)
            android.content.res.AssetManager r4 = r2.assetManager     // Catch:{ RuntimeException -> 0x004a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x004a }
            r5.<init>()     // Catch:{ RuntimeException -> 0x004a }
            java.lang.StringBuilder r5 = r5.append(r3)     // Catch:{ RuntimeException -> 0x004a }
            java.lang.String r0 = ".ttf"
            java.lang.StringBuilder r5 = r5.append(r0)     // Catch:{ RuntimeException -> 0x004a }
            java.lang.String r5 = r5.toString()     // Catch:{ RuntimeException -> 0x004a }
            android.graphics.Typeface r3 = android.graphics.Typeface.createFromAsset(r4, r5)     // Catch:{ RuntimeException -> 0x004a }
            return r3
        L_0x004a:
            android.content.res.AssetManager r4 = r2.assetManager     // Catch:{ RuntimeException -> 0x0064 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0064 }
            r5.<init>()     // Catch:{ RuntimeException -> 0x0064 }
            java.lang.StringBuilder r3 = r5.append(r3)     // Catch:{ RuntimeException -> 0x0064 }
            java.lang.String r5 = ".otf"
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ RuntimeException -> 0x0064 }
            java.lang.String r3 = r3.toString()     // Catch:{ RuntimeException -> 0x0064 }
            android.graphics.Typeface r3 = android.graphics.Typeface.createFromAsset(r4, r3)     // Catch:{ RuntimeException -> 0x0064 }
            return r3
        L_0x0064:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SimpleAssetResolver.resolveFont(java.lang.String, int, java.lang.String):android.graphics.Typeface");
    }

    public Bitmap resolveImage(String str) {
        Log.i(TAG, "resolveImage(" + str + ")");
        try {
            return BitmapFactory.decodeStream(this.assetManager.open(str));
        } catch (IOException unused) {
            return null;
        }
    }

    public boolean isFormatSupported(String str) {
        return supportedFormats.contains(str);
    }

    public String resolveCSSStyleSheet(String str) {
        Log.i(TAG, "resolveCSSStyleSheet(" + str + ")");
        return getAssetAsString(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c A[SYNTHETIC, Splitter:B:17:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043 A[SYNTHETIC, Splitter:B:25:0x0043] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getAssetAsString(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            android.content.res.AssetManager r1 = r7.assetManager     // Catch:{ IOException -> 0x0040, all -> 0x0036 }
            java.io.InputStream r8 = r1.open(r8)     // Catch:{ IOException -> 0x0040, all -> 0x0036 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0041, all -> 0x0034 }
            java.lang.String r2 = "UTF-8"
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r2)     // Catch:{ IOException -> 0x0041, all -> 0x0034 }
            r1.<init>(r8, r2)     // Catch:{ IOException -> 0x0041, all -> 0x0034 }
            r2 = 4096(0x1000, float:5.74E-42)
            char[] r2 = new char[r2]     // Catch:{ IOException -> 0x0041, all -> 0x0034 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0041, all -> 0x0034 }
            r3.<init>()     // Catch:{ IOException -> 0x0041, all -> 0x0034 }
            int r4 = r1.read(r2)     // Catch:{ IOException -> 0x0041, all -> 0x0034 }
        L_0x001f:
            if (r4 <= 0) goto L_0x002a
            r5 = 0
            r3.append(r2, r5, r4)     // Catch:{ IOException -> 0x0041, all -> 0x0034 }
            int r4 = r1.read(r2)     // Catch:{ IOException -> 0x0041, all -> 0x0034 }
            goto L_0x001f
        L_0x002a:
            java.lang.String r0 = r3.toString()     // Catch:{ IOException -> 0x0041, all -> 0x0034 }
            if (r8 == 0) goto L_0x0033
            r8.close()     // Catch:{ IOException -> 0x0033 }
        L_0x0033:
            return r0
        L_0x0034:
            r0 = move-exception
            goto L_0x003a
        L_0x0036:
            r8 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
        L_0x003a:
            if (r8 == 0) goto L_0x003f
            r8.close()     // Catch:{ IOException -> 0x003f }
        L_0x003f:
            throw r0
        L_0x0040:
            r8 = r0
        L_0x0041:
            if (r8 == 0) goto L_0x0046
            r8.close()     // Catch:{ IOException -> 0x0046 }
        L_0x0046:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SimpleAssetResolver.getAssetAsString(java.lang.String):java.lang.String");
    }
}
