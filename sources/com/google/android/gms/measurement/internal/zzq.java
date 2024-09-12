package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzq implements Parcelable.Creator<zzo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = true;
        boolean z2 = true;
        String str = "";
        String str2 = str;
        String str3 = str2;
        boolean z3 = false;
        int i = 0;
        boolean z4 = false;
        boolean z5 = false;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        Boolean bool = null;
        ArrayList<String> arrayList = null;
        String str11 = null;
        String str12 = null;
        long j8 = -2147483648L;
        int i3 = 100;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 5:
                    str7 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    j = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 7:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 8:
                    str8 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 9:
                    z = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 10:
                    z3 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 11:
                    j8 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 12:
                    str9 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 13:
                    j3 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 14:
                    j4 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 15:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 16:
                    z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 18:
                    z4 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 19:
                    str10 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 21:
                    bool = SafeParcelReader.readBooleanObject(parcel2, readHeader);
                    break;
                case 22:
                    j5 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 23:
                    arrayList = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 24:
                    str11 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 25:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 26:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 27:
                    str12 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 28:
                    z5 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 29:
                    j6 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 30:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 31:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 32:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 34:
                    j7 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzo(str4, str5, str6, str7, j, j2, str8, z, z3, j8, str9, j3, j4, i, z2, z4, str10, bool, j5, (List<String>) arrayList, str11, str, str2, str12, z5, j6, i3, str3, i2, j7);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }
}
