package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class CropTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.CropTransformation.1";
    private static final int VERSION = 1;
    private CropType cropType;
    private int height;
    private int width;

    public enum CropType {
        TOP,
        CENTER,
        BOTTOM
    }

    public CropTransformation(int i, int i2) {
        this(i, i2, CropType.CENTER);
    }

    public CropTransformation(int i, int i2, CropType cropType2) {
        CropType cropType3 = CropType.CENTER;
        this.width = i;
        this.height = i2;
        this.cropType = cropType2;
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(Context context, BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        int i3 = this.width;
        if (i3 == 0) {
            i3 = bitmap.getWidth();
        }
        this.width = i3;
        int i4 = this.height;
        if (i4 == 0) {
            i4 = bitmap.getHeight();
        }
        this.height = i4;
        Bitmap bitmap2 = bitmapPool.get(this.width, this.height, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        bitmap2.setHasAlpha(true);
        float max = Math.max(((float) this.width) / ((float) bitmap.getWidth()), ((float) this.height) / ((float) bitmap.getHeight()));
        float width2 = ((float) bitmap.getWidth()) * max;
        float height2 = max * ((float) bitmap.getHeight());
        float f = (((float) this.width) - width2) / 2.0f;
        float top = getTop(height2);
        RectF rectF = new RectF(f, top, width2 + f, height2 + top);
        setCanvasBitmapDensity(bitmap, bitmap2);
        new Canvas(bitmap2).drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
        return bitmap2;
    }

    /* renamed from: jp.wasabeef.glide.transformations.CropTransformation$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                jp.wasabeef.glide.transformations.CropTransformation$CropType[] r0 = jp.wasabeef.glide.transformations.CropTransformation.CropType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType = r0
                jp.wasabeef.glide.transformations.CropTransformation$CropType r1 = jp.wasabeef.glide.transformations.CropTransformation.CropType.TOP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType     // Catch:{ NoSuchFieldError -> 0x001d }
                jp.wasabeef.glide.transformations.CropTransformation$CropType r1 = jp.wasabeef.glide.transformations.CropTransformation.CropType.CENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType     // Catch:{ NoSuchFieldError -> 0x0028 }
                jp.wasabeef.glide.transformations.CropTransformation$CropType r1 = jp.wasabeef.glide.transformations.CropTransformation.CropType.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.wasabeef.glide.transformations.CropTransformation.AnonymousClass1.<clinit>():void");
        }
    }

    private float getTop(float f) {
        int i = AnonymousClass1.$SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType[this.cropType.ordinal()];
        if (i == 2) {
            return (((float) this.height) - f) / 2.0f;
        }
        if (i != 3) {
            return 0.0f;
        }
        return ((float) this.height) - f;
    }

    public String toString() {
        return "CropTransformation(width=" + this.width + ", height=" + this.height + ", cropType=" + this.cropType + ")";
    }

    public boolean equals(Object obj) {
        if (obj instanceof CropTransformation) {
            CropTransformation cropTransformation = (CropTransformation) obj;
            return cropTransformation.width == this.width && cropTransformation.height == this.height && cropTransformation.cropType == this.cropType;
        }
    }

    public int hashCode() {
        return -1462327117 + (this.width * 100000) + (this.height * 1000) + (this.cropType.ordinal() * 10);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.width + this.height + this.cropType).getBytes(CHARSET));
    }
}
