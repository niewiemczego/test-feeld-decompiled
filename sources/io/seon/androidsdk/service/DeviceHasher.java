package io.seon.androidsdk.service;

import io.sentry.ProfilingTraceData;
import io.sentry.protocol.OperatingSystem;
import io.seon.androidsdk.logger.Logger;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class DeviceHasher {
    private static final Logger a = Logger.withClass(DeviceHasher.class);
    static final String[] b = {"build_manufacturer", ProfilingTraceData.JsonKeys.BUILD_ID, "build_device", "build_number", OperatingSystem.JsonKeys.KERNEL_VERSION, "kernel_arch", "cpu_count", "cpu_speed", "total_storage", "sensor_hash", "build_device", "build_model", "device_id", "region_language", "physical_memory"};
    static final String[] c = {"build_manufacturer", ProfilingTraceData.JsonKeys.BUILD_ID, "build_device", "build_number", OperatingSystem.JsonKeys.KERNEL_VERSION, "kernel_arch", "cpu_count", "cpu_speed", "total_storage", "sensor_hash", "build_device", "build_model", "device_id", "region_language", "physical_memory"};
    private static final ArrayList d = new ArrayList();

    public static void a(Object obj) {
        ArrayList arrayList = d;
        if (!arrayList.contains(obj)) {
            arrayList.add(obj);
        }
    }

    static String b(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        for (String str : c) {
            if (jSONObject.has(str)) {
                try {
                    if (jSONObject.get(str) != null) {
                        sb.append(jSONObject.get(str));
                    }
                } catch (JSONException e) {
                    a.withCause(e, 6);
                }
            }
        }
        try {
            return SeonUtil.b(sb.toString());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e2) {
            a.withCause(e2, 6);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005d A[LOOP:1: B:24:0x0057->B:26:0x005d, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String a(org.json.JSONObject r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = io.seon.androidsdk.service.MediaProbe.g()
            if (r1 == 0) goto L_0x000c
            goto L_0x001a
        L_0x000c:
            java.lang.String r1 = "gsf_id"
            java.lang.String r1 = a(r7, r1)
            java.lang.String r2 = "android_id"
            java.lang.String r2 = a(r7, r2)
            if (r1 == 0) goto L_0x001e
        L_0x001a:
            r0.append(r1)
            goto L_0x0023
        L_0x001e:
            if (r2 == 0) goto L_0x0023
            r0.append(r2)
        L_0x0023:
            java.lang.String[] r1 = b
            int r2 = r1.length
            r3 = 0
        L_0x0027:
            r4 = 6
            if (r3 >= r2) goto L_0x0049
            r5 = r1[r3]
            boolean r6 = r7.has(r5)
            if (r6 == 0) goto L_0x0046
            java.lang.Object r6 = r7.get(r5)     // Catch:{ JSONException -> 0x0040 }
            if (r6 == 0) goto L_0x0046
            java.lang.Object r5 = r7.get(r5)     // Catch:{ JSONException -> 0x0040 }
            r0.append(r5)     // Catch:{ JSONException -> 0x0040 }
            goto L_0x0046
        L_0x0040:
            r5 = move-exception
            io.seon.androidsdk.logger.Logger r6 = a
            r6.withCause(r5, r4)
        L_0x0046:
            int r3 = r3 + 1
            goto L_0x0027
        L_0x0049:
            java.util.ArrayList r7 = d
            if (r7 == 0) goto L_0x0069
            int r1 = r7.size()
            if (r1 <= 0) goto L_0x0069
            java.util.Iterator r7 = r7.iterator()
        L_0x0057:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0069
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            goto L_0x0057
        L_0x0069:
            java.lang.String r7 = r0.toString()     // Catch:{ NoSuchAlgorithmException -> 0x0074, UnsupportedEncodingException -> 0x0072 }
            java.lang.String r7 = io.seon.androidsdk.service.SeonUtil.b((java.lang.String) r7)     // Catch:{ NoSuchAlgorithmException -> 0x0074, UnsupportedEncodingException -> 0x0072 }
            return r7
        L_0x0072:
            r7 = move-exception
            goto L_0x0075
        L_0x0074:
            r7 = move-exception
        L_0x0075:
            io.seon.androidsdk.logger.Logger r0 = a
            r0.withCause(r7, r4)
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.seon.androidsdk.service.DeviceHasher.a(org.json.JSONObject):java.lang.String");
    }

    static String a(JSONObject jSONObject, String str) {
        try {
            if (jSONObject.has(str)) {
                return (String) jSONObject.get(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
