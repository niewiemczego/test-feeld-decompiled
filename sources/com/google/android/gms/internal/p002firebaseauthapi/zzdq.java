package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdm;
import com.google.android.gms.internal.p002firebaseauthapi.zzui;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzdq {
    private static final zzxr zza;
    private static final zzoa<zzdm, zzos> zzb = zzoa.zza(zzdp.zza, zzdm.class, zzos.class);
    private static final zznw<zzos> zzc;
    private static final zzmx<zzdf, zzot> zzd = zzmx.zza(zzdr.zza, zzdf.class, zzot.class);
    private static final zzmt<zzot> zze;

    /* access modifiers changed from: private */
    public static zzdf zzb(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        if (zzot.zzf().equals(zzcx.zza)) {
            try {
                zzsd zza2 = zzsd.zza(zzot.zzd(), zzaip.zza());
                if (zza2.zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys are accepted");
                } else if (zza2.zzd().zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
                } else if (zza2.zze().zza() == 0) {
                    return zzdf.zzb().zza(zzdm.zzf().zza(zza2.zzd().zzf().zzb()).zzb(zza2.zze().zzf().zzb()).zzc(zza2.zzd().zze().zza()).zzd(zza2.zze().zze().zza()).zza(zza(zza2.zze().zze().zzb())).zza(zza(zzot.zzc())).zza()).zza(zzxt.zza(zza2.zzd().zzf().zzg(), zzct.zza(zzct))).zzb(zzxt.zza(zza2.zze().zzf().zzg(), zzct.zza(zzct))).zza(zzot.zze()).zza();
                } else {
                    throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
                }
            } catch (zzajj unused) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
    }

    private static zzdm.zzb zza(zzuc zzuc) throws GeneralSecurityException {
        int i = zzdt.zzb[zzuc.ordinal()];
        if (i == 1) {
            return zzdm.zzb.zza;
        }
        if (i == 2) {
            return zzdm.zzb.zzb;
        }
        if (i == 3) {
            return zzdm.zzb.zzc;
        }
        if (i == 4) {
            return zzdm.zzb.zzd;
        }
        if (i == 5) {
            return zzdm.zzb.zze;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + zzuc.zza());
    }

    private static zzdm.zzc zza(zzvt zzvt) throws GeneralSecurityException {
        int i = zzdt.zza[zzvt.ordinal()];
        if (i == 1) {
            return zzdm.zzc.zza;
        }
        if (i == 2 || i == 3) {
            return zzdm.zzc.zzb;
        }
        if (i == 4) {
            return zzdm.zzc.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzvt.zza());
    }

    /* access modifiers changed from: private */
    public static zzdm zzb(zzos zzos) throws GeneralSecurityException {
        if (zzos.zza().zzf().equals(zzcx.zza)) {
            try {
                zzsg zza2 = zzsg.zza(zzos.zza().zze(), zzaip.zza());
                if (zza2.zzd().zzb() == 0) {
                    return zzdm.zzf().zza(zza2.zzc().zza()).zzb(zza2.zzd().zza()).zzc(zza2.zzc().zze().zza()).zzd(zza2.zzd().zzf().zza()).zza(zza(zza2.zzd().zzf().zzb())).zza(zza(zzos.zza().zzd())).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj e) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: " + zzos.zza().zzf());
        }
    }

    private static zzui zzb(zzdm zzdm) throws GeneralSecurityException {
        zzuc zzuc;
        zzui.zza zza2 = zzui.zzc().zza(zzdm.zze());
        zzdm.zzb zzg = zzdm.zzg();
        if (zzdm.zzb.zza.equals(zzg)) {
            zzuc = zzuc.SHA1;
        } else if (zzdm.zzb.zzb.equals(zzg)) {
            zzuc = zzuc.SHA224;
        } else if (zzdm.zzb.zzc.equals(zzg)) {
            zzuc = zzuc.SHA256;
        } else if (zzdm.zzb.zzd.equals(zzg)) {
            zzuc = zzuc.SHA384;
        } else if (zzdm.zzb.zze.equals(zzg)) {
            zzuc = zzuc.SHA512;
        } else {
            throw new GeneralSecurityException("Unable to serialize HashType " + String.valueOf(zzg));
        }
        return (zzui) ((zzaja) zza2.zza(zzuc).zzf());
    }

    private static zzvt zza(zzdm.zzc zzc2) throws GeneralSecurityException {
        if (zzdm.zzc.zza.equals(zzc2)) {
            return zzvt.TINK;
        }
        if (zzdm.zzc.zzb.equals(zzc2)) {
            return zzvt.CRUNCHY;
        }
        if (zzdm.zzc.zzc.equals(zzc2)) {
            return zzvt.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzc2));
    }

    static {
        zzxr zzb2 = zzpg.zzb(zzcx.zza);
        zza = zzb2;
        zzc = zznw.zza(zzds.zza, zzb2, zzos.class);
        zze = zzmt.zza(zzdu.zza, zzb2, zzot.class);
    }

    public static void zza() throws GeneralSecurityException {
        zznv zza2 = zznv.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
