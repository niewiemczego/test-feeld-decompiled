package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.ActionCodeUrl;
import com.google.firebase.auth.EmailAuthCredential;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaeo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class zzaeo implements zzacr {
    private static final String zza = "zzaeo";
    private static final Logger zzb = new Logger(zza, new String[0]);
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;

    public final String zza() throws JSONException {
        ActionCodeUrl parseLink = ActionCodeUrl.parseLink(this.zzd);
        String str = null;
        String code = parseLink != null ? parseLink.getCode() : null;
        if (parseLink != null) {
            str = parseLink.zza();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", (Object) this.zzc);
        if (code != null) {
            jSONObject.put("oobCode", (Object) code);
        }
        if (str != null) {
            jSONObject.put("tenantId", (Object) str);
        }
        String str2 = this.zze;
        if (str2 != null) {
            jSONObject.put("idToken", (Object) str2);
        }
        String str3 = this.zzf;
        if (str3 != null) {
            zzahb.zza(jSONObject, "captchaResp", str3);
        } else {
            zzahb.zza(jSONObject);
        }
        return jSONObject.toString();
    }

    public zzaeo(EmailAuthCredential emailAuthCredential, String str, String str2) {
        this.zzc = Preconditions.checkNotEmpty(emailAuthCredential.zzc());
        this.zzd = Preconditions.checkNotEmpty(emailAuthCredential.zze());
        this.zze = str;
        this.zzf = str2;
    }
}
