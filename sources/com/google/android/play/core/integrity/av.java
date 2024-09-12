package com.google.android.play.core.integrity;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.q;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class av extends at {
    private final q c = new q("OnWarmUpIntegrityTokenCallback");

    av(ax axVar, TaskCompletionSource taskCompletionSource) {
        super(axVar, taskCompletionSource);
    }

    public final void e(Bundle bundle) throws RemoteException {
        super.e(bundle);
        this.c.c("onWarmUpExpressIntegrityToken", new Object[0]);
        int i = bundle.getInt("error");
        if (i != 0) {
            this.a.trySetException(new StandardIntegrityException(i, (Throwable) null));
        } else {
            this.a.trySetResult(Long.valueOf(bundle.getLong("warm.up.sid")));
        }
    }
}
