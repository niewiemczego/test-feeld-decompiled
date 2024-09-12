package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjl;
import com.google.android.gms.internal.p002firebaseauthapi.zzts;
import com.google.android.gms.internal.p002firebaseauthapi.zztw;
import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzjq {
    private static final zzxr zza;
    private static final zzxr zzb;
    private static final zzoa<zzjl, zzos> zzc = zzoa.zza(zzjp.zza, zzjl.class, zzos.class);
    private static final zznw<zzos> zzd;
    private static final zzmx<zzjv, zzot> zze = zzmx.zza(zzjr.zza, zzjv.class, zzot.class);
    private static final zzmt<zzot> zzf;
    private static final zzmx<zzjn, zzot> zzg = zzmx.zza(zzjt.zza, zzjn.class, zzot.class);
    private static final zzmt<zzot> zzh;
    private static final zzmf<zzvt, zzjl.zzd> zzi = zzmf.zza().zza(zzvt.RAW, zzjl.zzd.zzc).zza(zzvt.TINK, zzjl.zzd.zza).zza(zzvt.LEGACY, zzjl.zzd.zzb).zza(zzvt.CRUNCHY, zzjl.zzd.zzb).zza();
    private static final zzmf<zzuc, zzjl.zzb> zzj = zzmf.zza().zza(zzuc.SHA1, zzjl.zzb.zza).zza(zzuc.SHA224, zzjl.zzb.zzb).zza(zzuc.SHA256, zzjl.zzb.zzc).zza(zzuc.SHA384, zzjl.zzb.zzd).zza(zzuc.SHA512, zzjl.zzb.zze).zza();
    private static final zzmf<zztx, zzjl.zzc> zzk = zzmf.zza().zza(zztx.NIST_P256, zzjl.zzc.zza).zza(zztx.NIST_P384, zzjl.zzc.zzb).zza(zztx.NIST_P521, zzjl.zzc.zzc).zza(zztx.CURVE25519, zzjl.zzc.zzd).zza();
    private static final zzmf<zztj, zzjl.zze> zzl = zzmf.zza().zza(zztj.UNCOMPRESSED, zzjl.zze.zzb).zza(zztj.COMPRESSED, zzjl.zze.zza).zza(zztj.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, zzjl.zze.zzc).zza();

    private static int zza(zzjl.zzc zzc2) throws GeneralSecurityException {
        if (zzjl.zzc.zza.equals(zzc2)) {
            return 33;
        }
        if (zzjl.zzc.zzb.equals(zzc2)) {
            return 49;
        }
        if (zzjl.zzc.zzc.equals(zzc2)) {
            return 67;
        }
        throw new GeneralSecurityException("Unable to serialize CurveType " + String.valueOf(zzc2));
    }

    private static zzjl zza(zzvt zzvt, zztp zztp) throws GeneralSecurityException {
        zzjl.zza zza2 = zzjl.zzc().zza(zzi.zza(zzvt)).zza(zzk.zza(zztp.zzf().zzd())).zza(zzj.zza(zztp.zzf().zze())).zza(zzcv.zza(((zzvd) ((zzaja) zzvd.zza().zza(zztp.zzb().zzd().zzf()).zza(zzvt.RAW).zza(zztp.zzb().zzd().zze()).zzf())).zzj())).zza(zzxr.zza(zztp.zzf().zzf().zzg()));
        if (!zztp.zzf().zzd().equals(zztx.CURVE25519)) {
            zza2.zza(zzl.zza(zztp.zza()));
        } else if (!zztp.zza().equals(zztj.COMPRESSED)) {
            throw new GeneralSecurityException("For CURVE25519 EcPointFormat must be compressed");
        }
        return zza2.zza();
    }

    /* access modifiers changed from: private */
    public static zzjl zzb(zzos zzos) throws GeneralSecurityException {
        if (zzos.zza().zzf().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
            try {
                return zza(zzos.zza().zzd(), zzto.zza(zzos.zza().zze(), zzaip.zza()).zzc());
            } catch (zzajj e) {
                throw new GeneralSecurityException("Parsing EciesParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parseParameters: " + zzos.zza().zzf());
        }
    }

    /* access modifiers changed from: private */
    public static zzjn zzc(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        if (zzot.zzf().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
            try {
                zzts zza2 = zzts.zza(zzot.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    zztt zzd2 = zza2.zzd();
                    zzjl zza3 = zza(zzot.zzc(), zzd2.zzb());
                    if (zza3.zzd().equals(zzjl.zzc.zzd)) {
                        return zzjn.zza(zzjv.zza(zza3, zzxr.zza(zzd2.zzf().zzg()), zzot.zze()), zzxt.zza(zza2.zze().zzg(), zzct.zza(zzct)));
                    }
                    return zzjn.zza(zzjv.zza(zza3, new ECPoint(zzmb.zza(zzd2.zzf().zzg()), zzmb.zza(zzd2.zzg().zzg())), zzot.zze()), zzxu.zza(zzmb.zza(zza2.zze().zzg()), zzct.zza(zzct)));
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing EcdsaPrivateKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePrivateKey: " + zzot.zzf());
        }
    }

    /* access modifiers changed from: private */
    public static zzjv zzd(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        if (zzot.zzf().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
            try {
                zztt zza2 = zztt.zza(zzot.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    zzjl zza3 = zza(zzot.zzc(), zza2.zzb());
                    if (!zza3.zzd().equals(zzjl.zzc.zzd)) {
                        return zzjv.zza(zza3, new ECPoint(zzmb.zza(zza2.zzf().zzg()), zzmb.zza(zza2.zzg().zzg())), zzot.zze());
                    }
                    if (zza2.zzg().zze()) {
                        return zzjv.zza(zza3, zzxr.zza(zza2.zzf().zzg()), zzot.zze());
                    }
                    throw new GeneralSecurityException("Y must be empty for X25519 points");
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing EcdsaPublicKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePublicKey: " + zzot.zzf());
        }
    }

    public static /* synthetic */ zzot zza(zzjn zzjn, zzct zzct) {
        zzts.zza zza2 = zzts.zzb().zza(0).zza(zza((zzjv) zzjn.zzc()));
        if (zzjn.zzb().zzd().equals(zzjl.zzc.zzd)) {
            zza2.zza(zzahm.zza(zzjn.zze().zza(zzct.zza(zzct))));
        } else {
            zza2.zza(zzahm.zza(zzmb.zza(zzjn.zzd().zza(zzct.zza(zzct)), zza(zzjn.zzb().zzd()))));
        }
        return zzot.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", ((zzts) ((zzaja) zza2.zzf())).zzi(), zzux.zzb.ASYMMETRIC_PRIVATE, zzi.zza(zzjn.zzb().zzg()), zzjn.zza());
    }

    private static zztp zzb(zzjl zzjl) throws GeneralSecurityException {
        zztw.zza zza2 = zztw.zza().zza(zzk.zza(zzjl.zzd())).zza(zzj.zza(zzjl.zze()));
        if (zzjl.zzh() != null && zzjl.zzh().zza() > 0) {
            zza2.zza(zzahm.zza(zzjl.zzh().zzb()));
        }
        zztw zztw = (zztw) ((zzaja) zza2.zzf());
        try {
            zzvd zza3 = zzvd.zza(zzcv.zza(zzjl.zzb()), zzaip.zza());
            zztk zztk = (zztk) ((zzaja) zztk.zza().zza((zzvd) ((zzaja) zzvd.zza().zza(zza3.zzf()).zza(zzvt.TINK).zza(zza3.zze()).zzf())).zzf());
            zzjl.zze zzf2 = zzjl.zzf();
            if (zzf2 == null) {
                zzf2 = zzjl.zze.zza;
            }
            return (zztp) ((zzaja) zztp.zzc().zza(zztw).zza(zztk).zza(zzl.zza(zzf2)).zzf());
        } catch (zzajj e) {
            throw new GeneralSecurityException("Parsing EciesParameters failed: ", e);
        }
    }

    private static zztt zza(zzjv zzjv) throws GeneralSecurityException {
        if (zzjv.zzb().zzd().equals(zzjl.zzc.zzd)) {
            return (zztt) ((zzaja) zztt.zzc().zza(0).zza(zzb(zzjv.zzb())).zza(zzahm.zza(zzjv.zzc().zzb())).zzb(zzahm.zza).zzf());
        }
        int zza2 = zza(zzjv.zzb().zzd());
        ECPoint zzd2 = zzjv.zzd();
        if (zzd2 != null) {
            return (zztt) ((zzaja) zztt.zzc().zza(0).zza(zzb(zzjv.zzb())).zza(zzahm.zza(zzmb.zza(zzd2.getAffineX(), zza2))).zzb(zzahm.zza(zzmb.zza(zzd2.getAffineY(), zza2))).zzf());
        }
        throw new GeneralSecurityException("NistCurvePoint was null for NIST curve");
    }

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
        zza = zzb2;
        zzxr zzb3 = zzpg.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
        zzb = zzb3;
        zzd = zznw.zza(zzjs.zza, zzb2, zzos.class);
        zzf = zzmt.zza(zzju.zza, zzb3, zzot.class);
        zzh = zzmt.zza(zzjw.zza, zzb2, zzot.class);
    }

    public static void zza() throws GeneralSecurityException {
        zznv zza2 = zznv.zza();
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
        zza2.zza(zzf);
        zza2.zza(zzg);
        zza2.zza(zzh);
    }
}
