package com.adapty.models;

import com.adapty.internal.domain.models.BackendProduct;
import com.android.billingclient.api.ProductDetails;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002'(BY\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013¨\u0006)"}, d2 = {"Lcom/adapty/models/AdaptyPaywallProduct;", "", "vendorProductId", "", "localizedTitle", "localizedDescription", "paywallName", "paywallABTestName", "variationId", "price", "Lcom/adapty/models/AdaptyPaywallProduct$Price;", "subscriptionDetails", "Lcom/adapty/models/AdaptyProductSubscriptionDetails;", "productDetails", "Lcom/android/billingclient/api/ProductDetails;", "payloadData", "Lcom/adapty/models/AdaptyPaywallProduct$Payload;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/adapty/models/AdaptyPaywallProduct$Price;Lcom/adapty/models/AdaptyProductSubscriptionDetails;Lcom/android/billingclient/api/ProductDetails;Lcom/adapty/models/AdaptyPaywallProduct$Payload;)V", "getLocalizedDescription", "()Ljava/lang/String;", "getLocalizedTitle", "getPayloadData$adapty_release", "()Lcom/adapty/models/AdaptyPaywallProduct$Payload;", "getPaywallABTestName", "getPaywallName", "getPrice", "()Lcom/adapty/models/AdaptyPaywallProduct$Price;", "getProductDetails", "()Lcom/android/billingclient/api/ProductDetails;", "getSubscriptionDetails", "()Lcom/adapty/models/AdaptyProductSubscriptionDetails;", "getVariationId", "getVendorProductId", "equals", "", "other", "hashCode", "", "toString", "Payload", "Price", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyPaywallProduct.kt */
public final class AdaptyPaywallProduct {
    private final String localizedDescription;
    private final String localizedTitle;
    private final Payload payloadData;
    private final String paywallABTestName;
    private final String paywallName;
    private final Price price;
    private final ProductDetails productDetails;
    private final AdaptyProductSubscriptionDetails subscriptionDetails;
    private final String variationId;
    private final String vendorProductId;

    public AdaptyPaywallProduct(String str, String str2, String str3, String str4, String str5, String str6, Price price2, AdaptyProductSubscriptionDetails adaptyProductSubscriptionDetails, ProductDetails productDetails2, Payload payload) {
        Intrinsics.checkNotNullParameter(str, "vendorProductId");
        Intrinsics.checkNotNullParameter(str2, "localizedTitle");
        Intrinsics.checkNotNullParameter(str3, "localizedDescription");
        Intrinsics.checkNotNullParameter(str4, "paywallName");
        Intrinsics.checkNotNullParameter(str5, "paywallABTestName");
        Intrinsics.checkNotNullParameter(str6, "variationId");
        Intrinsics.checkNotNullParameter(price2, FirebaseAnalytics.Param.PRICE);
        Intrinsics.checkNotNullParameter(productDetails2, "productDetails");
        Intrinsics.checkNotNullParameter(payload, "payloadData");
        this.vendorProductId = str;
        this.localizedTitle = str2;
        this.localizedDescription = str3;
        this.paywallName = str4;
        this.paywallABTestName = str5;
        this.variationId = str6;
        this.price = price2;
        this.subscriptionDetails = adaptyProductSubscriptionDetails;
        this.productDetails = productDetails2;
        this.payloadData = payload;
    }

    public final String getVendorProductId() {
        return this.vendorProductId;
    }

    public final String getLocalizedTitle() {
        return this.localizedTitle;
    }

    public final String getLocalizedDescription() {
        return this.localizedDescription;
    }

    public final String getPaywallName() {
        return this.paywallName;
    }

    public final String getPaywallABTestName() {
        return this.paywallABTestName;
    }

    public final String getVariationId() {
        return this.variationId;
    }

    public final Price getPrice() {
        return this.price;
    }

    public final AdaptyProductSubscriptionDetails getSubscriptionDetails() {
        return this.subscriptionDetails;
    }

    public final ProductDetails getProductDetails() {
        return this.productDetails;
    }

