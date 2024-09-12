package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcp;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
abstract class zzaw {
    private static volatile Handler zza;
    private final zzif zzb;
    private final Runnable zzc;
    /* access modifiers changed from: private */
    public volatile long zzd;

    private final Handler zzd() {
        Handler handler;
        if (zza != null) {
            return zza;
        }
        synchronized (zzaw.class) {
            if (zza == null) {
                zza = new zzcp(this.zzb.zza().getMainLooper());
            }
            handler = zza;
        }
        return handler;
    }

    public abstract void zzb();

    zzaw(zzif zzif) {
        Preconditions.checkNotNull(zzif);
        this.zzb = zzif;
        this.zzc = new zzav(this, zzif);
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzd = 0;
        zzd().removeCallbacks(this.zzc);
    }

    public final void zza(long j) {
        zza();
        if (j >= 0) {
            this.zzd = this.zzb.zzb().currentTimeMillis();
            if (!zzd().postDelayed(this.zzc, j)) {
                this.zzb.zzj().zzg().zza("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final boolean zzc() {
        return this.zzd != 0;
    }
}
