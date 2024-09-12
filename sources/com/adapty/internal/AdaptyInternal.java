package com.adapty.internal;

import android.app.Activity;
import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.internal.data.cloud.AnalyticsTracker;
import com.adapty.internal.data.models.AnalyticsEvent;
import com.adapty.internal.domain.AuthInteractor;
import com.adapty.internal.domain.ProductsInteractor;
import com.adapty.internal.domain.ProfileInteractor;
import com.adapty.internal.domain.PurchasesInteractor;
import com.adapty.internal.utils.LifecycleAwareRequestRunner;
import com.adapty.internal.utils.LifecycleManager;
import com.adapty.internal.utils.Logger;
import com.adapty.internal.utils.Logger$log$1;
import com.adapty.listeners.OnProfileUpdatedListener;
import com.adapty.models.AdaptyAttributionSource;
import com.adapty.models.AdaptyPaywall;
import com.adapty.models.AdaptyPaywallProduct;
import com.adapty.models.AdaptyProfileParameters;
import com.adapty.models.AdaptySubscriptionUpdateParameters;
import com.adapty.models.AdaptyViewConfiguration;
import com.adapty.utils.AdaptyLogLevel;
import com.adapty.utils.ErrorCallback;
import com.adapty.utils.ResultCallback;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J&\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u0011J6\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020)0(J\"\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020)2\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0(J\u0014\u0010.\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020/0(J,\u00100\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020)2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002010(J\u0016\u00102\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001dJ,\u00105\u001a\u00020\u001b2\b\u00106\u001a\u0004\u0018\u00010\u001d2\b\u00107\u001a\u0004\u0018\u00010\u001d2\u0006\u00108\u001a\u00020'2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\"\u00109\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020)2\b\u0010:\u001a\u0004\u0018\u0001012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u000e\u0010;\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fJ8\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020-2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\u00112\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010C0(J\u0014\u0010D\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020/0(J\u0018\u0010E\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u001e\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010J\u001a\u00020\u001bH\u0002J(\u0010K\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020\u00012\u0006\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010P\u001a\u00020\u001b2\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R*\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/adapty/internal/AdaptyInternal;", "", "authInteractor", "Lcom/adapty/internal/domain/AuthInteractor;", "profileInteractor", "Lcom/adapty/internal/domain/ProfileInteractor;", "purchasesInteractor", "Lcom/adapty/internal/domain/PurchasesInteractor;", "productsInteractor", "Lcom/adapty/internal/domain/ProductsInteractor;", "analyticsTracker", "Lcom/adapty/internal/data/cloud/AnalyticsTracker;", "lifecycleAwareRequestRunner", "Lcom/adapty/internal/utils/LifecycleAwareRequestRunner;", "lifecycleManager", "Lcom/adapty/internal/utils/LifecycleManager;", "isObserverMode", "", "(Lcom/adapty/internal/domain/AuthInteractor;Lcom/adapty/internal/domain/ProfileInteractor;Lcom/adapty/internal/domain/PurchasesInteractor;Lcom/adapty/internal/domain/ProductsInteractor;Lcom/adapty/internal/data/cloud/AnalyticsTracker;Lcom/adapty/internal/utils/LifecycleAwareRequestRunner;Lcom/adapty/internal/utils/LifecycleManager;Z)V", "value", "Lcom/adapty/listeners/OnProfileUpdatedListener;", "onProfileUpdatedListener", "getOnProfileUpdatedListener", "()Lcom/adapty/listeners/OnProfileUpdatedListener;", "setOnProfileUpdatedListener", "(Lcom/adapty/listeners/OnProfileUpdatedListener;)V", "activate", "", "customerUserId", "", "callback", "Lcom/adapty/utils/ErrorCallback;", "isInitialActivation", "getPaywall", "id", "locale", "fetchPolicy", "Lcom/adapty/models/AdaptyPaywall$FetchPolicy;", "loadTimeout", "", "Lcom/adapty/utils/ResultCallback;", "Lcom/adapty/models/AdaptyPaywall;", "getPaywallProducts", "paywall", "", "Lcom/adapty/models/AdaptyPaywallProduct;", "getProfile", "Lcom/adapty/models/AdaptyProfile;", "getViewConfiguration", "Lcom/adapty/models/AdaptyViewConfiguration;", "identify", "init", "appKey", "logShowOnboarding", "name", "screenName", "screenOrder", "logShowPaywall", "viewConfiguration", "logout", "makePurchase", "activity", "Landroid/app/Activity;", "product", "subscriptionUpdateParams", "Lcom/adapty/models/AdaptySubscriptionUpdateParameters;", "isOfferPersonalized", "Lcom/adapty/models/AdaptyPurchasedInfo;", "restorePurchases", "setFallbackPaywalls", "paywalls", "setVariationId", "transactionId", "variationId", "setupStartRequests", "updateAttribution", "attribution", "source", "Lcom/adapty/models/AdaptyAttributionSource;", "networkUserId", "updateProfile", "params", "Lcom/adapty/models/AdaptyProfileParameters;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyInternal.kt */
public final class AdaptyInternal {
    /* access modifiers changed from: private */
    public final AnalyticsTracker analyticsTracker;
    /* access modifiers changed from: private */
    public final AuthInteractor authInteractor;
    private final boolean isObserverMode;
    /* access modifiers changed from: private */
    public final LifecycleAwareRequestRunner lifecycleAwareRequestRunner;
    private final LifecycleManager lifecycleManager;
    private OnProfileUpdatedListener onProfileUpdatedListener;
    /* access modifiers changed from: private */
    public final ProductsInteractor productsInteractor;
    /* access modifiers changed from: private */
    public final ProfileInteractor profileInteractor;
    /* access modifiers changed from: private */
    public final PurchasesInteractor purchasesInteractor;

    public AdaptyInternal(AuthInteractor authInteractor2, ProfileInteractor profileInteractor2, PurchasesInteractor purchasesInteractor2, ProductsInteractor productsInteractor2, AnalyticsTracker analyticsTracker2, LifecycleAwareRequestRunner lifecycleAwareRequestRunner2, LifecycleManager lifecycleManager2, boolean z) {
        Intrinsics.checkNotNullParameter(authInteractor2, "authInteractor");
        Intrinsics.checkNotNullParameter(profileInteractor2, "profileInteractor");
        Intrinsics.checkNotNullParameter(purchasesInteractor2, "purchasesInteractor");
        Intrinsics.checkNotNullParameter(productsInteractor2, "productsInteractor");
        Intrinsics.checkNotNullParameter(analyticsTracker2, "analyticsTracker");
        Intrinsics.checkNotNullParameter(lifecycleAwareRequestRunner2, "lifecycleAwareRequestRunner");
        Intrinsics.checkNotNullParameter(lifecycleManager2, "lifecycleManager");
        this.authInteractor = authInteractor2;
        this.profileInteractor = profileInteractor2;
        this.purchasesInteractor = purchasesInteractor2;
        this.productsInteractor = productsInteractor2;
        this.analyticsTracker = analyticsTracker2;
        this.lifecycleAwareRequestRunner = lifecycleAwareRequestRunner2;
        this.lifecycleManager = lifecycleManager2;
        this.isObserverMode = z;
    }

    public final /* synthetic */ OnProfileUpdatedListener getOnProfileUpdatedListener() {
        return this.onProfileUpdatedListener;
    }

    public final /* synthetic */ void setOnProfileUpdatedListener(OnProfileUpdatedListener onProfileUpdatedListener2) {
        Job unused = Intrinsics.checkNotNullParameter(new AdaptyInternal$onProfileUpdatedListener$1(this, onProfileUpdatedListener2, (Continuation<? super AdaptyInternal$onProfileUpdatedListener$1>) null), "block");
        this.onProfileUpdatedListener = onProfileUpdatedListener2;
    }

    public final void init(String str) {
        Intrinsics.checkNotNullParameter(str, "appKey");
        this.authInteractor.handleAppKey(str);
        this.lifecycleManager.init();
    }

    public final /* synthetic */ void getProfile(ResultCallback resultCallback) {
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        AnalyticsEvent.SDKMethodRequestData.Basic create = AnalyticsEvent.SDKMethodRequestData.Companion.create("get_profile");
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, create, (Function2) null, 2, (Object) null);
        Job unused = Intrinsics.checkNotNullParameter(new AdaptyInternal$getProfile$1(this, create, resultCallback, (Continuation<? super AdaptyInternal$getProfile$1>) null), "block");
    }

    public final /* synthetic */ void updateProfile(AdaptyProfileParameters adaptyProfileParameters, ErrorCallback errorCallback) {
        Intrinsics.checkNotNullParameter(adaptyProfileParameters, "params");
        Intrinsics.checkNotNullParameter(errorCallback, "callback");
        AnalyticsEvent.SDKMethodRequestData.Basic create = AnalyticsEvent.SDKMethodRequestData.Companion.create("update_profile");
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, create, (Function2) null, 2, (Object) null);
        Job unused = Intrinsics.checkNotNullParameter(new AdaptyInternal$updateProfile$1(this, adaptyProfileParameters, create, errorCallback, (Continuation<? super AdaptyInternal$updateProfile$1>) null), "block");
    }

    public static /* synthetic */ void activate$default(AdaptyInternal adaptyInternal, String str, ErrorCallback errorCallback, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            errorCallback = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        adaptyInternal.activate(str, errorCallback, z);
    }

    public final /* synthetic */ void activate(String str, ErrorCallback errorCallback, boolean z) {
        AnalyticsEvent.SDKMethodRequestData sDKMethodRequestData;
        if (z) {
            sDKMethodRequestData = AnalyticsEvent.SDKMethodRequestData.Activate.Companion.create(this.isObserverMode, str != null);
        } else {
            sDKMethodRequestData = AnalyticsEvent.SDKMethodRequestData.Companion.create("logout");
        }
        AnalyticsEvent.SDKMethodRequestData sDKMethodRequestData2 = sDKMethodRequestData;
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, sDKMethodRequestData2, (Function2) null, 2, (Object) null);
        Job unused = Intrinsics.checkNotNullParameter(new AdaptyInternal$activate$1(this, str, sDKMethodRequestData2, errorCallback, z, (Continuation<? super AdaptyInternal$activate$1>) null), "block");
        Job unused2 = Intrinsics.checkNotNullParameter(new AdaptyInternal$activate$2(this, (Continuation<? super AdaptyInternal$activate$2>) null), "block");
    }

    public final /* synthetic */ void identify(String str, ErrorCallback errorCallback) {
        Intrinsics.checkNotNullParameter(str, "customerUserId");
        Intrinsics.checkNotNullParameter(errorCallback, "callback");
        AnalyticsEvent.SDKMethodRequestData.Basic create = AnalyticsEvent.SDKMethodRequestData.Companion.create("identify");
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, create, (Function2) null, 2, (Object) null);
        if (StringsKt.isBlank(str)) {
            Logger logger = Logger.INSTANCE;
            AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.ERROR;
            if (logger.canLog(adaptyLogLevel.value)) {
                logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "customerUserId should not be empty"));
            }
            AdaptyError adaptyError = new AdaptyError((Throwable) null, "customerUserId should not be empty", AdaptyErrorCode.WRONG_PARAMETER, 1, (DefaultConstructorMarker) null);
            AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, AnalyticsEvent.SDKMethodResponseData.Companion.create(create, adaptyError), (Function2) null, 2, (Object) null);
            errorCallback.onResult(adaptyError);
        } else if (Intrinsics.areEqual((Object) str, (Object) this.authInteractor.getCustomerUserId())) {
            AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, AnalyticsEvent.SDKMethodResponseData.Companion.create(create, (AdaptyError) null), (Function2) null, 2, (Object) null);
            errorCallback.onResult((AdaptyError) null);
        } else {
            Job unused = Intrinsics.checkNotNullParameter(new AdaptyInternal$identify$2(this, str, create, errorCallback, (Continuation<? super AdaptyInternal$identify$2>) null), "block");
        }
    }

    public final /* synthetic */ void logout(ErrorCallback errorCallback) {
        Intrinsics.checkNotNullParameter(errorCallback, "callback");
        this.authInteractor.clearDataOnLogout();
        activate((String) null, errorCallback, false);
    }

    public final /* synthetic */ void makePurchase(Activity activity, AdaptyPaywallProduct adaptyPaywallProduct, AdaptySubscriptionUpdateParameters adaptySubscriptionUpdateParameters, boolean z, ResultCallback resultCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adaptyPaywallProduct, "product");
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        AnalyticsEvent.SDKMethodRequestData.MakePurchase create = AnalyticsEvent.SDKMethodRequestData.MakePurchase.Companion.create(adaptyPaywallProduct);
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, create, (Function2) null, 2, (Object) null);
        Job unused = Intrinsics.checkNotNullParameter(new AdaptyInternal$makePurchase$1(this, activity, adaptyPaywallProduct, adaptySubscriptionUpdateParameters, z, create, resultCallback, (Continuation<? super AdaptyInternal$makePurchase$1>) null), "block");
    }

    public final /* synthetic */ void restorePurchases(ResultCallback resultCallback) {
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        AnalyticsEvent.SDKMethodRequestData.Basic create = AnalyticsEvent.SDKMethodRequestData.Companion.create("restore_purchases");
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, create, (Function2) null, 2, (Object) null);
        Job unused = Intrinsics.checkNotNullParameter(new AdaptyInternal$restorePurchases$1(this, create, resultCallback, (Continuation<? super AdaptyInternal$restorePurchases$1>) null), "block");
    }

    public final /* synthetic */ void getPaywall(String str, String str2, AdaptyPaywall.FetchPolicy fetchPolicy, int i, ResultCallback resultCallback) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        AnalyticsEvent.SDKMethodRequestData.GetPaywall create = AnalyticsEvent.SDKMethodRequestData.GetPaywall.Companion.create(str, str2, fetchPolicy, i);
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, create, (Function2) null, 2, (Object) null);
        Job unused = Intrinsics.checkNotNullParameter(new AdaptyInternal$getPaywall$1(this, str, str2, fetchPolicy, i, create, resultCallback, (Continuation<? super AdaptyInternal$getPaywall$1>) null), "block");
    }

    public final /* synthetic */ void getViewConfiguration(AdaptyPaywall adaptyPaywall, String str, int i, ResultCallback resultCallback) {
        Intrinsics.checkNotNullParameter(adaptyPaywall, "paywall");
        Intrinsics.checkNotNullParameter(str, "locale");
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        AnalyticsEvent.SDKMethodRequestData.Basic create = AnalyticsEvent.SDKMethodRequestData.Companion.create("get_paywall_builder");
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, create, (Function2) null, 2, (Object) null);
        Job unused = Intrinsics.checkNotNullParameter(new AdaptyInternal$getViewConfiguration$1(this, adaptyPaywall, str, i, create, resultCallback, (Continuation<? super AdaptyInternal$getViewConfiguration$1>) null), "block");
    }

    public final /* synthetic */ void getPaywallProducts(AdaptyPaywall adaptyPaywall, ResultCallback resultCallback) {
        Intrinsics.checkNotNullParameter(adaptyPaywall, "paywall");
        Intrinsics.checkNotNullParameter(resultCallback, "callback");
        AnalyticsEvent.SDKMethodRequestData.GetPaywallProducts create = AnalyticsEvent.SDKMethodRequestData.GetPaywallProducts.Companion.create(adaptyPaywall.getPlacementId());
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, create, (Function2) null, 2, (Object) null);
        Job unused = Intrinsics.checkNotNullParameter(new AdaptyInternal$getPaywallProducts$1(this, adaptyPaywall, create, resultCallback, (Continuation<? super AdaptyInternal$getPaywallProducts$1>) null), "block");
    }

    public final /* synthetic */ void setFallbackPaywalls(String str, ErrorCallback errorCallback) {
        Intrinsics.checkNotNullParameter(str, "paywalls");
        AnalyticsEvent.SDKMethodRequestData.Basic create = AnalyticsEvent.SDKMethodRequestData.Companion.create("set_fallback_paywalls");
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, create, (Function2) null, 2, (Object) null);
        AdaptyError fallbackPaywalls = this.productsInteractor.setFallbackPaywalls(str);
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, AnalyticsEvent.SDKMethodResponseData.Companion.create(create, fallbackPaywalls), (Function2) null, 2, (Object) null);
        if (errorCallback != null) {
            errorCallback.onResult(fallbackPaywalls);
        }
    }

    public final /* synthetic */ void logShowPaywall(AdaptyPaywall adaptyPaywall, AdaptyViewConfiguration adaptyViewConfiguration, ErrorCallback errorCallback) {
        String id;
        Intrinsics.checkNotNullParameter(adaptyPaywall, "paywall");
        AnalyticsTracker analyticsTracker2 = this.analyticsTracker;
        Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("variation_id", adaptyPaywall.getVariationId()));
        if (!(adaptyViewConfiguration == null || (id = adaptyViewConfiguration.getId()) == null)) {
            mutableMapOf.put("paywall_builder_id", id);
        }
        Unit unit = Unit.INSTANCE;
        AnalyticsTracker.DefaultImpls.trackEvent$default(analyticsTracker2, "paywall_showed", mutableMapOf, (Function2) null, errorCallback, 4, (Object) null);
    }

    public final /* synthetic */ void logShowOnboarding(String str, String str2, int i, ErrorCallback errorCallback) {
        if (i < 1) {
            Logger logger = Logger.INSTANCE;
            AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.ERROR;
            if (logger.canLog(adaptyLogLevel.value)) {
                logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "screenOrder must be greater than or equal to 1"));
            }
            if (errorCallback != null) {
                errorCallback.onResult(new AdaptyError((Throwable) null, "screenOrder must be greater than or equal to 1", AdaptyErrorCode.WRONG_PARAMETER, 1, (DefaultConstructorMarker) null));
                return;
            }
            return;
        }
        AnalyticsTracker analyticsTracker2 = this.analyticsTracker;
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to("onboarding_screen_order", Integer.valueOf(i)));
        if (str != null) {
            hashMapOf.put("onboarding_name", str);
        }
        if (str2 != null) {
            hashMapOf.put("onboarding_screen_name", str2);
        }
        Unit unit = Unit.INSTANCE;
        AnalyticsTracker.DefaultImpls.trackEvent$default(analyticsTracker2, "onboarding_screen_showed", hashMapOf, (Function2) null, errorCallback, 4, (Object) null);
    }

    public final /* synthetic */ void updateAttribution(Object obj, AdaptyAttributionSource adaptyAttributionSource, String str, ErrorCallback errorCallback) {
        Intrinsics.checkNotNullParameter(obj, "attribution");
        Intrinsics.checkNotNullParameter(adaptyAttributionSource, "source");
        Intrinsics.checkNotNullParameter(errorCallback, "callback");
        AnalyticsEvent.SDKMethodRequestData.UpdateAttribution create = AnalyticsEvent.SDKMethodRequestData.UpdateAttribution.Companion.create(adaptyAttributionSource.toString(), str);
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, create, (Function2) null, 2, (Object) null);
        Job unused = Intrinsics.checkNotNullParameter(new AdaptyInternal$updateAttribution$1(this, obj, adaptyAttributionSource, str, create, errorCallback, (Continuation<? super AdaptyInternal$updateAttribution$1>) null), "block");
    }

    public final /* synthetic */ void setVariationId(String str, String str2, ErrorCallback errorCallback) {
        Intrinsics.checkNotNullParameter(str, "transactionId");
        Intrinsics.checkNotNullParameter(str2, "variationId");
        Intrinsics.checkNotNullParameter(errorCallback, "callback");
        AnalyticsEvent.SDKMethodRequestData.SetVariationId create = AnalyticsEvent.SDKMethodRequestData.SetVariationId.Companion.create(str, str2);
        AnalyticsTracker.DefaultImpls.trackSystemEvent$default(this.analyticsTracker, create, (Function2) null, 2, (Object) null);
        Job unused = Intrinsics.checkNotNullParameter(new AdaptyInternal$setVariationId$1(this, str, str2, create, errorCallback, (Continuation<? super AdaptyInternal$setVariationId$1>) null), "block");
    }

    /* access modifiers changed from: private */
    public final void setupStartRequests() {
        Job unused = Intrinsics.checkNotNullParameter(new AdaptyInternal$setupStartRequests$1(this, (Continuation<? super AdaptyInternal$setupStartRequests$1>) null), "block");
    }
}
