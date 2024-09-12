package com.google.android.gms.internal.p000authapiphone;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzy  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
public final /* synthetic */ class zzy implements RemoteCall {
    public final /* synthetic */ zzab zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzy(zzab zzab, String str) {
        this.zza = zzab;
        this.zzb = str;
    }

    public final void accept(Object obj, Object obj2) {
        zzab zzab = this.zza;
        ((zzh) ((zzw) obj).getService()).zzh(this.zzb, new zzaa(zzab, (TaskCompletionSource) obj2));
    }
}
