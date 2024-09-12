package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.internal.zzar;
import com.google.firebase.auth.internal.zzl;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaam  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaam extends zzacw<SignInMethodQueryResult, zzl> {
    private final String zzy;
    private final String zzz;

    public final String zza() {
        return "fetchSignInMethodsForEmail";
    }

    public zzaam(String str, String str2) {
        super(3);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zzy = str;
        this.zzz = str2;
    }

    public final void zzb() {
        List list;
        if (this.zzl.zza() == null) {
            list = zzaq.zzh();
        } else {
            list = (List) Preconditions.checkNotNull(this.zzl.zza());
        }
        zzb(new zzar(list));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zze(this.zzy, this.zzz, this.zzb);
    }
}
