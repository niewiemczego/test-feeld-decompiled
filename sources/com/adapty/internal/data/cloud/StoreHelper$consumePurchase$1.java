package com.adapty.internal.data.cloud;

import com.adapty.errors.AdaptyError;
import com.adapty.internal.data.cloud.AnalyticsTracker;
import com.adapty.internal.data.models.AnalyticsEvent;
import com.android.billingclient.api.BillingClientKotlinKt;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResult;
import com.android.billingclient.api.Purchase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.StoreHelper$consumePurchase$1", f = "StoreManager.kt", i = {0, 0, 1}, l = {523, 525}, m = "invokeSuspend", n = {"$this$flow", "requestEvent", "requestEvent"}, s = {"L$0", "L$1", "L$0"})
/* compiled from: StoreManager.kt */
final class StoreHelper$consumePurchase$1 extends SuspendLambda implements Function2<FlowCollector<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Purchase $purchase;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ StoreHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreHelper$consumePurchase$1(Purchase purchase, StoreHelper storeHelper, Continuation<? super StoreHelper$consumePurchase$1> continuation) {
        super(2, continuation);
        this.$purchase = purchase;
        this.this$0 = storeHelper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StoreHelper$consumePurchase$1 storeHelper$consumePurchase$1 = new StoreHelper$consumePurchase$1(this.$purchase, this.this$0, continuation);
        storeHelper$consumePurchase$1.L$0 = obj;
        return storeHelper$consumePurchase$1;
    }

    public final Object invoke(FlowCollector<? super Unit> flowCollector, Continuation<? super Unit> continuation) {
        return ((StoreHelper$consumePurchase$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AnalyticsEvent.GoogleAPIRequestData.ConsumePurchase consumePurchase;
        FlowCollector flowCollector;
        AnalyticsEvent.GoogleAPIRequestData.ConsumePurchase consumePurchase2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            consumePurchase2 = AnalyticsEvent.GoogleAPIRequestData.ConsumePurchase.Companion.create(this.$purchase);
            AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.this$0.analyticsTracker, consumePurchase2, (Function2) null, 2, (Object) null);
            ConsumeParams build = ConsumeParams.newBuilder().setPurchaseToken(this.$purchase.getPurchaseToken()).build();
            Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …\n                .build()");
            this.L$0 = flowCollector2;
            this.L$1 = consumePurchase2;
            this.label = 1;
            Object consumePurchase3 = BillingClientKotlinKt.consumePurchase(this.this$0.billingClient, build, this);
            if (consumePurchase3 == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj2 = consumePurchase3;
            flowCollector = flowCollector2;
            obj = obj2;
        } else if (i == 1) {
            consumePurchase2 = (AnalyticsEvent.GoogleAPIRequestData.ConsumePurchase) this.L$1;
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            consumePurchase = (AnalyticsEvent.GoogleAPIRequestData.ConsumePurchase) this.L$0;
            ResultKt.throwOnFailure(obj);
            AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.this$0.analyticsTracker, AnalyticsEvent.GoogleAPIResponseData.Companion.create$default(AnalyticsEvent.GoogleAPIResponseData.Companion, consumePurchase, (AdaptyError) null, 2, (Object) null), (Function2) null, 2, (Object) null);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BillingResult billingResult = ((ConsumeResult) obj).getBillingResult();
        if (billingResult.getResponseCode() == 0) {
            this.L$0 = consumePurchase2;
            this.L$1 = null;
            this.label = 2;
            if (flowCollector.emit(Unit.INSTANCE, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            consumePurchase = consumePurchase2;
            AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.this$0.analyticsTracker, AnalyticsEvent.GoogleAPIResponseData.Companion.create$default(AnalyticsEvent.GoogleAPIResponseData.Companion, consumePurchase, (AdaptyError) null, 2, (Object) null), (Function2) null, 2, (Object) null);
            return Unit.INSTANCE;
        }
        AdaptyError access$createException = this.this$0.createException(billingResult, "on consume");
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.this$0.analyticsTracker, AnalyticsEvent.GoogleAPIResponseData.Companion.create(consumePurchase2, access$createException), (Function2) null, 2, (Object) null);
        throw access$createException;
    }
}
