package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zza implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzb zzc;

    zza(zzb zzb2, String str, long j) {
        this.zzc = zzb2;
        this.zza = str;
        this.zzb = j;
    }

    public final void run() {
        zzb.zza(this.zzc, this.zza, this.zzb);
    }
}
