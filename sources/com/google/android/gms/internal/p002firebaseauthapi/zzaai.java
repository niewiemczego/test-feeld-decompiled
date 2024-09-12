package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzu;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaai  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaai extends zzacw<ActionCodeResult, zzl> {
    private final String zzy;
    private final String zzz;

    public final String zza() {
        return "checkActionCode";
    }

    public zzaai(String str, String str2) {
        super(4);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zzy = str;
        this.zzz = str2;
    }

    public final void zzb() {
        zzb(new zzu(this.zzm));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zzd(this.zzy, this.zzz, this.zzb);
    }
}
