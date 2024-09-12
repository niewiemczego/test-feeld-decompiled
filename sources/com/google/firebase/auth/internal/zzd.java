package com.google.firebase.auth.internal;

import android.app.Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final /* synthetic */ class zzd implements OnCompleteListener {
    private /* synthetic */ zzb zza;
    private /* synthetic */ TaskCompletionSource zzb;
    private /* synthetic */ FirebaseAuth zzc;
    private /* synthetic */ zzce zzd;
    private /* synthetic */ Activity zze;

    public /* synthetic */ zzd(zzb zzb2, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, zzce zzce, Activity activity) {
        this.zza = zzb2;
        this.zzb = taskCompletionSource;
        this.zzc = firebaseAuth;
        this.zzd = zzce;
        this.zze = activity;
    }

    public final void onComplete(Task task) {
        this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze, task);
    }
}
