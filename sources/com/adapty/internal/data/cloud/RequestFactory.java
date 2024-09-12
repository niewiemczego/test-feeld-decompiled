package com.adapty.internal.data.cloud;

import com.adapty.BuildConfig;
import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.cache.ResponseCacheKeyProvider;
import com.adapty.internal.data.cache.ResponseCacheKeys;
import com.adapty.internal.data.cloud.Request;
import com.adapty.internal.data.models.AnalyticsEvent;
import com.adapty.internal.data.models.AttributionData;
import com.adapty.internal.data.models.InstallationMeta;
import com.adapty.internal.data.models.requests.CreateOrUpdateProfileRequest;
import com.adapty.internal.data.models.requests.RestoreReceiptRequest;
import com.adapty.internal.data.models.requests.SendEventRequest;
import com.adapty.internal.data.models.requests.SetVariationIdRequest;
import com.adapty.internal.data.models.requests.UpdateAttributionRequest;
import com.adapty.internal.data.models.requests.ValidateReceiptRequest;
import com.adapty.internal.domain.models.PurchaseableProduct;
import com.adapty.internal.utils.MetaInfoRetriever;
import com.adapty.internal.utils.PayloadProvider;
import com.adapty.internal.utils.UtilsKt;
import com.adapty.models.AdaptyProfileParameters;
import com.amplitude.reactnative.AndroidContextProvider;
import com.android.billingclient.api.Purchase;
import com.facebook.internal.ServerProtocol;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.gson.Gson;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 G2\u00020\u0001:\u0001GB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\"\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\u0002\b\u001aH\bJ\"\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0006\u0010!\u001a\u00020\u0015J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\rH\u0002J\u0006\u0010$\u001a\u00020\u0015J\u0016\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\rJ\u001e\u0010(\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\u0006\u0010)\u001a\u00020\rJ\u0006\u0010*\u001a\u00020\u0015J\u0006\u0010+\u001a\u00020\u0015J\u0016\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\r2\u0006\u0010'\u001a\u00020\rJ\u0016\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\r2\u0006\u0010'\u001a\u00020\rJ\u0014\u00100\u001a\u00020\u00152\f\u00101\u001a\b\u0012\u0004\u0012\u00020302J\u0014\u00104\u001a\u00020\u00152\f\u00105\u001a\b\u0012\u0004\u0012\u00020602J\u0016\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\r2\u0006\u0010/\u001a\u00020\rJ\u000e\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020;J$\u0010<\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010=\u001a\u0004\u0018\u00010\rJ\u0016\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BJ\f\u0010C\u001a\u00020\u0019*\u00020\u0018H\u0002J\u0014\u0010D\u001a\u00020\u0019*\u00020\u00182\u0006\u0010E\u001a\u00020FH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/adapty/internal/data/cloud/RequestFactory;", "", "cacheRepository", "Lcom/adapty/internal/data/cache/CacheRepository;", "responseCacheKeyProvider", "Lcom/adapty/internal/data/cache/ResponseCacheKeyProvider;", "metaInfoRetriever", "Lcom/adapty/internal/utils/MetaInfoRetriever;", "payloadProvider", "Lcom/adapty/internal/utils/PayloadProvider;", "gson", "Lcom/google/gson/Gson;", "apiKey", "", "isObserverMode", "", "(Lcom/adapty/internal/data/cache/CacheRepository;Lcom/adapty/internal/data/cache/ResponseCacheKeyProvider;Lcom/adapty/internal/utils/MetaInfoRetriever;Lcom/adapty/internal/utils/PayloadProvider;Lcom/google/gson/Gson;Ljava/lang/String;Z)V", "apiKeyPrefix", "inappsEndpointPrefix", "profilesEndpointPrefix", "buildRequest", "Lcom/adapty/internal/data/cloud/Request;", "action", "Lkotlin/Function1;", "Lcom/adapty/internal/data/cloud/Request$Builder;", "", "Lkotlin/ExtensionFunctionType;", "createProfileRequest", "customerUserId", "installationMeta", "Lcom/adapty/internal/data/models/InstallationMeta;", "params", "Lcom/adapty/models/AdaptyProfileParameters;", "getAnalyticsConfig", "getEndpointForProfileRequests", "profileId", "getIPv4Request", "getPaywallFallbackRequest", "id", "locale", "getPaywallRequest", "segmentId", "getProductIdsRequest", "getProfileRequest", "getViewConfigurationFallbackRequest", "paywallId", "getViewConfigurationRequest", "variationId", "restorePurchasesRequest", "purchases", "", "Lcom/adapty/internal/data/models/RestoreProductInfo;", "sendAnalyticsEventsRequest", "events", "Lcom/adapty/internal/data/models/AnalyticsEvent;", "setVariationIdRequest", "transactionId", "updateAttributionRequest", "attributionData", "Lcom/adapty/internal/data/models/AttributionData;", "updateProfileRequest", "ipv4Address", "validatePurchaseRequest", "purchase", "Lcom/android/billingclient/api/Purchase;", "product", "Lcom/adapty/internal/domain/models/PurchaseableProduct;", "addDefaultHeaders", "addResponseCacheKeys", "keys", "Lcom/adapty/internal/data/cache/ResponseCacheKeys;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Request.kt */
public final class RequestFactory {
    @Deprecated
    private static final String API_KEY_PREFIX = "Api-Key ";
    @Deprecated
    private static final String AUTHORIZATION_KEY = "Authorization";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String apiKey;
    private final String apiKeyPrefix;
    private final CacheRepository cacheRepository;
    private final Gson gson;
    private final String inappsEndpointPrefix = "in-apps";
    private final boolean isObserverMode;
    private final MetaInfoRetriever metaInfoRetriever;
    private final PayloadProvider payloadProvider;
    private final String profilesEndpointPrefix = "analytics/profiles";
    private final ResponseCacheKeyProvider responseCacheKeyProvider;

