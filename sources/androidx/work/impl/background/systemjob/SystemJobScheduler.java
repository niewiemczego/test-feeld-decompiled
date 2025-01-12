package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.util.Consumer;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class SystemJobScheduler implements Scheduler {
    private static final String TAG = Logger.tagWithPrefix("SystemJobScheduler");
    private final Context mContext;
    private final JobScheduler mJobScheduler;
    private final SystemJobInfoConverter mSystemJobInfoConverter;
    private final WorkManagerImpl mWorkManager;

    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    public SystemJobScheduler(Context context, WorkManagerImpl workManagerImpl) {
        this(context, workManagerImpl, (JobScheduler) context.getSystemService("jobscheduler"), new SystemJobInfoConverter(context));
    }

    public SystemJobScheduler(Context context, WorkManagerImpl workManagerImpl, JobScheduler jobScheduler, SystemJobInfoConverter systemJobInfoConverter) {
        this.mContext = context;
        this.mWorkManager = workManagerImpl;
        this.mJobScheduler = jobScheduler;
        this.mSystemJobInfoConverter = systemJobInfoConverter;
    }

    public void schedule(WorkSpec... workSpecArr) {
        List<Integer> pendingJobIds;
        int i;
        WorkDatabase workDatabase = this.mWorkManager.getWorkDatabase();
        IdGenerator idGenerator = new IdGenerator(workDatabase);
        int length = workSpecArr.length;
        int i2 = 0;
        while (i2 < length) {
            WorkSpec workSpec = workSpecArr[i2];
            workDatabase.beginTransaction();
            try {
                WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(workSpec.id);
                if (workSpec2 == null) {
                    Logger.get().warning(TAG, "Skipping scheduling " + workSpec.id + " because it's no longer in the DB");
                    workDatabase.setTransactionSuccessful();
                } else if (workSpec2.state != WorkInfo.State.ENQUEUED) {
                    Logger.get().warning(TAG, "Skipping scheduling " + workSpec.id + " because it is no longer enqueued");
                    workDatabase.setTransactionSuccessful();
                } else {
                    WorkGenerationalId generationalId = WorkSpecKt.generationalId(workSpec);
                    SystemIdInfo systemIdInfo = workDatabase.systemIdInfoDao().getSystemIdInfo(generationalId);
                    int nextJobSchedulerIdWithRange = systemIdInfo != null ? systemIdInfo.systemId : idGenerator.nextJobSchedulerIdWithRange(this.mWorkManager.getConfiguration().getMinJobSchedulerId(), this.mWorkManager.getConfiguration().getMaxJobSchedulerId());
                    if (systemIdInfo == null) {
                        this.mWorkManager.getWorkDatabase().systemIdInfoDao().insertSystemIdInfo(SystemIdInfoKt.systemIdInfo(generationalId, nextJobSchedulerIdWithRange));
                    }
                    scheduleInternal(workSpec, nextJobSchedulerIdWithRange);
                    if (Build.VERSION.SDK_INT == 23 && (pendingJobIds = getPendingJobIds(this.mContext, this.mJobScheduler, workSpec.id)) != null) {
                        int indexOf = pendingJobIds.indexOf(Integer.valueOf(nextJobSchedulerIdWithRange));
                        if (indexOf >= 0) {
                            pendingJobIds.remove(indexOf);
                        }
                        if (!pendingJobIds.isEmpty()) {
                            i = pendingJobIds.get(0).intValue();
                        } else {
                            i = idGenerator.nextJobSchedulerIdWithRange(this.mWorkManager.getConfiguration().getMinJobSchedulerId(), this.mWorkManager.getConfiguration().getMaxJobSchedulerId());
                        }
                        scheduleInternal(workSpec, i);
                    }
                    workDatabase.setTransactionSuccessful();
                }
                i2++;
            } finally {
                workDatabase.endTransaction();
            }
        }
    }

    public void scheduleInternal(WorkSpec workSpec, int i) {
        JobInfo convert = this.mSystemJobInfoConverter.convert(workSpec, i);
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, "Scheduling work ID " + workSpec.id + "Job ID " + i);
        try {
            if (this.mJobScheduler.schedule(convert) == 0) {
                Logger.get().warning(str, "Unable to schedule work ID " + workSpec.id);
                if (workSpec.expedited && workSpec.outOfQuotaPolicy == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    workSpec.expedited = false;
                    Logger.get().debug(str, String.format("Scheduling a non-expedited job (work ID %s)", new Object[]{workSpec.id}));
                    scheduleInternal(workSpec, i);
                }
            }
        } catch (IllegalStateException e) {
            List<JobInfo> pendingJobs = getPendingJobs(this.mContext, this.mJobScheduler);
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", new Object[]{Integer.valueOf(pendingJobs != null ? pendingJobs.size() : 0), Integer.valueOf(this.mWorkManager.getWorkDatabase().workSpecDao().getScheduledWork().size()), Integer.valueOf(this.mWorkManager.getConfiguration().getMaxSchedulerLimit())});
            Logger.get().error(TAG, format);
            IllegalStateException illegalStateException = new IllegalStateException(format, e);
            Consumer<Throwable> schedulingExceptionHandler = this.mWorkManager.getConfiguration().getSchedulingExceptionHandler();
            if (schedulingExceptionHandler != null) {
                schedulingExceptionHandler.accept(illegalStateException);
                return;
            }
            throw illegalStateException;
        } catch (Throwable th) {
            Logger.get().error(TAG, "Unable to schedule " + workSpec, th);
        }
    }

    public void cancel(String str) {
        List<Integer> pendingJobIds = getPendingJobIds(this.mContext, this.mJobScheduler, str);
        if (pendingJobIds != null && !pendingJobIds.isEmpty()) {
            for (Integer intValue : pendingJobIds) {
                cancelJobById(this.mJobScheduler, intValue.intValue());
            }
            this.mWorkManager.getWorkDatabase().systemIdInfoDao().removeSystemIdInfo(str);
        }
    }

    private static void cancelJobById(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            Logger.get().error(TAG, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[]{Integer.valueOf(i)}), th);
        }
    }

    public static void cancelAll(Context context) {
        List<JobInfo> pendingJobs;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (pendingJobs = getPendingJobs(context, jobScheduler)) != null && !pendingJobs.isEmpty()) {
            for (JobInfo id : pendingJobs) {
                cancelJobById(jobScheduler, id.getId());
            }
        }
    }

    public static boolean reconcileJobs(Context context, WorkManagerImpl workManagerImpl) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> pendingJobs = getPendingJobs(context, jobScheduler);
        List<String> workSpecIds = workManagerImpl.getWorkDatabase().systemIdInfoDao().getWorkSpecIds();
        boolean z = false;
        HashSet hashSet = new HashSet(pendingJobs != null ? pendingJobs.size() : 0);
        if (pendingJobs != null && !pendingJobs.isEmpty()) {
            for (JobInfo next : pendingJobs) {
                WorkGenerationalId workGenerationalIdFromJobInfo = getWorkGenerationalIdFromJobInfo(next);
                if (workGenerationalIdFromJobInfo != null) {
                    hashSet.add(workGenerationalIdFromJobInfo.getWorkSpecId());
                } else {
                    cancelJobById(jobScheduler, next.getId());
                }
            }
        }
        Iterator<String> it = workSpecIds.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!hashSet.contains(it.next())) {
                    Logger.get().debug(TAG, "Reconciling jobs");
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z) {
            WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                WorkSpecDao workSpecDao = workDatabase.workSpecDao();
                for (String markWorkSpecScheduled : workSpecIds) {
                    workSpecDao.markWorkSpecScheduled(markWorkSpecScheduled, -1);
                }
                workDatabase.setTransactionSuccessful();
            } finally {
                workDatabase.endTransaction();
            }
        }
        return z;
    }

    private static List<JobInfo> getPendingJobs(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            Logger.get().error(TAG, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo next : list) {
            if (componentName.equals(next.getService())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static List<Integer> getPendingJobIds(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> pendingJobs = getPendingJobs(context, jobScheduler);
        if (pendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo next : pendingJobs) {
            WorkGenerationalId workGenerationalIdFromJobInfo = getWorkGenerationalIdFromJobInfo(next);
            if (workGenerationalIdFromJobInfo != null && str.equals(workGenerationalIdFromJobInfo.getWorkSpecId())) {
                arrayList.add(Integer.valueOf(next.getId()));
            }
        }
        return arrayList;
    }

    private static WorkGenerationalId getWorkGenerationalIdFromJobInfo(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new WorkGenerationalId(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }
}
