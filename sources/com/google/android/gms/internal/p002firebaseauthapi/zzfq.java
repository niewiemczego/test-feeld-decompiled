package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfo;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzfq {
    private static final zzxr zza;
    private static final zzoa<zzfo, zzos> zzb = zzoa.zza(zzfp.zza, zzfo.class, zzos.class);
    private static final zznw<zzos> zzc;
    private static final zzmx<zzfl, zzot> zzd = zzmx.zza(zzfr.zza, zzfl.class, zzot.class);
    private static final zzmt<zzot> zze;

    /* access modifiers changed from: private */
    public static zzfl zzb(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        if (zzot.zzf().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zztf zza2 = zztf.zza(zzot.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzfl.zza(zza(zzot.zzc()), zzxt.zza(zza2.zzd().zzg(), zzct.zza(zzct)), zzot.zze());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj unused) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
        }
    }

    private static zzfo.zza zza(zzvt zzvt) throws GeneralSecurityException {
        int i = zzft.zza[zzvt.ordinal()];
        if (i == 1) {
            return zzfo.zza.zza;
        }
        if (i == 2 || i == 3) {
            return zzfo.zza.zzb;
        }
        if (i == 4) {
            return zzfo.zza.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzvt.zza());
    }

    /* access modifiers changed from: private */
    public static zzfo zzb(zzos zzos) throws GeneralSecurityException {
        if (zzos.zza().zzf().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzti.zza(zzos.zza().zze(), zzaip.zza());
                return zzfo.zza(zza(zzos.zza().zzd()));
            } catch (zzajj e) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: " + zzos.zza().zzf());
        }
    }

    private static zzvt zza(zzfo.zza zza2) throws GeneralSecurityException {
        if (zzfo.zza.zza.equals(zza2)) {
            return zzvt.TINK;
        }
        if (zzfo.zza.zzb.equals(zza2)) {
            return zzvt.CRUNCHY;
        }
        if (zzfo.zza.zzc.equals(zza2)) {
            return zzvt.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zza2));
    }

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zza = zzb2;
        zzc = zznw.zza(zzfs.zza, zzb2, zzos.class);
        zze = zzmt.zza(zzfu.zza, zzb2, zzot.class);
    }

    public static void zza() throws GeneralSecurityException {
        zznv zza2 = zznv.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
