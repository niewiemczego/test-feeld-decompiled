package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzam;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzabq extends zzacw<zzagi, Void> {
    private final zzagl zzy;

    public final String zza() {
        return "startMfaEnrollment";
    }

    public zzabq(zzam zzam, String str) {
        super(12);
        Preconditions.checkNotNull(zzam);
        this.zzy = zzagl.zza(Preconditions.checkNotEmpty(zzam.zzb()), str);
    }

    public final void zzb() {
        zzb(this.zzv);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zza(this.zzy, (zzacc) this.zzb);
    }
}
