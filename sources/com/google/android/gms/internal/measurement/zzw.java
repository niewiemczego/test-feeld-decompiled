package com.google.android.gms.internal.measurement;

import io.sentry.protocol.SentryThread;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzw extends zzal {
    private zzaa zzk;

    public final zzaq zza(zzh zzh, List<zzaq> list) {
        zzg.zza(this.zza, 3, list);
        String zzf = zzh.zza(list.get(0)).zzf();
        zzaq zza = zzh.zza(list.get(1));
        if (zza instanceof zzar) {
            zzaq zza2 = zzh.zza(list.get(2));
            if (zza2 instanceof zzap) {
                zzap zzap = (zzap) zza2;
                if (zzap.zzc("type")) {
                    String zzf2 = zzap.zza("type").zzf();
                    int i = 1000;
                    if (zzap.zzc(SentryThread.JsonKeys.PRIORITY)) {
                        i = zzg.zzb(zzap.zza(SentryThread.JsonKeys.PRIORITY).zze().doubleValue());
                    }
                    this.zzk.zza(zzf, i, (zzar) zza, zzf2);
                    return zzaq.zzc;
                }
                throw new IllegalArgumentException("Undefined rule type");
            }
            throw new IllegalArgumentException("Invalid callback params");
        }
        throw new IllegalArgumentException("Invalid callback type");
    }

    public zzw(zzaa zzaa) {
        super("internal.registerCallback");
        this.zzk = zzaa;
    }
}
