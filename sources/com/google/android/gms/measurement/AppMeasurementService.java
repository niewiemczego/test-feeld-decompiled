package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.zzlu;
import com.google.android.gms.measurement.internal.zzly;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class AppMeasurementService extends Service implements zzly {
    private zzlu<AppMeasurementService> zza;

    public final int onStartCommand(Intent intent, int i, int i2) {
        return zza().zza(intent, i, i2);
    }

    public final IBinder onBind(Intent intent) {
        return zza().zza(intent);
    }

    private final zzlu<AppMeasurementService> zza() {
        if (this.zza == null) {
            this.zza = new zzlu<>(this);
        }
        return this.zza;
    }

    public final void zza(Intent intent) {
        AppMeasurementReceiver.completeWakefulIntent(intent);
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
        throw new UnsupportedOperationException();
    }

    public final boolean zza(int i) {
        return stopSelfResult(i);
    }

    public final boolean onUnbind(Intent intent) {
        return zza().zzc(intent);
    }
}
