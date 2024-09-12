package com.google.firebase.analytics;

import com.google.android.gms.internal.measurement.zzcl;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.5.0 */
final class zzb extends ThreadPoolExecutor {
    zzb(FirebaseAnalytics firebaseAnalytics, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue) {
        super(0, 1, 30, timeUnit, blockingQueue);
    }

    public final void execute(Runnable runnable) {
        super.execute(zzcl.zza().zza(runnable));
    }
}
