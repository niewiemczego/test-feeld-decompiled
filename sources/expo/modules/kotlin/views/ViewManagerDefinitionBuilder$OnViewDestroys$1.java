package expo.modules.kotlin.views;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "ViewType", "Landroid/view/View;", "it", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* compiled from: ViewManagerDefinitionBuilder.kt */
public final class ViewManagerDefinitionBuilder$OnViewDestroys$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Function1<ViewType, Unit> $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewManagerDefinitionBuilder$OnViewDestroys$1(Function1<? super ViewType, Unit> function1) {
        super(1);
        this.$body = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        Function1<ViewType, Unit> function1 = this.$body;
        Intrinsics.reifiedOperationMarker(1, "ViewType");
        View view2 = view;
        function1.invoke(view);
    }
}
