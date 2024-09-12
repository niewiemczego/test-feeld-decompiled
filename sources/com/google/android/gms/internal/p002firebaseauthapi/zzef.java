package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzea;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzef  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzef {
    private static final zzxr zza;
    private static final zzoa<zzea, zzos> zzb = zzoa.zza(zzee.zza, zzea.class, zzos.class);
    private static final zznw<zzos> zzc;
    private static final zzmx<zzdv, zzot> zzd = zzmx.zza(zzeg.zza, zzdv.class, zzot.class);
    private static final zzmt<zzot> zze;

    /* access modifiers changed from: private */
    public static zzdv zzb(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        if (zzot.zzf().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzso zza2 = zzso.zza(zzot.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzdv.zzb().zza(zzea.zze().zzb(zza2.zze().zzb()).zza(zza2.zzd().zza()).zzc(16).zza(zza(zzot.zzc())).zza()).zza(zzxt.zza(zza2.zze().zzg(), zzct.zza(zzct))).zza(zzot.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj unused) {
                throw new GeneralSecurityException("Parsing AesEaxcKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
    }

    private static zzea.zzb zza(zzvt zzvt) throws GeneralSecurityException {
        int i = zzei.zza[zzvt.ordinal()];
        if (i == 1) {
            return zzea.zzb.zza;
        }
        if (i == 2 || i == 3) {
            return zzea.zzb.zzb;
        }
        if (i == 4) {
            return zzea.zzb.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzvt.zza());
    }

    /* access modifiers changed from: private */
    public static zzea zzb(zzos zzos) throws GeneralSecurityException {
        if (zzos.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzsp zza2 = zzsp.zza(zzos.zza().zze(), zzaip.zza());
                return zzea.zze().zzb(zza2.zza()).zza(zza2.zzd().zza()).zzc(16).zza(zza(zzos.zza().zzd())).zza();
            } catch (zzajj e) {
                throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: " + zzos.zza().zzf());
        }
    }

    private static zzss zzb(zzea zzea) throws GeneralSecurityException {
        if (zzea.zzd() == 16) {
            return (zzss) ((zzaja) zzss.zzb().zza(zzea.zzb()).zzf());
        }
        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports aes eax keys with tag size equal to 16 bytes.", new Object[]{Integer.valueOf(zzea.zzd())}));
    }

    private static zzvt zza(zzea.zzb zzb2) throws GeneralSecurityException {
        if (zzea.zzb.zza.equals(zzb2)) {
            return zzvt.TINK;
        }
        if (zzea.zzb.zzb.equals(zzb2)) {
            return zzvt.CRUNCHY;
        }
        if (zzea.zzb.zzc.equals(zzb2)) {
            return zzvt.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzb2));
    }

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zza = zzb2;
        zzc = zznw.zza(zzeh.zza, zzb2, zzos.class);
        zze = zzmt.zza(zzej.zza, zzb2, zzot.class);
    }

    public static void zza() throws GeneralSecurityException {
        zznv zza2 = zznv.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
