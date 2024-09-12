package com.facebook.fresco.animation.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;

public class BitmapAnimationBackend implements AnimationBackend, AnimationBackendDelegateWithInactivityCheck.InactivityListener {
    public static final int FRAME_TYPE_CACHED = 0;
    public static final int FRAME_TYPE_CREATED = 2;
    public static final int FRAME_TYPE_FALLBACK = 3;
    public static final int FRAME_TYPE_REUSED = 1;
    public static final int FRAME_TYPE_UNKNOWN = -1;
    private static final Class<?> TAG = BitmapAnimationBackend.class;
    private final AnimationInformation mAnimationInformation;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;
    private final BitmapFrameCache mBitmapFrameCache;
    @Nullable
    private final BitmapFramePreparationStrategy mBitmapFramePreparationStrategy;
    @Nullable
    private final BitmapFramePreparer mBitmapFramePreparer;
    private final BitmapFrameRenderer mBitmapFrameRenderer;
    private int mBitmapHeight;
    private int mBitmapWidth;
    @Nullable
    private Rect mBounds;
    @Nullable
    private FrameListener mFrameListener;
    private final Paint mPaint;
    private final PlatformBitmapFactory mPlatformBitmapFactory;

    public interface FrameListener {
        void onDrawFrameStart(BitmapAnimationBackend bitmapAnimationBackend, int i);

        void onFrameDrawn(BitmapAnimationBackend bitmapAnimationBackend, int i, int i2);

