package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzkx implements zzld {
    private final String zza;

    /* access modifiers changed from: package-private */
    public final int zza() throws GeneralSecurityException {
        return Mac.getInstance(this.zza).getMacLength();
    }

    zzkx(String str) {
        this.zza = str;
    }

    private final byte[] zza(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        Mac zza2 = zzwr.zzb.zza(this.zza);
        if (i <= zza2.getMacLength() * 255) {
            byte[] bArr3 = new byte[i];
            zza2.init(new SecretKeySpec(bArr, this.zza));
            byte[] bArr4 = new byte[0];
            int i2 = 1;
            int i3 = 0;
            while (true) {
                zza2.update(bArr4);
                zza2.update(bArr2);
                zza2.update((byte) i2);
                bArr4 = zza2.doFinal();
                if (bArr4.length + i3 < i) {
                    System.arraycopy(bArr4, 0, bArr3, i3, bArr4.length);
                    i3 += bArr4.length;
                    i2++;
                } else {
                    System.arraycopy(bArr4, 0, bArr3, i3, i - i3);
                    return bArr3;
                }
            }
        } else {
            throw new GeneralSecurityException("size too large");
        }
    }

    private final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Mac zza2 = zzwr.zzb.zza(this.zza);
        if (bArr2 == null || bArr2.length == 0) {
            zza2.init(new SecretKeySpec(new byte[zza2.getMacLength()], this.zza));
        } else {
            zza2.init(new SecretKeySpec(bArr2, this.zza));
        }
        return zza2.doFinal(bArr);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i) throws GeneralSecurityException {
        return zza(zza(zzlq.zza(str, bArr2, bArr4), (byte[]) null), zzlq.zza(str2, bArr3, bArr4, i), i);
    }

    public final byte[] zzb() throws GeneralSecurityException {
        String str = this.zza;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 984523022:
                if (str.equals("HmacSha256")) {
                    c = 0;
                    break;
                }
                break;
            case 984524074:
                if (str.equals("HmacSha384")) {
                    c = 1;
                    break;
                }
                break;
            case 984525777:
                if (str.equals("HmacSha512")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return zzlq.zzf;
            case 1:
                return zzlq.zzg;
            case 2:
                return zzlq.zzh;
            default:
                throw new GeneralSecurityException("Could not determine HPKE KDF ID");
        }
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i) throws GeneralSecurityException {
        return zza(bArr, zzlq.zza(str, bArr2, bArr3, i), i);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) throws GeneralSecurityException {
        return zza(zzlq.zza(str, bArr2, bArr3), bArr);
    }
}
