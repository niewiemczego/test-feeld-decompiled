package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzhk implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ zzhj zzb;

    zzhk(zzhj zzhj, zzo zzo) {
        this.zzb = zzhj;
        this.zza = zzo;
    }

    public final void run() {
        this.zzb.zza.zzr();
        this.zzb.zza.zzc(this.zza);
    }
}
