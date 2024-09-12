package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzhd;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzhu {
    private static final zzxr zza;
    private static final zzoa<zzhd, zzos> zzb = zzoa.zza(zzhx.zza, zzhd.class, zzos.class);
    private static final zznw<zzos> zzc;
    private static final zzmx<zzha, zzot> zzd = zzmx.zza(zzhz.zza, zzha.class, zzot.class);
    private static final zzmt<zzot> zze;

    /* access modifiers changed from: private */
    public static zzha zzb(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        if (zzot.zzf().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                zzvw zza2 = zzvw.zza(zzot.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzha.zza(zza(zzot.zzc()), zzxt.zza(zza2.zzd().zzg(), zzct.zza(zzct)), zzot.zze());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj unused) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
    }

    private static zzhd.zza zza(zzvt zzvt) throws GeneralSecurityException {
        int i = zzib.zza[zzvt.ordinal()];
        if (i == 1) {
            return zzhd.zza.zza;
        }
        if (i == 2 || i == 3) {
            return zzhd.zza.zzb;
        }
        if (i == 4) {
            return zzhd.zza.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzvt.zza());
    }

    /* access modifiers changed from: private */
    public static zzhd zzb(zzos zzos) throws GeneralSecurityException {
        if (zzos.zza().zzf().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                if (zzvz.zza(zzos.zza().zze(), zzaip.zza()).zza() == 0) {
                    return zzhd.zza(zza(zzos.zza().zzd()));
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzajj e) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: " + zzos.zza().zzf());
        }
    }

    private static zzvt zza(zzhd.zza zza2) throws GeneralSecurityException {
        if (zzhd.zza.zza.equals(zza2)) {
            return zzvt.TINK;
        }
        if (zzhd.zza.zzb.equals(zza2)) {
            return zzvt.CRUNCHY;
        }
        if (zzhd.zza.zzc.equals(zza2)) {
            return zzvt.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zza2));
    }

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza = zzb2;
        zzc = zznw.zza(zzhw.zza, zzb2, zzos.class);
        zze = zzmt.zza(zzhy.zza, zzb2, zzot.class);
    }

    public static void zza() throws GeneralSecurityException {
        zznv zza2 = zznv.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
