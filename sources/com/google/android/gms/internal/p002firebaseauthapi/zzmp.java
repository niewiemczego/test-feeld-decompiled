package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzmn;
import java.security.GeneralSecurityException;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzmp implements zzmn.zza {
    private final /* synthetic */ zznb zza;

    public final <Q> zzbt<Q> zza(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzml(this.zza, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    public final zzbt<?> zza() {
        zznb zznb = this.zza;
        return new zzml(zznb, zznb.zze());
    }

    public final Class<?> zzb() {
        return this.zza.getClass();
    }

    public final Set<Class<?>> zzc() {
        return this.zza.zzg();
    }

    zzmp(zznb zznb) {
        this.zza = zznb;
    }
}
