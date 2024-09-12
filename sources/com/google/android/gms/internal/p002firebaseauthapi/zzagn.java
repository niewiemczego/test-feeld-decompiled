package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzagn {
    private final int zza;
    private List<String> zzb;

    public static zzagn zza() {
        return new zzagn((List<String>) null);
    }

    public final List<String> zzb() {
        return this.zzb;
    }

    public zzagn() {
        this((List<String>) null);
    }

    private zzagn(List<String> list) {
        this.zza = 1;
        this.zzb = new ArrayList();
    }

    public zzagn(int i, List<String> list) {
        this.zza = 1;
        if (list == null || list.isEmpty()) {
            this.zzb = Collections.emptyList();
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.set(i2, Strings.emptyToNull(list.get(i2)));
        }
        this.zzb = Collections.unmodifiableList(list);
    }
}
