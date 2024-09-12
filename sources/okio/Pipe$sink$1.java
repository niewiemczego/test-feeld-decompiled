package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"okio/Pipe$sink$1", "Lokio/Sink;", "timeout", "Lokio/Timeout;", "close", "", "flush", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Pipe.kt */
public final class Pipe$sink$1 implements Sink {
    final /* synthetic */ Pipe this$0;
    private final Timeout timeout = new Timeout();

    Pipe$sink$1(Pipe pipe) {
        this.this$0 = pipe;
    }

    public void write(Buffer buffer, long j) {
        Sink sink;
        Intrinsics.checkNotNullParameter(buffer, "source");
        Buffer buffer$okio = this.this$0.getBuffer$okio();
        Pipe pipe = this.this$0;
        synchronized (buffer$okio) {
            if (!(!pipe.getSinkClosed$okio())) {
                throw new IllegalStateException("closed".toString());
            } else if (!pipe.getCanceled$okio()) {
                while (true) {
                    if (j <= 0) {
                        sink = null;
                        break;
                    }
                    sink = pipe.getFoldedSink$okio();
                    if (sink != null) {
                        break;
                    } else if (!pipe.getSourceClosed$okio()) {
                        long maxBufferSize$okio = pipe.getMaxBufferSize$okio() - pipe.getBuffer$okio().size();
                        if (maxBufferSize$okio == 0) {
                            this.timeout.waitUntilNotified(pipe.getBuffer$okio());
                            if (pipe.getCanceled$okio()) {
                                throw new IOException("canceled");
                            }
                        } else {
                            long min = Math.min(maxBufferSize$okio, j);
                            pipe.getBuffer$okio().write(buffer, min);
                            j -= min;
                            pipe.getBuffer$okio().notifyAll();
                        }
                    } else {
                        throw new IOException("source is closed");
                    }
                }
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IOException("canceled");
            }
        }
        if (sink != null) {
            Pipe pipe2 = this.this$0;
            Timeout timeout2 = sink.timeout();
            Timeout timeout3 = pipe2.sink().timeout();
            long timeoutNanos = timeout2.timeoutNanos();
            timeout2.timeout(Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos()), TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                long deadlineNanoTime = timeout2.deadlineNanoTime();
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                }
                try {
                    sink.write(buffer, j);
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(deadlineNanoTime);
                    }
                }
            } else {
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                }
                try {
                    sink.write(buffer, j);
                    Unit unit3 = Unit.INSTANCE;
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.clearDeadline();
                    }
                }
            }
        }
    }

    public void flush() {
        Sink foldedSink$okio;
        Buffer buffer$okio = this.this$0.getBuffer$okio();
        Pipe pipe = this.this$0;
        synchronized (buffer$okio) {
            if (!(!pipe.getSinkClosed$okio())) {
                throw new IllegalStateException("closed".toString());
            } else if (!pipe.getCanceled$okio()) {
                foldedSink$okio = pipe.getFoldedSink$okio();
                if (foldedSink$okio == null) {
                    if (pipe.getSourceClosed$okio()) {
                        if (pipe.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                    }
                    foldedSink$okio = null;
                }
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IOException("canceled");
            }
        }
        if (foldedSink$okio != null) {
            Pipe pipe2 = this.this$0;
            Timeout timeout2 = foldedSink$okio.timeout();
            Timeout timeout3 = pipe2.sink().timeout();
            long timeoutNanos = timeout2.timeoutNanos();
            timeout2.timeout(Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos()), TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                long deadlineNanoTime = timeout2.deadlineNanoTime();
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                }
                try {
                    foldedSink$okio.flush();
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(deadlineNanoTime);
                    }
                }
            } else {
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                }
                try {
                    foldedSink$okio.flush();
                    Unit unit3 = Unit.INSTANCE;
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.clearDeadline();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        r0 = r11.this$0;
        r1 = r2.timeout();
        r0 = r0.sink().timeout();
        r3 = r1.timeoutNanos();
        r1.timeout(okio.Timeout.Companion.minTimeout(r0.timeoutNanos(), r1.timeoutNanos()), java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0071, code lost:
        if (r1.hasDeadline() == false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0073, code lost:
        r5 = r1.deadlineNanoTime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
        if (r0.hasDeadline() == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
        r1.deadlineNanoTime(java.lang.Math.min(r1.deadlineNanoTime(), r0.deadlineNanoTime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r2.close();
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a0, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a1, code lost:
        r1.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00aa, code lost:
        if (r0.hasDeadline() != false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ac, code lost:
        r1.deadlineNanoTime(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00af, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b4, code lost:
        if (r0.hasDeadline() == false) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b6, code lost:
        r1.deadlineNanoTime(r0.deadlineNanoTime());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r2.close();
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d1, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d2, code lost:
        r1.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00db, code lost:
        if (r0.hasDeadline() != false) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00dd, code lost:
        r1.clearDeadline();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e0, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r11 = this;
            okio.Pipe r0 = r11.this$0
            okio.Buffer r0 = r0.getBuffer$okio()
            okio.Pipe r1 = r11.this$0
            monitor-enter(r0)
            boolean r2 = r1.getSinkClosed$okio()     // Catch:{ all -> 0x00e2 }
            if (r2 == 0) goto L_0x0011
            monitor-exit(r0)
            return
        L_0x0011:
            okio.Sink r2 = r1.getFoldedSink$okio()     // Catch:{ all -> 0x00e2 }
            if (r2 == 0) goto L_0x0018
            goto L_0x0043
        L_0x0018:
            boolean r2 = r1.getSourceClosed$okio()     // Catch:{ all -> 0x00e2 }
            if (r2 == 0) goto L_0x0035
            okio.Buffer r2 = r1.getBuffer$okio()     // Catch:{ all -> 0x00e2 }
            long r2 = r2.size()     // Catch:{ all -> 0x00e2 }
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x002d
            goto L_0x0035
        L_0x002d:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x00e2 }
            java.lang.String r2 = "source is closed"
            r1.<init>(r2)     // Catch:{ all -> 0x00e2 }
            throw r1     // Catch:{ all -> 0x00e2 }
        L_0x0035:
            r2 = 1
            r1.setSinkClosed$okio(r2)     // Catch:{ all -> 0x00e2 }
            okio.Buffer r1 = r1.getBuffer$okio()     // Catch:{ all -> 0x00e2 }
            java.lang.Object r1 = (java.lang.Object) r1     // Catch:{ all -> 0x00e2 }
            r1.notifyAll()     // Catch:{ all -> 0x00e2 }
            r2 = 0
        L_0x0043:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e2 }
            monitor-exit(r0)
            if (r2 == 0) goto L_0x00e1
            okio.Pipe r0 = r11.this$0
            okio.Timeout r1 = r2.timeout()
            okio.Sink r0 = r0.sink()
            okio.Timeout r0 = r0.timeout()
            long r3 = r1.timeoutNanos()
            okio.Timeout$Companion r5 = okio.Timeout.Companion
            long r6 = r0.timeoutNanos()
            long r8 = r1.timeoutNanos()
            long r5 = r5.minTimeout(r6, r8)
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1.timeout(r5, r7)
            boolean r5 = r1.hasDeadline()
            if (r5 == 0) goto L_0x00b0
            long r5 = r1.deadlineNanoTime()
            boolean r7 = r0.hasDeadline()
            if (r7 == 0) goto L_0x008c
            long r7 = r1.deadlineNanoTime()
            long r9 = r0.deadlineNanoTime()
            long r7 = java.lang.Math.min(r7, r9)
            r1.deadlineNanoTime(r7)
        L_0x008c:
            r2.close()     // Catch:{ all -> 0x00a0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a0 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1.timeout(r3, r2)
            boolean r0 = r0.hasDeadline()
            if (r0 == 0) goto L_0x00e1
            r1.deadlineNanoTime(r5)
            goto L_0x00e1
        L_0x00a0:
            r2 = move-exception
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1.timeout(r3, r7)
            boolean r0 = r0.hasDeadline()
            if (r0 == 0) goto L_0x00af
            r1.deadlineNanoTime(r5)
        L_0x00af:
            throw r2
        L_0x00b0:
            boolean r5 = r0.hasDeadline()
            if (r5 == 0) goto L_0x00bd
            long r5 = r0.deadlineNanoTime()
            r1.deadlineNanoTime(r5)
        L_0x00bd:
            r2.close()     // Catch:{ all -> 0x00d1 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00d1 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1.timeout(r3, r2)
            boolean r0 = r0.hasDeadline()
            if (r0 == 0) goto L_0x00e1
            r1.clearDeadline()
            goto L_0x00e1
        L_0x00d1:
            r2 = move-exception
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1.timeout(r3, r5)
            boolean r0 = r0.hasDeadline()
            if (r0 == 0) goto L_0x00e0
            r1.clearDeadline()
        L_0x00e0:
            throw r2
        L_0x00e1:
            return
        L_0x00e2:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Pipe$sink$1.close():void");
    }

    public Timeout timeout() {
        return this.timeout;
    }
}
