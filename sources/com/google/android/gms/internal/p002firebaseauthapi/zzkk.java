package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjx;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.EllipticCurve;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzkk extends zzkr {
    private final zzjx zza;
    private final zzxr zzb;
    private final zzxr zzc;
    @Nullable
    private final Integer zzd;

    public final zzjx zzb() {
        return this.zza;
    }

    public static zzkk zza(zzjx zzjx, zzxr zzxr, @Nullable Integer num) throws GeneralSecurityException {
        zzxr zzxr2;
        EllipticCurve ellipticCurve;
        zzjx.zzf zzf = zzjx.zzf();
        if (!zzf.equals(zzjx.zzf.zzc) && num == null) {
            throw new GeneralSecurityException("'idRequirement' must be non-null for " + String.valueOf(zzf) + " variant.");
        } else if (!zzf.equals(zzjx.zzf.zzc) || num == null) {
            zzjx.zzd zze = zzjx.zze();
            int zza2 = zzxr.zza();
            String str = "Encoded public key byte length for " + String.valueOf(zze) + " must be %d, not " + zza2;
            if (zze == zzjx.zzd.zza) {
                if (zza2 != 65) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{65}));
                }
            } else if (zze == zzjx.zzd.zzb) {
                if (zza2 != 97) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{97}));
                }
            } else if (zze == zzjx.zzd.zzc) {
                if (zza2 != 133) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{133}));
                }
            } else if (zze != zzjx.zzd.zzd) {
                throw new GeneralSecurityException("Unable to validate public key length for " + String.valueOf(zze));
            } else if (zza2 != 32) {
                throw new GeneralSecurityException(String.format(str, new Object[]{32}));
            }
            if (zze == zzjx.zzd.zza || zze == zzjx.zzd.zzb || zze == zzjx.zzd.zzc) {
                if (zze == zzjx.zzd.zza) {
                    ellipticCurve = zzmd.zza.getCurve();
                } else if (zze == zzjx.zzd.zzb) {
                    ellipticCurve = zzmd.zzb.getCurve();
                } else if (zze == zzjx.zzd.zzc) {
                    ellipticCurve = zzmd.zzc.getCurve();
                } else {
                    throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zze));
                }
                zzmd.zza(zzwn.zza(ellipticCurve, zzwp.UNCOMPRESSED, zzxr.zzb()), ellipticCurve);
            }
            zzjx.zzf zzf2 = zzjx.zzf();
            if (zzf2 == zzjx.zzf.zzc) {
                zzxr2 = zzxr.zza(new byte[0]);
            } else if (num == null) {
                throw new IllegalStateException("idRequirement must be non-null for HpkeParameters.Variant " + String.valueOf(zzf2));
            } else if (zzf2 == zzjx.zzf.zzb) {
                zzxr2 = zzxr.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
            } else if (zzf2 == zzjx.zzf.zza) {
                zzxr2 = zzxr.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown HpkeParameters.Variant: " + String.valueOf(zzf2));
            }
            return new zzkk(zzjx, zzxr, zzxr2, num);
        } else {
            throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
        }
    }

    public final zzxr zzc() {
        return this.zzb;
    }

    @Nullable
    public final Integer zza() {
        return this.zzd;
    }

    private zzkk(zzjx zzjx, zzxr zzxr, zzxr zzxr2, @Nullable Integer num) {
        this.zza = zzjx;
        this.zzb = zzxr;
        this.zzc = zzxr2;
        this.zzd = num;
    }
}
