package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafe  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzafe {
    private List<zzafb> zza;

    public final List<zzafb> zza() {
        return this.zza;
    }

    public zzafe() {
        this.zza = new ArrayList();
    }

    public zzafe(List<zzafb> list) {
        this.zza = Collections.unmodifiableList(list);
    }
}
