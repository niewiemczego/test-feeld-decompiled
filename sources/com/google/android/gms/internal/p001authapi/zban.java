package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zban  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final /* synthetic */ class zban implements RemoteCall {
    public final /* synthetic */ zbaq zba;
    public final /* synthetic */ AuthorizationRequest zbb;

    public /* synthetic */ zban(zbaq zbaq, AuthorizationRequest authorizationRequest) {
        this.zba = zbaq;
        this.zbb = authorizationRequest;
    }

    public final void accept(Object obj, Object obj2) {
        zbaq zbaq = this.zba;
        AuthorizationRequest authorizationRequest = this.zbb;
        ((zbaa) ((zbw) obj).getService()).zbc(new zbap(zbaq, (TaskCompletionSource) obj2), (AuthorizationRequest) Preconditions.checkNotNull(authorizationRequest));
    }
}
