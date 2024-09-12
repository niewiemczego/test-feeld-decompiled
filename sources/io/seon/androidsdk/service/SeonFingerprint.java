package io.seon.androidsdk.service;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Pair;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import io.sentry.ProfilingTraceData;
import io.seon.androidsdk.exception.SeonException;
import io.seon.androidsdk.exception.SessionIsMissingException;
import io.seon.androidsdk.logger.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class SeonFingerprint {
    private static final Logger f = Logger.withClass(SeonFingerprint.class);
    private static String g = null;
    private final SeonImpl a;
    private JSONObject b = null;
    private boolean c;
    private String d;
    private ArrayList e;

    SeonFingerprint(SeonImpl seonImpl) {
        this.a = seonImpl;
    }

    private void a(JSONObject jSONObject, String str, Object obj) {
        if (obj == null) {
            obj = JSONObject.NULL;
        }
        jSONObject.put(str, obj);
    }

    private String b() {
        try {
            JSONObject jSONObject = this.b;
            if (jSONObject == null) {
                return null;
            }
            return jSONObject.toString(0);
        } catch (JSONException e2) {
            f.withCause(e2, 6);
            return null;
        }
    }

    private synchronized String c() {
        if (g == null) {
            SharedPreferences sharedPreferences = this.a.getContext().getSharedPreferences("PREF_UNIQUE_ID", 0);
            String string = sharedPreferences.getString("PREF_UNIQUE_ID", (String) null);
            g = string;
            if (string == null) {
                g = UUID.randomUUID().toString();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("PREF_UNIQUE_ID", g);
                edit.apply();
            }
        }
        return g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0226, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0227, code lost:
        r2 = r0;
        r4 = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x02e7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x02e8, code lost:
        r2 = r0;
        r4 = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x02ea, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x02ec, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x02ed, code lost:
        r2 = r0;
        r3 = f;
        r3.withCause(r2, 6);
        r1.b = null;
        r3.withCause(r2, 6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x02fb, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x02fd, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x02ec A[ExcHandler: Exception (r0v2 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:1:0x000b] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x02fb A[ExcHandler: SeonException (r0v1 'e' io.seon.androidsdk.exception.SeonException A[CUSTOM_DECLARE]), Splitter:B:1:0x000b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r19 = this;
            r1 = r19
            io.seon.androidsdk.service.SeonImpl r2 = r1.a
            java.lang.String r2 = r2.getSessionId()
            io.seon.androidsdk.service.SeonUtil.d()
            io.seon.androidsdk.service.SeonImpl r5 = r1.a     // Catch:{ JSONException -> 0x02fe, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r5 = r5.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.DeviceProbe r5 = r5.b()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.util.Map r5 = r5.scan()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SeonImpl r6 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r6 = r6.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.MediaProbe r6 = r6.f()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.util.Map r6 = r6.scan()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SeonImpl r7 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r7 = r7.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.NetworkProbe r7 = r7.g()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.util.Map r7 = r7.scan()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SeonImpl r8 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r8 = r8.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.HardwareProbe r8 = r8.d()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.util.Map r8 = r8.scan()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SeonImpl r9 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r9 = r9.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.LocaleProbe r9 = r9.e()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.util.Map r9 = r9.scan()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SeonImpl r10 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r10 = r10.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.OSProbe r10 = r10.h()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.util.Map r10 = r10.scan()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SeonImpl r11 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r11 = r11.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.TelephonyProbe r11 = r11.j()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.util.Map r11 = r11.scan()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SeonImpl r12 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r12 = r12.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.GeolocationProbe r12 = r12.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.util.Map r12 = r12.scan()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SeonImpl r13 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r13 = r13.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SecurityProbe r13 = r13.i()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.util.Map r13 = r13.scan()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r14.<init>()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.String[] r15 = io.seon.androidsdk.service.DeviceProbe.h     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r3 = r15.length     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r16 = 0
            r4 = r16
        L_0x0095:
            if (r4 >= r3) goto L_0x00ab
            r17 = r3
            r3 = r15[r4]     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r18 = r15
            java.lang.Object r15 = r5.get(r3)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r3, (java.lang.Object) r15)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r4 = r4 + 1
            r3 = r17
            r15 = r18
            goto L_0x0095
        L_0x00ab:
            java.lang.String[] r3 = io.seon.androidsdk.service.MediaProbe.g     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r4 = r3.length     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r5 = r16
        L_0x00b0:
            if (r5 >= r4) goto L_0x00de
            r15 = r3[r5]     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r17 = r3
            java.lang.String r3 = "enabled_accessibility_apps"
            boolean r3 = r3.equals(r15)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            if (r3 != 0) goto L_0x00cc
            java.lang.String r3 = "interfering_apps"
            boolean r3 = r3.equals(r15)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            if (r3 == 0) goto L_0x00c7
            goto L_0x00cc
        L_0x00c7:
            java.lang.Object r3 = r6.get(r15)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            goto L_0x00d6
        L_0x00cc:
            java.lang.Object r3 = r6.get(r15)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            org.json.JSONArray r3 = io.seon.androidsdk.service.SeonUtil.a((java.util.Collection) r3)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
        L_0x00d6:
            r1.a((org.json.JSONObject) r14, (java.lang.String) r15, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r5 = r5 + 1
            r3 = r17
            goto L_0x00b0
        L_0x00de:
            java.lang.String[] r3 = io.seon.androidsdk.service.NetworkProbe.c     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r4 = r3.length     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r5 = r16
        L_0x00e3:
            if (r5 >= r4) goto L_0x00f1
            r6 = r3[r5]     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.Object r15 = r7.get(r6)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r6, (java.lang.Object) r15)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r5 = r5 + 1
            goto L_0x00e3
        L_0x00f1:
            java.lang.String[] r3 = io.seon.androidsdk.service.HardwareProbe.f     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r4 = r3.length     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r5 = r16
        L_0x00f6:
            if (r5 >= r4) goto L_0x0104
            r6 = r3[r5]     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.Object r7 = r8.get(r6)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r6, (java.lang.Object) r7)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r5 = r5 + 1
            goto L_0x00f6
        L_0x0104:
            java.lang.String[] r3 = io.seon.androidsdk.service.LocaleProbe.b     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r4 = r3.length     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r5 = r16
        L_0x0109:
            if (r5 >= r4) goto L_0x0117
            r6 = r3[r5]     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.Object r7 = r9.get(r6)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r6, (java.lang.Object) r7)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r5 = r5 + 1
            goto L_0x0109
        L_0x0117:
            java.lang.String[] r3 = io.seon.androidsdk.service.OSProbe.i     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r4 = r3.length     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r5 = r16
        L_0x011c:
            if (r5 >= r4) goto L_0x012a
            r6 = r3[r5]     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.Object r7 = r10.get(r6)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r6, (java.lang.Object) r7)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r5 = r5 + 1
            goto L_0x011c
        L_0x012a:
            java.lang.String[] r3 = io.seon.androidsdk.service.TelephonyProbe.c     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r4 = r3.length     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r5 = r16
        L_0x012f:
            if (r5 >= r4) goto L_0x013d
            r6 = r3[r5]     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.Object r7 = r11.get(r6)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r6, (java.lang.Object) r7)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r5 = r5 + 1
            goto L_0x012f
        L_0x013d:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r3.<init>()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.String[] r4 = io.seon.androidsdk.service.GeolocationProbe.KEYS     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r5 = r4.length     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r6 = r16
        L_0x0147:
            if (r6 >= r5) goto L_0x0155
            r7 = r4[r6]     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.Object r8 = r12.get(r7)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r3, (java.lang.String) r7, (java.lang.Object) r8)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r6 = r6 + 1
            goto L_0x0147
        L_0x0155:
            java.lang.String r4 = "device_location"
            r1.a((org.json.JSONObject) r14, (java.lang.String) r4, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.String[] r3 = io.seon.androidsdk.service.SecurityProbe.KEYS     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r4 = r3.length     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r5 = r16
        L_0x015f:
            if (r5 >= r4) goto L_0x016d
            r6 = r3[r5]     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.Object r7 = r13.get(r6)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r6, (java.lang.Object) r7)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            int r5 = r5 + 1
            goto L_0x015f
        L_0x016d:
            java.lang.String r3 = "app_guid"
            java.lang.String r4 = r19.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.String r3 = "build_id"
            java.lang.String r4 = android.os.Build.ID     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.String r3 = "build_manufacturer"
            java.lang.String r4 = android.os.Build.MANUFACTURER     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.String r3 = "build_number"
            java.lang.String r4 = android.os.Build.DISPLAY     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.String r3 = "build_time"
            long r4 = android.os.Build.TIME     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.String r3 = "session_id"
            r1.a((org.json.JSONObject) r14, (java.lang.String) r3, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.String r3 = "source"
            io.seon.androidsdk.service.SeonImpl r4 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.String r4 = r4.version()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SeonImpl r3 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            boolean r3 = r3.b()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r4 = 5
            r5 = 1
            if (r3 != 0) goto L_0x022b
            java.lang.String r3 = "experimental_fields"
            r6 = 8
            io.seon.androidsdk.service.SeonProbe[] r6 = new io.seon.androidsdk.service.SeonProbe[r6]     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SeonImpl r7 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r7 = r7.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.DeviceProbe r7 = r7.b()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r6[r16] = r7     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SeonImpl r7 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r7 = r7.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.HardwareProbe r7 = r7.d()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r6[r5] = r7     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r7 = 2
            io.seon.androidsdk.service.SeonImpl r8 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r8 = r8.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.OSProbe r8 = r8.h()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r6[r7] = r8     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r7 = 3
            io.seon.androidsdk.service.SeonImpl r8 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r8 = r8.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.LocaleProbe r8 = r8.e()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r6[r7] = r8     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r7 = 4
            io.seon.androidsdk.service.SeonImpl r8 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r8 = r8.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.MediaProbe r8 = r8.f()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r6[r7] = r8     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SeonImpl r7 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r7 = r7.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.NetworkProbe r7 = r7.g()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r6[r4] = r7     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SeonImpl r7 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r7 = r7.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.TelephonyProbe r7 = r7.j()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r8 = 6
            r6[r8] = r7     // Catch:{ JSONException -> 0x0226, SeonException -> 0x02fb, Exception -> 0x02ec }
            r7 = 7
            io.seon.androidsdk.service.SeonImpl r8 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r8 = r8.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.GeolocationProbe r8 = r8.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r6[r7] = r8     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            org.json.JSONObject r6 = r1.a((io.seon.androidsdk.service.SeonProbe[]) r6)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r3, (java.lang.Object) r6)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            goto L_0x022b
        L_0x0226:
            r0 = move-exception
            r2 = r0
            r4 = r8
            goto L_0x02ea
        L_0x022b:
            io.seon.androidsdk.service.SeonImpl r3 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            android.content.Context r3 = r3.getContext()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            com.framgia.android.emulator.EmulatorDetector r3 = com.framgia.android.emulator.EmulatorDetector.a((android.content.Context) r3, (org.json.JSONObject) r14)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SeonFingerprint$$ExternalSyntheticLambda0 r6 = new io.seon.androidsdk.service.SeonFingerprint$$ExternalSyntheticLambda0     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r6.<init>(r1)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r3.a((com.framgia.android.emulator.EmulatorDetector.OnEmulatorDetectorListener) r6)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SeonImpl r3 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            boolean r3 = r3.b()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            if (r3 != 0) goto L_0x028c
            java.util.UUID r3 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x0271 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0271 }
            java.lang.String r6 = "request_id"
            r1.a((org.json.JSONObject) r14, (java.lang.String) r6, (java.lang.Object) r3)     // Catch:{ Exception -> 0x0271 }
            io.seon.androidsdk.service.DynamicComponentRequest r6 = new io.seon.androidsdk.service.DynamicComponentRequest     // Catch:{ Exception -> 0x0271 }
            java.lang.String r3 = r1.a((java.lang.String) r3, (org.json.JSONObject) r14)     // Catch:{ Exception -> 0x0271 }
            r6.<init>(r2, r3)     // Catch:{ Exception -> 0x0271 }
            io.seon.androidsdk.service.DynamicComponentTask r2 = new io.seon.androidsdk.service.DynamicComponentTask     // Catch:{ Exception -> 0x0271 }
            io.seon.androidsdk.service.SeonImpl r3 = r1.a     // Catch:{ Exception -> 0x0271 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0271 }
            io.seon.androidsdk.service.DynamicComponentRequest[] r3 = new io.seon.androidsdk.service.DynamicComponentRequest[r5]     // Catch:{ Exception -> 0x0271 }
            r3[r16] = r6     // Catch:{ Exception -> 0x0271 }
            android.os.AsyncTask r2 = r2.execute(r3)     // Catch:{ Exception -> 0x0271 }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x0271 }
            io.seon.androidsdk.service.DynamicComponentResponse r2 = (io.seon.androidsdk.service.DynamicComponentResponse) r2     // Catch:{ Exception -> 0x0271 }
            goto L_0x0279
        L_0x0271:
            r0 = move-exception
            r2 = r0
            io.seon.androidsdk.logger.Logger r3 = f     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r3.withCause(r2, r4)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r2 = 0
        L_0x0279:
            if (r2 == 0) goto L_0x028c
            java.lang.String r3 = r2.b     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            if (r3 == 0) goto L_0x028c
            boolean r3 = r3.isEmpty()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            if (r3 != 0) goto L_0x028c
            java.lang.String r3 = "dynamic_evaluator_results"
            java.lang.String r2 = r2.b     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r3, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
        L_0x028c:
            java.lang.String r2 = "is_emulator"
            boolean r3 = r1.c     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.String r2 = "emulator_trigger_causes"
            java.util.ArrayList r3 = r1.e     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            org.json.JSONArray r3 = io.seon.androidsdk.service.SeonUtil.a((java.util.Collection) r3)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.String r2 = "predicted_emulator_engine"
            java.lang.String r3 = r1.d     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.String r2 = "version_code"
            java.lang.String r3 = "6.0.2"
            java.lang.String r3 = r1.a((java.lang.String) r3)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SeonImpl r2 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r2 = r2.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.HardwareProbe r2 = r2.d()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            double r2 = r2.d()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.DeviceHasher.a((java.lang.Object) r2)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.SeonImpl r2 = r1.a     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.Probes r2 = r2.c()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.HardwareProbe r2 = r2.d()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.String r2 = r2.p()     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            io.seon.androidsdk.service.DeviceHasher.a((java.lang.Object) r2)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            java.lang.String r2 = "device_hash"
            java.lang.String r3 = io.seon.androidsdk.service.DeviceHasher.a((org.json.JSONObject) r14)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.a((org.json.JSONObject) r14, (java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            r1.b = r14     // Catch:{ JSONException -> 0x02e7, SeonException -> 0x02fb, Exception -> 0x02ec }
            goto L_0x0309
        L_0x02e7:
            r0 = move-exception
            r2 = r0
            r4 = 6
        L_0x02ea:
            r5 = 0
            goto L_0x0302
        L_0x02ec:
            r0 = move-exception
            r2 = r0
            io.seon.androidsdk.logger.Logger r3 = f
            r4 = 6
            r3.withCause(r2, r4)
            r5 = 0
            r1.b = r5
            r3.withCause(r2, r4)
            goto L_0x0309
        L_0x02fb:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x02fe:
            r0 = move-exception
            r4 = 6
            r5 = 0
            r2 = r0
        L_0x0302:
            io.seon.androidsdk.logger.Logger r3 = f
            r3.withCause(r2, r4)
            r1.b = r5
        L_0x0309:
            io.seon.androidsdk.service.SeonUtil.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.seon.androidsdk.service.SeonFingerprint.d():void");
    }

    private String a(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            a(jSONObject2, "source", (Object) this.a.version());
            a(jSONObject2, SDKAnalyticsEvents.PARAMETER_REQUEST_ID, (Object) str);
            a(jSONObject2, ProfilingTraceData.JsonKeys.DEVICE_MODEL, (Object) new JSONArray((Collection<?>) this.a.c().b().d()));
            a(jSONObject2, "battery_total_capacity", (Object) Double.valueOf(this.a.c().d().d()));
            a(jSONObject2, "emulator_trigger_cause", (Object) "");
            Pair c2 = this.a.c().h().c();
            a(jSONObject2, "font_hash", c2.first);
            a(jSONObject2, "font_count", c2.second);
            a(jSONObject2, "wallpaper_hash", (Object) this.a.c().h().q());
            a(jSONObject2, "experimental_hash", (Object) DeviceHasher.b(jSONObject));
            byte[] a2 = SeonEncrypt.a();
            String encodeToString = Base64.encodeToString(a2, 2);
            return "Android;" + this.a.getSessionId() + ";" + encodeToString + ";" + new String(this.a.a().a(jSONObject2.toString(), a2));
        } catch (JSONException e2) {
            f.withCause(e2, 5);
            return null;
        }
    }

    private JSONObject a(SeonProbe... seonProbeArr) {
        JSONObject jSONObject = new JSONObject();
        for (SeonProbe experimentalFields : seonProbeArr) {
            Map experimentalFields2 = experimentalFields.getExperimentalFields();
            if (experimentalFields2 != null) {
                for (Map.Entry entry : experimentalFields2.entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    try {
                        if (value instanceof Collection) {
                            value = SeonUtil.a((Collection) value);
                        } else if (value instanceof Map) {
                            value = SeonUtil.a((Map) value);
                        } else if (value != null && value.getClass().isArray() && value.getClass().getComponentType() == String.class) {
                            a(jSONObject, str, (Object) new JSONArray((Collection<?>) Arrays.asList((String[]) value)));
                        }
                        a(jSONObject, str, value);
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, SeonCallback seonCallback) {
        if (str == null || str.isEmpty()) {
            throw new SessionIsMissingException();
        }
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        newSingleThreadExecutor.submit(new SeonFingerprint$$ExternalSyntheticLambda1(this, seonCallback, str, newSingleThreadExecutor));
    }

    private String a() {
        d();
        String b2 = b();
        if (b2 != null) {
            return b2;
        }
        throw new SeonException("Fingerprint could not be generated");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:11|12|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r9.shutdownNow();
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0065 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void a(io.seon.androidsdk.service.SeonCallback r7, java.lang.String r8, java.util.concurrent.ExecutorService r9) {
        /*
            r6 = this;
            java.lang.String r0 = ";"
            java.lang.String r1 = r6.a()     // Catch:{ SeonException -> 0x0070 }
            if (r7 == 0) goto L_0x0074
            byte[] r2 = io.seon.androidsdk.service.SeonEncrypt.a()     // Catch:{ SeonException -> 0x0070 }
            r3 = 2
            java.lang.String r3 = android.util.Base64.encodeToString(r2, r3)     // Catch:{ SeonException -> 0x0070 }
            java.lang.String r4 = new java.lang.String     // Catch:{ SeonException -> 0x0070 }
            io.seon.androidsdk.service.SeonImpl r5 = r6.a     // Catch:{ SeonException -> 0x0070 }
            io.seon.androidsdk.service.SeonEncrypt r5 = r5.a()     // Catch:{ SeonException -> 0x0070 }
            byte[] r1 = r5.a(r1, r2)     // Catch:{ SeonException -> 0x0070 }
            r4.<init>(r1)     // Catch:{ SeonException -> 0x0070 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SeonException -> 0x0070 }
            r1.<init>()     // Catch:{ SeonException -> 0x0070 }
            java.lang.String r2 = "Android;"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ SeonException -> 0x0070 }
            java.lang.StringBuilder r8 = r1.append(r8)     // Catch:{ SeonException -> 0x0070 }
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch:{ SeonException -> 0x0070 }
            java.lang.StringBuilder r8 = r8.append(r3)     // Catch:{ SeonException -> 0x0070 }
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch:{ SeonException -> 0x0070 }
            java.lang.StringBuilder r8 = r8.append(r4)     // Catch:{ SeonException -> 0x0070 }
            java.lang.String r8 = r8.toString()     // Catch:{ SeonException -> 0x0070 }
            r7.onComplete(r8)     // Catch:{ SeonException -> 0x0070 }
            r9.shutdown()     // Catch:{ SeonException -> 0x0070 }
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x0065 }
            r0 = 3
            boolean r8 = r9.awaitTermination(r0, r7)     // Catch:{ InterruptedException -> 0x0065 }
            if (r8 != 0) goto L_0x0074
            r9.shutdownNow()     // Catch:{ InterruptedException -> 0x0065 }
            boolean r7 = r9.awaitTermination(r0, r7)     // Catch:{ InterruptedException -> 0x0065 }
            if (r7 != 0) goto L_0x0074
            io.seon.androidsdk.logger.Logger r7 = f     // Catch:{ InterruptedException -> 0x0065 }
            java.lang.String r8 = "Pool didn't terminate"
            r0 = 5
            r7.log(r8, r0)     // Catch:{ InterruptedException -> 0x0065 }
            goto L_0x0074
        L_0x0065:
            r9.shutdownNow()     // Catch:{ SeonException -> 0x0070 }
            java.lang.Thread r7 = java.lang.Thread.currentThread()     // Catch:{ SeonException -> 0x0070 }
            r7.interrupt()     // Catch:{ SeonException -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.seon.androidsdk.service.SeonFingerprint.a(io.seon.androidsdk.service.SeonCallback, java.lang.String, java.util.concurrent.ExecutorService):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, ArrayList arrayList, String str) {
        this.c = z;
        this.e = arrayList;
        this.d = str;
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        try {
            String[] split = str.split("-")[0].split("\\.");
            return String.format(Locale.US, "%s%02d%02d%02d", new Object[]{"02", Integer.valueOf((split.length > 0 ? Integer.parseInt(split[0]) : 0) % 100), Integer.valueOf((split.length > 1 ? Integer.parseInt(split[1]) : 0) % 100), Integer.valueOf((split.length > 2 ? Integer.parseInt(split[2]) : 0) % 100)});
        } catch (Exception unused) {
            return null;
        }
    }
}
