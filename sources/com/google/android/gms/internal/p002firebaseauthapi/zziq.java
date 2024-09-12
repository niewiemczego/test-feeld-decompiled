package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zziq extends zziu {
    private final int zza;
    private final zzb zzb;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zziq$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza {
        @Nullable
        private Integer zza;
        private zzb zzb;

        public final zza zza(int i) throws GeneralSecurityException {
            if (i == 32 || i == 48 || i == 64) {
                this.zza = Integer.valueOf(i);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 32-byte, 48-byte and 64-byte AES-SIV keys are supported", new Object[]{Integer.valueOf(i)}));
        }

        public final zza zza(zzb zzb2) {
            this.zzb = zzb2;
            return this;
        }

        public final zziq zza() throws GeneralSecurityException {
            if (this.zza == null) {
                throw new GeneralSecurityException("Key size is not set");
            } else if (this.zzb != null) {
                return new zziq(this.zza.intValue(), this.zzb);
            } else {
                throw new GeneralSecurityException("Variant is not set");
            }
        }

        private zza() {
            this.zza = null;
            this.zzb = zzb.zzc;
        }
    }

    public final int zzb() {
        return this.zza;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zziq.class, Integer.valueOf(this.zza), this.zzb});
    }

    public static zza zzc() {
        return new zza();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zziq$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zzb {
        public static final zzb zza = new zzb("TINK");
        public static final zzb zzb = new zzb("CRUNCHY");
        public static final zzb zzc = new zzb("NO_PREFIX");
        private final String zzd;

        public final String toString() {
            return this.zzd;
        }

        private zzb(String str) {
            this.zzd = str;
        }
    }

    public final zzb zzd() {
        return this.zzb;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        return "AesSiv Parameters (variant: " + valueOf + ", " + this.zza + "-byte key)";
    }

    private zziq(int i, zzb zzb2) {
        this.zza = i;
        this.zzb = zzb2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zziq)) {
            return false;
        }
        zziq zziq = (zziq) obj;
        if (zziq.zza == this.zza && zziq.zzb == this.zzb) {
            return true;
        }
        return false;
    }

    public final boolean zza() {
        return this.zzb != zzb.zzc;
    }
}
