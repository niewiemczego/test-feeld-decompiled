package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzbo;
import com.google.firebase.auth.internal.zzl;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzq extends zzbo<AuthResult> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ FirebaseAuth zzc;

    public final Task<AuthResult> zza(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Creating user with " + this.zza + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for sign up with email " + this.zza);
        }
        return this.zzc.zze.zza(this.zzc.zza, this.zza, this.zzb, this.zzc.zzk, str, (zzl) new FirebaseAuth.zzb());
    }

    zzq(FirebaseAuth firebaseAuth, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = firebaseAuth;
    }
}
