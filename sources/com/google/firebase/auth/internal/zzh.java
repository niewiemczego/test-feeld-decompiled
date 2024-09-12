package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuthException;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzh implements OnFailureListener {
    private final /* synthetic */ TaskCompletionSource zza;

    zzh(zzb zzb, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void onFailure(Exception exc) {
        Log.e(zzb.zza, String.format("Failed to get reCAPTCHA token with error [%s]- calling backend without app verification", new Object[]{exc.getMessage()}));
        if (!(exc instanceof FirebaseAuthException) || !((FirebaseAuthException) exc).getErrorCode().endsWith("UNAUTHORIZED_DOMAIN")) {
            this.zza.setResult(new zzm().zza());
        } else {
            this.zza.setException(exc);
        }
    }
}
