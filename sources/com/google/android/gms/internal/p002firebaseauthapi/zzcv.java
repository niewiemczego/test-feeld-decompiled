package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzcv {
    public static zzci zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzvd zza = zzvd.zza(bArr, zzaip.zza());
            zznv zza2 = zznv.zza();
            zzos zza3 = zzos.zza(zza);
            if (!zza2.zzb(zza3)) {
                return new zzne(zza3);
            }
            return zza2.zza(zza3);
        } catch (IOException e) {
            throw new GeneralSecurityException("Failed to parse proto", e);
        }
    }

    public static byte[] zza(zzci zzci) throws GeneralSecurityException {
        if (zzci instanceof zzne) {
            return ((zzne) zzci).zzb().zza().zzj();
        }
        return ((zzos) zznv.zza().zza(zzci, zzos.class)).zza().zzj();
    }
}
