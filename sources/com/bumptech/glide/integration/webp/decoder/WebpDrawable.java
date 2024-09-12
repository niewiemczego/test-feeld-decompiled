package com.bumptech.glide.integration.webp.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.webp.decoder.WebpFrameLoader;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class WebpDrawable extends Drawable implements WebpFrameLoader.FrameCallback, Animatable, Animatable2Compat {
    private static final int GRAVITY = 119;
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC = 0;
    private List<Animatable2Compat.AnimationCallback> animationCallbacks;
    private boolean applyGravity;
    private Rect destRect;
    private boolean isRecycled;
    private boolean isRunning;
    private boolean isStarted;
    private boolean isVisible;
    private int loopCount;
    private int maxLoopCount;
    private Paint paint;
    private final WebpState state;

    @Deprecated
    public int getOpacity() {
        return -2;
    }

    /* access modifiers changed from: package-private */
    public void setIsRunning(boolean z) {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WebpDrawable(Context context, WebpDecoder webpDecoder, BitmapPool bitmapPool, Transformation<Bitmap> transformation, int i, int i2, Bitmap bitmap) {
        this(new WebpState(bitmapPool, new WebpFrameLoader(Glide.get(context), webpDecoder, i, i2, transformation, bitmap)));
        BitmapPool bitmapPool2 = bitmapPool;
    }

    WebpDrawable(WebpState webpState) {
        this.isVisible = true;
        this.maxLoopCount = -1;
        this.state = (WebpState) Preconditions.checkNotNull(webpState);
    }

    WebpDrawable(WebpFrameLoader webpFrameLoader, BitmapPool bitmapPool, Paint paint2) {
        this(new WebpState(bitmapPool, webpFrameLoader));
        this.paint = paint2;
    }

    public int getSize() {
        return this.state.frameLoader.getSize();
    }

    public Bitmap getFirstFrame() {
        return this.state.frameLoader.getFirstFrame();
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.state.frameLoader.setFrameTransformation(transformation, bitmap);
    }

    public Transformation<Bitmap> getFrameTransformation() {
        return this.state.frameLoader.getFrameTransformation();
    }

    public ByteBuffer getBuffer() {
        return this.state.frameLoader.getBuffer();
    }

    public int getFrameCount() {
        return this.state.frameLoader.getFrameCount();
    }

    public int getFrameIndex() {
        return this.state.frameLoader.getCurrentIndex();
    }

    private void resetLoopCount() {
        this.loopCount = 0;
    }

    public void startFromFirstFrame() {
        Preconditions.checkArgument(!this.isRunning, "You cannot restart a currently running animation.");
        this.state.frameLoader.setNextStartFromFirstFrame();
        start();
    }

    public void start() {
        this.isStarted = true;
        resetLoopCount();
        if (this.isVisible) {
            startRunning();
        }
    }

    public void stop() {
        this.isStarted = false;
        stopRunning();
    }

    private void startRunning() {
        Preconditions.checkArgument(!this.isRecycled, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.state.frameLoader.getFrameCount() == 1) {
            invalidateSelf();
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.state.frameLoader.subscribe(this);
            invalidateSelf();
        }
    }

    private void stopRunning() {
        this.isRunning = false;
        this.state.frameLoader.unsubscribe(this);
    }

    public boolean setVisible(boolean z, boolean z2) {
        Preconditions.checkArgument(!this.isRecycled, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.isVisible = z;
        if (!z) {
            stopRunning();
        } else if (this.isStarted) {
            startRunning();
        }
        return super.setVisible(z, z2);
    }

    public int getIntrinsicWidth() {
        return this.state.frameLoader.getWidth();
    }

    public int getIntrinsicHeight() {
        return this.state.frameLoader.getHeight();
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.applyGravity = true;
    }

    public void draw(Canvas canvas) {
        if (!isRecycled()) {
            if (this.applyGravity) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), getDestRect());
                this.applyGravity = false;
            }
            Rect rect = null;
            canvas.drawBitmap(this.state.frameLoader.getCurrentFrame(), (Rect) null, getDestRect(), getPaint());
        }
    }

    public void setAlpha(int i) {
        getPaint().setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        getPaint().setColorFilter(colorFilter);
    }

    private Rect getDestRect() {
        if (this.destRect == null) {
            this.destRect = new Rect();
        }
        return this.destRect;
    }

    private Paint getPaint() {
        if (this.paint == null) {
            this.paint = new Paint(2);
        }
        return this.paint;
    }

    private Drawable.Callback findCallback() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    public void onFrameReady() {
        if (findCallback() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (getFrameIndex() == getFrameCount() - 1) {
            this.loopCount++;
        }
        int i = this.maxLoopCount;
        if (i != -1 && this.loopCount >= i) {
            stop();
            notifyAnimationEndToListeners();
        }
    }

    private void notifyAnimationEndToListeners() {
        List<Animatable2Compat.AnimationCallback> list = this.animationCallbacks;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.animationCallbacks.get(i).onAnimationEnd(this);
            }
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    public void recycle() {
        this.isRecycled = true;
        this.state.frameLoader.clear();
    }

    /* access modifiers changed from: package-private */
    public boolean isRecycled() {
        return this.isRecycled;
    }

    public void setLoopCount(int i) {
        int i2 = -1;
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to LOOP_FOREVER, or equal to LOOP_INTRINSIC");
        } else if (i == 0) {
            int loopCount2 = this.state.frameLoader.getLoopCount();
            if (loopCount2 != 0) {
                i2 = loopCount2;
            }
            this.maxLoopCount = i2;
        } else {
            this.maxLoopCount = i;
        }
    }

    public int getLoopCount() {
        return this.maxLoopCount;
    }

    public int getIntrinsicLoopCount() {
        return this.state.frameLoader.getLoopCount();
    }

    public void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback != null) {
            if (this.animationCallbacks == null) {
                this.animationCallbacks = new ArrayList();
            }
            this.animationCallbacks.add(animationCallback);
        }
    }

    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.animationCallbacks;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.animationCallbacks;
        if (list != null) {
            list.clear();
        }
    }

    static class WebpState extends Drawable.ConstantState {
        final BitmapPool bitmapPool;
        final WebpFrameLoader frameLoader;

        public int getChangingConfigurations() {
            return 0;
        }

        public WebpState(BitmapPool bitmapPool2, WebpFrameLoader webpFrameLoader) {
            this.bitmapPool = bitmapPool2;
            this.frameLoader = webpFrameLoader;
        }

        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        public Drawable newDrawable() {
            return new WebpDrawable(this);
        }
    }
}
