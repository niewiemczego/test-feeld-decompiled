package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;

public class FrescoFrameCache implements BitmapFrameCache {
    private static final Class<?> TAG = FrescoFrameCache.class;
    private final AnimatedFrameCache mAnimatedFrameCache;
    private final boolean mEnableBitmapReusing;
    @Nullable
    private CloseableReference<CloseableImage> mLastRenderedItem;
    private final SparseArray<CloseableReference<CloseableImage>> mPreparedPendingFrames = new SparseArray<>();

    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener frameCacheListener) {
    }

    public FrescoFrameCache(AnimatedFrameCache animatedFrameCache, boolean z) {
        this.mAnimatedFrameCache = animatedFrameCache;
        this.mEnableBitmapReusing = z;
    }

    @Nullable
    public synchronized CloseableReference<Bitmap> getCachedFrame(int i) {
        return convertToBitmapReferenceAndClose(this.mAnimatedFrameCache.get(i));
    }

    @Nullable
    public synchronized CloseableReference<Bitmap> getFallbackFrame(int i) {
        return convertToBitmapReferenceAndClose(CloseableReference.cloneOrNull(this.mLastRenderedItem));
    }

    @Nullable
    public synchronized CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3) {
        if (!this.mEnableBitmapReusing) {
            return null;
        }
        return convertToBitmapReferenceAndClose(this.mAnimatedFrameCache.getForReuse());
    }

    public synchronized boolean contains(int i) {
        return this.mAnimatedFrameCache.contains(i);
    }

    public synchronized int getSizeInBytes() {
        return getBitmapSizeBytes(this.mLastRenderedItem) + getPreparedPendingFramesSizeBytes();
    }

    public synchronized void clear() {
        CloseableReference.closeSafely((CloseableReference<?>) this.mLastRenderedItem);
        this.mLastRenderedItem = null;
        for (int i = 0; i < this.mPreparedPendingFrames.size(); i++) {
            CloseableReference.closeSafely((CloseableReference<?>) this.mPreparedPendingFrames.valueAt(i));
        }
        this.mPreparedPendingFrames.clear();
    }

    public synchronized void onFrameRendered(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        Preconditions.checkNotNull(closeableReference);
        removePreparedReference(i);
        CloseableReference closeableReference2 = null;
        try {
            closeableReference2 = createImageReference(closeableReference);
            if (closeableReference2 != null) {
                CloseableReference.closeSafely((CloseableReference<?>) this.mLastRenderedItem);
                this.mLastRenderedItem = this.mAnimatedFrameCache.cache(i, closeableReference2);
            }
        } finally {
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference2);
        }
    }

    public synchronized void onFramePrepared(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        Preconditions.checkNotNull(closeableReference);
        CloseableReference<CloseableImage> closeableReference2 = null;
        try {
            closeableReference2 = createImageReference(closeableReference);
            if (closeableReference2 != null) {
                CloseableReference<CloseableImage> cache = this.mAnimatedFrameCache.cache(i, closeableReference2);
                if (CloseableReference.isValid(cache)) {
                    CloseableReference.closeSafely((CloseableReference<?>) this.mPreparedPendingFrames.get(i));
                    this.mPreparedPendingFrames.put(i, cache);
                    FLog.v(TAG, "cachePreparedFrame(%d) cached. Pending frames: %s", (Object) Integer.valueOf(i), (Object) this.mPreparedPendingFrames);
                }
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference2);
            }
        } finally {
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference2);
        }
    }

    private synchronized int getPreparedPendingFramesSizeBytes() {
        int i;
        i = 0;
        for (int i2 = 0; i2 < this.mPreparedPendingFrames.size(); i2++) {
            i += getBitmapSizeBytes(this.mPreparedPendingFrames.valueAt(i2));
        }
        return i;
    }

    private synchronized void removePreparedReference(int i) {
        CloseableReference closeableReference = this.mPreparedPendingFrames.get(i);
        if (closeableReference != null) {
            this.mPreparedPendingFrames.delete(i);
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
            FLog.v(TAG, "removePreparedReference(%d) removed. Pending frames: %s", (Object) Integer.valueOf(i), (Object) this.mPreparedPendingFrames);
        }
    }

    @Nullable
    static CloseableReference<Bitmap> convertToBitmapReferenceAndClose(@Nullable CloseableReference<CloseableImage> closeableReference) {
        CloseableStaticBitmap closeableStaticBitmap;
        try {
            if (CloseableReference.isValid(closeableReference) && (closeableReference.get() instanceof CloseableStaticBitmap) && (closeableStaticBitmap = (CloseableStaticBitmap) closeableReference.get()) != null) {
                return closeableStaticBitmap.cloneUnderlyingBitmapReference();
            }
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
            return null;
        } finally {
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
        }
    }

    private static int getBitmapSizeBytes(@Nullable CloseableReference<CloseableImage> closeableReference) {
        if (!CloseableReference.isValid(closeableReference)) {
            return 0;
        }
        return getBitmapSizeBytes(closeableReference.get());
    }

    private static int getBitmapSizeBytes(@Nullable CloseableImage closeableImage) {
        if (!(closeableImage instanceof CloseableBitmap)) {
            return 0;
        }
        return BitmapUtil.getSizeInBytes(((CloseableBitmap) closeableImage).getUnderlyingBitmap());
    }

    @Nullable
    private static CloseableReference<CloseableImage> createImageReference(CloseableReference<Bitmap> closeableReference) {
        return CloseableReference.of(new CloseableStaticBitmap(closeableReference, ImmutableQualityInfo.FULL_QUALITY, 0));
    }
}
