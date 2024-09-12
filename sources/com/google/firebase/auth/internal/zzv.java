package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeMultiFactorInfo;
import com.google.firebase.auth.MultiFactorInfo;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzv extends ActionCodeMultiFactorInfo {
    private final MultiFactorInfo zza;

    public final MultiFactorInfo getMultiFactorInfo() {
        return this.zza;
    }

    public zzv(String str, MultiFactorInfo multiFactorInfo) {
        this.email = Preconditions.checkNotEmpty(str);
        this.zza = (MultiFactorInfo) Preconditions.checkNotNull(multiFactorInfo);
    }
}
