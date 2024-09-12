package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjl;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzjn extends zzks {
    private final zzjv zza;
    @Nullable
    private final zzxu zzb;
    @Nullable
    private final zzxt zzc;

    public final zzjl zzb() {
        return this.zza.zzb();
    }

    public static zzjn zza(zzjv zzjv, zzxt zzxt) throws GeneralSecurityException {
        if (zzjv == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
        } else if (zzjv.zzc() == null) {
            throw new GeneralSecurityException("ECIES private key for X25519 curve cannot be constructed with NIST-curve public key");
        } else if (zzxt != null) {
            byte[] zza2 = zzxt.zza(zzbr.zza());
            byte[] zzb2 = zzjv.zzc().zzb();
            if (zza2.length != 32) {
                throw new GeneralSecurityException("Private key bytes length for X25519 curve must be 32");
            } else if (Arrays.equals(zzxp.zza(zza2), zzb2)) {
                return new zzjn(zzjv, (zzxu) null, zzxt);
            } else {
                throw new GeneralSecurityException("Invalid private key for public key.");
            }
        } else {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
    }

    public static zzjn zza(zzjv zzjv, zzxu zzxu) throws GeneralSecurityException {
        if (zzjv == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
        } else if (zzjv.zzd() == null) {
            throw new GeneralSecurityException("ECIES private key for NIST curve cannot be constructed with X25519-curve public key");
        } else if (zzxu != null) {
            BigInteger zza2 = zzxu.zza(zzbr.zza());
            ECPoint zzd = zzjv.zzd();
            zzjl.zzc zzd2 = zzjv.zzb().zzd();
            BigInteger order = zza(zzd2).getOrder();
            if (zza2.signum() <= 0 || zza2.compareTo(order) >= 0) {
                throw new GeneralSecurityException("Invalid private value");
            } else if (zzmd.zza(zza2, zza(zzd2)).equals(zzd)) {
                return new zzjn(zzjv, zzxu, (zzxt) null);
            } else {
                throw new GeneralSecurityException("Invalid private value");
            }
        } else {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
    }

    public final /* synthetic */ zzkr zzc() {
        return this.zza;
    }

    @Nullable
    public final zzxu zzd() {
        return this.zzb;
    }

    @Nullable
    public final zzxt zze() {
        return this.zzc;
    }

    private static ECParameterSpec zza(zzjl.zzc zzc2) {
        if (zzc2 == zzjl.zzc.zza) {
            return zzmd.zza;
        }
        if (zzc2 == zzjl.zzc.zzb) {
            return zzmd.zzb;
        }
        if (zzc2 == zzjl.zzc.zzc) {
            return zzmd.zzc;
        }
        throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zzc2));
    }

    private zzjn(zzjv zzjv, @Nullable zzxu zzxu, @Nullable zzxt zzxt) {
        this.zza = zzjv;
        this.zzb = zzxu;
        this.zzc = zzxt;
    }
}
