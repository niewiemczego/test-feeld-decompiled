package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

public class IncreasingQualityDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    /* access modifiers changed from: private */
    public final boolean mDataSourceLazy;
    /* access modifiers changed from: private */
    public final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

    private IncreasingQualityDataSourceSupplier(List<Supplier<DataSource<T>>> list, boolean z) {
        Preconditions.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mDataSourceSuppliers = list;
        this.mDataSourceLazy = z;
    }

    public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> list) {
        return create(list, false);
    }

    public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> list, boolean z) {
        return new IncreasingQualityDataSourceSupplier<>(list, z);
    }

    public DataSource<T> get() {
        return new IncreasingQualityDataSource();
    }

    public int hashCode() {
        return this.mDataSourceSuppliers.hashCode();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IncreasingQualityDataSourceSupplier)) {
            return false;
        }
        return Objects.equal(this.mDataSourceSuppliers, ((IncreasingQualityDataSourceSupplier) obj).mDataSourceSuppliers);
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("list", (Object) this.mDataSourceSuppliers).toString();
    }

    private class IncreasingQualityDataSource extends AbstractDataSource<T> {
        @Nullable
        private ArrayList<DataSource<T>> mDataSources;
        @Nullable
        private Throwable mDelayedError;
        @Nullable
        private Map<String, Object> mDelayedExtras;
        private AtomicInteger mFinishedDataSources;
        private int mIndexOfDataSourceWithResult;
        private int mNumberOfDataSources;

        public IncreasingQualityDataSource() {
            if (!IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
        }

        private void ensureDataSourceInitialized() {
            if (this.mFinishedDataSources == null) {
                synchronized (this) {
                    if (this.mFinishedDataSources == null) {
                        int i = 0;
                        this.mFinishedDataSources = new AtomicInteger(0);
                        int size = IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.size();
                        this.mNumberOfDataSources = size;
                        this.mIndexOfDataSourceWithResult = size;
                        this.mDataSources = new ArrayList<>(size);
                        while (true) {
                            if (i >= size) {
                                break;
                            }
                            DataSource dataSource = (DataSource) ((Supplier) IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.get(i)).get();
                            this.mDataSources.add(dataSource);
                            dataSource.subscribe(new InternalDataSubscriber(i), CallerThreadExecutor.getInstance());
                            if (dataSource.hasResult()) {
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized DataSource<T> getDataSource(int i) {
            ArrayList<DataSource<T>> arrayList;
            arrayList = this.mDataSources;
            return (arrayList == null || i >= arrayList.size()) ? null : this.mDataSources.get(i);
        }

        @Nullable
        private synchronized DataSource<T> getAndClearDataSource(int i) {
            DataSource<T> dataSource;
            ArrayList<DataSource<T>> arrayList = this.mDataSources;
            dataSource = null;
            if (arrayList != null && i < arrayList.size()) {
                dataSource = this.mDataSources.set(i, (Object) null);
            }
            return dataSource;
        }

        @Nullable
        private synchronized DataSource<T> getDataSourceWithResult() {
            return getDataSource(this.mIndexOfDataSourceWithResult);
        }

        @Nullable
        public synchronized T getResult() {
            DataSource dataSourceWithResult;
            if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
            dataSourceWithResult = getDataSourceWithResult();
            return dataSourceWithResult != null ? dataSourceWithResult.getResult() : null;
        }

        public synchronized boolean hasResult() {
            DataSource dataSourceWithResult;
            if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
            dataSourceWithResult = getDataSourceWithResult();
            return dataSourceWithResult != null && dataSourceWithResult.hasResult();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            if (r1 >= r0.size()) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            closeSafely(r0.get(r1));
            r1 = r1 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean close() {
            /*
                r3 = this;
                com.facebook.datasource.IncreasingQualityDataSourceSupplier r0 = com.facebook.datasource.IncreasingQualityDataSourceSupplier.this
                boolean r0 = r0.mDataSourceLazy
                if (r0 == 0) goto L_0x000b
                r3.ensureDataSourceInitialized()
            L_0x000b:
                monitor-enter(r3)
                boolean r0 = super.close()     // Catch:{ all -> 0x0031 }
                r1 = 0
                if (r0 != 0) goto L_0x0015
                monitor-exit(r3)     // Catch:{ all -> 0x0031 }
                return r1
            L_0x0015:
                java.util.ArrayList<com.facebook.datasource.DataSource<T>> r0 = r3.mDataSources     // Catch:{ all -> 0x0031 }
                r2 = 0
                r3.mDataSources = r2     // Catch:{ all -> 0x0031 }
                monitor-exit(r3)     // Catch:{ all -> 0x0031 }
                if (r0 == 0) goto L_0x002f
            L_0x001d:
                int r2 = r0.size()
                if (r1 >= r2) goto L_0x002f
                java.lang.Object r2 = r0.get(r1)
                com.facebook.datasource.DataSource r2 = (com.facebook.datasource.DataSource) r2
                r3.closeSafely(r2)
                int r1 = r1 + 1
                goto L_0x001d
            L_0x002f:
                r0 = 1
                return r0
            L_0x0031:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0031 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.close():boolean");
        }

        /* access modifiers changed from: private */
        public void onDataSourceNewResult(int i, DataSource<T> dataSource) {
            maybeSetIndexOfDataSourceWithResult(i, dataSource, dataSource.isFinished());
            if (dataSource == getDataSourceWithResult()) {
                setResult(null, i == 0 && dataSource.isFinished(), dataSource.getExtras());
            }
            maybeSetFailure();
        }

        /* access modifiers changed from: private */
        public void onDataSourceFailed(int i, DataSource<T> dataSource) {
            closeSafely(tryGetAndClearDataSource(i, dataSource));
            if (i == 0) {
                this.mDelayedError = dataSource.getFailureCause();
                this.mDelayedExtras = dataSource.getExtras();
            }
            maybeSetFailure();
        }

        private void maybeSetFailure() {
            Throwable th;
            if (this.mFinishedDataSources.incrementAndGet() == this.mNumberOfDataSources && (th = this.mDelayedError) != null) {
                setFailure(th, this.mDelayedExtras);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
            if (r0 <= r3) goto L_0x002c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0022, code lost:
            closeSafely(getAndClearDataSource(r0));
            r0 = r0 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void maybeSetIndexOfDataSourceWithResult(int r3, com.facebook.datasource.DataSource<T> r4, boolean r5) {
            /*
                r2 = this;
                monitor-enter(r2)
                int r0 = r2.mIndexOfDataSourceWithResult     // Catch:{ all -> 0x002f }
                com.facebook.datasource.DataSource r1 = r2.getDataSource(r3)     // Catch:{ all -> 0x002f }
                if (r4 != r1) goto L_0x002d
                int r4 = r2.mIndexOfDataSourceWithResult     // Catch:{ all -> 0x002f }
                if (r3 != r4) goto L_0x000e
                goto L_0x002d
            L_0x000e:
                com.facebook.datasource.DataSource r4 = r2.getDataSourceWithResult()     // Catch:{ all -> 0x002f }
                if (r4 == 0) goto L_0x001d
                if (r5 == 0) goto L_0x001b
                int r4 = r2.mIndexOfDataSourceWithResult     // Catch:{ all -> 0x002f }
                if (r3 >= r4) goto L_0x001b
                goto L_0x001d
            L_0x001b:
                r3 = r0
                goto L_0x001f
            L_0x001d:
                r2.mIndexOfDataSourceWithResult = r3     // Catch:{ all -> 0x002f }
            L_0x001f:
                monitor-exit(r2)     // Catch:{ all -> 0x002f }
            L_0x0020:
                if (r0 <= r3) goto L_0x002c
                com.facebook.datasource.DataSource r4 = r2.getAndClearDataSource(r0)
                r2.closeSafely(r4)
                int r0 = r0 + -1
                goto L_0x0020
            L_0x002c:
                return
            L_0x002d:
                monitor-exit(r2)     // Catch:{ all -> 0x002f }
                return
            L_0x002f:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x002f }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.maybeSetIndexOfDataSourceWithResult(int, com.facebook.datasource.DataSource, boolean):void");
        }

        @Nullable
        private synchronized DataSource<T> tryGetAndClearDataSource(int i, DataSource<T> dataSource) {
            if (dataSource == getDataSourceWithResult()) {
                return null;
            }
            if (dataSource != getDataSource(i)) {
                return dataSource;
            }
            return getAndClearDataSource(i);
        }

        private void closeSafely(DataSource<T> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
        }

        private class InternalDataSubscriber implements DataSubscriber<T> {
            private int mIndex;

            public void onCancellation(DataSource<T> dataSource) {
            }

            public InternalDataSubscriber(int i) {
                this.mIndex = i;
            }

            public void onNewResult(DataSource<T> dataSource) {
                if (dataSource.hasResult()) {
                    IncreasingQualityDataSource.this.onDataSourceNewResult(this.mIndex, dataSource);
                } else if (dataSource.isFinished()) {
                    IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, dataSource);
                }
            }

            public void onFailure(DataSource<T> dataSource) {
                IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, dataSource);
            }

            public void onProgressUpdate(DataSource<T> dataSource) {
                if (this.mIndex == 0) {
                    IncreasingQualityDataSource.this.setProgress(dataSource.getProgress());
                }
            }
        }
    }
}
