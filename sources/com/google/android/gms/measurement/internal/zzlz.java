package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzlz implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzlx zzb;

    zzlz(zzlx zzlx, long j) {
        this.zzb = zzlx;
        this.zza = j;
    }

    public final void run() {
        zzlx.zza(this.zzb, this.zza);
    }
}
