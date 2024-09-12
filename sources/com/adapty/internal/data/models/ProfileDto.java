package com.adapty.internal.data.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0003%&'Bã\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b\u0012&\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000b\u0012<\u0010\u000e\u001a8\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\tj \u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011\u0018\u0001`\u000b\u0012&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000b¢\u0006\u0002\u0010\u0013J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010#\u001a\u00020$H\u0016R6\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R6\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018RL\u0010\u000e\u001a8\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\tj \u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011\u0018\u0001`\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R6\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Lcom/adapty/internal/data/models/ProfileDto;", "", "profileId", "", "customerUserId", "segmentId", "timestamp", "", "accessLevels", "Ljava/util/HashMap;", "Lcom/adapty/internal/data/models/ProfileDto$AccessLevelDto;", "Lkotlin/collections/HashMap;", "subscriptions", "Lcom/adapty/internal/data/models/ProfileDto$SubscriptionDto;", "nonSubscriptions", "Ljava/util/ArrayList;", "Lcom/adapty/internal/data/models/ProfileDto$NonSubscriptionDto;", "Lkotlin/collections/ArrayList;", "customAttributes", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;)V", "getAccessLevels", "()Ljava/util/HashMap;", "getCustomAttributes", "getCustomerUserId", "()Ljava/lang/String;", "getNonSubscriptions", "getProfileId", "getSegmentId", "getSubscriptions", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "equals", "", "other", "hashCode", "", "AccessLevelDto", "NonSubscriptionDto", "SubscriptionDto", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProfileDto.kt */
public final class ProfileDto {
    @SerializedName("paid_access_levels")
    private final HashMap<String, AccessLevelDto> accessLevels;
    @SerializedName("custom_attributes")
    private final HashMap<String, Object> customAttributes;
    @SerializedName("customer_user_id")
    private final String customerUserId;
    @SerializedName("non_subscriptions")
    private final HashMap<String, ArrayList<NonSubscriptionDto>> nonSubscriptions;
    @SerializedName("profile_id")
    private final String profileId;
    @SerializedName("segment_hash")
    private final String segmentId;
    @SerializedName("subscriptions")
    private final HashMap<String, SubscriptionDto> subscriptions;
    @SerializedName("timestamp")
    private final Long timestamp;

