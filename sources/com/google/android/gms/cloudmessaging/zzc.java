package com.google.android.gms.cloudmessaging;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
final class zzc implements Parcelable.Creator {
    zzc() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zze(parcel.readStrongBinder());
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zze[i];
    }
}
