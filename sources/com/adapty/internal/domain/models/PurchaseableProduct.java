package com.adapty.internal.domain.models;

import com.android.billingclient.api.ProductDetails;
import com.appsflyer.AppsFlyerProperties;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/adapty/internal/domain/models/PurchaseableProduct;", "", "vendorProductId", "", "type", "priceAmountMicros", "", "currencyCode", "variationId", "currentOfferDetails", "Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;", "isOfferPersonalized", "", "productDetails", "Lcom/android/billingclient/api/ProductDetails;", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;ZLcom/android/billingclient/api/ProductDetails;)V", "getCurrencyCode", "()Ljava/lang/String;", "getCurrentOfferDetails", "()Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;", "()Z", "isSubscription", "getPriceAmountMicros", "()J", "getProductDetails", "()Lcom/android/billingclient/api/ProductDetails;", "getType", "getVariationId", "getVendorProductId", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PurchaseableProduct.kt */
public final class PurchaseableProduct {
    private final String currencyCode;
    private final ProductDetails.SubscriptionOfferDetails currentOfferDetails;
    private final boolean isOfferPersonalized;
    private final boolean isSubscription;
    private final long priceAmountMicros;
    private final ProductDetails productDetails;
    private final String type;
    private final String variationId;
    private final String vendorProductId;

    public PurchaseableProduct(String str, String str2, long j, String str3, String str4, ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails, boolean z, ProductDetails productDetails2) {
        Intrinsics.checkNotNullParameter(str, "vendorProductId");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(str3, AppsFlyerProperties.CURRENCY_CODE);
        Intrinsics.checkNotNullParameter(str4, "variationId");
        Intrinsics.checkNotNullParameter(productDetails2, "productDetails");
        this.vendorProductId = str;
        this.type = str2;
        this.priceAmountMicros = j;
        this.currencyCode = str3;
        this.variationId = str4;
        this.currentOfferDetails = subscriptionOfferDetails;
        this.isOfferPersonalized = z;
        this.productDetails = productDetails2;
        this.isSubscription = subscriptionOfferDetails != null;
    }

    public final String getVendorProductId() {
        return this.vendorProductId;
    }

    public final String getType() {
        return this.type;
    }

    public final long getPriceAmountMicros() {
        return this.priceAmountMicros;
    }

    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    public final String getVariationId() {
        return this.variationId;
    }

    public final ProductDetails.SubscriptionOfferDetails getCurrentOfferDetails() {
        return this.currentOfferDetails;
    }

    public final boolean isOfferPersonalized() {
        return this.isOfferPersonalized;
    }

    public final ProductDetails getProductDetails() {
        return this.productDetails;
    }

    public final boolean isSubscription() {
        return this.isSubscription;
    }
}
