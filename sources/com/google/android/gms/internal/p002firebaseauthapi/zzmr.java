package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzmn;
import java.security.GeneralSecurityException;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzmr implements zzmn.zza {
    private final /* synthetic */ zzoq zza;
    private final /* synthetic */ zznb zzb;

    public final <Q> zzbt<Q> zza(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzor(this.zza, this.zzb, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    public final zzbt<?> zza() {
        zzoq zzoq = this.zza;
        return new zzor(zzoq, this.zzb, zzoq.zze());
    }

    public final Class<?> zzb() {
        return this.zza.getClass();
    }

    public final Set<Class<?>> zzc() {
        return this.zza.zzg();
    }

    zzmr(zzoq zzoq, zznb zznb) {
        this.zza = zzoq;
        this.zzb = zznb;
    }
}
