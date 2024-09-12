package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
public class a implements IInterface {
    private final IBinder a;
    private final String b;

    protected a(IBinder iBinder, String str) {
        this.a = iBinder;
        this.b = str;
    }

    /* access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.b);
        return obtain;
    }

    public final IBinder asBinder() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public final void b(int i, Parcel parcel) throws RemoteException {
        try {
            this.a.transact(i, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
