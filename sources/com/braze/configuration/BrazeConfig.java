package com.braze.configuration;

import com.braze.enums.BrazeSdkMetadata;
import com.braze.enums.DeviceKey;
import com.braze.enums.LocationProviderName;
import com.braze.enums.SdkFlavor;
import com.braze.support.BrazeLogger;
import com.google.android.exoplayer2.C;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.EnumSet;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001<B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010;\u001a\u00020\u0006H\u0016R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000f8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010 \u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010!\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\"\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010#\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010$\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010%\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010&\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010'\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010(\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010)\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010*\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010+\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010,\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010-\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010.\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010/\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u00100\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u00101\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0012\u00102\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u0004\u0018\u0001058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0012\u00108\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010:\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006="}, d2 = {"Lcom/braze/configuration/BrazeConfig;", "", "builder", "Lcom/braze/configuration/BrazeConfig$Builder;", "(Lcom/braze/configuration/BrazeConfig$Builder;)V", "apiKey", "", "areAutomaticGeofenceRequestsEnabled", "", "Ljava/lang/Boolean;", "areGeofencesEnabled", "badNetworkInterval", "", "Ljava/lang/Integer;", "brazeSdkMetadata", "Ljava/util/EnumSet;", "Lcom/braze/enums/BrazeSdkMetadata;", "customEndpoint", "customHtmlWebViewActivityClassName", "customLocationProviderNames", "Lcom/braze/enums/LocationProviderName;", "defaultNotificationAccentColor", "defaultNotificationChannelDescription", "defaultNotificationChannelName", "deviceObjectAllowlist", "Lcom/braze/enums/DeviceKey;", "doesPushStoryDismissOnClick", "fallbackFirebaseMessagingServiceClasspath", "firebaseCloudMessagingSenderIdKey", "goodNetworkInterval", "greatNetworkInterval", "inAppMessageWebViewClientMaxOnPageFinishedWaitMs", "isAdmMessagingRegistrationEnabled", "isContentCardsUnreadVisualIndicatorEnabled", "isDeviceObjectAllowlistEnabled", "isFallbackFirebaseMessagingServiceEnabled", "isFirebaseCloudMessagingRegistrationEnabled", "isFirebaseMessagingServiceOnNewTokenRegistrationEnabled", "isHtmlInAppMessageApplyWindowInsetsEnabled", "isHtmlInAppMessageHtmlLinkTargetEnabled", "isInAppMessageAccessibilityExclusiveModeEnabled", "isInAppMessageTestPushEagerDisplayEnabled", "isLocationCollectionEnabled", "isNewsFeedVisualIndicatorOn", "isPushDeepLinkBackStackActivityEnabled", "isPushHtmlRenderingEnabled", "isPushWakeScreenForNotificationEnabled", "isSdkAuthEnabled", "isSessionStartBasedTimeoutEnabled", "isTouchModeRequiredForHtmlInAppMessages", "largeNotificationIcon", "pushDeepLinkBackStackActivityClassName", "sdkFlavor", "Lcom/braze/enums/SdkFlavor;", "serverTarget", "sessionTimeout", "smallNotificationIcon", "triggerActionMinimumTimeIntervalSeconds", "willHandlePushDeepLinksAutomatically", "toString", "Builder", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BrazeConfig {
    public final String apiKey;
    public final Boolean areAutomaticGeofenceRequestsEnabled;
    public final Boolean areGeofencesEnabled;
    public final Integer badNetworkInterval;
    public final EnumSet<BrazeSdkMetadata> brazeSdkMetadata;
    private final Builder builder;
    public final String customEndpoint;
    public final String customHtmlWebViewActivityClassName;
    public final EnumSet<LocationProviderName> customLocationProviderNames;
    public final Integer defaultNotificationAccentColor;
    public final String defaultNotificationChannelDescription;
    public final String defaultNotificationChannelName;
    public final EnumSet<DeviceKey> deviceObjectAllowlist;
    public final Boolean doesPushStoryDismissOnClick;
    public final String fallbackFirebaseMessagingServiceClasspath;
    public final String firebaseCloudMessagingSenderIdKey;
    public final Integer goodNetworkInterval;
    public final Integer greatNetworkInterval;
    public final Integer inAppMessageWebViewClientMaxOnPageFinishedWaitMs;
    public final Boolean isAdmMessagingRegistrationEnabled;
    public final Boolean isContentCardsUnreadVisualIndicatorEnabled;
    public final Boolean isDeviceObjectAllowlistEnabled;
    public final Boolean isFallbackFirebaseMessagingServiceEnabled;
    public final Boolean isFirebaseCloudMessagingRegistrationEnabled;
    public final Boolean isFirebaseMessagingServiceOnNewTokenRegistrationEnabled;
    public final Boolean isHtmlInAppMessageApplyWindowInsetsEnabled;
    public final Boolean isHtmlInAppMessageHtmlLinkTargetEnabled;
    public final Boolean isInAppMessageAccessibilityExclusiveModeEnabled;
    public final Boolean isInAppMessageTestPushEagerDisplayEnabled;
    public final Boolean isLocationCollectionEnabled;
    public final Boolean isNewsFeedVisualIndicatorOn;
    public final Boolean isPushDeepLinkBackStackActivityEnabled;
    public final Boolean isPushHtmlRenderingEnabled;
    public final Boolean isPushWakeScreenForNotificationEnabled;
    public final Boolean isSdkAuthEnabled;
    public final Boolean isSessionStartBasedTimeoutEnabled;
    public final Boolean isTouchModeRequiredForHtmlInAppMessages;
    public final String largeNotificationIcon;
    public final String pushDeepLinkBackStackActivityClassName;
    public final SdkFlavor sdkFlavor;
    public final String serverTarget;
    public final Integer sessionTimeout;
    public final String smallNotificationIcon;
    public final Integer triggerActionMinimumTimeIntervalSeconds;
    public final Boolean willHandlePushDeepLinksAutomatically;

    public /* synthetic */ BrazeConfig(Builder builder2, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder2);
    }

    public String toString() {
        return this.builder.toString();
    }

    private BrazeConfig(Builder builder2) {
        this.builder = builder2;
        this.apiKey = builder2.getApiKey$android_sdk_base_release();
        this.serverTarget = builder2.getServerTarget$android_sdk_base_release();
        this.smallNotificationIcon = builder2.getSmallNotificationIconName$android_sdk_base_release();
        this.largeNotificationIcon = builder2.getLargeNotificationIconName$android_sdk_base_release();
        this.customEndpoint = builder2.getCustomEndpoint$android_sdk_base_release();
        this.defaultNotificationChannelName = builder2.getDefaultNotificationChannelName$android_sdk_base_release();
        this.defaultNotificationChannelDescription = builder2.getDefaultNotificationChannelDescription$android_sdk_base_release();
        this.pushDeepLinkBackStackActivityClassName = builder2.getPushDeepLinkBackStackActivityClassName$android_sdk_base_release();
        this.firebaseCloudMessagingSenderIdKey = builder2.getFirebaseCloudMessagingSenderIdKey$android_sdk_base_release();
        this.customHtmlWebViewActivityClassName = builder2.getCustomHtmlWebViewActivityClassName$android_sdk_base_release();
        this.sdkFlavor = builder2.getSdkFlavor$android_sdk_base_release();
        this.sessionTimeout = builder2.getSessionTimeout$android_sdk_base_release();
        this.defaultNotificationAccentColor = builder2.getDefaultNotificationAccentColor$android_sdk_base_release();
        this.triggerActionMinimumTimeIntervalSeconds = builder2.getTriggerActionMinimumTimeIntervalSeconds$android_sdk_base_release();
        this.badNetworkInterval = builder2.getBadNetworkInterval$android_sdk_base_release();
        this.goodNetworkInterval = builder2.getGoodNetworkInterval$android_sdk_base_release();
        this.greatNetworkInterval = builder2.getGreatNetworkInterval$android_sdk_base_release();
        this.inAppMessageWebViewClientMaxOnPageFinishedWaitMs = builder2.getInAppMessageWebViewClientMaxOnPageFinishedWaitMs$android_sdk_base_release();
        this.isAdmMessagingRegistrationEnabled = builder2.getAdmMessagingRegistrationEnabled$android_sdk_base_release();
        this.willHandlePushDeepLinksAutomatically = builder2.getHandlePushDeepLinksAutomatically$android_sdk_base_release();
        this.isLocationCollectionEnabled = builder2.isLocationCollectionEnabled$android_sdk_base_release();
        this.isNewsFeedVisualIndicatorOn = builder2.isNewsFeedVisualIndicatorOn$android_sdk_base_release();
        this.isPushDeepLinkBackStackActivityEnabled = builder2.isPushDeepLinkBackStackActivityEnabled$android_sdk_base_release();
        this.isSessionStartBasedTimeoutEnabled = builder2.isSessionStartBasedTimeoutEnabled$android_sdk_base_release();
        this.isFirebaseCloudMessagingRegistrationEnabled = builder2.isFirebaseCloudMessagingRegistrationEnabled$android_sdk_base_release();
        this.isContentCardsUnreadVisualIndicatorEnabled = builder2.isContentCardsUnreadVisualIndicatorEnabled$android_sdk_base_release();
        this.isInAppMessageAccessibilityExclusiveModeEnabled = builder2.isInAppMessageAccessibilityExclusiveModeEnabled$android_sdk_base_release();
        this.isPushWakeScreenForNotificationEnabled = builder2.isPushWakeScreenForNotificationEnabled$android_sdk_base_release();
        this.isPushHtmlRenderingEnabled = builder2.isPushHtmlRenderingEnabled$android_sdk_base_release();
        this.areGeofencesEnabled = builder2.isGeofencesEnabled$android_sdk_base_release();
        this.isInAppMessageTestPushEagerDisplayEnabled = builder2.getInAppMessageTestPushEagerDisplayEnabled$android_sdk_base_release();
        this.areAutomaticGeofenceRequestsEnabled = builder2.getAutomaticGeofenceRequestsEnabled$android_sdk_base_release();
        this.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled = builder2.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled$android_sdk_base_release();
        this.isSdkAuthEnabled = builder2.isSdkAuthEnabled$android_sdk_base_release();
        this.isTouchModeRequiredForHtmlInAppMessages = builder2.isTouchModeRequiredForHtmlInAppMessages$android_sdk_base_release();
        this.deviceObjectAllowlist = builder2.getDeviceObjectAllowlist$android_sdk_base_release();
        this.isDeviceObjectAllowlistEnabled = builder2.isDeviceObjectAllowlistEnabled$android_sdk_base_release();
        this.customLocationProviderNames = builder2.getCustomLocationProviderNames$android_sdk_base_release();
        this.brazeSdkMetadata = builder2.getBrazeSdkMetadata$android_sdk_base_release();
        this.isHtmlInAppMessageApplyWindowInsetsEnabled = builder2.isHtmlInAppMessageApplyWindowInsetsEnabled$android_sdk_base_release();
        this.isHtmlInAppMessageHtmlLinkTargetEnabled = builder2.isHtmlInAppMessageHtmlLinkTargetEnabled$android_sdk_base_release();
        this.doesPushStoryDismissOnClick = builder2.getDoesPushStoryDismissOnClick$android_sdk_base_release();
        this.isFallbackFirebaseMessagingServiceEnabled = builder2.isFallbackFirebaseMessagingServiceEnabled$android_sdk_base_release();
        this.fallbackFirebaseMessagingServiceClasspath = builder2.getFallbackFirebaseMessagingServiceClasspath$android_sdk_base_release();
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bk\n\u0002\u0018\u0002\n\u0002\bj\n\u0002\u0018\u0002\n\u0002\b6\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B©\u0004\b\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0019\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0019\u0012\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010+\u0012\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010+\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u00107J\b\u0010\u0001\u001a\u00030\u0001J\u0012\u0010\u0001\u001a\u0004\u0018\u00010\u0004HÀ\u0003¢\u0006\u0003\b\u0001J\u0012\u0010 \u0001\u001a\u0004\u0018\u00010\u0004HÀ\u0003¢\u0006\u0003\b¡\u0001J\u0012\u0010¢\u0001\u001a\u0004\u0018\u00010\u000fHÀ\u0003¢\u0006\u0003\b£\u0001J\u0014\u0010¤\u0001\u001a\u0004\u0018\u00010\u0011HÀ\u0003¢\u0006\u0005\b¥\u0001\u0010DJ\u0014\u0010¦\u0001\u001a\u0004\u0018\u00010\u0011HÀ\u0003¢\u0006\u0005\b§\u0001\u0010DJ\u0014\u0010¨\u0001\u001a\u0004\u0018\u00010\u0011HÀ\u0003¢\u0006\u0005\b©\u0001\u0010DJ\u0014\u0010ª\u0001\u001a\u0004\u0018\u00010\u0011HÀ\u0003¢\u0006\u0005\b«\u0001\u0010DJ\u0014\u0010¬\u0001\u001a\u0004\u0018\u00010\u0011HÀ\u0003¢\u0006\u0005\b­\u0001\u0010DJ\u0014\u0010®\u0001\u001a\u0004\u0018\u00010\u0011HÀ\u0003¢\u0006\u0005\b¯\u0001\u0010DJ\u0014\u0010°\u0001\u001a\u0004\u0018\u00010\u0011HÀ\u0003¢\u0006\u0005\b±\u0001\u0010DJ\u0014\u0010²\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\b³\u0001\u00109J\u0012\u0010´\u0001\u001a\u0004\u0018\u00010\u0004HÀ\u0003¢\u0006\u0003\bµ\u0001J\u0014\u0010¶\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\b·\u0001\u00109J\u0014\u0010¸\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\b¹\u0001\u00109J\u0014\u0010º\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\b»\u0001\u00109J\u0014\u0010¼\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\b½\u0001\u00109J\u0014\u0010¾\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\b¿\u0001\u00109J\u0014\u0010À\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\bÁ\u0001\u00109J\u0014\u0010Â\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\bÃ\u0001\u00109J\u0014\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\bÅ\u0001\u00109J\u0014\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\bÇ\u0001\u00109J\u0014\u0010È\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\bÉ\u0001\u00109J\u0012\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0004HÀ\u0003¢\u0006\u0003\bË\u0001J\u0014\u0010Ì\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\bÍ\u0001\u00109J\u0014\u0010Î\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\bÏ\u0001\u00109J\u0014\u0010Ð\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\bÑ\u0001\u00109J\u0014\u0010Ò\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\bÓ\u0001\u00109J\u0014\u0010Ô\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\bÕ\u0001\u00109J\u0014\u0010Ö\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\b×\u0001\u00109J\u0018\u0010Ø\u0001\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+HÀ\u0003¢\u0006\u0003\bÙ\u0001J\u0014\u0010Ú\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\bÛ\u0001\u00109J\u0018\u0010Ü\u0001\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010+HÀ\u0003¢\u0006\u0003\bÝ\u0001J\u0018\u0010Þ\u0001\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010+HÀ\u0003¢\u0006\u0003\bß\u0001J\u0012\u0010à\u0001\u001a\u0004\u0018\u00010\u0004HÀ\u0003¢\u0006\u0003\bá\u0001J\u0014\u0010â\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\bã\u0001\u00109J\u0014\u0010ä\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\bå\u0001\u00109J\u0014\u0010æ\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\bç\u0001\u00109J\u0014\u0010è\u0001\u001a\u0004\u0018\u00010\u0019HÀ\u0003¢\u0006\u0005\bé\u0001\u00109J\u0012\u0010ê\u0001\u001a\u0004\u0018\u00010\u0004HÀ\u0003¢\u0006\u0003\bë\u0001J\u0012\u0010ì\u0001\u001a\u0004\u0018\u00010\u0004HÀ\u0003¢\u0006\u0003\bí\u0001J\u0012\u0010î\u0001\u001a\u0004\u0018\u00010\u0004HÀ\u0003¢\u0006\u0003\bï\u0001J\u0012\u0010ð\u0001\u001a\u0004\u0018\u00010\u0004HÀ\u0003¢\u0006\u0003\bñ\u0001J\u0012\u0010ò\u0001\u001a\u0004\u0018\u00010\u0004HÀ\u0003¢\u0006\u0003\bó\u0001J\u0012\u0010ô\u0001\u001a\u0004\u0018\u00010\u0004HÀ\u0003¢\u0006\u0003\bõ\u0001J²\u0004\u0010ö\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00192\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00192\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010+2\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010+2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0003\u0010÷\u0001J\u0015\u0010ø\u0001\u001a\u00020\u00192\t\u0010ù\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010ú\u0001\u001a\u00020\u0011HÖ\u0001J\u000f\u0010û\u0001\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u000f\u0010ü\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010ý\u0001\u001a\u00020\u00002\u0007\u0010þ\u0001\u001a\u00020\u0019J\u0010\u0010ÿ\u0001\u001a\u00020\u00002\u0007\u0010\u0002\u001a\u00020\u0011J\u0010\u0010\u0002\u001a\u00020\u00002\u0007\u0010\u0002\u001a\u00020\u0019J\u000f\u0010\u0002\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\u0002\u001a\u00020\u00002\r\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002010+J\u0015\u0010\u0002\u001a\u00020\u00002\f\u0010\u0002\u001a\u0007\u0012\u0002\b\u00030\u0002J\u000f\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0002\u001a\u00020\u00002\u0007\u0010\u0002\u001a\u00020\u0004J\u0010\u0010\u0002\u001a\u00020\u00002\u0007\u0010\u0002\u001a\u00020\u0004J\u0015\u0010\u0002\u001a\u00020\u00002\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+J\u0010\u0010\u0002\u001a\u00020\u00002\u0007\u0010þ\u0001\u001a\u00020\u0019J\u0017\u0010\u0002\u001a\u00020\u00002\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0007J\u0012\u0010\u0002\u001a\u00020\u00002\u0007\u0010þ\u0001\u001a\u00020\u0019H\u0007J\u0010\u0010\u0002\u001a\u00020\u00002\u0007\u0010þ\u0001\u001a\u00020\u0019J\u0010\u0010\u0002\u001a\u00020\u00002\u0007\u0010\u0002\u001a\u00020\u0004J\u0010\u0010\u0002\u001a\u00020\u00002\u0007\u0010þ\u0001\u001a\u00020\u0019J\u0010\u0010\u0002\u001a\u00020\u00002\u0007\u0010\u0002\u001a\u00020\u0004J\u0010\u0010\u0002\u001a\u00020\u00002\u0007\u0010þ\u0001\u001a\u00020\u0019J\u0010\u0010\u0002\u001a\u00020\u00002\u0007\u0010\u0002\u001a\u00020\u0011J\u0010\u0010\u0002\u001a\u00020\u00002\u0007\u0010\u0002\u001a\u00020\u0011J\u000f\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u0002\u001a\u00020\u00002\u0007\u0010þ\u0001\u001a\u00020\u0019J\u0010\u0010\u0002\u001a\u00020\u00002\u0007\u0010 \u0002\u001a\u00020\u0011J\u0010\u0010¡\u0002\u001a\u00020\u00002\u0007\u0010¢\u0002\u001a\u00020\u0019J\u0010\u0010£\u0002\u001a\u00020\u00002\u0007\u0010þ\u0001\u001a\u00020\u0019J\u0010\u0010¤\u0002\u001a\u00020\u00002\u0007\u0010þ\u0001\u001a\u00020\u0019J\u0010\u0010¥\u0002\u001a\u00020\u00002\u0007\u0010þ\u0001\u001a\u00020\u0019J\u0010\u0010¦\u0002\u001a\u00020\u00002\u0007\u0010þ\u0001\u001a\u00020\u0019J\u000f\u0010§\u0002\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0019J\u0010\u0010¨\u0002\u001a\u00020\u00002\u0007\u0010þ\u0001\u001a\u00020\u0019J\u0010\u0010©\u0002\u001a\u00020\u00002\u0007\u0010þ\u0001\u001a\u00020\u0019J\u000f\u0010ª\u0002\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0019J\u0010\u0010«\u0002\u001a\u00020\u00002\u0007\u0010¬\u0002\u001a\u00020\u0019J\u000f\u0010­\u0002\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0004J\u0010\u0010®\u0002\u001a\u00020\u00002\u0007\u0010¯\u0002\u001a\u00020\u0019J\u0015\u0010°\u0002\u001a\u00020\u00002\f\u0010±\u0002\u001a\u0007\u0012\u0002\b\u00030\u0002J\u0010\u0010²\u0002\u001a\u00020\u00002\u0007\u0010³\u0002\u001a\u00020\u0019J\u0010\u0010´\u0002\u001a\u00020\u00002\u0007\u0010þ\u0001\u001a\u00020\u0019J\u0011\u0010µ\u0002\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010¶\u0002\u001a\u00020\u00002\u000f\u0010·\u0002\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010+J\u000f\u0010¸\u0002\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010¹\u0002\u001a\u00020\u00002\u0007\u0010º\u0002\u001a\u00020\u0011J\u000f\u0010»\u0002\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0004J\u000f\u0010¼\u0002\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0011J\n\u0010½\u0002\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001e\u0010&\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\bA\u00109\"\u0004\bB\u0010;R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010>\"\u0004\bM\u0010@R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010>\"\u0004\bO\u0010@R\"\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010I\"\u0004\bQ\u0010KR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bR\u0010D\"\u0004\bS\u0010FR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010>\"\u0004\bU\u0010@R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010>\"\u0004\bW\u0010@R\"\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010I\"\u0004\bY\u0010KR\u001e\u00104\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\bZ\u00109\"\u0004\b[\u0010;R\u001c\u00106\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010>\"\u0004\b]\u0010@R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010>\"\u0004\b_\u0010@R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\b`\u0010D\"\u0004\ba\u0010FR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bb\u0010D\"\u0004\bc\u0010FR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\bd\u00109\"\u0004\be\u0010;R\u001e\u0010%\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\bf\u00109\"\u0004\bg\u0010;R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bh\u0010D\"\u0004\bi\u0010FR\u001e\u0010 \u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\bj\u00109\"\u0004\bk\u0010;R\u001e\u0010-\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\bl\u00109\"\u0004\bm\u0010;R\u001e\u00105\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\bn\u00109\"\u0004\bo\u0010;R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\bp\u00109\"\u0004\bq\u0010;R\u001e\u0010'\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\br\u00109\"\u0004\bs\u0010;R\u001e\u0010$\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\bt\u00109\"\u0004\bu\u0010;R\u001e\u00102\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\bv\u00109\"\u0004\bw\u0010;R\u001e\u00103\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\bx\u00109\"\u0004\by\u0010;R\u001e\u0010!\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\bz\u00109\"\u0004\b{\u0010;R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\b|\u00109\"\u0004\b}\u0010;R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\b~\u00109\"\u0004\b\u0010;R \u0010\u001d\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0012\n\u0002\u0010<\u001a\u0005\b\u0001\u00109\"\u0005\b\u0001\u0010;R \u0010#\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0012\n\u0002\u0010<\u001a\u0005\b\u0001\u00109\"\u0005\b\u0001\u0010;R \u0010\"\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0012\n\u0002\u0010<\u001a\u0005\b\u0001\u00109\"\u0005\b\u0001\u0010;R \u0010)\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0012\n\u0002\u0010<\u001a\u0005\b\u0001\u00109\"\u0005\b\u0001\u0010;R \u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0012\n\u0002\u0010<\u001a\u0005\b\u0001\u00109\"\u0005\b\u0001\u0010;R \u0010(\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0012\n\u0002\u0010<\u001a\u0005\b\u0001\u00109\"\u0005\b\u0001\u0010;R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010>\"\u0005\b\u0001\u0010@R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010>\"\u0005\b\u0001\u0010@R \u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010>\"\u0005\b\u0001\u0010@R \u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0012\n\u0002\u0010G\u001a\u0005\b\u0001\u0010D\"\u0005\b\u0001\u0010FR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010>\"\u0005\b\u0001\u0010@R \u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0012\n\u0002\u0010G\u001a\u0005\b\u0001\u0010D\"\u0005\b\u0001\u0010F¨\u0006¾\u0002"}, d2 = {"Lcom/braze/configuration/BrazeConfig$Builder;", "", "()V", "apiKey", "", "serverTarget", "smallNotificationIconName", "largeNotificationIconName", "customEndpoint", "defaultNotificationChannelName", "defaultNotificationChannelDescription", "pushDeepLinkBackStackActivityClassName", "firebaseCloudMessagingSenderIdKey", "customHtmlWebViewActivityClassName", "sdkFlavor", "Lcom/braze/enums/SdkFlavor;", "sessionTimeout", "", "defaultNotificationAccentColor", "triggerActionMinimumTimeIntervalSeconds", "badNetworkInterval", "goodNetworkInterval", "greatNetworkInterval", "inAppMessageWebViewClientMaxOnPageFinishedWaitMs", "admMessagingRegistrationEnabled", "", "handlePushDeepLinksAutomatically", "isLocationCollectionEnabled", "isNewsFeedVisualIndicatorOn", "isPushDeepLinkBackStackActivityEnabled", "isSessionStartBasedTimeoutEnabled", "isFirebaseCloudMessagingRegistrationEnabled", "isContentCardsUnreadVisualIndicatorEnabled", "isInAppMessageAccessibilityExclusiveModeEnabled", "isPushWakeScreenForNotificationEnabled", "isPushHtmlRenderingEnabled", "isGeofencesEnabled", "inAppMessageTestPushEagerDisplayEnabled", "automaticGeofenceRequestsEnabled", "isFirebaseMessagingServiceOnNewTokenRegistrationEnabled", "isTouchModeRequiredForHtmlInAppMessages", "isSdkAuthEnabled", "deviceObjectAllowlist", "Ljava/util/EnumSet;", "Lcom/braze/enums/DeviceKey;", "isDeviceObjectAllowlistEnabled", "brazeSdkMetadata", "Lcom/braze/enums/BrazeSdkMetadata;", "customLocationProviderNames", "Lcom/braze/enums/LocationProviderName;", "isHtmlInAppMessageApplyWindowInsetsEnabled", "isHtmlInAppMessageHtmlLinkTargetEnabled", "doesPushStoryDismissOnClick", "isFallbackFirebaseMessagingServiceEnabled", "fallbackFirebaseMessagingServiceClasspath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/braze/enums/SdkFlavor;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/EnumSet;Ljava/lang/Boolean;Ljava/util/EnumSet;Ljava/util/EnumSet;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getAdmMessagingRegistrationEnabled$android_sdk_base_release", "()Ljava/lang/Boolean;", "setAdmMessagingRegistrationEnabled$android_sdk_base_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getApiKey$android_sdk_base_release", "()Ljava/lang/String;", "setApiKey$android_sdk_base_release", "(Ljava/lang/String;)V", "getAutomaticGeofenceRequestsEnabled$android_sdk_base_release", "setAutomaticGeofenceRequestsEnabled$android_sdk_base_release", "getBadNetworkInterval$android_sdk_base_release", "()Ljava/lang/Integer;", "setBadNetworkInterval$android_sdk_base_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBrazeSdkMetadata$android_sdk_base_release", "()Ljava/util/EnumSet;", "setBrazeSdkMetadata$android_sdk_base_release", "(Ljava/util/EnumSet;)V", "getCustomEndpoint$android_sdk_base_release", "setCustomEndpoint$android_sdk_base_release", "getCustomHtmlWebViewActivityClassName$android_sdk_base_release", "setCustomHtmlWebViewActivityClassName$android_sdk_base_release", "getCustomLocationProviderNames$android_sdk_base_release", "setCustomLocationProviderNames$android_sdk_base_release", "getDefaultNotificationAccentColor$android_sdk_base_release", "setDefaultNotificationAccentColor$android_sdk_base_release", "getDefaultNotificationChannelDescription$android_sdk_base_release", "setDefaultNotificationChannelDescription$android_sdk_base_release", "getDefaultNotificationChannelName$android_sdk_base_release", "setDefaultNotificationChannelName$android_sdk_base_release", "getDeviceObjectAllowlist$android_sdk_base_release", "setDeviceObjectAllowlist$android_sdk_base_release", "getDoesPushStoryDismissOnClick$android_sdk_base_release", "setDoesPushStoryDismissOnClick$android_sdk_base_release", "getFallbackFirebaseMessagingServiceClasspath$android_sdk_base_release", "setFallbackFirebaseMessagingServiceClasspath$android_sdk_base_release", "getFirebaseCloudMessagingSenderIdKey$android_sdk_base_release", "setFirebaseCloudMessagingSenderIdKey$android_sdk_base_release", "getGoodNetworkInterval$android_sdk_base_release", "setGoodNetworkInterval$android_sdk_base_release", "getGreatNetworkInterval$android_sdk_base_release", "setGreatNetworkInterval$android_sdk_base_release", "getHandlePushDeepLinksAutomatically$android_sdk_base_release", "setHandlePushDeepLinksAutomatically$android_sdk_base_release", "getInAppMessageTestPushEagerDisplayEnabled$android_sdk_base_release", "setInAppMessageTestPushEagerDisplayEnabled$android_sdk_base_release", "getInAppMessageWebViewClientMaxOnPageFinishedWaitMs$android_sdk_base_release", "setInAppMessageWebViewClientMaxOnPageFinishedWaitMs$android_sdk_base_release", "isContentCardsUnreadVisualIndicatorEnabled$android_sdk_base_release", "setContentCardsUnreadVisualIndicatorEnabled$android_sdk_base_release", "isDeviceObjectAllowlistEnabled$android_sdk_base_release", "setDeviceObjectAllowlistEnabled$android_sdk_base_release", "isFallbackFirebaseMessagingServiceEnabled$android_sdk_base_release", "setFallbackFirebaseMessagingServiceEnabled$android_sdk_base_release", "isFirebaseCloudMessagingRegistrationEnabled$android_sdk_base_release", "setFirebaseCloudMessagingRegistrationEnabled$android_sdk_base_release", "isFirebaseMessagingServiceOnNewTokenRegistrationEnabled$android_sdk_base_release", "setFirebaseMessagingServiceOnNewTokenRegistrationEnabled$android_sdk_base_release", "isGeofencesEnabled$android_sdk_base_release", "setGeofencesEnabled$android_sdk_base_release", "isHtmlInAppMessageApplyWindowInsetsEnabled$android_sdk_base_release", "setHtmlInAppMessageApplyWindowInsetsEnabled$android_sdk_base_release", "isHtmlInAppMessageHtmlLinkTargetEnabled$android_sdk_base_release", "setHtmlInAppMessageHtmlLinkTargetEnabled$android_sdk_base_release", "isInAppMessageAccessibilityExclusiveModeEnabled$android_sdk_base_release", "setInAppMessageAccessibilityExclusiveModeEnabled$android_sdk_base_release", "isLocationCollectionEnabled$android_sdk_base_release", "setLocationCollectionEnabled$android_sdk_base_release", "isNewsFeedVisualIndicatorOn$android_sdk_base_release", "setNewsFeedVisualIndicatorOn$android_sdk_base_release", "isPushDeepLinkBackStackActivityEnabled$android_sdk_base_release", "setPushDeepLinkBackStackActivityEnabled$android_sdk_base_release", "isPushHtmlRenderingEnabled$android_sdk_base_release", "setPushHtmlRenderingEnabled$android_sdk_base_release", "isPushWakeScreenForNotificationEnabled$android_sdk_base_release", "setPushWakeScreenForNotificationEnabled$android_sdk_base_release", "isSdkAuthEnabled$android_sdk_base_release", "setSdkAuthEnabled$android_sdk_base_release", "isSessionStartBasedTimeoutEnabled$android_sdk_base_release", "setSessionStartBasedTimeoutEnabled$android_sdk_base_release", "isTouchModeRequiredForHtmlInAppMessages$android_sdk_base_release", "setTouchModeRequiredForHtmlInAppMessages$android_sdk_base_release", "getLargeNotificationIconName$android_sdk_base_release", "setLargeNotificationIconName$android_sdk_base_release", "getPushDeepLinkBackStackActivityClassName$android_sdk_base_release", "setPushDeepLinkBackStackActivityClassName$android_sdk_base_release", "getSdkFlavor$android_sdk_base_release", "()Lcom/braze/enums/SdkFlavor;", "setSdkFlavor$android_sdk_base_release", "(Lcom/braze/enums/SdkFlavor;)V", "getServerTarget$android_sdk_base_release", "setServerTarget$android_sdk_base_release", "getSessionTimeout$android_sdk_base_release", "setSessionTimeout$android_sdk_base_release", "getSmallNotificationIconName$android_sdk_base_release", "setSmallNotificationIconName$android_sdk_base_release", "getTriggerActionMinimumTimeIntervalSeconds$android_sdk_base_release", "setTriggerActionMinimumTimeIntervalSeconds$android_sdk_base_release", "build", "Lcom/braze/configuration/BrazeConfig;", "component1", "component1$android_sdk_base_release", "component10", "component10$android_sdk_base_release", "component11", "component11$android_sdk_base_release", "component12", "component12$android_sdk_base_release", "component13", "component13$android_sdk_base_release", "component14", "component14$android_sdk_base_release", "component15", "component15$android_sdk_base_release", "component16", "component16$android_sdk_base_release", "component17", "component17$android_sdk_base_release", "component18", "component18$android_sdk_base_release", "component19", "component19$android_sdk_base_release", "component2", "component2$android_sdk_base_release", "component20", "component20$android_sdk_base_release", "component21", "component21$android_sdk_base_release", "component22", "component22$android_sdk_base_release", "component23", "component23$android_sdk_base_release", "component24", "component24$android_sdk_base_release", "component25", "component25$android_sdk_base_release", "component26", "component26$android_sdk_base_release", "component27", "component27$android_sdk_base_release", "component28", "component28$android_sdk_base_release", "component29", "component29$android_sdk_base_release", "component3", "component3$android_sdk_base_release", "component30", "component30$android_sdk_base_release", "component31", "component31$android_sdk_base_release", "component32", "component32$android_sdk_base_release", "component33", "component33$android_sdk_base_release", "component34", "component34$android_sdk_base_release", "component35", "component35$android_sdk_base_release", "component36", "component36$android_sdk_base_release", "component37", "component37$android_sdk_base_release", "component38", "component38$android_sdk_base_release", "component39", "component39$android_sdk_base_release", "component4", "component4$android_sdk_base_release", "component40", "component40$android_sdk_base_release", "component41", "component41$android_sdk_base_release", "component42", "component42$android_sdk_base_release", "component43", "component43$android_sdk_base_release", "component44", "component44$android_sdk_base_release", "component5", "component5$android_sdk_base_release", "component6", "component6$android_sdk_base_release", "component7", "component7$android_sdk_base_release", "component8", "component8$android_sdk_base_release", "component9", "component9$android_sdk_base_release", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/braze/enums/SdkFlavor;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/EnumSet;Ljava/lang/Boolean;Ljava/util/EnumSet;Ljava/util/EnumSet;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/braze/configuration/BrazeConfig$Builder;", "equals", "other", "hashCode", "setAdmMessagingRegistrationEnabled", "setApiKey", "setAutomaticGeofenceRequestsEnabled", "enabled", "setBadNetworkDataFlushInterval", "badNetworkIntervalSeconds", "setContentCardsUnreadVisualIndicatorEnabled", "contentCardsUnreadVisualIndicatorEnabled", "setCustomEndpoint", "setCustomLocationProviderNames", "locationProviderNames", "setCustomWebViewActivityClass", "customWebViewActivityClass", "Ljava/lang/Class;", "setDefaultNotificationAccentColor", "setDefaultNotificationChannelDescription", "description", "setDefaultNotificationChannelName", "name", "setDeviceObjectAllowlist", "setDeviceObjectAllowlistEnabled", "setDeviceObjectWhitelist", "setDeviceObjectWhitelistEnabled", "setDoesPushStoryDismissOnClick", "setFallbackFirebaseMessagingServiceClasspath", "classpath", "setFallbackFirebaseMessagingServiceEnabled", "setFirebaseCloudMessagingSenderIdKey", "firebaseSenderId", "setGeofencesEnabled", "setGoodNetworkDataFlushInterval", "goodNetworkIntervalSeconds", "setGreatNetworkDataFlushInterval", "greatNetworkIntervalSeconds", "setHandlePushDeepLinksAutomatically", "setInAppMessageTestPushEagerDisplayEnabled", "setInAppMessageWebViewClientMaxOnPageFinishedWaitMs", "maxOnPageFinishedWaitMs", "setIsFirebaseCloudMessagingRegistrationEnabled", "firebaseMessagingRegistrationEnabled", "setIsFirebaseMessagingServiceOnNewTokenRegistrationEnabled", "setIsHtmlInAppMessageApplyWindowInsetsEnabled", "setIsHtmlInAppMessageHtmlLinkTargetEnabled", "setIsInAppMessageAccessibilityExclusiveModeEnabled", "setIsLocationCollectionEnabled", "setIsPushWakeScreenForNotificationEnabled", "setIsSdkAuthenticationEnabled", "setIsSessionStartBasedTimeoutEnabled", "setIsTouchModeRequiredForHtmlInAppMessages", "required", "setLargeNotificationIcon", "setNewsfeedVisualIndicatorOn", "newsfeedVisualIndicatorOn", "setPushDeepLinkBackStackActivityClass", "pushDeepLinkActivityClass", "setPushDeepLinkBackStackActivityEnabled", "pushDeepLinkBackStackActivityEnabled", "setPushHtmlRenderingEnabled", "setSdkFlavor", "setSdkMetadata", "sdkMetadata", "setServerTarget", "setSessionTimeout", "sessionTimeoutSeconds", "setSmallNotificationIcon", "setTriggerActionMinimumTimeIntervalSeconds", "toString", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private Boolean admMessagingRegistrationEnabled;
        private String apiKey;
        private Boolean automaticGeofenceRequestsEnabled;
        private Integer badNetworkInterval;
        private EnumSet<BrazeSdkMetadata> brazeSdkMetadata;
        private String customEndpoint;
        private String customHtmlWebViewActivityClassName;
        private EnumSet<LocationProviderName> customLocationProviderNames;
        private Integer defaultNotificationAccentColor;
        private String defaultNotificationChannelDescription;
        private String defaultNotificationChannelName;
        private EnumSet<DeviceKey> deviceObjectAllowlist;
        private Boolean doesPushStoryDismissOnClick;
        private String fallbackFirebaseMessagingServiceClasspath;
        private String firebaseCloudMessagingSenderIdKey;
        private Integer goodNetworkInterval;
        private Integer greatNetworkInterval;
        private Boolean handlePushDeepLinksAutomatically;
        private Boolean inAppMessageTestPushEagerDisplayEnabled;
        private Integer inAppMessageWebViewClientMaxOnPageFinishedWaitMs;
        private Boolean isContentCardsUnreadVisualIndicatorEnabled;
        private Boolean isDeviceObjectAllowlistEnabled;
        private Boolean isFallbackFirebaseMessagingServiceEnabled;
        private Boolean isFirebaseCloudMessagingRegistrationEnabled;
        private Boolean isFirebaseMessagingServiceOnNewTokenRegistrationEnabled;
        private Boolean isGeofencesEnabled;
        private Boolean isHtmlInAppMessageApplyWindowInsetsEnabled;
        private Boolean isHtmlInAppMessageHtmlLinkTargetEnabled;
        private Boolean isInAppMessageAccessibilityExclusiveModeEnabled;
        private Boolean isLocationCollectionEnabled;
        private Boolean isNewsFeedVisualIndicatorOn;
        private Boolean isPushDeepLinkBackStackActivityEnabled;
        private Boolean isPushHtmlRenderingEnabled;
        private Boolean isPushWakeScreenForNotificationEnabled;
        private Boolean isSdkAuthEnabled;
        private Boolean isSessionStartBasedTimeoutEnabled;
        private Boolean isTouchModeRequiredForHtmlInAppMessages;
        private String largeNotificationIconName;
        private String pushDeepLinkBackStackActivityClassName;
        private SdkFlavor sdkFlavor;
        private String serverTarget;
        private Integer sessionTimeout;
        private String smallNotificationIconName;
        private Integer triggerActionMinimumTimeIntervalSeconds;

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Cannot set Braze API key to blank string. API key field not set";
            }
        }

        static final class b extends Lambda implements Function0 {
            public static final b b = new b();

            b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Cannot set Braze default NotificationChannel description to null or blank string. NotificationChannel description field not set.";
            }
        }

        static final class c extends Lambda implements Function0 {
            public static final c b = new c();

            c() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Cannot set Braze default NotificationChannel name to blank string. NotificationChannel name field not set.";
            }
        }

        static final class d extends Lambda implements Function0 {
            public static final d b = new d();

            d() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Cannot set Firebase Cloud Messaging Sender Id to blank string. Firebase Cloud Messaging Sender Id field not set";
            }
        }

        static final class e extends Lambda implements Function0 {
            final /* synthetic */ int b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(int i) {
                super(0);
                this.b = i;
            }

            /* renamed from: a */
            public final String invoke() {
                return "setInAppMessageWebViewClientMaxOnPageFinishedWaitMs called with negative value. Not setting timeout to: " + this.b;
            }
        }

        private Builder(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, SdkFlavor sdkFlavor2, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, EnumSet<DeviceKey> enumSet, Boolean bool18, EnumSet<BrazeSdkMetadata> enumSet2, EnumSet<LocationProviderName> enumSet3, Boolean bool19, Boolean bool20, Boolean bool21, Boolean bool22, String str11) {
            this.apiKey = str;
            this.serverTarget = str2;
            this.smallNotificationIconName = str3;
            this.largeNotificationIconName = str4;
            this.customEndpoint = str5;
            this.defaultNotificationChannelName = str6;
            this.defaultNotificationChannelDescription = str7;
            this.pushDeepLinkBackStackActivityClassName = str8;
            this.firebaseCloudMessagingSenderIdKey = str9;
            this.customHtmlWebViewActivityClassName = str10;
            this.sdkFlavor = sdkFlavor2;
            this.sessionTimeout = num;
            this.defaultNotificationAccentColor = num2;
            this.triggerActionMinimumTimeIntervalSeconds = num3;
            this.badNetworkInterval = num4;
            this.goodNetworkInterval = num5;
            this.greatNetworkInterval = num6;
            this.inAppMessageWebViewClientMaxOnPageFinishedWaitMs = num7;
            this.admMessagingRegistrationEnabled = bool;
            this.handlePushDeepLinksAutomatically = bool2;
            this.isLocationCollectionEnabled = bool3;
            this.isNewsFeedVisualIndicatorOn = bool4;
            this.isPushDeepLinkBackStackActivityEnabled = bool5;
            this.isSessionStartBasedTimeoutEnabled = bool6;
            this.isFirebaseCloudMessagingRegistrationEnabled = bool7;
            this.isContentCardsUnreadVisualIndicatorEnabled = bool8;
            this.isInAppMessageAccessibilityExclusiveModeEnabled = bool9;
            this.isPushWakeScreenForNotificationEnabled = bool10;
            this.isPushHtmlRenderingEnabled = bool11;
            this.isGeofencesEnabled = bool12;
            this.inAppMessageTestPushEagerDisplayEnabled = bool13;
            this.automaticGeofenceRequestsEnabled = bool14;
            this.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled = bool15;
            this.isTouchModeRequiredForHtmlInAppMessages = bool16;
            this.isSdkAuthEnabled = bool17;
            this.deviceObjectAllowlist = enumSet;
            this.isDeviceObjectAllowlistEnabled = bool18;
            this.brazeSdkMetadata = enumSet2;
            this.customLocationProviderNames = enumSet3;
            this.isHtmlInAppMessageApplyWindowInsetsEnabled = bool19;
            this.isHtmlInAppMessageHtmlLinkTargetEnabled = bool20;
            this.doesPushStoryDismissOnClick = bool21;
            this.isFallbackFirebaseMessagingServiceEnabled = bool22;
            this.fallbackFirebaseMessagingServiceClasspath = str11;
        }

        public static /* synthetic */ Builder copy$default(Builder builder, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, SdkFlavor sdkFlavor2, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, EnumSet enumSet, Boolean bool18, EnumSet enumSet2, EnumSet enumSet3, Boolean bool19, Boolean bool20, Boolean bool21, Boolean bool22, String str11, int i, int i2, Object obj) {
            Builder builder2 = builder;
            int i3 = i;
            int i4 = i2;
            return builder.copy((i3 & 1) != 0 ? builder2.apiKey : str, (i3 & 2) != 0 ? builder2.serverTarget : str2, (i3 & 4) != 0 ? builder2.smallNotificationIconName : str3, (i3 & 8) != 0 ? builder2.largeNotificationIconName : str4, (i3 & 16) != 0 ? builder2.customEndpoint : str5, (i3 & 32) != 0 ? builder2.defaultNotificationChannelName : str6, (i3 & 64) != 0 ? builder2.defaultNotificationChannelDescription : str7, (i3 & 128) != 0 ? builder2.pushDeepLinkBackStackActivityClassName : str8, (i3 & 256) != 0 ? builder2.firebaseCloudMessagingSenderIdKey : str9, (i3 & 512) != 0 ? builder2.customHtmlWebViewActivityClassName : str10, (i3 & 1024) != 0 ? builder2.sdkFlavor : sdkFlavor2, (i3 & 2048) != 0 ? builder2.sessionTimeout : num, (i3 & 4096) != 0 ? builder2.defaultNotificationAccentColor : num2, (i3 & 8192) != 0 ? builder2.triggerActionMinimumTimeIntervalSeconds : num3, (i3 & 16384) != 0 ? builder2.badNetworkInterval : num4, (i3 & 32768) != 0 ? builder2.goodNetworkInterval : num5, (i3 & 65536) != 0 ? builder2.greatNetworkInterval : num6, (i3 & 131072) != 0 ? builder2.inAppMessageWebViewClientMaxOnPageFinishedWaitMs : num7, (i3 & 262144) != 0 ? builder2.admMessagingRegistrationEnabled : bool, (i3 & 524288) != 0 ? builder2.handlePushDeepLinksAutomatically : bool2, (i3 & 1048576) != 0 ? builder2.isLocationCollectionEnabled : bool3, (i3 & 2097152) != 0 ? builder2.isNewsFeedVisualIndicatorOn : bool4, (i3 & 4194304) != 0 ? builder2.isPushDeepLinkBackStackActivityEnabled : bool5, (i3 & 8388608) != 0 ? builder2.isSessionStartBasedTimeoutEnabled : bool6, (i3 & 16777216) != 0 ? builder2.isFirebaseCloudMessagingRegistrationEnabled : bool7, (i3 & 33554432) != 0 ? builder2.isContentCardsUnreadVisualIndicatorEnabled : bool8, (i3 & 67108864) != 0 ? builder2.isInAppMessageAccessibilityExclusiveModeEnabled : bool9, (i3 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? builder2.isPushWakeScreenForNotificationEnabled : bool10, (i3 & 268435456) != 0 ? builder2.isPushHtmlRenderingEnabled : bool11, (i3 & 536870912) != 0 ? builder2.isGeofencesEnabled : bool12, (i3 & 1073741824) != 0 ? builder2.inAppMessageTestPushEagerDisplayEnabled : bool13, (i3 & Integer.MIN_VALUE) != 0 ? builder2.automaticGeofenceRequestsEnabled : bool14, (i4 & 1) != 0 ? builder2.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled : bool15, (i4 & 2) != 0 ? builder2.isTouchModeRequiredForHtmlInAppMessages : bool16, (i4 & 4) != 0 ? builder2.isSdkAuthEnabled : bool17, (i4 & 8) != 0 ? builder2.deviceObjectAllowlist : enumSet, (i4 & 16) != 0 ? builder2.isDeviceObjectAllowlistEnabled : bool18, (i4 & 32) != 0 ? builder2.brazeSdkMetadata : enumSet2, (i4 & 64) != 0 ? builder2.customLocationProviderNames : enumSet3, (i4 & 128) != 0 ? builder2.isHtmlInAppMessageApplyWindowInsetsEnabled : bool19, (i4 & 256) != 0 ? builder2.isHtmlInAppMessageHtmlLinkTargetEnabled : bool20, (i4 & 512) != 0 ? builder2.doesPushStoryDismissOnClick : bool21, (i4 & 1024) != 0 ? builder2.isFallbackFirebaseMessagingServiceEnabled : bool22, (i4 & 2048) != 0 ? builder2.fallbackFirebaseMessagingServiceClasspath : str11);
        }

        public final BrazeConfig build() {
            return new BrazeConfig(this, (DefaultConstructorMarker) null);
        }

        public final String component1$android_sdk_base_release() {
            return this.apiKey;
        }

        public final String component10$android_sdk_base_release() {
            return this.customHtmlWebViewActivityClassName;
        }

        public final SdkFlavor component11$android_sdk_base_release() {
            return this.sdkFlavor;
        }

        public final Integer component12$android_sdk_base_release() {
            return this.sessionTimeout;
        }

        public final Integer component13$android_sdk_base_release() {
            return this.defaultNotificationAccentColor;
        }

        public final Integer component14$android_sdk_base_release() {
            return this.triggerActionMinimumTimeIntervalSeconds;
        }

        public final Integer component15$android_sdk_base_release() {
            return this.badNetworkInterval;
        }

        public final Integer component16$android_sdk_base_release() {
            return this.goodNetworkInterval;
        }

        public final Integer component17$android_sdk_base_release() {
            return this.greatNetworkInterval;
        }

        public final Integer component18$android_sdk_base_release() {
            return this.inAppMessageWebViewClientMaxOnPageFinishedWaitMs;
        }

        public final Boolean component19$android_sdk_base_release() {
            return this.admMessagingRegistrationEnabled;
        }

        public final String component2$android_sdk_base_release() {
            return this.serverTarget;
        }

        public final Boolean component20$android_sdk_base_release() {
            return this.handlePushDeepLinksAutomatically;
        }

        public final Boolean component21$android_sdk_base_release() {
            return this.isLocationCollectionEnabled;
        }

        public final Boolean component22$android_sdk_base_release() {
            return this.isNewsFeedVisualIndicatorOn;
        }

        public final Boolean component23$android_sdk_base_release() {
            return this.isPushDeepLinkBackStackActivityEnabled;
        }

        public final Boolean component24$android_sdk_base_release() {
            return this.isSessionStartBasedTimeoutEnabled;
        }

        public final Boolean component25$android_sdk_base_release() {
            return this.isFirebaseCloudMessagingRegistrationEnabled;
        }

        public final Boolean component26$android_sdk_base_release() {
            return this.isContentCardsUnreadVisualIndicatorEnabled;
        }

        public final Boolean component27$android_sdk_base_release() {
            return this.isInAppMessageAccessibilityExclusiveModeEnabled;
        }

        public final Boolean component28$android_sdk_base_release() {
            return this.isPushWakeScreenForNotificationEnabled;
        }

        public final Boolean component29$android_sdk_base_release() {
            return this.isPushHtmlRenderingEnabled;
        }

        public final String component3$android_sdk_base_release() {
            return this.smallNotificationIconName;
        }

        public final Boolean component30$android_sdk_base_release() {
            return this.isGeofencesEnabled;
        }

        public final Boolean component31$android_sdk_base_release() {
            return this.inAppMessageTestPushEagerDisplayEnabled;
        }

        public final Boolean component32$android_sdk_base_release() {
            return this.automaticGeofenceRequestsEnabled;
        }

        public final Boolean component33$android_sdk_base_release() {
            return this.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled;
        }

        public final Boolean component34$android_sdk_base_release() {
            return this.isTouchModeRequiredForHtmlInAppMessages;
        }

        public final Boolean component35$android_sdk_base_release() {
            return this.isSdkAuthEnabled;
        }

        public final EnumSet<DeviceKey> component36$android_sdk_base_release() {
            return this.deviceObjectAllowlist;
        }

        public final Boolean component37$android_sdk_base_release() {
            return this.isDeviceObjectAllowlistEnabled;
        }

        public final EnumSet<BrazeSdkMetadata> component38$android_sdk_base_release() {
            return this.brazeSdkMetadata;
        }

        public final EnumSet<LocationProviderName> component39$android_sdk_base_release() {
            return this.customLocationProviderNames;
        }

        public final String component4$android_sdk_base_release() {
            return this.largeNotificationIconName;
        }

        public final Boolean component40$android_sdk_base_release() {
            return this.isHtmlInAppMessageApplyWindowInsetsEnabled;
        }

        public final Boolean component41$android_sdk_base_release() {
            return this.isHtmlInAppMessageHtmlLinkTargetEnabled;
        }

        public final Boolean component42$android_sdk_base_release() {
            return this.doesPushStoryDismissOnClick;
        }

        public final Boolean component43$android_sdk_base_release() {
            return this.isFallbackFirebaseMessagingServiceEnabled;
        }

        public final String component44$android_sdk_base_release() {
            return this.fallbackFirebaseMessagingServiceClasspath;
        }

        public final String component5$android_sdk_base_release() {
            return this.customEndpoint;
        }

        public final String component6$android_sdk_base_release() {
            return this.defaultNotificationChannelName;
        }

        public final String component7$android_sdk_base_release() {
            return this.defaultNotificationChannelDescription;
        }

        public final String component8$android_sdk_base_release() {
            return this.pushDeepLinkBackStackActivityClassName;
        }

        public final String component9$android_sdk_base_release() {
            return this.firebaseCloudMessagingSenderIdKey;
        }

        public final Builder copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, SdkFlavor sdkFlavor2, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, EnumSet<DeviceKey> enumSet, Boolean bool18, EnumSet<BrazeSdkMetadata> enumSet2, EnumSet<LocationProviderName> enumSet3, Boolean bool19, Boolean bool20, Boolean bool21, Boolean bool22, String str11) {
            return new Builder(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, sdkFlavor2, num, num2, num3, num4, num5, num6, num7, bool, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13, bool14, bool15, bool16, bool17, enumSet, bool18, enumSet2, enumSet3, bool19, bool20, bool21, bool22, str11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) obj;
            return Intrinsics.areEqual((Object) this.apiKey, (Object) builder.apiKey) && Intrinsics.areEqual((Object) this.serverTarget, (Object) builder.serverTarget) && Intrinsics.areEqual((Object) this.smallNotificationIconName, (Object) builder.smallNotificationIconName) && Intrinsics.areEqual((Object) this.largeNotificationIconName, (Object) builder.largeNotificationIconName) && Intrinsics.areEqual((Object) this.customEndpoint, (Object) builder.customEndpoint) && Intrinsics.areEqual((Object) this.defaultNotificationChannelName, (Object) builder.defaultNotificationChannelName) && Intrinsics.areEqual((Object) this.defaultNotificationChannelDescription, (Object) builder.defaultNotificationChannelDescription) && Intrinsics.areEqual((Object) this.pushDeepLinkBackStackActivityClassName, (Object) builder.pushDeepLinkBackStackActivityClassName) && Intrinsics.areEqual((Object) this.firebaseCloudMessagingSenderIdKey, (Object) builder.firebaseCloudMessagingSenderIdKey) && Intrinsics.areEqual((Object) this.customHtmlWebViewActivityClassName, (Object) builder.customHtmlWebViewActivityClassName) && this.sdkFlavor == builder.sdkFlavor && Intrinsics.areEqual((Object) this.sessionTimeout, (Object) builder.sessionTimeout) && Intrinsics.areEqual((Object) this.defaultNotificationAccentColor, (Object) builder.defaultNotificationAccentColor) && Intrinsics.areEqual((Object) this.triggerActionMinimumTimeIntervalSeconds, (Object) builder.triggerActionMinimumTimeIntervalSeconds) && Intrinsics.areEqual((Object) this.badNetworkInterval, (Object) builder.badNetworkInterval) && Intrinsics.areEqual((Object) this.goodNetworkInterval, (Object) builder.goodNetworkInterval) && Intrinsics.areEqual((Object) this.greatNetworkInterval, (Object) builder.greatNetworkInterval) && Intrinsics.areEqual((Object) this.inAppMessageWebViewClientMaxOnPageFinishedWaitMs, (Object) builder.inAppMessageWebViewClientMaxOnPageFinishedWaitMs) && Intrinsics.areEqual((Object) this.admMessagingRegistrationEnabled, (Object) builder.admMessagingRegistrationEnabled) && Intrinsics.areEqual((Object) this.handlePushDeepLinksAutomatically, (Object) builder.handlePushDeepLinksAutomatically) && Intrinsics.areEqual((Object) this.isLocationCollectionEnabled, (Object) builder.isLocationCollectionEnabled) && Intrinsics.areEqual((Object) this.isNewsFeedVisualIndicatorOn, (Object) builder.isNewsFeedVisualIndicatorOn) && Intrinsics.areEqual((Object) this.isPushDeepLinkBackStackActivityEnabled, (Object) builder.isPushDeepLinkBackStackActivityEnabled) && Intrinsics.areEqual((Object) this.isSessionStartBasedTimeoutEnabled, (Object) builder.isSessionStartBasedTimeoutEnabled) && Intrinsics.areEqual((Object) this.isFirebaseCloudMessagingRegistrationEnabled, (Object) builder.isFirebaseCloudMessagingRegistrationEnabled) && Intrinsics.areEqual((Object) this.isContentCardsUnreadVisualIndicatorEnabled, (Object) builder.isContentCardsUnreadVisualIndicatorEnabled) && Intrinsics.areEqual((Object) this.isInAppMessageAccessibilityExclusiveModeEnabled, (Object) builder.isInAppMessageAccessibilityExclusiveModeEnabled) && Intrinsics.areEqual((Object) this.isPushWakeScreenForNotificationEnabled, (Object) builder.isPushWakeScreenForNotificationEnabled) && Intrinsics.areEqual((Object) this.isPushHtmlRenderingEnabled, (Object) builder.isPushHtmlRenderingEnabled) && Intrinsics.areEqual((Object) this.isGeofencesEnabled, (Object) builder.isGeofencesEnabled) && Intrinsics.areEqual((Object) this.inAppMessageTestPushEagerDisplayEnabled, (Object) builder.inAppMessageTestPushEagerDisplayEnabled) && Intrinsics.areEqual((Object) this.automaticGeofenceRequestsEnabled, (Object) builder.automaticGeofenceRequestsEnabled) && Intrinsics.areEqual((Object) this.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled, (Object) builder.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled) && Intrinsics.areEqual((Object) this.isTouchModeRequiredForHtmlInAppMessages, (Object) builder.isTouchModeRequiredForHtmlInAppMessages) && Intrinsics.areEqual((Object) this.isSdkAuthEnabled, (Object) builder.isSdkAuthEnabled) && Intrinsics.areEqual((Object) this.deviceObjectAllowlist, (Object) builder.deviceObjectAllowlist) && Intrinsics.areEqual((Object) this.isDeviceObjectAllowlistEnabled, (Object) builder.isDeviceObjectAllowlistEnabled) && Intrinsics.areEqual((Object) this.brazeSdkMetadata, (Object) builder.brazeSdkMetadata) && Intrinsics.areEqual((Object) this.customLocationProviderNames, (Object) builder.customLocationProviderNames) && Intrinsics.areEqual((Object) this.isHtmlInAppMessageApplyWindowInsetsEnabled, (Object) builder.isHtmlInAppMessageApplyWindowInsetsEnabled) && Intrinsics.areEqual((Object) this.isHtmlInAppMessageHtmlLinkTargetEnabled, (Object) builder.isHtmlInAppMessageHtmlLinkTargetEnabled) && Intrinsics.areEqual((Object) this.doesPushStoryDismissOnClick, (Object) builder.doesPushStoryDismissOnClick) && Intrinsics.areEqual((Object) this.isFallbackFirebaseMessagingServiceEnabled, (Object) builder.isFallbackFirebaseMessagingServiceEnabled) && Intrinsics.areEqual((Object) this.fallbackFirebaseMessagingServiceClasspath, (Object) builder.fallbackFirebaseMessagingServiceClasspath);
        }

        public final Boolean getAdmMessagingRegistrationEnabled$android_sdk_base_release() {
            return this.admMessagingRegistrationEnabled;
        }

        public final String getApiKey$android_sdk_base_release() {
            return this.apiKey;
        }

        public final Boolean getAutomaticGeofenceRequestsEnabled$android_sdk_base_release() {
            return this.automaticGeofenceRequestsEnabled;
        }

        public final Integer getBadNetworkInterval$android_sdk_base_release() {
            return this.badNetworkInterval;
        }

        public final EnumSet<BrazeSdkMetadata> getBrazeSdkMetadata$android_sdk_base_release() {
            return this.brazeSdkMetadata;
        }

        public final String getCustomEndpoint$android_sdk_base_release() {
            return this.customEndpoint;
        }

        public final String getCustomHtmlWebViewActivityClassName$android_sdk_base_release() {
            return this.customHtmlWebViewActivityClassName;
        }

        public final EnumSet<LocationProviderName> getCustomLocationProviderNames$android_sdk_base_release() {
            return this.customLocationProviderNames;
        }

        public final Integer getDefaultNotificationAccentColor$android_sdk_base_release() {
            return this.defaultNotificationAccentColor;
        }

        public final String getDefaultNotificationChannelDescription$android_sdk_base_release() {
            return this.defaultNotificationChannelDescription;
        }

        public final String getDefaultNotificationChannelName$android_sdk_base_release() {
            return this.defaultNotificationChannelName;
        }

        public final EnumSet<DeviceKey> getDeviceObjectAllowlist$android_sdk_base_release() {
            return this.deviceObjectAllowlist;
        }

        public final Boolean getDoesPushStoryDismissOnClick$android_sdk_base_release() {
            return this.doesPushStoryDismissOnClick;
        }

        public final String getFallbackFirebaseMessagingServiceClasspath$android_sdk_base_release() {
            return this.fallbackFirebaseMessagingServiceClasspath;
        }

        public final String getFirebaseCloudMessagingSenderIdKey$android_sdk_base_release() {
            return this.firebaseCloudMessagingSenderIdKey;
        }

        public final Integer getGoodNetworkInterval$android_sdk_base_release() {
            return this.goodNetworkInterval;
        }

        public final Integer getGreatNetworkInterval$android_sdk_base_release() {
            return this.greatNetworkInterval;
        }

        public final Boolean getHandlePushDeepLinksAutomatically$android_sdk_base_release() {
            return this.handlePushDeepLinksAutomatically;
        }

        public final Boolean getInAppMessageTestPushEagerDisplayEnabled$android_sdk_base_release() {
            return this.inAppMessageTestPushEagerDisplayEnabled;
        }

        public final Integer getInAppMessageWebViewClientMaxOnPageFinishedWaitMs$android_sdk_base_release() {
            return this.inAppMessageWebViewClientMaxOnPageFinishedWaitMs;
        }

        public final String getLargeNotificationIconName$android_sdk_base_release() {
            return this.largeNotificationIconName;
        }

        public final String getPushDeepLinkBackStackActivityClassName$android_sdk_base_release() {
            return this.pushDeepLinkBackStackActivityClassName;
        }

        public final SdkFlavor getSdkFlavor$android_sdk_base_release() {
            return this.sdkFlavor;
        }

        public final String getServerTarget$android_sdk_base_release() {
            return this.serverTarget;
        }

        public final Integer getSessionTimeout$android_sdk_base_release() {
            return this.sessionTimeout;
        }

        public final String getSmallNotificationIconName$android_sdk_base_release() {
            return this.smallNotificationIconName;
        }

        public final Integer getTriggerActionMinimumTimeIntervalSeconds$android_sdk_base_release() {
            return this.triggerActionMinimumTimeIntervalSeconds;
        }

        public int hashCode() {
            String str = this.apiKey;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.serverTarget;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.smallNotificationIconName;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.largeNotificationIconName;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.customEndpoint;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.defaultNotificationChannelName;
            int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.defaultNotificationChannelDescription;
            int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.pushDeepLinkBackStackActivityClassName;
            int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.firebaseCloudMessagingSenderIdKey;
            int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.customHtmlWebViewActivityClassName;
            int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
            SdkFlavor sdkFlavor2 = this.sdkFlavor;
            int hashCode11 = (hashCode10 + (sdkFlavor2 == null ? 0 : sdkFlavor2.hashCode())) * 31;
            Integer num = this.sessionTimeout;
            int hashCode12 = (hashCode11 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.defaultNotificationAccentColor;
            int hashCode13 = (hashCode12 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.triggerActionMinimumTimeIntervalSeconds;
            int hashCode14 = (hashCode13 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.badNetworkInterval;
            int hashCode15 = (hashCode14 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.goodNetworkInterval;
            int hashCode16 = (hashCode15 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Integer num6 = this.greatNetworkInterval;
            int hashCode17 = (hashCode16 + (num6 == null ? 0 : num6.hashCode())) * 31;
            Integer num7 = this.inAppMessageWebViewClientMaxOnPageFinishedWaitMs;
            int hashCode18 = (hashCode17 + (num7 == null ? 0 : num7.hashCode())) * 31;
            Boolean bool = this.admMessagingRegistrationEnabled;
            int hashCode19 = (hashCode18 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.handlePushDeepLinksAutomatically;
            int hashCode20 = (hashCode19 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.isLocationCollectionEnabled;
            int hashCode21 = (hashCode20 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.isNewsFeedVisualIndicatorOn;
            int hashCode22 = (hashCode21 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.isPushDeepLinkBackStackActivityEnabled;
            int hashCode23 = (hashCode22 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
            Boolean bool6 = this.isSessionStartBasedTimeoutEnabled;
            int hashCode24 = (hashCode23 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
            Boolean bool7 = this.isFirebaseCloudMessagingRegistrationEnabled;
            int hashCode25 = (hashCode24 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
            Boolean bool8 = this.isContentCardsUnreadVisualIndicatorEnabled;
            int hashCode26 = (hashCode25 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
            Boolean bool9 = this.isInAppMessageAccessibilityExclusiveModeEnabled;
            int hashCode27 = (hashCode26 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
            Boolean bool10 = this.isPushWakeScreenForNotificationEnabled;
            int hashCode28 = (hashCode27 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
            Boolean bool11 = this.isPushHtmlRenderingEnabled;
            int hashCode29 = (hashCode28 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
            Boolean bool12 = this.isGeofencesEnabled;
            int hashCode30 = (hashCode29 + (bool12 == null ? 0 : bool12.hashCode())) * 31;
            Boolean bool13 = this.inAppMessageTestPushEagerDisplayEnabled;
            int hashCode31 = (hashCode30 + (bool13 == null ? 0 : bool13.hashCode())) * 31;
            Boolean bool14 = this.automaticGeofenceRequestsEnabled;
            int hashCode32 = (hashCode31 + (bool14 == null ? 0 : bool14.hashCode())) * 31;
            Boolean bool15 = this.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled;
            int hashCode33 = (hashCode32 + (bool15 == null ? 0 : bool15.hashCode())) * 31;
            Boolean bool16 = this.isTouchModeRequiredForHtmlInAppMessages;
            int hashCode34 = (hashCode33 + (bool16 == null ? 0 : bool16.hashCode())) * 31;
            Boolean bool17 = this.isSdkAuthEnabled;
            int hashCode35 = (hashCode34 + (bool17 == null ? 0 : bool17.hashCode())) * 31;
            EnumSet<DeviceKey> enumSet = this.deviceObjectAllowlist;
            int hashCode36 = (hashCode35 + (enumSet == null ? 0 : enumSet.hashCode())) * 31;
            Boolean bool18 = this.isDeviceObjectAllowlistEnabled;
            int hashCode37 = (hashCode36 + (bool18 == null ? 0 : bool18.hashCode())) * 31;
            EnumSet<BrazeSdkMetadata> enumSet2 = this.brazeSdkMetadata;
            int hashCode38 = (hashCode37 + (enumSet2 == null ? 0 : enumSet2.hashCode())) * 31;
            EnumSet<LocationProviderName> enumSet3 = this.customLocationProviderNames;
            int hashCode39 = (hashCode38 + (enumSet3 == null ? 0 : enumSet3.hashCode())) * 31;
            Boolean bool19 = this.isHtmlInAppMessageApplyWindowInsetsEnabled;
            int hashCode40 = (hashCode39 + (bool19 == null ? 0 : bool19.hashCode())) * 31;
            Boolean bool20 = this.isHtmlInAppMessageHtmlLinkTargetEnabled;
            int hashCode41 = (hashCode40 + (bool20 == null ? 0 : bool20.hashCode())) * 31;
            Boolean bool21 = this.doesPushStoryDismissOnClick;
            int hashCode42 = (hashCode41 + (bool21 == null ? 0 : bool21.hashCode())) * 31;
            Boolean bool22 = this.isFallbackFirebaseMessagingServiceEnabled;
            int hashCode43 = (hashCode42 + (bool22 == null ? 0 : bool22.hashCode())) * 31;
            String str11 = this.fallbackFirebaseMessagingServiceClasspath;
            if (str11 != null) {
                i = str11.hashCode();
            }
            return hashCode43 + i;
        }

        public final Boolean isContentCardsUnreadVisualIndicatorEnabled$android_sdk_base_release() {
            return this.isContentCardsUnreadVisualIndicatorEnabled;
        }

        public final Boolean isDeviceObjectAllowlistEnabled$android_sdk_base_release() {
            return this.isDeviceObjectAllowlistEnabled;
        }

        public final Boolean isFallbackFirebaseMessagingServiceEnabled$android_sdk_base_release() {
            return this.isFallbackFirebaseMessagingServiceEnabled;
        }

        public final Boolean isFirebaseCloudMessagingRegistrationEnabled$android_sdk_base_release() {
            return this.isFirebaseCloudMessagingRegistrationEnabled;
        }

        public final Boolean isFirebaseMessagingServiceOnNewTokenRegistrationEnabled$android_sdk_base_release() {
            return this.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled;
        }

        public final Boolean isGeofencesEnabled$android_sdk_base_release() {
            return this.isGeofencesEnabled;
        }

        public final Boolean isHtmlInAppMessageApplyWindowInsetsEnabled$android_sdk_base_release() {
            return this.isHtmlInAppMessageApplyWindowInsetsEnabled;
        }

        public final Boolean isHtmlInAppMessageHtmlLinkTargetEnabled$android_sdk_base_release() {
            return this.isHtmlInAppMessageHtmlLinkTargetEnabled;
        }

        public final Boolean isInAppMessageAccessibilityExclusiveModeEnabled$android_sdk_base_release() {
            return this.isInAppMessageAccessibilityExclusiveModeEnabled;
        }

        public final Boolean isLocationCollectionEnabled$android_sdk_base_release() {
            return this.isLocationCollectionEnabled;
        }

        public final Boolean isNewsFeedVisualIndicatorOn$android_sdk_base_release() {
            return this.isNewsFeedVisualIndicatorOn;
        }

        public final Boolean isPushDeepLinkBackStackActivityEnabled$android_sdk_base_release() {
            return this.isPushDeepLinkBackStackActivityEnabled;
        }

        public final Boolean isPushHtmlRenderingEnabled$android_sdk_base_release() {
            return this.isPushHtmlRenderingEnabled;
        }

        public final Boolean isPushWakeScreenForNotificationEnabled$android_sdk_base_release() {
            return this.isPushWakeScreenForNotificationEnabled;
        }

        public final Boolean isSdkAuthEnabled$android_sdk_base_release() {
            return this.isSdkAuthEnabled;
        }

        public final Boolean isSessionStartBasedTimeoutEnabled$android_sdk_base_release() {
            return this.isSessionStartBasedTimeoutEnabled;
        }

        public final Boolean isTouchModeRequiredForHtmlInAppMessages$android_sdk_base_release() {
            return this.isTouchModeRequiredForHtmlInAppMessages;
        }

        public final Builder setAdmMessagingRegistrationEnabled(boolean z) {
            this.admMessagingRegistrationEnabled = Boolean.valueOf(z);
            return this;
        }

        public final void setAdmMessagingRegistrationEnabled$android_sdk_base_release(Boolean bool) {
            this.admMessagingRegistrationEnabled = bool;
        }

        public final Builder setApiKey(String str) {
            Intrinsics.checkNotNullParameter(str, DynamicLink.Builder.KEY_API_KEY);
            if (!StringsKt.isBlank(str)) {
                this.apiKey = str;
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) a.b, 2, (Object) null);
            }
            return this;
        }

        public final void setApiKey$android_sdk_base_release(String str) {
            this.apiKey = str;
        }

        public final Builder setAutomaticGeofenceRequestsEnabled(boolean z) {
            this.automaticGeofenceRequestsEnabled = Boolean.valueOf(z);
            return this;
        }

        public final void setAutomaticGeofenceRequestsEnabled$android_sdk_base_release(Boolean bool) {
            this.automaticGeofenceRequestsEnabled = bool;
        }

        public final Builder setBadNetworkDataFlushInterval(int i) {
            this.badNetworkInterval = Integer.valueOf(i);
            return this;
        }

        public final void setBadNetworkInterval$android_sdk_base_release(Integer num) {
            this.badNetworkInterval = num;
        }

        public final void setBrazeSdkMetadata$android_sdk_base_release(EnumSet<BrazeSdkMetadata> enumSet) {
            this.brazeSdkMetadata = enumSet;
        }

        public final Builder setContentCardsUnreadVisualIndicatorEnabled(boolean z) {
            this.isContentCardsUnreadVisualIndicatorEnabled = Boolean.valueOf(z);
            return this;
        }

        public final void setContentCardsUnreadVisualIndicatorEnabled$android_sdk_base_release(Boolean bool) {
            this.isContentCardsUnreadVisualIndicatorEnabled = bool;
        }

        public final Builder setCustomEndpoint(String str) {
            Intrinsics.checkNotNullParameter(str, "customEndpoint");
            this.customEndpoint = str;
            return this;
        }

        public final void setCustomEndpoint$android_sdk_base_release(String str) {
            this.customEndpoint = str;
        }

        public final void setCustomHtmlWebViewActivityClassName$android_sdk_base_release(String str) {
            this.customHtmlWebViewActivityClassName = str;
        }

        public final Builder setCustomLocationProviderNames(EnumSet<LocationProviderName> enumSet) {
            Intrinsics.checkNotNullParameter(enumSet, "locationProviderNames");
            this.customLocationProviderNames = enumSet;
            return this;
        }

        public final void setCustomLocationProviderNames$android_sdk_base_release(EnumSet<LocationProviderName> enumSet) {
            this.customLocationProviderNames = enumSet;
        }

        public final Builder setCustomWebViewActivityClass(Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "customWebViewActivityClass");
            this.customHtmlWebViewActivityClassName = cls.getName();
            return this;
        }

        public final Builder setDefaultNotificationAccentColor(int i) {
            this.defaultNotificationAccentColor = Integer.valueOf(i);
            return this;
        }

        public final void setDefaultNotificationAccentColor$android_sdk_base_release(Integer num) {
            this.defaultNotificationAccentColor = num;
        }

        public final Builder setDefaultNotificationChannelDescription(String str) {
            Intrinsics.checkNotNullParameter(str, "description");
            if (!StringsKt.isBlank(str)) {
                this.defaultNotificationChannelDescription = str;
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
            }
            return this;
        }

        public final void setDefaultNotificationChannelDescription$android_sdk_base_release(String str) {
            this.defaultNotificationChannelDescription = str;
        }

        public final Builder setDefaultNotificationChannelName(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            if (!StringsKt.isBlank(str)) {
                this.defaultNotificationChannelName = str;
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) c.b, 2, (Object) null);
            }
            return this;
        }

        public final void setDefaultNotificationChannelName$android_sdk_base_release(String str) {
            this.defaultNotificationChannelName = str;
        }

        public final Builder setDeviceObjectAllowlist(EnumSet<DeviceKey> enumSet) {
            Intrinsics.checkNotNullParameter(enumSet, "deviceObjectAllowlist");
            this.deviceObjectAllowlist = enumSet;
            return this;
        }

        public final void setDeviceObjectAllowlist$android_sdk_base_release(EnumSet<DeviceKey> enumSet) {
            this.deviceObjectAllowlist = enumSet;
        }

        public final Builder setDeviceObjectAllowlistEnabled(boolean z) {
            this.isDeviceObjectAllowlistEnabled = Boolean.valueOf(z);
            return this;
        }

        public final void setDeviceObjectAllowlistEnabled$android_sdk_base_release(Boolean bool) {
            this.isDeviceObjectAllowlistEnabled = bool;
        }

        @Deprecated(message = "Use {@link #setDeviceObjectAllowlist(EnumSet)}", replaceWith = @ReplaceWith(expression = "setDeviceObjectAllowlist", imports = {}))
        public final Builder setDeviceObjectWhitelist(EnumSet<DeviceKey> enumSet) {
            Intrinsics.checkNotNullParameter(enumSet, "deviceObjectAllowlist");
            return setDeviceObjectAllowlist(enumSet);
        }

        @Deprecated(message = "Use {@link #setDeviceObjectAllowlistEnabled(boolean)}", replaceWith = @ReplaceWith(expression = "setDeviceObjectAllowlistEnabled", imports = {}))
        public final Builder setDeviceObjectWhitelistEnabled(boolean z) {
            return setDeviceObjectAllowlistEnabled(z);
        }

        public final Builder setDoesPushStoryDismissOnClick(boolean z) {
            this.doesPushStoryDismissOnClick = Boolean.valueOf(z);
            return this;
        }

        public final void setDoesPushStoryDismissOnClick$android_sdk_base_release(Boolean bool) {
            this.doesPushStoryDismissOnClick = bool;
        }

        public final Builder setFallbackFirebaseMessagingServiceClasspath(String str) {
            Intrinsics.checkNotNullParameter(str, "classpath");
            this.fallbackFirebaseMessagingServiceClasspath = str;
            return this;
        }

        public final void setFallbackFirebaseMessagingServiceClasspath$android_sdk_base_release(String str) {
            this.fallbackFirebaseMessagingServiceClasspath = str;
        }

        public final Builder setFallbackFirebaseMessagingServiceEnabled(boolean z) {
            this.isFallbackFirebaseMessagingServiceEnabled = Boolean.valueOf(z);
            return this;
        }

        public final void setFallbackFirebaseMessagingServiceEnabled$android_sdk_base_release(Boolean bool) {
            this.isFallbackFirebaseMessagingServiceEnabled = bool;
        }

        public final void setFirebaseCloudMessagingRegistrationEnabled$android_sdk_base_release(Boolean bool) {
            this.isFirebaseCloudMessagingRegistrationEnabled = bool;
        }

        public final Builder setFirebaseCloudMessagingSenderIdKey(String str) {
            Intrinsics.checkNotNullParameter(str, "firebaseSenderId");
            if (!StringsKt.isBlank(str)) {
                this.firebaseCloudMessagingSenderIdKey = str;
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) d.b, 2, (Object) null);
            }
            return this;
        }

        public final void setFirebaseCloudMessagingSenderIdKey$android_sdk_base_release(String str) {
            this.firebaseCloudMessagingSenderIdKey = str;
        }

        public final void setFirebaseMessagingServiceOnNewTokenRegistrationEnabled$android_sdk_base_release(Boolean bool) {
            this.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled = bool;
        }

        public final Builder setGeofencesEnabled(boolean z) {
            this.isGeofencesEnabled = Boolean.valueOf(z);
            return this;
        }

        public final void setGeofencesEnabled$android_sdk_base_release(Boolean bool) {
            this.isGeofencesEnabled = bool;
        }

        public final Builder setGoodNetworkDataFlushInterval(int i) {
            this.goodNetworkInterval = Integer.valueOf(i);
            return this;
        }

        public final void setGoodNetworkInterval$android_sdk_base_release(Integer num) {
            this.goodNetworkInterval = num;
        }

        public final Builder setGreatNetworkDataFlushInterval(int i) {
            this.greatNetworkInterval = Integer.valueOf(i);
            return this;
        }

        public final void setGreatNetworkInterval$android_sdk_base_release(Integer num) {
            this.greatNetworkInterval = num;
        }

        public final Builder setHandlePushDeepLinksAutomatically(boolean z) {
            this.handlePushDeepLinksAutomatically = Boolean.valueOf(z);
            return this;
        }

        public final void setHandlePushDeepLinksAutomatically$android_sdk_base_release(Boolean bool) {
            this.handlePushDeepLinksAutomatically = bool;
        }

        public final void setHtmlInAppMessageApplyWindowInsetsEnabled$android_sdk_base_release(Boolean bool) {
            this.isHtmlInAppMessageApplyWindowInsetsEnabled = bool;
        }

        public final void setHtmlInAppMessageHtmlLinkTargetEnabled$android_sdk_base_release(Boolean bool) {
            this.isHtmlInAppMessageHtmlLinkTargetEnabled = bool;
        }

        public final void setInAppMessageAccessibilityExclusiveModeEnabled$android_sdk_base_release(Boolean bool) {
            this.isInAppMessageAccessibilityExclusiveModeEnabled = bool;
        }

        public final Builder setInAppMessageTestPushEagerDisplayEnabled(boolean z) {
            this.inAppMessageTestPushEagerDisplayEnabled = Boolean.valueOf(z);
            return this;
        }

        public final void setInAppMessageTestPushEagerDisplayEnabled$android_sdk_base_release(Boolean bool) {
            this.inAppMessageTestPushEagerDisplayEnabled = bool;
        }

        public final Builder setInAppMessageWebViewClientMaxOnPageFinishedWaitMs(int i) {
            if (i >= 0) {
                this.inAppMessageWebViewClientMaxOnPageFinishedWaitMs = Integer.valueOf(i);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new e(i), 2, (Object) null);
            }
            return this;
        }

        public final void setInAppMessageWebViewClientMaxOnPageFinishedWaitMs$android_sdk_base_release(Integer num) {
            this.inAppMessageWebViewClientMaxOnPageFinishedWaitMs = num;
        }

        public final Builder setIsFirebaseCloudMessagingRegistrationEnabled(boolean z) {
            this.isFirebaseCloudMessagingRegistrationEnabled = Boolean.valueOf(z);
            return this;
        }

        public final Builder setIsFirebaseMessagingServiceOnNewTokenRegistrationEnabled(boolean z) {
            this.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled = Boolean.valueOf(z);
            return this;
        }

        public final Builder setIsHtmlInAppMessageApplyWindowInsetsEnabled(boolean z) {
            this.isHtmlInAppMessageApplyWindowInsetsEnabled = Boolean.valueOf(z);
            return this;
        }

        public final Builder setIsHtmlInAppMessageHtmlLinkTargetEnabled(boolean z) {
            this.isHtmlInAppMessageHtmlLinkTargetEnabled = Boolean.valueOf(z);
            return this;
        }

        public final Builder setIsInAppMessageAccessibilityExclusiveModeEnabled(boolean z) {
            this.isInAppMessageAccessibilityExclusiveModeEnabled = Boolean.valueOf(z);
            return this;
        }

        public final Builder setIsLocationCollectionEnabled(boolean z) {
            this.isLocationCollectionEnabled = Boolean.valueOf(z);
            return this;
        }

        public final Builder setIsPushWakeScreenForNotificationEnabled(boolean z) {
            this.isPushWakeScreenForNotificationEnabled = Boolean.valueOf(z);
            return this;
        }

        public final Builder setIsSdkAuthenticationEnabled(boolean z) {
            this.isSdkAuthEnabled = Boolean.valueOf(z);
            return this;
        }

        public final Builder setIsSessionStartBasedTimeoutEnabled(boolean z) {
            this.isSessionStartBasedTimeoutEnabled = Boolean.valueOf(z);
            return this;
        }

        public final Builder setIsTouchModeRequiredForHtmlInAppMessages(boolean z) {
            this.isTouchModeRequiredForHtmlInAppMessages = Boolean.valueOf(z);
            return this;
        }

        public final Builder setLargeNotificationIcon(String str) {
            Intrinsics.checkNotNullParameter(str, "largeNotificationIconName");
            this.largeNotificationIconName = str;
            return this;
        }

        public final void setLargeNotificationIconName$android_sdk_base_release(String str) {
            this.largeNotificationIconName = str;
        }

        public final void setLocationCollectionEnabled$android_sdk_base_release(Boolean bool) {
            this.isLocationCollectionEnabled = bool;
        }

        public final void setNewsFeedVisualIndicatorOn$android_sdk_base_release(Boolean bool) {
            this.isNewsFeedVisualIndicatorOn = bool;
        }

        public final Builder setNewsfeedVisualIndicatorOn(boolean z) {
            this.isNewsFeedVisualIndicatorOn = Boolean.valueOf(z);
            return this;
        }

        public final Builder setPushDeepLinkBackStackActivityClass(Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "pushDeepLinkActivityClass");
            this.pushDeepLinkBackStackActivityClassName = cls.getName();
            return this;
        }

        public final void setPushDeepLinkBackStackActivityClassName$android_sdk_base_release(String str) {
            this.pushDeepLinkBackStackActivityClassName = str;
        }

        public final Builder setPushDeepLinkBackStackActivityEnabled(boolean z) {
            this.isPushDeepLinkBackStackActivityEnabled = Boolean.valueOf(z);
            return this;
        }

        public final void setPushDeepLinkBackStackActivityEnabled$android_sdk_base_release(Boolean bool) {
            this.isPushDeepLinkBackStackActivityEnabled = bool;
        }

        public final Builder setPushHtmlRenderingEnabled(boolean z) {
            this.isPushHtmlRenderingEnabled = Boolean.valueOf(z);
            return this;
        }

        public final void setPushHtmlRenderingEnabled$android_sdk_base_release(Boolean bool) {
            this.isPushHtmlRenderingEnabled = bool;
        }

        public final void setPushWakeScreenForNotificationEnabled$android_sdk_base_release(Boolean bool) {
            this.isPushWakeScreenForNotificationEnabled = bool;
        }

        public final void setSdkAuthEnabled$android_sdk_base_release(Boolean bool) {
            this.isSdkAuthEnabled = bool;
        }

        public final Builder setSdkFlavor(SdkFlavor sdkFlavor2) {
            this.sdkFlavor = sdkFlavor2;
            return this;
        }

        public final void setSdkFlavor$android_sdk_base_release(SdkFlavor sdkFlavor2) {
            this.sdkFlavor = sdkFlavor2;
        }

        public final Builder setSdkMetadata(EnumSet<BrazeSdkMetadata> enumSet) {
            this.brazeSdkMetadata = enumSet;
            return this;
        }

        public final Builder setServerTarget(String str) {
            Intrinsics.checkNotNullParameter(str, "serverTarget");
            this.serverTarget = str;
            return this;
        }

        public final void setServerTarget$android_sdk_base_release(String str) {
            this.serverTarget = str;
        }

        public final void setSessionStartBasedTimeoutEnabled$android_sdk_base_release(Boolean bool) {
            this.isSessionStartBasedTimeoutEnabled = bool;
        }

        public final Builder setSessionTimeout(int i) {
            this.sessionTimeout = Integer.valueOf(i);
            return this;
        }

        public final void setSessionTimeout$android_sdk_base_release(Integer num) {
            this.sessionTimeout = num;
        }

        public final Builder setSmallNotificationIcon(String str) {
            Intrinsics.checkNotNullParameter(str, "smallNotificationIconName");
            this.smallNotificationIconName = str;
            return this;
        }

        public final void setSmallNotificationIconName$android_sdk_base_release(String str) {
            this.smallNotificationIconName = str;
        }

        public final void setTouchModeRequiredForHtmlInAppMessages$android_sdk_base_release(Boolean bool) {
            this.isTouchModeRequiredForHtmlInAppMessages = bool;
        }

        public final Builder setTriggerActionMinimumTimeIntervalSeconds(int i) {
            this.triggerActionMinimumTimeIntervalSeconds = Integer.valueOf(i);
            return this;
        }

        public final void setTriggerActionMinimumTimeIntervalSeconds$android_sdk_base_release(Integer num) {
            this.triggerActionMinimumTimeIntervalSeconds = num;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Builder(apiKey=").append(this.apiKey).append(", serverTarget=").append(this.serverTarget).append(", smallNotificationIconName=").append(this.smallNotificationIconName).append(", largeNotificationIconName=").append(this.largeNotificationIconName).append(", customEndpoint=").append(this.customEndpoint).append(", defaultNotificationChannelName=").append(this.defaultNotificationChannelName).append(", defaultNotificationChannelDescription=").append(this.defaultNotificationChannelDescription).append(", pushDeepLinkBackStackActivityClassName=").append(this.pushDeepLinkBackStackActivityClassName).append(", firebaseCloudMessagingSenderIdKey=").append(this.firebaseCloudMessagingSenderIdKey).append(", customHtmlWebViewActivityClassName=").append(this.customHtmlWebViewActivityClassName).append(", sdkFlavor=").append(this.sdkFlavor).append(", sessionTimeout=");
            sb.append(this.sessionTimeout).append(", defaultNotificationAccentColor=").append(this.defaultNotificationAccentColor).append(", triggerActionMinimumTimeIntervalSeconds=").append(this.triggerActionMinimumTimeIntervalSeconds).append(", badNetworkInterval=").append(this.badNetworkInterval).append(", goodNetworkInterval=").append(this.goodNetworkInterval).append(", greatNetworkInterval=").append(this.greatNetworkInterval).append(", inAppMessageWebViewClientMaxOnPageFinishedWaitMs=").append(this.inAppMessageWebViewClientMaxOnPageFinishedWaitMs).append(", admMessagingRegistrationEnabled=").append(this.admMessagingRegistrationEnabled).append(", handlePushDeepLinksAutomatically=").append(this.handlePushDeepLinksAutomatically).append(", isLocationCollectionEnabled=").append(this.isLocationCollectionEnabled).append(", isNewsFeedVisualIndicatorOn=").append(this.isNewsFeedVisualIndicatorOn).append(", isPushDeepLinkBackStackActivityEnabled=").append(this.isPushDeepLinkBackStackActivityEnabled);
            sb.append(", isSessionStartBasedTimeoutEnabled=").append(this.isSessionStartBasedTimeoutEnabled).append(", isFirebaseCloudMessagingRegistrationEnabled=").append(this.isFirebaseCloudMessagingRegistrationEnabled).append(", isContentCardsUnreadVisualIndicatorEnabled=").append(this.isContentCardsUnreadVisualIndicatorEnabled).append(", isInAppMessageAccessibilityExclusiveModeEnabled=").append(this.isInAppMessageAccessibilityExclusiveModeEnabled).append(", isPushWakeScreenForNotificationEnabled=").append(this.isPushWakeScreenForNotificationEnabled).append(", isPushHtmlRenderingEnabled=").append(this.isPushHtmlRenderingEnabled).append(", isGeofencesEnabled=").append(this.isGeofencesEnabled).append(", inAppMessageTestPushEagerDisplayEnabled=").append(this.inAppMessageTestPushEagerDisplayEnabled).append(", automaticGeofenceRequestsEnabled=").append(this.automaticGeofenceRequestsEnabled).append(", isFirebaseMessagingServiceOnNewTokenRegistrationEnabled=").append(this.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled).append(", isTouchModeRequiredForHtmlInAppMessages=").append(this.isTouchModeRequiredForHtmlInAppMessages).append(", isSdkAuthEnabled=");
            sb.append(this.isSdkAuthEnabled).append(", deviceObjectAllowlist=").append(this.deviceObjectAllowlist).append(", isDeviceObjectAllowlistEnabled=").append(this.isDeviceObjectAllowlistEnabled).append(", brazeSdkMetadata=").append(this.brazeSdkMetadata).append(", customLocationProviderNames=").append(this.customLocationProviderNames).append(", isHtmlInAppMessageApplyWindowInsetsEnabled=").append(this.isHtmlInAppMessageApplyWindowInsetsEnabled).append(", isHtmlInAppMessageHtmlLinkTargetEnabled=").append(this.isHtmlInAppMessageHtmlLinkTargetEnabled).append(", doesPushStoryDismissOnClick=").append(this.doesPushStoryDismissOnClick).append(", isFallbackFirebaseMessagingServiceEnabled=").append(this.isFallbackFirebaseMessagingServiceEnabled).append(", fallbackFirebaseMessagingServiceClasspath=").append(this.fallbackFirebaseMessagingServiceClasspath).append(')');
            return sb.toString();
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* synthetic */ Builder(java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, com.braze.enums.SdkFlavor r54, java.lang.Integer r55, java.lang.Integer r56, java.lang.Integer r57, java.lang.Integer r58, java.lang.Integer r59, java.lang.Integer r60, java.lang.Integer r61, java.lang.Boolean r62, java.lang.Boolean r63, java.lang.Boolean r64, java.lang.Boolean r65, java.lang.Boolean r66, java.lang.Boolean r67, java.lang.Boolean r68, java.lang.Boolean r69, java.lang.Boolean r70, java.lang.Boolean r71, java.lang.Boolean r72, java.lang.Boolean r73, java.lang.Boolean r74, java.lang.Boolean r75, java.lang.Boolean r76, java.lang.Boolean r77, java.lang.Boolean r78, java.util.EnumSet r79, java.lang.Boolean r80, java.util.EnumSet r81, java.util.EnumSet r82, java.lang.Boolean r83, java.lang.Boolean r84, java.lang.Boolean r85, java.lang.Boolean r86, java.lang.String r87, int r88, int r89, kotlin.jvm.internal.DefaultConstructorMarker r90) {
            /*
                r43 = this;
                r0 = r88
                r1 = r89
                r2 = r0 & 1
                if (r2 == 0) goto L_0x000a
                r2 = 0
                goto L_0x000c
            L_0x000a:
                r2 = r44
            L_0x000c:
                r4 = r0 & 2
                if (r4 == 0) goto L_0x0012
                r4 = 0
                goto L_0x0014
            L_0x0012:
                r4 = r45
            L_0x0014:
                r5 = r0 & 4
                if (r5 == 0) goto L_0x001a
                r5 = 0
                goto L_0x001c
            L_0x001a:
                r5 = r46
            L_0x001c:
                r6 = r0 & 8
                if (r6 == 0) goto L_0x0022
                r6 = 0
                goto L_0x0024
            L_0x0022:
                r6 = r47
            L_0x0024:
                r7 = r0 & 16
                if (r7 == 0) goto L_0x002a
                r7 = 0
                goto L_0x002c
            L_0x002a:
                r7 = r48
            L_0x002c:
                r8 = r0 & 32
                if (r8 == 0) goto L_0x0032
                r8 = 0
                goto L_0x0034
            L_0x0032:
                r8 = r49
            L_0x0034:
                r9 = r0 & 64
                if (r9 == 0) goto L_0x003a
                r9 = 0
                goto L_0x003c
            L_0x003a:
                r9 = r50
            L_0x003c:
                r10 = r0 & 128(0x80, float:1.794E-43)
                if (r10 == 0) goto L_0x0042
                r10 = 0
                goto L_0x0044
            L_0x0042:
                r10 = r51
            L_0x0044:
                r11 = r0 & 256(0x100, float:3.59E-43)
                if (r11 == 0) goto L_0x004a
                r11 = 0
                goto L_0x004c
            L_0x004a:
                r11 = r52
            L_0x004c:
                r12 = r0 & 512(0x200, float:7.175E-43)
                if (r12 == 0) goto L_0x0052
                r12 = 0
                goto L_0x0054
            L_0x0052:
                r12 = r53
            L_0x0054:
                r13 = r0 & 1024(0x400, float:1.435E-42)
                if (r13 == 0) goto L_0x005a
                r13 = 0
                goto L_0x005c
            L_0x005a:
                r13 = r54
            L_0x005c:
                r14 = r0 & 2048(0x800, float:2.87E-42)
                if (r14 == 0) goto L_0x0062
                r14 = 0
                goto L_0x0064
            L_0x0062:
                r14 = r55
            L_0x0064:
                r15 = r0 & 4096(0x1000, float:5.74E-42)
                if (r15 == 0) goto L_0x006a
                r15 = 0
                goto L_0x006c
            L_0x006a:
                r15 = r56
            L_0x006c:
                r3 = r0 & 8192(0x2000, float:1.14794E-41)
                if (r3 == 0) goto L_0x0072
                r3 = 0
                goto L_0x0074
            L_0x0072:
                r3 = r57
            L_0x0074:
                r16 = r3
                r3 = r0 & 16384(0x4000, float:2.2959E-41)
                if (r3 == 0) goto L_0x007c
                r3 = 0
                goto L_0x007e
            L_0x007c:
                r3 = r58
            L_0x007e:
                r17 = 32768(0x8000, float:4.5918E-41)
                r17 = r0 & r17
                if (r17 == 0) goto L_0x0088
                r17 = 0
                goto L_0x008a
            L_0x0088:
                r17 = r59
            L_0x008a:
                r18 = 65536(0x10000, float:9.18355E-41)
                r18 = r0 & r18
                if (r18 == 0) goto L_0x0093
                r18 = 0
                goto L_0x0095
            L_0x0093:
                r18 = r60
            L_0x0095:
                r19 = 131072(0x20000, float:1.83671E-40)
                r19 = r0 & r19
                if (r19 == 0) goto L_0x009e
                r19 = 0
                goto L_0x00a0
            L_0x009e:
                r19 = r61
            L_0x00a0:
                r20 = 262144(0x40000, float:3.67342E-40)
                r20 = r0 & r20
                if (r20 == 0) goto L_0x00a9
                r20 = 0
                goto L_0x00ab
            L_0x00a9:
                r20 = r62
            L_0x00ab:
                r21 = 524288(0x80000, float:7.34684E-40)
                r21 = r0 & r21
                if (r21 == 0) goto L_0x00b4
                r21 = 0
                goto L_0x00b6
            L_0x00b4:
                r21 = r63
            L_0x00b6:
                r22 = 1048576(0x100000, float:1.469368E-39)
                r22 = r0 & r22
                if (r22 == 0) goto L_0x00bf
                r22 = 0
                goto L_0x00c1
            L_0x00bf:
                r22 = r64
            L_0x00c1:
                r23 = 2097152(0x200000, float:2.938736E-39)
                r23 = r0 & r23
                if (r23 == 0) goto L_0x00ca
                r23 = 0
                goto L_0x00cc
            L_0x00ca:
                r23 = r65
            L_0x00cc:
                r24 = 4194304(0x400000, float:5.877472E-39)
                r24 = r0 & r24
                if (r24 == 0) goto L_0x00d5
                r24 = 0
                goto L_0x00d7
            L_0x00d5:
                r24 = r66
            L_0x00d7:
                r25 = 8388608(0x800000, float:1.17549435E-38)
                r25 = r0 & r25
                if (r25 == 0) goto L_0x00e0
                r25 = 0
                goto L_0x00e2
            L_0x00e0:
                r25 = r67
            L_0x00e2:
                r26 = 16777216(0x1000000, float:2.3509887E-38)
                r26 = r0 & r26
                if (r26 == 0) goto L_0x00eb
                r26 = 0
                goto L_0x00ed
            L_0x00eb:
                r26 = r68
            L_0x00ed:
                r27 = 33554432(0x2000000, float:9.403955E-38)
                r27 = r0 & r27
                if (r27 == 0) goto L_0x00f6
                r27 = 0
                goto L_0x00f8
            L_0x00f6:
                r27 = r69
            L_0x00f8:
                r28 = 67108864(0x4000000, float:1.5046328E-36)
                r28 = r0 & r28
                if (r28 == 0) goto L_0x0101
                r28 = 0
                goto L_0x0103
            L_0x0101:
                r28 = r70
            L_0x0103:
                r29 = 134217728(0x8000000, float:3.85186E-34)
                r29 = r0 & r29
                if (r29 == 0) goto L_0x010c
                r29 = 0
                goto L_0x010e
            L_0x010c:
                r29 = r71
            L_0x010e:
                r30 = 268435456(0x10000000, float:2.5243549E-29)
                r30 = r0 & r30
                if (r30 == 0) goto L_0x0117
                r30 = 0
                goto L_0x0119
            L_0x0117:
                r30 = r72
            L_0x0119:
                r31 = 536870912(0x20000000, float:1.0842022E-19)
                r31 = r0 & r31
                if (r31 == 0) goto L_0x0122
                r31 = 0
                goto L_0x0124
            L_0x0122:
                r31 = r73
            L_0x0124:
                r32 = 1073741824(0x40000000, float:2.0)
                r32 = r0 & r32
                if (r32 == 0) goto L_0x012d
                r32 = 0
                goto L_0x012f
            L_0x012d:
                r32 = r74
            L_0x012f:
                r33 = -2147483648(0xffffffff80000000, float:-0.0)
                r0 = r0 & r33
                if (r0 == 0) goto L_0x0137
                r0 = 0
                goto L_0x0139
            L_0x0137:
                r0 = r75
            L_0x0139:
                r33 = r1 & 1
                if (r33 == 0) goto L_0x0140
                r33 = 0
                goto L_0x0142
            L_0x0140:
                r33 = r76
            L_0x0142:
                r34 = r1 & 2
                if (r34 == 0) goto L_0x0149
                r34 = 0
                goto L_0x014b
            L_0x0149:
                r34 = r77
            L_0x014b:
                r35 = r1 & 4
                if (r35 == 0) goto L_0x0152
                r35 = 0
                goto L_0x0154
            L_0x0152:
                r35 = r78
            L_0x0154:
                r36 = r1 & 8
                if (r36 == 0) goto L_0x015b
                r36 = 0
                goto L_0x015d
            L_0x015b:
                r36 = r79
            L_0x015d:
                r37 = r1 & 16
                if (r37 == 0) goto L_0x0164
                r37 = 0
                goto L_0x0166
            L_0x0164:
                r37 = r80
            L_0x0166:
                r38 = r1 & 32
                if (r38 == 0) goto L_0x016d
                r38 = 0
                goto L_0x016f
            L_0x016d:
                r38 = r81
            L_0x016f:
                r39 = r1 & 64
                if (r39 == 0) goto L_0x0176
                r39 = 0
                goto L_0x0178
            L_0x0176:
                r39 = r82
            L_0x0178:
                r88 = r0
                r0 = r1 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x0180
                r0 = 0
                goto L_0x0182
            L_0x0180:
                r0 = r83
            L_0x0182:
                r40 = r0
                r0 = r1 & 256(0x100, float:3.59E-43)
                if (r0 == 0) goto L_0x018a
                r0 = 0
                goto L_0x018c
            L_0x018a:
                r0 = r84
            L_0x018c:
                r41 = r0
                r0 = r1 & 512(0x200, float:7.175E-43)
                if (r0 == 0) goto L_0x0194
                r0 = 0
                goto L_0x0196
            L_0x0194:
                r0 = r85
            L_0x0196:
                r42 = r0
                r0 = r1 & 1024(0x400, float:1.435E-42)
                if (r0 == 0) goto L_0x019e
                r0 = 0
                goto L_0x01a0
            L_0x019e:
                r0 = r86
            L_0x01a0:
                r1 = r1 & 2048(0x800, float:2.87E-42)
                if (r1 == 0) goto L_0x01a6
                r1 = 0
                goto L_0x01a8
            L_0x01a6:
                r1 = r87
            L_0x01a8:
                r44 = r43
                r45 = r2
                r46 = r4
                r47 = r5
                r48 = r6
                r49 = r7
                r50 = r8
                r51 = r9
                r52 = r10
                r53 = r11
                r54 = r12
                r55 = r13
                r56 = r14
                r57 = r15
                r58 = r16
                r59 = r3
                r60 = r17
                r61 = r18
                r62 = r19
                r63 = r20
                r64 = r21
                r65 = r22
                r66 = r23
                r67 = r24
                r68 = r25
                r69 = r26
                r70 = r27
                r71 = r28
                r72 = r29
                r73 = r30
                r74 = r31
                r75 = r32
                r76 = r88
                r77 = r33
                r78 = r34
                r79 = r35
                r80 = r36
                r81 = r37
                r82 = r38
                r83 = r39
                r84 = r40
                r85 = r41
                r86 = r42
                r87 = r0
                r88 = r1
                r44.<init>(r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.configuration.BrazeConfig.Builder.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.braze.enums.SdkFlavor, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.util.EnumSet, java.lang.Boolean, java.util.EnumSet, java.util.EnumSet, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public Builder() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (SdkFlavor) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (EnumSet) null, (Boolean) null, (EnumSet) null, (EnumSet) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, -2, 4095, (DefaultConstructorMarker) null);
        }
    }
}
