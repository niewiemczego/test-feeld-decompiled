package com.bumptech.glide.integration.avif;

import android.graphics.Bitmap;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.ByteBufferUtil;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;

public final class AvifStreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
    private static final String TAG = "AvifStreamBitmapDecoder";
    private final ArrayPool arrayPool;
    private final AvifByteBufferBitmapDecoder avifByteBufferDecoder;
    private final List<ImageHeaderParser> parsers;

    public AvifStreamBitmapDecoder(List<ImageHeaderParser> list, AvifByteBufferBitmapDecoder avifByteBufferBitmapDecoder, ArrayPool arrayPool2) {
        this.parsers = list;
        this.avifByteBufferDecoder = (AvifByteBufferBitmapDecoder) Preconditions.checkNotNull(avifByteBufferBitmapDecoder);
        this.arrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool2);
    }

    @Nullable
    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) throws IOException {
        return this.avifByteBufferDecoder.decode(ByteBufferUtil.fromStream(inputStream), i, i2, options);
    }

    public boolean handles(InputStream inputStream, Options options) throws IOException {
        return ImageHeaderParser.ImageType.AVIF.equals(ImageHeaderParserUtils.getType(this.parsers, inputStream, this.arrayPool));
    }
}
