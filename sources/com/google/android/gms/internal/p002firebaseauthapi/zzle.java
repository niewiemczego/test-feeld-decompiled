package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzle  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzle implements zzbs {
    private static final byte[] zza = new byte[0];
    private final byte[] zzb;
    private final zzlg zzc;
    private final zzld zzd;
    private final zzla zze;
    private final byte[] zzf;

    static zzle zza(zzuw zzuw) throws GeneralSecurityException {
        if (!zzuw.zzf().zze()) {
            zzus zzb2 = zzuw.zzb();
            return new zzle(zzxr.zza(zzuw.zzf().zzg()), zzlh.zzc(zzb2), zzlh.zzb(zzb2), zzlh.zza(zzb2), zzxr.zza(new byte[0]));
        }
        throw new IllegalArgumentException("HpkePublicKey.public_key is empty.");
    }

    private zzle(zzxr zzxr, zzlg zzlg, zzld zzld, zzla zzla, zzxr zzxr2) {
        this.zzb = zzxr.zzb();
        this.zzc = zzlg;
        this.zzd = zzld;
        this.zze = zzla;
        this.zzf = zzxr2.zzb();
    }
}
