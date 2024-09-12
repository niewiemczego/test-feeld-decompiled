package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class StreamWebpDecoder implements ResourceDecoder<InputStream, WebpDrawable> {
    public static final Option<Boolean> DISABLE_ANIMATION = Option.memory("com.bumptech.glide.integration.webp.decoder.StreamWebpDecoder.DisableAnimation", false);
    private final ArrayPool byteArrayPool;
    private final ResourceDecoder<ByteBuffer, WebpDrawable> byteBufferDecoder;

    public StreamWebpDecoder(ResourceDecoder<ByteBuffer, WebpDrawable> resourceDecoder, ArrayPool arrayPool) {
        this.byteBufferDecoder = resourceDecoder;
        this.byteArrayPool = arrayPool;
    }

    public boolean handles(InputStream inputStream, Options options) throws IOException {
        if (((Boolean) options.get(DISABLE_ANIMATION)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.isAnimatedWebpType(WebpHeaderParser.getType(inputStream, this.byteArrayPool));
    }

    public Resource<WebpDrawable> decode(InputStream inputStream, int i, int i2, Options options) throws IOException {
        byte[] inputStreamToBytes = Utils.inputStreamToBytes(inputStream);
        if (inputStreamToBytes == null) {
            return null;
        }
        return this.byteBufferDecoder.decode(ByteBuffer.wrap(inputStreamToBytes), i, i2, options);
    }
}
