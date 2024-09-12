package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.review.internal.zzi;

/* compiled from: com.google.android.play:review@@2.0.1 */
final class zzh extends zzg {
    final String zzd;

    zzh(zzi zzi, TaskCompletionSource taskCompletionSource, String str) {
        super(zzi, new zzi("OnRequestInstallCallback"), taskCompletionSource);
        this.zzd = str;
    }

    public final void zzb(Bundle bundle) throws RemoteException {
        super.zzb(bundle);
        this.zzb.trySetResult(new zza((PendingIntent) bundle.get("confirmation_intent"), bundle.getBoolean("is_review_no_op")));
    }
}
