package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzagh implements zzacr {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private zzaed zzh;

    public static zzagh zza(String str, String str2, String str3, String str4, String str5, String str6) {
        Preconditions.checkNotEmpty(str3);
        return new zzagh("phone", str, str2, str3, str4, str5, str6);
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mfaPendingCredential", (Object) this.zzb);
        jSONObject.put("mfaEnrollmentId", (Object) this.zzc);
        this.zza.hashCode();
        jSONObject.put("mfaProvider", 1);
        if (this.zze != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, (Object) this.zze);
            if (!TextUtils.isEmpty(this.zzf)) {
                jSONObject2.put("recaptchaToken", (Object) this.zzf);
            }
            if (!TextUtils.isEmpty(this.zzg)) {
                jSONObject2.put("playIntegrityToken", (Object) this.zzg);
            }
            zzaed zzaed = this.zzh;
            if (zzaed != null) {
                jSONObject2.put("autoRetrievalInfo", (Object) zzaed.zza());
            }
            jSONObject.put("phoneSignInInfo", (Object) jSONObject2);
        }
        return jSONObject.toString();
    }

    private zzagh(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = Preconditions.checkNotEmpty(str3);
        this.zze = str4;
        this.zzd = str5;
        this.zzf = str6;
        this.zzg = str7;
    }

    public final void zza(zzaed zzaed) {
        this.zzh = zzaed;
    }
}
