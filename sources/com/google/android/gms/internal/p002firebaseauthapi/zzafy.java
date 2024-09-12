package com.google.android.gms.internal.p002firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zzafy implements zzacr {
    public static zzafx zzg() {
        return new zzaei();
    }

    public abstract zzaex zzb();

    public abstract String zzc();

    public abstract String zzd();

    public abstract String zze();

    public abstract String zzf();

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", (Object) zzc());
        jSONObject.put("token", (Object) zzf());
        jSONObject.put("providerId", (Object) zzd());
        jSONObject.put("tokenType", (Object) zzb().toString());
        jSONObject.put("tenantId", (Object) zze());
        return jSONObject.toString();
    }
}
