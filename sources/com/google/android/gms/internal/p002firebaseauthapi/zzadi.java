package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final /* synthetic */ class zzadi implements Runnable {
    private /* synthetic */ zzadf zza;
    private /* synthetic */ zzadh zzb;
    private /* synthetic */ TaskCompletionSource zzc;

    public /* synthetic */ zzadi(zzadf zzadf, zzadh zzadh, TaskCompletionSource taskCompletionSource) {
        this.zza = zzadf;
        this.zzb = zzadh;
        this.zzc = taskCompletionSource;
    }

    public final void run() {
        this.zzb.zza(this.zzc, this.zza.zza);
    }
}
