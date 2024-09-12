package jp.wasabeef.glide.transformations.gpu;

import android.graphics.PointF;
import java.security.MessageDigest;
import java.util.Arrays;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageVignetteFilter;

public class VignetteFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation.1";
    private static final int VERSION = 1;
    private PointF center;
    private float[] vignetteColor;
    private float vignetteEnd;
    private float vignetteStart;

    public VignetteFilterTransformation() {
        this(new PointF(0.5f, 0.5f), new float[]{0.0f, 0.0f, 0.0f}, 0.0f, 0.75f);
    }

    public VignetteFilterTransformation(PointF pointF, float[] fArr, float f, float f2) {
        super(new GPUImageVignetteFilter());
        this.center = pointF;
        this.vignetteColor = fArr;
        this.vignetteStart = f;
        this.vignetteEnd = f2;
        GPUImageVignetteFilter gPUImageVignetteFilter = (GPUImageVignetteFilter) getFilter();
        gPUImageVignetteFilter.setVignetteCenter(this.center);
        gPUImageVignetteFilter.setVignetteColor(this.vignetteColor);
        gPUImageVignetteFilter.setVignetteStart(this.vignetteStart);
        gPUImageVignetteFilter.setVignetteEnd(this.vignetteEnd);
    }

    public String toString() {
        return "VignetteFilterTransformation(center=" + this.center.toString() + ",color=" + Arrays.toString(this.vignetteColor) + ",start=" + this.vignetteStart + ",end=" + this.vignetteEnd + ")";
    }

    public boolean equals(Object obj) {
        if (obj instanceof VignetteFilterTransformation) {
            VignetteFilterTransformation vignetteFilterTransformation = (VignetteFilterTransformation) obj;
            return vignetteFilterTransformation.center.equals(this.center.x, this.center.y) && Arrays.equals(vignetteFilterTransformation.vignetteColor, this.vignetteColor) && vignetteFilterTransformation.vignetteStart == this.vignetteStart && vignetteFilterTransformation.vignetteEnd == this.vignetteEnd;
        }
    }

    public int hashCode() {
        return 1874002103 + this.center.hashCode() + Arrays.hashCode(this.vignetteColor) + ((int) (this.vignetteStart * 100.0f)) + ((int) (this.vignetteEnd * 10.0f));
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.center + Arrays.hashCode(this.vignetteColor) + this.vignetteStart + this.vignetteEnd).getBytes(CHARSET));
    }
}
