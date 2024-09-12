package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public final /* synthetic */ class zzf implements zzk {
    public final /* synthetic */ Account zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Bundle zzc;

    public /* synthetic */ zzf(Account account, String str, Bundle bundle) {
        this.zza = account;
        this.zzb = str;
        this.zzc = bundle;
    }

    public final Object zza(IBinder iBinder) {
        return zzl.zzb(this.zza, this.zzb, this.zzc, iBinder);
    }
}
