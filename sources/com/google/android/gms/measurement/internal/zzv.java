package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzix;
import com.google.android.gms.internal.measurement.zzob;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzv {
    private String zza;
    private boolean zzb;
    private zzfi.zzl zzc;
    /* access modifiers changed from: private */
    public BitSet zzd;
    private BitSet zze;
    private Map<Integer, Long> zzf;
    private Map<Integer, List<Long>> zzg;
    private final /* synthetic */ zzt zzh;

    /* access modifiers changed from: package-private */
    public final zzfi.zzc zza(int i) {
        ArrayList arrayList;
        List list;
        zzfi.zzc.zza zzb2 = zzfi.zzc.zzb();
        zzb2.zza(i);
        zzb2.zza(this.zzb);
        zzfi.zzl zzl = this.zzc;
        if (zzl != null) {
            zzb2.zza(zzl);
        }
        zzfi.zzl.zza zzd2 = zzfi.zzl.zze().zzb(zzmz.zza(this.zzd)).zzd(zzmz.zza(this.zze));
        if (this.zzf == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.zzf.size());
            for (Integer intValue : this.zzf.keySet()) {
                int intValue2 = intValue.intValue();
                Long l = this.zzf.get(Integer.valueOf(intValue2));
                if (l != null) {
                    arrayList.add((zzfi.zzd) ((zzix) zzfi.zzd.zzc().zza(intValue2).zza(l.longValue()).zzab()));
                }
            }
        }
        if (arrayList != null) {
            zzd2.zza(arrayList);
        }
        if (this.zzg == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList(this.zzg.size());
            for (Integer next : this.zzg.keySet()) {
                zzfi.zzm.zza zza2 = zzfi.zzm.zzc().zza(next.intValue());
                List list2 = this.zzg.get(next);
                if (list2 != null) {
                    Collections.sort(list2);
                    zza2.zza((Iterable<? extends Long>) list2);
                }
                arrayList2.add((zzfi.zzm) ((zzix) zza2.zzab()));
            }
            list = arrayList2;
        }
        zzd2.zzc(list);
        zzb2.zza(zzd2);
        return (zzfi.zzc) ((zzix) zzb2.zzab());
    }

    private zzv(zzt zzt, String str) {
        this.zzh = zzt;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
    }

    private zzv(zzt zzt, String str, zzfi.zzl zzl, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.zzh = zzt;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new ArrayMap();
        if (map2 != null) {
            for (Integer next : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(next));
                this.zzg.put(next, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zzl;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzac zzac) {
        int zza2 = zzac.zza();
        if (zzac.zzc != null) {
            this.zze.set(zza2, zzac.zzc.booleanValue());
        }
        if (zzac.zzd != null) {
            this.zzd.set(zza2, zzac.zzd.booleanValue());
        }
        if (zzac.zze != null) {
            Long l = this.zzf.get(Integer.valueOf(zza2));
            long longValue = zzac.zze.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.zzf.put(Integer.valueOf(zza2), Long.valueOf(longValue));
            }
        }
        if (zzac.zzf != null) {
            List list = this.zzg.get(Integer.valueOf(zza2));
            if (list == null) {
                list = new ArrayList();
                this.zzg.put(Integer.valueOf(zza2), list);
            }
            if (zzac.zzc()) {
                list.clear();
            }
            if (zzob.zza() && this.zzh.zze().zzf(this.zza, zzbi.zzbg) && zzac.zzb()) {
                list.clear();
            }
            if (!zzob.zza() || !this.zzh.zze().zzf(this.zza, zzbi.zzbg)) {
                list.add(Long.valueOf(zzac.zzf.longValue() / 1000));
                return;
            }
            long longValue2 = zzac.zzf.longValue() / 1000;
            if (!list.contains(Long.valueOf(longValue2))) {
                list.add(Long.valueOf(longValue2));
            }
        }
    }
}
