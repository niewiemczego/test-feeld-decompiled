package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public abstract class SegmentDownloader<M extends FilterableManifest<M>> implements Downloader {
    private static final int BUFFER_SIZE_BYTES = 131072;
    private static final long MAX_MERGED_SEGMENT_START_TIME_DIFF_US = 20000000;
    private final ArrayList<RunnableFutureTask<?, ?>> activeRunnables = new ArrayList<>();
    private final Cache cache;
    private final CacheDataSource.Factory cacheDataSourceFactory;
    private final CacheKeyFactory cacheKeyFactory;
    private final Executor executor;
    private volatile boolean isCanceled;
    private final DataSpec manifestDataSpec;
    /* access modifiers changed from: private */
    public final ParsingLoadable.Parser<M> manifestParser;
    private final PriorityTaskManager priorityTaskManager;
    private final ArrayList<StreamKey> streamKeys;

    /* access modifiers changed from: protected */
    public abstract List<Segment> getSegments(DataSource dataSource, M m, boolean z) throws IOException, InterruptedException;

    protected static class Segment implements Comparable<Segment> {
        public final DataSpec dataSpec;
        public final long startTimeUs;

        public Segment(long j, DataSpec dataSpec2) {
            this.startTimeUs = j;
            this.dataSpec = dataSpec2;
        }

        public int compareTo(Segment segment) {
            return Util.compareLong(this.startTimeUs, segment.startTimeUs);
        }
    }

    public SegmentDownloader(MediaItem mediaItem, ParsingLoadable.Parser<M> parser, CacheDataSource.Factory factory, Executor executor2) {
        Assertions.checkNotNull(mediaItem.localConfiguration);
        this.manifestDataSpec = getCompressibleDataSpec(mediaItem.localConfiguration.uri);
        this.manifestParser = parser;
        this.streamKeys = new ArrayList<>(mediaItem.localConfiguration.streamKeys);
        this.cacheDataSourceFactory = factory;
        this.executor = executor2;
        this.cache = (Cache) Assertions.checkNotNull(factory.getCache());
        this.cacheKeyFactory = factory.getCacheKeyFactory();
        this.priorityTaskManager = factory.getUpstreamPriorityTaskManager();
    }

    /* JADX WARNING: Removed duplicated region for block: B:87:0x01a6 A[LOOP:5: B:85:0x019e->B:87:0x01a6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01bf A[LOOP:6: B:89:0x01bd->B:90:0x01bf, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void download(com.google.android.exoplayer2.offline.Downloader.ProgressListener r26) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r25 = this;
            r1 = r25
            java.util.ArrayDeque r2 = new java.util.ArrayDeque
            r2.<init>()
            java.util.ArrayDeque r3 = new java.util.ArrayDeque
            r3.<init>()
            com.google.android.exoplayer2.util.PriorityTaskManager r0 = r1.priorityTaskManager
            r4 = -1000(0xfffffffffffffc18, float:NaN)
            if (r0 == 0) goto L_0x0015
            r0.add(r4)
        L_0x0015:
            r5 = 0
            r6 = 1
            com.google.android.exoplayer2.upstream.cache.CacheDataSource$Factory r0 = r1.cacheDataSourceFactory     // Catch:{ all -> 0x019b }
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r0 = r0.createDataSourceForDownloading()     // Catch:{ all -> 0x019b }
            com.google.android.exoplayer2.upstream.DataSpec r7 = r1.manifestDataSpec     // Catch:{ all -> 0x019b }
            com.google.android.exoplayer2.offline.FilterableManifest r7 = r1.getManifest(r0, r7, r5)     // Catch:{ all -> 0x019b }
            java.util.ArrayList<com.google.android.exoplayer2.offline.StreamKey> r8 = r1.streamKeys     // Catch:{ all -> 0x019b }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x019b }
            if (r8 != 0) goto L_0x0033
            java.util.ArrayList<com.google.android.exoplayer2.offline.StreamKey> r8 = r1.streamKeys     // Catch:{ all -> 0x019b }
            java.lang.Object r7 = r7.copy(r8)     // Catch:{ all -> 0x019b }
            com.google.android.exoplayer2.offline.FilterableManifest r7 = (com.google.android.exoplayer2.offline.FilterableManifest) r7     // Catch:{ all -> 0x019b }
        L_0x0033:
            java.util.List r0 = r1.getSegments(r0, r7, r5)     // Catch:{ all -> 0x019b }
            java.util.Collections.sort(r0)     // Catch:{ all -> 0x019b }
            com.google.android.exoplayer2.upstream.cache.CacheKeyFactory r7 = r1.cacheKeyFactory     // Catch:{ all -> 0x019b }
            mergeSegments(r0, r7)     // Catch:{ all -> 0x019b }
            int r12 = r0.size()     // Catch:{ all -> 0x019b }
            int r7 = r0.size()     // Catch:{ all -> 0x019b }
            int r7 = r7 - r6
            r8 = 0
            r15 = r5
            r10 = r8
            r13 = r10
        L_0x004d:
            if (r7 < 0) goto L_0x00af
            java.lang.Object r8 = r0.get(r7)     // Catch:{ all -> 0x00aa }
            com.google.android.exoplayer2.offline.SegmentDownloader$Segment r8 = (com.google.android.exoplayer2.offline.SegmentDownloader.Segment) r8     // Catch:{ all -> 0x00aa }
            com.google.android.exoplayer2.upstream.DataSpec r8 = r8.dataSpec     // Catch:{ all -> 0x00aa }
            com.google.android.exoplayer2.upstream.cache.CacheKeyFactory r9 = r1.cacheKeyFactory     // Catch:{ all -> 0x00aa }
            java.lang.String r9 = r9.buildCacheKey(r8)     // Catch:{ all -> 0x00aa }
            long r5 = r8.length     // Catch:{ all -> 0x00aa }
            r22 = -1
            int r16 = (r5 > r22 ? 1 : (r5 == r22 ? 0 : -1))
            if (r16 != 0) goto L_0x0077
            com.google.android.exoplayer2.upstream.cache.Cache r4 = r1.cache     // Catch:{ all -> 0x019b }
            com.google.android.exoplayer2.upstream.cache.ContentMetadata r4 = r4.getContentMetadata(r9)     // Catch:{ all -> 0x019b }
            long r16 = com.google.android.exoplayer2.upstream.cache.ContentMetadata.getContentLength(r4)     // Catch:{ all -> 0x019b }
            int r4 = (r16 > r22 ? 1 : (r16 == r22 ? 0 : -1))
            if (r4 == 0) goto L_0x0077
            long r4 = r8.position     // Catch:{ all -> 0x019b }
            long r5 = r16 - r4
        L_0x0077:
            com.google.android.exoplayer2.upstream.cache.Cache r4 = r1.cache     // Catch:{ all -> 0x00aa }
            r24 = r2
            long r1 = r8.position     // Catch:{ all -> 0x00aa }
            r16 = r4
            r17 = r9
            r18 = r1
            r20 = r5
            long r1 = r16.getCachedBytes(r17, r18, r20)     // Catch:{ all -> 0x00aa }
            long r13 = r13 + r1
            int r4 = (r5 > r22 ? 1 : (r5 == r22 ? 0 : -1))
            if (r4 == 0) goto L_0x009d
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0097
            int r15 = r15 + 1
            r0.remove(r7)     // Catch:{ all -> 0x00aa }
        L_0x0097:
            int r1 = (r10 > r22 ? 1 : (r10 == r22 ? 0 : -1))
            if (r1 == 0) goto L_0x009f
            long r10 = r10 + r5
            goto L_0x009f
        L_0x009d:
            r10 = r22
        L_0x009f:
            int r7 = r7 + -1
            r1 = r25
            r2 = r24
            r4 = -1000(0xfffffffffffffc18, float:NaN)
            r5 = 0
            r6 = 1
            goto L_0x004d
        L_0x00aa:
            r0 = move-exception
            r4 = r25
            goto L_0x019d
        L_0x00af:
            r24 = r2
            if (r26 == 0) goto L_0x00bc
            com.google.android.exoplayer2.offline.SegmentDownloader$ProgressNotifier r1 = new com.google.android.exoplayer2.offline.SegmentDownloader$ProgressNotifier     // Catch:{ all -> 0x00aa }
            r8 = r1
            r9 = r26
            r8.<init>(r9, r10, r12, r13, r15)     // Catch:{ all -> 0x00aa }
            goto L_0x00bd
        L_0x00bc:
            r1 = 0
        L_0x00bd:
            r2 = r24
            r2.addAll(r0)     // Catch:{ all -> 0x00aa }
            r4 = r25
        L_0x00c4:
            boolean r0 = r4.isCanceled     // Catch:{ all -> 0x0199 }
            if (r0 != 0) goto L_0x015c
            boolean r0 = r2.isEmpty()     // Catch:{ all -> 0x0199 }
            if (r0 != 0) goto L_0x015c
            com.google.android.exoplayer2.util.PriorityTaskManager r0 = r4.priorityTaskManager     // Catch:{ all -> 0x0199 }
            if (r0 == 0) goto L_0x00d7
            r5 = -1000(0xfffffffffffffc18, float:NaN)
            r0.proceed(r5)     // Catch:{ all -> 0x0199 }
        L_0x00d7:
            boolean r0 = r3.isEmpty()     // Catch:{ all -> 0x0199 }
            if (r0 != 0) goto L_0x00e8
            java.lang.Object r0 = r3.removeFirst()     // Catch:{ all -> 0x0199 }
            com.google.android.exoplayer2.offline.SegmentDownloader$SegmentDownloadRunnable r0 = (com.google.android.exoplayer2.offline.SegmentDownloader.SegmentDownloadRunnable) r0     // Catch:{ all -> 0x0199 }
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r5 = r0.dataSource     // Catch:{ all -> 0x0199 }
            byte[] r0 = r0.temporaryBuffer     // Catch:{ all -> 0x0199 }
            goto L_0x00f2
        L_0x00e8:
            com.google.android.exoplayer2.upstream.cache.CacheDataSource$Factory r0 = r4.cacheDataSourceFactory     // Catch:{ all -> 0x0199 }
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r5 = r0.createDataSourceForDownloading()     // Catch:{ all -> 0x0199 }
            r0 = 131072(0x20000, float:1.83671E-40)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0199 }
        L_0x00f2:
            java.lang.Object r6 = r2.removeFirst()     // Catch:{ all -> 0x0199 }
            com.google.android.exoplayer2.offline.SegmentDownloader$Segment r6 = (com.google.android.exoplayer2.offline.SegmentDownloader.Segment) r6     // Catch:{ all -> 0x0199 }
            com.google.android.exoplayer2.offline.SegmentDownloader$SegmentDownloadRunnable r7 = new com.google.android.exoplayer2.offline.SegmentDownloader$SegmentDownloadRunnable     // Catch:{ all -> 0x0199 }
            r7.<init>(r6, r5, r1, r0)     // Catch:{ all -> 0x0199 }
            r4.addActiveRunnable(r7)     // Catch:{ all -> 0x0199 }
            java.util.concurrent.Executor r0 = r4.executor     // Catch:{ all -> 0x0199 }
            r0.execute(r7)     // Catch:{ all -> 0x0199 }
            java.util.ArrayList<com.google.android.exoplayer2.util.RunnableFutureTask<?, ?>> r0 = r4.activeRunnables     // Catch:{ all -> 0x0199 }
            int r0 = r0.size()     // Catch:{ all -> 0x0199 }
            r5 = 1
            int r0 = r0 - r5
            r5 = r0
        L_0x010e:
            if (r5 < 0) goto L_0x0157
            java.util.ArrayList<com.google.android.exoplayer2.util.RunnableFutureTask<?, ?>> r0 = r4.activeRunnables     // Catch:{ all -> 0x0199 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0199 }
            r6 = r0
            com.google.android.exoplayer2.offline.SegmentDownloader$SegmentDownloadRunnable r6 = (com.google.android.exoplayer2.offline.SegmentDownloader.SegmentDownloadRunnable) r6     // Catch:{ all -> 0x0199 }
            boolean r0 = r2.isEmpty()     // Catch:{ all -> 0x0199 }
            if (r0 != 0) goto L_0x0125
            boolean r0 = r6.isDone()     // Catch:{ all -> 0x0199 }
            if (r0 == 0) goto L_0x0151
        L_0x0125:
            r6.get()     // Catch:{ ExecutionException -> 0x012f }
            r4.removeActiveRunnable((int) r5)     // Catch:{ ExecutionException -> 0x012f }
            r3.addLast(r6)     // Catch:{ ExecutionException -> 0x012f }
            goto L_0x0151
        L_0x012f:
            r0 = move-exception
            java.lang.Throwable r0 = r0.getCause()     // Catch:{ all -> 0x0199 }
            java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r0)     // Catch:{ all -> 0x0199 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0199 }
            boolean r8 = r0 instanceof com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException     // Catch:{ all -> 0x0199 }
            if (r8 == 0) goto L_0x014a
            com.google.android.exoplayer2.offline.SegmentDownloader$Segment r0 = r6.segment     // Catch:{ all -> 0x0199 }
            r2.addFirst(r0)     // Catch:{ all -> 0x0199 }
            r4.removeActiveRunnable((int) r5)     // Catch:{ all -> 0x0199 }
            r3.addLast(r6)     // Catch:{ all -> 0x0199 }
            goto L_0x0151
        L_0x014a:
            boolean r6 = r0 instanceof java.io.IOException     // Catch:{ all -> 0x0199 }
            if (r6 != 0) goto L_0x0154
            com.google.android.exoplayer2.util.Util.sneakyThrow(r0)     // Catch:{ all -> 0x0199 }
        L_0x0151:
            int r5 = r5 + -1
            goto L_0x010e
        L_0x0154:
            java.io.IOException r0 = (java.io.IOException) r0     // Catch:{ all -> 0x0199 }
            throw r0     // Catch:{ all -> 0x0199 }
        L_0x0157:
            r7.blockUntilStarted()     // Catch:{ all -> 0x0199 }
            goto L_0x00c4
        L_0x015c:
            r5 = 0
        L_0x015d:
            java.util.ArrayList<com.google.android.exoplayer2.util.RunnableFutureTask<?, ?>> r0 = r4.activeRunnables
            int r0 = r0.size()
            if (r5 >= r0) goto L_0x0174
            java.util.ArrayList<com.google.android.exoplayer2.util.RunnableFutureTask<?, ?>> r0 = r4.activeRunnables
            java.lang.Object r0 = r0.get(r5)
            com.google.android.exoplayer2.util.RunnableFutureTask r0 = (com.google.android.exoplayer2.util.RunnableFutureTask) r0
            r1 = 1
            r0.cancel(r1)
            int r5 = r5 + 1
            goto L_0x015d
        L_0x0174:
            r1 = 1
            java.util.ArrayList<com.google.android.exoplayer2.util.RunnableFutureTask<?, ?>> r0 = r4.activeRunnables
            int r0 = r0.size()
            int r0 = r0 - r1
        L_0x017c:
            if (r0 < 0) goto L_0x018f
            java.util.ArrayList<com.google.android.exoplayer2.util.RunnableFutureTask<?, ?>> r1 = r4.activeRunnables
            java.lang.Object r1 = r1.get(r0)
            com.google.android.exoplayer2.util.RunnableFutureTask r1 = (com.google.android.exoplayer2.util.RunnableFutureTask) r1
            r1.blockUntilFinished()
            r4.removeActiveRunnable((int) r0)
            int r0 = r0 + -1
            goto L_0x017c
        L_0x018f:
            com.google.android.exoplayer2.util.PriorityTaskManager r0 = r4.priorityTaskManager
            if (r0 == 0) goto L_0x0198
            r1 = -1000(0xfffffffffffffc18, float:NaN)
            r0.remove(r1)
        L_0x0198:
            return
        L_0x0199:
            r0 = move-exception
            goto L_0x019d
        L_0x019b:
            r0 = move-exception
            r4 = r1
        L_0x019d:
            r5 = 0
        L_0x019e:
            java.util.ArrayList<com.google.android.exoplayer2.util.RunnableFutureTask<?, ?>> r1 = r4.activeRunnables
            int r1 = r1.size()
            if (r5 >= r1) goto L_0x01b5
            java.util.ArrayList<com.google.android.exoplayer2.util.RunnableFutureTask<?, ?>> r1 = r4.activeRunnables
            java.lang.Object r1 = r1.get(r5)
            com.google.android.exoplayer2.util.RunnableFutureTask r1 = (com.google.android.exoplayer2.util.RunnableFutureTask) r1
            r2 = 1
            r1.cancel(r2)
            int r5 = r5 + 1
            goto L_0x019e
        L_0x01b5:
            r2 = 1
            java.util.ArrayList<com.google.android.exoplayer2.util.RunnableFutureTask<?, ?>> r1 = r4.activeRunnables
            int r1 = r1.size()
            int r1 = r1 - r2
        L_0x01bd:
            if (r1 < 0) goto L_0x01d0
            java.util.ArrayList<com.google.android.exoplayer2.util.RunnableFutureTask<?, ?>> r2 = r4.activeRunnables
            java.lang.Object r2 = r2.get(r1)
            com.google.android.exoplayer2.util.RunnableFutureTask r2 = (com.google.android.exoplayer2.util.RunnableFutureTask) r2
            r2.blockUntilFinished()
            r4.removeActiveRunnable((int) r1)
            int r1 = r1 + -1
            goto L_0x01bd
        L_0x01d0:
            com.google.android.exoplayer2.util.PriorityTaskManager r1 = r4.priorityTaskManager
            if (r1 == 0) goto L_0x01d9
            r2 = -1000(0xfffffffffffffc18, float:NaN)
            r1.remove(r2)
        L_0x01d9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.SegmentDownloader.download(com.google.android.exoplayer2.offline.Downloader$ProgressListener):void");
    }

    public void cancel() {
        synchronized (this.activeRunnables) {
            this.isCanceled = true;
            for (int i = 0; i < this.activeRunnables.size(); i++) {
                this.activeRunnables.get(i).cancel(true);
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void remove() {
        /*
            r5 = this;
            com.google.android.exoplayer2.upstream.cache.CacheDataSource$Factory r0 = r5.cacheDataSourceFactory
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r0 = r0.createDataSourceForRemovingDownload()
            com.google.android.exoplayer2.upstream.DataSpec r1 = r5.manifestDataSpec     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            r2 = 1
            com.google.android.exoplayer2.offline.FilterableManifest r1 = r5.getManifest(r0, r1, r2)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            java.util.List r0 = r5.getSegments(r0, r1, r2)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            r1 = 0
        L_0x0012:
            int r2 = r0.size()     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            if (r1 >= r2) goto L_0x0030
            com.google.android.exoplayer2.upstream.cache.Cache r2 = r5.cache     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            com.google.android.exoplayer2.upstream.cache.CacheKeyFactory r3 = r5.cacheKeyFactory     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            java.lang.Object r4 = r0.get(r1)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            com.google.android.exoplayer2.offline.SegmentDownloader$Segment r4 = (com.google.android.exoplayer2.offline.SegmentDownloader.Segment) r4     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            com.google.android.exoplayer2.upstream.DataSpec r4 = r4.dataSpec     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            java.lang.String r3 = r3.buildCacheKey(r4)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            r2.removeResource(r3)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            int r1 = r1 + 1
            goto L_0x0012
        L_0x002e:
            r0 = move-exception
            goto L_0x0047
        L_0x0030:
            com.google.android.exoplayer2.upstream.cache.Cache r0 = r5.cache
            com.google.android.exoplayer2.upstream.cache.CacheKeyFactory r1 = r5.cacheKeyFactory
            com.google.android.exoplayer2.upstream.DataSpec r2 = r5.manifestDataSpec
            java.lang.String r1 = r1.buildCacheKey(r2)
            r0.removeResource(r1)
            goto L_0x0046
        L_0x003e:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002e }
            r0.interrupt()     // Catch:{ all -> 0x002e }
            goto L_0x0030
        L_0x0046:
            return
        L_0x0047:
            com.google.android.exoplayer2.upstream.cache.Cache r1 = r5.cache
            com.google.android.exoplayer2.upstream.cache.CacheKeyFactory r2 = r5.cacheKeyFactory
            com.google.android.exoplayer2.upstream.DataSpec r3 = r5.manifestDataSpec
            java.lang.String r2 = r2.buildCacheKey(r3)
            r1.removeResource(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.SegmentDownloader.remove():void");
    }

    /* access modifiers changed from: protected */
    public final M getManifest(final DataSource dataSource, final DataSpec dataSpec, boolean z) throws InterruptedException, IOException {
        return (FilterableManifest) execute(new RunnableFutureTask<M, IOException>() {
            /* access modifiers changed from: protected */
            public M doWork() throws IOException {
                return (FilterableManifest) ParsingLoadable.load(dataSource, SegmentDownloader.this.manifestParser, dataSpec, 4);
            }
        }, z);
    }

    /* access modifiers changed from: protected */
    public final <T> T execute(RunnableFutureTask<T, ?> runnableFutureTask, boolean z) throws InterruptedException, IOException {
        if (z) {
            runnableFutureTask.run();
            try {
                return runnableFutureTask.get();
            } catch (ExecutionException e) {
                Throwable th = (Throwable) Assertions.checkNotNull(e.getCause());
                if (!(th instanceof IOException)) {
                    Util.sneakyThrow(e);
                } else {
                    throw ((IOException) th);
                }
            }
        }
        while (!this.isCanceled) {
            PriorityTaskManager priorityTaskManager2 = this.priorityTaskManager;
            if (priorityTaskManager2 != null) {
                priorityTaskManager2.proceed(-1000);
            }
            addActiveRunnable(runnableFutureTask);
            this.executor.execute(runnableFutureTask);
            try {
                return runnableFutureTask.get();
            } catch (ExecutionException e2) {
                Throwable th2 = (Throwable) Assertions.checkNotNull(e2.getCause());
                if (!(th2 instanceof PriorityTaskManager.PriorityTooLowException)) {
                    if (!(th2 instanceof IOException)) {
                        Util.sneakyThrow(e2);
                    } else {
                        throw ((IOException) th2);
                    }
                }
            } finally {
                runnableFutureTask.blockUntilFinished();
                removeActiveRunnable((RunnableFutureTask<?, ?>) runnableFutureTask);
            }
        }
        throw new InterruptedException();
    }

    protected static DataSpec getCompressibleDataSpec(Uri uri) {
        return new DataSpec.Builder().setUri(uri).setFlags(1).build();
    }

    private <T> void addActiveRunnable(RunnableFutureTask<T, ?> runnableFutureTask) throws InterruptedException {
        synchronized (this.activeRunnables) {
            if (!this.isCanceled) {
                this.activeRunnables.add(runnableFutureTask);
            } else {
                throw new InterruptedException();
            }
        }
    }

    private void removeActiveRunnable(RunnableFutureTask<?, ?> runnableFutureTask) {
        synchronized (this.activeRunnables) {
            this.activeRunnables.remove(runnableFutureTask);
        }
    }

    private void removeActiveRunnable(int i) {
        synchronized (this.activeRunnables) {
            this.activeRunnables.remove(i);
        }
    }

    private static void mergeSegments(List<Segment> list, CacheKeyFactory cacheKeyFactory2) {
        Segment segment;
        HashMap hashMap = new HashMap();
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Segment segment2 = list.get(i2);
            String buildCacheKey = cacheKeyFactory2.buildCacheKey(segment2.dataSpec);
            Integer num = (Integer) hashMap.get(buildCacheKey);
            if (num == null) {
                segment = null;
            } else {
                segment = list.get(num.intValue());
            }
            if (segment == null || segment2.startTimeUs > segment.startTimeUs + MAX_MERGED_SEGMENT_START_TIME_DIFF_US || !canMergeSegments(segment.dataSpec, segment2.dataSpec)) {
                hashMap.put(buildCacheKey, Integer.valueOf(i));
                list.set(i, segment2);
                i++;
            } else {
                long j = -1;
                if (segment2.dataSpec.length != -1) {
                    j = segment.dataSpec.length + segment2.dataSpec.length;
                }
                list.set(((Integer) Assertions.checkNotNull(num)).intValue(), new Segment(segment.startTimeUs, segment.dataSpec.subrange(0, j)));
            }
        }
        Util.removeRange(list, i, list.size());
    }

    private static boolean canMergeSegments(DataSpec dataSpec, DataSpec dataSpec2) {
        return dataSpec.uri.equals(dataSpec2.uri) && dataSpec.length != -1 && dataSpec.position + dataSpec.length == dataSpec2.position && Util.areEqual(dataSpec.key, dataSpec2.key) && dataSpec.flags == dataSpec2.flags && dataSpec.httpMethod == dataSpec2.httpMethod && dataSpec.httpRequestHeaders.equals(dataSpec2.httpRequestHeaders);
    }

    private static final class SegmentDownloadRunnable extends RunnableFutureTask<Void, IOException> {
        private final CacheWriter cacheWriter;
        public final CacheDataSource dataSource;
        private final ProgressNotifier progressNotifier;
        public final Segment segment;
        public final byte[] temporaryBuffer;

        public SegmentDownloadRunnable(Segment segment2, CacheDataSource cacheDataSource, ProgressNotifier progressNotifier2, byte[] bArr) {
            this.segment = segment2;
            this.dataSource = cacheDataSource;
            this.progressNotifier = progressNotifier2;
            this.temporaryBuffer = bArr;
            this.cacheWriter = new CacheWriter(cacheDataSource, segment2.dataSpec, bArr, progressNotifier2);
        }

        /* access modifiers changed from: protected */
        public Void doWork() throws IOException {
            this.cacheWriter.cache();
            ProgressNotifier progressNotifier2 = this.progressNotifier;
            if (progressNotifier2 == null) {
                return null;
            }
            progressNotifier2.onSegmentDownloaded();
            return null;
        }

        /* access modifiers changed from: protected */
        public void cancelWork() {
            this.cacheWriter.cancel();
        }
    }

    private static final class ProgressNotifier implements CacheWriter.ProgressListener {
        private long bytesDownloaded;
        private final long contentLength;
        private final Downloader.ProgressListener progressListener;
        private int segmentsDownloaded;
        private final int totalSegments;

        public ProgressNotifier(Downloader.ProgressListener progressListener2, long j, int i, long j2, int i2) {
            this.progressListener = progressListener2;
            this.contentLength = j;
            this.totalSegments = i;
            this.bytesDownloaded = j2;
            this.segmentsDownloaded = i2;
        }

        public void onProgress(long j, long j2, long j3) {
            long j4 = this.bytesDownloaded + j3;
            this.bytesDownloaded = j4;
            this.progressListener.onProgress(this.contentLength, j4, getPercentDownloaded());
        }

        public void onSegmentDownloaded() {
            this.segmentsDownloaded++;
            this.progressListener.onProgress(this.contentLength, this.bytesDownloaded, getPercentDownloaded());
        }

        private float getPercentDownloaded() {
            long j = this.contentLength;
            if (j != -1 && j != 0) {
                return (((float) this.bytesDownloaded) * 100.0f) / ((float) j);
            }
            int i = this.totalSegments;
            if (i != 0) {
                return (((float) this.segmentsDownloaded) * 100.0f) / ((float) i);
            }
            return -1.0f;
        }
    }
}
