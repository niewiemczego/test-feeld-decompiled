package expo.modules.image;

import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "view", "Lexpo/modules/image/ExpoImageViewWrapper;", "index", "", "color", "invoke", "(Lexpo/modules/image/ExpoImageViewWrapper;ILjava/lang/Integer;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoImageModule.kt */
final class ExpoImageModule$definition$1$4$9 extends Lambda implements Function3<ExpoImageViewWrapper, Integer, Integer, Unit> {
    public static final ExpoImageModule$definition$1$4$9 INSTANCE = new ExpoImageModule$definition$1$4$9();

    ExpoImageModule$definition$1$4$9() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((ExpoImageViewWrapper) obj, ((Number) obj2).intValue(), (Integer) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(ExpoImageViewWrapper expoImageViewWrapper, int i, Integer num) {
        Intrinsics.checkNotNullParameter(expoImageViewWrapper, ViewHierarchyConstants.VIEW_KEY);
        float f = Float.NaN;
        float intValue = num == null ? Float.NaN : (float) (num.intValue() & ViewCompat.MEASURED_SIZE_MASK);
        if (num != null) {
            f = (float) (num.intValue() >>> 24);
        }
        expoImageViewWrapper.setBorderColor(i, intValue, f);
    }
}
