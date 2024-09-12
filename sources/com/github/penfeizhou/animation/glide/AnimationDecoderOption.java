package com.github.penfeizhou.animation.glide;

import com.bumptech.glide.load.Option;

public final class AnimationDecoderOption {
    public static final Option<Boolean> DISABLE_ANIMATION_APNG_DECODER = Option.memory("com.github.penfeizhou.animation.glide.AnimationDecoderOption.DISABLE_ANIMATION_APNG_DECODER", false);
    public static final Option<Boolean> DISABLE_ANIMATION_GIF_DECODER = Option.memory("com.github.penfeizhou.animation.glide.AnimationDecoderOption.DISABLE_ANIMATION_GIF_DECODER", false);
    public static final Option<Boolean> DISABLE_ANIMATION_WEBP_DECODER = Option.memory("com.github.penfeizhou.animation.glide.AnimationDecoderOption.DISABLE_ANIMATION_WEBP_DECODER", false);
    public static final Option<Boolean> NO_ANIMATION_BOUNDS_MEASURE = Option.memory("com.github.penfeizhou.animation.glide.AnimationDecoderOption.DISABLE_ANIMATION_BOUNDS_MEASURE", false);

    private AnimationDecoderOption() {
    }
}
