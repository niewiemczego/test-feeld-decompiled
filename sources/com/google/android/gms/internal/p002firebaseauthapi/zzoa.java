package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzci;
import com.google.android.gms.internal.p002firebaseauthapi.zzow;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoa  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zzoa<ParametersT extends zzci, SerializationT extends zzow> {
    private final Class<ParametersT> zza;
    private final Class<SerializationT> zzb;

    public static <ParametersT extends zzci, SerializationT extends zzow> zzoa<ParametersT, SerializationT> zza(zzoc<ParametersT, SerializationT> zzoc, Class<ParametersT> cls, Class<SerializationT> cls2) {
        return new zzod(cls, cls2, zzoc);
    }

    public abstract SerializationT zza(ParametersT parameterst) throws GeneralSecurityException;

    public final Class<ParametersT> zza() {
        return this.zza;
    }

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zzoa(Class<ParametersT> cls, Class<SerializationT> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }
}
