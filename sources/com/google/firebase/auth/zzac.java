package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzbo;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzac extends zzbo<AuthResult> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ FirebaseUser zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ FirebaseAuth zzf;

    /* JADX WARNING: type inference failed for: r8v0, types: [com.google.firebase.auth.internal.zzcc, com.google.firebase.auth.FirebaseAuth$zza] */
    public final Task<AuthResult> zza(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Logging in as " + this.zza + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for login with email " + this.zza);
        }
        if (this.zzb) {
            return this.zzf.zze.zzb(this.zzf.zza, (FirebaseUser) Preconditions.checkNotNull(this.zzc), this.zza, this.zzd, this.zze, str, new FirebaseAuth.zza());
        }
        return this.zzf.zze.zzb(this.zzf.zza, this.zza, this.zzd, this.zze, str, new FirebaseAuth.zzb());
    }

    zzac(FirebaseAuth firebaseAuth, String str, boolean z, FirebaseUser firebaseUser, String str2, String str3) {
        this.zza = str;
        this.zzb = z;
        this.zzc = firebaseUser;
        this.zzd = str2;
        this.zze = str3;
        this.zzf = firebaseAuth;
    }
}
