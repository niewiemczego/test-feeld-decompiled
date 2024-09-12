package com.google.firebase.auth.internal;

import com.google.firebase.auth.SignInMethodQueryResult;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzar implements SignInMethodQueryResult {
    private final List<String> zza;

    public final List<String> getSignInMethods() {
        return this.zza;
    }

    public zzar(List<String> list) {
        this.zza = list;
    }
}
