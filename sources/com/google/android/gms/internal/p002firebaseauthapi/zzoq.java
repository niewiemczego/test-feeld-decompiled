package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakk;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zzoq<KeyProtoT extends zzakk, PublicKeyProtoT extends zzakk> extends zznb<KeyProtoT> {
    private final Class<PublicKeyProtoT> zza;

    @SafeVarargs
    protected zzoq(Class<KeyProtoT> cls, Class<PublicKeyProtoT> cls2, zzoi<?, KeyProtoT>... zzoiArr) {
        super(cls, zzoiArr);
        this.zza = cls2;
    }

    public abstract PublicKeyProtoT zza(KeyProtoT keyprotot) throws GeneralSecurityException;
}
