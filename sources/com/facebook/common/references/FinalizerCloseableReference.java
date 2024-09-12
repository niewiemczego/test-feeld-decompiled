package com.facebook.common.references;

import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;

public class FinalizerCloseableReference<T> extends CloseableReference<T> {
    private static final String TAG = "FinalizerCloseableReference";

    public CloseableReference<T> clone() {
        return this;
    }

    public void close() {
    }

    FinalizerCloseableReference(T t, ResourceReleaser<T> resourceReleaser, CloseableReference.LeakHandler leakHandler, @Nullable Throwable th) {
        super(t, resourceReleaser, leakHandler, th);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0 = r6.mSharedReference.get();
        r3 = new java.lang.Object[3];
        r3[0] = java.lang.Integer.valueOf(java.lang.System.identityHashCode(r6));
        r3[1] = java.lang.Integer.valueOf(java.lang.System.identityHashCode(r6.mSharedReference));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        if (r0 != null) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        r0 = r0.getClass().getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r3[2] = r0;
        com.facebook.common.logging.FLog.w(TAG, "Finalized without closing: %x %x (type = %s)", r3);
        r6.mSharedReference.deleteReference();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        super.finalize();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finalize() throws java.lang.Throwable {
        /*
            r6 = this;
            monitor-enter(r6)     // Catch:{ all -> 0x004e }
            boolean r0 = r6.mIsClosed     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x000a
            monitor-exit(r6)     // Catch:{ all -> 0x004b }
            super.finalize()
            return
        L_0x000a:
            monitor-exit(r6)     // Catch:{ all -> 0x004b }
            com.facebook.common.references.SharedReference r0 = r6.mSharedReference     // Catch:{ all -> 0x004e }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x004e }
            java.lang.String r1 = "FinalizerCloseableReference"
            java.lang.String r2 = "Finalized without closing: %x %x (type = %s)"
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x004e }
            r4 = 0
            int r5 = java.lang.System.identityHashCode(r6)     // Catch:{ all -> 0x004e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x004e }
            r3[r4] = r5     // Catch:{ all -> 0x004e }
            r4 = 1
            com.facebook.common.references.SharedReference r5 = r6.mSharedReference     // Catch:{ all -> 0x004e }
            int r5 = java.lang.System.identityHashCode(r5)     // Catch:{ all -> 0x004e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x004e }
            r3[r4] = r5     // Catch:{ all -> 0x004e }
            r4 = 2
            if (r0 != 0) goto L_0x0035
            r0 = 0
            goto L_0x003d
        L_0x0035:
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x004e }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x004e }
        L_0x003d:
            r3[r4] = r0     // Catch:{ all -> 0x004e }
            com.facebook.common.logging.FLog.w((java.lang.String) r1, (java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ all -> 0x004e }
            com.facebook.common.references.SharedReference r0 = r6.mSharedReference     // Catch:{ all -> 0x004e }
            r0.deleteReference()     // Catch:{ all -> 0x004e }
            super.finalize()
            return
        L_0x004b:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x004b }
            throw r0     // Catch:{ all -> 0x004e }
        L_0x004e:
            r0 = move-exception
            super.finalize()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.references.FinalizerCloseableReference.finalize():void");
    }
}
