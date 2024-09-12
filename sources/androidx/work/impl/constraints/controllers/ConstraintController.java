package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001%B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H&J\u0015\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0011J\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0014\u0010\u001f\u001a\u00020\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130!J\u0006\u0010\"\u001a\u00020\u001cJ!\u0010#\u001a\u00020\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010$R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/work/impl/constraints/controllers/ConstraintController;", "T", "Landroidx/work/impl/constraints/ConstraintListener;", "tracker", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "(Landroidx/work/impl/constraints/trackers/ConstraintTracker;)V", "value", "Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;", "callback", "getCallback", "()Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;", "setCallback", "(Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;)V", "currentValue", "Ljava/lang/Object;", "matchingWorkSpecIds", "", "", "matchingWorkSpecs", "Landroidx/work/impl/model/WorkSpec;", "hasConstraint", "", "workSpec", "isConstrained", "(Ljava/lang/Object;)Z", "isWorkSpecConstrained", "workSpecId", "onConstraintChanged", "", "newValue", "(Ljava/lang/Object;)V", "replace", "workSpecs", "", "reset", "updateCallback", "(Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;Ljava/lang/Object;)V", "OnConstraintUpdatedCallback", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConstraintController.kt */
public abstract class ConstraintController<T> implements ConstraintListener<T> {
    private OnConstraintUpdatedCallback callback;
    private T currentValue;
    private final List<String> matchingWorkSpecIds = new ArrayList();
    private final List<WorkSpec> matchingWorkSpecs = new ArrayList();
    private final ConstraintTracker<T> tracker;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\b"}, d2 = {"Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;", "", "onConstraintMet", "", "workSpecs", "", "Landroidx/work/impl/model/WorkSpec;", "onConstraintNotMet", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ConstraintController.kt */
    public interface OnConstraintUpdatedCallback {
        void onConstraintMet(List<WorkSpec> list);

        void onConstraintNotMet(List<WorkSpec> list);
    }

    public abstract boolean hasConstraint(WorkSpec workSpec);

    public abstract boolean isConstrained(T t);

    public ConstraintController(ConstraintTracker<T> constraintTracker) {
        Intrinsics.checkNotNullParameter(constraintTracker, "tracker");
        this.tracker = constraintTracker;
    }

    public final OnConstraintUpdatedCallback getCallback() {
        return this.callback;
    }

    public final void setCallback(OnConstraintUpdatedCallback onConstraintUpdatedCallback) {
        if (this.callback != onConstraintUpdatedCallback) {
            this.callback = onConstraintUpdatedCallback;
            updateCallback(onConstraintUpdatedCallback, this.currentValue);
        }
    }

    public final void replace(Iterable<WorkSpec> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "workSpecs");
        this.matchingWorkSpecs.clear();
        this.matchingWorkSpecIds.clear();
        Collection collection = this.matchingWorkSpecs;
        for (WorkSpec next : iterable) {
            if (hasConstraint(next)) {
                collection.add(next);
            }
        }
        Collection collection2 = this.matchingWorkSpecIds;
        for (WorkSpec workSpec : this.matchingWorkSpecs) {
            collection2.add(workSpec.id);
        }
        if (this.matchingWorkSpecs.isEmpty()) {
            this.tracker.removeListener(this);
        } else {
            this.tracker.addListener(this);
        }
        updateCallback(this.callback, this.currentValue);
    }

    public final void reset() {
        if (!this.matchingWorkSpecs.isEmpty()) {
            this.matchingWorkSpecs.clear();
            this.tracker.removeListener(this);
        }
    }

    public final boolean isWorkSpecConstrained(String str) {
        Intrinsics.checkNotNullParameter(str, "workSpecId");
        T t = this.currentValue;
        return t != null && isConstrained(t) && this.matchingWorkSpecIds.contains(str);
    }

    private final void updateCallback(OnConstraintUpdatedCallback onConstraintUpdatedCallback, T t) {
        if (!this.matchingWorkSpecs.isEmpty() && onConstraintUpdatedCallback != null) {
            if (t == null || isConstrained(t)) {
                onConstraintUpdatedCallback.onConstraintNotMet(this.matchingWorkSpecs);
            } else {
                onConstraintUpdatedCallback.onConstraintMet(this.matchingWorkSpecs);
            }
        }
    }

    public void onConstraintChanged(T t) {
        this.currentValue = t;
        updateCallback(this.callback, t);
    }
}
