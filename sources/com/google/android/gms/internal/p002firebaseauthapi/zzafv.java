package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class zzafv implements zzacq<zzafv> {
    private static final String zza = "zzafv";
    private String zzb;
    private String zzc;
    private String zzd;
    private zzafq zze;

    public final zzafq zza() {
        return this.zze;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0091, code lost:
        r5 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0092, code lost:
        if (r5 == 0) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0094, code lost:
        if (r5 == 1) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0096, code lost:
        if (r5 == 2) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0098, code lost:
        if (r5 == 3) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009a, code lost:
        if (r5 == 4) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009d, code lost:
        if (r5 == 5) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009f, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a1, code lost:
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a2, code lost:
        r1.zzd = r10;
     */
    /* renamed from: zzb */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.p002firebaseauthapi.zzafv zza(java.lang.String r17) throws com.google.android.gms.internal.p002firebaseauthapi.zzaah {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            java.lang.String r0 = "mfaInfo"
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            r3.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            java.lang.String r4 = "email"
            java.lang.String r4 = r3.optString(r4)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            java.lang.String r4 = com.google.android.gms.common.util.Strings.emptyToNull(r4)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            r1.zzb = r4     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            java.lang.String r4 = "newEmail"
            java.lang.String r4 = r3.optString(r4)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            java.lang.String r4 = com.google.android.gms.common.util.Strings.emptyToNull(r4)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            r1.zzc = r4     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            java.lang.String r4 = "reqType"
            int r4 = r3.optInt(r4)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            java.lang.String r5 = "REVERT_SECOND_FACTOR_ADDITION"
            java.lang.String r6 = "VERIFY_AND_CHANGE_EMAIL"
            java.lang.String r7 = "EMAIL_SIGNIN"
            java.lang.String r8 = "RECOVER_EMAIL"
            java.lang.String r9 = "VERIFY_EMAIL"
            java.lang.String r11 = "PASSWORD_RESET"
            r12 = 1
            if (r4 == r12) goto L_0x0047
            switch(r4) {
                case 4: goto L_0x0045;
                case 5: goto L_0x0043;
                case 6: goto L_0x0041;
                case 7: goto L_0x003f;
                case 8: goto L_0x003d;
                default: goto L_0x003b;
            }
        L_0x003b:
            r4 = 0
            goto L_0x0048
        L_0x003d:
            r4 = r5
            goto L_0x0048
        L_0x003f:
            r4 = r6
            goto L_0x0048
        L_0x0041:
            r4 = r7
            goto L_0x0048
        L_0x0043:
            r4 = r8
            goto L_0x0048
        L_0x0045:
            r4 = r9
            goto L_0x0048
        L_0x0047:
            r4 = r11
        L_0x0048:
            r1.zzd = r4     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            if (r4 == 0) goto L_0x00a4
            java.lang.String r4 = "requestType"
            java.lang.String r4 = r3.optString(r4)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            int r14 = r4.hashCode()     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            r10 = 4
            r13 = 3
            r15 = 2
            switch(r14) {
                case -1874510116: goto L_0x0089;
                case -1452371317: goto L_0x0081;
                case -1341836234: goto L_0x0079;
                case -1099157829: goto L_0x0071;
                case 870738373: goto L_0x0069;
                case 970484929: goto L_0x0061;
                default: goto L_0x0060;
            }     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
        L_0x0060:
            goto L_0x0091
        L_0x0061:
            boolean r5 = r4.equals(r8)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            if (r5 == 0) goto L_0x0091
            r5 = r10
            goto L_0x0092
        L_0x0069:
            boolean r5 = r4.equals(r7)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            if (r5 == 0) goto L_0x0091
            r5 = r15
            goto L_0x0092
        L_0x0071:
            boolean r5 = r4.equals(r6)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            if (r5 == 0) goto L_0x0091
            r5 = r13
            goto L_0x0092
        L_0x0079:
            boolean r5 = r4.equals(r9)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            if (r5 == 0) goto L_0x0091
            r5 = 0
            goto L_0x0092
        L_0x0081:
            boolean r5 = r4.equals(r11)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            if (r5 == 0) goto L_0x0091
            r5 = r12
            goto L_0x0092
        L_0x0089:
            boolean r5 = r4.equals(r5)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            if (r5 == 0) goto L_0x0091
            r5 = 5
            goto L_0x0092
        L_0x0091:
            r5 = -1
        L_0x0092:
            if (r5 == 0) goto L_0x00a1
            if (r5 == r12) goto L_0x00a1
            if (r5 == r15) goto L_0x00a1
            if (r5 == r13) goto L_0x00a1
            if (r5 == r10) goto L_0x00a1
            r6 = 5
            if (r5 == r6) goto L_0x00a1
            r10 = 0
            goto L_0x00a2
        L_0x00a1:
            r10 = r4
        L_0x00a2:
            r1.zzd = r10     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
        L_0x00a4:
            boolean r4 = r3.has(r0)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            if (r4 == 0) goto L_0x00b4
            org.json.JSONObject r0 = r3.optJSONObject(r0)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            com.google.android.gms.internal.firebase-auth-api.zzafq r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafq.zza((org.json.JSONObject) r0)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            r1.zze = r0     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
        L_0x00b4:
            return r1
        L_0x00b5:
            r0 = move-exception
            goto L_0x00b8
        L_0x00b7:
            r0 = move-exception
        L_0x00b8:
            java.lang.String r3 = zza
            com.google.android.gms.internal.firebase-auth-api.zzaah r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahb.zza((java.lang.Exception) r0, (java.lang.String) r3, (java.lang.String) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzafv.zza(java.lang.String):com.google.android.gms.internal.firebase-auth-api.zzafv");
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }

    public final boolean zze() {
        return this.zzb != null;
    }

    public final boolean zzf() {
        return this.zze != null;
    }

    public final boolean zzg() {
        return this.zzc != null;
    }

    public final boolean zzh() {
        return this.zzd != null;
    }
}
