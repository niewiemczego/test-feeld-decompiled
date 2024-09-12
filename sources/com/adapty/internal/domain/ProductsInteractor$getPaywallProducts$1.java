package com.adapty.internal.domain;

import com.adapty.internal.domain.models.BackendProduct;
import com.adapty.models.AdaptyPaywall;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/adapty/internal/domain/models/BackendProduct;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.ProductsInteractor$getPaywallProducts$1", f = "ProductsInteractor.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProductsInteractor.kt */
final class ProductsInteractor$getPaywallProducts$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends BackendProduct>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ AdaptyPaywall $paywall;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductsInteractor$getPaywallProducts$1(AdaptyPaywall adaptyPaywall, Continuation<? super ProductsInteractor$getPaywallProducts$1> continuation) {
        super(2, continuation);
        this.$paywall = adaptyPaywall;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProductsInteractor$getPaywallProducts$1 productsInteractor$getPaywallProducts$1 = new ProductsInteractor$getPaywallProducts$1(this.$paywall, continuation);
        productsInteractor$getPaywallProducts$1.L$0 = obj;
        return productsInteractor$getPaywallProducts$1;
    }

    public final Object invoke(FlowCollector<? super List<BackendProduct>> flowCollector, Continuation<? super Unit> continuation) {
        return ((ProductsInteractor$getPaywallProducts$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (((FlowCollector) this.L$0).emit(this.$paywall.getProducts$adapty_release(), this) == coroutine_suspended) {
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
