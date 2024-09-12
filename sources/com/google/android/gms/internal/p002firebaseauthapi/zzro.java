package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzro  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzro {
    private HashMap<String, String> zza = new HashMap<>();

    public final zzrl zza() {
        if (this.zza != null) {
            zzrl zzrl = new zzrl(Collections.unmodifiableMap(this.zza));
            this.zza = null;
            return zzrl;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
