package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzk extends zzal {
    private final zzac zzk;

    public final zzaq zza(zzh zzh, List<zzaq> list) {
        Map map;
        zzg.zza(this.zza, 3, list);
        String zzf = zzh.zza(list.get(0)).zzf();
        long zza = (long) zzg.zza(zzh.zza(list.get(1)).zze().doubleValue());
        zzaq zza2 = zzh.zza(list.get(2));
        if (zza2 instanceof zzap) {
            map = zzg.zza((zzap) zza2);
        } else {
            map = new HashMap();
        }
        this.zzk.zza(zzf, zza, map);
        return zzaq.zzc;
    }

    public zzk(zzac zzac) {
        super("internal.eventLogger");
        this.zzk = zzac;
    }
}
