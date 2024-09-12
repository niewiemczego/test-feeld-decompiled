package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzbr extends zzbd {
    final /* synthetic */ zzbs zza;

    zzbr(zzbs zzbs) {
        this.zza = zzbs;
    }

    public final void zzc(String str) {
        if (str != null) {
            this.zza.setResult(new zzbv(str));
        } else {
            this.zza.setResult(new zzbv(new Status(AuthApiStatusCodes.AUTH_APP_CERT_ERROR)));
        }
    }
}
