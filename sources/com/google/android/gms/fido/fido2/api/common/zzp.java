package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.fido2.api.common.COSEAlgorithmIdentifier;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
final class zzp implements Parcelable.Creator {
    zzp() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return COSEAlgorithmIdentifier.fromCoseValue(parcel.readInt());
        } catch (COSEAlgorithmIdentifier.UnsupportedAlgorithmIdentifierException e) {
            throw new RuntimeException(e);
        }
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new COSEAlgorithmIdentifier[i];
    }
}
