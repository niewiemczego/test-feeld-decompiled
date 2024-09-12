package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.i;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class ar extends aw {
    final /* synthetic */ long a;
    final /* synthetic */ TaskCompletionSource b;
    final /* synthetic */ ax c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ar(ax axVar, TaskCompletionSource taskCompletionSource, long j, TaskCompletionSource taskCompletionSource2) {
        super(axVar, taskCompletionSource);
        this.c = axVar;
        this.a = j;
        this.b = taskCompletionSource2;
    }

    /* access modifiers changed from: protected */
    public final void b() {
        if (ax.g(this.c)) {
            super.a(new StandardIntegrityException(-2, (Throwable) null));
            return;
        }
        try {
            ax axVar = this.c;
            ((i) axVar.a.e()).d(ax.b(axVar, this.a), new av(this.c, this.b));
        } catch (RemoteException e) {
            this.c.b.b(e, "warmUpIntegrityToken(%s)", Long.valueOf(this.a));
            this.b.trySetException(new StandardIntegrityException(-100, e));
        }
    }
}
