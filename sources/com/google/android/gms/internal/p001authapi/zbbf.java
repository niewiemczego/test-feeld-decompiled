package com.google.android.gms.internal.p001authapi;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbbf  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
final class zbbf extends zbae {
    final /* synthetic */ TaskCompletionSource zba;

    zbbf(zbbg zbbg, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    public final void zbb(Status status, PendingIntent pendingIntent) {
        TaskUtil.setResultOrApiException(status, pendingIntent, this.zba);
    }
}
