package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaet  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzaet implements zzaes {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;

    public static zzaet zza(String str, String str2, String str3, String str4) {
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotEmpty(str2);
        return new zzaet("phone", str, str2, str3, str4);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mfaProvider", 1);
        JSONObject jSONObject2 = new JSONObject();
        String str = this.zzc;
        if (str != null) {
            jSONObject2.put("sessionInfo", (Object) str);
        }
        String str2 = this.zzd;
        if (str2 != null) {
            jSONObject2.put("code", (Object) str2);
        }
        jSONObject.put("phoneVerificationInfo", (Object) jSONObject2);
        jSONObject.put("mfaPendingCredential", (Object) this.zzb);
        String str3 = this.zze;
        if (str3 != null) {
            jSONObject.put("tenantId", (Object) str3);
        }
        return jSONObject.toString();
    }

    private zzaet(String str, String str2, String str3, String str4, String str5) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
    }
}
