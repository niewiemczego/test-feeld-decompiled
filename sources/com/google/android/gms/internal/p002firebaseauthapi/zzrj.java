package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzrj implements zzcf {
    private static final byte[] zza = {0};
    private final zzcf zzb;
    private final zzvt zzc;
    private final byte[] zzd;

    public static zzcf zza(zznc zznc) throws GeneralSecurityException {
        byte[] bArr;
        zzot zza2 = zznc.zza(zzbr.zza());
        zzcf zzcf = (zzcf) zzox.zza().zza((zzux) ((zzaja) zzux.zza().zza(zza2.zzf()).zza(zza2.zzd()).zza(zza2.zza()).zzf()), zzcf.class);
        zzvt zzc2 = zza2.zzc();
        int i = zzrm.zza[zzc2.ordinal()];
        if (i == 1) {
            bArr = new byte[0];
        } else if (i == 2 || i == 3) {
            bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zznc.zza().intValue()).array();
        } else if (i == 4) {
            bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zznc.zza().intValue()).array();
        } else {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return new zzrj(zzcf, zzc2, bArr);
    }

    private zzrj(zzcf zzcf, zzvt zzvt, byte[] bArr) {
        this.zzb = zzcf;
        this.zzc = zzvt;
        this.zzd = bArr;
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length >= 10) {
            if (this.zzc.equals(zzvt.LEGACY)) {
                bArr2 = zzwi.zza(bArr2, zza);
            }
            byte[] bArr3 = new byte[0];
            if (!this.zzc.equals(zzvt.RAW)) {
                byte[] copyOf = Arrays.copyOf(bArr, 5);
                bArr = Arrays.copyOfRange(bArr, 5, bArr.length);
                bArr3 = copyOf;
            }
            if (Arrays.equals(this.zzd, bArr3)) {
                this.zzb.zza(bArr, bArr2);
                return;
            }
            throw new GeneralSecurityException("wrong prefix");
        }
        throw new GeneralSecurityException("tag too short");
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        if (this.zzc.equals(zzvt.LEGACY)) {
            bArr = zzwi.zza(bArr, zza);
        }
        return zzwi.zza(this.zzd, this.zzb.zza(bArr));
    }
}
