package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqm;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzqb extends zzqp {
    private final zzqm zza;
    private final zzxt zzb;
    private final zzxr zzc;
    @Nullable
    private final Integer zzd;

    public static zza zzb() {
        return new zza();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqb$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static class zza {
        @Nullable
        private zzqm zza;
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

        public final zza zza(zzqm zzqm) {
            this.zza = zzqm;
            return this;
        }

        public final zzqb zza() throws GeneralSecurityException {
            zzxr zza2;
            zzqm zzqm = this.zza;
            if (zzqm == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            } else if (zzqm.zzc() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            } else if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzc == null) {
                if (this.zza.zzf() == zzqm.zzc.zzd) {
                    zza2 = zzxr.zza(new byte[0]);
                } else if (this.zza.zzf() == zzqm.zzc.zzc || this.zza.zzf() == zzqm.zzc.zzb) {
                    zza2 = zzxr.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
                } else if (this.zza.zzf() == zzqm.zzc.zza) {
                    zza2 = zzxr.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
                } else {
                    throw new IllegalStateException("Unknown HmacParameters.Variant: " + String.valueOf(this.zza.zzf()));
                }
                return new zzqb(this.zza, this.zzb, zza2, this.zzc);
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

    public final /* synthetic */ zzqs zzc() {
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

    private zzqb(zzqm zzqm, zzxt zzxt, zzxr zzxr, @Nullable Integer num) {
        this.zza = zzqm;
        this.zzb = zzxt;
        this.zzc = zzxr;
        this.zzd = num;
    }
}
