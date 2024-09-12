package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzg implements OnSuccessListener<String> {
    private final /* synthetic */ TaskCompletionSource zza;

    zzg(zzb zzb, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zza.setResult(new zzm().zzc((String) obj).zza());
    }
}
