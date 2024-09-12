package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzjb implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zziq zzb;

    zzjb(zziq zziq, boolean z) {
        this.zzb = zziq;
        this.zza = z;
    }

    public final void run() {
        boolean zzac = this.zzb.zzu.zzac();
        boolean zzab = this.zzb.zzu.zzab();
        this.zzb.zzu.zza(this.zza);
        if (zzab == this.zza) {
            this.zzb.zzu.zzj().zzp().zza("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzu.zzac() == zzac || this.zzb.zzu.zzac() != this.zzb.zzu.zzab()) {
            this.zzb.zzu.zzj().zzv().zza("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zzac));
        }
        this.zzb.zzap();
    }
}
