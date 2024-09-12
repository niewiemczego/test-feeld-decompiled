package expo.modules.kotlin.views;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "ChildViewType", "Landroid/view/View;", "ParentType", "Landroid/view/ViewGroup;", "view", "child", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* compiled from: ViewGroupDefinitionBuilder.kt */
public final class ViewGroupDefinitionBuilder$RemoveChildView$1 extends Lambda implements Function2<ViewGroup, View, Unit> {
    final /* synthetic */ Function2<ParentType, ChildViewType, Unit> $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewGroupDefinitionBuilder$RemoveChildView$1(Function2<? super ParentType, ? super ChildViewType, Unit> function2) {
        super(2);
        this.$body = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ViewGroup) obj, (View) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(ViewGroup viewGroup, View view) {
        Intrinsics.checkNotNullParameter(viewGroup, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(view, "child");
        Function2<ParentType, ChildViewType, Unit> function2 = this.$body;
        ViewGroup viewGroup2 = viewGroup;
        Intrinsics.reifiedOperationMarker(1, "ChildViewType");
        View view2 = view;
        function2.invoke(viewGroup, view);
    }
}
