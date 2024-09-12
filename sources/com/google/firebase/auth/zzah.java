package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzah implements Continuation<GetTokenResult, Task<Void>> {
    private final /* synthetic */ FirebaseUser zza;

    public final /* synthetic */ Object then(Task task) throws Exception {
        return FirebaseAuth.getInstance(this.zza.zza()).zza((ActionCodeSettings) null, (String) Preconditions.checkNotNull(((GetTokenResult) task.getResult()).getToken()));
    }

    zzah(FirebaseUser firebaseUser) {
        this.zza = firebaseUser;
    }
}
