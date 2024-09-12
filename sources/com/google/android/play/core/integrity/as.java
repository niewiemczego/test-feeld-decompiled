package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.i;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class as extends aw {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ long c;
    final /* synthetic */ TaskCompletionSource d;
    final /* synthetic */ ax e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    as(ax axVar, TaskCompletionSource taskCompletionSource, String str, long j, long j2, TaskCompletionSource taskCompletionSource2) {
        super(axVar, taskCompletionSource);
        this.e = axVar;
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = taskCompletionSource2;
    }

    /* access modifiers changed from: protected */
    public final void b() {
        if (ax.g(this.e)) {
            super.a(new StandardIntegrityException(-2, (Throwable) null));
            return;
        }
        try {
            ax axVar = this.e;
            ((i) axVar.a.e()).c(ax.a(axVar, this.a, this.b, this.c), new au(this.e, this.d));
        } catch (RemoteException e2) {
            this.e.b.b(e2, "requestExpressIntegrityToken(%s, %s)", this.a, Long.valueOf(this.b));
            this.d.trySetException(new StandardIntegrityException(-100, e2));
        }
    }
}
