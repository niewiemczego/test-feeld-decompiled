package com.google.android.gms.internal.auth;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzge {
    private static final zzge zza = new zzge();
    private final zzgi zzb = new zzfo();
    private final ConcurrentMap zzc = new ConcurrentHashMap();

    private zzge() {
    }

    public static zzge zza() {
        return zza;
    }

    public final zzgh zzb(Class cls) {
        zzez.zzf(cls, "messageType");
        zzgh zzgh = (zzgh) this.zzc.get(cls);
        if (zzgh == null) {
            zzgh = this.zzb.zza(cls);
            zzez.zzf(cls, "messageType");
            zzez.zzf(zzgh, "schema");
            zzgh zzgh2 = (zzgh) this.zzc.putIfAbsent(cls, zzgh);
            return zzgh2 == null ? zzgh : zzgh2;
        }
    }
}
