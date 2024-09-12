package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final /* synthetic */ class zzbr implements Continuation {
    private /* synthetic */ RecaptchaAction zza;
    private /* synthetic */ FirebaseAuth zzb;
    private /* synthetic */ String zzc;
    private /* synthetic */ Continuation zzd;

    public /* synthetic */ zzbr(RecaptchaAction recaptchaAction, FirebaseAuth firebaseAuth, String str, Continuation continuation) {
        this.zza = recaptchaAction;
        this.zzb = firebaseAuth;
        this.zzc = str;
        this.zzd = continuation;
    }

    public final Object then(Task task) {
        return zzbo.zza(this.zza, this.zzb, this.zzc, this.zzd, task);
    }
}
