package com.adapty.internal.data.cloud;

import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingConfig;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.GetBillingConfigParams;
import com.android.billingclient.api.Purchase;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\b2\u0006\u0010\u0016\u001a\u00020\u0017J'\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00192\u0006\u0010\u0016\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001c0\b2\u0006\u0010\u001d\u001a\u00020\u0012J\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001c0\b2\u0006\u0010\u001d\u001a\u00020\u0012J,\u0010\u001f\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001c0\u00190\b2\u0006\u0010\u001d\u001a\u00020\u0012J(\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001c0\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120\u001c2\u0006\u0010$\u001a\u00020\u0012J\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001c0\b2\u0006\u0010\u001d\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/adapty/internal/data/cloud/StoreHelper;", "", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "analyticsTracker", "Lcom/adapty/internal/data/cloud/AnalyticsTracker;", "(Lcom/android/billingclient/api/BillingClient;Lcom/adapty/internal/data/cloud/AnalyticsTracker;)V", "acknowledgePurchase", "Lkotlinx/coroutines/flow/Flow;", "", "purchase", "Lcom/android/billingclient/api/Purchase;", "consumePurchase", "createException", "Lcom/adapty/errors/AdaptyError;", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "where", "", "errorMessageFromBillingResult", "getBillingConfig", "Lcom/android/billingclient/api/BillingConfig;", "params", "Lcom/android/billingclient/api/GetBillingConfigParams;", "getBillingConfigSync", "Lkotlin/Pair;", "(Lcom/android/billingclient/api/GetBillingConfigParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryActivePurchasesForType", "", "type", "queryActivePurchasesForTypeWithSync", "queryAllPurchasesForType", "Lcom/android/billingclient/api/PurchaseHistoryRecord;", "queryProductDetailsForType", "Lcom/android/billingclient/api/ProductDetails;", "productList", "productType", "queryPurchaseHistoryForType", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: StoreManager.kt */
final class StoreHelper {
    /* access modifiers changed from: private */
    public final AnalyticsTracker analyticsTracker;
    /* access modifiers changed from: private */
    public final BillingClient billingClient;

    public StoreHelper(BillingClient billingClient2, AnalyticsTracker analyticsTracker2) {
        Intrinsics.checkNotNullParameter(billingClient2, "billingClient");
        Intrinsics.checkNotNullParameter(analyticsTracker2, "analyticsTracker");
        this.billingClient = billingClient2;
        this.analyticsTracker = analyticsTracker2;
    }

    public final /* synthetic */ Flow queryProductDetailsForType(List list, String str) {
        Intrinsics.checkNotNullParameter(list, "productList");
        Intrinsics.checkNotNullParameter(str, "productType");
        return FlowKt.flow(new StoreHelper$queryProductDetailsForType$1(list, str, this, (Continuation<? super StoreHelper$queryProductDetailsForType$1>) null));
    }

    public final /* synthetic */ Flow queryActivePurchasesForType(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        return FlowKt.flow(new StoreHelper$queryActivePurchasesForType$1(str, this, (Continuation<? super StoreHelper$queryActivePurchasesForType$1>) null));
    }

    public final /* synthetic */ Flow queryPurchaseHistoryForType(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        return FlowKt.flow(new StoreHelper$queryPurchaseHistoryForType$1(str, this, (Continuation<? super StoreHelper$queryPurchaseHistoryForType$1>) null));
    }

    public final /* synthetic */ Flow queryAllPurchasesForType(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        return FlowKt.flatMapConcat(queryPurchaseHistoryForType(str), new StoreHelper$queryAllPurchasesForType$1(this, str, (Continuation<? super StoreHelper$queryAllPurchasesForType$1>) null));
    }

    public final /* synthetic */ Flow queryActivePurchasesForTypeWithSync(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        return new StoreHelper$queryActivePurchasesForTypeWithSync$$inlined$map$1(queryAllPurchasesForType(str));
    }

    public final /* synthetic */ Flow acknowledgePurchase(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, FirebaseAnalytics.Event.PURCHASE);
        return FlowKt.flow(new StoreHelper$acknowledgePurchase$1(purchase, this, (Continuation<? super StoreHelper$acknowledgePurchase$1>) null));
    }

    public final /* synthetic */ Flow consumePurchase(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, FirebaseAnalytics.Event.PURCHASE);
        return FlowKt.flow(new StoreHelper$consumePurchase$1(purchase, this, (Continuation<? super StoreHelper$consumePurchase$1>) null));
    }

    public final /* synthetic */ Flow getBillingConfig(GetBillingConfigParams getBillingConfigParams) {
        Intrinsics.checkNotNullParameter(getBillingConfigParams, "params");
        return FlowKt.flow(new StoreHelper$getBillingConfig$1(this, getBillingConfigParams, (Continuation<? super StoreHelper$getBillingConfig$1>) null));
    }

    public final /* synthetic */ String errorMessageFromBillingResult(BillingResult billingResult, String str) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(str, "where");
        StringBuilder append = new StringBuilder().append("Play Market request failed ").append(str).append(": responseCode=").append(billingResult.getResponseCode());
        String debugMessage = billingResult.getDebugMessage();
        Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
        String str2 = null;
        if (!(debugMessage.length() > 0)) {
            debugMessage = null;
        }
        if (debugMessage != null) {
            str2 = ", debugMessage=" + debugMessage;
        }
        if (str2 == null) {
            str2 = "";
        }
        return append.append(str2).toString();
    }

    /* access modifiers changed from: private */
    public final AdaptyError createException(BillingResult billingResult, String str) {
        return new AdaptyError((Throwable) null, errorMessageFromBillingResult(billingResult, str), AdaptyErrorCode.Companion.fromBilling$adapty_release(billingResult.getResponseCode()), 1, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public final Object getBillingConfigSync(GetBillingConfigParams getBillingConfigParams, Continuation<? super Pair<BillingResult, BillingConfig>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        this.billingClient.getBillingConfigAsync(getBillingConfigParams, new StoreHelper$getBillingConfigSync$2$1(new Ref.BooleanRef(), cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
