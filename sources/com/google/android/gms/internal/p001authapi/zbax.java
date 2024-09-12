package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbax  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final /* synthetic */ class zbax implements RemoteCall {
    public final /* synthetic */ zbbg zba;
    public final /* synthetic */ BeginSignInRequest zbb;

    public /* synthetic */ zbax(zbbg zbbg, BeginSignInRequest beginSignInRequest) {
        this.zba = zbbg;
        this.zbb = beginSignInRequest;
    }

    public final void accept(Object obj, Object obj2) {
        zbbg zbbg = this.zba;
        BeginSignInRequest beginSignInRequest = this.zbb;
        ((zbam) ((zbbh) obj).getService()).zbc(new zbbc(zbbg, (TaskCompletionSource) obj2), (BeginSignInRequest) Preconditions.checkNotNull(beginSignInRequest));
    }
}
