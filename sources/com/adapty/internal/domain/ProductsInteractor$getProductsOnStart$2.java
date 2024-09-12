package com.adapty.internal.domain;

import com.android.billingclient.api.ProductDetails;
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

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/android/billingclient/api/ProductDetails;", "productIds", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.ProductsInteractor$getProductsOnStart$2", f = "ProductsInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProductsInteractor.kt */
final class ProductsInteractor$getProductsOnStart$2 extends SuspendLambda implements Function2<List<? extends String>, Continuation<? super Flow<? extends List<? extends ProductDetails>>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProductsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductsInteractor$getProductsOnStart$2(ProductsInteractor productsInteractor, Continuation<? super ProductsInteractor$getProductsOnStart$2> continuation) {
        super(2, continuation);
        this.this$0 = productsInteractor;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProductsInteractor$getProductsOnStart$2 productsInteractor$getProductsOnStart$2 = new ProductsInteractor$getProductsOnStart$2(this.this$0, continuation);
        productsInteractor$getProductsOnStart$2.L$0 = obj;
        return productsInteractor$getProductsOnStart$2;
    }

    public final Object invoke(List<String> list, Continuation<? super Flow<? extends List<ProductDetails>>> continuation) {
        return ((ProductsInteractor$getProductsOnStart$2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.storeManager.queryProductDetails((List) this.L$0, -1);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
