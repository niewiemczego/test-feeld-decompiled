package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzbg extends zzay {
    public final zzaq zza(String str, zzh zzh, List<zzaq> list) {
        int i = zzbj.zza[zzg.zza(str).ordinal()];
        if (i == 1) {
            zzg.zza(zzbv.AND, 2, list);
            zzaq zza = zzh.zza(list.get(0));
            if (!zza.zzd().booleanValue()) {
                return zza;
            }
            return zzh.zza(list.get(1));
        } else if (i == 2) {
            zzg.zza(zzbv.NOT, 1, list);
            return new zzag(Boolean.valueOf(!zzh.zza(list.get(0)).zzd().booleanValue()));
        } else if (i != 3) {
            return super.zza(str);
        } else {
            zzg.zza(zzbv.OR, 2, list);
            zzaq zza2 = zzh.zza(list.get(0));
            if (zza2.zzd().booleanValue()) {
                return zza2;
            }
            return zzh.zza(list.get(1));
        }
    }

    protected zzbg() {
        this.zza.add(zzbv.AND);
        this.zza.add(zzbv.NOT);
        this.zza.add(zzbv.OR);
    }
}
