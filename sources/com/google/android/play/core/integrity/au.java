package com.google.android.play.core.integrity;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.q;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class au extends at {
    private final q c = new q("OnRequestIntegrityTokenCallback");

    au(ax axVar, TaskCompletionSource taskCompletionSource) {
        super(axVar, taskCompletionSource);
    }

    public final void c(Bundle bundle) throws RemoteException {
        PendingIntent pendingIntent;
        super.c(bundle);
        this.c.c("onRequestExpressIntegrityToken", new Object[0]);
        int i = bundle.getInt("error");
        if (i != 0) {
            this.a.trySetException(new StandardIntegrityException(i, (Throwable) null));
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            pendingIntent = (PendingIntent) bundle.getParcelable("dialog.intent", PendingIntent.class);
        } else {
            pendingIntent = (PendingIntent) bundle.getParcelable("dialog.intent");
        }
        TaskCompletionSource taskCompletionSource = this.a;
        b bVar = new b();
        bVar.c(bundle.getString("token"));
        bVar.b(this.c);
        bVar.a(pendingIntent);
        taskCompletionSource.trySetResult(bVar.d());
    }
}
