package com.adapty.internal.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.ProductsInteractor$getProductsOnStart$1", f = "ProductsInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProductsInteractor.kt */
final class ProductsInteractor$getProductsOnStart$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super List<? extends String>>, Object> {
    int label;
    final /* synthetic */ ProductsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductsInteractor$getProductsOnStart$1(ProductsInteractor productsInteractor, Continuation<? super ProductsInteractor$getProductsOnStart$1> continuation) {
        super(2, continuation);
        this.this$0 = productsInteractor;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductsInteractor$getProductsOnStart$1(this.this$0, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation<? super List<String>>) (Continuation) obj2);
    }

    public final Object invoke(boolean z, Continuation<? super List<String>> continuation) {
        return ((ProductsInteractor$getProductsOnStart$1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.cloudRepository.getProductIds();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
