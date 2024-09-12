package com.google.firebase.auth.internal;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzach;
import com.google.android.gms.internal.p002firebaseauthapi.zzadq;
import com.google.android.gms.internal.p002firebaseauthapi.zzaec;
import com.google.android.gms.internal.p002firebaseauthapi.zzafi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class zzb {
    /* access modifiers changed from: private */
    public static final String zza = "zzb";
    private static final zzb zzb = new zzb();
    /* access modifiers changed from: private */
    public String zzc;

    public final Task<zzj> zza(FirebaseAuth firebaseAuth, String str, Activity activity, boolean z, boolean z2, boolean z3, RecaptchaAction recaptchaAction) {
        boolean z4 = z2;
        zzac zzac = (zzac) firebaseAuth.getFirebaseAuthSettings();
        zzce zzc2 = zzce.zzc();
        if (zzaec.zza(firebaseAuth.getApp()) || zzac.zze()) {
            return Tasks.forResult(new zzm().zza());
        }
        String str2 = zza;
        Log.i(str2, "ForceRecaptchaV2Flow from phoneAuthOptions = " + z4 + ", ForceRecaptchav2Flow from firebaseSettings = " + zzac.zzc());
        boolean z5 = z4 || zzac.zzc();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Task<String> zzb2 = zzc2.zzb();
        if (zzb2 != null) {
            if (zzb2.isSuccessful()) {
                return Tasks.forResult(new zzm().zzc(zzb2.getResult()).zza());
            }
            Log.e(str2, "Error in previous reCAPTCHAV2 flow: " + zzb2.getException().getMessage());
            Log.e(str2, "Continuing with application verification as normal");
        }
        if (!z5) {
            firebaseAuth.initializeRecaptchaConfig().addOnCompleteListener(new zza(this, taskCompletionSource, firebaseAuth, recaptchaAction, str, activity, z, false, zzc2));
        } else {
            zza(firebaseAuth, str, activity, z, true, zzc2, (TaskCompletionSource<zzj>) taskCompletionSource);
        }
        return taskCompletionSource.getTask();
    }

    public static zzb zza() {
        return zzb;
    }

    private zzb() {
    }

    private final void zza(FirebaseAuth firebaseAuth, zzce zzce, Activity activity, TaskCompletionSource<zzj> taskCompletionSource) {
        Task task;
        if (activity == null) {
            taskCompletionSource.setException(new FirebaseAuthMissingActivityForRecaptchaException());
            return;
        }
        zzbl.zza(firebaseAuth.getApp().getApplicationContext(), firebaseAuth);
        Preconditions.checkNotNull(activity);
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        if (!zzax.zza().zza(activity, (TaskCompletionSource<String>) taskCompletionSource2)) {
            task = Tasks.forException(zzach.zza(new Status(17057, "reCAPTCHA flow already in progress")));
        } else {
            new zzadq(firebaseAuth, activity).zza();
            task = taskCompletionSource2.getTask();
        }
        task.addOnSuccessListener(new zzg(this, taskCompletionSource)).addOnFailureListener(new zzh(this, taskCompletionSource));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, zzce zzce, Activity activity, Task task) {
        if (task.isSuccessful() && task.getResult() != null && !TextUtils.isEmpty(((IntegrityTokenResponse) task.getResult()).token())) {
            taskCompletionSource.setResult(new zzm().zza(((IntegrityTokenResponse) task.getResult()).token()).zza());
            return;
        }
        Log.e(zza, "Play Integrity Token fetch failed, falling back to Recaptcha" + (task.getException() == null ? "" : task.getException().getMessage()));
        zza(firebaseAuth, zzce, activity, taskCompletionSource);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, RecaptchaAction recaptchaAction, String str, Activity activity, boolean z, boolean z2, zzce zzce, Task task) {
        TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
        if (!task.isSuccessful()) {
            Log.e(zza, "Failed to initialize reCAPTCHA config: " + task.getException().getMessage());
        }
        if (firebaseAuth.zzb() == null || !firebaseAuth.zzb().zza("PHONE_PROVIDER")) {
            zza(firebaseAuth, str, activity, z, z2, zzce, (TaskCompletionSource<zzj>) taskCompletionSource);
            return;
        }
        RecaptchaAction recaptchaAction2 = recaptchaAction;
        firebaseAuth.zzb().zza(firebaseAuth.getTenantId(), false, recaptchaAction).addOnSuccessListener(new zzf(this, taskCompletionSource)).addOnFailureListener(new zzc(this, taskCompletionSource));
    }

    private final void zza(FirebaseAuth firebaseAuth, String str, Activity activity, boolean z, boolean z2, zzce zzce, TaskCompletionSource<zzj> taskCompletionSource) {
        Task<zzafi> task;
        if (!z || z2) {
            zza(firebaseAuth, zzce, activity, taskCompletionSource);
            return;
        }
        IntegrityManager create = IntegrityManagerFactory.create(firebaseAuth.getApp().getApplicationContext());
        if (!TextUtils.isEmpty(this.zzc)) {
            task = Tasks.forResult(new zzafi(this.zzc));
        } else {
            task = firebaseAuth.zza();
        }
        task.continueWithTask(firebaseAuth.zzf(), new zze(this, str, create)).addOnCompleteListener(new zzd(this, taskCompletionSource, firebaseAuth, zzce, activity));
    }

    public static boolean zza(Exception exc) {
        if (!(exc instanceof FirebaseAuthMissingActivityForRecaptchaException)) {
            return (exc instanceof FirebaseAuthException) && ((FirebaseAuthException) exc).getErrorCode().endsWith("UNAUTHORIZED_DOMAIN");
        }
        return true;
    }
}
