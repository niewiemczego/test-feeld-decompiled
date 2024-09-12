package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzar extends zzal implements zzak {
    private final List<String> zzk;
    private final List<zzaq> zzl;
    private zzh zzm;

    public final zzaq zzc() {
        return new zzar(this);
    }

    public final zzaq zza(zzh zzh, List<zzaq> list) {
        zzh zza = this.zzm.zza();
        for (int i = 0; i < this.zzk.size(); i++) {
            if (i < list.size()) {
                zza.zza(this.zzk.get(i), zzh.zza(list.get(i)));
            } else {
                zza.zza(this.zzk.get(i), zzc);
            }
        }
        for (zzaq next : this.zzl) {
            zzaq zza2 = zza.zza(next);
            if (zza2 instanceof zzat) {
                zza2 = zza.zza(next);
            }
            if (zza2 instanceof zzaj) {
                return ((zzaj) zza2).zza();
            }
        }
        return zzaq.zzc;
    }

    private zzar(zzar zzar) {
        super(zzar.zza);
        ArrayList arrayList = new ArrayList(zzar.zzk.size());
        this.zzk = arrayList;
        arrayList.addAll(zzar.zzk);
        ArrayList arrayList2 = new ArrayList(zzar.zzl.size());
        this.zzl = arrayList2;
        arrayList2.addAll(zzar.zzl);
        this.zzm = zzar.zzm;
    }

    public zzar(String str, List<zzaq> list, List<zzaq> list2, zzh zzh) {
        super(str);
        this.zzk = new ArrayList();
        this.zzm = zzh;
        if (!list.isEmpty()) {
            for (zzaq zzf : list) {
                this.zzk.add(zzf.zzf());
            }
        }
        this.zzl = new ArrayList(list2);
    }
}
