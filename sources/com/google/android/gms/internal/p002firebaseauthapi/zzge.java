package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzge  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzge extends zzdc {
    private final String zza;

    public final int hashCode() {
        return Objects.hash(new Object[]{zzge.class, this.zza});
    }

    public final boolean zza() {
        return false;
    }

    public static zzge zza(String str) throws GeneralSecurityException {
        return new zzge(str);
    }

    public final String zzb() {
        return this.zza;
    }

    public final String toString() {
        return "LegacyKmsAead Parameters (keyUri: " + this.zza + ")";
    }

    private zzge(String str) {
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzge)) {
            return false;
        }
        return ((zzge) obj).zza.equals(this.zza);
    }
}
