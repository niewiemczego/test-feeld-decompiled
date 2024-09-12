package com.github.penfeizhou.animation.glide;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.github.penfeizhou.animation.apng.decode.APNGDecoder;
import com.github.penfeizhou.animation.apng.decode.APNGParser;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import com.github.penfeizhou.animation.gif.decode.GifDecoder;
import com.github.penfeizhou.animation.gif.decode.GifParser;
import com.github.penfeizhou.animation.io.ByteBufferReader;
import com.github.penfeizhou.animation.io.Reader;
import com.github.penfeizhou.animation.loader.ByteBufferLoader;
import com.github.penfeizhou.animation.webp.decode.WebPDecoder;
import com.github.penfeizhou.animation.webp.decode.WebPParser;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferAnimationDecoder implements ResourceDecoder<ByteBuffer, FrameSeqDecoder> {
    public boolean handles(ByteBuffer byteBuffer, Options options) {
        return (!((Boolean) options.get(AnimationDecoderOption.DISABLE_ANIMATION_WEBP_DECODER)).booleanValue() && WebPParser.isAWebP((Reader) new ByteBufferReader(byteBuffer))) || (!((Boolean) options.get(AnimationDecoderOption.DISABLE_ANIMATION_APNG_DECODER)).booleanValue() && APNGParser.isAPNG((Reader) new ByteBufferReader(byteBuffer))) || (!((Boolean) options.get(AnimationDecoderOption.DISABLE_ANIMATION_GIF_DECODER)).booleanValue() && GifParser.isGif((Reader) new ByteBufferReader(byteBuffer)));
    }

    public Resource<FrameSeqDecoder> decode(final ByteBuffer byteBuffer, int i, int i2, Options options) throws IOException {
        FrameSeqDecoder frameSeqDecoder;
        AnonymousClass1 r2 = new ByteBufferLoader() {
            public ByteBuffer getByteBuffer() {
                byteBuffer.position(0);
                return byteBuffer;
            }
        };
        if (WebPParser.isAWebP((Reader) new ByteBufferReader(byteBuffer))) {
            frameSeqDecoder = new WebPDecoder(r2, (FrameSeqDecoder.RenderListener) null);
        } else if (APNGParser.isAPNG((Reader) new ByteBufferReader(byteBuffer))) {
            frameSeqDecoder = new APNGDecoder(r2, (FrameSeqDecoder.RenderListener) null);
        } else if (!GifParser.isGif((Reader) new ByteBufferReader(byteBuffer))) {
            return null;
        } else {
            frameSeqDecoder = new GifDecoder(r2, (FrameSeqDecoder.RenderListener) null);
        }
        return new FrameSeqDecoderResource(frameSeqDecoder, byteBuffer.limit());
    }

    private static class FrameSeqDecoderResource implements Resource<FrameSeqDecoder> {
        private final FrameSeqDecoder decoder;
        private final int size;

        FrameSeqDecoderResource(FrameSeqDecoder frameSeqDecoder, int i) {
            this.decoder = frameSeqDecoder;
            this.size = i;
        }

        public Class<FrameSeqDecoder> getResourceClass() {
            return FrameSeqDecoder.class;
        }

        public FrameSeqDecoder get() {
            return this.decoder;
        }

        public int getSize() {
            return this.size;
        }

        public void recycle() {
            this.decoder.stop();
        }
    }
}
