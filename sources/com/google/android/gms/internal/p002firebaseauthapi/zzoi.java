package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakk;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zzoi<PrimitiveT, KeyProtoT extends zzakk> {
    private final Class<PrimitiveT> zza;

    /* access modifiers changed from: package-private */
    public final Class<PrimitiveT> zza() {
        return this.zza;
    }

    public abstract PrimitiveT zza(KeyProtoT keyprotot) throws GeneralSecurityException;

    public zzoi(Class<PrimitiveT> cls) {
        this.zza = cls;
    }
}
