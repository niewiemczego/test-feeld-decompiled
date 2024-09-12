package com.bumptech.glide.integration.webp.decoder;

import android.graphics.Bitmap;
import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bumptech.glide.integration.webp.WebpImage;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifBitmapProvider;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class AnimatedWebpBitmapDecoder {
    public static final Option<Boolean> DISABLE_BITMAP = Option.memory("com.bumptech.glide.integration.webp.decoder.AnimatedWebpBitmapDecoder.DisableBitmap", false);
    private final ArrayPool mArrayPool;
    private final BitmapPool mBitmapPool;
    private final GifBitmapProvider mProvider;

    public AnimatedWebpBitmapDecoder(ArrayPool arrayPool, BitmapPool bitmapPool) {
        this.mArrayPool = arrayPool;
        this.mBitmapPool = bitmapPool;
        this.mProvider = new GifBitmapProvider(bitmapPool, arrayPool);
    }

    public boolean handles(InputStream inputStream, Options options) throws IOException {
        if (((Boolean) options.get(DISABLE_BITMAP)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.isAnimatedWebpType(WebpHeaderParser.getType(inputStream, this.mArrayPool));
    }

    public boolean handles(ByteBuffer byteBuffer, Options options) throws IOException {
        if (((Boolean) options.get(DISABLE_BITMAP)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.isAnimatedWebpType(WebpHeaderParser.getType(byteBuffer));
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) throws IOException {
        byte[] inputStreamToBytes = Utils.inputStreamToBytes(inputStream);
        if (inputStreamToBytes == null) {
            return null;
        }
        return decode(ByteBuffer.wrap(inputStreamToBytes), i, i2, options);
    }

    public Resource<Bitmap> decode(ByteBuffer byteBuffer, int i, int i2, Options options) throws IOException {
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr, 0, remaining);
        WebpImage create = WebpImage.create(bArr);
        WebpDecoder webpDecoder = new WebpDecoder(this.mProvider, create, byteBuffer, Utils.getSampleSize(create.getWidth(), create.getHeight(), i, i2));
        try {
            webpDecoder.advance();
            return BitmapResource.obtain(webpDecoder.getNextFrame(), this.mBitmapPool);
        } finally {
            webpDecoder.clear();
        }
    }
}
