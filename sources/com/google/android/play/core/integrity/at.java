package com.google.android.play.core.integrity;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.j;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
class at extends j {
    final TaskCompletionSource a;
    final /* synthetic */ ax b;

    at(ax axVar, TaskCompletionSource taskCompletionSource) {
        this.b = axVar;
        this.a = taskCompletionSource;
    }

    public final void b(Bundle bundle) throws RemoteException {
        this.b.a.v(this.a);
    }

    public void c(Bundle bundle) throws RemoteException {
        this.b.a.v(this.a);
    }

    public final void d(Bundle bundle) throws RemoteException {
        this.b.a.v(this.a);
    }

    public void e(Bundle bundle) throws RemoteException {
        this.b.a.v(this.a);
    }
}
