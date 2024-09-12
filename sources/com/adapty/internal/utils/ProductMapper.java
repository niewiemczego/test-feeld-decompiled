package com.adapty.internal.utils;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.adapty.R;
import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.internal.crossplatform.AdaptyPaywallTypeAdapterFactory;
import com.adapty.internal.data.models.ProductDto;
import com.adapty.internal.data.models.PurchaseRecordModel;
import com.adapty.internal.data.models.RestoreProductInfo;
import com.adapty.internal.data.models.SyncedPurchase;
import com.adapty.internal.data.models.requests.PurchasedProductDetails;
import com.adapty.internal.domain.models.BackendProduct;
import com.adapty.internal.domain.models.ProductType;
import com.adapty.internal.domain.models.PurchaseableProduct;
import com.adapty.models.AdaptyPaywall;
import com.adapty.models.AdaptyPaywallProduct;
import com.adapty.models.AdaptyPeriodUnit;
import com.adapty.models.AdaptyProductDiscountPhase;
import com.adapty.models.AdaptyProductSubscriptionDetails;
import com.adapty.models.AdaptyProductSubscriptionPeriod;
import com.adapty.utils.AdaptyLogLevel;
import com.adapty.utils.ImmutableList;
import com.android.billingclient.api.ProductDetails;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0018H\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ \u0010\u0019\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000e2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000eJ6\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000e2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020 0\b2\u0006\u0010!\u001a\u00020\"J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u001e\u0010'\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010)\u001a\u00020*J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010/\u001a\u0002002\u0006\u0010-\u001a\u00020.J\u0018\u00101\u001a\n 3*\u0004\u0018\u000102022\u0006\u00104\u001a\u000205H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/adapty/internal/utils/ProductMapper;", "", "context", "Landroid/content/Context;", "currencyHelper", "Lcom/adapty/internal/utils/CurrencyHelper;", "(Landroid/content/Context;Lcom/adapty/internal/utils/CurrencyHelper;)V", "discountPeriodMultipliers", "", "", "", "findCurrentOffer", "Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;", "subOfferDetails", "", "subData", "Lcom/adapty/internal/domain/models/BackendProduct$SubscriptionData;", "getPeriodNumberOfUnits", "period", "getPeriodUnit", "Lcom/adapty/models/AdaptyPeriodUnit;", "localize", "unit", "numberOfUnits", "Lcom/adapty/models/AdaptyProductSubscriptionPeriod;", "map", "Lcom/adapty/internal/domain/models/BackendProduct;", "productDto", "Lcom/adapty/internal/data/models/ProductDto;", "Lcom/adapty/models/AdaptyPaywallProduct;", "product", "productDetails", "Lcom/android/billingclient/api/ProductDetails;", "paywall", "Lcom/adapty/models/AdaptyPaywall;", "productDtos", "products", "billingInfo", "mapSubscriptionPeriod", "mapToPurchaseableProduct", "Lcom/adapty/internal/domain/models/PurchaseableProduct;", "isOfferPersonalized", "", "mapToRestore", "Lcom/adapty/internal/data/models/RestoreProductInfo;", "purchaseRecord", "Lcom/adapty/internal/data/models/PurchaseRecordModel;", "mapToSyncedPurchase", "Lcom/adapty/internal/data/models/SyncedPurchase;", "priceFromMicros", "Ljava/math/BigDecimal;", "kotlin.jvm.PlatformType", "priceAmountMicros", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProductMapper.kt */
public final class ProductMapper {
    private final Context context;
    private final CurrencyHelper currencyHelper;
    /* access modifiers changed from: private */
    public final Map<String, Integer> discountPeriodMultipliers = MapsKt.mapOf(TuplesKt.to("Y", 365), TuplesKt.to("M", 30), TuplesKt.to(ExifInterface.LONGITUDE_WEST, 7), TuplesKt.to("D", 1));

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ProductMapper.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.adapty.models.AdaptyPeriodUnit[] r0 = com.adapty.models.AdaptyPeriodUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.adapty.models.AdaptyPeriodUnit r1 = com.adapty.models.AdaptyPeriodUnit.DAY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.adapty.models.AdaptyPeriodUnit r1 = com.adapty.models.AdaptyPeriodUnit.WEEK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.adapty.models.AdaptyPeriodUnit r1 = com.adapty.models.AdaptyPeriodUnit.MONTH     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.adapty.models.AdaptyPeriodUnit r1 = com.adapty.models.AdaptyPeriodUnit.YEAR     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.ProductMapper.WhenMappings.<clinit>():void");
        }
    }

    public ProductMapper(Context context2, CurrencyHelper currencyHelper2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(currencyHelper2, "currencyHelper");
        this.context = context2;
        this.currencyHelper = currencyHelper2;
    }

    public final /* synthetic */ List map(List list, Map map, AdaptyPaywall adaptyPaywall) {
        AdaptyPaywallProduct adaptyPaywallProduct;
        Intrinsics.checkNotNullParameter(list, AdaptyPaywallTypeAdapterFactory.PRODUCTS);
        Intrinsics.checkNotNullParameter(map, "billingInfo");
        Intrinsics.checkNotNullParameter(adaptyPaywall, "paywall");
        Collection arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BackendProduct backendProduct = (BackendProduct) it.next();
            ProductDetails productDetails = (ProductDetails) map.get(backendProduct.getVendorProductId());
            if (productDetails != null) {
                adaptyPaywallProduct = map(backendProduct, productDetails, adaptyPaywall);
            } else {
                adaptyPaywallProduct = null;
            }
            if (adaptyPaywallProduct != null) {
                arrayList.add(adaptyPaywallProduct);
            }
        }
        return (List) arrayList;
    }

    public final /* synthetic */ AdaptyPaywallProduct map(BackendProduct backendProduct, ProductDetails productDetails, AdaptyPaywall adaptyPaywall) {
        BackendProduct.SubscriptionData subscriptionData;
        String str;
        long j;
        String str2;
        AdaptyProductSubscriptionDetails adaptyProductSubscriptionDetails;
        AdaptyProductSubscriptionDetails.RenewalType renewalType;
        AdaptyProductDiscountPhase.PaymentMode paymentMode;
        boolean z;
        AdaptyProductDiscountPhase.PaymentMode paymentMode2;
        StringBuilder sb;
        StringBuilder sb2;
        Intrinsics.checkNotNullParameter(backendProduct, "product");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        Intrinsics.checkNotNullParameter(adaptyPaywall, "paywall");
        if (backendProduct.getType() instanceof ProductType.Subscription) {
            List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails = productDetails.getSubscriptionOfferDetails();
            if (subscriptionOfferDetails == null) {
                Logger logger = Logger.INSTANCE;
                AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.ERROR;
                if (logger.canLog(adaptyLogLevel.value)) {
                    logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "Subscription data was not found for the product " + backendProduct.getVendorProductId()));
                }
                return null;
            }
            BackendProduct.SubscriptionData subscriptionData2 = ((ProductType.Subscription) backendProduct.getType()).getSubscriptionData();
            String basePlanId = subscriptionData2.getBasePlanId();
            String offerId = subscriptionData2.getOfferId();
            ProductDetails.SubscriptionOfferDetails findCurrentOffer = findCurrentOffer(subscriptionOfferDetails, subscriptionData2);
            if (findCurrentOffer == null) {
                Logger logger2 = Logger.INSTANCE;
                AdaptyLogLevel adaptyLogLevel2 = AdaptyLogLevel.ERROR;
                if (logger2.canLog(adaptyLogLevel2.value)) {
                    logger2.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel2, "Base plan " + basePlanId + " was not found for the product " + backendProduct.getVendorProductId()));
                }
                return null;
            }
            if (findCurrentOffer.getOfferId() == null && offerId != null) {
                Logger logger3 = Logger.INSTANCE;
                AdaptyLogLevel adaptyLogLevel3 = AdaptyLogLevel.WARN;
                if (logger3.canLog(adaptyLogLevel3.value)) {
                    logger3.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel3, "Offer " + offerId + " was not found for the base plan " + basePlanId + " for the product " + backendProduct.getVendorProductId()));
                }
            }
            List<ProductDetails.PricingPhase> pricingPhaseList = findCurrentOffer.getPricingPhases().getPricingPhaseList();
            Intrinsics.checkNotNullExpressionValue(pricingPhaseList, "offer.pricingPhases.pricingPhaseList");
            ProductDetails.PricingPhase pricingPhase = (ProductDetails.PricingPhase) CollectionsKt.lastOrNull(pricingPhaseList);
            if (pricingPhase == null) {
                Logger logger4 = Logger.INSTANCE;
                AdaptyLogLevel adaptyLogLevel4 = AdaptyLogLevel.ERROR;
                if (logger4.canLog(adaptyLogLevel4.value)) {
                    StringBuilder append = new StringBuilder().append("Subscription price was not found for the ");
                    if (offerId == null) {
                        sb2 = sb.append("base plan ").append(basePlanId);
                    } else {
                        sb = new StringBuilder();
                        sb2 = sb.append("offer ").append(basePlanId).append(':').append(offerId);
                    }
                    logger4.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel4, append.append(sb2.toString()).append(" for the product ").append(backendProduct.getVendorProductId()).toString()));
                }
                return null;
            }
            long priceAmountMicros = pricingPhase.getPriceAmountMicros();
            str2 = pricingPhase.getFormattedPrice();
            Intrinsics.checkNotNullExpressionValue(str2, "basePriceInfo.formattedPrice");
            String priceCurrencyCode = pricingPhase.getPriceCurrencyCode();
            Intrinsics.checkNotNullExpressionValue(priceCurrencyCode, "basePriceInfo.priceCurrencyCode");
            String basePlanId2 = findCurrentOffer.getBasePlanId();
            Intrinsics.checkNotNullExpressionValue(basePlanId2, "offer.basePlanId");
            subscriptionData = new BackendProduct.SubscriptionData(basePlanId2, findCurrentOffer.getOfferId());
            String billingPeriod = pricingPhase.getBillingPeriod();
            Intrinsics.checkNotNullExpressionValue(billingPeriod, "basePriceInfo.billingPeriod");
            AdaptyProductSubscriptionPeriod mapSubscriptionPeriod = mapSubscriptionPeriod(billingPeriod);
            List<String> offerTags = findCurrentOffer.getOfferTags();
            Intrinsics.checkNotNullExpressionValue(offerTags, "offer.offerTags");
            ImmutableList immutableWithInterop = Intrinsics.checkNotNullParameter(offerTags, "<this>");
            if (pricingPhase.getRecurrenceMode() == 3) {
                renewalType = AdaptyProductSubscriptionDetails.RenewalType.PREPAID;
            } else {
                renewalType = AdaptyProductSubscriptionDetails.RenewalType.AUTORENEWABLE;
            }
            AdaptyProductSubscriptionDetails.RenewalType renewalType2 = renewalType;
            String localize = localize(mapSubscriptionPeriod);
            List<ProductDetails.PricingPhase> pricingPhaseList2 = findCurrentOffer.getPricingPhases().getPricingPhaseList();
            Intrinsics.checkNotNullExpressionValue(pricingPhaseList2, "offer.pricingPhases.pricingPhaseList");
            Iterable dropLast = CollectionsKt.dropLast(pricingPhaseList2, 1);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(dropLast, 10));
            Iterator it = dropLast.iterator();
            while (it.hasNext()) {
                ProductDetails.PricingPhase pricingPhase2 = (ProductDetails.PricingPhase) it.next();
                String billingPeriod2 = pricingPhase2.getBillingPeriod();
                Iterator it2 = it;
                Intrinsics.checkNotNullExpressionValue(billingPeriod2, "phase.billingPeriod");
                AdaptyProductSubscriptionPeriod mapSubscriptionPeriod2 = mapSubscriptionPeriod(billingPeriod2);
                int billingCycleCount = pricingPhase2.getBillingCycleCount();
                String str3 = str2;
                BigDecimal priceFromMicros = priceFromMicros(pricingPhase2.getPriceAmountMicros());
                Intrinsics.checkNotNullExpressionValue(priceFromMicros, "priceFromMicros(phase.priceAmountMicros)");
                String formattedPrice = pricingPhase2.getFormattedPrice();
                String str4 = priceCurrencyCode;
                Intrinsics.checkNotNullExpressionValue(formattedPrice, "phase.formattedPrice");
                String priceCurrencyCode2 = pricingPhase2.getPriceCurrencyCode();
                long j2 = priceAmountMicros;
                Intrinsics.checkNotNullExpressionValue(priceCurrencyCode2, "phase.priceCurrencyCode");
                CurrencyHelper currencyHelper2 = this.currencyHelper;
                BackendProduct.SubscriptionData subscriptionData3 = subscriptionData;
                String priceCurrencyCode3 = pricingPhase2.getPriceCurrencyCode();
                Intrinsics.checkNotNullExpressionValue(priceCurrencyCode3, "phase.priceCurrencyCode");
                AdaptyPaywallProduct.Price price = new AdaptyPaywallProduct.Price(priceFromMicros, formattedPrice, priceCurrencyCode2, currencyHelper2.getCurrencySymbol(priceCurrencyCode3));
                if (pricingPhase2.getPriceAmountMicros() == 0) {
                    paymentMode = AdaptyProductDiscountPhase.PaymentMode.FREE_TRIAL;
                    z = true;
                } else {
                    z = true;
                    if (pricingPhase2.getBillingCycleCount() > 1) {
                        paymentMode2 = AdaptyProductDiscountPhase.PaymentMode.PAY_AS_YOU_GO;
                    } else {
                        paymentMode2 = AdaptyProductDiscountPhase.PaymentMode.PAY_UPFRONT;
                    }
                    paymentMode = paymentMode2;
                }
                arrayList.add(new AdaptyProductDiscountPhase(price, billingCycleCount, paymentMode, localize(mapSubscriptionPeriod2.getUnit(), mapSubscriptionPeriod2.getNumberOfUnits() * billingCycleCount), mapSubscriptionPeriod2, localize(mapSubscriptionPeriod2)));
                AdaptyPaywall adaptyPaywall2 = adaptyPaywall;
                boolean z2 = z;
                it = it2;
                str2 = str3;
                priceCurrencyCode = str4;
                priceAmountMicros = j2;
                subscriptionData = subscriptionData3;
            }
            String str5 = str2;
            long j3 = priceAmountMicros;
            BackendProduct.SubscriptionData subscriptionData4 = subscriptionData;
            adaptyProductSubscriptionDetails = new AdaptyProductSubscriptionDetails(basePlanId, offerId, immutableWithInterop, renewalType2, mapSubscriptionPeriod, localize, Intrinsics.checkNotNullParameter((List) arrayList, "<this>"));
            str = priceCurrencyCode;
            j = j3;
        } else {
            ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails();
            if (oneTimePurchaseOfferDetails == null) {
                Logger logger5 = Logger.INSTANCE;
                AdaptyLogLevel adaptyLogLevel5 = AdaptyLogLevel.ERROR;
                if (logger5.canLog(adaptyLogLevel5.value)) {
                    logger5.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel5, "In-app data was not found for the product " + backendProduct.getVendorProductId()));
                }
                return null;
            }
            long priceAmountMicros2 = oneTimePurchaseOfferDetails.getPriceAmountMicros();
            String formattedPrice2 = oneTimePurchaseOfferDetails.getFormattedPrice();
            Intrinsics.checkNotNullExpressionValue(formattedPrice2, "inappDetails.formattedPrice");
            String priceCurrencyCode4 = oneTimePurchaseOfferDetails.getPriceCurrencyCode();
            Intrinsics.checkNotNullExpressionValue(priceCurrencyCode4, "inappDetails.priceCurrencyCode");
            adaptyProductSubscriptionDetails = null;
            subscriptionData = null;
            str2 = formattedPrice2;
            long j4 = priceAmountMicros2;
            str = priceCurrencyCode4;
            j = j4;
        }
        String vendorProductId = backendProduct.getVendorProductId();
        String name = productDetails.getName();
        Intrinsics.checkNotNullExpressionValue(name, "productDetails.name");
        String description = productDetails.getDescription();
        Intrinsics.checkNotNullExpressionValue(description, "productDetails.description");
        String name2 = adaptyPaywall.getName();
        String abTestName = adaptyPaywall.getAbTestName();
        String variationId = adaptyPaywall.getVariationId();
        BigDecimal priceFromMicros2 = priceFromMicros(j);
        Intrinsics.checkNotNullExpressionValue(priceFromMicros2, "priceFromMicros(priceAmountMicros)");
        return new AdaptyPaywallProduct(vendorProductId, name, description, name2, abTestName, variationId, new AdaptyPaywallProduct.Price(priceFromMicros2, str2, str, this.currencyHelper.getCurrencySymbol(str)), adaptyProductSubscriptionDetails, productDetails, new AdaptyPaywallProduct.Payload(j, str, backendProduct.getType().toString(), subscriptionData));
    }

    public final /* synthetic */ List map(List list) {
        Intrinsics.checkNotNullParameter(list, "productDtos");
        Iterable<ProductDto> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProductDto map : iterable) {
            arrayList.add(map(map));
        }
        return (List) arrayList;
    }

    public final /* synthetic */ BackendProduct map(ProductDto productDto) {
        ProductType productType;
        Intrinsics.checkNotNullParameter(productDto, "productDto");
        String id = productDto.getId();
        if (id != null) {
            String vendorProductId = productDto.getVendorProductId();
            if (vendorProductId != null) {
                if (productDto.getBasePlanId() != null) {
                    productType = new ProductType.Subscription(new BackendProduct.SubscriptionData(productDto.getBasePlanId(), productDto.getOfferId()));
                } else if (Intrinsics.areEqual((Object) productDto.isConsumable(), (Object) true)) {
                    productType = ProductType.Consumable.INSTANCE;
                } else {
                    productType = ProductType.NonConsumable.INSTANCE;
                }
                ProductType productType2 = productType;
                Long timestamp = productDto.getTimestamp();
                return new BackendProduct(id, vendorProductId, timestamp != null ? timestamp.longValue() : 0, productType2);
            }
            throw new AdaptyError((Throwable) null, "vendorProductId in Product should not be null", AdaptyErrorCode.DECODING_FAILED, 1, (DefaultConstructorMarker) null);
        }
        throw new AdaptyError((Throwable) null, "id in Product should not be null", AdaptyErrorCode.DECODING_FAILED, 1, (DefaultConstructorMarker) null);
    }

    public final /* synthetic */ PurchaseableProduct mapToPurchaseableProduct(AdaptyPaywallProduct adaptyPaywallProduct, ProductDetails productDetails, boolean z) {
        Intrinsics.checkNotNullParameter(adaptyPaywallProduct, "product");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        BackendProduct.SubscriptionData subscriptionData = adaptyPaywallProduct.getPayloadData$adapty_release().getSubscriptionData();
        List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails = productDetails.getSubscriptionOfferDetails();
        return new PurchaseableProduct(adaptyPaywallProduct.getVendorProductId(), adaptyPaywallProduct.getPayloadData$adapty_release().getType(), adaptyPaywallProduct.getPayloadData$adapty_release().getPriceAmountMicros(), adaptyPaywallProduct.getPayloadData$adapty_release().getCurrencyCode(), adaptyPaywallProduct.getVariationId(), (subscriptionOfferDetails == null || subscriptionData == null) ? null : findCurrentOffer(subscriptionOfferDetails, subscriptionData), z, productDetails);
    }

    public final /* synthetic */ RestoreProductInfo mapToRestore(PurchaseRecordModel purchaseRecordModel, ProductDetails productDetails) {
        Intrinsics.checkNotNullParameter(purchaseRecordModel, "purchaseRecord");
        return new RestoreProductInfo(Boolean.valueOf(Intrinsics.areEqual((Object) purchaseRecordModel.getType(), (Object) "subs")), (String) CollectionsKt.firstOrNull(purchaseRecordModel.getProducts()), purchaseRecordModel.getPurchaseToken(), productDetails != null ? PurchasedProductDetails.Companion.create(productDetails) : null);
    }

    public final /* synthetic */ SyncedPurchase mapToSyncedPurchase(PurchaseRecordModel purchaseRecordModel) {
        Intrinsics.checkNotNullParameter(purchaseRecordModel, "purchaseRecord");
        return new SyncedPurchase(purchaseRecordModel.getPurchaseToken(), Long.valueOf(purchaseRecordModel.getPurchaseTime()));
    }

    private final AdaptyProductSubscriptionPeriod mapSubscriptionPeriod(String str) {
        AdaptyPeriodUnit periodUnit = getPeriodUnit(str);
        int periodNumberOfUnits = getPeriodNumberOfUnits(str);
        AdaptyPeriodUnit adaptyPeriodUnit = periodNumberOfUnits == 0 ? AdaptyPeriodUnit.UNKNOWN : periodUnit;
        if (periodUnit == AdaptyPeriodUnit.UNKNOWN) {
            periodNumberOfUnits = 0;
        }
        return new AdaptyProductSubscriptionPeriod(adaptyPeriodUnit, periodNumberOfUnits);
    }

    private final BigDecimal priceFromMicros(long j) {
        BigDecimal divide;
        Long valueOf = Long.valueOf(j);
        if (!(valueOf.longValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            BigDecimal valueOf2 = BigDecimal.valueOf(valueOf.longValue());
            Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(this)");
            if (!(valueOf2 == null || (divide = valueOf2.divide(BigDecimal.valueOf(1000000))) == null)) {
                return divide;
            }
        }
        return BigDecimal.ZERO;
    }

    private final ProductDetails.SubscriptionOfferDetails findCurrentOffer(List<ProductDetails.SubscriptionOfferDetails> list, BackendProduct.SubscriptionData subscriptionData) {
        String basePlanId = subscriptionData.getBasePlanId();
        String offerId = subscriptionData.getOfferId();
        ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails = null;
        for (ProductDetails.SubscriptionOfferDetails next : list) {
            if (Intrinsics.areEqual((Object) next.getBasePlanId(), (Object) basePlanId)) {
                if (Intrinsics.areEqual((Object) next.getOfferId(), (Object) offerId)) {
                    return next;
                }
                if (next.getOfferId() == null) {
                    subscriptionOfferDetails = next;
                }
            }
        }
        return subscriptionOfferDetails;
    }

    private final AdaptyPeriodUnit getPeriodUnit(String str) {
        Character lastOrNull = StringsKt.lastOrNull(str);
        boolean z = false;
        if ((lastOrNull != null && lastOrNull.charValue() == 'D') || (lastOrNull != null && lastOrNull.charValue() == 'd')) {
            return AdaptyPeriodUnit.DAY;
        }
        if ((lastOrNull != null && lastOrNull.charValue() == 'W') || (lastOrNull != null && lastOrNull.charValue() == 'w')) {
            return AdaptyPeriodUnit.WEEK;
        }
        if ((lastOrNull != null && lastOrNull.charValue() == 'M') || (lastOrNull != null && lastOrNull.charValue() == 'm')) {
            return AdaptyPeriodUnit.MONTH;
        }
        if ((lastOrNull != null && lastOrNull.charValue() == 'Y') || (lastOrNull != null && lastOrNull.charValue() == 'y')) {
            z = true;
        }
        if (z) {
            return AdaptyPeriodUnit.YEAR;
        }
        return AdaptyPeriodUnit.UNKNOWN;
    }

    private final int getPeriodNumberOfUnits(String str) {
        CharSequence charSequence = str;
        boolean z = true;
        Integer num = null;
        if (!(charSequence.length() == 0)) {
            if (StringsKt.last(charSequence) == 'D') {
                int i = 0;
                for (R intValue : SequencesKt.map(new Regex("\\d+[a-zA-Z]").findAll(charSequence, 0), new ProductMapper$getPeriodNumberOfUnits$1(this))) {
                    i = Integer.valueOf(i.intValue() + intValue.intValue());
                }
                if (i.intValue() <= 0) {
                    z = false;
                }
                if (z) {
                    num = i;
                }
            } else {
                String replace = new Regex("[^0-9]").replace(charSequence, "");
                if (replace.length() <= 0) {
                    z = false;
                }
                if (!z) {
                    replace = null;
                }
                if (replace != null) {
                    num = Integer.valueOf(Integer.parseInt(replace));
                }
            }
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private final String localize(AdaptyProductSubscriptionPeriod adaptyProductSubscriptionPeriod) {
        return localize(adaptyProductSubscriptionPeriod.getUnit(), adaptyProductSubscriptionPeriod.getNumberOfUnits());
    }

    private final String localize(AdaptyPeriodUnit adaptyPeriodUnit, int i) {
        int i2;
        int i3 = WhenMappings.$EnumSwitchMapping$0[adaptyPeriodUnit.ordinal()];
        if (i3 == 1) {
            i2 = R.plurals.adapty_day;
        } else if (i3 == 2) {
            i2 = R.plurals.adapty_week;
        } else if (i3 == 3) {
            i2 = R.plurals.adapty_month;
        } else if (i3 != 4) {
            return "";
        } else {
            i2 = R.plurals.adapty_year;
        }
        String quantityString = this.context.getResources().getQuantityString(i2, i, new Object[]{Integer.valueOf(i)});
        Intrinsics.checkNotNullExpressionValue(quantityString, "context.resources.getQua…erOfUnits, numberOfUnits)");
        return quantityString;
    }
}
