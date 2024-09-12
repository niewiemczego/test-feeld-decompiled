package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzmm extends zzaw {
    private final /* synthetic */ zzmj zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzmm(zzmj zzmj, zzif zzif) {
        super(zzif);
        this.zza = zzmj;
    }

    public final void zzb() {
        this.zza.zzu();
        this.zza.zzj().zzp().zza("Starting upload from DelayedRunnable");
        this.zza.zzf.zzw();
    }
}
