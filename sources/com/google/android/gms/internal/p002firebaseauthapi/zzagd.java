package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzagd implements zzacr {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = this.zza;
        if (str != null) {
            jSONObject.put("email", (Object) str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            jSONObject.put("password", (Object) str2);
        }
        String str3 = this.zzd;
        if (str3 != null) {
            jSONObject.put("tenantId", (Object) str3);
        }
        String str4 = this.zze;
        if (str4 != null) {
            zzahb.zza(jSONObject, "captchaResponse", str4);
        } else {
            zzahb.zza(jSONObject);
        }
        String str5 = this.zzf;
        if (str5 != null) {
            jSONObject.put("idToken", (Object) str5);
        }
        return jSONObject.toString();
    }

    public zzagd(String str) {
        this.zzd = str;
    }

    public zzagd(String str, String str2, String str3, String str4, String str5, String str6) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = null;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
    }
}
