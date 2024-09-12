package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zznc extends zzbu {
    private final zzot zza;

    public final zzot zza(@Nullable zzct zzct) throws GeneralSecurityException {
        zza(this.zza, zzct);
        return this.zza;
    }

    @Nullable
    public final Integer zza() {
        return this.zza.zze();
    }

    public zznc(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        zza(zzot, zzct);
        this.zza = zzot;
    }

    private static void zza(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        int i = zznf.zza[zzot.zza().ordinal()];
        if (i == 1 || i == 2) {
            zzct.zza(zzct);
        }
    }
}
