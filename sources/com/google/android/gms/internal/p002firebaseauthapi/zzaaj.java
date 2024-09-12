package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzl;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaaj extends zzacw<Void, zzl> {
    private final String zzy;
    private final String zzz;

    public final String zza() {
        return "applyActionCode";
    }

    public zzaaj(String str, String str2) {
        super(7);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zzy = str;
        this.zzz = str2;
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zza(this.zzy, this.zzz, (zzacc) this.zzb);
    }
}
