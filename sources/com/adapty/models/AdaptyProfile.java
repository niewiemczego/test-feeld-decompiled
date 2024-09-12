package com.adapty.models;

import com.adapty.utils.ImmutableList;
import com.adapty.utils.ImmutableMap;
import com.amplitude.reactnative.DatabaseConstants;
import com.android.billingclient.api.BillingClient;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0005\u001d\u001e\u001f !Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R#\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006\""}, d2 = {"Lcom/adapty/models/AdaptyProfile;", "", "profileId", "", "customerUserId", "accessLevels", "Lcom/adapty/utils/ImmutableMap;", "Lcom/adapty/models/AdaptyProfile$AccessLevel;", "subscriptions", "Lcom/adapty/models/AdaptyProfile$Subscription;", "nonSubscriptions", "Lcom/adapty/utils/ImmutableList;", "Lcom/adapty/models/AdaptyProfile$NonSubscription;", "customAttributes", "(Ljava/lang/String;Ljava/lang/String;Lcom/adapty/utils/ImmutableMap;Lcom/adapty/utils/ImmutableMap;Lcom/adapty/utils/ImmutableMap;Lcom/adapty/utils/ImmutableMap;)V", "getAccessLevels", "()Lcom/adapty/utils/ImmutableMap;", "getCustomAttributes", "getCustomerUserId", "()Ljava/lang/String;", "getNonSubscriptions", "getProfileId", "getSubscriptions", "equals", "", "other", "hashCode", "", "toString", "AccessLevel", "Date", "Gender", "NonSubscription", "Subscription", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyProfile.kt */
public final class AdaptyProfile {
    private final ImmutableMap<String, AccessLevel> accessLevels;
    private final ImmutableMap<String, Object> customAttributes;
    private final String customerUserId;
    private final ImmutableMap<String, ImmutableList<NonSubscription>> nonSubscriptions;
    private final String profileId;
    private final ImmutableMap<String, Subscription> subscriptions;

