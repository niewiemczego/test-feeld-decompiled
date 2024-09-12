package com.adapty.internal.domain;

import com.adapty.internal.data.models.ViewConfigurationDto;
import com.adapty.models.AdaptyPaywall;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", "Lcom/adapty/internal/data/models/ViewConfigurationDto;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.ProductsInteractor$getViewConfiguration$baseFlow$1", f = "ProductsInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProductsInteractor.kt */
final class ProductsInteractor$getViewConfiguration$baseFlow$1 extends SuspendLambda implements Function1<Continuation<? super ViewConfigurationDto>, Object> {
    final /* synthetic */ String $locale;
    final /* synthetic */ AdaptyPaywall $paywall;
    int label;
    final /* synthetic */ ProductsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductsInteractor$getViewConfiguration$baseFlow$1(ProductsInteractor productsInteractor, AdaptyPaywall adaptyPaywall, String str, Continuation<? super ProductsInteractor$getViewConfiguration$baseFlow$1> continuation) {
        super(1, continuation);
        this.this$0 = productsInteractor;
        this.$paywall = adaptyPaywall;
        this.$locale = str;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ProductsInteractor$getViewConfiguration$baseFlow$1(this.this$0, this.$paywall, this.$locale, continuation);
    }

    public final Object invoke(Continuation<? super ViewConfigurationDto> continuation) {
        return ((ProductsInteractor$getViewConfiguration$baseFlow$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.cloudRepository.getViewConfiguration(this.$paywall.getVariationId(), this.$locale);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
