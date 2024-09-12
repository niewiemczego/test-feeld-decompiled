package com.adapty.internal.data.cloud;

import com.android.billingclient.api.BillingConfig;
import com.android.billingclient.api.GetBillingConfigParams;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Lcom/android/billingclient/api/BillingConfig;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: StoreManager.kt */
final class StoreManager$getStoreCountry$1 extends Lambda implements Function0<Flow<? extends BillingConfig>> {
    final /* synthetic */ StoreManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreManager$getStoreCountry$1(StoreManager storeManager) {
        super(0);
        this.this$0 = storeManager;
    }

    public final Flow<BillingConfig> invoke() {
        GetBillingConfigParams build = GetBillingConfigParams.newBuilder().build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().build()");
        return this.this$0.storeHelper.getBillingConfig(build);
    }
}
