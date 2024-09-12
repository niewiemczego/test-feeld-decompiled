package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.TotpMultiFactorGenerator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaev  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzaev implements zzaes {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;

    public static zzaev zza(String str, String str2, String str3, String str4) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str4);
        return new zzaev(TotpMultiFactorGenerator.FACTOR_ID, str, str2, str3, str4);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String str = this.zzc;
        if (str != null) {
            jSONObject2.put("verificationCode", (Object) str);
        }
        jSONObject.put("totpVerificationInfo", (Object) jSONObject2);
        jSONObject.put("mfaPendingCredential", (Object) this.zzb);
        String str2 = this.zzd;
        if (str2 != null) {
            jSONObject.put("tenantId", (Object) str2);
        }
        String str3 = this.zze;
        if (str3 != null) {
            jSONObject.put("mfaEnrollmentId", (Object) str3);
        }
        return jSONObject.toString();
    }

    private zzaev(String str, String str2, String str3, String str4, String str5) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
    }
}
