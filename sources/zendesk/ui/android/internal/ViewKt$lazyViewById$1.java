package zendesk.ui.android.internal;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "T", "kotlin.jvm.PlatformType", "Landroid/view/View;", "invoke", "()Landroid/view/View;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: View.kt */
final class ViewKt$lazyViewById$1 extends Lambda implements Function0<T> {
    final /* synthetic */ View $this_lazyViewById;
    final /* synthetic */ int $viewId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewKt$lazyViewById$1(View view, int i) {
        super(0);
        this.$this_lazyViewById = view;
        this.$viewId = i;
    }

    public final T invoke() {
        return this.$this_lazyViewById.findViewById(this.$viewId);
    }
}
