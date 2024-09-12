package com.appsflyer.internal;

public final class AFc1gSDK {
    private final int AFInAppEventType;

    public AFc1gSDK(int i) {
        this.AFInAppEventType = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0156 A[Catch:{ Exception -> 0x01f8, all -> 0x01f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x025c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFc1aSDK<java.lang.String> AFInAppEventParameterName(com.appsflyer.internal.AFc1rSDK r20) throws java.io.IOException {
        /*
            r19 = this;
            java.lang.String r1 = "ms"
            java.lang.String r2 = "\n took "
            java.lang.String r3 = "] "
            java.lang.String r4 = "HTTP: ["
            long r5 = java.lang.System.currentTimeMillis()
            r8 = 0
            byte[] r0 = r20.AFInAppEventType()     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            r10.<init>()     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.lang.String r11 = r20.AFLogger()     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.lang.String r11 = ":"
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.lang.String r11 = r20.values()     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            byte[] r10 = r20.AFInAppEventType()     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            if (r10 == 0) goto L_0x0060
            boolean r11 = r20.afRDLog()     // Catch:{ Exception -> 0x005a, all -> 0x0054 }
            if (r11 == 0) goto L_0x0044
            java.lang.String r10 = "<encrypted>"
            goto L_0x004a
        L_0x0044:
            java.lang.String r11 = new java.lang.String     // Catch:{ Exception -> 0x005a, all -> 0x0054 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x005a, all -> 0x0054 }
            r10 = r11
        L_0x004a:
            java.lang.String r11 = "\n payload: "
            java.lang.StringBuilder r11 = r9.append(r11)     // Catch:{ Exception -> 0x005a, all -> 0x0054 }
            r11.append(r10)     // Catch:{ Exception -> 0x005a, all -> 0x0054 }
            goto L_0x0060
        L_0x0054:
            r0 = move-exception
            r7 = 0
            r10 = r19
            goto L_0x025a
        L_0x005a:
            r0 = move-exception
            r7 = 0
            r10 = r19
            goto L_0x020f
        L_0x0060:
            java.util.Map r10 = r20.afErrorLog()     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.util.Set r10 = r10.entrySet()     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
        L_0x006c:
            boolean r11 = r10.hasNext()     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            if (r11 == 0) goto L_0x0098
            java.lang.Object r11 = r10.next()     // Catch:{ Exception -> 0x005a, all -> 0x0054 }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ Exception -> 0x005a, all -> 0x0054 }
            java.lang.String r12 = "\n "
            java.lang.StringBuilder r12 = r9.append(r12)     // Catch:{ Exception -> 0x005a, all -> 0x0054 }
            java.lang.Object r13 = r11.getKey()     // Catch:{ Exception -> 0x005a, all -> 0x0054 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ Exception -> 0x005a, all -> 0x0054 }
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ Exception -> 0x005a, all -> 0x0054 }
            java.lang.String r13 = ": "
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ Exception -> 0x005a, all -> 0x0054 }
            java.lang.Object r11 = r11.getValue()     // Catch:{ Exception -> 0x005a, all -> 0x0054 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x005a, all -> 0x0054 }
            r12.append(r11)     // Catch:{ Exception -> 0x005a, all -> 0x0054 }
            goto L_0x006c
        L_0x0098:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            r10.<init>(r4)     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            int r11 = r20.hashCode()     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.lang.StringBuilder r10 = r10.append(r3)     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.lang.StringBuilder r9 = r10.append(r9)     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            com.appsflyer.AFLogger.afDebugLog(r9)     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.net.URL r9 = new java.net.URL     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.lang.String r10 = r20.values()     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.net.URLConnection r9 = r9.openConnection()     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ Exception -> 0x020a, all -> 0x0204 }
            java.lang.String r10 = r20.AFLogger()     // Catch:{ Exception -> 0x01ff, all -> 0x01fa }
            r9.setRequestMethod(r10)     // Catch:{ Exception -> 0x01ff, all -> 0x01fa }
            boolean r10 = r20.afErrorLogForExcManagerOnly()     // Catch:{ Exception -> 0x01ff, all -> 0x01fa }
            if (r10 == 0) goto L_0x00d3
            r9.setUseCaches(r8)     // Catch:{ Exception -> 0x01ff, all -> 0x01fa }
        L_0x00d3:
            boolean r10 = r20.afWarnLog()     // Catch:{ Exception -> 0x01ff, all -> 0x01fa }
            if (r10 != 0) goto L_0x00dc
            r9.setInstanceFollowRedirects(r8)     // Catch:{ Exception -> 0x01ff, all -> 0x01fa }
        L_0x00dc:
            r10 = r19
            int r11 = r10.AFInAppEventType     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            int r12 = r20.afDebugLog()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            r13 = -1
            if (r12 == r13) goto L_0x00e8
            r11 = r12
        L_0x00e8:
            r9.setConnectTimeout(r11)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            r9.setReadTimeout(r11)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            boolean r11 = r20.afRDLog()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            if (r11 == 0) goto L_0x00f7
            java.lang.String r11 = "application/octet-stream"
            goto L_0x00f9
        L_0x00f7:
            java.lang.String r11 = "application/json"
        L_0x00f9:
            java.lang.String r12 = "Content-Type"
            r9.addRequestProperty(r12, r11)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.util.Map r11 = r20.afErrorLog()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.util.Set r11 = r11.entrySet()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
        L_0x010a:
            boolean r12 = r11.hasNext()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            if (r12 == 0) goto L_0x0126
            java.lang.Object r12 = r11.next()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.Object r13 = r12.getKey()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.Object r12 = r12.getValue()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            r9.setRequestProperty(r13, r12)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            goto L_0x010a
        L_0x0126:
            r11 = 1
            if (r0 == 0) goto L_0x015a
            r9.setDoOutput(r11)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.String r12 = "Content-Length"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            r13.<init>()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            int r14 = r0.length     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            r9.setRequestProperty(r12, r13)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.io.BufferedOutputStream r12 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0152 }
            java.io.OutputStream r13 = r9.getOutputStream()     // Catch:{ all -> 0x0152 }
            r12.<init>(r13)     // Catch:{ all -> 0x0152 }
            r12.write(r0)     // Catch:{ all -> 0x014f }
            r12.close()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            goto L_0x015a
        L_0x014f:
            r0 = move-exception
            r7 = r12
            goto L_0x0154
        L_0x0152:
            r0 = move-exception
            r7 = 0
        L_0x0154:
            if (r7 == 0) goto L_0x0159
            r7.close()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
        L_0x0159:
            throw r0     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
        L_0x015a:
            int r0 = r9.getResponseCode()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            int r0 = r0 / 100
            r12 = 2
            if (r0 != r12) goto L_0x0164
            goto L_0x0165
        L_0x0164:
            r11 = r8
        L_0x0165:
            boolean r0 = r20.afInfoLog()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.String r12 = ""
            if (r0 == 0) goto L_0x0173
            java.lang.String r0 = AFInAppEventParameterName(r9, r11)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            r14 = r0
            goto L_0x0174
        L_0x0173:
            r14 = r12
        L_0x0174:
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            long r12 = r12 - r5
            com.appsflyer.internal.AFc1eSDK r0 = new com.appsflyer.internal.AFc1eSDK     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.String r13 = "response code:"
            r12.<init>(r13)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            int r13 = r9.getResponseCode()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.String r13 = " "
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.String r13 = r9.getResponseMessage()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.String r13 = "\n body:"
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.StringBuilder r12 = r12.append(r14)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.StringBuilder r12 = r12.append(r2)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            long r7 = r0.AFInAppEventType     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.StringBuilder r7 = r12.append(r7)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.StringBuilder r7 = r7.append(r1)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            r8.<init>(r4)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            int r12 = r20.hashCode()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.StringBuilder r8 = r8.append(r12)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.StringBuilder r8 = r8.append(r3)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.StringBuilder r7 = r8.append(r7)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            com.appsflyer.AFLogger.afDebugLog(r7)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            java.util.Map r8 = r9.getHeaderFields()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            r8 = 0
            r7.remove(r8)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            com.appsflyer.internal.AFc1aSDK r8 = new com.appsflyer.internal.AFc1aSDK     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            int r15 = r9.getResponseCode()     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            r13 = r8
            r16 = r11
            r17 = r7
            r18 = r0
            r13.<init>(r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x01f8, all -> 0x01f6 }
            if (r9 == 0) goto L_0x01f5
            r9.disconnect()
        L_0x01f5:
            return r8
        L_0x01f6:
            r0 = move-exception
            goto L_0x01fd
        L_0x01f8:
            r0 = move-exception
            goto L_0x0202
        L_0x01fa:
            r0 = move-exception
            r10 = r19
        L_0x01fd:
            r7 = r9
            goto L_0x025a
        L_0x01ff:
            r0 = move-exception
            r10 = r19
        L_0x0202:
            r7 = r9
            goto L_0x020f
        L_0x0204:
            r0 = move-exception
            r10 = r19
            r8 = 0
            r7 = r8
            goto L_0x025a
        L_0x020a:
            r0 = move-exception
            r10 = r19
            r8 = 0
            r7 = r8
        L_0x020f:
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0259 }
            long r8 = r8 - r5
            com.appsflyer.internal.AFc1eSDK r5 = new com.appsflyer.internal.AFc1eSDK     // Catch:{ all -> 0x0259 }
            r5.<init>(r8)     // Catch:{ all -> 0x0259 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0259 }
            java.lang.String r8 = "error: "
            r6.<init>(r8)     // Catch:{ all -> 0x0259 }
            java.lang.StringBuilder r6 = r6.append(r0)     // Catch:{ all -> 0x0259 }
            java.lang.StringBuilder r2 = r6.append(r2)     // Catch:{ all -> 0x0259 }
            long r8 = r5.AFInAppEventType     // Catch:{ all -> 0x0259 }
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch:{ all -> 0x0259 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ all -> 0x0259 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0259 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0259 }
            r2.<init>(r4)     // Catch:{ all -> 0x0259 }
            int r4 = r20.hashCode()     // Catch:{ all -> 0x0259 }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ all -> 0x0259 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0259 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ all -> 0x0259 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0259 }
            r2 = 0
            com.appsflyer.AFLogger.afErrorLog(r1, r0, r2, r2)     // Catch:{ all -> 0x0259 }
            com.appsflyer.internal.components.network.http.exceptions.HttpException r1 = new com.appsflyer.internal.components.network.http.exceptions.HttpException     // Catch:{ all -> 0x0259 }
            r1.<init>(r0, r5)     // Catch:{ all -> 0x0259 }
            throw r1     // Catch:{ all -> 0x0259 }
        L_0x0259:
            r0 = move-exception
        L_0x025a:
            if (r7 == 0) goto L_0x025f
            r7.disconnect()
        L_0x025f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1gSDK.AFInAppEventParameterName(com.appsflyer.internal.AFc1rSDK):com.appsflyer.internal.AFc1aSDK");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String AFInAppEventParameterName(java.net.HttpURLConnection r4, boolean r5) throws java.io.IOException {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x0008
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x0048 }
            goto L_0x000c
        L_0x0008:
            java.io.InputStream r4 = r4.getErrorStream()     // Catch:{ all -> 0x0048 }
        L_0x000c:
            if (r4 != 0) goto L_0x0011
            java.lang.String r4 = ""
            return r4
        L_0x0011:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            r5.<init>()     // Catch:{ all -> 0x0048 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x0048 }
            r1.<init>(r4)     // Catch:{ all -> 0x0048 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x0044 }
            r4.<init>(r1)     // Catch:{ all -> 0x0044 }
            r0 = 1
        L_0x0021:
            java.lang.String r2 = r4.readLine()     // Catch:{ all -> 0x003e }
            if (r2 == 0) goto L_0x0033
            if (r0 != 0) goto L_0x002e
            r0 = 10
            r5.append(r0)     // Catch:{ all -> 0x003e }
        L_0x002e:
            r5.append(r2)     // Catch:{ all -> 0x003e }
            r0 = 0
            goto L_0x0021
        L_0x0033:
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x003e }
            r1.close()
            r4.close()
            return r5
        L_0x003e:
            r5 = move-exception
            r0 = r1
            r3 = r5
            r5 = r4
            r4 = r3
            goto L_0x004a
        L_0x0044:
            r4 = move-exception
            r5 = r0
            r0 = r1
            goto L_0x004a
        L_0x0048:
            r4 = move-exception
            r5 = r0
        L_0x004a:
            if (r0 == 0) goto L_0x004f
            r0.close()
        L_0x004f:
            if (r5 == 0) goto L_0x0054
            r5.close()
        L_0x0054:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1gSDK.AFInAppEventParameterName(java.net.HttpURLConnection, boolean):java.lang.String");
    }
}
