package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zzkf implements zzkg {
    public final int zza(int i, Object obj, Object obj2) {
        zzkd zzkd = (zzkd) obj;
        zzkb zzkb = (zzkb) obj2;
        if (zzkd.isEmpty()) {
            return 0;
        }
        Iterator it = zzkd.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    public final zzke<?, ?> zza(Object obj) {
        zzkb zzkb = (zzkb) obj;
        throw new NoSuchMethodError();
    }

    public final Object zza(Object obj, Object obj2) {
        zzkd zzkd = (zzkd) obj;
        zzkd zzkd2 = (zzkd) obj2;
        if (!zzkd2.isEmpty()) {
            if (!zzkd.zzd()) {
                zzkd = zzkd.zzb();
            }
            zzkd.zza(zzkd2);
        }
        return zzkd;
    }

    public final Object zzb(Object obj) {
        return zzkd.zza().zzb();
    }

    public final Object zzc(Object obj) {
        ((zzkd) obj).zzc();
        return obj;
    }

    public final Map<?, ?> zzd(Object obj) {
        return (zzkd) obj;
    }

    public final Map<?, ?> zze(Object obj) {
        return (zzkd) obj;
    }

    zzkf() {
    }

    public final boolean zzf(Object obj) {
        return !((zzkd) obj).zzd();
    }
}
