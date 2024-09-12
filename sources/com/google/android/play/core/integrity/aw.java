package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.ad;
import com.google.android.play.integrity.internal.r;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
abstract class aw extends r {
    final /* synthetic */ ax f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aw(ax axVar, TaskCompletionSource taskCompletionSource) {
        super(taskCompletionSource);
        this.f = axVar;
    }

    public final void a(Exception exc) {
        if (!(exc instanceof ad)) {
            super.a(exc);
        } else if (ax.g(this.f)) {
            super.a(new StandardIntegrityException(-2, exc));
        } else {
            super.a(new StandardIntegrityException(-9, exc));
        }
    }
}
