package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.PersistableBundle;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService extends JobService implements ExecutionListener {
    private static final String TAG = Logger.tagWithPrefix("SystemJobService");
    private final Map<WorkGenerationalId, JobParameters> mJobParameters = new HashMap();
    private final StartStopTokens mStartStopTokens = new StartStopTokens();
    private WorkManagerImpl mWorkManagerImpl;

    public void onCreate() {
        super.onCreate();
        try {
            WorkManagerImpl instance = WorkManagerImpl.getInstance(getApplicationContext());
            this.mWorkManagerImpl = instance;
            instance.getProcessor().addExecutionListener(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                Logger.get().warning(TAG, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
        if (workManagerImpl != null) {
            workManagerImpl.getProcessor().removeExecutionListener(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0072, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0077, code lost:
        if (android.os.Build.VERSION.SDK_INT < 24) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0079, code lost:
        r2 = new androidx.work.WorkerParameters.RuntimeExtras();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.getTriggeredContentUris(r8) == null) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0084, code lost:
        r2.triggeredContentUris = java.util.Arrays.asList(androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.getTriggeredContentUris(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0092, code lost:
        if (androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.getTriggeredContentAuthorities(r8) == null) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0094, code lost:
        r2.triggeredContentAuthorities = java.util.Arrays.asList(androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.getTriggeredContentAuthorities(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a2, code lost:
        if (android.os.Build.VERSION.SDK_INT < 28) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a4, code lost:
        r2.network = androidx.work.impl.background.systemjob.SystemJobService.Api28Impl.getNetwork(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00aa, code lost:
        r7.mWorkManagerImpl.startWork(r7.mStartStopTokens.tokenFor(r0), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b5, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartJob(android.app.job.JobParameters r8) {
        /*
            r7 = this;
            androidx.work.impl.WorkManagerImpl r0 = r7.mWorkManagerImpl
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0015
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r3 = TAG
            java.lang.String r4 = "WorkManager is not initialized; requesting retry."
            r0.debug(r3, r4)
            r7.jobFinished(r8, r1)
            return r2
        L_0x0015:
            androidx.work.impl.model.WorkGenerationalId r0 = workGenerationalIdFromJobParameters(r8)
            if (r0 != 0) goto L_0x0027
            androidx.work.Logger r8 = androidx.work.Logger.get()
            java.lang.String r0 = TAG
            java.lang.String r1 = "WorkSpec id not found!"
            r8.error(r0, r1)
            return r2
        L_0x0027:
            java.util.Map<androidx.work.impl.model.WorkGenerationalId, android.app.job.JobParameters> r3 = r7.mJobParameters
            monitor-enter(r3)
            java.util.Map<androidx.work.impl.model.WorkGenerationalId, android.app.job.JobParameters> r4 = r7.mJobParameters     // Catch:{ all -> 0x00b6 }
            boolean r4 = r4.containsKey(r0)     // Catch:{ all -> 0x00b6 }
            if (r4 == 0) goto L_0x0050
            androidx.work.Logger r8 = androidx.work.Logger.get()     // Catch:{ all -> 0x00b6 }
            java.lang.String r1 = TAG     // Catch:{ all -> 0x00b6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b6 }
            r4.<init>()     // Catch:{ all -> 0x00b6 }
            java.lang.String r5 = "Job is already being executed by SystemJobService: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00b6 }
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch:{ all -> 0x00b6 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b6 }
            r8.debug(r1, r0)     // Catch:{ all -> 0x00b6 }
            monitor-exit(r3)     // Catch:{ all -> 0x00b6 }
            return r2
        L_0x0050:
            androidx.work.Logger r2 = androidx.work.Logger.get()     // Catch:{ all -> 0x00b6 }
            java.lang.String r4 = TAG     // Catch:{ all -> 0x00b6 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b6 }
            r5.<init>()     // Catch:{ all -> 0x00b6 }
            java.lang.String r6 = "onStartJob for "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x00b6 }
            java.lang.StringBuilder r5 = r5.append(r0)     // Catch:{ all -> 0x00b6 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00b6 }
            r2.debug(r4, r5)     // Catch:{ all -> 0x00b6 }
            java.util.Map<androidx.work.impl.model.WorkGenerationalId, android.app.job.JobParameters> r2 = r7.mJobParameters     // Catch:{ all -> 0x00b6 }
            r2.put(r0, r8)     // Catch:{ all -> 0x00b6 }
            monitor-exit(r3)     // Catch:{ all -> 0x00b6 }
            r2 = 0
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r3 < r4) goto L_0x00aa
            androidx.work.WorkerParameters$RuntimeExtras r2 = new androidx.work.WorkerParameters$RuntimeExtras
            r2.<init>()
            android.net.Uri[] r3 = androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.getTriggeredContentUris(r8)
            if (r3 == 0) goto L_0x008e
            android.net.Uri[] r3 = androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.getTriggeredContentUris(r8)
            java.util.List r3 = java.util.Arrays.asList(r3)
            r2.triggeredContentUris = r3
        L_0x008e:
            java.lang.String[] r3 = androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.getTriggeredContentAuthorities(r8)
            if (r3 == 0) goto L_0x009e
            java.lang.String[] r3 = androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.getTriggeredContentAuthorities(r8)
            java.util.List r3 = java.util.Arrays.asList(r3)
            r2.triggeredContentAuthorities = r3
        L_0x009e:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r3 < r4) goto L_0x00aa
            android.net.Network r8 = androidx.work.impl.background.systemjob.SystemJobService.Api28Impl.getNetwork(r8)
            r2.network = r8
        L_0x00aa:
            androidx.work.impl.WorkManagerImpl r8 = r7.mWorkManagerImpl
            androidx.work.impl.StartStopTokens r3 = r7.mStartStopTokens
            androidx.work.impl.StartStopToken r0 = r3.tokenFor((androidx.work.impl.model.WorkGenerationalId) r0)
            r8.startWork(r0, r2)
            return r1
        L_0x00b6:
            r8 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00b6 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    public boolean onStopJob(JobParameters jobParameters) {
        if (this.mWorkManagerImpl == null) {
            Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        WorkGenerationalId workGenerationalIdFromJobParameters = workGenerationalIdFromJobParameters(jobParameters);
        if (workGenerationalIdFromJobParameters == null) {
            Logger.get().error(TAG, "WorkSpec id not found!");
            return false;
        }
        Logger.get().debug(TAG, "onStopJob for " + workGenerationalIdFromJobParameters);
        synchronized (this.mJobParameters) {
            this.mJobParameters.remove(workGenerationalIdFromJobParameters);
        }
        StartStopToken remove = this.mStartStopTokens.remove(workGenerationalIdFromJobParameters);
        if (remove != null) {
            this.mWorkManagerImpl.stopWork(remove);
        }
        return !this.mWorkManagerImpl.getProcessor().isCancelled(workGenerationalIdFromJobParameters.getWorkSpecId());
    }

    public void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
        JobParameters remove;
        Logger.get().debug(TAG, workGenerationalId.getWorkSpecId() + " executed on JobScheduler");
        synchronized (this.mJobParameters) {
            remove = this.mJobParameters.remove(workGenerationalId);
        }
        this.mStartStopTokens.remove(workGenerationalId);
        if (remove != null) {
            jobFinished(remove, z);
        }
    }

    private static WorkGenerationalId workGenerationalIdFromJobParameters(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new WorkGenerationalId(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static Uri[] getTriggeredContentUris(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentUris();
        }

        static String[] getTriggeredContentAuthorities(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentAuthorities();
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Network getNetwork(JobParameters jobParameters) {
            return jobParameters.getNetwork();
        }
    }
}
