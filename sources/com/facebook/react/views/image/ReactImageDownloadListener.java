package com.facebook.react.views.image;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ForwardingDrawable;
import javax.annotation.Nullable;

public class ReactImageDownloadListener<INFO> extends ForwardingDrawable implements ControllerListener<INFO> {
    private static final int MAX_LEVEL = 10000;

    public void onFailure(String str, Throwable th) {
    }

    public void onFinalImageSet(String str, @Nullable INFO info, @Nullable Animatable animatable) {
    }

    public void onIntermediateImageFailed(String str, Throwable th) {
    }

    public void onIntermediateImageSet(String str, @Nullable INFO info) {
    }

    public void onProgressChange(int i, int i2) {
    }

    public void onRelease(String str) {
    }

    public void onSubmit(String str, Object obj) {
    }

    public ReactImageDownloadListener() {
        super(new EmptyDrawable());
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        onProgressChange(i, 10000);
        return super.onLevelChange(i);
    }

    private static final class EmptyDrawable extends Drawable {
        public void draw(Canvas canvas) {
        }

        public int getOpacity() {
            return -1;
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }

        private EmptyDrawable() {
        }
    }
}
