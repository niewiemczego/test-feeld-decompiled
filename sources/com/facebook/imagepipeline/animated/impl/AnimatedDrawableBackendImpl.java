package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import javax.annotation.Nullable;

public class AnimatedDrawableBackendImpl implements AnimatedDrawableBackend {
    private final AnimatedDrawableUtil mAnimatedDrawableUtil;
    private final AnimatedImage mAnimatedImage;
    private final AnimatedImageResult mAnimatedImageResult;
    private final boolean mDownscaleFrameToDrawableDimensions;
    private final int mDurationMs;
    private final int[] mFrameDurationsMs;
    private final AnimatedDrawableFrameInfo[] mFrameInfos;
    private final int[] mFrameTimestampsMs;
    private final Rect mRenderDstRect = new Rect();
    private final Rect mRenderSrcRect = new Rect();
    private final Rect mRenderedBounds;
    @Nullable
    private Bitmap mTempBitmap;

    public AnimatedDrawableBackendImpl(AnimatedDrawableUtil animatedDrawableUtil, AnimatedImageResult animatedImageResult, @Nullable Rect rect, boolean z) {
        this.mAnimatedDrawableUtil = animatedDrawableUtil;
        this.mAnimatedImageResult = animatedImageResult;
        AnimatedImage image = animatedImageResult.getImage();
        this.mAnimatedImage = image;
        int[] frameDurations = image.getFrameDurations();
        this.mFrameDurationsMs = frameDurations;
        animatedDrawableUtil.fixFrameDurations(frameDurations);
        this.mDurationMs = animatedDrawableUtil.getTotalDurationFromFrameDurations(frameDurations);
        this.mFrameTimestampsMs = animatedDrawableUtil.getFrameTimeStampsFromDurations(frameDurations);
        this.mRenderedBounds = getBoundsToUse(image, rect);
        this.mDownscaleFrameToDrawableDimensions = z;
        this.mFrameInfos = new AnimatedDrawableFrameInfo[image.getFrameCount()];
        for (int i = 0; i < this.mAnimatedImage.getFrameCount(); i++) {
            this.mFrameInfos[i] = this.mAnimatedImage.getFrameInfo(i);
        }
    }

    private static Rect getBoundsToUse(AnimatedImage animatedImage, @Nullable Rect rect) {
        if (rect == null) {
            return new Rect(0, 0, animatedImage.getWidth(), animatedImage.getHeight());
        }
        return new Rect(0, 0, Math.min(rect.width(), animatedImage.getWidth()), Math.min(rect.height(), animatedImage.getHeight()));
    }

    public AnimatedImageResult getAnimatedImageResult() {
        return this.mAnimatedImageResult;
    }

    public int getDurationMs() {
        return this.mDurationMs;
    }

    public int getFrameCount() {
        return this.mAnimatedImage.getFrameCount();
    }

    public int getLoopCount() {
        return this.mAnimatedImage.getLoopCount();
    }

    public int getWidth() {
        return this.mAnimatedImage.getWidth();
    }

    public int getHeight() {
        return this.mAnimatedImage.getHeight();
    }

    public int getRenderedWidth() {
        return this.mRenderedBounds.width();
    }

    public int getRenderedHeight() {
        return this.mRenderedBounds.height();
    }

    public AnimatedDrawableFrameInfo getFrameInfo(int i) {
        return this.mFrameInfos[i];
    }

    public int getFrameForTimestampMs(int i) {
        return this.mAnimatedDrawableUtil.getFrameForTimestampMs(this.mFrameTimestampsMs, i);
    }

    public int getTimestampMsForFrame(int i) {
        Preconditions.checkElementIndex(i, this.mFrameTimestampsMs.length);
        return this.mFrameTimestampsMs[i];
    }

    public int getDurationMsForFrame(int i) {
        return this.mFrameDurationsMs[i];
    }

    public int getFrameForPreview() {
        return this.mAnimatedImageResult.getFrameForPreview();
    }

    public AnimatedDrawableBackend forNewBounds(@Nullable Rect rect) {
        if (getBoundsToUse(this.mAnimatedImage, rect).equals(this.mRenderedBounds)) {
            return this;
        }
        return new AnimatedDrawableBackendImpl(this.mAnimatedDrawableUtil, this.mAnimatedImageResult, rect, this.mDownscaleFrameToDrawableDimensions);
    }

