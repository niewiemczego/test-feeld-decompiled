package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaem  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class zzaem implements zzacq<zzaem> {
    private static final String zza = "zzaem";
    private String zzb;
    private boolean zzc;
    private String zzd;
    private boolean zze;
    private zzagn zzf = zzagn.zza();
    private List<String> zzg;

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzaem zza(String str) throws zzaah {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("authUri", (String) null);
            this.zzc = jSONObject.optBoolean("registered", false);
            this.zzd = jSONObject.optString("providerId", (String) null);
            this.zze = jSONObject.optBoolean("forExistingProvider", false);
            if (!jSONObject.has("allProviders")) {
                this.zzf = zzagn.zza();
            } else {
                this.zzf = new zzagn(1, zzahb.zza(jSONObject.optJSONArray("allProviders")));
            }
            this.zzg = zzahb.zza(jSONObject.optJSONArray("signinMethods"));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzahb.zza((Exception) e, zza, str);
        }
    }

    public final List<String> zza() {
        return this.zzg;
    }
}
