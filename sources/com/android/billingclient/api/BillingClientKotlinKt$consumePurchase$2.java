package com.android.billingclient.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "kotlin.jvm.PlatformType", "purchaseToken", "", "onConsumeResponse"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: com.android.billingclient:billing-ktx@@6.1.0 */
final class BillingClientKotlinKt$consumePurchase$2 implements ConsumeResponseListener {
    final /* synthetic */ CompletableDeferred<ConsumeResult> $deferred;

    BillingClientKotlinKt$consumePurchase$2(CompletableDeferred<ConsumeResult> completableDeferred) {
        this.$deferred = completableDeferred;
    }

    public final void onConsumeResponse(BillingResult billingResult, String str) {
        Intrinsics.checkNotNull(billingResult);
        this.$deferred.complete(new ConsumeResult(billingResult, str));
    }
}
