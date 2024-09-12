package com.adapty.internal.data.cloud;

import com.adapty.internal.data.models.PurchaseRecordModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class StoreManager$getPurchaseHistoryDataToRestoreForType$1$invoke$$inlined$map$1 implements Flow<List<? extends PurchaseRecordModel>> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ String $type$inlined;

    public StoreManager$getPurchaseHistoryDataToRestoreForType$1$invoke$$inlined$map$1(Flow flow, String str) {
        this.$this_unsafeTransform$inlined = flow;
        this.$type$inlined = str;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final String str = this.$type$inlined;
        Object collect = flow.collect(new Object() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r14, kotlin.coroutines.Continuation r15) {
                /*
                    r13 = this;
                    boolean r0 = r15 instanceof com.adapty.internal.data.cloud.StoreManager$getPurchaseHistoryDataToRestoreForType$1$invoke$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r15
                    com.adapty.internal.data.cloud.StoreManager$getPurchaseHistoryDataToRestoreForType$1$invoke$$inlined$map$1$2$1 r0 = (com.adapty.internal.data.cloud.StoreManager$getPurchaseHistoryDataToRestoreForType$1$invoke$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r15 = r0.label
                    int r15 = r15 - r2
                    r0.label = r15
                    goto L_0x0019
                L_0x0014:
                    com.adapty.internal.data.cloud.StoreManager$getPurchaseHistoryDataToRestoreForType$1$invoke$$inlined$map$1$2$1 r0 = new com.adapty.internal.data.cloud.StoreManager$getPurchaseHistoryDataToRestoreForType$1$invoke$$inlined$map$1$2$1
                    r0.<init>(r13, r15)
                L_0x0019:
                    java.lang.Object r15 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0033
                    if (r2 != r3) goto L_0x002b
                    kotlin.ResultKt.throwOnFailure(r15)
                    goto L_0x00c7
                L_0x002b:
                    java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                    java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
                    r14.<init>(r15)
                    throw r14
                L_0x0033:
                    kotlin.ResultKt.throwOnFailure(r15)
                    kotlinx.coroutines.flow.FlowCollector r15 = r4
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    kotlin.Pair r14 = (kotlin.Pair) r14
                    java.lang.Object r2 = r14.component1()
                    java.util.List r2 = (java.util.List) r2
                    java.lang.Object r14 = r14.component2()
                    java.util.List r14 = (java.util.List) r14
                    java.util.LinkedHashSet r4 = new java.util.LinkedHashSet
                    r4.<init>()
                    java.util.Set r4 = (java.util.Set) r4
                    java.lang.Iterable r14 = (java.lang.Iterable) r14
                    java.util.Iterator r14 = r14.iterator()
                L_0x0056:
                    boolean r5 = r14.hasNext()
                    if (r5 == 0) goto L_0x0084
                    java.lang.Object r5 = r14.next()
                    com.android.billingclient.api.Purchase r5 = (com.android.billingclient.api.Purchase) r5
                    com.adapty.internal.data.models.PurchaseRecordModel r12 = new com.adapty.internal.data.models.PurchaseRecordModel
                    java.lang.String r7 = r5.getPurchaseToken()
                    java.lang.String r6 = "purchase.purchaseToken"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
                    long r8 = r5.getPurchaseTime()
                    java.util.List r10 = r5.getProducts()
                    java.lang.String r5 = "purchase.products"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r5)
                    java.lang.String r11 = r2
                    r6 = r12
                    r6.<init>(r7, r8, r10, r11)
                    r4.add(r12)
                    goto L_0x0056
                L_0x0084:
                    java.lang.Iterable r2 = (java.lang.Iterable) r2
                    java.util.Iterator r14 = r2.iterator()
                L_0x008a:
                    boolean r2 = r14.hasNext()
                    if (r2 == 0) goto L_0x00b8
                    java.lang.Object r2 = r14.next()
                    com.android.billingclient.api.PurchaseHistoryRecord r2 = (com.android.billingclient.api.PurchaseHistoryRecord) r2
                    com.adapty.internal.data.models.PurchaseRecordModel r11 = new com.adapty.internal.data.models.PurchaseRecordModel
                    java.lang.String r6 = r2.getPurchaseToken()
                    java.lang.String r5 = "historyRecord.purchaseToken"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
                    long r7 = r2.getPurchaseTime()
                    java.util.List r9 = r2.getProducts()
                    java.lang.String r2 = "historyRecord.products"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
                    java.lang.String r10 = r2
                    r5 = r11
                    r5.<init>(r6, r7, r9, r10)
                    r4.add(r11)
                    goto L_0x008a
                L_0x00b8:
                    java.lang.Iterable r4 = (java.lang.Iterable) r4
                    java.util.List r14 = kotlin.collections.CollectionsKt.toList(r4)
                    r0.label = r3
                    java.lang.Object r14 = r15.emit(r14, r0)
                    if (r14 != r1) goto L_0x00c7
                    return r1
                L_0x00c7:
                    kotlin.Unit r14 = kotlin.Unit.INSTANCE
                    return r14
                */
                throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cloud.StoreManager$getPurchaseHistoryDataToRestoreForType$1$invoke$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
