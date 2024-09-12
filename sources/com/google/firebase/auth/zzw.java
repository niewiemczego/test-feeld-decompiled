package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzagi;
import com.google.android.gms.internal.p002firebaseauthapi.zzago;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.internal.zzcd;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzw implements Continuation<zzagi, Task<TotpSecret>> {
    private final /* synthetic */ FirebaseAuth zza;

    public final /* synthetic */ Object then(Task task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException((Exception) Preconditions.checkNotNull(task.getException()));
        }
        zzagi zzagi = (zzagi) task.getResult();
        if (zzagi instanceof zzago) {
            zzago zzago = (zzago) zzagi;
            return Tasks.forResult(new zzcd(Preconditions.checkNotEmpty(zzago.zzf()), Preconditions.checkNotEmpty(zzago.zze()), zzago.zzc(), zzago.zzb(), zzago.zzd(), Preconditions.checkNotEmpty(zzago.zza()), this.zza));
        }
        throw new IllegalArgumentException("Response should be an instance of StartTotpMfaEnrollmentResponse but was " + zzagi.getClass().getName() + ".");
    }

    zzw(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }
}
