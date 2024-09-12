package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzkn implements Runnable {
    private final /* synthetic */ zzki zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzkh zzc;

    zzkn(zzkh zzkh, zzki zzki, long j) {
        this.zzc = zzkh;
        this.zza = zzki;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zza(this.zza, false, this.zzb);
        this.zzc.zza = null;
        this.zzc.zzo().zza((zzki) null);
    }
}
