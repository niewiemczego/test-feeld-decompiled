package coil.util;

import coil.decode.ExifOrientationPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ8\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0014"}, d2 = {"Lcoil/util/ImageLoaderOptions;", "", "addLastModifiedToFileCacheKey", "", "networkObserverEnabled", "respectCacheHeaders", "bitmapFactoryMaxParallelism", "", "bitmapFactoryExifOrientationPolicy", "Lcoil/decode/ExifOrientationPolicy;", "(ZZZILcoil/decode/ExifOrientationPolicy;)V", "getAddLastModifiedToFileCacheKey", "()Z", "getBitmapFactoryExifOrientationPolicy", "()Lcoil/decode/ExifOrientationPolicy;", "getBitmapFactoryMaxParallelism", "()I", "getNetworkObserverEnabled", "getRespectCacheHeaders", "copy", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageLoaderOptions.kt */
public final class ImageLoaderOptions {
    private final boolean addLastModifiedToFileCacheKey;
    private final ExifOrientationPolicy bitmapFactoryExifOrientationPolicy;
    private final int bitmapFactoryMaxParallelism;
    private final boolean networkObserverEnabled;
    private final boolean respectCacheHeaders;

    public ImageLoaderOptions() {
        this(false, false, false, 0, (ExifOrientationPolicy) null, 31, (DefaultConstructorMarker) null);
    }

    public ImageLoaderOptions(boolean z, boolean z2, boolean z3, int i, ExifOrientationPolicy exifOrientationPolicy) {
        this.addLastModifiedToFileCacheKey = z;
        this.networkObserverEnabled = z2;
        this.respectCacheHeaders = z3;
        this.bitmapFactoryMaxParallelism = i;
        this.bitmapFactoryExifOrientationPolicy = exifOrientationPolicy;
    }

    public final boolean getAddLastModifiedToFileCacheKey() {
        return this.addLastModifiedToFileCacheKey;
    }

    public final boolean getNetworkObserverEnabled() {
        return this.networkObserverEnabled;
    }

    public final boolean getRespectCacheHeaders() {
        return this.respectCacheHeaders;
    }

    public final int getBitmapFactoryMaxParallelism() {
        return this.bitmapFactoryMaxParallelism;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ImageLoaderOptions(boolean r4, boolean r5, boolean r6, int r7, coil.decode.ExifOrientationPolicy r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 1
            if (r10 == 0) goto L_0x0007
            r10 = r0
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r5
        L_0x000f:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = r6
        L_0x0015:
            r4 = r9 & 8
            if (r4 == 0) goto L_0x001a
            r7 = 4
        L_0x001a:
            r2 = r7
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0021
            coil.decode.ExifOrientationPolicy r8 = coil.decode.ExifOrientationPolicy.RESPECT_PERFORMANCE
        L_0x0021:
            r9 = r8
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r0
            r8 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.util.ImageLoaderOptions.<init>(boolean, boolean, boolean, int, coil.decode.ExifOrientationPolicy, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final ExifOrientationPolicy getBitmapFactoryExifOrientationPolicy() {
        return this.bitmapFactoryExifOrientationPolicy;
    }

    public static /* synthetic */ ImageLoaderOptions copy$default(ImageLoaderOptions imageLoaderOptions, boolean z, boolean z2, boolean z3, int i, ExifOrientationPolicy exifOrientationPolicy, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = imageLoaderOptions.addLastModifiedToFileCacheKey;
        }
        if ((i2 & 2) != 0) {
            z2 = imageLoaderOptions.networkObserverEnabled;
        }
        boolean z4 = z2;
        if ((i2 & 4) != 0) {
            z3 = imageLoaderOptions.respectCacheHeaders;
        }
        boolean z5 = z3;
        if ((i2 & 8) != 0) {
            i = imageLoaderOptions.bitmapFactoryMaxParallelism;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            exifOrientationPolicy = imageLoaderOptions.bitmapFactoryExifOrientationPolicy;
        }
        return imageLoaderOptions.copy(z, z4, z5, i3, exifOrientationPolicy);
    }

    public final ImageLoaderOptions copy(boolean z, boolean z2, boolean z3, int i, ExifOrientationPolicy exifOrientationPolicy) {
        return new ImageLoaderOptions(z, z2, z3, i, exifOrientationPolicy);
    }
}
