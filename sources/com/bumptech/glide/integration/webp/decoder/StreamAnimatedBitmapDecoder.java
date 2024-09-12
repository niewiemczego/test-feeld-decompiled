package com.bumptech.glide.integration.webp.decoder;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;
import java.io.InputStream;

public class StreamAnimatedBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
    private final AnimatedWebpBitmapDecoder bitmapDecoder;

    public StreamAnimatedBitmapDecoder(AnimatedWebpBitmapDecoder animatedWebpBitmapDecoder) {
        this.bitmapDecoder = animatedWebpBitmapDecoder;
    }

    public boolean handles(InputStream inputStream, Options options) throws IOException {
        return this.bitmapDecoder.handles(inputStream, options);
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) throws IOException {
        return this.bitmapDecoder.decode(inputStream, i, i2, options);
    }
}
