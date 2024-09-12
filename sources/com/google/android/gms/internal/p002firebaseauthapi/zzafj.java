package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class zzafj implements zzacq<zzafj> {
    private static final String zza = "zzafj";
    private String zzb;
    private zzaq<zzaft> zzc;

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final zzafj zza(String str) throws zzaah {
        zzaq<zzaft> zzaq;
        zzaft zzaft;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("recaptchaKey"));
            if (jSONObject.has("recaptchaEnforcementState")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("recaptchaEnforcementState");
                if (optJSONArray != null) {
                    if (optJSONArray.length() != 0) {
                        zzap zzg = zzaq.zzg();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                            if (jSONObject2 == null) {
                                zzaft = zzaft.zza((String) null, (String) null);
                            } else {
                                zzaft = zzaft.zza(Strings.emptyToNull(jSONObject2.optString("provider")), Strings.emptyToNull(jSONObject2.optString("enforcementState")));
                            }
                            zzg.zza(zzaft);
                        }
                        zzaq = zzg.zza();
                        this.zzc = zzaq;
                    }
                }
                zzaq = zzaq.zza(new ArrayList());
                this.zzc = zzaq;
            }
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzahb.zza((Exception) e, zza, str);
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb(String str) {
        Preconditions.checkNotEmpty(str);
        zzaq<zzaft> zzaq = this.zzc;
        String str2 = null;
        if (zzaq != null && !zzaq.isEmpty()) {
            zzaq<zzaft> zzaq2 = this.zzc;
            zzaq zzaq3 = zzaq2;
            int size = zzaq2.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                Object obj = zzaq2.get(i);
                i++;
                zzaft zzaft = (zzaft) obj;
                String zza2 = zzaft.zza();
                String zzb2 = zzaft.zzb();
                if (zza2 != null && zzb2 != null && zzb2.equals(str)) {
                    str2 = zzaft.zza();
                    break;
                }
            }
        }
        if (str2 == null) {
            return false;
        }
        if (str2.equals("ENFORCE") || str2.equals("AUDIT")) {
            return true;
        }
        return false;
    }
}
