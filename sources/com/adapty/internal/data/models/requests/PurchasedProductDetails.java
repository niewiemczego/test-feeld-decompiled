package com.adapty.internal.data.models.requests;

import com.appsflyer.AppsFlyerProperties;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \n2\u00020\u0001:\u0003\n\u000b\fB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/adapty/internal/data/models/requests/PurchasedProductDetails;", "", "productId", "", "oneTimePurchaseOfferDetails", "Lcom/adapty/internal/data/models/requests/PurchasedProductDetails$OneTime;", "subscriptionOfferDetails", "", "Lcom/adapty/internal/data/models/requests/PurchasedProductDetails$Sub;", "(Ljava/lang/String;Lcom/adapty/internal/data/models/requests/PurchasedProductDetails$OneTime;Ljava/util/List;)V", "Companion", "OneTime", "Sub", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PurchasedProductDetails.kt */
public final class PurchasedProductDetails {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("one_time_purchase_offer_details")
    private final OneTime oneTimePurchaseOfferDetails;
    @SerializedName("product_id")
    private final String productId;
    @SerializedName("subscription_offer_details")
    private final List<Sub> subscriptionOfferDetails;

    public PurchasedProductDetails(String str, OneTime oneTime, List<Sub> list) {
        Intrinsics.checkNotNullParameter(str, "productId");
        this.productId = str;
        this.oneTimePurchaseOfferDetails = oneTime;
        this.subscriptionOfferDetails = list;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/data/models/requests/PurchasedProductDetails$OneTime;", "", "priceAmountMicros", "", "currencyCode", "", "(JLjava/lang/String;)V", "getCurrencyCode", "()Ljava/lang/String;", "getPriceAmountMicros", "()J", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PurchasedProductDetails.kt */
    public static final class OneTime {
        @SerializedName("price_currency_code")
        private final String currencyCode;
        @SerializedName("price_amount_micros")
        private final long priceAmountMicros;

        public OneTime(long j, String str) {
            Intrinsics.checkNotNullParameter(str, AppsFlyerProperties.CURRENCY_CODE);
            this.priceAmountMicros = j;
            this.currencyCode = str;
        }

        public final long getPriceAmountMicros() {
            return this.priceAmountMicros;
        }

        public final String getCurrencyCode() {
            return this.currencyCode;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/adapty/internal/data/models/requests/PurchasedProductDetails$Sub;", "", "basePlanId", "", "offerId", "pricingPhases", "", "Lcom/adapty/internal/data/models/requests/PurchasedProductDetails$Sub$PricingPhase;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBasePlanId", "()Ljava/lang/String;", "getOfferId", "getPricingPhases", "()Ljava/util/List;", "PricingPhase", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PurchasedProductDetails.kt */
    public static final class Sub {
        @SerializedName("base_plan_id")
        private final String basePlanId;
        @SerializedName("offer_id")
        private final String offerId;
        @SerializedName("pricing_phases")
        private final List<PricingPhase> pricingPhases;

        public Sub(String str, String str2, List<PricingPhase> list) {
            Intrinsics.checkNotNullParameter(str, "basePlanId");
            Intrinsics.checkNotNullParameter(list, "pricingPhases");
            this.basePlanId = str;
            this.offerId = str2;
            this.pricingPhases = list;
        }

        public final String getBasePlanId() {
            return this.basePlanId;
        }

        public final String getOfferId() {
            return this.offerId;
        }

        public final List<PricingPhase> getPricingPhases() {
            return this.pricingPhases;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/adapty/internal/data/models/requests/PurchasedProductDetails$Sub$PricingPhase;", "", "priceAmountMicros", "", "currencyCode", "", "billingPeriod", "recurrenceMode", "", "billingCycleCount", "(JLjava/lang/String;Ljava/lang/String;II)V", "getBillingCycleCount", "()I", "getBillingPeriod", "()Ljava/lang/String;", "getCurrencyCode", "getPriceAmountMicros", "()J", "getRecurrenceMode", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: PurchasedProductDetails.kt */
        public static final class PricingPhase {
            @SerializedName("billing_cycle_count")
            private final int billingCycleCount;
            @SerializedName("billing_period")
            private final String billingPeriod;
            @SerializedName("price_currency_code")
            private final String currencyCode;
            @SerializedName("price_amount_micros")
            private final long priceAmountMicros;
            @SerializedName("recurrence_mode")
            private final int recurrenceMode;

            public PricingPhase(long j, String str, String str2, int i, int i2) {
                Intrinsics.checkNotNullParameter(str, AppsFlyerProperties.CURRENCY_CODE);
                Intrinsics.checkNotNullParameter(str2, "billingPeriod");
                this.priceAmountMicros = j;
                this.currencyCode = str;
                this.billingPeriod = str2;
                this.recurrenceMode = i;
                this.billingCycleCount = i2;
            }

            public final long getPriceAmountMicros() {
                return this.priceAmountMicros;
            }

            public final String getCurrencyCode() {
                return this.currencyCode;
            }

            public final String getBillingPeriod() {
                return this.billingPeriod;
            }

            public final int getRecurrenceMode() {
                return this.recurrenceMode;
            }

            public final int getBillingCycleCount() {
                return this.billingCycleCount;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/requests/PurchasedProductDetails$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/requests/PurchasedProductDetails;", "productDetails", "Lcom/android/billingclient/api/ProductDetails;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PurchasedProductDetails.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.util.Collection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.util.List} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.adapty.internal.data.models.requests.PurchasedProductDetails create(com.android.billingclient.api.ProductDetails r18) {
            /*
                r17 = this;
                java.lang.String r0 = "productDetails"
                r1 = r18
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
                java.lang.String r0 = r18.getProductId()
                java.lang.String r2 = "productDetails.productId"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
                com.android.billingclient.api.ProductDetails$OneTimePurchaseOfferDetails r2 = r18.getOneTimePurchaseOfferDetails()
                r3 = 0
                if (r2 == 0) goto L_0x002a
                com.adapty.internal.data.models.requests.PurchasedProductDetails$OneTime r4 = new com.adapty.internal.data.models.requests.PurchasedProductDetails$OneTime
                long r5 = r2.getPriceAmountMicros()
                java.lang.String r2 = r2.getPriceCurrencyCode()
                java.lang.String r7 = "oneTime.priceCurrencyCode"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
                r4.<init>(r5, r2)
                goto L_0x002b
            L_0x002a:
                r4 = r3
            L_0x002b:
                java.util.List r1 = r18.getSubscriptionOfferDetails()
                if (r1 == 0) goto L_0x00c6
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.ArrayList r2 = new java.util.ArrayList
                r3 = 10
                int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r3)
                r2.<init>(r5)
                java.util.Collection r2 = (java.util.Collection) r2
                java.util.Iterator r1 = r1.iterator()
            L_0x0044:
                boolean r5 = r1.hasNext()
                if (r5 == 0) goto L_0x00c3
                java.lang.Object r5 = r1.next()
                com.android.billingclient.api.ProductDetails$SubscriptionOfferDetails r5 = (com.android.billingclient.api.ProductDetails.SubscriptionOfferDetails) r5
                java.lang.String r6 = r5.getBasePlanId()
                java.lang.String r7 = "sub.basePlanId"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
                java.lang.String r7 = r5.getOfferId()
                com.android.billingclient.api.ProductDetails$PricingPhases r5 = r5.getPricingPhases()
                java.util.List r5 = r5.getPricingPhaseList()
                java.lang.String r8 = "sub.pricingPhases.pricingPhaseList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
                java.lang.Iterable r5 = (java.lang.Iterable) r5
                java.util.ArrayList r8 = new java.util.ArrayList
                int r9 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r3)
                r8.<init>(r9)
                java.util.Collection r8 = (java.util.Collection) r8
                java.util.Iterator r5 = r5.iterator()
            L_0x007b:
                boolean r9 = r5.hasNext()
                if (r9 == 0) goto L_0x00b6
                java.lang.Object r9 = r5.next()
                com.android.billingclient.api.ProductDetails$PricingPhase r9 = (com.android.billingclient.api.ProductDetails.PricingPhase) r9
                com.adapty.internal.data.models.requests.PurchasedProductDetails$Sub$PricingPhase r15 = new com.adapty.internal.data.models.requests.PurchasedProductDetails$Sub$PricingPhase
                long r11 = r9.getPriceAmountMicros()
                java.lang.String r13 = r9.getPriceCurrencyCode()
                java.lang.String r10 = "pricingPhase.priceCurrencyCode"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r10)
                java.lang.String r14 = r9.getBillingPeriod()
                java.lang.String r10 = "pricingPhase.billingPeriod"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r10)
                int r16 = r9.getRecurrenceMode()
                int r9 = r9.getBillingCycleCount()
                r10 = r15
                r3 = r15
                r15 = r16
                r16 = r9
                r10.<init>(r11, r13, r14, r15, r16)
                r8.add(r3)
                r3 = 10
                goto L_0x007b
            L_0x00b6:
                java.util.List r8 = (java.util.List) r8
                com.adapty.internal.data.models.requests.PurchasedProductDetails$Sub r3 = new com.adapty.internal.data.models.requests.PurchasedProductDetails$Sub
                r3.<init>(r6, r7, r8)
                r2.add(r3)
                r3 = 10
                goto L_0x0044
            L_0x00c3:
                r3 = r2
                java.util.List r3 = (java.util.List) r3
            L_0x00c6:
                com.adapty.internal.data.models.requests.PurchasedProductDetails r1 = new com.adapty.internal.data.models.requests.PurchasedProductDetails
                r1.<init>(r0, r4, r3)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.models.requests.PurchasedProductDetails.Companion.create(com.android.billingclient.api.ProductDetails):com.adapty.internal.data.models.requests.PurchasedProductDetails");
        }
    }
}
