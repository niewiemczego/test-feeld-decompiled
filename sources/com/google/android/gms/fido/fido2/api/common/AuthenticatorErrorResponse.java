package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.fido.fido2.api.common.ErrorCode;
import com.google.android.gms.internal.fido.zzaj;
import com.google.android.gms.internal.fido.zzak;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
public class AuthenticatorErrorResponse extends AuthenticatorResponse {
    public static final Parcelable.Creator<AuthenticatorErrorResponse> CREATOR = new zzl();
    private final ErrorCode zza;
    private final String zzb;
    private final int zzc;

    AuthenticatorErrorResponse(int i, String str, int i2) {
        try {
            this.zza = ErrorCode.toErrorCode(i);
            this.zzb = str;
            this.zzc = i2;
        } catch (ErrorCode.UnsupportedErrorCodeException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static AuthenticatorErrorResponse deserializeFromBytes(byte[] bArr) {
        return (AuthenticatorErrorResponse) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthenticatorErrorResponse)) {
            return false;
        }
        AuthenticatorErrorResponse authenticatorErrorResponse = (AuthenticatorErrorResponse) obj;
        if (!Objects.equal(this.zza, authenticatorErrorResponse.zza) || !Objects.equal(this.zzb, authenticatorErrorResponse.zzb) || !Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(authenticatorErrorResponse.zzc))) {
            return false;
        }
        return true;
    }

    public byte[] getClientDataJSON() {
        throw new UnsupportedOperationException();
    }

    public ErrorCode getErrorCode() {
        return this.zza;
    }

    public int getErrorCodeAsInt() {
        return this.zza.getCode();
    }

    public String getErrorMessage() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(this.zzc));
    }

    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    public String toString() {
        zzaj zza2 = zzak.zza(this);
        zza2.zza("errorCode", this.zza.getCode());
        String str = this.zzb;
        if (str != null) {
            zza2.zzb("errorMessage", str);
        }
        return zza2.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getErrorCodeAsInt());
        SafeParcelWriter.writeString(parcel, 3, getErrorMessage(), false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
