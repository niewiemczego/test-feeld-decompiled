package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLinkListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class AFa1tSDK {
    static final List<String> AFInAppEventType = new ArrayList();
    public static String[] AFKeystoreWrapper;
    private static Intent afErrorLog;
    public String AFInAppEventParameterName;
    public List<List<String>> afRDLog = new ArrayList();
    public Map<String, String> valueOf;
    public DeepLinkListener values;

    /* access modifiers changed from: package-private */
    public final void AFInAppEventType(Map<String, Object> map, Intent intent, Context context) {
        AFb1xSDK.AFInAppEventType().AFInAppEventType(context);
        AFc1vSDK AFKeystoreWrapper2 = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper();
        AFc1xSDK afErrorLog2 = AFKeystoreWrapper2.afErrorLog();
        if (!values(intent, context, map) && this.values != null && AFKeystoreWrapper2.AFInAppEventParameterName().AFInAppEventType.AFKeystoreWrapper("appsFlyerCount", 0) == 0 && !afErrorLog2.AFInAppEventParameterName("ddl_sent")) {
            AFb1qSDK aFb1qSDK = new AFb1qSDK(context, AFKeystoreWrapper2);
            AFd1pSDK afDebugLog = AFKeystoreWrapper2.afDebugLog();
            afDebugLog.AFKeystoreWrapper.execute(new Runnable(new AFd1gSDK(aFb1qSDK)) {
                private /* synthetic */ AFd1qSDK AFInAppEventParameterName;

                {
                    this.AFInAppEventParameterName = r2;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c9, code lost:
                    if (r1 == false) goto L_0x016c;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:30:0x00cb, code lost:
                    r6.AFKeystoreWrapper.AFInAppEventParameterName.add(r6.AFInAppEventParameterName.values);
                    com.appsflyer.AFLogger.afDebugLog(new java.lang.StringBuilder("QUEUE: new task added: ").append(r6.AFInAppEventParameterName).toString());
                    r0 = r6.AFKeystoreWrapper.valueOf.iterator();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f6, code lost:
                    if (r0.hasNext() == false) goto L_0x00ff;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f8, code lost:
                    r1 = r0.next();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ff, code lost:
                    r0 = r6.AFKeystoreWrapper;
                    r0.AFInAppEventType.submit(r0);
                    r0 = r6.AFKeystoreWrapper;
                    r1 = r0.afDebugLog;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:35:0x010a, code lost:
                    monitor-enter(r1);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
                    r2 = (r0.afDebugLog.size() + r0.AFLogger.size()) - 40;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:38:0x011a, code lost:
                    if (r2 <= 0) goto L_0x0167;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:40:0x0123, code lost:
                    if (r0.AFLogger.isEmpty() != false) goto L_0x0127;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:41:0x0125, code lost:
                    r3 = true;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:42:0x0127, code lost:
                    r3 = false;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:43:0x0128, code lost:
                    r4 = true ^ r0.afDebugLog.isEmpty();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:44:0x012f, code lost:
                    if (r4 == false) goto L_0x0155;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:45:0x0131, code lost:
                    if (r3 == false) goto L_0x0155;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:47:0x0147, code lost:
                    if (((com.appsflyer.internal.AFd1qSDK) r0.afDebugLog.first()).AFInAppEventType((com.appsflyer.internal.AFd1qSDK) r0.AFLogger.first()) <= 0) goto L_0x014f;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:48:0x0149, code lost:
                    r0.AFKeystoreWrapper(r0.afDebugLog);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:49:0x014f, code lost:
                    r0.AFKeystoreWrapper(r0.AFLogger);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:50:0x0155, code lost:
                    if (r4 == false) goto L_0x015d;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:51:0x0157, code lost:
                    r0.AFKeystoreWrapper(r0.afDebugLog);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:52:0x015d, code lost:
                    if (r3 == false) goto L_0x0164;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:53:0x015f, code lost:
                    r0.AFKeystoreWrapper(r0.AFLogger);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:54:0x0164, code lost:
                    r2 = r2 - 1;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:55:0x0167, code lost:
                    monitor-exit(r1);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:56:0x0168, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:60:0x016c, code lost:
                    com.appsflyer.AFLogger.afWarnLog(new java.lang.StringBuilder("QUEUE: tried to add already pending task: ").append(r6.AFInAppEventParameterName).toString());
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:61:0x0180, code lost:
                    return;
                 */
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
                        int r3 = r3.AFInAppEventType(r4)     // Catch:{ all -> 0x0169 }
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
        afErrorLog2.AFInAppEventType("ddl_sent", true);
    }

    static void AFKeystoreWrapper(Context context, Map<String, Object> map, Uri uri) {
        AFd1fSDK aFd1fSDK = new AFd1fSDK(context, map, uri, AFInAppEventType);
        AFb1xSDK.AFInAppEventType().AFInAppEventType(context);
        AFd1pSDK afDebugLog = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afDebugLog();
        afDebugLog.AFKeystoreWrapper.execute(new Runnable(aFd1fSDK) {
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
                    int r3 = r3.AFInAppEventType(r4)     // Catch:{ all -> 0x0169 }
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
        afErrorLog = null;
    }

    private Uri AFInAppEventParameterName(Object obj, Iterator<String> it) {
        while (obj != JSONObject.NULL) {
            if (!it.hasNext()) {
                Uri parse = Uri.parse(obj.toString());
                if (parse == null || parse.getScheme() == null || parse.getHost() == null) {
                    return null;
                }
                return parse;
            }
            try {
                obj = new JSONObject(obj.toString()).get(it.next());
            } catch (JSONException e) {
                AFLogger.afErrorLogForExcManagerOnly("recursiveSearch error", e);
                return null;
            }
        }
        return null;
    }

    static Uri values(Intent intent) {
        if (intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) {
            return null;
        }
        return intent.getData();
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0076 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean values(android.content.Intent r9, android.content.Context r10, java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
            r8 = this;
            java.lang.String r0 = "android.intent.action.VIEW"
            r1 = 0
            if (r9 == 0) goto L_0x0014
            java.lang.String r2 = r9.getAction()
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0014
            android.net.Uri r2 = r9.getData()
            goto L_0x0015
        L_0x0014:
            r2 = r1
        L_0x0015:
            android.content.Intent r3 = afErrorLog
            if (r3 == 0) goto L_0x0028
            java.lang.String r4 = r3.getAction()
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0028
            android.net.Uri r0 = r3.getData()
            goto L_0x0029
        L_0x0028:
            r0 = r1
        L_0x0029:
            if (r9 != 0) goto L_0x0031
            java.lang.String r3 = "Could not extract deeplink from null intent"
            com.appsflyer.AFLogger.afDebugLog(r3)
            goto L_0x0098
        L_0x0031:
            android.os.Bundle r3 = r9.getExtras()
            java.util.List<java.util.List<java.lang.String>> r4 = r8.afRDLog
            if (r4 == 0) goto L_0x0098
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0098
            if (r3 != 0) goto L_0x0042
            goto L_0x0098
        L_0x0042:
            java.util.List<java.util.List<java.lang.String>> r4 = r8.afRDLog
            java.util.Iterator r4 = r4.iterator()
        L_0x0048:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0098
            java.lang.Object r5 = r4.next()
            java.util.List r5 = (java.util.List) r5
            if (r5 != 0) goto L_0x0058
        L_0x0056:
            r6 = r1
            goto L_0x0074
        L_0x0058:
            java.util.Iterator r6 = r5.iterator()
            boolean r7 = r6.hasNext()
            if (r7 != 0) goto L_0x0063
            goto L_0x0056
        L_0x0063:
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = r3.getString(r7)
            if (r7 != 0) goto L_0x0070
            goto L_0x0056
        L_0x0070:
            android.net.Uri r6 = r8.AFInAppEventParameterName(r7, r6)
        L_0x0074:
            if (r6 == 0) goto L_0x0048
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Found deeplink in push payload at "
            r1.<init>(r3)
            java.lang.String r3 = r5.toString()
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.appsflyer.AFLogger.afDebugLog(r1)
            java.util.Map r1 = com.appsflyer.internal.AFb1xSDK.valueOf((java.util.Map<java.lang.String, java.lang.Object>) r11)
            java.util.List<java.util.List<java.lang.String>> r3 = r8.afRDLog
            java.lang.String r4 = "payloadKey"
            r1.put(r4, r3)
            r1 = r6
        L_0x0098:
            r3 = 1
            java.lang.String r4 = " w/af_consumed"
            r5 = 0
            java.lang.String r6 = "af_consumed"
            if (r2 == 0) goto L_0x00cc
            boolean r0 = r9.hasExtra(r6)
            if (r0 != 0) goto L_0x00b1
            long r0 = java.lang.System.currentTimeMillis()
            r9.putExtra(r6, r0)
            AFKeystoreWrapper(r10, r11, r2)
            return r3
        L_0x00b1:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "skipping re-use of previously consumed deep link: "
            r9.<init>(r10)
            java.lang.String r10 = r2.toString()
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.StringBuilder r9 = r9.append(r4)
            java.lang.String r9 = r9.toString()
            com.appsflyer.AFLogger.afInfoLog(r9)
            return r5
        L_0x00cc:
            if (r0 == 0) goto L_0x00fe
            android.content.Intent r9 = afErrorLog
            boolean r9 = r9.hasExtra(r6)
            if (r9 != 0) goto L_0x00e3
            android.content.Intent r9 = afErrorLog
            long r1 = java.lang.System.currentTimeMillis()
            r9.putExtra(r6, r1)
            AFKeystoreWrapper(r10, r11, r0)
            return r3
        L_0x00e3:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "skipping re-use of previously consumed trampoline deep link: "
            r9.<init>(r10)
            java.lang.String r10 = r0.toString()
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.StringBuilder r9 = r9.append(r4)
            java.lang.String r9 = r9.toString()
            com.appsflyer.AFLogger.afInfoLog(r9)
            return r5
        L_0x00fe:
            if (r1 == 0) goto L_0x012c
            boolean r0 = r9.hasExtra(r6)
            if (r0 != 0) goto L_0x0111
            long r4 = java.lang.System.currentTimeMillis()
            r9.putExtra(r6, r4)
            AFKeystoreWrapper(r10, r11, r1)
            return r3
        L_0x0111:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "skipping re-use of previously consumed deep link from push: "
            r9.<init>(r10)
            java.lang.String r10 = r1.toString()
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.StringBuilder r9 = r9.append(r4)
            java.lang.String r9 = r9.toString()
            com.appsflyer.AFLogger.afInfoLog(r9)
            return r5
        L_0x012c:
            java.lang.String r9 = "No deep link detected"
            com.appsflyer.AFLogger.afDebugLog(r9)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1tSDK.values(android.content.Intent, android.content.Context, java.util.Map):boolean");
    }

    public static void valueOf(Intent intent) {
        Uri uri;
        if (intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) {
            uri = null;
        } else {
            uri = intent.getData();
        }
        if (uri != null && intent != afErrorLog) {
            afErrorLog = intent;
        }
    }
}
