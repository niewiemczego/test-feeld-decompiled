package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcv;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.5.0 */
final class zzl implements Runnable {
    private final /* synthetic */ zzcv zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcv zzcv, String str, String str2) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzcv;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void run() {
        this.zzd.zza.zzr().zza(this.zza, this.zzb, this.zzc);
    }
}
