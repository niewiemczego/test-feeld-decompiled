package com.google.android.play.core.integrity;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.ac;
import com.google.android.play.integrity.internal.d;
import com.google.android.play.integrity.internal.q;
import com.google.android.play.integrity.internal.w;
import java.util.ArrayList;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class ax {
    final ac a;
    /* access modifiers changed from: private */
    public final q b;
    private final String c;
    /* access modifiers changed from: private */
    public final TaskCompletionSource d;

    ax(Context context, q qVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.d = taskCompletionSource;
        this.c = context.getPackageName();
        this.b = qVar;
        ac acVar = new ac(context, qVar, "ExpressIntegrityService", ay.a, ap.a, (w) null);
        this.a = acVar;
        acVar.c().post(new aq(this, taskCompletionSource, context));
    }

    static /* bridge */ /* synthetic */ Bundle a(ax axVar, String str, long j, long j2) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", axVar.c);
        bundle.putLong("cloud.prj", j);
        bundle.putString("nonce", str);
        bundle.putLong("warm.up.sid", j2);
        ArrayList arrayList = new ArrayList();
        d.b(5, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList(d.a(arrayList)));
        return bundle;
    }

    static /* bridge */ /* synthetic */ Bundle b(ax axVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", axVar.c);
        bundle.putLong("cloud.prj", j);
        ArrayList arrayList = new ArrayList();
        d.b(4, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList(d.a(arrayList)));
        return bundle;
    }

    static /* bridge */ /* synthetic */ boolean g(ax axVar) {
        return axVar.d.getTask().isSuccessful() && !((Boolean) axVar.d.getTask().getResult()).booleanValue();
    }

    public final Task c(String str, long j, long j2) {
        this.b.c("requestExpressIntegrityToken(%s)", Long.valueOf(j2));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.a.t(new as(this, taskCompletionSource, str, j, j2, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task d(long j) {
        this.b.c("warmUpIntegrityToken(%s)", Long.valueOf(j));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.a.t(new ar(this, taskCompletionSource, j, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }
}
