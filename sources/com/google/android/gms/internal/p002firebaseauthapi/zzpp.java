package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzpp extends zzqs {
    private final int zza;
    private final int zzb;
    private final zzb zzc;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpp$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza {
        @Nullable
        private Integer zza;
        @Nullable
        private Integer zzb;
        private zzb zzc;

        public final zza zza(int i) throws GeneralSecurityException {
            if (i == 16 || i == 32) {
                this.zza = Integer.valueOf(i);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", new Object[]{Integer.valueOf(i << 3)}));
        }

        public final zza zzb(int i) throws GeneralSecurityException {
            if (i < 10 || 16 < i) {
                throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i);
            }
            this.zzb = Integer.valueOf(i);
            return this;
        }

        public final zza zza(zzb zzb2) {
            this.zzc = zzb2;
            return this;
        }

        public final zzpp zza() throws GeneralSecurityException {
            if (this.zza == null) {
                throw new GeneralSecurityException("key size not set");
            } else if (this.zzb == null) {
                throw new GeneralSecurityException("tag size not set");
            } else if (this.zzc != null) {
                return new zzpp(this.zza.intValue(), this.zzb.intValue(), this.zzc);
            } else {
                throw new GeneralSecurityException("variant not set");
            }
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = zzb.zzd;
        }
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    private final int zzf() {
        int i;
        if (this.zzc == zzb.zzd) {
            return this.zzb;
        }
        if (this.zzc == zzb.zza) {
            i = this.zzb;
        } else if (this.zzc == zzb.zzb) {
            i = this.zzb;
        } else if (this.zzc == zzb.zzc) {
            i = this.zzb;
        } else {
            throw new IllegalStateException("Unknown variant");
        }
        return i + 5;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpp$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zzb {
        public static final zzb zza = new zzb("TINK");
        public static final zzb zzb = new zzb("CRUNCHY");
        public static final zzb zzc = new zzb("LEGACY");
        public static final zzb zzd = new zzb("NO_PREFIX");
        private final String zze;

        public final String toString() {
            return this.zze;
        }

        private zzb(String str) {
            this.zze = str;
        }
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzpp.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc});
    }

    public static zza zzd() {
        return new zza();
    }

    public final zzb zze() {
        return this.zzc;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        int i = this.zzb;
        return "AES-CMAC Parameters (variant: " + valueOf + ", " + i + "-byte tags, and " + this.zza + "-byte key)";
    }

    private zzpp(int i, int i2, zzb zzb2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzb2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzpp)) {
            return false;
        }
        zzpp zzpp = (zzpp) obj;
        if (zzpp.zza == this.zza && zzpp.zzf() == zzf() && zzpp.zzc == this.zzc) {
            return true;
        }
        return false;
    }

    public final boolean zza() {
        return this.zzc != zzb.zzd;
    }
}
