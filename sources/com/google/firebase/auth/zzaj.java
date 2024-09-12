package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaj implements Continuation<GetTokenResult, Task<Void>> {
    private final /* synthetic */ ActionCodeSettings zza;
    private final /* synthetic */ FirebaseUser zzb;

    public final /* synthetic */ Object then(Task task) throws Exception {
        return FirebaseAuth.getInstance(this.zzb.zza()).zza(this.zza, (String) Preconditions.checkNotNull(((GetTokenResult) task.getResult()).getToken()));
    }

    zzaj(FirebaseUser firebaseUser, ActionCodeSettings actionCodeSettings) {
        this.zza = actionCodeSettings;
        this.zzb = firebaseUser;
    }
}
