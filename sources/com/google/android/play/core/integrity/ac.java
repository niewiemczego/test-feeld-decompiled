package com.google.android.play.core.integrity;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.o;
import com.google.android.play.integrity.internal.q;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class ac extends o {
    final /* synthetic */ ad a;
    private final q b = new q("OnRequestIntegrityTokenCallback");
    private final TaskCompletionSource c;

    ac(ad adVar, TaskCompletionSource taskCompletionSource) {
        this.a = adVar;
        this.c = taskCompletionSource;
    }

    public final void b(Bundle bundle) {
        PendingIntent pendingIntent;
        this.a.a.v(this.c);
        this.b.c("onRequestIntegrityToken", new Object[0]);
        int i = bundle.getInt("error");
        if (i != 0) {
            this.c.trySetException(new IntegrityServiceException(i, (Throwable) null));
            return;
        }
        String string = bundle.getString("token");
        if (string == null) {
            this.c.trySetException(new IntegrityServiceException(-100, (Throwable) null));
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            pendingIntent = (PendingIntent) bundle.getParcelable("dialog.intent", PendingIntent.class);
        } else {
            pendingIntent = (PendingIntent) bundle.getParcelable("dialog.intent");
        }
        TaskCompletionSource taskCompletionSource = this.c;
        a aVar = new a();
        aVar.c(string);
        aVar.b(this.b);
        aVar.a(pendingIntent);
        taskCompletionSource.trySetResult(aVar.d());
    }
}
