package com.adapty.internal.data.cloud;

import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.cloud.Response;
import com.adapty.internal.data.models.AnalyticsConfig;
import com.adapty.internal.data.models.AnalyticsEvent;
import com.adapty.internal.utils.LifecycleManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.sync.Semaphore;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J?\u0010\u0018\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00160\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u001b\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ'\u0010\u001e\u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00162\u0006\u0010\u001b\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ%\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lcom/adapty/internal/data/cloud/AnalyticsEventQueueDispatcher;", "", "cacheRepository", "Lcom/adapty/internal/data/cache/CacheRepository;", "httpClient", "Lcom/adapty/internal/data/cloud/HttpClient;", "requestFactory", "Lcom/adapty/internal/data/cloud/RequestFactory;", "lifecycleManager", "Lcom/adapty/internal/utils/LifecycleManager;", "dataLocalSemaphore", "Lkotlinx/coroutines/sync/Semaphore;", "dataRemoteSemaphore", "(Lcom/adapty/internal/data/cache/CacheRepository;Lcom/adapty/internal/data/cloud/HttpClient;Lcom/adapty/internal/data/cloud/RequestFactory;Lcom/adapty/internal/utils/LifecycleManager;Lkotlinx/coroutines/sync/Semaphore;Lkotlinx/coroutines/sync/Semaphore;)V", "eventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/adapty/internal/data/models/AnalyticsEvent;", "addToQueue", "", "event", "(Lcom/adapty/internal/data/models/AnalyticsEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchDisabledEventTypes", "", "", "prepareData", "Lkotlin/Pair;", "disabledEventTypes", "isSystemLog", "", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeProcessedEventsOnSuccess", "processedEvents", "sendData", "Lkotlinx/coroutines/flow/Flow;", "filteredEvents", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startProcessingEvents", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnalyticsEventQueueDispatcher.kt */
public final class AnalyticsEventQueueDispatcher {
    private final CacheRepository cacheRepository;
    private final Semaphore dataLocalSemaphore;
    /* access modifiers changed from: private */
    public final Semaphore dataRemoteSemaphore;
    /* access modifiers changed from: private */
    public final MutableSharedFlow<AnalyticsEvent> eventFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    /* access modifiers changed from: private */
    public final HttpClient httpClient;
    /* access modifiers changed from: private */
    public final LifecycleManager lifecycleManager;
    /* access modifiers changed from: private */
    public final RequestFactory requestFactory;

    public AnalyticsEventQueueDispatcher(CacheRepository cacheRepository2, HttpClient httpClient2, RequestFactory requestFactory2, LifecycleManager lifecycleManager2, Semaphore semaphore, Semaphore semaphore2) {
        Intrinsics.checkNotNullParameter(cacheRepository2, "cacheRepository");
        Intrinsics.checkNotNullParameter(httpClient2, "httpClient");
        Intrinsics.checkNotNullParameter(requestFactory2, "requestFactory");
        Intrinsics.checkNotNullParameter(lifecycleManager2, "lifecycleManager");
        Intrinsics.checkNotNullParameter(semaphore, "dataLocalSemaphore");
        Intrinsics.checkNotNullParameter(semaphore2, "dataRemoteSemaphore");
        this.cacheRepository = cacheRepository2;
        this.httpClient = httpClient2;
        this.requestFactory = requestFactory2;
        this.lifecycleManager = lifecycleManager2;
        this.dataLocalSemaphore = semaphore;
        this.dataRemoteSemaphore = semaphore2;
        startProcessingEvents();
    }

