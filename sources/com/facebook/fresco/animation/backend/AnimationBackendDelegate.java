package com.facebook.fresco.animation.backend;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.backend.AnimationBackend;
import javax.annotation.Nullable;

public class AnimationBackendDelegate<T extends AnimationBackend> implements AnimationBackend {
    private static final int ALPHA_UNSET = -1;
    private int mAlpha = -1;
    @Nullable
    private T mAnimationBackend;
    @Nullable
    private Rect mBounds;
    @Nullable
    private ColorFilter mColorFilter;

    public AnimationBackendDelegate(@Nullable T t) {
        this.mAnimationBackend = t;
    }

    public int getFrameCount() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.getFrameCount();
    }

    public int getFrameDurationMs(int i) {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.getFrameDurationMs(i);
    }

    public int getLoopCount() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.getLoopCount();
    }

    public boolean drawFrame(Drawable drawable, Canvas canvas, int i) {
        T t = this.mAnimationBackend;
        return t != null && t.drawFrame(drawable, canvas, i);
    }

    public void setAlpha(int i) {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.setAlpha(i);
        }
        this.mAlpha = i;
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.setColorFilter(colorFilter);
        }
        this.mColorFilter = colorFilter;
    }

    public void setBounds(Rect rect) {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.setBounds(rect);
        }
        this.mBounds = rect;
    }

    public int getSizeInBytes() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.getSizeInBytes();
    }

    public void clear() {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.clear();
        }
    }

    public int getIntrinsicWidth() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return -1;
        }
        return t.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return -1;
        }
        return t.getIntrinsicHeight();
    }

    public void setAnimationBackend(@Nullable T t) {
        this.mAnimationBackend = t;
        if (t != null) {
            applyBackendProperties(t);
        }
    }

    @Nullable
    public T getAnimationBackend() {
        return this.mAnimationBackend;
    }

    private void applyBackendProperties(AnimationBackend animationBackend) {
        Rect rect = this.mBounds;
        if (rect != null) {
            animationBackend.setBounds(rect);
        }
        int i = this.mAlpha;
        if (i >= 0 && i <= 255) {
            animationBackend.setAlpha(i);
        }
        ColorFilter colorFilter = this.mColorFilter;
        if (colorFilter != null) {
            animationBackend.setColorFilter(colorFilter);
        }
    }
}
