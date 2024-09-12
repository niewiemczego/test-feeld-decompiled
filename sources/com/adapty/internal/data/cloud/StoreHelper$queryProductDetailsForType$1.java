package com.adapty.internal.data.cloud;

import com.adapty.errors.AdaptyError;
import com.adapty.internal.data.cloud.AnalyticsTracker;
import com.adapty.internal.data.models.AnalyticsEvent;
import com.android.billingclient.api.BillingClientKotlinKt;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResult;
import com.android.billingclient.api.QueryProductDetailsParams;
import java.util.ArrayList;
import java.util.Collection;
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

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/android/billingclient/api/ProductDetails;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.StoreHelper$queryProductDetailsForType$1", f = "StoreManager.kt", i = {0, 0, 1, 1}, l = {428, 430}, m = "invokeSuspend", n = {"$this$flow", "requestEvent", "requestEvent", "productDetailsResult"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: StoreManager.kt */
final class StoreHelper$queryProductDetailsForType$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends ProductDetails>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $productList;
    final /* synthetic */ String $productType;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ StoreHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreHelper$queryProductDetailsForType$1(List<String> list, String str, StoreHelper storeHelper, Continuation<? super StoreHelper$queryProductDetailsForType$1> continuation) {
        super(2, continuation);
        this.$productList = list;
        this.$productType = str;
        this.this$0 = storeHelper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StoreHelper$queryProductDetailsForType$1 storeHelper$queryProductDetailsForType$1 = new StoreHelper$queryProductDetailsForType$1(this.$productList, this.$productType, this.this$0, continuation);
        storeHelper$queryProductDetailsForType$1.L$0 = obj;
        return storeHelper$queryProductDetailsForType$1;
    }

    public final Object invoke(FlowCollector<? super List<ProductDetails>> flowCollector, Continuation<? super Unit> continuation) {
        return ((StoreHelper$queryProductDetailsForType$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AnalyticsEvent.GoogleAPIRequestData.QueryProductDetails queryProductDetails;
        ProductDetailsResult productDetailsResult;
        FlowCollector flowCollector;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            queryProductDetails = AnalyticsEvent.GoogleAPIRequestData.QueryProductDetails.Companion.create(this.$productList, this.$productType);
            AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.this$0.analyticsTracker, queryProductDetails, (Function2) null, 2, (Object) null);
            QueryProductDetailsParams.Builder newBuilder = QueryProductDetailsParams.newBuilder();
            Iterable<String> iterable = this.$productList;
            String str = this.$productType;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (String productId : iterable) {
                arrayList.add(QueryProductDetailsParams.Product.newBuilder().setProductId(productId).setProductType(str).build());
            }
            QueryProductDetailsParams build = newBuilder.setProductList((List) arrayList).build();
            Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setProductL…  }\n            ).build()");
            this.L$0 = flowCollector2;
            this.L$1 = queryProductDetails;
            this.label = 1;
            Object queryProductDetails2 = BillingClientKotlinKt.queryProductDetails(this.this$0.billingClient, build, this);
            if (queryProductDetails2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj2 = queryProductDetails2;
            flowCollector = flowCollector2;
            obj = obj2;
        } else if (i == 1) {
            queryProductDetails = (AnalyticsEvent.GoogleAPIRequestData.QueryProductDetails) this.L$1;
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            productDetailsResult = (ProductDetailsResult) this.L$1;
            queryProductDetails = (AnalyticsEvent.GoogleAPIRequestData.QueryProductDetails) this.L$0;
            ResultKt.throwOnFailure(obj);
            AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.this$0.analyticsTracker, AnalyticsEvent.GoogleAPIResponseData.QueryProductDetails.Companion.create(productDetailsResult.getProductDetailsList(), queryProductDetails), (Function2) null, 2, (Object) null);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ProductDetailsResult productDetailsResult2 = (ProductDetailsResult) obj;
        if (productDetailsResult2.getBillingResult().getResponseCode() == 0) {
            List<ProductDetails> productDetailsList = productDetailsResult2.getProductDetailsList();
            if (productDetailsList == null) {
                productDetailsList = CollectionsKt.emptyList();
            }
            this.L$0 = queryProductDetails;
            this.L$1 = productDetailsResult2;
            this.label = 2;
            if (flowCollector.emit(productDetailsList, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            productDetailsResult = productDetailsResult2;
            AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.this$0.analyticsTracker, AnalyticsEvent.GoogleAPIResponseData.QueryProductDetails.Companion.create(productDetailsResult.getProductDetailsList(), queryProductDetails), (Function2) null, 2, (Object) null);
            return Unit.INSTANCE;
        }
        AdaptyError access$createException = this.this$0.createException(productDetailsResult2.getBillingResult(), "on query product details");
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.this$0.analyticsTracker, AnalyticsEvent.GoogleAPIResponseData.QueryProductDetails.Companion.create(access$createException, queryProductDetails), (Function2) null, 2, (Object) null);
        throw access$createException;
    }
}
