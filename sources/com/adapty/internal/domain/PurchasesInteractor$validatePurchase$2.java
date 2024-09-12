package com.adapty.internal.domain;

import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.internal.data.cloud.Request;
import com.adapty.internal.data.models.ProfileDto;
import com.adapty.internal.domain.models.PurchaseableProduct;
import com.android.billingclient.api.Purchase;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0007H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;", "Lcom/adapty/internal/data/models/ProfileDto;", "Lcom/adapty/internal/data/cloud/Request$CurrentDataWhenSent;", "e", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.PurchasesInteractor$validatePurchase$2", f = "PurchasesInteractor.kt", i = {0}, l = {107}, m = "invokeSuspend", n = {"e"}, s = {"L$0"})
/* compiled from: PurchasesInteractor.kt */
final class PurchasesInteractor$validatePurchase$2 extends SuspendLambda implements Function3<FlowCollector<? super Pair<? extends ProfileDto, ? extends Request.CurrentDataWhenSent>>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ PurchaseableProduct $product;
    final /* synthetic */ Purchase $purchase;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PurchasesInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesInteractor$validatePurchase$2(PurchasesInteractor purchasesInteractor, Purchase purchase, PurchaseableProduct purchaseableProduct, Continuation<? super PurchasesInteractor$validatePurchase$2> continuation) {
        super(3, continuation);
        this.this$0 = purchasesInteractor;
        this.$purchase = purchase;
        this.$product = purchaseableProduct;
    }

    public final Object invoke(FlowCollector<? super Pair<ProfileDto, Request.CurrentDataWhenSent>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        PurchasesInteractor$validatePurchase$2 purchasesInteractor$validatePurchase$2 = new PurchasesInteractor$validatePurchase$2(this.this$0, this.$purchase, this.$product, continuation);
        purchasesInteractor$validatePurchase$2.L$0 = th;
        return purchasesInteractor$validatePurchase$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Throwable th;
        Throwable th2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            th = (Throwable) this.L$0;
            if (th instanceof AdaptyError) {
                if (CollectionsKt.listOf(AdaptyErrorCode.BAD_REQUEST, AdaptyErrorCode.SERVER_ERROR).contains(((AdaptyError) th).getAdaptyErrorCode())) {
                    this.L$0 = th;
                    this.label = 1;
                    if (FlowKt.collect(FlowKt.m2547catch(this.this$0.storeManager.acknowledgeOrConsume(this.$purchase, this.$product), new AnonymousClass1((Continuation<? super AnonymousClass1>) null)), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    th2 = th;
                }
            }
            throw th;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            th2 = (Throwable) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        th = th2;
        throw th;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.adapty.internal.domain.PurchasesInteractor$validatePurchase$2$1", f = "PurchasesInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.adapty.internal.domain.PurchasesInteractor$validatePurchase$2$1  reason: invalid class name */
    /* compiled from: PurchasesInteractor.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super Unit>, Throwable, Continuation<? super Unit>, Object> {
        int label;

        public final Object invoke(FlowCollector<? super Unit> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return new AnonymousClass1(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
