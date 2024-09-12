package com.adapty.internal.domain;

import com.adapty.models.AdaptyProfile;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class PurchasesInteractor$syncPurchasesInternal$2$2$invokeSuspend$$inlined$map$1 implements Flow<AdaptyProfile> {
    final /* synthetic */ List $dataToSync$inlined;
    final /* synthetic */ Set $syncedPurchases$inlined;
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ PurchasesInteractor this$0;

    public PurchasesInteractor$syncPurchasesInternal$2$2$invokeSuspend$$inlined$map$1(Flow flow, PurchasesInteractor purchasesInteractor, List list, Set set) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = purchasesInteractor;
        this.$dataToSync$inlined = list;
        this.$syncedPurchases$inlined = set;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final PurchasesInteractor purchasesInteractor = this.this$0;
        final List list = this.$dataToSync$inlined;
        final Set set = this.$syncedPurchases$inlined;
        Object collect = flow.collect(new Object() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x013e A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r17, kotlin.coroutines.Continuation r18) {
                /*
                    r16 = this;
                    r0 = r16
                    r1 = r18
                    boolean r2 = r1 instanceof com.adapty.internal.domain.PurchasesInteractor$syncPurchasesInternal$2$2$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r2 == 0) goto L_0x0018
                    r2 = r1
                    com.adapty.internal.domain.PurchasesInteractor$syncPurchasesInternal$2$2$invokeSuspend$$inlined$map$1$2$1 r2 = (com.adapty.internal.domain.PurchasesInteractor$syncPurchasesInternal$2$2$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r2
                    int r3 = r2.label
                    r4 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r3 & r4
                    if (r3 == 0) goto L_0x0018
                    int r1 = r2.label
                    int r1 = r1 - r4
                    r2.label = r1
                    goto L_0x001d
                L_0x0018:
                    com.adapty.internal.domain.PurchasesInteractor$syncPurchasesInternal$2$2$invokeSuspend$$inlined$map$1$2$1 r2 = new com.adapty.internal.domain.PurchasesInteractor$syncPurchasesInternal$2$2$invokeSuspend$$inlined$map$1$2$1
                    r2.<init>(r0, r1)
                L_0x001d:
                    java.lang.Object r1 = r2.result
                    java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r4 = r2.label
                    r5 = 2
                    r6 = 0
                    r7 = 1
                    if (r4 == 0) goto L_0x0048
                    if (r4 == r7) goto L_0x003b
                    if (r4 != r5) goto L_0x0033
                    kotlin.ResultKt.throwOnFailure(r1)
                    goto L_0x013f
                L_0x0033:
                    java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                    java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                    r1.<init>(r2)
                    throw r1
                L_0x003b:
                    java.lang.Object r4 = r2.L$1
                    kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                    java.lang.Object r7 = r2.L$0
                    com.adapty.internal.domain.PurchasesInteractor$syncPurchasesInternal$2$2$invokeSuspend$$inlined$map$1$2 r7 = (com.adapty.internal.domain.PurchasesInteractor$syncPurchasesInternal$2$2$invokeSuspend$$inlined$map$1.AnonymousClass2) r7
                    kotlin.ResultKt.throwOnFailure(r1)
                    goto L_0x0126
                L_0x0048:
                    kotlin.ResultKt.throwOnFailure(r1)
                    kotlinx.coroutines.flow.FlowCollector r4 = r6
                    r1 = r2
                    kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                    r1 = r17
                    kotlin.Pair r1 = (kotlin.Pair) r1
                    java.lang.Object r8 = r1.component1()
                    com.adapty.internal.data.models.ProfileDto r8 = (com.adapty.internal.data.models.ProfileDto) r8
                    java.lang.Object r1 = r1.component2()
                    com.adapty.internal.data.cloud.Request$CurrentDataWhenSent r1 = (com.adapty.internal.data.cloud.Request.CurrentDataWhenSent) r1
                    com.adapty.internal.domain.PurchasesInteractor r9 = r2
                    com.adapty.internal.data.cache.CacheRepository r9 = r9.cacheRepository
                    java.lang.String r9 = r9.getProfileId()
                    if (r1 == 0) goto L_0x0071
                    java.lang.String r10 = r1.getProfileId()
                    goto L_0x0072
                L_0x0071:
                    r10 = r6
                L_0x0072:
                    boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
                    if (r9 == 0) goto L_0x010a
                    com.adapty.internal.domain.PurchasesInteractor r9 = r2
                    com.adapty.internal.data.cache.CacheRepository r9 = r9.cacheRepository
                    java.lang.String r9 = r9.getCustomerUserId()
                    java.lang.String r10 = r1.getCustomerUserId()
                    boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
                    if (r9 == 0) goto L_0x010a
                    com.adapty.internal.domain.PurchasesInteractor r9 = r2
                    com.adapty.internal.data.cache.CacheRepository r9 = r9.cacheRepository
                    java.util.List r10 = r3
                    java.lang.Iterable r10 = (java.lang.Iterable) r10
                    com.adapty.internal.domain.PurchasesInteractor r11 = r2
                    com.adapty.internal.utils.ProductMapper r11 = r11.productMapper
                    java.util.ArrayList r12 = new java.util.ArrayList
                    r13 = 10
                    int r13 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r13)
                    r12.<init>(r13)
                    java.util.Collection r12 = (java.util.Collection) r12
                    java.util.Iterator r10 = r10.iterator()
                L_0x00ad:
                    boolean r13 = r10.hasNext()
                    if (r13 == 0) goto L_0x00c1
                    java.lang.Object r13 = r10.next()
                    com.adapty.internal.data.models.PurchaseRecordModel r13 = (com.adapty.internal.data.models.PurchaseRecordModel) r13
                    com.adapty.internal.data.models.SyncedPurchase r13 = r11.mapToSyncedPurchase(r13)
                    r12.add(r13)
                    goto L_0x00ad
                L_0x00c1:
                    java.util.List r12 = (java.util.List) r12
                    java.lang.Iterable r12 = (java.lang.Iterable) r12
                    java.util.Set r10 = r4
                    java.lang.Iterable r10 = (java.lang.Iterable) r10
                    java.util.ArrayList r11 = new java.util.ArrayList
                    r11.<init>()
                    java.util.Collection r11 = (java.util.Collection) r11
                    java.util.Iterator r10 = r10.iterator()
                L_0x00d4:
                    boolean r13 = r10.hasNext()
                    if (r13 == 0) goto L_0x00f6
                    java.lang.Object r13 = r10.next()
                    r14 = r13
                    com.adapty.internal.data.models.SyncedPurchase r14 = (com.adapty.internal.data.models.SyncedPurchase) r14
                    java.lang.String r15 = r14.getPurchaseToken()
                    if (r15 == 0) goto L_0x00ef
                    java.lang.Long r14 = r14.getPurchaseTime()
                    if (r14 == 0) goto L_0x00ef
                    r14 = r7
                    goto L_0x00f0
                L_0x00ef:
                    r14 = 0
                L_0x00f0:
                    if (r14 == 0) goto L_0x00d4
                    r11.add(r13)
                    goto L_0x00d4
                L_0x00f6:
                    java.util.List r11 = (java.util.List) r11
                    java.lang.Iterable r11 = (java.lang.Iterable) r11
                    java.util.Set r10 = kotlin.collections.CollectionsKt.union(r12, r11)
                    r9.saveSyncedPurchases(r10)
                    com.adapty.internal.domain.PurchasesInteractor r9 = r2
                    com.adapty.internal.data.cache.CacheRepository r9 = r9.cacheRepository
                    r9.setPurchasesHaveBeenSynced(r7)
                L_0x010a:
                    com.adapty.internal.domain.PurchasesInteractor r9 = r2
                    com.adapty.internal.data.cache.CacheRepository r9 = r9.cacheRepository
                    if (r1 == 0) goto L_0x0117
                    java.lang.String r1 = r1.getProfileId()
                    goto L_0x0118
                L_0x0117:
                    r1 = r6
                L_0x0118:
                    r2.L$0 = r0
                    r2.L$1 = r4
                    r2.label = r7
                    java.lang.Object r1 = r9.updateOnProfileReceived(r8, r1, r2)
                    if (r1 != r3) goto L_0x0125
                    return r3
                L_0x0125:
                    r7 = r0
                L_0x0126:
                    com.adapty.internal.domain.PurchasesInteractor r7 = r2
                    com.adapty.internal.utils.ProfileMapper r7 = r7.profileMapper
                    com.adapty.internal.data.models.ProfileDto r1 = (com.adapty.internal.data.models.ProfileDto) r1
                    com.adapty.models.AdaptyProfile r1 = r7.map(r1)
                    r2.L$0 = r6
                    r2.L$1 = r6
                    r2.label = r5
                    java.lang.Object r1 = r4.emit(r1, r2)
                    if (r1 != r3) goto L_0x013f
                    return r3
                L_0x013f:
                    kotlin.Unit r1 = kotlin.Unit.INSTANCE
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.domain.PurchasesInteractor$syncPurchasesInternal$2$2$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
