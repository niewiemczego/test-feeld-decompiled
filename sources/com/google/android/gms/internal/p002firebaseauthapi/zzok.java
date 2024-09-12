package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzok  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzok {
    /* access modifiers changed from: private */
    public final Map<zzom, zzoe<?, ?>> zza;
    /* access modifiers changed from: private */
    public final Map<Class<?>, zzcq<?, ?>> zzb;

    public final <KeyT extends zzbu, PrimitiveT> zzok zza(zzoe<KeyT, PrimitiveT> zzoe) throws GeneralSecurityException {
        if (zzoe != null) {
            zzom zzom = new zzom(zzoe.zza(), zzoe.zzb());
            if (this.zza.containsKey(zzom)) {
                zzoe zzoe2 = this.zza.get(zzom);
                if (!zzoe2.equals(zzoe) || !zzoe.equals(zzoe2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: " + String.valueOf(zzom));
                }
            } else {
                this.zza.put(zzom, zzoe);
            }
            return this;
        }
        throw new NullPointerException("primitive constructor must be non-null");
    }

    public final <InputPrimitiveT, WrapperPrimitiveT> zzok zza(zzcq<InputPrimitiveT, WrapperPrimitiveT> zzcq) throws GeneralSecurityException {
        if (zzcq != null) {
            Class<WrapperPrimitiveT> zzb2 = zzcq.zzb();
            if (this.zzb.containsKey(zzb2)) {
                zzcq zzcq2 = this.zzb.get(zzb2);
                if (!zzcq2.equals(zzcq) || !zzcq.equals(zzcq2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type" + String.valueOf(zzb2));
                }
            } else {
                this.zzb.put(zzb2, zzcq);
            }
            return this;
        }
        throw new NullPointerException("wrapper must be non-null");
    }

    public final zzol zza() {
        return new zzol(this);
    }

    private zzok() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    private zzok(zzol zzol) {
        this.zza = new HashMap(zzol.zza);
        this.zzb = new HashMap(zzol.zzb);
    }
}
