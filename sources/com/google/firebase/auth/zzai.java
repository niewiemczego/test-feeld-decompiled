package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzai implements Continuation<GetTokenResult, Task<Void>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ ActionCodeSettings zzb;
    private final /* synthetic */ FirebaseUser zzc;

    public final /* synthetic */ Object then(Task task) throws Exception {
        return FirebaseAuth.getInstance(this.zzc.zza()).zza((String) Preconditions.checkNotNull(((GetTokenResult) task.getResult()).getToken()), this.zza, this.zzb);
    }

    zzai(FirebaseUser firebaseUser, String str, ActionCodeSettings actionCodeSettings) {
        this.zza = str;
        this.zzb = actionCodeSettings;
        this.zzc = firebaseUser;
    }
}
