package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Log;
import com.facebook.AuthenticationTokenClaims;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzafn {
    private String zza;
    private String zzb;
    private String zzc;
    private Long zzd;
    private Long zze;
    private boolean zzf;

    public static zzafn zza(String str) throws UnsupportedEncodingException {
        try {
            zzafn zzafn = new zzafn();
            JSONObject jSONObject = new JSONObject(str);
            zzafn.zza = jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_ISS);
            zzafn.zzb = jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_AUD);
            zzafn.zzc = jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_SUB);
            zzafn.zzd = Long.valueOf(jSONObject.optLong(AuthenticationTokenClaims.JSON_KEY_IAT));
            zzafn.zze = Long.valueOf(jSONObject.optLong(AuthenticationTokenClaims.JSON_KEY_EXP));
            zzafn.zzf = jSONObject.optBoolean("is_anonymous");
            return zzafn;
        } catch (JSONException e) {
            if (Log.isLoggable("JwtToken", 3)) {
                Log.d("JwtToken", "Failed to read JwtToken from JSONObject. " + String.valueOf(e));
            }
            throw new UnsupportedEncodingException("Failed to read JwtToken from JSONObject. " + String.valueOf(e));
        }
    }

    public final Long zza() {
        return this.zze;
    }

    public final Long zzb() {
        return this.zzd;
    }
}
