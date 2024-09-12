package com.adapty.internal.data.models;

import com.adapty.internal.data.models.requests.PurchasedProductDetails;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0002\u0010\nR\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0002X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/adapty/internal/data/models/RestoreProductInfo;", "", "isSubscription", "", "productId", "", "purchaseToken", "productDetails", "Lcom/adapty/internal/data/models/requests/PurchasedProductDetails;", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/adapty/internal/data/models/requests/PurchasedProductDetails;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getProductId", "()Ljava/lang/String;", "getPurchaseToken", "equals", "other", "hashCode", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RestoreProductInfo.kt */
public final class RestoreProductInfo {
    @SerializedName("is_subscription")
    private final Boolean isSubscription;
    @SerializedName("product_details")
    private final PurchasedProductDetails productDetails;
    @SerializedName("product_id")
    private final String productId;
    @SerializedName("purchase_token")
    private final String purchaseToken;

    public RestoreProductInfo(Boolean bool, String str, String str2, PurchasedProductDetails purchasedProductDetails) {
        this.isSubscription = bool;
        this.productId = str;
        this.purchaseToken = str2;
        this.productDetails = purchasedProductDetails;
    }

    public final Boolean isSubscription() {
        return this.isSubscription;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.internal.data.models.RestoreProductInfo");
        return Intrinsics.areEqual((Object) this.purchaseToken, (Object) ((RestoreProductInfo) obj).purchaseToken);
    }

    public int hashCode() {
        String str = this.purchaseToken;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
