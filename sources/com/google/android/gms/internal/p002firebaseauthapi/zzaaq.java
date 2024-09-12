package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaaq extends zzacw<zzafi, Void> {
    private final zzxw zzy = new zzxw();

    public final String zza() {
        return "getRecaptchaParam";
    }

    public zzaaq() {
        super(11);
    }

    public final void zzb() {
        zzb(this.zzu);
    }

    public final void zza(TaskCompletionSource<zzafi> taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zza(this.zzy, (zzacc) this.zzb);
    }
}
