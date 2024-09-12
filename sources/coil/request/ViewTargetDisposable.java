package coil.request;

import android.view.View;
import coil.util.Utils;
import kotlin.Metadata;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcoil/request/ViewTargetDisposable;", "Lcoil/request/Disposable;", "view", "Landroid/view/View;", "job", "Lkotlinx/coroutines/Deferred;", "Lcoil/request/ImageResult;", "(Landroid/view/View;Lkotlinx/coroutines/Deferred;)V", "isDisposed", "", "()Z", "getJob", "()Lkotlinx/coroutines/Deferred;", "setJob", "(Lkotlinx/coroutines/Deferred;)V", "dispose", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Disposable.kt */
public final class ViewTargetDisposable implements Disposable {
    private volatile Deferred<? extends ImageResult> job;
    private final View view;

    public ViewTargetDisposable(View view2, Deferred<? extends ImageResult> deferred) {
        this.view = view2;
        this.job = deferred;
    }

    public Deferred<ImageResult> getJob() {
        return this.job;
    }

    public void setJob(Deferred<? extends ImageResult> deferred) {
        this.job = deferred;
    }

    public boolean isDisposed() {
        return Utils.getRequestManager(this.view).isDisposed(this);
    }

    public void dispose() {
        if (!isDisposed()) {
            Utils.getRequestManager(this.view).dispose();
        }
    }
}
