package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbay  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final /* synthetic */ class zbay implements RemoteCall {
    public final /* synthetic */ zbbg zba;
    public final /* synthetic */ GetSignInIntentRequest zbb;

    public /* synthetic */ zbay(zbbg zbbg, GetSignInIntentRequest getSignInIntentRequest) {
        this.zba = zbbg;
        this.zbb = getSignInIntentRequest;
    }

    public final void accept(Object obj, Object obj2) {
        zbbg zbbg = this.zba;
        GetSignInIntentRequest getSignInIntentRequest = this.zbb;
        ((zbam) ((zbbh) obj).getService()).zbe(new zbbe(zbbg, (TaskCompletionSource) obj2), (GetSignInIntentRequest) Preconditions.checkNotNull(getSignInIntentRequest));
    }
}
