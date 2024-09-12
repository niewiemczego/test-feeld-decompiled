package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzqm extends zzqs {
    private final int zza;
    private final int zzb;
    private final zzc zzc;
    private final zzb zzd;

    public final int zzb() {
        return this.zzb;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqm$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza {
        @Nullable
        private Integer zza;
        @Nullable
        private Integer zzb;
        private zzb zzc;
        private zzc zzd;

        public final zza zza(zzb zzb2) {
            this.zzc = zzb2;
            return this;
        }

        public final zza zza(int i) throws GeneralSecurityException {
            this.zza = Integer.valueOf(i);
            return this;
        }

        public final zza zzb(int i) throws GeneralSecurityException {
            this.zzb = Integer.valueOf(i);
            return this;
        }

        public final zza zza(zzc zzc2) {
            this.zzd = zzc2;
            return this;
        }

        public final zzqm zza() throws GeneralSecurityException {
            Integer num = this.zza;
            if (num == null) {
                throw new GeneralSecurityException("key size is not set");
            } else if (this.zzb == null) {
                throw new GeneralSecurityException("tag size is not set");
            } else if (this.zzc == null) {
                throw new GeneralSecurityException("hash type is not set");
            } else if (this.zzd == null) {
                throw new GeneralSecurityException("variant is not set");
            } else if (num.intValue() >= 16) {
                int intValue = this.zzb.intValue();
                zzb zzb2 = this.zzc;
                if (intValue >= 10) {
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
                        throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
                    } else if (intValue > 64) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", new Object[]{Integer.valueOf(intValue)}));
                    }
                    return new zzqm(this.zza.intValue(), this.zzb.intValue(), this.zzd, this.zzc);
                }
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", new Object[]{Integer.valueOf(intValue)}));
            } else {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", new Object[]{this.zza}));
            }
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = zzc.zzd;
        }
    }

    public final int zzc() {
        return this.zza;
    }

    private final int zzg() {
        int i;
        if (this.zzc == zzc.zzd) {
            return this.zzb;
        }
        if (this.zzc == zzc.zza) {
            i = this.zzb;
        } else if (this.zzc == zzc.zzb) {
            i = this.zzb;
        } else if (this.zzc == zzc.zzc) {
            i = this.zzb;
        } else {
            throw new IllegalStateException("Unknown variant");
        }
        return i + 5;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqm$zzc */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zzc {
        public static final zzc zza = new zzc("TINK");
        public static final zzc zzb = new zzc("CRUNCHY");
        public static final zzc zzc = new zzc("LEGACY");
        public static final zzc zzd = new zzc("NO_PREFIX");
        private final String zze;

        public final String toString() {
            return this.zze;
        }

        private zzc(String str) {
            this.zze = str;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqm$zzb */
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

    public final int hashCode() {
        return Objects.hash(new Object[]{zzqm.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public static zza zzd() {
        return new zza();
    }

    public final zzb zze() {
        return this.zzd;
    }

    public final zzc zzf() {
        return this.zzc;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(this.zzd);
        int i = this.zzb;
        return "HMAC Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + i + "-byte tags, and " + this.zza + "-byte key)";
    }

    private zzqm(int i, int i2, zzc zzc2, zzb zzb2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzc2;
        this.zzd = zzb2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzqm)) {
            return false;
        }
        zzqm zzqm = (zzqm) obj;
        if (zzqm.zza == this.zza && zzqm.zzg() == zzg() && zzqm.zzc == this.zzc && zzqm.zzd == this.zzd) {
            return true;
        }
        return false;
    }

    public final boolean zza() {
        return this.zzc != zzc.zzd;
    }
}
