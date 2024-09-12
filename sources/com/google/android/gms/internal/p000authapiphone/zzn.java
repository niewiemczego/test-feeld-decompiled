package com.google.android.gms.internal.p000authapiphone;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzn  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
final class zzn extends Api.AbstractClientBuilder<zzw, Api.ApiOptions.NoOptions> {
    zzn() {
    }

    public final /* bridge */ /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        Api.ApiOptions.NoOptions noOptions = (Api.ApiOptions.NoOptions) obj;
        return new zzw(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }
}
