package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjx;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzkb {
    private static final zzxr zza;
    private static final zzxr zzb;
    private static final zzoa<zzjx, zzos> zzc = zzoa.zza(zzke.zza, zzjx.class, zzos.class);
    private static final zznw<zzos> zzd;
    private static final zzmx<zzkk, zzot> zze = zzmx.zza(zzkg.zza, zzkk.class, zzot.class);
    private static final zzmt<zzot> zzf;
    private static final zzmx<zzkc, zzot> zzg = zzmx.zza(zzki.zza, zzkc.class, zzot.class);
    private static final zzmt<zzot> zzh;
    private static final zzmf<zzvt, zzjx.zzf> zzi = zzmf.zza().zza(zzvt.RAW, zzjx.zzf.zzc).zza(zzvt.TINK, zzjx.zzf.zza).zza(zzvt.LEGACY, zzjx.zzf.zzb).zza(zzvt.CRUNCHY, zzjx.zzf.zzb).zza();
    private static final zzmf<zzum, zzjx.zzd> zzj = zzmf.zza().zza(zzum.DHKEM_P256_HKDF_SHA256, zzjx.zzd.zza).zza(zzum.DHKEM_P384_HKDF_SHA384, zzjx.zzd.zzb).zza(zzum.DHKEM_P521_HKDF_SHA512, zzjx.zzd.zzc).zza(zzum.DHKEM_X25519_HKDF_SHA256, zzjx.zzd.zzd).zza();
    private static final zzmf<zzuk, zzjx.zze> zzk = zzmf.zza().zza(zzuk.HKDF_SHA256, zzjx.zze.zza).zza(zzuk.HKDF_SHA384, zzjx.zze.zzb).zza(zzuk.HKDF_SHA512, zzjx.zze.zzc).zza();
    private static final zzmf<zzuj, zzjx.zza> zzl = zzmf.zza().zza(zzuj.AES_128_GCM, zzjx.zza.zza).zza(zzuj.AES_256_GCM, zzjx.zza.zzb).zza(zzuj.CHACHA20_POLY1305, zzjx.zza.zzc).zza();

    private static zzjx zza(zzvt zzvt, zzus zzus) throws GeneralSecurityException {
        return zzjx.zzc().zza(zzi.zza(zzvt)).zza(zzj.zza(zzus.zzc())).zza(zzk.zza(zzus.zzb())).zza(zzl.zza(zzus.zza())).zza();
    }

    /* access modifiers changed from: private */
    public static zzjx zzb(zzos zzos) throws GeneralSecurityException {
        if (zzos.zza().zzf().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            try {
                return zza(zzos.zza().zzd(), zzuo.zza(zzos.zza().zze(), zzaip.zza()).zzc());
            } catch (zzajj e) {
                throw new GeneralSecurityException("Parsing HpkeParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parseParameters: " + zzos.zza().zzf());
        }
    }

    /* access modifiers changed from: private */
    public static zzkc zzc(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        if (zzot.zzf().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            try {
                zzut zza2 = zzut.zza(zzot.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    zzuw zzd2 = zza2.zzd();
                    return zzkc.zza(zzkk.zza(zza(zzot.zzc(), zzd2.zzb()), zza(zzd2.zzb().zzc(), zzd2.zzf().zzg()), zzot.zze()), zzxt.zza(zzmb.zza(zzmb.zza(zza2.zze().zzg()), zzlq.zza(zzd2.zzb().zzc())), zzct.zza(zzct)));
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj unused) {
                throw new GeneralSecurityException("Parsing HpkePrivateKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePrivateKey: " + zzot.zzf());
        }
    }

    /* access modifiers changed from: private */
    public static zzkk zzd(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        if (zzot.zzf().equals("type.googleapis.com/google.crypto.tink.HpkePublicKey")) {
            try {
                zzuw zza2 = zzuw.zza(zzot.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzkk.zza(zza(zzot.zzc(), zza2.zzb()), zza(zza2.zzb().zzc(), zza2.zzf().zzg()), zzot.zze());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj unused) {
                throw new GeneralSecurityException("Parsing HpkePublicKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePublicKey: " + zzot.zzf());
        }
    }

    private static zzus zzb(zzjx zzjx) throws GeneralSecurityException {
        return (zzus) ((zzaja) zzus.zzd().zza(zzj.zza(zzjx.zze())).zza(zzk.zza(zzjx.zzd())).zza(zzl.zza(zzjx.zzb())).zzf());
    }

    private static zzuw zza(zzkk zzkk) throws GeneralSecurityException {
        return (zzuw) ((zzaja) zzuw.zzc().zza(0).zza(zzb(zzkk.zzb())).zza(zzahm.zza(zzkk.zzc().zzb())).zzf());
    }

    private static zzxr zza(zzum zzum, byte[] bArr) throws GeneralSecurityException {
        return zzxr.zza(zzmb.zza(zzmb.zza(bArr), zzlq.zzb(zzum)));
    }

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.HpkePrivateKey");
        zza = zzb2;
        zzxr zzb3 = zzpg.zzb("type.googleapis.com/google.crypto.tink.HpkePublicKey");
        zzb = zzb3;
        zzd = zznw.zza(zzkd.zza, zzb2, zzos.class);
        zzf = zzmt.zza(zzkf.zza, zzb3, zzot.class);
        zzh = zzmt.zza(zzkh.zza, zzb2, zzot.class);
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
