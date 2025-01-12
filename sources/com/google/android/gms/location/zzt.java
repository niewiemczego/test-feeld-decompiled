package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzt implements Parcelable.Creator<zzs> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = true;
        long j = 50;
        float f = 0.0f;
        long j2 = Long.MAX_VALUE;
        int i = Integer.MAX_VALUE;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                z = SafeParcelReader.readBoolean(parcel2, readHeader);
            } else if (fieldId == 2) {
                j = SafeParcelReader.readLong(parcel2, readHeader);
            } else if (fieldId == 3) {
                f = SafeParcelReader.readFloat(parcel2, readHeader);
            } else if (fieldId == 4) {
                j2 = SafeParcelReader.readLong(parcel2, readHeader);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel2, readHeader);
            } else {
                i = SafeParcelReader.readInt(parcel2, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzs(z, j, f, j2, i);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzs[i];
    }
}
