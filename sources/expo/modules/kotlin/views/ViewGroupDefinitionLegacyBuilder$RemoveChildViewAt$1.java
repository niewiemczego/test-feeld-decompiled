package expo.modules.kotlin.views;

import android.view.ViewGroup;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "ParentViewType", "Landroid/view/ViewGroup;", "view", "index", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* compiled from: ViewGroupDefinitionBuilder.kt */
public final class ViewGroupDefinitionLegacyBuilder$RemoveChildViewAt$1 extends Lambda implements Function2<ViewGroup, Integer, Unit> {
    final /* synthetic */ Function2<ParentViewType, Integer, Unit> $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewGroupDefinitionLegacyBuilder$RemoveChildViewAt$1(Function2<? super ParentViewType, ? super Integer, Unit> function2) {
        super(2);
        this.$body = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ViewGroup) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, ViewHierarchyConstants.VIEW_KEY);
        Function2<ParentViewType, Integer, Unit> function2 = this.$body;
        Intrinsics.reifiedOperationMarker(1, "ParentViewType");
        ViewGroup viewGroup2 = viewGroup;
        function2.invoke(viewGroup, Integer.valueOf(i));
    }
}
