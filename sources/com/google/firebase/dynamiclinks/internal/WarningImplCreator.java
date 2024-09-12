package com.google.firebase.dynamiclinks.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.dynamiclinks.internal.ShortDynamicLinkImpl;

public class WarningImplCreator implements Parcelable.Creator<ShortDynamicLinkImpl.WarningImpl> {
    public static final int CONTENT_DESCRIPTION = 0;

    public ShortDynamicLinkImpl.WarningImpl createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(readHeader) != 2) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                str = SafeParcelReader.createString(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new ShortDynamicLinkImpl.WarningImpl(str);
    }

    public ShortDynamicLinkImpl.WarningImpl[] newArray(int i) {
        return new ShortDynamicLinkImpl.WarningImpl[i];
    }

    static void writeToParcel(ShortDynamicLinkImpl.WarningImpl warningImpl, Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, warningImpl.getMessage(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
