package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
public class UvmEntry extends AbstractSafeParcelable {
    public static final Parcelable.Creator<UvmEntry> CREATOR = new zzba();
    private final int zza;
    private final short zzb;
    private final short zzc;

    /* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
    public static final class Builder {
        private int zza;
        private short zzb;
        private short zzc;

        public UvmEntry build() {
            return new UvmEntry(this.zza, this.zzb, this.zzc);
        }

        public Builder setKeyProtectionType(short s) {
            this.zzb = s;
            return this;
        }

        public Builder setMatcherProtectionType(short s) {
            this.zzc = s;
            return this;
        }

        public Builder setUserVerificationMethod(int i) {
            this.zza = i;
            return this;
        }
    }

    UvmEntry(int i, short s, short s2) {
        this.zza = i;
        this.zzb = s;
        this.zzc = s2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UvmEntry)) {
            return false;
        }
        UvmEntry uvmEntry = (UvmEntry) obj;
        if (this.zza == uvmEntry.zza && this.zzb == uvmEntry.zzb && this.zzc == uvmEntry.zzc) {
            return true;
        }
        return false;
    }

    public short getKeyProtectionType() {
        return this.zzb;
    }

    public short getMatcherProtectionType() {
        return this.zzc;
    }

    public int getUserVerificationMethod() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Short.valueOf(this.zzb), Short.valueOf(this.zzc));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getUserVerificationMethod());
        SafeParcelWriter.writeShort(parcel, 2, getKeyProtectionType());
        SafeParcelWriter.writeShort(parcel, 3, getMatcherProtectionType());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
