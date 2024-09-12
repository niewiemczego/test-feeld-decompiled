package com.braze.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.braze.Braze;
import com.braze.Constants;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.BrazeDateFormat;
import com.braze.enums.BrazeViewBounds;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.push.support.HtmlUtils;
import com.braze.support.BrazeImageUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.IntentUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.R;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/braze/push/BrazeNotificationStyleFactory;", "", "()V", "Companion", "NoOpSentinelStyle", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeNotificationStyleFactory.kt */
public class BrazeNotificationStyleFactory {
    private static final int BIG_PICTURE_STYLE_IMAGE_HEIGHT = 192;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String STORY_SET_GRAVITY = "setGravity";
    private static final String STORY_SET_VISIBILITY = "setVisibility";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/braze/push/BrazeNotificationStyleFactory$NoOpSentinelStyle;", "Landroidx/core/app/NotificationCompat$Style;", "()V", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BrazeNotificationStyleFactory.kt */
    private static final class NoOpSentinelStyle extends NotificationCompat.Style {
    }

    @JvmStatic
    public static final void setBigPictureSummaryAndTitle(NotificationCompat.BigPictureStyle bigPictureStyle, BrazeNotificationPayload brazeNotificationPayload) {
        Companion.setBigPictureSummaryAndTitle(bigPictureStyle, brazeNotificationPayload);
    }

