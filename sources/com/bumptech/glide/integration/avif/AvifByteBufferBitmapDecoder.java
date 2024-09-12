package com.bumptech.glide.integration.avif;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.aomedia.avif.android.AvifDecoder;

public final class AvifByteBufferBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {
    private static final String TAG = "AvifBitmapDecoder";
    private final BitmapPool bitmapPool;

    public AvifByteBufferBitmapDecoder(BitmapPool bitmapPool2) {
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool2);
    }

    private ByteBuffer maybeCopyBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.isDirect()) {
            return byteBuffer;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.remaining());
        allocateDirect.put(byteBuffer);
        allocateDirect.flip();
        return allocateDirect;
    }

    @Nullable
    public Resource<Bitmap> decode(ByteBuffer byteBuffer, int i, int i2, Options options) {
        ByteBuffer maybeCopyBuffer = maybeCopyBuffer(byteBuffer);
        AvifDecoder.Info info = new AvifDecoder.Info();
        if (!AvifDecoder.getInfo(maybeCopyBuffer, maybeCopyBuffer.remaining(), info)) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "Requested to decode byte buffer which cannot be handled by AvifDecoder");
            }
            return null;
        }
        Bitmap bitmap = this.bitmapPool.get(info.width, info.height, info.depth == 8 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGBA_F16);
        if (AvifDecoder.decode(maybeCopyBuffer, maybeCopyBuffer.remaining(), bitmap)) {
            return BitmapResource.obtain(bitmap, this.bitmapPool);
        }
        if (Log.isLoggable(TAG, 6)) {
            Log.e(TAG, "Failed to decode ByteBuffer as Avif.");
        }
        this.bitmapPool.put(bitmap);
        return null;
    }

    public boolean handles(ByteBuffer byteBuffer, Options options) {
        return AvifDecoder.isAvifImage(maybeCopyBuffer(byteBuffer));
    }
}
