package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzer  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzer extends zzdc {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final zzb zzd;

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzer$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza {
        @Nullable
        private Integer zza;
        @Nullable
        private Integer zzb;
        @Nullable
        private Integer zzc;
        private zzb zzd;

        public final zza zza(int i) throws GeneralSecurityException {
            this.zzb = 12;
            return this;
        }

        public final zza zzb(int i) throws GeneralSecurityException {
            if (i == 16 || i == 24 || i == 32) {
                this.zza = Integer.valueOf(i);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i)}));
        }

        public final zza zzc(int i) throws GeneralSecurityException {
            this.zzc = 16;
            return this;
        }

        public final zza zza(zzb zzb2) {
            this.zzd = zzb2;
            return this;
        }

        public final zzer zza() throws GeneralSecurityException {
            if (this.zza == null) {
                throw new GeneralSecurityException("Key size is not set");
            } else if (this.zzd == null) {
                throw new GeneralSecurityException("Variant is not set");
            } else if (this.zzb == null) {
                throw new GeneralSecurityException("IV size is not set");
            } else if (this.zzc != null) {
                return new zzer(this.zza.intValue(), this.zzb.intValue(), this.zzc.intValue(), this.zzd);
            } else {
                throw new GeneralSecurityException("Tag size is not set");
            }
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = zzb.zzc;
        }
    }

    public final int zzd() {
        return this.zzc;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzer$zzb */
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

    public final int hashCode() {
        return Objects.hash(new Object[]{zzer.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd});
    }

    public static zza zze() {
        return new zza();
    }

    public final zzb zzf() {
        return this.zzd;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        int i = this.zzb;
        int i2 = this.zzc;
        return "AesGcm Parameters (variant: " + valueOf + ", " + i + "-byte IV, " + i2 + "-byte tag, and " + this.zza + "-byte key)";
    }

    private zzer(int i, int i2, int i3, zzb zzb2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = zzb2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzer)) {
            return false;
        }
        zzer zzer = (zzer) obj;
        if (zzer.zza == this.zza && zzer.zzb == this.zzb && zzer.zzc == this.zzc && zzer.zzd == this.zzd) {
            return true;
        }
        return false;
    }

    public final boolean zza() {
        return this.zzd != zzb.zzc;
    }
}
