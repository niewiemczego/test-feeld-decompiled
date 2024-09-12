package coil.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import coil.size.Size;
import coil.util.Bitmaps;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J!\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcoil/transform/CircleCropTransformation;", "Lcoil/transform/Transformation;", "()V", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "transform", "Landroid/graphics/Bitmap;", "input", "size", "Lcoil/size/Size;", "(Landroid/graphics/Bitmap;Lcoil/size/Size;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CircleCropTransformation.kt */
public final class CircleCropTransformation implements Transformation {
    private final String cacheKey = getClass().getName();

    public String getCacheKey() {
        return this.cacheKey;
    }

    public Object transform(Bitmap bitmap, Size size, Continuation<? super Bitmap> continuation) {
        Paint paint = new Paint(3);
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        float f = ((float) min) / 2.0f;
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmaps.getSafeConfig(bitmap));
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(width, height, config)");
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawCircle(f, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, f - (((float) bitmap.getWidth()) / 2.0f), f - (((float) bitmap.getHeight()) / 2.0f), paint);
        return createBitmap;
    }

    public boolean equals(Object obj) {
        return obj instanceof CircleCropTransformation;
    }

    public int hashCode() {
        return getClass().hashCode();
    }
}
