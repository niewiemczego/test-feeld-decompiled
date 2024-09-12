package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzqq {
    private static final String zza = "type.googleapis.com/google.crypto.tink.HmacKey";
    @Deprecated
    private static final zzvv zzb;
    @Deprecated
    private static final zzvv zzc;
    @Deprecated
    private static final zzvv zzd;

    static {
        zzvv zzb2 = zzvv.zzb();
        zzb = zzb2;
        zzc = zzb2;
        zzd = zzb2;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzqr.zzc();
        zzqa.zzc();
        zzqe.zza(true);
        if (!zzic.zzb()) {
            zzpm.zza(true);
        }
    }
}
