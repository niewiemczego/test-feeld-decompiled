package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.braze.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpg;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzgf {
    private final String zza;
    private final Bundle zzb = new Bundle();
    private Bundle zzc;
    private final /* synthetic */ zzgd zzd;

    /* JADX WARNING: Can't wrap try/catch for region: R(3:62|63|74) */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r14.zzd.zzj().zzg().zza("Error reading value from SharedPreferences. Value dropped");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x0127 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zza() {
        /*
            r14 = this;
            android.os.Bundle r0 = r14.zzc
            if (r0 != 0) goto L_0x0154
            com.google.android.gms.measurement.internal.zzgd r0 = r14.zzd
            android.content.SharedPreferences r0 = r0.zzc()
            java.lang.String r1 = r14.zza
            r2 = 0
            java.lang.String r0 = r0.getString(r1, r2)
            if (r0 == 0) goto L_0x014c
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ JSONException -> 0x013d }
            r1.<init>()     // Catch:{ JSONException -> 0x013d }
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x013d }
            r2.<init>((java.lang.String) r0)     // Catch:{ JSONException -> 0x013d }
            r0 = 0
            r3 = r0
        L_0x001f:
            int r4 = r2.length()     // Catch:{ JSONException -> 0x013d }
            if (r3 >= r4) goto L_0x013a
            org.json.JSONObject r4 = r2.getJSONObject(r3)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            java.lang.String r5 = "n"
            java.lang.String r5 = r4.getString(r5)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            java.lang.String r6 = "t"
            java.lang.String r6 = r4.getString(r6)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            r7 = -1
            int r8 = r6.hashCode()     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            r9 = 100
            r10 = 4
            r11 = 3
            r12 = 2
            r13 = 1
            if (r8 == r9) goto L_0x007b
            r9 = 108(0x6c, float:1.51E-43)
            if (r8 == r9) goto L_0x0071
            r9 = 115(0x73, float:1.61E-43)
            if (r8 == r9) goto L_0x0067
            r9 = 3352(0xd18, float:4.697E-42)
            if (r8 == r9) goto L_0x005d
            r9 = 3445(0xd75, float:4.827E-42)
            if (r8 == r9) goto L_0x0053
            goto L_0x0084
        L_0x0053:
            java.lang.String r8 = "la"
            boolean r8 = r6.equals(r8)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            if (r8 == 0) goto L_0x0084
            r7 = r10
            goto L_0x0084
        L_0x005d:
            java.lang.String r8 = "ia"
            boolean r8 = r6.equals(r8)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            if (r8 == 0) goto L_0x0084
            r7 = r11
            goto L_0x0084
        L_0x0067:
            java.lang.String r8 = "s"
            boolean r8 = r6.equals(r8)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            if (r8 == 0) goto L_0x0084
            r7 = r0
            goto L_0x0084
        L_0x0071:
            java.lang.String r8 = "l"
            boolean r8 = r6.equals(r8)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            if (r8 == 0) goto L_0x0084
            r7 = r12
            goto L_0x0084
        L_0x007b:
            java.lang.String r8 = "d"
            boolean r8 = r6.equals(r8)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            if (r8 == 0) goto L_0x0084
            r7 = r13
        L_0x0084:
            java.lang.String r8 = "v"
            if (r7 == 0) goto L_0x011f
            if (r7 == r13) goto L_0x0113
            if (r7 == r12) goto L_0x0107
            if (r7 == r11) goto L_0x00d4
            if (r7 == r10) goto L_0x00a1
            com.google.android.gms.measurement.internal.zzgd r4 = r14.zzd     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzj()     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            com.google.android.gms.measurement.internal.zzft r4 = r4.zzg()     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            java.lang.String r5 = "Unrecognized persisted bundle type. Type"
            r4.zza(r5, r6)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            goto L_0x0136
        L_0x00a1:
            boolean r6 = com.google.android.gms.internal.measurement.zzpg.zza()     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            if (r6 == 0) goto L_0x0136
            com.google.android.gms.measurement.internal.zzgd r6 = r14.zzd     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            com.google.android.gms.measurement.internal.zzaf r6 = r6.zze()     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbi.zzcg     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean>) r7)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            if (r6 == 0) goto L_0x0136
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            java.lang.String r4 = r4.getString(r8)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            r6.<init>((java.lang.String) r4)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            int r4 = r6.length()     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            long[] r7 = new long[r4]     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            r8 = r0
        L_0x00c5:
            if (r8 >= r4) goto L_0x00d0
            long r9 = r6.optLong(r8)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            r7[r8] = r9     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            int r8 = r8 + 1
            goto L_0x00c5
        L_0x00d0:
            r1.putLongArray(r5, r7)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            goto L_0x0136
        L_0x00d4:
            boolean r6 = com.google.android.gms.internal.measurement.zzpg.zza()     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            if (r6 == 0) goto L_0x0136
            com.google.android.gms.measurement.internal.zzgd r6 = r14.zzd     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            com.google.android.gms.measurement.internal.zzaf r6 = r6.zze()     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbi.zzcg     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean>) r7)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            if (r6 == 0) goto L_0x0136
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            java.lang.String r4 = r4.getString(r8)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            r6.<init>((java.lang.String) r4)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            int r4 = r6.length()     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            int[] r7 = new int[r4]     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            r8 = r0
        L_0x00f8:
            if (r8 >= r4) goto L_0x0103
            int r9 = r6.optInt(r8)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            r7[r8] = r9     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            int r8 = r8 + 1
            goto L_0x00f8
        L_0x0103:
            r1.putIntArray(r5, r7)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            goto L_0x0136
        L_0x0107:
            java.lang.String r4 = r4.getString(r8)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            long r6 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            r1.putLong(r5, r6)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            goto L_0x0136
        L_0x0113:
            java.lang.String r4 = r4.getString(r8)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            double r6 = java.lang.Double.parseDouble(r4)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            r1.putDouble(r5, r6)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            goto L_0x0136
        L_0x011f:
            java.lang.String r4 = r4.getString(r8)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            r1.putString(r5, r4)     // Catch:{ NumberFormatException | JSONException -> 0x0127 }
            goto L_0x0136
        L_0x0127:
            com.google.android.gms.measurement.internal.zzgd r4 = r14.zzd     // Catch:{ JSONException -> 0x013d }
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzj()     // Catch:{ JSONException -> 0x013d }
            com.google.android.gms.measurement.internal.zzft r4 = r4.zzg()     // Catch:{ JSONException -> 0x013d }
            java.lang.String r5 = "Error reading value from SharedPreferences. Value dropped"
            r4.zza(r5)     // Catch:{ JSONException -> 0x013d }
        L_0x0136:
            int r3 = r3 + 1
            goto L_0x001f
        L_0x013a:
            r14.zzc = r1     // Catch:{ JSONException -> 0x013d }
            goto L_0x014c
        L_0x013d:
            com.google.android.gms.measurement.internal.zzgd r0 = r14.zzd
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzft r0 = r0.zzg()
            java.lang.String r1 = "Error loading bundle from SharedPreferences. Values will be lost"
            r0.zza(r1)
        L_0x014c:
            android.os.Bundle r0 = r14.zzc
            if (r0 != 0) goto L_0x0154
            android.os.Bundle r0 = r14.zzb
            r14.zzc = r0
        L_0x0154:
            android.os.Bundle r0 = r14.zzc
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgf.zza():android.os.Bundle");
    }

    private final String zzb(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(Constants.BRAZE_PUSH_CUSTOM_NOTIFICATION_ID, (Object) str);
                    if (zzpg.zza()) {
                        if (this.zzd.zze().zza(zzbi.zzcg)) {
                            if (obj instanceof String) {
                                jSONObject.put("v", (Object) String.valueOf(obj));
                                jSONObject.put(Constants.BRAZE_PUSH_TITLE_KEY, (Object) Constants.BRAZE_PUSH_SUMMARY_TEXT_KEY);
                            } else if (obj instanceof Long) {
                                jSONObject.put("v", (Object) String.valueOf(obj));
                                jSONObject.put(Constants.BRAZE_PUSH_TITLE_KEY, (Object) "l");
                            } else if (obj instanceof int[]) {
                                jSONObject.put("v", (Object) Arrays.toString((int[]) obj));
                                jSONObject.put(Constants.BRAZE_PUSH_TITLE_KEY, (Object) "ia");
                            } else if (obj instanceof long[]) {
                                jSONObject.put("v", (Object) Arrays.toString((long[]) obj));
                                jSONObject.put(Constants.BRAZE_PUSH_TITLE_KEY, (Object) "la");
                            } else if (obj instanceof Double) {
                                jSONObject.put("v", (Object) String.valueOf(obj));
                                jSONObject.put(Constants.BRAZE_PUSH_TITLE_KEY, (Object) Constants.BRAZE_PUSH_NOTIFICATION_SOUND_DEFAULT_VALUE);
                            } else {
                                this.zzd.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                            }
                            jSONArray.put((Object) jSONObject);
                        }
                    }
                    jSONObject.put("v", (Object) String.valueOf(obj));
                    if (obj instanceof String) {
                        jSONObject.put(Constants.BRAZE_PUSH_TITLE_KEY, (Object) Constants.BRAZE_PUSH_SUMMARY_TEXT_KEY);
                    } else if (obj instanceof Long) {
                        jSONObject.put(Constants.BRAZE_PUSH_TITLE_KEY, (Object) "l");
                    } else if (obj instanceof Double) {
                        jSONObject.put(Constants.BRAZE_PUSH_TITLE_KEY, (Object) Constants.BRAZE_PUSH_NOTIFICATION_SOUND_DEFAULT_VALUE);
                    } else {
                        this.zzd.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                    }
                    jSONArray.put((Object) jSONObject);
                } catch (JSONException e) {
                    this.zzd.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences", e);
                }
            }
        }
        return jSONArray.toString();
    }

    public zzgf(zzgd zzgd, String str, Bundle bundle) {
        this.zzd = zzgd;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
    }

    public final void zza(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor edit = this.zzd.zzc().edit();
        if (bundle.size() == 0) {
            edit.remove(this.zza);
        } else {
            edit.putString(this.zza, zzb(bundle));
        }
        edit.apply();
        this.zzc = bundle;
    }
}
