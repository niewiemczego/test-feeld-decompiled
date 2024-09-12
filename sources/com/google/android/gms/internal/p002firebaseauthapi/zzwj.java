package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzwj implements zzbp {
    private static final byte[] zza = new byte[0];
    private final ECPrivateKey zzb;
    private final zzwl zzc;
    private final String zzd;
    private final byte[] zze;
    private final zzwp zzf;
    private final zzwk zzg;
    private final byte[] zzh;

    public zzwj(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzwp zzwp, zzwk zzwk) throws GeneralSecurityException {
        this(eCPrivateKey, bArr, str, zzwp, zzwk, new byte[0]);
    }

    private zzwj(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzwp zzwp, zzwk zzwk, byte[] bArr2) throws GeneralSecurityException {
        this.zzb = eCPrivateKey;
        this.zzc = new zzwl(eCPrivateKey);
        this.zze = bArr;
        this.zzd = str;
        this.zzf = zzwp;
        this.zzg = zzwk;
        this.zzh = bArr2;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzh;
        if (bArr3.length == 0) {
            return zzb(bArr, bArr2);
        }
        if (zzpg.zza(bArr3, bArr)) {
            return zzb(Arrays.copyOfRange(bArr, this.zzh.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final byte[] zzb(byte[] r10, byte[] r11) throws java.security.GeneralSecurityException {
        /*
            r9 = this;
            java.security.interfaces.ECPrivateKey r0 = r9.zzb
            java.security.spec.ECParameterSpec r0 = r0.getParams()
            java.security.spec.EllipticCurve r0 = r0.getCurve()
            com.google.android.gms.internal.firebase-auth-api.zzwp r1 = r9.zzf
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzwn.zza((java.security.spec.EllipticCurve) r0)
            int r1 = r1.ordinal()
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r3) goto L_0x0027
            if (r1 != r2) goto L_0x001e
            int r0 = r0 * r2
            goto L_0x0028
        L_0x001e:
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException
            java.lang.String r11 = "unknown EC point format"
            r10.<init>(r11)
            throw r10
        L_0x0026:
            int r0 = r0 * r2
        L_0x0027:
            int r0 = r0 + r3
        L_0x0028:
            int r1 = r10.length
            if (r1 < r0) goto L_0x0055
            r1 = 0
            byte[] r3 = java.util.Arrays.copyOfRange(r10, r1, r0)
            com.google.android.gms.internal.firebase-auth-api.zzwl r2 = r9.zzc
            java.lang.String r4 = r9.zzd
            byte[] r5 = r9.zze
            com.google.android.gms.internal.firebase-auth-api.zzwk r1 = r9.zzg
            int r7 = r1.zza()
            com.google.android.gms.internal.firebase-auth-api.zzwp r8 = r9.zzf
            r6 = r11
            byte[] r11 = r2.zza(r3, r4, r5, r6, r7, r8)
            com.google.android.gms.internal.firebase-auth-api.zzwk r1 = r9.zzg
            com.google.android.gms.internal.firebase-auth-api.zzlv r11 = r1.zza(r11)
            int r1 = r10.length
            byte[] r10 = java.util.Arrays.copyOfRange(r10, r0, r1)
            byte[] r0 = zza
            byte[] r10 = r11.zza(r10, r0)
            return r10
        L_0x0055:
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException
            java.lang.String r11 = "ciphertext too short"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzwj.zzb(byte[], byte[]):byte[]");
    }
}
