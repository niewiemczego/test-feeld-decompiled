package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzhf {
    private static final zzxr zza;
    private static final zzoa<zzer, zzos> zzb = zzoa.zza(zzhh.zza, zzer.class, zzos.class);
    private static final zznw<zzos> zzc;
    private static final zzmx<zzek, zzot> zzd = zzmx.zza(zzhj.zza, zzek.class, zzot.class);
    private static final zzmt<zzot> zze;

    /* access modifiers changed from: private */
    public static zzek zzb(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        if (zzot.zzf().equals(zzcx.zzb)) {
            try {
                zzst zza2 = zzst.zza(zzot.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzek.zzb().zza(zzer.zze().zzb(zza2.zzd().zzb()).zza(12).zzc(16).zza(zza(zzot.zzc())).zza()).zza(zzxt.zza(zza2.zzd().zzg(), zzct.zza(zzct))).zza(zzot.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj unused) {
                throw new GeneralSecurityException("Parsing AesGcmKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
    }

    private static zzer.zzb zza(zzvt zzvt) throws GeneralSecurityException {
        int i = zzhl.zza[zzvt.ordinal()];
        if (i == 1) {
            return zzer.zzb.zza;
        }
        if (i == 2 || i == 3) {
            return zzer.zzb.zzb;
        }
        if (i == 4) {
            return zzer.zzb.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzvt.zza());
    }

    /* access modifiers changed from: private */
    public static zzer zzb(zzos zzos) throws GeneralSecurityException {
        if (zzos.zza().zzf().equals(zzcx.zzb)) {
            try {
                zzsw zza2 = zzsw.zza(zzos.zza().zze(), zzaip.zza());
                if (zza2.zzb() == 0) {
                    return zzer.zze().zzb(zza2.zza()).zza(12).zzc(16).zza(zza(zzos.zza().zzd())).zza();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzajj e) {
                throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: " + zzos.zza().zzf());
        }
    }

    private static zzvt zza(zzer.zzb zzb2) throws GeneralSecurityException {
        if (zzer.zzb.zza.equals(zzb2)) {
            return zzvt.TINK;
        }
        if (zzer.zzb.zzb.equals(zzb2)) {
            return zzvt.CRUNCHY;
        }
        if (zzer.zzb.zzc.equals(zzb2)) {
            return zzvt.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzb2));
    }

    static {
        zzxr zzb2 = zzpg.zzb(zzcx.zzb);
        zza = zzb2;
        zzc = zznw.zza(zzhg.zza, zzb2, zzos.class);
        zze = zzmt.zza(zzhi.zza, zzb2, zzot.class);
    }

    public static void zza() throws GeneralSecurityException {
        zznv zza2 = zznv.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }

    /* access modifiers changed from: private */
    public static void zzb(zzer zzer) throws GeneralSecurityException {
        if (zzer.zzd() != 16) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports serialization of AES GCM keys with tag size equal to 16 bytes.", new Object[]{Integer.valueOf(zzer.zzd())}));
        } else if (zzer.zzb() != 12) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d. Currently Tink only supports serialization of AES GCM keys with IV size equal to 12 bytes.", new Object[]{Integer.valueOf(zzer.zzb())}));
        }
    }
}
