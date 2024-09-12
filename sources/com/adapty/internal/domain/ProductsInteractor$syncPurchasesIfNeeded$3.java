package com.adapty.internal.domain;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.ProductsInteractor$syncPurchasesIfNeeded$3", f = "ProductsInteractor.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProductsInteractor.kt */
final class ProductsInteractor$syncPurchasesIfNeeded$3 extends SuspendLambda implements Function3<FlowCollector<? super Boolean>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    ProductsInteractor$syncPurchasesIfNeeded$3(Continuation<? super ProductsInteractor$syncPurchasesIfNeeded$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(FlowCollector<? super Boolean> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        ProductsInteractor$syncPurchasesIfNeeded$3 productsInteractor$syncPurchasesIfNeeded$3 = new ProductsInteractor$syncPurchasesIfNeeded$3(continuation);
        productsInteractor$syncPurchasesIfNeeded$3.L$0 = flowCollector;
        return productsInteractor$syncPurchasesIfNeeded$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (((FlowCollector) this.L$0).emit(Boxing.boxBoolean(false), this) == coroutine_suspended) {
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
