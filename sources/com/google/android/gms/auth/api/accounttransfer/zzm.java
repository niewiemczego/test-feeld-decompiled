package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzan;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzm extends zzan {
    final /* synthetic */ zzn zza;

    zzm(zzn zzn) {
        this.zza = zzn;
    }

    public final void zzd(Status status) {
        this.zza.zzb.setException(new AccountTransferException(status));
    }

    public final void zze() {
        this.zza.zzb.setResult(null);
    }
}
