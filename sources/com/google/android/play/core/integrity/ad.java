package com.google.android.play.core.integrity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.integrity.internal.ac;
import com.google.android.play.integrity.internal.ag;
import com.google.android.play.integrity.internal.d;
import com.google.android.play.integrity.internal.q;
import com.google.android.play.integrity.internal.w;
import java.util.ArrayList;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class ad {
    final ac a;
    /* access modifiers changed from: private */
    public final q b;
    private final String c;

    ad(Context context, q qVar) {
        this.c = context.getPackageName();
        this.b = qVar;
        if (!ag.a(context)) {
            qVar.a("Phonesky is not installed.", new Object[0]);
            this.a = null;
            return;
        }
        this.a = new ac(context, qVar, "IntegrityService", ae.a, aa.a, (w) null);
    }

    static /* bridge */ /* synthetic */ Bundle a(ad adVar, byte[] bArr, Long l, Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", adVar.c);
        bundle.putByteArray("nonce", bArr);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 2);
        bundle.putInt("playcore.integrity.version.patch", 0);
        if (l != null) {
            bundle.putLong("cloud.prj", l.longValue());
        }
        ArrayList arrayList = new ArrayList();
        d.b(3, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList(d.a(arrayList)));
        return bundle;
    }

    public final Task b(IntegrityTokenRequest integrityTokenRequest) {
        if (this.a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, (Throwable) null));
        }
        try {
            byte[] decode = Base64.decode(integrityTokenRequest.nonce(), 10);
            Long cloudProjectNumber = integrityTokenRequest.cloudProjectNumber();
            if (Build.VERSION.SDK_INT >= 23) {
                integrityTokenRequest.a();
            }
            this.b.c("requestIntegrityToken(%s)", integrityTokenRequest);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.a.t(new ab(this, taskCompletionSource, decode, cloudProjectNumber, (Parcelable) null, taskCompletionSource, integrityTokenRequest), taskCompletionSource);
            return taskCompletionSource.getTask();
        } catch (IllegalArgumentException e) {
            return Tasks.forException(new IntegrityServiceException(-13, e));
        }
    }
}
