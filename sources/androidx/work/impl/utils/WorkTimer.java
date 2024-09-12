package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.HashMap;
import java.util.Map;

public class WorkTimer {
    private static final String TAG = Logger.tagWithPrefix("WorkTimer");
    final Map<WorkGenerationalId, TimeLimitExceededListener> mListeners = new HashMap();
    final Object mLock = new Object();
    final RunnableScheduler mRunnableScheduler;
    final Map<WorkGenerationalId, WorkTimerRunnable> mTimerMap = new HashMap();

    public interface TimeLimitExceededListener {
        void onTimeLimitExceeded(WorkGenerationalId workGenerationalId);
    }

    public WorkTimer(RunnableScheduler runnableScheduler) {
        this.mRunnableScheduler = runnableScheduler;
    }

    public void startTimer(WorkGenerationalId workGenerationalId, long j, TimeLimitExceededListener timeLimitExceededListener) {
        synchronized (this.mLock) {
            Logger.get().debug(TAG, "Starting timer for " + workGenerationalId);
            stopTimer(workGenerationalId);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, workGenerationalId);
            this.mTimerMap.put(workGenerationalId, workTimerRunnable);
            this.mListeners.put(workGenerationalId, timeLimitExceededListener);
            this.mRunnableScheduler.scheduleWithDelay(j, workTimerRunnable);
        }
    }

    public void stopTimer(WorkGenerationalId workGenerationalId) {
        synchronized (this.mLock) {
            if (this.mTimerMap.remove(workGenerationalId) != null) {
                Logger.get().debug(TAG, "Stopping timer for " + workGenerationalId);
                this.mListeners.remove(workGenerationalId);
            }
        }
    }

    public Map<WorkGenerationalId, WorkTimerRunnable> getTimerMap() {
        Map<WorkGenerationalId, WorkTimerRunnable> map;
        synchronized (this.mLock) {
            map = this.mTimerMap;
        }
        return map;
    }

    public Map<WorkGenerationalId, TimeLimitExceededListener> getListeners() {
        Map<WorkGenerationalId, TimeLimitExceededListener> map;
        synchronized (this.mLock) {
            map = this.mListeners;
        }
        return map;
    }

    public static class WorkTimerRunnable implements Runnable {
        static final String TAG = "WrkTimerRunnable";
        private final WorkGenerationalId mWorkGenerationalId;
        private final WorkTimer mWorkTimer;

        WorkTimerRunnable(WorkTimer workTimer, WorkGenerationalId workGenerationalId) {
            this.mWorkTimer = workTimer;
            this.mWorkGenerationalId = workGenerationalId;
        }

        public void run() {
            synchronized (this.mWorkTimer.mLock) {
                if (this.mWorkTimer.mTimerMap.remove(this.mWorkGenerationalId) != null) {
                    TimeLimitExceededListener remove = this.mWorkTimer.mListeners.remove(this.mWorkGenerationalId);
                    if (remove != null) {
                        remove.onTimeLimitExceeded(this.mWorkGenerationalId);
                    }
                } else {
                    Logger.get().debug(TAG, String.format("Timer with %s is already marked as complete.", new Object[]{this.mWorkGenerationalId}));
                }
            }
        }
    }
}
