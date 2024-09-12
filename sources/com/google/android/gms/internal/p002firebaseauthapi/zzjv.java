package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjl;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzjv extends zzkr {
    private final zzjl zza;
    @Nullable
    private final ECPoint zzb;
    @Nullable
    private final zzxr zzc;
    private final zzxr zzd;
    @Nullable
    private final Integer zze;

    public final zzjl zzb() {
        return this.zza;
    }

    public static zzjv zza(zzjl zzjl, zzxr zzxr, @Nullable Integer num) throws GeneralSecurityException {
        if (zzjl.zzd().equals(zzjl.zzc.zzd)) {
            zzb(zzjl.zzg(), num);
            if (zzxr.zza() == 32) {
                return new zzjv(zzjl, (ECPoint) null, zzxr, zza(zzjl.zzg(), num), num);
            }
            throw new GeneralSecurityException("Encoded public point byte length for X25519 curve must be 32");
        }
        throw new GeneralSecurityException("createForCurveX25519 may only be called with parameters for curve X25519");
    }

    public static zzjv zza(zzjl zzjl, ECPoint eCPoint, @Nullable Integer num) throws GeneralSecurityException {
        EllipticCurve ellipticCurve;
        if (!zzjl.zzd().equals(zzjl.zzc.zzd)) {
            zzb(zzjl.zzg(), num);
            zzjl.zzc zzd2 = zzjl.zzd();
            if (zzd2 == zzjl.zzc.zza) {
                ellipticCurve = zzmd.zza.getCurve();
            } else if (zzd2 == zzjl.zzc.zzb) {
                ellipticCurve = zzmd.zzb.getCurve();
            } else if (zzd2 == zzjl.zzc.zzc) {
                ellipticCurve = zzmd.zzc.getCurve();
            } else {
                throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zzd2));
            }
            zzmd.zza(eCPoint, ellipticCurve);
            return new zzjv(zzjl, eCPoint, (zzxr) null, zza(zzjl.zzg(), num), num);
        }
        throw new GeneralSecurityException("createForNistCurve may only be called with parameters for NIST curve");
    }

    private static zzxr zza(zzjl.zzd zzd2, @Nullable Integer num) {
        if (zzd2 == zzjl.zzd.zzc) {
            return zzxr.zza(new byte[0]);
        }
        if (num == null) {
            throw new IllegalStateException("idRequirement must be non-null for EciesParameters.Variant: " + String.valueOf(zzd2));
        } else if (zzd2 == zzjl.zzd.zzb) {
            return zzxr.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        } else {
            if (zzd2 == zzjl.zzd.zza) {
                return zzxr.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            }
            throw new IllegalStateException("Unknown EciesParameters.Variant: " + String.valueOf(zzd2));
        }
    }

    @Nullable
    public final zzxr zzc() {
        return this.zzc;
    }

    @Nullable
    public final Integer zza() {
        return this.zze;
    }

    @Nullable
    public final ECPoint zzd() {
        return this.zzb;
    }

    private zzjv(zzjl zzjl, @Nullable ECPoint eCPoint, @Nullable zzxr zzxr, zzxr zzxr2, @Nullable Integer num) {
        this.zza = zzjl;
        this.zzb = eCPoint;
        this.zzc = zzxr;
        this.zzd = zzxr2;
        this.zze = num;
    }

    private static void zzb(zzjl.zzd zzd2, @Nullable Integer num) throws GeneralSecurityException {
        if (!zzd2.equals(zzjl.zzd.zzc) && num == null) {
            throw new GeneralSecurityException("'idRequirement' must be non-null for " + String.valueOf(zzd2) + " variant.");
        } else if (zzd2.equals(zzjl.zzd.zzc) && num != null) {
            throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
        }
    }
}