    public ProfileDto(String str, String str2, String str3, Long l, HashMap<String, AccessLevelDto> hashMap, HashMap<String, SubscriptionDto> hashMap2, HashMap<String, ArrayList<NonSubscriptionDto>> hashMap3, HashMap<String, Object> hashMap4) {
        this.profileId = str;
        this.customerUserId = str2;
        this.segmentId = str3;
        this.timestamp = l;
        this.accessLevels = hashMap;
        this.subscriptions = hashMap2;
        this.nonSubscriptions = hashMap3;
        this.customAttributes = hashMap4;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final String getCustomerUserId() {
        return this.customerUserId;
    }

    public final String getSegmentId() {
        return this.segmentId;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final HashMap<String, AccessLevelDto> getAccessLevels() {
        return this.accessLevels;
    }

    public final HashMap<String, SubscriptionDto> getSubscriptions() {
        return this.subscriptions;
    }

    public final HashMap<String, ArrayList<NonSubscriptionDto>> getNonSubscriptions() {
        return this.nonSubscriptions;
    }

    public final HashMap<String, Object> getCustomAttributes() {
        return this.customAttributes;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.internal.data.models.ProfileDto");
        ProfileDto profileDto = (ProfileDto) obj;
        return Intrinsics.areEqual((Object) this.profileId, (Object) profileDto.profileId) && Intrinsics.areEqual((Object) this.customerUserId, (Object) profileDto.customerUserId) && Intrinsics.areEqual((Object) this.segmentId, (Object) profileDto.segmentId) && Intrinsics.areEqual((Object) this.accessLevels, (Object) profileDto.accessLevels) && Intrinsics.areEqual((Object) this.subscriptions, (Object) profileDto.subscriptions) && Intrinsics.areEqual((Object) this.nonSubscriptions, (Object) profileDto.nonSubscriptions) && Intrinsics.areEqual((Object) this.customAttributes, (Object) profileDto.customAttributes);
    }

    public int hashCode() {
        String str = this.profileId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.customerUserId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.segmentId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        HashMap<String, AccessLevelDto> hashMap = this.accessLevels;
        int hashCode4 = (hashCode3 + (hashMap != null ? hashMap.hashCode() : 0)) * 31;
        HashMap<String, SubscriptionDto> hashMap2 = this.subscriptions;
        int hashCode5 = (hashCode4 + (hashMap2 != null ? hashMap2.hashCode() : 0)) * 31;
        HashMap<String, ArrayList<NonSubscriptionDto>> hashMap3 = this.nonSubscriptions;
        int hashCode6 = (hashCode5 + (hashMap3 != null ? hashMap3.hashCode() : 0)) * 31;
        HashMap<String, Object> hashMap4 = this.customAttributes;
        if (hashMap4 != null) {
            i = hashMap4.hashCode();
        }
        return hashCode6 + i;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B¹\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0016J\u0013\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010*\u001a\u00020+H\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u0002\u0010\u001fR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u0013\u0010\u001fR\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\f\u0010\u001fR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u000e\u0010\u001fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b'\u0010\u001f¨\u0006,"}, d2 = {"Lcom/adapty/internal/data/models/ProfileDto$AccessLevelDto;", "", "isActive", "", "vendorProductId", "", "offerId", "store", "activatedAt", "startsAt", "renewedAt", "expiresAt", "isLifetime", "cancellationReason", "isRefund", "activeIntroductoryOfferType", "activePromotionalOfferType", "activePromotionalOfferId", "willRenew", "isInGracePeriod", "unsubscribedAt", "billingIssueDetectedAt", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getActivatedAt", "()Ljava/lang/String;", "getActiveIntroductoryOfferType", "getActivePromotionalOfferId", "getActivePromotionalOfferType", "getBillingIssueDetectedAt", "getCancellationReason", "getExpiresAt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOfferId", "getRenewedAt", "getStartsAt", "getStore", "getUnsubscribedAt", "getVendorProductId", "getWillRenew", "equals", "other", "hashCode", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ProfileDto.kt */
    public static final class AccessLevelDto {
        @SerializedName("activated_at")
        private final String activatedAt;
        @SerializedName("active_introductory_offer_type")
        private final String activeIntroductoryOfferType;
        @SerializedName("active_promotional_offer_id")
        private final String activePromotionalOfferId;
        @SerializedName("active_promotional_offer_type")
        private final String activePromotionalOfferType;
        @SerializedName("billing_issue_detected_at")
        private final String billingIssueDetectedAt;
        @SerializedName("cancellation_reason")
        private final String cancellationReason;
        @SerializedName("expires_at")
        private final String expiresAt;
        @SerializedName("is_active")
        private final Boolean isActive;
        @SerializedName("is_in_grace_period")
        private final Boolean isInGracePeriod;
        @SerializedName("is_lifetime")
        private final Boolean isLifetime;
        @SerializedName("is_refund")
        private final Boolean isRefund;
        @SerializedName("offer_id")
        private final String offerId;
        @SerializedName("renewed_at")
        private final String renewedAt;
        @SerializedName("starts_at")
        private final String startsAt;
        @SerializedName("store")
        private final String store;
        @SerializedName("unsubscribed_at")
        private final String unsubscribedAt;
        @SerializedName("vendor_product_id")
        private final String vendorProductId;
        @SerializedName("will_renew")
        private final Boolean willRenew;

        public AccessLevelDto(Boolean bool, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool2, String str8, Boolean bool3, String str9, String str10, String str11, Boolean bool4, Boolean bool5, String str12, String str13) {
            this.isActive = bool;
            this.vendorProductId = str;
            this.offerId = str2;
            this.store = str3;
            this.activatedAt = str4;
            this.startsAt = str5;
            this.renewedAt = str6;
            this.expiresAt = str7;
            this.isLifetime = bool2;
            this.cancellationReason = str8;
            this.isRefund = bool3;
            this.activeIntroductoryOfferType = str9;
            this.activePromotionalOfferType = str10;
            this.activePromotionalOfferId = str11;
            this.willRenew = bool4;
            this.isInGracePeriod = bool5;
            this.unsubscribedAt = str12;
            this.billingIssueDetectedAt = str13;
        }

        public final Boolean isActive() {
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

        public final Boolean isLifetime() {
            return this.isLifetime;
        }

        public final String getCancellationReason() {
            return this.cancellationReason;
        }

        public final Boolean isRefund() {
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

        public final Boolean getWillRenew() {
            return this.willRenew;
        }

        public final Boolean isInGracePeriod() {
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
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.internal.data.models.ProfileDto.AccessLevelDto");
            AccessLevelDto accessLevelDto = (AccessLevelDto) obj;
            return Intrinsics.areEqual((Object) this.isActive, (Object) accessLevelDto.isActive) && Intrinsics.areEqual((Object) this.vendorProductId, (Object) accessLevelDto.vendorProductId) && Intrinsics.areEqual((Object) this.offerId, (Object) accessLevelDto.offerId) && Intrinsics.areEqual((Object) this.store, (Object) accessLevelDto.store) && Intrinsics.areEqual((Object) this.activatedAt, (Object) accessLevelDto.activatedAt) && Intrinsics.areEqual((Object) this.startsAt, (Object) accessLevelDto.startsAt) && Intrinsics.areEqual((Object) this.renewedAt, (Object) accessLevelDto.renewedAt) && Intrinsics.areEqual((Object) this.expiresAt, (Object) accessLevelDto.expiresAt) && Intrinsics.areEqual((Object) this.isLifetime, (Object) accessLevelDto.isLifetime) && Intrinsics.areEqual((Object) this.cancellationReason, (Object) accessLevelDto.cancellationReason) && Intrinsics.areEqual((Object) this.isRefund, (Object) accessLevelDto.isRefund) && Intrinsics.areEqual((Object) this.activeIntroductoryOfferType, (Object) accessLevelDto.activeIntroductoryOfferType) && Intrinsics.areEqual((Object) this.activePromotionalOfferType, (Object) accessLevelDto.activePromotionalOfferType) && Intrinsics.areEqual((Object) this.activePromotionalOfferId, (Object) accessLevelDto.activePromotionalOfferId) && Intrinsics.areEqual((Object) this.willRenew, (Object) accessLevelDto.willRenew) && Intrinsics.areEqual((Object) this.isInGracePeriod, (Object) accessLevelDto.isInGracePeriod) && Intrinsics.areEqual((Object) this.unsubscribedAt, (Object) accessLevelDto.unsubscribedAt) && Intrinsics.areEqual((Object) this.billingIssueDetectedAt, (Object) accessLevelDto.billingIssueDetectedAt);
        }

        public int hashCode() {
            Boolean bool = this.isActive;
            int i = 0;
            int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
            String str = this.vendorProductId;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.offerId;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.store;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.activatedAt;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.startsAt;
            int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.renewedAt;
            int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.expiresAt;
            int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
            Boolean bool2 = this.isLifetime;
            int hashCode9 = (hashCode8 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
            String str8 = this.cancellationReason;
            int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
            Boolean bool3 = this.isRefund;
            int hashCode11 = (hashCode10 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
            String str9 = this.activeIntroductoryOfferType;
            int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
            String str10 = this.activePromotionalOfferType;
            int hashCode13 = (hashCode12 + (str10 != null ? str10.hashCode() : 0)) * 31;
            String str11 = this.activePromotionalOfferId;
            int hashCode14 = (hashCode13 + (str11 != null ? str11.hashCode() : 0)) * 31;
            Boolean bool4 = this.willRenew;
            int hashCode15 = (hashCode14 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
            Boolean bool5 = this.isInGracePeriod;
            int hashCode16 = (hashCode15 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
            String str12 = this.unsubscribedAt;
            int hashCode17 = (hashCode16 + (str12 != null ? str12.hashCode() : 0)) * 31;
            String str13 = this.billingIssueDetectedAt;
            if (str13 != null) {
                i = str13.hashCode();
            }
            return hashCode17 + i;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B×\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0019J\u0013\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010/\u001a\u000200H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\u0002\u0010\"R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\u0013\u0010\"R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\u000e\u0010\"R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\u0017\u0010\"R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\u0016\u0010\"R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b,\u0010\"¨\u00061"}, d2 = {"Lcom/adapty/internal/data/models/ProfileDto$SubscriptionDto;", "", "isActive", "", "vendorProductId", "", "vendorTransactionId", "vendorOriginalTransactionId", "offerId", "store", "activatedAt", "renewedAt", "expiresAt", "startsAt", "isLifetime", "activeIntroductoryOfferType", "activePromotionalOfferType", "activePromotionalOfferId", "willRenew", "isInGracePeriod", "unsubscribedAt", "billingIssueDetectedAt", "isSandbox", "isRefund", "cancellationReason", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getActivatedAt", "()Ljava/lang/String;", "getActiveIntroductoryOfferType", "getActivePromotionalOfferId", "getActivePromotionalOfferType", "getBillingIssueDetectedAt", "getCancellationReason", "getExpiresAt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOfferId", "getRenewedAt", "getStartsAt", "getStore", "getUnsubscribedAt", "getVendorOriginalTransactionId", "getVendorProductId", "getVendorTransactionId", "getWillRenew", "equals", "other", "hashCode", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ProfileDto.kt */
    public static final class SubscriptionDto {
        @SerializedName("activated_at")
        private final String activatedAt;
        @SerializedName("active_introductory_offer_type")
        private final String activeIntroductoryOfferType;
        @SerializedName("active_promotional_offer_id")
        private final String activePromotionalOfferId;
        @SerializedName("active_promotional_offer_type")
        private final String activePromotionalOfferType;
        @SerializedName("billing_issue_detected_at")
        private final String billingIssueDetectedAt;
        @SerializedName("cancellation_reason")
        private final String cancellationReason;
        @SerializedName("expires_at")
        private final String expiresAt;
        @SerializedName("is_active")
        private final Boolean isActive;
        @SerializedName("is_in_grace_period")
        private final Boolean isInGracePeriod;
        @SerializedName("is_lifetime")
        private final Boolean isLifetime;
        @SerializedName("is_refund")
        private final Boolean isRefund;
        @SerializedName("is_sandbox")
        private final Boolean isSandbox;
        @SerializedName("offer_id")
        private final String offerId;
        @SerializedName("renewed_at")
        private final String renewedAt;
        @SerializedName("starts_at")
        private final String startsAt;
        @SerializedName("store")
        private final String store;
        @SerializedName("unsubscribed_at")
        private final String unsubscribedAt;
        @SerializedName("vendor_original_transaction_id")
        private final String vendorOriginalTransactionId;
        @SerializedName("vendor_product_id")
        private final String vendorProductId;
        @SerializedName("vendor_transaction_id")
        private final String vendorTransactionId;
        @SerializedName("will_renew")
        private final Boolean willRenew;

        public SubscriptionDto(Boolean bool, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Boolean bool2, String str10, String str11, String str12, Boolean bool3, Boolean bool4, String str13, String str14, Boolean bool5, Boolean bool6, String str15) {
            this.isActive = bool;
            this.vendorProductId = str;
            this.vendorTransactionId = str2;
            this.vendorOriginalTransactionId = str3;
            this.offerId = str4;
            this.store = str5;
            this.activatedAt = str6;
            this.renewedAt = str7;
            this.expiresAt = str8;
            this.startsAt = str9;
            this.isLifetime = bool2;
            this.activeIntroductoryOfferType = str10;
            this.activePromotionalOfferType = str11;
            this.activePromotionalOfferId = str12;
            this.willRenew = bool3;
            this.isInGracePeriod = bool4;
            this.unsubscribedAt = str13;
            this.billingIssueDetectedAt = str14;
            this.isSandbox = bool5;
            this.isRefund = bool6;
            this.cancellationReason = str15;
        }

        public final Boolean isActive() {
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

        public final Boolean isLifetime() {
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

        public final Boolean getWillRenew() {
            return this.willRenew;
        }

        public final Boolean isInGracePeriod() {
            return this.isInGracePeriod;
        }

        public final String getUnsubscribedAt() {
            return this.unsubscribedAt;
        }

        public final String getBillingIssueDetectedAt() {
            return this.billingIssueDetectedAt;
        }

        public final Boolean isSandbox() {
            return this.isSandbox;
        }

        public final Boolean isRefund() {
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
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.internal.data.models.ProfileDto.SubscriptionDto");
            SubscriptionDto subscriptionDto = (SubscriptionDto) obj;
            return Intrinsics.areEqual((Object) this.isActive, (Object) subscriptionDto.isActive) && Intrinsics.areEqual((Object) this.vendorProductId, (Object) subscriptionDto.vendorProductId) && Intrinsics.areEqual((Object) this.vendorTransactionId, (Object) subscriptionDto.vendorTransactionId) && Intrinsics.areEqual((Object) this.vendorOriginalTransactionId, (Object) subscriptionDto.vendorOriginalTransactionId) && Intrinsics.areEqual((Object) this.offerId, (Object) subscriptionDto.offerId) && Intrinsics.areEqual((Object) this.store, (Object) subscriptionDto.store) && Intrinsics.areEqual((Object) this.activatedAt, (Object) subscriptionDto.activatedAt) && Intrinsics.areEqual((Object) this.renewedAt, (Object) subscriptionDto.renewedAt) && Intrinsics.areEqual((Object) this.expiresAt, (Object) subscriptionDto.expiresAt) && Intrinsics.areEqual((Object) this.startsAt, (Object) subscriptionDto.startsAt) && Intrinsics.areEqual((Object) this.isLifetime, (Object) subscriptionDto.isLifetime) && Intrinsics.areEqual((Object) this.activeIntroductoryOfferType, (Object) subscriptionDto.activeIntroductoryOfferType) && Intrinsics.areEqual((Object) this.activePromotionalOfferType, (Object) subscriptionDto.activePromotionalOfferType) && Intrinsics.areEqual((Object) this.activePromotionalOfferId, (Object) subscriptionDto.activePromotionalOfferId) && Intrinsics.areEqual((Object) this.willRenew, (Object) subscriptionDto.willRenew) && Intrinsics.areEqual((Object) this.isInGracePeriod, (Object) subscriptionDto.isInGracePeriod) && Intrinsics.areEqual((Object) this.unsubscribedAt, (Object) subscriptionDto.unsubscribedAt) && Intrinsics.areEqual((Object) this.billingIssueDetectedAt, (Object) subscriptionDto.billingIssueDetectedAt) && Intrinsics.areEqual((Object) this.isSandbox, (Object) subscriptionDto.isSandbox) && Intrinsics.areEqual((Object) this.isRefund, (Object) subscriptionDto.isRefund) && Intrinsics.areEqual((Object) this.cancellationReason, (Object) subscriptionDto.cancellationReason);
        }

        public int hashCode() {
            Boolean bool = this.isActive;
            int i = 0;
            int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
            String str = this.vendorProductId;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.vendorTransactionId;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.vendorOriginalTransactionId;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.offerId;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.store;
            int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.activatedAt;
            int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.renewedAt;
            int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.expiresAt;
            int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
            String str9 = this.startsAt;
            int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
            Boolean bool2 = this.isLifetime;
            int hashCode11 = (hashCode10 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
            String str10 = this.activeIntroductoryOfferType;
            int hashCode12 = (hashCode11 + (str10 != null ? str10.hashCode() : 0)) * 31;
            String str11 = this.activePromotionalOfferType;
            int hashCode13 = (hashCode12 + (str11 != null ? str11.hashCode() : 0)) * 31;
            String str12 = this.activePromotionalOfferId;
            int hashCode14 = (hashCode13 + (str12 != null ? str12.hashCode() : 0)) * 31;
            Boolean bool3 = this.willRenew;
            int hashCode15 = (hashCode14 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
            Boolean bool4 = this.isInGracePeriod;
            int hashCode16 = (hashCode15 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
            String str13 = this.unsubscribedAt;
            int hashCode17 = (hashCode16 + (str13 != null ? str13.hashCode() : 0)) * 31;
            String str14 = this.billingIssueDetectedAt;
            int hashCode18 = (hashCode17 + (str14 != null ? str14.hashCode() : 0)) * 31;
            Boolean bool5 = this.isSandbox;
            int hashCode19 = (hashCode18 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
            Boolean bool6 = this.isRefund;
            int hashCode20 = (hashCode19 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
            String str15 = this.cancellationReason;
            if (str15 != null) {
                i = str15.hashCode();
            }
            return hashCode20 + i;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\fJ\u0013\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\b\u0010\rR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000b\u0010\rR\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/adapty/internal/data/models/ProfileDto$NonSubscriptionDto;", "", "purchaseId", "", "vendorProductId", "vendorTransactionId", "store", "purchasedAt", "isConsumable", "", "isSandbox", "isRefund", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPurchaseId", "()Ljava/lang/String;", "getPurchasedAt", "getStore", "getVendorProductId", "getVendorTransactionId", "equals", "other", "hashCode", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ProfileDto.kt */
    public static final class NonSubscriptionDto {
        @SerializedName("is_consumable")
        private final Boolean isConsumable;
        @SerializedName("is_refund")
        private final Boolean isRefund;
        @SerializedName("is_sandbox")
        private final Boolean isSandbox;
        @SerializedName("purchase_id")
        private final String purchaseId;
        @SerializedName("purchased_at")
        private final String purchasedAt;
        @SerializedName("store")
        private final String store;
        @SerializedName("vendor_product_id")
        private final String vendorProductId;
        @SerializedName("vendor_transaction_id")
        private final String vendorTransactionId;

        public NonSubscriptionDto(String str, String str2, String str3, String str4, String str5, Boolean bool, Boolean bool2, Boolean bool3) {
            this.purchaseId = str;
            this.vendorProductId = str2;
            this.vendorTransactionId = str3;
            this.store = str4;
            this.purchasedAt = str5;
            this.isConsumable = bool;
            this.isSandbox = bool2;
            this.isRefund = bool3;
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

        public final Boolean isConsumable() {
            return this.isConsumable;
        }

        public final Boolean isSandbox() {
            return this.isSandbox;
        }

        public final Boolean isRefund() {
            return this.isRefund;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.internal.data.models.ProfileDto.NonSubscriptionDto");
            NonSubscriptionDto nonSubscriptionDto = (NonSubscriptionDto) obj;
            return Intrinsics.areEqual((Object) this.purchaseId, (Object) nonSubscriptionDto.purchaseId) && Intrinsics.areEqual((Object) this.vendorProductId, (Object) nonSubscriptionDto.vendorProductId) && Intrinsics.areEqual((Object) this.vendorTransactionId, (Object) nonSubscriptionDto.vendorTransactionId) && Intrinsics.areEqual((Object) this.store, (Object) nonSubscriptionDto.store) && Intrinsics.areEqual((Object) this.purchasedAt, (Object) nonSubscriptionDto.purchasedAt) && Intrinsics.areEqual((Object) this.isConsumable, (Object) nonSubscriptionDto.isConsumable) && Intrinsics.areEqual((Object) this.isSandbox, (Object) nonSubscriptionDto.isSandbox) && Intrinsics.areEqual((Object) this.isRefund, (Object) nonSubscriptionDto.isRefund);
        }

        public int hashCode() {
            String str = this.purchaseId;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.vendorProductId;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.vendorTransactionId;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.store;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.purchasedAt;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            Boolean bool = this.isConsumable;
            int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
            Boolean bool2 = this.isSandbox;
            int hashCode7 = (hashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
            Boolean bool3 = this.isRefund;
            if (bool3 != null) {
                i = bool3.hashCode();
            }
            return hashCode7 + i;
        }
    }
}
