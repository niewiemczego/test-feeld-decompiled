package androidx.room;

import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\b\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020,H\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0011\u0010)\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0014¨\u0006."}, d2 = {"Landroidx/room/RoomTrackingLiveData;", "T", "Landroidx/lifecycle/LiveData;", "database", "Landroidx/room/RoomDatabase;", "container", "Landroidx/room/InvalidationLiveDataContainer;", "inTransaction", "", "computeFunction", "Ljava/util/concurrent/Callable;", "tableNames", "", "", "(Landroidx/room/RoomDatabase;Landroidx/room/InvalidationLiveDataContainer;ZLjava/util/concurrent/Callable;[Ljava/lang/String;)V", "getComputeFunction", "()Ljava/util/concurrent/Callable;", "computing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getComputing", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "getDatabase", "()Landroidx/room/RoomDatabase;", "getInTransaction", "()Z", "invalid", "getInvalid", "invalidationRunnable", "Ljava/lang/Runnable;", "getInvalidationRunnable", "()Ljava/lang/Runnable;", "observer", "Landroidx/room/InvalidationTracker$Observer;", "getObserver", "()Landroidx/room/InvalidationTracker$Observer;", "queryExecutor", "Ljava/util/concurrent/Executor;", "getQueryExecutor", "()Ljava/util/concurrent/Executor;", "refreshRunnable", "getRefreshRunnable", "registeredObserver", "getRegisteredObserver", "onActive", "", "onInactive", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RoomTrackingLiveData.kt */
public final class RoomTrackingLiveData<T> extends LiveData<T> {
    private final Callable<T> computeFunction;
    private final AtomicBoolean computing = new AtomicBoolean(false);
    private final InvalidationLiveDataContainer container;
    private final RoomDatabase database;
    private final boolean inTransaction;
    private final AtomicBoolean invalid = new AtomicBoolean(true);
    private final Runnable invalidationRunnable = new RoomTrackingLiveData$$ExternalSyntheticLambda1(this);
    private final InvalidationTracker.Observer observer;
    private final Runnable refreshRunnable = new RoomTrackingLiveData$$ExternalSyntheticLambda0(this);
    private final AtomicBoolean registeredObserver = new AtomicBoolean(false);

    public final RoomDatabase getDatabase() {
        return this.database;
    }

    public final boolean getInTransaction() {
        return this.inTransaction;
    }

    public final Callable<T> getComputeFunction() {
        return this.computeFunction;
    }

    public RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z, Callable<T> callable, String[] strArr) {
        Intrinsics.checkNotNullParameter(roomDatabase, "database");
        Intrinsics.checkNotNullParameter(invalidationLiveDataContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(callable, "computeFunction");
        Intrinsics.checkNotNullParameter(strArr, "tableNames");
        this.database = roomDatabase;
        this.container = invalidationLiveDataContainer;
        this.inTransaction = z;
        this.computeFunction = callable;
        this.observer = new RoomTrackingLiveData$observer$1(strArr, this);
    }

    public final InvalidationTracker.Observer getObserver() {
        return this.observer;
    }

    public final AtomicBoolean getInvalid() {
        return this.invalid;
    }

    public final AtomicBoolean getComputing() {
        return this.computing;
    }

    public final AtomicBoolean getRegisteredObserver() {
        return this.registeredObserver;
    }

    public final Runnable getRefreshRunnable() {
        return this.refreshRunnable;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void refreshRunnable$lambda$0(androidx.room.RoomTrackingLiveData r5) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.registeredObserver
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x001a
            androidx.room.RoomDatabase r0 = r5.database
            androidx.room.InvalidationTracker r0 = r0.getInvalidationTracker()
            androidx.room.InvalidationTracker$Observer r3 = r5.observer
            r0.addWeakObserver(r3)
        L_0x001a:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.computing
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x0051
            r0 = 0
            r3 = r1
        L_0x0024:
            java.util.concurrent.atomic.AtomicBoolean r4 = r5.invalid     // Catch:{ all -> 0x004a }
            boolean r4 = r4.compareAndSet(r2, r1)     // Catch:{ all -> 0x004a }
            if (r4 == 0) goto L_0x003f
            java.util.concurrent.Callable<T> r0 = r5.computeFunction     // Catch:{ Exception -> 0x0034 }
            java.lang.Object r0 = r0.call()     // Catch:{ Exception -> 0x0034 }
            r3 = r2
            goto L_0x0024
        L_0x0034:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x004a }
            java.lang.String r3 = "Exception while computing database live data."
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x004a }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x004a }
            throw r2     // Catch:{ all -> 0x004a }
        L_0x003f:
            if (r3 == 0) goto L_0x0044
            r5.postValue(r0)     // Catch:{ all -> 0x004a }
        L_0x0044:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.computing
            r0.set(r1)
            goto L_0x0052
        L_0x004a:
            r0 = move-exception
            java.util.concurrent.atomic.AtomicBoolean r5 = r5.computing
            r5.set(r1)
            throw r0
        L_0x0051:
            r3 = r1
        L_0x0052:
            if (r3 == 0) goto L_0x005c
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.invalid
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x001a
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomTrackingLiveData.refreshRunnable$lambda$0(androidx.room.RoomTrackingLiveData):void");
    }

    public final Runnable getInvalidationRunnable() {
        return this.invalidationRunnable;
    }

    /* access modifiers changed from: private */
    public static final void invalidationRunnable$lambda$1(RoomTrackingLiveData roomTrackingLiveData) {
        Intrinsics.checkNotNullParameter(roomTrackingLiveData, "this$0");
        boolean hasActiveObservers = roomTrackingLiveData.hasActiveObservers();
        if (roomTrackingLiveData.invalid.compareAndSet(false, true) && hasActiveObservers) {
            roomTrackingLiveData.getQueryExecutor().execute(roomTrackingLiveData.refreshRunnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onActive() {
        super.onActive();
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.container;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        invalidationLiveDataContainer.onActive(this);
        getQueryExecutor().execute(this.refreshRunnable);
    }

    /* access modifiers changed from: protected */
    public void onInactive() {
        super.onInactive();
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.container;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        invalidationLiveDataContainer.onInactive(this);
    }

    public final Executor getQueryExecutor() {
        if (this.inTransaction) {
            return this.database.getTransactionExecutor();
        }
        return this.database.getQueryExecutor();
    }
}
