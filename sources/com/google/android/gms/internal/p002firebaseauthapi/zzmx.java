package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzbu;
import com.google.android.gms.internal.p002firebaseauthapi.zzow;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zzmx<KeyT extends zzbu, SerializationT extends zzow> {
    private final Class<KeyT> zza;
    private final Class<SerializationT> zzb;

    public static <KeyT extends zzbu, SerializationT extends zzow> zzmx<KeyT, SerializationT> zza(zzmz<KeyT, SerializationT> zzmz, Class<KeyT> cls, Class<SerializationT> cls2) {
        return new zzmw(cls, cls2, zzmz);
    }

    public abstract SerializationT zza(KeyT keyt, @Nullable zzct zzct) throws GeneralSecurityException;

    public final Class<KeyT> zza() {
        return this.zza;
    }

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zzmx(Class<KeyT> cls, Class<SerializationT> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }
}
