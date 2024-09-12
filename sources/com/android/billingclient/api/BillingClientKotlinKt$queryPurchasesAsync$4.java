package com.android.billingclient.api;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\b0\u0006H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "kotlin.jvm.PlatformType", "purchases", "", "Lcom/android/billingclient/api/Purchase;", "", "onQueryPurchasesResponse"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: com.android.billingclient:billing-ktx@@6.1.0 */
final class BillingClientKotlinKt$queryPurchasesAsync$4 implements PurchasesResponseListener {
    final /* synthetic */ CompletableDeferred<PurchasesResult> $deferred;

    BillingClientKotlinKt$queryPurchasesAsync$4(CompletableDeferred<PurchasesResult> completableDeferred) {
        this.$deferred = completableDeferred;
    }

    public final void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list) {
        Intrinsics.checkNotNull(billingResult);
        Intrinsics.checkNotNull(list);
        this.$deferred.complete(new PurchasesResult(billingResult, list));
    }
}
