package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzhx implements Runnable {
    private final /* synthetic */ zzbg zza;
    private final /* synthetic */ zzo zzb;
    private final /* synthetic */ zzhj zzc;

    zzhx(zzhj zzhj, zzbg zzbg, zzo zzo) {
        this.zzc = zzhj;
        this.zza = zzbg;
        this.zzb = zzo;
    }

    public final void run() {
        this.zzc.zzc(this.zzc.zzb(this.zza, this.zzb), this.zzb);
    }
}
