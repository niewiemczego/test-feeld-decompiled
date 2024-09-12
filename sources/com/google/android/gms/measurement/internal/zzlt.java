package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final /* synthetic */ class zzlt implements Runnable {
    private /* synthetic */ zzlu zza;
    private /* synthetic */ zzfr zzb;
    private /* synthetic */ JobParameters zzc;

    public /* synthetic */ zzlt(zzlu zzlu, zzfr zzfr, JobParameters jobParameters) {
        this.zza = zzlu;
        this.zzb = zzfr;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc);
    }
}
