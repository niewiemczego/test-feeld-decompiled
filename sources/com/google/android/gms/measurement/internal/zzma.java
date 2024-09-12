package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzma implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzlx zzb;

    zzma(zzlx zzlx, long j) {
        this.zzb = zzlx;
        this.zza = j;
    }

    public final void run() {
        zzlx.zzb(this.zzb, this.zza);
    }
}
