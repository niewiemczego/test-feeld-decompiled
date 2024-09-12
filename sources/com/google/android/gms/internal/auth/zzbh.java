package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public final class zzbh extends zza implements IInterface {
    zzbh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.internal.IAuthService");
    }

    public final void zzd(zzbg zzbg) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzbg);
        zzc(3, zza);
    }

    public final void zze(zzbg zzbg, ProxyRequest proxyRequest) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzbg);
        zzc.zzd(zza, proxyRequest);
        zzc(1, zza);
    }
}
