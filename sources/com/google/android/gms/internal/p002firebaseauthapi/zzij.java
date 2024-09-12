package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziq;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzij  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzij extends zziv {
    private final zziq zza;
    private final zzxt zzb;
    private final zzxr zzc;
    @Nullable
    private final Integer zzd;

    public static zza zzb() {
        return new zza();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzij$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static class zza {
        @Nullable
        private zziq zza;
        @Nullable
        private zzxt zzb;
        @Nullable
        private Integer zzc;

        public final zza zza(@Nullable Integer num) {
            this.zzc = num;
            return this;
        }

        public final zza zza(zzxt zzxt) {
            this.zzb = zzxt;
            return this;
        }

        public final zza zza(zziq zziq) {
            this.zza = zziq;
            return this;
        }

        public final zzij zza() throws GeneralSecurityException {
            zzxr zza2;
            zziq zziq = this.zza;
            if (zziq == null || this.zzb == null) {
                throw new IllegalArgumentException("Cannot build without parameters and/or key material");
            } else if (zziq.zzb() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            } else if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzc == null) {
                if (this.zza.zzd() == zziq.zzb.zzc) {
                    zza2 = zzxr.zza(new byte[0]);
                } else if (this.zza.zzd() == zziq.zzb.zzb) {
                    zza2 = zzxr.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
                } else if (this.zza.zzd() == zziq.zzb.zza) {
                    zza2 = zzxr.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
                } else {
                    throw new IllegalStateException("Unknown AesSivParameters.Variant: " + String.valueOf(this.zza.zzd()));
                }
                return new zzij(this.zza, this.zzb, zza2, this.zzc);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }
    }

    public final zziq zzc() {
        return this.zza;
    }

    public final zzxr zzd() {
        return this.zzc;
    }

    public final zzxt zze() {
        return this.zzb;
    }

    @Nullable
    public final Integer zza() {
        return this.zzd;
    }

    private zzij(zziq zziq, zzxt zzxt, zzxr zzxr, @Nullable Integer num) {
        this.zza = zziq;
        this.zzb = zzxt;
        this.zzc = zzxr;
        this.zzd = num;
    }
}
