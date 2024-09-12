package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfo;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzfl extends zzda {
    private final zzfo zza;
    private final zzxt zzb;
    private final zzxr zzc;
    @Nullable
    private final Integer zzd;

    public static zzfl zza(zzfo.zza zza2, zzxt zzxt, @Nullable Integer num) throws GeneralSecurityException {
        zzxr zzxr;
        if (zza2 != zzfo.zza.zzc && num == null) {
            throw new GeneralSecurityException("For given Variant " + String.valueOf(zza2) + " the value of idRequirement must be non-null");
        } else if (zza2 == zzfo.zza.zzc && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzxt.zza() == 32) {
            zzfo zza3 = zzfo.zza(zza2);
            if (zza3.zzb() == zzfo.zza.zzc) {
                zzxr = zzxr.zza(new byte[0]);
            } else if (zza3.zzb() == zzfo.zza.zzb) {
                zzxr = zzxr.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
            } else if (zza3.zzb() == zzfo.zza.zza) {
                zzxr = zzxr.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown Variant: " + String.valueOf(zza3.zzb()));
            }
            return new zzfl(zza3, zzxt, zzxr, num);
        } else {
            throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zzxt.zza());
        }
    }

    public final zzfo zzb() {
        return this.zza;
    }

    public final zzxr zzc() {
        return this.zzc;
    }

    public final zzxt zzd() {
        return this.zzb;
    }

    @Nullable
    public final Integer zza() {
        return this.zzd;
    }

    private zzfl(zzfo zzfo, zzxt zzxt, zzxr zzxr, @Nullable Integer num) {
        this.zza = zzfo;
        this.zzb = zzxt;
        this.zzc = zzxr;
        this.zzd = num;
    }
}
