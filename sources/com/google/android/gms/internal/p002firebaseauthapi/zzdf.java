package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdm;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzdf extends zzda {
    private final zzdm zza;
    private final zzxt zzb;
    private final zzxt zzc;
    private final zzxr zzd;
    @Nullable
    private final Integer zze;

    public static zza zzb() {
        return new zza();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdf$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static class zza {
        @Nullable
        private zzdm zza;
        @Nullable
        private zzxt zzb;
        @Nullable
        private zzxt zzc;
        @Nullable
        private Integer zzd;

        public final zza zza(zzxt zzxt) {
            this.zzb = zzxt;
            return this;
        }

        public final zza zzb(zzxt zzxt) {
            this.zzc = zzxt;
            return this;
        }

        public final zza zza(@Nullable Integer num) {
            this.zzd = num;
            return this;
        }

        public final zza zza(zzdm zzdm) {
            this.zza = zzdm;
            return this;
        }

        public final zzdf zza() throws GeneralSecurityException {
            zzxr zza2;
            zzdm zzdm = this.zza;
            if (zzdm == null) {
                throw new GeneralSecurityException("Cannot build without parameters");
            } else if (this.zzb == null || this.zzc == null) {
                throw new GeneralSecurityException("Cannot build without key material");
            } else if (zzdm.zzb() != this.zzb.zza()) {
                throw new GeneralSecurityException("AES key size mismatch");
            } else if (this.zza.zzc() != this.zzc.zza()) {
                throw new GeneralSecurityException("HMAC key size mismatch");
            } else if (this.zza.zza() && this.zzd == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzd == null) {
                if (this.zza.zzh() == zzdm.zzc.zzc) {
                    zza2 = zzxr.zza(new byte[0]);
                } else if (this.zza.zzh() == zzdm.zzc.zzb) {
                    zza2 = zzxr.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzd.intValue()).array());
                } else if (this.zza.zzh() == zzdm.zzc.zza) {
                    zza2 = zzxr.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzd.intValue()).array());
                } else {
                    throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: " + String.valueOf(this.zza.zzh()));
                }
                return new zzdf(this.zza, this.zzb, this.zzc, zza2, this.zzd);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
        }
    }

    public final zzdm zzc() {
        return this.zza;
    }

    public final zzxr zzd() {
        return this.zzd;
    }

    public final zzxt zze() {
        return this.zzb;
    }

    public final zzxt zzf() {
        return this.zzc;
    }

    @Nullable
    public final Integer zza() {
        return this.zze;
    }

    private zzdf(zzdm zzdm, zzxt zzxt, zzxt zzxt2, zzxr zzxr, @Nullable Integer num) {
        this.zza = zzdm;
        this.zzb = zzxt;
        this.zzc = zzxt2;
        this.zzd = zzxr;
        this.zze = num;
    }
}
