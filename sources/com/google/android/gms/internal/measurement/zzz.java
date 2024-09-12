package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzz extends zzal {
    private final zzl zzk;
    private final Map<String, zzal> zzl = new HashMap();

    public final zzaq zza(zzh zzh, List<zzaq> list) {
        zzg.zza("require", 1, list);
        String zzf = zzh.zza(list.get(0)).zzf();
        if (this.zzl.containsKey(zzf)) {
            return this.zzl.get(zzf);
        }
        zzaq zza = this.zzk.zza(zzf);
        if (zza instanceof zzal) {
            this.zzl.put(zzf, (zzal) zza);
        }
        return zza;
    }

    public zzz(zzl zzl2) {
        super("require");
        this.zzk = zzl2;
    }
}
