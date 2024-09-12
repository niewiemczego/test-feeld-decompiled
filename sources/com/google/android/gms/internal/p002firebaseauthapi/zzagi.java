package com.google.android.gms.internal.p002firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class zzagi implements zzacq<zzagi> {
    private static final String zza = "zzagi";

    public String zza() {
        return null;
    }

    /* renamed from: zzb */
    public zzagi zza(String str) throws zzaah {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optJSONObject("phoneSessionInfo") != null) {
                return (zzagm) ((zzagi) new zzagm().zza(str));
            }
            if (jSONObject.optJSONObject("totpSessionInfo") != null) {
                return (zzago) ((zzagi) new zzago().zza(str));
            }
            throw new IllegalArgumentException("Missing phoneSessionInfo or totpSessionInfo.");
        } catch (NullPointerException | JSONException e) {
            throw zzahb.zza((Exception) e, zza, str);
        }
    }
}
