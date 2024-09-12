package expo.modules.image.records;

import android.graphics.RectF;
import expo.modules.image.ImageUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ContentPosition.kt */
/* synthetic */ class ContentPosition$offsetY$1 extends FunctionReferenceImpl implements Function5<Float, RectF, RectF, Boolean, Boolean, Float> {
    public static final ContentPosition$offsetY$1 INSTANCE = new ContentPosition$offsetY$1();

    ContentPosition$offsetY$1() {
        super(5, ImageUtilsKt.class, "calcYTranslation", "calcYTranslation(FLandroid/graphics/RectF;Landroid/graphics/RectF;ZZ)F", 1);
    }

    public final Float invoke(float f, RectF rectF, RectF rectF2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(rectF, "p1");
        Intrinsics.checkNotNullParameter(rectF2, "p2");
        return Float.valueOf(ImageUtilsKt.calcYTranslation(f, rectF, rectF2, z, z2));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return invoke(((Number) obj).floatValue(), (RectF) obj2, (RectF) obj3, ((Boolean) obj4).booleanValue(), ((Boolean) obj5).booleanValue());
    }
}
