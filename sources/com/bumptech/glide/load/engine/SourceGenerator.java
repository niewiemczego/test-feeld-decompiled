package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.IOException;
import java.util.List;

class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {
    private static final String TAG = "SourceGenerator";
    private final DataFetcherGenerator.FetcherReadyCallback cb;
    private volatile Object dataToCache;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private volatile int loadDataListIndex;
    private volatile DataCacheKey originalKey;
    private volatile DataCacheGenerator sourceCacheGenerator;

    SourceGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.helper = decodeHelper;
        this.cb = fetcherReadyCallback;
    }

    public boolean startNext() {
        if (this.dataToCache != null) {
            Object obj = this.dataToCache;
            this.dataToCache = null;
            try {
                if (!cacheData(obj)) {
                    return true;
                }
            } catch (IOException e) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Failed to properly rewind or write data to cache", e);
                }
            }
        }
        if (this.sourceCacheGenerator != null && this.sourceCacheGenerator.startNext()) {
            return true;
        }
        this.sourceCacheGenerator = null;
        this.loadData = null;
        boolean z = false;
        while (!z && hasNextModelLoader()) {
            List<ModelLoader.LoadData<?>> loadData2 = this.helper.getLoadData();
            int i = this.loadDataListIndex;
            this.loadDataListIndex = i + 1;
            this.loadData = loadData2.get(i);
            if (this.loadData != null && (this.helper.getDiskCacheStrategy().isDataCacheable(this.loadData.fetcher.getDataSource()) || this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()))) {
                startNextLoad(this.loadData);
                z = true;
            }
        }
        return z;
    }

    private void startNextLoad(final ModelLoader.LoadData<?> loadData2) {
        this.loadData.fetcher.loadData(this.helper.getPriority(), new DataFetcher.DataCallback<Object>() {
            public void onDataReady(Object obj) {
                if (SourceGenerator.this.isCurrentRequest(loadData2)) {
                    SourceGenerator.this.onDataReadyInternal(loadData2, obj);
                }
            }

            public void onLoadFailed(Exception exc) {
                if (SourceGenerator.this.isCurrentRequest(loadData2)) {
                    SourceGenerator.this.onLoadFailedInternal(loadData2, exc);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean isCurrentRequest(ModelLoader.LoadData<?> loadData2) {
        ModelLoader.LoadData<?> loadData3 = this.loadData;
        return loadData3 != null && loadData3 == loadData2;
    }

    private boolean hasNextModelLoader() {
        return this.loadDataListIndex < this.helper.getLoadData().size();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean cacheData(java.lang.Object r13) throws java.io.IOException {
        /*
            r12 = this;
            java.lang.String r0 = "SourceGenerator"
            long r1 = com.bumptech.glide.util.LogTime.getLogTime()
            r3 = 1
            r4 = 0
            com.bumptech.glide.load.engine.DecodeHelper<?> r5 = r12.helper     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.data.DataRewinder r5 = r5.getRewinder(r13)     // Catch:{ all -> 0x00e9 }
            java.lang.Object r6 = r5.rewindAndGet()     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.engine.DecodeHelper<?> r7 = r12.helper     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.Encoder r7 = r7.getSourceEncoder(r6)     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.engine.DataCacheWriter r8 = new com.bumptech.glide.load.engine.DataCacheWriter     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.engine.DecodeHelper<?> r9 = r12.helper     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.Options r9 = r9.getOptions()     // Catch:{ all -> 0x00e9 }
            r8.<init>(r7, r6, r9)     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.engine.DataCacheKey r6 = new com.bumptech.glide.load.engine.DataCacheKey     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r9 = r12.loadData     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.Key r9 = r9.sourceKey     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.engine.DecodeHelper<?> r10 = r12.helper     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.Key r10 = r10.getSignature()     // Catch:{ all -> 0x00e9 }
            r6.<init>(r9, r10)     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.engine.DecodeHelper<?> r9 = r12.helper     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.engine.cache.DiskCache r9 = r9.getDiskCache()     // Catch:{ all -> 0x00e9 }
            r9.put(r6, r8)     // Catch:{ all -> 0x00e9 }
            r8 = 2
            boolean r8 = android.util.Log.isLoggable(r0, r8)     // Catch:{ all -> 0x00e9 }
            java.lang.String r10 = ", data: "
            if (r8 == 0) goto L_0x007a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e9 }
            r8.<init>()     // Catch:{ all -> 0x00e9 }
            java.lang.String r11 = "Finished encoding source to cache, key: "
            java.lang.StringBuilder r8 = r8.append(r11)     // Catch:{ all -> 0x00e9 }
            java.lang.StringBuilder r8 = r8.append(r6)     // Catch:{ all -> 0x00e9 }
            java.lang.StringBuilder r8 = r8.append(r10)     // Catch:{ all -> 0x00e9 }
            java.lang.StringBuilder r8 = r8.append(r13)     // Catch:{ all -> 0x00e9 }
            java.lang.String r11 = ", encoder: "
            java.lang.StringBuilder r8 = r8.append(r11)     // Catch:{ all -> 0x00e9 }
            java.lang.StringBuilder r7 = r8.append(r7)     // Catch:{ all -> 0x00e9 }
            java.lang.String r8 = ", duration: "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x00e9 }
            double r1 = com.bumptech.glide.util.LogTime.getElapsedMillis(r1)     // Catch:{ all -> 0x00e9 }
            java.lang.StringBuilder r1 = r7.append(r1)     // Catch:{ all -> 0x00e9 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00e9 }
            android.util.Log.v(r0, r1)     // Catch:{ all -> 0x00e9 }
        L_0x007a:
            java.io.File r1 = r9.get(r6)     // Catch:{ all -> 0x00e9 }
            if (r1 == 0) goto L_0x009b
            r12.originalKey = r6     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.engine.DataCacheGenerator r13 = new com.bumptech.glide.load.engine.DataCacheGenerator     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r12.loadData     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.Key r0 = r0.sourceKey     // Catch:{ all -> 0x00e9 }
            java.util.List r0 = java.util.Collections.singletonList(r0)     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.engine.DecodeHelper<?> r1 = r12.helper     // Catch:{ all -> 0x00e9 }
            r13.<init>(r0, r1, r12)     // Catch:{ all -> 0x00e9 }
            r12.sourceCacheGenerator = r13     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r13 = r12.loadData
            com.bumptech.glide.load.data.DataFetcher<Data> r13 = r13.fetcher
            r13.cleanup()
            return r3
        L_0x009b:
            r1 = 3
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00e9 }
            if (r1 == 0) goto L_0x00c8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e9 }
            r1.<init>()     // Catch:{ all -> 0x00e9 }
            java.lang.String r2 = "Attempt to write: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00e9 }
            com.bumptech.glide.load.engine.DataCacheKey r2 = r12.originalKey     // Catch:{ all -> 0x00e9 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00e9 }
            java.lang.StringBuilder r1 = r1.append(r10)     // Catch:{ all -> 0x00e9 }
            java.lang.StringBuilder r13 = r1.append(r13)     // Catch:{ all -> 0x00e9 }
            java.lang.String r1 = " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly..."
            java.lang.StringBuilder r13 = r13.append(r1)     // Catch:{ all -> 0x00e9 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00e9 }
            android.util.Log.d(r0, r13)     // Catch:{ all -> 0x00e9 }
        L_0x00c8:
            com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback r13 = r12.cb     // Catch:{ all -> 0x00e7 }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r12.loadData     // Catch:{ all -> 0x00e7 }
            com.bumptech.glide.load.Key r6 = r0.sourceKey     // Catch:{ all -> 0x00e7 }
            java.lang.Object r7 = r5.rewindAndGet()     // Catch:{ all -> 0x00e7 }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r12.loadData     // Catch:{ all -> 0x00e7 }
            com.bumptech.glide.load.data.DataFetcher<Data> r8 = r0.fetcher     // Catch:{ all -> 0x00e7 }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r12.loadData     // Catch:{ all -> 0x00e7 }
            com.bumptech.glide.load.data.DataFetcher<Data> r0 = r0.fetcher     // Catch:{ all -> 0x00e7 }
            com.bumptech.glide.load.DataSource r9 = r0.getDataSource()     // Catch:{ all -> 0x00e7 }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r12.loadData     // Catch:{ all -> 0x00e7 }
            com.bumptech.glide.load.Key r10 = r0.sourceKey     // Catch:{ all -> 0x00e7 }
            r5 = r13
            r5.onDataFetcherReady(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x00e7 }
            return r4
        L_0x00e7:
            r13 = move-exception
            goto L_0x00eb
        L_0x00e9:
            r13 = move-exception
            r3 = r4
        L_0x00eb:
            if (r3 != 0) goto L_0x00f4
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r12.loadData
            com.bumptech.glide.load.data.DataFetcher<Data> r0 = r0.fetcher
            r0.cleanup()
        L_0x00f4:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.SourceGenerator.cacheData(java.lang.Object):boolean");
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData2 = this.loadData;
        if (loadData2 != null) {
            loadData2.fetcher.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void onDataReadyInternal(ModelLoader.LoadData<?> loadData2, Object obj) {
        DiskCacheStrategy diskCacheStrategy = this.helper.getDiskCacheStrategy();
        if (obj == null || !diskCacheStrategy.isDataCacheable(loadData2.fetcher.getDataSource())) {
            this.cb.onDataFetcherReady(loadData2.sourceKey, obj, loadData2.fetcher, loadData2.fetcher.getDataSource(), this.originalKey);
            return;
        }
        this.dataToCache = obj;
        this.cb.reschedule();
    }

    /* access modifiers changed from: package-private */
    public void onLoadFailedInternal(ModelLoader.LoadData<?> loadData2, Exception exc) {
        this.cb.onDataFetcherFailed(this.originalKey, exc, loadData2.fetcher, loadData2.fetcher.getDataSource());
    }

    public void reschedule() {
        throw new UnsupportedOperationException();
    }

    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.cb.onDataFetcherReady(key, obj, dataFetcher, this.loadData.fetcher.getDataSource(), key);
    }

    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.cb.onDataFetcherFailed(key, exc, dataFetcher, this.loadData.fetcher.getDataSource());
    }
}
