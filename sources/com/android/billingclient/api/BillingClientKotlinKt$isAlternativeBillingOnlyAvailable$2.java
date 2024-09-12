package com.android.billingclient.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/android/billingclient/api/BillingResult;", "kotlin.jvm.PlatformType", "onAlternativeBillingOnlyAvailabilityResponse"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: com.android.billingclient:billing-ktx@@6.1.0 */
final class BillingClientKotlinKt$isAlternativeBillingOnlyAvailable$2 implements AlternativeBillingOnlyAvailabilityListener {
    final /* synthetic */ CompletableDeferred<BillingResult> $deferred;

    BillingClientKotlinKt$isAlternativeBillingOnlyAvailable$2(CompletableDeferred<BillingResult> completableDeferred) {
        this.$deferred = completableDeferred;
    }

    public final void onAlternativeBillingOnlyAvailabilityResponse(BillingResult billingResult) {
        Intrinsics.checkNotNull(billingResult);
        this.$deferred.complete(billingResult);
    }
}
