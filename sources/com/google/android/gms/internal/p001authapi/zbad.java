package com.google.android.gms.internal.p001authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;

/* renamed from: com.google.android.gms.internal.auth-api.zbad  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final class zbad extends zba implements IInterface {
    zbad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ICredentialSavingService");
    }

    public final void zbc(zbaj zbaj, SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbaj);
        zbc.zbc(zba, saveAccountLinkingTokenRequest);
        zbb(1, zba);
    }

    public final void zbd(zbal zbal, SavePasswordRequest savePasswordRequest) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbal);
        zbc.zbc(zba, savePasswordRequest);
        zbb(2, zba);
    }
}
