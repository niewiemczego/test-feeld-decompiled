package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;

public class SystemAlarmScheduler implements Scheduler {
    private static final String TAG = Logger.tagWithPrefix("SystemAlarmScheduler");
    private final Context mContext;

    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    public SystemAlarmScheduler(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void schedule(WorkSpec... workSpecArr) {
        for (WorkSpec scheduleWorkSpec : workSpecArr) {
            scheduleWorkSpec(scheduleWorkSpec);
        }
    }

    public void cancel(String str) {
        this.mContext.startService(CommandHandler.createStopWorkIntent(this.mContext, str));
    }

    private void scheduleWorkSpec(WorkSpec workSpec) {
        Logger.get().debug(TAG, "Scheduling work with workSpecId " + workSpec.id);
        this.mContext.startService(CommandHandler.createScheduleWorkIntent(this.mContext, WorkSpecKt.generationalId(workSpec)));
    }
}
