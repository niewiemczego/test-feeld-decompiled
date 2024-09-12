package com.adapty.models;

import com.adapty.utils.ImmutableList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u001eBK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/adapty/models/AdaptyProductSubscriptionDetails;", "", "basePlanId", "", "offerId", "offerTags", "Lcom/adapty/utils/ImmutableList;", "renewalType", "Lcom/adapty/models/AdaptyProductSubscriptionDetails$RenewalType;", "subscriptionPeriod", "Lcom/adapty/models/AdaptyProductSubscriptionPeriod;", "localizedSubscriptionPeriod", "introductoryOfferPhases", "Lcom/adapty/models/AdaptyProductDiscountPhase;", "(Ljava/lang/String;Ljava/lang/String;Lcom/adapty/utils/ImmutableList;Lcom/adapty/models/AdaptyProductSubscriptionDetails$RenewalType;Lcom/adapty/models/AdaptyProductSubscriptionPeriod;Ljava/lang/String;Lcom/adapty/utils/ImmutableList;)V", "getBasePlanId", "()Ljava/lang/String;", "introductoryOfferEligibility", "Lcom/adapty/models/AdaptyEligibility;", "getIntroductoryOfferEligibility", "()Lcom/adapty/models/AdaptyEligibility;", "getIntroductoryOfferPhases", "()Lcom/adapty/utils/ImmutableList;", "getLocalizedSubscriptionPeriod", "getOfferId", "getOfferTags", "getRenewalType", "()Lcom/adapty/models/AdaptyProductSubscriptionDetails$RenewalType;", "getSubscriptionPeriod", "()Lcom/adapty/models/AdaptyProductSubscriptionPeriod;", "RenewalType", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyProductSubscriptionDetails.kt */
public final class AdaptyProductSubscriptionDetails {
    private final String basePlanId;
    private final ImmutableList<AdaptyProductDiscountPhase> introductoryOfferPhases;
    private final String localizedSubscriptionPeriod;
    private final String offerId;
    private final ImmutableList<String> offerTags;
    private final RenewalType renewalType;
    private final AdaptyProductSubscriptionPeriod subscriptionPeriod;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/adapty/models/AdaptyProductSubscriptionDetails$RenewalType;", "", "(Ljava/lang/String;I)V", "AUTORENEWABLE", "PREPAID", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyProductSubscriptionDetails.kt */
    public enum RenewalType {
        AUTORENEWABLE,
        PREPAID
    }

    public AdaptyProductSubscriptionDetails(String str, String str2, ImmutableList<String> immutableList, RenewalType renewalType2, AdaptyProductSubscriptionPeriod adaptyProductSubscriptionPeriod, String str3, ImmutableList<AdaptyProductDiscountPhase> immutableList2) {
        Intrinsics.checkNotNullParameter(str, "basePlanId");
        Intrinsics.checkNotNullParameter(immutableList, "offerTags");
        Intrinsics.checkNotNullParameter(renewalType2, "renewalType");
        Intrinsics.checkNotNullParameter(adaptyProductSubscriptionPeriod, "subscriptionPeriod");
        Intrinsics.checkNotNullParameter(str3, "localizedSubscriptionPeriod");
        Intrinsics.checkNotNullParameter(immutableList2, "introductoryOfferPhases");
        this.basePlanId = str;
        this.offerId = str2;
        this.offerTags = immutableList;
        this.renewalType = renewalType2;
        this.subscriptionPeriod = adaptyProductSubscriptionPeriod;
        this.localizedSubscriptionPeriod = str3;
        this.introductoryOfferPhases = immutableList2;
    }

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    public final String getOfferId() {
        return this.offerId;
    }

    public final ImmutableList<String> getOfferTags() {
        return this.offerTags;
    }

    public final RenewalType getRenewalType() {
        return this.renewalType;
    }

    public final AdaptyProductSubscriptionPeriod getSubscriptionPeriod() {
        return this.subscriptionPeriod;
    }

    public final String getLocalizedSubscriptionPeriod() {
        return this.localizedSubscriptionPeriod;
    }

    public final ImmutableList<AdaptyProductDiscountPhase> getIntroductoryOfferPhases() {
        return this.introductoryOfferPhases;
    }

    public final AdaptyEligibility getIntroductoryOfferEligibility() {
        if (this.renewalType == RenewalType.PREPAID) {
            return AdaptyEligibility.NOT_APPLICABLE;
        }
        if (this.introductoryOfferPhases.isEmpty()) {
            return AdaptyEligibility.INELIGIBLE;
        }
        return AdaptyEligibility.ELIGIBLE;
    }
}
