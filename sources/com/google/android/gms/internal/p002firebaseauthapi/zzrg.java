package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqm;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzrg {
    private static final zzxr zza;
    private static final zzmf<zzvt, zzqm.zzc> zzb = zzmf.zza().zza(zzvt.RAW, zzqm.zzc.zzd).zza(zzvt.TINK, zzqm.zzc.zza).zza(zzvt.LEGACY, zzqm.zzc.zzc).zza(zzvt.CRUNCHY, zzqm.zzc.zzb).zza();
    private static final zzmf<zzuc, zzqm.zzb> zzc = zzmf.zza().zza(zzuc.SHA1, zzqm.zzb.zza).zza(zzuc.SHA224, zzqm.zzb.zzb).zza(zzuc.SHA256, zzqm.zzb.zzc).zza(zzuc.SHA384, zzqm.zzb.zzd).zza(zzuc.SHA512, zzqm.zzb.zze).zza();
    private static final zzoa<zzqm, zzos> zzd = zzoa.zza(zzrf.zza, zzqm.class, zzos.class);
    private static final zznw<zzos> zze;
    private static final zzmx<zzqb, zzot> zzf = zzmx.zza(zzrh.zza, zzqb.class, zzot.class);
    private static final zzmt<zzot> zzg;

    /* access modifiers changed from: private */
    public static zzqb zzb(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        if (zzot.zzf().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzue zza2 = zzue.zza(zzot.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzqb.zzb().zza(zzqm.zzd().zza(zza2.zzf().zzb()).zzb(zza2.zze().zza()).zza(zzc.zza(zza2.zze().zzb())).zza(zzb.zza(zzot.zzc())).zza()).zza(zzxt.zza(zza2.zzf().zzg(), zzct.zza(zzct))).zza(zzot.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing HmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
    }

    /* access modifiers changed from: private */
    public static zzqm zzb(zzos zzos) throws GeneralSecurityException {
        if (zzos.zza().zzf().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzuf zza2 = zzuf.zza(zzos.zza().zze(), zzaip.zza());
                if (zza2.zzb() == 0) {
                    return zzqm.zzd().zza(zza2.zza()).zzb(zza2.zzf().zza()).zza(zzc.zza(zza2.zzf().zzb())).zza(zzb.zza(zzos.zza().zzd())).zza();
                }
                throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zza2.zzb());
            } catch (zzajj e) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: " + zzos.zza().zzf());
        }
    }

    private static zzui zzb(zzqm zzqm) throws GeneralSecurityException {
        return (zzui) ((zzaja) zzui.zzc().zza(zzqm.zzb()).zza(zzc.zza(zzqm.zze())).zzf());
    }

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zza = zzb2;
        zze = zznw.zza(zzri.zza, zzb2, zzos.class);
        zzg = zzmt.zza(zzrk.zza, zzb2, zzot.class);
    }

    public static void zza() throws GeneralSecurityException {
        zznv zza2 = zznv.zza();
        zza2.zza(zzd);
        zza2.zza(zze);
        zza2.zza(zzf);
        zza2.zza(zzg);
    }
}
