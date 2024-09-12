package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import com.google.android.gms.internal.p002firebaseauthapi.zzvh;
import com.google.android.gms.internal.p002firebaseauthapi.zzvi;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzcy {
    private static final Charset zza = Charset.forName("UTF-8");

    public static zzvi zza(zzvh zzvh) {
        zzvi.zza zza2 = zzvi.zza().zza(zzvh.zzb());
        for (zzvh.zza next : zzvh.zze()) {
            zza2.zza((zzvi.zzb) ((zzaja) zzvi.zzb.zzb().zza(next.zzb().zzf()).zza(next.zzc()).zza(next.zzf()).zza(next.zza()).zzf()));
        }
        return (zzvi) ((zzaja) zza2.zzf());
    }

    public static void zzb(zzvh zzvh) throws GeneralSecurityException {
        int zzb = zzvh.zzb();
        boolean z = true;
        int i = 0;
        boolean z2 = false;
        for (zzvh.zza next : zzvh.zze()) {
            if (next.zzc() == zzvb.ENABLED) {
                if (!next.zzg()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(next.zza())}));
                } else if (next.zzf() == zzvt.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(next.zza())}));
                } else if (next.zzc() != zzvb.UNKNOWN_STATUS) {
                    if (next.zza() == zzb) {
                        if (!z2) {
                            z2 = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    if (next.zzb().zzb() != zzux.zzb.ASYMMETRIC_PUBLIC) {
                        z = false;
                    }
                    i++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(next.zza())}));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z2 && !z) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
