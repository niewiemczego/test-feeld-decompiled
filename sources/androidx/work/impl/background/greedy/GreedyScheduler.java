package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Scheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.ProcessUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GreedyScheduler implements Scheduler, WorkConstraintsCallback, ExecutionListener {
    private static final String TAG = Logger.tagWithPrefix("GreedyScheduler");
    private final Set<WorkSpec> mConstrainedWorkSpecs = new HashSet();
    private final Context mContext;
    private DelayedWorkTracker mDelayedWorkTracker;
    Boolean mInDefaultProcess;
    private final Object mLock;
    private boolean mRegisteredExecutionListener;
    private final StartStopTokens mStartStopTokens = new StartStopTokens();
    private final WorkConstraintsTracker mWorkConstraintsTracker;
    private final WorkManagerImpl mWorkManagerImpl;

    public boolean hasLimitedSchedulingSlots() {
        return false;
    }

    public GreedyScheduler(Context context, Configuration configuration, Trackers trackers, WorkManagerImpl workManagerImpl) {
        this.mContext = context;
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkConstraintsTracker = new WorkConstraintsTrackerImpl(trackers, (WorkConstraintsCallback) this);
        this.mDelayedWorkTracker = new DelayedWorkTracker(this, configuration.getRunnableScheduler());
        this.mLock = new Object();
    }

    public GreedyScheduler(Context context, WorkManagerImpl workManagerImpl, WorkConstraintsTracker workConstraintsTracker) {
        this.mContext = context;
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkConstraintsTracker = workConstraintsTracker;
        this.mLock = new Object();
    }

    public void setDelayedWorkTracker(DelayedWorkTracker delayedWorkTracker) {
        this.mDelayedWorkTracker = delayedWorkTracker;
    }

    public void schedule(WorkSpec... workSpecArr) {
        if (this.mInDefaultProcess == null) {
            checkDefaultProcess();
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            Logger.get().info(TAG, "Ignoring schedule request in a secondary process");
            return;
        }
        registerExecutionListenerIfNeeded();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (WorkSpec workSpec : workSpecArr) {
            if (!this.mStartStopTokens.contains(WorkSpecKt.generationalId(workSpec))) {
                long calculateNextRunTime = workSpec.calculateNextRunTime();
                long currentTimeMillis = System.currentTimeMillis();
                if (workSpec.state == WorkInfo.State.ENQUEUED) {
                    if (currentTimeMillis < calculateNextRunTime) {
                        DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
                        if (delayedWorkTracker != null) {
                            delayedWorkTracker.schedule(workSpec);
                        }
                    } else if (workSpec.hasConstraints()) {
                        if (Build.VERSION.SDK_INT >= 23 && workSpec.constraints.requiresDeviceIdle()) {
                            Logger.get().debug(TAG, "Ignoring " + workSpec + ". Requires device idle.");
                        } else if (Build.VERSION.SDK_INT < 24 || !workSpec.constraints.hasContentUriTriggers()) {
                            hashSet.add(workSpec);
                            hashSet2.add(workSpec.id);
                        } else {
                            Logger.get().debug(TAG, "Ignoring " + workSpec + ". Requires ContentUri triggers.");
                        }
                    } else if (!this.mStartStopTokens.contains(WorkSpecKt.generationalId(workSpec))) {
                        Logger.get().debug(TAG, "Starting work for " + workSpec.id);
                        this.mWorkManagerImpl.startWork(this.mStartStopTokens.tokenFor(workSpec));
                    }
                }
            }
        }
        synchronized (this.mLock) {
            if (!hashSet.isEmpty()) {
                Logger.get().debug(TAG, "Starting tracking for " + TextUtils.join(",", hashSet2));
                this.mConstrainedWorkSpecs.addAll(hashSet);
                this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
            }
        }
    }

    private void checkDefaultProcess() {
        this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext, this.mWorkManagerImpl.getConfiguration()));
    }

    public void cancel(String str) {
        if (this.mInDefaultProcess == null) {
            checkDefaultProcess();
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            Logger.get().info(TAG, "Ignoring schedule request in non-main process");
            return;
        }
        registerExecutionListenerIfNeeded();
        Logger.get().debug(TAG, "Cancelling work ID " + str);
        DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
        if (delayedWorkTracker != null) {
            delayedWorkTracker.unschedule(str);
        }
        for (StartStopToken stopWork : this.mStartStopTokens.remove(str)) {
            this.mWorkManagerImpl.stopWork(stopWork);
        }
    }

    public void onAllConstraintsMet(List<WorkSpec> list) {
        for (WorkSpec generationalId : list) {
            WorkGenerationalId generationalId2 = WorkSpecKt.generationalId(generationalId);
            if (!this.mStartStopTokens.contains(generationalId2)) {
                Logger.get().debug(TAG, "Constraints met: Scheduling work ID " + generationalId2);
                this.mWorkManagerImpl.startWork(this.mStartStopTokens.tokenFor(generationalId2));
            }
        }
    }

    public void onAllConstraintsNotMet(List<WorkSpec> list) {
        for (WorkSpec generationalId : list) {
            WorkGenerationalId generationalId2 = WorkSpecKt.generationalId(generationalId);
            Logger.get().debug(TAG, "Constraints not met: Cancelling work ID " + generationalId2);
            StartStopToken remove = this.mStartStopTokens.remove(generationalId2);
            if (remove != null) {
                this.mWorkManagerImpl.stopWork(remove);
            }
        }
    }

    public void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
        this.mStartStopTokens.remove(workGenerationalId);
        removeConstraintTrackingFor(workGenerationalId);
    }

    private void removeConstraintTrackingFor(WorkGenerationalId workGenerationalId) {
        synchronized (this.mLock) {
            Iterator<WorkSpec> it = this.mConstrainedWorkSpecs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WorkSpec next = it.next();
                if (WorkSpecKt.generationalId(next).equals(workGenerationalId)) {
                    Logger.get().debug(TAG, "Stopping tracking for " + workGenerationalId);
                    this.mConstrainedWorkSpecs.remove(next);
                    this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
                    break;
                }
            }
        }
    }

    private void registerExecutionListenerIfNeeded() {
        if (!this.mRegisteredExecutionListener) {
            this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
            this.mRegisteredExecutionListener = true;
        }
    }
}
