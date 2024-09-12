package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzhm implements Runnable {
    private final /* synthetic */ zzad zza;
    private final /* synthetic */ zzo zzb;
    private final /* synthetic */ zzhj zzc;

    zzhm(zzhj zzhj, zzad zzad, zzo zzo) {
        this.zzc = zzhj;
        this.zza = zzad;
        this.zzb = zzo;
    }

    public final void run() {
        this.zzc.zza.zzr();
        if (this.zza.zzc.zza() == null) {
            this.zzc.zza.zza(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzb(this.zza, this.zzb);
        }
    }
}
