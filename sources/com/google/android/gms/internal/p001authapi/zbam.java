package com.google.android.gms.internal.p001authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* renamed from: com.google.android.gms.internal.auth-api.zbam  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final class zbam extends zba implements IInterface {
    zbam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ISignInService");
    }

    public final void zbc(zbac zbac, BeginSignInRequest beginSignInRequest) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbac);
        zbc.zbc(zba, beginSignInRequest);
        zbb(1, zba);
    }

    public final void zbd(zbaf zbaf, GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest, String str) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbaf);
        zbc.zbc(zba, getPhoneNumberHintIntentRequest);
        zba.writeString(str);
        zbb(4, zba);
    }

    public final void zbe(zbah zbah, GetSignInIntentRequest getSignInIntentRequest) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbah);
        zbc.zbc(zba, getSignInIntentRequest);
        zbb(3, zba);
    }

    public final void zbf(IStatusCallback iStatusCallback, String str) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, iStatusCallback);
        zba.writeString(str);
        zbb(2, zba);
    }
}
