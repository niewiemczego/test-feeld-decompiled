package coil.size;

import android.view.ViewTreeObserver;
import coil.size.ViewSizeResolver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "Landroid/view/View;", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ViewSizeResolver.kt */
final class ViewSizeResolver$size$3$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ ViewSizeResolver$size$3$preDrawListener$1 $preDrawListener;
    final /* synthetic */ ViewTreeObserver $viewTreeObserver;
    final /* synthetic */ ViewSizeResolver<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewSizeResolver$size$3$1(ViewSizeResolver<T> viewSizeResolver, ViewTreeObserver viewTreeObserver, ViewSizeResolver$size$3$preDrawListener$1 viewSizeResolver$size$3$preDrawListener$1) {
        super(1);
        this.this$0 = viewSizeResolver;
        this.$viewTreeObserver = viewTreeObserver;
        this.$preDrawListener = viewSizeResolver$size$3$preDrawListener$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        ViewSizeResolver.DefaultImpls.removePreDrawListenerSafe(this.this$0, this.$viewTreeObserver, this.$preDrawListener);
    }
}
