package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzbv {
    @Nullable
    private final zzvd zza = null;
    @Nullable
    private final zzci zzb;

    public static zzbv zza(zzci zzci) throws GeneralSecurityException {
        return new zzbv(zzci);
    }

    /* access modifiers changed from: package-private */
    public final zzvd zza() throws GeneralSecurityException {
        zzci zzci = this.zzb;
        if (zzci instanceof zzne) {
            return ((zzne) zzci).zzb().zza();
        }
        return ((zzos) zznv.zza().zza(this.zzb, zzos.class)).zza();
    }

    private zzbv(zzci zzci) {
        this.zzb = zzci;
    }
}
