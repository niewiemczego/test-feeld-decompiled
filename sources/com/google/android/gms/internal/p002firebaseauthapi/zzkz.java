package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzkz {
    private static final byte[] zza = new byte[0];
    private final zzla zzb;
    private final BigInteger zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private final byte[] zzf;
    private BigInteger zzg = BigInteger.ZERO;

    public static zzkz zza(byte[] bArr, zzli zzli, zzlg zzlg, zzld zzld, zzla zzla, byte[] bArr2) throws GeneralSecurityException {
        byte[] zza2 = zzlg.zza(bArr, zzli);
        byte[] bArr3 = zzlq.zza;
        byte[] zza3 = zzlq.zza(zzlg.zza(), zzld.zzb(), zzla.zzc());
        byte[] bArr4 = zzlq.zzl;
        byte[] bArr5 = zza;
        byte[] zza4 = zzwi.zza(bArr3, zzld.zza(bArr4, bArr5, "psk_id_hash", zza3), zzld.zza(zzlq.zzl, bArr2, "info_hash", zza3));
        zzld zzld2 = zzld;
        byte[] zza5 = zzld.zza(zza2, bArr5, "secret", zza3);
        byte[] bArr6 = zza4;
        byte[] bArr7 = zza3;
        byte[] zza6 = zzld2.zza(zza5, bArr6, "key", bArr7, zzla.zza());
        byte[] zza7 = zzld2.zza(zza5, bArr6, "base_nonce", bArr7, zzla.zzb());
        zzla.zzb();
        return new zzkz(bArr, zza6, zza7, BigInteger.ONE.shiftLeft(96).subtract(BigInteger.ONE), zzla);
    }

    private zzkz(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, zzla zzla) {
        this.zzf = bArr;
        this.zzd = bArr2;
        this.zze = bArr3;
        this.zzc = bigInteger;
        this.zzb = zzla;
    }

    private final synchronized byte[] zza() throws GeneralSecurityException {
        byte[] zza2;
        zza2 = zzwi.zza(this.zze, zzmb.zza(this.zzg, this.zzb.zzb()));
        if (this.zzg.compareTo(this.zzc) < 0) {
            this.zzg = this.zzg.add(BigInteger.ONE);
        } else {
            throw new GeneralSecurityException("message limit reached");
        }
        return zza2;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.zzb.zza(this.zzd, zza(), bArr, bArr2);
    }
}
