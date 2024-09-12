package com.adapty.internal.domain;

import com.adapty.internal.data.models.PaywallDto;
import com.adapty.internal.domain.models.BackendProduct;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class ProductsInteractor$getPaywallFromCloud$baseFlow$2$invokeSuspend$$inlined$map$1 implements Flow<Pair<? extends PaywallDto, ? extends List<? extends BackendProduct>>> {
    final /* synthetic */ String $id$inlined;
    final /* synthetic */ String $locale$inlined;
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ ProductsInteractor this$0;

    public ProductsInteractor$getPaywallFromCloud$baseFlow$2$invokeSuspend$$inlined$map$1(Flow flow, ProductsInteractor productsInteractor, String str, String str2) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = productsInteractor;
        this.$id$inlined = str;
        this.$locale$inlined = str2;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final ProductsInteractor productsInteractor = this.this$0;
        final String str = this.$id$inlined;
        final String str2 = this.$locale$inlined;
        Object collect = flow.collect(new Object() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof com.adapty.internal.domain.ProductsInteractor$getPaywallFromCloud$baseFlow$2$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r8
                    com.adapty.internal.domain.ProductsInteractor$getPaywallFromCloud$baseFlow$2$invokeSuspend$$inlined$map$1$2$1 r0 = (com.adapty.internal.domain.ProductsInteractor$getPaywallFromCloud$baseFlow$2$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r8 = r0.label
                    int r8 = r8 - r2
                    r0.label = r8
                    goto L_0x0019
                L_0x0014:
                    com.adapty.internal.domain.ProductsInteractor$getPaywallFromCloud$baseFlow$2$invokeSuspend$$inlined$map$1$2$1 r0 = new com.adapty.internal.domain.ProductsInteractor$getPaywallFromCloud$baseFlow$2$invokeSuspend$$inlined$map$1$2$1
                    r0.<init>(r6, r8)
                L_0x0019:
                    java.lang.Object r8 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0033
                    if (r2 != r3) goto L_0x002b
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L_0x00a3
                L_0x002b:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L_0x0033:
                    kotlin.ResultKt.throwOnFailure(r8)
                    kotlinx.coroutines.flow.FlowCollector r8 = r6
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    java.lang.Boolean r7 = (java.lang.Boolean) r7
                    r7.booleanValue()
                    com.adapty.internal.domain.ProductsInteractor r7 = r2
                    com.adapty.internal.data.cache.CacheRepository r7 = r7.cacheRepository
                    com.adapty.internal.data.models.ProfileDto r7 = r7.getProfile()
                    if (r7 == 0) goto L_0x0052
                    java.lang.String r7 = r7.getSegmentId()
                    if (r7 != 0) goto L_0x0068
                L_0x0052:
                    com.adapty.internal.domain.ProductsInteractor r7 = r2
                    com.adapty.internal.data.cloud.CloudRepository r7 = r7.cloudRepository
                    kotlin.Pair r7 = r7.getProfile()
                    java.lang.Object r7 = r7.getFirst()
                    com.adapty.internal.data.models.ProfileDto r7 = (com.adapty.internal.data.models.ProfileDto) r7
                    java.lang.String r7 = r7.getSegmentId()
                    if (r7 == 0) goto L_0x00a6
                L_0x0068:
                    com.adapty.internal.domain.ProductsInteractor r2 = r2
                    com.adapty.internal.data.cloud.CloudRepository r2 = r2.cloudRepository
                    java.lang.String r4 = r3
                    java.lang.String r5 = r4
                    if (r5 == 0) goto L_0x0075
                    goto L_0x0077
                L_0x0075:
                    java.lang.String r5 = "en"
                L_0x0077:
                    com.adapty.internal.data.models.PaywallDto r7 = r2.getPaywall(r4, r5, r7)
                    com.adapty.internal.domain.ProductsInteractor r2 = r2
                    com.adapty.internal.data.cache.CacheRepository r2 = r2.cacheRepository
                    java.lang.String r4 = r3
                    r2.savePaywall(r4, r7)
                    com.adapty.internal.domain.ProductsInteractor r2 = r2
                    com.adapty.internal.utils.ProductMapper r2 = r2.productMapper
                    java.util.ArrayList r4 = r7.getProducts()
                    java.util.List r4 = (java.util.List) r4
                    java.util.List r2 = r2.map((java.util.List) r4)
                    kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r2)
                    r0.label = r3
                    java.lang.Object r7 = r8.emit(r7, r0)
                    if (r7 != r1) goto L_0x00a3
                    return r1
                L_0x00a3:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                L_0x00a6:
                    com.adapty.errors.AdaptyError r7 = new com.adapty.errors.AdaptyError
                    r1 = 0
                    com.adapty.errors.AdaptyErrorCode r3 = com.adapty.errors.AdaptyErrorCode.DECODING_FAILED
                    r4 = 1
                    r5 = 0
                    java.lang.String r2 = "segmentId in Profile should not be null"
                    r0 = r7
                    r0.<init>(r1, r2, r3, r4, r5)
                    throw r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.domain.ProductsInteractor$getPaywallFromCloud$baseFlow$2$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
