package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzxs implements zzbh {
    private final zzhs zza;
    private final byte[] zzb;

    public static zzbh zza(zzha zzha) throws GeneralSecurityException {
        return new zzxs(zzha.zzd().zza(zzbr.zza()), zzha.zzc().zzb());
    }

    private zzxs(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        this.zza = new zzhs(bArr);
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
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 24 + 16);
        byte[] zza2 = zzov.zza(24);
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
        if (bArr.length >= 40) {
            byte[] copyOf = Arrays.copyOf(bArr, 24);
            return this.zza.zza(ByteBuffer.wrap(bArr, 24, bArr.length - 24), copyOf, bArr2);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
