package coil.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import coil.ImageLoader;
import coil.decode.Decoder;
import coil.decode.ImageSource;
import coil.fetch.SourceResult;
import coil.request.Options;
import coil.size.Size;
import coil.size.Sizes;
import coil.util.Bitmaps;
import coil.util.Utils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0003\u0016\u0017\u0018B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010\u0015\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\f\u0010\r\u001a\u00020\u000e*\u00020\u0012H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder;", "Lcoil/decode/Decoder;", "source", "Lcoil/decode/ImageSource;", "options", "Lcoil/request/Options;", "(Lcoil/decode/ImageSource;Lcoil/request/Options;)V", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Lkotlinx/coroutines/sync/Semaphore;)V", "exifOrientationPolicy", "Lcoil/decode/ExifOrientationPolicy;", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Lkotlinx/coroutines/sync/Semaphore;Lcoil/decode/ExifOrientationPolicy;)V", "decode", "Lcoil/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureConfig", "", "Landroid/graphics/BitmapFactory$Options;", "exifData", "Lcoil/decode/ExifData;", "configureScale", "Companion", "ExceptionCatchingSource", "Factory", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BitmapFactoryDecoder.kt */
public final class BitmapFactoryDecoder implements Decoder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_MAX_PARALLELISM = 4;
    private final ExifOrientationPolicy exifOrientationPolicy;
    private final Options options;
    private final Semaphore parallelismLock;
    private final ImageSource source;

    public BitmapFactoryDecoder(ImageSource imageSource, Options options2, Semaphore semaphore, ExifOrientationPolicy exifOrientationPolicy2) {
        this.source = imageSource;
        this.options = options2;
        this.parallelismLock = semaphore;
        this.exifOrientationPolicy = exifOrientationPolicy2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BitmapFactoryDecoder(ImageSource imageSource, Options options2, Semaphore semaphore, ExifOrientationPolicy exifOrientationPolicy2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options2, (i & 4) != 0 ? SemaphoreKt.Semaphore$default(Integer.MAX_VALUE, 0, 2, (Object) null) : semaphore, (i & 8) != 0 ? ExifOrientationPolicy.RESPECT_PERFORMANCE : exifOrientationPolicy2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    public /* synthetic */ BitmapFactoryDecoder(ImageSource imageSource, Options options2) {
        this(imageSource, options2, (Semaphore) null, (ExifOrientationPolicy) null, 12, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BitmapFactoryDecoder(ImageSource imageSource, Options options2, Semaphore semaphore, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options2, (i & 4) != 0 ? SemaphoreKt.Semaphore$default(Integer.MAX_VALUE, 0, 2, (Object) null) : semaphore);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    public /* synthetic */ BitmapFactoryDecoder(ImageSource imageSource, Options options2, Semaphore semaphore) {
        this(imageSource, options2, semaphore, (ExifOrientationPolicy) null, 8, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object decode(kotlin.coroutines.Continuation<? super coil.decode.DecodeResult> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof coil.decode.BitmapFactoryDecoder$decode$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            coil.decode.BitmapFactoryDecoder$decode$1 r0 = (coil.decode.BitmapFactoryDecoder$decode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            coil.decode.BitmapFactoryDecoder$decode$1 r0 = new coil.decode.BitmapFactoryDecoder$decode$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r4) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Semaphore r0 = (kotlinx.coroutines.sync.Semaphore) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0031 }
            goto L_0x0073
        L_0x0031:
            r8 = move-exception
            goto L_0x007d
        L_0x0033:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003b:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Semaphore r2 = (kotlinx.coroutines.sync.Semaphore) r2
            java.lang.Object r5 = r0.L$0
            coil.decode.BitmapFactoryDecoder r5 = (coil.decode.BitmapFactoryDecoder) r5
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r2
            goto L_0x005b
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Semaphore r8 = r7.parallelismLock
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r2 = r8.acquire(r0)
            if (r2 != r1) goto L_0x005a
            return r1
        L_0x005a:
            r5 = r7
        L_0x005b:
            coil.decode.BitmapFactoryDecoder$decode$2$1 r2 = new coil.decode.BitmapFactoryDecoder$decode$2$1     // Catch:{ all -> 0x0079 }
            r2.<init>(r5)     // Catch:{ all -> 0x0079 }
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2     // Catch:{ all -> 0x0079 }
            r0.L$0 = r8     // Catch:{ all -> 0x0079 }
            r5 = 0
            r0.L$1 = r5     // Catch:{ all -> 0x0079 }
            r0.label = r3     // Catch:{ all -> 0x0079 }
            java.lang.Object r0 = kotlinx.coroutines.InterruptibleKt.runInterruptible$default(r5, r2, r0, r4, r5)     // Catch:{ all -> 0x0079 }
            if (r0 != r1) goto L_0x0070
            return r1
        L_0x0070:
            r6 = r0
            r0 = r8
            r8 = r6
        L_0x0073:
            coil.decode.DecodeResult r8 = (coil.decode.DecodeResult) r8     // Catch:{ all -> 0x0031 }
            r0.release()
            return r8
        L_0x0079:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
        L_0x007d:
            r0.release()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.BitmapFactoryDecoder.decode(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c4, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c7, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final coil.decode.DecodeResult decode(android.graphics.BitmapFactory.Options r9) {
        /*
            r8 = this;
            coil.decode.BitmapFactoryDecoder$ExceptionCatchingSource r0 = new coil.decode.BitmapFactoryDecoder$ExceptionCatchingSource
            coil.decode.ImageSource r1 = r8.source
            okio.BufferedSource r1 = r1.source()
            okio.Source r1 = (okio.Source) r1
            r0.<init>(r1)
            r1 = r0
            okio.Source r1 = (okio.Source) r1
            okio.BufferedSource r1 = okio.Okio.buffer((okio.Source) r1)
            r2 = 1
            r9.inJustDecodeBounds = r2
            okio.BufferedSource r3 = r1.peek()
            java.io.InputStream r3 = r3.inputStream()
            r4 = 0
            android.graphics.BitmapFactory.decodeStream(r3, r4, r9)
            java.lang.Exception r3 = r0.getException()
            if (r3 != 0) goto L_0x00c9
            r3 = 0
            r9.inJustDecodeBounds = r3
            coil.decode.ExifUtils r5 = coil.decode.ExifUtils.INSTANCE
            java.lang.String r6 = r9.outMimeType
            coil.decode.ExifOrientationPolicy r7 = r8.exifOrientationPolicy
            coil.decode.ExifData r5 = r5.getExifData(r6, r1, r7)
            java.lang.Exception r6 = r0.getException()
            if (r6 != 0) goto L_0x00c8
            r9.inMutable = r3
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 26
            if (r6 < r7) goto L_0x0054
            coil.request.Options r6 = r8.options
            android.graphics.ColorSpace r6 = r6.getColorSpace()
            if (r6 == 0) goto L_0x0054
            coil.request.Options r6 = r8.options
            android.graphics.ColorSpace r6 = r6.getColorSpace()
            r9.inPreferredColorSpace = r6
        L_0x0054:
            coil.request.Options r6 = r8.options
            boolean r6 = r6.getPremultipliedAlpha()
            r9.inPremultiplied = r6
            r8.configureConfig(r9, r5)
            r8.configureScale(r9, r5)
            java.io.Closeable r1 = (java.io.Closeable) r1
            r6 = r1
            okio.BufferedSource r6 = (okio.BufferedSource) r6     // Catch:{ all -> 0x00c1 }
            java.io.InputStream r6 = r6.inputStream()     // Catch:{ all -> 0x00c1 }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r6, r4, r9)     // Catch:{ all -> 0x00c1 }
            kotlin.io.CloseableKt.closeFinally(r1, r4)
            java.lang.Exception r0 = r0.getException()
            if (r0 != 0) goto L_0x00c0
            if (r6 == 0) goto L_0x00b4
            coil.request.Options r0 = r8.options
            android.content.Context r0 = r0.getContext()
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.densityDpi
            r6.setDensity(r0)
            coil.decode.ExifUtils r0 = coil.decode.ExifUtils.INSTANCE
            android.graphics.Bitmap r0 = r0.reverseTransformations(r6, r5)
            coil.decode.DecodeResult r1 = new coil.decode.DecodeResult
            coil.request.Options r4 = r8.options
            android.content.Context r4 = r4.getContext()
            android.content.res.Resources r4 = r4.getResources()
            android.graphics.drawable.BitmapDrawable r5 = new android.graphics.drawable.BitmapDrawable
            r5.<init>(r4, r0)
            android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5
            int r0 = r9.inSampleSize
            if (r0 > r2) goto L_0x00b0
            boolean r9 = r9.inScaled
            if (r9 == 0) goto L_0x00af
            goto L_0x00b0
        L_0x00af:
            r2 = r3
        L_0x00b0:
            r1.<init>(r5, r2)
            return r1
        L_0x00b4:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format."
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L_0x00c0:
            throw r0
        L_0x00c1:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x00c3 }
        L_0x00c3:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r9)
            throw r0
        L_0x00c8:
            throw r6
        L_0x00c9:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.BitmapFactoryDecoder.decode(android.graphics.BitmapFactory$Options):coil.decode.DecodeResult");
    }

    private final void configureConfig(BitmapFactory.Options options2, ExifData exifData) {
        Bitmap.Config config = this.options.getConfig();
        if (exifData.isFlipped() || ExifUtilsKt.isRotated(exifData)) {
            config = Bitmaps.toSoftware(config);
        }
        if (this.options.getAllowRgb565() && config == Bitmap.Config.ARGB_8888 && Intrinsics.areEqual((Object) options2.outMimeType, (Object) "image/jpeg")) {
            config = Bitmap.Config.RGB_565;
        }
        if (Build.VERSION.SDK_INT >= 26 && options2.outConfig == Bitmap.Config.RGBA_F16 && config != Bitmap.Config.HARDWARE) {
            config = Bitmap.Config.RGBA_F16;
        }
        options2.inPreferredConfig = config;
    }

    private final void configureScale(BitmapFactory.Options options2, ExifData exifData) {
        BitmapFactory.Options options3 = options2;
        ImageSource.Metadata metadata = this.source.getMetadata();
        if (!(metadata instanceof ResourceMetadata) || !Sizes.isOriginal(this.options.getSize())) {
            boolean z = false;
            if (options3.outWidth <= 0 || options3.outHeight <= 0) {
                options3.inSampleSize = 1;
                options3.inScaled = false;
                return;
            }
            int i = ExifUtilsKt.isSwapped(exifData) ? options3.outHeight : options3.outWidth;
            int i2 = ExifUtilsKt.isSwapped(exifData) ? options3.outWidth : options3.outHeight;
            Size size = this.options.getSize();
            int px = Sizes.isOriginal(size) ? i : Utils.toPx(size.getWidth(), this.options.getScale());
            Size size2 = this.options.getSize();
            int px2 = Sizes.isOriginal(size2) ? i2 : Utils.toPx(size2.getHeight(), this.options.getScale());
            options3.inSampleSize = DecodeUtils.calculateInSampleSize(i, i2, px, px2, this.options.getScale());
            double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(((double) i) / ((double) options3.inSampleSize), ((double) i2) / ((double) options3.inSampleSize), (double) px, (double) px2, this.options.getScale());
            if (this.options.getAllowInexactSize()) {
                computeSizeMultiplier = RangesKt.coerceAtMost(computeSizeMultiplier, 1.0d);
            }
            if (computeSizeMultiplier == 1.0d) {
                z = true;
            }
            options3.inScaled = !z;
            if (!options3.inScaled) {
                return;
            }
            if (computeSizeMultiplier > 1.0d) {
                options3.inDensity = MathKt.roundToInt(((double) Integer.MAX_VALUE) / computeSizeMultiplier);
                options3.inTargetDensity = Integer.MAX_VALUE;
                return;
            }
            options3.inDensity = Integer.MAX_VALUE;
            options3.inTargetDensity = MathKt.roundToInt(((double) Integer.MAX_VALUE) * computeSizeMultiplier);
            return;
        }
        options3.inSampleSize = 1;
        options3.inScaled = true;
        options3.inDensity = ((ResourceMetadata) metadata).getDensity();
        options3.inTargetDensity = this.options.getContext().getResources().getDisplayMetrics().densityDpi;
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0017¢\u0006\u0002\u0010\u0002B\u0011\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$Factory;", "Lcoil/decode/Decoder$Factory;", "()V", "maxParallelism", "", "(I)V", "exifOrientationPolicy", "Lcoil/decode/ExifOrientationPolicy;", "(ILcoil/decode/ExifOrientationPolicy;)V", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "create", "Lcoil/decode/Decoder;", "result", "Lcoil/fetch/SourceResult;", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "equals", "", "other", "", "hashCode", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BitmapFactoryDecoder.kt */
    public static final class Factory implements Decoder.Factory {
        private final ExifOrientationPolicy exifOrientationPolicy;
        private final Semaphore parallelismLock;

        public Factory(int i, ExifOrientationPolicy exifOrientationPolicy2) {
            this.exifOrientationPolicy = exifOrientationPolicy2;
            this.parallelismLock = SemaphoreKt.Semaphore$default(i, 0, 2, (Object) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(int i, ExifOrientationPolicy exifOrientationPolicy2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 4 : i, (i2 & 2) != 0 ? ExifOrientationPolicy.RESPECT_PERFORMANCE : exifOrientationPolicy2);
        }

        public Factory() {
            this(0, (ExifOrientationPolicy) null, 3, (DefaultConstructorMarker) null);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
        public /* synthetic */ Factory(int i) {
            this(i, (ExifOrientationPolicy) null, 2, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 4 : i);
        }

        public Decoder create(SourceResult sourceResult, Options options, ImageLoader imageLoader) {
            return new BitmapFactoryDecoder(sourceResult.getSource(), options, this.parallelismLock, this.exifOrientationPolicy);
        }

        public boolean equals(Object obj) {
            return obj instanceof Factory;
        }

        public int hashCode() {
            return getClass().hashCode();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016R.\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$ExceptionCatchingSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "(Lokio/Source;)V", "<set-?>", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "getException", "()Ljava/lang/Exception;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BitmapFactoryDecoder.kt */
    private static final class ExceptionCatchingSource extends ForwardingSource {
        private Exception exception;

        public ExceptionCatchingSource(Source source) {
            super(source);
        }

        public final Exception getException() {
            return this.exception;
        }

        public long read(Buffer buffer, long j) {
            try {
                return super.read(buffer, j);
            } catch (Exception e) {
                this.exception = e;
                throw e;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$Companion;", "", "()V", "DEFAULT_MAX_PARALLELISM", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BitmapFactoryDecoder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
