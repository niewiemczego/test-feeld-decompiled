package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzqi extends zzoi<zzcf, zzue> {
    public final /* synthetic */ Object zza(zzakk zzakk) throws GeneralSecurityException {
        zzue zzue = (zzue) zzakk;
        zzuc zzb = zzue.zze().zzb();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzue.zzf().zzg(), "HMAC");
        int zza = zzue.zze().zza();
        int i = zzqk.zza[zzb.ordinal()];
        if (i == 1) {
            return new zzxo(new zzxm("HMACSHA1", secretKeySpec), zza);
        }
        if (i == 2) {
            return new zzxo(new zzxm("HMACSHA224", secretKeySpec), zza);
        }
        if (i == 3) {
            return new zzxo(new zzxm("HMACSHA256", secretKeySpec), zza);
        }
        if (i == 4) {
            return new zzxo(new zzxm("HMACSHA384", secretKeySpec), zza);
        }
        if (i == 5) {
            return new zzxo(new zzxm("HMACSHA512", secretKeySpec), zza);
        }
        throw new GeneralSecurityException("unknown hash");
    }

    zzqi(Class cls) {
        super(cls);
    }
}
