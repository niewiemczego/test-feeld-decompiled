package com.appsflyer.internal;

import android.net.Uri;
import com.appsflyer.AFLogger;
import com.facebook.internal.ServerProtocol;

public final class AFd1hSDK extends AFd1qSDK<Boolean> {
    private static volatile boolean afRDLog = false;
    private final AFc1vSDK AFLogger;
    private final AFb1zSDK afDebugLog;
    private Boolean afErrorLog;
    private final AFd1pSDK afInfoLog;

    public final long AFInAppEventParameterName() {
        return 30000;
    }

    public final boolean values() {
        return false;
    }

    public AFd1hSDK(AFc1vSDK aFc1vSDK) {
        super(AFd1sSDK.LOAD_CACHE, new AFd1sSDK[0], "LoadCachedRequests");
        this.afDebugLog = aFc1vSDK.AFLogger$LogLevel();
        this.afInfoLog = aFc1vSDK.afDebugLog();
        this.AFLogger = aFc1vSDK;
    }

    public static boolean AFLogger() {
        return afRDLog;
    }

    public final AFd1tSDK AFInAppEventType() throws Exception {
        for (AFa1oSDK next : this.afDebugLog.AFInAppEventType()) {
            AFLogger.afInfoLog(new StringBuilder("CACHE: resending request: ").append(next.AFKeystoreWrapper).toString());
            try {
                AFe1eSDK aFe1eSDK = new AFe1eSDK(valueOf(next), next.values(), next.AFInAppEventParameterName, next.AFInAppEventType);
                AFd1pSDK aFd1pSDK = this.afInfoLog;
                aFd1pSDK.AFKeystoreWrapper.execute(new Runnable(new AFd1aSDK(aFe1eSDK, this.AFLogger)) {
                    private /* synthetic */ AFd1qSDK AFInAppEventParameterName;

                    {
                        this.AFInAppEventParameterName = r2;
                    }

                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                            r6 = this;
                            com.appsflyer.internal.AFd1pSDK r0 = com.appsflyer.internal.AFd1pSDK.this
                            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r0 = r0.afDebugLog
                            monitor-enter(r0)
                            com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                            java.util.Set<com.appsflyer.internal.AFd1qSDK<?>> r1 = r1.afRDLog     // Catch:{ all -> 0x0197 }
                            com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0197 }
                            if (r1 == 0) goto L_0x0027
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
                            java.lang.String r2 = "QUEUE: tried to add already running task: "
                            r1.<init>(r2)     // Catch:{ all -> 0x0197 }
                            com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0197 }
                            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0197 }
                            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0197 }
                            monitor-exit(r0)     // Catch:{ all -> 0x0197 }
                            return
                        L_0x0027:
                            com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r1 = r1.afDebugLog     // Catch:{ all -> 0x0197 }
                            com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0197 }
                            if (r1 != 0) goto L_0x0181
                            com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r1 = r1.AFLogger     // Catch:{ all -> 0x0197 }
                            com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0197 }
                            if (r1 == 0) goto L_0x0041
                            goto L_0x0181
                        L_0x0041:
                            com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                            com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                            java.util.Set<com.appsflyer.internal.AFd1sSDK> r3 = r2.AFKeystoreWrapper     // Catch:{ all -> 0x0197 }
                            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0197 }
                        L_0x004b:
                            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0197 }
                            if (r4 == 0) goto L_0x0065
                            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0197 }
                            com.appsflyer.internal.AFd1sSDK r4 = (com.appsflyer.internal.AFd1sSDK) r4     // Catch:{ all -> 0x0197 }
                            java.util.Set<com.appsflyer.internal.AFd1sSDK> r5 = r1.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                            boolean r5 = r5.contains(r4)     // Catch:{ all -> 0x0197 }
                            if (r5 == 0) goto L_0x004b
                            java.util.Set<com.appsflyer.internal.AFd1sSDK> r5 = r2.valueOf     // Catch:{ all -> 0x0197 }
                            r5.add(r4)     // Catch:{ all -> 0x0197 }
                            goto L_0x004b
                        L_0x0065:
                            com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                            com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                            boolean r1 = r1.AFInAppEventType((com.appsflyer.internal.AFd1qSDK<?>) r2)     // Catch:{ all -> 0x0197 }
                            if (r1 == 0) goto L_0x007a
                            com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r1 = r1.afDebugLog     // Catch:{ all -> 0x0197 }
                            com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                            boolean r1 = r1.add(r2)     // Catch:{ all -> 0x0197 }
                            goto L_0x009f
                        L_0x007a:
                            com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r1 = r1.AFLogger     // Catch:{ all -> 0x0197 }
                            com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                            boolean r1 = r1.add(r2)     // Catch:{ all -> 0x0197 }
                            if (r1 == 0) goto L_0x009f
                            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
                            java.lang.String r3 = "QUEUE: new task was blocked: "
                            r2.<init>(r3)     // Catch:{ all -> 0x0197 }
                            com.appsflyer.internal.AFd1qSDK r3 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0197 }
                            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0197 }
                            com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x0197 }
                            com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                            r2.valueOf()     // Catch:{ all -> 0x0197 }
                        L_0x009f:
                            if (r1 == 0) goto L_0x00b4
                            com.appsflyer.internal.AFd1pSDK r2 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r2 = r2.afDebugLog     // Catch:{ all -> 0x0197 }
                            com.appsflyer.internal.AFd1pSDK r3 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                            java.util.List<com.appsflyer.internal.AFd1qSDK<?>> r3 = r3.afInfoLog     // Catch:{ all -> 0x0197 }
                            r2.addAll(r3)     // Catch:{ all -> 0x0197 }
                            com.appsflyer.internal.AFd1pSDK r2 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                            java.util.List<com.appsflyer.internal.AFd1qSDK<?>> r2 = r2.afInfoLog     // Catch:{ all -> 0x0197 }
                            r2.clear()     // Catch:{ all -> 0x0197 }
                            goto L_0x00c8
                        L_0x00b4:
                            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
                            java.lang.String r3 = "QUEUE: task not added, it's already in the queue: "
                            r2.<init>(r3)     // Catch:{ all -> 0x0197 }
                            com.appsflyer.internal.AFd1qSDK r3 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0197 }
                            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0197 }
                            com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x0197 }
                        L_0x00c8:
                            monitor-exit(r0)     // Catch:{ all -> 0x0197 }
                            if (r1 == 0) goto L_0x016c
                            com.appsflyer.internal.AFd1pSDK r0 = com.appsflyer.internal.AFd1pSDK.this
                            java.util.Set<com.appsflyer.internal.AFd1sSDK> r0 = r0.AFInAppEventParameterName
                            com.appsflyer.internal.AFd1qSDK r1 = r6.AFInAppEventParameterName
                            com.appsflyer.internal.AFd1sSDK r1 = r1.values
                            r0.add(r1)
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder
                            java.lang.String r1 = "QUEUE: new task added: "
                            r0.<init>(r1)
                            com.appsflyer.internal.AFd1qSDK r1 = r6.AFInAppEventParameterName
                            java.lang.StringBuilder r0 = r0.append(r1)
                            java.lang.String r0 = r0.toString()
                            com.appsflyer.AFLogger.afDebugLog(r0)
                            com.appsflyer.internal.AFd1pSDK r0 = com.appsflyer.internal.AFd1pSDK.this
                            java.util.List<com.appsflyer.internal.AFd1wSDK> r0 = r0.valueOf
                            java.util.Iterator r0 = r0.iterator()
                        L_0x00f2:
                            boolean r1 = r0.hasNext()
                            if (r1 == 0) goto L_0x00ff
                            java.lang.Object r1 = r0.next()
                            com.appsflyer.internal.AFd1wSDK r1 = (com.appsflyer.internal.AFd1wSDK) r1
                            goto L_0x00f2
                        L_0x00ff:
                            com.appsflyer.internal.AFd1pSDK r0 = com.appsflyer.internal.AFd1pSDK.this
                            java.util.concurrent.ExecutorService r1 = r0.AFInAppEventType
                            r1.submit(r0)
                            com.appsflyer.internal.AFd1pSDK r0 = com.appsflyer.internal.AFd1pSDK.this
                            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r1 = r0.afDebugLog
                            monitor-enter(r1)
                            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r2 = r0.afDebugLog     // Catch:{ all -> 0x0169 }
                            int r2 = r2.size()     // Catch:{ all -> 0x0169 }
                            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0169 }
                            int r3 = r3.size()     // Catch:{ all -> 0x0169 }
                            int r2 = r2 + r3
                            int r2 = r2 + -40
                        L_0x011a:
                            if (r2 <= 0) goto L_0x0167
                            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0169 }
                            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0169 }
                            r4 = 1
                            if (r3 != 0) goto L_0x0127
                            r3 = r4
                            goto L_0x0128
                        L_0x0127:
                            r3 = 0
                        L_0x0128:
                            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r5 = r0.afDebugLog     // Catch:{ all -> 0x0169 }
                            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0169 }
                            r4 = r4 ^ r5
                            if (r4 == 0) goto L_0x0155
                            if (r3 == 0) goto L_0x0155
                            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.afDebugLog     // Catch:{ all -> 0x0169 }
                            java.lang.Object r3 = r3.first()     // Catch:{ all -> 0x0169 }
                            com.appsflyer.internal.AFd1qSDK r3 = (com.appsflyer.internal.AFd1qSDK) r3     // Catch:{ all -> 0x0169 }
                            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r4 = r0.AFLogger     // Catch:{ all -> 0x0169 }
                            java.lang.Object r4 = r4.first()     // Catch:{ all -> 0x0169 }
                            com.appsflyer.internal.AFd1qSDK r4 = (com.appsflyer.internal.AFd1qSDK) r4     // Catch:{ all -> 0x0169 }
                            int r3 = r3.compareTo(r4)     // Catch:{ all -> 0x0169 }
                            if (r3 <= 0) goto L_0x014f
                            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.afDebugLog     // Catch:{ all -> 0x0169 }
                            r0.AFKeystoreWrapper(r3)     // Catch:{ all -> 0x0169 }
                            goto L_0x0164
                        L_0x014f:
                            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0169 }
                            r0.AFKeystoreWrapper(r3)     // Catch:{ all -> 0x0169 }
                            goto L_0x0164
                        L_0x0155:
                            if (r4 == 0) goto L_0x015d
                            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.afDebugLog     // Catch:{ all -> 0x0169 }
                            r0.AFKeystoreWrapper(r3)     // Catch:{ all -> 0x0169 }
                            goto L_0x0164
                        L_0x015d:
                            if (r3 == 0) goto L_0x0164
                            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0169 }
                            r0.AFKeystoreWrapper(r3)     // Catch:{ all -> 0x0169 }
                        L_0x0164:
                            int r2 = r2 + -1
                            goto L_0x011a
                        L_0x0167:
                            monitor-exit(r1)     // Catch:{ all -> 0x0169 }
                            return
                        L_0x0169:
                            r0 = move-exception
                            monitor-exit(r1)
                            throw r0
                        L_0x016c:
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder
                            java.lang.String r1 = "QUEUE: tried to add already pending task: "
                            r0.<init>(r1)
                            com.appsflyer.internal.AFd1qSDK r1 = r6.AFInAppEventParameterName
                            java.lang.StringBuilder r0 = r0.append(r1)
                            java.lang.String r0 = r0.toString()
                            com.appsflyer.AFLogger.afWarnLog(r0)
                            return
                        L_0x0181:
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
                            java.lang.String r2 = "QUEUE: tried to add already scheduled task: "
                            r1.<init>(r2)     // Catch:{ all -> 0x0197 }
                            com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0197 }
                            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0197 }
                            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0197 }
                            monitor-exit(r0)     // Catch:{ all -> 0x0197 }
                            return
                        L_0x0197:
                            r1 = move-exception
                            monitor-exit(r0)
                            throw r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1pSDK.AnonymousClass5.run():void");
                    }
                });
            } catch (Exception e) {
                AFLogger.afErrorLog("QUEUE: Failed to resend cached request", e);
            }
        }
        this.afErrorLog = Boolean.TRUE;
        afRDLog = true;
        return AFd1tSDK.SUCCESS;
    }

    private static String valueOf(AFa1oSDK aFa1oSDK) {
        long currentTimeMillis = System.currentTimeMillis();
        long parseLong = Long.parseLong(aFa1oSDK.AFInAppEventParameterName, 10);
        String str = aFa1oSDK.AFKeystoreWrapper;
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("isCachedRequest", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE).appendQueryParameter("timeincache", String.valueOf((currentTimeMillis - parseLong) / 1000)).toString();
        } catch (Exception e) {
            AFLogger.afErrorLogForExcManagerOnly("Couldn't parse the uri", e);
            return str;
        }
    }
}
