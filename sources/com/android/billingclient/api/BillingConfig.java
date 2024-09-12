package com.android.billingclient.api;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class BillingConfig {
    private final String zza;
    private final JSONObject zzb;
    private final String zzc;

    BillingConfig(String str) throws JSONException {
        this.zza = str;
        JSONObject jSONObject = new JSONObject(str);
        this.zzb = jSONObject;
        this.zzc = jSONObject.optString("countryCode");
    }

    public String getCountryCode() {
        return this.zzc;
    }
}
