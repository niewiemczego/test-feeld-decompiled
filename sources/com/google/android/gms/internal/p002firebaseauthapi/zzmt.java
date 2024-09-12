package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzow;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zzmt<SerializationT extends zzow> {
    private final zzxr zza;
    private final Class<SerializationT> zzb;

    public static <SerializationT extends zzow> zzmt<SerializationT> zza(zzmv<SerializationT> zzmv, zzxr zzxr, Class<SerializationT> cls) {
        return new zzms(zzxr, cls, zzmv);
    }

    public abstract zzbu zza(SerializationT serializationt, @Nullable zzct zzct) throws GeneralSecurityException;

    public final zzxr zza() {
        return this.zza;
    }

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zzmt(zzxr zzxr, Class<SerializationT> cls) {
        this.zza = zzxr;
        this.zzb = cls;
    }
}
