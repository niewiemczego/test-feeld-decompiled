package expo.modules.camera.tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.camera.PictureOptions;
import expo.modules.kotlin.Promise;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0016H\u0002J \u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J'\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u001c\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0014J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lexpo/modules/camera/tasks/ResolveTakenPictureAsyncTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "Landroid/os/Bundle;", "imageData", "", "promise", "Lexpo/modules/kotlin/Promise;", "options", "Lexpo/modules/camera/PictureOptions;", "directory", "Ljava/io/File;", "pictureSavedDelegate", "Lexpo/modules/camera/tasks/PictureSavedDelegate;", "([BLexpo/modules/kotlin/Promise;Lexpo/modules/camera/PictureOptions;Ljava/io/File;Lexpo/modules/camera/tasks/PictureSavedDelegate;)V", "quality", "", "getQuality", "()I", "decodeAndRotateBitmap", "Landroid/graphics/Bitmap;", "angle", "Landroid/graphics/BitmapFactory$Options;", "decodeBitmap", "orientation", "bitmapOptions", "doInBackground", "params", "", "([Ljava/lang/Void;)Landroid/os/Bundle;", "getImageRotation", "handleSkipProcessing", "onPostExecute", "", "response", "writeStreamToFile", "", "inputStream", "Ljava/io/ByteArrayOutputStream;", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ResolveTakenPictureAsyncTask.kt */
public final class ResolveTakenPictureAsyncTask extends AsyncTask<Void, Void, Bundle> {
    private final File directory;
    private byte[] imageData;
    private PictureOptions options;
    private PictureSavedDelegate pictureSavedDelegate;
    private Promise promise;

    private final int getImageRotation(int i) {
        if (i == 3) {
            return RotationOptions.ROTATE_180;
        }
        if (i != 6) {
            return i != 8 ? 0 : 270;
        }
        return 90;
    }

