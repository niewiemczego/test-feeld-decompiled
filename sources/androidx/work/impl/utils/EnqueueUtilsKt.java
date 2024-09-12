package androidx.work.impl.utils;

import android.os.Build;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.impl.workers.ConstraintTrackingWorkerKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u001e\u0010\n\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\u000b"}, d2 = {"tryDelegateConstrainedWorkSpec", "Landroidx/work/impl/model/WorkSpec;", "workSpec", "usesScheduler", "", "schedulers", "", "Landroidx/work/impl/Scheduler;", "className", "", "wrapInConstraintTrackingWorkerIfNeeded", "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: EnqueueUtils.kt */
public final class EnqueueUtilsKt {
    public static final WorkSpec tryDelegateConstrainedWorkSpec(WorkSpec workSpec) {
        WorkSpec workSpec2 = workSpec;
        Intrinsics.checkNotNullParameter(workSpec2, "workSpec");
        Constraints constraints = workSpec2.constraints;
        String str = workSpec2.workerClassName;
        if (Intrinsics.areEqual((Object) str, (Object) ConstraintTrackingWorker.class.getName())) {
            return workSpec2;
        }
        if (!constraints.requiresBatteryNotLow() && !constraints.requiresStorageNotLow()) {
            return workSpec2;
        }
        Data build = new Data.Builder().putAll(workSpec2.input).putString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME, str).build();
        Data data = build;
        Intrinsics.checkNotNullExpressionValue(build, "Builder().putAll(workSpe…ame)\n            .build()");
        String name = ConstraintTrackingWorker.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return WorkSpec.copy$default(workSpec, (String) null, (WorkInfo.State) null, name, (String) null, data, (Data) null, 0, 0, 0, (Constraints) null, 0, (BackoffPolicy) null, 0, 0, 0, 0, false, (OutOfQuotaPolicy) null, 0, 0, 1048555, (Object) null);
    }

    public static final WorkSpec wrapInConstraintTrackingWorkerIfNeeded(List<? extends Scheduler> list, WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(list, "schedulers");
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        if (23 <= i && i < 26) {
            z = true;
        }
        if (z) {
            return tryDelegateConstrainedWorkSpec(workSpec);
        }
        return (Build.VERSION.SDK_INT > 22 || !usesScheduler(list, Schedulers.GCM_SCHEDULER)) ? workSpec : tryDelegateConstrainedWorkSpec(workSpec);
    }

    private static final boolean usesScheduler(List<? extends Scheduler> list, String str) {
        try {
            Class<?> cls = Class.forName(str);
            Iterable<Scheduler> iterable = list;
            if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                return false;
            }
            for (Scheduler scheduler : iterable) {
                if (cls.isAssignableFrom(scheduler.getClass())) {
                    return true;
                }
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
