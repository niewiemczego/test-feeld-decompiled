package com.google.firebase.auth;

import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzau;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.HashMap;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class ActionCodeUrl {
    private static final zzau<String, Integer> zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;

    public int getOperation() {
        zzau<String, Integer> zzau = zza;
        if (zzau.containsKey(this.zzd)) {
            return zzau.get(this.zzd).intValue();
        }
        return 3;
    }

    public static ActionCodeUrl parseLink(String str) {
        Preconditions.checkNotEmpty(str);
        try {
            return new ActionCodeUrl(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String getApiKey() {
        return this.zzb;
    }

    public String getCode() {
        return this.zzc;
    }

    public String getContinueUrl() {
        return this.zze;
    }

    public String getLanguageCode() {
        return this.zzf;
    }

    public final String zza() {
        return this.zzg;
    }

    private static String zza(String str, String str2) {
        Uri parse = Uri.parse(str);
        try {
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return parse.getQueryParameter(str2);
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(Preconditions.checkNotEmpty(parse.getQueryParameter("link"))).getQueryParameter(str2);
            }
            return null;
        } catch (NullPointerException | UnsupportedOperationException unused) {
            return null;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("recoverEmail", 2);
        hashMap.put("resetPassword", 0);
        hashMap.put("signIn", 4);
        hashMap.put("verifyEmail", 1);
        hashMap.put("verifyBeforeChangeEmail", 5);
        hashMap.put("revertSecondFactorAddition", 6);
        zza = zzau.zza(hashMap);
    }

    private ActionCodeUrl(String str) {
        String zza2 = zza(str, DynamicLink.Builder.KEY_API_KEY);
        String zza3 = zza(str, "oobCode");
        String zza4 = zza(str, "mode");
        if (zza2 == null || zza3 == null || zza4 == null) {
            throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", new Object[]{DynamicLink.Builder.KEY_API_KEY, "oobCode", "mode"}));
        }
        this.zzb = Preconditions.checkNotEmpty(zza2);
        this.zzc = Preconditions.checkNotEmpty(zza3);
        this.zzd = Preconditions.checkNotEmpty(zza4);
        this.zze = zza(str, "continueUrl");
        this.zzf = zza(str, "languageCode");
        this.zzg = zza(str, "tenantId");
    }
}
