package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzgj extends zzdc {
    private final String zza;
    private final zzb zzb;
    private final zzdc zzc;

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgj.class, this.zza, this.zzb, this.zzc});
    }

    public final boolean zza() {
        return false;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgj$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static class zza {
        @Nullable
        private String zza;
        @Nullable
        private zzb zzb;
        @Nullable
        private zzdc zzc;

        public final zza zza(zzdc zzdc) {
            this.zzc = zzdc;
            return this;
        }

        public final zza zza(zzb zzb2) {
            this.zzb = zzb2;
            return this;
        }

        public final zza zza(String str) {
            this.zza = str;
            return this;
        }

        public final zzgj zza() throws GeneralSecurityException {
            if (this.zza == null) {
                throw new GeneralSecurityException("kekUri must be set");
            } else if (this.zzb != null) {
                zzdc zzdc = this.zzc;
                if (zzdc == null) {
                    throw new GeneralSecurityException("dekParametersForNewKeys must be set");
                } else if (!zzdc.zza()) {
                    zzb zzb2 = this.zzb;
                    zzdc zzdc2 = this.zzc;
                    boolean z = true;
                    if ((!zzb2.equals(zzb.zza) || !(zzdc2 instanceof zzer)) && ((!zzb2.equals(zzb.zzc) || !(zzdc2 instanceof zzfo)) && ((!zzb2.equals(zzb.zzb) || !(zzdc2 instanceof zzhd)) && ((!zzb2.equals(zzb.zzd) || !(zzdc2 instanceof zzdm)) && ((!zzb2.equals(zzb.zze) || !(zzdc2 instanceof zzea)) && (!zzb2.equals(zzb.zzf) || !(zzdc2 instanceof zzfa))))))) {
                        z = false;
                    }
                    if (z) {
                        return new zzgj(this.zza, this.zzb, this.zzc);
                    }
                    String zzb3 = this.zzb.toString();
                    throw new GeneralSecurityException("Cannot use parsing strategy " + zzb3 + " when new keys are picked according to " + String.valueOf(this.zzc) + ".");
                } else {
                    throw new GeneralSecurityException("dekParametersForNewKeys must note have ID Requirements");
                }
            } else {
                throw new GeneralSecurityException("dekParsingStrategy must be set");
            }
        }

        private zza() {
        }
    }

    public final zzdc zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zza;
    }

    public final String toString() {
        String str = this.zza;
        String valueOf = String.valueOf(this.zzb);
        return "LegacyKmsEnvelopeAead Parameters (kekUri: " + str + ", dekParsingStrategy: " + valueOf + ", dekParametersForNewKeys: " + String.valueOf(this.zzc) + ")";
    }

    private zzgj(String str, zzb zzb2, zzdc zzdc) {
        this.zza = str;
        this.zzb = zzb2;
        this.zzc = zzdc;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgj$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zzb {
        public static final zzb zza = new zzb("ASSUME_AES_GCM");
        public static final zzb zzb = new zzb("ASSUME_XCHACHA20POLY1305");
        public static final zzb zzc = new zzb("ASSUME_CHACHA20POLY1305");
        public static final zzb zzd = new zzb("ASSUME_AES_CTR_HMAC");
        public static final zzb zze = new zzb("ASSUME_AES_EAX");
        public static final zzb zzf = new zzb("ASSUME_AES_GCM_SIV");
        private final String zzg;

        public final String toString() {
            return this.zzg;
        }

        private zzb(String str) {
            this.zzg = str;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgj)) {
            return false;
        }
        zzgj zzgj = (zzgj) obj;
        if (!zzgj.zzb.equals(this.zzb) || !zzgj.zzc.equals(this.zzc) || !zzgj.zza.equals(this.zza)) {
            return false;
        }
        return true;
    }
}
