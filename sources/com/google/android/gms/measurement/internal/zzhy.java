package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzhy implements Runnable {
    private final /* synthetic */ zznc zza;
    private final /* synthetic */ zzo zzb;
    private final /* synthetic */ zzhj zzc;

    zzhy(zzhj zzhj, zznc zznc, zzo zzo) {
        this.zzc = zzhj;
        this.zza = zznc;
        this.zzb = zzo;
    }

    public final void run() {
        this.zzc.zza.zzr();
        if (this.zza.zza() == null) {
            this.zzc.zza.zza(this.zza.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}
