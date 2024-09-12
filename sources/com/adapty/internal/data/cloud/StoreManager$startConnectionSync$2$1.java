package com.adapty.internal.data.cloud;

import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/adapty/internal/data/cloud/StoreManager$startConnectionSync$2$1", "Lcom/android/billingclient/api/BillingClientStateListener;", "onBillingServiceDisconnected", "", "onBillingSetupFinished", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: StoreManager.kt */
public final class StoreManager$startConnectionSync$2$1 implements BillingClientStateListener {
    final /* synthetic */ CancellableContinuation<Unit> $continuation;
    final /* synthetic */ Ref.BooleanRef $resumed;
    final /* synthetic */ StoreManager this$0;

    StoreManager$startConnectionSync$2$1(Ref.BooleanRef booleanRef, CancellableContinuation<? super Unit> cancellableContinuation, StoreManager storeManager) {
        this.$resumed = booleanRef;
        this.$continuation = cancellableContinuation;
        this.this$0 = storeManager;
    }

    public void onBillingSetupFinished(BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        if (!this.$resumed.element) {
            if (billingResult.getResponseCode() == 0) {
                this.$continuation.resume(Unit.INSTANCE, StoreManager$startConnectionSync$2$1$onBillingSetupFinished$1.INSTANCE);
            } else {
                Result.Companion companion = Result.Companion;
                this.$continuation.resumeWith(Result.m983constructorimpl(ResultKt.createFailure(new AdaptyError((Throwable) null, "Play Market request failed: " + billingResult.getDebugMessage(), AdaptyErrorCode.Companion.fromBilling$adapty_release(billingResult.getResponseCode()), 1, (DefaultConstructorMarker) null))));
            }
            this.$resumed.element = true;
            this.this$0.startConnectionSemaphore.release();
        }
    }

    public void onBillingServiceDisconnected() {
        if (!this.$resumed.element) {
            Result.Companion companion = Result.Companion;
            this.$continuation.resumeWith(Result.m983constructorimpl(ResultKt.createFailure(new AdaptyError((Throwable) null, "Play Market request failed: SERVICE_DISCONNECTED", AdaptyErrorCode.Companion.fromBilling$adapty_release(-1), 1, (DefaultConstructorMarker) null))));
            this.$resumed.element = true;
            this.this$0.startConnectionSemaphore.release();
        }
    }
}
