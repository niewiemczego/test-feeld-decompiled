package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzagx implements zzacr {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;

    public static zzagx zza(String str, String str2, boolean z) {
        zzagx zzagx = new zzagx();
        zzagx.zzb = Preconditions.checkNotEmpty(str);
        zzagx.zzc = Preconditions.checkNotEmpty(str2);
        zzagx.zzf = z;
        return zzagx;
    }

    public static zzagx zzb(String str, String str2, boolean z) {
        zzagx zzagx = new zzagx();
        zzagx.zza = Preconditions.checkNotEmpty(str);
        zzagx.zzd = Preconditions.checkNotEmpty(str2);
        zzagx.zzf = z;
        return zzagx;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zzd)) {
            jSONObject.put(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, (Object) this.zza);
            jSONObject.put("temporaryProof", (Object) this.zzd);
        } else {
            jSONObject.put("sessionInfo", (Object) this.zzb);
            jSONObject.put("code", (Object) this.zzc);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", (Object) str);
        }
        if (!this.zzf) {
            jSONObject.put("operation", 2);
        }
        return jSONObject.toString();
    }

    private zzagx() {
    }

    public final void zza(String str) {
        this.zze = str;
    }
}
