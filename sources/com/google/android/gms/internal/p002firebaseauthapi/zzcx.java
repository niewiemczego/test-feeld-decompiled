package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzcx {
    public static final String zza = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    public static final String zzb = "type.googleapis.com/google.crypto.tink.AesGcmKey";
    private static final String zzc = "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    private static final String zzd = "type.googleapis.com/google.crypto.tink.AesEaxKey";
    private static final String zze = "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    private static final String zzf = "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    private static final String zzg = "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    private static final String zzh = "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    @Deprecated
    private static final zzvv zzi;
    @Deprecated
    private static final zzvv zzj;
    @Deprecated
    private static final zzvv zzk;

    static {
        zzvv zzb2 = zzvv.zzb();
        zzi = zzb2;
        zzj = zzb2;
        zzk = zzb2;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzdb.zzc();
        zzqq.zza();
        zzdj.zza(true);
        zzeo.zza(true);
        if (!zzic.zzb()) {
            zzdz.zza(true);
            zzew.zza(true);
            zzfk.zza(true);
            zzfw.zza(true);
            zzga.zza(true);
            zzgz.zza(true);
        }
    }
}
