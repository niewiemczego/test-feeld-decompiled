package com.adapty.internal.crossplatform;

import com.adapty.errors.AdaptyError;
import com.adapty.models.AdaptyEligibility;
import com.adapty.models.AdaptyPaywall;
import com.adapty.models.AdaptyPeriodUnit;
import com.adapty.models.AdaptyProductDiscountPhase;
import com.adapty.models.AdaptyProductSubscriptionDetails;
import com.adapty.models.AdaptyPurchasedInfo;
import com.adapty.models.AdaptySubscriptionUpdateParameters;
import com.adapty.utils.ImmutableList;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SerializationHelper.kt */
final class SerializationHelper$gson$2 extends Lambda implements Function0<Gson> {
    public static final SerializationHelper$gson$2 INSTANCE = new SerializationHelper$gson$2();

    SerializationHelper$gson$2() {
        super(0);
    }

    public final Gson invoke() {
        GsonBuilder registerTypeAdapterFactory;
        GsonBuilder registerTypeAdapter = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setFieldNamingStrategy(new SerializationFieldNamingStrategy()).addSerializationExclusionStrategy(new SerializationExclusionStrategy()).registerTypeAdapterFactory(new AdaptyPaywallProductTypeAdapterFactory()).registerTypeAdapterFactory(new AdaptyProfileTypeAdapterFactory()).registerTypeAdapterFactory(new AdaptyProductSubscriptionDetailsTypeAdapterFactory()).registerTypeAdapterFactory(new AdaptyImmutableMapTypeAdapterFactory()).registerTypeAdapterFactory(new AdaptyPaywallTypeAdapterFactory()).registerTypeAdapterFactory(new AdaptyResultTypeAdapterFactory()).registerTypeAdapterFactory(new AdaptyViewConfigActionTypeAdapterFactory()).registerTypeAdapterFactory(new AdaptyViewConfigTransitionTypeAdapterFactory()).registerTypeAdapterFactory(new AdaptyViewConfigBulletTypeAdapterFactory()).registerTypeAdapterFactory(new AdaptyViewConfigTextItemTypeAdapterFactory()).registerTypeAdapterFactory(new AdaptyViewConfigComponentTypeAdapterFactory()).registerTypeAdapterFactory(new AdaptyViewConfigShapeTypeTypeAdapterFactory()).registerTypeAdapterFactory(new AdaptyViewConfigCornerRadiusTypeAdapterFactory()).registerTypeAdapterFactory(new AdaptyViewConfigAssetTypeAdapterFactory()).registerTypeAdapterFactory(new AdaptyProductTypeTypeAdapterFactory()).registerTypeAdapter(AdaptyPeriodUnit.class, new AdaptyPeriodUnitSerializer()).registerTypeAdapter(AdaptyProductDiscountPhase.PaymentMode.class, new AdaptyPaymentModeSerializer()).registerTypeAdapter(AdaptyEligibility.class, new AdaptyEligibilityAdapter()).registerTypeAdapter(AdaptyProductSubscriptionDetails.RenewalType.class, new AdaptyRenewalTypeAdapter()).registerTypeAdapter(AdaptyPaywall.FetchPolicy.class, new AdaptyPaywallFetchPolicyDeserializer()).registerTypeAdapter(AdaptyPurchasedInfo.class, new AdaptyPurchasedInfoSerializer()).registerTypeAdapter(AdaptySubscriptionUpdateParameters.class, new AdaptySubscriptionUpdateParametersDeserializer()).registerTypeAdapter(AdaptySubscriptionUpdateParameters.ReplacementMode.class, new AdaptyReplacementModeDeserializer()).registerTypeAdapter(ImmutableList.class, new AdaptyImmutableListSerializer()).registerTypeAdapter(AdaptyError.class, new AdaptyErrorSerializer());
        try {
            if (!(UtilsKt.getClassForNameOrNull("com.adapty.ui.AdaptyUI") == null || (registerTypeAdapterFactory = registerTypeAdapter.registerTypeAdapterFactory(new AdaptyUIActionTypeAdapterFactory())) == null)) {
                registerTypeAdapter = registerTypeAdapterFactory;
            }
        } catch (Throwable unused) {
        }
        return registerTypeAdapter.create();
    }
}
