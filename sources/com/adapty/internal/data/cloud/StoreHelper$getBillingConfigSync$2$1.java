package com.adapty.internal.data.cloud;

import com.android.billingclient.api.BillingConfig;
import com.android.billingclient.api.BillingConfigResponseListener;
import com.android.billingclient.api.BillingResult;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "billingConfig", "Lcom/android/billingclient/api/BillingConfig;", "onBillingConfigResponse"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: StoreManager.kt */
final class StoreHelper$getBillingConfigSync$2$1 implements BillingConfigResponseListener {
    final /* synthetic */ CancellableContinuation<Pair<BillingResult, BillingConfig>> $continuation;
    final /* synthetic */ Ref.BooleanRef $resumed;

    StoreHelper$getBillingConfigSync$2$1(Ref.BooleanRef booleanRef, CancellableContinuation<? super Pair<BillingResult, BillingConfig>> cancellableContinuation) {
        this.$resumed = booleanRef;
        this.$continuation = cancellableContinuation;
    }

    public final void onBillingConfigResponse(BillingResult billingResult, BillingConfig billingConfig) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        if (!this.$resumed.element) {
            this.$continuation.resume(TuplesKt.to(billingResult, billingConfig), AnonymousClass1.INSTANCE);
            this.$resumed.element = true;
        }
    }
}
