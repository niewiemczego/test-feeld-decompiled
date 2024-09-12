package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zznm {
    private static final zznm zza = new zznm();
    private final Map<Class<? extends zzci>, zznp<? extends zzci>> zzb = new HashMap();

    public static zznm zza() {
        return zza;
    }

    public final synchronized <ParametersT extends zzci> void zza(zznp<ParametersT> zznp, Class<ParametersT> cls) throws GeneralSecurityException {
        zznp zznp2 = this.zzb.get(cls);
        if (zznp2 != null) {
            if (!zznp2.equals(zznp)) {
                throw new GeneralSecurityException("Different key creator for parameters class already inserted");
            }
        }
        this.zzb.put(cls, zznp);
    }
}
