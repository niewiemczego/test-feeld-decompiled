package com.google.android.play.core.review.internal;

import android.os.IBinder;

/* compiled from: com.google.android.play:review@@2.0.1 */
public final /* synthetic */ class zzl implements IBinder.DeathRecipient {
    public final /* synthetic */ zzt zza;

    public /* synthetic */ zzl(zzt zzt) {
        this.zza = zzt;
    }

    public final void binderDied() {
        zzt.zzh(this.zza);
    }
}
