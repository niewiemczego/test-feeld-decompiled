package expo.modules.image;

import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T", "Landroid/view/View;", "it", "invoke", "expo/modules/kotlin/views/ViewDefinitionBuilder$OnViewDestroys$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: expo.modules.image.ExpoImageModule$definition$lambda-9$lambda-8$$inlined$OnViewDestroys$1  reason: invalid class name */
/* compiled from: ViewDefinitionBuilder.kt */
public final class ExpoImageModule$definition$lambda9$lambda8$$inlined$OnViewDestroys$1 extends Lambda implements Function1<View, Unit> {
    public ExpoImageModule$definition$lambda9$lambda8$$inlined$OnViewDestroys$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        ExpoImageViewWrapper expoImageViewWrapper = (ExpoImageViewWrapper) view;
        View view2 = expoImageViewWrapper;
        if (!ViewCompat.isAttachedToWindow(view2)) {
            expoImageViewWrapper.onViewDestroys();
        } else {
            view2.addOnAttachStateChangeListener(new ExpoImageModule$definition$lambda9$lambda8$lambda7$$inlined$doOnDetach$1(view2, expoImageViewWrapper));
        }
    }
}
