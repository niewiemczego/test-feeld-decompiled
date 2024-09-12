package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzu;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaca  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaca extends zzacw<String, zzl> {
    private final String zzy;
    private final String zzz;

    public final String zza() {
        return "verifyPasswordResetCode";
    }

    public zzaca(String str, String str2) {
        super(4);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zzy = str;
        this.zzz = str2;
    }

    public final void zzb() {
        if (new zzu(this.zzm).getOperation() != 0) {
            zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR));
        } else {
            zzb(this.zzm.zzb());
        }
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zzd(this.zzy, this.zzz, this.zzb);
    }
}
