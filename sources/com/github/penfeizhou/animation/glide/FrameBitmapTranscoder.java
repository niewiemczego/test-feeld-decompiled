package com.github.penfeizhou.animation.glide;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import java.io.IOException;

class FrameBitmapTranscoder implements ResourceTranscoder<FrameSeqDecoder, Bitmap> {
    private final BitmapPool bitmapPool;

    FrameBitmapTranscoder(BitmapPool bitmapPool2) {
        this.bitmapPool = bitmapPool2;
    }

    public Resource<Bitmap> transcode(Resource<FrameSeqDecoder> resource, Options options) {
        try {
            return BitmapResource.obtain(resource.get().getFrameBitmap(0), this.bitmapPool);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
