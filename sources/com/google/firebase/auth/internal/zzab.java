package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzafb;
import com.google.android.gms.internal.p002firebaseauthapi.zzafr;
import com.google.android.gms.internal.p002firebaseauthapi.zzxv;
import com.google.firebase.auth.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzab extends AbstractSafeParcelable implements UserInfo {
    public static final Parcelable.Creator<zzab> CREATOR = new zzaa();
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private Uri zze;
    private String zzf;
    private String zzg;
    private boolean zzh;
    private String zzi;

    public final Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.zzd) && this.zze == null) {
            this.zze = Uri.parse(this.zzd);
        }
        return this.zze;
    }

    public static zzab zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new zzab(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString("email"), jSONObject.optString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new zzxv(e);
        }
    }

    public final String getDisplayName() {
        return this.zzc;
    }

    public final String getEmail() {
        return this.zzf;
    }

    public final String getPhoneNumber() {
        return this.zzg;
    }

    public final String getProviderId() {
        return this.zzb;
    }

    public final String zza() {
        return this.zzi;
    }

    public final String getUid() {
        return this.zza;
    }

    public final String zzb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.zza);
            jSONObject.putOpt("providerId", this.zzb);
            jSONObject.putOpt("displayName", this.zzc);
            jSONObject.putOpt("photoUrl", this.zzd);
            jSONObject.putOpt("email", this.zzf);
            jSONObject.putOpt(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, this.zzg);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.zzh));
            jSONObject.putOpt("rawUserInfo", this.zzi);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new zzxv(e);
        }
    }

    public zzab(zzafr zzafr) {
        Preconditions.checkNotNull(zzafr);
        this.zza = zzafr.zzd();
        this.zzb = Preconditions.checkNotEmpty(zzafr.zzf());
        this.zzc = zzafr.zzb();
        Uri zza2 = zzafr.zza();
        if (zza2 != null) {
            this.zzd = zza2.toString();
            this.zze = zza2;
        }
        this.zzf = zzafr.zzc();
        this.zzg = zzafr.zze();
        this.zzh = false;
        this.zzi = zzafr.zzg();
    }

    public zzab(zzafb zzafb, String str) {
        Preconditions.checkNotNull(zzafb);
        Preconditions.checkNotEmpty(str);
        this.zza = Preconditions.checkNotEmpty(zzafb.zzi());
        this.zzb = str;
        this.zzf = zzafb.zzh();
        this.zzc = zzafb.zzg();
        Uri zzc2 = zzafb.zzc();
        if (zzc2 != null) {
            this.zzd = zzc2.toString();
            this.zze = zzc2;
        }
        this.zzh = zzafb.zzm();
        this.zzi = null;
        this.zzg = zzafb.zzj();
    }

    public zzab(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzf = str3;
        this.zzg = str4;
        this.zzc = str5;
        this.zzd = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.zze = Uri.parse(this.zzd);
        }
        this.zzh = z;
        this.zzi = str7;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUid(), false);
        SafeParcelWriter.writeString(parcel, 2, getProviderId(), false);
        SafeParcelWriter.writeString(parcel, 3, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 6, getPhoneNumber(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, isEmailVerified());
        SafeParcelWriter.writeString(parcel, 8, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean isEmailVerified() {
        return this.zzh;
    }
}
