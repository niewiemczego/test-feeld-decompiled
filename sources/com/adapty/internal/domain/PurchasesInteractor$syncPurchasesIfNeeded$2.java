package com.adapty.internal.domain;

import com.adapty.internal.utils.UtilsKt;
import com.adapty.models.AdaptyProfile;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "it", "Lcom/adapty/models/AdaptyProfile;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.PurchasesInteractor$syncPurchasesIfNeeded$2", f = "PurchasesInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PurchasesInteractor.kt */
final class PurchasesInteractor$syncPurchasesIfNeeded$2 extends SuspendLambda implements Function2<AdaptyProfile, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PurchasesInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesInteractor$syncPurchasesIfNeeded$2(PurchasesInteractor purchasesInteractor, Continuation<? super PurchasesInteractor$syncPurchasesIfNeeded$2> continuation) {
        super(2, continuation);
        this.this$0 = purchasesInteractor;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PurchasesInteractor$syncPurchasesIfNeeded$2(this.this$0, continuation);
    }

    public final Object invoke(AdaptyProfile adaptyProfile, Continuation<? super Unit> continuation) {
        return ((PurchasesInteractor$syncPurchasesIfNeeded$2) create(adaptyProfile, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            UtilsKt.releaseQuietly(this.this$0.syncPurchasesSemaphore);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
