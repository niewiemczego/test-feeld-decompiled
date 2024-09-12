package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzu extends zzal {
    private boolean zzk;
    private boolean zzl;
    private final /* synthetic */ zzr zzm;

    public final zzaq zza(zzh zzh, List<zzaq> list) {
        zzg.zzb("log", 1, list);
        if (list.size() == 1) {
            this.zzm.zzk.zza(zzs.INFO, zzh.zza(list.get(0)).zzf(), Collections.emptyList(), this.zzk, this.zzl);
            return zzc;
        }
        zzs zza = zzs.zza(zzg.zzb(zzh.zza(list.get(0)).zze().doubleValue()));
        String zzf = zzh.zza(list.get(1)).zzf();
        if (list.size() == 2) {
            this.zzm.zzk.zza(zza, zzf, Collections.emptyList(), this.zzk, this.zzl);
            return zzc;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 2; i < Math.min(list.size(), 5); i++) {
            arrayList.add(zzh.zza(list.get(i)).zzf());
        }
        this.zzm.zzk.zza(zza, zzf, arrayList, this.zzk, this.zzl);
        return zzc;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzu(zzr zzr, boolean z, boolean z2) {
        super("log");
        this.zzm = zzr;
        this.zzk = z;
        this.zzl = z2;
    }
}
