package com.google.android.gms.cloudmessaging;

import android.util.Log;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
public final /* synthetic */ class zzab implements Runnable {
    public final /* synthetic */ TaskCompletionSource zza;

    public /* synthetic */ zzab(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void run() {
        if (this.zza.trySetException(new IOException(InstanceID.ERROR_TIMEOUT))) {
            Log.w("Rpc", "No response");
        }
    }
}
