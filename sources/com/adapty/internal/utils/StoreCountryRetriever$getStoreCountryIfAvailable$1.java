package com.adapty.internal.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1", f = "StoreCountryRetriever.kt", i = {0, 3}, l = {31, 32, 40, 44, 47, 51}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
/* compiled from: StoreCountryRetriever.kt */
final class StoreCountryRetriever$getStoreCountryIfAvailable$1 extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $forceUpdate;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StoreCountryRetriever this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreCountryRetriever$getStoreCountryIfAvailable$1(boolean z, StoreCountryRetriever storeCountryRetriever, Continuation<? super StoreCountryRetriever$getStoreCountryIfAvailable$1> continuation) {
        super(2, continuation);
        this.$forceUpdate = z;
        this.this$0 = storeCountryRetriever;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StoreCountryRetriever$getStoreCountryIfAvailable$1 storeCountryRetriever$getStoreCountryIfAvailable$1 = new StoreCountryRetriever$getStoreCountryIfAvailable$1(this.$forceUpdate, this.this$0, continuation);
        storeCountryRetriever$getStoreCountryIfAvailable$1.L$0 = obj;
        return storeCountryRetriever$getStoreCountryIfAvailable$1;
    }

    public final Object invoke(FlowCollector<? super String> flowCollector, Continuation<? super Unit> continuation) {
        return ((StoreCountryRetriever$getStoreCountryIfAvailable$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v23, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        r6 = kotlinx.coroutines.flow.FlowKt.m2547catch(new com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1$invokeSuspend$$inlined$map$1(r5.this$0.storeManager.getStoreCountry()), new com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1.AnonymousClass2((kotlin.coroutines.Continuation<? super com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1.AnonymousClass2>) null));
        r4 = r5.this$0;
        r5.L$0 = null;
        r5.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0088, code lost:
        if (kotlinx.coroutines.flow.FlowKt.emitAll(r1, kotlinx.coroutines.flow.FlowKt.onEach(r6, new com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1.AnonymousClass3((kotlin.coroutines.Continuation<? super com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1.AnonymousClass3>) null)), (kotlin.coroutines.Continuation<? super kotlin.Unit>) r5) != r0) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x008a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009f, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b5, code lost:
        r6 = r5.this$0.cachedStoreCountry;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00bb, code lost:
        if (r6 == null) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00bd, code lost:
        r5.this$0.semaphore.release();
        r5.L$0 = null;
        r5.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00cf, code lost:
        if (r1.emit(r6, r5) != r0) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d1, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d4, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d5, code lost:
        r6 = kotlinx.coroutines.flow.FlowKt.m2547catch(new com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1$invokeSuspend$$inlined$map$2(r5.this$0.storeManager.getStoreCountry()), new com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1.AnonymousClass7((kotlin.coroutines.Continuation<? super com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1.AnonymousClass7>) null));
        r4 = r5.this$0;
        r5.L$0 = null;
        r5.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x010a, code lost:
        if (kotlinx.coroutines.flow.FlowKt.emitAll(r1, kotlinx.coroutines.flow.FlowKt.onEach(r6, new com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1.AnonymousClass8((kotlin.coroutines.Continuation<? super com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1.AnonymousClass8>) null)), (kotlin.coroutines.Continuation<? super kotlin.Unit>) r5) != r0) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x010c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010f, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 0
            switch(r1) {
                case 0: goto L_0x0032;
                case 1: goto L_0x002a;
                case 2: goto L_0x0025;
                case 3: goto L_0x0020;
                case 4: goto L_0x0017;
                case 5: goto L_0x0012;
                case 6: goto L_0x0025;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0012:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x00d2
        L_0x0017:
            java.lang.Object r1 = r5.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x00b5
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x009d
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x010d
        L_0x002a:
            java.lang.Object r1 = r5.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0053
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Object r6 = r5.L$0
            r1 = r6
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            boolean r6 = r5.$forceUpdate
            if (r6 == 0) goto L_0x008b
            com.adapty.internal.utils.StoreCountryRetriever r6 = r5.this$0
            kotlinx.coroutines.sync.Semaphore r6 = r6.semaphore
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r5.L$0 = r1
            r4 = 1
            r5.label = r4
            java.lang.Object r6 = r6.acquire(r3)
            if (r6 != r0) goto L_0x0053
            return r0
        L_0x0053:
            com.adapty.internal.utils.StoreCountryRetriever r6 = r5.this$0
            com.adapty.internal.data.cloud.StoreManager r6 = r6.storeManager
            kotlinx.coroutines.flow.Flow r6 = r6.getStoreCountry()
            com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1$invokeSuspend$$inlined$map$1 r3 = new com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1$invokeSuspend$$inlined$map$1
            r3.<init>(r6)
            kotlinx.coroutines.flow.Flow r3 = (kotlinx.coroutines.flow.Flow) r3
            com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1$2 r6 = new com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1$2
            r6.<init>(r2)
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.m2547catch(r3, r6)
            com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1$3 r3 = new com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1$3
            com.adapty.internal.utils.StoreCountryRetriever r4 = r5.this$0
            r3.<init>(r4, r2)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.onEach(r6, r3)
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r5.L$0 = r2
            r2 = 2
            r5.label = r2
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.emitAll(r1, r6, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r3)
            if (r6 != r0) goto L_0x010d
            return r0
        L_0x008b:
            com.adapty.internal.utils.StoreCountryRetriever r6 = r5.this$0
            java.lang.String r6 = r6.cachedStoreCountry
            if (r6 == 0) goto L_0x00a0
            r2 = 3
            r5.label = r2
            java.lang.Object r6 = r1.emit(r6, r5)
            if (r6 != r0) goto L_0x009d
            return r0
        L_0x009d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x00a0:
            com.adapty.internal.utils.StoreCountryRetriever r6 = r5.this$0
            kotlinx.coroutines.sync.Semaphore r6 = r6.semaphore
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r5.L$0 = r1
            r4 = 4
            r5.label = r4
            java.lang.Object r6 = r6.acquire(r3)
            if (r6 != r0) goto L_0x00b5
            return r0
        L_0x00b5:
            com.adapty.internal.utils.StoreCountryRetriever r6 = r5.this$0
            java.lang.String r6 = r6.cachedStoreCountry
            if (r6 == 0) goto L_0x00d5
            com.adapty.internal.utils.StoreCountryRetriever r3 = r5.this$0
            kotlinx.coroutines.sync.Semaphore r3 = r3.semaphore
            r3.release()
            r5.L$0 = r2
            r2 = 5
            r5.label = r2
            java.lang.Object r6 = r1.emit(r6, r5)
            if (r6 != r0) goto L_0x00d2
            return r0
        L_0x00d2:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x00d5:
            com.adapty.internal.utils.StoreCountryRetriever r6 = r5.this$0
            com.adapty.internal.data.cloud.StoreManager r6 = r6.storeManager
            kotlinx.coroutines.flow.Flow r6 = r6.getStoreCountry()
            com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1$invokeSuspend$$inlined$map$2 r3 = new com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1$invokeSuspend$$inlined$map$2
            r3.<init>(r6)
            kotlinx.coroutines.flow.Flow r3 = (kotlinx.coroutines.flow.Flow) r3
            com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1$7 r6 = new com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1$7
            r6.<init>(r2)
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.m2547catch(r3, r6)
            com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1$8 r3 = new com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1$8
            com.adapty.internal.utils.StoreCountryRetriever r4 = r5.this$0
            r3.<init>(r4, r2)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.onEach(r6, r3)
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r5.L$0 = r2
            r2 = 6
            r5.label = r2
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.emitAll(r1, r6, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r3)
            if (r6 != r0) goto L_0x010d
            return r0
        L_0x010d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.StoreCountryRetriever$getStoreCountryIfAvailable$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
