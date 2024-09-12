package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
public abstract class j extends b implements k {
    public j() {
        super("com.google.android.play.core.integrity.protocol.IExpressIntegrityServiceCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            c.b(parcel);
            e((Bundle) c.a(parcel, Bundle.CREATOR));
            return true;
        } else if (i == 3) {
            c.b(parcel);
            c((Bundle) c.a(parcel, Bundle.CREATOR));
            return true;
        } else if (i == 4) {
            c.b(parcel);
            d((Bundle) c.a(parcel, Bundle.CREATOR));
            return true;
        } else if (i != 5) {
            return false;
        } else {
            c.b(parcel);
            b((Bundle) c.a(parcel, Bundle.CREATOR));
            return true;
        }
    }
}
