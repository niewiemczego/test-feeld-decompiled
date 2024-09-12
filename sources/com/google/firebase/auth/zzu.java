package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.internal.zzav;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzu implements zzav {
    private final /* synthetic */ FirebaseUser zza;
    private final /* synthetic */ FirebaseAuth zzb;

    zzu(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.zza = firebaseUser;
        this.zzb = firebaseAuth;
    }

    public final void zza() {
        if (this.zzb.zzf != null && this.zzb.zzf.getUid().equalsIgnoreCase(this.zza.getUid())) {
            this.zzb.zzh();
        }
    }

    public final void zza(Status status) {
        if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005) {
            this.zzb.signOut();
        }
    }
}
