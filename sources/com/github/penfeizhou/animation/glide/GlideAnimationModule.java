package com.github.penfeizhou.animation.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.module.LibraryGlideModule;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class GlideAnimationModule extends LibraryGlideModule {
    public void registerComponents(Context context, Glide glide, Registry registry) {
        super.registerComponents(context, glide, registry);
        ByteBufferAnimationDecoder byteBufferAnimationDecoder = new ByteBufferAnimationDecoder();
        registry.prepend(InputStream.class, FrameSeqDecoder.class, new StreamAnimationDecoder(byteBufferAnimationDecoder));
        registry.prepend(ByteBuffer.class, FrameSeqDecoder.class, byteBufferAnimationDecoder);
        registry.register(FrameSeqDecoder.class, Drawable.class, new FrameDrawableTranscoder());
        registry.register(FrameSeqDecoder.class, Bitmap.class, new FrameBitmapTranscoder(glide.getBitmapPool()));
    }
}
