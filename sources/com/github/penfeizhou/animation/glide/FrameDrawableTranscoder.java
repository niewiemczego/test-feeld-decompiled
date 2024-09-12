package com.github.penfeizhou.animation.glide;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.github.penfeizhou.animation.apng.APNGDrawable;
import com.github.penfeizhou.animation.apng.decode.APNGDecoder;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import com.github.penfeizhou.animation.gif.GifDrawable;
import com.github.penfeizhou.animation.gif.decode.GifDecoder;
import com.github.penfeizhou.animation.webp.WebPDrawable;
import com.github.penfeizhou.animation.webp.decode.WebPDecoder;

class FrameDrawableTranscoder implements ResourceTranscoder<FrameSeqDecoder, Drawable> {
    FrameDrawableTranscoder() {
    }

    public Resource<Drawable> transcode(Resource<FrameSeqDecoder> resource, Options options) {
        FrameSeqDecoder frameSeqDecoder = resource.get();
        boolean booleanValue = ((Boolean) options.get(AnimationDecoderOption.NO_ANIMATION_BOUNDS_MEASURE)).booleanValue();
        if (frameSeqDecoder instanceof APNGDecoder) {
            final APNGDrawable aPNGDrawable = new APNGDrawable((APNGDecoder) frameSeqDecoder);
            aPNGDrawable.setAutoPlay(false);
            aPNGDrawable.setNoMeasure(booleanValue);
            return new DrawableResource<Drawable>(aPNGDrawable) {
                public Class<Drawable> getResourceClass() {
                    return Drawable.class;
                }

                public int getSize() {
                    return aPNGDrawable.getMemorySize();
                }

                public void recycle() {
                    aPNGDrawable.stop();
                }

                public void initialize() {
                    super.initialize();
                }
            };
        } else if (frameSeqDecoder instanceof WebPDecoder) {
            final WebPDrawable webPDrawable = new WebPDrawable((WebPDecoder) frameSeqDecoder);
            webPDrawable.setAutoPlay(false);
            webPDrawable.setNoMeasure(booleanValue);
            return new DrawableResource<Drawable>(webPDrawable) {
                public void recycle() {
                }

                public Class<Drawable> getResourceClass() {
                    return Drawable.class;
                }

                public int getSize() {
                    return webPDrawable.getMemorySize();
                }

                public void initialize() {
                    super.initialize();
                }
            };
        } else if (!(frameSeqDecoder instanceof GifDecoder)) {
            return null;
        } else {
            final GifDrawable gifDrawable = new GifDrawable((GifDecoder) frameSeqDecoder);
            gifDrawable.setAutoPlay(false);
            gifDrawable.setNoMeasure(booleanValue);
            return new DrawableResource<Drawable>(gifDrawable) {
                public void recycle() {
                }

                public Class<Drawable> getResourceClass() {
                    return Drawable.class;
                }

                public int getSize() {
                    return gifDrawable.getMemorySize();
                }

                public void initialize() {
                    super.initialize();
                }
            };
        }
    }
}
