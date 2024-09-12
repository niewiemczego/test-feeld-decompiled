package com.adapty.internal.data.cloud;

import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.internal.data.cloud.Response;
import com.adapty.internal.data.models.AttributionData;
import com.adapty.internal.data.models.IP;
import com.adapty.internal.data.models.InstallationMeta;
import com.adapty.internal.data.models.PaywallDto;
import com.adapty.internal.data.models.ProfileDto;
import com.adapty.internal.data.models.RemoteConfigDto;
import com.adapty.internal.data.models.ValidationResult;
import com.adapty.internal.data.models.ViewConfigurationDto;
import com.adapty.internal.domain.models.PurchaseableProduct;
import com.adapty.internal.utils.UtilsKt;
import com.adapty.models.AdaptyProfileParameters;
import com.android.billingclient.api.Purchase;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bJ\u0016\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bJ\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019J\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bJ\u0016\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bJ\u0014\u0010\"\u001a\u00020#2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030%H\u0002J\"\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0019J\u0016\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bJ\u001c\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b2\u0006\u0010,\u001a\u00020-J8\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000bJ$\u00100\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/adapty/internal/data/cloud/CloudRepository;", "", "httpClient", "Lcom/adapty/internal/data/cloud/HttpClient;", "requestFactory", "Lcom/adapty/internal/data/cloud/RequestFactory;", "(Lcom/adapty/internal/data/cloud/HttpClient;Lcom/adapty/internal/data/cloud/RequestFactory;)V", "createProfile", "Lkotlinx/coroutines/flow/Flow;", "Lcom/adapty/internal/data/models/ProfileDto;", "customerUserId", "", "installationMeta", "Lcom/adapty/internal/data/models/InstallationMeta;", "params", "Lcom/adapty/models/AdaptyProfileParameters;", "getIPv4Request", "Lcom/adapty/internal/data/models/IP;", "getPaywall", "Lcom/adapty/internal/data/models/PaywallDto;", "id", "locale", "segmentId", "getPaywallFallback", "getProductIds", "", "getProfile", "Lkotlin/Pair;", "Lcom/adapty/internal/data/cloud/Request$CurrentDataWhenSent;", "getViewConfiguration", "Lcom/adapty/internal/data/models/ViewConfigurationDto;", "variationId", "getViewConfigurationFallback", "paywallId", "processEmptyResponse", "", "response", "Lcom/adapty/internal/data/cloud/Response;", "restorePurchases", "purchases", "Lcom/adapty/internal/data/models/RestoreProductInfo;", "setVariationId", "transactionId", "updateAttribution", "attributionData", "Lcom/adapty/internal/data/models/AttributionData;", "updateProfile", "ipv4Address", "validatePurchase", "purchase", "Lcom/android/billingclient/api/Purchase;", "product", "Lcom/adapty/internal/domain/models/PurchaseableProduct;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CloudRepository.kt */
public final class CloudRepository {
    /* access modifiers changed from: private */
    public final HttpClient httpClient;
    /* access modifiers changed from: private */
    public final RequestFactory requestFactory;

    public CloudRepository(HttpClient httpClient2, RequestFactory requestFactory2) {
        Intrinsics.checkNotNullParameter(httpClient2, "httpClient");
        Intrinsics.checkNotNullParameter(requestFactory2, "requestFactory");
        this.httpClient = httpClient2;
        this.requestFactory = requestFactory2;
    }

