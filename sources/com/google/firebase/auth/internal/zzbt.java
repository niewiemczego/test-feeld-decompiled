package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzach;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzbt implements Continuation<T, Task<T>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzbx zzb;
    private final /* synthetic */ RecaptchaAction zzc;
    private final /* synthetic */ Continuation zzd;

    public final /* synthetic */ Object then(Task task) throws Exception {
        if (task.isSuccessful() || !zzach.zzb((Exception) Preconditions.checkNotNull(task.getException()))) {
            return task;
        }
        if (Log.isLoggable("RecaptchaCallWrapper", 4)) {
            Log.i("RecaptchaCallWrapper", "Invalid token - Refreshing Recaptcha Enterprise config and fetching new token for tenant " + this.zza);
        }
        return this.zzb.zza(this.zza, true, this.zzc).continueWithTask(this.zzd);
    }

    zzbt(String str, zzbx zzbx, RecaptchaAction recaptchaAction, Continuation continuation) {
        this.zza = str;
        this.zzb = zzbx;
        this.zzc = recaptchaAction;
        this.zzd = continuation;
    }
}
