package com.adapty.internal.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.utils.AdIdRetriever$getAdIdIfAvailable$1", f = "AdIdRetriever.kt", i = {2}, l = {31, 35, 39, 42, 47, 60}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* compiled from: AdIdRetriever.kt */
final class AdIdRetriever$getAdIdIfAvailable$1 extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AdIdRetriever this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdIdRetriever$getAdIdIfAvailable$1(AdIdRetriever adIdRetriever, Continuation<? super AdIdRetriever$getAdIdIfAvailable$1> continuation) {
        super(2, continuation);
        this.this$0 = adIdRetriever;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AdIdRetriever$getAdIdIfAvailable$1 adIdRetriever$getAdIdIfAvailable$1 = new AdIdRetriever$getAdIdIfAvailable$1(this.this$0, continuation);
        adIdRetriever$getAdIdIfAvailable$1.L$0 = obj;
        return adIdRetriever$getAdIdIfAvailable$1;
    }

    public final Object invoke(FlowCollector<? super String> flowCollector, Continuation<? super Unit> continuation) {
        return ((AdIdRetriever$getAdIdIfAvailable$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005e, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009c, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7.this$0.cacheRepository.getExternalAnalyticsEnabled(), (java.lang.Object) kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false)) == false) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009e, code lost:
        r7.this$0.adIdSemaphore.release();
        r7.L$0 = null;
        r7.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b3, code lost:
        if (r1.emit(r4, r7) != r0) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b5, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b8, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b9, code lost:
        r8 = r7.this$0.cachedAdvertisingId;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bf, code lost:
        if (r8 == null) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c1, code lost:
        r7.this$0.adIdSemaphore.release();
        r7.L$0 = null;
        r7.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d3, code lost:
        if (r1.emit(r8, r7) != r0) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d5, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d8, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r8 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r7.this$0.appContext);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e8, code lost:
        if ((true ^ r8.isLimitAdTrackingEnabled()) == false) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00eb, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ec, code lost:
        if (r8 == null) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ee, code lost:
        r8 = r8.getId();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            r3 = 0
            java.lang.String r4 = ""
            switch(r1) {
                case 0: goto L_0x0034;
                case 1: goto L_0x0030;
                case 2: goto L_0x002c;
                case 3: goto L_0x0024;
                case 4: goto L_0x001f;
                case 5: goto L_0x001a;
                case 6: goto L_0x0015;
                default: goto L_0x000d;
            }
        L_0x000d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0015:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0115
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00d6
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00b6
        L_0x0024:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0089
        L_0x002c:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0071
        L_0x0030:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005c
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            com.adapty.internal.utils.AdIdRetriever r8 = r7.this$0
            com.adapty.internal.data.cache.CacheRepository r8 = r8.cacheRepository
            java.lang.Boolean r8 = r8.getExternalAnalyticsEnabled()
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r5)
            if (r8 == 0) goto L_0x005f
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r7.label = r2
            java.lang.Object r8 = r1.emit(r4, r8)
            if (r8 != r0) goto L_0x005c
            return r0
        L_0x005c:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x005f:
            com.adapty.internal.utils.AdIdRetriever r8 = r7.this$0
            java.lang.String r8 = r8.cachedAdvertisingId
            if (r8 == 0) goto L_0x0074
            r2 = 2
            r7.label = r2
            java.lang.Object r8 = r1.emit(r8, r7)
            if (r8 != r0) goto L_0x0071
            return r0
        L_0x0071:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x0074:
            com.adapty.internal.utils.AdIdRetriever r8 = r7.this$0
            kotlinx.coroutines.sync.Semaphore r8 = r8.adIdSemaphore
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r7.L$0 = r1
            r6 = 3
            r7.label = r6
            java.lang.Object r8 = r8.acquire(r5)
            if (r8 != r0) goto L_0x0089
            return r0
        L_0x0089:
            com.adapty.internal.utils.AdIdRetriever r8 = r7.this$0
            com.adapty.internal.data.cache.CacheRepository r8 = r8.cacheRepository
            java.lang.Boolean r8 = r8.getExternalAnalyticsEnabled()
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r3)
            r3 = 0
            if (r8 == 0) goto L_0x00b9
            com.adapty.internal.utils.AdIdRetriever r8 = r7.this$0
            kotlinx.coroutines.sync.Semaphore r8 = r8.adIdSemaphore
            r8.release()
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r7.L$0 = r3
            r2 = 4
            r7.label = r2
            java.lang.Object r8 = r1.emit(r4, r8)
            if (r8 != r0) goto L_0x00b6
            return r0
        L_0x00b6:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00b9:
            com.adapty.internal.utils.AdIdRetriever r8 = r7.this$0
            java.lang.String r8 = r8.cachedAdvertisingId
            if (r8 == 0) goto L_0x00d9
            com.adapty.internal.utils.AdIdRetriever r2 = r7.this$0
            kotlinx.coroutines.sync.Semaphore r2 = r2.adIdSemaphore
            r2.release()
            r7.L$0 = r3
            r2 = 5
            r7.label = r2
            java.lang.Object r8 = r1.emit(r8, r7)
            if (r8 != r0) goto L_0x00d6
            return r0
        L_0x00d6:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00d9:
            com.adapty.internal.utils.AdIdRetriever r8 = r7.this$0     // Catch:{ Exception -> 0x00f3 }
            android.content.Context r8 = r8.appContext     // Catch:{ Exception -> 0x00f3 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r8 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r8)     // Catch:{ Exception -> 0x00f3 }
            boolean r5 = r8.isLimitAdTrackingEnabled()     // Catch:{ Exception -> 0x00f3 }
            r2 = r2 ^ r5
            if (r2 == 0) goto L_0x00eb
            goto L_0x00ec
        L_0x00eb:
            r8 = r3
        L_0x00ec:
            if (r8 == 0) goto L_0x00f3
            java.lang.String r8 = r8.getId()     // Catch:{ Exception -> 0x00f3 }
            goto L_0x00f4
        L_0x00f3:
            r8 = r3
        L_0x00f4:
            com.adapty.internal.utils.AdIdRetriever r2 = r7.this$0
            r2.cachedAdvertisingId = r8
            com.adapty.internal.utils.AdIdRetriever r2 = r7.this$0
            kotlinx.coroutines.sync.Semaphore r2 = r2.adIdSemaphore
            r2.release()
            if (r8 != 0) goto L_0x0105
            goto L_0x0106
        L_0x0105:
            r4 = r8
        L_0x0106:
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r7.L$0 = r3
            r2 = 6
            r7.label = r2
            java.lang.Object r8 = r1.emit(r4, r8)
            if (r8 != r0) goto L_0x0115
            return r0
        L_0x0115:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.AdIdRetriever$getAdIdIfAvailable$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
