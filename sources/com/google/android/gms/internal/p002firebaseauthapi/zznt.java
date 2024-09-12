package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zznt {
    private static final zznt zza = new zznt();
    private final Map<String, zzci> zzb = new HashMap();

    public static zznt zza() {
        return zza;
    }

    zznt() {
    }

    private final synchronized void zza(String str, zzci zzci) throws GeneralSecurityException {
        if (!this.zzb.containsKey(str)) {
            this.zzb.put(str, zzci);
        } else if (!this.zzb.get(str).equals(zzci)) {
            String valueOf = String.valueOf(this.zzb.get(str));
            throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + valueOf + "), cannot insert " + String.valueOf(zzci));
        }
    }

    public final synchronized void zza(Map<String, zzci> map) throws GeneralSecurityException {
        for (Map.Entry next : map.entrySet()) {
            zza((String) next.getKey(), (zzci) next.getValue());
        }
    }
}
