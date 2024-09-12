package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzbo;
import com.google.firebase.auth.internal.zzcc;
import com.google.firebase.auth.internal.zzl;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzab extends zzbo<AuthResult> {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ FirebaseUser zzb;
    private final /* synthetic */ EmailAuthCredential zzc;
    private final /* synthetic */ FirebaseAuth zzd;

    /* JADX WARNING: type inference failed for: r6v0, types: [com.google.firebase.auth.internal.zzcc, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<AuthResult> zza(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Email link login/reauth with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for login/reauth with email link");
        }
        if (!this.zza) {
            return this.zzd.zze.zza(this.zzd.zza, this.zzc, str, (zzl) new FirebaseAuth.zzb());
        }
        return this.zzd.zze.zzb(this.zzd.zza, (FirebaseUser) Preconditions.checkNotNull(this.zzb), this.zzc, str, (zzcc) new FirebaseAuth.zza());
    }

    zzab(FirebaseAuth firebaseAuth, boolean z, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential) {
        this.zza = z;
        this.zzb = firebaseUser;
        this.zzc = emailAuthCredential;
        this.zzd = firebaseAuth;
    }
}
