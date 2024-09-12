package com.google.firebase.auth.internal;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzac;
import com.google.android.gms.internal.p002firebaseauthapi.zzafj;
import com.google.android.gms.internal.p002firebaseauthapi.zzah;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaTasksClient;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzbw implements Continuation<zzafj, Task<RecaptchaTasksClient>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzbx zzb;

    public final /* synthetic */ Object then(Task task) throws Exception {
        String str;
        if (!task.isSuccessful()) {
            return Tasks.forException(new zzbu((String) Preconditions.checkNotNull(((Exception) Preconditions.checkNotNull(task.getException())).getMessage())));
        }
        zzafj zzafj = (zzafj) task.getResult();
        String zza2 = zzafj.zza();
        if (zzah.zzc(zza2)) {
            return Tasks.forException(new zzbu("No Recaptcha Enterprise siteKey configured for tenant/project " + this.zza));
        }
        List<String> zza3 = zzac.zza((char) IOUtils.DIR_SEPARATOR_UNIX).zza((CharSequence) zza2);
        if (zza3.size() != 4) {
            str = null;
        } else {
            str = zza3.get(3);
        }
        if (TextUtils.isEmpty(str)) {
            return Tasks.forException(new Exception("Invalid siteKey format " + zza2));
        }
        if (Log.isLoggable("RecaptchaHandler", 4)) {
            Log.i("RecaptchaHandler", "Successfully obtained site key for tenant " + this.zza);
        }
        this.zzb.zzd = zzafj;
        Task<RecaptchaTasksClient> zza4 = this.zzb.zzc.zza((Application) this.zzb.zzb.getApplicationContext(), str);
        this.zzb.zza.put(this.zza, zza4);
        return zza4;
    }

    zzbw(zzbx zzbx, String str) {
        this.zza = str;
        this.zzb = zzbx;
    }
}
