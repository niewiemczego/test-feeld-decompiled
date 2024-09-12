package com.google.android.play.integrity.internal;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class v extends r {
    final /* synthetic */ ac a;

    v(ac acVar) {
        this.a = acVar;
    }

    public final void b() {
        synchronized (this.a.g) {
            if (this.a.m.get() > 0) {
                if (this.a.m.decrementAndGet() > 0) {
                    this.a.c.c("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
            }
            ac acVar = this.a;
            if (acVar.o != null) {
                acVar.c.c("Unbind from service.", new Object[0]);
                ac acVar2 = this.a;
                acVar2.b.unbindService(acVar2.f28n);
                this.a.h = false;
                this.a.o = null;
                this.a.f28n = null;
            }
            this.a.x();
        }
    }
}
