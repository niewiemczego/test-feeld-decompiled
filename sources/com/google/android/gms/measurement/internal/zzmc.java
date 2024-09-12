package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzmc {
    final /* synthetic */ zzlx zza;
    private zzmb zzb;

    zzmc(zzlx zzlx) {
        this.zza = zzlx;
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzb = new zzmb(this, this.zza.zzb().currentTimeMillis(), j);
        this.zza.zzc.postDelayed(this.zzb, 2000);
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zza.zzt();
        if (this.zzb != null) {
            this.zza.zzc.removeCallbacks(this.zzb);
        }
        this.zza.zzk().zzn.zza(false);
        this.zza.zza(false);
    }
}
