package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzoh;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzmd {
    protected long zza;
    final /* synthetic */ zzlx zzb;
    private long zzc;
    private final zzaw zzd;

    /* access modifiers changed from: package-private */
    public final long zza(long j) {
        long j2 = j - this.zza;
        this.zza = j;
        return j2;
    }

    static /* synthetic */ void zza(zzmd zzmd) {
        zzmd.zzb.zzt();
        zzmd.zza(false, false, zzmd.zzb.zzb().elapsedRealtime());
        zzmd.zzb.zzc().zza(zzmd.zzb.zzb().elapsedRealtime());
    }

    public zzmd(zzlx zzlx) {
        this.zzb = zzlx;
        this.zzd = new zzmg(this, zzlx.zzu);
        long elapsedRealtime = zzlx.zzb().elapsedRealtime();
        this.zzc = elapsedRealtime;
        this.zza = elapsedRealtime;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzd.zza();
        this.zzc = 0;
        this.zza = 0;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(long j) {
        this.zzd.zza();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(long j) {
        this.zzb.zzt();
        this.zzd.zza();
        this.zzc = j;
        this.zza = j;
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        this.zzb.zzt();
        this.zzb.zzu();
        if (!zzoh.zza() || !this.zzb.zze().zza(zzbi.zzbn) || this.zzb.zzu.zzac()) {
            this.zzb.zzk().zzk.zza(this.zzb.zzb().currentTimeMillis());
        }
        long j2 = j - this.zzc;
        if (z || j2 >= 1000) {
            if (!z2) {
                j2 = zza(j);
            }
            this.zzb.zzj().zzp().zza("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            zznd.zza(this.zzb.zzn().zza(!this.zzb.zze().zzu()), bundle, true);
            if (!z2) {
                this.zzb.zzm().zzc("auto", "_e", bundle);
            }
            this.zzc = j;
            this.zzd.zza();
            this.zzd.zza(DateUtils.MILLIS_PER_HOUR);
            return true;
        }
        this.zzb.zzj().zzp().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }
}
