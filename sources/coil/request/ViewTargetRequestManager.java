package coil.request;

import android.view.View;
import coil.util.Utils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0006J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0003H\u0017J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0003H\u0017J\u0012\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0007R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcoil/request/ViewTargetRequestManager;", "Landroid/view/View$OnAttachStateChangeListener;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "currentDisposable", "Lcoil/request/ViewTargetDisposable;", "currentRequest", "Lcoil/request/ViewTargetRequestDelegate;", "isRestart", "", "pendingClear", "Lkotlinx/coroutines/Job;", "dispose", "", "getDisposable", "job", "Lkotlinx/coroutines/Deferred;", "Lcoil/request/ImageResult;", "getResult", "isDisposed", "disposable", "onViewAttachedToWindow", "v", "onViewDetachedFromWindow", "setRequest", "request", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ViewTargetRequestManager.kt */
public final class ViewTargetRequestManager implements View.OnAttachStateChangeListener {
    private ViewTargetDisposable currentDisposable;
    private ViewTargetRequestDelegate currentRequest;
    private boolean isRestart;
    private Job pendingClear;
    private final View view;

    public ViewTargetRequestManager(View view2) {
        this.view = view2;
    }

    public final synchronized boolean isDisposed(ViewTargetDisposable viewTargetDisposable) {
        return viewTargetDisposable != this.currentDisposable;
    }

    public final synchronized ViewTargetDisposable getDisposable(Deferred<? extends ImageResult> deferred) {
        ViewTargetDisposable viewTargetDisposable = this.currentDisposable;
        if (viewTargetDisposable == null || !Utils.isMainThread() || !this.isRestart) {
            Job job = this.pendingClear;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.pendingClear = null;
            ViewTargetDisposable viewTargetDisposable2 = new ViewTargetDisposable(this.view, deferred);
            this.currentDisposable = viewTargetDisposable2;
            return viewTargetDisposable2;
        }
        this.isRestart = false;
        viewTargetDisposable.setJob(deferred);
        return viewTargetDisposable;
    }

    public final synchronized void dispose() {
        Job job = this.pendingClear;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.pendingClear = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), (CoroutineStart) null, new ViewTargetRequestManager$dispose$1(this, (Continuation<? super ViewTargetRequestManager$dispose$1>) null), 2, (Object) null);
        this.currentDisposable = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0005, code lost:
        r0 = r0.getJob();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized coil.request.ImageResult getResult() {
        /*
            r1 = this;
            monitor-enter(r1)
            coil.request.ViewTargetDisposable r0 = r1.currentDisposable     // Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x0012
            kotlinx.coroutines.Deferred r0 = r0.getJob()     // Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x0012
            java.lang.Object r0 = coil.util.Utils.getCompletedOrNull(r0)     // Catch:{ all -> 0x0015 }
            coil.request.ImageResult r0 = (coil.request.ImageResult) r0     // Catch:{ all -> 0x0015 }
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            monitor-exit(r1)
            return r0
        L_0x0015:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.request.ViewTargetRequestManager.getResult():coil.request.ImageResult");
    }

    public final void setRequest(ViewTargetRequestDelegate viewTargetRequestDelegate) {
        ViewTargetRequestDelegate viewTargetRequestDelegate2 = this.currentRequest;
        if (viewTargetRequestDelegate2 != null) {
            viewTargetRequestDelegate2.dispose();
        }
        this.currentRequest = viewTargetRequestDelegate;
    }

    public void onViewAttachedToWindow(View view2) {
        ViewTargetRequestDelegate viewTargetRequestDelegate = this.currentRequest;
        if (viewTargetRequestDelegate != null) {
            this.isRestart = true;
            viewTargetRequestDelegate.restart();
        }
    }

    public void onViewDetachedFromWindow(View view2) {
        ViewTargetRequestDelegate viewTargetRequestDelegate = this.currentRequest;
        if (viewTargetRequestDelegate != null) {
            viewTargetRequestDelegate.dispose();
        }
    }
}
