package expo.modules.kotlin.views;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u0002H\u0003\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "ViewType", "T", "Landroid/view/View;", "it", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* compiled from: ViewDefinitionBuilder.kt */
public final class ViewDefinitionBuilder$OnViewDidUpdateProps$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Function1<ViewType, Unit> $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewDefinitionBuilder$OnViewDidUpdateProps$2(Function1<? super ViewType, Unit> function1) {
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
