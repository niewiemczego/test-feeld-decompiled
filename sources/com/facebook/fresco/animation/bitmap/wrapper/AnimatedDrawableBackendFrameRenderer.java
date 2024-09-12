package com.facebook.fresco.animation.bitmap.wrapper;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;

public class AnimatedDrawableBackendFrameRenderer implements BitmapFrameRenderer {
    private static final Class<?> TAG = AnimatedDrawableBackendFrameRenderer.class;
    private AnimatedDrawableBackend mAnimatedDrawableBackend;
    private AnimatedImageCompositor mAnimatedImageCompositor;
    /* access modifiers changed from: private */
    public final BitmapFrameCache mBitmapFrameCache;
    private final AnimatedImageCompositor.Callback mCallback;

    public AnimatedDrawableBackendFrameRenderer(BitmapFrameCache bitmapFrameCache, AnimatedDrawableBackend animatedDrawableBackend) {
        AnonymousClass1 r0 = new AnimatedImageCompositor.Callback() {
            public void onIntermediateResult(int i, Bitmap bitmap) {
            }

            @Nullable
            public CloseableReference<Bitmap> getCachedBitmap(int i) {
                return AnimatedDrawableBackendFrameRenderer.this.mBitmapFrameCache.getCachedFrame(i);
            }
        };
        this.mCallback = r0;
        this.mBitmapFrameCache = bitmapFrameCache;
        this.mAnimatedDrawableBackend = animatedDrawableBackend;
        this.mAnimatedImageCompositor = new AnimatedImageCompositor(this.mAnimatedDrawableBackend, r0);
    }

    public void setBounds(@Nullable Rect rect) {
        AnimatedDrawableBackend forNewBounds = this.mAnimatedDrawableBackend.forNewBounds(rect);
        if (forNewBounds != this.mAnimatedDrawableBackend) {
            this.mAnimatedDrawableBackend = forNewBounds;
            this.mAnimatedImageCompositor = new AnimatedImageCompositor(this.mAnimatedDrawableBackend, this.mCallback);
        }
    }

    public int getIntrinsicWidth() {
        return this.mAnimatedDrawableBackend.getWidth();
    }

    public int getIntrinsicHeight() {
        return this.mAnimatedDrawableBackend.getHeight();
    }

    public boolean renderFrame(int i, Bitmap bitmap) {
        try {
            this.mAnimatedImageCompositor.renderFrame(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            FLog.e(TAG, (Throwable) e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