    public AdaptyProfile(String str, String str2, ImmutableMap<String, AccessLevel> immutableMap, ImmutableMap<String, Subscription> immutableMap2, ImmutableMap<String, ImmutableList<NonSubscription>> immutableMap3, ImmutableMap<String, Object> immutableMap4) {
        Intrinsics.checkNotNullParameter(str, "profileId");
        Intrinsics.checkNotNullParameter(immutableMap, "accessLevels");
        Intrinsics.checkNotNullParameter(immutableMap2, BillingClient.FeatureType.SUBSCRIPTIONS);
        Intrinsics.checkNotNullParameter(immutableMap3, "nonSubscriptions");
        Intrinsics.checkNotNullParameter(immutableMap4, "customAttributes");
        this.profileId = str;
        this.customerUserId = str2;
        this.accessLevels = immutableMap;
        this.subscriptions = immutableMap2;
        this.nonSubscriptions = immutableMap3;
        this.customAttributes = immutableMap4;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final String getCustomerUserId() {
        return this.customerUserId;
    }

    public final ImmutableMap<String, AccessLevel> getAccessLevels() {
        return this.accessLevels;
    }

    public final ImmutableMap<String, Subscription> getSubscriptions() {
        return this.subscriptions;
    }

    public final ImmutableMap<String, ImmutableList<NonSubscription>> getNonSubscriptions() {
        return this.nonSubscriptions;
    }

    public final ImmutableMap<String, Object> getCustomAttributes() {
        return this.customAttributes;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.models.AdaptyProfile");
        AdaptyProfile adaptyProfile = (AdaptyProfile) obj;
        return Intrinsics.areEqual((Object) this.profileId, (Object) adaptyProfile.profileId) && Intrinsics.areEqual((Object) this.customerUserId, (Object) adaptyProfile.customerUserId) && Intrinsics.areEqual((Object) this.accessLevels, (Object) adaptyProfile.accessLevels) && Intrinsics.areEqual((Object) this.subscriptions, (Object) adaptyProfile.subscriptions) && Intrinsics.areEqual((Object) this.nonSubscriptions, (Object) adaptyProfile.nonSubscriptions) && Intrinsics.areEqual((Object) this.customAttributes, (Object) adaptyProfile.customAttributes);
    }

    public int hashCode() {
        int hashCode = this.profileId.hashCode() * 31;
        String str = this.customerUserId;
        return ((((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.accessLevels.hashCode()) * 31) + this.subscriptions.hashCode()) * 31) + this.nonSubscriptions.hashCode()) * 31) + this.customAttributes.hashCode();
    }

    public String toString() {
        return "AdaptyProfile(profileId=" + this.profileId + ", customerUserId=" + this.customerUserId + ", accessLevels=" + this.accessLevels + ", subscriptions=" + this.subscriptions + ", nonSubscriptions=" + this.nonSubscriptions + ", customAttributes=" + this.customAttributes + ')';
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B±\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0017J\u0013\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u0003H\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010!R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010!R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010!R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010!R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!¨\u0006."}, d2 = {"Lcom/adapty/models/AdaptyProfile$AccessLevel;", "", "id", "", "isActive", "", "vendorProductId", "offerId", "store", "activatedAt", "startsAt", "renewedAt", "expiresAt", "isLifetime", "cancellationReason", "isRefund", "activeIntroductoryOfferType", "activePromotionalOfferType", "activePromotionalOfferId", "willRenew", "isInGracePeriod", "unsubscribedAt", "billingIssueDetectedAt", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V", "getActivatedAt", "()Ljava/lang/String;", "getActiveIntroductoryOfferType", "getActivePromotionalOfferId", "getActivePromotionalOfferType", "getBillingIssueDetectedAt", "getCancellationReason", "getExpiresAt", "getId", "()Z", "getOfferId", "getRenewedAt", "getStartsAt", "getStore", "getUnsubscribedAt", "getVendorProductId", "getWillRenew", "equals", "other", "hashCode", "", "toString", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyProfile.kt */
    public static final class AccessLevel {
        private final String activatedAt;
        private final String activeIntroductoryOfferType;
        private final String activePromotionalOfferId;
        private final String activePromotionalOfferType;
        private final String billingIssueDetectedAt;
        private final String cancellationReason;
        private final String expiresAt;
        private final String id;
        private final boolean isActive;
        private final boolean isInGracePeriod;
        private final boolean isLifetime;
        private final boolean isRefund;
        private final String offerId;
        private final String renewedAt;
        private final String startsAt;
        private final String store;
        private final String unsubscribedAt;
        private final String vendorProductId;
        private final boolean willRenew;

        public AccessLevel(String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z2, String str9, boolean z3, String str10, String str11, String str12, boolean z4, boolean z5, String str13, String str14) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "vendorProductId");
            Intrinsics.checkNotNullParameter(str4, DatabaseConstants.STORE_TABLE_NAME);
            Intrinsics.checkNotNullParameter(str5, "activatedAt");
            this.id = str;
            this.isActive = z;
            this.vendorProductId = str2;
            this.offerId = str3;
            this.store = str4;
            this.activatedAt = str5;
            this.startsAt = str6;
            this.renewedAt = str7;
            this.expiresAt = str8;
            this.isLifetime = z2;
            this.cancellationReason = str9;
            this.isRefund = z3;
            this.activeIntroductoryOfferType = str10;
            this.activePromotionalOfferType = str11;
            this.activePromotionalOfferId = str12;
            this.willRenew = z4;
            this.isInGracePeriod = z5;
            this.unsubscribedAt = str13;
            this.billingIssueDetectedAt = str14;
        }

        public final String getId() {
            return this.id;
        }

        public final boolean isActive() {
            return this.isActive;
        }

        public final String getVendorProductId() {
            return this.vendorProductId;
        }

        public final String getOfferId() {
            return this.offerId;
        }

        public final String getStore() {
            return this.store;
        }

        public final String getActivatedAt() {
            return this.activatedAt;
        }

        public final String getStartsAt() {
            return this.startsAt;
        }

        public final String getRenewedAt() {
            return this.renewedAt;
        }

        public final String getExpiresAt() {
            return this.expiresAt;
        }

        public final boolean isLifetime() {
            return this.isLifetime;
        }

        public final String getCancellationReason() {
            return this.cancellationReason;
        }

        public final boolean isRefund() {
            return this.isRefund;
        }

        public final String getActiveIntroductoryOfferType() {
            return this.activeIntroductoryOfferType;
        }

        public final String getActivePromotionalOfferType() {
            return this.activePromotionalOfferType;
        }

        public final String getActivePromotionalOfferId() {
            return this.activePromotionalOfferId;
        }

        public final boolean getWillRenew() {
            return this.willRenew;
        }

        public final boolean isInGracePeriod() {
            return this.isInGracePeriod;
        }

        public final String getUnsubscribedAt() {
            return this.unsubscribedAt;
        }

        public final String getBillingIssueDetectedAt() {
            return this.billingIssueDetectedAt;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.models.AdaptyProfile.AccessLevel");
            AccessLevel accessLevel = (AccessLevel) obj;
            return Intrinsics.areEqual((Object) this.id, (Object) accessLevel.id) && this.isActive == accessLevel.isActive && Intrinsics.areEqual((Object) this.vendorProductId, (Object) accessLevel.vendorProductId) && Intrinsics.areEqual((Object) this.offerId, (Object) accessLevel.offerId) && Intrinsics.areEqual((Object) this.store, (Object) accessLevel.store) && Intrinsics.areEqual((Object) this.activatedAt, (Object) accessLevel.activatedAt) && Intrinsics.areEqual((Object) this.startsAt, (Object) accessLevel.startsAt) && Intrinsics.areEqual((Object) this.renewedAt, (Object) accessLevel.renewedAt) && Intrinsics.areEqual((Object) this.expiresAt, (Object) accessLevel.expiresAt) && this.isLifetime == accessLevel.isLifetime && Intrinsics.areEqual((Object) this.cancellationReason, (Object) accessLevel.cancellationReason) && this.isRefund == accessLevel.isRefund && Intrinsics.areEqual((Object) this.activeIntroductoryOfferType, (Object) accessLevel.activeIntroductoryOfferType) && Intrinsics.areEqual((Object) this.activePromotionalOfferType, (Object) accessLevel.activePromotionalOfferType) && Intrinsics.areEqual((Object) this.activePromotionalOfferId, (Object) accessLevel.activePromotionalOfferId) && this.willRenew == accessLevel.willRenew && this.isInGracePeriod == accessLevel.isInGracePeriod && Intrinsics.areEqual((Object) this.unsubscribedAt, (Object) accessLevel.unsubscribedAt) && Intrinsics.areEqual((Object) this.billingIssueDetectedAt, (Object) accessLevel.billingIssueDetectedAt);
        }

        public int hashCode() {
            int hashCode = ((((this.id.hashCode() * 31) + Boolean.hashCode(this.isActive)) * 31) + this.vendorProductId.hashCode()) * 31;
            String str = this.offerId;
            int i = 0;
            int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.store.hashCode()) * 31) + this.activatedAt.hashCode()) * 31;
            String str2 = this.startsAt;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.renewedAt;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.expiresAt;
            int hashCode5 = (((hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + Boolean.hashCode(this.isLifetime)) * 31;
            String str5 = this.cancellationReason;
            int hashCode6 = (((hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + Boolean.hashCode(this.isRefund)) * 31;
            String str6 = this.activeIntroductoryOfferType;
            int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.activePromotionalOfferType;
            int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.activePromotionalOfferId;
            int hashCode9 = (((((hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31) + Boolean.hashCode(this.willRenew)) * 31) + Boolean.hashCode(this.isInGracePeriod)) * 31;
            String str9 = this.unsubscribedAt;
            int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
            String str10 = this.billingIssueDetectedAt;
            if (str10 != null) {
                i = str10.hashCode();
            }
            return hashCode10 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessLevel(id=").append(this.id).append(", isActive=").append(this.isActive).append(", vendorProductId=").append(this.vendorProductId).append(", offerId=").append(this.offerId).append(", store=").append(this.store).append(", activatedAt=").append(this.activatedAt).append(", startsAt=").append(this.startsAt).append(", renewedAt=").append(this.renewedAt).append(", expiresAt=").append(this.expiresAt).append(", isLifetime=").append(this.isLifetime).append(", cancellationReason=").append(this.cancellationReason).append(", isRefund=");
            sb.append(this.isRefund).append(", activeIntroductoryOfferType=").append(this.activeIntroductoryOfferType).append(", activePromotionalOfferType=").append(this.activePromotionalOfferType).append(", activePromotionalOfferId=").append(this.activePromotionalOfferId).append(", willRenew=").append(this.willRenew).append(", isInGracePeriod=").append(this.isInGracePeriod).append(", unsubscribedAt=").append(this.unsubscribedAt).append(", billingIssueDetectedAt=").append(this.billingIssueDetectedAt).append(')');
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001BÅ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0019J\u0013\u0010,\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u0005H\u0016R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\"R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\"R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\"R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\"R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\"R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"¨\u00061"}, d2 = {"Lcom/adapty/models/AdaptyProfile$Subscription;", "", "isActive", "", "vendorProductId", "", "vendorTransactionId", "vendorOriginalTransactionId", "offerId", "store", "activatedAt", "renewedAt", "expiresAt", "startsAt", "isLifetime", "activeIntroductoryOfferType", "activePromotionalOfferType", "activePromotionalOfferId", "willRenew", "isInGracePeriod", "unsubscribedAt", "billingIssueDetectedAt", "isSandbox", "isRefund", "cancellationReason", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "getActivatedAt", "()Ljava/lang/String;", "getActiveIntroductoryOfferType", "getActivePromotionalOfferId", "getActivePromotionalOfferType", "getBillingIssueDetectedAt", "getCancellationReason", "getExpiresAt", "()Z", "getOfferId", "getRenewedAt", "getStartsAt", "getStore", "getUnsubscribedAt", "getVendorOriginalTransactionId", "getVendorProductId", "getVendorTransactionId", "getWillRenew", "equals", "other", "hashCode", "", "toString", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyProfile.kt */
    public static final class Subscription {
        private final String activatedAt;
        private final String activeIntroductoryOfferType;
        private final String activePromotionalOfferId;
        private final String activePromotionalOfferType;
        private final String billingIssueDetectedAt;
        private final String cancellationReason;
        private final String expiresAt;
        private final boolean isActive;
        private final boolean isInGracePeriod;
        private final boolean isLifetime;
        private final boolean isRefund;
        private final boolean isSandbox;
        private final String offerId;
        private final String renewedAt;
        private final String startsAt;
        private final String store;
        private final String unsubscribedAt;
        private final String vendorOriginalTransactionId;
        private final String vendorProductId;
        private final String vendorTransactionId;
        private final boolean willRenew;

        public Subscription(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z2, String str10, String str11, String str12, boolean z3, boolean z4, String str13, String str14, boolean z5, boolean z6, String str15) {
            Intrinsics.checkNotNullParameter(str, "vendorProductId");
            Intrinsics.checkNotNullParameter(str5, DatabaseConstants.STORE_TABLE_NAME);
            Intrinsics.checkNotNullParameter(str6, "activatedAt");
            this.isActive = z;
            this.vendorProductId = str;
            this.vendorTransactionId = str2;
            this.vendorOriginalTransactionId = str3;
            this.offerId = str4;
            this.store = str5;
            this.activatedAt = str6;
            this.renewedAt = str7;
            this.expiresAt = str8;
            this.startsAt = str9;
            this.isLifetime = z2;
            this.activeIntroductoryOfferType = str10;
            this.activePromotionalOfferType = str11;
            this.activePromotionalOfferId = str12;
            this.willRenew = z3;
            this.isInGracePeriod = z4;
            this.unsubscribedAt = str13;
            this.billingIssueDetectedAt = str14;
            this.isSandbox = z5;
            this.isRefund = z6;
            this.cancellationReason = str15;
        }

        public final boolean isActive() {
            return this.isActive;
        }

        public final String getVendorProductId() {
            return this.vendorProductId;
        }

        public final String getVendorTransactionId() {
            return this.vendorTransactionId;
        }

        public final String getVendorOriginalTransactionId() {
            return this.vendorOriginalTransactionId;
        }

        public final String getOfferId() {
            return this.offerId;
        }

        public final String getStore() {
            return this.store;
        }

        public final String getActivatedAt() {
            return this.activatedAt;
        }

        public final String getRenewedAt() {
            return this.renewedAt;
        }

        public final String getExpiresAt() {
            return this.expiresAt;
        }

        public final String getStartsAt() {
            return this.startsAt;
        }

        public final boolean isLifetime() {
            return this.isLifetime;
        }

        public final String getActiveIntroductoryOfferType() {
            return this.activeIntroductoryOfferType;
        }

        public final String getActivePromotionalOfferType() {
            return this.activePromotionalOfferType;
        }

        public final String getActivePromotionalOfferId() {
            return this.activePromotionalOfferId;
        }

        public final boolean getWillRenew() {
            return this.willRenew;
        }

        public final boolean isInGracePeriod() {
            return this.isInGracePeriod;
        }

        public final String getUnsubscribedAt() {
            return this.unsubscribedAt;
        }

        public final String getBillingIssueDetectedAt() {
            return this.billingIssueDetectedAt;
        }

        public final boolean isSandbox() {
            return this.isSandbox;
        }

        public final boolean isRefund() {
            return this.isRefund;
        }

        public final String getCancellationReason() {
            return this.cancellationReason;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.models.AdaptyProfile.Subscription");
            Subscription subscription = (Subscription) obj;
            return this.isActive == subscription.isActive && Intrinsics.areEqual((Object) this.vendorProductId, (Object) subscription.vendorProductId) && Intrinsics.areEqual((Object) this.vendorTransactionId, (Object) subscription.vendorTransactionId) && Intrinsics.areEqual((Object) this.vendorOriginalTransactionId, (Object) subscription.vendorOriginalTransactionId) && Intrinsics.areEqual((Object) this.offerId, (Object) subscription.offerId) && Intrinsics.areEqual((Object) this.store, (Object) subscription.store) && Intrinsics.areEqual((Object) this.activatedAt, (Object) subscription.activatedAt) && Intrinsics.areEqual((Object) this.renewedAt, (Object) subscription.renewedAt) && Intrinsics.areEqual((Object) this.expiresAt, (Object) subscription.expiresAt) && Intrinsics.areEqual((Object) this.startsAt, (Object) subscription.startsAt) && this.isLifetime == subscription.isLifetime && Intrinsics.areEqual((Object) this.activeIntroductoryOfferType, (Object) subscription.activeIntroductoryOfferType) && Intrinsics.areEqual((Object) this.activePromotionalOfferType, (Object) subscription.activePromotionalOfferType) && Intrinsics.areEqual((Object) this.activePromotionalOfferId, (Object) subscription.activePromotionalOfferId) && this.willRenew == subscription.willRenew && this.isInGracePeriod == subscription.isInGracePeriod && Intrinsics.areEqual((Object) this.unsubscribedAt, (Object) subscription.unsubscribedAt) && Intrinsics.areEqual((Object) this.billingIssueDetectedAt, (Object) subscription.billingIssueDetectedAt) && this.isSandbox == subscription.isSandbox && this.isRefund == subscription.isRefund && Intrinsics.areEqual((Object) this.cancellationReason, (Object) subscription.cancellationReason);
        }

        public int hashCode() {
            int hashCode = ((Boolean.hashCode(this.isActive) * 31) + this.vendorProductId.hashCode()) * 31;
            String str = this.vendorTransactionId;
            int i = 0;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.vendorOriginalTransactionId;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.offerId;
            int hashCode4 = (((((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.store.hashCode()) * 31) + this.activatedAt.hashCode()) * 31;
            String str4 = this.renewedAt;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.expiresAt;
            int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.startsAt;
            int hashCode7 = (((hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + Boolean.hashCode(this.isLifetime)) * 31;
            String str7 = this.activeIntroductoryOfferType;
            int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.activePromotionalOfferType;
            int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
            String str9 = this.activePromotionalOfferId;
            int hashCode10 = (((((hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31) + Boolean.hashCode(this.willRenew)) * 31) + Boolean.hashCode(this.isInGracePeriod)) * 31;
            String str10 = this.unsubscribedAt;
            int hashCode11 = (hashCode10 + (str10 != null ? str10.hashCode() : 0)) * 31;
            String str11 = this.billingIssueDetectedAt;
            int hashCode12 = (((((hashCode11 + (str11 != null ? str11.hashCode() : 0)) * 31) + Boolean.hashCode(this.isSandbox)) * 31) + Boolean.hashCode(this.isRefund)) * 31;
            String str12 = this.cancellationReason;
            if (str12 != null) {
                i = str12.hashCode();
            }
            return hashCode12 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Subscription(isActive=").append(this.isActive).append(", vendorProductId='").append(this.vendorProductId).append("', vendorTransactionId=").append(this.vendorTransactionId).append(", vendorOriginalTransactionId=").append(this.vendorOriginalTransactionId).append(", offerId=").append(this.offerId).append(", store='").append(this.store).append("', activatedAt=").append(this.activatedAt).append(", renewedAt=").append(this.renewedAt).append(", expiresAt=").append(this.expiresAt).append(", startsAt=").append(this.startsAt).append(", isLifetime=").append(this.isLifetime).append(", activeIntroductoryOfferType=");
            sb.append(this.activeIntroductoryOfferType).append(", activePromotionalOfferType=").append(this.activePromotionalOfferType).append(", activePromotionalOfferId=").append(this.activePromotionalOfferId).append(", willRenew=").append(this.willRenew).append(", isInGracePeriod=").append(this.isInGracePeriod).append(", unsubscribedAt=").append(this.unsubscribedAt).append(", billingIssueDetectedAt=").append(this.billingIssueDetectedAt).append(", isSandbox=").append(this.isSandbox).append(", isRefund=").append(this.isRefund).append(", cancellationReason=").append(this.cancellationReason).append(')');
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/adapty/models/AdaptyProfile$NonSubscription;", "", "purchaseId", "", "vendorProductId", "vendorTransactionId", "store", "purchasedAt", "isConsumable", "", "isSandbox", "isRefund", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)V", "()Z", "isOneTime", "isOneTime$annotations", "()V", "getPurchaseId", "()Ljava/lang/String;", "getPurchasedAt", "getStore", "getVendorProductId", "getVendorTransactionId", "equals", "other", "hashCode", "", "toString", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyProfile.kt */
    public static final class NonSubscription {
        private final boolean isConsumable;
        private final boolean isRefund;
        private final boolean isSandbox;
        private final String purchaseId;
        private final String purchasedAt;
        private final String store;
        private final String vendorProductId;
        private final String vendorTransactionId;

        @Deprecated(level = DeprecationLevel.WARNING, message = "This property is deprecated and will be removed in future releases", replaceWith = @ReplaceWith(expression = "isConsumable", imports = {}))
        public static /* synthetic */ void isOneTime$annotations() {
        }

        public NonSubscription(String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(str, "purchaseId");
            Intrinsics.checkNotNullParameter(str2, "vendorProductId");
            Intrinsics.checkNotNullParameter(str4, DatabaseConstants.STORE_TABLE_NAME);
            Intrinsics.checkNotNullParameter(str5, "purchasedAt");
            this.purchaseId = str;
            this.vendorProductId = str2;
            this.vendorTransactionId = str3;
            this.store = str4;
            this.purchasedAt = str5;
            this.isConsumable = z;
            this.isSandbox = z2;
            this.isRefund = z3;
        }

        public final String getPurchaseId() {
            return this.purchaseId;
        }

        public final String getVendorProductId() {
            return this.vendorProductId;
        }

        public final String getVendorTransactionId() {
            return this.vendorTransactionId;
        }

        public final String getStore() {
            return this.store;
        }

        public final String getPurchasedAt() {
            return this.purchasedAt;
        }

        public final boolean isConsumable() {
            return this.isConsumable;
        }

        public final boolean isSandbox() {
            return this.isSandbox;
        }

        public final boolean isRefund() {
            return this.isRefund;
        }

        public final boolean isOneTime() {
            return this.isConsumable;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.models.AdaptyProfile.NonSubscription");
            NonSubscription nonSubscription = (NonSubscription) obj;
            return Intrinsics.areEqual((Object) this.purchaseId, (Object) nonSubscription.purchaseId) && Intrinsics.areEqual((Object) this.vendorProductId, (Object) nonSubscription.vendorProductId) && Intrinsics.areEqual((Object) this.vendorTransactionId, (Object) nonSubscription.vendorTransactionId) && Intrinsics.areEqual((Object) this.store, (Object) nonSubscription.store) && Intrinsics.areEqual((Object) this.purchasedAt, (Object) nonSubscription.purchasedAt) && this.isConsumable == nonSubscription.isConsumable && this.isSandbox == nonSubscription.isSandbox && this.isRefund == nonSubscription.isRefund;
        }

        public int hashCode() {
            int hashCode = ((this.purchaseId.hashCode() * 31) + this.vendorProductId.hashCode()) * 31;
            String str = this.vendorTransactionId;
            return ((((((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.store.hashCode()) * 31) + this.purchasedAt.hashCode()) * 31) + Boolean.hashCode(this.isConsumable)) * 31) + Boolean.hashCode(this.isSandbox)) * 31) + Boolean.hashCode(this.isRefund);
        }

        public String toString() {
            return "NonSubscription(purchaseId='" + this.purchaseId + "', vendorProductId='" + this.vendorProductId + "', vendorTransactionId=" + this.vendorTransactionId + ", store='" + this.store + "', purchasedAt=" + this.purchasedAt + ", isConsumable=" + this.isConsumable + ", isSandbox=" + this.isSandbox + ", isRefund=" + this.isRefund + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/adapty/models/AdaptyProfile$Gender;", "", "(Ljava/lang/String;I)V", "toString", "", "MALE", "FEMALE", "OTHER", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyProfile.kt */
    public enum Gender {
        MALE,
        FEMALE,
        OTHER;

        public String toString() {
            return String.valueOf(Character.toLowerCase(name().charAt(0)));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/adapty/models/AdaptyProfile$Date;", "", "year", "", "month", "date", "(III)V", "toString", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptyProfile.kt */
    public static final class Date {
        private final int date;
        private final int month;
        private final int year;

        public Date(int i, int i2, int i3) {
            this.year = i;
            this.month = i2;
            this.date = i3;
        }

        public String toString() {
            StringBuilder append = new StringBuilder().append(this.year).append('-');
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(this.month)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            StringBuilder append2 = append.append(format).append('-');
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(this.date)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return append2.append(format2).toString();
        }
    }
}
