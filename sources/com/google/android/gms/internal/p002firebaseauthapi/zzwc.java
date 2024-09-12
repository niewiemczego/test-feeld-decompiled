package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzwc extends ThreadLocal<Cipher> {
    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        return zza();
    }

    private static Cipher zza() {
        try {
            return zzwr.zza.zza("AES/CTR/NoPadding");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    zzwc() {
    }
}
