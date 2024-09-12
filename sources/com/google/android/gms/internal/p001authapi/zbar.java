package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbar  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final /* synthetic */ class zbar implements RemoteCall {
    public final /* synthetic */ zbaw zba;
    public final /* synthetic */ SaveAccountLinkingTokenRequest zbb;

    public /* synthetic */ zbar(zbaw zbaw, SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        this.zba = zbaw;
        this.zbb = saveAccountLinkingTokenRequest;
    }

    public final void accept(Object obj, Object obj2) {
        zbaw zbaw = this.zba;
        SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest = this.zbb;
        ((zbad) ((zbx) obj).getService()).zbc(new zbau(zbaw, (TaskCompletionSource) obj2), (SaveAccountLinkingTokenRequest) Preconditions.checkNotNull(saveAccountLinkingTokenRequest));
    }
}
