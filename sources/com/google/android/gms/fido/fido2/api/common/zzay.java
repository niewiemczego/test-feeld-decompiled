package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
public enum zzay implements Parcelable {
    USER_VERIFICATION_REQUIRED("required"),
    USER_VERIFICATION_PREFERRED("preferred"),
    USER_VERIFICATION_DISCOURAGED("discouraged");
    
    public static final Parcelable.Creator<zzay> CREATOR = null;
    private final String zze;

    static {
        CREATOR = new zzaw();
    }

    private zzay(String str) {
        this.zze = str;
    }

    public static zzay zza(String str) throws zzax {
        for (zzay zzay : values()) {
            if (str.equals(zzay.zze)) {
                return zzay;
            }
        }
        throw new zzax(str);
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return this.zze;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zze);
    }
}
