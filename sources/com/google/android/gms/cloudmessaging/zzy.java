package com.google.android.gms.cloudmessaging;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
public final /* synthetic */ class zzy implements Executor {
    public static final /* synthetic */ zzy zza = new zzy();

    private /* synthetic */ zzy() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
