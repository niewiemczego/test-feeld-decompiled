package coil.request;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcoil/request/GlobalLifecycle;", "Landroidx/lifecycle/Lifecycle;", "()V", "owner", "Landroidx/lifecycle/LifecycleOwner;", "addObserver", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "getCurrentState", "Landroidx/lifecycle/Lifecycle$State;", "removeObserver", "toString", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GlobalLifecycle.kt */
public final class GlobalLifecycle extends Lifecycle {
    public static final GlobalLifecycle INSTANCE = new GlobalLifecycle();
    private static final LifecycleOwner owner = new GlobalLifecycle$$ExternalSyntheticLambda0();

    public void removeObserver(LifecycleObserver lifecycleObserver) {
    }

    public String toString() {
        return "coil.request.GlobalLifecycle";
    }

    private GlobalLifecycle() {
    }

    /* access modifiers changed from: private */
    /* renamed from: owner$lambda-0  reason: not valid java name */
    public static final Lifecycle m86owner$lambda0() {
        return INSTANCE;
    }

    public void addObserver(LifecycleObserver lifecycleObserver) {
        if (lifecycleObserver instanceof DefaultLifecycleObserver) {
            DefaultLifecycleObserver defaultLifecycleObserver = (DefaultLifecycleObserver) lifecycleObserver;
            LifecycleOwner lifecycleOwner = owner;
            defaultLifecycleObserver.onCreate(lifecycleOwner);
            defaultLifecycleObserver.onStart(lifecycleOwner);
            defaultLifecycleObserver.onResume(lifecycleOwner);
            return;
        }
        throw new IllegalArgumentException((lifecycleObserver + " must implement androidx.lifecycle.DefaultLifecycleObserver.").toString());
    }

    public Lifecycle.State getCurrentState() {
        return Lifecycle.State.RESUMED;
    }
}
