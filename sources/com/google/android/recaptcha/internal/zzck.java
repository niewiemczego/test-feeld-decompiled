package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzck {
    private final Map zza;
    private final Set zzb = new LinkedHashSet();
    private final Map zzc;

    public zzck() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zza = linkedHashMap;
        this.zzc = linkedHashMap;
    }

    private final List zzi(List list) {
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zza((zzpq) it.next()));
        }
        return arrayList;
    }

    public final Object zza(zzpq zzpq) throws zzae {
        int zzO = zzpq.zzO();
        int i = zzO - 1;
        if (zzO != 0) {
            switch (i) {
                case 0:
                    return this.zza.get(Integer.valueOf(zzpq.zzi()));
                case 1:
                    return Boolean.valueOf(zzpq.zzM());
                case 2:
                    byte[] zzo = zzpq.zzI().zzo();
                    if (zzo.length == 1) {
                        return Byte.valueOf(zzo[0]);
                    }
                    throw new zzae(4, 6, (Throwable) null);
                case 3:
                    String zzK = zzpq.zzK();
                    if (zzK.length() == 1) {
                        return Character.valueOf(zzK.charAt(0));
                    }
                    throw new zzae(4, 6, (Throwable) null);
                case 4:
                    int zzj = zzpq.zzj();
                    if (zzj >= -32768 && zzj <= 32767) {
                        return Short.valueOf((short) zzj);
                    }
                    throw new zzae(4, 6, (Throwable) null);
                case 5:
                    return Integer.valueOf(zzpq.zzk());
                case 6:
                case 8:
                    throw new zzae(4, 6, (Throwable) null);
                case 7:
                    return Long.valueOf(zzpq.zzH());
                case 9:
                    return Float.valueOf(zzpq.zzg());
                case 10:
                    return Double.valueOf(zzpq.zzf());
                case 11:
                    return zzpq.zzL();
                case 12:
                    return null;
                default:
                    throw new zzae(4, 5, (Throwable) null);
            }
        } else {
            throw null;
        }
    }

    public final Object zzb(int i) {
        return this.zza.remove(Integer.valueOf(i));
    }

    public final Map zzc() {
        return this.zzc;
    }

    public final void zzd() {
        this.zza.clear();
    }

    public final void zze(int i, Object obj) {
        zzf(173, obj);
        this.zzb.add(173);
    }

    public final void zzf(int i, Object obj) {
        this.zza.put(Integer.valueOf(i), obj);
    }

    public final Class[] zzg(List list) {
        List<Object> zzi = zzi(list);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(zzi, 10));
        for (Object zza2 : zzi) {
            arrayList.add(zzci.zza(zza2));
        }
        return (Class[]) arrayList.toArray(new Class[0]);
    }

    public final Object[] zzh(List list) {
        return zzi(list).toArray(new Object[0]);
    }
}
