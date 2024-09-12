package com.adapty.internal.di;

import com.adapty.internal.crossplatform.AdaptyPaywallTypeAdapterFactory;
import com.adapty.internal.data.cache.CacheEntityTypeAdapterFactory;
import com.adapty.internal.data.cloud.AdaptyResponseTypeAdapterFactory;
import com.adapty.internal.data.cloud.CreateOrUpdateProfileRequestTypeAdapterFactory;
import com.adapty.internal.data.cloud.SendEventRequestSerializer;
import com.adapty.internal.data.models.AnalyticsConfig;
import com.adapty.internal.data.models.AnalyticsData;
import com.adapty.internal.data.models.AnalyticsEvent;
import com.adapty.internal.data.models.FallbackPaywalls;
import com.adapty.internal.data.models.PaywallDto;
import com.adapty.internal.data.models.ProductDto;
import com.adapty.internal.data.models.ProfileDto;
import com.adapty.internal.data.models.ValidationResult;
import com.adapty.internal.data.models.ViewConfigurationDto;
import com.adapty.internal.data.models.requests.SendEventRequest;
import com.adapty.internal.utils.AnalyticsDataTypeAdapter;
import com.adapty.internal.utils.AnalyticsEventTypeAdapter;
import com.adapty.internal.utils.BigDecimalDeserializer;
import com.google.android.gms.common.Scopes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import io.sentry.Session;
import io.sentry.protocol.Mechanism;
import java.math.BigDecimal;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$1 extends Lambda implements Function0<Gson> {
    public static final Dependencies$init$1 INSTANCE = new Dependencies$init$1();

    Dependencies$init$1() {
        super(0);
    }

    public final Gson invoke() {
        Dependencies$init$1$$ExternalSyntheticLambda0 dependencies$init$1$$ExternalSyntheticLambda0 = new Dependencies$init$1$$ExternalSyntheticLambda0("data", "attributes");
        Dependencies$init$1$$ExternalSyntheticLambda1 dependencies$init$1$$ExternalSyntheticLambda1 = new Dependencies$init$1$$ExternalSyntheticLambda1("data");
        Dependencies$init$1$$ExternalSyntheticLambda2 dependencies$init$1$$ExternalSyntheticLambda2 = new Dependencies$init$1$$ExternalSyntheticLambda2("data");
        Dependencies$init$1$$ExternalSyntheticLambda3 dependencies$init$1$$ExternalSyntheticLambda3 = new Dependencies$init$1$$ExternalSyntheticLambda3("data", Mechanism.JsonKeys.META, AdaptyPaywallTypeAdapterFactory.PRODUCTS, "version", "attributes", "paywalls");
        Dependencies$init$1$$ExternalSyntheticLambda4 dependencies$init$1$$ExternalSyntheticLambda4 = new Dependencies$init$1$$ExternalSyntheticLambda4("data", "attributes", Session.JsonKeys.ERRORS, Scopes.PROFILE);
        GsonBuilder gsonBuilder = new GsonBuilder();
        TypeToken<PaywallDto> typeToken = TypeToken.get(PaywallDto.class);
        Intrinsics.checkNotNullExpressionValue(typeToken, "get(PaywallDto::class.java)");
        GsonBuilder registerTypeAdapterFactory = gsonBuilder.registerTypeAdapterFactory(new AdaptyResponseTypeAdapterFactory(typeToken, dependencies$init$1$$ExternalSyntheticLambda0));
        TypeToken<ViewConfigurationDto> typeToken2 = TypeToken.get(ViewConfigurationDto.class);
        Intrinsics.checkNotNullExpressionValue(typeToken2, "get(ViewConfigurationDto::class.java)");
        GsonBuilder registerTypeAdapterFactory2 = registerTypeAdapterFactory.registerTypeAdapterFactory(new AdaptyResponseTypeAdapterFactory(typeToken2, dependencies$init$1$$ExternalSyntheticLambda2));
        TypeToken<AnalyticsConfig> typeToken3 = TypeToken.get(AnalyticsConfig.class);
        Intrinsics.checkNotNullExpressionValue(typeToken3, "get(AnalyticsConfig::class.java)");
        GsonBuilder registerTypeAdapterFactory3 = registerTypeAdapterFactory2.registerTypeAdapterFactory(new AdaptyResponseTypeAdapterFactory(typeToken3, dependencies$init$1$$ExternalSyntheticLambda2));
        TypeToken<ProfileDto> typeToken4 = TypeToken.get(ProfileDto.class);
        Intrinsics.checkNotNullExpressionValue(typeToken4, "get(ProfileDto::class.java)");
        GsonBuilder registerTypeAdapterFactory4 = registerTypeAdapterFactory3.registerTypeAdapterFactory(new AdaptyResponseTypeAdapterFactory(typeToken4, dependencies$init$1$$ExternalSyntheticLambda0)).registerTypeAdapterFactory(new AdaptyResponseTypeAdapterFactory(new TypeToken<ArrayList<ProductDto>>() {
        }, dependencies$init$1$$ExternalSyntheticLambda1)).registerTypeAdapterFactory(new AdaptyResponseTypeAdapterFactory(new TypeToken<ArrayList<String>>() {
        }, dependencies$init$1$$ExternalSyntheticLambda1));
        TypeToken<FallbackPaywalls> typeToken5 = TypeToken.get(FallbackPaywalls.class);
        Intrinsics.checkNotNullExpressionValue(typeToken5, "get(FallbackPaywalls::class.java)");
        GsonBuilder registerTypeAdapterFactory5 = registerTypeAdapterFactory4.registerTypeAdapterFactory(new AdaptyResponseTypeAdapterFactory(typeToken5, dependencies$init$1$$ExternalSyntheticLambda3));
        TypeToken<ValidationResult> typeToken6 = TypeToken.get(ValidationResult.class);
        Intrinsics.checkNotNullExpressionValue(typeToken6, "get(ValidationResult::class.java)");
        return registerTypeAdapterFactory5.registerTypeAdapterFactory(new AdaptyResponseTypeAdapterFactory(typeToken6, dependencies$init$1$$ExternalSyntheticLambda4)).registerTypeAdapterFactory(new CacheEntityTypeAdapterFactory()).registerTypeAdapterFactory(new CreateOrUpdateProfileRequestTypeAdapterFactory()).registerTypeAdapter(SendEventRequest.class, new SendEventRequestSerializer()).registerTypeAdapter(AnalyticsEvent.class, new AnalyticsEventTypeAdapter()).registerTypeAdapter(AnalyticsData.class, new AnalyticsDataTypeAdapter()).registerTypeAdapter(BigDecimal.class, new BigDecimalDeserializer()).create();
    }

    /* access modifiers changed from: private */
    public static final JsonElement invoke$lambda$0(String str, String str2, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(str, "$dataKey");
        Intrinsics.checkNotNullParameter(str2, "$attributesKey");
        Intrinsics.checkNotNullParameter(jsonElement, "jsonElement");
        JsonObject jsonObject = null;
        JsonObject jsonObject2 = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
        JsonElement jsonElement2 = jsonObject2 != null ? jsonObject2.get(str) : null;
        JsonObject jsonObject3 = jsonElement2 instanceof JsonObject ? (JsonObject) jsonElement2 : null;
        JsonElement jsonElement3 = jsonObject3 != null ? jsonObject3.get(str2) : null;
        if (jsonElement3 instanceof JsonObject) {
            jsonObject = (JsonObject) jsonElement3;
        }
        return jsonObject;
    }

    /* access modifiers changed from: private */
    public static final JsonElement invoke$lambda$1(String str, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(str, "$dataKey");
        Intrinsics.checkNotNullParameter(jsonElement, "jsonElement");
        JsonArray jsonArray = null;
        JsonObject jsonObject = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
        JsonElement jsonElement2 = jsonObject != null ? jsonObject.get(str) : null;
        if (jsonElement2 instanceof JsonArray) {
            jsonArray = (JsonArray) jsonElement2;
        }
        return jsonArray;
    }

    /* access modifiers changed from: private */
    public static final JsonElement invoke$lambda$2(String str, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(str, "$dataKey");
        Intrinsics.checkNotNullParameter(jsonElement, "jsonElement");
        JsonObject jsonObject = null;
        JsonObject jsonObject2 = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
        JsonElement jsonElement2 = jsonObject2 != null ? jsonObject2.get(str) : null;
        if (jsonElement2 instanceof JsonObject) {
            jsonObject = (JsonObject) jsonElement2;
        }
        return jsonObject;
    }

    /* access modifiers changed from: private */
    public static final JsonElement invoke$lambda$5(String str, String str2, String str3, String str4, String str5, String str6, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(str, "$dataKey");
        Intrinsics.checkNotNullParameter(str2, "$metaKey");
        Intrinsics.checkNotNullParameter(str3, "$productsKey");
        Intrinsics.checkNotNullParameter(str4, "$versionKey");
        Intrinsics.checkNotNullParameter(str5, "$attributesKey");
        Intrinsics.checkNotNullParameter(str6, "$paywallsKey");
        Intrinsics.checkNotNullParameter(jsonElement, "jsonElement");
        JsonArray jsonArray = new JsonArray();
        boolean z = jsonElement instanceof JsonObject;
        JsonPrimitive jsonPrimitive = null;
        JsonObject jsonObject = z ? (JsonObject) jsonElement : null;
        JsonElement jsonElement2 = jsonObject != null ? jsonObject.get(str) : null;
        JsonArray<JsonElement> jsonArray2 = jsonElement2 instanceof JsonArray ? (JsonArray) jsonElement2 : null;
        if (jsonArray2 != null) {
            for (JsonElement jsonElement3 : jsonArray2) {
                JsonObject jsonObject2 = jsonElement3 instanceof JsonObject ? (JsonObject) jsonElement3 : null;
                JsonElement jsonElement4 = jsonObject2 != null ? jsonObject2.get(str5) : null;
                JsonObject jsonObject3 = jsonElement4 instanceof JsonObject ? (JsonObject) jsonElement4 : null;
                if (jsonObject3 != null) {
                    jsonArray.add((JsonElement) jsonObject3);
                }
            }
        }
        JsonObject jsonObject4 = z ? (JsonObject) jsonElement : null;
        JsonElement jsonElement5 = jsonObject4 != null ? jsonObject4.get(str2) : null;
        JsonObject jsonObject5 = jsonElement5 instanceof JsonObject ? (JsonObject) jsonElement5 : null;
        JsonElement jsonElement6 = jsonObject5 != null ? jsonObject5.get(str3) : null;
        JsonArray jsonArray3 = jsonElement6 instanceof JsonArray ? (JsonArray) jsonElement6 : null;
        if (jsonArray3 == null) {
            jsonArray3 = new JsonArray();
        }
        JsonElement jsonElement7 = jsonObject5 != null ? jsonObject5.get(str4) : null;
        if (jsonElement7 instanceof JsonPrimitive) {
            jsonPrimitive = (JsonPrimitive) jsonElement7;
        }
        if (jsonPrimitive == null) {
            jsonPrimitive = new JsonPrimitive((Number) 0);
        }
        JsonObject jsonObject6 = new JsonObject();
        jsonObject6.add(str6, jsonArray);
        jsonObject6.add(str3, jsonArray3);
        jsonObject6.add(str4, jsonPrimitive);
        return jsonObject6;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.google.gson.JsonArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.gson.JsonArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.google.gson.JsonArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.google.gson.JsonArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.google.gson.JsonArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.google.gson.JsonArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.google.gson.JsonArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.gson.JsonArray} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.google.gson.JsonElement invoke$lambda$8(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, com.google.gson.JsonElement r6) {
        /*
            java.lang.String r0 = "$dataKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "$attributesKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "$errorsKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "$profileKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "jsonElement"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = r6 instanceof com.google.gson.JsonObject
            r1 = 0
            if (r0 == 0) goto L_0x0021
            com.google.gson.JsonObject r6 = (com.google.gson.JsonObject) r6
            goto L_0x0022
        L_0x0021:
            r6 = r1
        L_0x0022:
            if (r6 == 0) goto L_0x0029
            com.google.gson.JsonElement r2 = r6.get(r2)
            goto L_0x002a
        L_0x0029:
            r2 = r1
        L_0x002a:
            boolean r6 = r2 instanceof com.google.gson.JsonObject
            if (r6 == 0) goto L_0x0031
            com.google.gson.JsonObject r2 = (com.google.gson.JsonObject) r2
            goto L_0x0032
        L_0x0031:
            r2 = r1
        L_0x0032:
            if (r2 == 0) goto L_0x0039
            com.google.gson.JsonElement r2 = r2.get(r3)
            goto L_0x003a
        L_0x0039:
            r2 = r1
        L_0x003a:
            boolean r3 = r2 instanceof com.google.gson.JsonObject
            if (r3 == 0) goto L_0x0041
            com.google.gson.JsonObject r2 = (com.google.gson.JsonObject) r2
            goto L_0x0042
        L_0x0041:
            r2 = r1
        L_0x0042:
            if (r2 == 0) goto L_0x0066
            com.google.gson.JsonElement r3 = r2.remove(r4)
            boolean r6 = r3 instanceof com.google.gson.JsonArray
            if (r6 == 0) goto L_0x004f
            r1 = r3
            com.google.gson.JsonArray r1 = (com.google.gson.JsonArray) r1
        L_0x004f:
            if (r1 != 0) goto L_0x0056
            com.google.gson.JsonArray r1 = new com.google.gson.JsonArray
            r1.<init>()
        L_0x0056:
            com.google.gson.JsonObject r3 = new com.google.gson.JsonObject
            r3.<init>()
            com.google.gson.JsonElement r2 = (com.google.gson.JsonElement) r2
            r3.add(r5, r2)
            com.google.gson.JsonElement r1 = (com.google.gson.JsonElement) r1
            r3.add(r4, r1)
            r1 = r3
        L_0x0066:
            com.google.gson.JsonElement r1 = (com.google.gson.JsonElement) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.di.Dependencies$init$1.invoke$lambda$8(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.gson.JsonElement):com.google.gson.JsonElement");
    }
}
