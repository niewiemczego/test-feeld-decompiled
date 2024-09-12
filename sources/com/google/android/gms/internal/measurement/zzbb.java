package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzbb {
    private Map<String, zzay> zza = new HashMap();
    private zzbq zzb = new zzbq();

    public final zzaq zza(zzh zzh, zzaq zzaq) {
        zzay zzay;
        zzg.zza(zzh);
        if (!(zzaq instanceof zzat)) {
            return zzaq;
        }
        zzat zzat = (zzat) zzaq;
        ArrayList<zzaq> zzb2 = zzat.zzb();
        String zza2 = zzat.zza();
        if (this.zza.containsKey(zza2)) {
            zzay = this.zza.get(zza2);
        } else {
            zzay = this.zzb;
        }
        return zzay.zza(zza2, zzh, zzb2);
    }

    public zzbb() {
        zza(new zzaw());
        zza(new zzba());
        zza(new zzbc());
        zza(new zzbg());
        zza(new zzbi());
        zza(new zzbo());
        zza(new zzbt());
    }

    private final void zza(zzay zzay) {
        for (zzbv zzbv : zzay.zza) {
            this.zza.put(zzbv.toString(), zzay);
        }
    }
}
