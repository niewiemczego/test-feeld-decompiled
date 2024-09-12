package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafa  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzafa implements zzacr {
    private String zza = zzaey.REFRESH_TOKEN.toString();
    private String zzb;

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("grantType", (Object) this.zza);
        jSONObject.put("refreshToken", (Object) this.zzb);
        return jSONObject.toString();
    }

    public zzafa(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
    }
}
