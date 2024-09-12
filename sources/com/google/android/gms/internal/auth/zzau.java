package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public final class zzau extends zza implements IInterface {
    zzau(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService");
    }

    public final void zzd(zzat zzat, zzaq zzaq) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzat);
        zzc.zzd(zza, zzaq);
        zzc(7, zza);
    }

    public final void zze(zzat zzat, zzbb zzbb) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzat);
        zzc.zzd(zza, zzbb);
        zzc(8, zza);
    }

    public final void zzf(zzat zzat, zzav zzav) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzat);
        zzc.zzd(zza, zzav);
        zzc(9, zza);
    }

    public final void zzg(zzat zzat, zzax zzax) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzat);
        zzc.zzd(zza, zzax);
        zzc(6, zza);
    }

    public final void zzh(zzat zzat, zzaz zzaz) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzat);
        zzc.zzd(zza, zzaz);
        zzc(5, zza);
    }
}
