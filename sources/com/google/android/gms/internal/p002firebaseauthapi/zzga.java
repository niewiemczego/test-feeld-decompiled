package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzga  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzga {
    private static final zzbt<zzbh> zza = zznd.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", zzbh.class, zzux.zzb.SYMMETRIC, zzvp.zze());
    private static final zznn<zzgj> zzb = zzfz.zza;
    private static final zzoe<zzgk, zzbh> zzc = zzoe.zza(zzgc.zza, zzgk.class, zzbh.class);

    /* access modifiers changed from: private */
    public static zzbh zzb(zzgk zzgk) throws GeneralSecurityException {
        try {
            zzvd zza2 = zzvd.zza(zzcv.zza((zzci) zzgk.zzb().zzb()), zzaip.zza());
            String zzc2 = zzgk.zzb().zzc();
            return new zzfx(zza2, zzcg.zza(zzc2).zza(zzc2));
        } catch (zzajj e) {
            throw new GeneralSecurityException("Parsing of DEK key template failed: ", e);
        }
    }

    public static /* synthetic */ zzgk zza(zzgj zzgj, Integer num) {
        if (num == null) {
            return zzgk.zza(zzgj);
        }
        throw new GeneralSecurityException("Id Requirement is not supported for LegacyKmsEnvelopeAeadKey");
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzgo.zza();
        zznk.zza().zza(zzb, zzgj.class);
        zzns.zza().zza(zzc);
        zzcu.zza(zza, true);
    }
}
