package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.internal.zzr;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzags  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzags extends AbstractSafeParcelable implements zzacr {
    public static final Parcelable.Creator<zzags> CREATOR = new zzagr();
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private boolean zzi;
    private boolean zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private String zzn;
    private boolean zzo;
    private String zzp;

    public final zzags zza(boolean z) {
        this.zzj = false;
        return this;
    }

    public final zzags zza(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzags zzb(boolean z) {
        this.zzo = true;
        return this;
    }

    public final zzags zzc(boolean z) {
        this.zzi = true;
        return this;
    }

    public final zzags zzb(String str) {
        this.zzn = str;
        return this;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoCreate", this.zzj);
        jSONObject.put("returnSecureToken", this.zzi);
        String str = this.zzb;
        if (str != null) {
            jSONObject.put("idToken", (Object) str);
        }
        String str2 = this.zzg;
        if (str2 != null) {
            jSONObject.put("postBody", (Object) str2);
        }
        String str3 = this.zzn;
        if (str3 != null) {
            jSONObject.put("tenantId", (Object) str3);
        }
        String str4 = this.zzp;
        if (str4 != null) {
            jSONObject.put("pendingToken", (Object) str4);
        }
        if (!TextUtils.isEmpty(this.zzl)) {
            jSONObject.put("sessionId", (Object) this.zzl);
        }
        if (!TextUtils.isEmpty(this.zzm)) {
            jSONObject.put("requestUri", (Object) this.zzm);
        } else {
            String str5 = this.zza;
            if (str5 != null) {
                jSONObject.put("requestUri", (Object) str5);
            }
        }
        jSONObject.put("returnIdpCredential", this.zzo);
        return jSONObject.toString();
    }

    public zzags() {
        this.zzi = true;
        this.zzj = true;
    }

    public zzags(zzr zzr, String str) {
        Preconditions.checkNotNull(zzr);
        this.zzl = Preconditions.checkNotEmpty(zzr.zzd());
        this.zzm = Preconditions.checkNotEmpty(str);
        this.zze = Preconditions.checkNotEmpty(zzr.zzc());
        this.zzi = true;
        StringBuilder sb = new StringBuilder();
        sb.append("providerId=").append(this.zze);
        this.zzg = sb.toString();
    }

    public zzags(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.zza = "http://localhost";
        this.zzc = str;
        this.zzd = str2;
        this.zzh = str5;
        this.zzk = str6;
        this.zzn = str7;
        this.zzp = str8;
        this.zzi = true;
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(this.zzd) || !TextUtils.isEmpty(this.zzk)) {
            this.zze = Preconditions.checkNotEmpty(str3);
            this.zzf = null;
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.zzc)) {
                sb.append("id_token=").append(this.zzc).append("&");
            }
            if (!TextUtils.isEmpty(this.zzd)) {
                sb.append("access_token=").append(this.zzd).append("&");
            }
            if (!TextUtils.isEmpty(this.zzf)) {
                sb.append("identifier=").append(this.zzf).append("&");
            }
            if (!TextUtils.isEmpty(this.zzh)) {
                sb.append("oauth_token_secret=").append(this.zzh).append("&");
            }
            if (!TextUtils.isEmpty(this.zzk)) {
                sb.append("code=").append(this.zzk).append("&");
            }
            if (!TextUtils.isEmpty(str9)) {
                sb.append("nonce=").append(str9).append("&");
            }
            sb.append("providerId=").append(this.zze);
            this.zzg = sb.toString();
            this.zzj = true;
            return;
        }
        throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
    }

    zzags(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, String str9, String str10, String str11, String str12, boolean z3, String str13) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
        this.zzi = z;
        this.zzj = z2;
        this.zzk = str9;
        this.zzl = str10;
        this.zzm = str11;
        this.zzn = str12;
        this.zzo = z3;
        this.zzp = str13;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 6, this.zze, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzh, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.writeString(parcel, 12, this.zzk, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeString(parcel, 14, this.zzm, false);
        SafeParcelWriter.writeString(parcel, 15, this.zzn, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzo);
        SafeParcelWriter.writeString(parcel, 17, this.zzp, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
