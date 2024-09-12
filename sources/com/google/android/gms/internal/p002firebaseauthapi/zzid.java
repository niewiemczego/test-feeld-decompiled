package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzid  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzid extends ThreadLocal<Cipher> {
    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        return zza();
    }

    private static Cipher zza() {
        try {
            Cipher zza = zzwr.zza.zza("AES/GCM-SIV/NoPadding");
            if (!zzia.zzb(zza)) {
                return null;
            }
            return zza;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    zzid() {
    }
}
