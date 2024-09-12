package expo.modules.kotlin.views;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\n\b\u0001\u0010\u0004\u0018\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "ParentViewType", "Landroid/view/ViewGroup;", "ChildViewType", "Landroid/view/View;", "parent", "child", "index", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* compiled from: ViewGroupDefinitionBuilder.kt */
public final class ViewGroupDefinitionLegacyBuilder$AddChildView$1 extends Lambda implements Function3<ViewGroup, View, Integer, Unit> {
    final /* synthetic */ Function3<ParentViewType, ChildViewType, Integer, Unit> $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewGroupDefinitionLegacyBuilder$AddChildView$1(Function3<? super ParentViewType, ? super ChildViewType, ? super Integer, Unit> function3) {
        super(3);
        this.$body = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((ViewGroup) obj, (View) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ViewGroup viewGroup, View view, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(view, "child");
        Function3<ParentViewType, ChildViewType, Integer, Unit> function3 = this.$body;
        Intrinsics.reifiedOperationMarker(1, "ParentViewType");
        ViewGroup viewGroup2 = viewGroup;
        Intrinsics.reifiedOperationMarker(1, "ChildViewType");
        View view2 = view;
        function3.invoke(viewGroup, view, Integer.valueOf(i));
    }
}
