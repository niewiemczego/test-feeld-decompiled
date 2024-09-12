package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.ag;
import com.google.android.play.integrity.internal.r;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class aq extends r {
    final /* synthetic */ Context a;
    final /* synthetic */ ax b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aq(ax axVar, TaskCompletionSource taskCompletionSource, Context context) {
        super(taskCompletionSource);
        this.b = axVar;
        this.a = context;
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.b.d.trySetResult(Boolean.valueOf(ag.a(this.a)));
    }
}
