package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseNetworkException;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzas implements OnFailureListener {
    private final /* synthetic */ zzat zza;

    zzas(zzat zzat) {
        this.zza = zzat;
    }

    public final void onFailure(Exception exc) {
        if (exc instanceof FirebaseNetworkException) {
            zzaq.zzc.v("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.zza.zza.zzd();
        }
    }
}