    @JvmStatic
    public static final void setStyleIfSupported(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
        Companion.setStyleIfSupported(builder, brazeNotificationPayload);
    }

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\"\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0016\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010)\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/braze/push/BrazeNotificationStyleFactory$Companion;", "", "()V", "BIG_PICTURE_STYLE_IMAGE_HEIGHT", "", "STORY_SET_GRAVITY", "", "STORY_SET_VISIBILITY", "createStoryPageClickedPendingIntent", "Landroid/app/PendingIntent;", "context", "Landroid/content/Context;", "payload", "Lcom/braze/models/push/BrazeNotificationPayload;", "pushStoryPage", "Lcom/braze/models/push/BrazeNotificationPayload$PushStoryPage;", "createStoryTraversedPendingIntent", "notificationExtras", "Landroid/os/Bundle;", "pageIndex", "getBigPictureNotificationStyle", "Landroidx/core/app/NotificationCompat$BigPictureStyle;", "getBigTextNotificationStyle", "Landroidx/core/app/NotificationCompat$BigTextStyle;", "getConversationalPushStyle", "Landroidx/core/app/NotificationCompat$MessagingStyle;", "notificationBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "getInlineImageStyle", "Landroidx/core/app/NotificationCompat$Style;", "getNotificationStyle", "getStoryStyle", "Landroidx/core/app/NotificationCompat$DecoratedCustomViewStyle;", "isRemoteViewNotificationAvailableSpaceConstrained", "", "populatePushStoryPage", "view", "Landroid/widget/RemoteViews;", "setBigPictureSummaryAndTitle", "", "bigPictureNotificationStyle", "setStyleIfSupported", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BrazeNotificationStyleFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void setStyleIfSupported(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
            Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
            Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
            NotificationCompat.Style notificationStyle = getNotificationStyle(builder, brazeNotificationPayload);
            if (!(notificationStyle instanceof NoOpSentinelStyle)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationStyleFactory$Companion$setStyleIfSupported$1.INSTANCE, 3, (Object) null);
                builder.setStyle(notificationStyle);
            }
        }

        public final NotificationCompat.Style getNotificationStyle(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
            NotificationCompat.Style style;
            Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
            Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
            if (brazeNotificationPayload.isPushStory() && brazeNotificationPayload.getContext() != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationStyleFactory$Companion$getNotificationStyle$1.INSTANCE, 3, (Object) null);
                style = getStoryStyle(builder, brazeNotificationPayload);
            } else if (brazeNotificationPayload.isConversationalPush() && Build.VERSION.SDK_INT >= 25) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationStyleFactory$Companion$getNotificationStyle$2.INSTANCE, 3, (Object) null);
                style = getConversationalPushStyle(builder, brazeNotificationPayload);
            } else if (brazeNotificationPayload.getBigImageUrl() == null) {
                style = null;
            } else if (Build.VERSION.SDK_INT < 23 || !brazeNotificationPayload.isInlineImagePush()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationStyleFactory$Companion$getNotificationStyle$4.INSTANCE, 3, (Object) null);
                style = getBigPictureNotificationStyle(brazeNotificationPayload);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationStyleFactory$Companion$getNotificationStyle$3.INSTANCE, 3, (Object) null);
                style = getInlineImageStyle(brazeNotificationPayload, builder);
            }
            if (style != null) {
                return style;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationStyleFactory$Companion$getNotificationStyle$5.INSTANCE, 3, (Object) null);
            return getBigTextNotificationStyle(brazeNotificationPayload);
        }

        public final NotificationCompat.BigTextStyle getBigTextNotificationStyle(BrazeNotificationPayload brazeNotificationPayload) {
            CharSequence htmlSpannedTextIfEnabled;
            Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
            NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
            BrazeConfigurationProvider configurationProvider = brazeNotificationPayload.getConfigurationProvider();
            if (configurationProvider == null) {
                return bigTextStyle;
            }
            String contentText = brazeNotificationPayload.getContentText();
            if (!(contentText == null || (htmlSpannedTextIfEnabled = HtmlUtils.getHtmlSpannedTextIfEnabled(contentText, configurationProvider)) == null)) {
                bigTextStyle.bigText(htmlSpannedTextIfEnabled);
            }
            String bigSummaryText = brazeNotificationPayload.getBigSummaryText();
            if (bigSummaryText != null) {
                bigTextStyle.setSummaryText(HtmlUtils.getHtmlSpannedTextIfEnabled(bigSummaryText, configurationProvider));
            }
            String bigTitleText = brazeNotificationPayload.getBigTitleText();
            if (bigTitleText != null) {
                bigTextStyle.setBigContentTitle(HtmlUtils.getHtmlSpannedTextIfEnabled(bigTitleText, configurationProvider));
            }
            return bigTextStyle;
        }

        public final NotificationCompat.DecoratedCustomViewStyle getStoryStyle(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
            Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
            Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
            Context context = brazeNotificationPayload.getContext();
            if (context == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationStyleFactory$Companion$getStoryStyle$1.INSTANCE, 3, (Object) null);
                return null;
            }
            List<BrazeNotificationPayload.PushStoryPage> pushStoryPages = brazeNotificationPayload.getPushStoryPages();
            int pushStoryPageIndex = brazeNotificationPayload.getPushStoryPageIndex();
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.com_braze_push_story_one_image);
            if (!populatePushStoryPage(remoteViews, brazeNotificationPayload, pushStoryPages.get(pushStoryPageIndex))) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) BrazeNotificationStyleFactory$Companion$getStoryStyle$2.INSTANCE, 2, (Object) null);
                return null;
            }
            Bundle notificationExtras = brazeNotificationPayload.getNotificationExtras();
            NotificationCompat.DecoratedCustomViewStyle decoratedCustomViewStyle = new NotificationCompat.DecoratedCustomViewStyle();
            int size = pushStoryPages.size();
            remoteViews.setOnClickPendingIntent(R.id.com_braze_story_button_previous, createStoryTraversedPendingIntent(context, notificationExtras, ((pushStoryPageIndex - 1) + size) % size));
            remoteViews.setOnClickPendingIntent(R.id.com_braze_story_button_next, createStoryTraversedPendingIntent(context, notificationExtras, (pushStoryPageIndex + 1) % size));
            builder.setCustomBigContentView(remoteViews);
            builder.setOnlyAlertOnce(true);
            return decoratedCustomViewStyle;
        }

        public final NotificationCompat.Style getInlineImageStyle(BrazeNotificationPayload brazeNotificationPayload, NotificationCompat.Builder builder) {
            ApplicationInfo applicationInfo;
            Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
            Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
            Context context = brazeNotificationPayload.getContext();
            if (context == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationStyleFactory$Companion$getInlineImageStyle$1.INSTANCE, 3, (Object) null);
                return null;
            }
            String bigImageUrl = brazeNotificationPayload.getBigImageUrl();
            CharSequence charSequence = bigImageUrl;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationStyleFactory$Companion$getInlineImageStyle$2.INSTANCE, 3, (Object) null);
                return null;
            }
            Bundle notificationExtras = brazeNotificationPayload.getNotificationExtras();
            Bitmap pushBitmapFromUrl = Braze.Companion.getInstance(context).getImageLoader().getPushBitmapFromUrl(context, notificationExtras, bigImageUrl, BrazeViewBounds.NOTIFICATION_INLINE_PUSH_IMAGE);
            if (pushBitmapFromUrl == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationStyleFactory$Companion$getInlineImageStyle$3.INSTANCE, 3, (Object) null);
                return null;
            }
            boolean isRemoteViewNotificationAvailableSpaceConstrained = isRemoteViewNotificationAvailableSpaceConstrained(context);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), isRemoteViewNotificationAvailableSpaceConstrained ? R.layout.com_braze_push_inline_image_constrained : R.layout.com_braze_notification_inline_image);
            BrazeConfigurationProvider brazeConfigurationProvider = new BrazeConfigurationProvider(context);
            Icon createWithResource = Icon.createWithResource(context, brazeConfigurationProvider.getSmallNotificationIconResourceId());
            Intrinsics.checkNotNullExpressionValue(createWithResource, "createWithResource(\n    …nResourceId\n            )");
            Integer accentColor = brazeNotificationPayload.getAccentColor();
            if (accentColor != null) {
                createWithResource.setTint(accentColor.intValue());
            }
            remoteViews.setImageViewIcon(R.id.com_braze_inline_image_push_app_icon, createWithResource);
            PackageManager packageManager = context.getPackageManager();
            try {
                if (Build.VERSION.SDK_INT >= 33) {
                    applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(0));
                } else {
                    applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
                }
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "{\n                if (Bu…          }\n            }");
                CharSequence applicationLabel = packageManager.getApplicationLabel(applicationInfo);
                Intrinsics.checkNotNull(applicationLabel, "null cannot be cast to non-null type kotlin.String");
                remoteViews.setTextViewText(R.id.com_braze_inline_image_push_app_name_text, HtmlUtils.getHtmlSpannedTextIfEnabled((String) applicationLabel, brazeConfigurationProvider));
                remoteViews.setTextViewText(R.id.com_braze_inline_image_push_time_text, DateTimeUtils.formatDateNow(BrazeDateFormat.CLOCK_12_HOUR));
                String string = notificationExtras.getString(Constants.BRAZE_PUSH_TITLE_KEY);
                if (string != null) {
                    remoteViews.setTextViewText(R.id.com_braze_inline_image_push_title_text, HtmlUtils.getHtmlSpannedTextIfEnabled(string, brazeConfigurationProvider));
                }
                String string2 = notificationExtras.getString(Constants.BRAZE_PUSH_CONTENT_KEY);
                if (string2 != null) {
                    remoteViews.setTextViewText(R.id.com_braze_inline_image_push_content_text, HtmlUtils.getHtmlSpannedTextIfEnabled(string2, brazeConfigurationProvider));
                }
                builder.setCustomContentView(remoteViews);
                if (isRemoteViewNotificationAvailableSpaceConstrained) {
                    builder.setLargeIcon(pushBitmapFromUrl);
                    return new NotificationCompat.DecoratedCustomViewStyle();
                }
                remoteViews.setImageViewBitmap(R.id.com_braze_inline_image_push_side_image, pushBitmapFromUrl);
                return new NoOpSentinelStyle();
            } catch (PackageManager.NameNotFoundException e) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) BrazeNotificationStyleFactory$Companion$getInlineImageStyle$applicationInfo$1.INSTANCE);
                return null;
            }
        }

        public final NotificationCompat.BigPictureStyle getBigPictureNotificationStyle(BrazeNotificationPayload brazeNotificationPayload) {
            Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
            Context context = brazeNotificationPayload.getContext();
            if (context == null) {
                return null;
            }
            String bigImageUrl = brazeNotificationPayload.getBigImageUrl();
            CharSequence charSequence = bigImageUrl;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                return null;
            }
            Bitmap pushBitmapFromUrl = Braze.Companion.getInstance(context).getImageLoader().getPushBitmapFromUrl(context, brazeNotificationPayload.getNotificationExtras(), bigImageUrl, BrazeViewBounds.NOTIFICATION_EXPANDED_IMAGE);
            if (pushBitmapFromUrl == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeNotificationStyleFactory$Companion$getBigPictureNotificationStyle$1(bigImageUrl), 3, (Object) null);
                return null;
            }
            try {
                if (pushBitmapFromUrl.getWidth() > pushBitmapFromUrl.getHeight()) {
                    int pixelsFromDensityAndDp = BrazeImageUtils.getPixelsFromDensityAndDp(BrazeImageUtils.getDensityDpi(context), 192);
                    int i = pixelsFromDensityAndDp * 2;
                    int displayWidthPixels = BrazeImageUtils.getDisplayWidthPixels(context);
                    if (i > displayWidthPixels) {
                        i = displayWidthPixels;
                    }
                    try {
                        pushBitmapFromUrl = Bitmap.createScaledBitmap(pushBitmapFromUrl, i, pixelsFromDensityAndDp, true);
                    } catch (Exception e) {
                        BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) BrazeNotificationStyleFactory$Companion$getBigPictureNotificationStyle$2.INSTANCE);
                    }
                }
                if (pushBitmapFromUrl == null) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) BrazeNotificationStyleFactory$Companion$getBigPictureNotificationStyle$3.INSTANCE, 2, (Object) null);
                    return null;
                }
                NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
                bigPictureStyle.bigPicture(pushBitmapFromUrl);
                setBigPictureSummaryAndTitle(bigPictureStyle, brazeNotificationPayload);
                return bigPictureStyle;
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) BrazeNotificationStyleFactory$Companion$getBigPictureNotificationStyle$4.INSTANCE);
                return null;
            }
        }

        public final NotificationCompat.MessagingStyle getConversationalPushStyle(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
            Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
            Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
            try {
                Map<String, BrazeNotificationPayload.ConversationPerson> conversationPersonMap = brazeNotificationPayload.getConversationPersonMap();
                BrazeNotificationPayload.ConversationPerson conversationPerson = conversationPersonMap.get(brazeNotificationPayload.getConversationReplyPersonId());
                if (conversationPerson == null) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$1.INSTANCE, 3, (Object) null);
                    return null;
                }
                NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle(conversationPerson.getPerson());
                for (BrazeNotificationPayload.ConversationMessage next : brazeNotificationPayload.getConversationMessages()) {
                    BrazeNotificationPayload.ConversationPerson conversationPerson2 = conversationPersonMap.get(next.getPersonId());
                    if (conversationPerson2 == null) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$2(next), 3, (Object) null);
                        return null;
                    }
                    messagingStyle.addMessage((CharSequence) next.getMessage(), next.getTimestamp(), conversationPerson2.getPerson());
                }
                boolean z = true;
                if (conversationPersonMap.size() <= 1) {
                    z = false;
                }
                messagingStyle.setGroupConversation(z);
                builder.setShortcutId(brazeNotificationPayload.getConversationShortcutId());
                return messagingStyle;
            } catch (Exception e) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$3.INSTANCE);
                return null;
            }
        }

        private final PendingIntent createStoryPageClickedPendingIntent(Context context, BrazeNotificationPayload brazeNotificationPayload, BrazeNotificationPayload.PushStoryPage pushStoryPage) {
            Intent intent = new Intent(Constants.BRAZE_STORY_CLICKED_ACTION).setClass(context, NotificationTrampolineActivity.class);
            Intrinsics.checkNotNullExpressionValue(intent, "Intent(Constants.BRAZE_S…lineActivity::class.java)");
            intent.setFlags(intent.getFlags() | BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.NOTIFICATION_PUSH_STORY_PAGE_CLICK));
            intent.putExtras(brazeNotificationPayload.getNotificationExtras());
            intent.putExtra(Constants.BRAZE_ACTION_URI_KEY, pushStoryPage.getDeeplink());
            intent.putExtra(Constants.BRAZE_ACTION_USE_WEBVIEW_KEY, pushStoryPage.getUseWebview());
            intent.putExtra(Constants.BRAZE_STORY_PAGE_ID, pushStoryPage.getStoryPageId());
            intent.putExtra(Constants.BRAZE_CAMPAIGN_ID, pushStoryPage.getCampaignId());
            intent.putExtra(Constants.BRAZE_PUSH_NOTIFICATION_ID, BrazeNotificationUtils.getNotificationId(brazeNotificationPayload));
            PendingIntent activity = PendingIntent.getActivity(context, IntentUtils.getRequestCode(), intent, IntentUtils.getImmutablePendingIntentFlags());
            Intrinsics.checkNotNullExpressionValue(activity, "getActivity(\n           …tentFlags()\n            )");
            return activity;
        }

        private final PendingIntent createStoryTraversedPendingIntent(Context context, Bundle bundle, int i) {
            Intent intent = new Intent(Constants.BRAZE_STORY_TRAVERSE_CLICKED_ACTION).setClass(context, BrazeNotificationUtils.getNotificationReceiverClass());
            Intrinsics.checkNotNullExpressionValue(intent, "Intent(Constants.BRAZE_S…otificationReceiverClass)");
            if (bundle != null) {
                bundle.putInt(Constants.BRAZE_STORY_INDEX_KEY, i);
                intent.putExtras(bundle);
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, IntentUtils.getRequestCode(), intent, 1073741824 | IntentUtils.getImmutablePendingIntentFlags());
            Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(\n          …      flags\n            )");
            return broadcast;
        }

        private final boolean populatePushStoryPage(RemoteViews remoteViews, BrazeNotificationPayload brazeNotificationPayload, BrazeNotificationPayload.PushStoryPage pushStoryPage) {
            RemoteViews remoteViews2 = remoteViews;
            Context context = brazeNotificationPayload.getContext();
            boolean z = false;
            if (context == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationStyleFactory$Companion$populatePushStoryPage$1.INSTANCE, 3, (Object) null);
                return false;
            }
            BrazeConfigurationProvider configurationProvider = brazeNotificationPayload.getConfigurationProvider();
            if (configurationProvider == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationStyleFactory$Companion$populatePushStoryPage$2.INSTANCE, 3, (Object) null);
                return false;
            }
            String bitmapUrl = pushStoryPage.getBitmapUrl();
            CharSequence charSequence = bitmapUrl;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationStyleFactory$Companion$populatePushStoryPage$3.INSTANCE, 3, (Object) null);
                return false;
            }
            Bitmap pushBitmapFromUrl = Braze.Companion.getInstance(context).getImageLoader().getPushBitmapFromUrl(context, brazeNotificationPayload.getNotificationExtras(), bitmapUrl, BrazeViewBounds.NOTIFICATION_ONE_IMAGE_STORY);
            if (pushBitmapFromUrl == null) {
                return false;
            }
            remoteViews.setImageViewBitmap(R.id.com_braze_story_image_view, pushBitmapFromUrl);
            String title = pushStoryPage.getTitle();
            CharSequence charSequence2 = title;
            if (!(charSequence2 == null || StringsKt.isBlank(charSequence2))) {
                remoteViews.setTextViewText(R.id.com_braze_story_text_view, HtmlUtils.getHtmlSpannedTextIfEnabled(title, configurationProvider));
                remoteViews.setInt(R.id.com_braze_story_text_view_container, BrazeNotificationStyleFactory.STORY_SET_GRAVITY, pushStoryPage.getTitleGravity());
            } else {
                remoteViews.setInt(R.id.com_braze_story_text_view_container, BrazeNotificationStyleFactory.STORY_SET_VISIBILITY, 8);
            }
            String subtitle = pushStoryPage.getSubtitle();
            CharSequence charSequence3 = subtitle;
            if (charSequence3 == null || StringsKt.isBlank(charSequence3)) {
                z = true;
            }
            if (!z) {
                remoteViews.setTextViewText(R.id.com_braze_story_text_view_small, HtmlUtils.getHtmlSpannedTextIfEnabled(subtitle, configurationProvider));
                remoteViews.setInt(R.id.com_braze_story_text_view_small_container, BrazeNotificationStyleFactory.STORY_SET_GRAVITY, pushStoryPage.getSubtitleGravity());
            } else {
                remoteViews.setInt(R.id.com_braze_story_text_view_small_container, BrazeNotificationStyleFactory.STORY_SET_VISIBILITY, 8);
            }
            remoteViews.setOnClickPendingIntent(R.id.com_braze_story_relative_layout, createStoryPageClickedPendingIntent(context, brazeNotificationPayload, pushStoryPage));
            return true;
        }

        @JvmStatic
        public final void setBigPictureSummaryAndTitle(NotificationCompat.BigPictureStyle bigPictureStyle, BrazeNotificationPayload brazeNotificationPayload) {
            String contentText;
            Intrinsics.checkNotNullParameter(bigPictureStyle, "bigPictureNotificationStyle");
            Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
            BrazeConfigurationProvider configurationProvider = brazeNotificationPayload.getConfigurationProvider();
            if (configurationProvider != null) {
                String bigSummaryText = brazeNotificationPayload.getBigSummaryText();
                String bigTitleText = brazeNotificationPayload.getBigTitleText();
                String summaryText = brazeNotificationPayload.getSummaryText();
                if (bigSummaryText != null) {
                    bigPictureStyle.setSummaryText(HtmlUtils.getHtmlSpannedTextIfEnabled(bigSummaryText, configurationProvider));
                }
                if (bigTitleText != null) {
                    bigPictureStyle.setBigContentTitle(HtmlUtils.getHtmlSpannedTextIfEnabled(bigTitleText, configurationProvider));
                }
                if (summaryText == null && bigSummaryText == null && (contentText = brazeNotificationPayload.getContentText()) != null) {
                    bigPictureStyle.setSummaryText(HtmlUtils.getHtmlSpannedTextIfEnabled(contentText, configurationProvider));
                }
            }
        }

        private final boolean isRemoteViewNotificationAvailableSpaceConstrained(Context context) {
            return Build.VERSION.SDK_INT >= 31 && context.getApplicationContext().getApplicationInfo().targetSdkVersion >= 31;
        }
    }
}
