package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzao  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
class zzao<E> extends zzan<E> {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    public zzao<E> zza(E e) {
        zzz.zza(e);
        int i = this.zzb + 1;
        Object[] objArr = this.zza;
        if (objArr.length < i) {
            this.zza = Arrays.copyOf(objArr, zza(objArr.length, i));
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i2 = this.zzb;
        this.zzb = i2 + 1;
        objArr2[i2] = e;
        return this;
    }

    zzao(int i) {
        zzaj.zza(4, "initialCapacity");
    }
}
