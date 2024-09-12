package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzl;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaby  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaby extends zzacw<Void, zzl> {
    private final UserProfileChangeRequest zzy;

    public final String zza() {
        return "updateProfile";
    }

    public zzaby(UserProfileChangeRequest userProfileChangeRequest) {
        super(2);
        this.zzy = (UserProfileChangeRequest) Preconditions.checkNotNull(userProfileChangeRequest, "request cannot be null");
    }

    public final void zzb() {
        ((zzl) this.zze).zza(this.zzj, zzaag.zza(this.zzc, this.zzk));
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zza(this.zzd.zze(), this.zzy, (zzacc) this.zzb);
    }
}
