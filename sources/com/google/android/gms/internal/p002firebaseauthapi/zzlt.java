package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzlt implements zzlg {
    private final zzkx zza;

    zzlt(zzkx zzkx) {
        this.zza = zzkx;
    }

    public final byte[] zza(byte[] bArr, zzli zzli) throws GeneralSecurityException {
        byte[] zza2 = zzxp.zza(zzli.zza().zzb(), bArr);
        byte[] zza3 = zzwi.zza(bArr, zzli.zzb().zzb());
        byte[] zza4 = zzlq.zza(zzlq.zzb);
        zzkx zzkx = this.zza;
        return zzkx.zza((byte[]) null, zza2, "eae_prk", zza3, "shared_secret", zza4, zzkx.zza());
    }

    public final byte[] zza() throws GeneralSecurityException {
        if (Arrays.equals(this.zza.zzb(), zzlq.zzf)) {
            return zzlq.zzb;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
