package com.google.android.play.core.integrity;

import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.ad;
import com.google.android.play.integrity.internal.n;
import com.google.android.play.integrity.internal.r;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class ab extends r {
    final /* synthetic */ byte[] a;
    final /* synthetic */ Long b;
    final /* synthetic */ TaskCompletionSource c;
    final /* synthetic */ IntegrityTokenRequest d;
    final /* synthetic */ ad e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ab(ad adVar, TaskCompletionSource taskCompletionSource, byte[] bArr, Long l, Parcelable parcelable, TaskCompletionSource taskCompletionSource2, IntegrityTokenRequest integrityTokenRequest) {
        super(taskCompletionSource);
        this.e = adVar;
        this.a = bArr;
        this.b = l;
        this.c = taskCompletionSource2;
        this.d = integrityTokenRequest;
    }

    public final void a(Exception exc) {
        if (exc instanceof ad) {
            super.a(new IntegrityServiceException(-9, exc));
        } else {
            super.a(exc);
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        try {
            ((n) this.e.a.e()).c(ad.a(this.e, this.a, this.b, (Parcelable) null), new ac(this.e, this.c));
        } catch (RemoteException e2) {
            this.e.b.b(e2, "requestIntegrityToken(%s)", this.d);
            this.c.trySetException(new IntegrityServiceException(-100, e2));
        }
    }
}
