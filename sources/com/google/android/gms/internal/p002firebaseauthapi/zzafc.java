package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.autofill.HintConstants;
import com.google.android.gms.common.util.Strings;
import com.google.firebase.auth.zzd;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class zzafc implements zzacq<zzafc> {
    private static final String zza = "zzafc";
    private zzafe zzb;

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzafc zza(String str) throws zzaah {
        zzafe zzafe;
        int i;
        zzafb zzafb;
        String str2 = str;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (!jSONObject.has("users")) {
                zzafe = new zzafe();
            } else {
                JSONArray optJSONArray = jSONObject.optJSONArray("users");
                if (optJSONArray != null) {
                    if (optJSONArray.length() != 0) {
                        ArrayList arrayList = new ArrayList(optJSONArray.length());
                        boolean z = false;
                        int i2 = 0;
                        while (i2 < optJSONArray.length()) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                            if (jSONObject2 == null) {
                                zzafb = new zzafb();
                                i = i2;
                            } else {
                                i = i2;
                                zzafb = new zzafb(Strings.emptyToNull(jSONObject2.optString("localId", (String) null)), Strings.emptyToNull(jSONObject2.optString("email", (String) null)), jSONObject2.optBoolean("emailVerified", z), Strings.emptyToNull(jSONObject2.optString("displayName", (String) null)), Strings.emptyToNull(jSONObject2.optString("photoUrl", (String) null)), zzafu.zza(jSONObject2.optJSONArray("providerUserInfo")), Strings.emptyToNull(jSONObject2.optString("rawPassword", (String) null)), Strings.emptyToNull(jSONObject2.optString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, (String) null)), jSONObject2.optLong("createdAt", 0), jSONObject2.optLong("lastLoginAt", 0), false, (zzd) null, zzafq.zza(jSONObject2.optJSONArray("mfaInfo")), zzafp.zza(jSONObject2.optJSONArray("passkeyInfo")));
                            }
                            arrayList.add(zzafb);
                            i2 = i + 1;
                            z = false;
                        }
                        zzafe = new zzafe(arrayList);
                    }
                }
                zzafe = new zzafe(new ArrayList());
            }
            this.zzb = zzafe;
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzahb.zza((Exception) e, zza, str2);
        }
    }

    public final List<zzafb> zza() {
        return this.zzb.zza();
    }
}
