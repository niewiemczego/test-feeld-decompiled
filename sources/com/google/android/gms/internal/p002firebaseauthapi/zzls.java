package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzls  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzls implements zzlg {
    private final zzwq zza;
    private final zzkx zzb;

    static zzls zza(zzwq zzwq) throws GeneralSecurityException {
        int i = zzlr.zza[zzwq.ordinal()];
        if (i == 1) {
            return new zzls(new zzkx("HmacSha256"), zzwq.NIST_P256);
        }
        if (i == 2) {
            return new zzls(new zzkx("HmacSha384"), zzwq.NIST_P384);
        }
        if (i == 3) {
            return new zzls(new zzkx("HmacSha512"), zzwq.NIST_P521);
        }
        throw new GeneralSecurityException("invalid curve type: " + String.valueOf(zzwq));
    }

    private zzls(zzkx zzkx, zzwq zzwq) {
        this.zzb = zzkx;
        this.zza = zzwq;
    }

    public final byte[] zza(byte[] bArr, zzli zzli) throws GeneralSecurityException {
        byte[] zza2 = zzwn.zza(zzwn.zza(this.zza, zzli.zza().zzb()), zzwn.zza(this.zza, zzwp.UNCOMPRESSED, bArr));
        byte[] zza3 = zzwi.zza(bArr, zzli.zzb().zzb());
        byte[] zza4 = zzlq.zza(zza());
        zzkx zzkx = this.zzb;
        return zzkx.zza((byte[]) null, zza2, "eae_prk", zza3, "shared_secret", zza4, zzkx.zza());
    }

    public final byte[] zza() throws GeneralSecurityException {
        int i = zzlr.zza[this.zza.ordinal()];
        if (i == 1) {
            return zzlq.zzc;
        }
        if (i == 2) {
            return zzlq.zzd;
        }
        if (i == 3) {
            return zzlq.zze;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
