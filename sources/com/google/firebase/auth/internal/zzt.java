package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeEmailInfo;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzt extends ActionCodeEmailInfo {
    private final String zza;

    public final String getPreviousEmail() {
        return this.zza;
    }

    public zzt(String str, String str2) {
        this.email = Preconditions.checkNotEmpty(str);
        this.zza = Preconditions.checkNotEmpty(str2);
    }
}
