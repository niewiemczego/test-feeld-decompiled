package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzafw implements zzacr {
    private final String zza;
    private final String zzb;
    private final String zzc;

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("oobCode", (Object) this.zza);
        String str = this.zzb;
        if (str != null) {
            jSONObject.put(HintConstants.AUTOFILL_HINT_NEW_PASSWORD, (Object) str);
        }
        String str2 = this.zzc;
        if (str2 != null) {
            jSONObject.put("tenantId", (Object) str2);
        }
        return jSONObject.toString();
    }

    public zzafw(String str, String str2, String str3) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = str2;
        this.zzc = str3;
    }
}
