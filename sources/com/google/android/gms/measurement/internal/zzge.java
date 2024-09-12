package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzge implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzgb zzb;

    zzge(zzgb zzgb, boolean z) {
        this.zzb = zzgb;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzb.zza(this.zza);
    }
}
