package com.adapty.internal.data.cloud;

import com.android.billingclient.api.Purchase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class StoreManager$findActivePurchaseForProduct$$inlined$map$1 implements Flow<Purchase> {
    final /* synthetic */ String $productId$inlined;
    final /* synthetic */ Flow $this_unsafeTransform$inlined;

    public StoreManager$findActivePurchaseForProduct$$inlined$map$1(Flow flow, String str) {
        this.$this_unsafeTransform$inlined = flow;
        this.$productId$inlined = str;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final String str = this.$productId$inlined;
        Object collect = flow.collect(new Object() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
            /* JADX WARNING: Removed duplicated region for block: B:29:0x0071 A[EDGE_INSN: B:29:0x0071->B:23:0x0071 ?: BREAK  , SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof com.adapty.internal.data.cloud.StoreManager$findActivePurchaseForProduct$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r8
                    com.adapty.internal.data.cloud.StoreManager$findActivePurchaseForProduct$$inlined$map$1$2$1 r0 = (com.adapty.internal.data.cloud.StoreManager$findActivePurchaseForProduct$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r8 = r0.label
                    int r8 = r8 - r2
                    r0.label = r8
                    goto L_0x0019
                L_0x0014:
                    com.adapty.internal.data.cloud.StoreManager$findActivePurchaseForProduct$$inlined$map$1$2$1 r0 = new com.adapty.internal.data.cloud.StoreManager$findActivePurchaseForProduct$$inlined$map$1$2$1
                    r0.<init>(r6, r8)
                L_0x0019:
                    java.lang.Object r8 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0032
                    if (r2 != r3) goto L_0x002a
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L_0x007a
                L_0x002a:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L_0x0032:
                    kotlin.ResultKt.throwOnFailure(r8)
                    kotlinx.coroutines.flow.FlowCollector r8 = r4
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    java.util.List r7 = (java.util.List) r7
                    java.lang.Iterable r7 = (java.lang.Iterable) r7
                    java.util.Iterator r7 = r7.iterator()
                L_0x0042:
                    boolean r2 = r7.hasNext()
                    if (r2 == 0) goto L_0x0070
                    java.lang.Object r2 = r7.next()
                    r4 = r2
                    com.android.billingclient.api.Purchase r4 = (com.android.billingclient.api.Purchase) r4
                    int r5 = r4.getPurchaseState()
                    if (r5 != r3) goto L_0x006c
                    java.util.List r4 = r4.getProducts()
                    java.lang.String r5 = "it.products"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
                    java.lang.Object r4 = kotlin.collections.CollectionsKt.firstOrNull(r4)
                    java.lang.String r5 = r2
                    boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
                    if (r4 == 0) goto L_0x006c
                    r4 = r3
                    goto L_0x006d
                L_0x006c:
                    r4 = 0
                L_0x006d:
                    if (r4 == 0) goto L_0x0042
                    goto L_0x0071
                L_0x0070:
                    r2 = 0
                L_0x0071:
                    r0.label = r3
                    java.lang.Object r7 = r8.emit(r2, r0)
                    if (r7 != r1) goto L_0x007a
                    return r1
                L_0x007a:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cloud.StoreManager$findActivePurchaseForProduct$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
