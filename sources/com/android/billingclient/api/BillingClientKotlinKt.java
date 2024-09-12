package com.android.billingclient.api;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@¢\u0006\u0002\u0010\u0005\u001a\u001a\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH@¢\u0006\u0002\u0010\t\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\u0002H@¢\u0006\u0002\u0010\f\u001a\u0012\u0010\r\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0002\u0010\f\u001a\u001a\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0010H@¢\u0006\u0002\u0010\u0011\u001a\u001a\u0010\u0012\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0014H@¢\u0006\u0002\u0010\u0015\u001a\u001a\u0010\u0012\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H@¢\u0006\u0002\u0010\u0018\u001a\u001a\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001bH@¢\u0006\u0002\u0010\u001c\u001a\u001a\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H@¢\u0006\u0002\u0010\u0018\u001a\u001a\u0010\u001d\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001fH@¢\u0006\u0002\u0010 ¨\u0006!"}, d2 = {"acknowledgePurchase", "Lcom/android/billingclient/api/BillingResult;", "Lcom/android/billingclient/api/BillingClient;", "params", "Lcom/android/billingclient/api/AcknowledgePurchaseParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/AcknowledgePurchaseParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumePurchase", "Lcom/android/billingclient/api/ConsumeResult;", "Lcom/android/billingclient/api/ConsumeParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/ConsumeParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAlternativeBillingOnlyReportingDetails", "Lcom/android/billingclient/api/CreateAlternativeBillingOnlyReportingDetailsResult;", "(Lcom/android/billingclient/api/BillingClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAlternativeBillingOnlyAvailable", "queryProductDetails", "Lcom/android/billingclient/api/ProductDetailsResult;", "Lcom/android/billingclient/api/QueryProductDetailsParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryProductDetailsParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryPurchaseHistory", "Lcom/android/billingclient/api/PurchaseHistoryResult;", "Lcom/android/billingclient/api/QueryPurchaseHistoryParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryPurchaseHistoryParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "skuType", "", "(Lcom/android/billingclient/api/BillingClient;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryPurchasesAsync", "Lcom/android/billingclient/api/PurchasesResult;", "Lcom/android/billingclient/api/QueryPurchasesParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryPurchasesParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "querySkuDetails", "Lcom/android/billingclient/api/SkuDetailsResult;", "Lcom/android/billingclient/api/SkuDetailsParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/SkuDetailsParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: com.android.billingclient:billing-ktx@@6.1.0 */
public final class BillingClientKotlinKt {
    public static final Object acknowledgePurchase(BillingClient billingClient, AcknowledgePurchaseParams acknowledgePurchaseParams, Continuation<? super BillingResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.acknowledgePurchase(acknowledgePurchaseParams, new BillingClientKotlinKt$acknowledgePurchase$2(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object consumePurchase(BillingClient billingClient, ConsumeParams consumeParams, Continuation<? super ConsumeResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.consumeAsync(consumeParams, new BillingClientKotlinKt$consumePurchase$2(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object createAlternativeBillingOnlyReportingDetails(BillingClient billingClient, Continuation<? super CreateAlternativeBillingOnlyReportingDetailsResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.createAlternativeBillingOnlyReportingDetailsAsync(new BillingClientKotlinKt$createAlternativeBillingOnlyReportingDetails$2(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object isAlternativeBillingOnlyAvailable(BillingClient billingClient, Continuation<? super BillingResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.isAlternativeBillingOnlyAvailableAsync(new BillingClientKotlinKt$isAlternativeBillingOnlyAvailable$2(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object queryProductDetails(BillingClient billingClient, QueryProductDetailsParams queryProductDetailsParams, Continuation<? super ProductDetailsResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.queryProductDetailsAsync(queryProductDetailsParams, new BillingClientKotlinKt$queryProductDetails$2(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object queryPurchaseHistory(BillingClient billingClient, QueryPurchaseHistoryParams queryPurchaseHistoryParams, Continuation<? super PurchaseHistoryResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.queryPurchaseHistoryAsync(queryPurchaseHistoryParams, (PurchaseHistoryResponseListener) new BillingClientKotlinKt$queryPurchaseHistory$4(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object queryPurchasesAsync(BillingClient billingClient, QueryPurchasesParams queryPurchasesParams, Continuation<? super PurchasesResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.queryPurchasesAsync(queryPurchasesParams, (PurchasesResponseListener) new BillingClientKotlinKt$queryPurchasesAsync$4(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    @Deprecated(message = "Use [BillingClient.queryProductDetails] instead")
    public static final Object querySkuDetails(BillingClient billingClient, SkuDetailsParams skuDetailsParams, Continuation<? super SkuDetailsResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.querySkuDetailsAsync(skuDetailsParams, new BillingClientKotlinKt$querySkuDetails$2(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    @Deprecated(message = "Use [BillingClient.queryPurchaseHistory(QueryPurchaseHistoryParams)] instead")
    public static final Object queryPurchaseHistory(BillingClient billingClient, String str, Continuation<? super PurchaseHistoryResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.queryPurchaseHistoryAsync(str, (PurchaseHistoryResponseListener) new BillingClientKotlinKt$queryPurchaseHistory$2(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    @Deprecated(message = "Use [BillingClient.queryPurchasesAsync(QueryPurchasesParams)] instead")
    public static final Object queryPurchasesAsync(BillingClient billingClient, String str, Continuation<? super PurchasesResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.queryPurchasesAsync(str, (PurchasesResponseListener) new BillingClientKotlinKt$queryPurchasesAsync$2(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }
}
