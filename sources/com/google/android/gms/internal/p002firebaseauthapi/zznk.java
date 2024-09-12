package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zznk {
    private static final zznk zza = new zznk();
    private final Map<Class<? extends zzci>, zznn<? extends zzci>> zzb = new HashMap();

    public final zzbu zza(zzci zzci, @Nullable Integer num) throws GeneralSecurityException {
        return zzb(zzci, (Integer) null);
    }

    private final synchronized <ParametersT extends zzci> zzbu zzb(ParametersT parameterst, @Nullable Integer num) throws GeneralSecurityException {
        zznn zznn;
        zznn = this.zzb.get(parameterst.getClass());
        if (zznn != null) {
        } else {
            throw new GeneralSecurityException("Cannot create a new key for parameters " + String.valueOf(parameterst) + ": no key creator for this class was registered.");
        }
        return zznn.zza(parameterst, (Integer) null);
    }

    public static zznk zza() {
        return zza;
    }

    public final synchronized <ParametersT extends zzci> void zza(zznn<ParametersT> zznn, Class<ParametersT> cls) throws GeneralSecurityException {
        zznn zznn2 = this.zzb.get(cls);
        if (zznn2 != null) {
            if (!zznn2.equals(zznn)) {
                throw new GeneralSecurityException("Different key creator for parameters class " + String.valueOf(cls) + " already inserted");
            }
        }
        this.zzb.put(cls, zznn);
    }
}
