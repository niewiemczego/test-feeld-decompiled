package com.adapty.internal.domain;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.PurchasesInteractor$setVariationId$1", f = "PurchasesInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PurchasesInteractor.kt */
final class PurchasesInteractor$setVariationId$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $transactionId;
    final /* synthetic */ String $variationId;
    int label;
    final /* synthetic */ PurchasesInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesInteractor$setVariationId$1(PurchasesInteractor purchasesInteractor, String str, String str2, Continuation<? super PurchasesInteractor$setVariationId$1> continuation) {
        super(1, continuation);
        this.this$0 = purchasesInteractor;
        this.$transactionId = str;
        this.$variationId = str2;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new PurchasesInteractor$setVariationId$1(this.this$0, this.$transactionId, this.$variationId, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((PurchasesInteractor$setVariationId$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.cloudRepository.setVariationId(this.$transactionId, this.$variationId);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
