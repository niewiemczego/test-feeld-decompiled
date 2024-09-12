package com.adapty.internal.domain;

import com.adapty.models.AdaptyPaywall;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Lcom/adapty/models/AdaptyPaywall;", "paywall"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.ProductsInteractor$getPaywall$1", f = "ProductsInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProductsInteractor.kt */
final class ProductsInteractor$getPaywall$1 extends SuspendLambda implements Function2<AdaptyPaywall, Continuation<? super Flow<? extends AdaptyPaywall>>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ int $loadTimeout;
    final /* synthetic */ String $locale;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProductsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductsInteractor$getPaywall$1(ProductsInteractor productsInteractor, String str, String str2, int i, Continuation<? super ProductsInteractor$getPaywall$1> continuation) {
        super(2, continuation);
        this.this$0 = productsInteractor;
        this.$id = str;
        this.$locale = str2;
        this.$loadTimeout = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProductsInteractor$getPaywall$1 productsInteractor$getPaywall$1 = new ProductsInteractor$getPaywall$1(this.this$0, this.$id, this.$locale, this.$loadTimeout, continuation);
        productsInteractor$getPaywall$1.L$0 = obj;
        return productsInteractor$getPaywall$1;
    }

    public final Object invoke(AdaptyPaywall adaptyPaywall, Continuation<? super Flow<AdaptyPaywall>> continuation) {
        return ((ProductsInteractor$getPaywall$1) create(adaptyPaywall, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AdaptyPaywall adaptyPaywall = (AdaptyPaywall) this.L$0;
            if (adaptyPaywall != null) {
                return FlowKt.flowOf(adaptyPaywall);
            }
            return this.this$0.getPaywallFromCloud(this.$id, this.$locale, this.$loadTimeout);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
