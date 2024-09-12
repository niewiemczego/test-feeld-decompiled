package coil.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.decode.DecodeUtils;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J(\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcoil/util/DrawableUtils;", "", "()V", "DEFAULT_SIZE", "", "convertToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "config", "Landroid/graphics/Bitmap$Config;", "size", "Lcoil/size/Size;", "scale", "Lcoil/size/Scale;", "allowInexactSize", "", "isConfigValid", "bitmap", "isSizeValid", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DrawableUtils.kt */
public final class DrawableUtils {
    private static final int DEFAULT_SIZE = 512;
    public static final DrawableUtils INSTANCE = new DrawableUtils();

    private DrawableUtils() {
    }

    public final Bitmap convertToBitmap(Drawable drawable, Bitmap.Config config, Size size, Scale scale, boolean z) {
        int i;
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (isConfigValid(bitmap, config) && isSizeValid(z, bitmap, size, scale)) {
                return bitmap;
            }
        }
        Drawable mutate = drawable.mutate();
        int width = Utils.getWidth(mutate);
        int i2 = 512;
        if (width <= 0) {
            width = 512;
        }
        int height = Utils.getHeight(mutate);
        if (height > 0) {
            i2 = height;
        }
        if (Sizes.isOriginal(size)) {
            i = width;
        } else {
            i = Utils.toPx(size.getWidth(), scale);
        }
        double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, i2, i, Sizes.isOriginal(size) ? i2 : Utils.toPx(size.getHeight(), scale), scale);
        int roundToInt = MathKt.roundToInt(((double) width) * computeSizeMultiplier);
        int roundToInt2 = MathKt.roundToInt(computeSizeMultiplier * ((double) i2));
        Bitmap createBitmap = Bitmap.createBitmap(roundToInt, roundToInt2, Bitmaps.toSoftware(config));
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(width, height, config)");
        Rect bounds = mutate.getBounds();
        int i3 = bounds.left;
        int i4 = bounds.top;
        int i5 = bounds.right;
        int i6 = bounds.bottom;
        mutate.setBounds(0, 0, roundToInt, roundToInt2);
        mutate.draw(new Canvas(createBitmap));
        mutate.setBounds(i3, i4, i5, i6);
        return createBitmap;
    }

    private final boolean isConfigValid(Bitmap bitmap, Bitmap.Config config) {
        return bitmap.getConfig() == Bitmaps.toSoftware(config);
    }

    private final boolean isSizeValid(boolean z, Bitmap bitmap, Size size, Scale scale) {
        int i;
        if (z) {
            return true;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (Sizes.isOriginal(size)) {
            i = bitmap.getWidth();
        } else {
            i = Utils.toPx(size.getWidth(), scale);
        }
        if (DecodeUtils.computeSizeMultiplier(width, height, i, Sizes.isOriginal(size) ? bitmap.getHeight() : Utils.toPx(size.getHeight(), scale), scale) == 1.0d) {
            return true;
        }
        return false;
    }
}
