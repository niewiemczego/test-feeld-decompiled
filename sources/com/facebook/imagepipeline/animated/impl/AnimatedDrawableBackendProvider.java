package com.facebook.imagepipeline.animated.impl;

import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import javax.annotation.Nullable;

public interface AnimatedDrawableBackendProvider {
    AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, @Nullable Rect rect);
}
