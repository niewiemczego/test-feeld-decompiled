package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaew  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzaew implements zzaeq {
    private String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;

    public final /* synthetic */ zzaeq zza(String str) {
        this.zza = str;
        return this;
    }

    public static zzaew zza(String str, String str2, String str3, String str4, String str5) {
        return new zzaew(str, str2, str3, str4, str5);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", (Object) this.zza);
        if (!TextUtils.isEmpty(this.zzb)) {
            jSONObject.put("displayName", (Object) this.zzb);
        }
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(this.zzc)) {
            jSONObject2.put("sessionInfo", (Object) this.zzc);
        }
        if (!TextUtils.isEmpty(this.zzd)) {
            jSONObject2.put("verificationCode", (Object) this.zzd);
        }
        jSONObject.put("totpVerificationInfo", (Object) jSONObject2);
        if (!TextUtils.isEmpty(this.zze)) {
            jSONObject.put("tenantId", (Object) this.zze);
        }
        return jSONObject.toString();
    }

    private zzaew(String str, String str2, String str3, String str4, String str5) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = Preconditions.checkNotEmpty(str3);
        this.zzd = Preconditions.checkNotEmpty(str4);
        this.zze = str5;
    }
}
