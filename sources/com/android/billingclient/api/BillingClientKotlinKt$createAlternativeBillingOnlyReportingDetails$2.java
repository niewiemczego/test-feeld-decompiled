package com.android.billingclient.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "kotlin.jvm.PlatformType", "alternativeBillingOnlyReportingDetails", "Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;", "onAlternativeBillingOnlyTokenResponse"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: com.android.billingclient:billing-ktx@@6.1.0 */
final class BillingClientKotlinKt$createAlternativeBillingOnlyReportingDetails$2 implements AlternativeBillingOnlyReportingDetailsListener {
    final /* synthetic */ CompletableDeferred<CreateAlternativeBillingOnlyReportingDetailsResult> $deferred;

    BillingClientKotlinKt$createAlternativeBillingOnlyReportingDetails$2(CompletableDeferred<CreateAlternativeBillingOnlyReportingDetailsResult> completableDeferred) {
        this.$deferred = completableDeferred;
    }

    public final void onAlternativeBillingOnlyTokenResponse(BillingResult billingResult, AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails) {
        Intrinsics.checkNotNull(billingResult);
        this.$deferred.complete(new CreateAlternativeBillingOnlyReportingDetailsResult(billingResult, alternativeBillingOnlyReportingDetails));
    }
}
