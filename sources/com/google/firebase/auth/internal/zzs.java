package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeInfo;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzs extends ActionCodeInfo {
    public zzs(String str) {
        this.email = Preconditions.checkNotEmpty(str);
    }
}
