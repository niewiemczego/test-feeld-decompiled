package com.adapty.internal.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.ProductsInteractor", f = "ProductsInteractor.kt", i = {}, l = {195}, m = "syncPurchasesIfNeeded", n = {}, s = {})
/* compiled from: ProductsInteractor.kt */
final class ProductsInteractor$syncPurchasesIfNeeded$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProductsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductsInteractor$syncPurchasesIfNeeded$1(ProductsInteractor productsInteractor, Continuation<? super ProductsInteractor$syncPurchasesIfNeeded$1> continuation) {
        super(continuation);
        this.this$0 = productsInteractor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.syncPurchasesIfNeeded(this);
    }
}
