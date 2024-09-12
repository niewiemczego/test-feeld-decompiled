package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;
import jp.wasabeef.glide.transformations.internal.FastBlur;

public class BlurTransformation extends BitmapTransformation {
    private static int DEFAULT_DOWN_SAMPLING = 1;
    private static final String ID = "jp.wasabeef.glide.transformations.BlurTransformation.1";
    private static int MAX_RADIUS = 25;
    private static final int VERSION = 1;
    private int radius;
    private int sampling;

    public BlurTransformation() {
        this(MAX_RADIUS, DEFAULT_DOWN_SAMPLING);
    }

    public BlurTransformation(int i) {
        this(i, DEFAULT_DOWN_SAMPLING);
    }

    public BlurTransformation(int i, int i2) {
        this.radius = i;
        this.sampling = i2;
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(Context context, BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = this.sampling;
        Bitmap bitmap2 = bitmapPool.get(width / i3, height / i3, Bitmap.Config.ARGB_8888);
        setCanvasBitmapDensity(bitmap, bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        int i4 = this.sampling;
        canvas.scale(1.0f / ((float) i4), 1.0f / ((float) i4));
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return FastBlur.blur(bitmap2, this.radius, true);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.radius + ", sampling=" + this.sampling + ")";
    }

    public boolean equals(Object obj) {
        if (obj instanceof BlurTransformation) {
            BlurTransformation blurTransformation = (BlurTransformation) obj;
            return blurTransformation.radius == this.radius && blurTransformation.sampling == this.sampling;
        }
    }

    public int hashCode() {
        return 737513610 + (this.radius * 1000) + (this.sampling * 10);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.radius + this.sampling).getBytes(CHARSET));
    }
}
