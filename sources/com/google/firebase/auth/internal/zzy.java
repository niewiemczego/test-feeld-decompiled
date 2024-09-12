package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.zzd;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzy implements Parcelable.Creator<zzz> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzaf zzaf = null;
        zzx zzx = null;
        zzd zzd = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                zzaf = (zzaf) SafeParcelReader.createParcelable(parcel, readHeader, zzaf.CREATOR);
            } else if (fieldId == 2) {
                zzx = (zzx) SafeParcelReader.createParcelable(parcel, readHeader, zzx.CREATOR);
            } else if (fieldId != 3) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zzd = (zzd) SafeParcelReader.createParcelable(parcel, readHeader, zzd.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzz(zzaf, zzx, zzd);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzz[i];
    }
}
