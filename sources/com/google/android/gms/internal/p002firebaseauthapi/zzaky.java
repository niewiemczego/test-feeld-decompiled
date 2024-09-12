package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaky  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaky {
    private static final zzaky zza = new zzaky();
    private final zzalf zzb = new zzajy();
    private final ConcurrentMap<Class<?>, zzalc<?>> zzc = new ConcurrentHashMap();

    public static zzaky zza() {
        return zza;
    }

    public final <T> zzalc<T> zza(Class<T> cls) {
        zzajc.zza(cls, "messageType");
        zzalc<T> zzalc = (zzalc) this.zzc.get(cls);
        if (zzalc != null) {
            return zzalc;
        }
        zzalc<T> zza2 = this.zzb.zza(cls);
        zzajc.zza(cls, "messageType");
        zzajc.zza(zza2, "schema");
        zzalc<T> putIfAbsent = this.zzc.putIfAbsent(cls, zza2);
        return putIfAbsent != null ? putIfAbsent : zza2;
    }

    public final <T> zzalc<T> zza(T t) {
        return zza(t.getClass());
    }

    private zzaky() {
    }
}
