package com.adapty.internal.data.cloud;

import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.cloud.AnalyticsTracker;
import com.adapty.internal.data.models.AnalyticsEvent;
import com.adapty.internal.utils.Logger;
import com.adapty.internal.utils.Logger$log$1;
import com.adapty.internal.utils.UtilsKt;
import com.adapty.utils.AdaptyLogLevel;
import com.adapty.utils.ErrorCallback;
import com.amplitude.reactnative.AndroidContextProvider;
import com.google.gson.Gson;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Semaphore;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\\\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00102\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\"\u0010\u001d\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\"J<\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\"\u0010\u001d\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u001eH\u0016ø\u0001\u0000¢\u0006\u0002\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/adapty/internal/data/cloud/AnalyticsEventRecorder;", "Lcom/adapty/internal/data/cloud/AnalyticsTracker;", "cacheRepository", "Lcom/adapty/internal/data/cache/CacheRepository;", "gson", "Lcom/google/gson/Gson;", "dataLocalSemaphore", "Lkotlinx/coroutines/sync/Semaphore;", "(Lcom/adapty/internal/data/cache/CacheRepository;Lcom/google/gson/Gson;Lkotlinx/coroutines/sync/Semaphore;)V", "dateFormatter", "Ljava/text/DateFormat;", "getDateFormatter", "()Ljava/text/DateFormat;", "dateFormatter$delegate", "Lkotlin/Lazy;", "sessionId", "", "createEvent", "Lcom/adapty/internal/data/models/AnalyticsEvent;", "eventName", "subMap", "", "", "formatCurrentDateTime", "retainEvent", "", "event", "(Lcom/adapty/internal/data/models/AnalyticsEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackEvent", "onEventRegistered", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "completion", "Lcom/adapty/utils/ErrorCallback;", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lcom/adapty/utils/ErrorCallback;)V", "trackSystemEvent", "customData", "Lcom/adapty/internal/data/models/AnalyticsEvent$CustomData;", "(Lcom/adapty/internal/data/models/AnalyticsEvent$CustomData;Lkotlin/jvm/functions/Function2;)V", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnalyticsEventRecorder.kt */
public final class AnalyticsEventRecorder implements AnalyticsTracker {
    /* access modifiers changed from: private */
    public final CacheRepository cacheRepository;
    private final Semaphore dataLocalSemaphore;
    private final Lazy dateFormatter$delegate = LazyKt.lazy(AnalyticsEventRecorder$dateFormatter$2.INSTANCE);
    private final Gson gson;
    private final String sessionId = UtilsKt.generateUuid();

    public AnalyticsEventRecorder(CacheRepository cacheRepository2, Gson gson2, Semaphore semaphore) {
        Intrinsics.checkNotNullParameter(cacheRepository2, "cacheRepository");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        Intrinsics.checkNotNullParameter(semaphore, "dataLocalSemaphore");
        this.cacheRepository = cacheRepository2;
        this.gson = gson2;
        this.dataLocalSemaphore = semaphore;
    }

    public void trackSystemEvent(AnalyticsEvent.CustomData customData, Function2<? super AnalyticsEvent, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(customData, "customData");
        Intrinsics.checkNotNullParameter(function2, "onEventRegistered");
        AnalyticsTracker.DefaultImpls.trackEvent$default(this, AnalyticsEvent.SYSTEM_LOG, MapsKt.mapOf(TuplesKt.to(AnalyticsEvent.CUSTOM_DATA, customData)), function2, (ErrorCallback) null, 8, (Object) null);
    }

