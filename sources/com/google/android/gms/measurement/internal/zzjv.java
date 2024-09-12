package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzps;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzjv implements Runnable {
    private final /* synthetic */ zzih zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzih zze;
    private final /* synthetic */ zziq zzf;

    zzjv(zziq zziq, zzih zzih, long j, long j2, boolean z, zzih zzih2) {
        this.zzf = zziq;
        this.zza = zzih;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = z;
        this.zze = zzih2;
    }

    public final void run() {
        this.zzf.zza(this.zza);
        this.zzf.zza(this.zzb, false);
        zziq.zza(this.zzf, this.zza, this.zzc, true, this.zzd);
        if (zzps.zza() && this.zzf.zze().zza(zzbi.zzbs)) {
            zziq.zza(this.zzf, this.zza, this.zze);
        }
    }
}
