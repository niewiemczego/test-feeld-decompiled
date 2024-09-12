package coil.request;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcoil/request/OneShotDisposable;", "Lcoil/request/Disposable;", "job", "Lkotlinx/coroutines/Deferred;", "Lcoil/request/ImageResult;", "(Lkotlinx/coroutines/Deferred;)V", "isDisposed", "", "()Z", "getJob", "()Lkotlinx/coroutines/Deferred;", "dispose", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Disposable.kt */
public final class OneShotDisposable implements Disposable {
    private final Deferred<ImageResult> job;

    public OneShotDisposable(Deferred<? extends ImageResult> deferred) {
        this.job = deferred;
    }

    public Deferred<ImageResult> getJob() {
        return this.job;
    }

    public boolean isDisposed() {
        return !getJob().isActive();
    }

    public void dispose() {
        if (!isDisposed()) {
            Job.DefaultImpls.cancel$default((Job) getJob(), (CancellationException) null, 1, (Object) null);
        }
    }
}
