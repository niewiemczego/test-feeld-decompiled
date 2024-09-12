package com.google.android.gms.internal.p002firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzagm extends zzagi {
    private static final String zza = "zzagm";
    private String zzb;

    public final /* synthetic */ zzacq zza(String str) throws zzaah {
        return (zzagm) zza(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final zzagm zzb(String str) throws zzaah {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("phoneSessionInfo");
            if (optJSONObject != null) {
                this.zzb = zzah.zza(optJSONObject.optString("sessionInfo"));
            }
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzahb.zza((Exception) e, zza, str);
        }
    }

    public final String zza() {
        return this.zzb;
    }
}
