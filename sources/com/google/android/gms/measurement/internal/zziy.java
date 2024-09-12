package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final /* synthetic */ class zziy implements Runnable {
    private /* synthetic */ zziq zza;
    private /* synthetic */ String zzb;

    public /* synthetic */ zziy(zziq zziq, String str) {
        this.zza = zziq;
        this.zzb = str;
    }

    public final void run() {
        zziq zziq = this.zza;
        if (zziq.zzg().zzb(this.zzb)) {
            zziq.zzg().zzag();
        }
    }
}
