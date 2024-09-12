package com.braze.support;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.braze.enums.BrazeViewBounds;
import com.braze.support.BrazeLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0007\u001a,\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a\"\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u001a\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u000e\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015\u001a$\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002\u001a\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001d2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u000e\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0006\u0010 \u001a\u00020\u0001\u001a \u0010!\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001\u001a\u0016\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0001\u001a\"\u0010%\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a\u0018\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u000f2\u0006\u0010)\u001a\u00020*\u001a\u0014\u0010+\u001a\u00020'*\u00020*2\b\u0010(\u001a\u0004\u0018\u00010\u000f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\u00020\u00018\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"MAX_IMAGE_CACHE_SIZE_BYTES", "", "MIN_IMAGE_CACHE_SIZE_BYTES", "QUARTER_MAX_SAMPLED_IMAGE_BYTES", "RUNTIME_MEMORY_IMAGE_LOADER_USAGE_QUOTIENT", "getRUNTIME_MEMORY_IMAGE_LOADER_USAGE_QUOTIENT$annotations", "()V", "TAG", "", "calculateInSampleSize", "options", "Landroid/graphics/BitmapFactory$Options;", "destinationWidth", "destinationHeight", "decodeSampledBitmapFromStream", "Landroid/graphics/Bitmap;", "inputStream", "Ljava/io/InputStream;", "imageMetadata", "getBitmap", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "viewBounds", "Lcom/braze/enums/BrazeViewBounds;", "getBitmapMetadataFromStream", "getDensityDpi", "getDestinationHeightAndWidthPixels", "Lkotlin/Pair;", "getDisplayHeightAndWidthPixels", "getDisplayWidthPixels", "getImageLoaderCacheSize", "getLocalBitmap", "getPixelsFromDensityAndDp", "dpi", "dp", "getRemoteBitmap", "resizeImageViewToBitmapDimensions", "", "bitmap", "imageView", "Landroid/widget/ImageView;", "resizeToBitmapDimensions", "android-sdk-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BrazeImageUtils {
    private static final int MAX_IMAGE_CACHE_SIZE_BYTES = 33554432;
    private static final int MIN_IMAGE_CACHE_SIZE_BYTES = 1024;
    private static final int QUARTER_MAX_SAMPLED_IMAGE_BYTES = 4194304;
    public static final int RUNTIME_MEMORY_IMAGE_LOADER_USAGE_QUOTIENT = 8;
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("BrazeImageUtils");

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not sampling on 0 destination width or height";
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ BitmapFactory.Options b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(BitmapFactory.Options options, int i, int i2) {
            super(0);
            this.b = options;
            this.c = i;
            this.d = i2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Calculating sample size for source image bounds: (width " + this.b.outWidth + " height " + this.b.outHeight + ") and destination image bounds: (width " + this.c + " height " + this.d + ')';
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ Ref.IntRef b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Ref.IntRef intRef, long j, long j2) {
            super(0);
            this.b = intRef;
            this.c = j;
            this.d = j2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Using image sample size of " + this.b.element + ". Image will be scaled to width: " + (this.c / ((long) this.b.element)) + " and height: " + (this.d / ((long) this.b.element));
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ Uri b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Uri uri) {
            super(0);
            this.b = uri;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Uri with unknown scheme received. Not getting image. Uri: " + this.b;
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(int i, int i2) {
            super(0);
            this.b = i;
            this.c = i2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Display width: " + this.b + " and height " + this.c;
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ Uri b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(Uri uri) {
            super(0);
            this.b = uri;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Local bitmap path is null. URI: " + this.b;
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ Uri b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(Uri uri) {
            super(0);
            this.b = uri;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Local bitmap file does not exist. URI: " + this.b;
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ File b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(File file) {
            super(0);
            this.b = file;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Retrieving image from local path: " + this.b.getAbsolutePath();
        }
    }

    static final class i extends Lambda implements Function0 {
        public static final i b = new i();

        i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Destination bounds unset. Loading entire bitmap into memory.";
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(int i, int i2) {
            super(0);
            this.b = i;
            this.c = i2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Sampling bitmap with destination image bounds: (width " + this.b + " height " + this.c + ')';
        }
    }

    static final class k extends Lambda implements Function0 {
        final /* synthetic */ Uri b;
        final /* synthetic */ BitmapFactory.Options c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(Uri uri, BitmapFactory.Options options) {
            super(0);
            this.b = uri;
            this.c = options;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The bitmap metadata with image uri " + this.b + " had bounds: (height " + this.c.outHeight + " width " + this.c.outWidth + "). Returning a bitmap with no sampling.";
        }
    }

    static final class l extends Lambda implements Function0 {
        public static final l b = new l();

        l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Decoding sampled bitmap";
        }
    }

    static final class m extends Lambda implements Function0 {
        final /* synthetic */ Exception b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(Exception exc) {
            super(0);
            this.b = exc;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exception occurred when attempting to retrieve local bitmap. " + this.b.getMessage();
        }
    }

    static final class n extends Lambda implements Function0 {
        public static final n b = new n();

        n() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "IOException during closing of bitmap metadata image stream.";
        }
    }

    static final class o extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "SDK is in offline mode, not downloading remote bitmap with uri: " + this.b;
        }
    }

    static final class p extends Lambda implements Function0 {
        final /* synthetic */ int b;
        final /* synthetic */ URL c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(int i, URL url) {
            super(0);
            this.b = i;
            this.c = url;
        }

        /* renamed from: a */
        public final String invoke() {
            return "HTTP response code was " + this.b + ". Bitmap with url " + this.c + " could not be downloaded.";
        }
    }

    static final class q extends Lambda implements Function0 {
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(int i, int i2) {
            super(0);
            this.b = i;
            this.c = i2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Sampling bitmap with destination image bounds: (height " + this.b + " width " + this.c + ')';
        }
    }

    static final class r extends Lambda implements Function0 {
        final /* synthetic */ URL b;
        final /* synthetic */ BitmapFactory.Options c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(URL url, BitmapFactory.Options options) {
            super(0);
            this.b = url;
            this.c = options;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The bitmap metadata with image url " + this.b + " had bounds: (height " + this.c.outHeight + " width " + this.c.outWidth + "). Returning a bitmap with no sampling.";
        }
    }

    static final class s extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Exception c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(String str, Exception exc) {
            super(0);
            this.b = str;
            this.c = exc;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exception in image bitmap download for Uri: " + this.b + ' ' + this.c.getMessage();
        }
    }

    static final class t extends Lambda implements Function0 {
        public static final t b = new t();

        t() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "IOException during closing of bitmap metadata download stream.";
        }
    }

    static final class u extends Lambda implements Function0 {
        public static final u b = new u();

        u() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Neither source bitmap nor ImageView may be null. Not resizing ImageView";
        }
    }

    static final class v extends Lambda implements Function0 {
        final /* synthetic */ ImageView b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(ImageView imageView) {
            super(0);
            this.b = imageView;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Bitmap dimensions cannot be 0. Not resizing ImageView " + this.b;
        }
    }

    static final class w extends Lambda implements Function0 {
        final /* synthetic */ ImageView b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(ImageView imageView) {
            super(0);
            this.b = imageView;
        }

        /* renamed from: a */
        public final String invoke() {
            return "ImageView dimensions cannot be 0. Not resizing ImageView " + this.b;
        }
    }

    static final class x extends Lambda implements Function0 {
        final /* synthetic */ float b;
        final /* synthetic */ ImageView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(float f, ImageView imageView) {
            super(0);
            this.b = f;
            this.c = imageView;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Resizing ImageView to aspect ratio " + this.b + " based on width: " + this.c.getWidth() + " layoutParams: " + this.c.getLayoutParams() + ' ' + this.c;
        }
    }

    public static final int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        long j2;
        long j3;
        BitmapFactory.Options options2 = options;
        int i4 = i2;
        int i5 = i3;
        Intrinsics.checkNotNullParameter(options2, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        if (i5 == 0 || i4 == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, (Function0) a.b, 6, (Object) null);
            return 1;
        }
        long j4 = (long) options2.outHeight;
        long j5 = (long) options2.outWidth;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new b(options2, i4, i5), 6, (Object) null);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 1;
        long j6 = (long) i5;
        if (j4 > j6 || j5 > ((long) i4)) {
            long j7 = (long) 2;
            long j8 = j4 / j7;
            long j9 = j5 / j7;
            while (true) {
                int i6 = intRef.element;
                j2 = j5;
                long j10 = (long) i6;
                if (j8 / j10 < j6) {
                    j3 = j6;
                    if (j9 / j10 < ((long) i4) && (j2 * j4) / ((long) (i6 * i6)) <= PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED) {
                        break;
                    }
                } else {
                    j3 = j6;
                }
                intRef.element = i6 * 2;
                j5 = j2;
                j6 = j3;
            }
        } else {
            j2 = j5;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new c(intRef, j2, j4), 6, (Object) null);
        return intRef.element;
    }

    private static final Bitmap decodeSampledBitmapFromStream(InputStream inputStream, BitmapFactory.Options options, int i2, int i3) {
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(inputStream, (Rect) null, options);
    }

    public static final Bitmap getBitmap(Context context, Uri uri, BrazeViewBounds brazeViewBounds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(brazeViewBounds, "viewBounds");
        Pair<Integer, Integer> destinationHeightAndWidthPixels = getDestinationHeightAndWidthPixels(context, brazeViewBounds);
        int intValue = destinationHeightAndWidthPixels.component1().intValue();
        int intValue2 = destinationHeightAndWidthPixels.component2().intValue();
        if (BrazeFileUtils.isLocalUri(uri)) {
            return getLocalBitmap(uri, intValue2, intValue);
        }
        if (BrazeFileUtils.isRemoteUri(uri)) {
            return getRemoteBitmap(uri, intValue2, intValue);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, (Function0) new d(uri), 4, (Object) null);
        return null;
    }

    public static /* synthetic */ Bitmap getBitmap$default(Context context, Uri uri, BrazeViewBounds brazeViewBounds, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            brazeViewBounds = BrazeViewBounds.NO_BOUNDS;
        }
        return getBitmap(context, uri, brazeViewBounds);
    }

    public static final BitmapFactory.Options getBitmapMetadataFromStream(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, (Rect) null, options);
        return options;
    }

    public static final int getDensityDpi(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getConfiguration().densityDpi;
    }

    private static final Pair<Integer, Integer> getDestinationHeightAndWidthPixels(Context context, BrazeViewBounds brazeViewBounds) {
        Pair<Integer, Integer> displayHeightAndWidthPixels = getDisplayHeightAndWidthPixels(context);
        int intValue = displayHeightAndWidthPixels.component1().intValue();
        int intValue2 = displayHeightAndWidthPixels.component2().intValue();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.V, (Throwable) null, (Function0) new e(intValue2, intValue), 4, (Object) null);
        if (BrazeViewBounds.NO_BOUNDS == brazeViewBounds) {
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
        }
        int densityDpi = getDensityDpi(context);
        return new Pair<>(Integer.valueOf(Math.min(intValue, getPixelsFromDensityAndDp(densityDpi, brazeViewBounds.getHeightDp()))), Integer.valueOf(Math.min(intValue2, getPixelsFromDensityAndDp(densityDpi, brazeViewBounds.getWidthDp()))));
    }

    public static final Pair<Integer, Integer> getDisplayHeightAndWidthPixels(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new Pair<>(Integer.valueOf(displayMetrics.heightPixels), Integer.valueOf(displayMetrics.widthPixels));
    }

    public static final int getDisplayWidthPixels(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getDisplayHeightAndWidthPixels(context).getSecond().intValue();
    }

    public static final int getImageLoaderCacheSize() {
        return Math.max(1024, Math.min((int) Math.min(Runtime.getRuntime().maxMemory() / ((long) 8), 2147483647L), MAX_IMAGE_CACHE_SIZE_BYTES));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018 A[Catch:{ Exception -> 0x00dd, all -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029 A[Catch:{ Exception -> 0x00dd, all -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ef A[SYNTHETIC, Splitter:B:53:0x00ef] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0105 A[SYNTHETIC, Splitter:B:62:0x0105] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.graphics.Bitmap getLocalBitmap(android.net.Uri r13, int r14, int r15) {
        /*
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 0
            java.lang.String r1 = r13.getPath()     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            if (r1 == 0) goto L_0x0015
            int r2 = r1.length()     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            if (r2 != 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r2 = 0
            goto L_0x0016
        L_0x0015:
            r2 = 1
        L_0x0016:
            if (r2 == 0) goto L_0x0029
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            java.lang.String r4 = TAG     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            r5 = 0
            r6 = 0
            com.braze.support.BrazeImageUtils$f r7 = new com.braze.support.BrazeImageUtils$f     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            r7.<init>(r13)     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            r8 = 6
            r9 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.String) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            return r0
        L_0x0029:
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            r2.<init>(r1)     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            boolean r1 = r2.exists()     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            if (r1 != 0) goto L_0x0045
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            java.lang.String r4 = TAG     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            r5 = 0
            r6 = 0
            com.braze.support.BrazeImageUtils$g r7 = new com.braze.support.BrazeImageUtils$g     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            r7.<init>(r13)     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            r8 = 6
            r9 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.String) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            return r0
        L_0x0045:
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            java.lang.String r10 = TAG     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.I     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            r6 = 0
            com.braze.support.BrazeImageUtils$h r7 = new com.braze.support.BrazeImageUtils$h     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            r7.<init>(r2)     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            r8 = 4
            r9 = 0
            r3 = r1
            r4 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.String) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            if (r14 <= 0) goto L_0x00c7
            if (r15 > 0) goto L_0x005e
            goto L_0x00c7
        L_0x005e:
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            r11.<init>(r2)     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            r5 = 0
            r6 = 0
            com.braze.support.BrazeImageUtils$j r7 = new com.braze.support.BrazeImageUtils$j     // Catch:{ Exception -> 0x00c5, all -> 0x00c3 }
            r7.<init>(r14, r15)     // Catch:{ Exception -> 0x00c5, all -> 0x00c3 }
            r8 = 6
            r9 = 0
            r3 = r1
            r4 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.String) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x00c5, all -> 0x00c3 }
            android.graphics.BitmapFactory$Options r8 = getBitmapMetadataFromStream(r11)     // Catch:{ Exception -> 0x00c5, all -> 0x00c3 }
            r11.close()     // Catch:{ Exception -> 0x00c5, all -> 0x00c3 }
            java.io.FileInputStream r12 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00c5, all -> 0x00c3 }
            r12.<init>(r2)     // Catch:{ Exception -> 0x00c5, all -> 0x00c3 }
            int r3 = r8.outHeight     // Catch:{ Exception -> 0x00c0, all -> 0x00bd }
            if (r3 == 0) goto L_0x0095
            int r3 = r8.outWidth     // Catch:{ Exception -> 0x00c0, all -> 0x00bd }
            if (r3 != 0) goto L_0x0086
            goto L_0x0095
        L_0x0086:
            r3 = 0
            r4 = 0
            com.braze.support.BrazeImageUtils$l r5 = com.braze.support.BrazeImageUtils.l.b     // Catch:{ Exception -> 0x00c0, all -> 0x00bd }
            r6 = 6
            r7 = 0
            r2 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.String) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ Exception -> 0x00c0, all -> 0x00bd }
            android.graphics.Bitmap r13 = decodeSampledBitmapFromStream(r12, r8, r14, r15)     // Catch:{ Exception -> 0x00c0, all -> 0x00bd }
            goto L_0x00ac
        L_0x0095:
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x00c0, all -> 0x00bd }
            r6 = 0
            com.braze.support.BrazeImageUtils$k r7 = new com.braze.support.BrazeImageUtils$k     // Catch:{ Exception -> 0x00c0, all -> 0x00bd }
            r7.<init>(r13, r8)     // Catch:{ Exception -> 0x00c0, all -> 0x00bd }
            r8 = 4
            r9 = 0
            r3 = r1
            r4 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.String) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x00c0, all -> 0x00bd }
            java.lang.String r13 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x00c0, all -> 0x00bd }
            android.graphics.Bitmap r13 = android.graphics.BitmapFactory.decodeFile(r13)     // Catch:{ Exception -> 0x00c0, all -> 0x00bd }
        L_0x00ac:
            r12.close()     // Catch:{ IOException -> 0x00b0 }
            goto L_0x00bc
        L_0x00b0:
            r14 = move-exception
            com.braze.support.BrazeLogger r15 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r0 = TAG
            com.braze.support.BrazeLogger$Priority r1 = com.braze.support.BrazeLogger.Priority.E
            com.braze.support.BrazeImageUtils$n r2 = com.braze.support.BrazeImageUtils.n.b
            r15.brazelog((java.lang.String) r0, (com.braze.support.BrazeLogger.Priority) r1, (java.lang.Throwable) r14, (kotlin.jvm.functions.Function0<java.lang.String>) r2)
        L_0x00bc:
            return r13
        L_0x00bd:
            r13 = move-exception
            r11 = r12
            goto L_0x0103
        L_0x00c0:
            r13 = move-exception
            r11 = r12
            goto L_0x00df
        L_0x00c3:
            r13 = move-exception
            goto L_0x0103
        L_0x00c5:
            r13 = move-exception
            goto L_0x00df
        L_0x00c7:
            r5 = 0
            r6 = 0
            com.braze.support.BrazeImageUtils$i r7 = com.braze.support.BrazeImageUtils.i.b     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            r8 = 6
            r9 = 0
            r3 = r1
            r4 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.String) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            java.lang.String r13 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            android.graphics.Bitmap r13 = android.graphics.BitmapFactory.decodeFile(r13)     // Catch:{ Exception -> 0x00dd, all -> 0x00db }
            return r13
        L_0x00db:
            r13 = move-exception
            goto L_0x0102
        L_0x00dd:
            r13 = move-exception
            r11 = r0
        L_0x00df:
            com.braze.support.BrazeLogger r14 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x0100 }
            java.lang.String r15 = TAG     // Catch:{ all -> 0x0100 }
            com.braze.support.BrazeLogger$Priority r1 = com.braze.support.BrazeLogger.Priority.E     // Catch:{ all -> 0x0100 }
            com.braze.support.BrazeImageUtils$m r2 = new com.braze.support.BrazeImageUtils$m     // Catch:{ all -> 0x0100 }
            r2.<init>(r13)     // Catch:{ all -> 0x0100 }
            r14.brazelog((java.lang.String) r15, (com.braze.support.BrazeLogger.Priority) r1, (java.lang.Throwable) r13, (kotlin.jvm.functions.Function0<java.lang.String>) r2)     // Catch:{ all -> 0x0100 }
            if (r11 == 0) goto L_0x00ff
            r11.close()     // Catch:{ IOException -> 0x00f3 }
            goto L_0x00ff
        L_0x00f3:
            r13 = move-exception
            com.braze.support.BrazeLogger r14 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r15 = TAG
            com.braze.support.BrazeLogger$Priority r1 = com.braze.support.BrazeLogger.Priority.E
            com.braze.support.BrazeImageUtils$n r2 = com.braze.support.BrazeImageUtils.n.b
            r14.brazelog((java.lang.String) r15, (com.braze.support.BrazeLogger.Priority) r1, (java.lang.Throwable) r13, (kotlin.jvm.functions.Function0<java.lang.String>) r2)
        L_0x00ff:
            return r0
        L_0x0100:
            r13 = move-exception
            r0 = r11
        L_0x0102:
            r11 = r0
        L_0x0103:
            if (r11 == 0) goto L_0x0115
            r11.close()     // Catch:{ IOException -> 0x0109 }
            goto L_0x0115
        L_0x0109:
            r14 = move-exception
            com.braze.support.BrazeLogger r15 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r0 = TAG
            com.braze.support.BrazeLogger$Priority r1 = com.braze.support.BrazeLogger.Priority.E
            com.braze.support.BrazeImageUtils$n r2 = com.braze.support.BrazeImageUtils.n.b
            r15.brazelog((java.lang.String) r0, (com.braze.support.BrazeLogger.Priority) r1, (java.lang.Throwable) r14, (kotlin.jvm.functions.Function0<java.lang.String>) r2)
        L_0x0115:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.support.BrazeImageUtils.getLocalBitmap(android.net.Uri, int, int):android.graphics.Bitmap");
    }

    public static final int getPixelsFromDensityAndDp(int i2, int i3) {
        return Math.abs((i2 * i3) / 160);
    }

    public static /* synthetic */ void getRUNTIME_MEMORY_IMAGE_LOADER_USAGE_QUOTIENT$annotations() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e3 A[SYNTHETIC, Splitter:B:46:0x00e3] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ff A[SYNTHETIC, Splitter:B:57:0x00ff] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final android.graphics.Bitmap getRemoteBitmap(android.net.Uri r17, int r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            r2 = 1337(0x539, float:1.874E-42)
            android.net.TrafficStats.setThreadStatsTag(r2)
            java.lang.String r2 = r17.toString()
            java.lang.String r3 = "uri.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            com.braze.Braze$Companion r3 = com.braze.Braze.Companion
            boolean r3 = r3.getOutboundNetworkRequestsOffline()
            r4 = 0
            if (r3 == 0) goto L_0x002d
            com.braze.support.BrazeLogger r5 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r6 = TAG
            com.braze.support.BrazeLogger$Priority r7 = com.braze.support.BrazeLogger.Priority.I
            com.braze.support.BrazeImageUtils$o r9 = new com.braze.support.BrazeImageUtils$o
            r9.<init>(r2)
            r8 = 0
            r10 = 4
            r11 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r5, (java.lang.String) r6, (com.braze.support.BrazeLogger.Priority) r7, (java.lang.Throwable) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
            return r4
        L_0x002d:
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x00cb, all -> 0x00c7 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00cb, all -> 0x00c7 }
            bo.app.v6 r5 = bo.app.v6.a     // Catch:{ Exception -> 0x00cb, all -> 0x00c7 }
            java.net.HttpURLConnection r6 = r5.a(r3)     // Catch:{ Exception -> 0x00cb, all -> 0x00c7 }
            int r7 = r6.getResponseCode()     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            r8 = 200(0xc8, float:2.8E-43)
            if (r7 == r8) goto L_0x0055
            com.braze.support.BrazeLogger r9 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            java.lang.String r10 = TAG     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            com.braze.support.BrazeLogger$Priority r11 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            r12 = 0
            com.braze.support.BrazeImageUtils$p r13 = new com.braze.support.BrazeImageUtils$p     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            r13.<init>(r7, r3)     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            r14 = 4
            r15 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r9, (java.lang.String) r10, (com.braze.support.BrazeLogger.Priority) r11, (java.lang.Throwable) r12, (kotlin.jvm.functions.Function0) r13, (int) r14, (java.lang.Object) r15)     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            r6.disconnect()
            return r4
        L_0x0055:
            java.io.InputStream r7 = r6.getInputStream()     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            if (r0 == 0) goto L_0x00a2
            if (r1 == 0) goto L_0x00a2
            com.braze.support.BrazeLogger r15 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00be }
            java.lang.String r16 = TAG     // Catch:{ Exception -> 0x00be }
            r10 = 0
            r11 = 0
            com.braze.support.BrazeImageUtils$q r12 = new com.braze.support.BrazeImageUtils$q     // Catch:{ Exception -> 0x00be }
            r12.<init>(r1, r0)     // Catch:{ Exception -> 0x00be }
            r13 = 6
            r14 = 0
            r8 = r15
            r9 = r16
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r8, (java.lang.String) r9, (com.braze.support.BrazeLogger.Priority) r10, (java.lang.Throwable) r11, (kotlin.jvm.functions.Function0) r12, (int) r13, (java.lang.Object) r14)     // Catch:{ Exception -> 0x00be }
            android.graphics.BitmapFactory$Options r8 = getBitmapMetadataFromStream(r7)     // Catch:{ Exception -> 0x00be }
            r6.disconnect()     // Catch:{ Exception -> 0x00be }
            java.net.HttpURLConnection r6 = r5.a(r3)     // Catch:{ Exception -> 0x00be }
            java.io.InputStream r7 = r6.getInputStream()     // Catch:{ Exception -> 0x00be }
            int r5 = r8.outHeight     // Catch:{ Exception -> 0x00be }
            if (r5 == 0) goto L_0x008d
            int r5 = r8.outWidth     // Catch:{ Exception -> 0x00be }
            if (r5 != 0) goto L_0x0088
            goto L_0x008d
        L_0x0088:
            android.graphics.Bitmap r0 = decodeSampledBitmapFromStream(r7, r8, r0, r1)     // Catch:{ Exception -> 0x00be }
            goto L_0x00a6
        L_0x008d:
            com.braze.support.BrazeLogger$Priority r10 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x00be }
            r11 = 0
            com.braze.support.BrazeImageUtils$r r12 = new com.braze.support.BrazeImageUtils$r     // Catch:{ Exception -> 0x00be }
            r12.<init>(r3, r8)     // Catch:{ Exception -> 0x00be }
            r13 = 4
            r14 = 0
            r8 = r15
            r9 = r16
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r8, (java.lang.String) r9, (com.braze.support.BrazeLogger.Priority) r10, (java.lang.Throwable) r11, (kotlin.jvm.functions.Function0) r12, (int) r13, (java.lang.Object) r14)     // Catch:{ Exception -> 0x00be }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r7)     // Catch:{ Exception -> 0x00be }
            goto L_0x00a6
        L_0x00a2:
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r7)     // Catch:{ Exception -> 0x00be }
        L_0x00a6:
            r1 = r0
            r6.disconnect()
            if (r7 == 0) goto L_0x00bd
            r7.close()     // Catch:{ IOException -> 0x00b0 }
            goto L_0x00bd
        L_0x00b0:
            r0 = move-exception
            r2 = r0
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r3 = TAG
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.E
            com.braze.support.BrazeImageUtils$t r5 = com.braze.support.BrazeImageUtils.t.b
            r0.brazelog((java.lang.String) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r2, (kotlin.jvm.functions.Function0<java.lang.String>) r5)
        L_0x00bd:
            return r1
        L_0x00be:
            r0 = move-exception
            goto L_0x00ce
        L_0x00c0:
            r0 = move-exception
            r1 = r0
            r7 = r4
            goto L_0x00f7
        L_0x00c4:
            r0 = move-exception
            r7 = r4
            goto L_0x00ce
        L_0x00c7:
            r0 = move-exception
            r1 = r0
            r7 = r4
            goto L_0x00f8
        L_0x00cb:
            r0 = move-exception
            r6 = r4
            r7 = r6
        L_0x00ce:
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x00f5 }
            java.lang.String r3 = TAG     // Catch:{ all -> 0x00f5 }
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.E     // Catch:{ all -> 0x00f5 }
            com.braze.support.BrazeImageUtils$s r8 = new com.braze.support.BrazeImageUtils$s     // Catch:{ all -> 0x00f5 }
            r8.<init>(r2, r0)     // Catch:{ all -> 0x00f5 }
            r1.brazelog((java.lang.String) r3, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r8)     // Catch:{ all -> 0x00f5 }
            if (r6 == 0) goto L_0x00e1
            r6.disconnect()
        L_0x00e1:
            if (r7 == 0) goto L_0x00f4
            r7.close()     // Catch:{ IOException -> 0x00e7 }
            goto L_0x00f4
        L_0x00e7:
            r0 = move-exception
            r1 = r0
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r2 = TAG
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.E
            com.braze.support.BrazeImageUtils$t r5 = com.braze.support.BrazeImageUtils.t.b
            r0.brazelog((java.lang.String) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r1, (kotlin.jvm.functions.Function0<java.lang.String>) r5)
        L_0x00f4:
            return r4
        L_0x00f5:
            r0 = move-exception
            r1 = r0
        L_0x00f7:
            r4 = r6
        L_0x00f8:
            if (r4 == 0) goto L_0x00fd
            r4.disconnect()
        L_0x00fd:
            if (r7 == 0) goto L_0x0110
            r7.close()     // Catch:{ IOException -> 0x0103 }
            goto L_0x0110
        L_0x0103:
            r0 = move-exception
            r2 = r0
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r3 = TAG
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.E
            com.braze.support.BrazeImageUtils$t r5 = com.braze.support.BrazeImageUtils.t.b
            r0.brazelog((java.lang.String) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r2, (kotlin.jvm.functions.Function0<java.lang.String>) r5)
        L_0x0110:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.support.BrazeImageUtils.getRemoteBitmap(android.net.Uri, int, int):android.graphics.Bitmap");
    }

    public static final void resizeImageViewToBitmapDimensions(Bitmap bitmap, ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        resizeToBitmapDimensions(imageView, bitmap);
    }

    public static final void resizeToBitmapDimensions(ImageView imageView, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (bitmap == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, (Function0) u.b, 4, (Object) null);
        } else if (bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, (Function0) new v(imageView), 4, (Object) null);
        } else if (imageView.getWidth() == 0 || imageView.getHeight() == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, (Function0) new w(imageView), 4, (Object) null);
        } else {
            float width = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
            imageView.getLayoutParams().height = (int) (((float) imageView.getWidth()) / width);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.V, (Throwable) null, (Function0) new x(width, imageView), 4, (Object) null);
            imageView.setLayoutParams(imageView.getLayoutParams());
        }
    }
}
