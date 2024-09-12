package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzav implements Runnable {
    private final /* synthetic */ zzif zza;
    private final /* synthetic */ zzaw zzb;

    zzav(zzaw zzaw, zzif zzif) {
        this.zzb = zzaw;
        this.zza = zzif;
    }

    public final void run() {
        this.zza.zzd();
        if (zzae.zza()) {
            this.zza.zzl().zzb((Runnable) this);
            return;
        }
        boolean zzc = this.zzb.zzc();
        this.zzb.zzd = 0;
        if (zzc) {
            this.zzb.zzb();
        }
    }
}
