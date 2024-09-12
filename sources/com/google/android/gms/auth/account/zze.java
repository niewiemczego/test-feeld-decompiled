package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public interface zze extends IInterface {
    void zzd(zzb zzb, String str) throws RemoteException;

    void zze(zzb zzb, Account account) throws RemoteException;

    void zzf(boolean z) throws RemoteException;
}
