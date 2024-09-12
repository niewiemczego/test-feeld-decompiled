package com.google.android.gms.internal.p001authapi;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.identity.zbu;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;

/* renamed from: com.google.android.gms.internal.auth-api.zbbb  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
final class zbbb extends Api.AbstractClientBuilder {
    zbbb() {
    }

    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new zbbh(context, looper, (zbu) obj, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }
}
