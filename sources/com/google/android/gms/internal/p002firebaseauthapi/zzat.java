package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzat  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzat<K, V> {
    zzaw zza;
    private Object[] zzb;
    private int zzc;
    private boolean zzd;

    public final zzat<K, V> zza(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        if (iterable instanceof Collection) {
            zza(this.zzc + ((Collection) iterable).size());
        }
        for (Map.Entry entry : iterable) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            zza(this.zzc + 1);
            zzaj.zza(key, value);
            Object[] objArr = this.zzb;
            int i = this.zzc;
            objArr[i * 2] = key;
            objArr[(i * 2) + 1] = value;
            this.zzc = i + 1;
        }
        return this;
    }

    public final zzau<K, V> zza() {
        zzaw zzaw = this.zza;
        if (zzaw == null) {
            int i = this.zzc;
            Object[] objArr = this.zzb;
            this.zzd = true;
            zzax zza2 = zzax.zza(i, objArr, this);
            zzaw zzaw2 = this.zza;
            if (zzaw2 == null) {
                return zza2;
            }
            throw zzaw2.zza();
        }
        throw zzaw.zza();
    }

    public zzat() {
        this(4);
    }

    zzat(int i) {
        this.zzb = new Object[(i * 2)];
        this.zzc = 0;
        this.zzd = false;
    }

    private final void zza(int i) {
        int i2 = i << 1;
        Object[] objArr = this.zzb;
        if (i2 > objArr.length) {
            this.zzb = Arrays.copyOf(objArr, zzan.zza(objArr.length, i2));
            this.zzd = false;
        }
    }
}
