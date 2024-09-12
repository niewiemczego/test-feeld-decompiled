package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012J\u0014\u0010\u001c\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012J\b\u0010\u001d\u001a\u00020\u001aH&J\b\u0010\u001e\u001a\u00020\u001aH&R\u0014\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00008F@FX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "T", "", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "appContext", "getAppContext", "()Landroid/content/Context;", "currentState", "Ljava/lang/Object;", "initialState", "getInitialState", "()Ljava/lang/Object;", "listeners", "Ljava/util/LinkedHashSet;", "Landroidx/work/impl/constraints/ConstraintListener;", "lock", "newState", "state", "getState", "setState", "(Ljava/lang/Object;)V", "addListener", "", "listener", "removeListener", "startTracking", "stopTracking", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConstraintTracker.kt */
public abstract class ConstraintTracker<T> {
    private final Context appContext;
    private T currentState;
    private final LinkedHashSet<ConstraintListener<T>> listeners = new LinkedHashSet<>();
    private final Object lock = new Object();
    private final TaskExecutor taskExecutor;

    public abstract T getInitialState();

    public abstract void startTracking();

    public abstract void stopTracking();

    protected ConstraintTracker(Context context, TaskExecutor taskExecutor2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskExecutor2, "taskExecutor");
        this.taskExecutor = taskExecutor2;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.appContext = applicationContext;
    }

    /* access modifiers changed from: protected */
    public final Context getAppContext() {
        return this.appContext;
    }

    public final void addListener(ConstraintListener<T> constraintListener) {
        Intrinsics.checkNotNullParameter(constraintListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this.lock) {
            if (this.listeners.add(constraintListener)) {
                if (this.listeners.size() == 1) {
                    this.currentState = getInitialState();
                    Logger.get().debug(ConstraintTrackerKt.TAG, getClass().getSimpleName() + ": initial state = " + this.currentState);
                    startTracking();
                }
                constraintListener.onConstraintChanged(this.currentState);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeListener(ConstraintListener<T> constraintListener) {
        Intrinsics.checkNotNullParameter(constraintListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this.lock) {
            if (this.listeners.remove(constraintListener) && this.listeners.isEmpty()) {
                stopTracking();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final T getState() {
        T t = this.currentState;
        return t == null ? getInitialState() : t;
    }

    public final void setState(T t) {
        synchronized (this.lock) {
            T t2 = this.currentState;
            if (t2 == null || !Intrinsics.areEqual((Object) t2, (Object) t)) {
                this.currentState = t;
                this.taskExecutor.getMainThreadExecutor().execute(new ConstraintTracker$$ExternalSyntheticLambda0(CollectionsKt.toList(this.listeners), this));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void _set_state_$lambda$4$lambda$3(List list, ConstraintTracker constraintTracker) {
        Intrinsics.checkNotNullParameter(list, "$listenersList");
        Intrinsics.checkNotNullParameter(constraintTracker, "this$0");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ConstraintListener) it.next()).onConstraintChanged(constraintTracker.currentState);
        }
    }
}
