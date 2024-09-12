package expo.modules.image;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\u0004\u0018\u0001\"\u0006\b\u0002\u0010\u0005\u0018\u00012\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u0002H\u0004H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"<anonymous>", "", "T", "Landroid/view/View;", "PropType", "CustomValueType", "view", "prop", "invoke", "(Landroid/view/View;Ljava/lang/Object;)V", "expo/modules/image/ExpoImageModuleKt$PropGroup$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: expo.modules.image.ExpoImageModule$definition$lambda-9$lambda-8$$inlined$PropGroup$3  reason: invalid class name */
/* compiled from: ExpoImageModule.kt */
public final class ExpoImageModule$definition$lambda9$lambda8$$inlined$PropGroup$3 extends Lambda implements Function2<ExpoImageViewWrapper, Integer, Unit> {
    final /* synthetic */ Function3 $body;
    final /* synthetic */ Object $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpoImageModule$definition$lambda9$lambda8$$inlined$PropGroup$3(Function3 function3, Object obj) {
        super(2);
        this.$body = function3;
        this.$value = obj;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ExpoImageViewWrapper) (View) obj, (Integer) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(ExpoImageViewWrapper expoImageViewWrapper, Integer num) {
        Intrinsics.checkNotNullParameter(expoImageViewWrapper, ViewHierarchyConstants.VIEW_KEY);
        this.$body.invoke(expoImageViewWrapper, this.$value, num);
    }
}