    public RequestFactory(CacheRepository cacheRepository2, ResponseCacheKeyProvider responseCacheKeyProvider2, MetaInfoRetriever metaInfoRetriever2, PayloadProvider payloadProvider2, Gson gson2, String str, boolean z) {
        Intrinsics.checkNotNullParameter(cacheRepository2, "cacheRepository");
        Intrinsics.checkNotNullParameter(responseCacheKeyProvider2, "responseCacheKeyProvider");
        Intrinsics.checkNotNullParameter(metaInfoRetriever2, "metaInfoRetriever");
        Intrinsics.checkNotNullParameter(payloadProvider2, "payloadProvider");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        Intrinsics.checkNotNullParameter(str, DynamicLink.Builder.KEY_API_KEY);
        this.cacheRepository = cacheRepository2;
        this.responseCacheKeyProvider = responseCacheKeyProvider2;
        this.metaInfoRetriever = metaInfoRetriever2;
        this.payloadProvider = payloadProvider2;
        this.gson = gson2;
        this.apiKey = str;
        this.isObserverMode = z;
        String str2 = (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null), 0);
        this.apiKeyPrefix = str2 == null ? "" : str2;
    }

    private final String getEndpointForProfileRequests(String str) {
        return this.profilesEndpointPrefix + IOUtils.DIR_SEPARATOR_UNIX + str + IOUtils.DIR_SEPARATOR_UNIX;
    }

    public final /* synthetic */ Request getProfileRequest() {
        String profileId = this.cacheRepository.getProfileId();
        Request.Builder builder = new Request.Builder((Request) null, 1, (DefaultConstructorMarker) null);
        builder.setMethod(Request.Method.GET);
        builder.endPoint = getEndpointForProfileRequests(profileId);
        addResponseCacheKeys(builder, this.responseCacheKeyProvider.forGetProfile());
        builder.currentDataWhenSent = Request.CurrentDataWhenSent.Companion.create(profileId);
        builder.systemLog = AnalyticsEvent.BackendAPIRequestData.GetProfile.Companion.create();
        if (builder.getMethod() != Request.Method.GET) {
            CollectionsKt.addAll(builder.headers, CollectionsKt.listOf(new Request.Header("Content-type", "application/vnd.api+json")));
        }
        addDefaultHeaders(builder);
        return builder.build();
    }

    public final /* synthetic */ Request updateProfileRequest(AdaptyProfileParameters adaptyProfileParameters, InstallationMeta installationMeta, String str) {
        String profileId = this.cacheRepository.getProfileId();
        Request.Builder builder = new Request.Builder((Request) null, 1, (DefaultConstructorMarker) null);
        builder.setMethod(Request.Method.PATCH);
        builder.body = this.gson.toJson((Object) CreateOrUpdateProfileRequest.Companion.create(profileId, installationMeta, adaptyProfileParameters, str));
        builder.endPoint = getEndpointForProfileRequests(profileId);
        addResponseCacheKeys(builder, this.responseCacheKeyProvider.forGetProfile());
        builder.currentDataWhenSent = Request.CurrentDataWhenSent.Companion.create(profileId);
        builder.systemLog = AnalyticsEvent.BackendAPIRequestData.UpdateProfile.Companion.create();
        if (builder.getMethod() != Request.Method.GET) {
            CollectionsKt.addAll(builder.headers, CollectionsKt.listOf(new Request.Header("Content-type", "application/vnd.api+json")));
        }
        addDefaultHeaders(builder);
        return builder.build();
    }

    public final /* synthetic */ Request createProfileRequest(String str, InstallationMeta installationMeta, AdaptyProfileParameters adaptyProfileParameters) {
        Intrinsics.checkNotNullParameter(installationMeta, "installationMeta");
        String profileId = this.cacheRepository.getProfileId();
        Request.Builder builder = new Request.Builder((Request) null, 1, (DefaultConstructorMarker) null);
        builder.setMethod(Request.Method.POST);
        builder.body = this.gson.toJson((Object) CreateOrUpdateProfileRequest.Companion.create(profileId, installationMeta, str, adaptyProfileParameters));
        builder.endPoint = getEndpointForProfileRequests(profileId);
        CharSequence charSequence = str;
        builder.systemLog = AnalyticsEvent.BackendAPIRequestData.CreateProfile.Companion.create(!(charSequence == null || charSequence.length() == 0));
        if (builder.getMethod() != Request.Method.GET) {
            CollectionsKt.addAll(builder.headers, CollectionsKt.listOf(new Request.Header("Content-type", "application/vnd.api+json")));
        }
        addDefaultHeaders(builder);
        return builder.build();
    }

    public final /* synthetic */ Request validatePurchaseRequest(Purchase purchase, PurchaseableProduct purchaseableProduct) {
        Intrinsics.checkNotNullParameter(purchase, FirebaseAnalytics.Event.PURCHASE);
        Intrinsics.checkNotNullParameter(purchaseableProduct, "product");
        String profileId = this.cacheRepository.getProfileId();
        Request.Builder builder = new Request.Builder((Request) null, 1, (DefaultConstructorMarker) null);
        builder.setMethod(Request.Method.POST);
        builder.endPoint = "purchase/play-store/token/v2/validate/";
        builder.body = this.gson.toJson((Object) ValidateReceiptRequest.Companion.create(profileId, purchase, purchaseableProduct));
        builder.currentDataWhenSent = Request.CurrentDataWhenSent.Companion.create(profileId);
        builder.systemLog = AnalyticsEvent.BackendAPIRequestData.Validate.Companion.create(purchaseableProduct, purchase);
        if (builder.getMethod() != Request.Method.GET) {
            CollectionsKt.addAll(builder.headers, CollectionsKt.listOf(new Request.Header("Content-type", "application/vnd.api+json")));
        }
        addDefaultHeaders(builder);
        return builder.build();
    }

    public final /* synthetic */ Request restorePurchasesRequest(List list) {
        Intrinsics.checkNotNullParameter(list, "purchases");
        String profileId = this.cacheRepository.getProfileId();
        String str = null;
        Request.Builder builder = new Request.Builder((Request) null, 1, (DefaultConstructorMarker) null);
        builder.setMethod(Request.Method.POST);
        builder.body = this.gson.toJson((Object) RestoreReceiptRequest.Companion.create(profileId, list));
        builder.endPoint = "purchase/play-store/token/v2/restore/";
        Request.CurrentDataWhenSent.Companion companion = Request.CurrentDataWhenSent.Companion;
        String customerUserId = this.cacheRepository.getCustomerUserId();
        if (customerUserId != null && (true ^ StringsKt.isBlank(customerUserId))) {
            str = customerUserId;
        }
        builder.currentDataWhenSent = companion.create(profileId, str);
        builder.systemLog = AnalyticsEvent.BackendAPIRequestData.Restore.Companion.create(list);
        if (builder.getMethod() != Request.Method.GET) {
            CollectionsKt.addAll(builder.headers, CollectionsKt.listOf(new Request.Header("Content-type", "application/vnd.api+json")));
        }
        addDefaultHeaders(builder);
        return builder.build();
    }

    public final /* synthetic */ Request getPaywallFallbackRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "locale");
        Request.Builder builder = new Request.Builder(new Request("https://fallback.adapty.io/api/v1/sdk/"));
        builder.setMethod(Request.Method.GET);
        String extractLanguageCode = UtilsKt.extractLanguageCode(str2);
        builder.endPoint = this.inappsEndpointPrefix + IOUtils.DIR_SEPARATOR_UNIX + this.apiKeyPrefix + "/paywall/" + str + IOUtils.DIR_SEPARATOR_UNIX + this.metaInfoRetriever.getStore() + IOUtils.DIR_SEPARATOR_UNIX + extractLanguageCode + "/fallback.json";
        builder.systemLog = AnalyticsEvent.BackendAPIRequestData.GetFallbackPaywall.Companion.create(this.apiKeyPrefix, str, extractLanguageCode);
        return builder.build();
    }

    public final /* synthetic */ Request getViewConfigurationFallbackRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "paywallId");
        Intrinsics.checkNotNullParameter(str2, "locale");
        Request.Builder builder = new Request.Builder(new Request("https://fallback.adapty.io/api/v1/sdk/"));
        builder.setMethod(Request.Method.GET);
        String str3 = (String) this.metaInfoRetriever.getAdaptyUiAndBuilderVersion().component2();
        String extractLanguageCode = UtilsKt.extractLanguageCode(str2);
        builder.endPoint = this.inappsEndpointPrefix + IOUtils.DIR_SEPARATOR_UNIX + this.apiKeyPrefix + "/paywall-builder/" + str + IOUtils.DIR_SEPARATOR_UNIX + str3 + IOUtils.DIR_SEPARATOR_UNIX + extractLanguageCode + "/fallback.json";
        builder.systemLog = AnalyticsEvent.BackendAPIRequestData.GetFallbackPaywallBuilder.Companion.create(this.apiKeyPrefix, str, str3, extractLanguageCode);
        return builder.build();
    }

    public final /* synthetic */ Request updateAttributionRequest(AttributionData attributionData) {
        Intrinsics.checkNotNullParameter(attributionData, "attributionData");
        String profileId = this.cacheRepository.getProfileId();
        Request.Builder builder = new Request.Builder((Request) null, 1, (DefaultConstructorMarker) null);
        builder.setMethod(Request.Method.POST);
        builder.endPoint = getEndpointForProfileRequests(profileId) + "attribution/";
        builder.body = this.gson.toJson((Object) UpdateAttributionRequest.Companion.create(attributionData));
        builder.currentDataWhenSent = Request.CurrentDataWhenSent.Companion.create(profileId);
        builder.systemLog = AnalyticsEvent.BackendAPIRequestData.SetAttribution.Companion.create(attributionData);
        if (builder.getMethod() != Request.Method.GET) {
            CollectionsKt.addAll(builder.headers, CollectionsKt.listOf(new Request.Header("Content-type", "application/vnd.api+json")));
        }
        addDefaultHeaders(builder);
        return builder.build();
    }

    public final /* synthetic */ Request getIPv4Request() {
        Request.Builder builder = new Request.Builder(new Request("https://api.ipify.org?format=json"));
        builder.setMethod(Request.Method.GET);
        return builder.build();
    }

    private final Request buildRequest(Function1<? super Request.Builder, Unit> function1) {
        Request.Builder builder = new Request.Builder((Request) null, 1, (DefaultConstructorMarker) null);
        function1.invoke(builder);
        if (builder.getMethod() != Request.Method.GET) {
            CollectionsKt.addAll(builder.headers, CollectionsKt.listOf(new Request.Header("Content-type", "application/vnd.api+json")));
        }
        addDefaultHeaders(builder);
        return builder.build();
    }

    private final void addDefaultHeaders(Request.Builder builder) {
        Set set;
        Set ofNotNull = SetsKt.setOfNotNull((T[]) new Request.Header[]{new Request.Header(HttpHeaders.ACCEPT_ENCODING, "gzip"), new Request.Header("adapty-sdk-profile-id", this.cacheRepository.getProfileId()), new Request.Header("adapty-sdk-platform", AndroidContextProvider.PLATFORM), new Request.Header("adapty-sdk-version", BuildConfig.VERSION_NAME), new Request.Header("adapty-sdk-session", this.cacheRepository.getSessionId()), new Request.Header("adapty-sdk-device-id", this.metaInfoRetriever.getInstallationMetaId()), new Request.Header("adapty-sdk-observer-mode-enabled", String.valueOf(this.isObserverMode)), new Request.Header("adapty-sdk-android-billing-new", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE), new Request.Header("adapty-sdk-store", this.metaInfoRetriever.getStore()), new Request.Header("Authorization", API_KEY_PREFIX + this.apiKey), new Request.Header("adapty-app-version", (String) this.metaInfoRetriever.getAppBuildAndVersion().component2())});
        Pair crossplatformNameAndVersion = this.metaInfoRetriever.getCrossplatformNameAndVersion();
        if (crossplatformNameAndVersion != null) {
            set = SetsKt.setOf(new Request.Header("adapty-sdk-crossplatform-name", (String) crossplatformNameAndVersion.component1()), new Request.Header("adapty-sdk-crossplatform-version", (String) crossplatformNameAndVersion.component2()));
        } else {
            set = null;
        }
        CollectionsKt.addAll(builder.headers, ofNotNull);
        if (set != null) {
            CollectionsKt.addAll(builder.headers, set);
        }
    }

    private final void addResponseCacheKeys(Request.Builder builder, ResponseCacheKeys responseCacheKeys) {
        builder.responseCacheKeys = responseCacheKeys;
        Collection collection = builder.headers;
        String string$adapty_release = this.cacheRepository.getString$adapty_release(responseCacheKeys.getResponseHashKey());
        CollectionsKt.addAll(collection, SetsKt.setOfNotNull(string$adapty_release != null ? new Request.Header("adapty-sdk-previous-response-hash", string$adapty_release) : null));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/adapty/internal/data/cloud/RequestFactory$Companion;", "", "()V", "API_KEY_PREFIX", "", "AUTHORIZATION_KEY", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Request.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final /* synthetic */ Request getProductIdsRequest() {
        Request.Builder builder = new Request.Builder((Request) null, 1, (DefaultConstructorMarker) null);
        builder.setMethod(Request.Method.GET);
        builder.endPoint = this.inappsEndpointPrefix + IOUtils.DIR_SEPARATOR_UNIX + this.apiKeyPrefix + "/products-ids/" + this.metaInfoRetriever.getStore() + IOUtils.DIR_SEPARATOR_UNIX;
        addResponseCacheKeys(builder, this.responseCacheKeyProvider.forGetProductIds());
        builder.systemLog = AnalyticsEvent.BackendAPIRequestData.GetProductIds.Companion.create();
        if (builder.getMethod() != Request.Method.GET) {
            CollectionsKt.addAll(builder.headers, CollectionsKt.listOf(new Request.Header("Content-type", "application/vnd.api+json")));
        }
        addDefaultHeaders(builder);
        return builder.build();
    }

    public final /* synthetic */ Request getPaywallRequest(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "locale");
        Intrinsics.checkNotNullParameter(str3, "segmentId");
        Request.Builder builder = new Request.Builder((Request) null, 1, (DefaultConstructorMarker) null);
        builder.setMethod(Request.Method.GET);
        String payloadHashForPaywallRequest = this.payloadProvider.getPayloadHashForPaywallRequest(str2, str3);
        builder.endPoint = this.inappsEndpointPrefix + IOUtils.DIR_SEPARATOR_UNIX + this.apiKeyPrefix + "/paywall/" + str + IOUtils.DIR_SEPARATOR_UNIX + payloadHashForPaywallRequest + IOUtils.DIR_SEPARATOR_UNIX;
        CollectionsKt.addAll(builder.headers, CollectionsKt.listOf(new Request.Header("adapty-paywall-locale", str2)));
        builder.systemLog = AnalyticsEvent.BackendAPIRequestData.GetPaywall.Companion.create(this.apiKeyPrefix, str, str2, str3, payloadHashForPaywallRequest);
        if (builder.getMethod() != Request.Method.GET) {
            CollectionsKt.addAll(builder.headers, CollectionsKt.listOf(new Request.Header("Content-type", "application/vnd.api+json")));
        }
        addDefaultHeaders(builder);
        return builder.build();
    }

    public final /* synthetic */ Request getViewConfigurationRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "variationId");
        Intrinsics.checkNotNullParameter(str2, "locale");
        Request.Builder builder = new Request.Builder((Request) null, 1, (DefaultConstructorMarker) null);
        builder.setMethod(Request.Method.GET);
        Pair adaptyUiAndBuilderVersion = this.metaInfoRetriever.getAdaptyUiAndBuilderVersion();
        String str3 = (String) adaptyUiAndBuilderVersion.component2();
        builder.endPoint = this.inappsEndpointPrefix + IOUtils.DIR_SEPARATOR_UNIX + this.apiKeyPrefix + "/paywall-builder/" + str + IOUtils.DIR_SEPARATOR_UNIX + this.payloadProvider.getPayloadHashForPaywallBuilderRequest(str2, str3) + IOUtils.DIR_SEPARATOR_UNIX;
        CollectionsKt.addAll(builder.headers, CollectionsKt.listOf(new Request.Header("adapty-paywall-builder-locale", str2), new Request.Header("adapty-paywall-builder-version", str3), new Request.Header("adapty-ui-version", (String) adaptyUiAndBuilderVersion.component1())));
        builder.systemLog = AnalyticsEvent.BackendAPIRequestData.GetPaywallBuilder.Companion.create(str);
        if (builder.getMethod() != Request.Method.GET) {
            CollectionsKt.addAll(builder.headers, CollectionsKt.listOf(new Request.Header("Content-type", "application/vnd.api+json")));
        }
        addDefaultHeaders(builder);
        return builder.build();
    }

    public final /* synthetic */ Request setVariationIdRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "transactionId");
        Intrinsics.checkNotNullParameter(str2, "variationId");
        Request.Builder builder = new Request.Builder((Request) null, 1, (DefaultConstructorMarker) null);
        builder.setMethod(Request.Method.POST);
        builder.endPoint = this.inappsEndpointPrefix + "/transaction-variation-id/";
        builder.body = this.gson.toJson((Object) SetVariationIdRequest.Companion.create(str, str2));
        builder.systemLog = AnalyticsEvent.BackendAPIRequestData.SetVariationId.Companion.create(str, str2);
        if (builder.getMethod() != Request.Method.GET) {
            CollectionsKt.addAll(builder.headers, CollectionsKt.listOf(new Request.Header("Content-type", "application/vnd.api+json")));
        }
        addDefaultHeaders(builder);
        return builder.build();
    }

    public final /* synthetic */ Request sendAnalyticsEventsRequest(List list) {
        Intrinsics.checkNotNullParameter(list, "events");
        Request.Builder builder = new Request.Builder((Request) null, 1, (DefaultConstructorMarker) null);
        builder.setMethod(Request.Method.POST);
        builder.endPoint = "events/";
        builder.body = this.gson.toJson((Object) SendEventRequest.Companion.create(list));
        if (builder.getMethod() != Request.Method.GET) {
            CollectionsKt.addAll(builder.headers, CollectionsKt.listOf(new Request.Header("Content-type", "application/vnd.api+json")));
        }
        addDefaultHeaders(builder);
        return builder.build();
    }

    public final /* synthetic */ Request getAnalyticsConfig() {
        Request.Builder builder = new Request.Builder((Request) null, 1, (DefaultConstructorMarker) null);
        builder.setMethod(Request.Method.GET);
        builder.endPoint = "events/blacklist/";
        builder.systemLog = AnalyticsEvent.BackendAPIRequestData.GetAnalyticsConfig.Companion.create();
        if (builder.getMethod() != Request.Method.GET) {
            CollectionsKt.addAll(builder.headers, CollectionsKt.listOf(new Request.Header("Content-type", "application/vnd.api+json")));
        }
        addDefaultHeaders(builder);
        return builder.build();
    }
}
