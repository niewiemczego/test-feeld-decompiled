package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzago  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzago extends zzagi {
    private static final String zza = "zzago";
    private String zzb;
    private String zzc;
    private int zzd;
    private String zze;
    private int zzf;
    private long zzg;

    public final int zzb() {
        return this.zzf;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final long zzd() {
        return this.zzg;
    }

    public final /* synthetic */ zzacq zza(String str) throws zzaah {
        return (zzago) zza(str);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0052 */
    /* renamed from: zzc */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.p002firebaseauthapi.zzago zzb(java.lang.String r5) throws com.google.android.gms.internal.p002firebaseauthapi.zzaah {
        /*
            r4 = this;
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            r0.<init>((java.lang.String) r5)     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            java.lang.String r1 = "totpSessionInfo"
            org.json.JSONObject r0 = r0.optJSONObject(r1)     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            if (r0 == 0) goto L_0x0066
            java.lang.String r1 = "sharedSecretKey"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            java.lang.String r1 = com.google.android.gms.internal.p002firebaseauthapi.zzah.zza((java.lang.String) r1)     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            r4.zzc = r1     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            java.lang.String r1 = "verificationCodeLength"
            int r1 = r0.optInt(r1)     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            r4.zzd = r1     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            java.lang.String r1 = "hashingAlgorithm"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            java.lang.String r1 = com.google.android.gms.internal.p002firebaseauthapi.zzah.zza((java.lang.String) r1)     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            r4.zze = r1     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            java.lang.String r1 = "periodSec"
            int r1 = r0.optInt(r1)     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            r4.zzf = r1     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            java.lang.String r1 = "sessionInfo"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            java.lang.String r1 = com.google.android.gms.internal.p002firebaseauthapi.zzah.zza((java.lang.String) r1)     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            r4.zzb = r1     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            java.lang.String r1 = "finalizeEnrollmentTime"
            java.lang.String r0 = r0.optString(r1)     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            com.google.android.gms.internal.firebase-auth-api.zzaly r1 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((java.lang.String) r0)     // Catch:{ ParseException -> 0x0052 }
            long r1 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((com.google.android.gms.internal.p002firebaseauthapi.zzaly) r1)     // Catch:{ ParseException -> 0x0052 }
            r4.zzg = r1     // Catch:{ ParseException -> 0x0052 }
            goto L_0x0066
        L_0x0052:
            java.lang.String r1 = zza     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            java.lang.String r3 = "Failed to parse timestamp: "
            r2.<init>(r3)     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
            android.util.Log.e(r1, r0)     // Catch:{ JSONException -> 0x0069, NullPointerException -> 0x0067 }
        L_0x0066:
            return r4
        L_0x0067:
            r0 = move-exception
            goto L_0x006a
        L_0x0069:
            r0 = move-exception
        L_0x006a:
            java.lang.String r1 = zza
            com.google.android.gms.internal.firebase-auth-api.zzaah r5 = com.google.android.gms.internal.p002firebaseauthapi.zzahb.zza((java.lang.Exception) r0, (java.lang.String) r1, (java.lang.String) r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzago.zzb(java.lang.String):com.google.android.gms.internal.firebase-auth-api.zzago");
    }

    public final String zze() {
        return this.zze;
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zzc;
    }
}
