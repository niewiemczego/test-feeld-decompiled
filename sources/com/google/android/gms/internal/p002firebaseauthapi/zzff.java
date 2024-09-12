package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfa;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzff  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzff {
    private static final zzxr zza;
    private static final zzoa<zzfa, zzos> zzb = zzoa.zza(zzfe.zza, zzfa.class, zzos.class);
    private static final zznw<zzos> zzc;
    private static final zzmx<zzet, zzot> zzd = zzmx.zza(zzfg.zza, zzet.class, zzot.class);
    private static final zzmt<zzot> zze;

    /* access modifiers changed from: private */
    public static zzet zzb(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        if (zzot.zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzsx zza2 = zzsx.zza(zzot.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzet.zzb().zza(zzfa.zzc().zza(zza2.zzd().zzb()).zza(zza(zzot.zzc())).zza()).zza(zzxt.zza(zza2.zzd().zzg(), zzct.zza(zzct))).zza(zzot.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj unused) {
                throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
    }

    private static zzfa.zzb zza(zzvt zzvt) throws GeneralSecurityException {
        int i = zzfi.zza[zzvt.ordinal()];
        if (i == 1) {
            return zzfa.zzb.zza;
        }
        if (i == 2 || i == 3) {
            return zzfa.zzb.zzb;
        }
        if (i == 4) {
            return zzfa.zzb.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzvt.zza());
    }

    /* access modifiers changed from: private */
    public static zzfa zzb(zzos zzos) throws GeneralSecurityException {
        if (zzos.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzta zza2 = zzta.zza(zzos.zza().zze(), zzaip.zza());
                if (zza2.zzb() == 0) {
                    return zzfa.zzc().zza(zza2.zza()).zza(zza(zzos.zza().zzd())).zza();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzajj e) {
                throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: " + zzos.zza().zzf());
        }
    }

    private static zzvt zza(zzfa.zzb zzb2) throws GeneralSecurityException {
        if (zzfa.zzb.zza.equals(zzb2)) {
            return zzvt.TINK;
        }
        if (zzfa.zzb.zzb.equals(zzb2)) {
            return zzvt.CRUNCHY;
        }
        if (zzfa.zzb.zzc.equals(zzb2)) {
            return zzvt.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzb2));
    }

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zza = zzb2;
        zzc = zznw.zza(zzfh.zza, zzb2, zzos.class);
        zze = zzmt.zza(zzfj.zza, zzb2, zzot.class);
    }

    public static void zza() throws GeneralSecurityException {
        zznv zza2 = zznv.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
