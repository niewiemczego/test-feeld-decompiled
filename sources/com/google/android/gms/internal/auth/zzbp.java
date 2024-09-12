package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyResponse;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzbp extends zzbd {
    final /* synthetic */ zzbq zza;

    zzbp(zzbq zzbq) {
        this.zza = zzbq;
    }

    public final void zzb(ProxyResponse proxyResponse) {
        this.zza.setResult(new zzbu(proxyResponse));
    }
}