    public final /* synthetic */ Payload getPayloadData$adapty_release() {
        return this.payloadData;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.models.AdaptyPaywallProduct");
        AdaptyPaywallProduct adaptyPaywallProduct = (AdaptyPaywallProduct) obj;
        return Intrinsics.areEqual((Object) this.vendorProductId, (Object) adaptyPaywallProduct.vendorProductId) && Intrinsics.areEqual((Object) this.localizedTitle, (Object) adaptyPaywallProduct.localizedTitle) && Intrinsics.areEqual((Object) this.localizedDescription, (Object) adaptyPaywallProduct.localizedDescription) && Intrinsics.areEqual((Object) this.paywallName, (Object) adaptyPaywallProduct.paywallName) && Intrinsics.areEqual((Object) this.paywallABTestName, (Object) adaptyPaywallProduct.paywallABTestName) && Intrinsics.areEqual((Object) this.variationId, (Object) adaptyPaywallProduct.variationId) && Intrinsics.areEqual((Object) this.price, (Object) adaptyPaywallProduct.price) && Intrinsics.areEqual((Object) this.subscriptionDetails, (Object) adaptyPaywallProduct.subscriptionDetails) && Intrinsics.areEqual((Object) this.productDetails, (Object) adaptyPaywallProduct.productDetails);
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.vendorProductId.hashCode() * 31) + this.localizedTitle.hashCode()) * 31) + this.localizedDescription.hashCode()) * 31) + this.paywallName.hashCode()) * 31) + this.paywallABTestName.hashCode()) * 31) + this.variationId.hashCode()) * 31) + this.price.hashCode()) * 31;
        AdaptyProductSubscriptionDetails adaptyProductSubscriptionDetails = this.subscriptionDetails;
        return ((hashCode + (adaptyProductSubscriptionDetails != null ? adaptyProductSubscriptionDetails.hashCode() : 0)) * 31) + this.productDetails.hashCode();
    }

    public String toString() {
        return "AdaptyPaywallProduct(vendorProductId=" + this.vendorProductId + ", localizedTitle=" + this.localizedTitle + ", localizedDescription=" + this.localizedDescription + ", paywallName=" + this.paywallName + ", paywallABTestName=" + this.paywallABTestName + ", variationId=" + this.variationId + ", price=" + this.price + ", subscriptionDetails=" + this.subscriptionDetails + ", productDetails=" + this.productDetails + ')';
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/adapty/models/AdaptyPaywallProduct$Price;", "", "amount", "Ljava/math/BigDecimal;", "localizedString", "", "currencyCode", "currencySymbol", "(Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/math/BigDecimal;", "getCurrencyCode", "()Ljava/lang/String;", "getCurrencySymbol", "getLocalizedString", "equals", "", "other", "hashCode", "", "toString", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyPaywallProduct.kt */
    public static final class Price {
        private final BigDecimal amount;
        private final String currencyCode;
        private final String currencySymbol;
        private final String localizedString;

        public Price(BigDecimal bigDecimal, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(bigDecimal, "amount");
            Intrinsics.checkNotNullParameter(str, "localizedString");
            Intrinsics.checkNotNullParameter(str2, AppsFlyerProperties.CURRENCY_CODE);
            Intrinsics.checkNotNullParameter(str3, "currencySymbol");
            this.amount = bigDecimal;
            this.localizedString = str;
            this.currencyCode = str2;
            this.currencySymbol = str3;
        }

        public final BigDecimal getAmount() {
            return this.amount;
        }

        public final String getLocalizedString() {
            return this.localizedString;
        }

        public final String getCurrencyCode() {
            return this.currencyCode;
        }

        public final String getCurrencySymbol() {
            return this.currencySymbol;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.models.AdaptyPaywallProduct.Price");
            Price price = (Price) obj;
            return Intrinsics.areEqual((Object) this.amount, (Object) price.amount) && Intrinsics.areEqual((Object) this.localizedString, (Object) price.localizedString) && Intrinsics.areEqual((Object) this.currencyCode, (Object) price.currencyCode) && Intrinsics.areEqual((Object) this.currencySymbol, (Object) price.currencySymbol);
        }

        public int hashCode() {
            return (((((this.amount.hashCode() * 31) + this.localizedString.hashCode()) * 31) + this.currencyCode.hashCode()) * 31) + this.currencySymbol.hashCode();
        }

        public String toString() {
            return "Price(amount=" + this.amount + ", localizedString=" + this.localizedString + ", currencyCode=" + this.currencyCode + ", currencySymbol=" + this.currencySymbol + ')';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/adapty/models/AdaptyPaywallProduct$Payload;", "", "priceAmountMicros", "", "currencyCode", "", "type", "subscriptionData", "Lcom/adapty/internal/domain/models/BackendProduct$SubscriptionData;", "(JLjava/lang/String;Ljava/lang/String;Lcom/adapty/internal/domain/models/BackendProduct$SubscriptionData;)V", "getCurrencyCode", "()Ljava/lang/String;", "getPriceAmountMicros", "()J", "getSubscriptionData", "()Lcom/adapty/internal/domain/models/BackendProduct$SubscriptionData;", "getType", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyPaywallProduct.kt */
    public static final class Payload {
        private final String currencyCode;
        private final long priceAmountMicros;
        private final BackendProduct.SubscriptionData subscriptionData;
        private final String type;

        public Payload(long j, String str, String str2, BackendProduct.SubscriptionData subscriptionData2) {
            Intrinsics.checkNotNullParameter(str, AppsFlyerProperties.CURRENCY_CODE);
            Intrinsics.checkNotNullParameter(str2, "type");
            this.priceAmountMicros = j;
            this.currencyCode = str;
            this.type = str2;
            this.subscriptionData = subscriptionData2;
        }

        public final /* synthetic */ String getCurrencyCode() {
            return this.currencyCode;
        }

        public final /* synthetic */ long getPriceAmountMicros() {
            return this.priceAmountMicros;
        }

        public final /* synthetic */ BackendProduct.SubscriptionData getSubscriptionData() {
            return this.subscriptionData;
        }

        public final /* synthetic */ String getType() {
            return this.type;
        }
    }
}
