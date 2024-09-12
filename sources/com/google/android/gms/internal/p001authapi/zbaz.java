package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbaz  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final /* synthetic */ class zbaz implements RemoteCall {
    public final /* synthetic */ zbbg zba;

    public /* synthetic */ zbaz(zbbg zbbg) {
        this.zba = zbbg;
    }

    public final void accept(Object obj, Object obj2) {
        this.zba.zbb((zbbh) obj, (TaskCompletionSource) obj2);
    }
}
