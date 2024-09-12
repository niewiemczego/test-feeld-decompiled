package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbba  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final /* synthetic */ class zbba implements RemoteCall {
    public final /* synthetic */ zbbg zba;
    public final /* synthetic */ GetPhoneNumberHintIntentRequest zbb;

    public /* synthetic */ zbba(zbbg zbbg, GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest) {
        this.zba = zbbg;
        this.zbb = getPhoneNumberHintIntentRequest;
    }

    public final void accept(Object obj, Object obj2) {
        this.zba.zba(this.zbb, (zbbh) obj, (TaskCompletionSource) obj2);
    }
}
