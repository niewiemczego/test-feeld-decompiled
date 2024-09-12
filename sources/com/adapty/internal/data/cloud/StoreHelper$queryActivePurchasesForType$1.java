package com.adapty.internal.data.cloud;

import com.adapty.errors.AdaptyError;
import com.adapty.internal.data.cloud.AnalyticsTracker;
import com.adapty.internal.data.models.AnalyticsEvent;
import com.android.billingclient.api.BillingClientKotlinKt;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResult;
import com.android.billingclient.api.QueryPurchasesParams;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/android/billingclient/api/Purchase;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.StoreHelper$queryActivePurchasesForType$1", f = "StoreManager.kt", i = {0, 0, 1, 1}, l = {449, 451}, m = "invokeSuspend", n = {"$this$flow", "requestEvent", "requestEvent", "purchasesResult"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: StoreManager.kt */
final class StoreHelper$queryActivePurchasesForType$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends Purchase>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $type;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ StoreHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreHelper$queryActivePurchasesForType$1(String str, StoreHelper storeHelper, Continuation<? super StoreHelper$queryActivePurchasesForType$1> continuation) {
        super(2, continuation);
        this.$type = str;
        this.this$0 = storeHelper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StoreHelper$queryActivePurchasesForType$1 storeHelper$queryActivePurchasesForType$1 = new StoreHelper$queryActivePurchasesForType$1(this.$type, this.this$0, continuation);
        storeHelper$queryActivePurchasesForType$1.L$0 = obj;
        return storeHelper$queryActivePurchasesForType$1;
    }

    public final Object invoke(FlowCollector<? super List<? extends Purchase>> flowCollector, Continuation<? super Unit> continuation) {
        return ((StoreHelper$queryActivePurchasesForType$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AnalyticsEvent.GoogleAPIRequestData.QueryActivePurchases queryActivePurchases;
        PurchasesResult purchasesResult;
        FlowCollector flowCollector;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            queryActivePurchases = AnalyticsEvent.GoogleAPIRequestData.QueryActivePurchases.Companion.create(this.$type);
            AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.this$0.analyticsTracker, queryActivePurchases, (Function2) null, 2, (Object) null);
            QueryPurchasesParams build = QueryPurchasesParams.newBuilder().setProductType(this.$type).build();
            Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setProductType(type).build()");
            this.L$0 = flowCollector2;
            this.L$1 = queryActivePurchases;
            this.label = 1;
            Object queryPurchasesAsync = BillingClientKotlinKt.queryPurchasesAsync(this.this$0.billingClient, build, (Continuation<? super PurchasesResult>) this);
            if (queryPurchasesAsync == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj2 = queryPurchasesAsync;
            flowCollector = flowCollector2;
            obj = obj2;
        } else if (i == 1) {
            queryActivePurchases = (AnalyticsEvent.GoogleAPIRequestData.QueryActivePurchases) this.L$1;
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            purchasesResult = (PurchasesResult) this.L$1;
            queryActivePurchases = (AnalyticsEvent.GoogleAPIRequestData.QueryActivePurchases) this.L$0;
            ResultKt.throwOnFailure(obj);
            AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.this$0.analyticsTracker, AnalyticsEvent.GoogleAPIResponseData.QueryActivePurchases.Companion.create((List<? extends Purchase>) purchasesResult.getPurchasesList(), queryActivePurchases), (Function2) null, 2, (Object) null);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PurchasesResult purchasesResult2 = (PurchasesResult) obj;
        if (purchasesResult2.getBillingResult().getResponseCode() == 0) {
            this.L$0 = queryActivePurchases;
            this.L$1 = purchasesResult2;
            this.label = 2;
            if (flowCollector.emit(purchasesResult2.getPurchasesList(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            purchasesResult = purchasesResult2;
            AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.this$0.analyticsTracker, AnalyticsEvent.GoogleAPIResponseData.QueryActivePurchases.Companion.create((List<? extends Purchase>) purchasesResult.getPurchasesList(), queryActivePurchases), (Function2) null, 2, (Object) null);
            return Unit.INSTANCE;
        }
        AdaptyError access$createException = this.this$0.createException(purchasesResult2.getBillingResult(), "on query active purchases");
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.this$0.analyticsTracker, AnalyticsEvent.GoogleAPIResponseData.QueryActivePurchases.Companion.create(access$createException, queryActivePurchases), (Function2) null, 2, (Object) null);
        throw access$createException;
    }
}
