package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0000\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\"\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0018\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001a\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u001a\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J.\u0010\u001a\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J)\u0010\u001a\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u001fJ$\u0010 \u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/facebook/appevents/InternalAppEventsLogger;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "applicationId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "activityName", "accessToken", "Lcom/facebook/AccessToken;", "(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/AccessToken;)V", "loggerImpl", "Lcom/facebook/appevents/AppEventsLoggerImpl;", "(Lcom/facebook/appevents/AppEventsLoggerImpl;)V", "flush", "", "logChangedSettingsEvent", "parameters", "Landroid/os/Bundle;", "logEvent", "eventName", "valueToSum", "", "logEventFromSE", "buttonText", "logEventImplicitly", "purchaseAmount", "Ljava/math/BigDecimal;", "currency", "Ljava/util/Currency;", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;)V", "logPurchaseImplicitly", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InternalAppEventsLogger.kt */
public final class InternalAppEventsLogger {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final AppEventsLoggerImpl loggerImpl;

    @JvmStatic
    public static final InternalAppEventsLogger createInstance(Context context) {
        return Companion.createInstance(context);
    }

    @JvmStatic
    public static final InternalAppEventsLogger createInstance(Context context, String str) {
        return Companion.createInstance(context, str);
    }

    @JvmStatic
    public static final InternalAppEventsLogger createInstance(String str, String str2, AccessToken accessToken) {
        return Companion.createInstance(str, str2, accessToken);
    }

    @JvmStatic
    public static final Executor getAnalyticsExecutor() {
        return Companion.getAnalyticsExecutor();
    }

    @JvmStatic
    public static final AppEventsLogger.FlushBehavior getFlushBehavior() {
        return Companion.getFlushBehavior();
    }

    @JvmStatic
    public static final String getPushNotificationsRegistrationId() {
        return Companion.getPushNotificationsRegistrationId();
    }

    @JvmStatic
    public static final void setInternalUserData(Map<String, String> map) {
        Companion.setInternalUserData(map);
    }

    @JvmStatic
    public static final void setUserData(Bundle bundle) {
        Companion.setUserData(bundle);
    }

    public InternalAppEventsLogger(AppEventsLoggerImpl appEventsLoggerImpl) {
        Intrinsics.checkNotNullParameter(appEventsLoggerImpl, "loggerImpl");
        this.loggerImpl = appEventsLoggerImpl;
    }

    public InternalAppEventsLogger(Context context) {
        this(new AppEventsLoggerImpl(context, (String) null, (AccessToken) null));
    }

    public InternalAppEventsLogger(Context context, String str) {
        this(new AppEventsLoggerImpl(context, str, (AccessToken) null));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InternalAppEventsLogger(String str, String str2, AccessToken accessToken) {
        this(new AppEventsLoggerImpl(str, str2, accessToken));
        Intrinsics.checkNotNullParameter(str, "activityName");
    }

    public final void logEvent(String str, Bundle bundle) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEvent(str, bundle);
        }
    }

    public final void logEvent(String str, double d, Bundle bundle) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEvent(str, d, bundle);
        }
    }

    public final void logPurchaseImplicitly(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logPurchaseImplicitly(bigDecimal, currency, bundle);
        }
    }

    public final void logEventFromSE(String str, String str2) {
        this.loggerImpl.logEventFromSE(str, str2);
    }

    public final void logEventImplicitly(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(str, bigDecimal, currency, bundle);
        }
    }

    public final void logEventImplicitly(String str) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(str, (Double) null, (Bundle) null);
        }
    }

    public final void logEventImplicitly(String str, Double d, Bundle bundle) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(str, d, bundle);
        }
    }

    public final void logEventImplicitly(String str, Bundle bundle) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(str, (Double) null, bundle);
        }
    }

    public final void logChangedSettingsEvent(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
        if (!((bundle.getInt("previous") & 2) != 0)) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (!FacebookSdk.getAutoLogAppEventsEnabled()) {
                return;
            }
        }
        this.loggerImpl.logEventImplicitly("fb_sdk_settings_changed", (Double) null, bundle);
    }

    public final void flush() {
        this.loggerImpl.flush();
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\n\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0007J\u001c\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0014H\u0007J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007¨\u0006\u0018"}, d2 = {"Lcom/facebook/appevents/InternalAppEventsLogger$Companion;", "", "()V", "createInstance", "Lcom/facebook/appevents/InternalAppEventsLogger;", "context", "Landroid/content/Context;", "applicationId", "", "activityName", "accessToken", "Lcom/facebook/AccessToken;", "getAnalyticsExecutor", "Ljava/util/concurrent/Executor;", "getFlushBehavior", "Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "getPushNotificationsRegistrationId", "setInternalUserData", "", "ud", "", "setUserData", "userData", "Landroid/os/Bundle;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InternalAppEventsLogger.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final InternalAppEventsLogger createInstance(Context context) {
            return createInstance$default(this, context, (String) null, 2, (Object) null);
        }

        private Companion() {
        }

        @JvmStatic
        public final AppEventsLogger.FlushBehavior getFlushBehavior() {
            return AppEventsLoggerImpl.Companion.getFlushBehavior();
        }

        @JvmStatic
        public final Executor getAnalyticsExecutor() {
            return AppEventsLoggerImpl.Companion.getAnalyticsExecutor();
        }

        @JvmStatic
        public final String getPushNotificationsRegistrationId() {
            return AppEventsLoggerImpl.Companion.getPushNotificationsRegistrationId();
        }

        @JvmStatic
        public final void setUserData(Bundle bundle) {
            UserDataStore userDataStore = UserDataStore.INSTANCE;
            UserDataStore.setUserDataAndHash(bundle);
        }

        @JvmStatic
        public final void setInternalUserData(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "ud");
            UserDataStore userDataStore = UserDataStore.INSTANCE;
            UserDataStore.setInternalUd(map);
        }

        public static /* synthetic */ InternalAppEventsLogger createInstance$default(Companion companion, Context context, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.createInstance(context, str);
        }

        @JvmStatic
        public final InternalAppEventsLogger createInstance(Context context, String str) {
            return new InternalAppEventsLogger(context, str);
        }

        @JvmStatic
        public final InternalAppEventsLogger createInstance(String str, String str2, AccessToken accessToken) {
            Intrinsics.checkNotNullParameter(str, "activityName");
            return new InternalAppEventsLogger(str, str2, accessToken);
        }
    }
}
