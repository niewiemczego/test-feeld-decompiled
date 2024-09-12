package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final /* synthetic */ class zzbq implements Continuation {
    private /* synthetic */ zzbo zza;

    public /* synthetic */ zzbq(zzbo zzbo) {
        this.zza = zzbo;
    }

    public final Object then(Task task) {
        zzbo zzbo = this.zza;
        if (task.isSuccessful()) {
            return zzbo.zza((String) task.getResult());
        }
        Log.e("RecaptchaCallWrapper", "Failed to get Recaptcha token, error - " + ((Exception) Preconditions.checkNotNull(task.getException())).getMessage() + "\n\n Failing open with a fake token.");
        return zzbo.zza("NO_RECAPTCHA");
    }
}
