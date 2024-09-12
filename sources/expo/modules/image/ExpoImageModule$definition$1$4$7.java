package expo.modules.image;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "view", "Lexpo/modules/image/ExpoImageViewWrapper;", "index", "", "borderRadius", "", "invoke", "(Lexpo/modules/image/ExpoImageViewWrapper;ILjava/lang/Float;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoImageModule.kt */
final class ExpoImageModule$definition$1$4$7 extends Lambda implements Function3<ExpoImageViewWrapper, Integer, Float, Unit> {
    public static final ExpoImageModule$definition$1$4$7 INSTANCE = new ExpoImageModule$definition$1$4$7();

    ExpoImageModule$definition$1$4$7() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((ExpoImageViewWrapper) obj, ((Number) obj2).intValue(), (Float) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(ExpoImageViewWrapper expoImageViewWrapper, int i, Float f) {
        Intrinsics.checkNotNullParameter(expoImageViewWrapper, ViewHierarchyConstants.VIEW_KEY);
        expoImageViewWrapper.setBorderRadius(i, YogaUtilsKt.makeYogaUndefinedIfNegative(f != null ? f.floatValue() : Float.NaN));
    }
}
