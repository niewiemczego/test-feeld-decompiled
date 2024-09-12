package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import okio.Utf8;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzlm extends zzna<zzuo, zzut> {
    private final /* synthetic */ zzlk zza;

    public final /* synthetic */ zzakk zza(zzakk zzakk) throws GeneralSecurityException {
        byte[] bArr;
        byte[] bArr2;
        zzuo zzuo = (zzuo) zzakk;
        zzum zzc = zzuo.zzc().zzc();
        int i = zzll.zza[zzc.ordinal()];
        if (i != 1) {
            int i2 = 3;
            if (i == 2 || i == 3 || i == 4) {
                zzwq zzc2 = zzlq.zzc(zzuo.zzc().zzc());
                ECParameterSpec zza2 = zzwn.zza(zzc2);
                KeyPairGenerator zza3 = zzwr.zzd.zza("EC");
                zza3.initialize(zza2);
                KeyPair generateKeyPair = zza3.generateKeyPair();
                zzwp zzwp = zzwp.UNCOMPRESSED;
                ECPoint w = ((ECPublicKey) generateKeyPair.getPublic()).getW();
                EllipticCurve curve = zzwn.zza(zzc2).getCurve();
                zzmd.zza(w, curve);
                int zza4 = zzwn.zza(curve);
                int ordinal = zzwp.ordinal();
                if (ordinal == 0) {
                    int i3 = (zza4 * 2) + 1;
                    byte[] bArr3 = new byte[i3];
                    byte[] zza5 = zzmb.zza(w.getAffineX());
                    byte[] zza6 = zzmb.zza(w.getAffineY());
                    System.arraycopy(zza6, 0, bArr3, i3 - zza6.length, zza6.length);
                    System.arraycopy(zza5, 0, bArr3, (zza4 + 1) - zza5.length, zza5.length);
                    bArr3[0] = 4;
                    bArr = bArr3;
                } else if (ordinal == 1) {
                    int i4 = zza4 + 1;
                    bArr = new byte[i4];
                    byte[] zza7 = zzmb.zza(w.getAffineX());
                    System.arraycopy(zza7, 0, bArr, i4 - zza7.length, zza7.length);
                    if (!w.getAffineY().testBit(0)) {
                        i2 = 2;
                    }
                    bArr[0] = (byte) i2;
                } else if (ordinal == 2) {
                    int i5 = zza4 * 2;
                    bArr = new byte[i5];
                    byte[] zza8 = zzmb.zza(w.getAffineX());
                    if (zza8.length > zza4) {
                        zza8 = Arrays.copyOfRange(zza8, zza8.length - zza4, zza8.length);
                    }
                    byte[] zza9 = zzmb.zza(w.getAffineY());
                    if (zza9.length > zza4) {
                        zza9 = Arrays.copyOfRange(zza9, zza9.length - zza4, zza9.length);
                    }
                    System.arraycopy(zza9, 0, bArr, i5 - zza9.length, zza9.length);
                    System.arraycopy(zza8, 0, bArr, zza4 - zza8.length, zza8.length);
                } else {
                    throw new GeneralSecurityException("invalid format:" + String.valueOf(zzwp));
                }
                bArr2 = zzmb.zza(((ECPrivateKey) generateKeyPair.getPrivate()).getS(), zzlq.zza(zzc));
            } else {
                throw new GeneralSecurityException("Invalid KEM");
            }
        } else {
            bArr2 = zzov.zza(32);
            bArr2[0] = (byte) (bArr2[0] | 7);
            byte b = (byte) (bArr2[31] & Utf8.REPLACEMENT_BYTE);
            bArr2[31] = b;
            bArr2[31] = (byte) (b | 128);
            bArr = zzxp.zza(bArr2);
        }
        return (zzut) ((zzaja) zzut.zzb().zza(0).zza((zzuw) ((zzaja) zzuw.zzc().zza(0).zza(zzuo.zzc()).zza(zzahm.zza(bArr)).zzf())).zza(zzahm.zza(bArr2)).zzf());
    }

    public final /* synthetic */ zzakk zza(zzahm zzahm) throws zzajj {
        return zzuo.zza(zzahm, zzaip.zza());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzlm(zzlk zzlk, Class cls) {
        super(cls);
        this.zza = zzlk;
    }

    public final /* synthetic */ void zzb(zzakk zzakk) throws GeneralSecurityException {
        zzlq.zza(((zzuo) zzakk).zzc());
    }
}
