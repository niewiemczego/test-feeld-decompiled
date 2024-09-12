package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;

public class KeepLastFrameCache implements BitmapFrameCache {
    private static final int FRAME_NUMBER_UNSET = -1;
    @Nullable
    private BitmapFrameCache.FrameCacheListener mFrameCacheListener;
    @Nullable
    private CloseableReference<Bitmap> mLastBitmapReference;
    private int mLastFrameNumber = -1;

    public void onFramePrepared(int i, CloseableReference<Bitmap> closeableReference, int i2) {
    }

    @Nullable
    public synchronized CloseableReference<Bitmap> getCachedFrame(int i) {
        if (this.mLastFrameNumber != i) {
            return null;
        }
        return CloseableReference.cloneOrNull(this.mLastBitmapReference);
    }

    @Nullable
    public synchronized CloseableReference<Bitmap> getFallbackFrame(int i) {
        return CloseableReference.cloneOrNull(this.mLastBitmapReference);
    }

    @Nullable
    public synchronized CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3) {
        CloseableReference<Bitmap> cloneOrNull;
        try {
            cloneOrNull = CloseableReference.cloneOrNull(this.mLastBitmapReference);
            closeAndResetLastBitmapReference();
        } catch (Throwable th) {
            closeAndResetLastBitmapReference();
            throw th;
        }
        return cloneOrNull;
    }

    public synchronized boolean contains(int i) {
        return i == this.mLastFrameNumber && CloseableReference.isValid(this.mLastBitmapReference);
    }

    public synchronized int getSizeInBytes() {
        CloseableReference<Bitmap> closeableReference;
        closeableReference = this.mLastBitmapReference;
        return closeableReference == null ? 0 : BitmapUtil.getSizeInBytes(closeableReference.get());
    }

    public synchronized void clear() {
        closeAndResetLastBitmapReference();
    }

    public synchronized void onFrameRendered(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        int i3;
        if (closeableReference != null) {
            if (this.mLastBitmapReference != null && closeableReference.get().equals(this.mLastBitmapReference.get())) {
                return;
            }
        }
        CloseableReference.closeSafely((CloseableReference<?>) this.mLastBitmapReference);
        BitmapFrameCache.FrameCacheListener frameCacheListener = this.mFrameCacheListener;
        if (!(frameCacheListener == null || (i3 = this.mLastFrameNumber) == -1)) {
            frameCacheListener.onFrameEvicted(this, i3);
        }
        this.mLastBitmapReference = CloseableReference.cloneOrNull(closeableReference);
        BitmapFrameCache.FrameCacheListener frameCacheListener2 = this.mFrameCacheListener;
        if (frameCacheListener2 != null) {
            frameCacheListener2.onFrameCached(this, i);
        }
        this.mLastFrameNumber = i;
    }

    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener frameCacheListener) {
        this.mFrameCacheListener = frameCacheListener;
    }

    private synchronized void closeAndResetLastBitmapReference() {
        int i;
        BitmapFrameCache.FrameCacheListener frameCacheListener = this.mFrameCacheListener;
        if (!(frameCacheListener == null || (i = this.mLastFrameNumber) == -1)) {
            frameCacheListener.onFrameEvicted(this, i);
        }
        CloseableReference.closeSafely((CloseableReference<?>) this.mLastBitmapReference);
        this.mLastBitmapReference = null;
        this.mLastFrameNumber = -1;
    }
}
