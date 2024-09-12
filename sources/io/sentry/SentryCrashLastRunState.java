package io.sentry;

public final class SentryCrashLastRunState {
    private static final SentryCrashLastRunState INSTANCE = new SentryCrashLastRunState();
    private Boolean crashedLastRun;
    private final Object crashedLastRunLock = new Object();
    private boolean readCrashedLastRun;

    private SentryCrashLastRunState() {
    }

    public static SentryCrashLastRunState getInstance() {
        return INSTANCE;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:12|13|14|15|(2:17|18)(4:19|20|(1:(2:23|24))|25)|27|28|29|30) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0039 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean isCrashedLastRun(java.lang.String r6, boolean r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.crashedLastRunLock
            monitor-enter(r0)
            boolean r1 = r5.readCrashedLastRun     // Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x000b
            java.lang.Boolean r6 = r5.crashedLastRun     // Catch:{ all -> 0x0041 }
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return r6
        L_0x000b:
            if (r6 != 0) goto L_0x0010
            r6 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return r6
        L_0x0010:
            r1 = 1
            r5.readCrashedLastRun = r1     // Catch:{ all -> 0x0041 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0041 }
            java.lang.String r3 = "last_crash"
            r2.<init>(r6, r3)     // Catch:{ all -> 0x0041 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = ".sentry-native/last_crash"
            r3.<init>(r6, r4)     // Catch:{ all -> 0x0041 }
            r6 = 0
            boolean r4 = r2.exists()     // Catch:{ all -> 0x0038 }
            if (r4 == 0) goto L_0x002c
            r2.delete()     // Catch:{ all -> 0x0039 }
            goto L_0x0039
        L_0x002c:
            boolean r2 = r3.exists()     // Catch:{ all -> 0x0038 }
            if (r2 == 0) goto L_0x0038
            if (r7 == 0) goto L_0x0039
            r3.delete()     // Catch:{ all -> 0x0039 }
            goto L_0x0039
        L_0x0038:
            r1 = r6
        L_0x0039:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0041 }
            r5.crashedLastRun = r6     // Catch:{ all -> 0x0041 }
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return r6
        L_0x0041:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryCrashLastRunState.isCrashedLastRun(java.lang.String, boolean):java.lang.Boolean");
    }

    public void setCrashedLastRun(boolean z) {
        synchronized (this.crashedLastRunLock) {
            if (!this.readCrashedLastRun) {
                this.crashedLastRun = Boolean.valueOf(z);
                this.readCrashedLastRun = true;
            }
        }
    }

    public void reset() {
        synchronized (this.crashedLastRunLock) {
            this.readCrashedLastRun = false;
            this.crashedLastRun = null;
        }
    }
}
