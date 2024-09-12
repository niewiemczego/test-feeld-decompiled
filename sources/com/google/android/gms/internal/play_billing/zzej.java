package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzej {
    static final zzej zza = new zzej(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzej zzd;
    private final Map zze;

    zzej() {
        this.zze = new HashMap();
    }

    public final zzev zzb(zzgc zzgc, int i) {
        return (zzev) this.zze.get(new zzei(zzgc, i));
    }

    zzej(boolean z) {
        this.zze = Collections.emptyMap();
    }

    public static zzej zza() {
        Class<zzej> cls = zzej.class;
        zzej zzej = zzd;
        if (zzej != null) {
            return zzej;
        }
        synchronized (cls) {
            zzej zzej2 = zzd;
            if (zzej2 != null) {
                return zzej2;
            }
            zzej zzb2 = zzer.zzb(cls);
            zzd = zzb2;
            return zzb2;
        }
    }
}
