package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageContrastFilter;

public class ContrastFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation.1";
    private static final int VERSION = 1;
    private float contrast;

    public ContrastFilterTransformation() {
        this(1.0f);
    }

    public ContrastFilterTransformation(float f) {
        super(new GPUImageContrastFilter());
        this.contrast = f;
        ((GPUImageContrastFilter) getFilter()).setContrast(this.contrast);
    }

    public String toString() {
        return "ContrastFilterTransformation(contrast=" + this.contrast + ")";
    }

    public boolean equals(Object obj) {
        return obj instanceof ContrastFilterTransformation;
    }

    public int hashCode() {
        return -306633601 + ((int) (this.contrast * 10.0f));
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.contrast).getBytes(CHARSET));
    }
}
