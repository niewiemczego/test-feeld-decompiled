package com.bumptech.glide.integration.webp.decoder;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferBitmapWebpDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {
    private final WebpDownsampler downsampler;

    public ByteBufferBitmapWebpDecoder(WebpDownsampler webpDownsampler) {
        this.downsampler = webpDownsampler;
    }

    public boolean handles(ByteBuffer byteBuffer, Options options) throws IOException {
        return this.downsampler.handles(byteBuffer, options);
    }

    public Resource<Bitmap> decode(ByteBuffer byteBuffer, int i, int i2, Options options) throws IOException {
        return this.downsampler.decode(ByteBufferUtil.toStream(byteBuffer), i, i2, options);
    }
}
