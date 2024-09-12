package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzfx implements zzbh {
    private static final byte[] zza = new byte[0];
    private static final Set<String> zzb;
    private final zzvd zzc;
    private final zzbh zzd;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(zzcx.zzb);
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add(zzcx.zza);
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = Collections.unmodifiableSet(hashSet);
    }

    @Deprecated
    zzfx(zzvd zzvd, zzbh zzbh) {
        if (zzb.contains(zzvd.zzf())) {
            this.zzc = zzvd;
            this.zzd = zzbh;
            return;
        }
        throw new IllegalArgumentException("Unsupported DEK key type: " + zzvd.zzf() + ". Only Tink AEAD key types are supported.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i = wrap.getInt();
            if (i <= 0 || i > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i];
            wrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[wrap.remaining()];
            wrap.get(bArr4, 0, wrap.remaining());
            return ((zzbh) zzcu.zza(this.zzc.zzf(), this.zzd.zza(bArr3, zza), zzbh.class)).zza(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e) {
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzg = zzcu.zza(this.zzc).zze().zzg();
        byte[] zzb2 = this.zzd.zzb(zzg, zza);
        byte[] zzb3 = ((zzbh) zzcu.zza(this.zzc.zzf(), zzg, zzbh.class)).zzb(bArr, bArr2);
        return ByteBuffer.allocate(zzb2.length + 4 + zzb3.length).putInt(zzb2.length).put(zzb2).put(zzb3).array();
    }
}