    public final /* synthetic */ Pair getProfile() {
        Request profileRequest = this.requestFactory.getProfileRequest();
        Response newCall = this.httpClient.newCall(profileRequest, ProfileDto.class);
        if (newCall instanceof Response.Success) {
            return TuplesKt.to(((Response.Success) newCall).getBody(), profileRequest.currentDataWhenSent);
        }
        if (newCall instanceof Response.Error) {
            throw ((Response.Error) newCall).getError();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final /* synthetic */ List getProductIds() {
        HttpClient httpClient2 = this.httpClient;
        Request productIdsRequest = this.requestFactory.getProductIdsRequest();
        Type type = new CloudRepository$getProductIds$response$1().getType();
        Intrinsics.checkNotNullExpressionValue(type, "object : TypeToken<ArrayList<String>>() {}.type");
        Response newCall = httpClient2.newCall(productIdsRequest, type);
        if (newCall instanceof Response.Success) {
            return (List) ((Response.Success) newCall).getBody();
        }
        if (newCall instanceof Response.Error) {
            throw ((Response.Error) newCall).getError();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final /* synthetic */ PaywallDto getPaywall(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str4, "id");
        Intrinsics.checkNotNullParameter(str5, "locale");
        Intrinsics.checkNotNullParameter(str6, "segmentId");
        Response newCall = this.httpClient.newCall(this.requestFactory.getPaywallRequest(str4, str5, str6), PaywallDto.class);
        if (newCall instanceof Response.Success) {
            Response.Success success = (Response.Success) newCall;
            Object body = success.getBody();
            if (!(((PaywallDto) body).getRemoteConfig() != null)) {
                body = null;
            }
            PaywallDto paywallDto = (PaywallDto) body;
            return paywallDto == null ? PaywallDto.copy$default((PaywallDto) success.getBody(), (String) null, (String) null, (Long) null, (String) null, (Integer) null, (String) null, (String) null, (ArrayList) null, new RemoteConfigDto(str5, (String) null), (Boolean) null, 767, (Object) null) : paywallDto;
        } else if (newCall instanceof Response.Error) {
            throw ((Response.Error) newCall).getError();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final /* synthetic */ PaywallDto getPaywallFallback(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str3, "id");
        Intrinsics.checkNotNullParameter(str4, "locale");
        Response newCall = this.httpClient.newCall(this.requestFactory.getPaywallFallbackRequest(str3, str4), PaywallDto.class);
        if (newCall instanceof Response.Success) {
            Response.Success success = (Response.Success) newCall;
            Object body = success.getBody();
            if (!(((PaywallDto) body).getRemoteConfig() != null)) {
                body = null;
            }
            PaywallDto paywallDto = (PaywallDto) body;
            return paywallDto == null ? PaywallDto.copy$default((PaywallDto) success.getBody(), (String) null, (String) null, (Long) null, (String) null, (Integer) null, (String) null, (String) null, (ArrayList) null, new RemoteConfigDto(str4, (String) null), (Boolean) null, 767, (Object) null) : paywallDto;
        } else if (newCall instanceof Response.Error) {
            Response.Error error = (Response.Error) newCall;
            if (error.getError().getAdaptyErrorCode() == AdaptyErrorCode.BAD_REQUEST && !Intrinsics.areEqual((Object) str4, (Object) UtilsKt.DEFAULT_PAYWALL_LOCALE)) {
                return getPaywallFallback(str3, UtilsKt.DEFAULT_PAYWALL_LOCALE);
            }
            throw error.getError();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final /* synthetic */ ViewConfigurationDto getViewConfiguration(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "variationId");
        Intrinsics.checkNotNullParameter(str2, "locale");
        Response newCall = this.httpClient.newCall(this.requestFactory.getViewConfigurationRequest(str, str2), ViewConfigurationDto.class);
        if (newCall instanceof Response.Success) {
            return (ViewConfigurationDto) ((Response.Success) newCall).getBody();
        }
        if (newCall instanceof Response.Error) {
            throw ((Response.Error) newCall).getError();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final /* synthetic */ ViewConfigurationDto getViewConfigurationFallback(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "paywallId");
        Intrinsics.checkNotNullParameter(str2, "locale");
        Response newCall = this.httpClient.newCall(this.requestFactory.getViewConfigurationFallbackRequest(str, str2), ViewConfigurationDto.class);
        if (newCall instanceof Response.Success) {
            return (ViewConfigurationDto) ((Response.Success) newCall).getBody();
        }
        if (newCall instanceof Response.Error) {
            Response.Error error = (Response.Error) newCall;
            if (error.getError().getAdaptyErrorCode() == AdaptyErrorCode.BAD_REQUEST && !Intrinsics.areEqual((Object) str2, (Object) UtilsKt.DEFAULT_PAYWALL_LOCALE)) {
                return getViewConfigurationFallback(str, UtilsKt.DEFAULT_PAYWALL_LOCALE);
            }
            throw error.getError();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final /* synthetic */ Flow createProfile(String str, InstallationMeta installationMeta, AdaptyProfileParameters adaptyProfileParameters) {
        Intrinsics.checkNotNullParameter(installationMeta, "installationMeta");
        return FlowKt.flow(new CloudRepository$createProfile$1(this, str, installationMeta, adaptyProfileParameters, (Continuation<? super CloudRepository$createProfile$1>) null));
    }

    public final /* synthetic */ Pair validatePurchase(Purchase purchase, PurchaseableProduct purchaseableProduct) {
        Intrinsics.checkNotNullParameter(purchase, FirebaseAnalytics.Event.PURCHASE);
        Intrinsics.checkNotNullParameter(purchaseableProduct, "product");
        Request validatePurchaseRequest = this.requestFactory.validatePurchaseRequest(purchase, purchaseableProduct);
        Response newCall = this.httpClient.newCall(validatePurchaseRequest, ValidationResult.class);
        if (newCall instanceof Response.Success) {
            ValidationResult validationResult = (ValidationResult) ((Response.Success) newCall).getBody();
            ValidationResult.SideError sideError = (ValidationResult.SideError) CollectionsKt.firstOrNull(validationResult.getErrors());
            if (sideError == null) {
                return TuplesKt.to(validationResult.getProfile(), validatePurchaseRequest.currentDataWhenSent);
            }
            String message = sideError.getMessage();
            if (message == null) {
                message = "";
            }
            throw new AdaptyError((Throwable) null, message, AdaptyErrorCode.BAD_REQUEST, 1, (DefaultConstructorMarker) null);
        } else if (newCall instanceof Response.Error) {
            throw ((Response.Error) newCall).getError();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final /* synthetic */ Pair restorePurchases(List list) {
        Intrinsics.checkNotNullParameter(list, "purchases");
        Request restorePurchasesRequest = this.requestFactory.restorePurchasesRequest(list);
        Response newCall = this.httpClient.newCall(restorePurchasesRequest, ProfileDto.class);
        if (newCall instanceof Response.Success) {
            return TuplesKt.to(((Response.Success) newCall).getBody(), restorePurchasesRequest.currentDataWhenSent);
        }
        if (newCall instanceof Response.Error) {
            throw ((Response.Error) newCall).getError();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Pair updateProfile$default(CloudRepository cloudRepository, AdaptyProfileParameters adaptyProfileParameters, InstallationMeta installationMeta, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            adaptyProfileParameters = null;
        }
        if ((i & 2) != 0) {
            installationMeta = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        return cloudRepository.updateProfile(adaptyProfileParameters, installationMeta, str);
    }

    public final /* synthetic */ Pair updateProfile(AdaptyProfileParameters adaptyProfileParameters, InstallationMeta installationMeta, String str) {
        Request updateProfileRequest = this.requestFactory.updateProfileRequest(adaptyProfileParameters, installationMeta, str);
        Response newCall = this.httpClient.newCall(updateProfileRequest, ProfileDto.class);
        if (newCall instanceof Response.Success) {
            return TuplesKt.to(((Response.Success) newCall).getBody(), updateProfileRequest.currentDataWhenSent);
        }
        if (newCall instanceof Response.Error) {
            throw ((Response.Error) newCall).getError();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final /* synthetic */ Pair updateAttribution(AttributionData attributionData) {
        Intrinsics.checkNotNullParameter(attributionData, "attributionData");
        Request updateAttributionRequest = this.requestFactory.updateAttributionRequest(attributionData);
        Response newCall = this.httpClient.newCall(updateAttributionRequest, ProfileDto.class);
        if (newCall instanceof Response.Success) {
            return TuplesKt.to(((Response.Success) newCall).getBody(), updateAttributionRequest.currentDataWhenSent);
        }
        if (newCall instanceof Response.Error) {
            throw ((Response.Error) newCall).getError();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final /* synthetic */ void setVariationId(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "transactionId");
        Intrinsics.checkNotNullParameter(str2, "variationId");
        processEmptyResponse(this.httpClient.newCall(this.requestFactory.setVariationIdRequest(str, str2), Object.class));
    }

    public final /* synthetic */ IP getIPv4Request() {
        Response newCall = this.httpClient.newCall(this.requestFactory.getIPv4Request(), IP.class);
        if (newCall instanceof Response.Success) {
            return (IP) ((Response.Success) newCall).getBody();
        }
        if (newCall instanceof Response.Error) {
            throw ((Response.Error) newCall).getError();
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void processEmptyResponse(Response<?> response) {
        if (!(response instanceof Response.Success)) {
            if (response instanceof Response.Error) {
                throw ((Response.Error) response).getError();
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
