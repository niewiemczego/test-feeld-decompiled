package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzjx extends zzkp {
    private final zzd zza;
    private final zze zzb;
    private final zza zzc;
    private final zzf zzd;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjx$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    private static class zzb {
        private final String zza;
        private final int zzb;

        public String toString() {
            return String.format("%s(0x%04x)", new Object[]{this.zza, Integer.valueOf(this.zzb)});
        }

        private zzb(String str, int i) {
            this.zza = str;
            this.zzb = i;
        }
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzjx.class, this.zza, this.zzb, this.zzc, this.zzd});
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjx$zzc */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zzc {
        private zzd zza;
        private zze zzb;
        private zza zzc;
        private zzf zzd;

        public final zzc zza(zza zza2) {
            this.zzc = zza2;
            return this;
        }

        public final zzc zza(zze zze) {
            this.zzb = zze;
            return this;
        }

        public final zzc zza(zzd zzd2) {
            this.zza = zzd2;
            return this;
        }

        public final zzc zza(zzf zzf) {
            this.zzd = zzf;
            return this;
        }

        public final zzjx zza() throws GeneralSecurityException {
            if (this.zza == null) {
                throw new GeneralSecurityException("HPKE KEM parameter is not set");
            } else if (this.zzb == null) {
                throw new GeneralSecurityException("HPKE KDF parameter is not set");
            } else if (this.zzc == null) {
                throw new GeneralSecurityException("HPKE AEAD parameter is not set");
            } else if (this.zzd != null) {
                return new zzjx(this.zza, this.zzb, this.zzc, this.zzd);
            } else {
                throw new GeneralSecurityException("HPKE variant is not set");
            }
        }

        private zzc() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = zzf.zzc;
        }
    }

    public final zza zzb() {
        return this.zzc;
    }

    public static zzc zzc() {
        return new zzc();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjx$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzb {
        public static final zza zza = new zza("AES_128_GCM", 1);
        public static final zza zzb = new zza("AES_256_GCM", 2);
        public static final zza zzc = new zza("CHACHA20_POLY1305", 3);

        public final /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        private zza(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjx$zze */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zze extends zzb {
        public static final zze zza = new zze("HKDF_SHA256", 1);
        public static final zze zzb = new zze("HKDF_SHA384", 2);
        public static final zze zzc = new zze("HKDF_SHA512", 3);

        public final /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        private zze(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjx$zzf */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zzf {
        public static final zzf zza = new zzf("TINK");
        public static final zzf zzb = new zzf("CRUNCHY");
        public static final zzf zzc = new zzf("NO_PREFIX");
        private final String zzd;

        public final String toString() {
            return this.zzd;
        }

        private zzf(String str) {
            this.zzd = str;
        }
    }

    public final zze zzd() {
        return this.zzb;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjx$zzd */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zzd extends zzb {
        public static final zzd zza = new zzd("DHKEM_P256_HKDF_SHA256", 16);
        public static final zzd zzb = new zzd("DHKEM_P384_HKDF_SHA384", 17);
        public static final zzd zzc = new zzd("DHKEM_P521_HKDF_SHA512", 18);
        public static final zzd zzd = new zzd("DHKEM_X25519_HKDF_SHA256", 32);

        public final /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        private zzd(String str, int i) {
            super(str, i);
        }
    }

    public final zzd zze() {
        return this.zza;
    }

    public final zzf zzf() {
        return this.zzd;
    }

    private zzjx(zzd zzd2, zze zze2, zza zza2, zzf zzf2) {
        this.zza = zzd2;
        this.zzb = zze2;
        this.zzc = zza2;
        this.zzd = zzf2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjx)) {
            return false;
        }
        zzjx zzjx = (zzjx) obj;
        if (this.zza == zzjx.zza && this.zzb == zzjx.zzb && this.zzc == zzjx.zzc && this.zzd == zzjx.zzd) {
            return true;
        }
        return false;
    }

    public final boolean zza() {
        return this.zzd != zzf.zzc;
    }
}
