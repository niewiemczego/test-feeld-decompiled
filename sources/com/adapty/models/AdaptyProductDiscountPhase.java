package com.adapty.models;

import com.adapty.models.AdaptyPaywallProduct;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001eB5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/adapty/models/AdaptyProductDiscountPhase;", "", "price", "Lcom/adapty/models/AdaptyPaywallProduct$Price;", "numberOfPeriods", "", "paymentMode", "Lcom/adapty/models/AdaptyProductDiscountPhase$PaymentMode;", "localizedNumberOfPeriods", "", "subscriptionPeriod", "Lcom/adapty/models/AdaptyProductSubscriptionPeriod;", "localizedSubscriptionPeriod", "(Lcom/adapty/models/AdaptyPaywallProduct$Price;ILcom/adapty/models/AdaptyProductDiscountPhase$PaymentMode;Ljava/lang/String;Lcom/adapty/models/AdaptyProductSubscriptionPeriod;Ljava/lang/String;)V", "getLocalizedNumberOfPeriods", "()Ljava/lang/String;", "getLocalizedSubscriptionPeriod", "getNumberOfPeriods", "()I", "getPaymentMode", "()Lcom/adapty/models/AdaptyProductDiscountPhase$PaymentMode;", "getPrice", "()Lcom/adapty/models/AdaptyPaywallProduct$Price;", "getSubscriptionPeriod", "()Lcom/adapty/models/AdaptyProductSubscriptionPeriod;", "equals", "", "other", "hashCode", "toString", "PaymentMode", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyProductDiscountPhase.kt */
public final class AdaptyProductDiscountPhase {
    private final String localizedNumberOfPeriods;
    private final String localizedSubscriptionPeriod;
    private final int numberOfPeriods;
    private final PaymentMode paymentMode;
    private final AdaptyPaywallProduct.Price price;
    private final AdaptyProductSubscriptionPeriod subscriptionPeriod;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/models/AdaptyProductDiscountPhase$PaymentMode;", "", "(Ljava/lang/String;I)V", "PAY_AS_YOU_GO", "PAY_UPFRONT", "FREE_TRIAL", "UNKNOWN", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyProductDiscountPhase.kt */
    public enum PaymentMode {
        PAY_AS_YOU_GO,
        PAY_UPFRONT,
        FREE_TRIAL,
        UNKNOWN
    }

    public AdaptyProductDiscountPhase(AdaptyPaywallProduct.Price price2, int i, PaymentMode paymentMode2, String str, AdaptyProductSubscriptionPeriod adaptyProductSubscriptionPeriod, String str2) {
        Intrinsics.checkNotNullParameter(price2, FirebaseAnalytics.Param.PRICE);
        Intrinsics.checkNotNullParameter(paymentMode2, "paymentMode");
        Intrinsics.checkNotNullParameter(str, "localizedNumberOfPeriods");
        Intrinsics.checkNotNullParameter(adaptyProductSubscriptionPeriod, "subscriptionPeriod");
        Intrinsics.checkNotNullParameter(str2, "localizedSubscriptionPeriod");
        this.price = price2;
        this.numberOfPeriods = i;
        this.paymentMode = paymentMode2;
        this.localizedNumberOfPeriods = str;
        this.subscriptionPeriod = adaptyProductSubscriptionPeriod;
        this.localizedSubscriptionPeriod = str2;
    }

    public final AdaptyPaywallProduct.Price getPrice() {
        return this.price;
    }

    public final int getNumberOfPeriods() {
        return this.numberOfPeriods;
    }

    public final PaymentMode getPaymentMode() {
        return this.paymentMode;
    }

    public final String getLocalizedNumberOfPeriods() {
        return this.localizedNumberOfPeriods;
    }

    public final AdaptyProductSubscriptionPeriod getSubscriptionPeriod() {
        return this.subscriptionPeriod;
    }

    public final String getLocalizedSubscriptionPeriod() {
        return this.localizedSubscriptionPeriod;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.models.AdaptyProductDiscountPhase");
        AdaptyProductDiscountPhase adaptyProductDiscountPhase = (AdaptyProductDiscountPhase) obj;
        return Intrinsics.areEqual((Object) this.price, (Object) adaptyProductDiscountPhase.price) && this.numberOfPeriods == adaptyProductDiscountPhase.numberOfPeriods && this.paymentMode == adaptyProductDiscountPhase.paymentMode && Intrinsics.areEqual((Object) this.localizedNumberOfPeriods, (Object) adaptyProductDiscountPhase.localizedNumberOfPeriods) && Intrinsics.areEqual((Object) this.subscriptionPeriod, (Object) adaptyProductDiscountPhase.subscriptionPeriod) && Intrinsics.areEqual((Object) this.localizedSubscriptionPeriod, (Object) adaptyProductDiscountPhase.localizedSubscriptionPeriod);
    }

    public int hashCode() {
        return (((((((((this.price.hashCode() * 31) + this.numberOfPeriods) * 31) + this.paymentMode.hashCode()) * 31) + this.localizedNumberOfPeriods.hashCode()) * 31) + this.subscriptionPeriod.hashCode()) * 31) + this.localizedSubscriptionPeriod.hashCode();
    }

    public String toString() {
        return "AdaptySubscriptionPhase(price=" + this.price + ", numberOfPeriods=" + this.numberOfPeriods + ", paymentMode=" + this.paymentMode + ", localizedNumberOfPeriods=" + this.localizedNumberOfPeriods + ", subscriptionPeriod=" + this.subscriptionPeriod + ", localizedSubscriptionPeriod=" + this.localizedSubscriptionPeriod + ')';
    }
}
