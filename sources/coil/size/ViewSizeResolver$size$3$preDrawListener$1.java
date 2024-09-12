package coil.size;

import android.view.ViewTreeObserver;
import coil.size.ViewSizeResolver;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"coil/size/ViewSizeResolver$size$3$preDrawListener$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "isResumed", "", "onPreDraw", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ViewSizeResolver.kt */
public final class ViewSizeResolver$size$3$preDrawListener$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ CancellableContinuation<Size> $continuation;
    final /* synthetic */ ViewTreeObserver $viewTreeObserver;
    private boolean isResumed;
    final /* synthetic */ ViewSizeResolver<T> this$0;

    ViewSizeResolver$size$3$preDrawListener$1(ViewSizeResolver<T> viewSizeResolver, ViewTreeObserver viewTreeObserver, CancellableContinuation<? super Size> cancellableContinuation) {
        this.this$0 = viewSizeResolver;
        this.$viewTreeObserver = viewTreeObserver;
        this.$continuation = cancellableContinuation;
    }

    public boolean onPreDraw() {
        Size access$getSize = ViewSizeResolver.DefaultImpls.getSize(this.this$0);
        if (access$getSize != null) {
            ViewSizeResolver.DefaultImpls.removePreDrawListenerSafe(this.this$0, this.$viewTreeObserver, this);
            if (!this.isResumed) {
                this.isResumed = true;
                Result.Companion companion = Result.Companion;
                this.$continuation.resumeWith(Result.m983constructorimpl(access$getSize));
            }
        }
        return true;
    }
}
