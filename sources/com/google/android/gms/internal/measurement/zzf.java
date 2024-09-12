package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfp;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzf {
    final zzh zza;
    final zzh zzb;
    private final zzbb zzc;
    private final zzl zzd;

    public final zzaq zza(zzh zzh, zzfp.zzd... zzdArr) {
        zzaq zzaq = zzaq.zzc;
        for (zzfp.zzd zza2 : zzdArr) {
            zzaq = zzj.zza(zza2);
            zzg.zza(this.zzb);
            if ((zzaq instanceof zzat) || (zzaq instanceof zzar)) {
                zzaq = this.zzc.zza(zzh, zzaq);
            }
        }
        return zzaq;
    }

    public zzf() {
        zzbb zzbb = new zzbb();
        this.zzc = zzbb;
        zzh zzh = new zzh((zzh) null, zzbb);
        this.zzb = zzh;
        this.zza = zzh.zza();
        zzl zzl = new zzl();
        this.zzd = zzl;
        zzh.zzc("require", new zzz(zzl));
        zzl.zza("internal.platform", zze.zza);
        zzh.zzc("runtime.counter", new zzai(Double.valueOf(0.0d)));
    }

    public final void zza(String str, Callable<? extends zzal> callable) {
        this.zzd.zza(str, callable);
    }
}
