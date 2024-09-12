package com.appsflyer.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class AFd1pSDK implements Runnable {
    final Set<AFd1sSDK> AFInAppEventParameterName = Collections.newSetFromMap(new ConcurrentHashMap());
    final ExecutorService AFInAppEventType;
    public Executor AFKeystoreWrapper = Executors.newSingleThreadExecutor();
    final NavigableSet<AFd1qSDK<?>> AFLogger = new ConcurrentSkipListSet();
    final NavigableSet<AFd1qSDK<?>> afDebugLog = new ConcurrentSkipListSet();
    private Timer afErrorLog = new Timer(true);
    final List<AFd1qSDK<?>> afInfoLog = new ArrayList();
    final Set<AFd1qSDK<?>> afRDLog = Collections.newSetFromMap(new ConcurrentHashMap());
    public final List<AFd1wSDK> valueOf = new CopyOnWriteArrayList();
    final Set<AFd1sSDK> values = new CopyOnWriteArraySet();

    public AFd1pSDK(ExecutorService executorService) {
        this.AFInAppEventType = executorService;
    }

    /* access modifiers changed from: package-private */
    public final void AFKeystoreWrapper(NavigableSet<AFd1qSDK<?>> navigableSet) {
        AFd1qSDK pollFirst = navigableSet.pollFirst();
        this.values.add(pollFirst.values);
        for (AFd1wSDK AFInAppEventType2 : this.valueOf) {
            AFInAppEventType2.AFInAppEventType(pollFirst);
        }
    }

    /* access modifiers changed from: private */
    public boolean AFInAppEventType(AFd1qSDK<?> aFd1qSDK) {
        return this.values.containsAll(aFd1qSDK.valueOf);
    }

    static /* synthetic */ void AFInAppEventType(AFd1pSDK aFd1pSDK) {
        synchronized (aFd1pSDK.afDebugLog) {
            Iterator<AFd1qSDK<?>> it = aFd1pSDK.AFLogger.iterator();
            boolean z = false;
            while (it.hasNext()) {
                AFd1qSDK next = it.next();
                if (aFd1pSDK.AFInAppEventType((AFd1qSDK<?>) next)) {
                    it.remove();
                    aFd1pSDK.afDebugLog.add(next);
                    z = true;
                }
            }
            if (z) {
                aFd1pSDK.AFInAppEventType.submit(aFd1pSDK);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r2 <= 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        r6.afErrorLog.schedule(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        r6.AFKeystoreWrapper.execute(new com.appsflyer.internal.AFd1pSDK.AnonymousClass1(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        if (r6.afDebugLog.isEmpty() != false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        r6.AFInAppEventType.submit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        com.appsflyer.AFLogger.afDebugLog("QUEUE: starting task execution: ".concat(java.lang.String.valueOf(r1)));
        r2 = r1.afInfoLog();
        r0.cancel();
        r6.AFKeystoreWrapper.execute(new com.appsflyer.internal.AFd1pSDK.AnonymousClass4(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
        r0.cancel();
        r0 = com.appsflyer.internal.AFd1tSDK.values;
        r6.AFKeystoreWrapper.execute(new com.appsflyer.internal.AFd1pSDK.AnonymousClass4(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
        com.appsflyer.AFLogger.afDebugLog("QUEUE: task was interrupted: ".concat(java.lang.String.valueOf(r1)));
        r1.AFInAppEventType = com.appsflyer.internal.AFd1tSDK.AFInAppEventParameterName;
        r0 = com.appsflyer.internal.AFd1tSDK.AFInAppEventParameterName;
        r6.AFKeystoreWrapper.execute(new com.appsflyer.internal.AFd1pSDK.AnonymousClass4(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0090, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        r2 = r1.AFInAppEventParameterName();
        r0 = new com.appsflyer.internal.AFd1rSDK(java.lang.Thread.currentThread());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r6 = this;
            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r0 = r6.afDebugLog
            monitor-enter(r0)
            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r1 = r6.afDebugLog     // Catch:{ all -> 0x0091 }
            java.lang.Object r1 = r1.pollFirst()     // Catch:{ all -> 0x0091 }
            com.appsflyer.internal.AFd1qSDK r1 = (com.appsflyer.internal.AFd1qSDK) r1     // Catch:{ all -> 0x0091 }
            if (r1 != 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            return
        L_0x000f:
            java.util.Set<com.appsflyer.internal.AFd1qSDK<?>> r2 = r6.afRDLog     // Catch:{ all -> 0x0091 }
            r2.add(r1)     // Catch:{ all -> 0x0091 }
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            long r2 = r1.AFInAppEventParameterName()
            com.appsflyer.internal.AFd1rSDK r0 = new com.appsflyer.internal.AFd1rSDK
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            r0.<init>(r4)
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x002d
            java.util.Timer r4 = r6.afErrorLog
            r4.schedule(r0, r2)
        L_0x002d:
            java.util.concurrent.Executor r2 = r6.AFKeystoreWrapper
            com.appsflyer.internal.AFd1pSDK$1 r3 = new com.appsflyer.internal.AFd1pSDK$1
            r3.<init>(r1)
            r2.execute(r3)
            java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r2 = r6.afDebugLog
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0044
            java.util.concurrent.ExecutorService r2 = r6.AFInAppEventType
            r2.submit(r6)
        L_0x0044:
            java.lang.String r2 = "QUEUE: starting task execution: "
            java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            com.appsflyer.internal.AFd1tSDK r2 = r1.call()     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            r0.cancel()     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            java.util.concurrent.Executor r3 = r6.AFKeystoreWrapper     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            com.appsflyer.internal.AFd1pSDK$4 r4 = new com.appsflyer.internal.AFd1pSDK$4     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            r4.<init>(r1, r2)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            r3.execute(r4)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0073, all -> 0x0063 }
            return
        L_0x0063:
            r0.cancel()
            com.appsflyer.internal.AFd1tSDK r0 = com.appsflyer.internal.AFd1tSDK.FAILURE
            java.util.concurrent.Executor r2 = r6.AFKeystoreWrapper
            com.appsflyer.internal.AFd1pSDK$4 r3 = new com.appsflyer.internal.AFd1pSDK$4
            r3.<init>(r1, r0)
            r2.execute(r3)
            return
        L_0x0073:
            java.lang.String r0 = "QUEUE: task was interrupted: "
            java.lang.String r2 = java.lang.String.valueOf(r1)
            java.lang.String r0 = r0.concat(r2)
            com.appsflyer.AFLogger.afDebugLog(r0)
            com.appsflyer.internal.AFd1tSDK r0 = com.appsflyer.internal.AFd1tSDK.TIMEOUT
            r1.AFInAppEventType = r0
            com.appsflyer.internal.AFd1tSDK r0 = com.appsflyer.internal.AFd1tSDK.TIMEOUT
            java.util.concurrent.Executor r2 = r6.AFKeystoreWrapper
            com.appsflyer.internal.AFd1pSDK$4 r3 = new com.appsflyer.internal.AFd1pSDK$4
            r3.<init>(r1, r0)
            r2.execute(r3)
            return
        L_0x0091:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1pSDK.run():void");
    }
}
