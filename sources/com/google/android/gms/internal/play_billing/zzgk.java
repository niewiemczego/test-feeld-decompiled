package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzgk {
    private static final zzgk zza = new zzgk();
    private final zzgn zzb = new zzfu();
    private final ConcurrentMap zzc = new ConcurrentHashMap();

    private zzgk() {
    }

    public static zzgk zza() {
        return zza;
    }

    public final zzgm zzb(Class cls) {
        zzfd.zzc(cls, "messageType");
        zzgm zzgm = (zzgm) this.zzc.get(cls);
        if (zzgm == null) {
            zzgm = this.zzb.zza(cls);
            zzfd.zzc(cls, "messageType");
            zzgm zzgm2 = (zzgm) this.zzc.putIfAbsent(cls, zzgm);
            return zzgm2 == null ? zzgm : zzgm2;
        }
    }
}
