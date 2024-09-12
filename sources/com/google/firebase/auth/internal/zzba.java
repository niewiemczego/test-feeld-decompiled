package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzba implements OnFailureListener {
    private final /* synthetic */ TaskCompletionSource zza;
    private final /* synthetic */ Context zzb;

    zzba(zzax zzax, TaskCompletionSource taskCompletionSource, Context context) {
        this.zza = taskCompletionSource;
        this.zzb = context;
    }

    public final void onFailure(Exception exc) {
        this.zza.setException(exc);
        zzax.zza(this.zzb);
    }
}
