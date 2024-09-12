package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzhp implements Runnable {
    private final /* synthetic */ zzad zza;
    private final /* synthetic */ zzhj zzb;

    zzhp(zzhj zzhj, zzad zzad) {
        this.zzb = zzhj;
        this.zza = zzad;
    }

    public final void run() {
        this.zzb.zza.zzr();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zza(this.zza);
        } else {
            this.zzb.zza.zzb(this.zza);
        }
    }
}
