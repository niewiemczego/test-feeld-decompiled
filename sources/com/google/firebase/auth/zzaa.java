package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzafm;
import com.google.firebase.auth.internal.zzau;
import com.google.firebase.auth.internal.zzl;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaa implements zzau, zzl {
    private final /* synthetic */ FirebaseAuth zza;

    zzaa(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void zza(zzafm zzafm, FirebaseUser firebaseUser) {
        this.zza.zza(firebaseUser, zzafm, true, true);
    }

    public final void zza(Status status) {
        int statusCode = status.getStatusCode();
        if (statusCode == 17011 || statusCode == 17021 || statusCode == 17005) {
            this.zza.signOut();
        }
    }
}
