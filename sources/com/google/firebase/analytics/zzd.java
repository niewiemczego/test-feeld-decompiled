package com.google.firebase.analytics;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.5.0 */
final class zzd implements Callable<Long> {
    private final /* synthetic */ FirebaseAnalytics zza;

    public final /* synthetic */ Object call() throws Exception {
        return this.zza.zzb.zzc();
    }

    zzd(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }
}