    public void trackEvent(String str, Map<String, ? extends Object> map, Function2<? super AnalyticsEvent, ? super Continuation<? super Unit>, ? extends Object> function2, ErrorCallback errorCallback) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(function2, "onEventRegistered");
        Job unused = Intrinsics.checkNotNullParameter(new AnalyticsEventRecorder$trackEvent$1(this, str, map, function2, errorCallback, (Continuation<? super AnalyticsEventRecorder$trackEvent$1>) null), "block");
    }

    /* access modifiers changed from: private */
    public final AnalyticsEvent createEvent(String str, Map<String, ? extends Object> map) {
        Object obj;
        String formatCurrentDateTime = formatCurrentDateTime();
        String generateUuid = UtilsKt.generateUuid();
        String profileId = this.cacheRepository.getProfileId();
        String str2 = this.sessionId;
        String installationMetaId = this.cacheRepository.getInstallationMetaId();
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        Map linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof AnalyticsEvent.CustomData) {
                try {
                    Result.Companion companion = Result.Companion;
                    AnalyticsEventRecorder analyticsEventRecorder = this;
                    obj = Result.m983constructorimpl(this.gson.toJson(value));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m983constructorimpl(ResultKt.createFailure(th));
                }
                Throwable r7 = Result.m986exceptionOrNullimpl(obj);
                if (r7 == null) {
                    value = (String) obj;
                } else {
                    Logger logger = Logger.INSTANCE;
                    AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.ERROR;
                    if (logger.canLog(adaptyLogLevel.value)) {
                        logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "Couldn't handle system event. " + r7));
                    }
                    value = "{\"event_name\":\"error\",\"message\":\"" + r7.getLocalizedMessage() + "\"}";
                }
                if (value == null) {
                    value = "";
                }
            }
            linkedHashMap.put(key, value);
        }
        return new AnalyticsEvent(generateUuid, str, profileId, str2, installationMetaId, formatCurrentDateTime, AndroidContextProvider.PLATFORM, linkedHashMap);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063 A[Catch:{ all -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065 A[Catch:{ all -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009d A[Catch:{ all -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009e A[Catch:{ all -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object retainEvent(com.adapty.internal.data.models.AnalyticsEvent r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.adapty.internal.data.cloud.AnalyticsEventRecorder$retainEvent$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.adapty.internal.data.cloud.AnalyticsEventRecorder$retainEvent$1 r0 = (com.adapty.internal.data.cloud.AnalyticsEventRecorder$retainEvent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.adapty.internal.data.cloud.AnalyticsEventRecorder$retainEvent$1 r0 = new com.adapty.internal.data.cloud.AnalyticsEventRecorder$retainEvent$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            boolean r11 = r0.Z$0
            java.lang.Object r1 = r0.L$2
            kotlinx.coroutines.sync.Semaphore r1 = (kotlinx.coroutines.sync.Semaphore) r1
            java.lang.Object r2 = r0.L$1
            com.adapty.internal.data.models.AnalyticsEvent r2 = (com.adapty.internal.data.models.AnalyticsEvent) r2
            java.lang.Object r0 = r0.L$0
            com.adapty.internal.data.cloud.AnalyticsEventRecorder r0 = (com.adapty.internal.data.cloud.AnalyticsEventRecorder) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x005e
        L_0x0038:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r12)
            boolean r12 = r11.isSystemLog()
            kotlinx.coroutines.sync.Semaphore r2 = r10.dataLocalSemaphore
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r2
            r0.Z$0 = r12
            r0.label = r3
            java.lang.Object r0 = r2.acquire(r0)
            if (r0 != r1) goto L_0x005a
            return r1
        L_0x005a:
            r0 = r10
            r1 = r2
            r2 = r11
            r11 = r12
        L_0x005e:
            com.adapty.internal.data.cache.CacheRepository r12 = r0.cacheRepository     // Catch:{ all -> 0x00aa }
            r4 = 0
            if (r11 == 0) goto L_0x0065
            r5 = r3
            goto L_0x0066
        L_0x0065:
            r5 = r4
        L_0x0066:
            com.adapty.internal.data.models.AnalyticsData r12 = r12.getAnalyticsData(r5)     // Catch:{ all -> 0x00aa }
            java.util.List r5 = r12.component1()     // Catch:{ all -> 0x00aa }
            long r6 = r12.component2()     // Catch:{ all -> 0x00aa }
            r8 = 1
            long r6 = r6 + r8
            r2.setOrdinal(r6)     // Catch:{ all -> 0x00aa }
            com.adapty.internal.data.cache.CacheRepository r12 = r0.cacheRepository     // Catch:{ all -> 0x00aa }
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch:{ all -> 0x00aa }
            com.adapty.internal.data.cloud.AnalyticsEventRecorder$retainEvent$lambda$7$$inlined$sortedBy$1 r0 = new com.adapty.internal.data.cloud.AnalyticsEventRecorder$retainEvent$lambda$7$$inlined$sortedBy$1     // Catch:{ all -> 0x00aa }
            r0.<init>()     // Catch:{ all -> 0x00aa }
            java.util.Comparator r0 = (java.util.Comparator) r0     // Catch:{ all -> 0x00aa }
            java.util.List r0 = kotlin.collections.CollectionsKt.sortedWith(r5, r0)     // Catch:{ all -> 0x00aa }
            r5 = 499(0x1f3, float:6.99E-43)
            java.util.List r0 = kotlin.collections.CollectionsKt.takeLast(r0, r5)     // Catch:{ all -> 0x00aa }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x00aa }
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r0)     // Catch:{ all -> 0x00aa }
            r0.add(r2)     // Catch:{ all -> 0x00aa }
            com.adapty.internal.data.models.AnalyticsData r2 = new com.adapty.internal.data.models.AnalyticsData     // Catch:{ all -> 0x00aa }
            r2.<init>(r0, r6)     // Catch:{ all -> 0x00aa }
            if (r11 == 0) goto L_0x009e
            goto L_0x009f
        L_0x009e:
            r3 = r4
        L_0x009f:
            r12.saveAnalyticsData(r2, r3)     // Catch:{ all -> 0x00aa }
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00aa }
            r1.release()
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00aa:
            r11 = move-exception
            r1.release()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cloud.AnalyticsEventRecorder.retainEvent(com.adapty.internal.data.models.AnalyticsEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String formatCurrentDateTime() {
        String format = getDateFormatter().format(Calendar.getInstance().getTime());
        Intrinsics.checkNotNullExpressionValue(format, "getInstance().time.let(dateFormatter::format)");
        return format;
    }

    private final DateFormat getDateFormatter() {
        return (DateFormat) this.dateFormatter$delegate.getValue();
    }
}
