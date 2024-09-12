package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzafz implements zzacr {
    private final String zza;
    private final long zzb;
    private final boolean zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final boolean zzh;
    private zzaed zzi;

    public final long zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zza;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, (Object) this.zza);
        String str = this.zze;
        if (str != null) {
            jSONObject.put("tenantId", (Object) str);
        }
        String str2 = this.zzf;
        if (str2 != null) {
            jSONObject.put("recaptchaToken", (Object) str2);
        }
        zzaed zzaed = this.zzi;
        if (zzaed != null) {
            jSONObject.put("autoRetrievalInfo", (Object) zzaed.zza());
        }
        String str3 = this.zzg;
        if (str3 != null) {
            jSONObject.put("playIntegrityToken", (Object) str3);
        }
        return jSONObject.toString();
    }

    public zzafz(String str, long j, boolean z, String str2, String str3, String str4, String str5, boolean z2) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = j;
        this.zzc = z;
        this.zzd = str2;
        this.zze = str3;
        this.zzf = str4;
        this.zzg = str5;
        this.zzh = z2;
    }

    public final void zza(zzaed zzaed) {
        this.zzi = zzaed;
    }

    public final boolean zze() {
        return this.zzc;
    }

    public final boolean zzf() {
        return this.zzh;
    }
}
