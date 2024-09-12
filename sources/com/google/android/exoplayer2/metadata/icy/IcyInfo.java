package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class IcyInfo implements Metadata.Entry {
    public static final Parcelable.Creator<IcyInfo> CREATOR = new Parcelable.Creator<IcyInfo>() {
        public IcyInfo createFromParcel(Parcel parcel) {
            return new IcyInfo(parcel);
        }

        public IcyInfo[] newArray(int i) {
            return new IcyInfo[i];
        }
    };
    public final byte[] rawMetadata;
    public final String title;
    public final String url;

    public int describeContents() {
        return 0;
    }

    public IcyInfo(byte[] bArr, String str, String str2) {
        this.rawMetadata = bArr;
        this.title = str;
        this.url = str2;
    }

    IcyInfo(Parcel parcel) {
        this.rawMetadata = (byte[]) Assertions.checkNotNull(parcel.createByteArray());
        this.title = parcel.readString();
        this.url = parcel.readString();
    }

    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.title;
        if (str != null) {
            builder.setTitle(str);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.rawMetadata, ((IcyInfo) obj).rawMetadata);
    }

    public int hashCode() {
        return Arrays.hashCode(this.rawMetadata);
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", new Object[]{this.title, this.url, Integer.valueOf(this.rawMetadata.length)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.rawMetadata);
        parcel.writeString(this.title);
        parcel.writeString(this.url);
    }
}
