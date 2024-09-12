package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public final /* synthetic */ class zzbk implements RemoteCall {
    public final /* synthetic */ zzbo zza;

    public /* synthetic */ zzbk(zzbo zzbo) {
        this.zza = zzbo;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzbh) ((zzbe) obj).getService()).zzd(new zzbn(this.zza, (TaskCompletionSource) obj2));
    }
}
