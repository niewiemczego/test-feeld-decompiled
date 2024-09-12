package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzak implements Continuation<AuthResult, Task<AuthResult>> {
    private final /* synthetic */ zzal zza;

    public final /* synthetic */ Object then(Task task) throws Exception {
        if (this.zza.zzd == null) {
            return task;
        }
        if (task.isSuccessful()) {
            AuthResult authResult = (AuthResult) task.getResult();
            return Tasks.forResult(new zzz((zzaf) authResult.getUser(), (zzx) authResult.getAdditionalUserInfo(), this.zza.zzd));
        }
        Exception exception = task.getException();
        if (exception instanceof FirebaseAuthUserCollisionException) {
            ((FirebaseAuthUserCollisionException) exception).zza((AuthCredential) this.zza.zzd);
        }
        return Tasks.forException(exception);
    }

    zzak(zzal zzal) {
        this.zza = zzal;
    }
}
