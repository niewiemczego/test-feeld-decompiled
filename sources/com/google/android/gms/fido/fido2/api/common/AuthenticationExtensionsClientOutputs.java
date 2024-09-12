package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
public class AuthenticationExtensionsClientOutputs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthenticationExtensionsClientOutputs> CREATOR = new zzc();
    private final UvmEntries zza;
    private final zzf zzb;
    private final AuthenticationExtensionsCredPropsOutputs zzc;
    private final zzh zzd;

    /* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
    public static final class Builder {
        private UvmEntries zza;
        private AuthenticationExtensionsCredPropsOutputs zzb;

        public AuthenticationExtensionsClientOutputs build() {
            return new AuthenticationExtensionsClientOutputs(this.zza, (zzf) null, this.zzb, (zzh) null);
        }

        public Builder setCredProps(AuthenticationExtensionsCredPropsOutputs authenticationExtensionsCredPropsOutputs) {
            this.zzb = authenticationExtensionsCredPropsOutputs;
            return this;
        }

        public Builder setUserVerificationMethodEntries(UvmEntries uvmEntries) {
            this.zza = uvmEntries;
            return this;
        }
    }

    AuthenticationExtensionsClientOutputs(UvmEntries uvmEntries, zzf zzf, AuthenticationExtensionsCredPropsOutputs authenticationExtensionsCredPropsOutputs, zzh zzh) {
        this.zza = uvmEntries;
        this.zzb = zzf;
        this.zzc = authenticationExtensionsCredPropsOutputs;
        this.zzd = zzh;
    }

    public static AuthenticationExtensionsClientOutputs deserializeFromBytes(byte[] bArr) {
        return (AuthenticationExtensionsClientOutputs) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthenticationExtensionsClientOutputs)) {
            return false;
        }
        AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs = (AuthenticationExtensionsClientOutputs) obj;
        if (!Objects.equal(this.zza, authenticationExtensionsClientOutputs.zza) || !Objects.equal(this.zzb, authenticationExtensionsClientOutputs.zzb) || !Objects.equal(this.zzc, authenticationExtensionsClientOutputs.zzc) || !Objects.equal(this.zzd, authenticationExtensionsClientOutputs.zzd)) {
            return false;
        }
        return true;
    }

    public AuthenticationExtensionsCredPropsOutputs getCredProps() {
        return this.zzc;
    }

    public UvmEntries getUvmEntries() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd);
    }

    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUvmEntries(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getCredProps(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
