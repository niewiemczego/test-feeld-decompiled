package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageBrightnessFilter;

public class BrightnessFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation.1";
    private static final int VERSION = 1;
    private float brightness;

    public BrightnessFilterTransformation() {
        this(0.0f);
    }

    public BrightnessFilterTransformation(float f) {
        super(new GPUImageBrightnessFilter());
        this.brightness = f;
        ((GPUImageBrightnessFilter) getFilter()).setBrightness(this.brightness);
    }

    public String toString() {
        return "BrightnessFilterTransformation(brightness=" + this.brightness + ")";
    }

    public boolean equals(Object obj) {
        return (obj instanceof BrightnessFilterTransformation) && ((BrightnessFilterTransformation) obj).brightness == this.brightness;
    }

    public int hashCode() {
        return -1311211954 + ((int) ((this.brightness + 1.0f) * 10.0f));
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.brightness).getBytes(CHARSET));
    }
}
