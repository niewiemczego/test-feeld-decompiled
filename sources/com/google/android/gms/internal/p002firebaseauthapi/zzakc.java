package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzakc<K, V> {
    static <K, V> int zza(zzakf<K, V> zzakf, K k, V v) {
        return zzais.zza(zzakf.zza, 1, k) + zzais.zza(zzakf.zzc, 2, v);
    }

    static <K, V> void zza(zzaii zzaii, zzakf<K, V> zzakf, K k, V v) throws IOException {
        zzais.zza(zzaii, zzakf.zza, 1, k);
        zzais.zza(zzaii, zzakf.zzc, 2, v);
    }
}
