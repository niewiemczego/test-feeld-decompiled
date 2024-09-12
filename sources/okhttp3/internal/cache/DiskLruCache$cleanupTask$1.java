package okhttp3.internal.cache;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.concurrent.Task;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DiskLruCache.kt */
public final class DiskLruCache$cleanupTask$1 extends Task {
    final /* synthetic */ DiskLruCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiskLruCache$cleanupTask$1(DiskLruCache diskLruCache, String str) {
        super(str, false, 2, (DefaultConstructorMarker) null);
        this.this$0 = diskLruCache;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.mostRecentRebuildFailed = true;
        r0.journalWriter = okio.Okio.buffer(okio.Okio.blackhole());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        return -1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0017 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long runOnce() {
        /*
            r5 = this;
            okhttp3.internal.cache.DiskLruCache r0 = r5.this$0
            monitor-enter(r0)
            boolean r1 = r0.initialized     // Catch:{ all -> 0x003a }
            r2 = -1
            if (r1 == 0) goto L_0x0038
            boolean r1 = r0.getClosed$okhttp()     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0012
            goto L_0x0038
        L_0x0012:
            r1 = 1
            r0.trimToSize()     // Catch:{ IOException -> 0x0017 }
            goto L_0x001a
        L_0x0017:
            r0.mostRecentTrimFailed = r1     // Catch:{ all -> 0x003a }
        L_0x001a:
            boolean r4 = r0.journalRebuildRequired()     // Catch:{ IOException -> 0x0028 }
            if (r4 == 0) goto L_0x0036
            r0.rebuildJournal$okhttp()     // Catch:{ IOException -> 0x0028 }
            r4 = 0
            r0.redundantOpCount = r4     // Catch:{ IOException -> 0x0028 }
            goto L_0x0036
        L_0x0028:
            r0.mostRecentRebuildFailed = r1     // Catch:{ all -> 0x003a }
            okio.Sink r1 = okio.Okio.blackhole()     // Catch:{ all -> 0x003a }
            okio.BufferedSink r1 = okio.Okio.buffer((okio.Sink) r1)     // Catch:{ all -> 0x003a }
            r0.journalWriter = r1     // Catch:{ all -> 0x003a }
        L_0x0036:
            monitor-exit(r0)
            return r2
        L_0x0038:
            monitor-exit(r0)
            return r2
        L_0x003a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache$cleanupTask$1.runOnce():long");
    }
}
