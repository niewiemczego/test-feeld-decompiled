package com.google.android.gms.auth.api.proxy;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public interface ProxyApi {

    /* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
    public interface ProxyResult extends Result {
        ProxyResponse getResponse();
    }

    /* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
    public interface SpatulaHeaderResult extends Result {
        String getSpatulaHeader();
    }

    @Deprecated
    PendingResult<SpatulaHeaderResult> getSpatulaHeader(GoogleApiClient googleApiClient);

    @Deprecated
    PendingResult<ProxyResult> performProxyRequest(GoogleApiClient googleApiClient, ProxyRequest proxyRequest);
}
