package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
public abstract class zzcy extends zzbx implements zzcv {
    public zzcy() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzbw.zzb(parcel);
        zza((Bundle) zzbw.zza(parcel, Bundle.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
