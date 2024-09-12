package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzgj;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzgo {
    private static final zzxr zza;
    private static final zzoa<zzgj, zzos> zzb = zzoa.zza(zzgn.zza, zzgj.class, zzos.class);
    private static final zznw<zzos> zzc;
    private static final zzmx<zzgk, zzot> zzd = zzmx.zza(zzgp.zza, zzgk.class, zzot.class);
    private static final zzmt<zzot> zze;

    /* access modifiers changed from: private */
    public static zzgk zzb(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        if (zzot.zzf().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                zzvp zza2 = zzvp.zza(zzot.zzd(), zzaip.zza());
                if (zzot.zzc() != zzvt.RAW) {
                    throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with OutputPrefixType RAW, got " + String.valueOf(zza2));
                } else if (zza2.zza() == 0) {
                    return zzgk.zza(zza(zza2.zzd()));
                } else {
                    throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got " + String.valueOf(zza2));
                }
            } catch (zzajj e) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
    }

    /* access modifiers changed from: private */
    public static zzgj zzb(zzos zzos) throws GeneralSecurityException {
        if (zzos.zza().zzf().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                return zza(zzvq.zza(zzos.zza().zze(), zzaip.zza()));
            } catch (zzajj e) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: " + zzos.zza().zzf());
        }
    }

    private static zzgj zza(zzvq zzvq) throws GeneralSecurityException {
        zzgj.zzb zzb2;
        zzci zza2 = zzcv.zza(((zzvd) ((zzaja) zzvd.zza().zza(zzvq.zza().zzf()).zza(zzvq.zza().zze()).zza(zzvt.RAW).zzf())).zzj());
        if (zza2 instanceof zzer) {
            zzb2 = zzgj.zzb.zza;
        } else if (zza2 instanceof zzfo) {
            zzb2 = zzgj.zzb.zzc;
        } else if (zza2 instanceof zzhd) {
            zzb2 = zzgj.zzb.zzb;
        } else if (zza2 instanceof zzdm) {
            zzb2 = zzgj.zzb.zzd;
        } else if (zza2 instanceof zzea) {
            zzb2 = zzgj.zzb.zze;
        } else if (zza2 instanceof zzfa) {
            zzb2 = zzgj.zzb.zzf;
        } else {
            throw new GeneralSecurityException("Unsupported DEK parameters when parsing " + String.valueOf(zza2));
        }
        return new zzgj.zza().zza(zzvq.zze()).zza((zzdc) zza2).zza(zzb2).zza();
    }

    private static zzvq zzb(zzgj zzgj) throws GeneralSecurityException {
        try {
            return (zzvq) ((zzaja) zzvq.zzb().zza(zzgj.zzc()).zza(zzvd.zza(zzcv.zza((zzci) zzgj.zzb()), zzaip.zza())).zzf());
        } catch (zzajj e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zza = zzb2;
        zzc = zznw.zza(zzgq.zza, zzb2, zzos.class);
        zze = zzmt.zza(zzgs.zza, zzb2, zzot.class);
    }

    public static void zza() throws GeneralSecurityException {
        zznv zza2 = zznv.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
