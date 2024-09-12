package com.braze.models.push;

import android.content.Context;
import android.os.Bundle;
import androidx.core.app.Person;
import androidx.core.view.GravityCompat;
import androidx.webkit.ProxyConfig;
import com.braze.Constants;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.BundleUtils;
import com.braze.support.JsonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u0000 ¸\u00012\u00020\u0001:\n·\u0001¸\u0001¹\u0001º\u0001»\u0001B5\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\n\u0010±\u0001\u001a\u00030²\u0001H\u0002J\u0016\u0010³\u0001\u001a\u00030²\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017J\u0010\u0010´\u0001\u001a\u00030²\u00012\u0006\u0010i\u001a\u00020eJ\u0018\u0010µ\u0001\u001a\u00030²\u00012\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u0017J\t\u0010¶\u0001\u001a\u00020\u0019H\u0016R \u0010\n\u001a\u0004\u0018\u00010\u000b8GX\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R&\u0010(\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010*\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u0010\u001dR\u001c\u00104\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001b\"\u0004\b6\u0010\u001dR\u001c\u00107\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001b\"\u0004\b9\u0010\u001dR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u00128F¢\u0006\u0006\u001a\u0004\b@\u0010\u0015R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020?0\u0017X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010B\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020D0C8F¢\u0006\u0006\u001a\u0004\bE\u0010FR\u001c\u0010G\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020D0HX\u0004¢\u0006\u0002\n\u0000R\"\u0010J\u001a\u0004\u0018\u00010\u00192\b\u0010I\u001a\u0004\u0018\u00010\u0019@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u001bR\u001c\u0010L\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001b\"\u0004\bN\u0010\u001dR\u001e\u0010O\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\bP\u0010\r\"\u0004\bQ\u0010\u000fR\u001c\u0010R\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u001b\"\u0004\bT\u0010\u001dR&\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010F\"\u0004\bW\u0010XR$\u0010Y\u001a\u00020Z8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b[\u0010*\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R$\u0010`\u001a\u00020Z8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\ba\u0010*\u001a\u0004\bb\u0010]\"\u0004\bc\u0010_R\u001a\u0010d\u001a\u00020eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010f\"\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010f\"\u0004\bj\u0010hR\u001a\u0010k\u001a\u00020eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010f\"\u0004\bl\u0010hR$\u0010m\u001a\u00020e8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bn\u0010*\u001a\u0004\bm\u0010f\"\u0004\bo\u0010hR\u001a\u0010p\u001a\u00020eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010f\"\u0004\bq\u0010hR\u001a\u0010r\u001a\u00020eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010f\"\u0004\bs\u0010hR\u001c\u0010t\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u001b\"\u0004\bv\u0010\u001dR\u001e\u0010w\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\bx\u0010\r\"\u0004\by\u0010\u000fR\u001c\u0010z\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u001b\"\u0004\b|\u0010\u001dR\u001c\u0010}\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u001b\"\u0004\b\u0010\u001dR\u0012\u0010\u0002\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010%R!\u0010\u0001\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0012\n\u0002\u0010\u0010\u001a\u0005\b\u0001\u0010\r\"\u0005\b\u0001\u0010\u000fR$\u0010\u0001\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u0015\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001b\"\u0005\b\u0001\u0010\u001dR!\u0010\u0001\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0012\n\u0002\u0010\u0010\u001a\u0005\b\u0001\u0010\r\"\u0005\b\u0001\u0010\u000fR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001b\"\u0005\b\u0001\u0010\u001dR!\u0010\u0001\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0012\n\u0002\u0010\u0010\u001a\u0005\b\u0001\u0010\r\"\u0005\b\u0001\u0010\u000fR\u001f\u0010\u0001\u001a\u00020\u000bX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00128F¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u0015R\u0016\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010\u001b\"\u0005\b¡\u0001\u0010\u001dR\u001d\u0010¢\u0001\u001a\u00020eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010f\"\u0005\b¤\u0001\u0010hR\u001d\u0010¥\u0001\u001a\u00020eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u0010f\"\u0005\b§\u0001\u0010hR\u001d\u0010¨\u0001\u001a\u00020eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0001\u0010f\"\u0005\bª\u0001\u0010hR\u001f\u0010«\u0001\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0001\u0010\u001b\"\u0005\b­\u0001\u0010\u001dR\u001f\u0010®\u0001\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u0010\u001b\"\u0005\b°\u0001\u0010\u001d¨\u0006¼\u0001"}, d2 = {"Lcom/braze/models/push/BrazeNotificationPayload;", "", "notificationExtras", "Landroid/os/Bundle;", "brazeExtras", "context", "Landroid/content/Context;", "configurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "(Landroid/os/Bundle;Landroid/os/Bundle;Landroid/content/Context;Lcom/braze/configuration/BrazeConfigurationProvider;)V", "accentColor", "", "getAccentColor", "()Ljava/lang/Integer;", "setAccentColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "actionButtons", "", "Lcom/braze/models/push/BrazeNotificationPayload$ActionButton;", "getActionButtons", "()Ljava/util/List;", "actionButtonsInternal", "", "bigImageUrl", "", "getBigImageUrl", "()Ljava/lang/String;", "setBigImageUrl", "(Ljava/lang/String;)V", "bigSummaryText", "getBigSummaryText", "setBigSummaryText", "bigTitleText", "getBigTitleText", "setBigTitleText", "getBrazeExtras", "()Landroid/os/Bundle;", "setBrazeExtras", "(Landroid/os/Bundle;)V", "campaignId", "getCampaignId$annotations", "()V", "getCampaignId", "setCampaignId", "getConfigurationProvider", "()Lcom/braze/configuration/BrazeConfigurationProvider;", "setConfigurationProvider", "(Lcom/braze/configuration/BrazeConfigurationProvider;)V", "contentCardSyncData", "getContentCardSyncData", "setContentCardSyncData", "contentCardSyncUserId", "getContentCardSyncUserId", "setContentCardSyncUserId", "contentText", "getContentText", "setContentText", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "conversationMessages", "Lcom/braze/models/push/BrazeNotificationPayload$ConversationMessage;", "getConversationMessages", "conversationMessagesInternal", "conversationPersonMap", "", "Lcom/braze/models/push/BrazeNotificationPayload$ConversationPerson;", "getConversationPersonMap", "()Ljava/util/Map;", "conversationPersonMapInternal", "", "<set-?>", "conversationReplyPersonId", "getConversationReplyPersonId", "conversationShortcutId", "getConversationShortcutId", "setConversationShortcutId", "customNotificationId", "getCustomNotificationId", "setCustomNotificationId", "deeplink", "getDeeplink", "setDeeplink", "extras", "getExtras", "setExtras", "(Ljava/util/Map;)V", "flushMaxMinutes", "", "getFlushMaxMinutes$annotations", "getFlushMaxMinutes", "()J", "setFlushMaxMinutes", "(J)V", "flushMinMinutes", "getFlushMinMinutes$annotations", "getFlushMinMinutes", "setFlushMinMinutes", "isConversationalPush", "", "()Z", "setConversationalPush", "(Z)V", "isInlineImagePush", "setInlineImagePush", "isNewlyReceivedPushStory", "setNewlyReceivedPushStory", "isPushDeliveryEnabled", "isPushDeliveryEnabled$annotations", "setPushDeliveryEnabled", "isPushStory", "setPushStory", "isUninstallTrackingPush", "setUninstallTrackingPush", "largeIcon", "getLargeIcon", "setLargeIcon", "notificationBadgeNumber", "getNotificationBadgeNumber", "setNotificationBadgeNumber", "notificationCategory", "getNotificationCategory", "setNotificationCategory", "notificationChannelId", "getNotificationChannelId", "setNotificationChannelId", "getNotificationExtras", "notificationPriorityInt", "getNotificationPriorityInt", "setNotificationPriorityInt", "notificationReceivedTimestampMillis", "getNotificationReceivedTimestampMillis", "()Ljava/lang/Long;", "setNotificationReceivedTimestampMillis", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "notificationSound", "getNotificationSound", "setNotificationSound", "notificationVisibility", "getNotificationVisibility", "setNotificationVisibility", "publicNotificationExtras", "getPublicNotificationExtras", "setPublicNotificationExtras", "pushDuration", "getPushDuration", "setPushDuration", "pushStoryPageIndex", "getPushStoryPageIndex", "()I", "setPushStoryPageIndex", "(I)V", "pushStoryPages", "Lcom/braze/models/push/BrazeNotificationPayload$PushStoryPage;", "getPushStoryPages", "pushStoryPagesInternal", "pushUniqueId", "getPushUniqueId", "setPushUniqueId", "shouldFetchTestTriggers", "getShouldFetchTestTriggers", "setShouldFetchTestTriggers", "shouldRefreshFeatureFlags", "getShouldRefreshFeatureFlags", "setShouldRefreshFeatureFlags", "shouldSyncGeofences", "getShouldSyncGeofences", "setShouldSyncGeofences", "summaryText", "getSummaryText", "setSummaryText", "titleText", "getTitleText", "setTitleText", "parsePayloadFieldsFromBundle", "", "setActionButtons", "setIsInlineImagePush", "setPushStoryPages", "toString", "ActionButton", "Companion", "ConversationMessage", "ConversationPerson", "PushStoryPage", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BrazeNotificationPayload {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DEFAULT_PUSH_DELIVERY_MAX_FLUSH = 120;
    public static final long DEFAULT_PUSH_DELIVERY_MIN_FLUSH = 5;
    private Integer accentColor;
    private List<ActionButton> actionButtonsInternal;
    private String bigImageUrl;
    private String bigSummaryText;
    private String bigTitleText;
    private Bundle brazeExtras;
    private String campaignId;
    private BrazeConfigurationProvider configurationProvider;
    private String contentCardSyncData;
    private String contentCardSyncUserId;
    private String contentText;
    private Context context;
    private final List<ConversationMessage> conversationMessagesInternal;
    private final Map<String, ConversationPerson> conversationPersonMapInternal;
    private String conversationReplyPersonId;
    private String conversationShortcutId;
    private Integer customNotificationId;
    private String deeplink;
    private Map<String, String> extras;
    private long flushMaxMinutes;
    private long flushMinMinutes;
    private boolean isConversationalPush;
    private boolean isInlineImagePush;
    private boolean isNewlyReceivedPushStory;
    private boolean isPushDeliveryEnabled;
    private boolean isPushStory;
    private boolean isUninstallTrackingPush;
    private String largeIcon;
    private Integer notificationBadgeNumber;
    private String notificationCategory;
    private String notificationChannelId;
    private final Bundle notificationExtras;
    private Integer notificationPriorityInt;
    private Long notificationReceivedTimestampMillis;
    private String notificationSound;
    private Integer notificationVisibility;
    private String publicNotificationExtras;
    private Integer pushDuration;
    private int pushStoryPageIndex;
    private List<PushStoryPage> pushStoryPagesInternal;
    private String pushUniqueId;
    private boolean shouldFetchTestTriggers;
    private boolean shouldRefreshFeatureFlags;
    private boolean shouldSyncGeofences;
    private String summaryText;
    private String titleText;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003J\b\u0010 \u001a\u00020\bH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\fR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\f¨\u0006!"}, d2 = {"Lcom/braze/models/push/BrazeNotificationPayload$ActionButton;", "", "notificationExtras", "Landroid/os/Bundle;", "actionIndex", "", "(Landroid/os/Bundle;I)V", "actionId", "", "getActionId", "()Ljava/lang/String;", "setActionId", "(Ljava/lang/String;)V", "getActionIndex", "()I", "setActionIndex", "(I)V", "text", "getText", "setText", "type", "getType", "setType", "uri", "getUri", "setUri", "useWebview", "getUseWebview", "setUseWebview", "putIntoBundle", "", "destination", "toString", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ActionButton {
        private String actionId;
        private int actionIndex;
        private String text;
        private String type;
        private String uri;
        private String useWebview;

        public ActionButton(Bundle bundle, int i) {
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            this.actionIndex = i;
            Companion companion = BrazeNotificationPayload.Companion;
            this.type = companion.getTemplateFieldAtIndex(i, bundle, Constants.BRAZE_PUSH_ACTION_TYPE_KEY_TEMPLATE);
            this.actionId = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, Constants.BRAZE_PUSH_ACTION_ID_KEY_TEMPLATE);
            this.uri = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, Constants.BRAZE_PUSH_ACTION_URI_KEY_TEMPLATE);
            this.useWebview = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, Constants.BRAZE_PUSH_ACTION_USE_WEBVIEW_KEY_TEMPLATE);
            this.text = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, Constants.BRAZE_PUSH_ACTION_TEXT_KEY_TEMPLATE);
        }

        public final String getActionId() {
            return this.actionId;
        }

        public final int getActionIndex() {
            return this.actionIndex;
        }

        public final String getText() {
            return this.text;
        }

        public final String getType() {
            return this.type;
        }

        public final String getUri() {
            return this.uri;
        }

        public final String getUseWebview() {
            return this.useWebview;
        }

        public final void putIntoBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "destination");
            bundle.putInt(Constants.BRAZE_ACTION_INDEX_KEY, this.actionIndex);
            bundle.putString(Constants.BRAZE_ACTION_TYPE_KEY, this.type);
            bundle.putString(Constants.BRAZE_ACTION_ID_KEY, this.actionId);
            bundle.putString(Constants.BRAZE_ACTION_URI_KEY, this.uri);
            bundle.putString(Constants.BRAZE_ACTION_USE_WEBVIEW_KEY, this.useWebview);
        }

        public final void setActionId(String str) {
            this.actionId = str;
        }

        public final void setActionIndex(int i) {
            this.actionIndex = i;
        }

        public final void setText(String str) {
            this.text = str;
        }

        public final void setType(String str) {
            this.type = str;
        }

        public final void setUri(String str) {
            this.uri = str;
        }

        public final void setUseWebview(String str) {
            this.useWebview = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Companion companion = BrazeNotificationPayload.Companion;
            return sb.append(companion.stringAndKey("ActionIndex", Integer.valueOf(this.actionIndex))).append(companion.stringAndKey("Type", this.type)).append(companion.stringAndKey("Id", this.actionId)).append(companion.stringAndKey("Uri", this.uri)).append(companion.stringAndKey("UseWebview", this.useWebview)).append(companion.stringAndKey("Text", this.text)).toString();
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J(\u0010\u0010\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J,\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0007J\u001f\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000fH\u0007J \u0010\u0019\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\fH\u0007J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000fH\u0007J\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000fH\u0007J\u001f\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001dJ\u001f\u0010\u001e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001dJ\u001f\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0017J\u001a\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006#"}, d2 = {"Lcom/braze/models/push/BrazeNotificationPayload$Companion;", "", "()V", "DEFAULT_PUSH_DELIVERY_MAX_FLUSH", "", "getDEFAULT_PUSH_DELIVERY_MAX_FLUSH$android_sdk_base_release$annotations", "DEFAULT_PUSH_DELIVERY_MIN_FLUSH", "getDEFAULT_PUSH_DELIVERY_MIN_FLUSH$android_sdk_base_release$annotations", "getAttachedBrazeExtras", "Landroid/os/Bundle;", "notificationExtras", "getPushStoryGravityAtIndex", "", "actionIndex", "actionFieldKeyTemplate", "", "getTemplateFieldAtIndex", "index", "", "defaultValue", "parseLong", "bundle", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Long;", "parseNonBlankString", "parseObjectAsInteger", "parseString", "parseStringAsBoolean", "parseStringAsColorInt", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Integer;", "parseStringAsInteger", "parseStringAsLong", "stringAndKey", "prefix", "value", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse action field boolean. Returning default.";
            }
        }

        static final class b extends Lambda implements Function0 {
            public static final b b = new b();

            b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse action field long. Returning default.";
            }
        }

        static final class c extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ Bundle c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(String str, Bundle bundle) {
                super(0);
                this.b = str;
                this.c = bundle;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse long with key " + this.b + " and bundle: " + this.c;
            }
        }

        static final class d extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ Bundle c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(String str, Bundle bundle) {
                super(0);
                this.b = str;
                this.c = bundle;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse non blank string with key " + this.b + " and bundle: " + this.c;
            }
        }

        static final class e extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ Bundle c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(String str, Bundle bundle) {
                super(0);
                this.b = str;
                this.c = bundle;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse string as int with key " + this.b + " and bundle: " + this.c;
            }
        }

        static final class f extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ Bundle c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(String str, Bundle bundle) {
                super(0);
                this.b = str;
                this.c = bundle;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse string with key " + this.b + " and bundle: " + this.c;
            }
        }

        static final class g extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ Bundle c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(String str, Bundle bundle) {
                super(0);
                this.b = str;
                this.c = bundle;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse string as boolean with key " + this.b + " and bundle: " + this.c;
            }
        }

        static final class h extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ Bundle c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            h(String str, Bundle bundle) {
                super(0);
                this.b = str;
                this.c = bundle;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse string as color int with key " + this.b + " and bundle: " + this.c;
            }
        }

        static final class i extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ Bundle c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            i(String str, Bundle bundle) {
                super(0);
                this.b = str;
                this.c = bundle;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse string as int with key " + this.b + " and bundle: " + this.c;
            }
        }

        static final class j extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ Bundle c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            j(String str, Bundle bundle) {
                super(0);
                this.b = str;
                this.c = bundle;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse string as long with key " + this.b + " and bundle: " + this.c;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDEFAULT_PUSH_DELIVERY_MAX_FLUSH$android_sdk_base_release$annotations() {
        }

        public static /* synthetic */ void getDEFAULT_PUSH_DELIVERY_MIN_FLUSH$android_sdk_base_release$annotations() {
        }

        /* access modifiers changed from: private */
        public final String stringAndKey(String str, Object obj) {
            return obj != null ? 10 + str + " = " + obj : "";
        }

        @JvmStatic
        public final Bundle getAttachedBrazeExtras(Bundle bundle) {
            if (bundle == null) {
                return new Bundle();
            }
            if (bundle.containsKey(Constants.BRAZE_PUSH_STORY_IS_NEWLY_RECEIVED) && !bundle.getBoolean(Constants.BRAZE_PUSH_STORY_IS_NEWLY_RECEIVED)) {
                Bundle bundle2 = bundle.getBundle("extra");
                return bundle2 == null ? new Bundle() : bundle2;
            } else if (Constants.isAmazonDevice()) {
                return new Bundle(bundle);
            } else {
                Object obj = bundle.get("extra");
                if (obj instanceof String) {
                    return JsonUtils.parseJsonObjectIntoBundle((String) obj);
                }
                if (obj instanceof Bundle) {
                    return (Bundle) obj;
                }
                return new Bundle();
            }
        }

        @JvmStatic
        public final int getPushStoryGravityAtIndex(int i2, Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            Intrinsics.checkNotNullParameter(str, "actionFieldKeyTemplate");
            String string = bundle.getString(StringsKt.replace$default(str, ProxyConfig.MATCH_ALL_SCHEMES, String.valueOf(i2), false, 4, (Object) null));
            if (!(string == null || StringsKt.isBlank(string))) {
                int hashCode = string.hashCode();
                if (hashCode == -1364013995) {
                    string.equals(TtmlNode.CENTER);
                } else if (hashCode != 100571) {
                    if (hashCode == 109757538 && string.equals("start")) {
                        return GravityCompat.START;
                    }
                } else if (!string.equals("end")) {
                    return 17;
                } else {
                    return GravityCompat.END;
                }
            }
            return 17;
        }

        @JvmStatic
        public final String getTemplateFieldAtIndex(int i2, Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            Intrinsics.checkNotNullParameter(str, "actionFieldKeyTemplate");
            return getTemplateFieldAtIndex(i2, bundle, str, "");
        }

        @JvmStatic
        public final Long parseLong(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            try {
                if (bundle.containsKey(str)) {
                    return Long.valueOf(bundle.getLong(str));
                }
                return null;
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new c(str, bundle), 3, (Object) null);
                return null;
            }
        }

        @JvmStatic
        public final String parseNonBlankString(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            try {
                String parseString = parseString(bundle, str);
                if (!(parseString == null || StringsKt.isBlank(parseString))) {
                    return parseString;
                }
                return null;
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new d(str, bundle), 3, (Object) null);
                return null;
            }
        }

        @JvmStatic
        public final int parseObjectAsInteger(Bundle bundle, String str, int i2) {
            Object obj;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            try {
                if (bundle.containsKey(str) && (obj = bundle.get(str)) != null) {
                    return Integer.parseInt(obj.toString());
                }
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new e(str, bundle), 3, (Object) null);
            }
            return i2;
        }

        @JvmStatic
        public final String parseString(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            try {
                if (bundle.containsKey(str)) {
                    return bundle.getString(str);
                }
                return null;
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new f(str, bundle), 3, (Object) null);
                return null;
            }
        }

        @JvmStatic
        public final boolean parseStringAsBoolean(Bundle bundle, String str) {
            String string;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            try {
                if (!bundle.containsKey(str) || (string = bundle.getString(str)) == null) {
                    return false;
                }
                return Boolean.parseBoolean(string);
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new g(str, bundle), 3, (Object) null);
                return false;
            }
        }

        @JvmStatic
        public final Integer parseStringAsColorInt(Bundle bundle, String str) {
            String string;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            try {
                if (!bundle.containsKey(str) || (string = bundle.getString(str)) == null) {
                    return null;
                }
                return Integer.valueOf((int) Long.parseLong(string));
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new h(str, bundle), 3, (Object) null);
                return null;
            }
        }

        @JvmStatic
        public final Integer parseStringAsInteger(Bundle bundle, String str) {
            String string;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            try {
                if (!bundle.containsKey(str) || (string = bundle.getString(str)) == null) {
                    return null;
                }
                return Integer.valueOf(Integer.parseInt(string));
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new i(str, bundle), 3, (Object) null);
                return null;
            }
        }

        @JvmStatic
        public final Long parseStringAsLong(Bundle bundle, String str) {
            String string;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            try {
                if (!bundle.containsKey(str) || (string = bundle.getString(str)) == null) {
                    return null;
                }
                return Long.valueOf(Long.parseLong(string));
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new j(str, bundle), 3, (Object) null);
                return null;
            }
        }

        private Companion() {
        }

        @JvmStatic
        public final String getTemplateFieldAtIndex(int i2, Bundle bundle, String str, String str2) {
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            Intrinsics.checkNotNullParameter(str, "actionFieldKeyTemplate");
            String string = bundle.getString(StringsKt.replace$default(str, ProxyConfig.MATCH_ALL_SCHEMES, String.valueOf(i2), false, 4, (Object) null));
            return string == null ? str2 : string;
        }

        @JvmStatic
        public final boolean getTemplateFieldAtIndex(int i2, Bundle bundle, String str, boolean z) {
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            Intrinsics.checkNotNullParameter(str, "actionFieldKeyTemplate");
            String string = bundle.getString(StringsKt.replace$default(str, ProxyConfig.MATCH_ALL_SCHEMES, String.valueOf(i2), false, 4, (Object) null));
            if (string == null) {
                return z;
            }
            try {
                return Boolean.parseBoolean(string);
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) a.b);
                return z;
            }
        }

        @JvmStatic
        public final long getTemplateFieldAtIndex(int i2, Bundle bundle, String str, long j2) {
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            Intrinsics.checkNotNullParameter(str, "actionFieldKeyTemplate");
            String string = bundle.getString(StringsKt.replace$default(str, ProxyConfig.MATCH_ALL_SCHEMES, String.valueOf(i2), false, 4, (Object) null));
            if (string == null) {
                return j2;
            }
            try {
                return Long.parseLong(string);
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) b.b);
                return j2;
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\bH\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/braze/models/push/BrazeNotificationPayload$ConversationMessage;", "", "notificationExtras", "Landroid/os/Bundle;", "index", "", "(Landroid/os/Bundle;I)V", "message", "", "getMessage", "()Ljava/lang/String;", "personId", "getPersonId", "timestamp", "", "getTimestamp", "()J", "toString", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ConversationMessage {
        private final String message;
        private final String personId;
        private final long timestamp;

        public ConversationMessage(Bundle bundle, int i) {
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            Companion companion = BrazeNotificationPayload.Companion;
            this.message = companion.getTemplateFieldAtIndex(i, bundle, Constants.BRAZE_CONVERSATIONAL_PUSH_MESSAGE_TEXT_TEMPLATE);
            this.timestamp = companion.getTemplateFieldAtIndex(i, bundle, Constants.BRAZE_CONVERSATIONAL_PUSH_MESSAGE_TIMESTAMP_TEMPLATE, 0);
            this.personId = companion.getTemplateFieldAtIndex(i, bundle, Constants.BRAZE_CONVERSATIONAL_PUSH_MESSAGE_PERSON_ID_TEMPLATE);
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getPersonId() {
            return this.personId;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Companion companion = BrazeNotificationPayload.Companion;
            return sb.append(companion.stringAndKey("Message", this.message)).append(companion.stringAndKey(RtspHeaders.TIMESTAMP, Long.valueOf(this.timestamp))).append(companion.stringAndKey("PersonId", this.personId)).toString();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\fH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/braze/models/push/BrazeNotificationPayload$ConversationPerson;", "", "notificationExtras", "Landroid/os/Bundle;", "index", "", "(Landroid/os/Bundle;I)V", "isBot", "", "()Z", "isImportant", "name", "", "getName", "()Ljava/lang/String;", "person", "Landroidx/core/app/Person;", "getPerson", "()Landroidx/core/app/Person;", "personId", "getPersonId", "uri", "getUri", "toString", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ConversationPerson {
        private final boolean isBot;
        private final boolean isImportant;
        private final String name;
        private final String personId;
        private final String uri;

        public ConversationPerson(Bundle bundle, int i) {
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            Companion companion = BrazeNotificationPayload.Companion;
            this.personId = companion.getTemplateFieldAtIndex(i, bundle, Constants.BRAZE_CONVERSATIONAL_PUSH_PERSON_ID_TEMPLATE);
            this.name = companion.getTemplateFieldAtIndex(i, bundle, Constants.BRAZE_CONVERSATIONAL_PUSH_PERSON_NAME_TEMPLATE);
            this.uri = companion.getTemplateFieldAtIndex(i, bundle, Constants.BRAZE_CONVERSATIONAL_PUSH_PERSON_URI_TEMPLATE, (String) null);
            this.isImportant = companion.getTemplateFieldAtIndex(i, bundle, Constants.BRAZE_CONVERSATIONAL_PUSH_PERSON_IS_IMPORTANT_TEMPLATE, false);
            this.isBot = companion.getTemplateFieldAtIndex(i, bundle, Constants.BRAZE_CONVERSATIONAL_PUSH_PERSON_IS_BOT_TEMPLATE, false);
        }

        public final String getName() {
            return this.name;
        }

        public final Person getPerson() {
            Person build = new Person.Builder().setKey(this.personId).setName(this.name).setUri(this.uri).setBot(this.isBot).setImportant(this.isImportant).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
            return build;
        }

        public final String getPersonId() {
            return this.personId;
        }

        public final String getUri() {
            return this.uri;
        }

        public final boolean isBot() {
            return this.isBot;
        }

        public final boolean isImportant() {
            return this.isImportant;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Companion companion = BrazeNotificationPayload.Companion;
            return sb.append(companion.stringAndKey("PersonId", this.personId)).append(companion.stringAndKey("Name", this.name)).append(companion.stringAndKey("Uri", this.uri)).append(companion.stringAndKey("IsImportant", Boolean.valueOf(this.isImportant))).append(companion.stringAndKey("IsBot", Boolean.valueOf(this.isBot))).toString();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010(\u001a\u00020\fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u001a\u0010\u001c\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\nR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010R\u001a\u0010\"\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\b\"\u0004\b$\u0010\nR\u001c\u0010%\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0010¨\u0006)"}, d2 = {"Lcom/braze/models/push/BrazeNotificationPayload$PushStoryPage;", "", "notificationExtras", "Landroid/os/Bundle;", "actionIndex", "", "(Landroid/os/Bundle;I)V", "getActionIndex", "()I", "setActionIndex", "(I)V", "bitmapUrl", "", "getBitmapUrl", "()Ljava/lang/String;", "setBitmapUrl", "(Ljava/lang/String;)V", "campaignId", "getCampaignId", "deeplink", "getDeeplink", "setDeeplink", "storyPageId", "getStoryPageId", "setStoryPageId", "subtitle", "getSubtitle", "setSubtitle", "subtitleGravity", "getSubtitleGravity", "setSubtitleGravity", "title", "getTitle", "setTitle", "titleGravity", "getTitleGravity", "setTitleGravity", "useWebview", "getUseWebview", "setUseWebview", "toString", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PushStoryPage {
        private int actionIndex;
        private String bitmapUrl;
        private final String campaignId;
        private String deeplink;
        private String storyPageId;
        private String subtitle;
        private int subtitleGravity;
        private String title;
        private int titleGravity;
        private String useWebview;

        public PushStoryPage(Bundle bundle, int i) {
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            this.actionIndex = i;
            Companion companion = BrazeNotificationPayload.Companion;
            this.campaignId = companion.parseString(bundle, Constants.BRAZE_PUSH_CAMPAIGN_ID_KEY);
            this.title = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, Constants.BRAZE_PUSH_STORY_TITLE_KEY_TEMPLATE);
            this.titleGravity = companion.getPushStoryGravityAtIndex(this.actionIndex, bundle, Constants.BRAZE_PUSH_STORY_TITLE_JUSTIFICATION_KEY_TEMPLATE);
            this.subtitle = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, Constants.BRAZE_PUSH_STORY_SUBTITLE_KEY_TEMPLATE);
            this.subtitleGravity = companion.getPushStoryGravityAtIndex(this.actionIndex, bundle, Constants.BRAZE_PUSH_STORY_SUBTITLE_JUSTIFICATION_KEY_TEMPLATE);
            this.bitmapUrl = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, Constants.BRAZE_PUSH_STORY_IMAGE_KEY_TEMPLATE);
            this.storyPageId = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, Constants.BRAZE_PUSH_STORY_ID_KEY_TEMPLATE, "");
            this.deeplink = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, Constants.BRAZE_PUSH_STORY_DEEP_LINK_KEY_TEMPLATE);
            this.useWebview = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, Constants.BRAZE_PUSH_STORY_USE_WEBVIEW_KEY_TEMPLATE);
        }

        public final int getActionIndex() {
            return this.actionIndex;
        }

        public final String getBitmapUrl() {
            return this.bitmapUrl;
        }

        public final String getCampaignId() {
            return this.campaignId;
        }

        public final String getDeeplink() {
            return this.deeplink;
        }

        public final String getStoryPageId() {
            return this.storyPageId;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final int getSubtitleGravity() {
            return this.subtitleGravity;
        }

        public final String getTitle() {
            return this.title;
        }

        public final int getTitleGravity() {
            return this.titleGravity;
        }

        public final String getUseWebview() {
            return this.useWebview;
        }

        public final void setActionIndex(int i) {
            this.actionIndex = i;
        }

        public final void setBitmapUrl(String str) {
            this.bitmapUrl = str;
        }

        public final void setDeeplink(String str) {
            this.deeplink = str;
        }

        public final void setStoryPageId(String str) {
            this.storyPageId = str;
        }

        public final void setSubtitle(String str) {
            this.subtitle = str;
        }

        public final void setSubtitleGravity(int i) {
            this.subtitleGravity = i;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final void setTitleGravity(int i) {
            this.titleGravity = i;
        }

        public final void setUseWebview(String str) {
            this.useWebview = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Companion companion = BrazeNotificationPayload.Companion;
            return sb.append(companion.stringAndKey("ActionIndex", Integer.valueOf(this.actionIndex))).append(companion.stringAndKey("CampaignId", this.campaignId)).append(companion.stringAndKey("Title", this.title)).append(companion.stringAndKey("TitleGravity", Integer.valueOf(this.titleGravity))).append(companion.stringAndKey("Subtitle", this.subtitle)).append(companion.stringAndKey("SubtitleGravity=", Integer.valueOf(this.subtitleGravity))).append(companion.stringAndKey("BitmapUrl", this.bitmapUrl)).append(companion.stringAndKey("StoryPageId", this.storyPageId)).append(companion.stringAndKey("Deeplink", this.deeplink)).append(companion.stringAndKey("UseWebview", this.useWebview)).toString();
        }
    }

    public BrazeNotificationPayload(Bundle bundle) {
        this(bundle, (Bundle) null, (Context) null, (BrazeConfigurationProvider) null, 14, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final Bundle getAttachedBrazeExtras(Bundle bundle) {
        return Companion.getAttachedBrazeExtras(bundle);
    }

    public static /* synthetic */ void getCampaignId$annotations() {
    }

    public static /* synthetic */ void getFlushMaxMinutes$annotations() {
    }

    public static /* synthetic */ void getFlushMinMinutes$annotations() {
    }

    @JvmStatic
    public static final int getPushStoryGravityAtIndex(int i, Bundle bundle, String str) {
        return Companion.getPushStoryGravityAtIndex(i, bundle, str);
    }

    @JvmStatic
    public static final long getTemplateFieldAtIndex(int i, Bundle bundle, String str, long j) {
        return Companion.getTemplateFieldAtIndex(i, bundle, str, j);
    }

    public static /* synthetic */ void isPushDeliveryEnabled$annotations() {
    }

    @JvmStatic
    public static final Long parseLong(Bundle bundle, String str) {
        return Companion.parseLong(bundle, str);
    }

    @JvmStatic
    public static final String parseNonBlankString(Bundle bundle, String str) {
        return Companion.parseNonBlankString(bundle, str);
    }

    @JvmStatic
    public static final int parseObjectAsInteger(Bundle bundle, String str, int i) {
        return Companion.parseObjectAsInteger(bundle, str, i);
    }

    private final void parsePayloadFieldsFromBundle() {
        parsePayloadFieldsFromBundle$parseNotificationMetadata(this);
        parsePayloadFieldsFromBundle$parseContentCardData(this);
        parsePayloadFieldsFromBundle$parseVisibleContent(this);
        parsePayloadFieldsFromBundle$parseBigTextStyle(this);
        parsePayloadFieldsFromBundle$parseBigImageStyle(this);
        parsePayloadFieldsFromBundle$parseActionButtons(this);
        parsePayloadFieldsFromBundle$parsePushStoryData(this);
        parsePayloadFieldsFromBundle$parseConversationPushData(this);
        parsePayloadFieldsFromBundle$parsePushDeliveryEventData(this);
    }

    private static final void parsePayloadFieldsFromBundle$parseActionButtons(BrazeNotificationPayload brazeNotificationPayload) {
        brazeNotificationPayload.actionButtonsInternal.clear();
        int i = 0;
        while (true) {
            String templateFieldAtIndex = Companion.getTemplateFieldAtIndex(i, brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_ACTION_TYPE_KEY_TEMPLATE);
            if (!(templateFieldAtIndex == null || StringsKt.isBlank(templateFieldAtIndex))) {
                brazeNotificationPayload.actionButtonsInternal.add(new ActionButton(brazeNotificationPayload.notificationExtras, i));
                i++;
            } else {
                return;
            }
        }
    }

    private static final void parsePayloadFieldsFromBundle$parseBigImageStyle(BrazeNotificationPayload brazeNotificationPayload) {
        String parseNonBlankString = Companion.parseNonBlankString(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_BIG_IMAGE_URL_TOP_LEVEL_KEY);
        brazeNotificationPayload.bigImageUrl = parseNonBlankString;
        boolean z = false;
        if (parseNonBlankString == null || StringsKt.isBlank(parseNonBlankString)) {
            String str = brazeNotificationPayload.extras.get(Constants.BRAZE_PUSH_BIG_IMAGE_URL_KEY);
            if (str == null || StringsKt.isBlank(str)) {
                z = true;
            }
            if (!z) {
                brazeNotificationPayload.bigImageUrl = str;
            }
        }
    }

    private static final void parsePayloadFieldsFromBundle$parseBigTextStyle(BrazeNotificationPayload brazeNotificationPayload) {
        Companion companion = Companion;
        brazeNotificationPayload.bigSummaryText = companion.parseString(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_BIG_SUMMARY_TEXT_KEY);
        brazeNotificationPayload.bigTitleText = companion.parseString(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_BIG_TITLE_TEXT_KEY);
    }

    private static final void parsePayloadFieldsFromBundle$parseContentCardData(BrazeNotificationPayload brazeNotificationPayload) {
        Companion companion = Companion;
        brazeNotificationPayload.contentCardSyncData = companion.parseString(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_CONTENT_CARD_SYNC_DATA_KEY);
        brazeNotificationPayload.contentCardSyncUserId = companion.parseString(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_CONTENT_CARD_SYNC_USER_ID_KEY);
    }

    private static final void parsePayloadFieldsFromBundle$parseConversationPushData(BrazeNotificationPayload brazeNotificationPayload) {
        Companion companion = Companion;
        brazeNotificationPayload.conversationShortcutId = companion.parseString(brazeNotificationPayload.notificationExtras, Constants.BRAZE_CONVERSATIONAL_PUSH_SHORTCUT_ID_KEY);
        brazeNotificationPayload.conversationReplyPersonId = companion.parseString(brazeNotificationPayload.notificationExtras, Constants.BRAZE_CONVERSATIONAL_PUSH_REPLY_PERSON_ID_KEY);
        brazeNotificationPayload.conversationMessagesInternal.clear();
        brazeNotificationPayload.conversationPersonMapInternal.clear();
        int i = 0;
        while (true) {
            String templateFieldAtIndex = Companion.getTemplateFieldAtIndex(i, brazeNotificationPayload.notificationExtras, Constants.BRAZE_CONVERSATIONAL_PUSH_MESSAGE_TEXT_TEMPLATE);
            if (templateFieldAtIndex == null || StringsKt.isBlank(templateFieldAtIndex)) {
                break;
            }
            brazeNotificationPayload.conversationMessagesInternal.add(new ConversationMessage(brazeNotificationPayload.notificationExtras, i));
            i++;
        }
        int i2 = 0;
        while (true) {
            String templateFieldAtIndex2 = Companion.getTemplateFieldAtIndex(i2, brazeNotificationPayload.notificationExtras, Constants.BRAZE_CONVERSATIONAL_PUSH_PERSON_ID_TEMPLATE);
            if (!(templateFieldAtIndex2 == null || StringsKt.isBlank(templateFieldAtIndex2))) {
                ConversationPerson conversationPerson = new ConversationPerson(brazeNotificationPayload.notificationExtras, i2);
                brazeNotificationPayload.conversationPersonMapInternal.put(conversationPerson.getPersonId(), conversationPerson);
                i2++;
            } else {
                return;
            }
        }
    }

    private static final void parsePayloadFieldsFromBundle$parseNotificationMetadata(BrazeNotificationPayload brazeNotificationPayload) {
        Companion companion = Companion;
        brazeNotificationPayload.pushDuration = companion.parseStringAsInteger(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_NOTIFICATION_DURATION_KEY);
        brazeNotificationPayload.isPushStory = brazeNotificationPayload.notificationExtras.containsKey(Constants.BRAZE_PUSH_STORY_KEY);
        brazeNotificationPayload.notificationCategory = companion.parseString(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_CATEGORY_KEY);
        brazeNotificationPayload.notificationVisibility = companion.parseStringAsInteger(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_VISIBILITY_KEY);
        brazeNotificationPayload.notificationBadgeNumber = companion.parseStringAsInteger(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_NOTIFICATION_BADGE_COUNT_KEY);
        brazeNotificationPayload.publicNotificationExtras = companion.parseString(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_PUBLIC_NOTIFICATION_KEY);
        brazeNotificationPayload.customNotificationId = companion.parseStringAsInteger(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_CUSTOM_NOTIFICATION_ID);
        brazeNotificationPayload.notificationReceivedTimestampMillis = companion.parseLong(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_RECEIVED_TIMESTAMP_MILLIS);
        brazeNotificationPayload.isInlineImagePush = brazeNotificationPayload.notificationExtras.containsKey(Constants.BRAZE_PUSH_INLINE_IMAGE_STYLE_KEY);
        brazeNotificationPayload.isConversationalPush = brazeNotificationPayload.notificationExtras.containsKey(Constants.BRAZE_CONVERSATIONAL_PUSH_STYLE_KEY);
        brazeNotificationPayload.notificationPriorityInt = companion.parseStringAsInteger(brazeNotificationPayload.notificationExtras, "p");
        brazeNotificationPayload.shouldFetchTestTriggers = companion.parseStringAsBoolean(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_FETCH_TEST_TRIGGERS_KEY);
        brazeNotificationPayload.shouldSyncGeofences = companion.parseStringAsBoolean(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_SYNC_GEOFENCES_KEY);
        brazeNotificationPayload.shouldRefreshFeatureFlags = companion.parseStringAsBoolean(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_REFRESH_FEATURE_FLAGS);
        brazeNotificationPayload.isUninstallTrackingPush = brazeNotificationPayload.notificationExtras.containsKey(Constants.BRAZE_PUSH_UNINSTALL_TRACKING_KEY) || brazeNotificationPayload.brazeExtras.containsKey(Constants.BRAZE_PUSH_UNINSTALL_TRACKING_KEY);
        brazeNotificationPayload.deeplink = companion.parseString(brazeNotificationPayload.notificationExtras, "uri");
        brazeNotificationPayload.campaignId = companion.parseString(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_CAMPAIGN_ID_KEY);
        brazeNotificationPayload.pushUniqueId = companion.parseString(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_UNIQUE_ID);
    }

    private static final void parsePayloadFieldsFromBundle$parsePushDeliveryEventData(BrazeNotificationPayload brazeNotificationPayload) {
        Companion companion = Companion;
        Integer parseStringAsInteger = companion.parseStringAsInteger(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_DELIVERY_ENABLED_KEY);
        boolean z = false;
        if ((parseStringAsInteger != null ? parseStringAsInteger.intValue() : 0) == 1) {
            z = true;
        }
        brazeNotificationPayload.isPushDeliveryEnabled = z;
        Long parseStringAsLong = companion.parseStringAsLong(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_DELIVERY_FLUSH_MIN_KEY);
        brazeNotificationPayload.flushMinMinutes = parseStringAsLong != null ? parseStringAsLong.longValue() : 5;
        Long parseStringAsLong2 = companion.parseStringAsLong(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_DELIVERY_FLUSH_MAX_KEY);
        brazeNotificationPayload.flushMaxMinutes = parseStringAsLong2 != null ? parseStringAsLong2.longValue() : 120;
    }

    private static final void parsePayloadFieldsFromBundle$parsePushStoryData(BrazeNotificationPayload brazeNotificationPayload) {
        brazeNotificationPayload.pushStoryPageIndex = Companion.parseObjectAsInteger(brazeNotificationPayload.notificationExtras, Constants.BRAZE_STORY_INDEX_KEY, 0);
        int i = 0;
        while (true) {
            String templateFieldAtIndex = Companion.getTemplateFieldAtIndex(i, brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_STORY_IMAGE_KEY_TEMPLATE);
            if (!(templateFieldAtIndex == null || StringsKt.isBlank(templateFieldAtIndex))) {
                brazeNotificationPayload.pushStoryPagesInternal.add(new PushStoryPage(brazeNotificationPayload.notificationExtras, i));
                i++;
            } else {
                brazeNotificationPayload.isNewlyReceivedPushStory = brazeNotificationPayload.notificationExtras.getBoolean(Constants.BRAZE_PUSH_STORY_IS_NEWLY_RECEIVED, false);
                return;
            }
        }
    }

    private static final void parsePayloadFieldsFromBundle$parseVisibleContent(BrazeNotificationPayload brazeNotificationPayload) {
        Companion companion = Companion;
        brazeNotificationPayload.notificationChannelId = companion.parseNonBlankString(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_NOTIFICATION_CHANNEL_ID_KEY);
        brazeNotificationPayload.titleText = companion.parseString(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_TITLE_KEY);
        brazeNotificationPayload.contentText = companion.parseString(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_CONTENT_KEY);
        brazeNotificationPayload.largeIcon = companion.parseString(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_LARGE_ICON_KEY);
        brazeNotificationPayload.notificationSound = companion.parseString(brazeNotificationPayload.notificationExtras, "sd");
        brazeNotificationPayload.summaryText = companion.parseString(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_SUMMARY_TEXT_KEY);
        brazeNotificationPayload.accentColor = companion.parseStringAsColorInt(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_ACCENT_KEY);
    }

    @JvmStatic
    public static final String parseString(Bundle bundle, String str) {
        return Companion.parseString(bundle, str);
    }

    @JvmStatic
    public static final boolean parseStringAsBoolean(Bundle bundle, String str) {
        return Companion.parseStringAsBoolean(bundle, str);
    }

    @JvmStatic
    public static final Integer parseStringAsColorInt(Bundle bundle, String str) {
        return Companion.parseStringAsColorInt(bundle, str);
    }

    @JvmStatic
    public static final Integer parseStringAsInteger(Bundle bundle, String str) {
        return Companion.parseStringAsInteger(bundle, str);
    }

    @JvmStatic
    public static final Long parseStringAsLong(Bundle bundle, String str) {
        return Companion.parseStringAsLong(bundle, str);
    }

    public final Integer getAccentColor() {
        return this.accentColor;
    }

    public final List<ActionButton> getActionButtons() {
        return this.actionButtonsInternal;
    }

    public final String getBigImageUrl() {
        return this.bigImageUrl;
    }

    public final String getBigSummaryText() {
        return this.bigSummaryText;
    }

    public final String getBigTitleText() {
        return this.bigTitleText;
    }

    public final Bundle getBrazeExtras() {
        return this.brazeExtras;
    }

    public final String getCampaignId() {
        return this.campaignId;
    }

    public final BrazeConfigurationProvider getConfigurationProvider() {
        return this.configurationProvider;
    }

    public final String getContentCardSyncData() {
        return this.contentCardSyncData;
    }

    public final String getContentCardSyncUserId() {
        return this.contentCardSyncUserId;
    }

    public final String getContentText() {
        return this.contentText;
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<ConversationMessage> getConversationMessages() {
        return this.conversationMessagesInternal;
    }

    public final Map<String, ConversationPerson> getConversationPersonMap() {
        return this.conversationPersonMapInternal;
    }

    public final String getConversationReplyPersonId() {
        return this.conversationReplyPersonId;
    }

    public final String getConversationShortcutId() {
        return this.conversationShortcutId;
    }

    public final Integer getCustomNotificationId() {
        return this.customNotificationId;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public final long getFlushMaxMinutes() {
        return this.flushMaxMinutes;
    }

    public final long getFlushMinMinutes() {
        return this.flushMinMinutes;
    }

    public final String getLargeIcon() {
        return this.largeIcon;
    }

    public final Integer getNotificationBadgeNumber() {
        return this.notificationBadgeNumber;
    }

    public final String getNotificationCategory() {
        return this.notificationCategory;
    }

    public final String getNotificationChannelId() {
        return this.notificationChannelId;
    }

    public final Bundle getNotificationExtras() {
        return this.notificationExtras;
    }

    public final Integer getNotificationPriorityInt() {
        return this.notificationPriorityInt;
    }

    public final Long getNotificationReceivedTimestampMillis() {
        return this.notificationReceivedTimestampMillis;
    }

    public final String getNotificationSound() {
        return this.notificationSound;
    }

    public final Integer getNotificationVisibility() {
        return this.notificationVisibility;
    }

    public final String getPublicNotificationExtras() {
        return this.publicNotificationExtras;
    }

    public final Integer getPushDuration() {
        return this.pushDuration;
    }

    public final int getPushStoryPageIndex() {
        return this.pushStoryPageIndex;
    }

    public final List<PushStoryPage> getPushStoryPages() {
        return this.pushStoryPagesInternal;
    }

    public final String getPushUniqueId() {
        return this.pushUniqueId;
    }

    public final boolean getShouldFetchTestTriggers() {
        return this.shouldFetchTestTriggers;
    }

    public final boolean getShouldRefreshFeatureFlags() {
        return this.shouldRefreshFeatureFlags;
    }

    public final boolean getShouldSyncGeofences() {
        return this.shouldSyncGeofences;
    }

    public final String getSummaryText() {
        return this.summaryText;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final boolean isConversationalPush() {
        return this.isConversationalPush;
    }

    public final boolean isInlineImagePush() {
        return this.isInlineImagePush;
    }

    public final boolean isNewlyReceivedPushStory() {
        return this.isNewlyReceivedPushStory;
    }

    public final boolean isPushDeliveryEnabled() {
        return this.isPushDeliveryEnabled;
    }

    public final boolean isPushStory() {
        return this.isPushStory;
    }

    public final boolean isUninstallTrackingPush() {
        return this.isUninstallTrackingPush;
    }

    public final void setAccentColor(Integer num) {
        this.accentColor = num;
    }

    public final void setActionButtons(List<ActionButton> list) {
        Intrinsics.checkNotNullParameter(list, "actionButtons");
        this.actionButtonsInternal = list;
    }

    public final void setBigImageUrl(String str) {
        this.bigImageUrl = str;
    }

    public final void setBigSummaryText(String str) {
        this.bigSummaryText = str;
    }

    public final void setBigTitleText(String str) {
        this.bigTitleText = str;
    }

    public final void setBrazeExtras(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<set-?>");
        this.brazeExtras = bundle;
    }

    public final void setCampaignId(String str) {
        this.campaignId = str;
    }

    public final void setConfigurationProvider(BrazeConfigurationProvider brazeConfigurationProvider) {
        this.configurationProvider = brazeConfigurationProvider;
    }

    public final void setContentCardSyncData(String str) {
        this.contentCardSyncData = str;
    }

    public final void setContentCardSyncUserId(String str) {
        this.contentCardSyncUserId = str;
    }

    public final void setContentText(String str) {
        this.contentText = str;
    }

    public final void setContext(Context context2) {
        this.context = context2;
    }

    public final void setConversationShortcutId(String str) {
        this.conversationShortcutId = str;
    }

    public final void setConversationalPush(boolean z) {
        this.isConversationalPush = z;
    }

    public final void setCustomNotificationId(Integer num) {
        this.customNotificationId = num;
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public final void setExtras(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extras = map;
    }

    public final void setFlushMaxMinutes(long j) {
        this.flushMaxMinutes = j;
    }

    public final void setFlushMinMinutes(long j) {
        this.flushMinMinutes = j;
    }

    public final void setInlineImagePush(boolean z) {
        this.isInlineImagePush = z;
    }

    public final void setIsInlineImagePush(boolean z) {
        this.isInlineImagePush = z;
    }

    public final void setLargeIcon(String str) {
        this.largeIcon = str;
    }

    public final void setNewlyReceivedPushStory(boolean z) {
        this.isNewlyReceivedPushStory = z;
    }

    public final void setNotificationBadgeNumber(Integer num) {
        this.notificationBadgeNumber = num;
    }

    public final void setNotificationCategory(String str) {
        this.notificationCategory = str;
    }

    public final void setNotificationChannelId(String str) {
        this.notificationChannelId = str;
    }

    public final void setNotificationPriorityInt(Integer num) {
        this.notificationPriorityInt = num;
    }

    public final void setNotificationReceivedTimestampMillis(Long l) {
        this.notificationReceivedTimestampMillis = l;
    }

    public final void setNotificationSound(String str) {
        this.notificationSound = str;
    }

    public final void setNotificationVisibility(Integer num) {
        this.notificationVisibility = num;
    }

    public final void setPublicNotificationExtras(String str) {
        this.publicNotificationExtras = str;
    }

    public final void setPushDeliveryEnabled(boolean z) {
        this.isPushDeliveryEnabled = z;
    }

    public final void setPushDuration(Integer num) {
        this.pushDuration = num;
    }

    public final void setPushStory(boolean z) {
        this.isPushStory = z;
    }

    public final void setPushStoryPageIndex(int i) {
        this.pushStoryPageIndex = i;
    }

    public final void setPushStoryPages(List<PushStoryPage> list) {
        Intrinsics.checkNotNullParameter(list, "pushStoryPages");
        this.pushStoryPagesInternal = list;
    }

    public final void setPushUniqueId(String str) {
        this.pushUniqueId = str;
    }

    public final void setShouldFetchTestTriggers(boolean z) {
        this.shouldFetchTestTriggers = z;
    }

    public final void setShouldRefreshFeatureFlags(boolean z) {
        this.shouldRefreshFeatureFlags = z;
    }

    public final void setShouldSyncGeofences(boolean z) {
        this.shouldSyncGeofences = z;
    }

    public final void setSummaryText(String str) {
        this.summaryText = str;
    }

    public final void setTitleText(String str) {
        this.titleText = str;
    }

    public final void setUninstallTrackingPush(boolean z) {
        this.isUninstallTrackingPush = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Companion companion = Companion;
        sb.append(companion.stringAndKey("PushDuration", this.pushDuration)).append(companion.stringAndKey("IsPushStory", Boolean.valueOf(this.isPushStory))).append(companion.stringAndKey("IsInlineImagePush", Boolean.valueOf(this.isInlineImagePush))).append(companion.stringAndKey("IsConversationalPush", Boolean.valueOf(this.isConversationalPush))).append(companion.stringAndKey("PublicNotificationExtras", this.publicNotificationExtras)).append(companion.stringAndKey("NotificationChannelId", this.notificationChannelId)).append(companion.stringAndKey("NotificationCategory", this.notificationCategory)).append(companion.stringAndKey("NotificationVisibility", this.notificationVisibility)).append(companion.stringAndKey("NotificationBadgeNumber", this.notificationBadgeNumber)).append(companion.stringAndKey("CustomNotificationId", this.customNotificationId)).append(companion.stringAndKey("NotificationReceivedTimestampMillis", this.notificationReceivedTimestampMillis)).append(companion.stringAndKey("ContentCardSyncData", this.contentCardSyncData)).append(companion.stringAndKey("ContentCardSyncUserId", this.contentCardSyncUserId)).append(companion.stringAndKey("TitleText", this.titleText)).append(companion.stringAndKey("ContentText", this.contentText)).append(companion.stringAndKey("LargeIcon", this.largeIcon)).append(companion.stringAndKey("NotificationSound", this.notificationSound)).append(companion.stringAndKey("SummaryText", this.summaryText)).append(companion.stringAndKey("AccentColor", this.accentColor)).append(companion.stringAndKey("BigSummaryText", this.bigSummaryText)).append(companion.stringAndKey("BigTitleText", this.bigTitleText)).append(companion.stringAndKey("BigImageUrl", this.bigImageUrl)).append(companion.stringAndKey("ActionButtons", getActionButtons()));
        sb.append(companion.stringAndKey("PushStoryPageIndex", Integer.valueOf(this.pushStoryPageIndex))).append(companion.stringAndKey("PushStoryPages", this.pushStoryPagesInternal)).append(companion.stringAndKey("ConversationMessages", this.conversationMessagesInternal)).append(companion.stringAndKey("ConversationPersonMap", this.conversationPersonMapInternal)).append(companion.stringAndKey("PushDeliveryEnabled", Boolean.valueOf(this.isPushDeliveryEnabled))).append(companion.stringAndKey("PushUniqueId", this.pushUniqueId)).append(companion.stringAndKey("ConversationShortcutId", this.conversationShortcutId));
        return sb.toString();
    }

    public BrazeNotificationPayload(Bundle bundle, Bundle bundle2) {
        this(bundle, bundle2, (Context) null, (BrazeConfigurationProvider) null, 12, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final String getTemplateFieldAtIndex(int i, Bundle bundle, String str) {
        return Companion.getTemplateFieldAtIndex(i, bundle, str);
    }

    public BrazeNotificationPayload(Bundle bundle, Bundle bundle2, Context context2) {
        this(bundle, bundle2, context2, (BrazeConfigurationProvider) null, 8, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final String getTemplateFieldAtIndex(int i, Bundle bundle, String str, String str2) {
        return Companion.getTemplateFieldAtIndex(i, bundle, str, str2);
    }

    public BrazeNotificationPayload(Bundle bundle, Bundle bundle2, Context context2, BrazeConfigurationProvider brazeConfigurationProvider) {
        Context context3;
        this.configurationProvider = brazeConfigurationProvider;
        this.notificationExtras = bundle == null ? new Bundle() : bundle;
        this.brazeExtras = bundle2 == null ? new Bundle() : bundle2;
        this.extras = BundleUtils.toStringMap(bundle2);
        if (context2 != null) {
            context3 = context2.getApplicationContext();
        } else {
            context3 = null;
        }
        this.context = context3;
        this.flushMinMinutes = 5;
        this.flushMaxMinutes = 120;
        this.actionButtonsInternal = new ArrayList();
        this.pushStoryPagesInternal = new ArrayList();
        this.conversationMessagesInternal = new ArrayList();
        this.conversationPersonMapInternal = new HashMap();
        parsePayloadFieldsFromBundle();
    }

    @JvmStatic
    public static final boolean getTemplateFieldAtIndex(int i, Bundle bundle, String str, boolean z) {
        return Companion.getTemplateFieldAtIndex(i, bundle, str, z);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BrazeNotificationPayload(Bundle bundle, Bundle bundle2, Context context2, BrazeConfigurationProvider brazeConfigurationProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bundle, (i & 2) != 0 ? Companion.getAttachedBrazeExtras(bundle) : bundle2, (i & 4) != 0 ? null : context2, (i & 8) != 0 ? null : brazeConfigurationProvider);
    }
}
