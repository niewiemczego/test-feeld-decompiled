package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzagq;
import com.google.android.gms.internal.p002firebaseauthapi.zzxv;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class TotpMultiFactorInfo extends MultiFactorInfo {
    public static final Parcelable.Creator<TotpMultiFactorInfo> CREATOR = new zzat();
    private final String zza;
    private final String zzb;
    private final long zzc;
    private final zzagq zzd;

    public long getEnrollmentTimestamp() {
        return this.zzc;
    }

    public String getFactorId() {
        return TotpMultiFactorGenerator.FACTOR_ID;
    }

    public static TotpMultiFactorInfo zza(JSONObject jSONObject) {
        if (jSONObject.has("enrollmentTimestamp")) {
            long optLong = jSONObject.optLong("enrollmentTimestamp");
            if (jSONObject.opt("totpInfo") != null) {
                return new TotpMultiFactorInfo(jSONObject.optString("uid"), jSONObject.optString("displayName"), optLong, new zzagq());
            }
            throw new IllegalArgumentException("A totpInfo is required to build a TotpMultiFactorInfo instance.");
        }
        throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a TotpMultiFactorInfo instance.");
    }

    public String getDisplayName() {
        return this.zzb;
    }

    public String getUid() {
        return this.zza;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MultiFactorInfo.FACTOR_ID_KEY, TotpMultiFactorGenerator.FACTOR_ID);
            jSONObject.putOpt("uid", this.zza);
            jSONObject.putOpt("displayName", this.zzb);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.zzc));
            jSONObject.putOpt("totpInfo", this.zzd);
            return jSONObject;
        } catch (JSONException e) {
            Log.d("TotpMultiFactorInfo", "Failed to jsonify this object");
            throw new zzxv(e);
        }
    }

    public TotpMultiFactorInfo(String str, String str2, long j, zzagq zzagq) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = str2;
        this.zzc = j;
        this.zzd = (zzagq) Preconditions.checkNotNull(zzagq, "totpInfo cannot be null.");
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUid(), false);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeLong(parcel, 3, getEnrollmentTimestamp());
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
