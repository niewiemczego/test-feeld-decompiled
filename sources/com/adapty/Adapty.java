package com.adapty;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.internal.AdaptyInternal;
import com.adapty.internal.di.Dependencies;
import com.adapty.internal.utils.InternalAdaptyApi;
import com.adapty.internal.utils.Logger;
import com.adapty.internal.utils.Logger$log$1;
import com.adapty.listeners.OnProfileUpdatedListener;
import com.adapty.models.AdaptyAttributionSource;
import com.adapty.models.AdaptyPaywall;
import com.adapty.models.AdaptyPaywallProduct;
import com.adapty.models.AdaptyProductSubscriptionDetails;
import com.adapty.models.AdaptyProfile;
import com.adapty.models.AdaptyProfileParameters;
import com.adapty.models.AdaptyPurchasedInfo;
import com.adapty.models.AdaptySubscriptionUpdateParameters;
import com.adapty.models.AdaptyViewConfiguration;
import com.adapty.utils.AdaptyLogHandler;
import com.adapty.utils.AdaptyLogLevel;
import com.adapty.utils.AdaptyResult;
import com.adapty.utils.ErrorCallback;
import com.adapty.utils.ResultCallback;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\n2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0007J\u0014\u0010 \u001a\u00020\n2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0002J>\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u001d2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0003\u0010(\u001a\u00020)2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020+0*H\u0007J$\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020+2\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0*H\u0007J\u0016\u00100\u001a\u00020\u00192\f\u0010!\u001a\b\u0012\u0004\u0012\u0002010*H\u0007J0\u00102\u001a\u00020\u00192\u0006\u0010-\u001a\u00020+2\u0006\u0010%\u001a\u00020\u001d2\b\b\u0003\u0010(\u001a\u00020)2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002030*H\u0007J\u0018\u00104\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0007J \u00105\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\nH\u0002J\b\u00106\u001a\u00020\u0019H\u0002J2\u00107\u001a\u00020\u00192\b\u00108\u001a\u0004\u0018\u00010\u001d2\b\u00109\u001a\u0004\u0018\u00010\u001d2\b\b\u0001\u0010:\u001a\u00020)2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0007J&\u0010;\u001a\u00020\u00192\u0006\u0010-\u001a\u00020+2\b\u0010<\u001a\u0004\u0018\u0001032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u001c\u0010;\u001a\u00020\u00192\u0006\u0010-\u001a\u00020+2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0010\u0010=\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0007J>\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020/2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010C2\b\b\u0002\u0010D\u001a\u00020\n2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010E0*H\u0007J\u0016\u0010F\u001a\u00020\u00192\f\u0010!\u001a\b\u0012\u0004\u0012\u0002010*H\u0007J\u001c\u0010G\u001a\u00020\u00192\u0006\u0010H\u001a\u00020\u001d2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0010\u0010I\u001a\u00020\u00192\u0006\u0010J\u001a\u00020KH\u0007J\u0012\u0010L\u001a\u00020\u00192\b\u0010M\u001a\u0004\u0018\u00010NH\u0007J \u0010O\u001a\u00020\u00192\u0006\u0010P\u001a\u00020\u001d2\u0006\u0010Q\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0007J,\u0010R\u001a\u00020\u00192\u0006\u0010S\u001a\u00020\u00012\u0006\u0010T\u001a\u00020U2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020\"H\u0007J\u0018\u0010W\u001a\u00020\u00192\u0006\u0010X\u001a\u00020Y2\u0006\u0010!\u001a\u00020\"H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\n8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@FX\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/adapty/Adapty;", "", "()V", "adaptyInternal", "Lcom/adapty/internal/AdaptyInternal;", "getAdaptyInternal", "()Lcom/adapty/internal/AdaptyInternal;", "adaptyInternal$delegate", "Lkotlin/Lazy;", "isActivated", "", "()Z", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "value", "Lcom/adapty/utils/AdaptyLogLevel;", "logLevel", "getLogLevel$annotations", "getLogLevel", "()Lcom/adapty/utils/AdaptyLogLevel;", "setLogLevel", "(Lcom/adapty/utils/AdaptyLogLevel;)V", "notInitializedError", "Lcom/adapty/errors/AdaptyError;", "activate", "", "context", "Landroid/content/Context;", "appKey", "", "observerMode", "customerUserId", "checkActivated", "callback", "Lcom/adapty/utils/ErrorCallback;", "getPaywall", "placementId", "locale", "fetchPolicy", "Lcom/adapty/models/AdaptyPaywall$FetchPolicy;", "loadTimeoutMillis", "", "Lcom/adapty/utils/ResultCallback;", "Lcom/adapty/models/AdaptyPaywall;", "getPaywallProducts", "paywall", "", "Lcom/adapty/models/AdaptyPaywallProduct;", "getProfile", "Lcom/adapty/models/AdaptyProfile;", "getViewConfiguration", "Lcom/adapty/models/AdaptyViewConfiguration;", "identify", "init", "logNotInitializedError", "logShowOnboarding", "name", "screenName", "screenOrder", "logShowPaywall", "viewConfiguration", "logout", "makePurchase", "activity", "Landroid/app/Activity;", "product", "subscriptionUpdateParams", "Lcom/adapty/models/AdaptySubscriptionUpdateParameters;", "isOfferPersonalized", "Lcom/adapty/models/AdaptyPurchasedInfo;", "restorePurchases", "setFallbackPaywalls", "paywalls", "setLogHandler", "logHandler", "Lcom/adapty/utils/AdaptyLogHandler;", "setOnProfileUpdatedListener", "onProfileUpdatedListener", "Lcom/adapty/listeners/OnProfileUpdatedListener;", "setVariationId", "forTransactionId", "variationId", "updateAttribution", "attribution", "source", "Lcom/adapty/models/AdaptyAttributionSource;", "networkUserId", "updateProfile", "params", "Lcom/adapty/models/AdaptyProfileParameters;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Adapty.kt */
public final class Adapty {
    public static final Adapty INSTANCE = new Adapty();
    private static final Lazy adaptyInternal$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Adapty$special$$inlined$inject$adapty_release$default$1((String) null));
    private static boolean isActivated;
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static final AdaptyError notInitializedError = new AdaptyError((Throwable) null, "Adapty was not initialized", AdaptyErrorCode.ADAPTY_NOT_INITIALIZED, 1, (DefaultConstructorMarker) null);

    @JvmStatic
    public static final void activate(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appKey");
        activate$default(context, str, false, (String) null, 12, (Object) null);
    }

    @JvmStatic
    public static final void activate(Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appKey");
        activate$default(context, str, z, (String) null, 8, (Object) null);
    }

    @JvmStatic
    public static /* synthetic */ void getLogLevel$annotations() {
    }

    @JvmStatic
    public static final void getPaywall(String str, ResultCallback<AdaptyPaywall> resultCallback) {
        Intrinsics.checkNotNullParameter(str, "placementId");
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        getPaywall$default(str, (String) null, (AdaptyPaywall.FetchPolicy) null, 0, resultCallback, 14, (Object) null);
    }

    @JvmStatic
    public static final void getPaywall(String str, String str2, AdaptyPaywall.FetchPolicy fetchPolicy, ResultCallback<AdaptyPaywall> resultCallback) {
        Intrinsics.checkNotNullParameter(str, "placementId");
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        getPaywall$default(str, str2, fetchPolicy, 0, resultCallback, 8, (Object) null);
    }

    @JvmStatic
    public static final void getPaywall(String str, String str2, ResultCallback<AdaptyPaywall> resultCallback) {
        Intrinsics.checkNotNullParameter(str, "placementId");
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        getPaywall$default(str, str2, (AdaptyPaywall.FetchPolicy) null, 0, resultCallback, 12, (Object) null);
    }

    @JvmStatic
    public static final void getViewConfiguration(AdaptyPaywall adaptyPaywall, String str, ResultCallback<AdaptyViewConfiguration> resultCallback) {
        Intrinsics.checkNotNullParameter(adaptyPaywall, "paywall");
        Intrinsics.checkNotNullParameter(str, "locale");
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        getViewConfiguration$default(adaptyPaywall, str, 0, resultCallback, 4, (Object) null);
    }

    @JvmStatic
    public static final void logShowOnboarding(String str, String str2, int i) {
        logShowOnboarding$default(str, str2, i, (ErrorCallback) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void logShowPaywall(AdaptyPaywall adaptyPaywall) {
        Intrinsics.checkNotNullParameter(adaptyPaywall, "paywall");
        logShowPaywall$default(adaptyPaywall, (ErrorCallback) null, 2, (Object) null);
    }

    @JvmStatic
    public static final void makePurchase(Activity activity, AdaptyPaywallProduct adaptyPaywallProduct, AdaptySubscriptionUpdateParameters adaptySubscriptionUpdateParameters, ResultCallback<AdaptyPurchasedInfo> resultCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adaptyPaywallProduct, "product");
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        makePurchase$default(activity, adaptyPaywallProduct, adaptySubscriptionUpdateParameters, false, resultCallback, 8, (Object) null);
    }

    @JvmStatic
    public static final void makePurchase(Activity activity, AdaptyPaywallProduct adaptyPaywallProduct, ResultCallback<AdaptyPurchasedInfo> resultCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adaptyPaywallProduct, "product");
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        makePurchase$default(activity, adaptyPaywallProduct, (AdaptySubscriptionUpdateParameters) null, false, resultCallback, 12, (Object) null);
    }

    @JvmStatic
    public static final void setFallbackPaywalls(String str) {
        Intrinsics.checkNotNullParameter(str, "paywalls");
        setFallbackPaywalls$default(str, (ErrorCallback) null, 2, (Object) null);
    }

    @JvmStatic
    public static final void updateAttribution(Object obj, AdaptyAttributionSource adaptyAttributionSource, ErrorCallback errorCallback) {
        Intrinsics.checkNotNullParameter(obj, "attribution");
        Intrinsics.checkNotNullParameter(adaptyAttributionSource, "source");
        Intrinsics.checkNotNullParameter(errorCallback, "callback");
        updateAttribution$default(obj, adaptyAttributionSource, (String) null, errorCallback, 4, (Object) null);
    }

    private Adapty() {
    }

    public static /* synthetic */ void activate$default(Context context, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        activate(context, str, z, str2);
    }

    @JvmStatic
    public static final void activate(Context context, String str, boolean z, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appKey");
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.VERBOSE;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "activate(customerUserId = " + str2 + ')'));
        }
        boolean z2 = true;
        if (!(!StringsKt.isBlank(str))) {
            throw new IllegalArgumentException("Public SDK key must not be empty.".toString());
        } else if (context.getApplicationContext() instanceof Application) {
            if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
                z2 = false;
            }
            if (z2) {
                Adapty adapty = INSTANCE;
                if (adapty.isActivated()) {
                    Logger logger2 = Logger.INSTANCE;
                    AdaptyLogLevel adaptyLogLevel2 = AdaptyLogLevel.ERROR;
                    if (logger2.canLog(adaptyLogLevel2.value)) {
                        logger2.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel2, "Adapty was already activated. If you want to provide new customerUserId, please call 'identify' function instead."));
                        return;
                    }
                    return;
                }
                adapty.init(context, str, z);
                AdaptyInternal.activate$default(adapty.getAdaptyInternal(), str2, (ErrorCallback) null, false, 6, (Object) null);
                return;
            }
            throw new IllegalArgumentException("INTERNET permission must be granted.".toString());
        } else {
            throw new IllegalArgumentException("Application context must be provided.".toString());
        }
    }

    @JvmStatic
    public static final void identify(String str, ErrorCallback errorCallback) {
        Intrinsics.checkNotNullParameter(str, "customerUserId");
        Intrinsics.checkNotNullParameter(errorCallback, "callback");
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.VERBOSE;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "identify(" + str + ')'));
        }
        Adapty adapty = INSTANCE;
        if (adapty.checkActivated(errorCallback)) {
            adapty.getAdaptyInternal().identify(str, errorCallback);
        }
    }

    @JvmStatic
    public static final void updateProfile(AdaptyProfileParameters adaptyProfileParameters, ErrorCallback errorCallback) {
        Intrinsics.checkNotNullParameter(adaptyProfileParameters, "params");
        Intrinsics.checkNotNullParameter(errorCallback, "callback");
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.VERBOSE;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "updateProfile()"));
        }
        Adapty adapty = INSTANCE;
        if (adapty.checkActivated(errorCallback)) {
            adapty.getAdaptyInternal().updateProfile(adaptyProfileParameters, errorCallback);
        }
    }

    @JvmStatic
    public static final void getProfile(ResultCallback<AdaptyProfile> resultCallback) {
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.VERBOSE;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "getProfile()"));
        }
        Adapty adapty = INSTANCE;
        if (!adapty.isActivated()) {
            adapty.logNotInitializedError();
            resultCallback.onResult(new AdaptyResult.Error(notInitializedError));
            return;
        }
        adapty.getAdaptyInternal().getProfile(resultCallback);
    }

    public static /* synthetic */ void getPaywall$default(String str, String str2, AdaptyPaywall.FetchPolicy fetchPolicy, int i, ResultCallback resultCallback, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            fetchPolicy = AdaptyPaywall.FetchPolicy.Default;
        }
        if ((i2 & 8) != 0) {
            i = 5000;
        }
        getPaywall(str, str2, fetchPolicy, i, resultCallback);
    }

    @JvmStatic
    public static final void getPaywall(String str, String str2, AdaptyPaywall.FetchPolicy fetchPolicy, int i, ResultCallback<AdaptyPaywall> resultCallback) {
        Intrinsics.checkNotNullParameter(str, "placementId");
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.VERBOSE;
        if (logger.canLog(adaptyLogLevel.value)) {
            StringBuilder append = new StringBuilder().append("getPaywall(placementId = ").append(str);
            String str3 = null;
            String str4 = str2 != null ? ", locale = " + str2 : null;
            String str5 = "";
            if (str4 == null) {
                str4 = str5;
            }
            StringBuilder append2 = append.append(str4).append(", fetchPolicy = ").append(fetchPolicy);
            Integer valueOf = Integer.valueOf(i);
            if (!Boolean.valueOf(valueOf.intValue() != Integer.MAX_VALUE).booleanValue()) {
                valueOf = null;
            }
            if (valueOf != null) {
                str3 = ", timeout = " + valueOf.intValue();
            }
            if (str3 != null) {
                str5 = str3;
            }
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, append2.append(str5).append(')').toString()));
        }
        Adapty adapty = INSTANCE;
        if (!adapty.isActivated()) {
            adapty.logNotInitializedError();
            resultCallback.onResult(new AdaptyResult.Error(notInitializedError));
            return;
        }
        adapty.getAdaptyInternal().getPaywall(str, str2, fetchPolicy, i, resultCallback);
    }

    @JvmStatic
    public static final void getPaywallProducts(AdaptyPaywall adaptyPaywall, ResultCallback<List<AdaptyPaywallProduct>> resultCallback) {
        Intrinsics.checkNotNullParameter(adaptyPaywall, "paywall");
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.VERBOSE;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "getPaywallProducts(placementId = " + adaptyPaywall.getPlacementId() + ')'));
        }
        Adapty adapty = INSTANCE;
        if (!adapty.isActivated()) {
            adapty.logNotInitializedError();
            resultCallback.onResult(new AdaptyResult.Error(notInitializedError));
            return;
        }
        adapty.getAdaptyInternal().getPaywallProducts(adaptyPaywall, resultCallback);
    }

    public static /* synthetic */ void getViewConfiguration$default(AdaptyPaywall adaptyPaywall, String str, int i, ResultCallback resultCallback, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 5000;
        }
        getViewConfiguration(adaptyPaywall, str, i, resultCallback);
    }

    @JvmStatic
    public static final void getViewConfiguration(AdaptyPaywall adaptyPaywall, String str, int i, ResultCallback<AdaptyViewConfiguration> resultCallback) {
        Intrinsics.checkNotNullParameter(adaptyPaywall, "paywall");
        Intrinsics.checkNotNullParameter(str, "locale");
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.VERBOSE;
        if (logger.canLog(adaptyLogLevel.value)) {
            StringBuilder append = new StringBuilder().append("getViewConfiguration(placementId = ").append(adaptyPaywall.getPlacementId()).append(", locale = ").append(str);
            Integer valueOf = Integer.valueOf(i);
            String str2 = null;
            if (!Boolean.valueOf(valueOf.intValue() != Integer.MAX_VALUE).booleanValue()) {
                valueOf = null;
            }
            if (valueOf != null) {
                str2 = ", timeout = " + valueOf.intValue();
            }
            if (str2 == null) {
                str2 = "";
            }
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, append.append(str2).append(')').toString()));
        }
        Adapty adapty = INSTANCE;
        if (!adapty.isActivated()) {
            adapty.logNotInitializedError();
            resultCallback.onResult(new AdaptyResult.Error(notInitializedError));
            return;
        }
        adapty.getAdaptyInternal().getViewConfiguration(adaptyPaywall, str, i, resultCallback);
    }

    public static /* synthetic */ void makePurchase$default(Activity activity, AdaptyPaywallProduct adaptyPaywallProduct, AdaptySubscriptionUpdateParameters adaptySubscriptionUpdateParameters, boolean z, ResultCallback resultCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            adaptySubscriptionUpdateParameters = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        makePurchase(activity, adaptyPaywallProduct, adaptySubscriptionUpdateParameters, z, resultCallback);
    }

    @JvmStatic
    public static final void makePurchase(Activity activity, AdaptyPaywallProduct adaptyPaywallProduct, AdaptySubscriptionUpdateParameters adaptySubscriptionUpdateParameters, boolean z, ResultCallback<AdaptyPurchasedInfo> resultCallback) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adaptyPaywallProduct, "product");
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.VERBOSE;
        if (logger.canLog(adaptyLogLevel.value)) {
            StringBuilder append = new StringBuilder().append("makePurchase(vendorProductId = ").append(adaptyPaywallProduct.getVendorProductId());
            AdaptyProductSubscriptionDetails subscriptionDetails = adaptyPaywallProduct.getSubscriptionDetails();
            String str2 = "";
            String str3 = null;
            if (subscriptionDetails != null) {
                StringBuilder append2 = new StringBuilder().append("; basePlanId = ").append(subscriptionDetails.getBasePlanId());
                String offerId = subscriptionDetails.getOfferId();
                String str4 = offerId != null ? "; offerId = " + offerId : null;
                if (str4 == null) {
                    str4 = str2;
                }
                str = append2.append(str4).toString();
            } else {
                str = null;
            }
            if (str == null) {
                str = str2;
            }
            StringBuilder append3 = append.append(str);
            if (adaptySubscriptionUpdateParameters != null) {
                str3 = "; oldVendorProductId = " + adaptySubscriptionUpdateParameters.getOldSubVendorProductId() + "; replacementMode = " + adaptySubscriptionUpdateParameters.getReplacementMode();
            }
            if (str3 != null) {
                str2 = str3;
            }
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, append3.append(str2).append(')').toString()));
        }
        Adapty adapty = INSTANCE;
        if (!adapty.isActivated()) {
            adapty.logNotInitializedError();
            resultCallback.onResult(new AdaptyResult.Error(notInitializedError));
            return;
        }
        adapty.getAdaptyInternal().makePurchase(activity, adaptyPaywallProduct, adaptySubscriptionUpdateParameters, z, resultCallback);
    }

    @JvmStatic
    public static final void restorePurchases(ResultCallback<AdaptyProfile> resultCallback) {
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.VERBOSE;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "restorePurchases()"));
        }
        Adapty adapty = INSTANCE;
        if (!adapty.isActivated()) {
            adapty.logNotInitializedError();
            resultCallback.onResult(new AdaptyResult.Error(notInitializedError));
            return;
        }
        adapty.getAdaptyInternal().restorePurchases(resultCallback);
    }

    public static /* synthetic */ void updateAttribution$default(Object obj, AdaptyAttributionSource adaptyAttributionSource, String str, ErrorCallback errorCallback, int i, Object obj2) {
        if ((i & 4) != 0) {
            str = null;
        }
        updateAttribution(obj, adaptyAttributionSource, str, errorCallback);
    }

    @JvmStatic
    public static final void updateAttribution(Object obj, AdaptyAttributionSource adaptyAttributionSource, String str, ErrorCallback errorCallback) {
        Intrinsics.checkNotNullParameter(obj, "attribution");
        Intrinsics.checkNotNullParameter(adaptyAttributionSource, "source");
        Intrinsics.checkNotNullParameter(errorCallback, "callback");
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.VERBOSE;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "updateAttribution(source = " + adaptyAttributionSource + ')'));
        }
        Adapty adapty = INSTANCE;
        if (adapty.checkActivated(errorCallback)) {
            adapty.getAdaptyInternal().updateAttribution(obj, adaptyAttributionSource, str, errorCallback);
        }
    }

    @JvmStatic
    public static final void setVariationId(String str, String str2, ErrorCallback errorCallback) {
        Intrinsics.checkNotNullParameter(str, "forTransactionId");
        Intrinsics.checkNotNullParameter(str2, "variationId");
        Intrinsics.checkNotNullParameter(errorCallback, "callback");
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.VERBOSE;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "setVariationId(variationId = " + str2 + " for transactionId = " + str + ')'));
        }
        Adapty adapty = INSTANCE;
        if (adapty.checkActivated(errorCallback)) {
            adapty.getAdaptyInternal().setVariationId(str, str2, errorCallback);
        }
    }

    @JvmStatic
    public static final void logout(ErrorCallback errorCallback) {
        Intrinsics.checkNotNullParameter(errorCallback, "callback");
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.VERBOSE;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "logout()"));
        }
        Adapty adapty = INSTANCE;
        if (adapty.checkActivated(errorCallback)) {
            adapty.getAdaptyInternal().logout(errorCallback);
        }
    }

    @JvmStatic
    public static final void setOnProfileUpdatedListener(OnProfileUpdatedListener onProfileUpdatedListener) {
        Adapty adapty = INSTANCE;
        if (checkActivated$default(adapty, (ErrorCallback) null, 1, (Object) null)) {
            adapty.getAdaptyInternal().setOnProfileUpdatedListener(onProfileUpdatedListener);
        }
    }

    public static final AdaptyLogLevel getLogLevel() {
        return Logger.logLevel;
    }

    public static final void setLogLevel(AdaptyLogLevel adaptyLogLevel) {
        Intrinsics.checkNotNullParameter(adaptyLogLevel, "value");
        Logger.logLevel = adaptyLogLevel;
    }

    @JvmStatic
    public static final void setLogHandler(AdaptyLogHandler adaptyLogHandler) {
        Intrinsics.checkNotNullParameter(adaptyLogHandler, "logHandler");
        Logger.logHandler = adaptyLogHandler;
    }

    public static /* synthetic */ void setFallbackPaywalls$default(String str, ErrorCallback errorCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            errorCallback = null;
        }
        setFallbackPaywalls(str, errorCallback);
    }

    @JvmStatic
    public static final void setFallbackPaywalls(String str, ErrorCallback errorCallback) {
        Intrinsics.checkNotNullParameter(str, "paywalls");
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.VERBOSE;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "setFallbackPaywalls()"));
        }
        Adapty adapty = INSTANCE;
        if (adapty.checkActivated(errorCallback)) {
            adapty.getAdaptyInternal().setFallbackPaywalls(str, errorCallback);
        }
    }

    public static /* synthetic */ void logShowPaywall$default(AdaptyPaywall adaptyPaywall, ErrorCallback errorCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            errorCallback = null;
        }
        logShowPaywall(adaptyPaywall, errorCallback);
    }

    @JvmStatic
    public static final void logShowPaywall(AdaptyPaywall adaptyPaywall, ErrorCallback errorCallback) {
        Intrinsics.checkNotNullParameter(adaptyPaywall, "paywall");
        INSTANCE.logShowPaywall(adaptyPaywall, (AdaptyViewConfiguration) null, errorCallback);
    }

    public static /* synthetic */ void logShowPaywall$default(Adapty adapty, AdaptyPaywall adaptyPaywall, AdaptyViewConfiguration adaptyViewConfiguration, ErrorCallback errorCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            errorCallback = null;
        }
        adapty.logShowPaywall(adaptyPaywall, adaptyViewConfiguration, errorCallback);
    }

    @InternalAdaptyApi
    public final void logShowPaywall(AdaptyPaywall adaptyPaywall, AdaptyViewConfiguration adaptyViewConfiguration, ErrorCallback errorCallback) {
        Intrinsics.checkNotNullParameter(adaptyPaywall, "paywall");
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.VERBOSE;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "logShowPaywall()"));
        }
        if (checkActivated(errorCallback)) {
            getAdaptyInternal().logShowPaywall(adaptyPaywall, adaptyViewConfiguration, errorCallback);
        }
    }

    public static /* synthetic */ void logShowOnboarding$default(String str, String str2, int i, ErrorCallback errorCallback, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            errorCallback = null;
        }
        logShowOnboarding(str, str2, i, errorCallback);
    }

    @JvmStatic
    public static final void logShowOnboarding(String str, String str2, int i, ErrorCallback errorCallback) {
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.VERBOSE;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "logShowOnboarding()"));
        }
        Adapty adapty = INSTANCE;
        if (adapty.checkActivated(errorCallback)) {
            adapty.getAdaptyInternal().logShowOnboarding(str, str2, i, errorCallback);
        }
    }

    static {
        Dependencies dependencies = Dependencies.INSTANCE;
    }

    private final AdaptyInternal getAdaptyInternal() {
        return (AdaptyInternal) adaptyInternal$delegate.getValue();
    }

    private final boolean isActivated() {
        try {
            ReentrantReadWriteLock reentrantReadWriteLock = lock;
            reentrantReadWriteLock.readLock().lock();
            boolean z = isActivated;
            reentrantReadWriteLock.readLock().unlock();
            return z;
        } catch (Throwable th) {
            lock.readLock().unlock();
            throw th;
        }
    }

    private final void init(Context context, String str, boolean z) {
        try {
            ReentrantReadWriteLock reentrantReadWriteLock = lock;
            reentrantReadWriteLock.writeLock().lock();
            Dependencies dependencies = Dependencies.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            dependencies.init$adapty_release(applicationContext, str, z);
            getAdaptyInternal().init(str);
            isActivated = true;
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            lock.writeLock().unlock();
            throw th;
        }
    }

    static /* synthetic */ boolean checkActivated$default(Adapty adapty, ErrorCallback errorCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            errorCallback = null;
        }
        return adapty.checkActivated(errorCallback);
    }

    private final boolean checkActivated(ErrorCallback errorCallback) {
        if (isActivated()) {
            return true;
        }
        logNotInitializedError();
        if (errorCallback == null) {
            return false;
        }
        errorCallback.onResult(notInitializedError);
        return false;
    }

    private final void logNotInitializedError() {
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.ERROR;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, String.valueOf(notInitializedError.getMessage())));
        }
    }
}
