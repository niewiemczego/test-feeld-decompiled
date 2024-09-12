package io.seon.androidsdk.service;

import android.os.AsyncTask;
import io.seon.androidsdk.logger.Logger;
import java.util.regex.Pattern;

class DynamicComponentTask extends AsyncTask<DynamicComponentRequest, Void, DynamicComponentResponse> {
    private static final Logger d = Logger.withClass(DynamicComponentTask.class);
    private static final Pattern e = Pattern.compile("[A-Za-z0-9](?:[A-Za-z0-9\\-]{0,61}[A-Za-z0-9])?");
    private final SeonImpl a;
    private DynamicComponentResponse b;
    private final int c = 3000;

    DynamicComponentTask(SeonImpl seonImpl) {
        this.a = seonImpl;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008b A[Catch:{ all -> 0x00ae, Exception -> 0x0154 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ea A[Catch:{ all -> 0x00ae, Exception -> 0x0154 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010f A[Catch:{ JSONException -> 0x013a, all -> 0x0145 }, LOOP:0: B:46:0x0109->B:48:0x010f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0117 A[EDGE_INSN: B:75:0x0117->B:49:0x0117 ?: BREAK  , SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.seon.androidsdk.service.DynamicComponentResponse doInBackground(io.seon.androidsdk.service.DynamicComponentRequest... r8) {
        /*
            r7 = this;
            java.lang.String r0 = "data"
            io.seon.androidsdk.service.DynamicComponentResponse r1 = new io.seon.androidsdk.service.DynamicComponentResponse
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r3 = 0
            r1.<init>(r2, r3)
            r7.b = r1
            r2 = 0
            r8 = r8[r2]
            if (r8 != 0) goto L_0x0012
            return r1
        L_0x0012:
            java.lang.String r1 = r8.a
            java.lang.String r8 = r8.b
            if (r1 == 0) goto L_0x0037
            java.util.regex.Pattern r3 = e
            java.lang.String r4 = "[^a-zA-Z0-9-]"
            java.lang.String r5 = ""
            java.lang.String r1 = r1.replaceAll(r4, r5)
            java.util.regex.Matcher r1 = r3.matcher(r1)
            boolean r3 = r1.find()
            if (r3 == 0) goto L_0x0037
            java.lang.String r1 = r1.group()     // Catch:{ Exception -> 0x0031 }
            goto L_0x0039
        L_0x0031:
            r1 = move-exception
            io.seon.androidsdk.logger.Logger r3 = d
            r3.withCause(r1)
        L_0x0037:
            java.lang.String r1 = "default"
        L_0x0039:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "https://"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r3 = ".seondnsresolve.com/android"
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x0154 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0154 }
            java.net.URLConnection r1 = r3.openConnection()     // Catch:{ Exception -> 0x0154 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x0154 }
            r3 = 1
            r1.setDoOutput(r3)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r4 = "POST"
            r1.setRequestMethod(r4)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r4 = "User-Agent"
            java.lang.String r5 = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11"
            r1.setRequestProperty(r4, r5)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r4 = "Accept"
            java.lang.String r5 = "*/*"
            r1.setRequestProperty(r4, r5)     // Catch:{ Exception -> 0x0154 }
            r4 = 3000(0xbb8, float:4.204E-42)
            r1.setConnectTimeout(r4)     // Catch:{ Exception -> 0x0154 }
            r1.setReadTimeout(r4)     // Catch:{ Exception -> 0x0154 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0154 }
            r4.<init>()     // Catch:{ Exception -> 0x0154 }
            r4.put((java.lang.String) r0, (java.lang.Object) r8)     // Catch:{ JSONException -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ Exception -> 0x0154 }
        L_0x0089:
            if (r8 == 0) goto L_0x00cb
            java.lang.Thread r8 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x0154 }
            long r5 = r8.getId()     // Catch:{ Exception -> 0x0154 }
            int r8 = (int) r5     // Catch:{ Exception -> 0x0154 }
            android.net.TrafficStats.setThreadStatsTag(r8)     // Catch:{ Exception -> 0x0154 }
            java.io.DataOutputStream r8 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0154 }
            java.io.OutputStream r5 = r1.getOutputStream()     // Catch:{ Exception -> 0x0154 }
            r8.<init>(r5)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00b0 }
            r8.writeBytes(r4)     // Catch:{ Exception -> 0x00b0 }
            r8.flush()     // Catch:{ Exception -> 0x0154 }
        L_0x00aa:
            r8.close()     // Catch:{ Exception -> 0x0154 }
            goto L_0x00bd
        L_0x00ae:
            r0 = move-exception
            goto L_0x00c1
        L_0x00b0:
            r4 = move-exception
            io.seon.androidsdk.logger.Logger r5 = d     // Catch:{ all -> 0x00ae }
            r5.withCause(r4)     // Catch:{ all -> 0x00ae }
            r8.close()     // Catch:{ all -> 0x00ae }
            r8.flush()     // Catch:{ Exception -> 0x0154 }
            goto L_0x00aa
        L_0x00bd:
            android.net.TrafficStats.clearThreadStatsTag()     // Catch:{ Exception -> 0x0154 }
            goto L_0x00cb
        L_0x00c1:
            r8.flush()     // Catch:{ Exception -> 0x0154 }
            r8.close()     // Catch:{ Exception -> 0x0154 }
            android.net.TrafficStats.clearThreadStatsTag()     // Catch:{ Exception -> 0x0154 }
            throw r0     // Catch:{ Exception -> 0x0154 }
        L_0x00cb:
            r1.connect()     // Catch:{ Exception -> 0x0154 }
            int r8 = r1.getResponseCode()     // Catch:{ Exception -> 0x0154 }
            io.seon.androidsdk.logger.Logger r4 = d     // Catch:{ Exception -> 0x0154 }
            java.lang.String r5 = "Status code: %s"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0154 }
            java.lang.String r6 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0154 }
            r3[r2] = r6     // Catch:{ Exception -> 0x0154 }
            java.lang.String r2 = java.lang.String.format(r5, r3)     // Catch:{ Exception -> 0x0154 }
            r3 = 4
            r4.log(r2, r3)     // Catch:{ Exception -> 0x0154 }
            r2 = 202(0xca, float:2.83E-43)
            if (r8 == r2) goto L_0x00f3
            r2 = 200(0xc8, float:2.8E-43)
            if (r8 != r2) goto L_0x00ef
            goto L_0x00f3
        L_0x00ef:
            r1.disconnect()     // Catch:{ Exception -> 0x0154 }
            goto L_0x015a
        L_0x00f3:
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ all -> 0x014f }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x014f }
            java.io.InputStream r3 = r1.getInputStream()     // Catch:{ all -> 0x014f }
            java.lang.String r4 = "utf-8"
            r2.<init>(r3, r4)     // Catch:{ all -> 0x014f }
            r8.<init>(r2)     // Catch:{ all -> 0x014f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0145 }
            r2.<init>()     // Catch:{ all -> 0x0145 }
        L_0x0109:
            java.lang.String r3 = r8.readLine()     // Catch:{ all -> 0x0145 }
            if (r3 == 0) goto L_0x0117
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x0145 }
            r2.append(r3)     // Catch:{ all -> 0x0145 }
            goto L_0x0109
        L_0x0117:
            io.seon.androidsdk.service.DynamicComponentResponse r3 = r7.b     // Catch:{ all -> 0x0145 }
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0145 }
            r3.a = r4     // Catch:{ all -> 0x0145 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0145 }
            r8.close()     // Catch:{ all -> 0x0145 }
            if (r2 == 0) goto L_0x0141
            boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x0145 }
            if (r3 != 0) goto L_0x0141
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x013a }
            r3.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x013a }
            io.seon.androidsdk.service.DynamicComponentResponse r2 = r7.b     // Catch:{ JSONException -> 0x013a }
            java.lang.String r0 = r3.getString(r0)     // Catch:{ JSONException -> 0x013a }
            r2.b = r0     // Catch:{ JSONException -> 0x013a }
            goto L_0x0141
        L_0x013a:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0145 }
            r1.disconnect()     // Catch:{ all -> 0x0145 }
        L_0x0141:
            r8.close()     // Catch:{ all -> 0x014f }
            goto L_0x00ef
        L_0x0145:
            r0 = move-exception
            r8.close()     // Catch:{ all -> 0x014a }
            goto L_0x014e
        L_0x014a:
            r8 = move-exception
            r0.addSuppressed(r8)     // Catch:{ all -> 0x014f }
        L_0x014e:
            throw r0     // Catch:{ all -> 0x014f }
        L_0x014f:
            r8 = move-exception
            r1.disconnect()     // Catch:{ Exception -> 0x0154 }
            throw r8     // Catch:{ Exception -> 0x0154 }
        L_0x0154:
            r8 = move-exception
            io.seon.androidsdk.logger.Logger r0 = d
            r0.withCause(r8)
        L_0x015a:
            io.seon.androidsdk.service.DynamicComponentResponse r8 = r7.b
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.seon.androidsdk.service.DynamicComponentTask.doInBackground(io.seon.androidsdk.service.DynamicComponentRequest[]):io.seon.androidsdk.service.DynamicComponentResponse");
    }
}
