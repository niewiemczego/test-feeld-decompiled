package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.Provider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzwu<JcePrimitiveT> implements zzxa<JcePrimitiveT> {
    private final zzwz<JcePrimitiveT> zza;

    public final JcePrimitiveT zza(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider zza2 : zzwr.zza(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL")) {
            try {
                return this.zza.zza(str, zza2);
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        return this.zza.zza(str, (Provider) null);
    }

    private zzwu(zzwz<JcePrimitiveT> zzwz) {
        this.zza = zzwz;
    }
}
