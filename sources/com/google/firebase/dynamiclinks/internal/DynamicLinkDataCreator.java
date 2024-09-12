package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class DynamicLinkDataCreator implements Parcelable.Creator<DynamicLinkData> {
    public static final int CONTENT_DESCRIPTION = 0;

    public DynamicLinkData createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        Bundle bundle = null;
        Uri uri = null;
        int i = 0;
        long j = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 2:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    j = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 5:
                    bundle = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel, readHeader, Uri.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new DynamicLinkData(str, str2, i, j, bundle, uri);
    }

    public DynamicLinkData[] newArray(int i) {
        return new DynamicLinkData[i];
    }

    static void writeToParcel(DynamicLinkData dynamicLinkData, Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, dynamicLinkData.getDynamicLink(), false);
        SafeParcelWriter.writeString(parcel, 2, dynamicLinkData.getDeepLink(), false);
        SafeParcelWriter.writeInt(parcel, 3, dynamicLinkData.getMinVersion());
        SafeParcelWriter.writeLong(parcel, 4, dynamicLinkData.getClickTimestamp());
        SafeParcelWriter.writeBundle(parcel, 5, dynamicLinkData.getExtensionBundle(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, dynamicLinkData.getRedirectUrl(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
