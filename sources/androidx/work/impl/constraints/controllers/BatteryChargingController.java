package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Landroidx/work/impl/constraints/controllers/BatteryChargingController;", "Landroidx/work/impl/constraints/controllers/ConstraintController;", "", "tracker", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "(Landroidx/work/impl/constraints/trackers/ConstraintTracker;)V", "hasConstraint", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "isConstrained", "value", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ContraintControllers.kt */
public final class BatteryChargingController extends ConstraintController<Boolean> {
    public boolean isConstrained(boolean z) {
        return !z;
    }

    public /* bridge */ /* synthetic */ boolean isConstrained(Object obj) {
        return isConstrained(((Boolean) obj).booleanValue());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BatteryChargingController(ConstraintTracker<Boolean> constraintTracker) {
        super(constraintTracker);
        Intrinsics.checkNotNullParameter(constraintTracker, "tracker");
    }

    public boolean hasConstraint(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        return workSpec.constraints.requiresCharging();
    }
}
