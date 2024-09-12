package com.google.android.gms.common.internal;

import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
public final class CallbackExecutor {
    private CallbackExecutor() {
    }

    public static ExecutorService executorService() {
        return zzj.zza;
    }
}
