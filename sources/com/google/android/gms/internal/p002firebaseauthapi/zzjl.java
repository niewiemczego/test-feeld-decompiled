package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdm;
import com.google.android.gms.internal.p002firebaseauthapi.zzer;
import com.google.android.gms.internal.p002firebaseauthapi.zziq;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzjl extends zzkp {
    /* access modifiers changed from: private */
    public static final Set<zzci> zza = ((Set) zzpe.zza(zzjk.zza));
    private final zzc zzb;
    private final zzb zzc;
    @Nullable
    private final zze zzd;
    private final zzd zze;
    private final zzci zzf;
    @Nullable
    private final zzxr zzg;

    public final int hashCode() {
        return Objects.hash(new Object[]{zzjl.class, this.zzb, this.zzc, this.zzd, this.zzf, this.zze, this.zzg});
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjl$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza {
        private zzc zza;
        private zzb zzb;
        private zze zzc;
        private zzci zzd;
        private zzd zze;
        @Nullable
        private zzxr zzf;

        public final zza zza(zzc zzc2) {
            this.zza = zzc2;
            return this;
        }

        public final zza zza(zzci zzci) throws GeneralSecurityException {
            if (zzjl.zza.contains(zzci)) {
                this.zzd = zzci;
                return this;
            }
            throw new GeneralSecurityException("Invalid DEM parameters " + String.valueOf(zzci) + "; only AES128_GCM_RAW, AES256_GCM_RAW, AES128_CTR_HMAC_SHA256_RAW, AES256_CTR_HMAC_SHA256_RAW XCHACHA20_POLY1305_RAW and AES256_SIV_RAW are currently supported.");
        }

        public final zza zza(zzb zzb2) {
            this.zzb = zzb2;
            return this;
        }

        public final zza zza(zze zze2) {
            this.zzc = zze2;
            return this;
        }

        public final zza zza(zzxr zzxr) {
            if (zzxr.zza() == 0) {
                this.zzf = null;
                return this;
            }
            this.zzf = zzxr;
            return this;
        }

        public final zza zza(zzd zzd2) {
            this.zze = zzd2;
            return this;
        }

        public final zzjl zza() throws GeneralSecurityException {
            zzc zzc2 = this.zza;
            if (zzc2 == null) {
                throw new GeneralSecurityException("Elliptic curve type is not set");
            } else if (this.zzb == null) {
                throw new GeneralSecurityException("Hash type is not set");
            } else if (this.zzd == null) {
                throw new GeneralSecurityException("DEM parameters are not set");
            } else if (this.zze == null) {
                throw new GeneralSecurityException("Variant is not set");
            } else if (zzc2 != zzc.zzd && this.zzc == null) {
                throw new GeneralSecurityException("Point format is not set");
            } else if (this.zza != zzc.zzd || this.zzc == null) {
                return new zzjl(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
            } else {
                throw new GeneralSecurityException("For Curve25519 point format must not be set");
            }
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = zzd.zzc;
            this.zzf = null;
        }
    }

    public final zzci zzb() {
        return this.zzf;
    }

    public static zza zzc() {
        return new zza();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjl$zzd */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zzd {
        public static final zzd zza = new zzd("TINK");
        public static final zzd zzb = new zzd("CRUNCHY");
        public static final zzd zzc = new zzd("NO_PREFIX");
        private final String zzd;

        public final String toString() {
            return this.zzd;
        }

        private zzd(String str) {
            this.zzd = str;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjl$zze */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zze {
        public static final zze zza = new zze("COMPRESSED");
        public static final zze zzb = new zze("UNCOMPRESSED");
        public static final zze zzc = new zze("LEGACY_UNCOMPRESSED");
        private final String zzd;

        public final String toString() {
            return this.zzd;
        }

        private zze(String str) {
            this.zzd = str;
        }
    }

    public final zzc zzd() {
        return this.zzb;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjl$zzc */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zzc {
        public static final zzc zza = new zzc("NIST_P256");
        public static final zzc zzb = new zzc("NIST_P384");
        public static final zzc zzc = new zzc("NIST_P521");
        public static final zzc zzd = new zzc("X25519");
        private final String zze;

        public final String toString() {
            return this.zze;
        }

        private zzc(String str) {
            this.zze = str;
        }
    }

    public final zzb zze() {
        return this.zzc;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjl$zzb */
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

    @Nullable
    public final zze zzf() {
        return this.zzd;
    }

    public final zzd zzg() {
        return this.zze;
    }

    @Nullable
    public final zzxr zzh() {
        return this.zzg;
    }

    public final String toString() {
        return String.format("EciesParameters(curveType=%s, hashType=%s, pointFormat=%s, demParameters=%s, variant=%s, salt=%s)", new Object[]{this.zzb, this.zzc, this.zzd, this.zzf, this.zze, this.zzg});
    }

    static /* synthetic */ Set zzj() throws Exception {
        HashSet hashSet = new HashSet();
        hashSet.add(zzer.zze().zza(12).zzb(16).zzc(16).zza(zzer.zzb.zzc).zza());
        hashSet.add(zzer.zze().zza(12).zzb(32).zzc(16).zza(zzer.zzb.zzc).zza());
        hashSet.add(zzdm.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdm.zzb.zzc).zza(zzdm.zzc.zzc).zza());
        hashSet.add(zzdm.zzf().zza(32).zzb(32).zzd(32).zzc(16).zza(zzdm.zzb.zzc).zza(zzdm.zzc.zzc).zza());
        hashSet.add(zzhd.zzc());
        hashSet.add(zziq.zzc().zza(64).zza(zziq.zzb.zzc).zza());
        return Collections.unmodifiableSet(hashSet);
    }

    private zzjl(zzc zzc2, zzb zzb2, @Nullable zze zze2, zzci zzci, zzd zzd2, zzxr zzxr) {
        this.zzb = zzc2;
        this.zzc = zzb2;
        this.zzd = zze2;
        this.zzf = zzci;
        this.zze = zzd2;
        this.zzg = zzxr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjl)) {
            return false;
        }
        zzjl zzjl = (zzjl) obj;
        if (!Objects.equals(zzjl.zzb, this.zzb) || !Objects.equals(zzjl.zzc, this.zzc) || !Objects.equals(zzjl.zzd, this.zzd) || !Objects.equals(zzjl.zzf, this.zzf) || !Objects.equals(zzjl.zze, this.zze) || !Objects.equals(zzjl.zzg, this.zzg)) {
            return false;
        }
        return true;
    }

    public final boolean zza() {
        return this.zze != zzd.zzc;
    }
}
