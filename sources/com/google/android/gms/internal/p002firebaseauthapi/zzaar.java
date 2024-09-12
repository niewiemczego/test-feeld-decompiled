package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.zzbi;
import com.google.firebase.auth.internal.zzl;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaar  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaar extends zzacw<GetTokenResult, zzl> {
    private final String zzy;

    public final String zza() {
        return "getAccessToken";
    }

    public zzaar(String str) {
        super(1);
        Preconditions.checkNotEmpty(str, "refresh token cannot be null");
        this.zzy = str;
    }

    public final void zzb() {
        if (TextUtils.isEmpty(this.zzj.zzd())) {
            this.zzj.zzc(this.zzy);
        }
        ((zzl) this.zze).zza(this.zzj, this.zzd);
        zzb(zzbi.zza(this.zzj.zzc()));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zzb(this.zzy, this.zzb);
    }
}
