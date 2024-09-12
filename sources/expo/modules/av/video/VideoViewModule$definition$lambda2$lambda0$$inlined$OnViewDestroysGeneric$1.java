package expo.modules.av.video;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u0002H\u0003\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "ViewType", "T", "Landroid/view/View;", "it", "invoke", "expo/modules/kotlin/views/ViewDefinitionBuilder$OnViewDestroys$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: expo.modules.av.video.VideoViewModule$definition$lambda-2$lambda-0$$inlined$OnViewDestroysGeneric$1  reason: invalid class name */
/* compiled from: ViewDefinitionBuilder.kt */
public final class VideoViewModule$definition$lambda2$lambda0$$inlined$OnViewDestroysGeneric$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Function1 $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoViewModule$definition$lambda2$lambda0$$inlined$OnViewDestroysGeneric$1(Function1 function1) {
        super(1);
        this.$body = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        this.$body.invoke((VideoViewWrapper) view);
    }
}
