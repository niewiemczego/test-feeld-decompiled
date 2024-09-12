package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.autofill.HintConstants;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzafu {
    private List<zzafr> zza;

    public static zzafu zza(JSONArray jSONArray) throws JSONException {
        zzafr zzafr;
        if (jSONArray == null || jSONArray.length() == 0) {
            return new zzafu(new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject == null) {
                zzafr = new zzafr();
            } else {
                zzafr = new zzafr(Strings.emptyToNull(jSONObject.optString("federatedId", (String) null)), Strings.emptyToNull(jSONObject.optString("displayName", (String) null)), Strings.emptyToNull(jSONObject.optString("photoUrl", (String) null)), Strings.emptyToNull(jSONObject.optString("providerId", (String) null)), (String) null, Strings.emptyToNull(jSONObject.optString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, (String) null)), Strings.emptyToNull(jSONObject.optString("email", (String) null)));
            }
            arrayList.add(zzafr);
        }
        return new zzafu(arrayList);
    }

    public final List<zzafr> zza() {
        return this.zza;
    }

    public zzafu() {
        this.zza = new ArrayList();
    }

    private zzafu(List<zzafr> list) {
        if (!list.isEmpty()) {
            this.zza = Collections.unmodifiableList(list);
        } else {
            this.zza = Collections.emptyList();
        }
    }
}
