package com.google.firebase.auth.internal;

import android.app.Application;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaTasksClient;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public interface zzbs {
    Task<RecaptchaTasksClient> zza(Application application, String str);
}
