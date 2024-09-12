package com.appsflyer.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\b\u0000\u0018\u0000 \u00012\u00020\u0014:\u0001\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0007\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0007\u0010\u000eR\u0012\u0010\u0003\u001a\u00020\u0002X\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R \u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\u0007\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/appsflyer/internal/AFc1jSDK;", "AFa1zSDK", "", "AFInAppEventParameterName", "[B", "", "", "AFInAppEventType", "Ljava/util/Map;", "values", "", "AFKeystoreWrapper", "I", "", "()Z", "p0", "p1", "p2", "<init>", "([BLjava/util/Map;I)V", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AFc1jSDK {
    public static final AFa1zSDK AFa1zSDK = new AFa1zSDK((DefaultConstructorMarker) null);
    public static String valueOf = "https://%smonitorsdk.%s/remote-debug/exception-manager";
    public byte[] AFInAppEventParameterName;
    public Map<String, String> AFInAppEventType;
    public int AFKeystoreWrapper;

    public AFc1jSDK(byte[] bArr, Map<String, String> map, int i) {
        Intrinsics.checkNotNullParameter(bArr, "");
        this.AFInAppEventParameterName = bArr;
        this.AFInAppEventType = map;
        this.AFKeystoreWrapper = i;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\b\u0003\u0018\u00002\u00020\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0004\u001a\u00020\u0001X\u0002¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/appsflyer/internal/AFc1jSDK$AFa1zSDK;", "", "valueOf", "Ljava/lang/String;", "values", "<init>", "()V", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AFa1zSDK {
        public /* synthetic */ AFa1zSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private AFa1zSDK() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x018e, code lost:
        if (r10 == null) goto L_0x0190;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean AFInAppEventType() {
        /*
            r21 = this;
            r1 = r21
            java.lang.String r2 = "\n\ttook "
            java.lang.String r3 = "[Exception Manager]: "
            java.lang.String r4 = "] "
            java.lang.String r5 = "HTTP: ["
            java.lang.String r6 = ""
            long r7 = java.lang.System.currentTimeMillis()
            r9 = 0
            r10 = 0
            java.lang.String r0 = valueOf     // Catch:{ all -> 0x020d }
            r11 = 2
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ all -> 0x020d }
            com.appsflyer.AppsFlyerLib r12 = com.appsflyer.AppsFlyerLib.getInstance()     // Catch:{ all -> 0x020d }
            java.lang.String r12 = r12.getHostPrefix()     // Catch:{ all -> 0x020d }
            r11[r9] = r12     // Catch:{ all -> 0x020d }
            com.appsflyer.internal.AFb1xSDK r12 = com.appsflyer.internal.AFb1xSDK.AFInAppEventType()     // Catch:{ all -> 0x020d }
            java.lang.String r12 = r12.getHostName()     // Catch:{ all -> 0x020d }
            r13 = 1
            r11[r13] = r12     // Catch:{ all -> 0x020d }
            java.lang.String r0 = java.lang.String.format(r0, r11)     // Catch:{ all -> 0x020d }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)     // Catch:{ all -> 0x020d }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r6)     // Catch:{ all -> 0x020d }
            java.net.URL r11 = new java.net.URL     // Catch:{ all -> 0x020d }
            r11.<init>(r0)     // Catch:{ all -> 0x020d }
            java.net.URLConnection r0 = r11.openConnection()     // Catch:{ all -> 0x020d }
            if (r0 == 0) goto L_0x0205
            r11 = r0
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ all -> 0x020d }
            java.lang.String r0 = "POST"
            r11.setRequestMethod(r0)     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0202 }
            r10.<init>()     // Catch:{ all -> 0x0202 }
            java.lang.String r12 = r11.getRequestMethod()     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r10 = r10.append(r12)     // Catch:{ all -> 0x0202 }
            r12 = 58
            java.lang.StringBuilder r10 = r10.append(r12)     // Catch:{ all -> 0x0202 }
            java.net.URL r12 = r11.getURL()     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r10 = r10.append(r12)     // Catch:{ all -> 0x0202 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0202 }
            r0.<init>(r10)     // Catch:{ all -> 0x0202 }
            java.lang.String r10 = "\n length: "
            java.lang.StringBuilder r10 = r0.append(r10)     // Catch:{ all -> 0x0202 }
            java.lang.String r12 = new java.lang.String     // Catch:{ all -> 0x0202 }
            byte[] r14 = r1.AFInAppEventParameterName     // Catch:{ all -> 0x0202 }
            java.nio.charset.Charset r15 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x0202 }
            r12.<init>(r14, r15)     // Catch:{ all -> 0x0202 }
            int r12 = r12.length()     // Catch:{ all -> 0x0202 }
            r10.append(r12)     // Catch:{ all -> 0x0202 }
            java.util.Map<java.lang.String, java.lang.String> r10 = r1.AFInAppEventType     // Catch:{ all -> 0x0202 }
            if (r10 == 0) goto L_0x00bb
            java.util.Set r10 = r10.entrySet()     // Catch:{ all -> 0x0202 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0202 }
        L_0x008f:
            boolean r12 = r10.hasNext()     // Catch:{ all -> 0x0202 }
            if (r12 == 0) goto L_0x00bb
            java.lang.Object r12 = r10.next()     // Catch:{ all -> 0x0202 }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ all -> 0x0202 }
            java.lang.String r14 = "\n "
            java.lang.StringBuilder r14 = r0.append(r14)     // Catch:{ all -> 0x0202 }
            java.lang.Object r15 = r12.getKey()     // Catch:{ all -> 0x0202 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ all -> 0x0202 }
            java.lang.String r15 = ": "
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ all -> 0x0202 }
            java.lang.Object r12 = r12.getValue()     // Catch:{ all -> 0x0202 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0202 }
            r14.append(r12)     // Catch:{ all -> 0x0202 }
            goto L_0x008f
        L_0x00bb:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0202 }
            r10.<init>(r5)     // Catch:{ all -> 0x0202 }
            int r12 = r11.hashCode()     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r10 = r10.append(r12)     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r10 = r10.append(r4)     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r0 = r10.append(r0)     // Catch:{ all -> 0x0202 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0202 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r6)     // Catch:{ all -> 0x0202 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0202 }
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x0202 }
            com.appsflyer.AFLogger.afRDLog(r0)     // Catch:{ all -> 0x0202 }
            r11.setInstanceFollowRedirects(r9)     // Catch:{ all -> 0x0202 }
            r11.setUseCaches(r9)     // Catch:{ all -> 0x0202 }
            int r0 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x0202 }
            r11.setReadTimeout(r0)     // Catch:{ all -> 0x0202 }
            int r0 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x0202 }
            r11.setConnectTimeout(r0)     // Catch:{ all -> 0x0202 }
            java.lang.String r0 = "Content-Type"
            java.lang.String r10 = "application/json"
            r11.addRequestProperty(r0, r10)     // Catch:{ all -> 0x0202 }
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.AFInAppEventType     // Catch:{ all -> 0x0202 }
            if (r0 == 0) goto L_0x0121
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0202 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0202 }
        L_0x0105:
            boolean r10 = r0.hasNext()     // Catch:{ all -> 0x0202 }
            if (r10 == 0) goto L_0x0121
            java.lang.Object r10 = r0.next()     // Catch:{ all -> 0x0202 }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ all -> 0x0202 }
            java.lang.Object r12 = r10.getKey()     // Catch:{ all -> 0x0202 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0202 }
            java.lang.Object r10 = r10.getValue()     // Catch:{ all -> 0x0202 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0202 }
            r11.addRequestProperty(r12, r10)     // Catch:{ all -> 0x0202 }
            goto L_0x0105
        L_0x0121:
            r11.setDoOutput(r13)     // Catch:{ all -> 0x0202 }
            java.lang.String r0 = "Content-Length"
            byte[] r10 = r1.AFInAppEventParameterName     // Catch:{ all -> 0x0202 }
            int r10 = r10.length     // Catch:{ all -> 0x0202 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0202 }
            r11.setRequestProperty(r0, r10)     // Catch:{ all -> 0x0202 }
            java.io.OutputStream r0 = r11.getOutputStream()     // Catch:{ all -> 0x0200 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)     // Catch:{ all -> 0x0200 }
            boolean r10 = r0 instanceof java.io.BufferedOutputStream     // Catch:{ all -> 0x0200 }
            r12 = 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x0140
            java.io.BufferedOutputStream r0 = (java.io.BufferedOutputStream) r0     // Catch:{ all -> 0x0200 }
            goto L_0x0146
        L_0x0140:
            java.io.BufferedOutputStream r10 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0200 }
            r10.<init>(r0, r12)     // Catch:{ all -> 0x0200 }
            r0 = r10
        L_0x0146:
            byte[] r10 = r1.AFInAppEventParameterName     // Catch:{ all -> 0x0200 }
            r0.write(r10)     // Catch:{ all -> 0x0200 }
            r0.close()     // Catch:{ all -> 0x0202 }
            boolean r0 = com.appsflyer.internal.AFc1qSDK.AFa1vSDK.AFKeystoreWrapper((java.net.HttpURLConnection) r11)     // Catch:{ all -> 0x0202 }
            if (r0 == 0) goto L_0x0159
            java.io.InputStream r0 = r11.getInputStream()     // Catch:{ all -> 0x0202 }
            goto L_0x015d
        L_0x0159:
            java.io.InputStream r0 = r11.getErrorStream()     // Catch:{ all -> 0x0202 }
        L_0x015d:
            if (r0 == 0) goto L_0x0190
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)     // Catch:{ all -> 0x0202 }
            java.nio.charset.Charset r10 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x0202 }
            java.io.InputStreamReader r13 = new java.io.InputStreamReader     // Catch:{ all -> 0x0202 }
            r13.<init>(r0, r10)     // Catch:{ all -> 0x0202 }
            java.io.Reader r13 = (java.io.Reader) r13     // Catch:{ all -> 0x0202 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x0202 }
            r0.<init>(r13, r12)     // Catch:{ all -> 0x0202 }
            r10 = r0
            java.io.Reader r10 = (java.io.Reader) r10     // Catch:{ all -> 0x0202 }
            java.util.List r10 = kotlin.io.TextStreamsKt.readLines(r10)     // Catch:{ all -> 0x0202 }
            r12 = r10
            java.lang.Iterable r12 = (java.lang.Iterable) r12     // Catch:{ all -> 0x0202 }
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 63
            r20 = 0
            java.lang.String r10 = kotlin.collections.CollectionsKt.joinToString$default(r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x0202 }
            r0.close()     // Catch:{ all -> 0x0202 }
            if (r10 != 0) goto L_0x0191
        L_0x0190:
            r10 = r6
        L_0x0191:
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0202 }
            long r12 = r12 - r7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0202 }
            java.lang.String r14 = "response code:"
            r0.<init>(r14)     // Catch:{ all -> 0x0202 }
            int r14 = r11.getResponseCode()     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r0 = r0.append(r14)     // Catch:{ all -> 0x0202 }
            r14 = 32
            java.lang.StringBuilder r0 = r0.append(r14)     // Catch:{ all -> 0x0202 }
            java.lang.String r14 = r11.getResponseMessage()     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r0 = r0.append(r14)     // Catch:{ all -> 0x0202 }
            java.lang.String r14 = "\n\tbody:"
            java.lang.StringBuilder r0 = r0.append(r14)     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r0 = r0.append(r12)     // Catch:{ all -> 0x0202 }
            java.lang.String r10 = "ms"
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch:{ all -> 0x0202 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0202 }
            r10.<init>(r5)     // Catch:{ all -> 0x0202 }
            int r12 = r11.hashCode()     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r10 = r10.append(r12)     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r10 = r10.append(r4)     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r0 = r10.append(r0)     // Catch:{ all -> 0x0202 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0202 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r6)     // Catch:{ all -> 0x0202 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0202 }
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x0202 }
            com.appsflyer.AFLogger.afRDLog(r0)     // Catch:{ all -> 0x0202 }
            boolean r9 = com.appsflyer.internal.AFc1qSDK.AFa1vSDK.AFKeystoreWrapper((java.net.HttpURLConnection) r11)     // Catch:{ all -> 0x0202 }
            if (r11 == 0) goto L_0x0268
            r11.disconnect()
            goto L_0x0268
        L_0x0200:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0202 }
        L_0x0202:
            r0 = move-exception
            r10 = r11
            goto L_0x020e
        L_0x0205:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x020d }
            java.lang.String r11 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r0.<init>(r11)     // Catch:{ all -> 0x020d }
            throw r0     // Catch:{ all -> 0x020d }
        L_0x020d:
            r0 = move-exception
        L_0x020e:
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0269 }
            long r11 = r11 - r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0269 }
            java.lang.String r8 = "error: "
            r7.<init>(r8)     // Catch:{ all -> 0x0269 }
            java.lang.StringBuilder r7 = r7.append(r0)     // Catch:{ all -> 0x0269 }
            java.lang.StringBuilder r2 = r7.append(r2)     // Catch:{ all -> 0x0269 }
            java.lang.StringBuilder r2 = r2.append(r11)     // Catch:{ all -> 0x0269 }
            java.lang.String r7 = "ms\n\t"
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ all -> 0x0269 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0269 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x0269 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0269 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0269 }
            r2.<init>(r5)     // Catch:{ all -> 0x0269 }
            if (r10 == 0) goto L_0x0244
            int r5 = r10.hashCode()     // Catch:{ all -> 0x0269 }
            goto L_0x0245
        L_0x0244:
            r5 = r9
        L_0x0245:
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x0269 }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ all -> 0x0269 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x0269 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0269 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r6)     // Catch:{ all -> 0x0269 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0269 }
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x0269 }
            com.appsflyer.AFLogger.afRDLog(r0)     // Catch:{ all -> 0x0269 }
            if (r10 == 0) goto L_0x0268
            r10.disconnect()
        L_0x0268:
            return r9
        L_0x0269:
            r0 = move-exception
            if (r10 == 0) goto L_0x026f
            r10.disconnect()
        L_0x026f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1jSDK.AFInAppEventType():boolean");
    }
}
