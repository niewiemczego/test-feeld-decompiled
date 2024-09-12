package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageColorInvertFilter;

public class InvertFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.InvertFilterTransformation.1";
    private static final int VERSION = 1;

    public int hashCode() {
        return 2014901395;
    }

    public String toString() {
        return "InvertFilterTransformation()";
    }

    public InvertFilterTransformation() {
        super(new GPUImageColorInvertFilter());
    }

    public boolean equals(Object obj) {
        return obj instanceof InvertFilterTransformation;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID.getBytes(CHARSET));
    }
}
