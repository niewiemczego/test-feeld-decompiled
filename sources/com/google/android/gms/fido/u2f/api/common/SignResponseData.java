package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fido.zzaj;
import com.google.android.gms.internal.fido.zzak;
import com.google.android.gms.internal.fido.zzbf;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
public class SignResponseData extends ResponseData {
    public static final Parcelable.Creator<SignResponseData> CREATOR = new zzl();
    public static final String JSON_RESPONSE_DATA_CLIENT_DATA = "clientData";
    public static final String JSON_RESPONSE_DATA_KEY_HANDLE = "keyHandle";
    public static final String JSON_RESPONSE_DATA_SIGNATURE_DATA = "signatureData";
    private final byte[] zza;
    private final String zzb;
    private final byte[] zzc;
    private final byte[] zzd;

    @Deprecated
    public SignResponseData(byte[] bArr, String str, byte[] bArr2) {
        this(bArr, str, bArr2, new byte[0]);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SignResponseData)) {
            return false;
        }
        SignResponseData signResponseData = (SignResponseData) obj;
        if (!Arrays.equals(this.zza, signResponseData.zza) || !Objects.equal(this.zzb, signResponseData.zzb) || !Arrays.equals(this.zzc, signResponseData.zzc) || !Arrays.equals(this.zzd, signResponseData.zzd)) {
            return false;
        }
        return true;
    }

    public String getClientDataString() {
        return this.zzb;
    }

    public byte[] getKeyHandle() {
        return this.zza;
    }

    public byte[] getSignatureData() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), this.zzb, Integer.valueOf(Arrays.hashCode(this.zzc)), Integer.valueOf(Arrays.hashCode(this.zzd)));
    }

    public JSONObject toJsonObject() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_RESPONSE_DATA_KEY_HANDLE, (Object) Base64.encodeToString(this.zza, 11));
            jSONObject.put(JSON_RESPONSE_DATA_CLIENT_DATA, (Object) Base64.encodeToString(this.zzb.getBytes(), 11));
            jSONObject.put(JSON_RESPONSE_DATA_SIGNATURE_DATA, (Object) Base64.encodeToString(this.zzc, 11));
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        zzaj zza2 = zzak.zza(this);
        zzbf zzd2 = zzbf.zzd();
        byte[] bArr = this.zza;
        zza2.zzb(JSON_RESPONSE_DATA_KEY_HANDLE, zzd2.zze(bArr, 0, bArr.length));
        zza2.zzb("clientDataString", this.zzb);
        zzbf zzd3 = zzbf.zzd();
        byte[] bArr2 = this.zzc;
        zza2.zzb(JSON_RESPONSE_DATA_SIGNATURE_DATA, zzd3.zze(bArr2, 0, bArr2.length));
        zzbf zzd4 = zzbf.zzd();
        byte[] bArr3 = this.zzd;
        zza2.zzb(MimeTypes.BASE_TYPE_APPLICATION, zzd4.zze(bArr3, 0, bArr3.length));
        return zza2.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getKeyHandle(), false);
        SafeParcelWriter.writeString(parcel, 3, getClientDataString(), false);
        SafeParcelWriter.writeByteArray(parcel, 4, getSignatureData(), false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public SignResponseData(byte[] bArr, String str, byte[] bArr2, byte[] bArr3) {
        this.zza = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzb = (String) Preconditions.checkNotNull(str);
        this.zzc = (byte[]) Preconditions.checkNotNull(bArr2);
        this.zzd = (byte[]) Preconditions.checkNotNull(bArr3);
    }
}
