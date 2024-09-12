package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzpp;
import com.google.android.gms.internal.p002firebaseauthapi.zzqm;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzxo implements zzcf {
    private static final byte[] zza = {0};
    private final zzrv zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    public static zzcf zza(zzpi zzpi) throws GeneralSecurityException {
        return new zzxo(zzpi);
    }

    public static zzcf zza(zzqb zzqb) throws GeneralSecurityException {
        return new zzxo(zzqb);
    }

    private zzxo(zzpi zzpi) throws GeneralSecurityException {
        this.zzb = new zzxj(zzpi.zze().zza(zzbr.zza()));
        this.zzc = ((zzpp) zzpi.zzc()).zzb();
        this.zzd = zzpi.zzd().zzb();
        if (((zzpp) zzpi.zzc()).zze().equals(zzpp.zzb.zzc)) {
            byte[] bArr = zza;
            this.zze = Arrays.copyOf(bArr, bArr.length);
            return;
        }
        this.zze = new byte[0];
    }

    private zzxo(zzqb zzqb) throws GeneralSecurityException {
        this.zzb = new zzxm("HMAC" + String.valueOf(((zzqm) zzqb.zzc()).zze()), new SecretKeySpec(zzqb.zze().zza(zzbr.zza()), "HMAC"));
        this.zzc = ((zzqm) zzqb.zzc()).zzb();
        this.zzd = zzqb.zzd().zzb();
        if (((zzqm) zzqb.zzc()).zzf().equals(zzqm.zzc.zzc)) {
            byte[] bArr = zza;
            this.zze = Arrays.copyOf(bArr, bArr.length);
            return;
        }
        this.zze = new byte[0];
    }

    public zzxo(zzrv zzrv, int i) throws GeneralSecurityException {
        this.zzb = zzrv;
        this.zzc = i;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        if (i >= 10) {
            zzrv.zza(new byte[0], i);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!MessageDigest.isEqual(zza(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = this.zze;
        if (bArr2.length > 0) {
            return zzwi.zza(this.zzd, this.zzb.zza(zzwi.zza(bArr, bArr2), this.zzc));
        }
        return zzwi.zza(this.zzd, this.zzb.zza(bArr, this.zzc));
    }
}
