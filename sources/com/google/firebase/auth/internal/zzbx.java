package com.google.firebase.auth.internal;

import androidx.webkit.ProxyConfig;
import com.google.android.gms.internal.p002firebaseauthapi.zzafj;
import com.google.android.gms.internal.p002firebaseauthapi.zzah;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaTasksClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzbx {
    Map<String, Task<RecaptchaTasksClient>> zza;
    FirebaseApp zzb;
    zzbs zzc;
    /* access modifiers changed from: private */
    public zzafj zzd;
    private FirebaseAuth zze;

    private final Task<RecaptchaTasksClient> zzb(String str) {
        return this.zza.get(str);
    }

    public final Task<String> zza(String str, Boolean bool, RecaptchaAction recaptchaAction) {
        String zzc2 = zzc(str);
        Task<RecaptchaTasksClient> zzb2 = zzb(zzc2);
        if (bool.booleanValue() || zzb2 == null) {
            zzb2 = zza(zzc2, bool);
        }
        return zzb2.continueWithTask(new zzbz(this, recaptchaAction));
    }

    public final Task<RecaptchaTasksClient> zza(String str, Boolean bool) {
        Task<RecaptchaTasksClient> zzb2;
        String zzc2 = zzc(str);
        if (bool.booleanValue() || (zzb2 = zzb(zzc2)) == null) {
            return this.zze.zza("RECAPTCHA_ENTERPRISE").continueWithTask(new zzbw(this, zzc2));
        }
        return zzb2;
    }

    private static String zzc(String str) {
        return zzah.zzc(str) ? ProxyConfig.MATCH_ALL_SCHEMES : str;
    }

    public zzbx(FirebaseApp firebaseApp, FirebaseAuth firebaseAuth) {
        this(firebaseApp, firebaseAuth, new zzbv());
    }

    private zzbx(FirebaseApp firebaseApp, FirebaseAuth firebaseAuth, zzbs zzbs) {
        this.zza = new HashMap();
        this.zzb = firebaseApp;
        this.zze = firebaseAuth;
        this.zzc = zzbs;
    }

    public final boolean zza(String str) {
        zzafj zzafj = this.zzd;
        return zzafj != null && zzafj.zzb(str);
    }
}
