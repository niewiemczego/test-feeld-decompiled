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
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/adapty/models/AdaptyProfile;", "error", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.PurchasesInteractor$syncPurchasesOnStart$3", f = "PurchasesInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PurchasesInteractor.kt */
final class PurchasesInteractor$syncPurchasesOnStart$3 extends SuspendLambda implements Function3<FlowCollector<? super AdaptyProfile>, Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PurchasesInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesInteractor$syncPurchasesOnStart$3(PurchasesInteractor purchasesInteractor, Continuation<? super PurchasesInteractor$syncPurchasesOnStart$3> continuation) {
        super(3, continuation);
        this.this$0 = purchasesInteractor;
    }

    public final Object invoke(FlowCollector<? super AdaptyProfile> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        PurchasesInteractor$syncPurchasesOnStart$3 purchasesInteractor$syncPurchasesOnStart$3 = new PurchasesInteractor$syncPurchasesOnStart$3(this.this$0, continuation);
        purchasesInteractor$syncPurchasesOnStart$3.L$0 = th;
        return purchasesInteractor$syncPurchasesOnStart$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Throwable th = (Throwable) this.L$0;
        UtilsKt.releaseQuietly(this.this$0.syncPurchasesSemaphore);
        throw th;
    }
}
