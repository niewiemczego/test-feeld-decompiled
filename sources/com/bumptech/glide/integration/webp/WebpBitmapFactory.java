package com.bumptech.glide.integration.webp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.TypedValue;
import com.bumptech.glide.integration.webp.WebpHeaderParser;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class WebpBitmapFactory {
    private static final int IN_TEMP_BUFFER_SIZE = 8192;
    private static final int MAX_WEBP_HEADER_SIZE = 21;

    private static native Bitmap nativeDecodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options, float f, byte[] bArr2);

    private static native Bitmap nativeDecodeStream(InputStream inputStream, BitmapFactory.Options options, float f, byte[] bArr);

    static {
        System.loadLibrary("glide-webp");
    }

    private static void setDensityFromOptions(Bitmap bitmap, BitmapFactory.Options options) {
        if (bitmap != null && options != null) {
            int i = options.inDensity;
            if (i != 0) {
                bitmap.setDensity(i);
                int i2 = options.inTargetDensity;
                if (i2 != 0 && i != i2 && i != options.inScreenDensity && options.inScaled) {
                    bitmap.setDensity(i2);
                }
            } else if (options.inBitmap != null) {
                bitmap.setDensity(160);
            }
        }
    }

    private static void setWebpBitmapOptions(Bitmap bitmap, BitmapFactory.Options options) {
        setDensityFromOptions(bitmap, options);
        if (options != null) {
            options.outMimeType = "image/webp";
        }
    }

    private static boolean setOutDimensions(BitmapFactory.Options options, int i, int i2) {
        if (options == null) {
            return false;
        }
        options.outWidth = i;
        options.outHeight = i2;
        return options.inJustDecodeBounds;
    }

    private static Bitmap createBitmap(int i, int i2, BitmapFactory.Options options) {
        if (options != null && options.inBitmap != null && options.inBitmap.isMutable()) {
            return options.inBitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.setHasAlpha(true);
        createBitmap.eraseColor(0);
        return createBitmap;
    }

    private static void setDefaultPadding(Rect rect) {
        if (rect != null) {
            rect.top = -1;
            rect.left = -1;
            rect.bottom = -1;
            rect.right = -1;
        }
    }

    public static boolean webpSupportRequired(byte[] bArr, int i, int i2) {
        WebpHeaderParser.WebpImageType webpImageType;
        try {
            webpImageType = WebpHeaderParser.getType(bArr, i, i2);
        } catch (IOException unused) {
            webpImageType = WebpHeaderParser.WebpImageType.NONE_WEBP;
        }
        return Build.VERSION.SDK_INT <= 17 && WebpHeaderParser.isNonSimpleWebpType(webpImageType);
    }

    private static byte[] getImageHeader(InputStream inputStream) {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream, 21);
        }
        inputStream.mark(21);
        byte[] bArr = new byte[21];
        try {
            inputStream.read(bArr, 0, 21);
            inputStream.reset();
            return bArr;
        } catch (IOException unused) {
            return null;
        }
    }

    private static InputStream wrapToMarkSupportedStream(InputStream inputStream) {
        return !inputStream.markSupported() ? new BufferedInputStream(inputStream, 8192) : inputStream;
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2) {
        return decodeByteArray(bArr, i, i2, (BitmapFactory.Options) null);
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options) {
        if ((i | i2) < 0 || bArr.length < i + i2) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (!webpSupportRequired(bArr, i, i2)) {
            return BitmapFactory.decodeByteArray(bArr, i, i2, options);
        } else {
            Bitmap nativeDecodeByteArray = nativeDecodeByteArray(bArr, i, i2, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
            setWebpBitmapOptions(nativeDecodeByteArray, options);
            return nativeDecodeByteArray;
        }
    }

    public static Bitmap decodeFile(String str) {
        return decodeFile(str, (BitmapFactory.Options) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r1 != null) goto L_0x000a;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034 A[SYNTHETIC, Splitter:B:20:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap decodeFile(java.lang.String r4, android.graphics.BitmapFactory.Options r5) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0012, all -> 0x0010 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0012, all -> 0x0010 }
            android.graphics.Bitmap r0 = decodeStream(r1, r0, r5)     // Catch:{ Exception -> 0x000e }
        L_0x000a:
            r1.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x002f
        L_0x000e:
            r4 = move-exception
            goto L_0x0014
        L_0x0010:
            r4 = move-exception
            goto L_0x0032
        L_0x0012:
            r4 = move-exception
            r1 = r0
        L_0x0014:
            java.lang.String r5 = "WebpBitmapFactory"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            r2.<init>()     // Catch:{ all -> 0x0030 }
            java.lang.String r3 = "Unable to decode stream: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0030 }
            java.lang.StringBuilder r4 = r2.append(r4)     // Catch:{ all -> 0x0030 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0030 }
            android.util.Log.e(r5, r4)     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002f
            goto L_0x000a
        L_0x002f:
            return r0
        L_0x0030:
            r4 = move-exception
            r0 = r1
        L_0x0032:
            if (r0 == 0) goto L_0x0037
            r0.close()     // Catch:{ IOException -> 0x0037 }
        L_0x0037:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.integration.webp.WebpBitmapFactory.decodeFile(java.lang.String, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    public static Bitmap decodeResource(Resources resources, int i) {
        return decodeResource(resources, i, (BitmapFactory.Options) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001f, code lost:
        if (r3 != null) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        if (r3 != null) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r3.close();
        r0 = r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001a A[SYNTHETIC, Splitter:B:12:0x001a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap decodeResource(android.content.res.Resources r2, int r3, android.graphics.BitmapFactory.Options r4) {
        /*
            r0 = 0
            android.util.TypedValue r1 = new android.util.TypedValue     // Catch:{ Exception -> 0x001e, all -> 0x0017 }
            r1.<init>()     // Catch:{ Exception -> 0x001e, all -> 0x0017 }
            java.io.InputStream r3 = r2.openRawResource(r3, r1)     // Catch:{ Exception -> 0x001e, all -> 0x0017 }
            android.graphics.Bitmap r0 = decodeResourceStream(r2, r1, r3, r0, r4)     // Catch:{ Exception -> 0x001f, all -> 0x0014 }
            if (r3 == 0) goto L_0x0022
        L_0x0010:
            r3.close()     // Catch:{ IOException -> 0x0022 }
            goto L_0x0022
        L_0x0014:
            r2 = move-exception
            r0 = r3
            goto L_0x0018
        L_0x0017:
            r2 = move-exception
        L_0x0018:
            if (r0 == 0) goto L_0x001d
            r0.close()     // Catch:{ IOException -> 0x001d }
        L_0x001d:
            throw r2
        L_0x001e:
            r3 = r0
        L_0x001f:
            if (r3 == 0) goto L_0x0022
            goto L_0x0010
        L_0x0022:
            if (r0 != 0) goto L_0x0033
            if (r4 == 0) goto L_0x0033
            android.graphics.Bitmap r2 = r4.inBitmap
            if (r2 != 0) goto L_0x002b
            goto L_0x0033
        L_0x002b:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Problem decoding into existing bitmap"
            r2.<init>(r3)
            throw r2
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.integration.webp.WebpBitmapFactory.decodeResource(android.content.res.Resources, int, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    public static Bitmap decodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (options.inDensity == 0 && typedValue != null) {
            int i = typedValue.density;
            if (i == 0) {
                options.inDensity = 160;
            } else if (i != 65535) {
                options.inDensity = i;
            }
        }
        if (options.inTargetDensity == 0 && resources != null) {
            options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        return decodeStream(inputStream, rect, options);
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor) {
        return decodeFileDescriptor(fileDescriptor, (Rect) null, (BitmapFactory.Options) null);
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        Bitmap bitmap;
        InputStream wrapToMarkSupportedStream = wrapToMarkSupportedStream(new FileInputStream(fileDescriptor));
        try {
            if (webpSupportRequired(getImageHeader(wrapToMarkSupportedStream), 0, 21)) {
                bitmap = nativeDecodeStream(wrapToMarkSupportedStream, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
                setWebpBitmapOptions(bitmap, options);
                setDefaultPadding(rect);
            } else {
                bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
            }
            try {
                wrapToMarkSupportedStream.close();
            } catch (Throwable unused) {
            }
            return bitmap;
        } catch (Throwable unused2) {
        }
        throw th;
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        return decodeStream(inputStream, (Rect) null, (BitmapFactory.Options) null);
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        if (inputStream == null) {
            return null;
        }
        InputStream wrapToMarkSupportedStream = wrapToMarkSupportedStream(inputStream);
        if (!webpSupportRequired(getImageHeader(wrapToMarkSupportedStream), 0, 21)) {
            return BitmapFactory.decodeStream(wrapToMarkSupportedStream, rect, options);
        }
        Bitmap nativeDecodeStream = nativeDecodeStream(wrapToMarkSupportedStream, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
        setWebpBitmapOptions(nativeDecodeStream, options);
        setDefaultPadding(rect);
        return nativeDecodeStream;
    }

    private static byte[] getInTempStorageFromOptions(BitmapFactory.Options options) {
        return (options == null || options.inTempStorage == null) ? new byte[8192] : options.inTempStorage;
    }

    private static float getScaleFromOptions(BitmapFactory.Options options) {
        float f = 1.0f;
        if (options == null) {
            return 1.0f;
        }
        int i = options.inSampleSize;
        if (i > 1) {
            f = 1.0f / ((float) i);
        }
        if (!options.inScaled) {
            return f;
        }
        int i2 = options.inDensity;
        int i3 = options.inTargetDensity;
        return (i2 == 0 || i3 == 0 || i2 == options.inScreenDensity) ? f : ((float) i3) / ((float) i2);
    }
}
