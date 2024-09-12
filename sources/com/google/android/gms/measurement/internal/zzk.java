package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcv;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.5.0 */
final class zzk implements Runnable {
    private final /* synthetic */ zzcv zza;
    private final /* synthetic */ zzbg zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzk(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcv zzcv, zzbg zzbg, String str) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzcv;
        this.zzb = zzbg;
        this.zzc = str;
    }

    public final void run() {
        this.zzd.zza.zzr().zza(this.zza, this.zzb, this.zzc);
    }
}
