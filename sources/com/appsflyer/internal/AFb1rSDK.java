package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class AFb1rSDK implements AFd1wSDK {
    private final AFe1kSDK AFInAppEventParameterName;
    private final Object AFInAppEventType;
    public final AFe1tSDK AFKeystoreWrapper;
    private AFe1xSDK AFLogger;
    private final AFe1rSDK afDebugLog;
    private final AFd1pSDK afErrorLog;
    private AFb1fSDK afInfoLog;
    private final AFc1kSDK afRDLog;
    private final AFb1bSDK valueOf;
    private final AFe1uSDK values;

    public final void AFInAppEventParameterName(AFd1qSDK<?> aFd1qSDK) {
    }

    public AFb1rSDK() {
    }

    public static Map<String, String> AFKeystoreWrapper(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            try {
                hashMap.put(URLEncoder.encode((String) next.getKey(), "utf-8"), URLEncoder.encode((String) next.getValue(), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                AFLogger.afErrorLogForExcManagerOnly("failed to encode map", e);
            }
        }
        return hashMap;
    }

    public AFb1rSDK(AFe1uSDK aFe1uSDK, AFb1bSDK aFb1bSDK, AFe1kSDK aFe1kSDK, AFe1tSDK aFe1tSDK, AFc1kSDK aFc1kSDK, AFe1rSDK aFe1rSDK, AFd1pSDK aFd1pSDK) {
        this.AFInAppEventType = new Object();
        this.values = aFe1uSDK;
        this.valueOf = aFb1bSDK;
        this.AFInAppEventParameterName = aFe1kSDK;
        this.AFKeystoreWrapper = aFe1tSDK;
        this.afRDLog = aFc1kSDK;
        this.afDebugLog = aFe1rSDK;
        this.afErrorLog = aFd1pSDK;
        aFd1pSDK.valueOf.add(this);
    }

    public final void AFInAppEventParameterName(AFe1ySDK aFe1ySDK) {
        AFe1wSDK aFe1wSDK = new AFe1wSDK(this.values, this.valueOf, this.AFInAppEventParameterName, this.AFKeystoreWrapper, this.afRDLog, this.afDebugLog, "v1", aFe1ySDK);
        AFd1pSDK aFd1pSDK = this.afErrorLog;
        aFd1pSDK.AFKeystoreWrapper.execute(new Runnable(aFe1wSDK) {
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
    }

    public final AFb1fSDK values() {
        AFb1fSDK aFb1fSDK;
        synchronized (this.AFInAppEventType) {
            aFb1fSDK = this.afInfoLog;
            this.afInfoLog = null;
        }
        return aFb1fSDK;
    }

    private void values(AFe1xSDK aFe1xSDK, AFe1ySDK aFe1ySDK) {
        synchronized (this.AFInAppEventType) {
            this.AFLogger = aFe1xSDK;
        }
        if (aFe1ySDK != null) {
            aFe1ySDK.onRemoteConfigUpdateFinished(aFe1xSDK);
        }
    }

    public final void valueOf(AFd1qSDK<?> aFd1qSDK, AFd1tSDK aFd1tSDK) {
        if (aFd1qSDK instanceof AFe1wSDK) {
            AFe1wSDK aFe1wSDK = (AFe1wSDK) aFd1qSDK;
            AFe1xSDK aFe1xSDK = aFe1wSDK.AFLogger;
            if (aFe1xSDK == null) {
                AFLogger.afWarnLog("CFG: update RC returned null result, something went wrong!");
                aFe1xSDK = AFe1xSDK.FAILURE;
            }
            if (aFe1xSDK != AFe1xSDK.USE_CACHED) {
                AFb1fSDK aFb1fSDK = aFe1wSDK.afErrorLog;
                synchronized (this.AFInAppEventType) {
                    this.afInfoLog = aFb1fSDK;
                }
            }
            values(aFe1xSDK, aFe1wSDK.afRDLog);
        }
    }

    public final void AFInAppEventType(AFd1qSDK<?> aFd1qSDK) {
        if (aFd1qSDK instanceof AFe1wSDK) {
            AFe1wSDK aFe1wSDK = (AFe1wSDK) aFd1qSDK;
            synchronized (this.AFInAppEventType) {
                this.afInfoLog = null;
            }
            values(AFe1xSDK.FAILURE, aFe1wSDK.afRDLog);
        }
    }
}
