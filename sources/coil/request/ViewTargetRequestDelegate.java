package coil.request;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import coil.ImageLoader;
import coil.target.ViewTarget;
import coil.util.Lifecycles;
import coil.util.Utils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0007J\b\u0010\u0014\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcoil/request/ViewTargetRequestDelegate;", "Lcoil/request/RequestDelegate;", "imageLoader", "Lcoil/ImageLoader;", "initialRequest", "Lcoil/request/ImageRequest;", "target", "Lcoil/target/ViewTarget;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "job", "Lkotlinx/coroutines/Job;", "(Lcoil/ImageLoader;Lcoil/request/ImageRequest;Lcoil/target/ViewTarget;Landroidx/lifecycle/Lifecycle;Lkotlinx/coroutines/Job;)V", "assertActive", "", "dispose", "onDestroy", "owner", "Landroidx/lifecycle/LifecycleOwner;", "restart", "start", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RequestDelegate.kt */
public final class ViewTargetRequestDelegate extends RequestDelegate {
    private final ImageLoader imageLoader;
    private final ImageRequest initialRequest;
    private final Job job;
    private final Lifecycle lifecycle;
    private final ViewTarget<?> target;

    public ViewTargetRequestDelegate(ImageLoader imageLoader2, ImageRequest imageRequest, ViewTarget<?> viewTarget, Lifecycle lifecycle2, Job job2) {
        super((DefaultConstructorMarker) null);
        this.imageLoader = imageLoader2;
        this.initialRequest = imageRequest;
        this.target = viewTarget;
        this.lifecycle = lifecycle2;
        this.job = job2;
    }

    public final void restart() {
        this.imageLoader.enqueue(this.initialRequest);
    }

    public void assertActive() {
        if (!this.target.getView().isAttachedToWindow()) {
            Utils.getRequestManager(this.target.getView()).setRequest(this);
            throw new CancellationException("'ViewTarget.view' must be attached to a window.");
        }
    }

    public void start() {
        this.lifecycle.addObserver(this);
        ViewTarget<?> viewTarget = this.target;
        if (viewTarget instanceof LifecycleObserver) {
            Lifecycles.removeAndAddObserver(this.lifecycle, (LifecycleObserver) viewTarget);
        }
        Utils.getRequestManager(this.target.getView()).setRequest(this);
    }

    public void dispose() {
        Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
        ViewTarget<?> viewTarget = this.target;
        if (viewTarget instanceof LifecycleObserver) {
            this.lifecycle.removeObserver((LifecycleObserver) viewTarget);
        }
        this.lifecycle.removeObserver(this);
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        Utils.getRequestManager(this.target.getView()).dispose();
    }
}
