package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import javax.annotation.Nullable;

public interface AnimatedImage {
    public static final int LOOP_COUNT_INFINITE = 0;

    void dispose();

    boolean doesRenderSupportScaling();

    @Nullable
    Bitmap.Config getAnimatedBitmapConfig();

    int getDuration();

    AnimatedImageFrame getFrame(int i);

    int getFrameCount();

    int[] getFrameDurations();

    AnimatedDrawableFrameInfo getFrameInfo(int i);

    int getHeight();

    int getLoopCount();

    int getSizeInBytes();

    int getWidth();
}