    public synchronized int getMemoryUsage() {
        int i;
        i = 0;
        Bitmap bitmap = this.mTempBitmap;
        if (bitmap != null) {
            i = 0 + this.mAnimatedDrawableUtil.getSizeOfBitmap(bitmap);
        }
        return i + this.mAnimatedImage.getSizeInBytes();
    }

    @Nullable
    public CloseableReference<Bitmap> getPreDecodedFrame(int i) {
        return this.mAnimatedImageResult.getDecodedFrame(i);
    }

    public boolean hasPreDecodedFrame(int i) {
        return this.mAnimatedImageResult.hasDecodedFrame(i);
    }

    public void renderFrame(int i, Canvas canvas) {
        AnimatedImageFrame frame = this.mAnimatedImage.getFrame(i);
        try {
            if (this.mAnimatedImage.doesRenderSupportScaling()) {
                renderImageSupportsScaling(canvas, frame);
            } else {
                renderImageDoesNotSupportScaling(canvas, frame);
            }
        } finally {
            frame.dispose();
        }
    }

    private synchronized Bitmap prepareTempBitmapForThisSize(int i, int i2) {
        Bitmap bitmap = this.mTempBitmap;
        if (bitmap != null && (bitmap.getWidth() < i || this.mTempBitmap.getHeight() < i2)) {
            clearTempBitmap();
        }
        if (this.mTempBitmap == null) {
            this.mTempBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.mTempBitmap.eraseColor(0);
        return this.mTempBitmap;
    }

    private void renderImageSupportsScaling(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        double width = ((double) this.mRenderedBounds.width()) / ((double) this.mAnimatedImage.getWidth());
        double height = ((double) this.mRenderedBounds.height()) / ((double) this.mAnimatedImage.getHeight());
        int round = (int) Math.round(((double) animatedImageFrame.getWidth()) * width);
        int round2 = (int) Math.round(((double) animatedImageFrame.getHeight()) * height);
        int xOffset = (int) (((double) animatedImageFrame.getXOffset()) * width);
        int yOffset = (int) (((double) animatedImageFrame.getYOffset()) * height);
        synchronized (this) {
            int width2 = this.mRenderedBounds.width();
            int height2 = this.mRenderedBounds.height();
            prepareTempBitmapForThisSize(width2, height2);
            Bitmap bitmap = this.mTempBitmap;
            if (bitmap != null) {
                animatedImageFrame.renderFrame(round, round2, bitmap);
            }
            this.mRenderSrcRect.set(0, 0, width2, height2);
            this.mRenderDstRect.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            Bitmap bitmap2 = this.mTempBitmap;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, this.mRenderSrcRect, this.mRenderDstRect, (Paint) null);
            }
        }
    }

    private void renderImageDoesNotSupportScaling(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.mDownscaleFrameToDrawableDimensions) {
            float max = Math.max(((float) animatedImageFrame.getWidth()) / ((float) Math.min(animatedImageFrame.getWidth(), canvas.getWidth())), ((float) animatedImageFrame.getHeight()) / ((float) Math.min(animatedImageFrame.getHeight(), canvas.getHeight())));
            i3 = (int) (((float) animatedImageFrame.getWidth()) / max);
            i2 = (int) (((float) animatedImageFrame.getHeight()) / max);
            i = (int) (((float) animatedImageFrame.getXOffset()) / max);
            i4 = (int) (((float) animatedImageFrame.getYOffset()) / max);
        } else {
            i3 = animatedImageFrame.getWidth();
            i2 = animatedImageFrame.getHeight();
            i = animatedImageFrame.getXOffset();
            i4 = animatedImageFrame.getYOffset();
        }
        synchronized (this) {
            Bitmap prepareTempBitmapForThisSize = prepareTempBitmapForThisSize(i3, i2);
            this.mTempBitmap = prepareTempBitmapForThisSize;
            animatedImageFrame.renderFrame(i3, i2, prepareTempBitmapForThisSize);
            canvas.save();
            canvas.translate((float) i, (float) i4);
            canvas.drawBitmap(this.mTempBitmap, 0.0f, 0.0f, (Paint) null);
            canvas.restore();
        }
    }

    public synchronized void dropCaches() {
        clearTempBitmap();
    }

    private synchronized void clearTempBitmap() {
        Bitmap bitmap = this.mTempBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mTempBitmap = null;
        }
    }
}
