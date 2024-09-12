package com.github.penfeizhou.animation.glide;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.github.penfeizhou.animation.apng.decode.APNGParser;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import com.github.penfeizhou.animation.gif.decode.GifParser;
import com.github.penfeizhou.animation.io.Reader;
import com.github.penfeizhou.animation.io.StreamReader;
import com.github.penfeizhou.animation.webp.decode.WebPParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class StreamAnimationDecoder implements ResourceDecoder<InputStream, FrameSeqDecoder> {
    private final ResourceDecoder<ByteBuffer, FrameSeqDecoder> byteBufferDecoder;

    public StreamAnimationDecoder(ResourceDecoder<ByteBuffer, FrameSeqDecoder> resourceDecoder) {
        this.byteBufferDecoder = resourceDecoder;
    }

    public boolean handles(InputStream inputStream, Options options) {
        return (!((Boolean) options.get(AnimationDecoderOption.DISABLE_ANIMATION_WEBP_DECODER)).booleanValue() && WebPParser.isAWebP((Reader) new StreamReader(inputStream))) || (!((Boolean) options.get(AnimationDecoderOption.DISABLE_ANIMATION_APNG_DECODER)).booleanValue() && APNGParser.isAPNG((Reader) new StreamReader(inputStream))) || (!((Boolean) options.get(AnimationDecoderOption.DISABLE_ANIMATION_GIF_DECODER)).booleanValue() && GifParser.isGif((Reader) new StreamReader(inputStream)));
    }

    public Resource<FrameSeqDecoder> decode(InputStream inputStream, int i, int i2, Options options) throws IOException {
        byte[] inputStreamToBytes = inputStreamToBytes(inputStream);
        if (inputStreamToBytes == null) {
            return null;
        }
        return this.byteBufferDecoder.decode(ByteBuffer.wrap(inputStreamToBytes), i, i2, options);
    }

    private static byte[] inputStreamToBytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
