package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzagj implements zzagf {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private zzaed zzg;
    private final String zzh = null;

    public static zzagj zza(String str, String str2, String str3, String str4, String str5, String str6) {
        Preconditions.checkNotEmpty(str2);
        return new zzagj(str, "phone", str2, str3, str4, str5, (String) null);
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", (Object) this.zza);
        jSONObject.put("mfaProvider", 1);
        if (this.zzc != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, (Object) this.zzc);
            if (!TextUtils.isEmpty(this.zze)) {
                jSONObject2.put("recaptchaToken", (Object) this.zze);
            }
            if (!TextUtils.isEmpty(this.zzf)) {
                jSONObject2.put("playIntegrityToken", (Object) this.zzf);
            }
            zzaed zzaed = this.zzg;
            if (zzaed != null) {
                jSONObject2.put("autoRetrievalInfo", (Object) zzaed.zza());
            }
            jSONObject.put("phoneEnrollmentInfo", (Object) jSONObject2);
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            jSONObject.put("tenantId", (Object) null);
        }
        return jSONObject.toString();
    }

    private zzagj(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
    }

    public final void zza(zzaed zzaed) {
        this.zzg = zzaed;
    }
}
