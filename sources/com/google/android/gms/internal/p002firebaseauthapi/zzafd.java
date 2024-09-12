package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeSettings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzafd implements zzacr {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private ActionCodeSettings zze;
    private String zzf;
    private String zzg;

    private static String zza(int i) {
        return i != 1 ? i != 4 ? i != 6 ? i != 7 ? "REQUEST_TYPE_UNSET_ENUM_VALUE" : "VERIFY_AND_CHANGE_EMAIL" : "EMAIL_SIGNIN" : "VERIFY_EMAIL" : "PASSWORD_RESET";
    }

    public final ActionCodeSettings zzb() {
        return this.zze;
    }

    public static zzafd zza(ActionCodeSettings actionCodeSettings, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(actionCodeSettings);
        return new zzafd(7, actionCodeSettings, (String) null, str2, str, (String) null, (String) null);
    }

    public final zzafd zza(ActionCodeSettings actionCodeSettings) {
        this.zze = (ActionCodeSettings) Preconditions.checkNotNull(actionCodeSettings);
        return this;
    }

    public final zzafd zza(String str) {
        this.zzg = str;
        return this;
    }

    public final zzafd zzb(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzafd zzc(String str) {
        this.zzf = str;
        return this;
    }

    public final zzafd zzd(String str) {
        this.zzd = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = this.zza;
        str.hashCode();
        int i = 1;
        char c = 65535;
        switch (str.hashCode()) {
            case -1452371317:
                if (str.equals("PASSWORD_RESET")) {
                    c = 0;
                    break;
                }
                break;
            case -1341836234:
                if (str.equals("VERIFY_EMAIL")) {
                    c = 1;
                    break;
                }
                break;
            case -1099157829:
                if (str.equals("VERIFY_AND_CHANGE_EMAIL")) {
                    c = 2;
                    break;
                }
                break;
            case 870738373:
                if (str.equals("EMAIL_SIGNIN")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                break;
            case 1:
                i = 4;
                break;
            case 2:
                i = 7;
                break;
            case 3:
                i = 6;
                break;
            default:
                i = 0;
                break;
        }
        jSONObject.put("requestType", i);
        String str2 = this.zzb;
        if (str2 != null) {
            jSONObject.put("email", (Object) str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            jSONObject.put("newEmail", (Object) str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            jSONObject.put("idToken", (Object) str4);
        }
        ActionCodeSettings actionCodeSettings = this.zze;
        if (actionCodeSettings != null) {
            jSONObject.put("androidInstallApp", actionCodeSettings.getAndroidInstallApp());
            jSONObject.put("canHandleCodeInApp", this.zze.canHandleCodeInApp());
            if (this.zze.getUrl() != null) {
                jSONObject.put("continueUrl", (Object) this.zze.getUrl());
            }
            if (this.zze.getIOSBundle() != null) {
                jSONObject.put("iosBundleId", (Object) this.zze.getIOSBundle());
            }
            if (this.zze.zzd() != null) {
                jSONObject.put("iosAppStoreId", (Object) this.zze.zzd());
            }
            if (this.zze.getAndroidPackageName() != null) {
                jSONObject.put("androidPackageName", (Object) this.zze.getAndroidPackageName());
            }
            if (this.zze.getAndroidMinimumVersion() != null) {
                jSONObject.put("androidMinimumVersion", (Object) this.zze.getAndroidMinimumVersion());
            }
            if (this.zze.zzc() != null) {
                jSONObject.put("dynamicLinkDomain", (Object) this.zze.zzc());
            }
        }
        String str5 = this.zzf;
        if (str5 != null) {
            jSONObject.put("tenantId", (Object) str5);
        }
        String str6 = this.zzg;
        if (str6 != null) {
            zzahb.zza(jSONObject, "captchaResp", str6);
        } else {
            zzahb.zza(jSONObject);
        }
        return jSONObject.toString();
    }

    public zzafd(int i) {
        this.zza = zza(i);
    }

    private zzafd(int i, ActionCodeSettings actionCodeSettings, String str, String str2, String str3, String str4, String str5) {
        this.zza = zza(7);
        this.zze = (ActionCodeSettings) Preconditions.checkNotNull(actionCodeSettings);
        this.zzb = null;
        this.zzc = str2;
        this.zzd = str3;
        this.zzf = null;
        this.zzg = null;
    }
}
