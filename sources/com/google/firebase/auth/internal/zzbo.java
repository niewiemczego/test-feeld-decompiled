package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzach;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zzbo<T> {
    public abstract Task<T> zza(String str);

    private static <T> Task<T> zza(zzbx zzbx, RecaptchaAction recaptchaAction, String str, Continuation<String, Task<T>> continuation) {
        Task<String> zza = zzbx.zza(str, false, recaptchaAction);
        return zza.continueWithTask(continuation).continueWithTask(new zzbt(str, zzbx, recaptchaAction, continuation));
    }

    public final Task<T> zza(FirebaseAuth firebaseAuth, String str, RecaptchaAction recaptchaAction, String str2) {
        zzbq zzbq = new zzbq(this);
        zzbx zzb = firebaseAuth.zzb();
        if (zzb == null || !zzb.zza(str2)) {
            return zza((String) null).continueWithTask(new zzbr(recaptchaAction, firebaseAuth, str, zzbq));
        }
        return zza(zzb, recaptchaAction, str, zzbq);
    }

    static /* synthetic */ Task zza(RecaptchaAction recaptchaAction, FirebaseAuth firebaseAuth, String str, Continuation continuation, Task task) throws Exception {
        if (task.isSuccessful()) {
            return Tasks.forResult(task.getResult());
        }
        Exception exc = (Exception) Preconditions.checkNotNull(task.getException());
        if (zzach.zzc(exc)) {
            if (Log.isLoggable("RecaptchaCallWrapper", 4)) {
                Log.i("RecaptchaCallWrapper", "Falling back to recaptcha enterprise flow for action " + String.valueOf(recaptchaAction));
            }
            if (firebaseAuth.zzb() == null) {
                firebaseAuth.zza(new zzbx(firebaseAuth.getApp(), firebaseAuth));
            }
            return zza(firebaseAuth.zzb(), recaptchaAction, str, continuation);
        }
        String valueOf = String.valueOf(recaptchaAction);
        Log.e("RecaptchaCallWrapper", "Initial task failed for action " + valueOf + "with exception - " + exc.getMessage());
        return Tasks.forException(exc);
    }
}
