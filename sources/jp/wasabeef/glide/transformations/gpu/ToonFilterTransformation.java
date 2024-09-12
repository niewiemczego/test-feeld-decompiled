package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageToonFilter;

public class ToonFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation.1";
    private static final int VERSION = 1;
    private float quantizationLevels;
    private float threshold;

    public ToonFilterTransformation() {
        this(0.2f, 10.0f);
    }

    public ToonFilterTransformation(float f, float f2) {
        super(new GPUImageToonFilter());
        this.threshold = f;
        this.quantizationLevels = f2;
        GPUImageToonFilter gPUImageToonFilter = (GPUImageToonFilter) getFilter();
        gPUImageToonFilter.setThreshold(this.threshold);
        gPUImageToonFilter.setQuantizationLevels(this.quantizationLevels);
    }

    public String toString() {
        return "ToonFilterTransformation(threshold=" + this.threshold + ",quantizationLevels=" + this.quantizationLevels + ")";
    }

    public boolean equals(Object obj) {
        if (obj instanceof ToonFilterTransformation) {
            ToonFilterTransformation toonFilterTransformation = (ToonFilterTransformation) obj;
            return toonFilterTransformation.threshold == this.threshold && toonFilterTransformation.quantizationLevels == this.quantizationLevels;
        }
    }

    public int hashCode() {
        return 1209810327 + ((int) (this.threshold * 1000.0f)) + ((int) (this.quantizationLevels * 10.0f));
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.threshold + this.quantizationLevels).getBytes(CHARSET));
    }
}
