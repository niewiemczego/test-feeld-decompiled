package com.launchdarkly.sdk.android;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Debounce {
    private volatile Callable<Void> inFlight = null;
    private volatile Callable<Void> pending;
    private final ExecutorService service = Executors.newSingleThreadExecutor();

    Debounce() {
    }

    /* access modifiers changed from: package-private */
    public synchronized void call(Callable<Void> callable) {
        this.pending = callable;
        schedulePending();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void schedulePending() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.concurrent.Callable<java.lang.Void> r0 = r2.pending     // Catch:{ all -> 0x001e }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            java.util.concurrent.Callable<java.lang.Void> r0 = r2.inFlight     // Catch:{ all -> 0x001e }
            if (r0 != 0) goto L_0x001c
            java.util.concurrent.Callable<java.lang.Void> r0 = r2.pending     // Catch:{ all -> 0x001e }
            r2.inFlight = r0     // Catch:{ all -> 0x001e }
            java.util.concurrent.ExecutorService r0 = r2.service     // Catch:{ all -> 0x001e }
            com.launchdarkly.sdk.android.Debounce$$ExternalSyntheticLambda0 r1 = new com.launchdarkly.sdk.android.Debounce$$ExternalSyntheticLambda0     // Catch:{ all -> 0x001e }
            r1.<init>(r2)     // Catch:{ all -> 0x001e }
            r0.submit(r1)     // Catch:{ all -> 0x001e }
            r0 = 0
            r2.pending = r0     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r2)
            return
        L_0x001e:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.android.Debounce.schedulePending():void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$schedulePending$0$com-launchdarkly-sdk-android-Debounce  reason: not valid java name */
    public /* synthetic */ Object m451lambda$schedulePending$0$comlaunchdarklysdkandroidDebounce() throws Exception {
        try {
            this.inFlight.call();
            return null;
        } finally {
            this.inFlight = null;
            schedulePending();
        }
    }
}
