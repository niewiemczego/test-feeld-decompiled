package com.google.firebase.auth;

import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.internal.zzb;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzj implements OnCompleteListener<com.google.firebase.auth.internal.zzj> {
    private final /* synthetic */ PhoneAuthOptions zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ FirebaseAuth zzc;

    zzj(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, String str) {
        this.zza = phoneAuthOptions;
        this.zzb = str;
        this.zzc = firebaseAuth;
    }

    public final void onComplete(Task<com.google.firebase.auth.internal.zzj> task) {
        String str;
        String str2 = null;
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            Log.e("FirebaseAuth", "Error while validating application identity: " + (exception != null ? exception.getMessage() : ""));
            if (exception == null || !zzb.zza(exception)) {
                Log.e("FirebaseAuth", "Proceeding without any application identifier.");
                str = null;
            } else {
                FirebaseAuth.zza((FirebaseException) exception, this.zza, this.zzb);
                return;
            }
        } else {
            str2 = task.getResult().zzc();
            str = task.getResult().zza();
        }
        this.zzc.zza(this.zza, str2, str);
    }
}
