package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class y extends r {
    final /* synthetic */ IBinder a;
    final /* synthetic */ ab b;

    y(ab abVar, IBinder iBinder) {
        this.b = abVar;
        this.a = iBinder;
    }

    public final void b() {
        ac acVar = this.b.a;
        acVar.o = (IInterface) acVar.j.a(this.a);
        ac.r(this.b.a);
        this.b.a.h = false;
        for (Runnable run : this.b.a.e) {
            run.run();
        }
        this.b.a.e.clear();
    }
}
