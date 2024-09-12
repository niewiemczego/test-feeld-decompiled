package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzz;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaas  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaas extends zzacw<AuthResult, zzl> {
    private final EmailAuthCredential zzy;
    private final String zzz;

    public final String zza() {
        return "linkEmailAuthCredential";
    }

    public zzaas(EmailAuthCredential emailAuthCredential, String str) {
        super(2);
        this.zzy = (EmailAuthCredential) Preconditions.checkNotNull(emailAuthCredential, "credential cannot be null");
        Preconditions.checkNotEmpty(emailAuthCredential.zzc(), "email cannot be null");
        Preconditions.checkNotEmpty(emailAuthCredential.zzd(), "password cannot be null");
        this.zzz = str;
    }

    public final void zzb() {
        zzaf zza = zzaag.zza(this.zzc, this.zzk);
        ((zzl) this.zze).zza(this.zzj, zza);
        zzb(new zzz(zza));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zza(this.zzy.zzc(), Preconditions.checkNotEmpty(this.zzy.zzd()), this.zzd.zze(), this.zzd.getTenantId(), this.zzz, this.zzb);
    }
}
