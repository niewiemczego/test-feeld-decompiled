package bolts;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class CancellationTokenSource implements Closeable {
    private boolean cancellationRequested;
    private boolean closed;
    private final ScheduledExecutorService executor = BoltsExecutors.scheduled();
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final List<CancellationTokenRegistration> registrations = new ArrayList();
    /* access modifiers changed from: private */
    public ScheduledFuture<?> scheduledCancellation;

    public boolean isCancellationRequested() {
        boolean z;
        synchronized (this.lock) {
            throwIfClosed();
            z = this.cancellationRequested;
        }
        return z;
    }

    public CancellationToken getToken() {
        CancellationToken cancellationToken;
        synchronized (this.lock) {
            throwIfClosed();
            cancellationToken = new CancellationToken(this);
        }
        return cancellationToken;
    }

    public void cancel() {
        synchronized (this.lock) {
            throwIfClosed();
            if (!this.cancellationRequested) {
                cancelScheduledCancellation();
                this.cancellationRequested = true;
                ArrayList arrayList = new ArrayList(this.registrations);
                notifyListeners(arrayList);
            }
        }
    }

    public void cancelAfter(long j) {
        cancelAfter(j, TimeUnit.MILLISECONDS);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cancelAfter(long r4, java.util.concurrent.TimeUnit r6) {
        /*
            r3 = this;
            r0 = -1
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x0030
            r1 = 0
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0010
            r3.cancel()
            return
        L_0x0010:
            java.lang.Object r1 = r3.lock
            monitor-enter(r1)
            boolean r2 = r3.cancellationRequested     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0019
            monitor-exit(r1)     // Catch:{ all -> 0x002d }
            return
        L_0x0019:
            r3.cancelScheduledCancellation()     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x002b
            java.util.concurrent.ScheduledExecutorService r0 = r3.executor     // Catch:{ all -> 0x002d }
            bolts.CancellationTokenSource$1 r2 = new bolts.CancellationTokenSource$1     // Catch:{ all -> 0x002d }
            r2.<init>()     // Catch:{ all -> 0x002d }
            java.util.concurrent.ScheduledFuture r4 = r0.schedule(r2, r4, r6)     // Catch:{ all -> 0x002d }
            r3.scheduledCancellation = r4     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r1)     // Catch:{ all -> 0x002d }
            return
        L_0x002d:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002d }
            throw r4
        L_0x0030:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Delay must be >= -1"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: bolts.CancellationTokenSource.cancelAfter(long, java.util.concurrent.TimeUnit):void");
    }

    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                cancelScheduledCancellation();
                for (CancellationTokenRegistration close : this.registrations) {
                    close.close();
                }
                this.registrations.clear();
                this.closed = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public CancellationTokenRegistration register(Runnable runnable) {
        CancellationTokenRegistration cancellationTokenRegistration;
        synchronized (this.lock) {
            throwIfClosed();
            cancellationTokenRegistration = new CancellationTokenRegistration(this, runnable);
            if (this.cancellationRequested) {
                cancellationTokenRegistration.runAction();
            } else {
                this.registrations.add(cancellationTokenRegistration);
            }
        }
        return cancellationTokenRegistration;
    }

    /* access modifiers changed from: package-private */
    public void throwIfCancellationRequested() throws CancellationException {
        synchronized (this.lock) {
            throwIfClosed();
            if (this.cancellationRequested) {
                throw new CancellationException();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void unregister(CancellationTokenRegistration cancellationTokenRegistration) {
        synchronized (this.lock) {
            throwIfClosed();
            this.registrations.remove(cancellationTokenRegistration);
        }
    }

    private void notifyListeners(List<CancellationTokenRegistration> list) {
        for (CancellationTokenRegistration runAction : list) {
            runAction.runAction();
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(isCancellationRequested())});
    }

    private void throwIfClosed() {
        if (this.closed) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void cancelScheduledCancellation() {
        ScheduledFuture<?> scheduledFuture = this.scheduledCancellation;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.scheduledCancellation = null;
        }
    }
}
