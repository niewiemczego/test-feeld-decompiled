package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzpp;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzpr {
    private static final zzxr zza;
    private static final zzoa<zzpp, zzos> zzb = zzoa.zza(zzpu.zza, zzpp.class, zzos.class);
    private static final zznw<zzos> zzc;
    private static final zzmx<zzpi, zzot> zzd = zzmx.zza(zzpw.zza, zzpi.class, zzot.class);
    private static final zzmt<zzot> zze;

    /* access modifiers changed from: private */
    public static zzpi zzb(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        if (zzot.zzf().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzry zza2 = zzry.zza(zzot.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzpi.zzb().zza(zzpp.zzd().zza(zza2.zze().zzb()).zzb(zza2.zzd().zza()).zza(zza(zzot.zzc())).zza()).zza(zzxt.zza(zza2.zze().zzg(), zzct.zza(zzct))).zza(zzot.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing AesCmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
    }

    private static zzpp.zzb zza(zzvt zzvt) throws GeneralSecurityException {
        int i = zzpy.zza[zzvt.ordinal()];
        if (i == 1) {
            return zzpp.zzb.zza;
        }
        if (i == 2) {
            return zzpp.zzb.zzb;
        }
        if (i == 3) {
            return zzpp.zzb.zzc;
        }
        if (i == 4) {
            return zzpp.zzb.zzd;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzvt.zza());
    }

    /* access modifiers changed from: private */
    public static zzpp zzb(zzos zzos) throws GeneralSecurityException {
        if (zzos.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzrz zza2 = zzrz.zza(zzos.zza().zze(), zzaip.zza());
                return zzpp.zzd().zza(zza2.zza()).zzb(zza2.zzd().zza()).zza(zza(zzos.zza().zzd())).zza();
            } catch (zzajj e) {
                throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: " + zzos.zza().zzf());
        }
    }

    private static zzsc zzb(zzpp zzpp) {
        return (zzsc) ((zzaja) zzsc.zzb().zza(zzpp.zzb()).zzf());
    }

    private static zzvt zza(zzpp.zzb zzb2) throws GeneralSecurityException {
        if (zzpp.zzb.zza.equals(zzb2)) {
            return zzvt.TINK;
        }
        if (zzpp.zzb.zzb.equals(zzb2)) {
            return zzvt.CRUNCHY;
        }
        if (zzpp.zzb.zzd.equals(zzb2)) {
            return zzvt.RAW;
        }
        if (zzpp.zzb.zzc.equals(zzb2)) {
            return zzvt.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzb2));
    }

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zza = zzb2;
        zzc = zznw.zza(zzpt.zza, zzb2, zzos.class);
        zze = zzmt.zza(zzpv.zza, zzb2, zzot.class);
    }

    public static void zza() throws GeneralSecurityException {
        zznv zza2 = zznv.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
