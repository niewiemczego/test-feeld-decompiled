package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import io.sentry.protocol.SentryThread;

public class JobInfoSchedulerService extends JobService {
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }

    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt(SentryThread.JsonKeys.PRIORITY);
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        TransportRuntime.initialize(getApplicationContext());
        TransportContext.Builder priority = TransportContext.builder().setBackendName(string).setPriority(PriorityMapping.valueOf(i));
        if (string2 != null) {
            priority.setExtras(Base64.decode(string2, 0));
        }
        TransportRuntime.getInstance().getUploader().upload(priority.build(), i2, new JobInfoSchedulerService$$ExternalSyntheticLambda0(this, jobParameters));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onStartJob$0$com-google-android-datatransport-runtime-scheduling-jobscheduling-JobInfoSchedulerService  reason: not valid java name */
    public /* synthetic */ void m414lambda$onStartJob$0$comgoogleandroiddatatransportruntimeschedulingjobschedulingJobInfoSchedulerService(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }
}
