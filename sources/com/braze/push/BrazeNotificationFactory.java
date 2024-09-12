package com.braze.push;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.braze.IBrazeNotificationFactory;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J0\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¨\u0006\u0012"}, d2 = {"Lcom/braze/push/BrazeNotificationFactory;", "Lcom/braze/IBrazeNotificationFactory;", "()V", "createNotification", "Landroid/app/Notification;", "appConfigurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "context", "Landroid/content/Context;", "notificationExtras", "Landroid/os/Bundle;", "brazeExtras", "payload", "Lcom/braze/models/push/BrazeNotificationPayload;", "populateNotificationBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "configurationProvider", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeNotificationFactory.kt */
public class BrazeNotificationFactory implements IBrazeNotificationFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final BrazeNotificationFactory internalInstance = new BrazeNotificationFactory();

    public static final BrazeNotificationFactory getInstance() {
        return Companion.getInstance();
    }

    @JvmStatic
    public static final NotificationCompat.Builder populateNotificationBuilder(BrazeNotificationPayload brazeNotificationPayload) {
        return Companion.populateNotificationBuilder(brazeNotificationPayload);
    }

    public Notification createNotification(BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        NotificationCompat.Builder populateNotificationBuilder = Companion.populateNotificationBuilder(brazeNotificationPayload);
        if (populateNotificationBuilder != null) {
            return populateNotificationBuilder.build();
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) BrazeNotificationFactory$createNotification$1.INSTANCE, 2, (Object) null);
        return null;
    }

    public final Notification createNotification(BrazeConfigurationProvider brazeConfigurationProvider, Context context, Bundle bundle, Bundle bundle2) {
        return createNotification(new BrazeNotificationPayload(bundle, bundle2, context, brazeConfigurationProvider));
    }

    public final NotificationCompat.Builder populateNotificationBuilder(BrazeConfigurationProvider brazeConfigurationProvider, Context context, Bundle bundle, Bundle bundle2) {
        return Companion.populateNotificationBuilder(new BrazeNotificationPayload(bundle, bundle2, context, brazeConfigurationProvider));
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/braze/push/BrazeNotificationFactory$Companion;", "", "()V", "instance", "Lcom/braze/push/BrazeNotificationFactory;", "getInstance$annotations", "getInstance", "()Lcom/braze/push/BrazeNotificationFactory;", "internalInstance", "populateNotificationBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "payload", "Lcom/braze/models/push/BrazeNotificationPayload;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BrazeNotificationFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        private Companion() {
        }

        public final BrazeNotificationFactory getInstance() {
            return BrazeNotificationFactory.internalInstance;
        }

        @JvmStatic
        public final NotificationCompat.Builder populateNotificationBuilder(BrazeNotificationPayload brazeNotificationPayload) {
            Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeNotificationFactory$Companion$populateNotificationBuilder$1(brazeNotificationPayload), 2, (Object) null);
            Context context = brazeNotificationPayload.getContext();
            if (context == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationFactory$Companion$populateNotificationBuilder$2.INSTANCE, 3, (Object) null);
                return null;
            }
            BrazeConfigurationProvider configurationProvider = brazeNotificationPayload.getConfigurationProvider();
            if (configurationProvider == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationFactory$Companion$populateNotificationBuilder$3.INSTANCE, 3, (Object) null);
                return null;
            }
            Bundle notificationExtras = brazeNotificationPayload.getNotificationExtras();
            BrazeNotificationUtils.prefetchBitmapsIfNewlyReceivedStoryPush(brazeNotificationPayload);
            NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(context, BrazeNotificationUtils.getOrCreateNotificationChannelId(brazeNotificationPayload)).setAutoCancel(true);
            Intrinsics.checkNotNullExpressionValue(autoCancel, "Builder(context, notific…     .setAutoCancel(true)");
            BrazeNotificationUtils.setTitleIfPresent(autoCancel, brazeNotificationPayload);
            BrazeNotificationUtils.setContentIfPresent(autoCancel, brazeNotificationPayload);
            BrazeNotificationUtils.setTickerIfPresent(autoCancel, brazeNotificationPayload);
            BrazeNotificationUtils.setSetShowWhen(autoCancel, brazeNotificationPayload);
            BrazeNotificationUtils.setContentIntentIfPresent(context, autoCancel, notificationExtras);
            BrazeNotificationUtils.setDeleteIntent(context, autoCancel, notificationExtras);
            BrazeNotificationUtils.setSmallIcon(configurationProvider, autoCancel);
            BrazeNotificationUtils.setLargeIconIfPresentAndSupported(autoCancel, brazeNotificationPayload);
            BrazeNotificationUtils.setSoundIfPresentAndSupported(autoCancel, brazeNotificationPayload);
            BrazeNotificationUtils.setSummaryTextIfPresentAndSupported(autoCancel, brazeNotificationPayload);
            BrazeNotificationUtils.setPriorityIfPresentAndSupported(autoCancel, brazeNotificationPayload);
            BrazeNotificationStyleFactory.Companion.setStyleIfSupported(autoCancel, brazeNotificationPayload);
            BrazeNotificationActionUtils.addNotificationActions(autoCancel, brazeNotificationPayload);
            BrazeNotificationUtils.setAccentColorIfPresentAndSupported(autoCancel, brazeNotificationPayload);
            BrazeNotificationUtils.setCategoryIfPresentAndSupported(autoCancel, brazeNotificationPayload);
            BrazeNotificationUtils.setVisibilityIfPresentAndSupported(autoCancel, brazeNotificationPayload);
            BrazeNotificationUtils.setPublicVersionIfPresentAndSupported(autoCancel, brazeNotificationPayload);
            BrazeNotificationUtils.setNotificationBadgeNumberIfPresent(autoCancel, brazeNotificationPayload);
            return autoCancel;
        }
    }
}
