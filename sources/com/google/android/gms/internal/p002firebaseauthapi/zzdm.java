package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzdm extends zzdc {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzc zze;
    private final zzb zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdm$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza {
        @Nullable
        private Integer zza;
        @Nullable
        private Integer zzb;
        @Nullable
        private Integer zzc;
        @Nullable
        private Integer zzd;
        private zzb zze;
        private zzc zzf;

        public final zza zza(int i) throws GeneralSecurityException {
            if (i == 16 || i == 24 || i == 32) {
                this.zza = Integer.valueOf(i);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i)}));
        }

        public final zza zza(zzb zzb2) {
            this.zze = zzb2;
            return this;
        }

        public final zza zzb(int i) throws GeneralSecurityException {
            if (i >= 16) {
                this.zzb = Integer.valueOf(i);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; HMAC key must be at least 16 bytes", new Object[]{Integer.valueOf(i)}));
        }

        public final zza zzc(int i) throws GeneralSecurityException {
            if (i < 12 || i > 16) {
                throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; IV size must be between 12 and 16 bytes", new Object[]{Integer.valueOf(i)}));
            }
            this.zzc = Integer.valueOf(i);
            return this;
        }

        public final zza zzd(int i) throws GeneralSecurityException {
            if (i >= 10) {
                this.zzd = Integer.valueOf(i);
                return this;
            }
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", new Object[]{Integer.valueOf(i)}));
        }

        public final zza zza(zzc zzc2) {
            this.zzf = zzc2;
            return this;
        }

        public final zzdm zza() throws GeneralSecurityException {
            if (this.zza == null) {
                throw new GeneralSecurityException("AES key size is not set");
            } else if (this.zzb == null) {
                throw new GeneralSecurityException("HMAC key size is not set");
            } else if (this.zzc != null) {
                Integer num = this.zzd;
                if (num == null) {
                    throw new GeneralSecurityException("tag size is not set");
                } else if (this.zze == null) {
                    throw new GeneralSecurityException("hash type is not set");
                } else if (this.zzf != null) {
                    int intValue = num.intValue();
                    zzb zzb2 = this.zze;
                    if (zzb2 == zzb.zza) {
                        if (intValue > 20) {
                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", new Object[]{Integer.valueOf(intValue)}));
                        }
                    } else if (zzb2 == zzb.zzb) {
                        if (intValue > 28) {
                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", new Object[]{Integer.valueOf(intValue)}));
                        }
                    } else if (zzb2 == zzb.zzc) {
                        if (intValue > 32) {
                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", new Object[]{Integer.valueOf(intValue)}));
                        }
                    } else if (zzb2 == zzb.zzd) {
                        if (intValue > 48) {
                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", new Object[]{Integer.valueOf(intValue)}));
                        }
                    } else if (zzb2 != zzb.zze) {
                        throw new GeneralSecurityException("unknown hash type; must be SHA1, SHA224, SHA256, SHA384 or SHA512");
                    } else if (intValue > 64) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", new Object[]{Integer.valueOf(intValue)}));
                    }
                    return new zzdm(this.zza.intValue(), this.zzb.intValue(), this.zzc.intValue(), this.zzd.intValue(), this.zzf, this.zze);
                } else {
                    throw new GeneralSecurityException("variant is not set");
                }
            } else {
                throw new GeneralSecurityException("iv size is not set");
            }
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzf = zzc.zzc;
        }
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzc;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdm$zzc */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zzc {
        public static final zzc zza = new zzc("TINK");
        public static final zzc zzb = new zzc("CRUNCHY");
        public static final zzc zzc = new zzc("NO_PREFIX");
        private final String zzd;

        public final String toString() {
            return this.zzd;
        }

        private zzc(String str) {
            this.zzd = str;
        }
    }

    public final int zze() {
        return this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzdm.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf});
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdm$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zzb {
        public static final zzb zza = new zzb("SHA1");
        public static final zzb zzb = new zzb("SHA224");
        public static final zzb zzc = new zzb("SHA256");
        public static final zzb zzd = new zzb("SHA384");
        public static final zzb zze = new zzb("SHA512");
        private final String zzf;

        public final String toString() {
            return this.zzf;
        }

        private zzb(String str) {
            this.zzf = str;
        }
    }

    public static zza zzf() {
        return new zza();
    }

    public final zzb zzg() {
        return this.zzf;
    }

    public final zzc zzh() {
        return this.zze;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zze);
        String valueOf2 = String.valueOf(this.zzf);
        int i = this.zzc;
        int i2 = this.zzd;
        int i3 = this.zza;
        return "AesCtrHmacAead Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + i + "-byte IV, and " + i2 + "-byte tags, and " + i3 + "-byte AES key, and " + this.zzb + "-byte HMAC key)";
    }

    private zzdm(int i, int i2, int i3, int i4, zzc zzc2, zzb zzb2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = zzc2;
        this.zzf = zzb2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdm)) {
            return false;
        }
        zzdm zzdm = (zzdm) obj;
        if (zzdm.zza == this.zza && zzdm.zzb == this.zzb && zzdm.zzc == this.zzc && zzdm.zzd == this.zzd && zzdm.zze == this.zze && zzdm.zzf == this.zzf) {
            return true;
        }
        return false;
    }

    public final boolean zza() {
        return this.zze != zzc.zzc;
    }
}
