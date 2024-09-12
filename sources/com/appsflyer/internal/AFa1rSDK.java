package com.appsflyer.internal;

@Deprecated
public final class AFa1rSDK {
    private final AFb1sSDK AFInAppEventParameterName;
    private final AFe1aSDK valueOf;

    public interface AFa1vSDK {
        void AFInAppEventType(String str);

        void values(String str, String str2, String str3);
    }

    AFa1rSDK() {
    }

    public AFa1rSDK(AFe1aSDK aFe1aSDK, AFb1sSDK aFb1sSDK) {
        this.valueOf = aFe1aSDK;
        this.AFInAppEventParameterName = aFb1sSDK;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v14, types: [java.net.URLConnection] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0177  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.net.HttpURLConnection AFInAppEventParameterName(java.lang.String r18) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = ""
            com.appsflyer.internal.AFe1aSDK r0 = r1.valueOf
            java.lang.String r3 = r0.AFLogger
            com.appsflyer.internal.AFe1aSDK r0 = r1.valueOf
            java.util.Map r0 = r0.AFInAppEventType()
            org.json.JSONObject r0 = com.appsflyer.internal.AFa1oSDK.values(r0)
            java.lang.String r0 = r0.toString()
            com.appsflyer.internal.AFe1aSDK r4 = r1.valueOf
            boolean r4 = r4.AFLogger$LogLevel()
            com.appsflyer.internal.AFe1aSDK r5 = r1.valueOf
            boolean r5 = r5.AFVersionDeclaration()
            com.appsflyer.internal.AFe1aSDK r6 = r1.valueOf
            boolean r6 = r6.getLevel()
            com.appsflyer.internal.AFe1aSDK r7 = r1.valueOf
            boolean r7 = r7.valueOf()
            byte[] r8 = r0.getBytes()
            r9 = 0
            if (r4 == 0) goto L_0x0036
            return r9
        L_0x0036:
            r4 = 0
            r10 = 1
            java.net.URL r11 = new java.net.URL     // Catch:{ all -> 0x015b }
            r11.<init>(r3)     // Catch:{ all -> 0x015b }
            if (r6 == 0) goto L_0x0085
            com.appsflyer.internal.AFb1sSDK r12 = r1.AFInAppEventParameterName     // Catch:{ all -> 0x015b }
            java.lang.String r13 = r11.toString()     // Catch:{ all -> 0x015b }
            r12.AFInAppEventParameterName(r13, r0)     // Catch:{ all -> 0x015b }
            java.lang.String r12 = "UTF-8"
            byte[] r12 = r0.getBytes(r12)     // Catch:{ all -> 0x015b }
            int r12 = r12.length     // Catch:{ all -> 0x015b }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x015b }
            java.lang.String r14 = "call = "
            r13.<init>(r14)     // Catch:{ all -> 0x015b }
            java.lang.StringBuilder r13 = r13.append(r11)     // Catch:{ all -> 0x015b }
            java.lang.String r14 = "; size = "
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ all -> 0x015b }
            java.lang.StringBuilder r13 = r13.append(r12)     // Catch:{ all -> 0x015b }
            java.lang.String r14 = " byte"
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ all -> 0x015b }
            if (r12 <= r10) goto L_0x006f
            java.lang.String r12 = "s"
            goto L_0x0070
        L_0x006f:
            r12 = r2
        L_0x0070:
            java.lang.StringBuilder r12 = r13.append(r12)     // Catch:{ all -> 0x015b }
            java.lang.String r13 = "; body = "
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ all -> 0x015b }
            java.lang.StringBuilder r0 = r12.append(r0)     // Catch:{ all -> 0x015b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x015b }
            com.appsflyer.internal.AFc1rSDK.AFInAppEventParameterName((java.lang.String) r0)     // Catch:{ all -> 0x015b }
        L_0x0085:
            java.lang.String r0 = "AppsFlyer"
            int r0 = r0.hashCode()     // Catch:{ all -> 0x015b }
            android.net.TrafficStats.setThreadStatsTag(r0)     // Catch:{ all -> 0x015b }
            java.net.URLConnection r0 = r11.openConnection()     // Catch:{ all -> 0x015b }
            r12 = r0
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ all -> 0x015b }
            r0 = 30000(0x7530, float:4.2039E-41)
            r12.setReadTimeout(r0)     // Catch:{ all -> 0x0158 }
            r12.setConnectTimeout(r0)     // Catch:{ all -> 0x0158 }
            java.lang.String r0 = "POST"
            r12.setRequestMethod(r0)     // Catch:{ all -> 0x0158 }
            r12.setDoInput(r10)     // Catch:{ all -> 0x0158 }
            r12.setDoOutput(r10)     // Catch:{ all -> 0x0158 }
            java.lang.String r0 = "Content-Type"
            if (r7 == 0) goto L_0x00af
            java.lang.String r13 = "application/octet-stream"
            goto L_0x00b1
        L_0x00af:
            java.lang.String r13 = "application/json"
        L_0x00b1:
            r12.setRequestProperty(r0, r13)     // Catch:{ all -> 0x0158 }
            java.io.OutputStream r0 = r12.getOutputStream()     // Catch:{ all -> 0x0158 }
            if (r7 == 0) goto L_0x0130
            java.lang.Object[] r7 = new java.lang.Object[r10]     // Catch:{ all -> 0x0127 }
            r7[r4] = r18     // Catch:{ all -> 0x0127 }
            int r13 = android.view.View.MeasureSpec.getSize(r4)     // Catch:{ all -> 0x0127 }
            char r13 = (char) r13     // Catch:{ all -> 0x0127 }
            r14 = 0
            int r16 = android.widget.ExpandableListView.getPackedPositionChild(r14)     // Catch:{ all -> 0x0127 }
            int r14 = 36 - r16
            int r15 = android.view.ViewConfiguration.getMaximumFlingVelocity()     // Catch:{ all -> 0x0127 }
            int r15 = r15 >> 16
            int r15 = r15 + 36
            java.lang.Object r13 = com.appsflyer.internal.AFa1vSDK.AFInAppEventParameterName(r13, r14, r15)     // Catch:{ all -> 0x0127 }
            java.lang.Class r13 = (java.lang.Class) r13     // Catch:{ all -> 0x0127 }
            java.lang.String r14 = "AFInAppEventParameterName"
            java.lang.Class[] r15 = new java.lang.Class[r10]     // Catch:{ all -> 0x0127 }
            java.lang.Class<java.lang.String> r16 = java.lang.String.class
            r15[r4] = r16     // Catch:{ all -> 0x0127 }
            java.lang.reflect.Method r13 = r13.getMethod(r14, r15)     // Catch:{ all -> 0x0127 }
            java.lang.Object r7 = r13.invoke(r9, r7)     // Catch:{ all -> 0x0127 }
            java.lang.Object[] r9 = new java.lang.Object[r10]     // Catch:{ all -> 0x011e }
            r9[r4] = r8     // Catch:{ all -> 0x011e }
            int r8 = android.text.TextUtils.getOffsetBefore(r2, r4)     // Catch:{ all -> 0x011e }
            char r8 = (char) r8     // Catch:{ all -> 0x011e }
            long r13 = android.view.ViewConfiguration.getZoomControlsTimeout()     // Catch:{ all -> 0x011e }
            r15 = 0
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            int r13 = 38 - r13
            int r14 = android.view.ViewConfiguration.getScrollDefaultDelay()     // Catch:{ all -> 0x011e }
            int r14 = r14 >> 16
            int r14 = r14 + 36
            java.lang.Object r8 = com.appsflyer.internal.AFa1vSDK.AFInAppEventParameterName(r8, r13, r14)     // Catch:{ all -> 0x011e }
            java.lang.Class r8 = (java.lang.Class) r8     // Catch:{ all -> 0x011e }
            java.lang.String r13 = "valueOf"
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ all -> 0x011e }
            java.lang.Class<byte[]> r15 = byte[].class
            r14[r4] = r15     // Catch:{ all -> 0x011e }
            java.lang.reflect.Method r8 = r8.getDeclaredMethod(r13, r14)     // Catch:{ all -> 0x011e }
            java.lang.Object r7 = r8.invoke(r7, r9)     // Catch:{ all -> 0x011e }
            r8 = r7
            byte[] r8 = (byte[]) r8     // Catch:{ all -> 0x011e }
            goto L_0x0130
        L_0x011e:
            r0 = move-exception
            java.lang.Throwable r4 = r0.getCause()     // Catch:{ all -> 0x0158 }
            if (r4 == 0) goto L_0x0126
            throw r4     // Catch:{ all -> 0x0158 }
        L_0x0126:
            throw r0     // Catch:{ all -> 0x0158 }
        L_0x0127:
            r0 = move-exception
            java.lang.Throwable r4 = r0.getCause()     // Catch:{ all -> 0x0158 }
            if (r4 == 0) goto L_0x012f
            throw r4     // Catch:{ all -> 0x0158 }
        L_0x012f:
            throw r0     // Catch:{ all -> 0x0158 }
        L_0x0130:
            r0.write(r8)     // Catch:{ all -> 0x0158 }
            r0.close()     // Catch:{ all -> 0x0158 }
            r12.connect()     // Catch:{ all -> 0x0158 }
            int r0 = r12.getResponseCode()     // Catch:{ all -> 0x0158 }
            if (r5 == 0) goto L_0x0143
            java.lang.String r2 = com.appsflyer.internal.AFb1xSDK.valueOf((java.net.HttpURLConnection) r12)     // Catch:{ all -> 0x0158 }
        L_0x0143:
            if (r6 == 0) goto L_0x014e
            com.appsflyer.internal.AFb1sSDK r5 = r1.AFInAppEventParameterName     // Catch:{ all -> 0x0158 }
            java.lang.String r6 = r11.toString()     // Catch:{ all -> 0x0158 }
            r5.values((java.lang.String) r6, (int) r0, (java.lang.String) r2)     // Catch:{ all -> 0x0158 }
        L_0x014e:
            r5 = 200(0xc8, float:2.8E-43)
            if (r0 != r5) goto L_0x016a
            java.lang.String r0 = "Status 200 ok"
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ all -> 0x0158 }
            goto L_0x016b
        L_0x0158:
            r0 = move-exception
            r9 = r12
            goto L_0x015c
        L_0x015b:
            r0 = move-exception
        L_0x015c:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Error while calling "
            java.lang.String r3 = r4.concat(r3)
            com.appsflyer.AFLogger.afErrorLog(r3, r0)
            r12 = r9
        L_0x016a:
            r4 = r10
        L_0x016b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Connection "
            r0.<init>(r3)
            if (r4 == 0) goto L_0x0177
            java.lang.String r3 = "error"
            goto L_0x0179
        L_0x0177:
            java.lang.String r3 = "call succeeded"
        L_0x0179:
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r3 = ": "
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afInfoLog(r0)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1rSDK.AFInAppEventParameterName(java.lang.String):java.net.HttpURLConnection");
    }
}
