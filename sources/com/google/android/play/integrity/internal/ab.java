package com.google.android.play.integrity.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class ab implements ServiceConnection {
    final /* synthetic */ ac a;

    /* synthetic */ ab(ac acVar, aa aaVar) {
        this.a = acVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.c.c("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        ac acVar = this.a;
        acVar.c().post(new y(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.c.c("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        ac acVar = this.a;
        acVar.c().post(new z(this));
    }
}
