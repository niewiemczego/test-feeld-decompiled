package com.adapty.internal.domain;

import com.android.billingclient.api.ProductDetails;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class ProductsInteractor$getBillingInfo$$inlined$map$1 implements Flow<Map<String, ? extends ProductDetails>> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ ProductsInteractor this$0;

    public ProductsInteractor$getBillingInfo$$inlined$map$1(Flow flow, ProductsInteractor productsInteractor) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = productsInteractor;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final ProductsInteractor productsInteractor = this.this$0;
        Object collect = flow.collect(new Object() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof com.adapty.internal.domain.ProductsInteractor$getBillingInfo$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r9
                    com.adapty.internal.domain.ProductsInteractor$getBillingInfo$$inlined$map$1$2$1 r0 = (com.adapty.internal.domain.ProductsInteractor$getBillingInfo$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r9 = r0.label
                    int r9 = r9 - r2
                    r0.label = r9
                    goto L_0x0019
                L_0x0014:
                    com.adapty.internal.domain.ProductsInteractor$getBillingInfo$$inlined$map$1$2$1 r0 = new com.adapty.internal.domain.ProductsInteractor$getBillingInfo$$inlined$map$1$2$1
                    r0.<init>(r7, r9)
                L_0x0019:
                    java.lang.Object r9 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0032
                    if (r2 != r3) goto L_0x002a
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L_0x0082
                L_0x002a:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L_0x0032:
                    kotlin.ResultKt.throwOnFailure(r9)
                    kotlinx.coroutines.flow.FlowCollector r9 = r4
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    java.util.List r8 = (java.util.List) r8
                    boolean r2 = r8.isEmpty()
                    if (r2 != 0) goto L_0x0085
                    java.lang.Iterable r8 = (java.lang.Iterable) r8
                    r2 = 10
                    int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r2)
                    int r2 = kotlin.collections.MapsKt.mapCapacity(r2)
                    r4 = 16
                    int r2 = kotlin.ranges.RangesKt.coerceAtLeast((int) r2, (int) r4)
                    java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
                    r4.<init>(r2)
                    java.util.Map r4 = (java.util.Map) r4
                    java.util.Iterator r8 = r8.iterator()
                L_0x005f:
                    boolean r2 = r8.hasNext()
                    if (r2 == 0) goto L_0x0079
                    java.lang.Object r2 = r8.next()
                    r5 = r2
                    com.android.billingclient.api.ProductDetails r5 = (com.android.billingclient.api.ProductDetails) r5
                    java.lang.String r5 = r5.getProductId()
                    java.lang.String r6 = "productDetails.productId"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
                    r4.put(r5, r2)
                    goto L_0x005f
                L_0x0079:
                    r0.label = r3
                    java.lang.Object r8 = r9.emit(r4, r0)
                    if (r8 != r1) goto L_0x0082
                    return r1
                L_0x0082:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                L_0x0085:
                    com.adapty.internal.domain.ProductsInteractor r8 = r2
                    java.lang.Void unused = r8.throwNoProductIdsFoundError()
                    kotlin.KotlinNothingValueException r8 = new kotlin.KotlinNothingValueException
                    r8.<init>()
                    throw r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.domain.ProductsInteractor$getBillingInfo$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
