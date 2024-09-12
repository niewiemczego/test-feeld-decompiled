package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzgd {
    private static final zzxr zza;
    private static final zzoa<zzge, zzos> zzb = zzoa.zza(zzgg.zza, zzge.class, zzos.class);
    private static final zznw<zzos> zzc;
    private static final zzmx<zzgb, zzot> zzd = zzmx.zza(zzgi.zza, zzgb.class, zzot.class);
    private static final zzmt<zzot> zze;

    /* access modifiers changed from: private */
    public static zzgb zzb(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        if (!zzot.zzf().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
        } else if (zzot.zzc() == zzvt.RAW) {
            try {
                zzvl zza2 = zzvl.zza(zzot.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzgb.zza(zzge.zza(zza2.zzd().zzd()));
                }
                throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got " + String.valueOf(zza2));
            } catch (zzajj e) {
                throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e);
            }
        } else {
            throw new GeneralSecurityException("KmsAeadKey are only accepted with RAW, got " + String.valueOf(zzot.zzc()));
        }
    }

    /* access modifiers changed from: private */
    public static zzge zzb(zzos zzos) throws GeneralSecurityException {
        if (zzos.zza().zzf().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            try {
                zzvm zza2 = zzvm.zza(zzos.zza().zze(), zzaip.zza());
                if (zzos.zza().zzd() == zzvt.RAW) {
                    return zzge.zza(zza2.zzd());
                }
                String valueOf = String.valueOf(zzos.zza().zzd());
                throw new GeneralSecurityException("Only key templates with RAW are accepted, but got " + valueOf + " with format " + String.valueOf(zza2));
            } catch (zzajj e) {
                throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: " + zzos.zza().zzf());
        }
    }

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zza = zzb2;
        zzc = zznw.zza(zzgf.zza, zzb2, zzos.class);
        zze = zzmt.zza(zzgh.zza, zzb2, zzot.class);
    }

    public static void zza() throws GeneralSecurityException {
        zznv zza2 = zznv.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
