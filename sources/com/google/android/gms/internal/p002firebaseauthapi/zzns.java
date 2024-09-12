package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzns  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzns {
    private static zzns zza = new zzns();
    private final AtomicReference<zzol> zzb = new AtomicReference<>(new zzok().zza());

    public static zzns zza() {
        return zza;
    }

    public final <WrapperPrimitiveT> Class<?> zza(Class<WrapperPrimitiveT> cls) throws GeneralSecurityException {
        return this.zzb.get().zza((Class<?>) cls);
    }

    public final <KeyT extends zzbu, PrimitiveT> PrimitiveT zza(KeyT keyt, Class<PrimitiveT> cls) throws GeneralSecurityException {
        return this.zzb.get().zza(keyt, cls);
    }

    public final <InputPrimitiveT, WrapperPrimitiveT> WrapperPrimitiveT zza(zzch<InputPrimitiveT> zzch, Class<WrapperPrimitiveT> cls) throws GeneralSecurityException {
        return this.zzb.get().zza(zzch, cls);
    }

    zzns() {
    }

    public final synchronized <KeyT extends zzbu, PrimitiveT> void zza(zzoe<KeyT, PrimitiveT> zzoe) throws GeneralSecurityException {
        this.zzb.set(zzol.zza(this.zzb.get()).zza(zzoe).zza());
    }

    public final synchronized <InputPrimitiveT, WrapperPrimitiveT> void zza(zzcq<InputPrimitiveT, WrapperPrimitiveT> zzcq) throws GeneralSecurityException {
        this.zzb.set(zzol.zza(this.zzb.get()).zza(zzcq).zza());
    }
}
