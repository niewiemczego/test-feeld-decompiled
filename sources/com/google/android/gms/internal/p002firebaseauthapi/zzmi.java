package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.Enum;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzmi<E extends Enum<E>, O> {
    private Map<E, O> zza;
    private Map<O, E> zzb;

    public final zzmi<E, O> zza(E e, O o) {
        this.zza.put(e, o);
        this.zzb.put(o, e);
        return this;
    }

    public final zzmf<E, O> zza() {
        return new zzmf<>(Collections.unmodifiableMap(this.zza), Collections.unmodifiableMap(this.zzb));
    }

    private zzmi() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }
}
