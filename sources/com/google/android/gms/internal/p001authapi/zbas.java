package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbas  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final /* synthetic */ class zbas implements RemoteCall {
    public final /* synthetic */ zbaw zba;
    public final /* synthetic */ SavePasswordRequest zbb;

    public /* synthetic */ zbas(zbaw zbaw, SavePasswordRequest savePasswordRequest) {
        this.zba = zbaw;
        this.zbb = savePasswordRequest;
    }

    public final void accept(Object obj, Object obj2) {
        zbaw zbaw = this.zba;
        SavePasswordRequest savePasswordRequest = this.zbb;
        ((zbad) ((zbx) obj).getService()).zbd(new zbav(zbaw, (TaskCompletionSource) obj2), (SavePasswordRequest) Preconditions.checkNotNull(savePasswordRequest));
    }
}