        void onFrameDropped(BitmapAnimationBackend bitmapAnimationBackend, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FrameType {
    }

    public BitmapAnimationBackend(PlatformBitmapFactory platformBitmapFactory, BitmapFrameCache bitmapFrameCache, AnimationInformation animationInformation, BitmapFrameRenderer bitmapFrameRenderer, @Nullable BitmapFramePreparationStrategy bitmapFramePreparationStrategy, @Nullable BitmapFramePreparer bitmapFramePreparer) {
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBitmapFrameCache = bitmapFrameCache;
        this.mAnimationInformation = animationInformation;
        this.mBitmapFrameRenderer = bitmapFrameRenderer;
        this.mBitmapFramePreparationStrategy = bitmapFramePreparationStrategy;
        this.mBitmapFramePreparer = bitmapFramePreparer;
        this.mPaint = new Paint(6);
        updateBitmapDimensions();
    }

    public void setBitmapConfig(Bitmap.Config config) {
        this.mBitmapConfig = config;
    }

    public void setFrameListener(@Nullable FrameListener frameListener) {
        this.mFrameListener = frameListener;
    }

    public int getFrameCount() {
        return this.mAnimationInformation.getFrameCount();
    }

    public int getFrameDurationMs(int i) {
        return this.mAnimationInformation.getFrameDurationMs(i);
    }

    public int getLoopCount() {
        return this.mAnimationInformation.getLoopCount();
    }

    public boolean drawFrame(Drawable drawable, Canvas canvas, int i) {
        BitmapFramePreparer bitmapFramePreparer;
        FrameListener frameListener;
        FrameListener frameListener2 = this.mFrameListener;
        if (frameListener2 != null) {
            frameListener2.onDrawFrameStart(this, i);
        }
        boolean drawFrameOrFallback = drawFrameOrFallback(canvas, i, 0);
        if (!drawFrameOrFallback && (frameListener = this.mFrameListener) != null) {
            frameListener.onFrameDropped(this, i);
        }
        BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.mBitmapFramePreparationStrategy;
        if (!(bitmapFramePreparationStrategy == null || (bitmapFramePreparer = this.mBitmapFramePreparer) == null)) {
            bitmapFramePreparationStrategy.prepareFrames(bitmapFramePreparer, this.mBitmapFrameCache, this, i);
        }
        return drawFrameOrFallback;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        com.facebook.common.logging.FLog.w(TAG, "Failed to create frame bitmap", (java.lang.Throwable) r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0077, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0078, code lost:
        com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x007b, code lost:
        throw r10;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:7:0x0012, B:10:0x001e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean drawFrameOrFallback(android.graphics.Canvas r10, int r11, int r12) {
        /*
            r9 = this;
            r0 = -1
            r1 = 3
            r2 = 2
            r3 = 0
            r4 = 1
            r5 = 0
            if (r12 == 0) goto L_0x005e
            if (r12 == r4) goto L_0x0044
            if (r12 == r2) goto L_0x001e
            if (r12 == r1) goto L_0x0012
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r5)
            return r3
        L_0x0012:
            com.facebook.fresco.animation.bitmap.BitmapFrameCache r12 = r9.mBitmapFrameCache     // Catch:{ all -> 0x0077 }
            com.facebook.common.references.CloseableReference r5 = r12.getFallbackFrame(r11)     // Catch:{ all -> 0x0077 }
            boolean r12 = r9.drawBitmapAndCache(r11, r5, r10, r1)     // Catch:{ all -> 0x0077 }
            r1 = r0
            goto L_0x0069
        L_0x001e:
            com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory r12 = r9.mPlatformBitmapFactory     // Catch:{ RuntimeException -> 0x0038 }
            int r6 = r9.mBitmapWidth     // Catch:{ RuntimeException -> 0x0038 }
            int r7 = r9.mBitmapHeight     // Catch:{ RuntimeException -> 0x0038 }
            android.graphics.Bitmap$Config r8 = r9.mBitmapConfig     // Catch:{ RuntimeException -> 0x0038 }
            com.facebook.common.references.CloseableReference r5 = r12.createBitmap((int) r6, (int) r7, (android.graphics.Bitmap.Config) r8)     // Catch:{ RuntimeException -> 0x0038 }
            boolean r12 = r9.renderFrameInBitmap(r11, r5)     // Catch:{ all -> 0x0077 }
            if (r12 == 0) goto L_0x005c
            boolean r12 = r9.drawBitmapAndCache(r11, r5, r10, r2)     // Catch:{ all -> 0x0077 }
            if (r12 == 0) goto L_0x005c
            r3 = r4
            goto L_0x005c
        L_0x0038:
            r10 = move-exception
            java.lang.Class<?> r11 = TAG     // Catch:{ all -> 0x0077 }
            java.lang.String r12 = "Failed to create frame bitmap"
            com.facebook.common.logging.FLog.w((java.lang.Class<?>) r11, (java.lang.String) r12, (java.lang.Throwable) r10)     // Catch:{ all -> 0x0077 }
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r5)
            return r3
        L_0x0044:
            com.facebook.fresco.animation.bitmap.BitmapFrameCache r12 = r9.mBitmapFrameCache     // Catch:{ all -> 0x0077 }
            int r1 = r9.mBitmapWidth     // Catch:{ all -> 0x0077 }
            int r6 = r9.mBitmapHeight     // Catch:{ all -> 0x0077 }
            com.facebook.common.references.CloseableReference r5 = r12.getBitmapToReuseForFrame(r11, r1, r6)     // Catch:{ all -> 0x0077 }
            boolean r12 = r9.renderFrameInBitmap(r11, r5)     // Catch:{ all -> 0x0077 }
            if (r12 == 0) goto L_0x005b
            boolean r12 = r9.drawBitmapAndCache(r11, r5, r10, r4)     // Catch:{ all -> 0x0077 }
            if (r12 == 0) goto L_0x005b
            r3 = r4
        L_0x005b:
            r1 = r2
        L_0x005c:
            r12 = r3
            goto L_0x0069
        L_0x005e:
            com.facebook.fresco.animation.bitmap.BitmapFrameCache r12 = r9.mBitmapFrameCache     // Catch:{ all -> 0x0077 }
            com.facebook.common.references.CloseableReference r5 = r12.getCachedFrame(r11)     // Catch:{ all -> 0x0077 }
            boolean r12 = r9.drawBitmapAndCache(r11, r5, r10, r3)     // Catch:{ all -> 0x0077 }
            r1 = r4
        L_0x0069:
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r5)
            if (r12 != 0) goto L_0x0076
            if (r1 != r0) goto L_0x0071
            goto L_0x0076
        L_0x0071:
            boolean r10 = r9.drawFrameOrFallback(r10, r11, r1)
            return r10
        L_0x0076:
            return r12
        L_0x0077:
            r10 = move-exception
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.animation.bitmap.BitmapAnimationBackend.drawFrameOrFallback(android.graphics.Canvas, int, int):boolean");
    }

    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setBounds(@Nullable Rect rect) {
        this.mBounds = rect;
        this.mBitmapFrameRenderer.setBounds(rect);
        updateBitmapDimensions();
    }

    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    public int getSizeInBytes() {
        return this.mBitmapFrameCache.getSizeInBytes();
    }

    public void clear() {
        this.mBitmapFrameCache.clear();
    }

    public void onInactive() {
        clear();
    }

    private void updateBitmapDimensions() {
        int intrinsicWidth = this.mBitmapFrameRenderer.getIntrinsicWidth();
        this.mBitmapWidth = intrinsicWidth;
        int i = -1;
        if (intrinsicWidth == -1) {
            Rect rect = this.mBounds;
            this.mBitmapWidth = rect == null ? -1 : rect.width();
        }
        int intrinsicHeight = this.mBitmapFrameRenderer.getIntrinsicHeight();
        this.mBitmapHeight = intrinsicHeight;
        if (intrinsicHeight == -1) {
            Rect rect2 = this.mBounds;
            if (rect2 != null) {
                i = rect2.height();
            }
            this.mBitmapHeight = i;
        }
    }

    private boolean renderFrameInBitmap(int i, @Nullable CloseableReference<Bitmap> closeableReference) {
        if (!CloseableReference.isValid(closeableReference)) {
            return false;
        }
        boolean renderFrame = this.mBitmapFrameRenderer.renderFrame(i, closeableReference.get());
        if (!renderFrame) {
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
        }
        return renderFrame;
    }

    private boolean drawBitmapAndCache(int i, @Nullable CloseableReference<Bitmap> closeableReference, Canvas canvas, int i2) {
        if (!CloseableReference.isValid(closeableReference)) {
            return false;
        }
        if (this.mBounds == null) {
            canvas.drawBitmap(closeableReference.get(), 0.0f, 0.0f, this.mPaint);
        } else {
            canvas.drawBitmap(closeableReference.get(), (Rect) null, this.mBounds, this.mPaint);
        }
        if (i2 != 3) {
            this.mBitmapFrameCache.onFrameRendered(i, closeableReference, i2);
        }
        FrameListener frameListener = this.mFrameListener;
        if (frameListener == null) {
            return true;
        }
        frameListener.onFrameDrawn(this, i, i2);
        return true;
    }
}
