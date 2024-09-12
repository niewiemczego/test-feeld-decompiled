package com.google.android.play.core.review.internal;

import android.os.IBinder;

/* compiled from: com.google.android.play:review@@2.0.1 */
final class zzp extends zzj {
    final /* synthetic */ IBinder zza;
    final /* synthetic */ zzs zzb;

    zzp(zzs zzs, IBinder iBinder) {
        this.zzb = zzs;
        this.zza = iBinder;
    }

    public final void zza() {
        this.zzb.zza.zzn = zze.zzb(this.zza);
        zzt.zzn(this.zzb.zza);
        this.zzb.zza.zzh = false;
        for (Runnable run : this.zzb.zza.zze) {
            run.run();
        }
        this.zzb.zza.zze.clear();
    }
}
