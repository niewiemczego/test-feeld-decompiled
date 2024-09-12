package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzhg implements Runnable {
    private final /* synthetic */ zzio zza;
    private final /* synthetic */ zzhf zzb;

    zzhg(zzhf zzhf, zzio zzio) {
        this.zzb = zzhf;
        this.zza = zzio;
    }

    public final void run() {
        zzhf.zza(this.zzb, this.zza);
        this.zzb.zza(this.zza.zzg);
    }
}
