package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzc implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzb zzb;

    zzc(zzb zzb2, long j) {
        this.zzb = zzb2;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
