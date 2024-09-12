package com.adapty.internal.data.cloud;

import com.adapty.errors.AdaptyError;
import com.adapty.internal.data.cloud.AnalyticsTracker;
import com.adapty.internal.data.models.AnalyticsEvent;
import com.android.billingclient.api.BillingClientKotlinKt;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.PurchaseHistoryResult;
import com.android.billingclient.api.QueryPurchaseHistoryParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/android/billingclient/api/PurchaseHistoryRecord;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.StoreHelper$queryPurchaseHistoryForType$1", f = "StoreManager.kt", i = {0, 0, 1, 1}, l = {468, 470}, m = "invokeSuspend", n = {"$this$flow", "requestEvent", "requestEvent", "purchaseHistoryResult"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: StoreManager.kt */
final class StoreHelper$queryPurchaseHistoryForType$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends PurchaseHistoryRecord>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $type;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ StoreHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreHelper$queryPurchaseHistoryForType$1(String str, StoreHelper storeHelper, Continuation<? super StoreHelper$queryPurchaseHistoryForType$1> continuation) {
        super(2, continuation);
        this.$type = str;
        this.this$0 = storeHelper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StoreHelper$queryPurchaseHistoryForType$1 storeHelper$queryPurchaseHistoryForType$1 = new StoreHelper$queryPurchaseHistoryForType$1(this.$type, this.this$0, continuation);
        storeHelper$queryPurchaseHistoryForType$1.L$0 = obj;
        return storeHelper$queryPurchaseHistoryForType$1;
    }

    public final Object invoke(FlowCollector<? super List<? extends PurchaseHistoryRecord>> flowCollector, Continuation<? super Unit> continuation) {
        return ((StoreHelper$queryPurchaseHistoryForType$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AnalyticsEvent.GoogleAPIRequestData.QueryPurchaseHistory queryPurchaseHistory;
        PurchaseHistoryResult purchaseHistoryResult;
        FlowCollector flowCollector;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            queryPurchaseHistory = AnalyticsEvent.GoogleAPIRequestData.QueryPurchaseHistory.Companion.create(this.$type);
            AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.this$0.analyticsTracker, queryPurchaseHistory, (Function2) null, 2, (Object) null);
            QueryPurchaseHistoryParams build = QueryPurchaseHistoryParams.newBuilder().setProductType(this.$type).build();
            Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setProductType(type).build()");
            this.L$0 = flowCollector2;
            this.L$1 = queryPurchaseHistory;
            this.label = 1;
            Object queryPurchaseHistory2 = BillingClientKotlinKt.queryPurchaseHistory(this.this$0.billingClient, build, (Continuation<? super PurchaseHistoryResult>) this);
            if (queryPurchaseHistory2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj2 = queryPurchaseHistory2;
            flowCollector = flowCollector2;
            obj = obj2;
        } else if (i == 1) {
            queryPurchaseHistory = (AnalyticsEvent.GoogleAPIRequestData.QueryPurchaseHistory) this.L$1;
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            purchaseHistoryResult = (PurchaseHistoryResult) this.L$1;
            queryPurchaseHistory = (AnalyticsEvent.GoogleAPIRequestData.QueryPurchaseHistory) this.L$0;
            ResultKt.throwOnFailure(obj);
            AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.this$0.analyticsTracker, AnalyticsEvent.GoogleAPIResponseData.QueryPurchaseHistory.Companion.create((List<? extends PurchaseHistoryRecord>) purchaseHistoryResult.getPurchaseHistoryRecordList(), queryPurchaseHistory), (Function2) null, 2, (Object) null);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PurchaseHistoryResult purchaseHistoryResult2 = (PurchaseHistoryResult) obj;
        if (purchaseHistoryResult2.getBillingResult().getResponseCode() == 0) {
            List<PurchaseHistoryRecord> purchaseHistoryRecordList = purchaseHistoryResult2.getPurchaseHistoryRecordList();
            if (purchaseHistoryRecordList == null) {
                purchaseHistoryRecordList = CollectionsKt.emptyList();
            }
            this.L$0 = queryPurchaseHistory;
            this.L$1 = purchaseHistoryResult2;
            this.label = 2;
            if (flowCollector.emit(purchaseHistoryRecordList, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            purchaseHistoryResult = purchaseHistoryResult2;
            AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.this$0.analyticsTracker, AnalyticsEvent.GoogleAPIResponseData.QueryPurchaseHistory.Companion.create((List<? extends PurchaseHistoryRecord>) purchaseHistoryResult.getPurchaseHistoryRecordList(), queryPurchaseHistory), (Function2) null, 2, (Object) null);
            return Unit.INSTANCE;
        }
        AdaptyError access$createException = this.this$0.createException(purchaseHistoryResult2.getBillingResult(), "on query history");
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.this$0.analyticsTracker, AnalyticsEvent.GoogleAPIResponseData.QueryPurchaseHistory.Companion.create(access$createException, queryPurchaseHistory), (Function2) null, 2, (Object) null);
        throw access$createException;
    }
}
