package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzz;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzabf extends zzacw<AuthResult, zzl> {
    private final zzye zzy;

    public final String zza() {
        return "reauthenticateWithPhoneCredentialWithData";
    }

    public zzabf(PhoneAuthCredential phoneAuthCredential, String str) {
        super(2);
        Preconditions.checkNotNull(phoneAuthCredential, "credential cannot be null");
        this.zzy = new zzye(phoneAuthCredential.zza(false), str);
    }

    public final void zzb() {
        zzaf zza = zzaag.zza(this.zzc, this.zzk);
        if (this.zzd.getUid().equalsIgnoreCase(zza.getUid())) {
            ((zzl) this.zze).zza(this.zzj, zza);
            zzb(new zzz(zza));
            return;
        }
        zza(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zza(this.zzy, (zzacc) this.zzb);
    }
}
