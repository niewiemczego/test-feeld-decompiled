package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

public class CropSquareTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.CropSquareTransformation.1";
    private static final int VERSION = 1;
    private int size;

    /* access modifiers changed from: protected */
    public Bitmap transform(Context context, BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        int max = Math.max(i, i2);
        this.size = max;
        return TransformationUtils.centerCrop(bitmapPool, bitmap, max, max);
    }

    public String toString() {
        return "CropSquareTransformation(size=" + this.size + ")";
    }

    public boolean equals(Object obj) {
        return (obj instanceof CropSquareTransformation) && ((CropSquareTransformation) obj).size == this.size;
    }

    public int hashCode() {
        return -789843280 + (this.size * 10);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.size).getBytes(CHARSET));
    }
}