    public final Object addToQueue(AnalyticsEvent analyticsEvent, Continuation<? super Unit> continuation) {
        Object emit = this.eventFlow.emit(analyticsEvent, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    private final void startProcessingEvents() {
        Job unused = Intrinsics.checkNotNullParameter(new AnalyticsEventQueueDispatcher$startProcessingEvents$1(this, (Continuation<? super AnalyticsEventQueueDispatcher$startProcessingEvents$1>) null), "block");
    }

    /* access modifiers changed from: private */
    public final List<String> fetchDisabledEventTypes() {
        AnalyticsConfig analyticsConfig = this.cacheRepository.getAnalyticsConfig();
        List<String> component1 = analyticsConfig.component1();
        if (System.currentTimeMillis() < analyticsConfig.component2()) {
            return component1;
        }
        Response newCall = this.httpClient.newCall(this.requestFactory.getAnalyticsConfig(), AnalyticsConfig.class);
        if (newCall instanceof Response.Success) {
            Response.Success success = (Response.Success) newCall;
            this.cacheRepository.setAnalyticsConfig((AnalyticsConfig) success.getBody());
            return ((AnalyticsConfig) success.getBody()).getDisabledEventTypes();
        } else if (newCall instanceof Response.Error) {
            throw ((Response.Error) newCall).getError();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e A[Catch:{ all -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f A[Catch:{ all -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object prepareData(java.util.List<java.lang.String> r6, boolean r7, kotlin.coroutines.Continuation<? super kotlin.Pair<? extends java.util.List<com.adapty.internal.data.models.AnalyticsEvent>, ? extends java.util.List<com.adapty.internal.data.models.AnalyticsEvent>>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$prepareData$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$prepareData$1 r0 = (com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$prepareData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$prepareData$1 r0 = new com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$prepareData$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            boolean r7 = r0.Z$0
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.sync.Semaphore r6 = (kotlinx.coroutines.sync.Semaphore) r6
            java.lang.Object r1 = r0.L$1
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r0 = r0.L$0
            com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher r0 = (com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0059
        L_0x0038:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Semaphore r8 = r5.dataLocalSemaphore
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r8
            r0.Z$0 = r7
            r0.label = r3
            java.lang.Object r0 = r8.acquire(r0)
            if (r0 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r0 = r5
            r1 = r6
            r6 = r8
        L_0x0059:
            com.adapty.internal.data.cache.CacheRepository r8 = r0.cacheRepository     // Catch:{ all -> 0x00b3 }
            r0 = 0
            if (r7 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r3 = r0
        L_0x0060:
            com.adapty.internal.data.models.AnalyticsData r7 = r8.getAnalyticsData(r3)     // Catch:{ all -> 0x00b3 }
            java.util.List r7 = r7.getEvents()     // Catch:{ all -> 0x00b3 }
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch:{ all -> 0x00b3 }
            com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$prepareData$lambda$1$$inlined$sortedByDescending$1 r8 = new com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$prepareData$lambda$1$$inlined$sortedByDescending$1     // Catch:{ all -> 0x00b3 }
            r8.<init>()     // Catch:{ all -> 0x00b3 }
            java.util.Comparator r8 = (java.util.Comparator) r8     // Catch:{ all -> 0x00b3 }
            java.util.List r7 = kotlin.collections.CollectionsKt.sortedWith(r7, r8)     // Catch:{ all -> 0x00b3 }
            r6.release()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r8 = r7.iterator()
        L_0x0083:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x00a8
            java.lang.Object r2 = r8.next()
            com.adapty.internal.data.models.AnalyticsEvent r2 = (com.adapty.internal.data.models.AnalyticsEvent) r2
            int r3 = r6.size()
            r4 = 500(0x1f4, float:7.0E-43)
            if (r3 < r4) goto L_0x0098
            goto L_0x00a8
        L_0x0098:
            java.lang.String r3 = r2.getEventName()
            boolean r3 = r1.contains(r3)
            if (r3 != 0) goto L_0x00a5
            r6.add(r2)
        L_0x00a5:
            int r0 = r0 + 1
            goto L_0x0083
        L_0x00a8:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.List r7 = kotlin.collections.CollectionsKt.take(r7, r0)
            kotlin.Pair r6 = kotlin.TuplesKt.to(r6, r7)
            return r6
        L_0x00b3:
            r7 = move-exception
            r6.release()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher.prepareData(java.util.List, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object sendData(List<AnalyticsEvent> list, Continuation<? super Flow<Unit>> continuation) {
        return FlowKt.flow(new AnalyticsEventQueueDispatcher$sendData$2(list, this, (Continuation<? super AnalyticsEventQueueDispatcher$sendData$2>) null));
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e A[Catch:{ all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060 A[Catch:{ all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0097 A[Catch:{ all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0098 A[Catch:{ all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object removeProcessedEventsOnSuccess(java.util.List<com.adapty.internal.data.models.AnalyticsEvent> r8, boolean r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$removeProcessedEventsOnSuccess$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$removeProcessedEventsOnSuccess$1 r0 = (com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$removeProcessedEventsOnSuccess$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$removeProcessedEventsOnSuccess$1 r0 = new com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$removeProcessedEventsOnSuccess$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            boolean r9 = r0.Z$0
            java.lang.Object r8 = r0.L$2
            kotlinx.coroutines.sync.Semaphore r8 = (kotlinx.coroutines.sync.Semaphore) r8
            java.lang.Object r1 = r0.L$1
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r0 = r0.L$0
            com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher r0 = (com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher) r0
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r8
            r8 = r1
            goto L_0x0059
        L_0x003a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.sync.Semaphore r10 = r7.dataLocalSemaphore
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r10
            r0.Z$0 = r9
            r0.label = r3
            java.lang.Object r0 = r10.acquire(r0)
            if (r0 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r0 = r7
        L_0x0059:
            com.adapty.internal.data.cache.CacheRepository r1 = r0.cacheRepository     // Catch:{ all -> 0x00a4 }
            r2 = 0
            if (r9 == 0) goto L_0x0060
            r4 = r3
            goto L_0x0061
        L_0x0060:
            r4 = r2
        L_0x0061:
            com.adapty.internal.data.models.AnalyticsData r1 = r1.getAnalyticsData(r4)     // Catch:{ all -> 0x00a4 }
            com.adapty.internal.data.cache.CacheRepository r0 = r0.cacheRepository     // Catch:{ all -> 0x00a4 }
            com.adapty.internal.data.models.AnalyticsData r4 = new com.adapty.internal.data.models.AnalyticsData     // Catch:{ all -> 0x00a4 }
            java.util.List r5 = r1.getEvents()     // Catch:{ all -> 0x00a4 }
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch:{ all -> 0x00a4 }
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch:{ all -> 0x00a4 }
            java.util.Set r8 = kotlin.collections.CollectionsKt.subtract(r5, r8)     // Catch:{ all -> 0x00a4 }
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch:{ all -> 0x00a4 }
            com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$removeProcessedEventsOnSuccess$lambda$4$lambda$3$$inlined$sortedBy$1 r5 = new com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$removeProcessedEventsOnSuccess$lambda$4$lambda$3$$inlined$sortedBy$1     // Catch:{ all -> 0x00a4 }
            r5.<init>()     // Catch:{ all -> 0x00a4 }
            java.util.Comparator r5 = (java.util.Comparator) r5     // Catch:{ all -> 0x00a4 }
            java.util.List r8 = kotlin.collections.CollectionsKt.sortedWith(r8, r5)     // Catch:{ all -> 0x00a4 }
            r5 = 500(0x1f4, float:7.0E-43)
            java.util.List r8 = kotlin.collections.CollectionsKt.takeLast(r8, r5)     // Catch:{ all -> 0x00a4 }
            java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ all -> 0x00a4 }
            java.util.List r8 = kotlin.collections.CollectionsKt.toMutableList(r8)     // Catch:{ all -> 0x00a4 }
            long r5 = r1.getPrevOrdinal()     // Catch:{ all -> 0x00a4 }
            r4.<init>(r8, r5)     // Catch:{ all -> 0x00a4 }
            if (r9 == 0) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r3 = r2
        L_0x0099:
            r0.saveAnalyticsData(r4, r3)     // Catch:{ all -> 0x00a4 }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a4 }
            r10.release()
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00a4:
            r8 = move-exception
            r10.release()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher.removeProcessedEventsOnSuccess(java.util.List, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
