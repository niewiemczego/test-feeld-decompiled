package expo.modules.image;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\u0004\u0018\u0001\"\u0006\b\u0002\u0010\u0005\u0018\u00012\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u0002H\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "T", "Landroid/view/View;", "PropType", "CustomValueType", "view", "prop", "invoke", "(Landroid/view/View;Ljava/lang/Object;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoImageModule.kt */
public final class ExpoImageModuleKt$PropGroup$1 extends Lambda implements Function2<T, PropType, Unit> {
    final /* synthetic */ Function3<T, CustomValueType, PropType, Unit> $body;
    final /* synthetic */ CustomValueType $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpoImageModuleKt$PropGroup$1(Function3<? super T, ? super CustomValueType, ? super PropType, Unit> function3, CustomValueType customvaluetype) {
        super(2);
        this.$body = function3;
        this.$value = customvaluetype;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((View) obj, obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(T t, PropType proptype) {
        Intrinsics.checkNotNullParameter(t, ViewHierarchyConstants.VIEW_KEY);
        this.$body.invoke(t, this.$value, proptype);
    }
}
