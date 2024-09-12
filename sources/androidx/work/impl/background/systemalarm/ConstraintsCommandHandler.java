package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.ArrayList;
import java.util.List;

class ConstraintsCommandHandler {
    private static final String TAG = Logger.tagWithPrefix("ConstraintsCmdHandler");
    private final Context mContext;
    private final SystemAlarmDispatcher mDispatcher;
    private final int mStartId;
    private final WorkConstraintsTrackerImpl mWorkConstraintsTracker;

    ConstraintsCommandHandler(Context context, int i, SystemAlarmDispatcher systemAlarmDispatcher) {
        this.mContext = context;
        this.mStartId = i;
        this.mDispatcher = systemAlarmDispatcher;
        this.mWorkConstraintsTracker = new WorkConstraintsTrackerImpl(systemAlarmDispatcher.getWorkManager().getTrackers(), (WorkConstraintsCallback) null);
    }

    /* access modifiers changed from: package-private */
    public void handleConstraintsChanged() {
        List<WorkSpec> scheduledWork = this.mDispatcher.getWorkManager().getWorkDatabase().workSpecDao().getScheduledWork();
        ConstraintProxy.updateAll(this.mContext, scheduledWork);
        this.mWorkConstraintsTracker.replace(scheduledWork);
        ArrayList<WorkSpec> arrayList = new ArrayList<>(scheduledWork.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (WorkSpec next : scheduledWork) {
            String str = next.id;
            if (currentTimeMillis >= next.calculateNextRunTime() && (!next.hasConstraints() || this.mWorkConstraintsTracker.areAllConstraintsMet(str))) {
                arrayList.add(next);
            }
        }
        for (WorkSpec workSpec : arrayList) {
            String str2 = workSpec.id;
            Intent createDelayMetIntent = CommandHandler.createDelayMetIntent(this.mContext, WorkSpecKt.generationalId(workSpec));
            Logger.get().debug(TAG, "Creating a delay_met command for workSpec with id (" + str2 + ")");
            this.mDispatcher.getTaskExecutor().getMainThreadExecutor().execute(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, createDelayMetIntent, this.mStartId));
        }
        this.mWorkConstraintsTracker.reset();
    }
}
