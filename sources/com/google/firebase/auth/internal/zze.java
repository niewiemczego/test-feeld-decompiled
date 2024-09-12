package com.google.firebase.auth.internal;

import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzafi;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityTokenRequest;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zze implements Continuation<zzafi, Task<IntegrityTokenResponse>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ IntegrityManager zzb;
    private final /* synthetic */ zzb zzc;

    public final /* synthetic */ Object then(Task task) throws Exception {
        if (task.isSuccessful()) {
            this.zzc.zzc = ((zzafi) task.getResult()).zza();
            return this.zzb.requestIntegrityToken(IntegrityTokenRequest.builder().setCloudProjectNumber(Long.parseLong(((zzafi) task.getResult()).zza())).setNonce(new String(Base64.encode(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(this.zza.getBytes("UTF-8")), 11))).build());
        }
        Log.e(zzb.zza, "Problem retrieving Play Integrity producer project:  " + task.getException().getMessage());
        return Tasks.forException(task.getException());
    }

    zze(zzb zzb2, String str, IntegrityManager integrityManager) {
        this.zza = str;
        this.zzb = integrityManager;
        this.zzc = zzb2;
    }
}
