package expo.modules.kotlin.views;

import android.view.ViewGroup;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "ParentType", "Landroid/view/ViewGroup;", "view", "invoke", "(Landroid/view/ViewGroup;)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* compiled from: ViewGroupDefinitionBuilder.kt */
public final class ViewGroupDefinitionBuilder$GetChildCount$1 extends Lambda implements Function1<ViewGroup, Integer> {
    final /* synthetic */ Function1<ParentType, Integer> $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewGroupDefinitionBuilder$GetChildCount$1(Function1<? super ParentType, Integer> function1) {
        super(1);
        this.$body = function1;
    }

    public final Integer invoke(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, ViewHierarchyConstants.VIEW_KEY);
        return this.$body.invoke(viewGroup);
    }
}
