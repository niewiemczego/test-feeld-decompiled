package jp.wasabeef.glide.transformations.gpu;

import android.graphics.PointF;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageSwirlFilter;

public class SwirlFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation.1";
    private static final int VERSION = 1;
    private float angle;
    private PointF center;
    private float radius;

    public SwirlFilterTransformation() {
        this(0.5f, 1.0f, new PointF(0.5f, 0.5f));
    }

    public SwirlFilterTransformation(float f, float f2, PointF pointF) {
        super(new GPUImageSwirlFilter());
        this.radius = f;
        this.angle = f2;
        this.center = pointF;
        GPUImageSwirlFilter gPUImageSwirlFilter = (GPUImageSwirlFilter) getFilter();
        gPUImageSwirlFilter.setRadius(this.radius);
        gPUImageSwirlFilter.setAngle(this.angle);
        gPUImageSwirlFilter.setCenter(this.center);
    }

    public String toString() {
        return "SwirlFilterTransformation(radius=" + this.radius + ",angle=" + this.angle + ",center=" + this.center.toString() + ")";
    }

    public boolean equals(Object obj) {
        if (obj instanceof SwirlFilterTransformation) {
            SwirlFilterTransformation swirlFilterTransformation = (SwirlFilterTransformation) obj;
            float f = swirlFilterTransformation.radius;
            float f2 = this.radius;
            return f == f2 && swirlFilterTransformation.angle == f2 && swirlFilterTransformation.center.equals(this.center.x, this.center.y);
        }
    }

    public int hashCode() {
        return -981084566 + ((int) (this.radius * 1000.0f)) + ((int) (this.angle * 10.0f)) + this.center.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.radius + this.angle + this.center.hashCode()).getBytes(CHARSET));
    }
}
