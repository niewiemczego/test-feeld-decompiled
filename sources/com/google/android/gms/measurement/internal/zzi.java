package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcv;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.5.0 */
final class zzi implements Runnable {
    private final /* synthetic */ zzcv zza;
    private final /* synthetic */ AppMeasurementDynamiteService zzb;

    zzi(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcv zzcv) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzcv;
    }

    public final void run() {
        this.zzb.zza.zzr().zza(this.zza);
    }
}
