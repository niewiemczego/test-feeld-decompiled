package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzlu;
import com.google.android.gms.measurement.internal.zzly;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class AppMeasurementJobService extends JobService implements zzly {
    private zzlu<AppMeasurementJobService> zza;

    private final zzlu<AppMeasurementJobService> zza() {
        if (this.zza == null) {
            this.zza = new zzlu<>(this);
        }
        return this.zza;
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public final void zza(Intent intent) {
    }

    public final void onCreate() {
        super.onCreate();
        zza().zza();
    }

    public final void onDestroy() {
        zza().zzb();
        super.onDestroy();
    }

    public final void onRebind(Intent intent) {
        zza().zzb(intent);
    }

    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    public final boolean zza(int i) {
        throw new UnsupportedOperationException();
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        return zza().zza(jobParameters);
    }

    public final boolean onUnbind(Intent intent) {
        return zza().zzc(intent);
    }
}
