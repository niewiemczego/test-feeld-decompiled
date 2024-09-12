package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public abstract class zzn extends zzq implements zzo {
    public zzn() {
        super("com.android.vending.billing.IInAppBillingServiceCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzb(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzr.zzb(parcel);
        zza((Bundle) zzr.zza(parcel, Bundle.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
