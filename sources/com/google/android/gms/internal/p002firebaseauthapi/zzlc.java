package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzlc implements zzbp {
    private static final byte[] zza = new byte[0];
    private final zzli zzb;
    private final zzlg zzc;
    private final zzld zzd;
    private final zzla zze;
    private final int zzf;
    private final byte[] zzg;

    static zzlc zza(zzut zzut) throws GeneralSecurityException {
        int i;
        zzli zzli;
        if (!zzut.zzf()) {
            throw new IllegalArgumentException("HpkePrivateKey is missing public_key field.");
        } else if (!zzut.zzd().zzg()) {
            throw new IllegalArgumentException("HpkePrivateKey.public_key is missing params field.");
        } else if (!zzut.zze().zze()) {
            zzus zzb2 = zzut.zzd().zzb();
            zzlg zzc2 = zzlh.zzc(zzb2);
            zzld zzb3 = zzlh.zzb(zzb2);
            zzla zza2 = zzlh.zza(zzb2);
            zzum zzc3 = zzb2.zzc();
            int i2 = zzlb.zza[zzc3.ordinal()];
            if (i2 == 1) {
                i = 32;
            } else if (i2 == 2) {
                i = 65;
            } else if (i2 == 3) {
                i = 97;
            } else if (i2 == 4) {
                i = 133;
            } else {
                throw new IllegalArgumentException("Unable to determine KEM-encoding length for " + zzc3.name());
            }
            int i3 = zzlf.zza[zzut.zzd().zzb().zzc().ordinal()];
            if (i3 == 1) {
                zzli = zzlw.zza(zzut.zze().zzg());
            } else if (i3 == 2 || i3 == 3 || i3 == 4) {
                zzli = zzlu.zza(zzut.zze().zzg(), zzut.zzd().zzf().zzg(), zzlq.zzc(zzut.zzd().zzb().zzc()));
            } else {
                throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
            }
            return new zzlc(zzli, zzc2, zzb3, zza2, i, zzxr.zza(new byte[0]));
        } else {
            throw new IllegalArgumentException("HpkePrivateKey.private_key is empty.");
        }
    }

    private zzlc(zzli zzli, zzlg zzlg, zzld zzld, zzla zzla, int i, zzxr zzxr) {
        this.zzb = zzli;
        this.zzc = zzlg;
        this.zzd = zzld;
        this.zze = zzla;
        this.zzf = i;
        this.zzg = zzxr.zzb();
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzg;
        if (bArr3.length == 0) {
            return zzb(bArr, bArr2);
        }
        if (zzpg.zza(bArr3, bArr)) {
            return zzb(Arrays.copyOfRange(bArr, this.zzg.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
    }

    private final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzf;
        if (length >= i) {
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] bArr3 = bArr2;
            byte[] copyOf = Arrays.copyOf(bArr, i);
            return zzkz.zza(copyOf, this.zzb, this.zzc, this.zzd, this.zze, bArr3).zza(Arrays.copyOfRange(bArr, this.zzf, bArr.length), zza);
        }
        throw new GeneralSecurityException("Ciphertext is too short.");
    }
}
