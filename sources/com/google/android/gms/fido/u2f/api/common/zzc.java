package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
final class zzc implements Parcelable.Creator {
    zzc() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ErrorCode.toErrorCode(parcel.readInt());
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ErrorCode[i];
    }
}
