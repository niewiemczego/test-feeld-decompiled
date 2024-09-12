package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final /* synthetic */ class zzan {
    public static zzaq zza(zzak zzak, zzaq zzaq, zzh zzh, List<zzaq> list) {
        if (zzak.zzc(zzaq.zzf())) {
            zzaq zza = zzak.zza(zzaq.zzf());
            if (zza instanceof zzal) {
                return ((zzal) zza).zza(zzh, list);
            }
            throw new IllegalArgumentException(String.format("%s is not a function", new Object[]{zzaq.zzf()}));
        } else if ("hasOwnProperty".equals(zzaq.zzf())) {
            zzg.zza("hasOwnProperty", 1, list);
            if (zzak.zzc(zzh.zza(list.get(0)).zzf())) {
                return zzaq.zzh;
            }
            return zzaq.zzi;
        } else {
            throw new IllegalArgumentException(String.format("Object has no function %s", new Object[]{zzaq.zzf()}));
        }
    }

    public static Iterator<zzaq> zza(Map<String, zzaq> map) {
        return new zzam(map.keySet().iterator());
    }
}
