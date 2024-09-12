package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class zzadf {
    zzace zza;
    Executor zzb;

    public final <ResultT> Task<ResultT> zza(zzadh<ResultT> zzadh) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzb.execute(new zzadi(this, zzadh, taskCompletionSource));
        return taskCompletionSource.getTask();
    }
}
