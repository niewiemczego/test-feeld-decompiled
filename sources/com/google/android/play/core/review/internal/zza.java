package com.google.android.play.core.review.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.play:review@@2.0.1 */
public class zza implements IInterface {
    private final IBinder zza;
    private final String zzb = "com.google.android.play.core.inappreview.protocol.IInAppReviewService";

    protected zza(IBinder iBinder, String str) {
        this.zza = iBinder;
    }

    public final IBinder asBinder() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final Parcel zza() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void zzb(int i, Parcel parcel) throws RemoteException {
        try {
            this.zza.transact(2, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
