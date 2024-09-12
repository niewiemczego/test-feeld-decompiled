package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzxv;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class PhoneMultiFactorInfo extends MultiFactorInfo {
    public static final Parcelable.Creator<PhoneMultiFactorInfo> CREATOR = new zzar();
    private final String zza;
    private final String zzb;
    private final long zzc;
    private final String zzd;

    public long getEnrollmentTimestamp() {
        return this.zzc;
    }

    public String getFactorId() {
        return "phone";
    }

    public static PhoneMultiFactorInfo zza(JSONObject jSONObject) {
        if (jSONObject.has("enrollmentTimestamp")) {
            return new PhoneMultiFactorInfo(jSONObject.optString("uid"), jSONObject.optString("displayName"), jSONObject.optLong("enrollmentTimestamp"), jSONObject.optString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER));
        }
        throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance.");
    }

    public String getDisplayName() {
        return this.zzb;
    }

    public String getPhoneNumber() {
        return this.zzd;
    }

    public String getUid() {
        return this.zza;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MultiFactorInfo.FACTOR_ID_KEY, "phone");
            jSONObject.putOpt("uid", this.zza);
            jSONObject.putOpt("displayName", this.zzb);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.zzc));
            jSONObject.putOpt(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, this.zzd);
            return jSONObject;
        } catch (JSONException e) {
            Log.d("PhoneMultiFactorInfo", "Failed to jsonify this object");
            throw new zzxv(e);
        }
    }

    public PhoneMultiFactorInfo(String str, String str2, long j, String str3) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = str2;
        this.zzc = j;
        this.zzd = Preconditions.checkNotEmpty(str3);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUid(), false);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeLong(parcel, 3, getEnrollmentTimestamp());
        SafeParcelWriter.writeString(parcel, 4, getPhoneNumber(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
