package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaat  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaat extends zzacw<zzafj, Void> {
    private final zzxz zzy;

    public final String zza() {
        return "getRecaptchaConfig";
    }

    public zzaat(String str, String str2) {
        super(10);
        Preconditions.checkNotEmpty(str2);
        this.zzy = new zzxz(str, str2);
    }

    public final void zzb() {
        zzb(this.zzt);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zza(this.zzy, (zzacc) this.zzb);
    }
}
