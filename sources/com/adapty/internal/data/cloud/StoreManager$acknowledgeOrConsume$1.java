package com.adapty.internal.data.cloud;

import com.adapty.internal.domain.models.ProductType;
import com.adapty.internal.domain.models.PurchaseableProduct;
import com.android.billingclient.api.Purchase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: StoreManager.kt */
final class StoreManager$acknowledgeOrConsume$1 extends Lambda implements Function0<Flow<? extends Unit>> {
    final /* synthetic */ PurchaseableProduct $product;
    final /* synthetic */ Purchase $purchase;
    final /* synthetic */ StoreManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreManager$acknowledgeOrConsume$1(PurchaseableProduct purchaseableProduct, StoreManager storeManager, Purchase purchase) {
        super(0);
        this.$product = purchaseableProduct;
        this.this$0 = storeManager;
        this.$purchase = purchase;
    }

    public final Flow<Unit> invoke() {
        if (Intrinsics.areEqual((Object) this.$product.getType(), (Object) ProductType.Consumable.INSTANCE.getNAME())) {
            return this.this$0.storeHelper.consumePurchase(this.$purchase);
        }
        return this.this$0.storeHelper.acknowledgePurchase(this.$purchase);
    }
}
