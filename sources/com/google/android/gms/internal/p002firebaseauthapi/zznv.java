package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zznv {
    private static final zznv zza = ((zznv) zzpe.zza(zznu.zza));
    private final AtomicReference<zzoz> zzb = new AtomicReference<>(new zzoy().zza());

    public final <SerializationT extends zzow> zzbu zza(SerializationT serializationt, @Nullable zzct zzct) throws GeneralSecurityException {
        return this.zzb.get().zza(serializationt, zzct);
    }

    public final zzbu zza(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        if (!this.zzb.get().zzb(zzot)) {
            return new zznc(zzot, zzct);
        }
        return zza(zzot, zzct);
    }

    public final <SerializationT extends zzow> zzci zza(SerializationT serializationt) throws GeneralSecurityException {
        return this.zzb.get().zza(serializationt);
    }

    public static zznv zza() {
        return zza;
    }

    public final <KeyT extends zzbu, SerializationT extends zzow> SerializationT zza(KeyT keyt, Class<SerializationT> cls, @Nullable zzct zzct) throws GeneralSecurityException {
        return this.zzb.get().zza(keyt, cls, zzct);
    }

    public final <ParametersT extends zzci, SerializationT extends zzow> SerializationT zza(ParametersT parameterst, Class<SerializationT> cls) throws GeneralSecurityException {
        return this.zzb.get().zza(parameterst, cls);
    }

    public final synchronized <SerializationT extends zzow> void zza(zzmt<SerializationT> zzmt) throws GeneralSecurityException {
        this.zzb.set(new zzoy(this.zzb.get()).zza(zzmt).zza());
    }

    public final synchronized <KeyT extends zzbu, SerializationT extends zzow> void zza(zzmx<KeyT, SerializationT> zzmx) throws GeneralSecurityException {
        this.zzb.set(new zzoy(this.zzb.get()).zza(zzmx).zza());
    }

    public final synchronized <SerializationT extends zzow> void zza(zznw<SerializationT> zznw) throws GeneralSecurityException {
        this.zzb.set(new zzoy(this.zzb.get()).zza(zznw).zza());
    }

    public final synchronized <ParametersT extends zzci, SerializationT extends zzow> void zza(zzoa<ParametersT, SerializationT> zzoa) throws GeneralSecurityException {
        this.zzb.set(new zzoy(this.zzb.get()).zza(zzoa).zza());
    }

    public final <SerializationT extends zzow> boolean zzb(SerializationT serializationt) {
        return this.zzb.get().zzc(serializationt);
    }
}
