package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.MultiFactorSession;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzai implements Continuation<GetTokenResult, Task<MultiFactorSession>> {
    private final /* synthetic */ zzaj zza;

    public final /* synthetic */ Object then(Task task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(task.getException());
        }
        return Tasks.forResult(zzam.zza(((GetTokenResult) task.getResult()).getToken(), this.zza.zza));
    }

    zzai(zzaj zzaj) {
        this.zza = zzaj;
    }
}
