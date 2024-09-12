package expo.modules.kotlin.views;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\u0004\u0018\u00012\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "ViewType", "Landroid/view/View;", "PropType", "view", "prop", "invoke", "(Landroid/view/View;Ljava/lang/Object;)V"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* compiled from: ViewManagerDefinitionBuilder.kt */
public final class ViewManagerDefinitionBuilder$PropGroup$1 extends Lambda implements Function2<ViewType, PropType, Unit> {
    final /* synthetic */ Function3<ViewType, String, PropType, Unit> $body;
    final /* synthetic */ String $name;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewManagerDefinitionBuilder$PropGroup$1(Function3<? super ViewType, ? super String, ? super PropType, Unit> function3, String str) {
        super(2);
        this.$body = function3;
        this.$name = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((View) obj, obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(ViewType viewtype, PropType proptype) {
        Intrinsics.checkNotNullParameter(viewtype, ViewHierarchyConstants.VIEW_KEY);
        this.$body.invoke(viewtype, this.$name, proptype);
    }
}