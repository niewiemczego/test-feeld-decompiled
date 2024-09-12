package androidx.room;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"androidx/room/InvalidationTracker$refreshRunnable$1", "Ljava/lang/Runnable;", "checkUpdatedTable", "", "", "run", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InvalidationTracker.kt */
public final class InvalidationTracker$refreshRunnable$1 implements Runnable {
    final /* synthetic */ InvalidationTracker this$0;

    InvalidationTracker$refreshRunnable$1(InvalidationTracker invalidationTracker) {
        this.this$0 = invalidationTracker;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0080, code lost:
        if (r0 != null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0082, code lost:
        r0.decrementCountAndScheduleClose();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a4, code lost:
        if (r0 == null) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00be, code lost:
        if (r0 == null) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c9, code lost:
        if ((!r3.isEmpty()) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cb, code lost:
        r0 = r5.this$0.getObserverMap$room_runtime_release();
        r1 = r5.this$0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d3, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r1 = r1.getObserverMap$room_runtime_release().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e2, code lost:
        if (r1.hasNext() == false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e4, code lost:
        ((androidx.room.InvalidationTracker.ObserverWrapper) ((java.util.Map.Entry) r1.next()).getValue()).notifyByTableInvalidStatus$room_runtime_release(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f4, code lost:
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f6, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
            androidx.room.InvalidationTracker r0 = r5.this$0
            androidx.room.RoomDatabase r0 = r0.getDatabase$room_runtime_release()
            java.util.concurrent.locks.Lock r0 = r0.getCloseLock$room_runtime_release()
            r0.lock()
            r1 = 1
            androidx.room.InvalidationTracker r2 = r5.this$0     // Catch:{ IllegalStateException -> 0x00a7, SQLiteException -> 0x008d }
            boolean r2 = r2.ensureInitialization$room_runtime_release()     // Catch:{ IllegalStateException -> 0x00a7, SQLiteException -> 0x008d }
            if (r2 != 0) goto L_0x0025
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r5.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x0024
            r0.decrementCountAndScheduleClose()
        L_0x0024:
            return
        L_0x0025:
            androidx.room.InvalidationTracker r2 = r5.this$0     // Catch:{ IllegalStateException -> 0x00a7, SQLiteException -> 0x008d }
            java.util.concurrent.atomic.AtomicBoolean r2 = r2.getPendingRefresh()     // Catch:{ IllegalStateException -> 0x00a7, SQLiteException -> 0x008d }
            r3 = 0
            boolean r2 = r2.compareAndSet(r1, r3)     // Catch:{ IllegalStateException -> 0x00a7, SQLiteException -> 0x008d }
            if (r2 != 0) goto L_0x0041
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r5.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x0040
            r0.decrementCountAndScheduleClose()
        L_0x0040:
            return
        L_0x0041:
            androidx.room.InvalidationTracker r2 = r5.this$0     // Catch:{ IllegalStateException -> 0x00a7, SQLiteException -> 0x008d }
            androidx.room.RoomDatabase r2 = r2.getDatabase$room_runtime_release()     // Catch:{ IllegalStateException -> 0x00a7, SQLiteException -> 0x008d }
            boolean r2 = r2.inTransaction()     // Catch:{ IllegalStateException -> 0x00a7, SQLiteException -> 0x008d }
            if (r2 == 0) goto L_0x005c
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r5.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x005b
            r0.decrementCountAndScheduleClose()
        L_0x005b:
            return
        L_0x005c:
            androidx.room.InvalidationTracker r2 = r5.this$0     // Catch:{ IllegalStateException -> 0x00a7, SQLiteException -> 0x008d }
            androidx.room.RoomDatabase r2 = r2.getDatabase$room_runtime_release()     // Catch:{ IllegalStateException -> 0x00a7, SQLiteException -> 0x008d }
            androidx.sqlite.db.SupportSQLiteOpenHelper r2 = r2.getOpenHelper()     // Catch:{ IllegalStateException -> 0x00a7, SQLiteException -> 0x008d }
            androidx.sqlite.db.SupportSQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ IllegalStateException -> 0x00a7, SQLiteException -> 0x008d }
            r2.beginTransactionNonExclusive()     // Catch:{ IllegalStateException -> 0x00a7, SQLiteException -> 0x008d }
            java.util.Set r3 = r5.checkUpdatedTable()     // Catch:{ all -> 0x0086 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x0086 }
            r2.endTransaction()     // Catch:{ IllegalStateException -> 0x00a7, SQLiteException -> 0x008d }
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r5.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x00c1
        L_0x0082:
            r0.decrementCountAndScheduleClose()
            goto L_0x00c1
        L_0x0086:
            r3 = move-exception
            r2.endTransaction()     // Catch:{ IllegalStateException -> 0x00a7, SQLiteException -> 0x008d }
            throw r3     // Catch:{ IllegalStateException -> 0x00a7, SQLiteException -> 0x008d }
        L_0x008b:
            r1 = move-exception
            goto L_0x00fc
        L_0x008d:
            r2 = move-exception
            java.lang.String r3 = "ROOM"
            java.lang.String r4 = "Cannot run invalidation tracker. Is the db closed?"
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x008b }
            android.util.Log.e(r3, r4, r2)     // Catch:{ all -> 0x008b }
            java.util.Set r3 = kotlin.collections.SetsKt.emptySet()     // Catch:{ all -> 0x008b }
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r5.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x00c1
            goto L_0x0082
        L_0x00a7:
            r2 = move-exception
            java.lang.String r3 = "ROOM"
            java.lang.String r4 = "Cannot run invalidation tracker. Is the db closed?"
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x008b }
            android.util.Log.e(r3, r4, r2)     // Catch:{ all -> 0x008b }
            java.util.Set r3 = kotlin.collections.SetsKt.emptySet()     // Catch:{ all -> 0x008b }
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r5.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x00c1
            goto L_0x0082
        L_0x00c1:
            r0 = r3
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x00fb
            androidx.room.InvalidationTracker r0 = r5.this$0
            androidx.arch.core.internal.SafeIterableMap r0 = r0.getObserverMap$room_runtime_release()
            androidx.room.InvalidationTracker r1 = r5.this$0
            monitor-enter(r0)
            androidx.arch.core.internal.SafeIterableMap r1 = r1.getObserverMap$room_runtime_release()     // Catch:{ all -> 0x00f8 }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ all -> 0x00f8 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00f8 }
        L_0x00de:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00f8 }
            if (r2 == 0) goto L_0x00f4
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00f8 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00f8 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00f8 }
            androidx.room.InvalidationTracker$ObserverWrapper r2 = (androidx.room.InvalidationTracker.ObserverWrapper) r2     // Catch:{ all -> 0x00f8 }
            r2.notifyByTableInvalidStatus$room_runtime_release(r3)     // Catch:{ all -> 0x00f8 }
            goto L_0x00de
        L_0x00f4:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f8 }
            monitor-exit(r0)
            goto L_0x00fb
        L_0x00f8:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x00fb:
            return
        L_0x00fc:
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r5.this$0
            androidx.room.AutoCloser r0 = r0.autoCloser
            if (r0 == 0) goto L_0x010a
            r0.decrementCountAndScheduleClose()
        L_0x010a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker$refreshRunnable$1.run():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.Set<java.lang.Integer> checkUpdatedTable() {
        /*
            r6 = this;
            androidx.room.InvalidationTracker r0 = r6.this$0
            java.util.Set r1 = kotlin.collections.SetsKt.createSetBuilder()
            androidx.room.RoomDatabase r0 = r0.getDatabase$room_runtime_release()
            androidx.sqlite.db.SimpleSQLiteQuery r2 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.String r3 = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;"
            r2.<init>(r3)
            androidx.sqlite.db.SupportSQLiteQuery r2 = (androidx.sqlite.db.SupportSQLiteQuery) r2
            r3 = 0
            r4 = 2
            android.database.Cursor r0 = androidx.room.RoomDatabase.query$default(r0, r2, r3, r4, r3)
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 0
            r5 = 15
            if (r2 <= r5) goto L_0x0044
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2 = r0
            android.database.Cursor r2 = (android.database.Cursor) r2     // Catch:{ all -> 0x003d }
        L_0x0025:
            boolean r5 = r2.moveToNext()     // Catch:{ all -> 0x003d }
            if (r5 == 0) goto L_0x0037
            int r5 = r2.getInt(r4)     // Catch:{ all -> 0x003d }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x003d }
            r1.add(r5)     // Catch:{ all -> 0x003d }
            goto L_0x0025
        L_0x0037:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003d }
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            goto L_0x005b
        L_0x003d:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x003f }
        L_0x003f:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        L_0x0044:
            boolean r2 = r0.moveToNext()     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x0056
            int r2 = r0.getInt(r4)     // Catch:{ all -> 0x0095 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0095 }
            r1.add(r2)     // Catch:{ all -> 0x0095 }
            goto L_0x0044
        L_0x0056:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0095 }
            r0.close()
        L_0x005b:
            java.util.Set r0 = kotlin.collections.SetsKt.build(r1)
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x0094
            androidx.room.InvalidationTracker r1 = r6.this$0
            androidx.sqlite.db.SupportSQLiteStatement r1 = r1.getCleanupStatement$room_runtime_release()
            java.lang.String r2 = "Required value was null."
            if (r1 == 0) goto L_0x008a
            androidx.room.InvalidationTracker r1 = r6.this$0
            androidx.sqlite.db.SupportSQLiteStatement r1 = r1.getCleanupStatement$room_runtime_release()
            if (r1 == 0) goto L_0x0080
            r1.executeUpdateDelete()
            goto L_0x0094
        L_0x0080:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x008a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0094:
            return r0
        L_0x0095:
            r1 = move-exception
            r0.close()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker$refreshRunnable$1.checkUpdatedTable():java.util.Set");
    }
}
