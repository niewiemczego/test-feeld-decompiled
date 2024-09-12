package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzbu implements ProxyApi.ProxyResult {
    private final Status zza;
    private ProxyResponse zzb;

    public zzbu(ProxyResponse proxyResponse) {
        this.zzb = proxyResponse;
        this.zza = Status.RESULT_SUCCESS;
    }

    public zzbu(Status status) {
        this.zza = status;
    }

    public final ProxyResponse getResponse() {
        return this.zzb;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
