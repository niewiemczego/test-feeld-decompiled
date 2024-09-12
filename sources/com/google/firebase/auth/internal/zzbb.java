package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzbb implements OnSuccessListener<AuthResult> {
    private final /* synthetic */ TaskCompletionSource zza;
    private final /* synthetic */ Context zzb;

    zzbb(zzax zzax, TaskCompletionSource taskCompletionSource, Context context) {
        this.zza = taskCompletionSource;
        this.zzb = context;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zza.setResult((AuthResult) obj);
        zzax.zza(this.zzb);
    }
}
