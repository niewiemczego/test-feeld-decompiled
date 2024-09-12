package com.adapty.internal;

import android.app.Activity;
import com.adapty.internal.data.cloud.AnalyticsTracker;
import com.adapty.internal.data.models.AnalyticsEvent;
import com.adapty.internal.utils.UtilsKt;
import com.adapty.models.AdaptyPaywallProduct;
import com.adapty.models.AdaptyPurchasedInfo;
import com.adapty.models.AdaptySubscriptionUpdateParameters;
import com.adapty.utils.AdaptyResult;
import com.adapty.utils.ResultCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.AdaptyInternal$makePurchase$1", f = "AdaptyInternal.kt", i = {}, l = {192}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AdaptyInternal.kt */
final class AdaptyInternal$makePurchase$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ ResultCallback<AdaptyPurchasedInfo> $callback;
    final /* synthetic */ boolean $isOfferPersonalized;
    final /* synthetic */ AdaptyPaywallProduct $product;
    final /* synthetic */ AnalyticsEvent.SDKMethodRequestData.MakePurchase $requestEvent;
    final /* synthetic */ AdaptySubscriptionUpdateParameters $subscriptionUpdateParams;
    int label;
    final /* synthetic */ AdaptyInternal this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdaptyInternal$makePurchase$1(AdaptyInternal adaptyInternal, Activity activity, AdaptyPaywallProduct adaptyPaywallProduct, AdaptySubscriptionUpdateParameters adaptySubscriptionUpdateParameters, boolean z, AnalyticsEvent.SDKMethodRequestData.MakePurchase makePurchase, ResultCallback<AdaptyPurchasedInfo> resultCallback, Continuation<? super AdaptyInternal$makePurchase$1> continuation) {
        super(2, continuation);
        this.this$0 = adaptyInternal;
        this.$activity = activity;
        this.$product = adaptyPaywallProduct;
        this.$subscriptionUpdateParams = adaptySubscriptionUpdateParameters;
        this.$isOfferPersonalized = z;
        this.$requestEvent = makePurchase;
        this.$callback = resultCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdaptyInternal$makePurchase$1(this.this$0, this.$activity, this.$product, this.$subscriptionUpdateParams, this.$isOfferPersonalized, this.$requestEvent, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdaptyInternal$makePurchase$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow makePurchase = this.this$0.purchasesInteractor.makePurchase(this.$activity, this.$product, this.$subscriptionUpdateParams, this.$isOfferPersonalized);
            final AdaptyInternal adaptyInternal = this.this$0;
            final AnalyticsEvent.SDKMethodRequestData.MakePurchase makePurchase2 = this.$requestEvent;
            final ResultCallback<AdaptyPurchasedInfo> resultCallback = this.$callback;
            this.label = 1;
            if (FlowKt.collect(Intrinsics.checkNotNullParameter(UtilsKt.onSingleResult(makePurchase, new AnonymousClass1((Continuation<? super AnonymousClass1>) null)), "<this>"), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H@"}, d2 = {"<anonymous>", "", "result", "Lcom/adapty/utils/AdaptyResult;", "Lcom/adapty/models/AdaptyPurchasedInfo;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.adapty.internal.AdaptyInternal$makePurchase$1$1", f = "AdaptyInternal.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.adapty.internal.AdaptyInternal$makePurchase$1$1  reason: invalid class name */
    /* compiled from: AdaptyInternal.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<AdaptyResult<? extends AdaptyPurchasedInfo>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(adaptyInternal, makePurchase2, resultCallback, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AdaptyResult<AdaptyPurchasedInfo> adaptyResult, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(adaptyResult, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AdaptyResult adaptyResult = (AdaptyResult) this.L$0;
                AnalyticsTracker.DefaultImpls.trackSystemEvent$default(adaptyInternal.analyticsTracker, AnalyticsEvent.SDKMethodResponseData.Companion.create(makePurchase2, UtilsKt.errorOrNull(adaptyResult)), (Function2) null, 2, (Object) null);
                resultCallback.onResult(adaptyResult);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
