package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zzkx {
    private static final zzkx zza = new zzkx();
    private final zzle zzb = new zzjx();
    private final ConcurrentMap<Class<?>, zzlb<?>> zzc = new ConcurrentHashMap();

    public static zzkx zza() {
        return zza;
    }

    public final <T> zzlb<T> zza(Class<T> cls) {
        zziz.zza(cls, "messageType");
        zzlb<T> zzlb = (zzlb) this.zzc.get(cls);
        if (zzlb != null) {
            return zzlb;
        }
        zzlb<T> zza2 = this.zzb.zza(cls);
        zziz.zza(cls, "messageType");
        zziz.zza(zza2, "schema");
        zzlb<T> putIfAbsent = this.zzc.putIfAbsent(cls, zza2);
        return putIfAbsent != null ? putIfAbsent : zza2;
    }

    public final <T> zzlb<T> zza(T t) {
        return zza(t.getClass());
    }

    private zzkx() {
    }
}
