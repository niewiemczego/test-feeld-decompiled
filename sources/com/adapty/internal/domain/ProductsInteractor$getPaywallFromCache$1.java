package com.adapty.internal.domain;

import com.adapty.internal.data.models.PaywallDto;
import com.adapty.models.AdaptyPaywall;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/adapty/models/AdaptyPaywall;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.ProductsInteractor$getPaywallFromCache$1", f = "ProductsInteractor.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProductsInteractor.kt */
final class ProductsInteractor$getPaywallFromCache$1 extends SuspendLambda implements Function2<FlowCollector<? super AdaptyPaywall>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ String $locale;
    final /* synthetic */ Long $maxAgeMillis;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProductsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductsInteractor$getPaywallFromCache$1(ProductsInteractor productsInteractor, String str, Long l, String str2, Continuation<? super ProductsInteractor$getPaywallFromCache$1> continuation) {
        super(2, continuation);
        this.this$0 = productsInteractor;
        this.$id = str;
        this.$maxAgeMillis = l;
        this.$locale = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProductsInteractor$getPaywallFromCache$1 productsInteractor$getPaywallFromCache$1 = new ProductsInteractor$getPaywallFromCache$1(this.this$0, this.$id, this.$maxAgeMillis, this.$locale, continuation);
        productsInteractor$getPaywallFromCache$1.L$0 = obj;
        return productsInteractor$getPaywallFromCache$1;
    }

    public final Object invoke(FlowCollector<? super AdaptyPaywall> flowCollector, Continuation<? super Unit> continuation) {
        return ((ProductsInteractor$getPaywallFromCache$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            AdaptyPaywall adaptyPaywall = null;
            PaywallDto pick = this.this$0.paywallPicker.pick(this.this$0.cacheRepository.getPaywall(this.$id, this.$maxAgeMillis), (PaywallDto) null, SetsKt.setOf(this.$locale));
            if (pick != null) {
                ProductsInteractor productsInteractor = this.this$0;
                adaptyPaywall = productsInteractor.paywallMapper.map(pick, productsInteractor.productMapper.map((List) pick.getProducts()));
            }
            this.label = 1;
            if (flowCollector.emit(adaptyPaywall, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
