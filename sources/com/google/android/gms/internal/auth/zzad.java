package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzad extends zzah {
    final /* synthetic */ zzae zza;

    zzad(zzae zzae) {
        this.zza = zzae;
    }

    public final void zzb(Account account) {
        this.zza.setResult(new zzai(account != null ? Status.RESULT_SUCCESS : zzal.zza, account));
    }
}
