package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzfw {
    private static final zzoe<zzgb, zzbh> zza = zzoe.zza(zzfv.zza, zzgb.class, zzbh.class);
    private static final zzbt<zzbh> zzb = zznd.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", zzbh.class, zzux.zzb.REMOTE, zzvl.zze());
    private static final zznn<zzge> zzc = zzfy.zza;

    public static /* synthetic */ zzgb zza(zzge zzge, Integer num) {
        if (num == null) {
            return zzgb.zza(zzge);
        }
        throw new GeneralSecurityException("Id Requirement is not supported for LegacyKmsEnvelopeAeadKey");
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzgd.zza();
        zzns.zza().zza(zza);
        zznk.zza().zza(zzc, zzge.class);
        zzcu.zza(zzb, true);
    }
}
