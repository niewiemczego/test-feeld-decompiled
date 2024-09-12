package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Set;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzbt {
    private static final zzbp zza = new zzbr();
    private static final zzbo zzb = new zzbs();

    public static zzbl zza(Set set) {
        zzbl zzbl = new zzbl(zza, (zzbk) null);
        zzbl.zza(zzb);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzbl.zzg((zzba) it.next());
        }
        return zzbl;
    }
}
