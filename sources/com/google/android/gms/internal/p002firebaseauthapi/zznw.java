package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzow;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zznw<SerializationT extends zzow> {
    private final zzxr zza;
    private final Class<SerializationT> zzb;

    public static <SerializationT extends zzow> zznw<SerializationT> zza(zzny<SerializationT> zzny, zzxr zzxr, Class<SerializationT> cls) {
        return new zznz(zzxr, cls, zzny);
    }

    public abstract zzci zza(SerializationT serializationt) throws GeneralSecurityException;

    public final zzxr zza() {
        return this.zza;
    }

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zznw(zzxr zzxr, Class<SerializationT> cls) {
        this.zza = zzxr;
        this.zzb = cls;
    }
}
