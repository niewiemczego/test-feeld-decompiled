package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzv implements Continuation<GetTokenResult, Task<Void>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ FirebaseAuth zzb;

    public final /* synthetic */ Object then(Task task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException((Exception) Preconditions.checkNotNull(task.getException()));
        }
        return this.zzb.zze.zza(this.zza, (String) Preconditions.checkNotNull(((GetTokenResult) task.getResult()).getToken()), "apple.com", this.zzb.zzk);
    }

    zzv(FirebaseAuth firebaseAuth, String str) {
        this.zza = str;
        this.zzb = firebaseAuth;
    }
}
