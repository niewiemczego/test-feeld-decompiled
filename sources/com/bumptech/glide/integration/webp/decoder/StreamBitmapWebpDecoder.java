package com.bumptech.glide.integration.webp.decoder;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.InputStream;

public class StreamBitmapWebpDecoder implements ResourceDecoder<InputStream, Bitmap> {
    private final ArrayPool byteArrayPool;
    private final WebpDownsampler downsampler;

    public StreamBitmapWebpDecoder(WebpDownsampler webpDownsampler, ArrayPool arrayPool) {
        this.downsampler = webpDownsampler;
        this.byteArrayPool = arrayPool;
    }

    public boolean handles(InputStream inputStream, Options options) throws IOException {
        return this.downsampler.handles(inputStream, options);
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) throws IOException {
        return this.downsampler.decode(inputStream, i, i2, options);
    }
}
