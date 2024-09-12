package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzwh implements zzbh {
    private final zzhr zza;
    private final byte[] zzb;

    public static zzbh zza(zzfl zzfl) throws GeneralSecurityException {
        return new zzwh(zzfl.zzd().zza(zzbr.zza()), zzfl.zzc().zzb());
    }

    private zzwh(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        this.zza = new zzhr(bArr);
        this.zzb = bArr2;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return zzc(bArr, bArr2);
        }
        if (zzpg.zza(bArr3, bArr)) {
            return zzc(Arrays.copyOfRange(bArr, this.zzb.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 12 + 16);
        byte[] zza2 = zzov.zza(12);
        allocate.put(zza2);
        this.zza.zza(allocate, zza2, bArr, bArr2);
        byte[] array = allocate.array();
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return array;
        }
        return zzwi.zza(bArr3, array);
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length >= 28) {
            byte[] copyOf = Arrays.copyOf(bArr, 12);
            return this.zza.zza(ByteBuffer.wrap(bArr, 12, bArr.length - 12), copyOf, bArr2);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
