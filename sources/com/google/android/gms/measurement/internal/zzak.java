package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzih;
import java.util.EnumMap;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzak {
    private final EnumMap<zzih.zza, zzaj> zza;

    public final zzaj zza(zzih.zza zza2) {
        zzaj zzaj = this.zza.get(zza2);
        return zzaj == null ? zzaj.UNSET : zzaj;
    }

    public static zzak zza(String str) {
        EnumMap enumMap = new EnumMap(zzih.zza.class);
        if (str.length() >= zzih.zza.values().length) {
            int i = 0;
            if (str.charAt(0) == '1') {
                zzih.zza[] values = zzih.zza.values();
                int length = values.length;
                int i2 = 1;
                while (i < length) {
                    enumMap.put(values[i], zzaj.zza(str.charAt(i2)));
                    i++;
                    i2++;
                }
                return new zzak(enumMap);
            }
        }
        return new zzak();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("1");
        for (zzih.zza zza2 : zzih.zza.values()) {
            zzaj zzaj = this.zza.get(zza2);
            if (zzaj == null) {
                zzaj = zzaj.UNSET;
            }
            sb.append(zzaj.zzj);
        }
        return sb.toString();
    }

    zzak() {
        this.zza = new EnumMap<>(zzih.zza.class);
    }

    private zzak(EnumMap<zzih.zza, zzaj> enumMap) {
        EnumMap<zzih.zza, zzaj> enumMap2 = new EnumMap<>(zzih.zza.class);
        this.zza = enumMap2;
        enumMap2.putAll(enumMap);
    }

    public final void zza(zzih.zza zza2, int i) {
        zzaj zzaj = zzaj.UNSET;
        if (i != -20) {
            if (i == -10) {
                zzaj = zzaj.MANIFEST;
            } else if (i != 0) {
                if (i == 30) {
                    zzaj = zzaj.INITIALIZATION;
                }
            }
            this.zza.put(zza2, zzaj);
        }
        zzaj = zzaj.API;
        this.zza.put(zza2, zzaj);
    }

    public final void zza(zzih.zza zza2, zzaj zzaj) {
        this.zza.put(zza2, zzaj);
    }
}
