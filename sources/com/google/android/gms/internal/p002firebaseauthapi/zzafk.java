package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzafk implements zzacr {
    private final String zza;
    private final String zzb = "CLIENT_TYPE_ANDROID";
    private final String zzc;

    public static zzafk zza(String str, String str2) {
        return new zzafk(str, str2);
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zza)) {
            jSONObject.put("tenantId", (Object) this.zza);
        }
        if (!TextUtils.isEmpty(this.zzb)) {
            jSONObject.put("clientType", (Object) this.zzb);
        }
        if (!TextUtils.isEmpty(this.zzc)) {
            jSONObject.put("recaptchaVersion", (Object) this.zzc);
        }
        return jSONObject.toString();
    }

    private zzafk(String str, String str2) {
        this.zza = str;
        this.zzc = str2;
    }
}
