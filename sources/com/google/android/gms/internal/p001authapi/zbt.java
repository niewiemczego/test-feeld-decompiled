package com.google.android.gms.internal.p001authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

/* renamed from: com.google.android.gms.internal.auth-api.zbt  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final class zbt extends zba implements IInterface {
    zbt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    public final void zbc(zbs zbs, zbp zbp) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbs);
        zbc.zbc(zba, zbp);
        zbb(3, zba);
    }

    public final void zbd(zbs zbs, CredentialRequest credentialRequest) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbs);
        zbc.zbc(zba, credentialRequest);
        zbb(1, zba);
    }

    public final void zbe(zbs zbs, zbu zbu) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbs);
        zbc.zbc(zba, zbu);
        zbb(2, zba);
    }

    public final void zbf(zbs zbs) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbs);
        zbb(4, zba);
    }
}
