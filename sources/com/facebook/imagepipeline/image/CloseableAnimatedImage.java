package com.facebook.imagepipeline.image;

import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import javax.annotation.Nullable;

public class CloseableAnimatedImage extends CloseableImage {
    @Nullable
    private AnimatedImageResult mImageResult;
    private boolean mIsStateful;

    public CloseableAnimatedImage(AnimatedImageResult animatedImageResult) {
        this(animatedImageResult, true);
    }

    public CloseableAnimatedImage(AnimatedImageResult animatedImageResult, boolean z) {
        this.mImageResult = animatedImageResult;
        this.mIsStateful = z;
    }

    public synchronized int getWidth() {
        AnimatedImageResult animatedImageResult;
        animatedImageResult = this.mImageResult;
        return animatedImageResult == null ? 0 : animatedImageResult.getImage().getWidth();
    }

    public synchronized int getHeight() {
        AnimatedImageResult animatedImageResult;
        animatedImageResult = this.mImageResult;
        return animatedImageResult == null ? 0 : animatedImageResult.getImage().getHeight();
    }

    public void close() {
        synchronized (this) {
            AnimatedImageResult animatedImageResult = this.mImageResult;
            if (animatedImageResult != null) {
                this.mImageResult = null;
                animatedImageResult.dispose();
            }
        }
    }

    public synchronized boolean isClosed() {
        return this.mImageResult == null;
    }

    public synchronized int getSizeInBytes() {
        AnimatedImageResult animatedImageResult;
        animatedImageResult = this.mImageResult;
        return animatedImageResult == null ? 0 : animatedImageResult.getImage().getSizeInBytes();
    }

    public boolean isStateful() {
        return this.mIsStateful;
    }

    @Nullable
    public synchronized AnimatedImageResult getImageResult() {
        return this.mImageResult;
    }

    @Nullable
    public synchronized AnimatedImage getImage() {
        AnimatedImageResult animatedImageResult;
        animatedImageResult = this.mImageResult;
        return animatedImageResult == null ? null : animatedImageResult.getImage();
    }
}
