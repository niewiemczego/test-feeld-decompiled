package com.adapty.internal.domain;

import com.adapty.internal.domain.models.BackendProduct;
import com.adapty.models.AdaptyPaywall;
import com.adapty.models.AdaptyPaywallProduct;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/adapty/models/AdaptyPaywallProduct;", "products", "Lcom/adapty/internal/domain/models/BackendProduct;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.ProductsInteractor$getPaywallProducts$2", f = "ProductsInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProductsInteractor.kt */
final class ProductsInteractor$getPaywallProducts$2 extends SuspendLambda implements Function2<List<? extends BackendProduct>, Continuation<? super Flow<? extends List<? extends AdaptyPaywallProduct>>>, Object> {
    final /* synthetic */ AdaptyPaywall $paywall;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProductsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductsInteractor$getPaywallProducts$2(ProductsInteractor productsInteractor, AdaptyPaywall adaptyPaywall, Continuation<? super ProductsInteractor$getPaywallProducts$2> continuation) {
        super(2, continuation);
        this.this$0 = productsInteractor;
        this.$paywall = adaptyPaywall;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProductsInteractor$getPaywallProducts$2 productsInteractor$getPaywallProducts$2 = new ProductsInteractor$getPaywallProducts$2(this.this$0, this.$paywall, continuation);
        productsInteractor$getPaywallProducts$2.L$0 = obj;
        return productsInteractor$getPaywallProducts$2;
    }

    public final Object invoke(List<BackendProduct> list, Continuation<? super Flow<? extends List<AdaptyPaywallProduct>>> continuation) {
        return ((ProductsInteractor$getPaywallProducts$2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List list = (List) this.L$0;
            return new ProductsInteractor$getPaywallProducts$2$invokeSuspend$$inlined$map$1(this.this$0.getBillingInfo(list, 3), this.this$0, list, this.$paywall);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
