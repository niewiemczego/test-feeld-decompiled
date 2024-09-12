package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class zzagg implements zzacq<zzagg> {
    private static final String zza = "zzagg";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private long zzf;

    public final long zza() {
        return this.zzf;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzagg zza(String str) throws zzaah {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("idToken", (String) null));
            this.zzc = Strings.emptyToNull(jSONObject.optString("displayName", (String) null));
            this.zzd = Strings.emptyToNull(jSONObject.optString("email", (String) null));
            this.zze = Strings.emptyToNull(jSONObject.optString("refreshToken", (String) null));
            this.zzf = jSONObject.optLong("expiresIn", 0);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzahb.zza((Exception) e, zza, str);
        }
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zze;
    }
}
