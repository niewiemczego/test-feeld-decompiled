package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzic  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzic {
    private static final Logger zza = Logger.getLogger(zzic.class.getName());
    private static final AtomicBoolean zzb = new AtomicBoolean(false);

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzic$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public enum zza {
        ALGORITHM_NOT_FIPS((String) null),
        ALGORITHM_REQUIRES_BORINGCRYPTO((String) null);

        public abstract boolean zza();
    }

    static Boolean zza() {
        try {
            return (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zza.logp(Level.INFO, "com.google.crypto.tink.config.internal.TinkFipsUtil", "checkConscryptIsAvailableAndUsesFipsBoringSsl", "Conscrypt is not available or does not support checking for FIPS build.");
            return false;
        }
    }

    private zzic() {
    }

    public static boolean zzb() {
        return zzb.get();
    }
}
