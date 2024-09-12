package com.adapty.internal.utils;

import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.internal.data.models.ProfileDto;
import com.adapty.models.AdaptyProfile;
import com.adapty.utils.ImmutableMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/utils/ProfileMapper;", "", "()V", "map", "Lcom/adapty/models/AdaptyProfile;", "dto", "Lcom/adapty/internal/data/models/ProfileDto;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProfileMapper.kt */
public final class ProfileMapper {
    public final /* synthetic */ AdaptyProfile map(ProfileDto profileDto) {
        Map map;
        Map map2;
        Map map3;
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(profileDto, "dto");
        String profileId = profileDto.getProfileId();
        String str5 = profileId == null ? "" : profileId;
        String customerUserId = profileDto.getCustomerUserId();
        HashMap<String, ArrayList<ProfileDto.NonSubscriptionDto>> nonSubscriptions = profileDto.getNonSubscriptions();
        if (nonSubscriptions != null) {
            Map map4 = nonSubscriptions;
            map = new LinkedHashMap(MapsKt.mapCapacity(map4.size()));
            for (Map.Entry entry : map4.entrySet()) {
                Object key = entry.getKey();
                Iterable<ProfileDto.NonSubscriptionDto> iterable = (Iterable) entry.getValue();
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (ProfileDto.NonSubscriptionDto nonSubscriptionDto : iterable) {
                    String purchaseId = nonSubscriptionDto.getPurchaseId();
                    if (purchaseId != null) {
                        String vendorProductId = nonSubscriptionDto.getVendorProductId();
                        if (vendorProductId != null) {
                            String vendorTransactionId = nonSubscriptionDto.getVendorTransactionId();
                            String store = nonSubscriptionDto.getStore();
                            if (store == null) {
                                str4 = "";
                            } else {
                                str4 = store;
                            }
                            String purchasedAt = nonSubscriptionDto.getPurchasedAt();
                            if (purchasedAt != null) {
                                Boolean isConsumable = nonSubscriptionDto.isConsumable();
                                boolean booleanValue = isConsumable != null ? isConsumable.booleanValue() : false;
                                Boolean isSandbox = nonSubscriptionDto.isSandbox();
                                boolean booleanValue2 = isSandbox != null ? isSandbox.booleanValue() : false;
                                Boolean isRefund = nonSubscriptionDto.isRefund();
                                AdaptyProfile.NonSubscription nonSubscription = r12;
                                AdaptyProfile.NonSubscription nonSubscription2 = new AdaptyProfile.NonSubscription(purchaseId, vendorProductId, vendorTransactionId, str4, purchasedAt, booleanValue, booleanValue2, isRefund != null ? isRefund.booleanValue() : false);
                                arrayList.add(nonSubscription);
                            } else {
                                throw new AdaptyError((Throwable) null, "purchasedAt in NonSubscription should not be null", AdaptyErrorCode.DECODING_FAILED, 1, (DefaultConstructorMarker) null);
                            }
                        } else {
                            throw new AdaptyError((Throwable) null, "vendorProductId in NonSubscription should not be null", AdaptyErrorCode.DECODING_FAILED, 1, (DefaultConstructorMarker) null);
                        }
                    } else {
                        throw new AdaptyError((Throwable) null, "purchaseId in NonSubscription should not be null", AdaptyErrorCode.DECODING_FAILED, 1, (DefaultConstructorMarker) null);
                    }
                }
                map.put(key, Intrinsics.checkNotNullParameter((List) arrayList, "<this>"));
            }
        } else {
            map = null;
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        ImmutableMap immutableWithInterop = Intrinsics.checkNotNullParameter(map, "<this>");
        HashMap<String, ProfileDto.AccessLevelDto> accessLevels = profileDto.getAccessLevels();
        if (accessLevels != null) {
            Map map5 = accessLevels;
            map2 = new LinkedHashMap(MapsKt.mapCapacity(map5.size()));
            for (Map.Entry entry2 : map5.entrySet()) {
                Object key2 = entry2.getKey();
                String str6 = (String) entry2.getKey();
                ProfileDto.AccessLevelDto accessLevelDto = (ProfileDto.AccessLevelDto) entry2.getValue();
                Boolean isActive = accessLevelDto.isActive();
                if (isActive != null) {
                    boolean booleanValue3 = isActive.booleanValue();
                    String vendorProductId2 = accessLevelDto.getVendorProductId();
                    if (vendorProductId2 == null) {
                        str2 = "";
                    } else {
                        str2 = vendorProductId2;
                    }
                    String offerId = accessLevelDto.getOfferId();
                    String store2 = accessLevelDto.getStore();
                    if (store2 == null) {
                        str3 = "";
                    } else {
                        str3 = store2;
                    }
                    String activatedAt = accessLevelDto.getActivatedAt();
                    if (activatedAt != null) {
                        String startsAt = accessLevelDto.getStartsAt();
                        String renewedAt = accessLevelDto.getRenewedAt();
                        String expiresAt = accessLevelDto.getExpiresAt();
                        Boolean isLifetime = accessLevelDto.isLifetime();
                        boolean booleanValue4 = isLifetime != null ? isLifetime.booleanValue() : false;
                        String cancellationReason = accessLevelDto.getCancellationReason();
                        Boolean isRefund2 = accessLevelDto.isRefund();
                        boolean booleanValue5 = isRefund2 != null ? isRefund2.booleanValue() : false;
                        String activeIntroductoryOfferType = accessLevelDto.getActiveIntroductoryOfferType();
                        String activePromotionalOfferType = accessLevelDto.getActivePromotionalOfferType();
                        String activePromotionalOfferId = accessLevelDto.getActivePromotionalOfferId();
                        Boolean willRenew = accessLevelDto.getWillRenew();
                        boolean booleanValue6 = willRenew != null ? willRenew.booleanValue() : false;
                        Boolean isInGracePeriod = accessLevelDto.isInGracePeriod();
                        map2.put(key2, new AdaptyProfile.AccessLevel(str6, booleanValue3, str2, offerId, str3, activatedAt, startsAt, renewedAt, expiresAt, booleanValue4, cancellationReason, booleanValue5, activeIntroductoryOfferType, activePromotionalOfferType, activePromotionalOfferId, booleanValue6, isInGracePeriod != null ? isInGracePeriod.booleanValue() : false, accessLevelDto.getUnsubscribedAt(), accessLevelDto.getBillingIssueDetectedAt()));
                    } else {
                        throw new AdaptyError((Throwable) null, "activatedAt in AccessLevel should not be null", AdaptyErrorCode.DECODING_FAILED, 1, (DefaultConstructorMarker) null);
                    }
                } else {
                    throw new AdaptyError((Throwable) null, "isActive in AccessLevel should not be null", AdaptyErrorCode.DECODING_FAILED, 1, (DefaultConstructorMarker) null);
                }
            }
        } else {
            map2 = null;
        }
        if (map2 == null) {
            map2 = MapsKt.emptyMap();
        }
        ImmutableMap immutableWithInterop2 = Intrinsics.checkNotNullParameter(map2, "<this>");
        HashMap<String, ProfileDto.SubscriptionDto> subscriptions = profileDto.getSubscriptions();
        if (subscriptions != null) {
            Map map6 = subscriptions;
            Map linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map6.size()));
            for (Map.Entry entry3 : map6.entrySet()) {
                Object key3 = entry3.getKey();
                ProfileDto.SubscriptionDto subscriptionDto = (ProfileDto.SubscriptionDto) entry3.getValue();
                Boolean isActive2 = subscriptionDto.isActive();
                if (isActive2 != null) {
                    boolean booleanValue7 = isActive2.booleanValue();
                    String vendorProductId3 = subscriptionDto.getVendorProductId();
                    if (vendorProductId3 != null) {
                        String vendorTransactionId2 = subscriptionDto.getVendorTransactionId();
                        String vendorOriginalTransactionId = subscriptionDto.getVendorOriginalTransactionId();
                        String offerId2 = subscriptionDto.getOfferId();
                        String store3 = subscriptionDto.getStore();
                        if (store3 == null) {
                            str = "";
                        } else {
                            str = store3;
                        }
                        String activatedAt2 = subscriptionDto.getActivatedAt();
                        if (activatedAt2 != null) {
                            String renewedAt2 = subscriptionDto.getRenewedAt();
                            String expiresAt2 = subscriptionDto.getExpiresAt();
                            String startsAt2 = subscriptionDto.getStartsAt();
                            Boolean isLifetime2 = subscriptionDto.isLifetime();
                            boolean booleanValue8 = isLifetime2 != null ? isLifetime2.booleanValue() : false;
                            String activeIntroductoryOfferType2 = subscriptionDto.getActiveIntroductoryOfferType();
                            String activePromotionalOfferType2 = subscriptionDto.getActivePromotionalOfferType();
                            String activePromotionalOfferId2 = subscriptionDto.getActivePromotionalOfferId();
                            Boolean willRenew2 = subscriptionDto.getWillRenew();
                            boolean booleanValue9 = willRenew2 != null ? willRenew2.booleanValue() : false;
                            Boolean isInGracePeriod2 = subscriptionDto.isInGracePeriod();
                            boolean booleanValue10 = isInGracePeriod2 != null ? isInGracePeriod2.booleanValue() : false;
                            String unsubscribedAt = subscriptionDto.getUnsubscribedAt();
                            String billingIssueDetectedAt = subscriptionDto.getBillingIssueDetectedAt();
                            Boolean isSandbox2 = subscriptionDto.isSandbox();
                            boolean booleanValue11 = isSandbox2 != null ? isSandbox2.booleanValue() : false;
                            Boolean isRefund3 = subscriptionDto.isRefund();
                            boolean booleanValue12 = isRefund3 != null ? isRefund3.booleanValue() : false;
                            String cancellationReason2 = subscriptionDto.getCancellationReason();
                            AdaptyProfile.Subscription subscription = r11;
                            AdaptyProfile.Subscription subscription2 = new AdaptyProfile.Subscription(booleanValue7, vendorProductId3, vendorTransactionId2, vendorOriginalTransactionId, offerId2, str, activatedAt2, renewedAt2, expiresAt2, startsAt2, booleanValue8, activeIntroductoryOfferType2, activePromotionalOfferType2, activePromotionalOfferId2, booleanValue9, booleanValue10, unsubscribedAt, billingIssueDetectedAt, booleanValue11, booleanValue12, cancellationReason2);
                            linkedHashMap.put(key3, subscription);
                        } else {
                            throw new AdaptyError((Throwable) null, "activatedAt in Subscription should not be null", AdaptyErrorCode.DECODING_FAILED, 1, (DefaultConstructorMarker) null);
                        }
                    } else {
                        throw new AdaptyError((Throwable) null, "vendorProductId in Subscription should not be null", AdaptyErrorCode.DECODING_FAILED, 1, (DefaultConstructorMarker) null);
                    }
                } else {
                    throw new AdaptyError((Throwable) null, "isActive in Subscription should not be null", AdaptyErrorCode.DECODING_FAILED, 1, (DefaultConstructorMarker) null);
                }
            }
            map3 = linkedHashMap;
        } else {
            map3 = null;
        }
        if (map3 == null) {
            map3 = MapsKt.emptyMap();
        }
        ImmutableMap immutableWithInterop3 = Intrinsics.checkNotNullParameter(map3, "<this>");
        Map customAttributes = profileDto.getCustomAttributes();
        if (customAttributes == null) {
            customAttributes = MapsKt.emptyMap();
        }
        return new AdaptyProfile(str5, customerUserId, immutableWithInterop2, immutableWithInterop3, immutableWithInterop, Intrinsics.checkNotNullParameter(customAttributes, "<this>"));
    }
}
