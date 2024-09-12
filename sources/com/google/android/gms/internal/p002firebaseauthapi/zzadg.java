package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzadg<ResultT, CallbackT> implements zzacx<ResultT> {
    private final zzacw<ResultT, CallbackT> zza;
    private final TaskCompletionSource<ResultT> zzb;

    public zzadg(zzacw<ResultT, CallbackT> zzacw, TaskCompletionSource<ResultT> taskCompletionSource) {
        this.zza = zzacw;
        this.zzb = taskCompletionSource;
    }

    public final void zza(ResultT resultt, Status status) {
        FirebaseUser firebaseUser;
        Preconditions.checkNotNull(this.zzb, "completion source cannot be null");
        if (status == null) {
            this.zzb.setResult(resultt);
        } else if (this.zza.zzs != null) {
            TaskCompletionSource<ResultT> taskCompletionSource = this.zzb;
            FirebaseAuth instance = FirebaseAuth.getInstance(this.zza.zzc);
            zzyi zzyi = this.zza.zzs;
            if ("reauthenticateWithCredential".equals(this.zza.zza()) || "reauthenticateWithCredentialWithData".equals(this.zza.zza())) {
                firebaseUser = this.zza.zzd;
            } else {
                firebaseUser = null;
            }
            taskCompletionSource.setException(zzach.zza(instance, zzyi, firebaseUser));
        } else if (this.zza.zzp != null) {
            this.zzb.setException(zzach.zza(status, this.zza.zzp, this.zza.zzq, this.zza.zzr));
        } else {
            this.zzb.setException(zzach.zza(status));
        }
    }
}
