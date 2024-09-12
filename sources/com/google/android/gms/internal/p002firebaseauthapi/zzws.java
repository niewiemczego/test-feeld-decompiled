package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzws  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzws implements zzbh {
    private final zzxk zza;
    private final zzcf zzb;
    private final int zzc;
    private final byte[] zzd;

    public static zzbh zza(zzdf zzdf) throws GeneralSecurityException {
        return new zzws(new zzwa(zzdf.zze().zza(zzbr.zza()), zzdf.zzc().zzd()), new zzxo(new zzxm("HMAC" + String.valueOf(zzdf.zzc().zzg()), new SecretKeySpec(zzdf.zzf().zza(zzbr.zza()), "HMAC")), zzdf.zzc().zze()), zzdf.zzc().zze(), zzdf.zzd().zzb());
    }

    private zzws(zzxk zzxk, zzcf zzcf, int i, byte[] bArr) {
        this.zza = zzxk;
        this.zzb = zzcf;
        this.zzc = i;
        this.zzd = bArr;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzc;
        byte[] bArr3 = this.zzd;
        if (length < i + bArr3.length) {
            throw new GeneralSecurityException("Decryption failed (ciphertext too short).");
        } else if (zzpg.zza(bArr3, bArr)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, this.zzd.length, bArr.length - this.zzc);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - this.zzc, bArr.length);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
            this.zzb.zza(copyOfRange2, zzwi.zza(bArr2, copyOfRange, copyOf));
            return this.zza.zza(copyOfRange);
        } else {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzb2 = this.zza.zzb(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        return zzwi.zza(this.zzd, zzb2, this.zzb.zza(zzwi.zza(bArr2, zzb2, copyOf)));
    }
}
