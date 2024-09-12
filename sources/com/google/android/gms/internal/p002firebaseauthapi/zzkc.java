package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjx;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzkc extends zzks {
    private final zzkk zza;
    private final zzxt zzb;

    public final zzjx zzb() {
        return this.zza.zzb();
    }

    public static zzkc zza(zzkk zzkk, zzxt zzxt) throws GeneralSecurityException {
        ECParameterSpec eCParameterSpec;
        if (zzkk == null) {
            throw new GeneralSecurityException("HPKE private key cannot be constructed without an HPKE public key");
        } else if (zzxt != null) {
            zzjx.zzd zze = zzkk.zzb().zze();
            int zza2 = zzxt.zza();
            String str = "Encoded private key byte length for " + String.valueOf(zze) + " must be %d, not " + zza2;
            boolean z = false;
            if (zze == zzjx.zzd.zza) {
                if (zza2 != 32) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{32}));
                }
            } else if (zze == zzjx.zzd.zzb) {
                if (zza2 != 48) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{48}));
                }
            } else if (zze == zzjx.zzd.zzc) {
                if (zza2 != 66) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{66}));
                }
            } else if (zze != zzjx.zzd.zzd) {
                throw new GeneralSecurityException("Unable to validate private key length for " + String.valueOf(zze));
            } else if (zza2 != 32) {
                throw new GeneralSecurityException(String.format(str, new Object[]{32}));
            }
            zzjx.zzd zze2 = zzkk.zzb().zze();
            byte[] zzb2 = zzkk.zzc().zzb();
            byte[] zza3 = zzxt.zza(zzbr.zza());
            if (zze2 == zzjx.zzd.zza || zze2 == zzjx.zzd.zzb || zze2 == zzjx.zzd.zzc) {
                z = true;
            }
            if (z) {
                if (zze2 == zzjx.zzd.zza) {
                    eCParameterSpec = zzmd.zza;
                } else if (zze2 == zzjx.zzd.zzb) {
                    eCParameterSpec = zzmd.zzb;
                } else if (zze2 == zzjx.zzd.zzc) {
                    eCParameterSpec = zzmd.zzc;
                } else {
                    throw new IllegalArgumentException("Unable to determine NIST curve params for " + String.valueOf(zze2));
                }
                BigInteger order = eCParameterSpec.getOrder();
                BigInteger zza4 = zzmb.zza(zza3);
                if (zza4.signum() <= 0 || zza4.compareTo(order) >= 0) {
                    throw new GeneralSecurityException("Invalid private key.");
                } else if (!zzmd.zza(zza4, eCParameterSpec).equals(zzwn.zza(eCParameterSpec.getCurve(), zzwp.UNCOMPRESSED, zzb2))) {
                    throw new GeneralSecurityException("Invalid private key for public key.");
                }
            } else if (zze2 != zzjx.zzd.zzd) {
                throw new IllegalArgumentException("Unable to validate key pair for " + String.valueOf(zze2));
            } else if (!Arrays.equals(zzxp.zza(zza3), zzb2)) {
                throw new GeneralSecurityException("Invalid private key for public key.");
            }
            return new zzkc(zzkk, zzxt);
        } else {
            throw new GeneralSecurityException("HPKE private key cannot be constructed without secret");
        }
    }

    public final /* synthetic */ zzkr zzc() {
        return this.zza;
    }

    public final zzxt zzd() {
        return this.zzb;
    }

    private zzkc(zzkk zzkk, zzxt zzxt) {
        this.zza = zzkk;
        this.zzb = zzxt;
    }
}
