package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GetTokenResult;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzat implements Runnable {
    final /* synthetic */ zzaq zza;
    private final String zzb;

    zzat(zzaq zzaq, String str) {
        this.zza = zzaq;
        this.zzb = Preconditions.checkNotEmpty(str);
    }

    public final void run() {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzb));
        if (instance.getCurrentUser() != null) {
            Task<GetTokenResult> accessToken = instance.getAccessToken(true);
            zzaq.zzc.v("Token refreshing started", new Object[0]);
            accessToken.addOnFailureListener(new zzas(this));
        }
    }
}
