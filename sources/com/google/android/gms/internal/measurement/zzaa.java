package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzaa {
    private final TreeMap<Integer, zzar> zza = new TreeMap<>();
    private final TreeMap<Integer, zzar> zzb = new TreeMap<>();

    private static int zza(zzh zzh, zzar zzar, zzaq zzaq) {
        zzaq zza2 = zzar.zza(zzh, (List<zzaq>) Collections.singletonList(zzaq));
        if (zza2 instanceof zzai) {
            return zzg.zzb(zza2.zze().doubleValue());
        }
        return -1;
    }

    public final void zza(String str, int i, zzar zzar, String str2) {
        TreeMap<Integer, zzar> treeMap;
        if ("create".equals(str2)) {
            treeMap = this.zzb;
        } else if ("edit".equals(str2)) {
            treeMap = this.zza;
        } else {
            throw new IllegalStateException("Unknown callback type: " + str2);
        }
        if (treeMap.containsKey(Integer.valueOf(i))) {
            i = treeMap.lastKey().intValue() + 1;
        }
        treeMap.put(Integer.valueOf(i), zzar);
    }

    public final void zza(zzh zzh, zzac zzac) {
        zzn zzn = new zzn(zzac);
        for (Integer num : this.zza.keySet()) {
            zzad zzad = (zzad) zzac.zzb().clone();
            int zza2 = zza(zzh, this.zza.get(num), zzn);
            if (zza2 == 2 || zza2 == -1) {
                zzac.zzb(zzad);
            }
        }
        for (Integer num2 : this.zzb.keySet()) {
            zza(zzh, this.zzb.get(num2), zzn);
        }
    }
}
