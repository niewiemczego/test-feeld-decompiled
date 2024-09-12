package expo.modules.image;

import android.graphics.RectF;
import com.bumptech.glide.request.FutureTarget;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterruptibleKt;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a2\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a2\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a!\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"calcTranslation", "", "value", "imageRefValue", "viewRefValue", "isPercentage", "", "isReverse", "calcXTranslation", "imageRect", "Landroid/graphics/RectF;", "viewRect", "calcYTranslation", "awaitGet", "T", "Lcom/bumptech/glide/request/FutureTarget;", "(Lcom/bumptech/glide/request/FutureTarget;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-image_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageUtils.kt */
public final class ImageUtilsKt {
    public static final float calcTranslation(float f, float f2, float f3, boolean z, boolean z2) {
        if (!z) {
            return z2 ? (f3 - f2) - f : f;
        }
        if (z2) {
            f = 100.0f - f;
        }
        return (f / 100.0f) * (f3 - f2);
    }

    public static final <T> Object awaitGet(FutureTarget<T> futureTarget, Continuation<? super T> continuation) {
        return InterruptibleKt.runInterruptible(Dispatchers.getIO(), new ImageUtilsKt$awaitGet$2(futureTarget), continuation);
    }

    public static /* synthetic */ float calcXTranslation$default(float f, RectF rectF, RectF rectF2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            z2 = false;
        }
        return calcXTranslation(f, rectF, rectF2, z, z2);
    }

    public static final float calcXTranslation(float f, RectF rectF, RectF rectF2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(rectF, "imageRect");
        Intrinsics.checkNotNullParameter(rectF2, "viewRect");
        return calcTranslation(f, rectF.width(), rectF2.width(), z, z2);
    }

    public static /* synthetic */ float calcYTranslation$default(float f, RectF rectF, RectF rectF2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            z2 = false;
        }
        return calcYTranslation(f, rectF, rectF2, z, z2);
    }

    public static final float calcYTranslation(float f, RectF rectF, RectF rectF2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(rectF, "imageRect");
        Intrinsics.checkNotNullParameter(rectF2, "viewRect");
        return calcTranslation(f, rectF.height(), rectF2.height(), z, z2);
    }

    public static /* synthetic */ float calcTranslation$default(float f, float f2, float f3, boolean z, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            z2 = false;
        }
        return calcTranslation(f, f2, f3, z, z2);
    }
}
