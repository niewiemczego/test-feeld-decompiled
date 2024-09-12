package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzahb {
    public static zzaah zza(Exception exc, String str, String str2) {
        Log.e(str, "Failed to parse " + str + " for string [" + str2 + "] with exception: " + exc.getMessage());
        return new zzaah("Failed to parse " + str + " for string [" + str2 + "]", exc);
    }

    public static List<String> zza(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        }
        return arrayList;
    }

    public static void zza(JSONObject jSONObject) throws JSONException {
        jSONObject.put("clientType", (Object) "CLIENT_TYPE_ANDROID");
    }

    public static void zza(JSONObject jSONObject, String str, String str2) throws JSONException {
        jSONObject.put(str, (Object) str2);
        jSONObject.put("recaptchaVersion", (Object) "RECAPTCHA_ENTERPRISE");
        jSONObject.put("clientType", (Object) "CLIENT_TYPE_ANDROID");
    }
}
