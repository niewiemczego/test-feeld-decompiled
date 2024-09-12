package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
public class UserVerificationMethodExtension extends AbstractSafeParcelable {
    public static final Parcelable.Creator<UserVerificationMethodExtension> CREATOR = new zzav();
    private final boolean zza;

    public UserVerificationMethodExtension(boolean z) {
        this.zza = z;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof UserVerificationMethodExtension) && this.zza == ((UserVerificationMethodExtension) obj).zza) {
            return true;
        }
        return false;
    }

    public boolean getUvm() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zza));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getUvm());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
