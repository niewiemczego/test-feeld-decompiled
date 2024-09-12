package com.adapty.internal.data.models.requests;

import com.adapty.internal.data.models.requests.PurchasedProductDetails;
import com.adapty.internal.domain.models.PurchaseableProduct;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00052\u00020\u0001:\u0002\u0005\u0006B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/requests/ValidateReceiptRequest;", "", "data", "Lcom/adapty/internal/data/models/requests/ValidateReceiptRequest$Data;", "(Lcom/adapty/internal/data/models/requests/ValidateReceiptRequest$Data;)V", "Companion", "Data", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ValidateReceiptRequest.kt */
public final class ValidateReceiptRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("data")
    private final Data data;

    public ValidateReceiptRequest(Data data2) {
        Intrinsics.checkNotNullParameter(data2, "data");
        this.data = data2;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\rB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/adapty/internal/data/models/requests/ValidateReceiptRequest$Data;", "", "id", "", "type", "attributes", "Lcom/adapty/internal/data/models/requests/ValidateReceiptRequest$Data$Attributes;", "(Ljava/lang/String;Ljava/lang/String;Lcom/adapty/internal/data/models/requests/ValidateReceiptRequest$Data$Attributes;)V", "getAttributes", "()Lcom/adapty/internal/data/models/requests/ValidateReceiptRequest$Data$Attributes;", "getId", "()Ljava/lang/String;", "getType", "Attributes", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ValidateReceiptRequest.kt */
    public static final class Data {
        @SerializedName("attributes")
        private final Attributes attributes;
        @SerializedName("id")
        private final String id;
        @SerializedName("type")
        private final String type;

        public Data(String str, String str2, Attributes attributes2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "type");
            Intrinsics.checkNotNullParameter(attributes2, "attributes");
            this.id = str;
            this.type = str2;
            this.attributes = attributes2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Data(String str, String str2, Attributes attributes2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? "google_receipt_validation_result" : str2, attributes2);
        }

        public final String getId() {
            return this.id;
        }

        public final String getType() {
            return this.type;
        }

        public final Attributes getAttributes() {
            return this.attributes;
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/adapty/internal/data/models/requests/ValidateReceiptRequest$Data$Attributes;", "", "profileId", "", "productId", "purchaseToken", "isSubscription", "", "variationId", "productDetails", "Lcom/adapty/internal/data/models/requests/PurchasedProductDetails;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/adapty/internal/data/models/requests/PurchasedProductDetails;)V", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: ValidateReceiptRequest.kt */
        public static final class Attributes {
            @SerializedName("is_subscription")
            private final boolean isSubscription;
            @SerializedName("product_details")
            private final PurchasedProductDetails productDetails;
            @SerializedName("product_id")
            private final String productId;
            @SerializedName("profile_id")
            private final String profileId;
            @SerializedName("purchase_token")
            private final String purchaseToken;
            @SerializedName("variation_id")
            private final String variationId;

            public Attributes(String str, String str2, String str3, boolean z, String str4, PurchasedProductDetails purchasedProductDetails) {
                Intrinsics.checkNotNullParameter(str, "profileId");
                Intrinsics.checkNotNullParameter(str2, "productId");
                Intrinsics.checkNotNullParameter(str3, SDKConstants.PARAM_PURCHASE_TOKEN);
                Intrinsics.checkNotNullParameter(str4, "variationId");
                Intrinsics.checkNotNullParameter(purchasedProductDetails, "productDetails");
                this.profileId = str;
                this.productId = str2;
                this.purchaseToken = str3;
                this.isSubscription = z;
                this.variationId = str4;
                this.productDetails = purchasedProductDetails;
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/data/models/requests/ValidateReceiptRequest$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/requests/ValidateReceiptRequest;", "id", "", "purchase", "Lcom/android/billingclient/api/Purchase;", "product", "Lcom/adapty/internal/domain/models/PurchaseableProduct;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ValidateReceiptRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ValidateReceiptRequest create(String str, Purchase purchase, PurchaseableProduct purchaseableProduct) {
            PurchasedProductDetails purchasedProductDetails;
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(purchase, FirebaseAnalytics.Event.PURCHASE);
            Intrinsics.checkNotNullParameter(purchaseableProduct, "product");
            ProductDetails.SubscriptionOfferDetails currentOfferDetails = purchaseableProduct.getCurrentOfferDetails();
            List<String> products = purchase.getProducts();
            Intrinsics.checkNotNullExpressionValue(products, "purchase.products");
            String str2 = (String) CollectionsKt.firstOrNull(products);
            String str3 = "";
            if (str2 == null) {
                str2 = str3;
            }
            String purchaseToken = purchase.getPurchaseToken();
            Intrinsics.checkNotNullExpressionValue(purchaseToken, "purchase.purchaseToken");
            boolean isSubscription = purchaseableProduct.isSubscription();
            String variationId = purchaseableProduct.getVariationId();
            if (currentOfferDetails == null) {
                List<String> products2 = purchase.getProducts();
                Intrinsics.checkNotNullExpressionValue(products2, "purchase.products");
                String str4 = (String) CollectionsKt.firstOrNull(products2);
                if (str4 != null) {
                    str3 = str4;
                }
                purchasedProductDetails = new PurchasedProductDetails(str3, new PurchasedProductDetails.OneTime(purchaseableProduct.getPriceAmountMicros(), purchaseableProduct.getCurrencyCode()), (List<PurchasedProductDetails.Sub>) null);
            } else {
                List<String> products3 = purchase.getProducts();
                Intrinsics.checkNotNullExpressionValue(products3, "purchase.products");
                String str5 = (String) CollectionsKt.firstOrNull(products3);
                if (str5 != null) {
                    str3 = str5;
                }
                String basePlanId = currentOfferDetails.getBasePlanId();
                Intrinsics.checkNotNullExpressionValue(basePlanId, "offerDetails.basePlanId");
                String offerId = currentOfferDetails.getOfferId();
                List<ProductDetails.PricingPhase> pricingPhaseList = currentOfferDetails.getPricingPhases().getPricingPhaseList();
                Intrinsics.checkNotNullExpressionValue(pricingPhaseList, "offerDetails.pricingPhases.pricingPhaseList");
                Iterable iterable = pricingPhaseList;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Iterator it = iterable.iterator(); it.hasNext(); it = it) {
                    ProductDetails.PricingPhase pricingPhase = (ProductDetails.PricingPhase) it.next();
                    long priceAmountMicros = pricingPhase.getPriceAmountMicros();
                    String priceCurrencyCode = pricingPhase.getPriceCurrencyCode();
                    Intrinsics.checkNotNullExpressionValue(priceCurrencyCode, "pricingPhase.priceCurrencyCode");
                    String billingPeriod = pricingPhase.getBillingPeriod();
                    Intrinsics.checkNotNullExpressionValue(billingPeriod, "pricingPhase.billingPeriod");
                    int recurrenceMode = pricingPhase.getRecurrenceMode();
                    int billingCycleCount = pricingPhase.getBillingCycleCount();
                    PurchasedProductDetails.Sub.PricingPhase pricingPhase2 = r12;
                    PurchasedProductDetails.Sub.PricingPhase pricingPhase3 = new PurchasedProductDetails.Sub.PricingPhase(priceAmountMicros, priceCurrencyCode, billingPeriod, recurrenceMode, billingCycleCount);
                    arrayList.add(pricingPhase2);
                }
                purchasedProductDetails = new PurchasedProductDetails(str3, (PurchasedProductDetails.OneTime) null, CollectionsKt.listOf(new PurchasedProductDetails.Sub(basePlanId, offerId, (List) arrayList)));
            }
            String str6 = str;
            return new ValidateReceiptRequest(new Data(str6, (String) null, new Data.Attributes(str6, str2, purchaseToken, isSubscription, variationId, purchasedProductDetails), 2, (DefaultConstructorMarker) null));
        }
    }
}
