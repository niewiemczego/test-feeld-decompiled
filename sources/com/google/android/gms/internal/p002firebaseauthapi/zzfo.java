package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzfo extends zzdc {
    private final zza zza;

    public final int hashCode() {
        return Objects.hash(new Object[]{zzfo.class, this.zza});
    }

    public final zza zzb() {
        return this.zza;
    }

    public static zzfo zza(zza zza2) {
        return new zzfo(zza2);
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfo$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza {
        public static final zza zza = new zza("TINK");
        public static final zza zzb = new zza("CRUNCHY");
        public static final zza zzc = new zza("NO_PREFIX");
        private final String zzd;

        public final String toString() {
            return this.zzd;
        }

        private zza(String str) {
            this.zzd = str;
        }
    }

    public final String toString() {
        return "ChaCha20Poly1305 Parameters (variant: " + String.valueOf(this.zza) + ")";
    }

    private zzfo(zza zza2) {
        this.zza = zza2;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof zzfo) && ((zzfo) obj).zza == this.zza) {
            return true;
        }
        return false;
    }

    public final boolean zza() {
        return this.zza != zza.zzc;
    }
}
