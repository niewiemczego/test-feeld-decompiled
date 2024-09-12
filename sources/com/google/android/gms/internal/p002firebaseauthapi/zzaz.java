package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaz extends zzaq<Map.Entry<K, V>> {
    private final /* synthetic */ zzba zza;

    public final int size() {
        return this.zza.zzd;
    }

    public final boolean zze() {
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzz.zza(i, this.zza.zzd);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(this.zza.zzb[i2]), Objects.requireNonNull(this.zza.zzb[i2 + 1]));
    }

    zzaz(zzba zzba) {
        this.zza = zzba;
    }
}
