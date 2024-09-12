package jp.wasabeef.glide.transformations.gpu;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.GPUImage;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter;
import jp.wasabeef.glide.transformations.BitmapTransformation;

public class GPUFilterTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation.1";
    private static final byte[] ID_BYTES = ID.getBytes(CHARSET);
    private static final int VERSION = 1;
    private GPUImageFilter gpuImageFilter;

    public int hashCode() {
        return 1751294359;
    }

    public GPUFilterTransformation(GPUImageFilter gPUImageFilter) {
        this.gpuImageFilter = gPUImageFilter;
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(Context context, BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        GPUImage gPUImage = new GPUImage(context);
        gPUImage.setImage(bitmap);
        gPUImage.setFilter(this.gpuImageFilter);
        return gPUImage.getBitmapWithFilterApplied();
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public <T> T getFilter() {
        return this.gpuImageFilter;
    }

    public boolean equals(Object obj) {
        return obj instanceof GPUFilterTransformation;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
