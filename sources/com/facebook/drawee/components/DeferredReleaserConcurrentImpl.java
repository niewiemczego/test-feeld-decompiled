package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.drawee.components.DeferredReleaser;
import java.util.ArrayList;

class DeferredReleaserConcurrentImpl extends DeferredReleaser {
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    /* access modifiers changed from: private */
    public ArrayList<DeferredReleaser.Releasable> mPendingReleasables = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<DeferredReleaser.Releasable> mTempList = new ArrayList<>();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());
    private final Runnable releaseRunnable = new Runnable() {
        public void run() {
            synchronized (DeferredReleaserConcurrentImpl.this.mLock) {
                ArrayList access$100 = DeferredReleaserConcurrentImpl.this.mTempList;
                DeferredReleaserConcurrentImpl deferredReleaserConcurrentImpl = DeferredReleaserConcurrentImpl.this;
                ArrayList unused = deferredReleaserConcurrentImpl.mTempList = deferredReleaserConcurrentImpl.mPendingReleasables;
                ArrayList unused2 = DeferredReleaserConcurrentImpl.this.mPendingReleasables = access$100;
            }
            int size = DeferredReleaserConcurrentImpl.this.mTempList.size();
            for (int i = 0; i < size; i++) {
                ((DeferredReleaser.Releasable) DeferredReleaserConcurrentImpl.this.mTempList.get(i)).release();
            }
            DeferredReleaserConcurrentImpl.this.mTempList.clear();
        }
    };

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        if (r1 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        r2.mUiHandler.post(r2.releaseRunnable);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void scheduleDeferredRelease(com.facebook.drawee.components.DeferredReleaser.Releasable r3) {
        /*
            r2 = this;
            boolean r0 = isOnUiThread()
            if (r0 != 0) goto L_0x000a
            r3.release()
            return
        L_0x000a:
            java.lang.Object r0 = r2.mLock
            monitor-enter(r0)
            java.util.ArrayList<com.facebook.drawee.components.DeferredReleaser$Releasable> r1 = r2.mPendingReleasables     // Catch:{ all -> 0x0032 }
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0017:
            java.util.ArrayList<com.facebook.drawee.components.DeferredReleaser$Releasable> r1 = r2.mPendingReleasables     // Catch:{ all -> 0x0032 }
            r1.add(r3)     // Catch:{ all -> 0x0032 }
            java.util.ArrayList<com.facebook.drawee.components.DeferredReleaser$Releasable> r3 = r2.mPendingReleasables     // Catch:{ all -> 0x0032 }
            int r3 = r3.size()     // Catch:{ all -> 0x0032 }
            r1 = 1
            if (r3 != r1) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            r1 = 0
        L_0x0027:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0031
            android.os.Handler r3 = r2.mUiHandler
            java.lang.Runnable r0 = r2.releaseRunnable
            r3.post(r0)
        L_0x0031:
            return
        L_0x0032:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.components.DeferredReleaserConcurrentImpl.scheduleDeferredRelease(com.facebook.drawee.components.DeferredReleaser$Releasable):void");
    }

    public void cancelDeferredRelease(DeferredReleaser.Releasable releasable) {
        synchronized (this.mLock) {
            this.mPendingReleasables.remove(releasable);
        }
    }
}