    public ResolveTakenPictureAsyncTask(byte[] bArr, Promise promise2, PictureOptions pictureOptions, File file, PictureSavedDelegate pictureSavedDelegate2) {
        Intrinsics.checkNotNullParameter(bArr, "imageData");
        Intrinsics.checkNotNullParameter(promise2, BaseJavaModule.METHOD_TYPE_PROMISE);
        Intrinsics.checkNotNullParameter(pictureOptions, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        Intrinsics.checkNotNullParameter(file, "directory");
        Intrinsics.checkNotNullParameter(pictureSavedDelegate2, "pictureSavedDelegate");
        this.imageData = bArr;
        this.promise = promise2;
        this.options = pictureOptions;
        this.directory = file;
        this.pictureSavedDelegate = pictureSavedDelegate2;
    }

    private final int getQuality() {
        return (int) (this.options.getQuality() * ((double) 100));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0110, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0114, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0117, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x011b, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Bundle doInBackground(java.lang.Void... r11) {
        /*
            r10 = this;
            java.lang.String r0 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            expo.modules.camera.PictureOptions r11 = r10.options
            boolean r11 = r11.getSkipProcessing()
            if (r11 == 0) goto L_0x0012
            android.os.Bundle r11 = r10.handleSkipProcessing()
            return r11
        L_0x0012:
            r11 = 0
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x011c }
            byte[] r1 = r10.imageData     // Catch:{ Exception -> 0x011c }
            r0.<init>(r1)     // Catch:{ Exception -> 0x011c }
            java.io.Closeable r0 = (java.io.Closeable) r0     // Catch:{ Exception -> 0x011c }
            r1 = r0
            java.io.ByteArrayInputStream r1 = (java.io.ByteArrayInputStream) r1     // Catch:{ all -> 0x0115 }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ all -> 0x0115 }
            r2.<init>()     // Catch:{ all -> 0x0115 }
            androidx.exifinterface.media.ExifInterface r3 = new androidx.exifinterface.media.ExifInterface     // Catch:{ all -> 0x0115 }
            java.io.InputStream r1 = (java.io.InputStream) r1     // Catch:{ all -> 0x0115 }
            r3.<init>((java.io.InputStream) r1)     // Catch:{ all -> 0x0115 }
            expo.modules.camera.PictureOptions r1 = r10.options     // Catch:{ all -> 0x0115 }
            java.util.Map r1 = r1.getAdditionalExif()     // Catch:{ all -> 0x0115 }
            if (r1 == 0) goto L_0x0036
            expo.modules.camera.CameraViewHelper.setExifData(r3, r1)     // Catch:{ all -> 0x0115 }
        L_0x0036:
            java.lang.String r1 = "Orientation"
            r4 = 0
            int r1 = r3.getAttributeInt(r1, r4)     // Catch:{ all -> 0x0115 }
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ all -> 0x0115 }
            r4.<init>()     // Catch:{ all -> 0x0115 }
            r5 = 1
            r4.inSampleSize = r5     // Catch:{ all -> 0x0115 }
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x0115 }
            r5.<init>()     // Catch:{ all -> 0x0115 }
            r6 = r11
        L_0x004b:
            int r7 = r4.inSampleSize     // Catch:{ all -> 0x0115 }
            expo.modules.camera.PictureOptions r8 = r10.options     // Catch:{ all -> 0x0115 }
            int r8 = r8.getMaxDownsampling()     // Catch:{ all -> 0x0115 }
            r9 = 2
            if (r7 > r8) goto L_0x0068
            byte[] r7 = r10.imageData     // Catch:{ OutOfMemoryError -> 0x005f }
            android.graphics.Bitmap r7 = r10.decodeBitmap(r7, r1, r4)     // Catch:{ OutOfMemoryError -> 0x005f }
            r5.element = r7     // Catch:{ OutOfMemoryError -> 0x005f }
            goto L_0x0068
        L_0x005f:
            r6 = move-exception
            int r7 = r4.inSampleSize     // Catch:{ all -> 0x0115 }
            int r7 = r7 * r9
            r4.inSampleSize = r7     // Catch:{ all -> 0x0115 }
            java.lang.Error r6 = (java.lang.Error) r6     // Catch:{ all -> 0x0115 }
            goto L_0x004b
        L_0x0068:
            T r1 = r5.element     // Catch:{ all -> 0x0115 }
            if (r1 != 0) goto L_0x007b
            expo.modules.kotlin.Promise r1 = r10.promise     // Catch:{ all -> 0x0115 }
            java.lang.String r2 = "ERR_CAMERA_OUT_OF_MEMORY"
            java.lang.String r3 = "Cannot allocate enough space to process the taken picture."
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x0115 }
            r1.reject(r2, r3, r6)     // Catch:{ all -> 0x0115 }
            kotlin.io.CloseableKt.closeFinally(r0, r11)     // Catch:{ Exception -> 0x011c }
            return r11
        L_0x007b:
            expo.modules.camera.PictureOptions r1 = r10.options     // Catch:{ all -> 0x0115 }
            boolean r1 = r1.getExif()     // Catch:{ all -> 0x0115 }
            if (r1 == 0) goto L_0x008c
            android.os.Bundle r1 = expo.modules.camera.CameraViewHelper.getExifData(r3)     // Catch:{ all -> 0x0115 }
            java.lang.String r4 = "exif"
            r2.putBundle(r4, r1)     // Catch:{ all -> 0x0115 }
        L_0x008c:
            java.lang.String r1 = "width"
            T r4 = r5.element     // Catch:{ all -> 0x0115 }
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4     // Catch:{ all -> 0x0115 }
            int r4 = r4.getWidth()     // Catch:{ all -> 0x0115 }
            r2.putInt(r1, r4)     // Catch:{ all -> 0x0115 }
            java.lang.String r1 = "height"
            T r4 = r5.element     // Catch:{ all -> 0x0115 }
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4     // Catch:{ all -> 0x0115 }
            int r4 = r4.getHeight()     // Catch:{ all -> 0x0115 }
            r2.putInt(r1, r4)     // Catch:{ all -> 0x0115 }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0115 }
            r1.<init>()     // Catch:{ all -> 0x0115 }
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ all -> 0x0115 }
            r4 = r1
            java.io.ByteArrayOutputStream r4 = (java.io.ByteArrayOutputStream) r4     // Catch:{ all -> 0x010e }
            T r5 = r5.element     // Catch:{ all -> 0x010e }
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5     // Catch:{ all -> 0x010e }
            android.graphics.Bitmap$CompressFormat r6 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x010e }
            int r7 = r10.getQuality()     // Catch:{ all -> 0x010e }
            r8 = r4
            java.io.OutputStream r8 = (java.io.OutputStream) r8     // Catch:{ all -> 0x010e }
            r5.compress(r6, r7, r8)     // Catch:{ all -> 0x010e }
            java.lang.String r5 = r10.writeStreamToFile(r4)     // Catch:{ all -> 0x010e }
            expo.modules.camera.PictureOptions r6 = r10.options     // Catch:{ all -> 0x010e }
            boolean r6 = r6.getExif()     // Catch:{ all -> 0x010e }
            if (r6 == 0) goto L_0x00d8
            androidx.exifinterface.media.ExifInterface r6 = new androidx.exifinterface.media.ExifInterface     // Catch:{ all -> 0x010e }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch:{ all -> 0x010e }
            r6.<init>((java.lang.String) r5)     // Catch:{ all -> 0x010e }
            expo.modules.camera.CameraViewHelper.addExifData(r6, r3)     // Catch:{ all -> 0x010e }
        L_0x00d8:
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x010e }
            r3.<init>(r5)     // Catch:{ all -> 0x010e }
            android.net.Uri r3 = android.net.Uri.fromFile(r3)     // Catch:{ all -> 0x010e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x010e }
            java.lang.String r5 = "fromFile(imageFile).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ all -> 0x010e }
            java.lang.String r5 = "uri"
            r2.putString(r5, r3)     // Catch:{ all -> 0x010e }
            expo.modules.camera.PictureOptions r3 = r10.options     // Catch:{ all -> 0x010e }
            boolean r3 = r3.getBase64()     // Catch:{ all -> 0x010e }
            if (r3 == 0) goto L_0x0105
            java.lang.String r3 = "base64"
            byte[] r4 = r4.toByteArray()     // Catch:{ all -> 0x010e }
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r9)     // Catch:{ all -> 0x010e }
            r2.putString(r3, r4)     // Catch:{ all -> 0x010e }
        L_0x0105:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x010e }
            kotlin.io.CloseableKt.closeFinally(r1, r11)     // Catch:{ all -> 0x0115 }
            kotlin.io.CloseableKt.closeFinally(r0, r11)     // Catch:{ Exception -> 0x011c }
            return r2
        L_0x010e:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0110 }
        L_0x0110:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r2)     // Catch:{ all -> 0x0115 }
            throw r3     // Catch:{ all -> 0x0115 }
        L_0x0115:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0117 }
        L_0x0117:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)     // Catch:{ Exception -> 0x011c }
            throw r2     // Catch:{ Exception -> 0x011c }
        L_0x011c:
            r0 = move-exception
            boolean r1 = r0 instanceof android.content.res.Resources.NotFoundException
            java.lang.String r2 = "E_TAKING_PICTURE_FAILED"
            if (r1 == 0) goto L_0x012e
            expo.modules.kotlin.Promise r1 = r10.promise
            r3 = r0
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            java.lang.String r4 = "Documents directory of the app could not be found."
            r1.reject(r2, r4, r3)
            goto L_0x0156
        L_0x012e:
            boolean r1 = r0 instanceof java.io.IOException
            if (r1 == 0) goto L_0x013d
            expo.modules.kotlin.Promise r1 = r10.promise
            r3 = r0
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            java.lang.String r4 = "An unknown I/O exception has occurred."
            r1.reject(r2, r4, r3)
            goto L_0x0156
        L_0x013d:
            boolean r1 = r0 instanceof java.lang.IllegalArgumentException
            if (r1 == 0) goto L_0x014c
            expo.modules.kotlin.Promise r1 = r10.promise
            r3 = r0
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            java.lang.String r4 = "An incompatible parameter has been passed in. "
            r1.reject(r2, r4, r3)
            goto L_0x0156
        L_0x014c:
            expo.modules.kotlin.Promise r1 = r10.promise
            r3 = r0
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            java.lang.String r4 = "An unknown exception has occurred."
            r1.reject(r2, r4, r3)
        L_0x0156:
            r0.printStackTrace()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.camera.tasks.ResolveTakenPictureAsyncTask.doInBackground(java.lang.Void[]):android.os.Bundle");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0080, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.os.Bundle handleSkipProcessing() {
        /*
            r7 = this;
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0081 }
            r1.<init>()     // Catch:{ Exception -> 0x0081 }
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ Exception -> 0x0081 }
            r2 = r1
            java.io.ByteArrayOutputStream r2 = (java.io.ByteArrayOutputStream) r2     // Catch:{ all -> 0x007a }
            byte[] r3 = r7.imageData     // Catch:{ all -> 0x007a }
            r2.write(r3)     // Catch:{ all -> 0x007a }
            java.lang.String r2 = r7.writeStreamToFile(r2)     // Catch:{ all -> 0x007a }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x007a }
            r3.<init>(r2)     // Catch:{ all -> 0x007a }
            android.net.Uri r3 = android.net.Uri.fromFile(r3)     // Catch:{ all -> 0x007a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x007a }
            java.lang.String r4 = "fromFile(imageFile).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x007a }
            androidx.exifinterface.media.ExifInterface r4 = new androidx.exifinterface.media.ExifInterface     // Catch:{ all -> 0x007a }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ all -> 0x007a }
            r4.<init>((java.lang.String) r2)     // Catch:{ all -> 0x007a }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ all -> 0x007a }
            r2.<init>()     // Catch:{ all -> 0x007a }
            java.lang.String r5 = "uri"
            r2.putString(r5, r3)     // Catch:{ all -> 0x007a }
            java.lang.String r3 = "width"
            java.lang.String r5 = "ImageWidth"
            r6 = -1
            int r5 = r4.getAttributeInt(r5, r6)     // Catch:{ all -> 0x007a }
            r2.putInt(r3, r5)     // Catch:{ all -> 0x007a }
            java.lang.String r3 = "height"
            java.lang.String r5 = "ImageLength"
            int r5 = r4.getAttributeInt(r5, r6)     // Catch:{ all -> 0x007a }
            r2.putInt(r3, r5)     // Catch:{ all -> 0x007a }
            expo.modules.camera.PictureOptions r3 = r7.options     // Catch:{ all -> 0x007a }
            boolean r3 = r3.getExif()     // Catch:{ all -> 0x007a }
            if (r3 == 0) goto L_0x0062
            android.os.Bundle r3 = expo.modules.camera.CameraViewHelper.getExifData(r4)     // Catch:{ all -> 0x007a }
            java.lang.String r4 = "exif"
            r2.putBundle(r4, r3)     // Catch:{ all -> 0x007a }
        L_0x0062:
            expo.modules.camera.PictureOptions r3 = r7.options     // Catch:{ all -> 0x007a }
            boolean r3 = r3.getBase64()     // Catch:{ all -> 0x007a }
            if (r3 == 0) goto L_0x0076
            java.lang.String r3 = "base64"
            byte[] r4 = r7.imageData     // Catch:{ all -> 0x007a }
            r5 = 2
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r5)     // Catch:{ all -> 0x007a }
            r2.putString(r3, r4)     // Catch:{ all -> 0x007a }
        L_0x0076:
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ Exception -> 0x0081 }
            return r2
        L_0x007a:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x007c }
        L_0x007c:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r2)     // Catch:{ Exception -> 0x0081 }
            throw r3     // Catch:{ Exception -> 0x0081 }
        L_0x0081:
            r1 = move-exception
            boolean r2 = r1 instanceof java.io.IOException
            java.lang.String r3 = "E_TAKING_PICTURE_FAILED"
            if (r2 == 0) goto L_0x0093
            expo.modules.kotlin.Promise r2 = r7.promise
            r4 = r1
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            java.lang.String r5 = "An unknown I/O exception has occurred."
            r2.reject(r3, r5, r4)
            goto L_0x009d
        L_0x0093:
            expo.modules.kotlin.Promise r2 = r7.promise
            r4 = r1
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            java.lang.String r5 = "An unknown exception has occurred."
            r2.reject(r3, r5, r4)
        L_0x009d:
            r1.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.camera.tasks.ResolveTakenPictureAsyncTask.handleSkipProcessing():android.os.Bundle");
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Bundle bundle) {
        super.onPostExecute(bundle);
        if (bundle == null) {
            return;
        }
        if (this.options.getFastMode()) {
            Bundle bundle2 = new Bundle();
            Integer id = this.options.getId();
            if (id != null) {
                bundle2.putInt("id", id.intValue());
                bundle2.putBundle("data", bundle);
                this.pictureSavedDelegate.onPictureSaved(bundle2);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        this.promise.resolve(bundle);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String writeStreamToFile(java.io.ByteArrayOutputStream r6) throws java.lang.Exception {
        /*
            r5 = this;
            r0 = 0
            expo.modules.camera.utils.FileSystemUtils r1 = expo.modules.camera.utils.FileSystemUtils.INSTANCE     // Catch:{ IOException -> 0x0029 }
            java.io.File r2 = r5.directory     // Catch:{ IOException -> 0x0029 }
            java.lang.String r3 = "Camera"
            java.lang.String r4 = ".jpg"
            java.lang.String r1 = r1.generateOutputPath(r2, r3, r4)     // Catch:{ IOException -> 0x0029 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0029 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0029 }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ IOException -> 0x0029 }
            r3 = r2
            java.io.FileOutputStream r3 = (java.io.FileOutputStream) r3     // Catch:{ all -> 0x0022 }
            java.io.OutputStream r3 = (java.io.OutputStream) r3     // Catch:{ all -> 0x0022 }
            r6.writeTo(r3)     // Catch:{ all -> 0x0022 }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0022 }
            kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ IOException -> 0x0029 }
            return r1
        L_0x0022:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r6)     // Catch:{ IOException -> 0x0029 }
            throw r1     // Catch:{ IOException -> 0x0029 }
        L_0x0029:
            r6 = move-exception
            r6.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.camera.tasks.ResolveTakenPictureAsyncTask.writeStreamToFile(java.io.ByteArrayOutputStream):java.lang.String");
    }

    private final Bitmap decodeBitmap(byte[] bArr, int i, BitmapFactory.Options options2) {
        if (i != 0) {
            return decodeAndRotateBitmap(bArr, getImageRotation(i), options2);
        }
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options2);
        Intrinsics.checkNotNullExpressionValue(decodeByteArray, "{\n      BitmapFactory.de…ize, bitmapOptions)\n    }");
        return decodeByteArray;
    }

    private final Bitmap decodeAndRotateBitmap(byte[] bArr, int i, BitmapFactory.Options options2) {
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options2);
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(source, 0, …rce.height, matrix, true)");
        return createBitmap;
    }
}
