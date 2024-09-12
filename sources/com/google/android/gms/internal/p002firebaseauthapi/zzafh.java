package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class zzafh implements zzacq<zzafh> {
    private static final String zza = "zzafh";
    private List<String> zzb;

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzafh zza(String str) throws zzaah {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("authorizedDomains");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.zzb.add(optJSONArray.getString(i));
                }
            }
            return this;
        } catch (JSONException e) {
            throw zzahb.zza((Exception) e, zza, str);
        }
    }

    public final List<String> zza() {
        return this.zzb;
    }
}
